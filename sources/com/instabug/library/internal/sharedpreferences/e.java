package com.instabug.library.internal.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f51016b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f51017c;

    public e(Context context, boolean z11) {
        this.f51016b = context;
        this.f51017c = z11;
    }

    @SuppressLint({"ApplySharedPref"})
    public void run() {
        SharedPreferences sharedPreferences = this.f51016b.getSharedPreferences(SettingsManager.MIGRATION_STATE_SHARED_PREF, 0);
        InstabugSDKLogger.d("IBG-Core", "SharedPreferences continue migration. Encryption enabled: " + this.f51017c);
        f.b(this.f51016b);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : f.f51020c) {
            if (!sharedPreferences.getBoolean(str, false)) {
                f.b(str, this.f51017c, this.f51016b);
                edit.putBoolean(str, true).commit();
            }
        }
        InstabugSDKLogger.d("IBG-Core", "SharedPreferences finished migration");
    }
}
