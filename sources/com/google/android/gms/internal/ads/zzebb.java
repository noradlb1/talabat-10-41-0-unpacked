package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzebb {
    private boolean zza = false;
    private boolean zzb = false;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final zzcjr<Boolean> zze = new zzcjr<>();
    private final Context zzf;
    private final WeakReference<Context> zzg;
    private final zzdww zzh;
    /* access modifiers changed from: private */
    public final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    /* access modifiers changed from: private */
    public final zzdzi zzl;
    private final zzcjf zzm;
    private final Map<String, zzbtn> zzn = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzdli zzo;
    private boolean zzp = true;

    public zzebb(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzdww zzdww, ScheduledExecutorService scheduledExecutorService, zzdzi zzdzi, zzcjf zzcjf, zzdli zzdli) {
        this.zzh = zzdww;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdzi;
        this.zzm = zzcjf;
        this.zzo = zzdli;
        this.zzd = zzt.zzA().elapsedRealtime();
        zzu("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public static /* bridge */ /* synthetic */ void zzi(zzebb zzebb, String str) {
        zzebb zzebb2 = zzebb;
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject(DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzcjr zzcjr = new zzcjr();
                zzfxa zzo2 = zzfwq.zzo(zzcjr, ((Long) zzbgq.zzc().zzb(zzblj.zzbp)).longValue(), TimeUnit.SECONDS, zzebb2.zzk);
                zzebb2.zzl.zzb(next);
                zzebb2.zzo.zzb(next);
                long elapsedRealtime = zzt.zzA().elapsedRealtime();
                Iterator<String> it = keys;
                zzeaw zzeaw = r1;
                zzeaw zzeaw2 = new zzeaw(zzebb, obj, zzcjr, next, elapsedRealtime);
                zzo2.zzc(zzeaw, zzebb2.zzi);
                arrayList.add(zzo2);
                zzeba zzeba = new zzeba(zzebb, obj, next, elapsedRealtime, zzcjr);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzbtx(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzebb2.zzu(next, false, "", 0);
                try {
                    zzebb2.zzj.execute(new zzeav(zzebb, zzebb2.zzh.zzb(next, new JSONObject()), zzeba, arrayList2, next));
                } catch (zzfek unused2) {
                    try {
                        zzeba.zze("Failed to create Adapter.");
                    } catch (RemoteException e11) {
                        zzciz.zzh("", e11);
                    }
                }
                keys = it;
            }
            zzfwq.zza(arrayList).zza(new zzeax(zzebb2), zzebb2.zzi);
        } catch (JSONException e12) {
            zze.zzb("Malformed CLD response", e12);
        }
    }

    private final synchronized zzfxa<String> zzt() {
        String zzc2 = zzt.zzo().zzh().zzg().zzc();
        if (!TextUtils.isEmpty(zzc2)) {
            return zzfwq.zzi(zzc2);
        }
        zzcjr zzcjr = new zzcjr();
        zzt.zzo().zzh().zzo(new zzeau(this, zzcjr));
        return zzcjr;
    }

    /* access modifiers changed from: private */
    public final void zzu(String str, boolean z11, String str2, int i11) {
        this.zzn.put(str, new zzbtn(str, z11, i11, str2));
    }

    public final /* synthetic */ Object zze() throws Exception {
        this.zze.zzd(Boolean.TRUE);
        return null;
    }

    public final List<zzbtn> zzf() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzn.keySet()) {
            zzbtn zzbtn = this.zzn.get(next);
            arrayList.add(new zzbtn(next, zzbtn.zzb, zzbtn.zzc, zzbtn.zzd));
        }
        return arrayList;
    }

    public final void zzk() {
        this.zzp = false;
    }

    public final /* synthetic */ void zzl() {
        synchronized (this) {
            if (!this.zzc) {
                zzu("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzt.zzA().elapsedRealtime() - this.zzd));
                this.zze.zze(new Exception());
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzciz.zzh("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.zze(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzm(com.google.android.gms.internal.ads.zzfev r2, com.google.android.gms.internal.ads.zzbtr r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.zzg     // Catch:{ zzfek -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzfek -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzfek -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzf     // Catch:{ zzfek -> 0x0011 }
        L_0x000d:
            r2.zzi(r0, r3, r4)     // Catch:{ zzfek -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.zze(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzciz.zzh(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebb.zzm(com.google.android.gms.internal.ads.zzfev, com.google.android.gms.internal.ads.zzbtr, java.util.List, java.lang.String):void");
    }

    public final /* synthetic */ void zzn(zzcjr zzcjr) {
        this.zzi.execute(new zzeat(this, zzcjr));
    }

    public final /* synthetic */ void zzo() {
        this.zzl.zzd();
        this.zzo.zzd();
        this.zzb = true;
    }

    public final /* synthetic */ void zzp(Object obj, zzcjr zzcjr, String str, long j11) {
        synchronized (obj) {
            if (!zzcjr.isDone()) {
                zzu(str, false, "Timeout.", (int) (zzt.zzA().elapsedRealtime() - j11));
                this.zzl.zza(str, "timeout");
                this.zzo.zza(str, "timeout");
                zzcjr.zzd(Boolean.FALSE);
            }
        }
    }

    public final void zzq() {
        if (!zzbnb.zza.zze().booleanValue()) {
            if (this.zzm.zzc >= ((Integer) zzbgq.zzc().zzb(zzblj.zzbo)).intValue() && this.zzp) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zze();
                            this.zzo.zze();
                            this.zze.zzc(new zzear(this), this.zzi);
                            this.zza = true;
                            zzfxa<String> zzt = zzt();
                            this.zzk.schedule(new zzeaq(this), ((Long) zzbgq.zzc().zzb(zzblj.zzbq)).longValue(), TimeUnit.SECONDS);
                            zzfwq.zzr(zzt, new zzeaz(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzu("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzd(Boolean.FALSE);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final void zzr(zzbtu zzbtu) {
        this.zze.zzc(new zzeas(this, zzbtu), this.zzj);
    }

    public final boolean zzs() {
        return this.zzb;
    }
}
