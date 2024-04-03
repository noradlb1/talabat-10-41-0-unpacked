package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzaay implements zzwp {
    public static final zzww zza = zzaas.zza;
    private static final byte[] zzb = {TarConstants.LF_LINK, 10, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 32, 45, 45, 62, 32, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 10};
    /* access modifiers changed from: private */
    public static final byte[] zzc = zzfn.zzW("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] zzd = {68, 105, 97, 108, 111, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 117, 101, 58, 32, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44};
    /* access modifiers changed from: private */
    public static final UUID zze = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */
    public static final Map<String, Integer> zzf;
    private boolean zzA;
    private int zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    @Nullable
    private zzeq zzH;
    @Nullable
    private zzeq zzI;
    private boolean zzJ;
    private boolean zzK;
    private int zzL;
    private long zzM;
    private long zzN;
    private int zzO;
    private int zzP;
    private int[] zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private boolean zzV;
    private int zzW;
    private int zzX;
    private int zzY;
    private boolean zzZ;
    private boolean zzaa;
    private boolean zzab;
    private int zzac;
    private byte zzad;
    private boolean zzae;
    private zzws zzaf;
    private final zzaaq zzag;
    private final zzaba zzg;
    private final SparseArray<zzaaw> zzh;
    private final boolean zzi;
    private final zzfd zzj;
    private final zzfd zzk;
    private final zzfd zzl;
    private final zzfd zzm;
    private final zzfd zzn;
    private final zzfd zzo;
    private final zzfd zzp;
    private final zzfd zzq;
    private final zzfd zzr;
    private final zzfd zzs;
    private ByteBuffer zzt;
    private long zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    @Nullable
    private zzaaw zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(hashMap);
    }

    public zzaay() {
        this(0);
    }

    @CallSuper
    public static final int zzn(int i11) {
        switch (i11) {
            case 131:
            case Opcodes.L2I:
            case 155:
            case Opcodes.IF_ICMPEQ:
            case Opcodes.ARETURN:
            case Opcodes.PUTSTATIC:
            case Opcodes.INVOKEDYNAMIC:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
            case 21358:
            case 2274716:
                return 3;
            case Opcodes.IF_ICMPNE:
            case Opcodes.IF_ACMPNE:
            case Opcodes.FRETURN:
            case Opcodes.INVOKESPECIAL:
            case Opcodes.NEW:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case Opcodes.IF_ICMPLT:
            case Opcodes.IF_ICMPGT:
            case Opcodes.IF_ACMPEQ:
            case TarArchiveEntry.DEFAULT_DIR_MODE:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case Opcodes.PUTFIELD:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    @CallSuper
    public static final boolean zzo(int i11) {
        return i11 == 357149030 || i11 == 524531317 || i11 == 475249515 || i11 == 374648427;
    }

    @RequiresNonNull({"#2.output"})
    private final int zzp(zzwq zzwq, zzaaw zzaaw, int i11) throws IOException {
        int i12;
        if ("S_TEXT/UTF8".equals(zzaaw.zzb)) {
            zzx(zzwq, zzb, i11);
            int i13 = this.zzX;
            zzw();
            return i13;
        } else if ("S_TEXT/ASS".equals(zzaaw.zzb)) {
            zzx(zzwq, zzd, i11);
            int i14 = this.zzX;
            zzw();
            return i14;
        } else {
            zzxt zzxt = zzaaw.zzV;
            boolean z11 = true;
            if (!this.zzZ) {
                if (zzaaw.zzg) {
                    this.zzT &= -1073741825;
                    int i15 = 128;
                    if (!this.zzaa) {
                        ((zzwk) zzwq).zzn(this.zzl.zzH(), 0, 1, false);
                        this.zzW++;
                        if ((this.zzl.zzH()[0] & 128) != 128) {
                            this.zzad = this.zzl.zzH()[0];
                            this.zzaa = true;
                        } else {
                            throw zzbj.zza("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b11 = this.zzad;
                    if ((b11 & 1) == 1) {
                        byte b12 = b11 & 2;
                        this.zzT |= 1073741824;
                        if (!this.zzae) {
                            ((zzwk) zzwq).zzn(this.zzq.zzH(), 0, 8, false);
                            this.zzW += 8;
                            this.zzae = true;
                            byte[] zzH2 = this.zzl.zzH();
                            if (b12 != 2) {
                                i15 = 0;
                            }
                            zzH2[0] = (byte) (i15 | 8);
                            this.zzl.zzF(0);
                            zzxt.zzr(this.zzl, 1, 1);
                            this.zzX++;
                            this.zzq.zzF(0);
                            zzxt.zzr(this.zzq, 8, 1);
                            this.zzX += 8;
                        }
                        if (b12 == 2) {
                            if (!this.zzab) {
                                ((zzwk) zzwq).zzn(this.zzl.zzH(), 0, 1, false);
                                this.zzW++;
                                this.zzl.zzF(0);
                                this.zzac = this.zzl.zzk();
                                this.zzab = true;
                            }
                            int i16 = this.zzac * 4;
                            this.zzl.zzC(i16);
                            ((zzwk) zzwq).zzn(this.zzl.zzH(), 0, i16, false);
                            this.zzW += i16;
                            int i17 = (this.zzac >> 1) + 1;
                            int i18 = (i17 * 6) + 2;
                            ByteBuffer byteBuffer = this.zzt;
                            if (byteBuffer == null || byteBuffer.capacity() < i18) {
                                this.zzt = ByteBuffer.allocate(i18);
                            }
                            this.zzt.position(0);
                            this.zzt.putShort((short) i17);
                            int i19 = 0;
                            int i21 = 0;
                            while (true) {
                                i12 = this.zzac;
                                if (i19 >= i12) {
                                    break;
                                }
                                int zzn2 = this.zzl.zzn();
                                if (i19 % 2 == 0) {
                                    this.zzt.putShort((short) (zzn2 - i21));
                                } else {
                                    this.zzt.putInt(zzn2 - i21);
                                }
                                i19++;
                                i21 = zzn2;
                            }
                            int i22 = (i11 - this.zzW) - i21;
                            if ((i12 & 1) == 1) {
                                this.zzt.putInt(i22);
                            } else {
                                this.zzt.putShort((short) i22);
                                this.zzt.putInt(0);
                            }
                            this.zzr.zzD(this.zzt.array(), i18);
                            zzxt.zzr(this.zzr, i18, 1);
                            this.zzX += i18;
                        }
                    }
                } else {
                    byte[] bArr = zzaaw.zzh;
                    if (bArr != null) {
                        this.zzo.zzD(bArr, bArr.length);
                    }
                }
                if (zzaaw.zzf > 0) {
                    this.zzT |= 268435456;
                    this.zzs.zzC(0);
                    this.zzl.zzC(4);
                    this.zzl.zzH()[0] = (byte) ((i11 >> 24) & 255);
                    this.zzl.zzH()[1] = (byte) ((i11 >> 16) & 255);
                    this.zzl.zzH()[2] = (byte) ((i11 >> 8) & 255);
                    this.zzl.zzH()[3] = (byte) (i11 & 255);
                    zzxt.zzr(this.zzl, 4, 2);
                    this.zzX += 4;
                }
                this.zzZ = true;
            }
            int zzd2 = i11 + this.zzo.zzd();
            if (!"V_MPEG4/ISO/AVC".equals(zzaaw.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzaaw.zzb)) {
                if (zzaaw.zzS != null) {
                    if (this.zzo.zzd() != 0) {
                        z11 = false;
                    }
                    zzdy.zzf(z11);
                    zzaaw.zzS.zzd(zzwq);
                }
                while (true) {
                    int i23 = this.zzW;
                    if (i23 >= zzd2) {
                        break;
                    }
                    int zzq2 = zzq(zzwq, zzxt, zzd2 - i23);
                    this.zzW += zzq2;
                    this.zzX += zzq2;
                }
            } else {
                byte[] zzH3 = this.zzk.zzH();
                zzH3[0] = 0;
                zzH3[1] = 0;
                zzH3[2] = 0;
                int i24 = zzaaw.zzW;
                int i25 = 4 - i24;
                while (this.zzW < zzd2) {
                    int i26 = this.zzY;
                    if (i26 == 0) {
                        int min = Math.min(i24, this.zzo.zza());
                        ((zzwk) zzwq).zzn(zzH3, i25 + min, i24 - min, false);
                        if (min > 0) {
                            this.zzo.zzB(zzH3, i25, min);
                        }
                        this.zzW += i24;
                        this.zzk.zzF(0);
                        this.zzY = this.zzk.zzn();
                        this.zzj.zzF(0);
                        zzxr.zzb(zzxt, this.zzj, 4);
                        this.zzX += 4;
                    } else {
                        int zzq3 = zzq(zzwq, zzxt, i26);
                        this.zzW += zzq3;
                        this.zzX += zzq3;
                        this.zzY -= zzq3;
                    }
                }
            }
            if ("A_VORBIS".equals(zzaaw.zzb)) {
                this.zzm.zzF(0);
                zzxr.zzb(zzxt, this.zzm, 4);
                this.zzX += 4;
            }
            int i27 = this.zzX;
            zzw();
            return i27;
        }
    }

    private final int zzq(zzwq zzwq, zzxt zzxt, int i11) throws IOException {
        int zza2 = this.zzo.zza();
        if (zza2 <= 0) {
            return zzxr.zza(zzxt, zzwq, i11, false);
        }
        int min = Math.min(i11, zza2);
        zzxr.zzb(zzxt, this.zzo, min);
        return min;
    }

    private final long zzr(long j11) throws zzbj {
        long j12 = this.zzw;
        if (j12 != C.TIME_UNSET) {
            return zzfn.zzt(j11, j12, 1000);
        }
        throw zzbj.zza("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzs(int i11) throws zzbj {
        if (this.zzH == null || this.zzI == null) {
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Element ");
            sb2.append(i11);
            sb2.append(" must be in a Cues");
            throw zzbj.zza(sb2.toString(), (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzt(int i11) throws zzbj {
        if (this.zzz == null) {
            StringBuilder sb2 = new StringBuilder(43);
            sb2.append("Element ");
            sb2.append(i11);
            sb2.append(" must be in a TrackEntry");
            throw zzbj.zza(sb2.toString(), (Throwable) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b9 A[EDGE_INSN: B:49:0x00b9->B:38:0x00b9 ?: BREAK  , SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzu(com.google.android.gms.internal.ads.zzaaw r17, long r18, int r20, int r21, int r22) {
        /*
            r16 = this;
            r0 = r16
            r2 = r17
            com.google.android.gms.internal.ads.zzaax r1 = r2.zzS
            r8 = 1
            if (r1 == 0) goto L_0x0018
            r2 = r17
            r3 = r18
            r5 = r20
            r6 = r21
            r7 = r22
            r1.zzc(r2, r3, r5, r6, r7)
            goto L_0x00fb
        L_0x0018:
            java.lang.String r1 = r2.zzb
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r1 = r3.equals(r1)
            java.lang.String r4 = "S_TEXT/ASS"
            if (r1 != 0) goto L_0x002c
            java.lang.String r1 = r2.zzb
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0048
        L_0x002c:
            int r1 = r0.zzP
            java.lang.String r5 = "MatroskaExtractor"
            if (r1 <= r8) goto L_0x0038
            java.lang.String r1 = "Skipping subtitle sample in laced block."
            android.util.Log.w(r5, r1)
            goto L_0x0048
        L_0x0038:
            long r6 = r0.zzN
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x004c
            java.lang.String r1 = "Skipping subtitle sample with no duration."
            android.util.Log.w(r5, r1)
        L_0x0048:
            r1 = r21
            goto L_0x00cc
        L_0x004c:
            java.lang.String r1 = r2.zzb
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzp
            byte[] r5 = r5.zzH()
            int r9 = r1.hashCode()
            r10 = 738597099(0x2c0618eb, float:1.9056378E-12)
            r11 = 0
            if (r9 == r10) goto L_0x006c
            r4 = 1422270023(0x54c61e47, float:6.807292E12)
            if (r9 == r4) goto L_0x0064
            goto L_0x0074
        L_0x0064:
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0074
            r1 = r11
            goto L_0x0075
        L_0x006c:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0074
            r1 = r8
            goto L_0x0075
        L_0x0074:
            r1 = -1
        L_0x0075:
            if (r1 == 0) goto L_0x008a
            if (r1 != r8) goto L_0x0084
            java.lang.String r1 = "%01d:%02d:%02d:%02d"
            r3 = 10000(0x2710, double:4.9407E-320)
            byte[] r1 = zzy(r6, r1, r3)
            r3 = 21
            goto L_0x0094
        L_0x0084:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x008a:
            java.lang.String r1 = "%02d:%02d:%02d,%03d"
            r3 = 1000(0x3e8, double:4.94E-321)
            byte[] r1 = zzy(r6, r1, r3)
            r3 = 19
        L_0x0094:
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r11, r5, r3, r4)
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzp
            int r1 = r1.zzc()
        L_0x009e:
            com.google.android.gms.internal.ads.zzfd r3 = r0.zzp
            int r3 = r3.zzd()
            if (r1 >= r3) goto L_0x00b9
            com.google.android.gms.internal.ads.zzfd r3 = r0.zzp
            byte[] r3 = r3.zzH()
            byte r3 = r3[r1]
            if (r3 != 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzfd r3 = r0.zzp
            r3.zzE(r1)
            goto L_0x00b9
        L_0x00b6:
            int r1 = r1 + 1
            goto L_0x009e
        L_0x00b9:
            com.google.android.gms.internal.ads.zzxt r1 = r2.zzV
            com.google.android.gms.internal.ads.zzfd r3 = r0.zzp
            int r4 = r3.zzd()
            com.google.android.gms.internal.ads.zzxr.zzb(r1, r3, r4)
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzp
            int r1 = r1.zzd()
            int r1 = r21 + r1
        L_0x00cc:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r20 & r3
            if (r3 == 0) goto L_0x00ed
            int r3 = r0.zzP
            if (r3 <= r8) goto L_0x00de
            r3 = -268435457(0xffffffffefffffff, float:-1.5845632E29)
            r3 = r20 & r3
            r13 = r1
            r12 = r3
            goto L_0x00f0
        L_0x00de:
            com.google.android.gms.internal.ads.zzfd r3 = r0.zzs
            int r3 = r3.zzd()
            com.google.android.gms.internal.ads.zzxt r4 = r2.zzV
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzs
            r6 = 2
            r4.zzr(r5, r3, r6)
            int r1 = r1 + r3
        L_0x00ed:
            r12 = r20
            r13 = r1
        L_0x00f0:
            com.google.android.gms.internal.ads.zzxt r9 = r2.zzV
            com.google.android.gms.internal.ads.zzxs r15 = r2.zzi
            r10 = r18
            r14 = r22
            r9.zzs(r10, r12, r13, r14, r15)
        L_0x00fb:
            r0.zzK = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaay.zzu(com.google.android.gms.internal.ads.zzaaw, long, int, int, int):void");
    }

    private final void zzv(zzwq zzwq, int i11) throws IOException {
        if (this.zzl.zzd() < i11) {
            if (this.zzl.zzb() < i11) {
                zzfd zzfd = this.zzl;
                int zzb2 = zzfd.zzb();
                zzfd.zzz(Math.max(zzb2 + zzb2, i11));
            }
            ((zzwk) zzwq).zzn(this.zzl.zzH(), this.zzl.zzd(), i11 - this.zzl.zzd(), false);
            this.zzl.zzE(i11);
        }
    }

    private final void zzw() {
        this.zzW = 0;
        this.zzX = 0;
        this.zzY = 0;
        this.zzZ = false;
        this.zzaa = false;
        this.zzab = false;
        this.zzac = 0;
        this.zzad = 0;
        this.zzae = false;
        this.zzo.zzC(0);
    }

    private final void zzx(zzwq zzwq, byte[] bArr, int i11) throws IOException {
        int length = bArr.length;
        int i12 = i11 + 32;
        if (this.zzp.zzb() < i12) {
            zzfd zzfd = this.zzp;
            byte[] copyOf = Arrays.copyOf(bArr, i12 + i11);
            zzfd.zzD(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzp.zzH(), 0, 32);
        }
        ((zzwk) zzwq).zzn(this.zzp.zzH(), 32, i11, false);
        this.zzp.zzF(0);
        this.zzp.zzE(i12);
    }

    private static byte[] zzy(long j11, String str, long j12) {
        boolean z11;
        if (j11 != C.TIME_UNSET) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - (((long) (i11 * 3600)) * 1000000);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - (((long) (i12 * 60)) * 1000000);
        int i13 = (int) (j14 / 1000000);
        return zzfn.zzW(String.format(Locale.US, str, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (((long) i13) * 1000000)) / j12))}));
    }

    private static int[] zzz(@Nullable int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        int length = iArr.length;
        return length >= i11 ? iArr : new int[Math.max(length + length, i11)];
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        this.zzK = false;
        while (!this.zzK) {
            if (this.zzag.zzc(zzwq)) {
                long zze2 = zzwq.zze();
                if (this.zzD) {
                    this.zzF = zze2;
                    zzxm.zza = this.zzE;
                    this.zzD = false;
                    return 1;
                } else if (this.zzA) {
                    long j11 = this.zzF;
                    if (j11 != -1) {
                        zzxm.zza = j11;
                        this.zzF = -1;
                        return 1;
                    }
                }
            } else {
                for (int i11 = 0; i11 < this.zzh.size(); i11++) {
                    zzaaw valueAt = this.zzh.valueAt(i11);
                    valueAt.zzV.getClass();
                    zzaax zzaax = valueAt.zzS;
                    if (zzaax != null) {
                        zzaax.zza(valueAt);
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    public final void zzb(zzws zzws) {
        this.zzaf = zzws;
    }

    @CallSuper
    public final void zzc(long j11, long j12) {
        this.zzG = C.TIME_UNSET;
        this.zzL = 0;
        this.zzag.zzb();
        this.zzg.zze();
        zzw();
        for (int i11 = 0; i11 < this.zzh.size(); i11++) {
            zzaax zzaax = this.zzh.valueAt(i11).zzS;
            if (zzaax != null) {
                zzaax.zzb();
            }
        }
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        return new zzaaz().zza(zzwq);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0281, code lost:
        throw com.google.android.gms.internal.ads.zzbj.zza("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(int r19, int r20, com.google.android.gms.internal.ads.zzwq r21) throws java.io.IOException {
        /*
            r18 = this;
            r7 = r18
            r0 = r19
            r1 = r20
            r8 = r21
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 0
            r4 = 4
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            if (r0 == r2) goto L_0x0114
            if (r0 == r5) goto L_0x0114
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00de
            r2 = 16877(0x41ed, float:2.365E-41)
            if (r0 == r2) goto L_0x00b4
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x00a4
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x008f
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x0069
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x0059
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x0041
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaaw r0 = r7.zzz
            byte[] r2 = new byte[r1]
            r0.zzu = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzwk r0 = (com.google.android.gms.internal.ads.zzwk) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x0041:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 26
            r1.<init>(r2)
            java.lang.String r2 = "Unexpected id: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r3)
            throw r0
        L_0x0059:
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaaw r0 = r7.zzz
            byte[] r2 = new byte[r1]
            r0.zzj = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzwk r0 = (com.google.android.gms.internal.ads.zzwk) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x0069:
            com.google.android.gms.internal.ads.zzfd r0 = r7.zzn
            byte[] r0 = r0.zzH()
            java.util.Arrays.fill(r0, r10)
            com.google.android.gms.internal.ads.zzfd r0 = r7.zzn
            byte[] r0 = r0.zzH()
            r2 = r8
            com.google.android.gms.internal.ads.zzwk r2 = (com.google.android.gms.internal.ads.zzwk) r2
            int r3 = 4 - r1
            r2.zzn(r0, r3, r1, r10)
            com.google.android.gms.internal.ads.zzfd r0 = r7.zzn
            r0.zzF(r10)
            com.google.android.gms.internal.ads.zzfd r0 = r7.zzn
            long r0 = r0.zzs()
            int r0 = (int) r0
            r7.zzB = r0
            return
        L_0x008f:
            byte[] r2 = new byte[r1]
            r3 = r8
            com.google.android.gms.internal.ads.zzwk r3 = (com.google.android.gms.internal.ads.zzwk) r3
            r3.zzn(r2, r10, r1, r10)
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaaw r0 = r7.zzz
            com.google.android.gms.internal.ads.zzxs r1 = new com.google.android.gms.internal.ads.zzxs
            r1.<init>(r9, r2, r10, r10)
            r0.zzi = r1
            return
        L_0x00a4:
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaaw r0 = r7.zzz
            byte[] r2 = new byte[r1]
            r0.zzh = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzwk r0 = (com.google.android.gms.internal.ads.zzwk) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x00b4:
            r18.zzt(r19)
            com.google.android.gms.internal.ads.zzaaw r0 = r7.zzz
            int r2 = r0.zzX
            r3 = 1685485123(0x64767643, float:1.8185683E22)
            if (r2 == r3) goto L_0x00d3
            int r2 = r0.zzX
            r3 = 1685480259(0x64766343, float:1.8180206E22)
            if (r2 != r3) goto L_0x00cc
            goto L_0x00d3
        L_0x00cc:
            r0 = r8
            com.google.android.gms.internal.ads.zzwk r0 = (com.google.android.gms.internal.ads.zzwk) r0
            r0.zzo(r1, r10)
            return
        L_0x00d3:
            byte[] r2 = new byte[r1]
            r0.zzM = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzwk r0 = (com.google.android.gms.internal.ads.zzwk) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x00de:
            int r0 = r7.zzL
            if (r0 == r6) goto L_0x00e3
            return
        L_0x00e3:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaaw> r0 = r7.zzh
            int r2 = r7.zzR
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.ads.zzaaw r0 = (com.google.android.gms.internal.ads.zzaaw) r0
            int r2 = r7.zzU
            if (r2 != r4) goto L_0x010d
            java.lang.String r2 = "V_VP9"
            java.lang.String r0 = r0.zzb
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.internal.ads.zzfd r0 = r7.zzs
            r0.zzC(r1)
            com.google.android.gms.internal.ads.zzfd r0 = r7.zzs
            byte[] r0 = r0.zzH()
            r2 = r8
            com.google.android.gms.internal.ads.zzwk r2 = (com.google.android.gms.internal.ads.zzwk) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x010d:
            r0 = r8
            com.google.android.gms.internal.ads.zzwk r0 = (com.google.android.gms.internal.ads.zzwk) r0
            r0.zzo(r1, r10)
            return
        L_0x0114:
            int r2 = r7.zzL
            r11 = 8
            if (r2 != 0) goto L_0x0139
            com.google.android.gms.internal.ads.zzaba r2 = r7.zzg
            long r12 = r2.zzd(r8, r10, r9, r11)
            int r2 = (int) r12
            r7.zzR = r2
            com.google.android.gms.internal.ads.zzaba r2 = r7.zzg
            int r2 = r2.zza()
            r7.zzS = r2
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zzN = r12
            r7.zzL = r9
            com.google.android.gms.internal.ads.zzfd r2 = r7.zzl
            r2.zzC(r10)
        L_0x0139:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaaw> r2 = r7.zzh
            int r12 = r7.zzR
            java.lang.Object r2 = r2.get(r12)
            r12 = r2
            com.google.android.gms.internal.ads.zzaaw r12 = (com.google.android.gms.internal.ads.zzaaw) r12
            if (r12 != 0) goto L_0x0153
            int r0 = r7.zzS
            r2 = r8
            com.google.android.gms.internal.ads.zzwk r2 = (com.google.android.gms.internal.ads.zzwk) r2
            int r0 = r1 - r0
            r2.zzo(r0, r10)
            r7.zzL = r10
            return
        L_0x0153:
            r12.zzV.getClass()
            int r2 = r7.zzL
            if (r2 != r9) goto L_0x02e4
            r2 = 3
            r7.zzv(r8, r2)
            com.google.android.gms.internal.ads.zzfd r13 = r7.zzl
            byte[] r13 = r13.zzH()
            byte r13 = r13[r6]
            r13 = r13 & 6
            int r13 = r13 >> r9
            r14 = 255(0xff, float:3.57E-43)
            if (r13 != 0) goto L_0x0180
            r7.zzP = r9
            int[] r2 = r7.zzQ
            int[] r2 = zzz(r2, r9)
            r7.zzQ = r2
            int r3 = r7.zzS
            int r1 = r1 - r3
            int r1 = r1 + -3
            r2[r10] = r1
            goto L_0x0292
        L_0x0180:
            r7.zzv(r8, r4)
            com.google.android.gms.internal.ads.zzfd r15 = r7.zzl
            byte[] r15 = r15.zzH()
            byte r15 = r15[r2]
            r15 = r15 & r14
            int r15 = r15 + r9
            r7.zzP = r15
            int[] r4 = r7.zzQ
            int[] r4 = zzz(r4, r15)
            r7.zzQ = r4
            if (r13 != r6) goto L_0x01a6
            int r2 = r7.zzS
            int r3 = r7.zzP
            int r1 = r1 - r2
            int r1 = r1 + -4
            int r1 = r1 / r3
            java.util.Arrays.fill(r4, r10, r3, r1)
            goto L_0x0292
        L_0x01a6:
            if (r13 != r9) goto L_0x01de
            r2 = r10
            r3 = r2
            r4 = 4
        L_0x01ab:
            int r13 = r7.zzP
            int r13 = r13 + -1
            if (r2 >= r13) goto L_0x01d3
            int[] r13 = r7.zzQ
            r13[r2] = r10
        L_0x01b5:
            int r4 = r4 + r9
            r7.zzv(r8, r4)
            com.google.android.gms.internal.ads.zzfd r13 = r7.zzl
            byte[] r13 = r13.zzH()
            int r15 = r4 + -1
            byte r13 = r13[r15]
            r13 = r13 & r14
            int[] r15 = r7.zzQ
            r16 = r15[r2]
            int r16 = r16 + r13
            r15[r2] = r16
            if (r13 == r14) goto L_0x01b5
            int r3 = r3 + r16
            int r2 = r2 + 1
            goto L_0x01ab
        L_0x01d3:
            int[] r2 = r7.zzQ
            int r15 = r7.zzS
            int r1 = r1 - r15
            int r1 = r1 - r4
            int r1 = r1 - r3
            r2[r13] = r1
            goto L_0x0292
        L_0x01de:
            if (r13 != r2) goto L_0x02dd
            r2 = r10
            r13 = r2
            r4 = 4
        L_0x01e3:
            int r15 = r7.zzP
            int r15 = r15 + -1
            if (r2 >= r15) goto L_0x0289
            int[] r15 = r7.zzQ
            r15[r2] = r10
            int r4 = r4 + 1
            r7.zzv(r8, r4)
            int r15 = r4 + -1
            com.google.android.gms.internal.ads.zzfd r5 = r7.zzl
            byte[] r5 = r5.zzH()
            byte r5 = r5[r15]
            if (r5 == 0) goto L_0x0282
            r5 = r10
        L_0x01ff:
            if (r5 >= r11) goto L_0x0251
            int r17 = 7 - r5
            int r6 = r9 << r17
            com.google.android.gms.internal.ads.zzfd r9 = r7.zzl
            byte[] r9 = r9.zzH()
            byte r9 = r9[r15]
            r9 = r9 & r6
            if (r9 == 0) goto L_0x0247
            int r4 = r4 + r5
            r7.zzv(r8, r4)
            int r9 = r15 + 1
            com.google.android.gms.internal.ads.zzfd r10 = r7.zzl
            byte[] r10 = r10.zzH()
            byte r10 = r10[r15]
            r10 = r10 & r14
            int r6 = ~r6
            r6 = r6 & r10
            long r14 = (long) r6
        L_0x0222:
            if (r9 >= r4) goto L_0x0238
            int r6 = r9 + 1
            long r14 = r14 << r11
            com.google.android.gms.internal.ads.zzfd r10 = r7.zzl
            byte[] r10 = r10.zzH()
            byte r9 = r10[r9]
            r10 = 255(0xff, float:3.57E-43)
            r9 = r9 & r10
            long r10 = (long) r9
            long r14 = r14 | r10
            r9 = r6
            r11 = 8
            goto L_0x0222
        L_0x0238:
            if (r2 <= 0) goto L_0x0253
            int r5 = r5 * 7
            int r5 = r5 + 6
            r9 = 1
            long r5 = r9 << r5
            r9 = -1
            long r5 = r5 + r9
            long r14 = r14 - r5
            goto L_0x0253
        L_0x0247:
            int r5 = r5 + 1
            r6 = 2
            r9 = 1
            r10 = 0
            r11 = 8
            r14 = 255(0xff, float:3.57E-43)
            goto L_0x01ff
        L_0x0251:
            r14 = 0
        L_0x0253:
            r5 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x027b
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x027b
            int r5 = (int) r14
            int[] r6 = r7.zzQ
            if (r2 == 0) goto L_0x026b
            int r9 = r2 + -1
            r9 = r6[r9]
            int r5 = r5 + r9
        L_0x026b:
            r6[r2] = r5
            int r13 = r13 + r5
            int r2 = r2 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            r11 = 8
            r14 = 255(0xff, float:3.57E-43)
            goto L_0x01e3
        L_0x027b:
            java.lang.String r0 = "EBML lacing sample size out of range."
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r3)
            throw r0
        L_0x0282:
            java.lang.String r0 = "No valid varint length mask found"
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r3)
            throw r0
        L_0x0289:
            int[] r2 = r7.zzQ
            int r3 = r7.zzS
            int r1 = r1 - r3
            int r1 = r1 - r4
            int r1 = r1 - r13
            r2[r15] = r1
        L_0x0292:
            com.google.android.gms.internal.ads.zzfd r1 = r7.zzl
            byte[] r1 = r1.zzH()
            r2 = 0
            byte r1 = r1[r2]
            com.google.android.gms.internal.ads.zzfd r2 = r7.zzl
            byte[] r2 = r2.zzH()
            r3 = 1
            byte r2 = r2[r3]
            long r3 = r7.zzG
            r5 = 8
            int r1 = r1 << r5
            r5 = 255(0xff, float:3.57E-43)
            r2 = r2 & r5
            r1 = r1 | r2
            long r1 = (long) r1
            long r1 = r7.zzr(r1)
            long r3 = r3 + r1
            r7.zzM = r3
            int r1 = r12.zzd
            r2 = 2
            if (r1 == r2) goto L_0x02d2
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02d0
            com.google.android.gms.internal.ads.zzfd r0 = r7.zzl
            byte[] r0 = r0.zzH()
            byte r0 = r0[r2]
            r1 = 128(0x80, float:1.794E-43)
            r0 = r0 & r1
            if (r0 != r1) goto L_0x02ce
            r0 = 163(0xa3, float:2.28E-43)
            goto L_0x02d2
        L_0x02ce:
            r0 = 163(0xa3, float:2.28E-43)
        L_0x02d0:
            r1 = 0
            goto L_0x02d3
        L_0x02d2:
            r1 = 1
        L_0x02d3:
            r7.zzT = r1
            r7.zzL = r2
            r1 = 0
            r7.zzO = r1
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x02e5
        L_0x02dd:
            java.lang.String r0 = "Unexpected lacing value: 2"
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r3)
            throw r0
        L_0x02e4:
            r1 = r5
        L_0x02e5:
            if (r0 != r1) goto L_0x0314
        L_0x02e7:
            int r0 = r7.zzO
            int r1 = r7.zzP
            if (r0 >= r1) goto L_0x0310
            int[] r1 = r7.zzQ
            r0 = r1[r0]
            int r5 = r7.zzp(r8, r12, r0)
            long r0 = r7.zzM
            int r2 = r7.zzO
            int r3 = r12.zze
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.zzT
            r6 = 0
            r0 = r18
            r1 = r12
            r0.zzu(r1, r2, r4, r5, r6)
            int r0 = r7.zzO
            r1 = 1
            int r0 = r0 + r1
            r7.zzO = r0
            goto L_0x02e7
        L_0x0310:
            r0 = 0
            r7.zzL = r0
            return
        L_0x0314:
            int r0 = r7.zzO
            int r1 = r7.zzP
            if (r0 >= r1) goto L_0x032b
            int[] r1 = r7.zzQ
            r2 = r1[r0]
            int r2 = r7.zzp(r8, r12, r2)
            r1[r0] = r2
            int r0 = r7.zzO
            r1 = 1
            int r0 = r0 + r1
            r7.zzO = r0
            goto L_0x0314
        L_0x032b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaay.zzg(int, int, com.google.android.gms.internal.ads.zzwq):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0252, code lost:
        if (r3.equals("V_AV1") != false) goto L_0x030a;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(int r22) throws com.google.android.gms.internal.ads.zzbj {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            com.google.android.gms.internal.ads.zzws r1 = r7.zzaf
            com.google.android.gms.internal.ads.zzdy.zzb(r1)
            r1 = 160(0xa0, float:2.24E-43)
            r2 = 2
            if (r0 == r1) goto L_0x0329
            r1 = 174(0xae, float:2.44E-43)
            r3 = -1
            if (r0 == r1) goto L_0x0188
            r1 = 19899(0x4dbb, float:2.7884E-41)
            r5 = -1
            r2 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r0 == r1) goto L_0x0170
            r1 = 25152(0x6240, float:3.5245E-41)
            if (r0 == r1) goto L_0x013d
            r1 = 28032(0x6d80, float:3.9281E-41)
            if (r0 == r1) goto L_0x0127
            r1 = 357149030(0x1549a966, float:4.072526E-26)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == r1) goto L_0x010f
            r1 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r0 == r1) goto L_0x00f9
            if (r0 == r2) goto L_0x0037
            goto L_0x017f
        L_0x0037:
            boolean r0 = r7.zzA
            if (r0 != 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zzws r0 = r7.zzaf
            com.google.android.gms.internal.ads.zzeq r1 = r7.zzH
            com.google.android.gms.internal.ads.zzeq r2 = r7.zzI
            long r12 = r7.zzv
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            r12 = 0
            if (r5 == 0) goto L_0x00e6
            long r5 = r7.zzy
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00e6
            if (r1 == 0) goto L_0x00e6
            int r5 = r1.zza()
            if (r5 == 0) goto L_0x00e6
            if (r2 == 0) goto L_0x00e6
            int r5 = r2.zza()
            int r6 = r1.zza()
            if (r5 == r6) goto L_0x0065
            goto L_0x00e6
        L_0x0065:
            int r5 = r1.zza()
            int[] r6 = new int[r5]
            long[] r10 = new long[r5]
            long[] r11 = new long[r5]
            long[] r14 = new long[r5]
            r15 = 0
        L_0x0072:
            if (r15 >= r5) goto L_0x0087
            long r16 = r1.zzb(r15)
            r14[r15] = r16
            long r8 = r7.zzv
            long r18 = r2.zzb(r15)
            long r8 = r8 + r18
            r10[r15] = r8
            int r15 = r15 + 1
            goto L_0x0072
        L_0x0087:
            r9 = 0
        L_0x0088:
            int r1 = r5 + -1
            if (r9 >= r1) goto L_0x00a2
            int r1 = r9 + 1
            r17 = r10[r1]
            r19 = r10[r9]
            long r3 = r17 - r19
            int r2 = (int) r3
            r6[r9] = r2
            r2 = r14[r1]
            r17 = r14[r9]
            long r2 = r2 - r17
            r11[r9] = r2
            r9 = r1
            r3 = -1
            goto L_0x0088
        L_0x00a2:
            long r2 = r7.zzv
            long r4 = r7.zzu
            long r2 = r2 + r4
            r4 = r10[r1]
            long r2 = r2 - r4
            int r2 = (int) r2
            r6[r1] = r2
            long r2 = r7.zzy
            r4 = r14[r1]
            long r2 = r2 - r4
            r11[r1] = r2
            int r4 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r4 > 0) goto L_0x00e0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 72
            r4.<init>(r5)
            java.lang.String r5 = "Discarding last cue point with unexpected duration: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = "MatroskaExtractor"
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r2, r3)
            int[] r6 = java.util.Arrays.copyOf(r6, r1)
            long[] r10 = java.util.Arrays.copyOf(r10, r1)
            long[] r11 = java.util.Arrays.copyOf(r11, r1)
            long[] r14 = java.util.Arrays.copyOf(r14, r1)
        L_0x00e0:
            com.google.android.gms.internal.ads.zzwi r1 = new com.google.android.gms.internal.ads.zzwi
            r1.<init>(r6, r10, r11, r14)
            goto L_0x00ed
        L_0x00e6:
            com.google.android.gms.internal.ads.zzxo r1 = new com.google.android.gms.internal.ads.zzxo
            long r2 = r7.zzy
            r1.<init>(r2, r12)
        L_0x00ed:
            r0.zzL(r1)
            r0 = 1
            r7.zzA = r0
        L_0x00f3:
            r0 = 0
            r7.zzH = r0
            r7.zzI = r0
            return
        L_0x00f9:
            r0 = 0
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaaw> r1 = r7.zzh
            int r1 = r1.size()
            if (r1 == 0) goto L_0x0108
            com.google.android.gms.internal.ads.zzws r0 = r7.zzaf
            r0.zzB()
            return
        L_0x0108:
            java.lang.String r1 = "No valid tracks were found"
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r1, r0)
            throw r0
        L_0x010f:
            long r0 = r7.zzw
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x011a
            r0 = 1000000(0xf4240, double:4.940656E-318)
            r7.zzw = r0
        L_0x011a:
            long r0 = r7.zzx
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x017f
            long r0 = r7.zzr(r0)
            r7.zzy = r0
            return
        L_0x0127:
            r21.zzt(r22)
            com.google.android.gms.internal.ads.zzaaw r0 = r7.zzz
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x017f
            byte[] r0 = r0.zzh
            if (r0 != 0) goto L_0x0135
            goto L_0x017f
        L_0x0135:
            java.lang.String r0 = "Combining encryption and compression is not supported"
            r1 = 0
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r1)
            throw r0
        L_0x013d:
            r21.zzt(r22)
            com.google.android.gms.internal.ads.zzaaw r0 = r7.zzz
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x017f
            com.google.android.gms.internal.ads.zzxs r1 = r0.zzi
            if (r1 == 0) goto L_0x0168
            com.google.android.gms.internal.ads.zzs r1 = new com.google.android.gms.internal.ads.zzs
            r2 = 1
            com.google.android.gms.internal.ads.zzr[] r2 = new com.google.android.gms.internal.ads.zzr[r2]
            com.google.android.gms.internal.ads.zzr r3 = new com.google.android.gms.internal.ads.zzr
            java.util.UUID r4 = com.google.android.gms.internal.ads.zzk.zza
            com.google.android.gms.internal.ads.zzaaw r5 = r7.zzz
            com.google.android.gms.internal.ads.zzxs r5 = r5.zzi
            byte[] r5 = r5.zzb
            java.lang.String r6 = "video/webm"
            r8 = 0
            r3.<init>(r4, r8, r6, r5)
            r4 = 0
            r2[r4] = r3
            r1.<init>(r8, r2)
            r0.zzk = r1
            return
        L_0x0168:
            r8 = 0
            java.lang.String r0 = "Encrypted Track found but ContentEncKeyID was not found"
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r8)
            throw r0
        L_0x0170:
            int r0 = r7.zzB
            r1 = -1
            if (r0 == r1) goto L_0x0180
            long r3 = r7.zzC
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0180
            if (r0 != r2) goto L_0x017f
            r7.zzE = r3
        L_0x017f:
            return
        L_0x0180:
            java.lang.String r0 = "Mandatory element SeekID or SeekPosition not found"
            r1 = 0
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r1)
            throw r0
        L_0x0188:
            r1 = r3
            com.google.android.gms.internal.ads.zzaaw r0 = r7.zzz
            com.google.android.gms.internal.ads.zzdy.zzb(r0)
            java.lang.String r3 = r0.zzb
            if (r3 == 0) goto L_0x0321
            int r4 = r3.hashCode()
            switch(r4) {
                case -2095576542: goto L_0x02ff;
                case -2095575984: goto L_0x02f5;
                case -1985379776: goto L_0x02ea;
                case -1784763192: goto L_0x02df;
                case -1730367663: goto L_0x02d4;
                case -1482641358: goto L_0x02c9;
                case -1482641357: goto L_0x02be;
                case -1373388978: goto L_0x02b3;
                case -933872740: goto L_0x02a8;
                case -538363189: goto L_0x029d;
                case -538363109: goto L_0x0292;
                case -425012669: goto L_0x0286;
                case -356037306: goto L_0x027a;
                case 62923557: goto L_0x026e;
                case 62923603: goto L_0x0262;
                case 62927045: goto L_0x0256;
                case 82318131: goto L_0x024c;
                case 82338133: goto L_0x0241;
                case 82338134: goto L_0x0236;
                case 99146302: goto L_0x022a;
                case 444813526: goto L_0x021e;
                case 542569478: goto L_0x0212;
                case 635596514: goto L_0x0206;
                case 725948237: goto L_0x01fa;
                case 725957860: goto L_0x01ee;
                case 738597099: goto L_0x01e2;
                case 855502857: goto L_0x01d6;
                case 1422270023: goto L_0x01ca;
                case 1809237540: goto L_0x01bf;
                case 1950749482: goto L_0x01b3;
                case 1950789798: goto L_0x01a7;
                case 1951062397: goto L_0x019b;
                default: goto L_0x0199;
            }
        L_0x0199:
            goto L_0x0309
        L_0x019b:
            java.lang.String r2 = "A_OPUS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 11
            goto L_0x030a
        L_0x01a7:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 22
            goto L_0x030a
        L_0x01b3:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 17
            goto L_0x030a
        L_0x01bf:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 3
            goto L_0x030a
        L_0x01ca:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 27
            goto L_0x030a
        L_0x01d6:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 8
            goto L_0x030a
        L_0x01e2:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 28
            goto L_0x030a
        L_0x01ee:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 24
            goto L_0x030a
        L_0x01fa:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 25
            goto L_0x030a
        L_0x0206:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 26
            goto L_0x030a
        L_0x0212:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 20
            goto L_0x030a
        L_0x021e:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 10
            goto L_0x030a
        L_0x022a:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 30
            goto L_0x030a
        L_0x0236:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 1
            goto L_0x030a
        L_0x0241:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 0
            goto L_0x030a
        L_0x024c:
            java.lang.String r4 = "V_AV1"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0309
            goto L_0x030a
        L_0x0256:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 19
            goto L_0x030a
        L_0x0262:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 16
            goto L_0x030a
        L_0x026e:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 13
            goto L_0x030a
        L_0x027a:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 21
            goto L_0x030a
        L_0x0286:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 29
            goto L_0x030a
        L_0x0292:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 7
            goto L_0x030a
        L_0x029d:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 5
            goto L_0x030a
        L_0x02a8:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 31
            goto L_0x030a
        L_0x02b3:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 9
            goto L_0x030a
        L_0x02be:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 15
            goto L_0x030a
        L_0x02c9:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 14
            goto L_0x030a
        L_0x02d4:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 12
            goto L_0x030a
        L_0x02df:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 18
            goto L_0x030a
        L_0x02ea:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 23
            goto L_0x030a
        L_0x02f5:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 4
            goto L_0x030a
        L_0x02ff:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0309
            r2 = 6
            goto L_0x030a
        L_0x0309:
            r2 = r1
        L_0x030a:
            switch(r2) {
                case 0: goto L_0x030f;
                case 1: goto L_0x030f;
                case 2: goto L_0x030f;
                case 3: goto L_0x030f;
                case 4: goto L_0x030f;
                case 5: goto L_0x030f;
                case 6: goto L_0x030f;
                case 7: goto L_0x030f;
                case 8: goto L_0x030f;
                case 9: goto L_0x030f;
                case 10: goto L_0x030f;
                case 11: goto L_0x030f;
                case 12: goto L_0x030f;
                case 13: goto L_0x030f;
                case 14: goto L_0x030f;
                case 15: goto L_0x030f;
                case 16: goto L_0x030f;
                case 17: goto L_0x030f;
                case 18: goto L_0x030f;
                case 19: goto L_0x030f;
                case 20: goto L_0x030f;
                case 21: goto L_0x030f;
                case 22: goto L_0x030f;
                case 23: goto L_0x030f;
                case 24: goto L_0x030f;
                case 25: goto L_0x030f;
                case 26: goto L_0x030f;
                case 27: goto L_0x030f;
                case 28: goto L_0x030f;
                case 29: goto L_0x030f;
                case 30: goto L_0x030f;
                case 31: goto L_0x030f;
                default: goto L_0x030d;
            }
        L_0x030d:
            r0 = 0
            goto L_0x031e
        L_0x030f:
            com.google.android.gms.internal.ads.zzws r1 = r7.zzaf
            int r2 = r0.zzc
            r0.zze(r1, r2)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaaw> r1 = r7.zzh
            int r2 = r0.zzc
            r1.put(r2, r0)
            goto L_0x030d
        L_0x031e:
            r7.zzz = r0
            return
        L_0x0321:
            r0 = 0
            java.lang.String r1 = "CodecId is missing in TrackEntry element"
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r1, r0)
            throw r0
        L_0x0329:
            int r0 = r7.zzL
            if (r0 != r2) goto L_0x037c
            r0 = 0
            r4 = 0
        L_0x032f:
            int r1 = r7.zzP
            if (r4 >= r1) goto L_0x033b
            int[] r1 = r7.zzQ
            r1 = r1[r4]
            int r0 = r0 + r1
            int r4 = r4 + 1
            goto L_0x032f
        L_0x033b:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaaw> r1 = r7.zzh
            int r2 = r7.zzR
            java.lang.Object r1 = r1.get(r2)
            r8 = r1
            com.google.android.gms.internal.ads.zzaaw r8 = (com.google.android.gms.internal.ads.zzaaw) r8
            r8.zzV.getClass()
            r4 = 0
        L_0x034a:
            int r1 = r7.zzP
            if (r4 >= r1) goto L_0x0379
            long r1 = r7.zzM
            int r3 = r8.zze
            int r3 = r3 * r4
            int r3 = r3 / 1000
            long r5 = (long) r3
            long r2 = r1 + r5
            int r1 = r7.zzT
            if (r4 != 0) goto L_0x0365
            boolean r4 = r7.zzV
            if (r4 != 0) goto L_0x0362
            r1 = r1 | 1
        L_0x0362:
            r4 = r1
            r9 = 0
            goto L_0x0367
        L_0x0365:
            r9 = r4
            r4 = r1
        L_0x0367:
            int[] r1 = r7.zzQ
            r5 = r1[r9]
            int r10 = r0 - r5
            r0 = r21
            r1 = r8
            r6 = r10
            r0.zzu(r1, r2, r4, r5, r6)
            r0 = 1
            int r4 = r9 + 1
            r0 = r10
            goto L_0x034a
        L_0x0379:
            r1 = 0
            r7.zzL = r1
        L_0x037c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaay.zzh(int):void");
    }

    @CallSuper
    public final void zzi(int i11, double d11) throws zzbj {
        if (i11 == 181) {
            zzt(i11);
            this.zzz.zzP = (int) d11;
        } else if (i11 != 17545) {
            switch (i11) {
                case 21969:
                    zzt(i11);
                    this.zzz.zzC = (float) d11;
                    return;
                case 21970:
                    zzt(i11);
                    this.zzz.zzD = (float) d11;
                    return;
                case 21971:
                    zzt(i11);
                    this.zzz.zzE = (float) d11;
                    return;
                case 21972:
                    zzt(i11);
                    this.zzz.zzF = (float) d11;
                    return;
                case 21973:
                    zzt(i11);
                    this.zzz.zzG = (float) d11;
                    return;
                case 21974:
                    zzt(i11);
                    this.zzz.zzH = (float) d11;
                    return;
                case 21975:
                    zzt(i11);
                    this.zzz.zzI = (float) d11;
                    return;
                case 21976:
                    zzt(i11);
                    this.zzz.zzJ = (float) d11;
                    return;
                case 21977:
                    zzt(i11);
                    this.zzz.zzK = (float) d11;
                    return;
                case 21978:
                    zzt(i11);
                    this.zzz.zzL = (float) d11;
                    return;
                default:
                    switch (i11) {
                        case 30323:
                            zzt(i11);
                            this.zzz.zzr = (float) d11;
                            return;
                        case 30324:
                            zzt(i11);
                            this.zzz.zzs = (float) d11;
                            return;
                        case 30325:
                            zzt(i11);
                            this.zzz.zzt = (float) d11;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.zzx = (long) d11;
        }
    }

    @CallSuper
    public final void zzj(int i11, long j11) throws zzbj {
        if (i11 != 20529) {
            if (i11 != 20530) {
                boolean z11 = false;
                switch (i11) {
                    case 131:
                        zzt(i11);
                        this.zzz.zzd = (int) j11;
                        return;
                    case Opcodes.L2I:
                        zzt(i11);
                        zzaaw zzaaw = this.zzz;
                        if (j11 == 1) {
                            z11 = true;
                        }
                        zzaaw.zzU = z11;
                        return;
                    case 155:
                        this.zzN = zzr(j11);
                        return;
                    case Opcodes.IF_ICMPEQ:
                        zzt(i11);
                        this.zzz.zzN = (int) j11;
                        return;
                    case Opcodes.ARETURN:
                        zzt(i11);
                        this.zzz.zzl = (int) j11;
                        return;
                    case Opcodes.PUTSTATIC:
                        zzs(i11);
                        this.zzH.zzc(zzr(j11));
                        return;
                    case Opcodes.INVOKEDYNAMIC:
                        zzt(i11);
                        this.zzz.zzm = (int) j11;
                        return;
                    case 215:
                        zzt(i11);
                        this.zzz.zzc = (int) j11;
                        return;
                    case 231:
                        this.zzG = zzr(j11);
                        return;
                    case 238:
                        this.zzU = (int) j11;
                        return;
                    case 241:
                        if (!this.zzJ) {
                            zzs(i11);
                            this.zzI.zzc(j11);
                            this.zzJ = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzV = true;
                        return;
                    case 16871:
                        zzt(i11);
                        this.zzz.zzX = (int) j11;
                        return;
                    case 16980:
                        if (j11 != 3) {
                            StringBuilder sb2 = new StringBuilder(50);
                            sb2.append("ContentCompAlgo ");
                            sb2.append(j11);
                            sb2.append(" not supported");
                            throw zzbj.zza(sb2.toString(), (Throwable) null);
                        }
                        return;
                    case 17029:
                        if (j11 < 1 || j11 > 2) {
                            StringBuilder sb3 = new StringBuilder(53);
                            sb3.append("DocTypeReadVersion ");
                            sb3.append(j11);
                            sb3.append(" not supported");
                            throw zzbj.zza(sb3.toString(), (Throwable) null);
                        }
                        return;
                    case 17143:
                        if (j11 != 1) {
                            StringBuilder sb4 = new StringBuilder(50);
                            sb4.append("EBMLReadVersion ");
                            sb4.append(j11);
                            sb4.append(" not supported");
                            throw zzbj.zza(sb4.toString(), (Throwable) null);
                        }
                        return;
                    case 18401:
                        if (j11 != 5) {
                            StringBuilder sb5 = new StringBuilder(49);
                            sb5.append("ContentEncAlgo ");
                            sb5.append(j11);
                            sb5.append(" not supported");
                            throw zzbj.zza(sb5.toString(), (Throwable) null);
                        }
                        return;
                    case 18408:
                        if (j11 != 1) {
                            StringBuilder sb6 = new StringBuilder(56);
                            sb6.append("AESSettingsCipherMode ");
                            sb6.append(j11);
                            sb6.append(" not supported");
                            throw zzbj.zza(sb6.toString(), (Throwable) null);
                        }
                        return;
                    case 21420:
                        this.zzC = j11 + this.zzv;
                        return;
                    case 21432:
                        zzt(i11);
                        int i12 = (int) j11;
                        if (i12 == 0) {
                            this.zzz.zzv = 0;
                            return;
                        } else if (i12 == 1) {
                            this.zzz.zzv = 2;
                            return;
                        } else if (i12 == 3) {
                            this.zzz.zzv = 1;
                            return;
                        } else if (i12 == 15) {
                            this.zzz.zzv = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        zzt(i11);
                        this.zzz.zzn = (int) j11;
                        return;
                    case 21682:
                        zzt(i11);
                        this.zzz.zzp = (int) j11;
                        return;
                    case 21690:
                        zzt(i11);
                        this.zzz.zzo = (int) j11;
                        return;
                    case 21930:
                        zzt(i11);
                        zzaaw zzaaw2 = this.zzz;
                        if (j11 == 1) {
                            z11 = true;
                        }
                        zzaaw2.zzT = z11;
                        return;
                    case 21998:
                        zzt(i11);
                        this.zzz.zzf = (int) j11;
                        return;
                    case 22186:
                        zzt(i11);
                        this.zzz.zzQ = j11;
                        return;
                    case 22203:
                        zzt(i11);
                        this.zzz.zzR = j11;
                        return;
                    case 25188:
                        zzt(i11);
                        this.zzz.zzO = (int) j11;
                        return;
                    case 30321:
                        zzt(i11);
                        int i13 = (int) j11;
                        if (i13 == 0) {
                            this.zzz.zzq = 0;
                            return;
                        } else if (i13 == 1) {
                            this.zzz.zzq = 1;
                            return;
                        } else if (i13 == 2) {
                            this.zzz.zzq = 2;
                            return;
                        } else if (i13 == 3) {
                            this.zzz.zzq = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        zzt(i11);
                        this.zzz.zze = (int) j11;
                        return;
                    case 2807729:
                        this.zzw = j11;
                        return;
                    default:
                        switch (i11) {
                            case 21945:
                                zzt(i11);
                                int i14 = (int) j11;
                                if (i14 == 1) {
                                    this.zzz.zzz = 2;
                                    return;
                                } else if (i14 == 2) {
                                    this.zzz.zzz = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                zzt(i11);
                                int zzb2 = zzm.zzb((int) j11);
                                if (zzb2 != -1) {
                                    this.zzz.zzy = zzb2;
                                    return;
                                }
                                return;
                            case 21947:
                                zzt(i11);
                                this.zzz.zzw = true;
                                int zza2 = zzm.zza((int) j11);
                                if (zza2 != -1) {
                                    this.zzz.zzx = zza2;
                                    return;
                                }
                                return;
                            case 21948:
                                zzt(i11);
                                this.zzz.zzA = (int) j11;
                                return;
                            case 21949:
                                zzt(i11);
                                this.zzz.zzB = (int) j11;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j11 != 1) {
                StringBuilder sb7 = new StringBuilder(55);
                sb7.append("ContentEncodingScope ");
                sb7.append(j11);
                sb7.append(" not supported");
                throw zzbj.zza(sb7.toString(), (Throwable) null);
            }
        } else if (j11 != 0) {
            StringBuilder sb8 = new StringBuilder(55);
            sb8.append("ContentEncodingOrder ");
            sb8.append(j11);
            sb8.append(" not supported");
            throw zzbj.zza(sb8.toString(), (Throwable) null);
        }
    }

    @CallSuper
    public final void zzk(int i11, long j11, long j12) throws zzbj {
        zzdy.zzb(this.zzaf);
        if (i11 == 160) {
            this.zzV = false;
        } else if (i11 == 174) {
            this.zzz = new zzaaw((zzaav) null);
        } else if (i11 == 187) {
            this.zzJ = false;
        } else if (i11 == 19899) {
            this.zzB = -1;
            this.zzC = -1;
        } else if (i11 == 20533) {
            zzt(i11);
            this.zzz.zzg = true;
        } else if (i11 == 21968) {
            zzt(i11);
            this.zzz.zzw = true;
        } else if (i11 == 408125543) {
            long j13 = this.zzv;
            if (j13 == -1 || j13 == j11) {
                this.zzv = j11;
                this.zzu = j12;
                return;
            }
            throw zzbj.zza("Multiple Segment elements not supported", (Throwable) null);
        } else if (i11 == 475249515) {
            this.zzH = new zzeq(32);
            this.zzI = new zzeq(32);
        } else if (i11 != 524531317 || this.zzA) {
        } else {
            if (!this.zzi || this.zzE == -1) {
                this.zzaf.zzL(new zzxo(this.zzy, 0));
                this.zzA = true;
                return;
            }
            this.zzD = true;
        }
    }

    @CallSuper
    public final void zzl(int i11, String str) throws zzbj {
        if (i11 == 134) {
            zzt(i11);
            this.zzz.zzb = str;
        } else if (i11 != 17026) {
            if (i11 == 21358) {
                zzt(i11);
                this.zzz.zza = str;
            } else if (i11 == 2274716) {
                zzt(i11);
                this.zzz.zzY = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb2 = new StringBuilder(str.length() + 22);
            sb2.append("DocType ");
            sb2.append(str);
            sb2.append(" not supported");
            throw zzbj.zza(sb2.toString(), (Throwable) null);
        }
    }

    public zzaay(int i11) {
        zzaaq zzaaq = new zzaaq();
        this.zzv = -1;
        this.zzw = C.TIME_UNSET;
        this.zzx = C.TIME_UNSET;
        this.zzy = C.TIME_UNSET;
        this.zzE = -1;
        this.zzF = -1;
        this.zzG = C.TIME_UNSET;
        this.zzag = zzaaq;
        zzaaq.zza(new zzaau(this, (zzaat) null));
        this.zzi = true;
        this.zzg = new zzaba();
        this.zzh = new SparseArray<>();
        this.zzl = new zzfd(4);
        this.zzm = new zzfd(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzn = new zzfd(4);
        this.zzj = new zzfd(zzeu.zza);
        this.zzk = new zzfd(4);
        this.zzo = new zzfd();
        this.zzp = new zzfd();
        this.zzq = new zzfd(8);
        this.zzr = new zzfd();
        this.zzs = new zzfd();
        this.zzQ = new int[1];
    }
}
