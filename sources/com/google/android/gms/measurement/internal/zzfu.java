package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.deliveryhero.customerchat.eventTracking.constants.UserPropertyKeys;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzr;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Instrumented
public final class zzfu extends zzku implements zzaf {
    @VisibleForTesting
    final Map zza = new ArrayMap();
    @VisibleForTesting
    final Map zzb = new ArrayMap();
    @VisibleForTesting
    final Map zzc = new ArrayMap();
    @VisibleForTesting
    final LruCache zzd = new zzfr(this, 20);
    final zzr zze = new zzfs(this);
    /* access modifiers changed from: private */
    public final Map zzg = new ArrayMap();
    private final Map zzh = new ArrayMap();
    private final Map zzi = new ArrayMap();
    private final Map zzj = new ArrayMap();
    private final Map zzk = new ArrayMap();
    private final Map zzl = new ArrayMap();

    public zzfu(zzlh zzlh) {
        super(zzlh);
    }

    @WorkerThread
    private final zzff zzA(String str, byte[] bArr) {
        Long l11;
        if (bArr == null) {
            return zzff.zzg();
        }
        try {
            zzff zzff = (zzff) ((zzfe) zzlj.zzm(zzff.zze(), bArr)).zzaD();
            zzer zzj2 = this.zzt.zzaA().zzj();
            String str2 = null;
            if (zzff.zzu()) {
                l11 = Long.valueOf(zzff.zzc());
            } else {
                l11 = null;
            }
            if (zzff.zzt()) {
                str2 = zzff.zzh();
            }
            zzj2.zzc("Parsed config. version, gmp_app_id", l11, str2);
            return zzff;
        } catch (zzll e11) {
            this.zzt.zzaA().zzk().zzc("Unable to merge remote config. appId", zzet.zzn(str), e11);
            return zzff.zzg();
        } catch (RuntimeException e12) {
            this.zzt.zzaA().zzk().zzc("Unable to merge remote config. appId", zzet.zzn(str), e12);
            return zzff.zzg();
        }
    }

    private final void zzB(String str, zzfe zzfe) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        for (zzfb zzb2 : zzfe.zzg()) {
            hashSet.add(zzb2.zzb());
        }
        for (int i11 = 0; i11 < zzfe.zza(); i11++) {
            zzfc zzfc = (zzfc) zzfe.zzb(i11).zzbB();
            if (zzfc.zzc().isEmpty()) {
                this.zzt.zzaA().zzk().zza("EventConfig contained null event name");
            } else {
                String zzc2 = zzfc.zzc();
                String zzb3 = zzhc.zzb(zzfc.zzc());
                if (!TextUtils.isEmpty(zzb3)) {
                    zzfc.zzb(zzb3);
                    zzfe.zzd(i11, zzfc);
                }
                if (zzfc.zzf() && zzfc.zzd()) {
                    arrayMap.put(zzc2, Boolean.TRUE);
                }
                if (zzfc.zzg() && zzfc.zze()) {
                    arrayMap2.put(zzfc.zzc(), Boolean.TRUE);
                }
                if (zzfc.zzh()) {
                    if (zzfc.zza() < 2 || zzfc.zza() > 65535) {
                        this.zzt.zzaA().zzk().zzc("Invalid sampling rate. Event name, sample rate", zzfc.zzc(), Integer.valueOf(zzfc.zza()));
                    } else {
                        arrayMap3.put(zzfc.zzc(), Integer.valueOf(zzfc.zza()));
                    }
                }
            }
        }
        this.zza.put(str, hashSet);
        this.zzb.put(str, arrayMap);
        this.zzc.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a0, code lost:
        if (r2 != null) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0124  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzC(java.lang.String r14) {
        /*
            r13 = this;
            r13.zzW()
            r13.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            java.util.Map r0 = r13.zzh
            java.lang.Object r0 = r0.get(r14)
            if (r0 != 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zzlh r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzak r0 = r0.zzh()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r0.zzg()
            r0.zzW()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.zzh()     // Catch:{ SQLiteException -> 0x008a, all -> 0x0087 }
            java.lang.String r3 = "apps"
            java.lang.String r4 = "remote_config"
            java.lang.String r5 = "config_last_modified_time"
            java.lang.String r6 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6}     // Catch:{ SQLiteException -> 0x008a, all -> 0x0087 }
            java.lang.String r5 = "app_id=?"
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x008a, all -> 0x0087 }
            r11 = 0
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x008a, all -> 0x0087 }
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r12 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x008a, all -> 0x0087 }
            if (r12 != 0) goto L_0x0048
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x008a, all -> 0x0087 }
            goto L_0x004c
        L_0x0048:
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x008a, all -> 0x0087 }
        L_0x004c:
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0085 }
            if (r3 != 0) goto L_0x0053
            goto L_0x00a2
        L_0x0053:
            byte[] r3 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r4 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x0085 }
            r5 = 2
            java.lang.String r5 = r2.getString(r5)     // Catch:{ SQLiteException -> 0x0085 }
            boolean r6 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0085 }
            if (r6 == 0) goto L_0x0079
            com.google.android.gms.measurement.internal.zzgd r6 = r0.zzt     // Catch:{ SQLiteException -> 0x0085 }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()     // Catch:{ SQLiteException -> 0x0085 }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r14)     // Catch:{ SQLiteException -> 0x0085 }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0085 }
        L_0x0079:
            if (r3 != 0) goto L_0x007c
            goto L_0x00a2
        L_0x007c:
            com.google.android.gms.measurement.internal.zzah r6 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ SQLiteException -> 0x0085 }
            r6.<init>(r3, r4, r5)     // Catch:{ SQLiteException -> 0x0085 }
            r2.close()
            goto L_0x00a6
        L_0x0085:
            r3 = move-exception
            goto L_0x008d
        L_0x0087:
            r14 = move-exception
            goto L_0x0122
        L_0x008a:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x008d:
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r14)     // Catch:{ all -> 0x0120 }
            r0.zzc(r4, r5, r3)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x00a5
        L_0x00a2:
            r2.close()
        L_0x00a5:
            r6 = r1
        L_0x00a6:
            if (r6 != 0) goto L_0x00d6
            java.util.Map r0 = r13.zzg
            r0.put(r14, r1)
            java.util.Map r0 = r13.zzb
            r0.put(r14, r1)
            java.util.Map r0 = r13.zza
            r0.put(r14, r1)
            java.util.Map r0 = r13.zzc
            r0.put(r14, r1)
            java.util.Map r0 = r13.zzh
            r0.put(r14, r1)
            java.util.Map r0 = r13.zzj
            r0.put(r14, r1)
            java.util.Map r0 = r13.zzk
            r0.put(r14, r1)
            java.util.Map r0 = r13.zzl
            r0.put(r14, r1)
            java.util.Map r0 = r13.zzi
            r0.put(r14, r1)
            return
        L_0x00d6:
            byte[] r0 = r6.zza
            com.google.android.gms.internal.measurement.zzff r0 = r13.zzA(r14, r0)
            com.google.android.gms.internal.measurement.zzkx r0 = r0.zzbB()
            com.google.android.gms.internal.measurement.zzfe r0 = (com.google.android.gms.internal.measurement.zzfe) r0
            r13.zzB(r14, r0)
            java.util.Map r1 = r13.zzg
            com.google.android.gms.internal.measurement.zzlb r2 = r0.zzaD()
            com.google.android.gms.internal.measurement.zzff r2 = (com.google.android.gms.internal.measurement.zzff) r2
            java.util.Map r2 = zzE(r2)
            r1.put(r14, r2)
            java.util.Map r1 = r13.zzh
            com.google.android.gms.internal.measurement.zzlb r2 = r0.zzaD()
            com.google.android.gms.internal.measurement.zzff r2 = (com.google.android.gms.internal.measurement.zzff) r2
            r1.put(r14, r2)
            com.google.android.gms.internal.measurement.zzlb r1 = r0.zzaD()
            com.google.android.gms.internal.measurement.zzff r1 = (com.google.android.gms.internal.measurement.zzff) r1
            r13.zzD(r14, r1)
            java.util.Map r1 = r13.zzj
            java.lang.String r0 = r0.zze()
            r1.put(r14, r0)
            java.util.Map r0 = r13.zzk
            java.lang.String r1 = r6.zzb
            r0.put(r14, r1)
            java.util.Map r0 = r13.zzl
            java.lang.String r1 = r6.zzc
            r0.put(r14, r1)
            return
        L_0x0120:
            r14 = move-exception
            r1 = r2
        L_0x0122:
            if (r1 == 0) goto L_0x0127
            r1.close()
        L_0x0127:
            throw r14
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.zzC(java.lang.String):void");
    }

    @WorkerThread
    private final void zzD(String str, zzff zzff) {
        if (zzff.zza() != 0) {
            this.zzt.zzaA().zzj().zzb("EES programs found", Integer.valueOf(zzff.zza()));
            zzgt zzgt = (zzgt) zzff.zzo().get(0);
            try {
                zzc zzc2 = new zzc();
                zzc2.zzd("internal.remoteConfig", new zzfo(this, str));
                zzc2.zzd("internal.appMetadata", new zzfp(this, str));
                zzc2.zzd("internal.logger", new zzfq(this));
                zzc2.zzc(zzgt);
                this.zzd.put(str, zzc2);
                this.zzt.zzaA().zzj().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzgt.zza().zza()));
                for (zzgr zzb2 : zzgt.zza().zzd()) {
                    this.zzt.zzaA().zzj().zzb("EES program activity", zzb2.zzb());
                }
            } catch (zzd unused) {
                this.zzt.zzaA().zzd().zzb("Failed to load EES program. appId", str);
            }
        } else {
            this.zzd.remove(str);
        }
    }

    private static final Map zzE(zzff zzff) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzff != null) {
            for (zzfj zzfj : zzff.zzp()) {
                arrayMap.put(zzfj.zzb(), zzfj.zzc());
            }
        }
        return arrayMap;
    }

    public static /* bridge */ /* synthetic */ zzc zzd(zzfu zzfu, String str) {
        zzfu.zzW();
        Preconditions.checkNotEmpty(str);
        if (!zzfu.zzo(str)) {
            return null;
        }
        if (!zzfu.zzh.containsKey(str) || zzfu.zzh.get(str) == null) {
            zzfu.zzC(str);
        } else {
            zzfu.zzD(str, (zzff) zzfu.zzh.get(str));
        }
        return (zzc) zzfu.zzd.snapshot().get(str);
    }

    @WorkerThread
    public final String zza(String str, String str2) {
        zzg();
        zzC(str);
        Map map = (Map) this.zzg.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final boolean zzb() {
        return false;
    }

    @WorkerThread
    public final int zzc(String str, String str2) {
        Integer num;
        zzg();
        zzC(str);
        Map map = (Map) this.zzi.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @WorkerThread
    public final zzff zze(String str) {
        zzW();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzC(str);
        return (zzff) this.zzh.get(str);
    }

    @WorkerThread
    public final String zzf(String str) {
        zzg();
        return (String) this.zzl.get(str);
    }

    @WorkerThread
    public final String zzh(String str) {
        zzg();
        return (String) this.zzk.get(str);
    }

    @WorkerThread
    public final String zzi(String str) {
        zzg();
        zzC(str);
        return (String) this.zzj.get(str);
    }

    @WorkerThread
    public final Set zzk(String str) {
        zzg();
        zzC(str);
        return (Set) this.zza.get(str);
    }

    @WorkerThread
    public final void zzl(String str) {
        zzg();
        this.zzk.put(str, (Object) null);
    }

    @WorkerThread
    public final void zzm(String str) {
        zzg();
        this.zzh.remove(str);
    }

    @WorkerThread
    public final boolean zzn(String str) {
        zzg();
        zzff zze2 = zze(str);
        if (zze2 == null) {
            return false;
        }
        return zze2.zzs();
    }

    public final boolean zzo(String str) {
        zzff zzff;
        if (TextUtils.isEmpty(str) || (zzff = (zzff) this.zzh.get(str)) == null || zzff.zza() == 0) {
            return false;
        }
        return true;
    }

    public final boolean zzp(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    @WorkerThread
    public final boolean zzq(String str, String str2) {
        Boolean bool;
        zzg();
        zzC(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzc.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final boolean zzr(String str, String str2) {
        Boolean bool;
        zzg();
        zzC(str);
        if (zzp(str) && zzlp.zzaj(str2)) {
            return true;
        }
        if (zzs(str) && zzlp.zzak(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean zzs(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    @WorkerThread
    public final boolean zzt(String str, byte[] bArr, String str2, String str3) {
        int i11;
        zzW();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzfe zzfe = (zzfe) zzA(str, bArr).zzbB();
        zzB(str, zzfe);
        zzD(str, (zzff) zzfe.zzaD());
        this.zzh.put(str, (zzff) zzfe.zzaD());
        this.zzj.put(str, zzfe.zze());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzg.put(str, zzE((zzff) zzfe.zzaD()));
        this.zzf.zzh().zzB(str, new ArrayList(zzfe.zzf()));
        try {
            zzfe.zzc();
            bArr = ((zzff) zzfe.zzaD()).zzbx();
        } catch (RuntimeException e11) {
            this.zzt.zzaA().zzk().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzet.zzn(str), e11);
        }
        zzak zzh2 = this.zzf.zzh();
        Preconditions.checkNotEmpty(str);
        zzh2.zzg();
        zzh2.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            SQLiteDatabase zzh3 = zzh2.zzh();
            String[] strArr = {str};
            if (!(zzh3 instanceof SQLiteDatabase)) {
                i11 = zzh3.update("apps", contentValues, "app_id = ?", strArr);
            } else {
                i11 = SQLiteInstrumentation.update(zzh3, "apps", contentValues, "app_id = ?", strArr);
            }
            if (((long) i11) == 0) {
                zzh2.zzt.zzaA().zzd().zzb("Failed to update remote config (got 0). appId", zzet.zzn(str));
            }
        } catch (SQLiteException e12) {
            zzh2.zzt.zzaA().zzd().zzc("Error storing remote config. appId", zzet.zzn(str), e12);
        }
        this.zzh.put(str, (zzff) zzfe.zzaD());
        return true;
    }

    @WorkerThread
    public final boolean zzu(String str) {
        zzg();
        zzC(str);
        if (this.zza.get(str) == null || !((Set) this.zza.get(str)).contains("app_instance_id")) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzv(String str) {
        zzg();
        zzC(str);
        if (this.zza.get(str) == null) {
            return false;
        }
        if (((Set) this.zza.get(str)).contains("device_model")) {
            return true;
        }
        if (!((Set) this.zza.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM)) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzw(String str) {
        zzg();
        zzC(str);
        if (this.zza.get(str) == null || !((Set) this.zza.get(str)).contains("enhanced_user_id")) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzx(String str) {
        zzg();
        zzC(str);
        if (this.zza.get(str) == null || !((Set) this.zza.get(str)).contains("google_signals")) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzy(String str) {
        zzg();
        zzC(str);
        if (this.zza.get(str) == null) {
            return false;
        }
        if (((Set) this.zza.get(str)).contains(UserPropertyKeys.OS_VERSION)) {
            return true;
        }
        if (!((Set) this.zza.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM)) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzz(String str) {
        zzg();
        zzC(str);
        if (this.zza.get(str) == null || !((Set) this.zza.get(str)).contains("user_id")) {
            return false;
        }
        return true;
    }
}
