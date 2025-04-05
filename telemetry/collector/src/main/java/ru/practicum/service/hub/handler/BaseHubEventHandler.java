package ru.practicum.service.hub.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import ru.practicum.model.hub.HubEvent;
import ru.practicum.service.hub.HubEventHandler;
import ru.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.kafka.telemetry.event.HubEventAvro;

@Slf4j
@RequiredArgsConstructor
public abstract class BaseHubEventHandler<T extends SpecificRecordBase> implements HubEventHandler {
    private final CollectorKafkaProducer producer;

    @Value("${kafka.topics.hub}")
    private String topic;

    public abstract T toAvro(HubEvent hubEvent);

    @Override
    public void handleEvent(HubEvent hubEvent) {
        if (!hubEvent.getHubEventType().equals(getEventType())) {
            throw new IllegalArgumentException("Wrong event type %s".formatted(hubEvent.getHubEventType()));
        }

        T payload = toAvro(hubEvent);

        HubEventAvro hubEventAvro = HubEventAvro.newBuilder()
                .setHubId(hubEvent.getHubId())
                .setTimestamp(hubEvent.getTimestamp())
                .setPayload(payload)
                .build();

        ProducerRecord<String, SpecificRecordBase> record = new ProducerRecord<>(topic, hubEventAvro);
        producer.send(record);
        log.info("Sending event to Kafka: {}", record);
    }
}
