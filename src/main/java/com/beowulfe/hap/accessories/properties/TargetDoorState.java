package com.beowulfe.hap.accessories.properties;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum TargetDoorState {

    OPEN(0),
    CLOSED(1);

    private final static Map<Integer, TargetDoorState> reverse;
    static {
        reverse = Arrays.stream(TargetDoorState.values()).collect(Collectors.toMap(t -> t.getCode(), t -> t));
    }

    public static TargetDoorState fromCode(Integer code) {
        return reverse.get(code);
    }

    private final int code;

    private TargetDoorState(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
