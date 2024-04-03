package com.instabug.library.internal.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;

class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f51014b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f51015c;

    public d(boolean z11, Context context) {
        this.f51014b = z11;
        this.f51015c = context;
    }

    @SuppressLint({"ApplySharedPref"})
    public void run() {
        InstabugSDKLogger.d("IBG-Core", "SharedPreferences started migration. Encryption enabled: " + this.f51014b);
        SharedPreferences.Editor edit = this.f51015c.getSharedPreferences(SettingsManager.MIGRATION_STATE_SHARED_PREF, 0).edit();
        f.b(this.f51015c);
        for (String str : f.f51020c) {
            edit.putBoolean(str, false).commit();
            f.b(str, this.f51014b, this.f51015c);
            edit.putBoolean(str, true).commit();
        }
        InstabugSDKLogger.d("IBG-Core", "SharedPreferences finished migration");
    }
}
