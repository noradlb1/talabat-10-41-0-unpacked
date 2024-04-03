package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Encoding {

    /* renamed from: name  reason: collision with root package name */
    private final String f33629name;

    private Encoding(@NonNull String str) {
        if (str != null) {
            this.f33629name = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static Encoding of(@NonNull String str) {
        return new Encoding(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.f33629name.equals(((Encoding) obj).f33629name);
    }

    public String getName() {
        return this.f33629name;
    }

    public int hashCode() {
        return this.f33629name.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f33629name + "\"}";
    }
}
