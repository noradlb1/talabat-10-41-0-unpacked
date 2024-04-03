package com.instabug.survey.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;

public class b {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static b f52430c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f52431a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f52432b;

    @SuppressLint({"CommitPrefEdits"})
    private b(@NonNull Context context) {
        if (context != null) {
            SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, "instabug_survey");
            this.f52431a = instabugSharedPreferences;
            if (instabugSharedPreferences != null) {
                this.f52432b = instabugSharedPreferences.edit();
            }
        }
    }

    public static void a(@Nullable Context context) {
        if (context != null) {
            f52430c = new b(context);
        }
    }

    @Nullable
    public static b c() {
        if (f52430c == null) {
            a(Instabug.getApplicationContext());
        }
        return f52430c;
    }

    public static void h() {
        f52430c = null;
    }

    @Nullable
    public String a() {
        SharedPreferences sharedPreferences = this.f52431a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("survey_resolve_country_code", (String) null);
        }
        return null;
    }

    public void a(long j11) {
        SharedPreferences.Editor editor = this.f52432b;
        if (editor != null) {
            editor.putLong("survey_resolve_country_code_last_fetch", j11);
            this.f52432b.apply();
        }
    }

    public void a(String str) {
        SharedPreferences.Editor editor = this.f52432b;
        if (editor != null) {
            editor.putString("survey_resolve_country_code", str);
            this.f52432b.apply();
        }
    }

    public long b() {
        SharedPreferences sharedPreferences = this.f52431a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("survey_resolve_country_code_last_fetch", 0);
        }
        return 0;
    }

    public void b(long j11) {
        SharedPreferences.Editor editor = this.f52432b;
        if (editor != null) {
            editor.putLong("survey_last_fetch_time", j11);
            this.f52432b.apply();
        }
    }

    public void c(long j11) {
        SharedPreferences.Editor editor = this.f52432b;
        if (editor != null) {
            editor.putLong("last_survey_time", j11);
            this.f52432b.apply();
        }
    }

    public long d() {
        SharedPreferences sharedPreferences = this.f52431a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("survey_last_fetch_time", 0);
        }
        return 0;
    }

    public long e() {
        SharedPreferences sharedPreferences = this.f52431a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_survey_time", 0);
        }
        return 0;
    }

    public boolean f() {
        SharedPreferences sharedPreferences = this.f52431a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("should_remove_old_survey_cache_file", false);
        }
        return false;
    }

    public void g() {
        SharedPreferences.Editor editor = this.f52432b;
        if (editor != null) {
            editor.putBoolean("should_remove_old_survey_cache_file", true);
            this.f52432b.apply();
        }
    }
}
