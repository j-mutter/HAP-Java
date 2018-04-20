package com.beowulfe.hap.accessories.properties;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum CurrentDoorState {

    OPEN(0),
    CLOSED(1),
    OPENING(2),
    CLOSING(3),
    STOPPED(4);

    private final static Map<Integer, CurrentDoorState> reverse;
    static {
        reverse = Arrays.stream(CurrentDoorState.values()).collect(Collectors.toMap(t -> t.getCode(), t -> t));
    }

    public static CurrentDoorState fromCode(Integer code) {
        return reverse.get(code);
    }

    private final int code;

    private CurrentDoorState(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
