package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzenx extends zzbzq {
    private final String zza;
    private final zzbzo zzb;
    private final zzcjr<JSONObject> zzc;
    private final JSONObject zzd;
    @GuardedBy("this")
    private boolean zze = false;

    public zzenx(String str, zzbzo zzbzo, zzcjr<JSONObject> zzcjr) {
        JSONObject jSONObject = new JSONObject();
        this.zzd = jSONObject;
        this.zzc = zzcjr;
        this.zza = str;
        this.zzb = zzbzo;
        try {
            jSONObject.put("adapter_version", (Object) zzbzo.zzf().toString());
            jSONObject.put("sdk_version", (Object) zzbzo.zzg().toString());
            jSONObject.put("name", (Object) str);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    public final synchronized void zzb() {
        if (!this.zze) {
            this.zzc.zzd(this.zzd);
            this.zze = true;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze(java.lang.String r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.lang.String r3 = "Adapter returned null signals"
            r2.zzf(r3)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0010:
            org.json.JSONObject r0 = r2.zzd     // Catch:{ JSONException -> 0x0017 }
            java.lang.String r1 = "signals"
            r0.put((java.lang.String) r1, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0017 }
        L_0x0017:
            com.google.android.gms.internal.ads.zzcjr<org.json.JSONObject> r3 = r2.zzc     // Catch:{ all -> 0x0023 }
            org.json.JSONObject r0 = r2.zzd     // Catch:{ all -> 0x0023 }
            r3.zzd(r0)     // Catch:{ all -> 0x0023 }
            r3 = 1
            r2.zze = r3     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenx.zze(java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf(java.lang.String r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            org.json.JSONObject r0 = r2.zzd     // Catch:{ JSONException -> 0x000e }
            java.lang.String r1 = "signal_error"
            r0.put((java.lang.String) r1, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x000e }
        L_0x000e:
            com.google.android.gms.internal.ads.zzcjr<org.json.JSONObject> r3 = r2.zzc     // Catch:{ all -> 0x001a }
            org.json.JSONObject r0 = r2.zzd     // Catch:{ all -> 0x001a }
            r3.zzd(r0)     // Catch:{ all -> 0x001a }
            r3 = 1
            r2.zze = r3     // Catch:{ all -> 0x001a }
            monitor-exit(r2)
            return
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenx.zzf(java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg(com.google.android.gms.internal.ads.zzbew r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            org.json.JSONObject r0 = r2.zzd     // Catch:{ JSONException -> 0x0010 }
            java.lang.String r1 = "signal_error"
            java.lang.String r3 = r3.zzb     // Catch:{ JSONException -> 0x0010 }
            r0.put((java.lang.String) r1, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0010 }
        L_0x0010:
            com.google.android.gms.internal.ads.zzcjr<org.json.JSONObject> r3 = r2.zzc     // Catch:{ all -> 0x001c }
            org.json.JSONObject r0 = r2.zzd     // Catch:{ all -> 0x001c }
            r3.zzd(r0)     // Catch:{ all -> 0x001c }
            r3 = 1
            r2.zze = r3     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenx.zzg(com.google.android.gms.internal.ads.zzbew):void");
    }
}
