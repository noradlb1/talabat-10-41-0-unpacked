package com.google.crypto.tink;

import com.google.crypto.tink.annotations.Alpha;
import com.google.errorprone.annotations.Immutable;

@Immutable
@Alpha
public final class KeyStatus {
    public static final KeyStatus DESTROYED = new KeyStatus("DESTROYED");
    public static final KeyStatus DISABLED = new KeyStatus("DISABLED");
    public static final KeyStatus ENABLED = new KeyStatus("ENABLED");

    /* renamed from: name  reason: collision with root package name */
    private final String f47299name;

    private KeyStatus(String str) {
        this.f47299name = str;
    }

    public String toString() {
        return this.f47299name;
    }
}
