package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.huawei.hms.flutter.map.constants.Param;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzaxk extends zzate {
    private int zzA;
    private final Context zzb;
    private final zzaxm zzc;
    private final zzaxu zzd;
    private final boolean zze;
    private final long[] zzf;
    private zzapg[] zzg;
    private zzaxj zzh;
    private Surface zzi;
    private Surface zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private float zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private float zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private float zzy;
    private long zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaxk(Context context, zzatg zzatg, long j11, Handler handler, zzaxv zzaxv, int i11) {
        super(2, zzatg, (zzarg) null, false);
        boolean z11 = false;
        this.zzb = context.getApplicationContext();
        this.zzc = new zzaxm(context);
        this.zzd = new zzaxu(handler, zzaxv);
        if (zzaxb.zza <= 22 && "foster".equals(zzaxb.zzb) && "NVIDIA".equals(zzaxb.zzc)) {
            z11 = true;
        }
        this.zze = z11;
        this.zzf = new long[10];
        this.zzz = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
        this.zzr = -1;
        this.zzs = -1;
        this.zzu = -1.0f;
        this.zzq = -1.0f;
        zzab();
    }

    private static int zzN(zzapg zzapg) {
        int i11 = zzapg.zzm;
        if (i11 == -1) {
            return 0;
        }
        return i11;
    }

    private final void zzab() {
        this.zzv = -1;
        this.zzw = -1;
        this.zzy = -1.0f;
        this.zzx = -1;
    }

    private final void zzac() {
        if (this.zzn > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzd.zzd(this.zzn, elapsedRealtime - this.zzm);
            this.zzn = 0;
            this.zzm = elapsedRealtime;
        }
    }

    private final void zzad() {
        int i11 = this.zzv;
        int i12 = this.zzr;
        if (i11 != i12 || this.zzw != this.zzs || this.zzx != this.zzt || this.zzy != this.zzu) {
            this.zzd.zzh(i12, this.zzs, this.zzt, this.zzu);
            this.zzv = this.zzr;
            this.zzw = this.zzs;
            this.zzx = this.zzt;
            this.zzy = this.zzu;
        }
    }

    private final void zzae() {
        if (this.zzv != -1 || this.zzw != -1) {
            this.zzd.zzh(this.zzr, this.zzs, this.zzt, this.zzu);
        }
    }

    private static boolean zzaf(long j11) {
        return j11 < -30000;
    }

    private final boolean zzag(boolean z11) {
        if (zzaxb.zza < 23) {
            return false;
        }
        if (!z11) {
            return true;
        }
        if (!zzaxh.zzb(this.zzb)) {
            return false;
        }
        return true;
    }

    public final boolean zzF() {
        Surface surface;
        if (super.zzF() && (this.zzk || (((surface = this.zzj) != null && this.zzi == surface) || zzU() == null))) {
            this.zzl = C.TIME_UNSET;
            return true;
        } else if (this.zzl == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzl) {
                return true;
            }
            this.zzl = C.TIME_UNSET;
            return false;
        }
    }

    public final int zzH(zzatg zzatg, zzapg zzapg) throws zzatj {
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        String str = zzapg.zzf;
        int i15 = 0;
        if (!zzawr.zzb(str)) {
            return 0;
        }
        zzarf zzarf = zzapg.zzi;
        if (zzarf != null) {
            z11 = false;
            for (int i16 = 0; i16 < zzarf.zza; i16++) {
                z11 |= zzarf.zza(i16).zzc;
            }
        } else {
            z11 = false;
        }
        zzatc zzc2 = zzato.zzc(str, z11);
        if (zzc2 == null) {
            return 1;
        }
        boolean zze2 = zzc2.zze(zzapg.zzc);
        if (zze2 && (i13 = zzapg.zzj) > 0 && (i14 = zzapg.zzk) > 0) {
            if (zzaxb.zza >= 21) {
                zze2 = zzc2.zzf(i13, i14, (double) zzapg.zzl);
            } else {
                if (i13 * i14 <= zzato.zza()) {
                    zze2 = true;
                } else {
                    zze2 = false;
                }
                if (!zze2) {
                    int i17 = zzapg.zzj;
                    int i18 = zzapg.zzk;
                    String str2 = zzaxb.zze;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb2.append("FalseCheck [legacyFrameSize, ");
                    sb2.append(i17);
                    sb2.append(Param.X);
                    sb2.append(i18);
                    sb2.append("] [");
                    sb2.append(str2);
                    sb2.append("]");
                }
            }
        }
        if (true != zzc2.zzb) {
            i11 = 4;
        } else {
            i11 = 8;
        }
        if (true == zzc2.zzc) {
            i15 = 16;
        }
        if (true != zze2) {
            i12 = 2;
        } else {
            i12 = 3;
        }
        return i12 | i11 | i15;
    }

    public final void zzI() {
        if (!this.zzk) {
            this.zzk = true;
            this.zzd.zzg(this.zzi);
        }
    }

    public final void zzJ(MediaCodec mediaCodec, int i11, long j11) {
        zzad();
        zzawz.zza("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i11, true);
        zzawz.zzb();
        this.zza.zzd++;
        this.zzo = 0;
        zzI();
    }

    @TargetApi(21)
    public final void zzK(MediaCodec mediaCodec, int i11, long j11, long j12) {
        zzad();
        zzawz.zza("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i11, j12);
        zzawz.zzb();
        this.zza.zzd++;
        this.zzo = 0;
        zzI();
    }

    public final void zzL(MediaCodec mediaCodec, int i11, long j11) {
        zzawz.zza("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i11, false);
        zzawz.zzb();
        this.zza.zze++;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(com.google.android.gms.internal.ads.zzatc r12, android.media.MediaCodec r13, com.google.android.gms.internal.ads.zzapg r14, android.media.MediaCrypto r15) throws com.google.android.gms.internal.ads.zzatj {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzapg[] r15 = r11.zzg
            int r0 = r14.zzj
            int r1 = r14.zzk
            int r2 = r14.zzg
            r3 = 0
            r4 = -1
            if (r2 != r4) goto L_0x008f
            java.lang.String r2 = r14.zzf
            if (r0 == r4) goto L_0x008e
            if (r1 != r4) goto L_0x0014
            goto L_0x008e
        L_0x0014:
            int r5 = r2.hashCode()
            r6 = 5
            r7 = 1
            r8 = 4
            r9 = 3
            r10 = 2
            switch(r5) {
                case -1664118616: goto L_0x0053;
                case -1662541442: goto L_0x0049;
                case 1187890754: goto L_0x003f;
                case 1331836730: goto L_0x0035;
                case 1599127256: goto L_0x002b;
                case 1599127257: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x005d
        L_0x0021:
            java.lang.String r5 = "video/x-vnd.on2.vp9"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r6
            goto L_0x005e
        L_0x002b:
            java.lang.String r5 = "video/x-vnd.on2.vp8"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r9
            goto L_0x005e
        L_0x0035:
            java.lang.String r5 = "video/avc"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r10
            goto L_0x005e
        L_0x003f:
            java.lang.String r5 = "video/mp4v-es"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r7
            goto L_0x005e
        L_0x0049:
            java.lang.String r5 = "video/hevc"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r8
            goto L_0x005e
        L_0x0053:
            java.lang.String r5 = "video/3gpp"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x005d
            r2 = r3
            goto L_0x005e
        L_0x005d:
            r2 = r4
        L_0x005e:
            if (r2 == 0) goto L_0x0087
            if (r2 == r7) goto L_0x0087
            if (r2 == r10) goto L_0x006e
            if (r2 == r9) goto L_0x0087
            if (r2 == r8) goto L_0x006b
            if (r2 == r6) goto L_0x006b
            goto L_0x008e
        L_0x006b:
            int r2 = r0 * r1
            goto L_0x008a
        L_0x006e:
            java.lang.String r2 = "BRAVIA 4K 2015"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzaxb.zzd
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0079
            goto L_0x008e
        L_0x0079:
            r2 = 16
            int r5 = com.google.android.gms.internal.ads.zzaxb.zzd(r0, r2)
            int r2 = com.google.android.gms.internal.ads.zzaxb.zzd(r1, r2)
            int r5 = r5 * r2
            int r2 = r5 * 256
            goto L_0x0089
        L_0x0087:
            int r2 = r0 * r1
        L_0x0089:
            r8 = r10
        L_0x008a:
            int r2 = r2 * r9
            int r8 = r8 + r8
            int r2 = r2 / r8
            goto L_0x008f
        L_0x008e:
            r2 = r4
        L_0x008f:
            int r15 = r15.length
            com.google.android.gms.internal.ads.zzaxj r15 = new com.google.android.gms.internal.ads.zzaxj
            r15.<init>(r0, r1, r2)
            r11.zzh = r15
            boolean r0 = r11.zze
            android.media.MediaFormat r14 = r14.zzb()
            int r1 = r15.zza
            java.lang.String r2 = "max-width"
            r14.setInteger(r2, r1)
            java.lang.String r1 = "max-height"
            int r2 = r15.zzb
            r14.setInteger(r1, r2)
            int r15 = r15.zzc
            if (r15 == r4) goto L_0x00b4
            java.lang.String r1 = "max-input-size"
            r14.setInteger(r1, r15)
        L_0x00b4:
            if (r0 == 0) goto L_0x00bb
            java.lang.String r15 = "auto-frc"
            r14.setInteger(r15, r3)
        L_0x00bb:
            android.view.Surface r15 = r11.zzi
            if (r15 != 0) goto L_0x00da
            boolean r15 = r12.zzd
            boolean r15 = r11.zzag(r15)
            com.google.android.gms.internal.ads.zzawm.zze(r15)
            android.view.Surface r15 = r11.zzj
            if (r15 != 0) goto L_0x00d6
            android.content.Context r15 = r11.zzb
            boolean r12 = r12.zzd
            com.google.android.gms.internal.ads.zzaxh r12 = com.google.android.gms.internal.ads.zzaxh.zza(r15, r12)
            r11.zzj = r12
        L_0x00d6:
            android.view.Surface r12 = r11.zzj
            r11.zzi = r12
        L_0x00da:
            android.view.Surface r12 = r11.zzi
            r15 = 0
            r13.configure(r14, r12, r15, r3)
            int r12 = com.google.android.gms.internal.ads.zzaxb.zza
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxk.zzO(com.google.android.gms.internal.ads.zzatc, android.media.MediaCodec, com.google.android.gms.internal.ads.zzapg, android.media.MediaCrypto):void");
    }

    public final void zzP(String str, long j11, long j12) {
        this.zzd.zzb(str, j11, j12);
    }

    public final void zzQ(zzapg zzapg) throws zzaos {
        super.zzQ(zzapg);
        this.zzd.zzf(zzapg);
        float f11 = zzapg.zzn;
        if (f11 == -1.0f) {
            f11 = 1.0f;
        }
        this.zzq = f11;
        this.zzp = zzN(zzapg);
    }

    public final void zzR(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i11;
        int i12;
        boolean z11 = false;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z11 = true;
        }
        if (z11) {
            i11 = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i11 = mediaFormat.getInteger("width");
        }
        this.zzr = i11;
        if (z11) {
            i12 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i12 = mediaFormat.getInteger("height");
        }
        this.zzs = i12;
        float f11 = this.zzq;
        this.zzu = f11;
        if (zzaxb.zza >= 21) {
            int i13 = this.zzp;
            if (i13 == 90 || i13 == 270) {
                int i14 = this.zzr;
                this.zzr = i12;
                this.zzs = i14;
                this.zzu = 1.0f / f11;
            }
        } else {
            this.zzt = this.zzp;
        }
        mediaCodec.setVideoScalingMode(1);
    }

    public final boolean zzT(long j11, long j12, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i11, int i12, long j13, boolean z11) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i13 = i11;
        long j14 = j13;
        while (true) {
            int i14 = this.zzA;
            if (i14 == 0) {
                break;
            }
            long[] jArr = this.zzf;
            long j15 = jArr[0];
            if (j14 < j15) {
                break;
            }
            this.zzz = j15;
            int i15 = i14 - 1;
            this.zzA = i15;
            System.arraycopy(jArr, 1, jArr, 0, i15);
        }
        long j16 = j14 - this.zzz;
        if (z11) {
            zzL(mediaCodec2, i13, j16);
            return true;
        }
        long j17 = j14 - j11;
        if (this.zzi == this.zzj) {
            if (!zzaf(j17)) {
                return false;
            }
            zzL(mediaCodec2, i13, j16);
            return true;
        } else if (!this.zzk) {
            if (zzaxb.zza >= 21) {
                zzK(mediaCodec, i11, j16, System.nanoTime());
            } else {
                zzJ(mediaCodec2, i13, j16);
            }
            return true;
        } else if (zzb() != 2) {
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long nanoTime = System.nanoTime();
            long zza = this.zzc.zza(j14, ((j17 - ((elapsedRealtime * 1000) - j12)) * 1000) + nanoTime);
            long j18 = (zza - nanoTime) / 1000;
            if (zzaf(j18)) {
                zzawz.zza("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i13, false);
                zzawz.zzb();
                zzara zzara = this.zza;
                zzara.zzf++;
                this.zzn++;
                int i16 = this.zzo + 1;
                this.zzo = i16;
                zzara.zzg = Math.max(i16, zzara.zzg);
                if (this.zzn == -1) {
                    zzac();
                }
                return true;
            }
            if (zzaxb.zza >= 21) {
                if (j18 < 50000) {
                    zzK(mediaCodec, i11, j16, zza);
                    return true;
                }
            } else if (j18 < 30000) {
                if (j18 > 11000) {
                    try {
                        Thread.sleep((j18 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzJ(mediaCodec2, i13, j16);
                return true;
            }
            return false;
        }
    }

    public final void zzX(zzarb zzarb) {
        int i11 = zzaxb.zza;
    }

    public final void zzY() {
        try {
            super.zzY();
        } finally {
            Surface surface = this.zzj;
            if (surface != null) {
                if (this.zzi == surface) {
                    this.zzi = null;
                }
                surface.release();
                this.zzj = null;
            }
        }
    }

    public final boolean zzZ(MediaCodec mediaCodec, boolean z11, zzapg zzapg, zzapg zzapg2) {
        if (!zzapg.zzf.equals(zzapg2.zzf) || zzN(zzapg) != zzN(zzapg2)) {
            return false;
        }
        if (!z11 && (zzapg.zzj != zzapg2.zzj || zzapg.zzk != zzapg2.zzk)) {
            return false;
        }
        int i11 = zzapg2.zzj;
        zzaxj zzaxj = this.zzh;
        if (i11 > zzaxj.zza || zzapg2.zzk > zzaxj.zzb || zzapg2.zzg > zzaxj.zzc) {
            return false;
        }
        return true;
    }

    public final boolean zzaa(zzatc zzatc) {
        return this.zzi != null || zzag(zzatc.zzd);
    }

    public final void zzl(int i11, Object obj) throws zzaos {
        if (i11 == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzj;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzatc zzV = zzV();
                    if (zzV != null && zzag(zzV.zzd)) {
                        surface = zzaxh.zza(this.zzb, zzV.zzd);
                        this.zzj = surface;
                    }
                }
            }
            if (this.zzi != surface) {
                this.zzi = surface;
                int zzb2 = zzb();
                if (zzb2 == 1 || zzb2 == 2) {
                    MediaCodec zzU = zzU();
                    if (zzaxb.zza < 23 || zzU == null || surface == null) {
                        zzY();
                        zzW();
                    } else {
                        zzU.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzj) {
                    zzab();
                    this.zzk = false;
                    int i12 = zzaxb.zza;
                    return;
                }
                zzae();
                this.zzk = false;
                int i13 = zzaxb.zza;
                if (zzb2 == 2) {
                    this.zzl = C.TIME_UNSET;
                }
            } else if (surface != null && surface != this.zzj) {
                zzae();
                if (this.zzk) {
                    this.zzd.zzg(this.zzi);
                }
            }
        }
    }

    public final void zzn() {
        this.zzr = -1;
        this.zzs = -1;
        this.zzu = -1.0f;
        this.zzq = -1.0f;
        this.zzz = C.TIME_UNSET;
        this.zzA = 0;
        zzab();
        this.zzk = false;
        int i11 = zzaxb.zza;
        this.zzc.zzb();
        try {
            super.zzn();
        } finally {
            this.zza.zza();
            this.zzd.zzc(this.zza);
        }
    }

    public final void zzo(boolean z11) throws zzaos {
        super.zzo(z11);
        int i11 = zzg().zzb;
        this.zzd.zze(this.zza);
        this.zzc.zzc();
    }

    public final void zzp(long j11, boolean z11) throws zzaos {
        super.zzp(j11, z11);
        this.zzk = false;
        int i11 = zzaxb.zza;
        this.zzo = 0;
        int i12 = this.zzA;
        if (i12 != 0) {
            this.zzz = this.zzf[i12 - 1];
            this.zzA = 0;
        }
        this.zzl = C.TIME_UNSET;
    }

    public final void zzq() {
        this.zzn = 0;
        this.zzm = SystemClock.elapsedRealtime();
        this.zzl = C.TIME_UNSET;
    }

    public final void zzr() {
        zzac();
    }

    public final void zzs(zzapg[] zzapgArr, long j11) throws zzaos {
        this.zzg = zzapgArr;
        if (this.zzz == C.TIME_UNSET) {
            this.zzz = j11;
            return;
        }
        int i11 = this.zzA;
        if (i11 == 10) {
            long j12 = this.zzf[9];
            StringBuilder sb2 = new StringBuilder(65);
            sb2.append("Too many stream changes, so dropping offset: ");
            sb2.append(j12);
            Log.w("MediaCodecVideoRenderer", sb2.toString());
        } else {
            this.zzA = i11 + 1;
        }
        this.zzf[this.zzA - 1] = j11;
    }
}
