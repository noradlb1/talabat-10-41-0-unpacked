package com.instabug.chat.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;

public class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f46163b;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f46164a;

    private c(@Nullable SharedPreferences sharedPreferences) {
        this.f46164a = sharedPreferences;
    }

    public static c a() {
        if (f46163b == null && Instabug.getApplicationContext() != null) {
            d(a.a(Instabug.getApplicationContext()));
        }
        return f46163b;
    }

    public static void d(@Nullable SharedPreferences sharedPreferences) {
        f46163b = new c(sharedPreferences);
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static void h() {
        f46163b = null;
    }

    public void b(@DrawableRes int i11) {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("ibc_push_notification_icon", i11).apply();
        }
    }

    public void c(long j11) {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("ibc_last_chat_time", j11).apply();
        }
    }

    public void e(boolean z11) {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ibc_conversation_sounds", z11).apply();
        }
    }

    public long f() {
        SharedPreferences sharedPreferences = this.f46164a;
        return sharedPreferences == null ? System.currentTimeMillis() : sharedPreferences.getLong("ibc_last_chat_time", System.currentTimeMillis());
    }

    public void g(long j11) {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("ibc_ttl", j11).apply();
        }
    }

    public void h(boolean z11) {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ibc_in_app_notification_sound", z11).apply();
        }
    }

    @DrawableRes
    public int i() {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt("ibc_push_notification_icon", -1);
    }

    public void j(boolean z11) {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ibc__notifications_state", z11).apply();
        }
    }

    public long k() {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences == null) {
            return 60;
        }
        return sharedPreferences.getLong("ibc_ttl", 60);
    }

    public void l(boolean z11) {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("ibc_notification_sound", z11).apply();
        }
    }

    public boolean m() {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("ibc_in_app_notification_sound", false);
    }

    public boolean n() {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ibc__notifications_state", true);
    }

    public boolean o() {
        SharedPreferences sharedPreferences = this.f46164a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("ibc_notification_sound", false);
    }
}
