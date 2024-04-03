package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzt;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzefh extends zzcdh {
    private final Context zza;
    private final Executor zzb;
    private final zzceb zzc;
    private final zzcvo zzd;
    @GuardedBy("this")
    private final ArrayDeque<zzefe> zze;
    private final zzcec zzf;
    private final zzefm zzg;

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, java.util.concurrent.Executor] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzcec, java.util.concurrent.Executor] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzcec, com.google.android.gms.internal.ads.zzcvo] */
    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.internal.ads.zzceb, com.google.android.gms.internal.ads.zzcvo] */
    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.internal.ads.zzceb, java.util.ArrayDeque<com.google.android.gms.internal.ads.zzefe>] */
    /* JADX WARNING: type inference failed for: r7v0, types: [java.util.ArrayDeque<com.google.android.gms.internal.ads.zzefe>, com.google.android.gms.internal.ads.zzefm] */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzefh(android.content.Context r1, android.content.Context r2, java.util.concurrent.Executor r3, com.google.android.gms.internal.ads.zzcec r4, com.google.android.gms.internal.ads.zzcvo r5, com.google.android.gms.internal.ads.zzceb r6, java.util.ArrayDeque<com.google.android.gms.internal.ads.zzefe> r7, com.google.android.gms.internal.ads.zzefm r8) {
        /*
            r0 = this;
            r0.<init>()
            com.google.android.gms.internal.ads.zzblj.zzc(r1)
            r0.zza = r1
            r0.zzb = r2
            r0.zzf = r3
            r0.zzc = r5
            r0.zzd = r4
            r0.zze = r6
            r0.zzg = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefh.<init>(android.content.Context, java.util.concurrent.Executor, com.google.android.gms.internal.ads.zzcec, com.google.android.gms.internal.ads.zzcvo, com.google.android.gms.internal.ads.zzceb, java.util.ArrayDeque, com.google.android.gms.internal.ads.zzefm, byte[]):void");
    }

    private final synchronized zzefe zzl(String str) {
        Iterator<zzefe> it = this.zze.iterator();
        while (it.hasNext()) {
            zzefe next = it.next();
            if (next.zzd.equals(str)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    private final synchronized zzefe zzm(String str) {
        Iterator<zzefe> it = this.zze.iterator();
        while (it.hasNext()) {
            zzefe next = it.next();
            if (next.zzc.equals(str)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    private static zzfxa<zzcdt> zzn(zzfxa<JSONObject> zzfxa, zzfie zzfie, zzbwh zzbwh) {
        return zzfie.zzb(zzfhy.BUILD_URL, zzfxa).zzf(zzbwh.zza("AFMA_getAdDictionary", zzbwe.zza, zzees.zza)).zza();
    }

    private static zzfxa<JSONObject> zzo(zzcdq zzcdq, zzfie zzfie, zzewf zzewf) {
        zzeew zzeew = new zzeew(zzewf);
        return zzfie.zzb(zzfhy.GMS_SIGNALS, zzfwq.zzi(zzcdq.zza)).zzf(zzeew).zze(zzeet.zza).zza();
    }

    private final synchronized void zzp(zzefe zzefe) {
        zzq();
        this.zze.addLast(zzefe);
    }

    private final synchronized void zzq() {
        int intValue = zzbnc.zzc.zze().intValue();
        while (this.zze.size() >= intValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzr(zzfxa<InputStream> zzfxa, zzcdm zzcdm) {
        zzfwq.zzr(zzfwq.zzn(zzfxa, new zzeeu(this), zzcjm.zza), new zzefd(this, zzcdm), zzcjm.zzf);
    }

    public final zzfxa<InputStream> zzb(zzcdq zzcdq, int i11) {
        if (!zzbnc.zza.zze().booleanValue()) {
            return zzfwq.zzh(new Exception("Split request is disabled."));
        }
        zzffu zzffu = zzcdq.zzi;
        if (zzffu == null) {
            return zzfwq.zzh(new Exception("Pool configuration missing from request."));
        }
        if (zzffu.zzc == 0 || zzffu.zzd == 0) {
            return zzfwq.zzh(new Exception("Caching is disabled."));
        }
        zzbwh zzb2 = zzt.zzf().zzb(this.zza, zzcjf.zza());
        zzewf zzs = this.zzd.zzs(zzcdq, i11);
        zzfie zzc2 = zzs.zzc();
        zzfxa<JSONObject> zzo = zzo(zzcdq, zzc2, zzs);
        zzfxa<zzcdt> zzn = zzn(zzo, zzc2, zzb2);
        return zzc2.zza(zzfhy.GET_URL_AND_CACHE_KEY, zzo, zzn).zza(new zzeey(this, zzn, zzo, zzcdq)).zza();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfxa<java.io.InputStream> zzc(com.google.android.gms.internal.ads.zzcdq r12, int r13) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzbvy r0 = com.google.android.gms.ads.internal.zzt.zzf()
            android.content.Context r1 = r11.zza
            com.google.android.gms.internal.ads.zzcjf r2 = com.google.android.gms.internal.ads.zzcjf.zza()
            com.google.android.gms.internal.ads.zzbwh r0 = r0.zzb(r1, r2)
            com.google.android.gms.internal.ads.zzcvo r1 = r11.zzd
            com.google.android.gms.internal.ads.zzewf r1 = r1.zzs(r12, r13)
            com.google.android.gms.internal.ads.zzbwa<com.google.android.gms.internal.ads.zzefg> r2 = com.google.android.gms.internal.ads.zzefg.zza
            com.google.android.gms.internal.ads.zzbvz<java.io.InputStream> r3 = com.google.android.gms.internal.ads.zzbwe.zzb
            java.lang.String r4 = "google.afma.response.normalize"
            com.google.android.gms.internal.ads.zzbvx r2 = r0.zza(r4, r2, r3)
            com.google.android.gms.internal.ads.zzefo r3 = new com.google.android.gms.internal.ads.zzefo
            java.lang.String r4 = r12.zzg
            r3.<init>(r4)
            android.content.Context r6 = r11.zza
            com.google.android.gms.internal.ads.zzcjf r4 = r12.zzb
            java.lang.String r7 = r4.zza
            com.google.android.gms.internal.ads.zzcec r8 = r11.zzf
            com.google.android.gms.internal.ads.zzefl r4 = new com.google.android.gms.internal.ads.zzefl
            r10 = 0
            r5 = r4
            r9 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            com.google.android.gms.internal.ads.zzfie r13 = r1.zzc()
            com.google.android.gms.internal.ads.zzbml<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzbnc.zza
            java.lang.Object r5 = r5.zze()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r6 = 0
            if (r5 != 0) goto L_0x0058
            java.lang.String r5 = r12.zzj
            if (r5 == 0) goto L_0x0084
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0084
            java.lang.String r5 = "Request contained a PoolKey but split request is disabled."
            com.google.android.gms.ads.internal.util.zze.zza(r5)
            goto L_0x0084
        L_0x0058:
            com.google.android.gms.internal.ads.zzbml<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzbnc.zzd
            java.lang.Object r5 = r5.zze()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x006e
            java.lang.String r5 = r12.zzh
            com.google.android.gms.internal.ads.zzefe r5 = r11.zzm(r5)
        L_0x006c:
            r6 = r5
            goto L_0x007d
        L_0x006e:
            java.lang.String r5 = r12.zzj
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x007d
            java.lang.String r5 = r12.zzj
            com.google.android.gms.internal.ads.zzefe r5 = r11.zzl(r5)
            goto L_0x006c
        L_0x007d:
            if (r6 != 0) goto L_0x0084
            java.lang.String r5 = "Request contained a PoolKey but no matching parameters were found."
            com.google.android.gms.ads.internal.util.zze.zza(r5)
        L_0x0084:
            r5 = 1
            r7 = 0
            r8 = 2
            if (r6 != 0) goto L_0x00d3
            com.google.android.gms.internal.ads.zzfxa r12 = zzo(r12, r13, r1)
            com.google.android.gms.internal.ads.zzfxa r0 = zzn(r12, r13, r0)
            com.google.android.gms.internal.ads.zzfhy r1 = com.google.android.gms.internal.ads.zzfhy.HTTP
            com.google.android.gms.internal.ads.zzfxa[] r6 = new com.google.android.gms.internal.ads.zzfxa[r8]
            r6[r7] = r0
            r6[r5] = r12
            com.google.android.gms.internal.ads.zzfhm r1 = r13.zza(r1, r6)
            com.google.android.gms.internal.ads.zzeez r6 = new com.google.android.gms.internal.ads.zzeez
            r6.<init>(r12, r0)
            com.google.android.gms.internal.ads.zzfhv r1 = r1.zza(r6)
            com.google.android.gms.internal.ads.zzfhv r1 = r1.zze(r3)
            com.google.android.gms.internal.ads.zzfhv r1 = r1.zze(r4)
            com.google.android.gms.internal.ads.zzfhj r1 = r1.zza()
            com.google.android.gms.internal.ads.zzfhy r3 = com.google.android.gms.internal.ads.zzfhy.PRE_PROCESS
            r4 = 3
            com.google.android.gms.internal.ads.zzfxa[] r4 = new com.google.android.gms.internal.ads.zzfxa[r4]
            r4[r7] = r12
            r4[r5] = r0
            r4[r8] = r1
            com.google.android.gms.internal.ads.zzfhm r13 = r13.zza(r3, r4)
            com.google.android.gms.internal.ads.zzefb r3 = new com.google.android.gms.internal.ads.zzefb
            r3.<init>(r1, r12, r0)
            com.google.android.gms.internal.ads.zzfhv r12 = r13.zza(r3)
            com.google.android.gms.internal.ads.zzfhv r12 = r12.zzf(r2)
            com.google.android.gms.internal.ads.zzfhj r12 = r12.zza()
            return r12
        L_0x00d3:
            com.google.android.gms.internal.ads.zzefn r12 = new com.google.android.gms.internal.ads.zzefn
            org.json.JSONObject r0 = r6.zzb
            com.google.android.gms.internal.ads.zzcdt r1 = r6.zza
            r12.<init>(r0, r1)
            com.google.android.gms.internal.ads.zzfhy r0 = com.google.android.gms.internal.ads.zzfhy.HTTP
            com.google.android.gms.internal.ads.zzfxa r12 = com.google.android.gms.internal.ads.zzfwq.zzi(r12)
            com.google.android.gms.internal.ads.zzfhv r12 = r13.zzb(r0, r12)
            com.google.android.gms.internal.ads.zzfhv r12 = r12.zze(r3)
            com.google.android.gms.internal.ads.zzfhv r12 = r12.zze(r4)
            com.google.android.gms.internal.ads.zzfhj r12 = r12.zza()
            com.google.android.gms.internal.ads.zzfxa r0 = com.google.android.gms.internal.ads.zzfwq.zzi(r6)
            com.google.android.gms.internal.ads.zzfhy r1 = com.google.android.gms.internal.ads.zzfhy.PRE_PROCESS
            com.google.android.gms.internal.ads.zzfxa[] r3 = new com.google.android.gms.internal.ads.zzfxa[r8]
            r3[r7] = r12
            r3[r5] = r0
            com.google.android.gms.internal.ads.zzfhm r13 = r13.zza(r1, r3)
            com.google.android.gms.internal.ads.zzefa r1 = new com.google.android.gms.internal.ads.zzefa
            r1.<init>(r12, r0)
            com.google.android.gms.internal.ads.zzfhv r12 = r13.zza(r1)
            com.google.android.gms.internal.ads.zzfhv r12 = r12.zzf(r2)
            com.google.android.gms.internal.ads.zzfhj r12 = r12.zza()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefh.zzc(com.google.android.gms.internal.ads.zzcdq, int):com.google.android.gms.internal.ads.zzfxa");
    }

    public final zzfxa<InputStream> zzd(zzcdq zzcdq, int i11) {
        zzbwh zzb2 = zzt.zzf().zzb(this.zza, zzcjf.zza());
        if (!zzbnh.zza.zze().booleanValue()) {
            return zzfwq.zzh(new Exception("Signal collection disabled."));
        }
        zzewf zzs = this.zzd.zzs(zzcdq, i11);
        zzevq<JSONObject> zza2 = zzs.zza();
        return zzs.zzc().zzb(zzfhy.GET_SIGNALS, zzfwq.zzi(zzcdq.zza)).zzf(new zzeev(zza2)).zzb(zzfhy.JS_SIGNALS).zzf(zzb2.zza("google.afma.request.getSignals", zzbwe.zza, zzbwe.zzb)).zza();
    }

    public final void zze(zzcdq zzcdq, zzcdm zzcdm) {
        zzr(zzb(zzcdq, Binder.getCallingUid()), zzcdm);
    }

    public final void zzf(zzcdq zzcdq, zzcdm zzcdm) {
        zzr(zzd(zzcdq, Binder.getCallingUid()), zzcdm);
    }

    public final void zzg(zzcdq zzcdq, zzcdm zzcdm) {
        zzfxa<InputStream> zzc2 = zzc(zzcdq, Binder.getCallingUid());
        zzr(zzc2, zzcdm);
        zzc2.zzc(new zzeex(this), this.zzb);
    }

    public final void zzh(String str, zzcdm zzcdm) {
        zzr(zzi(str), zzcdm);
    }

    public final zzfxa<InputStream> zzi(String str) {
        zzefe zzefe;
        String str2;
        if (!zzbnc.zza.zze().booleanValue()) {
            return zzfwq.zzh(new Exception("Split request is disabled."));
        }
        zzefc zzefc = new zzefc(this);
        if (zzbnc.zzd.zze().booleanValue()) {
            zzefe = zzm(str);
        } else {
            zzefe = zzl(str);
        }
        if (zzefe != null) {
            return zzfwq.zzi(zzefc);
        }
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "URL to be removed not found for cache key: ".concat(valueOf);
        } else {
            str2 = new String("URL to be removed not found for cache key: ");
        }
        return zzfwq.zzh(new Exception(str2));
    }

    public final /* synthetic */ InputStream zzj(zzfxa zzfxa, zzfxa zzfxa2, zzcdq zzcdq) throws Exception {
        String zzc2 = ((zzcdt) zzfxa.get()).zzc();
        String str = zzcdq.zzh;
        zzp(new zzefe((zzcdt) zzfxa.get(), (JSONObject) zzfxa2.get(), str, zzc2));
        return new ByteArrayInputStream(zzc2.getBytes(zzfpt.zzc));
    }

    public final /* synthetic */ void zzk() {
        zzcjp.zza(this.zzc.zza(), "persistFlags");
    }
}
