package com.instabug.library.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

public class g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f51526a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51527b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f51528c;

    /* renamed from: d  reason: collision with root package name */
    private long f51529d;

    public g(@Nullable String str, @Nullable String str2, @Nullable String str3, long j11) {
        this.f51526a = str;
        this.f51527b = str2;
        this.f51528c = str3;
        this.f51529d = j11;
    }

    @Nullable
    public String a() {
        return this.f51526a;
    }

    public long b() {
        return this.f51529d;
    }

    @Nullable
    public String c() {
        return this.f51527b;
    }

    @Nullable
    public String d() {
        return this.f51528c;
    }

    @NonNull
    public String toString() {
        return "\nsession started\nAppToken: " + a() + StringUtils.LF + "OS Version: " + c() + StringUtils.LF + "sdk version: " + d() + StringUtils.LF + "free memory: " + b() + "\n\n";
    }
}
