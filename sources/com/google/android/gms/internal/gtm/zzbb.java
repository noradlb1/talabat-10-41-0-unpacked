package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.apptimize.av;
import com.braze.models.FeatureFlag;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Instrumented
final class zzbb extends zzan {
    private boolean started;
    private final zzay zzxp;
    private final zzck zzxq;
    private final zzcj zzxr;
    private final zzat zzxs;
    private long zzxt = Long.MIN_VALUE;
    private final zzbs zzxu;
    private final zzbs zzxv;
    private final zzcv zzxw;
    private long zzxx;
    private boolean zzxy;

    public zzbb(zzap zzap, zzar zzar) {
        super(zzap);
        Preconditions.checkNotNull(zzar);
        this.zzxr = new zzcj(zzap);
        this.zzxp = new zzay(zzap);
        this.zzxq = new zzck(zzap);
        this.zzxs = new zzat(zzap);
        this.zzxw = new zzcv(zzcn());
        this.zzxu = new zzbc(this, zzap);
        this.zzxv = new zzbd(this, zzap);
    }

    private final long zzds() {
        zzk.zzav();
        zzdb();
        try {
            return this.zzxp.zzds();
        } catch (SQLiteException e11) {
            zze("Failed to get min/max hit times from local store", e11);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public final void zzdx() {
        zzb((zzbw) new zzbf(this));
    }

    /* access modifiers changed from: private */
    public final void zzdy() {
        try {
            this.zzxp.zzdr();
            zzec();
        } catch (SQLiteException e11) {
            zzd("Failed to delete stale hits", e11);
        }
        this.zzxv.zzh(86400000);
    }

    private final void zzdz() {
        if (!this.zzxy && zzbq.zzen() && !this.zzxs.isConnected()) {
            if (this.zzxw.zzj(zzby.zzaan.get().longValue())) {
                this.zzxw.start();
                zzq("Connecting to service");
                if (this.zzxs.connect()) {
                    zzq("Connected to service");
                    this.zzxw.clear();
                    onServiceConnected();
                }
            }
        }
    }

    private final boolean zzea() {
        zzk.zzav();
        zzdb();
        zzq("Dispatching a batch of local hits");
        boolean z11 = !this.zzxs.isConnected();
        boolean z12 = !this.zzxq.zzfr();
        if (!z11 || !z12) {
            long max = (long) Math.max(zzbq.zzer(), zzbq.zzes());
            ArrayList arrayList = new ArrayList();
            long j11 = 0;
            while (true) {
                this.zzxp.beginTransaction();
                arrayList.clear();
                try {
                    List<zzcd> zzd = this.zzxp.zzd(max);
                    if (zzd.isEmpty()) {
                        zzq("Store is empty, nothing to dispatch");
                        zzee();
                        try {
                            this.zzxp.setTransactionSuccessful();
                            this.zzxp.endTransaction();
                            return false;
                        } catch (SQLiteException e11) {
                            zze("Failed to commit local dispatch transaction", e11);
                            zzee();
                            return false;
                        }
                    } else {
                        zza("Hits loaded from store. count", Integer.valueOf(zzd.size()));
                        for (zzcd zzfg : zzd) {
                            if (zzfg.zzfg() == j11) {
                                zzd("Database contains successfully uploaded hit", Long.valueOf(j11), Integer.valueOf(zzd.size()));
                                zzee();
                                try {
                                    this.zzxp.setTransactionSuccessful();
                                    this.zzxp.endTransaction();
                                    return false;
                                } catch (SQLiteException e12) {
                                    zze("Failed to commit local dispatch transaction", e12);
                                    zzee();
                                    return false;
                                }
                            }
                        }
                        if (this.zzxs.isConnected()) {
                            zzq("Service connected, sending hits to the service");
                            while (!zzd.isEmpty()) {
                                zzcd zzcd = zzd.get(0);
                                if (this.zzxs.zzb(zzcd)) {
                                    j11 = Math.max(j11, zzcd.zzfg());
                                    zzd.remove(zzcd);
                                    zzb("Hit sent do device AnalyticsService for delivery", zzcd);
                                    try {
                                        this.zzxp.zze(zzcd.zzfg());
                                        arrayList.add(Long.valueOf(zzcd.zzfg()));
                                    } catch (SQLiteException e13) {
                                        zze("Failed to remove hit that was send for delivery", e13);
                                        zzee();
                                        try {
                                            this.zzxp.setTransactionSuccessful();
                                            this.zzxp.endTransaction();
                                            return false;
                                        } catch (SQLiteException e14) {
                                            zze("Failed to commit local dispatch transaction", e14);
                                            zzee();
                                            return false;
                                        }
                                    } catch (Throwable th2) {
                                        try {
                                            this.zzxp.setTransactionSuccessful();
                                            this.zzxp.endTransaction();
                                            throw th2;
                                        } catch (SQLiteException e15) {
                                            zze("Failed to commit local dispatch transaction", e15);
                                            zzee();
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                        if (this.zzxq.zzfr()) {
                            List<Long> zzb = this.zzxq.zzb(zzd);
                            for (Long longValue : zzb) {
                                j11 = Math.max(j11, longValue.longValue());
                            }
                            try {
                                this.zzxp.zza(zzb);
                                arrayList.addAll(zzb);
                            } catch (SQLiteException e16) {
                                zze("Failed to remove successfully uploaded hits", e16);
                                zzee();
                                try {
                                    this.zzxp.setTransactionSuccessful();
                                    this.zzxp.endTransaction();
                                    return false;
                                } catch (SQLiteException e17) {
                                    zze("Failed to commit local dispatch transaction", e17);
                                    zzee();
                                    return false;
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            try {
                                this.zzxp.setTransactionSuccessful();
                                this.zzxp.endTransaction();
                                return false;
                            } catch (SQLiteException e18) {
                                zze("Failed to commit local dispatch transaction", e18);
                                zzee();
                                return false;
                            }
                        } else {
                            try {
                                this.zzxp.setTransactionSuccessful();
                                this.zzxp.endTransaction();
                            } catch (SQLiteException e19) {
                                zze("Failed to commit local dispatch transaction", e19);
                                zzee();
                                return false;
                            }
                        }
                    }
                } catch (SQLiteException e21) {
                    zzd("Failed to read hits from persisted store", e21);
                    zzee();
                    try {
                        this.zzxp.setTransactionSuccessful();
                        this.zzxp.endTransaction();
                        return false;
                    } catch (SQLiteException e22) {
                        zze("Failed to commit local dispatch transaction", e22);
                        zzee();
                        return false;
                    }
                }
            }
        } else {
            zzq("No network or service available. Will retry later");
            return false;
        }
    }

    private final void zzed() {
        zzbv zzct = zzct();
        if (zzct.zzfc() && !zzct.zzez()) {
            long zzds = zzds();
            if (zzds != 0 && Math.abs(zzcn().currentTimeMillis() - zzds) <= zzby.zzzm.get().longValue()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzbq.zzeq()));
                zzct.zzfd();
            }
        }
    }

    private final void zzee() {
        if (this.zzxu.zzez()) {
            zzq("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzxu.cancel();
        zzbv zzct = zzct();
        if (zzct.zzez()) {
            zzct.cancel();
        }
    }

    private final long zzef() {
        long j11 = this.zzxt;
        if (j11 != Long.MIN_VALUE) {
            return j11;
        }
        long longValue = zzby.zzzh.get().longValue();
        zzda zzcu = zzcu();
        zzcu.zzdb();
        if (!zzcu.zzacv) {
            return longValue;
        }
        zzda zzcu2 = zzcu();
        zzcu2.zzdb();
        return ((long) zzcu2.zzaax) * 1000;
    }

    private final void zzeg() {
        zzdb();
        zzk.zzav();
        this.zzxy = true;
        this.zzxs.disconnect();
        zzec();
    }

    private final boolean zzx(String str) {
        return Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[LOOP:1: B:15:0x0044->B:23:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0040 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected() {
        /*
            r5 = this;
            com.google.android.gms.analytics.zzk.zzav()
            com.google.android.gms.analytics.zzk.zzav()
            r5.zzdb()
            boolean r0 = com.google.android.gms.internal.gtm.zzbq.zzen()
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService"
            r5.zzt(r0)
        L_0x0014:
            com.google.android.gms.internal.gtm.zzat r0 = r5.zzxs
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Service not connected"
            r5.zzq(r0)
            return
        L_0x0022:
            com.google.android.gms.internal.gtm.zzay r0 = r5.zzxp
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x007d
            java.lang.String r0 = "Dispatching local hits to device AnalyticsService"
            r5.zzq(r0)
        L_0x002f:
            com.google.android.gms.internal.gtm.zzay r0 = r5.zzxp     // Catch:{ SQLiteException -> 0x0074 }
            int r1 = com.google.android.gms.internal.gtm.zzbq.zzer()     // Catch:{ SQLiteException -> 0x0074 }
            long r1 = (long) r1     // Catch:{ SQLiteException -> 0x0074 }
            java.util.List r0 = r0.zzd(r1)     // Catch:{ SQLiteException -> 0x0074 }
            boolean r1 = r0.isEmpty()     // Catch:{ SQLiteException -> 0x0074 }
            if (r1 == 0) goto L_0x0044
            r5.zzec()     // Catch:{ SQLiteException -> 0x0074 }
            return
        L_0x0044:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x002f
            r1 = 0
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.gtm.zzcd r1 = (com.google.android.gms.internal.gtm.zzcd) r1
            com.google.android.gms.internal.gtm.zzat r2 = r5.zzxs
            boolean r2 = r2.zzb((com.google.android.gms.internal.gtm.zzcd) r1)
            if (r2 != 0) goto L_0x005d
            r5.zzec()
            return
        L_0x005d:
            r0.remove(r1)
            com.google.android.gms.internal.gtm.zzay r2 = r5.zzxp     // Catch:{ SQLiteException -> 0x006a }
            long r3 = r1.zzfg()     // Catch:{ SQLiteException -> 0x006a }
            r2.zze(r3)     // Catch:{ SQLiteException -> 0x006a }
            goto L_0x0044
        L_0x006a:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r5.zze(r1, r0)
            r5.zzee()
            return
        L_0x0074:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from store"
            r5.zze(r1, r0)
            r5.zzee()
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbb.onServiceConnected():void");
    }

    public final void start() {
        zzdb();
        Preconditions.checkState(!this.started, "Analytics backend already started");
        this.started = true;
        zzcq().zza((Runnable) new zzbe(this));
    }

    public final long zza(zzas zzas, boolean z11) {
        Preconditions.checkNotNull(zzas);
        zzdb();
        zzk.zzav();
        try {
            this.zzxp.beginTransaction();
            zzay zzay = this.zzxp;
            long zzdi = zzas.zzdi();
            String zzbt = zzas.zzbt();
            Preconditions.checkNotEmpty(zzbt);
            zzay.zzdb();
            zzk.zzav();
            SQLiteDatabase writableDatabase = zzay.getWritableDatabase();
            int i11 = 0;
            String[] strArr = {String.valueOf(zzdi), zzbt};
            int delete = !(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.delete(FeatureFlag.PROPERTIES, "app_uid=? AND cid<>?", strArr) : SQLiteInstrumentation.delete(writableDatabase, FeatureFlag.PROPERTIES, "app_uid=? AND cid<>?", strArr);
            if (delete > 0) {
                zzay.zza("Deleted property records", Integer.valueOf(delete));
            }
            long zza = this.zzxp.zza(zzas.zzdi(), zzas.zzbt(), zzas.zzdj());
            zzas.zzb(1 + zza);
            zzay zzay2 = this.zzxp;
            Preconditions.checkNotNull(zzas);
            zzay2.zzdb();
            zzk.zzav();
            SQLiteDatabase writableDatabase2 = zzay2.getWritableDatabase();
            Map<String, String> zzdm = zzas.zzdm();
            Preconditions.checkNotNull(zzdm);
            Uri.Builder builder = new Uri.Builder();
            for (Map.Entry next : zzdm.entrySet()) {
                builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
            String encodedQuery = builder.build().getEncodedQuery();
            if (encodedQuery == null) {
                encodedQuery = "";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uid", Long.valueOf(zzas.zzdi()));
            contentValues.put("cid", zzas.zzbt());
            contentValues.put("tid", zzas.zzdj());
            if (zzas.zzdk()) {
                i11 = 1;
            }
            contentValues.put("adid", Integer.valueOf(i11));
            contentValues.put("hits_count", Long.valueOf(zzas.zzdl()));
            contentValues.put(NativeProtocol.WEB_DIALOG_PARAMS, encodedQuery);
            try {
                if ((!(writableDatabase2 instanceof SQLiteDatabase) ? writableDatabase2.insertWithOnConflict(FeatureFlag.PROPERTIES, (String) null, contentValues, 5) : SQLiteInstrumentation.insertWithOnConflict(writableDatabase2, FeatureFlag.PROPERTIES, (String) null, contentValues, 5)) == -1) {
                    zzay2.zzu("Failed to insert/update a property (got -1)");
                }
            } catch (SQLiteException e11) {
                zzay2.zze("Error storing a property", e11);
            }
            this.zzxp.setTransactionSuccessful();
            try {
                this.zzxp.endTransaction();
            } catch (SQLiteException e12) {
                zze("Failed to end transaction", e12);
            }
            return zza;
        } catch (SQLiteException e13) {
            zze("Failed to update Analytics property", e13);
            try {
                this.zzxp.endTransaction();
            } catch (SQLiteException e14) {
                zze("Failed to end transaction", e14);
            }
            return -1;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            try {
                this.zzxp.endTransaction();
            } catch (SQLiteException e15) {
                zze("Failed to end transaction", e15);
            }
            throw th3;
        }
    }

    public final void zzaw() {
        this.zzxp.zzag();
        this.zzxq.zzag();
        this.zzxs.zzag();
    }

    public final void zzb(zzas zzas) {
        zzk.zzav();
        zzb("Sending first hit to property", zzas.zzdj());
        if (!zzcv().zzfw().zzj(zzbq.zzex())) {
            String zzfz = zzcv().zzfz();
            if (!TextUtils.isEmpty(zzfz)) {
                zzr zza = zzcz.zza(zzco(), zzfz);
                zzb("Found relevant installation campaign", zza);
                zza(zzas, zza);
            }
        }
    }

    public final void zzch() {
        zzk.zzav();
        zzdb();
        zzq("Delete all hits from local store");
        try {
            zzay zzay = this.zzxp;
            zzk.zzav();
            zzay.zzdb();
            SQLiteDatabase writableDatabase = zzay.getWritableDatabase();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.delete("hits2", (String) null, (String[]) null);
            } else {
                SQLiteInstrumentation.delete(writableDatabase, "hits2", (String) null, (String[]) null);
            }
            zzay zzay2 = this.zzxp;
            zzk.zzav();
            zzay2.zzdb();
            SQLiteDatabase writableDatabase2 = zzay2.getWritableDatabase();
            if (!(writableDatabase2 instanceof SQLiteDatabase)) {
                writableDatabase2.delete(FeatureFlag.PROPERTIES, (String) null, (String[]) null);
            } else {
                SQLiteInstrumentation.delete(writableDatabase2, FeatureFlag.PROPERTIES, (String) null, (String[]) null);
            }
            zzec();
        } catch (SQLiteException e11) {
            zzd("Failed to delete hits from store", e11);
        }
        zzdz();
        if (this.zzxs.zzdn()) {
            zzq("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public final void zzcl() {
        zzk.zzav();
        this.zzxx = zzcn().currentTimeMillis();
    }

    public final void zzdw() {
        zzdb();
        zzk.zzav();
        Context context = zzcm().getContext();
        if (!zzcp.zza(context)) {
            zzt("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzcq.zze(context)) {
            zzu("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zza(context)) {
            zzt("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzcv().zzfv();
        if (!zzx("android.permission.ACCESS_NETWORK_STATE")) {
            zzu("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzeg();
        }
        if (!zzx("android.permission.INTERNET")) {
            zzu("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzeg();
        }
        if (zzcq.zze(getContext())) {
            zzq("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzt("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzxy && !this.zzxp.isEmpty()) {
            zzdz();
        }
        zzec();
    }

    public final void zzeb() {
        zzk.zzav();
        zzdb();
        zzr("Sync dispatching local hits");
        long j11 = this.zzxx;
        zzdz();
        try {
            zzea();
            zzcv().zzfy();
            zzec();
            if (this.zzxx != j11) {
                this.zzxr.zzfq();
            }
        } catch (Exception e11) {
            zze("Sync local dispatch failed", e11);
            zzec();
        }
    }

    public final void zzec() {
        boolean z11;
        long j11;
        zzk.zzav();
        zzdb();
        boolean z12 = true;
        if (this.zzxy || zzef() <= 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            this.zzxr.unregister();
            zzee();
        } else if (this.zzxp.isEmpty()) {
            this.zzxr.unregister();
            zzee();
        } else {
            if (!zzby.zzaai.get().booleanValue()) {
                this.zzxr.zzfo();
                z12 = this.zzxr.isConnected();
            }
            if (z12) {
                zzed();
                long zzef = zzef();
                long zzfx = zzcv().zzfx();
                if (zzfx != 0) {
                    j11 = zzef - Math.abs(zzcn().currentTimeMillis() - zzfx);
                    if (j11 <= 0) {
                        j11 = Math.min(zzbq.zzep(), zzef);
                    }
                } else {
                    j11 = Math.min(zzbq.zzep(), zzef);
                }
                zza("Dispatch scheduled (ms)", Long.valueOf(j11));
                if (this.zzxu.zzez()) {
                    this.zzxu.zzi(Math.max(1, j11 + this.zzxu.zzey()));
                    return;
                }
                this.zzxu.zzh(j11);
                return;
            }
            zzee();
            zzed();
        }
    }

    public final void zzg(long j11) {
        zzk.zzav();
        zzdb();
        if (j11 < 0) {
            j11 = 0;
        }
        this.zzxt = j11;
        zzec();
    }

    public final void zzy(String str) {
        Preconditions.checkNotEmpty(str);
        zzk.zzav();
        zzr zza = zzcz.zza(zzco(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzfz = zzcv().zzfz();
        if (str.equals(zzfz)) {
            zzt("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(zzfz)) {
            zzd("Ignoring multiple install campaigns. original, new", zzfz, str);
        } else {
            zzcv().zzad(str);
            if (zzcv().zzfw().zzj(zzbq.zzex())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzas zza2 : this.zzxp.zzf(0)) {
                zza(zza2, zza);
            }
        }
    }

    public final void zzb(zzbw zzbw) {
        long j11 = this.zzxx;
        zzk.zzav();
        zzdb();
        long zzfx = zzcv().zzfx();
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(zzfx != 0 ? Math.abs(zzcn().currentTimeMillis() - zzfx) : -1));
        zzdz();
        try {
            zzea();
            zzcv().zzfy();
            zzec();
            if (zzbw != null) {
                zzbw.zza((Throwable) null);
            }
            if (this.zzxx != j11) {
                this.zzxr.zzfq();
            }
        } catch (Exception e11) {
            zze("Local dispatch failed", e11);
            zzcv().zzfy();
            zzec();
            if (zzbw != null) {
                zzbw.zza(e11);
            }
        }
    }

    public final void zza(zzcd zzcd) {
        Pair<String, Long> zzgc;
        Preconditions.checkNotNull(zzcd);
        zzk.zzav();
        zzdb();
        if (this.zzxy) {
            zzr("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzcd);
        }
        if (TextUtils.isEmpty(zzcd.zzfl()) && (zzgc = zzcv().zzga().zzgc()) != null) {
            String str = (String) zzgc.first;
            String valueOf = String.valueOf((Long) zzgc.second);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + String.valueOf(str).length());
            sb2.append(valueOf);
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append(str);
            String sb3 = sb2.toString();
            HashMap hashMap = new HashMap(zzcd.zzdm());
            hashMap.put("_m", sb3);
            zzcd = new zzcd(this, hashMap, zzcd.zzfh(), zzcd.zzfj(), zzcd.zzfg(), zzcd.zzff(), zzcd.zzfi());
        }
        zzdz();
        if (this.zzxs.zzb(zzcd)) {
            zzr("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.zzxp.zzc(zzcd);
            zzec();
        } catch (SQLiteException e11) {
            zze("Delivery failed to save hit to a database", e11);
            zzco().zza(zzcd, "deliver: failed to insert hit to database");
        }
    }

    private final void zza(zzas zzas, zzr zzr) {
        Preconditions.checkNotNull(zzas);
        Preconditions.checkNotNull(zzr);
        zza zza = new zza(zzcm());
        zza.zza(zzas.zzdj());
        zza.enableAdvertisingIdCollection(zzas.zzdk());
        zzg zzac = zza.zzac();
        zzz zzz = (zzz) zzac.zzb(zzz.class);
        zzz.zzl("data");
        zzz.zzb(true);
        zzac.zza((zzi) zzr);
        zzu zzu = (zzu) zzac.zzb(zzu.class);
        zzq zzq = (zzq) zzac.zzb(zzq.class);
        for (Map.Entry next : zzas.zzdm().entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if ("an".equals(str)) {
                zzq.setAppName(str2);
            } else if (av.f41238a.equals(str)) {
                zzq.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                zzq.setAppId(str2);
            } else if ("aiid".equals(str)) {
                zzq.setAppInstallerId(str2);
            } else if (PushNotificationParser.PUSH_ID_KEY.equals(str)) {
                zzz.setUserId(str2);
            } else {
                zzu.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", zzas.zzdj(), zzr);
        zzac.zza(zzcv().zzfv());
        zzac.zzam();
    }
}
