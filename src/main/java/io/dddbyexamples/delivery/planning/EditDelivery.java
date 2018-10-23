package io.dddbyexamples.delivery.planning;

import lombok.Value;

@Value
public class EditDelivery {

    Payload payload;
    Transport transport;
}
