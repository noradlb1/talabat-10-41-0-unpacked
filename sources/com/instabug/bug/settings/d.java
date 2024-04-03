package com.instabug.bug.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;

public class d {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static d f45783c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f45784a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f45785b;

    private d(Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, "instabug_bug_reporting");
        this.f45784a = instabugSharedPreferences;
        if (instabugSharedPreferences != null) {
            this.f45785b = instabugSharedPreferences.edit();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            f45783c = new d(context);
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static synchronized d b() {
        d dVar;
        synchronized (d.class) {
            if (f45783c == null && Instabug.getApplicationContext() != null) {
                a(Instabug.getApplicationContext());
            }
            dVar = f45783c;
        }
        return dVar;
    }

    public void a(long j11) {
        SharedPreferences.Editor editor = this.f45785b;
        if (editor != null) {
            editor.putLong("last_bug_time", j11);
            this.f45785b.apply();
        }
    }

    public void a(@Nullable String str) {
        SharedPreferences.Editor editor = this.f45785b;
        if (editor != null) {
            editor.putString("ib_e_pn", str);
            this.f45785b.apply();
        }
    }

    public void a(boolean z11) {
        SharedPreferences.Editor editor = this.f45785b;
        if (editor != null) {
            editor.putBoolean("ib_encryption_migration_status", z11);
            this.f45785b.apply();
        }
    }

    public boolean a() {
        SharedPreferences sharedPreferences = this.f45784a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_encryption_migration_status", true);
    }

    public void b(long j11) {
        SharedPreferences.Editor editor = this.f45785b;
        if (editor != null) {
            editor.putLong("report_categories_fetched_time", j11);
            this.f45785b.apply();
        }
    }

    public void b(@Nullable String str) {
        SharedPreferences.Editor editor = this.f45785b;
        if (editor != null) {
            editor.putString("ib_remote_report_categories", str);
            this.f45785b.apply();
        }
    }

    public void b(boolean z11) {
        SharedPreferences.Editor editor = this.f45785b;
        if (editor != null) {
            editor.putBoolean("ib_first_run_after_updating_encryptor", z11);
            this.f45785b.apply();
        }
    }

    public long c() {
        SharedPreferences sharedPreferences = this.f45784a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("last_bug_time", 0);
    }

    @Nullable
    public String d() {
        SharedPreferences sharedPreferences = this.f45784a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("ib_e_pn", (String) null);
    }

    @Nullable
    public String e() {
        SharedPreferences sharedPreferences = this.f45784a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("ib_remote_report_categories", (String) null);
    }

    public long f() {
        SharedPreferences sharedPreferences = this.f45784a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getLong("report_categories_fetched_time", 0);
    }

    public boolean g() {
        SharedPreferences sharedPreferences = this.f45784a;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean("ib_first_run_after_updating_encryptor", true);
    }
}
