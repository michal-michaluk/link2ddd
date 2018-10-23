package io.dddbyexamples.delivery.planning;

public class PayloadCapacityPolicy {

    public Amounts calculateExceeded(TransportType type, Amounts storageUnitAmount) {
        return Amounts.empty();
    }
}
