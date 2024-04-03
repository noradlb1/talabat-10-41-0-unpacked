package com.huawei.location.lite.common.util;

public abstract class SingleTon<T> {
    private volatile T mInstance;

    public abstract T create();

    public final T get() {
        if (this.mInstance == null) {
            synchronized (this) {
                if (this.mInstance == null) {
                    this.mInstance = create();
                }
            }
        }
        return this.mInstance;
    }
}
