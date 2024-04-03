package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class zzch implements Callable<String> {
    final /* synthetic */ Context zza;
    final /* synthetic */ Context zzb;

    public zzch(zzci zzci, Context context, Context context2) {
        this.zza = context;
        this.zzb = context2;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z11 = false;
        if (this.zza != null) {
            zze.zza("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zza.getSharedPreferences("admob_user_agent", 0);
        } else {
            zze.zza("Attempting to read user agent from local cache.");
            sharedPreferences = this.zzb.getSharedPreferences("admob_user_agent", 0);
            z11 = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zze.zza("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.zzb);
            if (z11) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zze.zza("Persisting user agent.");
            }
        }
        return string;
    }
}
