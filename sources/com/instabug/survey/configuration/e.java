package com.instabug.survey.configuration;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import org.jetbrains.annotations.NotNull;

public final class e implements d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f52376a = new e();

    private e() {
    }

    private final SharedPreferences.Editor e() {
        SharedPreferences f11 = f();
        if (f11 == null) {
            return null;
        }
        return f11.edit();
    }

    private final SharedPreferences f() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return CoreServiceLocator.getInstabugSharedPreferences(applicationContext, "instabug_survey");
    }

    public void a(boolean z11) {
        SharedPreferences.Editor putBoolean;
        SharedPreferences.Editor e11 = e();
        if (e11 != null && (putBoolean = e11.putBoolean("surveys_availability", z11)) != null) {
            putBoolean.apply();
        }
    }

    public boolean a() {
        return c() && !d();
    }

    public void b(boolean z11) {
        SharedPreferences.Editor putBoolean;
        SharedPreferences.Editor e11 = e();
        if (e11 != null && (putBoolean = e11.putBoolean("announcements_availability", z11)) != null) {
            putBoolean.apply();
        }
    }

    public boolean b() {
        SharedPreferences f11 = f();
        if (f11 == null) {
            return true;
        }
        return f11.getBoolean("announcements_availability", true);
    }

    public void c(boolean z11) {
        SharedPreferences.Editor putBoolean;
        SharedPreferences.Editor e11 = e();
        if (e11 != null && (putBoolean = e11.putBoolean("surveys_usage_exceeded", z11)) != null) {
            putBoolean.apply();
        }
    }

    public boolean c() {
        SharedPreferences f11 = f();
        if (f11 == null) {
            return true;
        }
        return f11.getBoolean("surveys_availability", true);
    }

    public boolean d() {
        SharedPreferences f11 = f();
        if (f11 == null) {
            return false;
        }
        return f11.getBoolean("surveys_usage_exceeded", false);
    }
}
