package ru.yandex.practicum.service.sensor.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import ru.yandex.practicum.grpc.telemetry.event.SensorEventProto;
import ru.yandex.practicum.kafka.telemetry.event.SensorEventAvro;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.service.sensor.SensorEventHandler;

import java.time.Instant;

@Slf4j
@RequiredArgsConstructor
public abstract class BaseSensorEventHandler<T extends SpecificRecordBase> implements SensorEventHandler {
    private final CollectorKafkaProducer producer;

    @Value("${kafka.topics.sensor}")
    private String topic;

    protected abstract T toAvro(SensorEventProto sensorEvent);

    @Override
    public void handleEvent(SensorEventProto sensorEvent) {
        if (!sensorEvent.getPayloadCase().equals(getEventType())) {
            throw new IllegalArgumentException("Wrong event type %s".formatted(sensorEvent.getPayloadCase()));
        }

        T payload = toAvro(sensorEvent);

        SensorEventAvro sensorEventAvro = SensorEventAvro.newBuilder()
                .setId(sensorEvent.getId())
                .setHubId(sensorEvent.getHubId())
                .setTimestamp(Instant.ofEpochSecond(
                        sensorEvent.getTimestamp().getSeconds(),
                        sensorEvent.getTimestamp().getNanos()))
                .setPayload(payload)
                .build();

        ProducerRecord<String, SpecificRecordBase> producerRecord = new ProducerRecord<>(topic, sensorEventAvro);

        producer.send(producerRecord);
        log.info("Sending event to kafka: {}", producerRecord);
    }
}
