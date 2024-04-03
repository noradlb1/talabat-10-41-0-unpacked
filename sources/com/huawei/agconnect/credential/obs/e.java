package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class e {

    /* renamed from: a  reason: collision with root package name */
    protected SharedPreferences f47573a;

    public e(Context context, String str) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Context a11 = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = a11.getSharedPreferences("move_to_de_records", 0);
                if (!sharedPreferences.getBoolean(str, false)) {
                    if (a11.moveSharedPreferencesFrom(context, str)) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean(str, true);
                        edit.apply();
                    }
                }
                context = a11;
            }
            this.f47573a = context.getSharedPreferences(str, 0);
            return;
        }
        throw new NullPointerException("context is null!");
    }

    public String a(String str) {
        SharedPreferences sharedPreferences = this.f47573a;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    public void a(String str, Long l11) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f47573a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, l11.longValue()).commit();
        }
    }

    public boolean a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f47573a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public long b(String str) {
        SharedPreferences sharedPreferences = this.f47573a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0);
        }
        return 0;
    }

    public boolean c(String str) {
        SharedPreferences sharedPreferences = this.f47573a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public boolean d(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f47573a;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (edit = this.f47573a.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }
}
