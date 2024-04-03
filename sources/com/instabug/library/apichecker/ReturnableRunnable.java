package com.instabug.library.apichecker;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface ReturnableRunnable<T> {
    @Nullable
    T run();
}
