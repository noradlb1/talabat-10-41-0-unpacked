package com.instabug.library.bugreporting.model;

public enum Bug$Type {
    BUG("bug"),
    FEEDBACK("feedback"),
    NOT_AVAILABLE("not-available");
    

    /* renamed from: name  reason: collision with root package name */
    private final String f34175name;

    private Bug$Type(String str) {
        this.f34175name = str;
    }

    public String toString() {
        return this.f34175name;
    }
}
