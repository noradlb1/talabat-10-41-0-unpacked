package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
interface LongAddable {
    void add(long j11);

    void increment();

    long sum();
}
