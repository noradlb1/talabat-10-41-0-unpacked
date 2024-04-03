package com.huawei.hms.dtm.core;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.huawei.hms.dtm.core.x  reason: case insensitive filesystem */
public class C0457x {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f48630a;

    public C0457x(Context context) {
        this.f48630a = context.getSharedPreferences("$dtm_cache_config", 0);
    }

    public void a() {
        this.f48630a.edit().putLong("updateTime", 0).apply();
    }

    public void a(long j11) {
        this.f48630a.edit().putLong("updateTime", j11).apply();
    }

    public void a(boolean z11) {
        this.f48630a.edit().putBoolean("dtmEnabled", z11).apply();
    }

    public long b() {
        return this.f48630a.getLong("updateTime", 0);
    }

    public void b(long j11) {
        this.f48630a.edit().putLong("updateInterval", j11).apply();
    }

    public long c() {
        return Math.max(this.f48630a.getLong("updateInterval", 6), 6);
    }
}
