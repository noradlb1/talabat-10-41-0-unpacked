package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzhf extends zzi {
    private int zzA;
    private long zzB;
    private final zzgx zzC;
    private zzrq zzD;
    final zzsw zzb;
    final zzbr zzc;
    private final zzil[] zzd;
    private final zzsv zze;
    private final zzei zzf;
    private final zzhp zzg;
    private final zzeo<zzbs> zzh;
    private final CopyOnWriteArraySet<zzgh> zzi;
    private final zzca zzj;
    private final List<zzhe> zzk;
    private final boolean zzl = true;
    private final zzqk zzm;
    @Nullable
    private final zzlb zzn;
    private final Looper zzo;
    private final zzte zzp;
    private final zzdz zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private int zzu;
    private zzio zzv;
    private zzbr zzw;
    private zzbe zzx;
    private zzbe zzy;
    private zzif zzz;

    @SuppressLint({"HandlerLeak"})
    public zzhf(zzil[] zzilArr, zzsv zzsv, zzqk zzqk, zzhs zzhs, zzte zzte, @Nullable zzlb zzlb, boolean z11, zzio zzio, long j11, long j12, zzgb zzgb, long j13, boolean z12, zzdz zzdz, Looper looper, @Nullable zzbw zzbw, zzbr zzbr, byte[] bArr) {
        zzil[] zzilArr2 = zzilArr;
        zzte zzte2 = zzte;
        zzlb zzlb2 = zzlb;
        zzdz zzdz2 = zzdz;
        Looper looper2 = looper;
        zzbw zzbw2 = zzbw;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzfn.zze;
        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 30 + String.valueOf(str).length());
        sb2.append("Init ");
        sb2.append(hexString);
        sb2.append(" [ExoPlayerLib/2.15.1] [");
        sb2.append(str);
        sb2.append("]");
        Log.i("ExoPlayerImpl", sb2.toString());
        int length = zzilArr2.length;
        this.zzd = zzilArr2;
        zzsv.getClass();
        this.zze = zzsv;
        this.zzm = zzqk;
        this.zzp = zzte2;
        this.zzn = zzlb2;
        zzio zzio2 = zzio;
        this.zzv = zzio2;
        this.zzo = looper2;
        this.zzq = zzdz2;
        zzeo<zzbs> zzeo = new zzeo<>(looper2, zzdz2, new zzgw(zzbw2));
        this.zzh = zzeo;
        this.zzi = new CopyOnWriteArraySet<>();
        this.zzk = new ArrayList();
        this.zzD = new zzrq(0);
        zzsw zzsw = r16;
        zzsw zzsw2 = new zzsw(new zzin[2], new zzsb[2], zzcr.zza, (Object) null, (byte[]) null);
        this.zzb = zzsw2;
        this.zzj = new zzca();
        zzbp zzbp = new zzbp();
        zzbp.zzc(1, 2, 12, 13, 14, 15, 16, 17, 18, 19, 29);
        zzbp.zzd(28, true);
        zzbp.zzb(zzbr);
        zzbr zze2 = zzbp.zze();
        this.zzc = zze2;
        zzbp zzbp2 = new zzbp();
        zzbp2.zzb(zze2);
        zzbp2.zza(3);
        zzbp2.zza(9);
        this.zzw = zzbp2.zze();
        zzbe zzbe = zzbe.zza;
        this.zzx = zzbe;
        this.zzy = zzbe;
        this.zzA = -1;
        this.zzf = zzdz2.zza(looper2, (Handler.Callback) null);
        zzgx zzgx = r5;
        zzgx zzgx2 = new zzgx(this);
        this.zzC = zzgx2;
        this.zzz = zzif.zzh(zzsw2);
        zzlb2.zzW(zzbw2, looper2);
        zzeo.zzb(zzlb2);
        zzte2.zze(new Handler(looper2), zzlb2);
        zzhp zzhp = r1;
        zzhp zzhp2 = new zzhp(zzilArr, zzsv, zzsw, zzhs, zzte, 0, false, zzlb, zzio2, zzgb, 500, false, looper, zzdz, zzgx, (byte[]) null);
        this.zzg = zzhp;
    }

    private final int zzJ() {
        if (this.zzz.zza.zzo()) {
            return this.zzA;
        }
        zzif zzif = this.zzz;
        return zzif.zza.zzn(zzif.zzb.zza, this.zzj).zzd;
    }

    private final long zzK(zzif zzif) {
        if (zzif.zza.zzo()) {
            return zzk.zzc(this.zzB);
        }
        if (zzif.zzb.zzb()) {
            return zzif.zzs;
        }
        zzcd zzcd = zzif.zza;
        zzpz zzpz = zzif.zzb;
        long j11 = zzif.zzs;
        zzM(zzcd, zzpz, j11);
        return j11;
    }

    private static long zzL(zzif zzif) {
        zzcc zzcc = new zzcc();
        zzca zzca = new zzca();
        zzif.zza.zzn(zzif.zzb.zza, zzca);
        long j11 = zzif.zzc;
        if (j11 != C.TIME_UNSET) {
            return j11;
        }
        long j12 = zzif.zza.zze(zzca.zzd, zzcc, 0).zzm;
        return 0;
    }

    private final long zzM(zzcd zzcd, zzpz zzpz, long j11) {
        zzcd.zzn(zzpz.zza, this.zzj);
        return j11;
    }

    @Nullable
    private final Pair<Object, Long> zzN(zzcd zzcd, int i11, long j11) {
        if (zzcd.zzo()) {
            this.zzA = i11;
            if (j11 == C.TIME_UNSET) {
                j11 = 0;
            }
            this.zzB = j11;
            return null;
        }
        if (i11 == -1 || i11 >= zzcd.zzc()) {
            i11 = zzcd.zzg(false);
            long j12 = zzcd.zze(i11, this.zza, 0).zzm;
            j11 = zzk.zzd(0);
        }
        return zzcd.zzl(this.zza, this.zzj, i11, zzk.zzc(j11));
    }

    private final zzif zzO(zzif zzif, zzcd zzcd, @Nullable Pair<Object, Long> pair) {
        boolean z11;
        zzpz zzpz;
        zzch zzch;
        zzsw zzsw;
        zzpz zzpz2;
        List list;
        int i11;
        zzif zzif2;
        long j11;
        zzcd zzcd2 = zzcd;
        Pair<Object, Long> pair2 = pair;
        if (zzcd.zzo() || pair2 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        zzcd zzcd3 = zzif.zza;
        zzif zzg2 = zzif.zzg(zzcd);
        if (zzcd.zzo()) {
            zzpz zzi2 = zzif.zzi();
            long zzc2 = zzk.zzc(this.zzB);
            zzif zza = zzg2.zzb(zzi2, zzc2, zzc2, zzc2, 0, zzch.zza, this.zzb, zzfss.zzo()).zza(zzi2);
            zza.zzq = zza.zzs;
            return zza;
        }
        Object obj = zzg2.zzb.zza;
        int i12 = zzfn.zza;
        boolean z12 = !obj.equals(pair2.first);
        if (z12) {
            zzpz = new zzpz(pair2.first);
        } else {
            zzpz = zzg2.zzb;
        }
        zzpz zzpz3 = zzpz;
        long longValue = ((Long) pair2.second).longValue();
        long zzc3 = zzk.zzc(zzj());
        if (!zzcd3.zzo()) {
            zzcd3.zzn(obj, this.zzj);
        }
        if (z12 || longValue < zzc3) {
            zzpz zzpz4 = zzpz3;
            zzdy.zzf(!zzpz4.zzb());
            if (z12) {
                zzch = zzch.zza;
            } else {
                zzch = zzg2.zzh;
            }
            zzch zzch2 = zzch;
            if (z12) {
                zzpz2 = zzpz4;
                zzsw = this.zzb;
            } else {
                zzpz2 = zzpz4;
                zzsw = zzg2.zzi;
            }
            zzsw zzsw2 = zzsw;
            if (z12) {
                list = zzfss.zzo();
            } else {
                list = zzg2.zzj;
            }
            zzif zza2 = zzg2.zzb(zzpz2, longValue, longValue, longValue, 0, zzch2, zzsw2, list).zza(zzpz2);
            zza2.zzq = longValue;
            return zza2;
        }
        if (i11 == 0) {
            int zza3 = zzcd2.zza(zzg2.zzk.zza);
            if (zza3 != -1 && zzcd2.zzd(zza3, this.zzj, false).zzd == zzcd2.zzn(zzpz3.zza, this.zzj).zzd) {
                return zzg2;
            }
            zzcd2.zzn(zzpz3.zza, this.zzj);
            if (zzpz3.zzb()) {
                j11 = this.zzj.zzf(zzpz3.zzb, zzpz3.zzc);
            } else {
                j11 = this.zzj.zze;
            }
            zzif2 = zzg2.zzb(zzpz3, zzg2.zzs, zzg2.zzs, zzg2.zzd, j11 - zzg2.zzs, zzg2.zzh, zzg2.zzi, zzg2.zzj).zza(zzpz3);
            zzif2.zzq = j11;
        } else {
            zzpz zzpz5 = zzpz3;
            zzdy.zzf(!zzpz5.zzb());
            long max = Math.max(0, zzg2.zzr - (longValue - zzc3));
            long j12 = zzg2.zzq;
            if (zzg2.zzk.equals(zzg2.zzb)) {
                j12 = longValue + max;
            }
            zzif2 = zzg2.zzb(zzpz5, longValue, longValue, longValue, max, zzg2.zzh, zzg2.zzi, zzg2.zzj);
            zzif2.zzq = j12;
        }
        return zzif2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0428, code lost:
        if (r4.zze(zzg(), r0.zza, 0).zzi != false) goto L_0x042a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x044f  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0461  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x04a8  */
    /* JADX WARNING: Removed duplicated region for block: B:195:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0269  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzP(com.google.android.gms.internal.ads.zzif r41, int r42, int r43, boolean r44, boolean r45, int r46, long r47, int r49) {
        /*
            r40 = this;
            r0 = r40
            r1 = r41
            r2 = r46
            com.google.android.gms.internal.ads.zzif r3 = r0.zzz
            r0.zzz = r1
            com.google.android.gms.internal.ads.zzcd r4 = r3.zza
            com.google.android.gms.internal.ads.zzcd r5 = r1.zza
            boolean r4 = r4.equals(r5)
            r5 = 1
            r4 = r4 ^ r5
            com.google.android.gms.internal.ads.zzcd r6 = r3.zza
            com.google.android.gms.internal.ads.zzcd r7 = r1.zza
            boolean r8 = r7.zzo()
            r10 = 3
            r11 = 0
            r13 = -1
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)
            r15 = 0
            if (r8 == 0) goto L_0x0036
            boolean r8 = r6.zzo()
            if (r8 == 0) goto L_0x0036
            android.util.Pair r4 = new android.util.Pair
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r4.<init>(r6, r14)
            goto L_0x00c0
        L_0x0036:
            boolean r8 = r7.zzo()
            boolean r9 = r6.zzo()
            if (r8 == r9) goto L_0x004d
            android.util.Pair r4 = new android.util.Pair
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r4.<init>(r6, r7)
            goto L_0x00c0
        L_0x004d:
            com.google.android.gms.internal.ads.zzpz r8 = r3.zzb
            java.lang.Object r8 = r8.zza
            com.google.android.gms.internal.ads.zzca r9 = r0.zzj
            com.google.android.gms.internal.ads.zzca r8 = r6.zzn(r8, r9)
            int r8 = r8.zzd
            com.google.android.gms.internal.ads.zzcc r9 = r0.zza
            com.google.android.gms.internal.ads.zzcc r6 = r6.zze(r8, r9, r11)
            java.lang.Object r6 = r6.zzc
            com.google.android.gms.internal.ads.zzpz r8 = r1.zzb
            java.lang.Object r8 = r8.zza
            com.google.android.gms.internal.ads.zzca r9 = r0.zzj
            com.google.android.gms.internal.ads.zzca r8 = r7.zzn(r8, r9)
            int r8 = r8.zzd
            com.google.android.gms.internal.ads.zzcc r9 = r0.zza
            com.google.android.gms.internal.ads.zzcc r7 = r7.zze(r8, r9, r11)
            java.lang.Object r7 = r7.zzc
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x009d
            if (r45 == 0) goto L_0x0081
            if (r2 != 0) goto L_0x0081
            r4 = r5
            goto L_0x008a
        L_0x0081:
            if (r45 == 0) goto L_0x0087
            if (r2 != r5) goto L_0x0087
            r4 = 2
            goto L_0x008a
        L_0x0087:
            if (r4 == 0) goto L_0x0097
            r4 = r10
        L_0x008a:
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.<init>(r7, r4)
            r4 = r6
            goto L_0x00c0
        L_0x0097:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x009d:
            if (r45 == 0) goto L_0x00b9
            if (r2 != 0) goto L_0x00b9
            com.google.android.gms.internal.ads.zzpz r4 = r3.zzb
            long r6 = r4.zzd
            com.google.android.gms.internal.ads.zzpz r4 = r1.zzb
            long r8 = r4.zzd
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b9
            android.util.Pair r4 = new android.util.Pair
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            java.lang.Integer r7 = java.lang.Integer.valueOf(r15)
            r4.<init>(r6, r7)
            goto L_0x00c0
        L_0x00b9:
            android.util.Pair r4 = new android.util.Pair
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r4.<init>(r6, r14)
        L_0x00c0:
            java.lang.Object r6 = r4.first
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            java.lang.Object r4 = r4.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzbe r7 = r0.zzx
            if (r6 == 0) goto L_0x0103
            com.google.android.gms.internal.ads.zzcd r7 = r1.zza
            boolean r7 = r7.zzo()
            if (r7 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzcd r7 = r1.zza
            com.google.android.gms.internal.ads.zzpz r9 = r1.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzca r14 = r0.zzj
            com.google.android.gms.internal.ads.zzca r7 = r7.zzn(r9, r14)
            int r7 = r7.zzd
            com.google.android.gms.internal.ads.zzcd r9 = r1.zza
            com.google.android.gms.internal.ads.zzcc r14 = r0.zza
            com.google.android.gms.internal.ads.zzcc r7 = r9.zze(r7, r14, r11)
            com.google.android.gms.internal.ads.zzaz r7 = r7.zzd
            goto L_0x00f6
        L_0x00f5:
            r7 = 0
        L_0x00f6:
            if (r7 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzbe r9 = r7.zzg
            goto L_0x00fd
        L_0x00fb:
            com.google.android.gms.internal.ads.zzbe r9 = com.google.android.gms.internal.ads.zzbe.zza
        L_0x00fd:
            r39 = r9
            r9 = r7
            r7 = r39
            goto L_0x0104
        L_0x0103:
            r9 = 0
        L_0x0104:
            if (r6 != 0) goto L_0x0110
            java.util.List<com.google.android.gms.internal.ads.zzdd> r14 = r3.zzj
            java.util.List<com.google.android.gms.internal.ads.zzdd> r10 = r1.zzj
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x013e
        L_0x0110:
            com.google.android.gms.internal.ads.zzbc r7 = r7.zza()
            java.util.List<com.google.android.gms.internal.ads.zzdd> r10 = r1.zzj
            r14 = r15
        L_0x0117:
            int r8 = r10.size()
            if (r14 >= r8) goto L_0x013a
            java.lang.Object r8 = r10.get(r14)
            com.google.android.gms.internal.ads.zzdd r8 = (com.google.android.gms.internal.ads.zzdd) r8
            r13 = r15
        L_0x0124:
            int r11 = r8.zza()
            if (r13 >= r11) goto L_0x0134
            com.google.android.gms.internal.ads.zzdc r11 = r8.zzb(r13)
            r11.zza(r7)
            int r13 = r13 + 1
            goto L_0x0124
        L_0x0134:
            int r14 = r14 + 1
            r11 = 0
            r13 = -1
            goto L_0x0117
        L_0x013a:
            com.google.android.gms.internal.ads.zzbe r7 = r7.zzr()
        L_0x013e:
            com.google.android.gms.internal.ads.zzbe r8 = r0.zzx
            boolean r8 = r7.equals(r8)
            r8 = r8 ^ r5
            r0.zzx = r7
            com.google.android.gms.internal.ads.zzcd r7 = r3.zza
            com.google.android.gms.internal.ads.zzcd r10 = r1.zza
            boolean r7 = r7.equals(r10)
            if (r7 != 0) goto L_0x015d
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r7 = r0.zzh
            com.google.android.gms.internal.ads.zzgr r10 = new com.google.android.gms.internal.ads.zzgr
            r11 = r42
            r10.<init>(r1, r11)
            r7.zzd(r15, r10)
        L_0x015d:
            r7 = 11
            if (r45 == 0) goto L_0x0289
            com.google.android.gms.internal.ads.zzca r10 = new com.google.android.gms.internal.ads.zzca
            r10.<init>()
            com.google.android.gms.internal.ads.zzcd r11 = r3.zza
            boolean r11 = r11.zzo()
            if (r11 != 0) goto L_0x019c
            com.google.android.gms.internal.ads.zzpz r11 = r3.zzb
            java.lang.Object r11 = r11.zza
            com.google.android.gms.internal.ads.zzcd r12 = r3.zza
            r12.zzn(r11, r10)
            int r12 = r10.zzd
            com.google.android.gms.internal.ads.zzcd r13 = r3.zza
            int r13 = r13.zza(r11)
            com.google.android.gms.internal.ads.zzcd r14 = r3.zza
            com.google.android.gms.internal.ads.zzcc r15 = r0.zza
            r16 = r6
            r5 = 0
            com.google.android.gms.internal.ads.zzcc r14 = r14.zze(r12, r15, r5)
            java.lang.Object r5 = r14.zzc
            com.google.android.gms.internal.ads.zzcc r6 = r0.zza
            com.google.android.gms.internal.ads.zzaz r6 = r6.zzd
            r18 = r5
            r20 = r6
            r21 = r11
            r19 = r12
            r22 = r13
            goto L_0x01a8
        L_0x019c:
            r16 = r6
            r19 = r49
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = -1
        L_0x01a8:
            if (r2 != 0) goto L_0x01db
            long r5 = r10.zze
            com.google.android.gms.internal.ads.zzpz r11 = r3.zzb
            boolean r11 = r11.zzb()
            if (r11 == 0) goto L_0x01c3
            com.google.android.gms.internal.ads.zzpz r5 = r3.zzb
            int r6 = r5.zzb
            int r5 = r5.zzc
            long r5 = r10.zzf(r6, r5)
            long r10 = zzL(r3)
            goto L_0x01ed
        L_0x01c3:
            com.google.android.gms.internal.ads.zzpz r10 = r3.zzb
            int r10 = r10.zze
            r11 = -1
            if (r10 == r11) goto L_0x01ec
            com.google.android.gms.internal.ads.zzif r10 = r0.zzz
            com.google.android.gms.internal.ads.zzpz r10 = r10.zzb
            boolean r10 = r10.zzb()
            if (r10 == 0) goto L_0x01ec
            com.google.android.gms.internal.ads.zzif r5 = r0.zzz
            long r5 = zzL(r5)
            goto L_0x01ec
        L_0x01db:
            com.google.android.gms.internal.ads.zzpz r5 = r3.zzb
            boolean r5 = r5.zzb()
            if (r5 == 0) goto L_0x01ea
            long r5 = r3.zzs
            long r10 = zzL(r3)
            goto L_0x01ed
        L_0x01ea:
            long r5 = r3.zzs
        L_0x01ec:
            r10 = r5
        L_0x01ed:
            com.google.android.gms.internal.ads.zzbv r12 = new com.google.android.gms.internal.ads.zzbv
            long r23 = com.google.android.gms.internal.ads.zzk.zzd(r5)
            long r25 = com.google.android.gms.internal.ads.zzk.zzd(r10)
            com.google.android.gms.internal.ads.zzpz r5 = r3.zzb
            int r6 = r5.zzb
            int r5 = r5.zzc
            r17 = r12
            r27 = r6
            r28 = r5
            r17.<init>(r18, r19, r20, r21, r22, r23, r25, r27, r28)
            int r5 = r40.zzg()
            com.google.android.gms.internal.ads.zzif r6 = r0.zzz
            com.google.android.gms.internal.ads.zzcd r6 = r6.zza
            boolean r6 = r6.zzo()
            if (r6 != 0) goto L_0x0244
            com.google.android.gms.internal.ads.zzif r6 = r0.zzz
            com.google.android.gms.internal.ads.zzpz r10 = r6.zzb
            java.lang.Object r10 = r10.zza
            com.google.android.gms.internal.ads.zzcd r6 = r6.zza
            com.google.android.gms.internal.ads.zzca r11 = r0.zzj
            r6.zzn(r10, r11)
            com.google.android.gms.internal.ads.zzif r6 = r0.zzz
            com.google.android.gms.internal.ads.zzcd r6 = r6.zza
            int r6 = r6.zza(r10)
            com.google.android.gms.internal.ads.zzif r11 = r0.zzz
            com.google.android.gms.internal.ads.zzcd r11 = r11.zza
            com.google.android.gms.internal.ads.zzcc r13 = r0.zza
            r14 = 0
            com.google.android.gms.internal.ads.zzcc r11 = r11.zze(r5, r13, r14)
            java.lang.Object r11 = r11.zzc
            com.google.android.gms.internal.ads.zzcc r13 = r0.zza
            com.google.android.gms.internal.ads.zzaz r13 = r13.zzd
            r32 = r6
            r31 = r10
            r28 = r11
            r30 = r13
            goto L_0x024c
        L_0x0244:
            r28 = 0
            r30 = 0
            r31 = 0
            r32 = -1
        L_0x024c:
            long r33 = com.google.android.gms.internal.ads.zzk.zzd(r47)
            com.google.android.gms.internal.ads.zzbv r6 = new com.google.android.gms.internal.ads.zzbv
            com.google.android.gms.internal.ads.zzif r10 = r0.zzz
            com.google.android.gms.internal.ads.zzpz r10 = r10.zzb
            boolean r10 = r10.zzb()
            if (r10 == 0) goto L_0x0269
            com.google.android.gms.internal.ads.zzif r10 = r0.zzz
            long r10 = zzL(r10)
            long r10 = com.google.android.gms.internal.ads.zzk.zzd(r10)
            r35 = r10
            goto L_0x026b
        L_0x0269:
            r35 = r33
        L_0x026b:
            com.google.android.gms.internal.ads.zzif r10 = r0.zzz
            com.google.android.gms.internal.ads.zzpz r10 = r10.zzb
            int r11 = r10.zzb
            int r10 = r10.zzc
            r27 = r6
            r29 = r5
            r37 = r11
            r38 = r10
            r27.<init>(r28, r29, r30, r31, r32, r33, r35, r37, r38)
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r5 = r0.zzh
            com.google.android.gms.internal.ads.zzgt r10 = new com.google.android.gms.internal.ads.zzgt
            r10.<init>(r2, r12, r6)
            r5.zzd(r7, r10)
            goto L_0x028b
        L_0x0289:
            r16 = r6
        L_0x028b:
            if (r16 == 0) goto L_0x0298
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgz r5 = new com.google.android.gms.internal.ads.zzgz
            r5.<init>(r9, r4)
            r4 = 1
            r2.zzd(r4, r5)
        L_0x0298:
            com.google.android.gms.internal.ads.zzgg r2 = r3.zzf
            com.google.android.gms.internal.ads.zzgg r4 = r1.zzf
            r5 = 10
            if (r2 == r4) goto L_0x02b8
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzhc r4 = new com.google.android.gms.internal.ads.zzhc
            r4.<init>(r1)
            r2.zzd(r5, r4)
            com.google.android.gms.internal.ads.zzgg r2 = r1.zzf
            if (r2 == 0) goto L_0x02b8
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzhd r4 = new com.google.android.gms.internal.ads.zzhd
            r4.<init>(r1)
            r2.zzd(r5, r4)
        L_0x02b8:
            com.google.android.gms.internal.ads.zzsw r2 = r3.zzi
            com.google.android.gms.internal.ads.zzsw r4 = r1.zzi
            if (r2 == r4) goto L_0x02e4
            com.google.android.gms.internal.ads.zzsv r2 = r0.zze
            java.lang.Object r4 = r4.zzd
            r2.zzj(r4)
            com.google.android.gms.internal.ads.zzci r2 = new com.google.android.gms.internal.ads.zzci
            com.google.android.gms.internal.ads.zzsw r4 = r1.zzi
            com.google.android.gms.internal.ads.zzsb[] r4 = r4.zze
            r6 = 0
            r2.<init>(r4, r6)
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r4 = r0.zzh
            com.google.android.gms.internal.ads.zzgs r6 = new com.google.android.gms.internal.ads.zzgs
            r6.<init>(r1, r2)
            r2 = 2
            r4.zzd(r2, r6)
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r4 = r0.zzh
            com.google.android.gms.internal.ads.zzgj r6 = new com.google.android.gms.internal.ads.zzgj
            r6.<init>(r1)
            r4.zzd(r2, r6)
        L_0x02e4:
            if (r8 == 0) goto L_0x02f4
            com.google.android.gms.internal.ads.zzbe r2 = r0.zzx
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r4 = r0.zzh
            com.google.android.gms.internal.ads.zzha r6 = new com.google.android.gms.internal.ads.zzha
            r6.<init>(r2)
            r2 = 14
            r4.zzd(r2, r6)
        L_0x02f4:
            boolean r2 = r3.zzg
            boolean r4 = r1.zzg
            if (r2 == r4) goto L_0x0305
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgk r4 = new com.google.android.gms.internal.ads.zzgk
            r4.<init>(r1)
            r6 = 3
            r2.zzd(r6, r4)
        L_0x0305:
            int r2 = r3.zze
            int r4 = r1.zze
            if (r2 != r4) goto L_0x0311
            boolean r2 = r3.zzl
            boolean r4 = r1.zzl
            if (r2 == r4) goto L_0x031c
        L_0x0311:
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgl r4 = new com.google.android.gms.internal.ads.zzgl
            r4.<init>(r1)
            r6 = -1
            r2.zzd(r6, r4)
        L_0x031c:
            int r2 = r3.zze
            int r4 = r1.zze
            r6 = 4
            if (r2 == r4) goto L_0x032d
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgm r4 = new com.google.android.gms.internal.ads.zzgm
            r4.<init>(r1)
            r2.zzd(r6, r4)
        L_0x032d:
            boolean r2 = r3.zzl
            boolean r4 = r1.zzl
            r8 = 5
            if (r2 == r4) goto L_0x0340
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgq r4 = new com.google.android.gms.internal.ads.zzgq
            r9 = r43
            r4.<init>(r1, r9)
            r2.zzd(r8, r4)
        L_0x0340:
            int r2 = r3.zzm
            int r4 = r1.zzm
            r9 = 6
            if (r2 == r4) goto L_0x0351
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgn r4 = new com.google.android.gms.internal.ads.zzgn
            r4.<init>(r1)
            r2.zzd(r9, r4)
        L_0x0351:
            boolean r2 = zzQ(r3)
            boolean r4 = zzQ(r41)
            r10 = 7
            if (r2 == r4) goto L_0x0366
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgo r4 = new com.google.android.gms.internal.ads.zzgo
            r4.<init>(r1)
            r2.zzd(r10, r4)
        L_0x0366:
            com.google.android.gms.internal.ads.zzbn r2 = r3.zzn
            com.google.android.gms.internal.ads.zzbn r4 = r1.zzn
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x037c
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgp r4 = new com.google.android.gms.internal.ads.zzgp
            r4.<init>(r1)
            r11 = 12
            r2.zzd(r11, r4)
        L_0x037c:
            if (r44 == 0) goto L_0x0386
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzgv r4 = com.google.android.gms.internal.ads.zzgv.zza
            r11 = -1
            r2.zzd(r11, r4)
        L_0x0386:
            com.google.android.gms.internal.ads.zzbr r2 = r0.zzw
            com.google.android.gms.internal.ads.zzbr r4 = r0.zzc
            com.google.android.gms.internal.ads.zzbp r11 = new com.google.android.gms.internal.ads.zzbp
            r11.<init>()
            r11.zzb(r4)
            boolean r4 = r40.zzp()
            r12 = 1
            r4 = r4 ^ r12
            r12 = 3
            r11.zzd(r12, r4)
            boolean r4 = r40.zzd()
            if (r4 == 0) goto L_0x03aa
            boolean r4 = r40.zzp()
            if (r4 != 0) goto L_0x03aa
            r4 = 1
            goto L_0x03ab
        L_0x03aa:
            r4 = 0
        L_0x03ab:
            r11.zzd(r6, r4)
            boolean r4 = r40.zzb()
            if (r4 == 0) goto L_0x03bc
            boolean r4 = r40.zzp()
            if (r4 != 0) goto L_0x03bc
            r4 = 1
            goto L_0x03bd
        L_0x03bc:
            r4 = 0
        L_0x03bd:
            r11.zzd(r8, r4)
            com.google.android.gms.internal.ads.zzif r4 = r0.zzz
            com.google.android.gms.internal.ads.zzcd r4 = r4.zza
            boolean r4 = r4.zzo()
            if (r4 != 0) goto L_0x03e4
            boolean r4 = r40.zzb()
            if (r4 != 0) goto L_0x03dc
            boolean r4 = r40.zzc()
            if (r4 == 0) goto L_0x03dc
            boolean r4 = r40.zzd()
            if (r4 == 0) goto L_0x03e4
        L_0x03dc:
            boolean r4 = r40.zzp()
            if (r4 != 0) goto L_0x03e4
            r4 = 1
            goto L_0x03e5
        L_0x03e4:
            r4 = 0
        L_0x03e5:
            r11.zzd(r9, r4)
            boolean r4 = r40.zza()
            if (r4 == 0) goto L_0x03f6
            boolean r4 = r40.zzp()
            if (r4 != 0) goto L_0x03f6
            r4 = 1
            goto L_0x03f7
        L_0x03f6:
            r4 = 0
        L_0x03f7:
            r11.zzd(r10, r4)
            com.google.android.gms.internal.ads.zzif r4 = r0.zzz
            com.google.android.gms.internal.ads.zzcd r4 = r4.zza
            boolean r4 = r4.zzo()
            if (r4 != 0) goto L_0x0432
            boolean r4 = r40.zza()
            if (r4 != 0) goto L_0x042a
            boolean r4 = r40.zzc()
            if (r4 == 0) goto L_0x0432
            com.google.android.gms.internal.ads.zzif r4 = r0.zzz
            com.google.android.gms.internal.ads.zzcd r4 = r4.zza
            boolean r6 = r4.zzo()
            if (r6 != 0) goto L_0x0432
            int r6 = r40.zzg()
            com.google.android.gms.internal.ads.zzcc r8 = r0.zza
            r9 = 0
            com.google.android.gms.internal.ads.zzcc r4 = r4.zze(r6, r8, r9)
            boolean r4 = r4.zzi
            if (r4 == 0) goto L_0x0432
        L_0x042a:
            boolean r4 = r40.zzp()
            if (r4 != 0) goto L_0x0432
            r4 = 1
            goto L_0x0433
        L_0x0432:
            r4 = 0
        L_0x0433:
            r6 = 8
            r11.zzd(r6, r4)
            boolean r4 = r40.zzp()
            r6 = 1
            r4 = r4 ^ r6
            r8 = 9
            r11.zzd(r8, r4)
            boolean r4 = r40.zzd()
            if (r4 == 0) goto L_0x0451
            boolean r4 = r40.zzp()
            if (r4 != 0) goto L_0x0451
            r4 = r6
            goto L_0x0452
        L_0x0451:
            r4 = 0
        L_0x0452:
            r11.zzd(r5, r4)
            boolean r4 = r40.zzd()
            if (r4 == 0) goto L_0x0463
            boolean r4 = r40.zzp()
            if (r4 != 0) goto L_0x0463
            r5 = r6
            goto L_0x0464
        L_0x0463:
            r5 = 0
        L_0x0464:
            r11.zzd(r7, r5)
            com.google.android.gms.internal.ads.zzbr r4 = r11.zze()
            r0.zzw = r4
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x047f
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            com.google.android.gms.internal.ads.zzhb r4 = new com.google.android.gms.internal.ads.zzhb
            r4.<init>(r0)
            r5 = 13
            r2.zzd(r5, r4)
        L_0x047f:
            com.google.android.gms.internal.ads.zzeo<com.google.android.gms.internal.ads.zzbs> r2 = r0.zzh
            r2.zzc()
            boolean r2 = r3.zzo
            boolean r4 = r1.zzo
            if (r2 == r4) goto L_0x04a2
            java.util.concurrent.CopyOnWriteArraySet<com.google.android.gms.internal.ads.zzgh> r2 = r0.zzi
            java.util.Iterator r2 = r2.iterator()
        L_0x0490:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x04a2
            java.lang.Object r4 = r2.next()
            com.google.android.gms.internal.ads.zzgh r4 = (com.google.android.gms.internal.ads.zzgh) r4
            boolean r5 = r1.zzo
            r4.zzq(r5)
            goto L_0x0490
        L_0x04a2:
            boolean r2 = r3.zzp
            boolean r3 = r1.zzp
            if (r2 == r3) goto L_0x04c0
            java.util.concurrent.CopyOnWriteArraySet<com.google.android.gms.internal.ads.zzgh> r2 = r0.zzi
            java.util.Iterator r2 = r2.iterator()
        L_0x04ae:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04c0
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.ads.zzgh r3 = (com.google.android.gms.internal.ads.zzgh) r3
            boolean r4 = r1.zzp
            r3.zzr(r4)
            goto L_0x04ae
        L_0x04c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhf.zzP(com.google.android.gms.internal.ads.zzif, int, int, boolean, boolean, int, long, int):void");
    }

    private static boolean zzQ(zzif zzif) {
        return zzif.zze == 3 && zzif.zzl && zzif.zzm == 0;
    }

    public final /* synthetic */ void zzA(zzbs zzbs) {
        zzbs.zza(this.zzw);
    }

    public final void zzC() {
        int i11;
        zzif zzif = this.zzz;
        if (zzif.zze == 1) {
            zzif zze2 = zzif.zze((zzgg) null);
            if (true != zze2.zza.zzo()) {
                i11 = 2;
            } else {
                i11 = 4;
            }
            zzif zzf2 = zze2.zzf(i11);
            this.zzr++;
            this.zzg.zzk();
            zzP(zzf2, 1, 1, false, false, 5, C.TIME_UNSET, -1);
        }
    }

    public final void zzD() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzfn.zze;
        String zza = zzt.zza();
        int length = String.valueOf(hexString).length();
        StringBuilder sb2 = new StringBuilder(length + 36 + String.valueOf(str).length() + String.valueOf(zza).length());
        sb2.append("Release ");
        sb2.append(hexString);
        sb2.append(" [ExoPlayerLib/2.15.1] [");
        sb2.append(str);
        sb2.append("] [");
        sb2.append(zza);
        sb2.append("]");
        Log.i("ExoPlayerImpl", sb2.toString());
        if (!this.zzg.zzp()) {
            zzeo<zzbs> zzeo = this.zzh;
            zzeo.zzd(10, zzgu.zza);
            zzeo.zzc();
        }
        this.zzh.zze();
        this.zzf.zzd((Object) null);
        zzlb zzlb = this.zzn;
        if (zzlb != null) {
            this.zzp.zzf(zzlb);
        }
        zzif zzf2 = this.zzz.zzf(1);
        this.zzz = zzf2;
        zzif zza2 = zzf2.zza(zzf2.zzb);
        this.zzz = zza2;
        zza2.zzq = zza2.zzs;
        this.zzz.zzr = 0;
    }

    public final void zzE(List<zzqb> list, boolean z11) {
        boolean z12;
        zzJ();
        zzk();
        this.zzr++;
        if (!this.zzk.isEmpty()) {
            int size = this.zzk.size();
            for (int i11 = size - 1; i11 >= 0; i11--) {
                this.zzk.remove(i11);
            }
            this.zzD = this.zzD.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzic zzic = new zzic(list.get(i12), this.zzl);
            arrayList.add(zzic);
            this.zzk.add(i12, new zzhe(zzic.zzb, zzic.zza.zzz()));
        }
        this.zzD = this.zzD.zzg(0, arrayList.size());
        zzij zzij = new zzij(this.zzk, this.zzD, (zzrq) null);
        if (zzij.zzo() || zzij.zzc() >= 0) {
            int zzg2 = zzij.zzg(false);
            zzif zzO = zzO(this.zzz, zzij, zzN(zzij, zzg2, C.TIME_UNSET));
            int i13 = zzO.zze;
            if (!(zzg2 == -1 || i13 == 1)) {
                i13 = 4;
                if (!zzij.zzo() && zzg2 < zzij.zzc()) {
                    i13 = 2;
                }
            }
            zzif zzf2 = zzO.zzf(i13);
            this.zzg.zzq(arrayList, zzg2, zzk.zzc(C.TIME_UNSET), this.zzD);
            if (this.zzz.zzb.zza.equals(zzf2.zzb.zza) || this.zzz.zza.zzo()) {
                z12 = false;
            } else {
                z12 = true;
            }
            zzP(zzf2, 0, 1, false, z12, 4, zzK(zzf2), -1);
            return;
        }
        throw new zzac(zzij, -1, C.TIME_UNSET);
    }

    public final void zzF(boolean z11, int i11, int i12) {
        zzif zzif = this.zzz;
        if (zzif.zzl != z11 || zzif.zzm != i11) {
            this.zzr++;
            zzif zzd2 = zzif.zzd(z11, i11);
            this.zzg.zzn(z11, i11);
            zzP(zzd2, 0, i12, false, false, 5, C.TIME_UNSET, -1);
        }
    }

    public final void zzG(boolean z11, @Nullable zzgg zzgg) {
        boolean z12;
        zzif zzif = this.zzz;
        zzif zza = zzif.zza(zzif.zzb);
        zza.zzq = zza.zzs;
        zza.zzr = 0;
        zzif zzf2 = zza.zzf(1);
        if (zzgg != null) {
            zzf2 = zzf2.zze(zzgg);
        }
        zzif zzif2 = zzf2;
        this.zzr++;
        this.zzg.zzo();
        if (!zzif2.zza.zzo() || this.zzz.zza.zzo()) {
            z12 = false;
        } else {
            z12 = true;
        }
        zzP(zzif2, 0, 1, false, z12, 4, zzK(zzif2), -1);
    }

    public final boolean zzH() {
        return this.zzz.zzp;
    }

    public final boolean zzI() {
        return this.zzz.zzl;
    }

    public final int zze() {
        if (zzp()) {
            return this.zzz.zzb.zzb;
        }
        return -1;
    }

    public final int zzf() {
        if (zzp()) {
            return this.zzz.zzb.zzc;
        }
        return -1;
    }

    public final int zzg() {
        int zzJ = zzJ();
        if (zzJ == -1) {
            return 0;
        }
        return zzJ;
    }

    public final int zzh() {
        if (this.zzz.zza.zzo()) {
            return 0;
        }
        zzif zzif = this.zzz;
        return zzif.zza.zza(zzif.zzb.zza);
    }

    public final int zzi() {
        return 0;
    }

    public final long zzj() {
        if (!zzp()) {
            return zzk();
        }
        zzif zzif = this.zzz;
        zzif.zza.zzn(zzif.zzb.zza, this.zzj);
        zzif zzif2 = this.zzz;
        if (zzif2.zzc != C.TIME_UNSET) {
            return zzk.zzd(0) + zzk.zzd(this.zzz.zzc);
        }
        long j11 = zzif2.zza.zze(zzg(), this.zza, 0).zzm;
        return zzk.zzd(0);
    }

    public final long zzk() {
        return zzk.zzd(zzK(this.zzz));
    }

    public final long zzl() {
        return zzk.zzd(this.zzz.zzr);
    }

    public final zzcd zzm() {
        return this.zzz.zza;
    }

    public final void zzn(int i11, long j11) {
        int i12 = i11;
        long j12 = j11;
        zzcd zzcd = this.zzz.zza;
        if (i12 < 0 || (!zzcd.zzo() && i12 >= zzcd.zzc())) {
            throw new zzac(zzcd, i11, j12);
        }
        int i13 = 1;
        this.zzr++;
        if (!zzp()) {
            if (this.zzz.zze != 1) {
                i13 = 2;
            }
            int zzg2 = zzg();
            zzif zzO = zzO(this.zzz.zzf(i13), zzcd, zzN(zzcd, i11, j12));
            this.zzg.zzl(zzcd, i11, zzk.zzc(j11));
            zzP(zzO, 0, 1, true, true, 1, zzK(zzO), zzg2);
            return;
        }
        Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
        zzhn zzhn = new zzhn(this.zzz);
        zzhn.zza(1);
        this.zzC.zza.zzz(zzhn);
    }

    public final boolean zzo() {
        return false;
    }

    public final boolean zzp() {
        return this.zzz.zzb.zzb();
    }

    public final int zzq() {
        return this.zzz.zze;
    }

    public final int zzr() {
        int length = this.zzd.length;
        return 2;
    }

    public final long zzs() {
        if (zzp()) {
            zzif zzif = this.zzz;
            if (zzif.zzk.equals(zzif.zzb)) {
                return zzk.zzd(this.zzz.zzq);
            }
            return zzt();
        } else if (this.zzz.zza.zzo()) {
            return this.zzB;
        } else {
            zzif zzif2 = this.zzz;
            long j11 = 0;
            if (zzif2.zzk.zzd != zzif2.zzb.zzd) {
                return zzk.zzd(zzif2.zza.zze(zzg(), this.zza, 0).zzn);
            }
            long j12 = zzif2.zzq;
            if (this.zzz.zzk.zzb()) {
                zzif zzif3 = this.zzz;
                zzif3.zza.zzn(zzif3.zzk.zza, this.zzj).zzg(this.zzz.zzk.zzb);
            } else {
                j11 = j12;
            }
            zzif zzif4 = this.zzz;
            zzM(zzif4.zza, zzif4.zzk, j11);
            return zzk.zzd(j11);
        }
    }

    public final long zzt() {
        if (!zzp()) {
            zzcd zzcd = this.zzz.zza;
            if (zzcd.zzo()) {
                return C.TIME_UNSET;
            }
            return zzk.zzd(zzcd.zze(zzg(), this.zza, 0).zzn);
        }
        zzif zzif = this.zzz;
        zzpz zzpz = zzif.zzb;
        zzif.zza.zzn(zzpz.zza, this.zzj);
        return zzk.zzd(this.zzj.zzf(zzpz.zzb, zzpz.zzc));
    }

    public final Looper zzu() {
        return this.zzo;
    }

    public final zzii zzv(zzih zzih) {
        return new zzii(this.zzg, zzih, this.zzz.zza, zzg(), this.zzq, this.zzg.zzb());
    }

    public final void zzw(zzgh zzgh) {
        this.zzi.add(zzgh);
    }

    public final void zzx(zzbs zzbs) {
        this.zzh.zzb(zzbs);
    }

    public final /* synthetic */ void zzy(zzhn zzhn) {
        long j11;
        boolean z11;
        long j12;
        boolean z12;
        int i11 = this.zzr - zzhn.zzb;
        this.zzr = i11;
        boolean z13 = true;
        if (zzhn.zzc) {
            this.zzs = zzhn.zzd;
            this.zzt = true;
        }
        if (zzhn.zze) {
            this.zzu = zzhn.zzf;
        }
        if (i11 == 0) {
            zzcd zzcd = zzhn.zza.zza;
            if (!this.zzz.zza.zzo() && zzcd.zzo()) {
                this.zzA = -1;
                this.zzB = 0;
            }
            if (!zzcd.zzo()) {
                List<zzcd> zzw2 = ((zzij) zzcd).zzw();
                if (zzw2.size() == this.zzk.size()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zzdy.zzf(z12);
                for (int i12 = 0; i12 < zzw2.size(); i12++) {
                    this.zzk.get(i12).zzb = zzw2.get(i12);
                }
            }
            if (this.zzt) {
                if (zzhn.zza.zzb.equals(this.zzz.zzb) && zzhn.zza.zzd == this.zzz.zzs) {
                    z13 = false;
                }
                if (z13) {
                    if (zzcd.zzo() || zzhn.zza.zzb.zzb()) {
                        j12 = zzhn.zza.zzd;
                    } else {
                        zzif zzif = zzhn.zza;
                        zzpz zzpz = zzif.zzb;
                        j12 = zzif.zzd;
                        zzM(zzcd, zzpz, j12);
                    }
                    z11 = z13;
                    j11 = j12;
                } else {
                    j11 = -9223372036854775807L;
                    z11 = z13;
                }
            } else {
                j11 = -9223372036854775807L;
                z11 = false;
            }
            this.zzt = false;
            zzP(zzhn.zza, 1, this.zzu, false, z11, this.zzs, j11, -1);
        }
    }

    public final /* synthetic */ void zzz(zzhn zzhn) {
        this.zzf.zzg(new zzgy(this, zzhn));
    }
}
