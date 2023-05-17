package com.hoanganhnhan.catalog.models;

public class ItemConfiguration {
    private String key;
    private String value;
    private String color;

    public ItemConfiguration(String key, String value, String color) {
        this.key = key;
        this.value = value;
        this.color = color;
        this.color ="#CCCCCC";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
