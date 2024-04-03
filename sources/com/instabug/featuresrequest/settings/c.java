package com.instabug.featuresrequest.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f46592c;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f46593a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f46594b;

    @SuppressLint({"CommitPrefEdits"})
    private c(Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, "instabug_feature_requests");
        this.f46593a = instabugSharedPreferences;
        if (instabugSharedPreferences != null) {
            this.f46594b = instabugSharedPreferences.edit();
        }
    }

    public static c a() {
        if (f46592c == null && Instabug.getApplicationContext() != null) {
            a(Instabug.getApplicationContext());
        }
        return f46592c;
    }

    public static void a(Context context) {
        f46592c = new c(context);
    }

    public void a(int i11) {
        SharedPreferences.Editor editor = this.f46594b;
        if (editor != null) {
            editor.putInt("last_sort_by_action", i11);
            this.f46594b.apply();
        }
    }

    public void a(long j11) {
        SharedPreferences.Editor editor = this.f46594b;
        if (editor != null) {
            editor.putLong("last_activity", j11);
            this.f46594b.apply();
        }
    }

    public long b() {
        SharedPreferences sharedPreferences = this.f46593a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("last_activity", 0);
    }

    public int c() {
        SharedPreferences sharedPreferences = this.f46593a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt("last_sort_by_action", 0);
    }
}
