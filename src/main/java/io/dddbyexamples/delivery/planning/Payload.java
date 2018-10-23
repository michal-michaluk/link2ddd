package io.dddbyexamples.delivery.planning;

public class Payload {

    public static Payload empty() {
        return new Payload();
    }

    public Amounts getStorageUnitAmount() {
        return Amounts.empty();
    }

    public Amounts diff(Payload payload) {
        return Amounts.empty();
    }
}
