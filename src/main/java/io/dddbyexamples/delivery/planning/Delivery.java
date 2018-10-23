package io.dddbyexamples.delivery.planning;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Delivery {

    // state
    private Object id;
    private Transport transport;
    private Payload payload;

    // dependencies
    private final DeliveryEvents events;
    private final PayloadCapacityPolicy policy;

    public void edit(EditDelivery command) {
        // - checking payload size against Transport Capacity (capacity exceeded),
        transportCapacityNotExceeded(command.getPayload());
        // payload = payload.merge(command.getPayloadDiff());
        Amounts diff = payload.diff(command.getPayload());
        payload = command.getPayload();
        transport = command.getTransport();

        events.emit(new DeliveredAmountsChanged(id, diff));

        // Software supports Logistician while planning, by:
        // - continuously checking Plan Completeness against customers demands for that day.

    }

    private void transportCapacityNotExceeded(Payload payload) {
        Amounts exceeded = policy.calculateExceeded(
                transport.getType(),
                payload.getStorageUnitAmount()
        );
        if (exceeded.isEmpty()) {
            throw new PayloadCapacityExceeded(exceeded);
        }
    }

    void cancel(CancelDelivery command) {

    }

}
