package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;

public class eq {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f13291a;

    public eq(Context context) {
        if (context != null) {
            this.f13291a = context.getSharedPreferences("UXCamPreferences", 0);
        }
    }

    public void a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f13291a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public String b(String str) {
        SharedPreferences sharedPreferences = this.f13291a;
        return sharedPreferences == null ? "" : sharedPreferences.getString(str, (String) null);
    }

    public void c(String str) {
        SharedPreferences sharedPreferences = this.f13291a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).apply();
        }
    }

    public int b() {
        SharedPreferences sharedPreferences = this.f13291a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt("recorded_video_count", 0);
    }

    public void a(String str, boolean z11) {
        SharedPreferences sharedPreferences = this.f13291a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z11).apply();
        }
    }

    public void c() {
        SharedPreferences sharedPreferences = this.f13291a;
        int i11 = 0;
        if (sharedPreferences != null) {
            i11 = sharedPreferences.getInt("recorded_session_count", 0);
        }
        int i12 = i11 + 1;
        SharedPreferences sharedPreferences2 = this.f13291a;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putInt("recorded_session_count", i12).apply();
        }
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = this.f13291a;
        return sharedPreferences != null && sharedPreferences.getBoolean(str, false);
    }

    public int a() {
        SharedPreferences sharedPreferences = this.f13291a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt("recorded_session_count", 0);
    }

    public void a(boolean z11) {
        SharedPreferences sharedPreferences = this.f13291a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("opt_out", z11).apply();
        }
    }
}
