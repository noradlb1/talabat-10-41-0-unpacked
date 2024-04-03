package com.instabug.library.model;

import androidx.annotation.NonNull;
import com.google.android.exoplayer2.util.MimeTypes;

public enum n {
    APPLICATION(MimeTypes.BASE_TYPE_APPLICATION),
    VIEW("view"),
    MOTION("motion"),
    TAP("tap"),
    PINCH("pinch"),
    LONG_PRESS("long_press"),
    SCROLL("scroll"),
    SWIPE("swipe"),
    DOUBLE_TAP("double_tap"),
    NOT_AVAILABLE("not_available");
    

    /* renamed from: name  reason: collision with root package name */
    private final String f51563name;

    private n(String str) {
        this.f51563name = str;
    }

    @NonNull
    public String toString() {
        return this.f51563name;
    }
}
