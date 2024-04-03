package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzebs;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzfxa;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzba {
    @VisibleForTesting
    protected String zza = "";
    private final Object zzb = new Object();
    @GuardedBy("lock")
    private String zzc = "";
    @GuardedBy("lock")
    private String zzd = "";
    @GuardedBy("lock")
    private boolean zze = false;
    @GuardedBy("lock")
    private boolean zzf = false;
    private zzebt zzg;

    @VisibleForTesting
    public static final String zzo(Context context, String str, String str2) {
        String str3;
        String str4;
        String str5;
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzt.zzp().zzd(context, str2));
        zzfxa<String> zzb2 = new zzbs(context).zzb(0, str, hashMap, (byte[]) null);
        try {
            return zzb2.get((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzdo)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e11) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str3 = "Timeout while retrieving a response from: ".concat(valueOf);
            } else {
                str3 = new String("Timeout while retrieving a response from: ");
            }
            zzciz.zzh(str3, e11);
            zzb2.cancel(true);
            return null;
        } catch (InterruptedException e12) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                str4 = "Interrupted while retrieving a response from: ".concat(valueOf2);
            } else {
                str4 = new String("Interrupted while retrieving a response from: ");
            }
            zzciz.zzh(str4, e12);
            zzb2.cancel(true);
            return null;
        } catch (Exception e13) {
            String valueOf3 = String.valueOf(str);
            if (valueOf3.length() != 0) {
                str5 = "Error retrieving a response from: ".concat(valueOf3);
            } else {
                str5 = new String("Error retrieving a response from: ");
            }
            zzciz.zzh(str5, e13);
            return null;
        }
    }

    private final Uri zzp(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        synchronized (this.zzb) {
            if (TextUtils.isEmpty(this.zzc)) {
                zzt.zzp();
                try {
                    str5 = new String(IOUtils.readInputStreamFully(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                } catch (IOException unused) {
                    zzciz.zze("Error reading from internal storage.");
                    str5 = "";
                }
                this.zzc = str5;
                if (TextUtils.isEmpty(str5)) {
                    zzt.zzp();
                    this.zzc = UUID.randomUUID().toString();
                    zzt.zzp();
                    String str6 = this.zzc;
                    try {
                        FileOutputStream openFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        openFileOutput.write(str6.getBytes("UTF-8"));
                        openFileOutput.close();
                    } catch (Exception e11) {
                        zzciz.zzh("Error writing to file in internal storage.", e11);
                    }
                }
            }
            str4 = this.zzc;
        }
        buildUpon.appendQueryParameter("linkedDeviceId", str4);
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    public final zzebt zza() {
        return this.zzg;
    }

    public final String zzb() {
        String str;
        synchronized (this.zzb) {
            str = this.zzd;
        }
        return str;
    }

    public final void zzc(Context context) {
        zzebt zzebt;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgP)).booleanValue() && (zzebt = this.zzg) != null) {
            zzebt.zzg(new zzax(this, context), zzebs.DEBUG_MENU);
        }
    }

    public final void zzd(Context context, String str, String str2) {
        zzt.zzp();
        zzt.zzY(context, zzp(context, (String) zzbgq.zzc().zzb(zzblj.zzdk), str, str2));
    }

    public final void zze(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzp(context, (String) zzbgq.zzc().zzb(zzblj.zzdn), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzt.zzp();
        zzt.zzO(context, str, buildUpon.build().toString());
    }

    public final void zzf(boolean z11) {
        synchronized (this.zzb) {
            this.zzf = z11;
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgP)).booleanValue()) {
                zzt.zzo().zzh().zzz(z11);
                zzebt zzebt = this.zzg;
                if (zzebt != null) {
                    zzebt.zzi(z11);
                }
            }
        }
    }

    public final void zzg(zzebt zzebt) {
        this.zzg = zzebt;
    }

    public final void zzh(boolean z11) {
        synchronized (this.zzb) {
            this.zze = z11;
        }
    }

    @VisibleForTesting
    public final void zzi(Context context, String str, boolean z11, boolean z12) {
        if (!(context instanceof Activity)) {
            zzciz.zzi("Can not create dialog without Activity Context");
        } else {
            zzt.zza.post(new zzaz(this, context, str, z11, z12));
        }
    }

    public final boolean zzj(Context context, String str, String str2) {
        String zzo = zzo(context, zzp(context, (String) zzbgq.zzc().zzb(zzblj.zzdm), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzo)) {
            zzciz.zze("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzo.trim()).optString("debug_mode"));
            zzf(equals);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgP)).booleanValue()) {
                zzg zzh = zzt.zzo().zzh();
                if (true != equals) {
                    str = "";
                }
                zzh.zzy(str);
            }
            return equals;
        } catch (JSONException e11) {
            zzciz.zzk("Fail to get debug mode response json.", e11);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzk(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzblb<java.lang.String> r0 = com.google.android.gms.internal.ads.zzblj.zzdl
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            android.net.Uri r0 = r3.zzp(r4, r0, r5, r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = zzo(r4, r0, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            r0 = 0
            if (r6 == 0) goto L_0x0025
            java.lang.String r4 = "Not linked for in app preview."
            com.google.android.gms.internal.ads.zzciz.zze(r4)
            return r0
        L_0x0025:
            java.lang.String r4 = r4.trim()
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r6.<init>((java.lang.String) r4)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r4 = "gct"
            java.lang.String r4 = r6.optString(r4)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "status"
            java.lang.String r6 = r6.optString(r1)     // Catch:{ JSONException -> 0x0083 }
            r3.zza = r6     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzblj.zzgP     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ JSONException -> 0x0083 }
            java.lang.Object r6 = r1.zzb(r6)     // Catch:{ JSONException -> 0x0083 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.booleanValue()     // Catch:{ JSONException -> 0x0083 }
            r1 = 1
            if (r6 == 0) goto L_0x0079
            java.lang.String r6 = "0"
            java.lang.String r2 = r3.zza     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r6 != 0) goto L_0x0066
            java.lang.String r6 = "2"
            java.lang.String r2 = r3.zza     // Catch:{ JSONException -> 0x0083 }
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r6 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r6 = r0
            goto L_0x0067
        L_0x0066:
            r6 = r1
        L_0x0067:
            r3.zzf(r6)     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.internal.ads.zzcik r2 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ JSONException -> 0x0083 }
            com.google.android.gms.ads.internal.util.zzg r2 = r2.zzh()     // Catch:{ JSONException -> 0x0083 }
            if (r1 == r6) goto L_0x0076
            java.lang.String r5 = ""
        L_0x0076:
            r2.zzy(r5)     // Catch:{ JSONException -> 0x0083 }
        L_0x0079:
            java.lang.Object r5 = r3.zzb
            monitor-enter(r5)
            r3.zzd = r4     // Catch:{ all -> 0x0080 }
            monitor-exit(r5)     // Catch:{ all -> 0x0080 }
            return r1
        L_0x0080:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0080 }
            throw r4
        L_0x0083:
            r4 = move-exception
            java.lang.String r5 = "Fail to get in app preview response json."
            com.google.android.gms.internal.ads.zzciz.zzk(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzba.zzk(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public final boolean zzl() {
        boolean z11;
        synchronized (this.zzb) {
            z11 = this.zzf;
        }
        return z11;
    }

    public final boolean zzm() {
        boolean z11;
        synchronized (this.zzb) {
            z11 = this.zze;
        }
        return z11;
    }

    public final boolean zzn(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzm()) {
            return false;
        }
        zzciz.zze("Sending troubleshooting signals to the server.");
        zze(context, str, str2, str3);
        return true;
    }
}
