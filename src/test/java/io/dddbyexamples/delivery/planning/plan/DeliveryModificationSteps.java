package io.dddbyexamples.delivery.planning.plan;

import cucumber.api.java.en.When;
import io.dddbyexamples.delivery.planning.*;
import lombok.Value;

import java.time.*;
import java.util.List;

public class DeliveryModificationSteps {
    private final Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    private PayloadCapacityPolicy policy = new PayloadCapacityPolicy();
    private final DeliveryFactory factory = new DeliveryFactory(createEvents(), policy, clock);

    private DeliveredAmountsChanged deliveredAmountsChangedEvent = null;

    @When("^new delivery is scheduled at \"([^\"]*)\" with \"([^\"]*)\" of capacity (\\d+):$")
    public void newDeliveryIsScheduledAtWithOfCapacity(String time, String type, int capacity, List<ProductAmount> payload) throws Throwable {
        Delivery delivery = factory.createDefault();
        delivery.edit(new EditDelivery(
                ProductAmount.toPayload(payload),
                new Transport(
                        LocalDateTime.of(
                                LocalDate.now(clock),
                                LocalTime.parse(time)
                        ),
                        new TransportType(type, capacity))
        ));
    }

    private DeliveryEvents createEvents() {
        return event -> deliveredAmountsChangedEvent = event;
    }

    @Value
    static class ProductAmount {
        String product;
        int storageUnits;

        static Payload toPayload(List<ProductAmount> amounts) {
            return new Payload();
        }
    }
}
