package com.instabug.chat.model;

import org.jetbrains.annotations.NotNull;

public enum i {
    INBOUND("inbound"),
    OUTBOUND("outbound"),
    NOT_AVAILABLE("not-available");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f46050a;

    private i(String str) {
        this.f46050a = str;
    }

    @NotNull
    public String toString() {
        return this.f46050a;
    }
}
