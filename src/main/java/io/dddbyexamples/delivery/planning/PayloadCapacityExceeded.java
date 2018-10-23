package io.dddbyexamples.delivery.planning;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PayloadCapacityExceeded extends RuntimeException {
    public Amounts exceeded;
}
