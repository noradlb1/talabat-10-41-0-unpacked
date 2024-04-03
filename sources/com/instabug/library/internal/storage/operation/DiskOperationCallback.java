package com.instabug.library.internal.storage.operation;

public interface DiskOperationCallback<T> {
    void onFailure(Throwable th2);

    void onSuccess(T t11);
}
