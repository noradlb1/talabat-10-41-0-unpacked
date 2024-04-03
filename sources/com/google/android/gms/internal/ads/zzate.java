package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(19)
@TargetApi(19)
public abstract class zzate extends zzaoq {
    private static final byte[] zzb = zzaxb.zzp("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private boolean zzA;
    private int zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    protected zzara zza;
    private final zzatg zzc;
    private final zzarb zzd;
    private final zzarb zze;
    private final zzaph zzf;
    private final List<Long> zzg;
    private final MediaCodec.BufferInfo zzh;
    private zzapg zzi;
    private MediaCodec zzj;
    private zzatc zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private ByteBuffer[] zzu;
    private ByteBuffer[] zzv;
    private long zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    public zzate(int i11, zzatg zzatg, zzarg zzarg, boolean z11) {
        super(i11);
        boolean z12;
        if (zzaxb.zza >= 16) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzawm.zze(z12);
        this.zzc = zzatg;
        this.zzd = new zzarb(0);
        this.zze = new zzarb(0);
        this.zzf = new zzaph();
        this.zzg = new ArrayList();
        this.zzh = new MediaCodec.BufferInfo();
        this.zzB = 0;
        this.zzC = 0;
    }

    private final void zzI() throws zzaos {
        if (this.zzC == 2) {
            zzY();
            zzW();
            return;
        }
        this.zzG = true;
        zzS();
    }

    private final boolean zzJ() throws zzaos {
        MediaCodec mediaCodec = this.zzj;
        if (mediaCodec == null || this.zzC == 2 || this.zzF) {
            return false;
        }
        if (this.zzx < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0);
            this.zzx = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            zzarb zzarb = this.zzd;
            zzarb.zzb = this.zzu[dequeueInputBuffer];
            zzarb.zzb();
        }
        if (this.zzC == 1) {
            if (!this.zzo) {
                this.zzE = true;
                this.zzj.queueInputBuffer(this.zzx, 0, 0, 0, 4);
                this.zzx = -1;
            }
            this.zzC = 2;
            return false;
        } else if (this.zzs) {
            this.zzs = false;
            ByteBuffer byteBuffer = this.zzd.zzb;
            byte[] bArr = zzb;
            byteBuffer.put(bArr);
            MediaCodec mediaCodec2 = this.zzj;
            int i11 = this.zzx;
            int length = bArr.length;
            mediaCodec2.queueInputBuffer(i11, 0, 38, 0, 0);
            this.zzx = -1;
            this.zzD = true;
            return true;
        } else {
            if (this.zzB == 1) {
                for (int i12 = 0; i12 < this.zzi.zzh.size(); i12++) {
                    this.zzd.zzb.put(this.zzi.zzh.get(i12));
                }
                this.zzB = 2;
            }
            int position = this.zzd.zzb.position();
            int zzd2 = zzd(this.zzf, this.zzd, false);
            if (zzd2 == -3) {
                return false;
            }
            if (zzd2 == -5) {
                if (this.zzB == 2) {
                    this.zzd.zzb();
                    this.zzB = 1;
                }
                zzQ(this.zzf.zza);
                return true;
            } else if (this.zzd.zzf()) {
                if (this.zzB == 2) {
                    this.zzd.zzb();
                    this.zzB = 1;
                }
                this.zzF = true;
                if (!this.zzD) {
                    zzI();
                    return false;
                }
                try {
                    if (!this.zzo) {
                        this.zzE = true;
                        this.zzj.queueInputBuffer(this.zzx, 0, 0, 0, 4);
                        this.zzx = -1;
                    }
                    return false;
                } catch (MediaCodec.CryptoException e11) {
                    throw zzaos.zza(e11, zza());
                }
            } else if (!this.zzH || this.zzd.zzg()) {
                this.zzH = false;
                boolean zzi2 = this.zzd.zzi();
                if (this.zzl && !zzi2) {
                    ByteBuffer byteBuffer2 = this.zzd.zzb;
                    byte[] bArr2 = zzaws.zza;
                    int position2 = byteBuffer2.position();
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        int i15 = i13 + 1;
                        if (i15 >= position2) {
                            byteBuffer2.clear();
                            break;
                        }
                        byte b11 = byteBuffer2.get(i13) & 255;
                        if (i14 == 3) {
                            if (b11 == 1) {
                                if ((byteBuffer2.get(i15) & Ascii.US) == 7) {
                                    ByteBuffer duplicate = byteBuffer2.duplicate();
                                    duplicate.position(i13 - 3);
                                    duplicate.limit(position2);
                                    byteBuffer2.position(0);
                                    byteBuffer2.put(duplicate);
                                    break;
                                }
                                b11 = 1;
                            }
                        } else if (b11 == 0) {
                            i14++;
                        }
                        if (b11 != 0) {
                            i14 = 0;
                        }
                        i13 = i15;
                    }
                    if (this.zzd.zzb.position() == 0) {
                        return true;
                    }
                    this.zzl = false;
                }
                try {
                    zzarb zzarb2 = this.zzd;
                    long j11 = zzarb2.zzc;
                    if (zzarb2.zze()) {
                        this.zzg.add(Long.valueOf(j11));
                    }
                    this.zzd.zzb.flip();
                    zzX(this.zzd);
                    if (zzi2) {
                        MediaCodec.CryptoInfo zza2 = this.zzd.zza.zza();
                        if (position != 0) {
                            if (zza2.numBytesOfClearData == null) {
                                zza2.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = zza2.numBytesOfClearData;
                            iArr[0] = iArr[0] + position;
                        }
                        this.zzj.queueSecureInputBuffer(this.zzx, 0, zza2, j11, 0);
                    } else {
                        this.zzj.queueInputBuffer(this.zzx, 0, this.zzd.zzb.limit(), j11, 0);
                    }
                    this.zzx = -1;
                    this.zzD = true;
                    this.zzB = 0;
                    this.zza.zzc++;
                    return true;
                } catch (MediaCodec.CryptoException e12) {
                    throw zzaos.zza(e12, zza());
                }
            } else {
                this.zzd.zzb();
                if (this.zzB == 2) {
                    this.zzB = 1;
                }
                return true;
            }
        }
    }

    public final void zzD(long j11, long j12) throws zzaos {
        boolean z11;
        int i11;
        boolean z12;
        if (this.zzG) {
            zzS();
            return;
        }
        if (this.zzi == null) {
            this.zze.zzb();
            int zzd2 = zzd(this.zzf, this.zze, true);
            if (zzd2 == -5) {
                zzQ(this.zzf.zza);
            } else if (zzd2 == -4) {
                zzawm.zze(this.zze.zzf());
                this.zzF = true;
                zzI();
                return;
            } else {
                return;
            }
        }
        zzW();
        if (this.zzj != null) {
            zzawz.zza("drainAndFeed");
            while (true) {
                if (this.zzy < 0) {
                    if (!this.zzq || !this.zzE) {
                        i11 = this.zzj.dequeueOutputBuffer(this.zzh, 0);
                        this.zzy = i11;
                    } else {
                        try {
                            i11 = this.zzj.dequeueOutputBuffer(this.zzh, 0);
                            this.zzy = i11;
                        } catch (IllegalStateException unused) {
                            zzI();
                            if (this.zzG) {
                                zzY();
                            }
                        }
                    }
                    if (i11 >= 0) {
                        if (this.zzt) {
                            this.zzt = false;
                            this.zzj.releaseOutputBuffer(i11, false);
                            this.zzy = -1;
                        } else {
                            MediaCodec.BufferInfo bufferInfo = this.zzh;
                            if ((bufferInfo.flags & 4) != 0) {
                                zzI();
                                this.zzy = -1;
                                break;
                            }
                            ByteBuffer byteBuffer = this.zzv[this.zzy];
                            if (byteBuffer != null) {
                                byteBuffer.position(bufferInfo.offset);
                                MediaCodec.BufferInfo bufferInfo2 = this.zzh;
                                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                            }
                            long j13 = this.zzh.presentationTimeUs;
                            int size = this.zzg.size();
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size) {
                                    z12 = false;
                                    break;
                                } else if (this.zzg.get(i12).longValue() == j13) {
                                    this.zzg.remove(i12);
                                    z12 = true;
                                    break;
                                } else {
                                    i12++;
                                }
                            }
                            this.zzz = z12;
                        }
                    } else if (i11 == -2) {
                        MediaFormat outputFormat = this.zzj.getOutputFormat();
                        if (this.zzn && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                            this.zzt = true;
                        } else {
                            if (this.zzr) {
                                outputFormat.setInteger("channel-count", 1);
                            }
                            zzR(this.zzj, outputFormat);
                        }
                    } else if (i11 == -3) {
                        this.zzv = this.zzj.getOutputBuffers();
                    } else if (this.zzo && (this.zzF || this.zzC == 2)) {
                        zzI();
                    }
                }
                if (!this.zzq || !this.zzE) {
                    MediaCodec mediaCodec = this.zzj;
                    ByteBuffer[] byteBufferArr = this.zzv;
                    int i13 = this.zzy;
                    ByteBuffer byteBuffer2 = byteBufferArr[i13];
                    MediaCodec.BufferInfo bufferInfo3 = this.zzh;
                    z11 = zzT(j11, j12, mediaCodec, byteBuffer2, i13, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.zzz);
                } else {
                    try {
                        MediaCodec mediaCodec2 = this.zzj;
                        ByteBuffer[] byteBufferArr2 = this.zzv;
                        int i14 = this.zzy;
                        ByteBuffer byteBuffer3 = byteBufferArr2[i14];
                        MediaCodec.BufferInfo bufferInfo4 = this.zzh;
                        z11 = zzT(j11, j12, mediaCodec2, byteBuffer3, i14, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.zzz);
                    } catch (IllegalStateException unused2) {
                        zzI();
                        if (this.zzG) {
                            zzY();
                        }
                    }
                }
                if (!z11) {
                    break;
                }
                long j14 = this.zzh.presentationTimeUs;
                this.zzy = -1;
            }
            do {
            } while (zzJ());
            zzawz.zzb();
        } else {
            zzx(j11);
            this.zze.zzb();
            int zzd3 = zzd(this.zzf, this.zze, false);
            if (zzd3 == -5) {
                zzQ(this.zzf.zza);
            } else if (zzd3 == -4) {
                zzawm.zze(this.zze.zzf());
                this.zzF = true;
                zzI();
            }
        }
        this.zza.zza();
    }

    public boolean zzE() {
        return this.zzG;
    }

    public boolean zzF() {
        if (this.zzi == null) {
            return false;
        }
        if (zzC() || this.zzy >= 0) {
            return true;
        }
        if (this.zzw == C.TIME_UNSET || SystemClock.elapsedRealtime() >= this.zzw) {
            return false;
        }
        return true;
    }

    public final int zzG(zzapg zzapg) throws zzaos {
        try {
            return zzH(this.zzc, zzapg);
        } catch (zzatj e11) {
            throw zzaos.zza(e11, zza());
        }
    }

    public abstract int zzH(zzatg zzatg, zzapg zzapg) throws zzatj;

    public zzatc zzM(zzatg zzatg, zzapg zzapg, boolean z11) throws zzatj {
        return zzato.zzc(zzapg.zzf, false);
    }

    public abstract void zzO(zzatc zzatc, MediaCodec mediaCodec, zzapg zzapg, MediaCrypto mediaCrypto) throws zzatj;

    public void zzP(String str, long j11, long j12) {
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r6.zzk == r0.zzk) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzQ(com.google.android.gms.internal.ads.zzapg r6) throws com.google.android.gms.internal.ads.zzaos {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzapg r0 = r5.zzi
            r5.zzi = r6
            com.google.android.gms.internal.ads.zzarf r6 = r6.zzi
            if (r0 != 0) goto L_0x000a
            r1 = 0
            goto L_0x000c
        L_0x000a:
            com.google.android.gms.internal.ads.zzarf r1 = r0.zzi
        L_0x000c:
            boolean r6 = com.google.android.gms.internal.ads.zzaxb.zzo(r6, r1)
            if (r6 != 0) goto L_0x0029
            com.google.android.gms.internal.ads.zzapg r6 = r5.zzi
            com.google.android.gms.internal.ads.zzarf r6 = r6.zzi
            if (r6 != 0) goto L_0x0019
            goto L_0x0029
        L_0x0019:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r6.<init>(r0)
            int r0 = r5.zza()
            com.google.android.gms.internal.ads.zzaos r6 = com.google.android.gms.internal.ads.zzaos.zza(r6, r0)
            throw r6
        L_0x0029:
            android.media.MediaCodec r6 = r5.zzj
            r1 = 1
            if (r6 == 0) goto L_0x0056
            com.google.android.gms.internal.ads.zzatc r2 = r5.zzk
            boolean r2 = r2.zzb
            com.google.android.gms.internal.ads.zzapg r3 = r5.zzi
            boolean r6 = r5.zzZ(r6, r2, r0, r3)
            if (r6 == 0) goto L_0x0056
            r5.zzA = r1
            r5.zzB = r1
            boolean r6 = r5.zzn
            r2 = 0
            if (r6 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzapg r6 = r5.zzi
            int r3 = r6.zzj
            int r4 = r0.zzj
            if (r3 != r4) goto L_0x0052
            int r6 = r6.zzk
            int r0 = r0.zzk
            if (r6 != r0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r1 = r2
        L_0x0053:
            r5.zzs = r1
            return
        L_0x0056:
            boolean r6 = r5.zzD
            if (r6 == 0) goto L_0x005d
            r5.zzC = r1
            return
        L_0x005d:
            r5.zzY()
            r5.zzW()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzate.zzQ(com.google.android.gms.internal.ads.zzapg):void");
    }

    public void zzR(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzaos {
        throw null;
    }

    public void zzS() throws zzaos {
    }

    public abstract boolean zzT(long j11, long j12, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i11, int i12, long j13, boolean z11) throws zzaos;

    public final MediaCodec zzU() {
        return this.zzj;
    }

    public final zzatc zzV() {
        return this.zzk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015c A[Catch:{ Exception -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0161 A[Catch:{ Exception -> 0x01d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzW() throws com.google.android.gms.internal.ads.zzaos {
        /*
            r11 = this;
            android.media.MediaCodec r0 = r11.zzj
            if (r0 != 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzapg r0 = r11.zzi
            if (r0 != 0) goto L_0x000a
            goto L_0x01e2
        L_0x000a:
            com.google.android.gms.internal.ads.zzatc r1 = r11.zzk
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzatg r1 = r11.zzc     // Catch:{ zzatj -> 0x002e }
            com.google.android.gms.internal.ads.zzatc r1 = r11.zzM(r1, r0, r3)     // Catch:{ zzatj -> 0x002e }
            r11.zzk = r1     // Catch:{ zzatj -> 0x002e }
            if (r1 == 0) goto L_0x001b
            goto L_0x0042
        L_0x001b:
            com.google.android.gms.internal.ads.zzatd r0 = new com.google.android.gms.internal.ads.zzatd
            com.google.android.gms.internal.ads.zzapg r1 = r11.zzi
            r4 = -49999(0xffffffffffff3cb1, float:NaN)
            r0.<init>((com.google.android.gms.internal.ads.zzapg) r1, (java.lang.Throwable) r2, (boolean) r3, (int) r4)
            int r1 = r11.zza()
            com.google.android.gms.internal.ads.zzaos r0 = com.google.android.gms.internal.ads.zzaos.zza(r0, r1)
            throw r0
        L_0x002e:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzatd r1 = new com.google.android.gms.internal.ads.zzatd
            com.google.android.gms.internal.ads.zzapg r2 = r11.zzi
            r4 = -49998(0xffffffffffff3cb2, float:NaN)
            r1.<init>((com.google.android.gms.internal.ads.zzapg) r2, (java.lang.Throwable) r0, (boolean) r3, (int) r4)
            int r0 = r11.zza()
            com.google.android.gms.internal.ads.zzaos r0 = com.google.android.gms.internal.ads.zzaos.zza(r1, r0)
            throw r0
        L_0x0042:
            boolean r0 = r11.zzaa(r1)
            if (r0 != 0) goto L_0x0049
            return
        L_0x0049:
            com.google.android.gms.internal.ads.zzatc r0 = r11.zzk
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.ads.zzapg r1 = r11.zzi
            int r4 = com.google.android.gms.internal.ads.zzaxb.zza
            r5 = 21
            r10 = 1
            if (r4 >= r5) goto L_0x0068
            java.util.List<byte[]> r1 = r1.zzh
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0068
            r1 = r10
            goto L_0x0069
        L_0x0068:
            r1 = r3
        L_0x0069:
            r11.zzl = r1
            r1 = 19
            r6 = 18
            if (r4 < r6) goto L_0x00a2
            if (r4 != r6) goto L_0x0083
            java.lang.String r7 = "OMX.SEC.avc.dec"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00a2
            java.lang.String r7 = "OMX.SEC.avc.dec.secure"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00a2
        L_0x0083:
            if (r4 != r1) goto L_0x00a0
            java.lang.String r7 = com.google.android.gms.internal.ads.zzaxb.zzd
            java.lang.String r8 = "SM-G800"
            boolean r7 = r7.startsWith(r8)
            if (r7 == 0) goto L_0x00a0
            java.lang.String r7 = "OMX.Exynos.avc.dec"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00a2
            java.lang.String r7 = "OMX.Exynos.avc.dec.secure"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r7 = r3
            goto L_0x00a3
        L_0x00a2:
            r7 = r10
        L_0x00a3:
            r11.zzm = r7
            r7 = 24
            if (r4 >= r7) goto L_0x00dd
            java.lang.String r7 = "OMX.Nvidia.h264.decode"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00b9
            java.lang.String r7 = "OMX.Nvidia.h264.decode.secure"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00dd
        L_0x00b9:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzaxb.zzb
            java.lang.String r8 = "flounder"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x00db
            java.lang.String r8 = "flounder_lte"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x00db
            java.lang.String r8 = "grouper"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x00db
            java.lang.String r8 = "tilapia"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x00dd
        L_0x00db:
            r7 = r10
            goto L_0x00de
        L_0x00dd:
            r7 = r3
        L_0x00de:
            r11.zzn = r7
            r7 = 17
            if (r4 > r7) goto L_0x00f6
            java.lang.String r7 = "OMX.rk.video_decoder.avc"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00f4
            java.lang.String r7 = "OMX.allwinner.video.decoder.avc"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00f6
        L_0x00f4:
            r7 = r10
            goto L_0x00f7
        L_0x00f6:
            r7 = r3
        L_0x00f7:
            r11.zzo = r7
            r7 = 23
            if (r4 > r7) goto L_0x0108
            java.lang.String r7 = "OMX.google.vorbis.decoder"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0106
            goto L_0x0108
        L_0x0106:
            r1 = r10
            goto L_0x0126
        L_0x0108:
            if (r4 > r1) goto L_0x0125
            java.lang.String r1 = "hb2000"
            java.lang.String r7 = com.google.android.gms.internal.ads.zzaxb.zzb
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x0125
            java.lang.String r1 = "OMX.amlogic.avc.decoder.awesome"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0106
            java.lang.String r1 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0125
            goto L_0x0106
        L_0x0125:
            r1 = r3
        L_0x0126:
            r11.zzp = r1
            if (r4 != r5) goto L_0x0134
            java.lang.String r1 = "OMX.google.aac.decoder"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0134
            r1 = r10
            goto L_0x0135
        L_0x0134:
            r1 = r3
        L_0x0135:
            r11.zzq = r1
            com.google.android.gms.internal.ads.zzapg r1 = r11.zzi
            if (r4 > r6) goto L_0x0149
            int r1 = r1.zzr
            if (r1 != r10) goto L_0x0149
            java.lang.String r1 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0149
            r1 = r10
            goto L_0x014a
        L_0x0149:
            r1 = r3
        L_0x014a:
            r11.zzr = r1
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r1 = "createCodec:"
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x01d1 }
            int r7 = r6.length()     // Catch:{ Exception -> 0x01d1 }
            if (r7 == 0) goto L_0x0161
            java.lang.String r1 = r1.concat(r6)     // Catch:{ Exception -> 0x01d1 }
            goto L_0x0167
        L_0x0161:
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x01d1 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x01d1 }
            r1 = r6
        L_0x0167:
            com.google.android.gms.internal.ads.zzawz.zza(r1)     // Catch:{ Exception -> 0x01d1 }
            android.media.MediaCodec r1 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x01d1 }
            r11.zzj = r1     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzawz.zzb()     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r1 = "configureCodec"
            com.google.android.gms.internal.ads.zzawz.zza(r1)     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzatc r1 = r11.zzk     // Catch:{ Exception -> 0x01d1 }
            android.media.MediaCodec r6 = r11.zzj     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzapg r7 = r11.zzi     // Catch:{ Exception -> 0x01d1 }
            r11.zzO(r1, r6, r7, r2)     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzawz.zzb()     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r1 = "startCodec"
            com.google.android.gms.internal.ads.zzawz.zza(r1)     // Catch:{ Exception -> 0x01d1 }
            android.media.MediaCodec r1 = r11.zzj     // Catch:{ Exception -> 0x01d1 }
            r1.start()     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzawz.zzb()     // Catch:{ Exception -> 0x01d1 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01d1 }
            long r8 = r6 - r4
            r4 = r11
            r5 = r0
            r4.zzP(r5, r6, r8)     // Catch:{ Exception -> 0x01d1 }
            android.media.MediaCodec r1 = r11.zzj     // Catch:{ Exception -> 0x01d1 }
            java.nio.ByteBuffer[] r1 = r1.getInputBuffers()     // Catch:{ Exception -> 0x01d1 }
            r11.zzu = r1     // Catch:{ Exception -> 0x01d1 }
            android.media.MediaCodec r1 = r11.zzj     // Catch:{ Exception -> 0x01d1 }
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()     // Catch:{ Exception -> 0x01d1 }
            r11.zzv = r1     // Catch:{ Exception -> 0x01d1 }
            int r0 = r11.zzb()
            r1 = 2
            if (r0 != r1) goto L_0x01bb
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r2
            goto L_0x01c0
        L_0x01bb:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x01c0:
            r11.zzw = r0
            r0 = -1
            r11.zzx = r0
            r11.zzy = r0
            r11.zzH = r10
            com.google.android.gms.internal.ads.zzara r0 = r11.zza
            int r1 = r0.zza
            int r1 = r1 + r10
            r0.zza = r1
            return
        L_0x01d1:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzatd r2 = new com.google.android.gms.internal.ads.zzatd
            com.google.android.gms.internal.ads.zzapg r4 = r11.zzi
            r2.<init>((com.google.android.gms.internal.ads.zzapg) r4, (java.lang.Throwable) r1, (boolean) r3, (java.lang.String) r0)
            int r0 = r11.zza()
            com.google.android.gms.internal.ads.zzaos r0 = com.google.android.gms.internal.ads.zzaos.zza(r2, r0)
            throw r0
        L_0x01e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzate.zzW():void");
    }

    public void zzX(zzarb zzarb) {
    }

    public void zzY() {
        this.zzw = C.TIME_UNSET;
        this.zzx = -1;
        this.zzy = -1;
        this.zzz = false;
        this.zzg.clear();
        this.zzu = null;
        this.zzv = null;
        this.zzk = null;
        this.zzA = false;
        this.zzD = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = false;
        this.zzp = false;
        this.zzr = false;
        this.zzs = false;
        this.zzt = false;
        this.zzE = false;
        this.zzB = 0;
        this.zzC = 0;
        this.zzd.zzb = null;
        MediaCodec mediaCodec = this.zzj;
        if (mediaCodec != null) {
            this.zza.zzb++;
            try {
                mediaCodec.stop();
                try {
                    this.zzj.release();
                } finally {
                    this.zzj = null;
                }
            } catch (Throwable th2) {
                this.zzj.release();
                throw th2;
            } finally {
                this.zzj = null;
            }
        }
    }

    public boolean zzZ(MediaCodec mediaCodec, boolean z11, zzapg zzapg, zzapg zzapg2) {
        return false;
    }

    public boolean zzaa(zzatc zzatc) {
        return true;
    }

    public final int zze() {
        return 4;
    }

    public void zzn() {
        this.zzi = null;
        zzY();
    }

    public void zzo(boolean z11) throws zzaos {
        this.zza = new zzara();
    }

    public void zzp(long j11, boolean z11) throws zzaos {
        this.zzF = false;
        this.zzG = false;
        if (this.zzj != null) {
            this.zzw = C.TIME_UNSET;
            this.zzx = -1;
            this.zzy = -1;
            this.zzH = true;
            this.zzz = false;
            this.zzg.clear();
            this.zzs = false;
            this.zzt = false;
            if (this.zzm || (this.zzp && this.zzE)) {
                zzY();
                zzW();
            } else if (this.zzC != 0) {
                zzY();
                zzW();
            } else {
                this.zzj.flush();
                this.zzD = false;
            }
            if (this.zzA && this.zzi != null) {
                this.zzB = 1;
            }
        }
    }
}
