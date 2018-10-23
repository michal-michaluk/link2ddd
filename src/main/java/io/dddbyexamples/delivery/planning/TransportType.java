package io.dddbyexamples.delivery.planning;

import lombok.Value;

@Value
public class TransportType {
    String type;
    int capacity;

    public static TransportType smalest() {
        return new TransportType("truck", 10);
    }
}
