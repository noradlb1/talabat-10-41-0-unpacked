package com.instabug.crash.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;

public class h {

    /* renamed from: b  reason: collision with root package name */
    private static h f46448b;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f46449a;

    private h(Context context) {
        this.f46449a = CoreServiceLocator.getInstabugSharedPreferences(context, "instabug_crash");
    }

    public static void a(Context context) {
        f46448b = new h(context);
    }

    public static h b() {
        if (f46448b == null && Instabug.getApplicationContext() != null) {
            a(Instabug.getApplicationContext());
        }
        return f46448b;
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static void f() {
        f46448b = null;
    }

    public long c() {
        SharedPreferences sharedPreferences = this.f46449a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("last_crash_request_started_at", 0);
    }

    public long d() {
        SharedPreferences sharedPreferences = this.f46449a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("last_crash_time", 0);
    }

    public boolean e() {
        SharedPreferences sharedPreferences = this.f46449a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_first_run_after_updating_encryptor", true);
    }

    public void a(boolean z11) {
        SharedPreferences sharedPreferences = this.f46449a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ib_first_run_after_updating_encryptor", z11).apply();
        }
    }

    public void a(long j11) {
        SharedPreferences sharedPreferences = this.f46449a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_crash_request_started_at", j11).apply();
        }
    }

    public void b(long j11) {
        SharedPreferences sharedPreferences = this.f46449a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_crash_time", j11).apply();
        }
    }

    public void a(int i11) {
        if (this.f46449a != null) {
            this.f46449a.edit().putLong("crashes_rate_limited_until", c() + (((long) i11) * 1000)).apply();
        }
    }

    public long a() {
        SharedPreferences sharedPreferences = this.f46449a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("crashes_rate_limited_until", 0);
    }
}
