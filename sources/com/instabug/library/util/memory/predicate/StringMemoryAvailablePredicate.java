package com.instabug.library.util.memory.predicate;

import androidx.annotation.Nullable;

public class StringMemoryAvailablePredicate extends MemoryAvailablePredicate {

    /* renamed from: b  reason: collision with root package name */
    private final long f52078b;

    public StringMemoryAvailablePredicate(@Nullable String str) {
        this.f52078b = str != null ? (long) str.length() : 0;
    }

    public boolean check() {
        long j11 = this.f52078b;
        if (j11 == 0) {
            return true;
        }
        return b((j11 * 2) + 40);
    }

    public StringMemoryAvailablePredicate(long j11) {
        this.f52078b = j11;
    }
}
