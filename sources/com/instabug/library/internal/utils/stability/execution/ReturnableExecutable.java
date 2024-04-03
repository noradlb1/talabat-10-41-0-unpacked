package com.instabug.library.internal.utils.stability.execution;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface ReturnableExecutable<T> {
    @Nullable
    T execute() throws Exception;
}
