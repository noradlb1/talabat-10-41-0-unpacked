package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

final /* synthetic */ class zzg implements Runnable {
    private final String zza;
    private final String zzb;
    private final zzi[] zzc;

    public zzg(String str, String str2, zzi[] zziArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zziArr;
    }

    public final void run() {
        JSONObject jSONObject;
        String str = this.zza;
        String str2 = this.zzb;
        zzi[] zziArr = this.zzc;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (JSONException unused) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase).length() + 32 + String.valueOf(str2).length());
                    sb2.append("Action[");
                    sb2.append(lowerCase);
                    sb2.append("]: failed to parse args: ");
                    sb2.append(str2);
                    return;
                }
            }
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb3 = new StringBuilder(String.valueOf(lowerCase).length() + 10 + valueOf.length());
            sb3.append("Action[");
            sb3.append(lowerCase);
            sb3.append("]: ");
            sb3.append(valueOf);
            int length = zziArr.length;
            int i11 = 0;
            while (i11 < length) {
                zzi zzi = zziArr[i11];
                FutureTask futureTask = new FutureTask(new zzf(zzi, lowerCase, jSONObject));
                zzi.zza().execute(futureTask);
                try {
                    if (!((Boolean) futureTask.get()).booleanValue()) {
                        i11++;
                    } else {
                        return;
                    }
                } catch (ExecutionException e11) {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(lowerCase).length() + 24);
                    sb4.append("Failed to run Action[");
                    sb4.append(lowerCase);
                    sb4.append("]: ");
                    zzca.zza(sb4.toString(), e11.getCause());
                } catch (InterruptedException e12) {
                    StringBuilder sb5 = new StringBuilder(String.valueOf(lowerCase).length() + 33);
                    sb5.append("Thread interrupted for Action[");
                    sb5.append(lowerCase);
                    sb5.append("]: ");
                    zzca.zza(sb5.toString(), e12);
                }
            }
        }
    }
}
