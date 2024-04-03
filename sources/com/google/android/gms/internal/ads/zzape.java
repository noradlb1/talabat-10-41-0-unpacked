package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import java.io.IOException;

final class zzape implements Handler.Callback, zzaul, zzavq, zzaun {
    private zzapc zzA;
    private long zzB;
    private zzapa zzC;
    private zzapa zzD;
    private zzapa zzE;
    private zzapr zzF;
    private boolean zzG;
    private volatile int zzH;
    private volatile int zzI;
    private final zzcmd zzJ;
    private final zzapl[] zza;
    private final zzapm[] zzb;
    private final zzavr zzc;
    private final zzawx zzd;
    private final Handler zze;
    private final HandlerThread zzf;
    private final Handler zzg;
    private final zzaow zzh;
    private final zzapq zzi;
    private final zzapp zzj;
    private zzapb zzk;
    private zzapk zzl;
    private zzapl zzm;
    private zzawq zzn;
    private zzauo zzo;
    private zzapl[] zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private int zzv = 0;
    private int zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    public zzape(zzapl[] zzaplArr, zzavr zzavr, zzcmd zzcmd, boolean z11, int i11, Handler handler, zzapb zzapb, zzaow zzaow, byte[] bArr) {
        this.zza = zzaplArr;
        this.zzc = zzavr;
        this.zzJ = zzcmd;
        this.zzr = z11;
        this.zzg = handler;
        this.zzu = 1;
        this.zzk = zzapb;
        this.zzh = zzaow;
        this.zzb = new zzapm[2];
        for (int i12 = 0; i12 < 2; i12++) {
            zzaplArr[i12].zzw(i12);
            this.zzb[i12] = zzaplArr[i12].zzf();
        }
        this.zzd = new zzawx();
        this.zzp = new zzapl[0];
        this.zzi = new zzapq();
        this.zzj = new zzapp();
        zzavr.zzf(this);
        this.zzl = zzapk.zza;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzf = handlerThread;
        handlerThread.start();
        this.zze = new Handler(handlerThread.getLooper(), this);
    }

    private final void zzA(long j11) throws zzaos {
        long j12;
        zzapa zzapa = this.zzE;
        if (zzapa == null) {
            j12 = j11 + 60000000;
        } else {
            j12 = j11 + (zzapa.zzf - zzapa.zzh);
        }
        this.zzB = j12;
        this.zzd.zza(j12);
        for (zzapl zzu2 : this.zzp) {
            zzu2.zzu(this.zzB);
        }
    }

    private final void zzB(long j11, long j12) {
        this.zze.removeMessages(2);
        long elapsedRealtime = (j11 + j12) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.zze.sendEmptyMessage(2);
        } else {
            this.zze.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final void zzC(boolean z11) {
        if (this.zzt != z11) {
            this.zzt = z11;
            this.zzg.obtainMessage(2, z11 ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzD(zzapa zzapa) throws zzaos {
        boolean z11;
        if (this.zzE != zzapa) {
            boolean[] zArr = new boolean[2];
            int i11 = 0;
            for (int i12 = 0; i12 < 2; i12++) {
                zzapl zzapl = this.zza[i12];
                if (zzapl.zzb() != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zArr[i12] = z11;
                zzavh zza2 = zzapa.zzm.zzb.zza(i12);
                if (zza2 != null) {
                    i11++;
                }
                if (zArr[i12] && (zza2 == null || (zzapl.zzB() && zzapl.zzh() == this.zzE.zzd[i12]))) {
                    if (zzapl == this.zzm) {
                        this.zzd.zzd(this.zzn);
                        this.zzn = null;
                        this.zzm = null;
                    }
                    zzL(zzapl);
                    zzapl.zzj();
                }
            }
            this.zzE = zzapa;
            this.zzg.obtainMessage(3, zzapa.zzm).sendToTarget();
            zzu(zArr, i11);
        }
    }

    private final void zzE(int i11) {
        if (this.zzu != i11) {
            this.zzu = i11;
            this.zzg.obtainMessage(1, i11, 0).sendToTarget();
        }
    }

    private final void zzF() throws zzaos {
        this.zzs = false;
        this.zzd.zzb();
        for (zzapl zzy2 : this.zzp) {
            zzy2.zzy();
        }
    }

    private final void zzG() {
        zzz(true);
        this.zzJ.zzc();
        zzE(1);
    }

    private final void zzH() throws zzaos {
        this.zzd.zzc();
        for (zzapl zzL : this.zzp) {
            zzL(zzL);
        }
    }

    private final void zzI() throws zzaos {
        long j11;
        zzapa zzapa = this.zzE;
        if (zzapa != null) {
            long zzh2 = zzapa.zza.zzh();
            if (zzh2 != C.TIME_UNSET) {
                zzA(zzh2);
            } else {
                zzapl zzapl = this.zzm;
                if (zzapl == null || zzapl.zzE()) {
                    this.zzB = this.zzd.zzI();
                } else {
                    long zzI2 = this.zzn.zzI();
                    this.zzB = zzI2;
                    this.zzd.zza(zzI2);
                }
                zzapa zzapa2 = this.zzE;
                zzh2 = this.zzB - (zzapa2.zzf - zzapa2.zzh);
            }
            this.zzk.zzc = zzh2;
            this.zzy = SystemClock.elapsedRealtime() * 1000;
            if (this.zzp.length == 0) {
                j11 = Long.MIN_VALUE;
            } else {
                j11 = this.zzE.zza.zzg();
            }
            zzapb zzapb = this.zzk;
            if (j11 == Long.MIN_VALUE) {
                j11 = this.zzF.zzd(this.zzE.zzg, this.zzj, false).zzc;
            }
            zzapb.zzd = j11;
        }
    }

    private final boolean zzJ(int i11) {
        this.zzF.zzd(i11, this.zzj, false);
        this.zzF.zzg(0, this.zzi, false);
        if (this.zzF.zzf(i11, this.zzj, this.zzi, this.zzv) == -1) {
            return true;
        }
        return false;
    }

    private final boolean zzK(long j11) {
        if (j11 == C.TIME_UNSET || this.zzk.zzc < j11) {
            return true;
        }
        zzapa zzapa = this.zzE.zzl;
        if (zzapa != null) {
            return zzapa.zzj;
        }
        return false;
    }

    private static final void zzL(zzapl zzapl) throws zzaos {
        if (zzapl.zzb() == 2) {
            zzapl.zzz();
        }
    }

    private static final void zzM(zzapa zzapa) {
        while (zzapa != null) {
            zzapa.zzc();
            zzapa = zzapa.zzl;
        }
    }

    private final int zzo(int i11, zzapr zzapr, zzapr zzapr2) {
        int zzb2 = zzapr.zzb();
        int i12 = -1;
        for (int i13 = 0; i13 < zzb2 && i12 == -1; i13++) {
            i11 = zzapr.zzf(i11, this.zzj, this.zzi, this.zzv);
            i12 = zzapr2.zza(zzapr.zzd(i11, this.zzj, true).zzb);
        }
        return i12;
    }

    private final long zzp(int i11, long j11) throws zzaos {
        zzapa zzapa;
        zzH();
        this.zzs = false;
        zzE(2);
        zzapa zzapa2 = this.zzE;
        if (zzapa2 == null) {
            zzapa zzapa3 = this.zzC;
            if (zzapa3 != null) {
                zzapa3.zzc();
            }
            zzapa = null;
        } else {
            zzapa = null;
            while (zzapa2 != null) {
                if (zzapa2.zzg != i11 || !zzapa2.zzj) {
                    zzapa2.zzc();
                } else {
                    zzapa = zzapa2;
                }
                zzapa2 = zzapa2.zzl;
            }
        }
        zzapa zzapa4 = this.zzE;
        if (!(zzapa4 == zzapa && zzapa4 == this.zzD)) {
            for (zzapl zzj2 : this.zzp) {
                zzj2.zzj();
            }
            this.zzp = new zzapl[0];
            this.zzn = null;
            this.zzm = null;
            this.zzE = null;
        }
        if (zzapa != null) {
            zzapa.zzl = null;
            this.zzC = zzapa;
            this.zzD = zzapa;
            zzD(zzapa);
            zzapa zzapa5 = this.zzE;
            if (zzapa5.zzk) {
                j11 = zzapa5.zza.zzi(j11);
            }
            zzA(j11);
            zzw();
        } else {
            this.zzC = null;
            this.zzD = null;
            this.zzE = null;
            zzA(j11);
        }
        this.zze.sendEmptyMessage(2);
        return j11;
    }

    private final Pair<Integer, Long> zzq(int i11, long j11) {
        return zzr(this.zzF, 0, C.TIME_UNSET);
    }

    private final Pair<Integer, Long> zzr(zzapr zzapr, int i11, long j11) {
        return zzs(zzapr, 0, j11, 0);
    }

    private final Pair<Integer, Long> zzs(zzapr zzapr, int i11, long j11, long j12) {
        zzawm.zza(0, 0, zzapr.zzc());
        zzapr.zze(0, this.zzi, false, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        long j13 = zzapr.zzd(0, this.zzj, false).zzc;
        if (j13 != C.TIME_UNSET) {
            int i12 = (j11 > j13 ? 1 : (j11 == j13 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j11));
    }

    private final Pair<Integer, Long> zzt(zzapc zzapc) {
        zzapr zzapr = zzapc.zza;
        if (zzapr.zzh()) {
            zzapr = this.zzF;
        }
        try {
            Pair<Integer, Long> zzr2 = zzr(zzapr, 0, zzapc.zzc);
            zzapr zzapr2 = this.zzF;
            if (zzapr2 == zzapr) {
                return zzr2;
            }
            if (zzapr2.zza(zzapr.zzd(((Integer) zzr2.first).intValue(), this.zzj, true).zzb) != -1) {
                return Pair.create(0, (Long) zzr2.second);
            }
            if (zzo(((Integer) zzr2.first).intValue(), zzapr, this.zzF) == -1) {
                return null;
            }
            this.zzF.zzd(0, this.zzj, false);
            return zzq(0, C.TIME_UNSET);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzapi(this.zzF, 0, zzapc.zzc);
        }
    }

    private final void zzu(boolean[] zArr, int i11) throws zzaos {
        int i12;
        boolean z11;
        boolean z12;
        this.zzp = new zzapl[i11];
        int i13 = 0;
        int i14 = 0;
        while (i13 < 2) {
            zzapl zzapl = this.zza[i13];
            zzavh zza2 = this.zzE.zzm.zzb.zza(i13);
            if (zza2 != null) {
                int i15 = i14 + 1;
                this.zzp[i14] = zzapl;
                if (zzapl.zzb() == 0) {
                    zzapn zzapn = this.zzE.zzm.zzd[i13];
                    if (!this.zzr || this.zzu != 3) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (zArr[i13] || !z11) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    zza2.zzb();
                    zzapg[] zzapgArr = new zzapg[1];
                    for (int i16 = 0; i16 <= 0; i16++) {
                        zzapgArr[i16] = zza2.zzc(i16);
                    }
                    zzapa zzapa = this.zzE;
                    i12 = i13;
                    zzapl.zzk(zzapn, zzapgArr, zzapa.zzd[i13], this.zzB, z12, zzapa.zzf - zzapa.zzh);
                    zzawq zzi2 = zzapl.zzi();
                    if (zzi2 != null) {
                        if (this.zzn == null) {
                            this.zzn = zzi2;
                            this.zzm = zzapl;
                            zzi2.zzK(this.zzl);
                        } else {
                            throw zzaos.zzc(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z11) {
                        zzapl.zzy();
                    }
                } else {
                    i12 = i13;
                }
                i14 = i15;
            } else {
                i12 = i13;
            }
            i13 = i12 + 1;
        }
    }

    private final void zzv(Object obj, int i11) {
        this.zzk = new zzapb(0, 0);
        zzy(obj, i11);
        this.zzk = new zzapb(0, C.TIME_UNSET);
        zzE(4);
        zzz(false);
    }

    private final void zzw() {
        long j11;
        zzapa zzapa = this.zzC;
        if (!zzapa.zzj) {
            j11 = 0;
        } else {
            j11 = zzapa.zza.zza();
        }
        if (j11 == Long.MIN_VALUE) {
            zzC(false);
            return;
        }
        zzapa zzapa2 = this.zzC;
        long j12 = this.zzB - (zzapa2.zzf - zzapa2.zzh);
        boolean zzj2 = this.zzJ.zzj(j11 - j12);
        zzC(zzj2);
        if (zzj2) {
            this.zzC.zza.zzbr(j12);
        }
    }

    private final void zzx() throws IOException {
        zzapa zzapa = this.zzC;
        if (zzapa != null && !zzapa.zzj) {
            zzapa zzapa2 = this.zzD;
            if (zzapa2 == null || zzapa2.zzl == zzapa) {
                zzapl[] zzaplArr = this.zzp;
                int length = zzaplArr.length;
                int i11 = 0;
                while (i11 < length) {
                    if (zzaplArr[i11].zzA()) {
                        i11++;
                    } else {
                        return;
                    }
                }
                this.zzC.zza.zzs();
            }
        }
    }

    private final void zzy(Object obj, int i11) {
        this.zzg.obtainMessage(6, new zzapd(this.zzF, obj, this.zzk, i11)).sendToTarget();
    }

    private final void zzz(boolean z11) {
        this.zze.removeMessages(2);
        this.zzs = false;
        this.zzd.zzc();
        this.zzn = null;
        this.zzm = null;
        this.zzB = 60000000;
        for (zzapl zzapl : this.zzp) {
            try {
                zzL(zzapl);
                zzapl.zzj();
            } catch (zzaos | RuntimeException e11) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e11);
            }
        }
        this.zzp = new zzapl[0];
        zzapa zzapa = this.zzE;
        if (zzapa == null) {
            zzapa = this.zzC;
        }
        zzM(zzapa);
        this.zzC = null;
        this.zzD = null;
        this.zzE = null;
        zzC(false);
        if (z11) {
            zzauo zzauo = this.zzo;
            if (zzauo != null) {
                zzauo.zzd();
                this.zzo = null;
            }
            this.zzF = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0364, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0416, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0417, code lost:
        r2 = r0;
        r6 = new com.google.android.gms.internal.ads.zzapb(r3, r4);
        r8.zzk = r6;
        r8.zzg.obtainMessage(4, r1, 0, r6).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0428, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:435:0x0798, code lost:
        if (zzK(r1) != false) goto L_0x079a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:473:0x080e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:474:0x080f, code lost:
        r2 = r0;
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:475:0x0813, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x0814, code lost:
        r2 = r0;
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x087c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x087d, code lost:
        r2 = r0;
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x0880, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x0881, code lost:
        r2 = r0;
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:515:0x0890, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:516:0x0891, code lost:
        r1 = r0;
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r1);
        r8.zzg.obtainMessage(8, com.google.android.gms.internal.ads.zzaos.zzc(r1)).sendToTarget();
        zzG();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:517:0x08ac, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:518:0x08ad, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:519:0x08ae, code lost:
        r1 = true;
        r3 = 8;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:0x08ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:523:0x08cb, code lost:
        r1 = true;
        r3 = 8;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ca, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00cb, code lost:
        monitor-enter(r33);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r8.zzx++;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0268 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x026c A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0271 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x04ea A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x04f1 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0508 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x050b A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0546 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0558 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0572 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }, LOOP:8: B:318:0x0572->B:322:0x0582, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x06c7 A[Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0890 A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r34) {
        /*
            r33 = this;
            r8 = r33
            r1 = r34
            r10 = 1
            int r2 = r1.what     // Catch:{ zzaos -> 0x08ca, IOException -> 0x08ad, RuntimeException -> 0x0890 }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x0847;
                case 1: goto L_0x0818;
                case 2: goto L_0x0429;
                case 3: goto L_0x038a;
                case 4: goto L_0x036c;
                case 5: goto L_0x0368;
                case 6: goto L_0x0351;
                case 7: goto L_0x01f6;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b6;
                case 10: goto L_0x00da;
                case 11: goto L_0x009c;
                case 12: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r1 = r9
            return r1
        L_0x001a:
            int r1 = r1.arg1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzv = r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0024:
            if (r2 != 0) goto L_0x0028
            goto L_0x009b
        L_0x0028:
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != r3) goto L_0x002e
            r3 = r10
            goto L_0x002f
        L_0x002e:
            r3 = r9
        L_0x002f:
            com.google.android.gms.internal.ads.zzapa r4 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != r4) goto L_0x0035
            r4 = r10
            goto L_0x0036
        L_0x0035:
            r4 = r9
        L_0x0036:
            com.google.android.gms.internal.ads.zzapr r11 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r12 = r2.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r13 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapq r14 = r8.zzi     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r11 = r11.zzf(r12, r13, r14, r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0042:
            com.google.android.gms.internal.ads.zzapa r12 = r2.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r12 == 0) goto L_0x0068
            if (r11 == r5) goto L_0x0068
            int r13 = r12.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r13 != r11) goto L_0x0068
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r12 != r2) goto L_0x0052
            r2 = r10
            goto L_0x0053
        L_0x0052:
            r2 = r9
        L_0x0053:
            r3 = r3 | r2
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r12 != r2) goto L_0x005a
            r2 = r10
            goto L_0x005b
        L_0x005a:
            r2 = r9
        L_0x005b:
            r4 = r4 | r2
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r11 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapq r14 = r8.zzi     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r11 = r2.zzf(r13, r11, r14, r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2 = r12
            goto L_0x0042
        L_0x0068:
            if (r12 == 0) goto L_0x006f
            zzM(r12)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzl = r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x006f:
            int r5 = r2.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            boolean r5 = r8.zzJ(r5)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzi = r5     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r4 != 0) goto L_0x007b
            r8.zzC = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x007b:
            if (r3 != 0) goto L_0x0092
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x0092
            int r2 = r2.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r3 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r3 = r3.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r3 = r8.zzp(r2, r3)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r5 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r5.<init>(r2, r3)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r5     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0092:
            int r2 = r8.zzu     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != r15) goto L_0x009b
            if (r1 == 0) goto L_0x009b
            r8.zzE(r7)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x009b:
            return r10
        L_0x009c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzaov[] r1 = (com.google.android.gms.internal.ads.zzaov[]) r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r1.length     // Catch:{ all -> 0x00c9 }
        L_0x00a1:
            if (r9 >= r2) goto L_0x00b1
            r3 = r1[r9]     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzaou r4 = r3.zza     // Catch:{ all -> 0x00c9 }
            int r5 = r3.zzb     // Catch:{ all -> 0x00c9 }
            java.lang.Object r3 = r3.zzc     // Catch:{ all -> 0x00c9 }
            r4.zzl(r5, r3)     // Catch:{ all -> 0x00c9 }
            int r9 = r9 + 1
            goto L_0x00a1
        L_0x00b1:
            com.google.android.gms.internal.ads.zzauo r1 = r8.zzo     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00ba
            android.os.Handler r1 = r8.zze     // Catch:{ all -> 0x00c9 }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00c9 }
        L_0x00ba:
            monitor-enter(r33)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r1 = r8.zzx     // Catch:{ all -> 0x00c5 }
            int r1 = r1 + r10
            r8.zzx = r1     // Catch:{ all -> 0x00c5 }
            r33.notifyAll()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r33)     // Catch:{ all -> 0x00c5 }
            return r10
        L_0x00c5:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x00c5 }
            throw r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x00c9:
            r0 = move-exception
            r1 = r0
            monitor-enter(r33)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r8.zzx     // Catch:{ all -> 0x00d6 }
            int r2 = r2 + r10
            r8.zzx = r2     // Catch:{ all -> 0x00d6 }
            r33.notifyAll()     // Catch:{ all -> 0x00d6 }
            monitor-exit(r33)     // Catch:{ all -> 0x00d6 }
            throw r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x00d6:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x00d6 }
            throw r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x00da:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x01b5
            r2 = r10
        L_0x00df:
            if (r1 == 0) goto L_0x01b5
            boolean r3 = r1.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 != 0) goto L_0x00e7
            goto L_0x01b5
        L_0x00e7:
            boolean r3 = r1.zze()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 == 0) goto L_0x01a9
            if (r2 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 == r3) goto L_0x00f7
            r2 = r10
            goto L_0x00f8
        L_0x00f7:
            r2 = r9
        L_0x00f8:
            com.google.android.gms.internal.ads.zzapa r3 = r3.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            zzM(r3)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3.zzl = r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzC = r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzD = r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            boolean[] r4 = new boolean[r7]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r5 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r11 = r5.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r2 = r3.zzb(r11, r2, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r5 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r11 = r5.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zzapb r5 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r5.zzc = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzA(r2)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x011e:
            boolean[] r2 = new boolean[r7]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3 = r9
            r5 = r3
        L_0x0122:
            if (r3 >= r7) goto L_0x0169
            com.google.android.gms.internal.ads.zzapl[] r11 = r8.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r11 = r11[r3]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r12 = r11.zzb()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r12 == 0) goto L_0x0130
            r12 = r10
            goto L_0x0131
        L_0x0130:
            r12 = r9
        L_0x0131:
            r2[r3] = r12     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r13 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzauy[] r13 = r13.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r13 = r13[r3]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r13 == 0) goto L_0x013d
            int r5 = r5 + 1
        L_0x013d:
            if (r12 == 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzauy r12 = r11.zzh()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r13 == r12) goto L_0x015d
            com.google.android.gms.internal.ads.zzapl r12 = r8.zzm     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r11 != r12) goto L_0x0156
            if (r13 != 0) goto L_0x0152
            com.google.android.gms.internal.ads.zzawx r12 = r8.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzawq r13 = r8.zzn     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r12.zzd(r13)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0152:
            r8.zzn = r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzm = r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0156:
            zzL(r11)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r11.zzj()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0166
        L_0x015d:
            boolean r12 = r4[r3]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r12 == 0) goto L_0x0166
            long r12 = r8.zzB     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r11.zzu(r12)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0166:
            int r3 = r3 + 1
            goto L_0x0122
        L_0x0169:
            android.os.Handler r3 = r8.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzavs r1 = r1.zzm     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.sendToTarget()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzu(r2, r5)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x019d
        L_0x0178:
            r8.zzC = r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r1 = r1.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x017c:
            if (r1 == 0) goto L_0x0184
            r1.zzc()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r1 = r1.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x017c
        L_0x0184:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.zzl = r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            boolean r2 = r1.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x019d
            long r2 = r1.zzh     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r4 = r8.zzB     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r11 = r1.zzf     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r11 = r11 - r2
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r2, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3.zza(r1, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x019d:
            r33.zzw()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r33.zzI()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Handler r1 = r8.zze     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.sendEmptyMessage(r7)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x01b5
        L_0x01a9:
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 != r3) goto L_0x01af
            r3 = r9
            goto L_0x01b0
        L_0x01af:
            r3 = r10
        L_0x01b0:
            r2 = r2 & r3
            com.google.android.gms.internal.ads.zzapa r1 = r1.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x00df
        L_0x01b5:
            return r10
        L_0x01b6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzaum r1 = (com.google.android.gms.internal.ads.zzaum) r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x01c5
            com.google.android.gms.internal.ads.zzaum r2 = r2.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != r1) goto L_0x01c5
            r33.zzw()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x01c5:
            return r10
        L_0x01c6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzaum r1 = (com.google.android.gms.internal.ads.zzaum) r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x01f5
            com.google.android.gms.internal.ads.zzaum r3 = r2.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 == r1) goto L_0x01d3
            goto L_0x01f5
        L_0x01d3:
            r2.zzj = r10     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zze()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r3 = r2.zzh     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r3 = r2.zza(r3, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzh = r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 != 0) goto L_0x01f2
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzD = r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r1 = r1.zzh     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzA(r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzD(r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x01f2:
            r33.zzw()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x01f5:
            return r10
        L_0x01f6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r3 = r1.first     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r3 = (com.google.android.gms.internal.ads.zzapr) r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzF = r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r1 = r1.second     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x0263
            int r4 = r8.zzz     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r4 <= 0) goto L_0x0235
            com.google.android.gms.internal.ads.zzapc r3 = r8.zzA     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.util.Pair r3 = r8.zzt(r3)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r4 = r8.zzz     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzz = r9     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzA = r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 != 0) goto L_0x021d
            r8.zzv(r1, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0350
        L_0x021d:
            com.google.android.gms.internal.ads.zzapb r7 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r11 = r3.first     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r11 = r11.intValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r3 = r3.second     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r14 = r3.longValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r7.<init>(r11, r14)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r7     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0264
        L_0x0235:
            com.google.android.gms.internal.ads.zzapb r4 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r14 = r4.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r4 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x0263
            boolean r3 = r3.zzh()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 == 0) goto L_0x0248
            r8.zzv(r1, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0350
        L_0x0248:
            android.util.Pair r3 = r8.zzq(r9, r12)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r4 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r7 = r3.first     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r7 = r7.intValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r3 = r3.second     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r14 = r3.longValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r4.<init>(r7, r14)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r4     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0263:
            r4 = r9
        L_0x0264:
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 != 0) goto L_0x026a
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x026a:
            if (r3 != 0) goto L_0x0271
            r8.zzy(r1, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0350
        L_0x0271:
            com.google.android.gms.internal.ads.zzapr r7 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r11 = r3.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r7 = r7.zza(r11)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r7 != r5) goto L_0x02d4
            int r6 = r3.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r7 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r8.zzo(r6, r2, r7)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != r5) goto L_0x028a
            r8.zzv(r1, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0350
        L_0x028a:
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r6 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzd(r9, r6, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.util.Pair r2 = r8.zzq(r9, r12)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r6 = r2.first     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r6 = r6.intValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r2 = r2.second     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r11 = r2.longValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r7 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzd(r6, r7, r10)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r2 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r2 = r2.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3.zzg = r5     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x02b2:
            com.google.android.gms.internal.ads.zzapa r3 = r3.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 == 0) goto L_0x02c4
            java.lang.Object r7 = r3.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            boolean r7 = r7.equals(r2)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r10 == r7) goto L_0x02c0
            r7 = r5
            goto L_0x02c1
        L_0x02c0:
            r7 = r6
        L_0x02c1:
            r3.zzg = r7     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x02b2
        L_0x02c4:
            long r2 = r8.zzp(r6, r11)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r5 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r5.<init>(r6, r2)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r5     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzy(r1, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0350
        L_0x02d4:
            boolean r2 = r8.zzJ(r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3.zzg = r9     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3.zzi = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 != r2) goto L_0x02e2
            r2 = r10
            goto L_0x02e3
        L_0x02e2:
            r2 = r9
        L_0x02e3:
            com.google.android.gms.internal.ads.zzapb r11 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r12 = r11.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r12 == 0) goto L_0x02fa
            com.google.android.gms.internal.ads.zzapb r12 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r13 = r11.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r12.<init>(r9, r13)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r13 = r11.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r12.zzc = r13     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r13 = r11.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r12.zzd = r13     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r12     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x02fa:
            com.google.android.gms.internal.ads.zzapa r11 = r3.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r11 == 0) goto L_0x034d
            com.google.android.gms.internal.ads.zzapr r12 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r13 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapq r14 = r8.zzi     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r15 = r8.zzv     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r7 = r12.zzf(r7, r13, r14, r15)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r7 == r5) goto L_0x0330
            java.lang.Object r12 = r11.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r13 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r14 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r13 = r13.zzd(r7, r14, r10)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r13 = r13.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            boolean r12 = r12.equals(r13)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r12 == 0) goto L_0x0330
            boolean r3 = r8.zzJ(r7)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r11.zzg = r7     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r11.zzi = r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r11 != r3) goto L_0x032c
            r3 = r10
            goto L_0x032d
        L_0x032c:
            r3 = r9
        L_0x032d:
            r2 = r2 | r3
            r3 = r11
            goto L_0x02fa
        L_0x0330:
            if (r2 != 0) goto L_0x0346
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r2.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r3 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r5 = r3.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r5 = r8.zzp(r2, r5)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r3 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3.<init>(r2, r5)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x034d
        L_0x0346:
            r8.zzC = r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3.zzl = r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            zzM(r11)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x034d:
            r8.zzy(r1, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0350:
            return r10
        L_0x0351:
            r8.zzz(r10)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzcmd r1 = r8.zzJ     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.zzb()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzE(r10)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            monitor-enter(r33)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzq = r10     // Catch:{ all -> 0x0364 }
            r33.notifyAll()     // Catch:{ all -> 0x0364 }
            monitor-exit(r33)     // Catch:{ all -> 0x0364 }
            return r10
        L_0x0364:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x0364 }
            throw r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0368:
            r33.zzG()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            return r10
        L_0x036c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapk r1 = (com.google.android.gms.internal.ads.zzapk) r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzawq r2 = r8.zzn     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x0379
            com.google.android.gms.internal.ads.zzapk r1 = r2.zzK(r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x037e
        L_0x0379:
            com.google.android.gms.internal.ads.zzawx r2 = r8.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzK(r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x037e:
            r8.zzl = r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.sendToTarget()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            return r10
        L_0x038a:
            java.lang.Object r1 = r1.obj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapc r1 = (com.google.android.gms.internal.ads.zzapc) r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x039b
            int r2 = r8.zzz     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r2 + r10
            r8.zzz = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzA = r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0415
        L_0x039b:
            android.util.Pair r2 = r8.zzt(r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x03bf
            com.google.android.gms.internal.ads.zzapb r1 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.<init>(r9, r3)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Message r1 = r2.obtainMessage(r15, r10, r9, r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.sendToTarget()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r1 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.<init>(r9, r12)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzE(r15)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzz(r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0415
        L_0x03bf:
            long r3 = r1.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03c7
            r1 = r10
            goto L_0x03c8
        L_0x03c7:
            r1 = r9
        L_0x03c8:
            java.lang.Object r3 = r2.first     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r3 = r3.intValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r2 = r2.second     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r4 = r2.longValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r2 = r8.zzk     // Catch:{ all -> 0x0416 }
            int r6 = r2.zza     // Catch:{ all -> 0x0416 }
            if (r3 != r6) goto L_0x03fb
            r16 = 1000(0x3e8, double:4.94E-321)
            long r6 = r4 / r16
            long r11 = r2.zzc     // Catch:{ all -> 0x0416 }
            long r11 = r11 / r16
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x03fb
            com.google.android.gms.internal.ads.zzapb r2 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.<init>(r3, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r2)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x03f7:
            r1.sendToTarget()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0415
        L_0x03fb:
            long r6 = r8.zzp(r3, r4)     // Catch:{ all -> 0x0416 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0405
            r2 = r10
            goto L_0x0406
        L_0x0405:
            r2 = r9
        L_0x0406:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzapb r2 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.<init>(r3, r6)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r2)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x03f7
        L_0x0415:
            return r10
        L_0x0416:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzapb r6 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r6.<init>(r3, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r6     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r6)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.sendToTarget()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            throw r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0429:
            r16 = 1000(0x3e8, double:4.94E-321)
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r1 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 != 0) goto L_0x043b
            com.google.android.gms.internal.ads.zzauo r1 = r8.zzo     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.zza()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r11 = r5
            goto L_0x0677
        L_0x043b:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 != 0) goto L_0x0444
            com.google.android.gms.internal.ads.zzapb r1 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r1 = r1.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0479
        L_0x0444:
            int r2 = r1.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            boolean r7 = r1.zzi     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r7 != 0) goto L_0x0553
            boolean r1 = r1.zzd()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x0553
            com.google.android.gms.internal.ads.zzapr r1 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r7 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r1 = r1.zzd(r2, r7, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r14 = r1.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x0553
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x046d
            com.google.android.gms.internal.ads.zzapa r7 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r7 = r7.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r1 = r1.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r7 = r7 - r1
            r1 = 100
            if (r7 == r1) goto L_0x0553
        L_0x046d:
            com.google.android.gms.internal.ads.zzapr r1 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r7 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapq r14 = r8.zzi     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r15 = r8.zzv     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r1 = r1.zzf(r2, r7, r14, r15)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0479:
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r2.zzb()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 < r2) goto L_0x0488
            com.google.android.gms.internal.ads.zzauo r1 = r8.zzo     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.zza()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0553
        L_0x0488:
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x0493
            com.google.android.gms.internal.ads.zzapb r2 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r3 = r2.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0490:
            r11 = r5
            r15 = 2
            goto L_0x04e6
        L_0x0493:
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r7 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzd(r1, r7, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapq r7 = r8.zzi     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzg(r9, r7, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x04a4
            goto L_0x0490
        L_0x04a4:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r14 = r1.zzf     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r11 = r1.zzh     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r14 = r14 - r11
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r1 = r1.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r7 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r1 = r2.zzd(r1, r7, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r1 = r1.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r14 = r14 + r1
            long r1 = r8.zzB     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r14 = r14 - r1
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r7 = 0
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r13 = java.lang.Math.max(r3, r14)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1 = r33
            r3 = r7
            r6 = r5
            r4 = r11
            r11 = r6
            r15 = 2
            r6 = r13
            android.util.Pair r1 = r1.zzs(r2, r3, r4, r6)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x0554
            java.lang.Object r2 = r1.first     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r2.intValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r1 = r1.second     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r3 = r1.longValue()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1 = r2
        L_0x04e6:
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x04f1
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x04ee:
            r21 = r5
            goto L_0x0504
        L_0x04f1:
            long r5 = r2.zzf     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r13 = r2.zzh     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r5 = r5 - r13
            com.google.android.gms.internal.ads.zzapr r7 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r2.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r13 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r2 = r7.zzd(r2, r13, r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r13 = r2.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r5 = r5 + r13
            goto L_0x04ee
        L_0x0504:
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x050b
            r27 = r9
            goto L_0x0510
        L_0x050b:
            int r2 = r2.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r2 = r2 + r10
            r27 = r2
        L_0x0510:
            boolean r29 = r8.zzJ(r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapr r2 = r8.zzF     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r5 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2.zzd(r1, r5, r10)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = new com.google.android.gms.internal.ads.zzapa     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapl[] r5 = r8.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapm[] r6 = r8.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzavr r7 = r8.zzc     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzcmd r13 = r8.zzJ     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzauo r14 = r8.zzo     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r15 = r8.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            java.lang.Object r15 = r15.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r32 = 0
            r18 = r2
            r19 = r5
            r20 = r6
            r23 = r7
            r24 = r13
            r25 = r14
            r26 = r15
            r28 = r1
            r30 = r3
            r18.<init>(r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r32)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x0548
            r1.zzl = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x0548:
            r8.zzC = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzaum r1 = r2.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.zzw(r8, r3)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzC(r10)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0554
        L_0x0553:
            r11 = r5
        L_0x0554:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x056b
            boolean r1 = r1.zzd()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x055f
            goto L_0x056b
        L_0x055f:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzC     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x056e
            boolean r1 = r8.zzt     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 != 0) goto L_0x056e
            r33.zzw()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x056e
        L_0x056b:
            r8.zzC(r9)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x056e:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x0677
        L_0x0572:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == r2) goto L_0x05a9
            long r3 = r8.zzB     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r5 = r1.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r5 = r5.zzf     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x05a9
            r1.zzc()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r1 = r1.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzD(r1)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r1 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzE     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r3 = r2.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r4 = r2.zzh     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.<init>(r3, r4)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzk = r1     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r33.zzI()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            android.os.Handler r1 = r8.zzg     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r2 = r8.zzk     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3 = 5
            android.os.Message r1 = r1.obtainMessage(r3, r2)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r1.sendToTarget()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0572
        L_0x05a9:
            boolean r1 = r2.zzi     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x05cf
            r1 = r9
        L_0x05ae:
            r2 = 2
            if (r1 >= r2) goto L_0x0677
            com.google.android.gms.internal.ads.zzapl[] r2 = r8.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2 = r2[r1]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzauy[] r3 = r3.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3 = r3[r1]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 == 0) goto L_0x05cc
            com.google.android.gms.internal.ads.zzauy r4 = r2.zzh()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r4 != r3) goto L_0x05cc
            boolean r3 = r2.zzA()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 == 0) goto L_0x05cc
            r2.zzv()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
        L_0x05cc:
            int r1 = r1 + 1
            goto L_0x05ae
        L_0x05cf:
            r1 = r9
        L_0x05d0:
            r2 = 2
            if (r1 >= r2) goto L_0x05ee
            com.google.android.gms.internal.ads.zzapl[] r2 = r8.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2 = r2[r1]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzauy[] r3 = r3.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r3 = r3[r1]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzauy r4 = r2.zzh()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r4 != r3) goto L_0x0677
            if (r3 == 0) goto L_0x05eb
            boolean r2 = r2.zzA()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x0677
        L_0x05eb:
            int r1 = r1 + 1
            goto L_0x05d0
        L_0x05ee:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r1.zzl     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x0677
            boolean r3 = r2.zzj     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r3 == 0) goto L_0x0677
            com.google.android.gms.internal.ads.zzavs r1 = r1.zzm     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r8.zzD = r2     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzavs r3 = r2.zzm     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzaum r2 = r2.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r4 = r2.zzh()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r2 = r9
            r6 = 2
        L_0x0606:
            if (r2 >= r6) goto L_0x0677
            com.google.android.gms.internal.ads.zzapl[] r6 = r8.zza     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r6 = r6[r2]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzavp r7 = r1.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzavh r7 = r7.zza(r2)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r7 != 0) goto L_0x0619
        L_0x0614:
            r19 = r3
            r20 = r4
            goto L_0x066d
        L_0x0619:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x0626
            r6.zzv()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            goto L_0x0614
        L_0x0626:
            boolean r7 = r6.zzB()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r7 != 0) goto L_0x0614
            com.google.android.gms.internal.ads.zzavp r7 = r3.zzb     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzavh r7 = r7.zza(r2)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapn[] r13 = r1.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r13 = r13[r2]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapn[] r14 = r3.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r14 = r14[r2]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r7 == 0) goto L_0x0666
            boolean r13 = r14.equals(r13)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            if (r13 == 0) goto L_0x0666
            r7.zzb()     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapg[] r13 = new com.google.android.gms.internal.ads.zzapg[r10]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r14 = r9
        L_0x0648:
            if (r14 > 0) goto L_0x0653
            com.google.android.gms.internal.ads.zzapg r15 = r7.zzc(r14)     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r13[r14] = r15     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            int r14 = r14 + 1
            goto L_0x0648
        L_0x0653:
            com.google.android.gms.internal.ads.zzapa r7 = r8.zzD     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzauy[] r14 = r7.zzd     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            r14 = r14[r2]     // Catch:{ zzaos -> 0x0813, IOException -> 0x080e, RuntimeException -> 0x0890 }
            long r9 = r7.zzf     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r19 = r3
            r20 = r4
            long r3 = r7.zzh     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r9 = r9 - r3
            r6.zzt(r13, r14, r9)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x066d
        L_0x0666:
            r19 = r3
            r20 = r4
            r6.zzv()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x066d:
            int r2 = r2 + 1
            r3 = r19
            r4 = r20
            r6 = 2
            r9 = 0
            r10 = 1
            goto L_0x0606
        L_0x0677:
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzE     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r2 = 10
            if (r1 != 0) goto L_0x0686
            r33.zzx()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r8.zzB(r11, r2)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x0683:
            r1 = 1
            goto L_0x080d
        L_0x0686:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzawz.zza(r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r33.zzI()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r1 = r8.zzE     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzaum r1 = r1.zza     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r4 = r8.zzk     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r4 = r4.zzc     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r1.zzq(r4)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapl[] r1 = r8.zzp     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r4 = r1.length     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r5 = 1
            r6 = 1
            r7 = 0
        L_0x069f:
            if (r7 >= r4) goto L_0x06d6
            r9 = r1[r7]     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r13 = r8.zzB     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r2 = r8.zzy     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r9.zzD(r13, r2)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r6 == 0) goto L_0x06b4
            boolean r2 = r9.zzE()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x06b4
            r6 = 1
            goto L_0x06b5
        L_0x06b4:
            r6 = 0
        L_0x06b5:
            boolean r2 = r9.zzF()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x06c4
            boolean r2 = r9.zzE()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r2 == 0) goto L_0x06c2
            goto L_0x06c4
        L_0x06c2:
            r2 = 0
            goto L_0x06c5
        L_0x06c4:
            r2 = 1
        L_0x06c5:
            if (r2 != 0) goto L_0x06ca
            r9.zzm()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x06ca:
            if (r5 == 0) goto L_0x06d0
            if (r2 == 0) goto L_0x06d0
            r5 = 1
            goto L_0x06d1
        L_0x06d0:
            r5 = 0
        L_0x06d1:
            int r7 = r7 + 1
            r2 = 10
            goto L_0x069f
        L_0x06d6:
            if (r5 != 0) goto L_0x06db
            r33.zzx()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x06db:
            com.google.android.gms.internal.ads.zzawq r1 = r8.zzn     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x06fe
            com.google.android.gms.internal.ads.zzapk r1 = r1.zzJ()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapk r2 = r8.zzl     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            boolean r2 = r1.equals(r2)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r2 != 0) goto L_0x06fe
            r8.zzl = r1     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzawx r2 = r8.zzd     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzawq r3 = r8.zzn     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r2.zzd(r3)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r1.sendToTarget()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x06fe:
            com.google.android.gms.internal.ads.zzapr r1 = r8.zzF     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzE     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r2 = r2.zzg     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r3 = r8.zzj     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r4 = 0
            com.google.android.gms.internal.ads.zzapp r1 = r1.zzd(r2, r3, r4)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r1 = r1.zzc     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r6 == 0) goto L_0x072f
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0720
            com.google.android.gms.internal.ads.zzapb r3 = r8.zzk     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r3 = r3.zzc     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x072f
        L_0x0720:
            com.google.android.gms.internal.ads.zzapa r3 = r8.zzE     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            boolean r3 = r3.zzi     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r3 == 0) goto L_0x072f
            r3 = 4
            r8.zzE(r3)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r33.zzH()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x07c0
        L_0x072f:
            int r3 = r8.zzu     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r4 = 2
            if (r3 != r4) goto L_0x07a6
            com.google.android.gms.internal.ads.zzapl[] r3 = r8.zzp     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r3 = r3.length     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r3 <= 0) goto L_0x0794
            if (r5 == 0) goto L_0x07c0
            boolean r1 = r8.zzs     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            boolean r3 = r2.zzj     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r3 != 0) goto L_0x0746
            long r2 = r2.zzh     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x074c
        L_0x0746:
            com.google.android.gms.internal.ads.zzaum r2 = r2.zza     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r2 = r2.zzg()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x074c:
            r4 = -9223372036854775808
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0766
            com.google.android.gms.internal.ads.zzapa r2 = r8.zzC     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            boolean r3 = r2.zzi     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r3 == 0) goto L_0x0759
            goto L_0x079a
        L_0x0759:
            com.google.android.gms.internal.ads.zzapr r3 = r8.zzF     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r2 = r2.zzg     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapp r4 = r8.zzj     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r5 = 0
            com.google.android.gms.internal.ads.zzapp r2 = r3.zzd(r2, r4, r5)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r2 = r2.zzc     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x0766:
            boolean r4 = r8.zzG     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r4 == 0) goto L_0x0780
            com.google.android.gms.internal.ads.zzcmd r2 = r8.zzJ     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapb r3 = r8.zzk     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r3 = r3.zzd     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r5 = r8.zzC     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r6 = r8.zzB     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r9 = r5.zzf     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r13 = r5.zzh     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r9 = r9 - r13
            long r6 = r6 - r9
            long r3 = r3 - r6
            boolean r1 = r2.zzk(r3, r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x0791
        L_0x0780:
            com.google.android.gms.internal.ads.zzcmd r4 = r8.zzJ     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzapa r5 = r8.zzC     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r6 = r8.zzB     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r9 = r5.zzf     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r13 = r5.zzh     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r9 = r9 - r13
            long r6 = r6 - r9
            long r2 = r2 - r6
            boolean r1 = r4.zzk(r2, r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x0791:
            if (r1 == 0) goto L_0x07c0
            goto L_0x079a
        L_0x0794:
            boolean r1 = r8.zzK(r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x07c0
        L_0x079a:
            r1 = 3
            r8.zzE(r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            boolean r1 = r8.zzr     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x07c0
            r33.zzF()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x07c0
        L_0x07a6:
            r4 = 3
            if (r3 != r4) goto L_0x07c0
            com.google.android.gms.internal.ads.zzapl[] r3 = r8.zzp     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r3 = r3.length     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r3 <= 0) goto L_0x07af
            goto L_0x07b3
        L_0x07af:
            boolean r5 = r8.zzK(r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x07b3:
            if (r5 != 0) goto L_0x07c0
            boolean r1 = r8.zzr     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r8.zzs = r1     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r1 = 2
            r8.zzE(r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r33.zzH()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x07c0:
            int r1 = r8.zzu     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r2 = 2
            if (r1 != r2) goto L_0x07d3
            com.google.android.gms.internal.ads.zzapl[] r1 = r8.zzp     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r2 = r1.length     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r9 = 0
        L_0x07c9:
            if (r9 >= r2) goto L_0x07d3
            r3 = r1[r9]     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r3.zzm()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r9 = r9 + 1
            goto L_0x07c9
        L_0x07d3:
            boolean r1 = r8.zzr     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x07dc
            int r1 = r8.zzu     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r2 = 3
            if (r1 == r2) goto L_0x07e1
        L_0x07dc:
            int r1 = r8.zzu     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r2 = 2
            if (r1 != r2) goto L_0x07ef
        L_0x07e1:
            int r1 = r8.zzH     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 <= 0) goto L_0x07e9
            int r1 = r8.zzH     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r2 = (long) r1     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x07eb
        L_0x07e9:
            r2 = 10
        L_0x07eb:
            r8.zzB(r11, r2)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x0808
        L_0x07ef:
            com.google.android.gms.internal.ads.zzapl[] r1 = r8.zzp     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r1 = r1.length     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x0802
            int r1 = r8.zzI     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 <= 0) goto L_0x07fc
            int r1 = r8.zzI     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            long r1 = (long) r1     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x07fe
        L_0x07fc:
            r1 = r16
        L_0x07fe:
            r8.zzB(r11, r1)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x0808
        L_0x0802:
            android.os.Handler r1 = r8.zze     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r2 = 2
            r1.removeMessages(r2)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x0808:
            com.google.android.gms.internal.ads.zzawz.zzb()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x0683
        L_0x080d:
            return r1
        L_0x080e:
            r0 = move-exception
            r2 = r0
            r1 = r10
            goto L_0x0887
        L_0x0813:
            r0 = move-exception
            r2 = r0
            r1 = r10
            goto L_0x088d
        L_0x0818:
            int r1 = r1.arg1     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x081e
            r1 = 1
            goto L_0x081f
        L_0x081e:
            r1 = 0
        L_0x081f:
            r2 = 0
            r8.zzs = r2     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r8.zzr = r1     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 != 0) goto L_0x082e
            r33.zzH()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r33.zzI()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x082c:
            r1 = 1
            goto L_0x0846
        L_0x082e:
            int r1 = r8.zzu     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r2 = 3
            if (r1 != r2) goto L_0x083d
            r33.zzF()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            android.os.Handler r1 = r8.zze     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r2 = 2
            r1.sendEmptyMessage(r2)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x082c
        L_0x083d:
            r2 = 2
            if (r1 != r2) goto L_0x082c
            android.os.Handler r1 = r8.zze     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r1.sendEmptyMessage(r2)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            goto L_0x082c
        L_0x0846:
            return r1
        L_0x0847:
            java.lang.Object r2 = r1.obj     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzauo r2 = (com.google.android.gms.internal.ads.zzauo) r2     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            int r1 = r1.arg1     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r4 = 0
            r3.sendEmptyMessage(r4)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r3 = 1
            r8.zzz(r3)     // Catch:{ zzaos -> 0x0880, IOException -> 0x087c, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzcmd r3 = r8.zzJ     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r3.zza()     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            if (r1 == 0) goto L_0x086a
            com.google.android.gms.internal.ads.zzapb r1 = new com.google.android.gms.internal.ads.zzapb     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r4, r5)     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r8.zzk = r1     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
        L_0x086a:
            r8.zzo = r2     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            com.google.android.gms.internal.ads.zzaow r1 = r8.zzh     // Catch:{ zzaos -> 0x088a, IOException -> 0x0884, RuntimeException -> 0x0890 }
            r3 = 1
            r2.zzb(r1, r3, r8)     // Catch:{ zzaos -> 0x0880, IOException -> 0x087c, RuntimeException -> 0x0890 }
            r1 = 2
            r8.zzE(r1)     // Catch:{ zzaos -> 0x0880, IOException -> 0x087c, RuntimeException -> 0x0890 }
            android.os.Handler r2 = r8.zze     // Catch:{ zzaos -> 0x0880, IOException -> 0x087c, RuntimeException -> 0x0890 }
            r2.sendEmptyMessage(r1)     // Catch:{ zzaos -> 0x0880, IOException -> 0x087c, RuntimeException -> 0x0890 }
            return r3
        L_0x087c:
            r0 = move-exception
            r2 = r0
            r1 = r3
            goto L_0x0887
        L_0x0880:
            r0 = move-exception
            r2 = r0
            r1 = r3
            goto L_0x088d
        L_0x0884:
            r0 = move-exception
            r2 = r0
            r1 = 1
        L_0x0887:
            r3 = 8
            goto L_0x08b2
        L_0x088a:
            r0 = move-exception
            r2 = r0
            r1 = 1
        L_0x088d:
            r3 = 8
            goto L_0x08cf
        L_0x0890:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.zzg
            com.google.android.gms.internal.ads.zzaos r1 = com.google.android.gms.internal.ads.zzaos.zzc(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r33.zzG()
            r1 = 1
            return r1
        L_0x08ad:
            r0 = move-exception
            r1 = r10
            r3 = 8
            r2 = r0
        L_0x08b2:
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r5 = "Source error."
            android.util.Log.e(r4, r5, r2)
            android.os.Handler r4 = r8.zzg
            com.google.android.gms.internal.ads.zzaos r2 = com.google.android.gms.internal.ads.zzaos.zzb(r2)
            android.os.Message r2 = r4.obtainMessage(r3, r2)
            r2.sendToTarget()
            r33.zzG()
            return r1
        L_0x08ca:
            r0 = move-exception
            r1 = r10
            r3 = 8
            r2 = r0
        L_0x08cf:
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r5 = "Renderer error."
            android.util.Log.e(r4, r5, r2)
            android.os.Handler r4 = r8.zzg
            android.os.Message r2 = r4.obtainMessage(r3, r2)
            r2.sendToTarget()
            r33.zzG()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzape.handleMessage(android.os.Message):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzaov... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.zzw     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.zzw = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.zze     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.zzx     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzape.zza(com.google.android.gms.internal.ads.zzaov[]):void");
    }

    public final void zzb() {
        this.zzG = true;
    }

    public final /* bridge */ /* synthetic */ void zzc(zzava zzava) {
        this.zze.obtainMessage(9, (zzaum) zzava).sendToTarget();
    }

    public final void zzd(zzaum zzaum) {
        this.zze.obtainMessage(8, zzaum).sendToTarget();
    }

    public final void zze(zzapr zzapr, Object obj) {
        this.zze.obtainMessage(7, Pair.create(zzapr, (Object) null)).sendToTarget();
    }

    public final void zzf() {
        this.zze.sendEmptyMessage(10);
    }

    public final void zzg(zzauo zzauo, boolean z11) {
        this.zze.obtainMessage(0, 1, 0, zzauo).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzq     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.zze     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzq     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzf     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzape.zzh():void");
    }

    public final void zzi(zzapr zzapr, int i11, long j11) {
        this.zze.obtainMessage(3, new zzapc(zzapr, 0, j11)).sendToTarget();
    }

    public final void zzj(zzaov... zzaovArr) {
        if (this.zzq) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzw++;
        this.zze.obtainMessage(11, zzaovArr).sendToTarget();
    }

    public final void zzk(int i11) {
        this.zzI = i11;
    }

    public final void zzl(int i11) {
        this.zzH = i11;
    }

    public final void zzm(boolean z11) {
        this.zze.obtainMessage(1, z11 ? 1 : 0, 0).sendToTarget();
    }

    public final void zzn() {
        this.zze.sendEmptyMessage(5);
    }
}
