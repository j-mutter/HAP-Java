package com.beowulfe.hap.impl.characteristics.garage;

import java.util.concurrent.CompletableFuture;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.GarageDoor;
import com.beowulfe.hap.characteristics.EnumCharacteristic;
import com.beowulfe.hap.characteristics.EventableCharacteristic;

public class CurrentDoorStateCharacteristic extends EnumCharacteristic implements EventableCharacteristic {

    private final GarageDoor door;

    public CurrentDoorStateCharacteristic(GarageDoor door) {
        super("0000000E-0000-1000-8000-0026BB765291", false, true, "Current Door State", 5);
        this.door = door;
    }

    @Override
    protected void setValue(Integer value) throws Exception {
        // Read-only
    }

    @Override
    protected CompletableFuture<Integer> getValue() {
        return door.getCurrentDoorState().thenApply(s -> s.getCode());
    }

    @Override
    public void subscribe(HomekitCharacteristicChangeCallback callback) {
        door.subscribeCurrentDoorState(callback);
    }

    @Override
    public void unsubscribe() {
        door.unsubscribeCurrentDoorState();
    }

}
