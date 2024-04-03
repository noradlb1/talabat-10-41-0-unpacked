package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import java.util.concurrent.Callable;

final class zzcg implements Callable<String> {
    final /* synthetic */ Context zza;

    public zzcg(zzci zzci, Context context) {
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences = this.zza.getSharedPreferences("admob_user_agent", 0);
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zze.zza("User agent is not initialized on Google Play Services. Initializing.");
            String defaultUserAgent = WebSettings.getDefaultUserAgent(this.zza);
            SharedPreferencesUtils.publishWorldReadableSharedPreferences(this.zza, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
            return defaultUserAgent;
        }
        zze.zza("User agent is already initialized on Google Play Services.");
        return string;
    }
}
