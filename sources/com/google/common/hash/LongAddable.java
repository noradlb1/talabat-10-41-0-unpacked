package com.google.common.hash;

@ElementTypesAreNonnullByDefault
interface LongAddable {
    void add(long j11);

    void increment();

    long sum();
}
