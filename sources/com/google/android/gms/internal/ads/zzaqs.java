package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzaqs extends zzate implements zzawq {
    /* access modifiers changed from: private */
    public final zzaqc zzb;
    private final zzaqo zzc = new zzaqo((zzapt) null, new zzapv[0], new zzaqr(this, (zzaqq) null));
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    /* access modifiers changed from: private */
    public boolean zzh;

    public zzaqs(zzatg zzatg, zzarg zzarg, boolean z11, Handler handler, zzaqd zzaqd) {
        super(1, zzatg, (zzarg) null, true);
        this.zzb = new zzaqc(handler, zzaqd);
    }

    public final boolean zzE() {
        return super.zzE() && this.zzc.zzo();
    }

    public final boolean zzF() {
        return this.zzc.zzn() || super.zzF();
    }

    public final int zzH(zzatg zzatg, zzapg zzapg) throws zzatj {
        int i11;
        int i12;
        int i13;
        String str = zzapg.zzf;
        if (!zzawr.zza(str)) {
            return 0;
        }
        int i14 = zzaxb.zza;
        if (i14 >= 21) {
            i11 = 16;
        } else {
            i11 = 0;
        }
        zzatc zzc2 = zzato.zzc(str, false);
        if (zzc2 == null) {
            return 1;
        }
        int i15 = 3;
        if (i14 >= 21 && (((i12 = zzapg.zzs) != -1 && !zzc2.zzd(i12)) || ((i13 = zzapg.zzr) != -1 && !zzc2.zzc(i13)))) {
            i15 = 2;
        }
        return i11 | 4 | i15;
    }

    public final long zzI() {
        long zza = this.zzc.zza(zzE());
        if (zza != Long.MIN_VALUE) {
            if (!this.zzh) {
                zza = Math.max(this.zzg, zza);
            }
            this.zzg = zza;
            this.zzh = false;
        }
        return this.zzg;
    }

    public final zzapk zzJ() {
        return this.zzc.zzc();
    }

    public final zzapk zzK(zzapk zzapk) {
        return this.zzc.zzd(zzapk);
    }

    public final zzatc zzM(zzatg zzatg, zzapg zzapg, boolean z11) throws zzatj {
        return super.zzM(zzatg, zzapg, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r3.startsWith("heroqlte") == false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(com.google.android.gms.internal.ads.zzatc r3, android.media.MediaCodec r4, com.google.android.gms.internal.ads.zzapg r5, android.media.MediaCrypto r6) {
        /*
            r2 = this;
            java.lang.String r3 = r3.zza
            int r6 = com.google.android.gms.internal.ads.zzaxb.zza
            r0 = 24
            r1 = 0
            if (r6 >= r0) goto L_0x0037
            java.lang.String r6 = "OMX.SEC.aac.dec"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x0037
            java.lang.String r3 = "samsung"
            java.lang.String r6 = com.google.android.gms.internal.ads.zzaxb.zzc
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x0037
            java.lang.String r3 = com.google.android.gms.internal.ads.zzaxb.zzb
            java.lang.String r6 = "zeroflte"
            boolean r6 = r3.startsWith(r6)
            r0 = 1
            if (r6 != 0) goto L_0x0038
            java.lang.String r6 = "herolte"
            boolean r6 = r3.startsWith(r6)
            if (r6 != 0) goto L_0x0038
            java.lang.String r6 = "heroqlte"
            boolean r3 = r3.startsWith(r6)
            if (r3 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r0 = r1
        L_0x0038:
            r2.zzd = r0
            android.media.MediaFormat r3 = r5.zzb()
            r5 = 0
            r4.configure(r3, r5, r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqs.zzO(com.google.android.gms.internal.ads.zzatc, android.media.MediaCodec, com.google.android.gms.internal.ads.zzapg, android.media.MediaCrypto):void");
    }

    public final void zzP(String str, long j11, long j12) {
        this.zzb.zzd(str, j11, j12);
    }

    public final void zzQ(zzapg zzapg) throws zzaos {
        int i11;
        super.zzQ(zzapg);
        this.zzb.zzg(zzapg);
        if (MimeTypes.AUDIO_RAW.equals(zzapg.zzf)) {
            i11 = zzapg.zzt;
        } else {
            i11 = 2;
        }
        this.zze = i11;
        this.zzf = zzapg.zzr;
    }

    public final void zzR(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzaos {
        int[] iArr;
        int i11;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzd || integer != 6) {
            i11 = integer;
        } else {
            int i12 = this.zzf;
            if (i12 < 6) {
                int[] iArr2 = new int[i12];
                for (int i13 = 0; i13 < this.zzf; i13++) {
                    iArr2[i13] = i13;
                }
                iArr = iArr2;
                i11 = 6;
                this.zzc.zze(MimeTypes.AUDIO_RAW, i11, integer2, this.zze, 0, iArr);
            }
            i11 = 6;
        }
        iArr = null;
        try {
            this.zzc.zze(MimeTypes.AUDIO_RAW, i11, integer2, this.zze, 0, iArr);
        } catch (zzaqi e11) {
            throw zzaos.zza(e11, zza());
        }
    }

    public final void zzS() throws zzaos {
        try {
            this.zzc.zzi();
        } catch (zzaqn e11) {
            throw zzaos.zza(e11, zza());
        }
    }

    public final boolean zzT(long j11, long j12, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i11, int i12, long j13, boolean z11) throws zzaos {
        if (z11) {
            mediaCodec.releaseOutputBuffer(i11, false);
            this.zza.zze++;
            this.zzc.zzf();
            return true;
        }
        try {
            if (!this.zzc.zzm(byteBuffer, j13)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i11, false);
            this.zza.zzd++;
            return true;
        } catch (zzaqj | zzaqn e11) {
            throw zzaos.zza(e11, zza());
        }
    }

    public final zzawq zzi() {
        return this;
    }

    public final void zzl(int i11, Object obj) throws zzaos {
        if (i11 == 2) {
            this.zzc.zzl(((Float) obj).floatValue());
        }
    }

    public final void zzn() {
        try {
            this.zzc.zzj();
            try {
                super.zzn();
            } finally {
                this.zza.zza();
                this.zzb.zze(this.zza);
            }
        } catch (Throwable th2) {
            super.zzn();
            throw th2;
        } finally {
            this.zza.zza();
            this.zzb.zze(this.zza);
        }
    }

    public final void zzo(boolean z11) throws zzaos {
        super.zzo(z11);
        this.zzb.zzf(this.zza);
        int i11 = zzg().zzb;
    }

    public final void zzp(long j11, boolean z11) throws zzaos {
        super.zzp(j11, z11);
        this.zzc.zzk();
        this.zzg = j11;
        this.zzh = true;
    }

    public final void zzq() {
        this.zzc.zzh();
    }

    public final void zzr() {
        this.zzc.zzg();
    }
}
