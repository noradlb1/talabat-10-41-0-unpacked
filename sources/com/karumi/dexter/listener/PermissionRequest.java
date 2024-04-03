package com.karumi.dexter.listener;

import androidx.annotation.NonNull;

public final class PermissionRequest {

    /* renamed from: name  reason: collision with root package name */
    private final String f52719name;

    public PermissionRequest(@NonNull String str) {
        this.f52719name = str;
    }

    public String getName() {
        return this.f52719name;
    }

    public String toString() {
        return "Permission name: " + this.f52719name;
    }
}
