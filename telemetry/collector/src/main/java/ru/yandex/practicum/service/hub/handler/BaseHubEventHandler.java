package ru.yandex.practicum.service.hub.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import ru.yandex.practicum.grpc.telemetry.event.HubEventProto;
import ru.yandex.practicum.kafka.telemetry.event.HubEventAvro;
import ru.yandex.practicum.service.hub.HubEventHandler;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;

import java.time.Instant;

@Slf4j
@RequiredArgsConstructor
public abstract class BaseHubEventHandler<T extends SpecificRecordBase> implements HubEventHandler {
    private final CollectorKafkaProducer producer;

    @Value("${kafka.topics.hub}")
    private String topic;

    public abstract T toAvro(HubEventProto hubEvent);

    @Override
    public void handleEvent(HubEventProto hubEvent) {
        if (!hubEvent.getPayloadCase().equals(getEventType())) {
            throw new IllegalArgumentException("Wrong event type %s".formatted(hubEvent.getPayloadCase()));
        }

        T payload = toAvro(hubEvent);

        HubEventAvro hubEventAvro = HubEventAvro.newBuilder()
                .setHubId(hubEvent.getHubId())
                .setTimestamp(Instant.ofEpochSecond(
                        hubEvent.getTimestamp().getSeconds(), hubEvent.getTimestamp().getNanos()))
                .setPayload(payload)
                .build();

        ProducerRecord<String, SpecificRecordBase> record = new ProducerRecord<>(topic, hubEventAvro);
        producer.send(record);
        log.info("Sending event to Kafka: {}", record);
    }
}
