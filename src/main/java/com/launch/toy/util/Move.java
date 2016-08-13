package com.launch.toy.util;

import java.util.HashMap;
import java.util.Map;

public enum Move {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    private static Map<Integer, Move> map = new HashMap<Integer, Move>();

    static {
        for (Move directionEnum : Move.values()) {
            map.put(directionEnum.directionIndex, directionEnum);
        }
    }

    private int directionIndex;

    private Move(int direction) {
        this.directionIndex = direction;
    }

    public static Move valueOf(int directionNum) {
        return map.get(directionNum);
    }

    /**
     * Returns the direction on the left of the current one
     */
    public Move leftDirection() {
        return rotate(-1);
    }

    /**
     * Returns the direction on the right of the current one
     */
    public Move rightDirection() {
        return rotate(1);
    }

    private Move rotate(int step) {

        int newIndex = (this.directionIndex + step) < 0 ?
                map.size() - 1 :
                (this.directionIndex + step) % map.size();

        return Move.valueOf(newIndex);
    }

}

