package com.test.ws.enumeration;

/**
 * Created by Nasim on 5/31/14.
 */
public enum  Role {
    ROLE_ADMIN(1),
    ROLE_MEMBER(2);

    private final int value;

    Role(int p) {
        this.value = p;
    }

    public int getValue() {
        return this.value;
    }
}
