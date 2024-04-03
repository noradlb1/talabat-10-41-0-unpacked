package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
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

public final class zzcmn extends zzcky implements zzawl, zzauj, zzaxv, zzaqd, zzaot {
    public static final /* synthetic */ int zzc = 0;
    private final Context zzd;
    private final zzcmd zze;
    private final zzapl zzf;
    private final zzapl zzg;
    private final zzavn zzh;
    private final zzclg zzi;
    private zzaow zzj;
    private ByteBuffer zzk;
    private boolean zzl;
    private final WeakReference<zzclh> zzm;
    private zzckx zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private final String zzr;
    private final int zzs;
    private final Object zzt = new Object();
    @GuardedBy("httpDataSourcesLock")
    private final ArrayList<zzawf> zzu;
    private volatile zzcmc zzv;
    private final Set<WeakReference<zzcma>> zzw = new HashSet();

    public zzcmn(Context context, zzclg zzclg, zzclh zzclh) {
        String str;
        this.zzd = context;
        this.zzi = zzclg;
        this.zzm = new WeakReference<>(zzclh);
        zzcmd zzcmd = new zzcmd();
        this.zze = zzcmd;
        zzatg zzatg = zzatg.zza;
        zzfpj zzfpj = zzt.zza;
        zzaxk zzaxk = new zzaxk(context, zzatg, 0, zzfpj, this, -1);
        this.zzf = zzaxk;
        zzaqs zzaqs = new zzaqs(zzatg, (zzarg) null, true, zzfpj, this);
        this.zzg = zzaqs;
        zzavj zzavj = new zzavj((zzavo) null);
        this.zzh = zzavj;
        if (zze.zzc()) {
            zze.zza("ForkedExoPlayerAdapter initialize ".concat(toString()));
        }
        zzcky.zza.incrementAndGet();
        int i11 = 0;
        zzaow zza = zzaox.zza(new zzapl[]{zzaqs, zzaxk}, zzavj, zzcmd);
        this.zzj = zza;
        zza.zze(this);
        this.zzo = 0;
        this.zzq = 0;
        this.zzp = 0;
        this.zzu = new ArrayList<>();
        this.zzv = null;
        if (zzclh == null || zzclh.zzt() == null) {
            str = "";
        } else {
            str = zzclh.zzt();
        }
        this.zzr = str;
        this.zzs = zzclh != null ? zzclh.zzh() : i11;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzn)).booleanValue()) {
            this.zzj.zzg();
        }
        if (zzclh != null && zzclh.zzg() > 0) {
            this.zzj.zzn(zzclh.zzg());
        }
        if (zzclh != null && zzclh.zzf() > 0) {
            this.zzj.zzm(zzclh.zzf());
        }
    }

    private final boolean zzY() {
        return this.zzv != null && this.zzv.zzk();
    }

    public final void finalize() throws Throwable {
        zzcky.zza.decrementAndGet();
        if (zze.zzc()) {
            zze.zza("ForkedExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final void zzA(Uri[] uriArr, String str) {
        zzB(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzB(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z11) {
        zzauo zzauo;
        if (this.zzj != null) {
            this.zzk = byteBuffer;
            this.zzl = z11;
            int length = uriArr.length;
            if (length == 1) {
                zzauo = zzR(uriArr[0], str);
            } else {
                zzauo[] zzauoArr = new zzauo[length];
                for (int i11 = 0; i11 < uriArr.length; i11++) {
                    zzauoArr[i11] = zzR(uriArr[i11], str);
                }
                zzauo = new zzaus(zzauoArr);
            }
            this.zzj.zzh(zzauo);
            zzcky.zzb.incrementAndGet();
        }
    }

    public final void zzC() {
        zzaow zzaow = this.zzj;
        if (zzaow != null) {
            zzaow.zzj(this);
            this.zzj.zzi();
            this.zzj = null;
            zzcky.zzb.decrementAndGet();
        }
    }

    public final void zzD(long j11) {
        this.zzj.zzk(j11);
    }

    public final void zzE(int i11) {
        this.zze.zzf(i11);
    }

    public final void zzF(int i11) {
        this.zze.zzg(i11);
    }

    public final void zzG(zzckx zzckx) {
        this.zzn = zzckx;
    }

    public final void zzH(int i11) {
        this.zze.zzh(i11);
    }

    public final void zzI(int i11) {
        this.zze.zzi(i11);
    }

    public final void zzJ(boolean z11) {
        this.zzj.zzo(z11);
    }

    public final void zzK(boolean z11) {
        if (this.zzj != null) {
            for (int i11 = 0; i11 < 2; i11++) {
                this.zzh.zze(i11, !z11);
            }
        }
    }

    public final void zzL(int i11) {
        for (WeakReference<zzcma> weakReference : this.zzw) {
            zzcma zzcma = (zzcma) weakReference.get();
            if (zzcma != null) {
                zzcma.zzh(i11);
            }
        }
    }

    public final void zzM(Surface surface, boolean z11) {
        if (this.zzj != null) {
            zzaov zzaov = new zzaov(this.zzf, 1, surface);
            if (z11) {
                this.zzj.zzf(zzaov);
                return;
            }
            this.zzj.zzl(zzaov);
        }
    }

    public final void zzN(float f11, boolean z11) {
        if (this.zzj != null) {
            zzaov zzaov = new zzaov(this.zzg, 2, Float.valueOf(f11));
            if (z11) {
                this.zzj.zzf(zzaov);
                return;
            }
            this.zzj.zzl(zzaov);
        }
    }

    public final void zzO() {
        this.zzj.zzp();
    }

    public final boolean zzP() {
        return this.zzj != null;
    }

    public final boolean zzQ() {
        return this.zzj.zzq();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0045, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbgq.zzc().zzb(com.google.android.gms.internal.ads.zzblj.zzbr)).booleanValue() == false) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzauo zzR(android.net.Uri r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzauk r9 = new com.google.android.gms.internal.ads.zzauk
            boolean r0 = r10.zzl
            if (r0 == 0) goto L_0x0022
            java.nio.ByteBuffer r0 = r10.zzk
            int r0 = r0.limit()
            if (r0 <= 0) goto L_0x0022
            java.nio.ByteBuffer r12 = r10.zzk
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r0 = r10.zzk
            r0.get(r12)
            com.google.android.gms.internal.ads.zzcmk r0 = new com.google.android.gms.internal.ads.zzcmk
            r0.<init>(r12)
        L_0x0020:
            r2 = r0
            goto L_0x0089
        L_0x0022:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzbw
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            if (r0 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzbr
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x004f
        L_0x0047:
            com.google.android.gms.internal.ads.zzclg r0 = r10.zzi
            boolean r0 = r0.zzj
            if (r0 != 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r1 = 0
        L_0x004f:
            com.google.android.gms.internal.ads.zzclg r0 = r10.zzi
            int r0 = r0.zzi
            if (r0 <= 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzcmi r0 = new com.google.android.gms.internal.ads.zzcmi
            r0.<init>(r10, r12, r1)
            goto L_0x0060
        L_0x005b:
            com.google.android.gms.internal.ads.zzcmj r0 = new com.google.android.gms.internal.ads.zzcmj
            r0.<init>(r10, r12, r1)
        L_0x0060:
            com.google.android.gms.internal.ads.zzclg r12 = r10.zzi
            boolean r12 = r12.zzj
            if (r12 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzcmh r12 = new com.google.android.gms.internal.ads.zzcmh
            r12.<init>(r10, r0)
            r0 = r12
        L_0x006c:
            java.nio.ByteBuffer r12 = r10.zzk
            if (r12 == 0) goto L_0x0020
            int r12 = r12.limit()
            if (r12 <= 0) goto L_0x0020
            java.nio.ByteBuffer r12 = r10.zzk
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r1 = r10.zzk
            r1.get(r12)
            com.google.android.gms.internal.ads.zzcmg r1 = new com.google.android.gms.internal.ads.zzcmg
            r1.<init>(r0, r12)
            r2 = r1
        L_0x0089:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzblj.zzm
            com.google.android.gms.internal.ads.zzblh r0 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r12 = r0.zzb(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzcme r12 = com.google.android.gms.internal.ads.zzcme.zza
            goto L_0x00a0
        L_0x009e:
            com.google.android.gms.internal.ads.zzcmf r12 = com.google.android.gms.internal.ads.zzcmf.zza
        L_0x00a0:
            r3 = r12
            com.google.android.gms.internal.ads.zzclg r12 = r10.zzi
            int r4 = r12.zzk
            com.google.android.gms.internal.ads.zzfpj r5 = com.google.android.gms.ads.internal.util.zzt.zza
            r7 = 0
            int r8 = r12.zzg
            r0 = r9
            r1 = r11
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmn.zzR(android.net.Uri, java.lang.String):com.google.android.gms.internal.ads.zzauo");
    }

    public final /* synthetic */ zzavw zzS(String str, boolean z11) {
        zzcmn zzcmn;
        if (true != z11) {
            zzcmn = null;
        } else {
            zzcmn = this;
        }
        zzclg zzclg = this.zzi;
        zzcma zzcma = new zzcma(str, zzcmn, zzclg.zzd, zzclg.zzf, zzclg.zzi);
        this.zzw.add(new WeakReference(zzcma));
        return zzcma;
    }

    public final /* synthetic */ zzavw zzT(String str, boolean z11) {
        zzcmn zzcmn;
        if (true != z11) {
            zzcmn = null;
        } else {
            zzcmn = this;
        }
        zzclg zzclg = this.zzi;
        return new zzawa(str, (zzaww<String>) null, zzcmn, zzclg.zzd, zzclg.zzf, true, (zzawe) null);
    }

    public final /* synthetic */ zzavw zzU(zzavv zzavv) {
        return new zzcmc(this.zzd, zzavv.zza(), this.zzr, this.zzs, this, new zzcml(this), (zzcml) null);
    }

    public final /* synthetic */ void zzV(boolean z11, long j11) {
        zzckx zzckx = this.zzn;
        if (zzckx != null) {
            zzckx.zzi(z11, j11);
        }
    }

    public final void zzW(zzavw zzavw, int i11) {
        this.zzo += i11;
    }

    /* renamed from: zzX */
    public final void zzk(zzavw zzavw, zzavy zzavy) {
        if (zzavw instanceof zzawf) {
            synchronized (this.zzt) {
                this.zzu.add((zzawf) zzavw);
            }
        } else if (zzavw instanceof zzcmc) {
            this.zzv = (zzcmc) zzavw;
            zzclh zzclh = this.zzm.get();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() && zzclh != null && this.zzv.zzh()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzv.zzj()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzv.zzi()));
                zzt.zza.post(new zzcmm(zzclh, hashMap));
            }
        }
    }

    public final void zza(boolean z11) {
    }

    public final void zzb(zzapk zzapk) {
    }

    public final void zzc(zzaos zzaos) {
        zzckx zzckx = this.zzn;
        if (zzckx != null) {
            zzckx.zzk("onPlayerError", zzaos);
        }
    }

    public final void zzd(boolean z11, int i11) {
        zzckx zzckx = this.zzn;
        if (zzckx != null) {
            zzckx.zzm(i11);
        }
    }

    public final void zze() {
    }

    public final void zzf(zzapr zzapr, Object obj) {
    }

    public final void zzg(zzavd zzavd, zzavp zzavp) {
    }

    public final void zzh(zzapg zzapg) {
        zzclh zzclh = this.zzm.get();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() && zzclh != null && zzapg != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzapg.zze);
            hashMap.put("audioSampleMime", zzapg.zzf);
            hashMap.put("audioCodec", zzapg.zzc);
            zzclh.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzi(IOException iOException) {
        zzckx zzckx = this.zzn;
        if (zzckx == null) {
            return;
        }
        if (this.zzi.zzl) {
            zzckx.zzl("onLoadException", iOException);
        } else {
            zzckx.zzk("onLoadError", iOException);
        }
    }

    public final /* synthetic */ void zzj(Object obj, int i11) {
        this.zzo += i11;
    }

    public final void zzl(int i11, long j11) {
        this.zzp += i11;
    }

    public final void zzm(Surface surface) {
        zzckx zzckx = this.zzn;
        if (zzckx != null) {
            zzckx.zzv();
        }
    }

    public final void zzn(zzapg zzapg) {
        zzclh zzclh = this.zzm.get();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() && zzclh != null && zzapg != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzapg.zzl));
            hashMap.put("bitRate", String.valueOf(zzapg.zzb));
            int i11 = zzapg.zzj;
            int i12 = zzapg.zzk;
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append(i11);
            sb2.append(Param.X);
            sb2.append(i12);
            hashMap.put("resolution", sb2.toString());
            hashMap.put("videoMime", zzapg.zze);
            hashMap.put("videoSampleMime", zzapg.zzf);
            hashMap.put("videoCodec", zzapg.zzc);
            zzclh.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzo(int i11, int i12, int i13, float f11) {
        zzckx zzckx = this.zzn;
        if (zzckx != null) {
            zzckx.zzC(i11, i12);
        }
    }

    public final int zzp() {
        return this.zzp;
    }

    public final int zzr() {
        return this.zzj.zza();
    }

    public final long zzt() {
        return this.zzj.zzb();
    }

    public final long zzu() {
        return (long) this.zzo;
    }

    public final long zzv() {
        if (zzY() && this.zzv.zzj()) {
            return Math.min((long) this.zzo, this.zzv.zze());
        }
        return 0;
    }

    public final long zzw() {
        return this.zzj.zzc();
    }

    public final long zzx() {
        return this.zzj.zzd();
    }

    public final long zzy() {
        if (!zzY()) {
            return (long) this.zzo;
        }
        return 0;
    }

    public final long zzz() {
        if (zzY()) {
            return this.zzv.zzf();
        }
        synchronized (this.zzt) {
            while (!this.zzu.isEmpty()) {
                long j11 = this.zzq;
                Map<String, List<String>> zze2 = this.zzu.remove(0).zze();
                long j12 = 0;
                if (zze2 != null) {
                    Iterator<Map.Entry<String, List<String>>> it = zze2.entrySet().iterator();
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
                this.zzq = j11 + j12;
            }
        }
        return this.zzq;
    }
}
