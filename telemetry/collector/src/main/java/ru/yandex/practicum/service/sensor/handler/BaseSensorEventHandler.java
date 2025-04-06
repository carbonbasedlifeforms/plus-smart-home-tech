package ru.yandex.practicum.service.sensor.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import ru.yandex.practicum.kafka.telemetry.event.SensorEventAvro;
import ru.yandex.practicum.model.sensor.SensorEvent;
import ru.yandex.practicum.service.producer.CollectorKafkaProducer;
import ru.yandex.practicum.service.sensor.SensorEventHandler;

@Slf4j
@RequiredArgsConstructor
public abstract class BaseSensorEventHandler<T extends SpecificRecordBase> implements SensorEventHandler {
    private final CollectorKafkaProducer producer;

    @Value("${kafka.topics.sensor}")
    private String topic;

    protected abstract T toAvro(SensorEvent sensorEvent);

    @Override
    public void handleEvent(SensorEvent sensorEvent) {
        if (!sensorEvent.getSensorType().equals(getEventType())) {
            throw new IllegalArgumentException("Wrong event type %s".formatted(sensorEvent.getSensorType()));
        }

        T payload = toAvro(sensorEvent);

        SensorEventAvro sensorEventAvro = SensorEventAvro.newBuilder()
                .setId(sensorEvent.getId())
                .setHubId(sensorEvent.getHubId())
                .setTimestamp(sensorEvent.getTimestamp())
                .setPayload(payload)
                .build();

        ProducerRecord<String, SpecificRecordBase> producerRecord = new ProducerRecord<>(topic, sensorEventAvro);

        producer.send(producerRecord);
        log.info("Sending event to kafka: {}", producerRecord);
    }
}
