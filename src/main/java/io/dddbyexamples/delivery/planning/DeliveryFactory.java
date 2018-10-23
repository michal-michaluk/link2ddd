package io.dddbyexamples.delivery.planning;

import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
public class DeliveryFactory {

    private DeliveryEvents events;
    private PayloadCapacityPolicy policy;
    private Clock clock;

    public Delivery createEmpty(Transport transport) {
        return new Delivery(
                UUID.randomUUID(),
                transport,
                Payload.empty(),
                events,
                policy
        );
    }

    public Delivery createDefault() {
        return new Delivery(
                UUID.randomUUID(),
                Transport.at(LocalDate.now(clock)
                        .plusDays(1)
                        .atTime(LocalTime.of(7, 0))),
                Payload.empty(),
                events,
                policy
        );
    }
}
