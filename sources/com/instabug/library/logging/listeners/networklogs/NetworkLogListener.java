package com.instabug.library.logging.listeners.networklogs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface NetworkLogListener {
    @Nullable
    NetworkLogSnapshot onNetworkLogCaptured(@NotNull NetworkLogSnapshot networkLogSnapshot);
}
