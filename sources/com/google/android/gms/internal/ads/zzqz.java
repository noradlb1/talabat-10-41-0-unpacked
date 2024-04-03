package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class zzqz implements zzpy, zzws, zztv, zzua, zzrl {
    /* access modifiers changed from: private */
    public static final Map<String, String> zzb;
    /* access modifiers changed from: private */
    public static final zzab zzc;
    private boolean zzA;
    private int zzB;
    private boolean zzC;
    private boolean zzD;
    private int zzE;
    private long zzF;
    private long zzG;
    private long zzH;
    private boolean zzI;
    private int zzJ;
    private boolean zzK;
    private boolean zzL;
    private final zztq zzM;
    private final zztk zzN;
    private final Uri zzd;
    private final zzdi zze;
    private final zznk zzf;
    private final zzqi zzg;
    private final zzne zzh;
    private final zzqv zzi;
    /* access modifiers changed from: private */
    public final long zzj;
    private final zzud zzk = new zzud("ProgressiveMediaPeriod");
    private final zzqq zzl;
    private final zzeb zzm;
    private final Runnable zzn;
    /* access modifiers changed from: private */
    public final Runnable zzo;
    /* access modifiers changed from: private */
    public final Handler zzp;
    @Nullable
    private zzpx zzq;
    /* access modifiers changed from: private */
    @Nullable
    public zzzd zzr;
    private zzrm[] zzs;
    private zzqx[] zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private zzqy zzx;
    private zzxp zzy;
    private long zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        zzb = Collections.unmodifiableMap(hashMap);
        zzz zzz2 = new zzz();
        zzz2.zzH("icy");
        zzz2.zzS(MimeTypes.APPLICATION_ICY);
        zzc = zzz2.zzY();
    }

    public zzqz(Uri uri, zzdi zzdi, zzqq zzqq, zznk zznk, zzne zzne, zztq zztq, zzqi zzqi, zzqv zzqv, zztk zztk, @Nullable String str, int i11, byte[] bArr) {
        this.zzd = uri;
        this.zze = zzdi;
        this.zzf = zznk;
        this.zzh = zzne;
        this.zzM = zztq;
        this.zzg = zzqi;
        this.zzi = zzqv;
        this.zzN = zztk;
        this.zzj = (long) i11;
        this.zzl = zzqq;
        this.zzm = new zzeb(zzdz.zza);
        this.zzn = new zzqs(this);
        this.zzo = new zzqr(this);
        this.zzp = zzfn.zzz((Handler.Callback) null);
        this.zzt = new zzqx[0];
        this.zzs = new zzrm[0];
        this.zzH = C.TIME_UNSET;
        this.zzF = -1;
        this.zzz = C.TIME_UNSET;
        this.zzB = 1;
    }

    private final int zzN() {
        int i11 = 0;
        for (zzrm zzc2 : this.zzs) {
            i11 += zzc2.zzc();
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public final long zzO() {
        long j11 = Long.MIN_VALUE;
        for (zzrm zzg2 : this.zzs) {
            j11 = Math.max(j11, zzg2.zzg());
        }
        return j11;
    }

    private final zzxt zzP(zzqx zzqx) {
        int length = this.zzs.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (zzqx.equals(this.zzt[i11])) {
                return this.zzs[i11];
            }
        }
        zztk zztk = this.zzN;
        Looper looper = this.zzp.getLooper();
        zznk zznk = this.zzf;
        zzne zzne = this.zzh;
        looper.getClass();
        zznk.getClass();
        zzrm zzrm = new zzrm(zztk, looper, zznk, zzne, (byte[]) null);
        zzrm.zzu(this);
        int i12 = length + 1;
        zzqx[] zzqxArr = (zzqx[]) Arrays.copyOf(this.zzt, i12);
        zzqxArr[length] = zzqx;
        this.zzt = (zzqx[]) zzfn.zzY(zzqxArr);
        zzrm[] zzrmArr = (zzrm[]) Arrays.copyOf(this.zzs, i12);
        zzrmArr[length] = zzrm;
        this.zzs = (zzrm[]) zzfn.zzY(zzrmArr);
        return zzrm;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzQ() {
        zzdy.zzf(this.zzv);
        this.zzx.getClass();
        this.zzy.getClass();
    }

    private final void zzR(zzqu zzqu) {
        if (this.zzF == -1) {
            this.zzF = zzqu.zzm;
        }
    }

    /* access modifiers changed from: private */
    public final void zzS() {
        boolean z11;
        zzdd zzdd;
        if (!this.zzL && !this.zzv && this.zzu && this.zzy != null) {
            zzrm[] zzrmArr = this.zzs;
            int length = zzrmArr.length;
            int i11 = 0;
            while (i11 < length) {
                if (zzrmArr[i11].zzh() != null) {
                    i11++;
                } else {
                    return;
                }
            }
            this.zzm.zzc();
            int length2 = this.zzs.length;
            zzcf[] zzcfArr = new zzcf[length2];
            boolean[] zArr = new boolean[length2];
            for (int i12 = 0; i12 < length2; i12++) {
                zzab zzh2 = this.zzs[i12].zzh();
                zzh2.getClass();
                String str = zzh2.zzm;
                boolean zzg2 = zzbi.zzg(str);
                if (zzg2 || zzbi.zzh(str)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zArr[i12] = z11;
                this.zzw = z11 | this.zzw;
                zzzd zzzd = this.zzr;
                if (zzzd != null) {
                    if (zzg2 || this.zzt[i12].zzb) {
                        zzdd zzdd2 = zzh2.zzk;
                        if (zzdd2 == null) {
                            zzdd = new zzdd(zzzd);
                        } else {
                            zzdd = zzdd2.zzc(zzzd);
                        }
                        zzz zzb2 = zzh2.zzb();
                        zzb2.zzM(zzdd);
                        zzh2 = zzb2.zzY();
                    }
                    if (zzg2 && zzh2.zzg == -1 && zzh2.zzh == -1 && zzzd.zza != -1) {
                        zzz zzb3 = zzh2.zzb();
                        zzb3.zzv(zzzd.zza);
                        zzh2 = zzb3.zzY();
                    }
                }
                zzcfArr[i12] = new zzcf(zzh2.zzc(this.zzf.zza(zzh2)));
            }
            this.zzx = new zzqy(new zzch(zzcfArr), zArr);
            this.zzv = true;
            zzpx zzpx = this.zzq;
            zzpx.getClass();
            zzpx.zzi(this);
        }
    }

    private final void zzT(int i11) {
        zzQ();
        zzqy zzqy = this.zzx;
        boolean[] zArr = zzqy.zzd;
        if (!zArr[i11]) {
            zzab zzb2 = zzqy.zza.zzb(i11).zzb(0);
            this.zzg.zzd(zzbi.zza(zzb2.zzm), zzb2, 0, (Object) null, this.zzG);
            zArr[i11] = true;
        }
    }

    private final void zzU(int i11) {
        zzQ();
        boolean[] zArr = this.zzx.zzb;
        if (this.zzI && zArr[i11] && !this.zzs[i11].zzx(false)) {
            this.zzH = 0;
            this.zzI = false;
            this.zzD = true;
            this.zzG = 0;
            this.zzJ = 0;
            for (zzrm zzp2 : this.zzs) {
                zzp2.zzp(false);
            }
            zzpx zzpx = this.zzq;
            zzpx.getClass();
            zzpx.zzg(this);
        }
    }

    private final void zzV() {
        zzqu zzqu = new zzqu(this, this.zzd, this.zze, this.zzl, this, this.zzm);
        if (this.zzv) {
            zzdy.zzf(zzW());
            long j11 = this.zzz;
            if (j11 == C.TIME_UNSET || this.zzH <= j11) {
                zzxp zzxp = this.zzy;
                zzxp.getClass();
                zzqu.zzg(zzqu, zzxp.zzg(this.zzH).zza.zzc, this.zzH);
                for (zzrm zzt2 : this.zzs) {
                    zzt2.zzt(this.zzH);
                }
                this.zzH = C.TIME_UNSET;
            } else {
                this.zzK = true;
                this.zzH = C.TIME_UNSET;
                return;
            }
        }
        this.zzJ = zzN();
        long zza = this.zzk.zza(zzqu, this, zztq.zza(this.zzB));
        zzdm zze2 = zzqu.zzl;
        this.zzg.zzl(new zzpr(zzqu.zzb, zze2, zze2.zza, Collections.emptyMap(), zza, 0, 0), 1, -1, (zzab) null, 0, (Object) null, zzqu.zzk, this.zzz);
    }

    private final boolean zzW() {
        return this.zzH != C.TIME_UNSET;
    }

    private final boolean zzX() {
        return this.zzD || zzW();
    }

    public final void zzB() {
        this.zzu = true;
        this.zzp.post(this.zzn);
    }

    public final /* synthetic */ void zzC() {
        if (!this.zzL) {
            zzpx zzpx = this.zzq;
            zzpx.getClass();
            zzpx.zzg(this);
        }
    }

    public final /* synthetic */ void zzD(zzxp zzxp) {
        zzxp zzxp2;
        if (this.zzr == null) {
            zzxp2 = zzxp;
        } else {
            zzxp2 = new zzxo(C.TIME_UNSET, 0);
        }
        this.zzy = zzxp2;
        this.zzz = zzxp.zze();
        boolean z11 = false;
        int i11 = 1;
        if (this.zzF == -1 && zzxp.zze() == C.TIME_UNSET) {
            z11 = true;
        }
        this.zzA = z11;
        if (true == z11) {
            i11 = 7;
        }
        this.zzB = i11;
        this.zzi.zza(this.zzz, zzxp.zzh(), this.zzA);
        if (!this.zzv) {
            zzS();
        }
    }

    public final void zzE() throws IOException {
        this.zzk.zzi(zztq.zza(this.zzB));
    }

    public final void zzF(int i11) throws IOException {
        this.zzs[i11].zzm();
        zzE();
    }

    public final /* bridge */ /* synthetic */ void zzG(zztz zztz, long j11, long j12, boolean z11) {
        zzqu zzqu = (zzqu) zztz;
        zzul zzf2 = zzqu.zzd;
        zzpr zzpr = new zzpr(zzqu.zzb, zzqu.zzl, zzf2.zzd(), zzf2.zze(), j11, j12, zzf2.zzc());
        long unused = zzqu.zzb;
        this.zzg.zzf(zzpr, 1, -1, (zzab) null, 0, (Object) null, zzqu.zzk, this.zzz);
        if (!z11) {
            zzR(zzqu);
            for (zzrm zzp2 : this.zzs) {
                zzp2.zzp(false);
            }
            if (this.zzE > 0) {
                zzpx zzpx = this.zzq;
                zzpx.getClass();
                zzpx.zzg(this);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzH(zztz zztz, long j11, long j12) {
        zzxp zzxp;
        long j13;
        if (this.zzz == C.TIME_UNSET && (zzxp = this.zzy) != null) {
            boolean zzh2 = zzxp.zzh();
            long zzO = zzO();
            if (zzO == Long.MIN_VALUE) {
                j13 = 0;
            } else {
                j13 = zzO + 10000;
            }
            this.zzz = j13;
            this.zzi.zza(j13, zzh2, this.zzA);
        }
        zzqu zzqu = (zzqu) zztz;
        zzul zzf2 = zzqu.zzd;
        zzpr zzpr = new zzpr(zzqu.zzb, zzqu.zzl, zzf2.zzd(), zzf2.zze(), j11, j12, zzf2.zzc());
        long unused = zzqu.zzb;
        this.zzg.zzh(zzpr, 1, -1, (zzab) null, 0, (Object) null, zzqu.zzk, this.zzz);
        zzR(zzqu);
        this.zzK = true;
        zzpx zzpx = this.zzq;
        zzpx.getClass();
        zzpx.zzg(this);
    }

    public final void zzI() {
        for (zzrm zzo2 : this.zzs) {
            zzo2.zzo();
        }
        this.zzl.zze();
    }

    public final void zzJ(zzab zzab) {
        this.zzp.post(this.zzn);
    }

    public final void zzK() {
        if (this.zzv) {
            for (zzrm zzn2 : this.zzs) {
                zzn2.zzn();
            }
        }
        this.zzk.zzj(this);
        this.zzp.removeCallbacksAndMessages((Object) null);
        this.zzq = null;
        this.zzL = true;
    }

    public final void zzL(zzxp zzxp) {
        this.zzp.post(new zzqt(this, zzxp));
    }

    public final boolean zzM(int i11) {
        return !zzX() && this.zzs[i11].zzx(this.zzK);
    }

    public final long zza(long j11, zzio zzio) {
        boolean z11;
        long j12 = j11;
        zzio zzio2 = zzio;
        zzQ();
        if (!this.zzy.zzh()) {
            return 0;
        }
        zzxn zzg2 = this.zzy.zzg(j12);
        long j13 = zzg2.zza.zzb;
        long j14 = zzg2.zzb.zzb;
        long j15 = zzio2.zzf;
        if (j15 == 0 && zzio2.zzg == 0) {
            return j12;
        }
        long j16 = j11;
        long zzu2 = zzfn.zzu(j16, j15, Long.MIN_VALUE);
        long zzn2 = zzfn.zzn(j16, zzio2.zzg, Long.MAX_VALUE);
        boolean z12 = true;
        if (zzu2 > j13 || j13 > zzn2) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (zzu2 > j14 || j14 > zzn2) {
            z12 = false;
        }
        if (!z11 || !z12) {
            if (!z11) {
                if (z12) {
                    return j14;
                }
                return zzu2;
            }
        } else if (Math.abs(j13 - j12) > Math.abs(j14 - j12)) {
            return j14;
        }
        return j13;
    }

    public final long zzb() {
        long j11;
        zzQ();
        boolean[] zArr = this.zzx.zzb;
        if (this.zzK) {
            return Long.MIN_VALUE;
        }
        if (zzW()) {
            return this.zzH;
        }
        if (this.zzw) {
            int length = this.zzs.length;
            j11 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < length; i11++) {
                if (zArr[i11] && !this.zzs[i11].zzw()) {
                    j11 = Math.min(j11, this.zzs[i11].zzg());
                }
            }
        } else {
            j11 = Long.MAX_VALUE;
        }
        if (j11 == Long.MAX_VALUE) {
            j11 = zzO();
        }
        if (j11 == Long.MIN_VALUE) {
            return this.zzG;
        }
        return j11;
    }

    public final long zzc() {
        if (this.zzE == 0) {
            return Long.MIN_VALUE;
        }
        return zzb();
    }

    public final long zzd() {
        if (!this.zzD) {
            return C.TIME_UNSET;
        }
        if (!this.zzK && zzN() <= this.zzJ) {
            return C.TIME_UNSET;
        }
        this.zzD = false;
        return this.zzG;
    }

    public final long zze(long j11) {
        zzQ();
        boolean[] zArr = this.zzx.zzb;
        if (true != this.zzy.zzh()) {
            j11 = 0;
        }
        this.zzD = false;
        this.zzG = j11;
        if (zzW()) {
            this.zzH = j11;
            return j11;
        }
        if (this.zzB != 7) {
            int length = this.zzs.length;
            int i11 = 0;
            while (i11 < length) {
                if (this.zzs[i11].zzy(j11, false) || (!zArr[i11] && this.zzw)) {
                    i11++;
                }
            }
            return j11;
        }
        this.zzI = false;
        this.zzH = j11;
        this.zzK = false;
        if (this.zzk.zzl()) {
            for (zzrm zzj2 : this.zzs) {
                zzj2.zzj();
            }
            this.zzk.zzg();
        } else {
            this.zzk.zzh();
            for (zzrm zzp2 : this.zzs) {
                zzp2.zzp(false);
            }
        }
        return j11;
    }

    public final zzch zzf() {
        zzQ();
        return this.zzx.zza;
    }

    public final int zzg(int i11, zzhr zzhr, zzda zzda, int i12) {
        if (zzX()) {
            return -3;
        }
        zzT(i11);
        int zzd2 = this.zzs[i11].zzd(zzhr, zzda, i12, this.zzK);
        if (zzd2 == -3) {
            zzU(i11);
        }
        return zzd2;
    }

    public final void zzh(long j11, boolean z11) {
        zzQ();
        if (!zzW()) {
            boolean[] zArr = this.zzx.zzc;
            int length = this.zzs.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.zzs[i11].zzi(j11, false, zArr[i11]);
            }
        }
    }

    public final int zzi(int i11, long j11) {
        if (zzX()) {
            return 0;
        }
        zzT(i11);
        zzrm zzrm = this.zzs[i11];
        int zzb2 = zzrm.zzb(j11, this.zzK);
        zzrm.zzv(zzb2);
        if (zzb2 != 0) {
            return zzb2;
        }
        zzU(i11);
        return 0;
    }

    public final void zzj() throws IOException {
        zzE();
        if (this.zzK && !this.zzv) {
            throw zzbj.zza("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public final void zzk(zzpx zzpx, long j11) {
        this.zzq = zzpx;
        this.zzm.zze();
        zzV();
    }

    public final void zzl(long j11) {
    }

    public final boolean zzn(long j11) {
        if (this.zzK || this.zzk.zzk() || this.zzI) {
            return false;
        }
        if (this.zzv && this.zzE == 0) {
            return false;
        }
        boolean zze2 = this.zzm.zze();
        if (this.zzk.zzl()) {
            return zze2;
        }
        zzV();
        return true;
    }

    public final boolean zzo() {
        return this.zzk.zzl() && this.zzm.zzd();
    }

    public final long zzq(zzsb[] zzsbArr, boolean[] zArr, zzrn[] zzrnArr, boolean[] zArr2, long j11) {
        boolean z11;
        zzsb zzsb;
        boolean z12;
        boolean z13;
        zzQ();
        zzqy zzqy = this.zzx;
        zzch zzch = zzqy.zza;
        boolean[] zArr3 = zzqy.zzc;
        int i11 = this.zzE;
        int i12 = 0;
        for (int i13 = 0; i13 < zzsbArr.length; i13++) {
            zzqw zzqw = zzrnArr[i13];
            if (zzqw != null && (zzsbArr[i13] == null || !zArr[i13])) {
                int zzc2 = zzqw.zzb;
                zzdy.zzf(zArr3[zzc2]);
                this.zzE--;
                zArr3[zzc2] = false;
                zzrnArr[i13] = null;
            }
        }
        if (!this.zzC ? j11 == 0 : i11 != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        for (int i14 = 0; i14 < zzsbArr.length; i14++) {
            if (zzrnArr[i14] == null && (zzsb = zzsbArr[i14]) != null) {
                if (zzsb.zzc() == 1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zzdy.zzf(z12);
                if (zzsb.zzb(0) == 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                zzdy.zzf(z13);
                int zza = zzch.zza(zzsb.zze());
                zzdy.zzf(!zArr3[zza]);
                this.zzE++;
                zArr3[zza] = true;
                zzrnArr[i14] = new zzqw(this, zza);
                zArr2[i14] = true;
                if (!z11) {
                    zzrm zzrm = this.zzs[zza];
                    if (zzrm.zzy(j11, true) || zzrm.zza() == 0) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                }
            }
        }
        if (this.zzE == 0) {
            this.zzI = false;
            this.zzD = false;
            if (this.zzk.zzl()) {
                zzrm[] zzrmArr = this.zzs;
                int length = zzrmArr.length;
                while (i12 < length) {
                    zzrmArr[i12].zzj();
                    i12++;
                }
                this.zzk.zzg();
            } else {
                for (zzrm zzp2 : this.zzs) {
                    zzp2.zzp(false);
                }
            }
        } else if (z11) {
            j11 = zze(j11);
            while (i12 < zzrnArr.length) {
                if (zzrnArr[i12] != null) {
                    zArr2[i12] = true;
                }
                i12++;
            }
        }
        this.zzC = true;
        return j11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.ads.zztx zzt(com.google.android.gms.internal.ads.zztz r27, long r28, long r30, java.io.IOException r32, int r33) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            com.google.android.gms.internal.ads.zzqu r1 = (com.google.android.gms.internal.ads.zzqu) r1
            r0.zzR(r1)
            com.google.android.gms.internal.ads.zzul r2 = r1.zzd
            com.google.android.gms.internal.ads.zzpr r15 = new com.google.android.gms.internal.ads.zzpr
            long r4 = r1.zzb
            com.google.android.gms.internal.ads.zzdm r6 = r1.zzl
            android.net.Uri r7 = r2.zzd()
            java.util.Map r8 = r2.zze()
            long r13 = r2.zzc()
            r3 = r15
            r9 = r28
            r11 = r30
            r3.<init>(r4, r6, r7, r8, r9, r11, r13)
            com.google.android.gms.internal.ads.zzpw r2 = new com.google.android.gms.internal.ads.zzpw
            r17 = 1
            r18 = -1
            r19 = 0
            r20 = 0
            r21 = 0
            long r3 = r1.zzk
            long r22 = com.google.android.gms.internal.ads.zzk.zzd(r3)
            long r3 = r0.zzz
            long r24 = com.google.android.gms.internal.ads.zzk.zzd(r3)
            r16 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r24)
            com.google.android.gms.internal.ads.zztu r3 = new com.google.android.gms.internal.ads.zztu
            r14 = r32
            r4 = r33
            r3.<init>(r15, r2, r14, r4)
            java.io.IOException r2 = r3.zzc
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzbj
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 != 0) goto L_0x008d
            boolean r4 = r2 instanceof java.io.FileNotFoundException
            if (r4 != 0) goto L_0x008d
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzdr
            if (r4 != 0) goto L_0x008d
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzuc
            if (r4 != 0) goto L_0x008d
        L_0x006a:
            if (r2 == 0) goto L_0x007f
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzdj
            if (r4 == 0) goto L_0x007a
            r4 = r2
            com.google.android.gms.internal.ads.zzdj r4 = (com.google.android.gms.internal.ads.zzdj) r4
            int r4 = r4.zza
            r7 = 2008(0x7d8, float:2.814E-42)
            if (r4 != r7) goto L_0x007a
            goto L_0x008d
        L_0x007a:
            java.lang.Throwable r2 = r2.getCause()
            goto L_0x006a
        L_0x007f:
            int r2 = r3.zzd
            int r2 = r2 + -1
            int r2 = r2 * 1000
            r3 = 5000(0x1388, float:7.006E-42)
            int r2 = java.lang.Math.min(r2, r3)
            long r2 = (long) r2
            goto L_0x008e
        L_0x008d:
            r2 = r5
        L_0x008e:
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            r7 = 1
            if (r4 != 0) goto L_0x0096
            com.google.android.gms.internal.ads.zztx r2 = com.google.android.gms.internal.ads.zzud.zzd
            goto L_0x00e8
        L_0x0096:
            int r4 = r26.zzN()
            int r8 = r0.zzJ
            r9 = 0
            if (r4 <= r8) goto L_0x00a1
            r8 = r7
            goto L_0x00a2
        L_0x00a1:
            r8 = r9
        L_0x00a2:
            long r10 = r0.zzF
            r12 = -1
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 != 0) goto L_0x00e2
            com.google.android.gms.internal.ads.zzxp r10 = r0.zzy
            if (r10 == 0) goto L_0x00b7
            long r10 = r10.zze()
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x00b7
            goto L_0x00e2
        L_0x00b7:
            boolean r4 = r0.zzv
            if (r4 == 0) goto L_0x00c6
            boolean r4 = r26.zzX()
            if (r4 != 0) goto L_0x00c6
            r0.zzI = r7
            com.google.android.gms.internal.ads.zztx r2 = com.google.android.gms.internal.ads.zzud.zzc
            goto L_0x00e8
        L_0x00c6:
            boolean r4 = r0.zzv
            r0.zzD = r4
            r4 = 0
            r0.zzG = r4
            r0.zzJ = r9
            com.google.android.gms.internal.ads.zzrm[] r6 = r0.zzs
            int r10 = r6.length
            r11 = r9
        L_0x00d4:
            if (r11 >= r10) goto L_0x00de
            r12 = r6[r11]
            r12.zzp(r9)
            int r11 = r11 + 1
            goto L_0x00d4
        L_0x00de:
            com.google.android.gms.internal.ads.zzqu.zzg(r1, r4, r4)
            goto L_0x00e4
        L_0x00e2:
            r0.zzJ = r4
        L_0x00e4:
            com.google.android.gms.internal.ads.zztx r2 = com.google.android.gms.internal.ads.zzud.zzb(r8, r2)
        L_0x00e8:
            boolean r3 = r2.zzc()
            r16 = r3 ^ 1
            com.google.android.gms.internal.ads.zzqi r3 = r0.zzg
            r5 = 1
            r6 = -1
            r7 = 0
            r8 = 0
            r9 = 0
            long r10 = r1.zzk
            long r12 = r0.zzz
            r4 = r15
            r14 = r32
            r15 = r16
            r3.zzj(r4, r5, r6, r7, r8, r9, r10, r12, r14, r15)
            if (r16 == 0) goto L_0x0108
            long unused = r1.zzb
        L_0x0108:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqz.zzt(com.google.android.gms.internal.ads.zztz, long, long, java.io.IOException, int):com.google.android.gms.internal.ads.zztx");
    }

    public final zzxt zzu() {
        return zzP(new zzqx(0, true));
    }

    public final zzxt zzv(int i11, int i12) {
        return zzP(new zzqx(i11, false));
    }
}
