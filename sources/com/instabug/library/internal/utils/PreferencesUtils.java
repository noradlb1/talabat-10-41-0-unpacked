package com.instabug.library.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;

public class PreferencesUtils {
    private final Context context;

    /* renamed from: name  reason: collision with root package name */
    private final String f51118name;

    public PreferencesUtils(Context context2, String str) {
        this.context = context2;
        this.f51118name = str;
    }

    public void delete(String str) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        if (instabugSharedPreferences != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.remove(str);
            edit.apply();
        }
    }

    public void deleteAll() {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        if (instabugSharedPreferences != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.clear();
            edit.apply();
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public long getLong(String str) {
        return getLong(str, 0);
    }

    @Nullable
    public SharedPreferences getSharedPreferences() {
        return CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
    }

    @Nullable
    public String getString(String str) {
        return getString(str, (String) null);
    }

    public void saveOrUpdateBoolean(String str, boolean z11) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        if (instabugSharedPreferences != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.putBoolean(str, z11);
            edit.apply();
        }
    }

    public void saveOrUpdateInt(String str, int i11) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        if (instabugSharedPreferences != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.putInt(str, i11);
            edit.apply();
        }
    }

    public void saveOrUpdateLong(String str, long j11) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        if (instabugSharedPreferences != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.putLong(str, j11);
            edit.apply();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void saveOrUpdateString(String str, @Nullable String str2) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        if (instabugSharedPreferences != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public boolean getBoolean(String str, boolean z11) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        return instabugSharedPreferences != null ? instabugSharedPreferences.getBoolean(str, z11) : z11;
    }

    public int getInt(String str, int i11) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        return instabugSharedPreferences != null ? instabugSharedPreferences.getInt(str, i11) : i11;
    }

    public long getLong(String str, long j11) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        return instabugSharedPreferences != null ? instabugSharedPreferences.getLong(str, j11) : j11;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public String getString(String str, @Nullable String str2) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(this.context, this.f51118name);
        return instabugSharedPreferences != null ? instabugSharedPreferences.getString(str, str2) : str2;
    }
}
