package io.dddbyexamples.delivery.planning;

public interface DeliveryEvents {
    void emit(DeliveredAmountsChanged event);
}
