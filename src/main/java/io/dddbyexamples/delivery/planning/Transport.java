package io.dddbyexamples.delivery.planning;

import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Value
public class Transport {
    LocalDateTime time;
    TransportType type;

    public static Transport atHour(LocalTime time) {
        return new Transport(
                LocalDateTime.of(LocalDate.now().plusDays(1), time),
                TransportType.smalest()
        );
    }

    public static Transport at(LocalDateTime time) {
        return new Transport(time, TransportType.smalest());
    }
}
