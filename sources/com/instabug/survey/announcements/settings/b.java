package com.instabug.survey.announcements.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f52269c;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f52270a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f52271b;

    @SuppressLint({"CommitPrefEdits"})
    private b(Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, "instabug_announcements");
        this.f52270a = instabugSharedPreferences;
        if (instabugSharedPreferences != null) {
            this.f52271b = instabugSharedPreferences.edit();
        }
    }

    public static void a(@NonNull Context context) {
        f52269c = new b(context);
    }

    @Nullable
    public static b b() {
        if (f52269c == null && Instabug.getApplicationContext() != null) {
            a(Instabug.getApplicationContext());
        }
        return f52269c;
    }

    @Nullable
    public String a() {
        SharedPreferences sharedPreferences = this.f52270a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("survey_resolve_country_code", (String) null);
    }

    public void a(long j11) {
        SharedPreferences.Editor editor = this.f52271b;
        if (editor != null) {
            editor.putLong("survey_resolve_country_code_last_fetch", j11);
            this.f52271b.apply();
        }
    }

    public void a(String str) {
        SharedPreferences.Editor editor = this.f52271b;
        if (editor != null) {
            editor.putString("announcement_last_retrieved_locale", str);
            this.f52271b.apply();
        }
    }

    public void b(long j11) {
        SharedPreferences.Editor editor = this.f52271b;
        if (editor != null) {
            editor.putLong("last_announcement_time", j11);
            this.f52271b.apply();
        }
    }

    public void b(String str) {
        SharedPreferences.Editor editor = this.f52271b;
        if (editor != null) {
            editor.putString("announcements_app_latest_version", str);
            this.f52271b.apply();
        }
    }

    public long c() {
        SharedPreferences sharedPreferences = this.f52270a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("announcements_last_fetch_time", 0);
    }

    public void c(long j11) {
        SharedPreferences.Editor editor = this.f52271b;
        if (editor != null) {
            editor.putLong("announcements_last_fetch_time", j11);
            this.f52271b.apply();
        }
    }

    public void c(String str) {
        SharedPreferences.Editor editor = this.f52271b;
        if (editor != null) {
            editor.putString("survey_resolve_country_code", str);
            this.f52271b.apply();
        }
    }
}
