package com.instabug.library;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface OnUserUUIDReadyCallback {
    void onUserUUIDReady(@Nullable String str);
}
