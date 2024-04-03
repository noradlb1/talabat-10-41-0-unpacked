package com.instabug.library.internal.storage.operation;

import androidx.annotation.Nullable;
import java.io.IOException;

public interface DiskOperation<T, N> {
    T execute(N n11) throws IOException;

    void executeAsync(N n11, @Nullable DiskOperationCallback<T> diskOperationCallback);
}
