package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import net.bytebuddy.jar.asm.Opcodes;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzaqo {
    private Method zzA;
    private int zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private int zzI;
    private long zzJ;
    private long zzK;
    private long zzL;
    private float zzM;
    private zzapv[] zzN;
    private ByteBuffer[] zzO;
    private ByteBuffer zzP;
    private ByteBuffer zzQ;
    private byte[] zzR;
    private int zzS;
    private int zzT;
    private boolean zzU;
    private boolean zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private final zzaqp zza;
    private final zzaqv zzb;
    private final zzapv[] zzc;
    private final zzaqk zzd;
    /* access modifiers changed from: private */
    public final ConditionVariable zze = new ConditionVariable(true);
    private final long[] zzf;
    private final zzaqg zzg;
    private final LinkedList<zzaqm> zzh;
    private AudioTrack zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private int zzo;
    private long zzp;
    private zzapk zzq;
    private zzapk zzr;
    private long zzs;
    private long zzt;
    private int zzu;
    private int zzv;
    private long zzw;
    private long zzx;
    private boolean zzy;
    private long zzz;

    public zzaqo(zzapt zzapt, zzapv[] zzapvArr, zzaqk zzaqk) {
        this.zzd = zzaqk;
        if (zzaxb.zza >= 18) {
            try {
                this.zzA = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzaxb.zza >= 19) {
            this.zzg = new zzaqh();
        } else {
            this.zzg = new zzaqg((zzaqf) null);
        }
        zzaqp zzaqp = new zzaqp();
        this.zza = zzaqp;
        zzaqv zzaqv = new zzaqv();
        this.zzb = zzaqv;
        zzapv[] zzapvArr2 = new zzapv[3];
        this.zzc = zzapvArr2;
        zzapvArr2[0] = new zzaqt();
        zzapvArr2[1] = zzaqp;
        System.arraycopy(zzapvArr, 0, zzapvArr2, 2, 0);
        zzapvArr2[2] = zzaqv;
        this.zzf = new long[10];
        this.zzM = 1.0f;
        this.zzI = 0;
        this.zzW = 0;
        this.zzr = zzapk.zza;
        this.zzT = -1;
        this.zzN = new zzapv[0];
        this.zzO = new ByteBuffer[0];
        this.zzh = new LinkedList<>();
    }

    private final long zzp(long j11) {
        return (j11 * ((long) this.zzj)) / 1000000;
    }

    private final long zzq(long j11) {
        return (j11 * 1000000) / ((long) this.zzj);
    }

    private final long zzr() {
        return this.zzn ? this.zzG : this.zzF / ((long) this.zzE);
    }

    private final void zzs(long j11) throws zzaqn {
        ByteBuffer byteBuffer;
        int length = this.zzN.length;
        int i11 = length;
        while (i11 >= 0) {
            if (i11 > 0) {
                byteBuffer = this.zzO[i11 - 1];
            } else {
                byteBuffer = this.zzP;
                if (byteBuffer == null) {
                    byteBuffer = zzapv.zza;
                }
            }
            if (i11 == length) {
                zzz(byteBuffer, j11);
            } else {
                zzapv zzapv = this.zzN[i11];
                zzapv.zzf(byteBuffer);
                ByteBuffer zzc2 = zzapv.zzc();
                this.zzO[i11] = zzc2;
                if (zzc2.hasRemaining()) {
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

    private final void zzt() {
        ArrayList arrayList = new ArrayList();
        zzapv[] zzapvArr = this.zzc;
        for (int i11 = 0; i11 < 3; i11++) {
            zzapv zzapv = zzapvArr[i11];
            if (zzapv.zzi()) {
                arrayList.add(zzapv);
            } else {
                zzapv.zzd();
            }
        }
        int size = arrayList.size();
        this.zzN = (zzapv[]) arrayList.toArray(new zzapv[size]);
        this.zzO = new ByteBuffer[size];
        for (int i12 = 0; i12 < size; i12++) {
            zzapv zzapv2 = this.zzN[i12];
            zzapv2.zzd();
            this.zzO[i12] = zzapv2.zzc();
        }
    }

    private final void zzu() {
        this.zzw = 0;
        this.zzv = 0;
        this.zzu = 0;
        this.zzx = 0;
        this.zzy = false;
        this.zzz = 0;
    }

    private final void zzv() {
        if (zzx()) {
            if (zzaxb.zza >= 21) {
                this.zzi.setVolume(this.zzM);
                return;
            }
            AudioTrack audioTrack = this.zzi;
            float f11 = this.zzM;
            audioTrack.setStereoVolume(f11, f11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzw() throws com.google.android.gms.internal.ads.zzaqn {
        /*
            r9 = this;
            int r0 = r9.zzT
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L_0x0014
            boolean r0 = r9.zzn
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzapv[] r0 = r9.zzN
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = r2
        L_0x0010:
            r9.zzT = r0
        L_0x0012:
            r0 = r1
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            int r4 = r9.zzT
            com.google.android.gms.internal.ads.zzapv[] r5 = r9.zzN
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zze()
        L_0x0028:
            r9.zzs(r7)
            boolean r0 = r4.zzj()
            if (r0 != 0) goto L_0x0032
            return r2
        L_0x0032:
            int r0 = r9.zzT
            int r0 = r0 + r1
            r9.zzT = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzQ
            if (r0 == 0) goto L_0x0044
            r9.zzz(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzQ
            if (r0 == 0) goto L_0x0044
            return r2
        L_0x0044:
            r9.zzT = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqo.zzw():boolean");
    }

    private final boolean zzx() {
        return this.zzi != null;
    }

    private final boolean zzy() {
        if (zzaxb.zza >= 23) {
            return false;
        }
        int i11 = this.zzm;
        if (i11 != 5) {
            return i11 == 6;
        }
        return true;
    }

    private final boolean zzz(ByteBuffer byteBuffer, long j11) throws zzaqn {
        int i11;
        boolean z11;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.zzQ;
        if (byteBuffer2 != null) {
            if (byteBuffer2 == byteBuffer) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzawm.zzc(z11);
        } else {
            this.zzQ = byteBuffer;
            if (zzaxb.zza < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.zzR;
                if (bArr == null || bArr.length < remaining) {
                    this.zzR = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.zzR, 0, remaining);
                byteBuffer.position(position);
                this.zzS = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (zzaxb.zza < 21) {
            int zza2 = this.zzo - ((int) (this.zzF - (this.zzg.zza() * ((long) this.zzE))));
            if (zza2 > 0) {
                i11 = this.zzi.write(this.zzR, this.zzS, Math.min(remaining2, zza2));
                if (i11 > 0) {
                    this.zzS += i11;
                    byteBuffer.position(byteBuffer.position() + i11);
                }
            } else {
                i11 = 0;
            }
        } else {
            i11 = this.zzi.write(byteBuffer, remaining2, 1);
        }
        this.zzY = SystemClock.elapsedRealtime();
        if (i11 >= 0) {
            boolean z12 = this.zzn;
            if (!z12) {
                this.zzF += (long) i11;
            }
            if (i11 != remaining2) {
                return false;
            }
            if (z12) {
                this.zzG += (long) this.zzH;
            }
            this.zzQ = null;
            return true;
        }
        throw new zzaqn(i11);
    }

    public final long zza(boolean z11) {
        long j11;
        long j12;
        long j13;
        long j14;
        if (!zzx() || this.zzI == 0) {
            return Long.MIN_VALUE;
        }
        if (this.zzi.getPlayState() == 3) {
            long zzb2 = this.zzg.zzb();
            if (zzb2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzx >= 30000) {
                    long[] jArr = this.zzf;
                    int i11 = this.zzu;
                    jArr[i11] = zzb2 - nanoTime;
                    this.zzu = (i11 + 1) % 10;
                    int i12 = this.zzv;
                    if (i12 < 10) {
                        this.zzv = i12 + 1;
                    }
                    this.zzx = nanoTime;
                    this.zzw = 0;
                    int i13 = 0;
                    while (true) {
                        int i14 = this.zzv;
                        if (i13 >= i14) {
                            break;
                        }
                        this.zzw += this.zzf[i13] / ((long) i14);
                        i13++;
                    }
                }
                if (!zzy() && nanoTime - this.zzz >= 500000) {
                    boolean zzh2 = this.zzg.zzh();
                    this.zzy = zzh2;
                    if (zzh2) {
                        long zzd2 = this.zzg.zzd() / 1000;
                        long zzc2 = this.zzg.zzc();
                        if (zzd2 < this.zzK) {
                            this.zzy = false;
                        } else if (Math.abs(zzd2 - nanoTime) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(Opcodes.L2I);
                            sb2.append("Spurious audio timestamp (system clock mismatch): ");
                            sb2.append(zzc2);
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb2.append(zzd2);
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb2.append(nanoTime);
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb2.append(zzb2);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzy = false;
                        } else if (Math.abs(zzq(zzc2) - zzb2) > 5000000) {
                            StringBuilder sb3 = new StringBuilder(138);
                            sb3.append("Spurious audio timestamp (frame position mismatch): ");
                            sb3.append(zzc2);
                            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb3.append(zzd2);
                            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb3.append(nanoTime);
                            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                            sb3.append(zzb2);
                            Log.w("AudioTrack", sb3.toString());
                            this.zzy = false;
                        }
                    }
                    Method method = this.zzA;
                    if (method != null && !this.zzn) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.zzi, (Object[]) null)).intValue()) * 1000) - this.zzp;
                            this.zzL = intValue;
                            long max = Math.max(intValue, 0);
                            this.zzL = max;
                            if (max > 5000000) {
                                StringBuilder sb4 = new StringBuilder(61);
                                sb4.append("Ignoring impossibly large audio latency: ");
                                sb4.append(max);
                                Log.w("AudioTrack", sb4.toString());
                                this.zzL = 0;
                            }
                        } catch (Exception unused) {
                            this.zzA = null;
                        }
                    }
                    this.zzz = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzy) {
            j11 = zzq(this.zzg.zzc() + zzp(nanoTime2 - (this.zzg.zzd() / 1000)));
        } else {
            if (this.zzv == 0) {
                j11 = this.zzg.zzb();
            } else {
                j11 = nanoTime2 + this.zzw;
            }
            if (!z11) {
                j11 -= this.zzL;
            }
        }
        long j15 = this.zzJ;
        while (!this.zzh.isEmpty() && j11 >= this.zzh.getFirst().zzc) {
            zzaqm remove = this.zzh.remove();
            this.zzr = remove.zza;
            this.zzt = remove.zzc;
            this.zzs = remove.zzb - this.zzJ;
        }
        if (this.zzr.zzb == 1.0f) {
            j12 = (j11 + this.zzs) - this.zzt;
        } else {
            if (!this.zzh.isEmpty() || this.zzb.zzn() < 1024) {
                j13 = this.zzs;
                j14 = (long) (((double) this.zzr.zzb) * ((double) (j11 - this.zzt)));
            } else {
                j13 = this.zzs;
                j14 = zzaxb.zzj(j11 - this.zzt, this.zzb.zzm(), this.zzb.zzn());
            }
            j12 = j14 + j13;
        }
        return j15 + j12;
    }

    public final zzapk zzc() {
        return this.zzr;
    }

    public final zzapk zzd(zzapk zzapk) {
        if (this.zzn) {
            zzapk zzapk2 = zzapk.zza;
            this.zzr = zzapk2;
            return zzapk2;
        }
        float zzl2 = this.zzb.zzl(zzapk.zzb);
        this.zzb.zzk(1.0f);
        zzapk zzapk3 = new zzapk(zzl2, 1.0f);
        zzapk zzapk4 = this.zzq;
        if (zzapk4 == null) {
            if (!this.zzh.isEmpty()) {
                zzapk4 = this.zzh.getLast().zza;
            } else {
                zzapk4 = this.zzr;
            }
        }
        if (!zzapk3.equals(zzapk4)) {
            if (zzx()) {
                this.zzq = zzapk3;
            } else {
                this.zzr = zzapk3;
            }
        }
        return this.zzr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(java.lang.String r7, int r8, int r9, int r10, int r11, int[] r12) throws com.google.android.gms.internal.ads.zzaqi {
        /*
            r6 = this;
            int r7 = com.google.android.gms.internal.ads.zzaxb.zzi(r10, r8)
            r6.zzB = r7
            com.google.android.gms.internal.ads.zzaqp r7 = r6.zza
            r7.zzk(r12)
            com.google.android.gms.internal.ads.zzapv[] r7 = r6.zzc
            r11 = 0
            r12 = r11
            r0 = r12
        L_0x0010:
            r1 = 3
            r2 = 2
            if (r12 >= r1) goto L_0x0033
            r1 = r7[r12]
            boolean r3 = r1.zzh(r9, r8, r10)     // Catch:{ zzapu -> 0x002c }
            r0 = r0 | r3
            boolean r3 = r1.zzi()
            if (r3 == 0) goto L_0x0029
            int r8 = r1.zza()
            r1.zzb()
            r10 = r2
        L_0x0029:
            int r12 = r12 + 1
            goto L_0x0010
        L_0x002c:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzaqi r8 = new com.google.android.gms.internal.ads.zzaqi
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        L_0x0033:
            if (r0 == 0) goto L_0x0038
            r6.zzt()
        L_0x0038:
            r7 = 252(0xfc, float:3.53E-43)
            switch(r8) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0067;
                case 3: goto L_0x0064;
                case 4: goto L_0x0061;
                case 5: goto L_0x005e;
                case 6: goto L_0x005c;
                case 7: goto L_0x0059;
                case 8: goto L_0x0056;
                default: goto L_0x003d;
            }
        L_0x003d:
            com.google.android.gms.internal.ads.zzaqi r7 = new com.google.android.gms.internal.ads.zzaqi
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r10 = 38
            r9.<init>(r10)
            java.lang.String r10 = "Unsupported channel count: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x0056:
            int r12 = com.google.android.gms.internal.ads.zzaor.zza
            goto L_0x006b
        L_0x0059:
            r12 = 1276(0x4fc, float:1.788E-42)
            goto L_0x006b
        L_0x005c:
            r12 = r7
            goto L_0x006b
        L_0x005e:
            r12 = 220(0xdc, float:3.08E-43)
            goto L_0x006b
        L_0x0061:
            r12 = 204(0xcc, float:2.86E-43)
            goto L_0x006b
        L_0x0064:
            r12 = 28
            goto L_0x006b
        L_0x0067:
            r12 = 12
            goto L_0x006b
        L_0x006a:
            r12 = 4
        L_0x006b:
            int r3 = com.google.android.gms.internal.ads.zzaxb.zza
            r4 = 23
            if (r3 > r4) goto L_0x0091
            java.lang.String r4 = "foster"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzaxb.zzb
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0091
            java.lang.String r4 = "NVIDIA"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzaxb.zzc
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0091
            if (r8 == r1) goto L_0x0092
            r1 = 5
            if (r8 == r1) goto L_0x0092
            r7 = 7
            if (r8 == r7) goto L_0x008e
            goto L_0x0091
        L_0x008e:
            int r7 = com.google.android.gms.internal.ads.zzaor.zza
            goto L_0x0092
        L_0x0091:
            r7 = r12
        L_0x0092:
            r12 = 25
            if (r3 > r12) goto L_0x009e
            java.lang.String r12 = "fugu"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzaxb.zzb
            boolean r12 = r12.equals(r1)
        L_0x009e:
            if (r0 != 0) goto L_0x00b4
            boolean r12 = r6.zzx()
            if (r12 == 0) goto L_0x00b4
            int r12 = r6.zzl
            if (r12 != r10) goto L_0x00b4
            int r12 = r6.zzj
            if (r12 != r9) goto L_0x00b4
            int r12 = r6.zzk
            if (r12 == r7) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            return
        L_0x00b4:
            r6.zzk()
            r6.zzl = r10
            r6.zzn = r11
            r6.zzj = r9
            r6.zzk = r7
            r6.zzm = r2
            int r8 = com.google.android.gms.internal.ads.zzaxb.zzi(r2, r8)
            r6.zzE = r8
            int r8 = r6.zzm
            int r7 = android.media.AudioTrack.getMinBufferSize(r9, r7, r8)
            r8 = -2
            if (r7 == r8) goto L_0x00d1
            r11 = 1
        L_0x00d1:
            com.google.android.gms.internal.ads.zzawm.zze(r11)
            int r8 = r7 * 4
            r9 = 250000(0x3d090, double:1.235164E-318)
            long r9 = r6.zzp(r9)
            int r9 = (int) r9
            int r10 = r6.zzE
            int r9 = r9 * r10
            long r10 = (long) r7
            r0 = 750000(0xb71b0, double:3.70549E-318)
            long r0 = r6.zzp(r0)
            int r7 = r6.zzE
            long r2 = (long) r7
            long r0 = r0 * r2
            long r10 = java.lang.Math.max(r10, r0)
            int r7 = (int) r10
            if (r8 >= r9) goto L_0x00f6
            r8 = r9
            goto L_0x00f9
        L_0x00f6:
            if (r8 <= r7) goto L_0x00f9
            r8 = r7
        L_0x00f9:
            r6.zzo = r8
            int r7 = r6.zzE
            int r8 = r8 / r7
            long r7 = (long) r8
            long r7 = r6.zzq(r7)
            r6.zzp = r7
            com.google.android.gms.internal.ads.zzapk r7 = r6.zzr
            r6.zzd(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqo.zze(java.lang.String, int, int, int, int, int[]):void");
    }

    public final void zzf() {
        if (this.zzI == 1) {
            this.zzI = 2;
        }
    }

    public final void zzg() {
        this.zzV = false;
        if (zzx()) {
            zzu();
            this.zzg.zzf();
        }
    }

    public final void zzh() {
        this.zzV = true;
        if (zzx()) {
            this.zzK = System.nanoTime() / 1000;
            this.zzi.play();
        }
    }

    public final void zzi() throws zzaqn {
        if (!this.zzU && zzx() && zzw()) {
            this.zzg.zze(zzr());
            this.zzU = true;
        }
    }

    public final void zzj() {
        zzk();
        zzapv[] zzapvArr = this.zzc;
        for (int i11 = 0; i11 < 3; i11++) {
            zzapvArr[i11].zzg();
        }
        this.zzW = 0;
        this.zzV = false;
    }

    public final void zzk() {
        if (zzx()) {
            this.zzC = 0;
            this.zzD = 0;
            this.zzF = 0;
            this.zzG = 0;
            this.zzH = 0;
            zzapk zzapk = this.zzq;
            if (zzapk != null) {
                this.zzr = zzapk;
                this.zzq = null;
            } else if (!this.zzh.isEmpty()) {
                this.zzr = this.zzh.getLast().zza;
            }
            this.zzh.clear();
            this.zzs = 0;
            this.zzt = 0;
            this.zzP = null;
            this.zzQ = null;
            int i11 = 0;
            while (true) {
                zzapv[] zzapvArr = this.zzN;
                if (i11 >= zzapvArr.length) {
                    break;
                }
                zzapv zzapv = zzapvArr[i11];
                zzapv.zzd();
                this.zzO[i11] = zzapv.zzc();
                i11++;
            }
            this.zzU = false;
            this.zzT = -1;
            this.zzI = 0;
            this.zzL = 0;
            zzu();
            if (this.zzi.getPlayState() == 3) {
                this.zzi.pause();
            }
            AudioTrack audioTrack = this.zzi;
            this.zzi = null;
            this.zzg.zzg((AudioTrack) null, false);
            this.zze.close();
            new zzaqe(this, audioTrack).start();
        }
    }

    public final void zzl(float f11) {
        if (this.zzM != f11) {
            this.zzM = f11;
            zzv();
        }
    }

    public final boolean zzm(ByteBuffer byteBuffer, long j11) throws zzaqj, zzaqn {
        boolean z11;
        long j12;
        int i11;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j13 = j11;
        ByteBuffer byteBuffer3 = this.zzP;
        if (byteBuffer3 == null || byteBuffer2 == byteBuffer3) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zzc(z11);
        if (!zzx()) {
            this.zze.block();
            int i12 = this.zzW;
            if (i12 == 0) {
                this.zzi = new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1);
            } else {
                this.zzi = new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1, i12);
            }
            int state = this.zzi.getState();
            if (state == 1) {
                int audioSessionId = this.zzi.getAudioSessionId();
                if (this.zzW != audioSessionId) {
                    this.zzW = audioSessionId;
                    ((zzaqr) this.zzd).zza.zzb.zzb(audioSessionId);
                }
                this.zzg.zzg(this.zzi, zzy());
                zzv();
                this.zzX = false;
                if (this.zzV) {
                    zzh();
                }
            } else {
                try {
                    this.zzi.release();
                } catch (Exception unused) {
                } finally {
                    this.zzi = null;
                }
                throw new zzaqj(state, this.zzj, this.zzk, this.zzo);
            }
        }
        if (zzy()) {
            if (this.zzi.getPlayState() == 2) {
                this.zzX = false;
                return false;
            } else if (this.zzi.getPlayState() == 1 && this.zzg.zza() != 0) {
                return false;
            }
        }
        boolean z12 = this.zzX;
        boolean zzn2 = zzn();
        this.zzX = zzn2;
        if (z12 && !zzn2 && this.zzi.getPlayState() != 1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j14 = this.zzY;
            zzaqk zzaqk = this.zzd;
            int i13 = this.zzo;
            int i14 = i13;
            ((zzaqr) zzaqk).zza.zzb.zzc(i14, zzaor.zzb(this.zzp), elapsedRealtime - j14);
        }
        if (this.zzP == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzn && this.zzH == 0) {
                int i15 = this.zzm;
                if (i15 == 7 || i15 == 8) {
                    int position = byteBuffer.position();
                    i11 = ((((byteBuffer2.get(position + 5) & 252) >> 2) | ((byteBuffer2.get(position + 4) & 1) << 6)) + 1) * 32;
                } else if (i15 == 5) {
                    int i16 = zzaps.zza;
                    i11 = 1536;
                } else if (i15 == 6) {
                    i11 = zzaps.zza(byteBuffer);
                } else {
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Unexpected audio encoding: ");
                    sb2.append(i15);
                    throw new IllegalStateException(sb2.toString());
                }
                this.zzH = i11;
            }
            if (this.zzq != null) {
                if (!zzw()) {
                    return false;
                }
                this.zzh.add(new zzaqm(this.zzq, Math.max(0, j13), zzq(zzr()), (zzaql) null));
                this.zzq = null;
                zzt();
            }
            if (this.zzI == 0) {
                this.zzJ = Math.max(0, j13);
                this.zzI = 1;
            } else {
                long j15 = this.zzJ;
                if (this.zzn) {
                    j12 = this.zzD;
                } else {
                    j12 = this.zzC / ((long) this.zzB);
                }
                long zzq2 = j15 + zzq(j12);
                if (this.zzI == 1 && Math.abs(zzq2 - j13) > 200000) {
                    StringBuilder sb3 = new StringBuilder(80);
                    sb3.append("Discontinuity detected [expected ");
                    sb3.append(zzq2);
                    sb3.append(", got ");
                    sb3.append(j13);
                    sb3.append("]");
                    Log.e("AudioTrack", sb3.toString());
                    this.zzI = 2;
                }
                if (this.zzI == 2) {
                    this.zzJ += j13 - zzq2;
                    this.zzI = 1;
                    ((zzaqr) this.zzd).zza.zzh = true;
                }
            }
            if (this.zzn) {
                this.zzD += (long) this.zzH;
            } else {
                this.zzC += (long) byteBuffer.remaining();
            }
            this.zzP = byteBuffer2;
        }
        if (this.zzn) {
            zzz(this.zzP, j13);
        } else {
            zzs(j13);
        }
        if (this.zzP.hasRemaining()) {
            return false;
        }
        this.zzP = null;
        return true;
    }

    public final boolean zzn() {
        if (!zzx()) {
            return false;
        }
        if (zzr() > this.zzg.zza()) {
            return true;
        }
        if (zzy() && this.zzi.getPlayState() == 2 && this.zzi.getPlaybackHeadPosition() == 0) {
            return true;
        }
        return false;
    }

    public final boolean zzo() {
        if (!zzx()) {
            return true;
        }
        if (this.zzU) {
            return !zzn();
        }
        return false;
    }
}
