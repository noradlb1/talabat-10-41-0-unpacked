package com.instabug.library.networkv2.request;

import java.io.Serializable;

public class RequestParameter<V> implements Serializable {
    private String key;
    private V value;

    public RequestParameter(String str, V v11) {
        this.key = str;
        this.value = v11;
    }

    public String getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
