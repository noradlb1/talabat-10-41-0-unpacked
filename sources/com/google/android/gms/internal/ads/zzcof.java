package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

public final class zzcof extends zzcky implements zzdx, zzld {
    public static final /* synthetic */ int zzc = 0;
    private final Context zzd;
    private final zzcnr zze;
    private final zzsp zzf;
    private final zzclg zzg;
    private final WeakReference<zzclh> zzh;
    private final zzrc zzi;
    private zziu zzj;
    private ByteBuffer zzk;
    private boolean zzl;
    private zzckx zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private final String zzq;
    private final int zzr;
    private final Object zzs = new Object();
    @GuardedBy("httpDataSourcesLock")
    private final ArrayList<zzdv> zzt;
    private volatile zzcnt zzu;
    private final Set<WeakReference<zzcnq>> zzv = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f4, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbgq.zzc().zzb(com.google.android.gms.internal.ads.zzblj.zzbr)).booleanValue() == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f8, code lost:
        if (r7.zzj == false) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fa, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fd, code lost:
        if (r7.zzi <= 0) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ff, code lost:
        r8 = new com.google.android.gms.internal.ads.zzcnx(r5, r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0105, code lost:
        r8 = new com.google.android.gms.internal.ads.zzcny(r5, r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010c, code lost:
        if (r7.zzj == false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x010e, code lost:
        r7 = new com.google.android.gms.internal.ads.zzcnw(r5, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0115, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0116, code lost:
        r6 = r5.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0118, code lost:
        if (r6 == null) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011e, code lost:
        if (r6.limit() <= 0) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0120, code lost:
        r6 = new byte[r5.zzk.limit()];
        r5.zzk.get(r6);
        r7 = new com.google.android.gms.internal.ads.zzcnv(r7, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcof(android.content.Context r6, com.google.android.gms.internal.ads.zzclg r7, com.google.android.gms.internal.ads.zzclh r8) {
        /*
            r5 = this;
            r5.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r5.zzs = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r5.zzv = r0
            r5.zzd = r6
            r5.zzg = r7
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r8)
            r5.zzh = r0
            com.google.android.gms.internal.ads.zzcnr r0 = new com.google.android.gms.internal.ads.zzcnr
            r0.<init>()
            r5.zze = r0
            com.google.android.gms.internal.ads.zzsp r1 = new com.google.android.gms.internal.ads.zzsp
            r1.<init>(r6)
            r5.zzf = r1
            boolean r2 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r2 == 0) goto L_0x003d
            java.lang.String r2 = "OfficialSimpleExoPlayerAdapter initialize "
            java.lang.String r3 = r5.toString()
            java.lang.String r2 = r2.concat(r3)
            com.google.android.gms.ads.internal.util.zze.zza(r2)
        L_0x003d:
            java.util.concurrent.atomic.AtomicInteger r2 = com.google.android.gms.internal.ads.zzcky.zza
            r2.incrementAndGet()
            com.google.android.gms.internal.ads.zzgi r2 = new com.google.android.gms.internal.ads.zzgi
            com.google.android.gms.internal.ads.zzcoa r3 = new com.google.android.gms.internal.ads.zzcoa
            r3.<init>(r5)
            r4 = 0
            r2.<init>(r6, r3, r4)
            r2.zzb(r1)
            r2.zza(r0)
            com.google.android.gms.internal.ads.zziu r0 = r2.zzc()
            r5.zzj = r0
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzbu
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 != 0) goto L_0x0071
            com.google.android.gms.internal.ads.zziu r0 = r5.zzj
            r0.zzV(r1)
        L_0x0071:
            com.google.android.gms.internal.ads.zziu r0 = r5.zzj
            r0.zzP(r5)
            r5.zzn = r1
            r2 = 0
            r5.zzp = r2
            r5.zzo = r1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.zzt = r0
            r5.zzu = r4
            if (r8 == 0) goto L_0x0094
            java.lang.String r0 = r8.zzt()
            if (r0 == 0) goto L_0x0094
            java.lang.String r0 = r8.zzt()
            goto L_0x0096
        L_0x0094:
            java.lang.String r0 = ""
        L_0x0096:
            r5.zzq = r0
            if (r8 == 0) goto L_0x009f
            int r0 = r8.zzh()
            goto L_0x00a0
        L_0x009f:
            r0 = r1
        L_0x00a0:
            r5.zzr = r0
            com.google.android.gms.internal.ads.zzrc r0 = new com.google.android.gms.internal.ads.zzrc
            com.google.android.gms.ads.internal.util.zzt r2 = com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.internal.ads.zzcjf r8 = r8.zzp()
            java.lang.String r8 = r8.zza
            java.lang.String r6 = r2.zzd(r6, r8)
            boolean r8 = r5.zzl
            if (r8 == 0) goto L_0x00d1
            java.nio.ByteBuffer r8 = r5.zzk
            int r8 = r8.limit()
            if (r8 <= 0) goto L_0x00d1
            java.nio.ByteBuffer r6 = r5.zzk
            int r6 = r6.limit()
            byte[] r6 = new byte[r6]
            java.nio.ByteBuffer r7 = r5.zzk
            r7.get(r6)
            com.google.android.gms.internal.ads.zzcnz r7 = new com.google.android.gms.internal.ads.zzcnz
            r7.<init>(r6)
            goto L_0x0133
        L_0x00d1:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r8 = com.google.android.gms.internal.ads.zzblj.zzbw
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r8 = r2.zzb(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2 = 1
            if (r8 == 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r8 = com.google.android.gms.internal.ads.zzblj.zzbr
            com.google.android.gms.internal.ads.zzblh r3 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r8 = r3.zzb(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x00fa
        L_0x00f6:
            boolean r8 = r7.zzj
            if (r8 != 0) goto L_0x00fb
        L_0x00fa:
            r1 = r2
        L_0x00fb:
            int r8 = r7.zzi
            if (r8 <= 0) goto L_0x0105
            com.google.android.gms.internal.ads.zzcnx r8 = new com.google.android.gms.internal.ads.zzcnx
            r8.<init>(r5, r6, r1)
            goto L_0x010a
        L_0x0105:
            com.google.android.gms.internal.ads.zzcny r8 = new com.google.android.gms.internal.ads.zzcny
            r8.<init>(r5, r6, r1)
        L_0x010a:
            boolean r6 = r7.zzj
            if (r6 == 0) goto L_0x0115
            com.google.android.gms.internal.ads.zzcnw r6 = new com.google.android.gms.internal.ads.zzcnw
            r6.<init>(r5, r8)
            r7 = r6
            goto L_0x0116
        L_0x0115:
            r7 = r8
        L_0x0116:
            java.nio.ByteBuffer r6 = r5.zzk
            if (r6 == 0) goto L_0x0133
            int r6 = r6.limit()
            if (r6 <= 0) goto L_0x0133
            java.nio.ByteBuffer r6 = r5.zzk
            int r6 = r6.limit()
            byte[] r6 = new byte[r6]
            java.nio.ByteBuffer r8 = r5.zzk
            r8.get(r6)
            com.google.android.gms.internal.ads.zzcnv r8 = new com.google.android.gms.internal.ads.zzcnv
            r8.<init>(r7, r6)
            r7 = r8
        L_0x0133:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzblj.zzm
            com.google.android.gms.internal.ads.zzblh r8 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r6 = r8.zzb(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0148
            com.google.android.gms.internal.ads.zzcob r6 = com.google.android.gms.internal.ads.zzcob.zza
            goto L_0x014a
        L_0x0148:
            com.google.android.gms.internal.ads.zzcoc r6 = com.google.android.gms.internal.ads.zzcoc.zza
        L_0x014a:
            r0.<init>(r7, r6)
            r5.zzi = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcof.<init>(android.content.Context, com.google.android.gms.internal.ads.zzclg, com.google.android.gms.internal.ads.zzclh):void");
    }

    private final boolean zzU() {
        return this.zzu != null && this.zzu.zzq();
    }

    public final void finalize() {
        zzcky.zza.decrementAndGet();
        if (zze.zzc()) {
            zze.zza("OfficialSimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final void zzA(Uri[] uriArr, String str) {
        zzB(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzB(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z11) {
        zzqb zzqb;
        if (this.zzj != null) {
            this.zzk = byteBuffer;
            this.zzl = z11;
            int length = uriArr.length;
            if (length == 1) {
                zzqb = zzR(uriArr[0]);
            } else {
                zzqb[] zzqbArr = new zzqb[length];
                for (int i11 = 0; i11 < uriArr.length; i11++) {
                    zzqbArr[i11] = zzR(uriArr[i11]);
                }
                zzqb = new zzqp(false, false, zzqbArr);
            }
            this.zzj.zzT(zzqb);
            this.zzj.zzQ();
            zzcky.zzb.incrementAndGet();
        }
    }

    public final void zzC() {
        zziu zziu = this.zzj;
        if (zziu != null) {
            zziu.zzS(this);
            this.zzj.zzR();
            this.zzj = null;
            zzcky.zzb.decrementAndGet();
        }
    }

    public final void zzD(long j11) {
        zziu zziu = this.zzj;
        zziu.zzn(zziu.zzg(), j11);
    }

    public final void zzE(int i11) {
        this.zze.zzk(i11);
    }

    public final void zzF(int i11) {
        this.zze.zzl(i11);
    }

    public final void zzG(zzckx zzckx) {
        this.zzm = zzckx;
    }

    public final void zzH(int i11) {
        this.zze.zzm(i11);
    }

    public final void zzI(int i11) {
        this.zze.zzn(i11);
    }

    public final void zzJ(boolean z11) {
        this.zzj.zzU(z11);
    }

    public final void zzK(boolean z11) {
        if (this.zzj != null) {
            int i11 = 0;
            while (true) {
                this.zzj.zzs();
                if (i11 < 2) {
                    zzsp zzsp = this.zzf;
                    zzsk zzd2 = zzsp.zzc().zzd();
                    zzd2.zzo(i11, !z11);
                    zzsp.zzg(zzd2);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzL(int i11) {
        for (WeakReference<zzcnq> weakReference : this.zzv) {
            zzcnq zzcnq = (zzcnq) weakReference.get();
            if (zzcnq != null) {
                zzcnq.zzm(i11);
            }
        }
    }

    public final void zzM(Surface surface, boolean z11) {
        zziu zziu = this.zzj;
        if (zziu != null) {
            zziu.zzW(surface);
        }
    }

    public final void zzN(float f11, boolean z11) {
        zziu zziu = this.zzj;
        if (zziu != null) {
            zziu.zzX(f11);
        }
    }

    public final void zzO() {
        this.zzj.zzY(false);
    }

    public final boolean zzP() {
        return this.zzj != null;
    }

    public final boolean zzQ() {
        return this.zzj.zzaa();
    }

    @VisibleForTesting
    public final zzqb zzR(Uri uri) {
        zzaf zzaf = new zzaf();
        zzaf.zzb(uri);
        zzaz zzc2 = zzaf.zzc();
        zzrc zzrc = this.zzi;
        zzrc.zza(this.zzg.zzg);
        return zzrc.zzb(zzc2);
    }

    public final /* synthetic */ void zzS(boolean z11, long j11) {
        zzckx zzckx = this.zzm;
        if (zzckx != null) {
            zzckx.zzi(z11, j11);
        }
    }

    public final /* synthetic */ zzil[] zzT(Handler handler, zzvp zzvp, zzlt zzlt, zzrv zzrv, zzpb zzpb) {
        Context context = this.zzd;
        zzol zzol = zzol.zzb;
        zzmr zzmr = new zzmr((zzle) null, new zzlh[0], false);
        zzoe zzoe = zzoe.zza;
        return new zzil[]{new zzmv(context, zzoe, zzol, false, handler, zzlt, zzmr), new zzuv(this.zzd, zzoe, zzol, 0, false, handler, zzvp, -1)};
    }

    public final void zza(zzdi zzdi, zzdm zzdm, boolean z11, int i11) {
        this.zzn += i11;
    }

    public final void zzb(zzdi zzdi, zzdm zzdm, boolean z11) {
    }

    public final void zzc(zzdi zzdi, zzdm zzdm, boolean z11) {
    }

    public final void zzd(zzdi zzdi, zzdm zzdm, boolean z11) {
        if (zzdi instanceof zzdv) {
            synchronized (this.zzs) {
                this.zzt.add((zzdv) zzdi);
            }
        } else if (zzdi instanceof zzcnt) {
            this.zzu = (zzcnt) zzdi;
            zzclh zzclh = this.zzh.get();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() && zzclh != null && this.zzu.zzn()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzu.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzu.zzo()));
                zzt.zza.post(new zzcoe(zzclh, hashMap));
            }
        }
    }

    public final void zze(zzlc zzlc, zzab zzab, @Nullable zzfz zzfz) {
        zzclh zzclh = this.zzh.get();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() && zzclh != null && zzab != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzab.zzl);
            hashMap.put("audioSampleMime", zzab.zzm);
            hashMap.put("audioCodec", zzab.zzj);
            zzclh.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzf(zzlc zzlc, int i11, long j11) {
        this.zzo += i11;
    }

    public final void zzg(zzlc zzlc, zzpr zzpr, zzpw zzpw, IOException iOException, boolean z11) {
        zzckx zzckx = this.zzm;
        if (zzckx == null) {
            return;
        }
        if (this.zzg.zzl) {
            zzckx.zzl("onLoadException", iOException);
        } else {
            zzckx.zzk("onLoadError", iOException);
        }
    }

    public final void zzh(zzlc zzlc, int i11) {
        zzckx zzckx = this.zzm;
        if (zzckx != null) {
            zzckx.zzm(i11);
        }
    }

    public final void zzi(zzlc zzlc, zzbl zzbl) {
        zzckx zzckx = this.zzm;
        if (zzckx != null) {
            zzckx.zzk("onPlayerError", zzbl);
        }
    }

    public final void zzj(zzlc zzlc, Object obj, long j11) {
        zzckx zzckx = this.zzm;
        if (zzckx != null) {
            zzckx.zzv();
        }
    }

    public final void zzk(zzlc zzlc, zzab zzab, @Nullable zzfz zzfz) {
        zzclh zzclh = this.zzh.get();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() && zzclh != null && zzab != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzab.zzt));
            hashMap.put("bitRate", String.valueOf(zzab.zzi));
            int i11 = zzab.zzr;
            int i12 = zzab.zzs;
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append(i11);
            sb2.append(Param.X);
            sb2.append(i12);
            hashMap.put("resolution", sb2.toString());
            hashMap.put("videoMime", zzab.zzl);
            hashMap.put("videoSampleMime", zzab.zzm);
            hashMap.put("videoCodec", zzab.zzj);
            zzclh.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzl(zzlc zzlc, zzct zzct) {
        zzckx zzckx = this.zzm;
        if (zzckx != null) {
            zzckx.zzC(zzct.zzc, zzct.zzd);
        }
    }

    public final /* synthetic */ zzdi zzm(String str, boolean z11) {
        zzcof zzcof;
        if (true != z11) {
            zzcof = null;
        } else {
            zzcof = this;
        }
        zzclg zzclg = this.zzg;
        zzcnq zzcnq = new zzcnq(str, zzcof, zzclg.zzd, zzclg.zzf, zzclg.zzi);
        this.zzv.add(new WeakReference(zzcnq));
        return zzcnq;
    }

    public final /* synthetic */ zzdi zzn(String str, boolean z11) {
        zzcof zzcof;
        zzdn zzdn = new zzdn();
        zzdn.zzf(str);
        if (true != z11) {
            zzcof = null;
        } else {
            zzcof = this;
        }
        zzdn.zze(zzcof);
        zzdn.zzc(this.zzg.zzd);
        zzdn.zzd(this.zzg.zzf);
        zzdn.zzb(true);
        return zzdn.zza();
    }

    public final /* synthetic */ zzdi zzo(zzdh zzdh) {
        return new zzcnt(this.zzd, zzdh.zza(), this.zzq, this.zzr, this, new zzcod(this), (byte[]) null);
    }

    public final int zzp() {
        return this.zzo;
    }

    public final int zzr() {
        return this.zzj.zzr();
    }

    public final long zzt() {
        return this.zzj.zzt();
    }

    public final long zzu() {
        return (long) this.zzn;
    }

    public final long zzv() {
        if (zzU() && this.zzu.zzp()) {
            return Math.min((long) this.zzn, this.zzu.zzk());
        }
        return 0;
    }

    public final long zzw() {
        return this.zzj.zzk();
    }

    public final long zzx() {
        return this.zzj.zzu();
    }

    public final long zzy() {
        if (!zzU()) {
            return (long) this.zzn;
        }
        return 0;
    }

    public final long zzz() {
        if (zzU()) {
            return this.zzu.zzl();
        }
        synchronized (this.zzs) {
            while (!this.zzt.isEmpty()) {
                long j11 = this.zzp;
                Map<String, List<String>> zza = this.zzt.remove(0).zza();
                long j12 = 0;
                if (zza != null) {
                    Iterator<Map.Entry<String, List<String>>> it = zza.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry next = it.next();
                        if (next != null) {
                            try {
                                if (!(next.getKey() == null || !zzfpn.zzc("content-length", (CharSequence) next.getKey()) || next.getValue() == null || ((List) next.getValue()).get(0) == null)) {
                                    j12 = Long.parseLong((String) ((List) next.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzp = j11 + j12;
            }
        }
        return this.zzp;
    }
}
