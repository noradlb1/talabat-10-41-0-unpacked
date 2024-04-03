package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import i.b;
import java.util.concurrent.atomic.AtomicReference;

public final class zzdww {
    private final zzdwt zza;
    private final AtomicReference<zzbxh> zzb = new AtomicReference<>();

    public zzdww(zzdwt zzdwt) {
        this.zza = zzdwt;
    }

    private final zzbxh zze() throws RemoteException {
        zzbxh zzbxh = this.zzb.get();
        if (zzbxh != null) {
            return zzbxh;
        }
        zzciz.zzj("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbzo zza(String str) throws RemoteException {
        zzbzo zzc = zze().zzc(str);
        this.zza.zzd(str, zzc);
        return zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(r6) != false) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfev zzb(java.lang.String r6, org.json.JSONObject r7) throws com.google.android.gms.internal.ads.zzfek {
        /*
            r5 = this;
            java.lang.String r0 = "com.google.ads.mediation.customevent.CustomEventAdapter"
            com.google.android.gms.internal.ads.zzfev r1 = new com.google.android.gms.internal.ads.zzfev     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzbyg r7 = new com.google.android.gms.internal.ads.zzbyg     // Catch:{ all -> 0x0083 }
            com.google.ads.mediation.admob.AdMobAdapter r0 = new com.google.ads.mediation.admob.AdMobAdapter     // Catch:{ all -> 0x0083 }
            r0.<init>()     // Catch:{ all -> 0x0083 }
            r7.<init>((com.google.android.gms.ads.mediation.MediationAdapter) r0)     // Catch:{ all -> 0x0083 }
            goto L_0x007a
        L_0x0017:
            java.lang.String r2 = "com.google.ads.mediation.AdUrlAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbyg r7 = new com.google.android.gms.internal.ads.zzbyg     // Catch:{ all -> 0x0083 }
            com.google.ads.mediation.AdUrlAdapter r0 = new com.google.ads.mediation.AdUrlAdapter     // Catch:{ all -> 0x0083 }
            r0.<init>()     // Catch:{ all -> 0x0083 }
            r7.<init>((com.google.android.gms.ads.mediation.MediationAdapter) r0)     // Catch:{ all -> 0x0083 }
            goto L_0x007a
        L_0x002a:
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobCustomTabsAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzbyg r7 = new com.google.android.gms.internal.ads.zzbyg     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzcaf r0 = new com.google.android.gms.internal.ads.zzcaf     // Catch:{ all -> 0x0083 }
            r0.<init>()     // Catch:{ all -> 0x0083 }
            r7.<init>((com.google.android.gms.ads.mediation.MediationAdapter) r0)     // Catch:{ all -> 0x0083 }
            goto L_0x007a
        L_0x003d:
            com.google.android.gms.internal.ads.zzbxh r2 = r5.zze()     // Catch:{ all -> 0x0083 }
            boolean r3 = r0.equals(r6)     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter"
            if (r3 != 0) goto L_0x004f
            boolean r3 = r4.equals(r6)     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x0076
        L_0x004f:
            java.lang.String r3 = "class_name"
            java.lang.String r7 = r7.getString(r3)     // Catch:{ JSONException -> 0x0070 }
            boolean r3 = r2.zzf(r7)     // Catch:{ JSONException -> 0x0070 }
            if (r3 == 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzbxk r7 = r2.zzb(r4)     // Catch:{ JSONException -> 0x0070 }
            goto L_0x007a
        L_0x0060:
            boolean r3 = r2.zze(r7)     // Catch:{ JSONException -> 0x0070 }
            if (r3 == 0) goto L_0x006b
            com.google.android.gms.internal.ads.zzbxk r7 = r2.zzb(r7)     // Catch:{ JSONException -> 0x0070 }
            goto L_0x007a
        L_0x006b:
            com.google.android.gms.internal.ads.zzbxk r7 = r2.zzb(r0)     // Catch:{ JSONException -> 0x0070 }
            goto L_0x007a
        L_0x0070:
            r7 = move-exception
            java.lang.String r0 = "Invalid custom event."
            com.google.android.gms.internal.ads.zzciz.zzh(r0, r7)     // Catch:{ all -> 0x0083 }
        L_0x0076:
            com.google.android.gms.internal.ads.zzbxk r7 = r2.zzb(r6)     // Catch:{ all -> 0x0083 }
        L_0x007a:
            r1.<init>(r7)     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzdwt r7 = r5.zza
            r7.zzc(r6, r1)
            return r1
        L_0x0083:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzfek r7 = new com.google.android.gms.internal.ads.zzfek
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdww.zzb(java.lang.String, org.json.JSONObject):com.google.android.gms.internal.ads.zzfev");
    }

    public final void zzc(zzbxh zzbxh) {
        b.a(this.zzb, (Object) null, zzbxh);
    }

    public final boolean zzd() {
        return this.zzb.get() != null;
    }
}
