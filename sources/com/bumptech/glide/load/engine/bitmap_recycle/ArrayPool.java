package com.bumptech.glide.load.engine.bitmap_recycle;

public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 65536;

    void clearMemory();

    <T> T get(int i11, Class<T> cls);

    <T> T getExact(int i11, Class<T> cls);

    <T> void put(T t11);

    @Deprecated
    <T> void put(T t11, Class<T> cls);

    void trimMemory(int i11);
}
