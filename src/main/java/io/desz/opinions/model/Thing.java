package io.desz.opinions.model;

import lombok.Value;

@Value
public class Thing {
    private String description;
    private Type type;
    public enum Type {
        PRODUCT, SERVICE
    }
}
