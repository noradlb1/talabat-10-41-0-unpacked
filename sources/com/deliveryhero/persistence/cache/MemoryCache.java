package com.deliveryhero.persistence.cache;

import androidx.annotation.Nullable;

public interface MemoryCache {
    @Nullable
    <T> T get(String str);

    <T> void put(String str, T t11);

    <T> void put(String str, T t11, long j11);

    void remove(String str);
}
