package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import i7.t;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public final class zzmr implements zzlz {
    private ByteBuffer[] zzA;
    @Nullable
    private ByteBuffer zzB;
    @Nullable
    private ByteBuffer zzC;
    private byte[] zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    /* access modifiers changed from: private */
    public boolean zzI;
    private boolean zzJ;
    private int zzK;
    private zzh zzL;
    /* access modifiers changed from: private */
    public long zzM;
    private boolean zzN;
    private boolean zzO;
    private final zzmi zzP;
    private final zzmf zza;
    private final zzna zzb;
    private final zzlh[] zzc;
    private final zzlh[] zzd;
    /* access modifiers changed from: private */
    public final ConditionVariable zze = new ConditionVariable(true);
    private final zzmd zzf = new zzmd(new zzmn(this, (zzmm) null));
    private final ArrayDeque<zzmk> zzg;
    private zzmq zzh;
    private final zzml<zzlv> zzi;
    private final zzml<zzly> zzj;
    /* access modifiers changed from: private */
    @Nullable
    public zzlw zzk;
    @Nullable
    private zzmh zzl;
    private zzmh zzm;
    /* access modifiers changed from: private */
    @Nullable
    public AudioTrack zzn;
    private zzg zzo;
    @Nullable
    private zzmk zzp;
    private zzmk zzq;
    private final zzbn zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private boolean zzv;
    private boolean zzw;
    private long zzx;
    private float zzy;
    private zzlh[] zzz;

    public zzmr(@Nullable zzle zzle, zzlh[] zzlhArr, boolean z11) {
        zzmi zzmi = new zzmi(zzlhArr);
        this.zzP = zzmi;
        int i11 = zzfn.zza;
        zzmf zzmf = new zzmf();
        this.zza = zzmf;
        zzna zzna = new zzna();
        this.zzb = zzna;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new zzme[]{new zzmw(), zzmf, zzna});
        Collections.addAll(arrayList, zzmi.zze());
        this.zzc = (zzlh[]) arrayList.toArray(new zzlh[0]);
        this.zzd = new zzlh[]{new zzms()};
        this.zzy = 1.0f;
        this.zzo = zzg.zza;
        this.zzK = 0;
        this.zzL = new zzh(0, 0.0f);
        zzbn zzbn = zzbn.zza;
        this.zzq = new zzmk(zzbn, false, 0, 0, (zzmj) null);
        this.zzr = zzbn;
        this.zzF = -1;
        this.zzz = new zzlh[0];
        this.zzA = new ByteBuffer[0];
        this.zzg = new ArrayDeque<>();
        this.zzi = new zzml<>(100);
        this.zzj = new zzml<>(100);
    }

    /* access modifiers changed from: private */
    public final long zzD() {
        zzmh zzmh = this.zzm;
        int i11 = zzmh.zzc;
        return this.zzs / ((long) zzmh.zzb);
    }

    /* access modifiers changed from: private */
    public final long zzE() {
        zzmh zzmh = this.zzm;
        int i11 = zzmh.zzc;
        return this.zzt / ((long) zzmh.zzd);
    }

    private final zzmk zzF() {
        zzmk zzmk = this.zzp;
        if (zzmk != null) {
            return zzmk;
        }
        if (!this.zzg.isEmpty()) {
            return this.zzg.getLast();
        }
        return this.zzq;
    }

    private final void zzG(long j11) {
        zzbn zzbn;
        boolean z11;
        if (zzQ()) {
            zzmi zzmi = this.zzP;
            zzbn = zzF().zza;
            zzmi.zzc(zzbn);
        } else {
            zzbn = zzbn.zza;
        }
        zzbn zzbn2 = zzbn;
        if (zzQ()) {
            zzmi zzmi2 = this.zzP;
            boolean z12 = zzF().zzb;
            zzmi2.zzd(z12);
            z11 = z12;
        } else {
            z11 = false;
        }
        this.zzg.add(new zzmk(zzbn2, z11, Math.max(0, j11), this.zzm.zzb(zzE()), (zzmj) null));
        zzlh[] zzlhArr = this.zzm.zzi;
        ArrayList arrayList = new ArrayList();
        for (zzlh zzlh : zzlhArr) {
            if (zzlh.zzg()) {
                arrayList.add(zzlh);
            } else {
                zzlh.zzc();
            }
        }
        int size = arrayList.size();
        this.zzz = (zzlh[]) arrayList.toArray(new zzlh[size]);
        this.zzA = new ByteBuffer[size];
        zzH();
        zzlw zzlw = this.zzk;
        if (zzlw != null) {
            ((zzmu) zzlw).zza.zzc.zzs(z11);
        }
    }

    private final void zzH() {
        int i11 = 0;
        while (true) {
            zzlh[] zzlhArr = this.zzz;
            if (i11 < zzlhArr.length) {
                zzlh zzlh = zzlhArr[i11];
                zzlh.zzc();
                this.zzA[i11] = zzlh.zzb();
                i11++;
            } else {
                return;
            }
        }
    }

    private final void zzI() {
        if (!this.zzH) {
            this.zzH = true;
            this.zzf.zzd(zzE());
            this.zzn.stop();
        }
    }

    private final void zzJ(long j11) throws zzly {
        ByteBuffer byteBuffer;
        int length = this.zzz.length;
        int i11 = length;
        while (i11 >= 0) {
            if (i11 > 0) {
                byteBuffer = this.zzA[i11 - 1];
            } else {
                byteBuffer = this.zzB;
                if (byteBuffer == null) {
                    byteBuffer = zzlh.zza;
                }
            }
            if (i11 == length) {
                zzM(byteBuffer, j11);
            } else {
                zzlh zzlh = this.zzz[i11];
                if (i11 > this.zzF) {
                    zzlh.zze(byteBuffer);
                }
                ByteBuffer zzb2 = zzlh.zzb();
                this.zzA[i11] = zzb2;
                if (zzb2.hasRemaining()) {
                    i11++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i11--;
            } else {
                return;
            }
        }
    }

    private final void zzK(zzbn zzbn, boolean z11) {
        zzmk zzF2 = zzF();
        if (!zzbn.equals(zzF2.zza) || z11 != zzF2.zzb) {
            zzmk zzmk = new zzmk(zzbn, z11, C.TIME_UNSET, C.TIME_UNSET, (zzmj) null);
            if (zzO()) {
                this.zzp = zzmk;
            } else {
                this.zzq = zzmk;
            }
        }
    }

    private final void zzL() {
        if (zzO()) {
            if (zzfn.zza >= 21) {
                this.zzn.setVolume(this.zzy);
                return;
            }
            AudioTrack audioTrack = this.zzn;
            float f11 = this.zzy;
            audioTrack.setStereoVolume(f11, f11);
        }
    }

    private final void zzM(ByteBuffer byteBuffer, long j11) throws zzly {
        int i11;
        boolean z11;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzC;
            boolean z12 = true;
            if (byteBuffer2 != null) {
                if (byteBuffer2 == byteBuffer) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zzdy.zzd(z11);
            } else {
                this.zzC = byteBuffer;
                if (zzfn.zza < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.zzD;
                    if (bArr == null || bArr.length < remaining) {
                        this.zzD = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.zzD, 0, remaining);
                    byteBuffer.position(position);
                    this.zzE = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            int i12 = zzfn.zza;
            if (i12 < 21) {
                int zza2 = this.zzf.zza(this.zzt);
                if (zza2 > 0) {
                    i11 = this.zzn.write(this.zzD, this.zzE, Math.min(remaining2, zza2));
                    if (i11 > 0) {
                        this.zzE += i11;
                        byteBuffer.position(byteBuffer.position() + i11);
                    }
                } else {
                    i11 = 0;
                }
            } else {
                i11 = this.zzn.write(byteBuffer, remaining2, 1);
            }
            this.zzM = SystemClock.elapsedRealtime();
            if (i11 < 0) {
                if ((i12 < 24 || i11 != -6) && i11 != -32) {
                    z12 = false;
                }
                zzly zzly = new zzly(i11, this.zzm.zza, z12);
                zzlw zzlw = this.zzk;
                if (zzlw != null) {
                    zzlw.zza(zzly);
                }
                if (!zzly.zza) {
                    this.zzj.zzb(zzly);
                    return;
                }
                throw zzly;
            }
            this.zzj.zza();
            if (zzP(this.zzn) && this.zzI && this.zzk != null && i11 < remaining2 && !this.zzO) {
                long zzc2 = this.zzf.zzc(0);
                zzmu zzmu = (zzmu) this.zzk;
                if (zzmu.zza.zzl != null) {
                    zzmu.zza.zzl.zza(zzc2);
                }
            }
            int i13 = this.zzm.zzc;
            this.zzt += (long) i11;
            if (i11 == remaining2) {
                this.zzC = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzN() throws com.google.android.gms.internal.ads.zzly {
        /*
            r9 = this;
            int r0 = r9.zzF
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L_0x000b
            r9.zzF = r2
        L_0x0009:
            r0 = r1
            goto L_0x000c
        L_0x000b:
            r0 = r2
        L_0x000c:
            int r4 = r9.zzF
            com.google.android.gms.internal.ads.zzlh[] r5 = r9.zzz
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.zzd()
        L_0x001f:
            r9.zzJ(r7)
            boolean r0 = r4.zzh()
            if (r0 != 0) goto L_0x0029
            return r2
        L_0x0029:
            int r0 = r9.zzF
            int r0 = r0 + r1
            r9.zzF = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.zzC
            if (r0 == 0) goto L_0x003b
            r9.zzM(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzC
            if (r0 == 0) goto L_0x003b
            return r2
        L_0x003b:
            r9.zzF = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmr.zzN():boolean");
    }

    private final boolean zzO() {
        return this.zzn != null;
    }

    private static boolean zzP(AudioTrack audioTrack) {
        return zzfn.zza >= 29 && t.a(audioTrack);
    }

    private final boolean zzQ() {
        if (!MimeTypes.AUDIO_RAW.equals(this.zzm.zza.zzm)) {
            return false;
        }
        int i11 = this.zzm.zza.zzB;
        return true;
    }

    public final int zza(zzab zzab) {
        if (!MimeTypes.AUDIO_RAW.equals(zzab.zzm)) {
            int i11 = zzfn.zza;
            return 0;
        } else if (!zzfn.zzR(zzab.zzB)) {
            int i12 = zzab.zzB;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Invalid PCM encoding: ");
            sb2.append(i12);
            Log.w("DefaultAudioSink", sb2.toString());
            return 0;
        } else if (zzab.zzB != 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public final long zzb(boolean z11) {
        long j11;
        if (!zzO() || this.zzw) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzf.zzb(z11), this.zzm.zzb(zzE()));
        while (!this.zzg.isEmpty() && min >= this.zzg.getFirst().zzd) {
            this.zzq = this.zzg.remove();
        }
        zzmk zzmk = this.zzq;
        long j12 = min - zzmk.zzd;
        if (zzmk.zza.equals(zzbn.zza)) {
            j11 = this.zzq.zzc + j12;
        } else if (this.zzg.isEmpty()) {
            j11 = this.zzP.zza(j12) + this.zzq.zzc;
        } else {
            zzmk first = this.zzg.getFirst();
            j11 = first.zzc - zzfn.zzp(first.zzd - min, this.zzq.zza.zzc);
        }
        return j11 + this.zzm.zzb(this.zzP.zzb());
    }

    public final zzbn zzc() {
        return zzF().zza;
    }

    public final void zzd(zzab zzab, int i11, @Nullable int[] iArr) throws zzlu {
        if (MimeTypes.AUDIO_RAW.equals(zzab.zzm)) {
            zzdy.zzd(zzfn.zzR(zzab.zzB));
            int zzm2 = zzfn.zzm(zzab.zzB, zzab.zzz);
            zzlh[] zzlhArr = this.zzc;
            this.zzb.zzq(zzab.zzC, zzab.zzD);
            if (zzfn.zza < 21 && zzab.zzz == 8 && iArr == null) {
                iArr = new int[6];
                for (int i12 = 0; i12 < 6; i12++) {
                    iArr[i12] = i12;
                }
            }
            this.zza.zzo(iArr);
            zzlf zzlf = new zzlf(zzab.zzA, zzab.zzz, zzab.zzB);
            int length = zzlhArr.length;
            int i13 = 0;
            while (i13 < length) {
                zzlh zzlh = zzlhArr[i13];
                try {
                    zzlf zza2 = zzlh.zza(zzlf);
                    if (true == zzlh.zzg()) {
                        zzlf = zza2;
                    }
                    i13++;
                } catch (zzlg e11) {
                    throw new zzlu((Throwable) e11, zzab);
                }
            }
            int i14 = zzlf.zzd;
            int i15 = zzlf.zzb;
            int zzj2 = zzfn.zzj(zzlf.zzc);
            int zzm3 = zzfn.zzm(i14, zzlf.zzc);
            if (i14 == 0) {
                String valueOf = String.valueOf(zzab);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 48);
                sb2.append("Invalid output encoding (mode=0) for: ");
                sb2.append(valueOf);
                throw new zzlu(sb2.toString(), zzab);
            } else if (zzj2 != 0) {
                this.zzN = false;
                zzmh zzmh = new zzmh(zzab, zzm2, 0, zzm3, i15, zzj2, i14, 0, false, zzlhArr);
                if (zzO()) {
                    this.zzl = zzmh;
                } else {
                    this.zzm = zzmh;
                }
            } else {
                String valueOf2 = String.valueOf(zzab);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 54);
                sb3.append("Invalid output channel config (mode=0) for: ");
                sb3.append(valueOf2);
                throw new zzlu(sb3.toString(), zzab);
            }
        } else {
            int i16 = zzfn.zza;
            throw new zzlu("Unable to configure passthrough for: ".concat(String.valueOf(zzab)), zzab);
        }
    }

    public final void zze() {
        if (zzO()) {
            this.zzs = 0;
            this.zzt = 0;
            this.zzu = 0;
            this.zzO = false;
            this.zzq = new zzmk(zzF().zza, zzF().zzb, 0, 0, (zzmj) null);
            this.zzx = 0;
            this.zzp = null;
            this.zzg.clear();
            this.zzB = null;
            this.zzC = null;
            this.zzH = false;
            this.zzG = false;
            this.zzF = -1;
            this.zzb.zzp();
            zzH();
            if (this.zzf.zzi()) {
                this.zzn.pause();
            }
            if (zzP(this.zzn)) {
                zzmq zzmq = this.zzh;
                zzmq.getClass();
                zzmq.zzb(this.zzn);
            }
            AudioTrack audioTrack = this.zzn;
            this.zzn = null;
            if (zzfn.zza < 21 && !this.zzJ) {
                this.zzK = 0;
            }
            zzmh zzmh = this.zzl;
            if (zzmh != null) {
                this.zzm = zzmh;
                this.zzl = null;
            }
            this.zzf.zze();
            this.zze.close();
            new zzmg(this, "ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
        this.zzj.zza();
        this.zzi.zza();
    }

    public final void zzf() {
        this.zzv = true;
    }

    public final void zzg() {
        this.zzI = false;
        if (zzO() && this.zzf.zzl()) {
            this.zzn.pause();
        }
    }

    public final void zzh() {
        this.zzI = true;
        if (zzO()) {
            this.zzf.zzg();
            this.zzn.play();
        }
    }

    public final void zzi() throws zzly {
        if (!this.zzG && zzO() && zzN()) {
            zzI();
            this.zzG = true;
        }
    }

    public final void zzj() {
        zze();
        for (zzlh zzf2 : this.zzc) {
            zzf2.zzf();
        }
        zzlh[] zzlhArr = this.zzd;
        int length = zzlhArr.length;
        for (int i11 = 0; i11 <= 0; i11++) {
            zzlhArr[i11].zzf();
        }
        this.zzI = false;
        this.zzN = false;
    }

    public final void zzk(zzg zzg2) {
        if (!this.zzo.equals(zzg2)) {
            this.zzo = zzg2;
            zze();
        }
    }

    public final void zzl(int i11) {
        if (this.zzK != i11) {
            this.zzK = i11;
            this.zzJ = i11 != 0;
            zze();
        }
    }

    public final void zzm(zzh zzh2) {
        if (!this.zzL.equals(zzh2)) {
            int i11 = zzh2.zza;
            if (this.zzn != null) {
                int i12 = this.zzL.zza;
            }
            this.zzL = zzh2;
        }
    }

    public final void zzn(zzlw zzlw) {
        this.zzk = zzlw;
    }

    public final void zzo(zzbn zzbn) {
        zzK(new zzbn(zzfn.zza(zzbn.zzc, 0.1f, 8.0f), zzfn.zza(zzbn.zzd, 0.1f, 8.0f)), zzF().zzb);
    }

    public final void zzp(boolean z11) {
        zzK(zzF().zza, z11);
    }

    public final void zzq(float f11) {
        if (this.zzy != f11) {
            this.zzy = f11;
            zzL();
        }
    }

    public final boolean zzr(ByteBuffer byteBuffer, long j11, int i11) throws zzlv, zzly {
        boolean z11;
        boolean z12;
        ByteBuffer byteBuffer2 = this.zzB;
        if (byteBuffer2 == null || byteBuffer == byteBuffer2) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        if (this.zzl != null) {
            if (!zzN()) {
                return false;
            }
            zzmh zzmh = this.zzl;
            zzmh zzmh2 = this.zzm;
            int i12 = zzmh2.zzc;
            int i13 = zzmh.zzc;
            if (zzmh2.zzg == zzmh.zzg && zzmh2.zze == zzmh.zze && zzmh2.zzf == zzmh.zzf && zzmh2.zzd == zzmh.zzd) {
                this.zzm = zzmh;
                this.zzl = null;
                if (zzP(this.zzn)) {
                    this.zzn.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.zzn;
                    zzab zzab = this.zzm.zza;
                    audioTrack.setOffloadDelayPadding(zzab.zzC, zzab.zzD);
                    this.zzO = true;
                }
            } else {
                zzI();
                if (zzs()) {
                    return false;
                }
                zze();
            }
            zzG(j11);
        }
        if (!zzO()) {
            try {
                this.zze.block();
                zzmh zzmh3 = this.zzm;
                zzmh3.getClass();
                AudioTrack zzc2 = zzmh3.zzc(false, this.zzo, this.zzK);
                this.zzn = zzc2;
                if (zzP(zzc2)) {
                    AudioTrack audioTrack2 = this.zzn;
                    if (this.zzh == null) {
                        this.zzh = new zzmq(this);
                    }
                    this.zzh.zza(audioTrack2);
                    AudioTrack audioTrack3 = this.zzn;
                    zzab zzab2 = this.zzm.zza;
                    audioTrack3.setOffloadDelayPadding(zzab2.zzC, zzab2.zzD);
                }
                this.zzK = this.zzn.getAudioSessionId();
                zzmd zzmd = this.zzf;
                AudioTrack audioTrack4 = this.zzn;
                zzmh zzmh4 = this.zzm;
                int i14 = zzmh4.zzc;
                zzmd.zzf(audioTrack4, false, zzmh4.zzg, zzmh4.zzd, zzmh4.zzh);
                zzL();
                int i15 = this.zzL.zza;
                this.zzw = true;
            } catch (zzlv e11) {
                zzlw zzlw = this.zzk;
                if (zzlw != null) {
                    zzlw.zza(e11);
                }
                throw e11;
            } catch (zzlv e12) {
                this.zzi.zzb(e12);
                return false;
            }
        }
        this.zzi.zza();
        if (this.zzw) {
            this.zzx = Math.max(0, j11);
            this.zzv = false;
            this.zzw = false;
            zzG(j11);
            if (this.zzI) {
                zzh();
            }
        }
        if (!this.zzf.zzk(zzE())) {
            return false;
        }
        if (this.zzB == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                z12 = true;
            } else {
                z12 = false;
            }
            zzdy.zzd(z12);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            int i16 = this.zzm.zzc;
            if (this.zzp != null) {
                if (!zzN()) {
                    return false;
                }
                zzG(j11);
                this.zzp = null;
            }
            long zzD2 = this.zzx + (((zzD() - this.zzb.zzo()) * 1000000) / ((long) this.zzm.zza.zzA));
            if (!this.zzv && Math.abs(zzD2 - j11) > 200000) {
                this.zzk.zza(new zzlx(j11, zzD2));
                this.zzv = true;
            }
            if (this.zzv) {
                if (!zzN()) {
                    return false;
                }
                long j12 = j11 - zzD2;
                this.zzx += j12;
                this.zzv = false;
                zzG(j11);
                zzlw zzlw2 = this.zzk;
                if (!(zzlw2 == null || j12 == 0)) {
                    ((zzmu) zzlw2).zza.zzaa();
                }
            }
            int i17 = this.zzm.zzc;
            this.zzs += (long) byteBuffer.remaining();
            this.zzB = byteBuffer;
        }
        zzJ(j11);
        if (!this.zzB.hasRemaining()) {
            this.zzB = null;
            return true;
        } else if (!this.zzf.zzj(zzE())) {
            return false;
        } else {
            Log.w("DefaultAudioSink", "Resetting stalled audio track");
            zze();
            return true;
        }
    }

    public final boolean zzs() {
        return zzO() && this.zzf.zzh(zzE());
    }

    public final boolean zzt() {
        if (!zzO()) {
            return true;
        }
        if (this.zzG) {
            return !zzs();
        }
        return false;
    }

    public final boolean zzu(zzab zzab) {
        return zza(zzab) != 0;
    }
}
