package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class zzasb implements zzarj {
    public static final zzarl zza = new zzarw();
    private static final byte[] zzb = {TarConstants.LF_LINK, 10, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 32, 45, 45, 62, 32, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 58, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 44, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 10};
    private static final byte[] zzc = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */
    public static final UUID zzd = new UUID(72057594037932032L, -9223371306706625679L);
    private boolean zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private zzawp zzE;
    private zzawp zzF;
    private boolean zzG;
    private int zzH;
    private long zzI;
    private long zzJ;
    private int zzK;
    private int zzL;
    private int[] zzM;
    private int zzN;
    private int zzO;
    private int zzP;
    private int zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private byte zzV;
    private int zzW;
    private int zzX;
    private int zzY;
    private boolean zzZ;
    private boolean zzaa;
    private zzark zzab;
    private final zzarv zzac;
    private final zzasd zze;
    private final SparseArray<zzasa> zzf;
    private final boolean zzg;
    private final zzawu zzh;
    private final zzawu zzi;
    private final zzawu zzj;
    private final zzawu zzk;
    private final zzawu zzl;
    private final zzawu zzm;
    private final zzawu zzn;
    private final zzawu zzo;
    private final zzawu zzp;
    private ByteBuffer zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private long zzv;
    private zzasa zzw;
    private boolean zzx;
    private int zzy;
    private long zzz;

    public zzasb() {
        this(0);
    }

    public static final int zzl(int i11) {
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
            case 241:
            case 251:
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
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
            case 2274716:
                return 3;
            case Opcodes.IF_ICMPNE:
            case Opcodes.FRETURN:
            case Opcodes.INVOKESPECIAL:
            case Opcodes.NEW:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
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
                return 5;
            default:
                return 0;
        }
    }

    public static final boolean zzm(int i11) {
        return i11 == 357149030 || i11 == 524531317 || i11 == 475249515 || i11 == 374648427;
    }

    private final long zzn(long j11) throws zzapj {
        long j12 = this.zzt;
        if (j12 != C.TIME_UNSET) {
            return zzaxb.zzj(j11, j12, 1000);
        }
        throw new zzapj("Can't scale timecode prior to timecodeScale being set.");
    }

    private final void zzo(zzasa zzasa, long j11) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzasa.zza)) {
            byte[] bArr2 = this.zzn.zza;
            long j12 = this.zzJ;
            if (j12 == C.TIME_UNSET) {
                bArr = zzc;
            } else {
                int i11 = (int) (j12 / 3600000000L);
                long j13 = j12 - (((long) i11) * 3600000000L);
                int i12 = (int) (j13 / 60000000);
                long j14 = j13 - ((long) (60000000 * i12));
                int i13 = (int) (j14 / 1000000);
                bArr = zzaxb.zzq(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - ((long) (i13 * 1000000))) / 1000))}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzars zzars = zzasa.zzN;
            zzawu zzawu = this.zzn;
            zzars.zzb(zzawu, zzawu.zzd());
            this.zzY += this.zzn.zzd();
        }
        zzasa.zzN.zzc(j11, this.zzP, this.zzY, 0, zzasa.zzg);
        this.zzZ = true;
        zzp();
    }

    private final void zzp() {
        this.zzQ = 0;
        this.zzY = 0;
        this.zzX = 0;
        this.zzR = false;
        this.zzS = false;
        this.zzU = false;
        this.zzW = 0;
        this.zzV = 0;
        this.zzT = false;
        this.zzm.zzr();
    }

    private static int[] zzq(int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        int length = iArr.length;
        return length >= i11 ? iArr : new int[Math.max(length + length, i11)];
    }

    private final int zzr(zzari zzari, zzars zzars, int i11) throws IOException, InterruptedException {
        int i12;
        int zza2 = this.zzm.zza();
        if (zza2 > 0) {
            i12 = Math.min(i11, zza2);
            zzars.zzb(this.zzm, i12);
        } else {
            i12 = zzars.zzd(zzari, i11, false);
        }
        this.zzQ += i12;
        this.zzY += i12;
        return i12;
    }

    private final void zzs(zzari zzari, int i11) throws IOException, InterruptedException {
        if (this.zzj.zzd() < i11) {
            if (this.zzj.zzb() < i11) {
                zzawu zzawu = this.zzj;
                byte[] bArr = zzawu.zza;
                int length = bArr.length;
                zzawu.zzt(Arrays.copyOf(bArr, Math.max(length + length, i11)), this.zzj.zzd());
            }
            zzawu zzawu2 = this.zzj;
            zzari.zzh(zzawu2.zza, zzawu2.zzd(), i11 - this.zzj.zzd(), false);
            this.zzj.zzu(i11);
        }
    }

    private final void zzt(zzari zzari, zzasa zzasa, int i11) throws IOException, InterruptedException {
        int i12;
        if ("S_TEXT/UTF8".equals(zzasa.zza)) {
            int i13 = i11 + 32;
            if (this.zzn.zzb() < i13) {
                this.zzn.zza = Arrays.copyOf(zzb, i13 + i11);
            }
            zzari.zzh(this.zzn.zza, 32, i11, false);
            this.zzn.zzv(0);
            this.zzn.zzu(i13);
            return;
        }
        zzars zzars = zzasa.zzN;
        if (!this.zzR) {
            if (zzasa.zze) {
                this.zzP &= -1073741825;
                int i14 = 128;
                if (!this.zzS) {
                    zzari.zzh(this.zzj.zza, 0, 1, false);
                    this.zzQ++;
                    byte b11 = this.zzj.zza[0];
                    if ((b11 & 128) != 128) {
                        this.zzV = b11;
                        this.zzS = true;
                    } else {
                        throw new zzapj("Extension bit is set in signal byte");
                    }
                }
                byte b12 = this.zzV;
                if ((b12 & 1) == 1) {
                    byte b13 = b12 & 2;
                    this.zzP |= 1073741824;
                    if (!this.zzT) {
                        zzari.zzh(this.zzo.zza, 0, 8, false);
                        this.zzQ += 8;
                        this.zzT = true;
                        zzawu zzawu = this.zzj;
                        byte[] bArr = zzawu.zza;
                        if (b13 != 2) {
                            i14 = 0;
                        }
                        bArr[0] = (byte) (i14 | 8);
                        zzawu.zzv(0);
                        zzars.zzb(this.zzj, 1);
                        this.zzY++;
                        this.zzo.zzv(0);
                        zzars.zzb(this.zzo, 8);
                        this.zzY += 8;
                    }
                    if (b13 == 2) {
                        if (!this.zzU) {
                            zzari.zzh(this.zzj.zza, 0, 1, false);
                            this.zzQ++;
                            this.zzj.zzv(0);
                            this.zzW = this.zzj.zzg();
                            this.zzU = true;
                        }
                        int i15 = this.zzW * 4;
                        this.zzj.zzs(i15);
                        zzari.zzh(this.zzj.zza, 0, i15, false);
                        this.zzQ += i15;
                        int i16 = (this.zzW >> 1) + 1;
                        int i17 = (i16 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzq;
                        if (byteBuffer == null || byteBuffer.capacity() < i17) {
                            this.zzq = ByteBuffer.allocate(i17);
                        }
                        this.zzq.position(0);
                        this.zzq.putShort((short) i16);
                        int i18 = 0;
                        int i19 = 0;
                        while (true) {
                            i12 = this.zzW;
                            if (i18 >= i12) {
                                break;
                            }
                            int zzi2 = this.zzj.zzi();
                            if (i18 % 2 == 0) {
                                this.zzq.putShort((short) (zzi2 - i19));
                            } else {
                                this.zzq.putInt(zzi2 - i19);
                            }
                            i18++;
                            i19 = zzi2;
                        }
                        int i21 = (i11 - this.zzQ) - i19;
                        if ((i12 & 1) == 1) {
                            this.zzq.putInt(i21);
                        } else {
                            this.zzq.putShort((short) i21);
                            this.zzq.putInt(0);
                        }
                        this.zzp.zzt(this.zzq.array(), i17);
                        zzars.zzb(this.zzp, i17);
                        this.zzY += i17;
                    }
                }
            } else {
                byte[] bArr2 = zzasa.zzf;
                if (bArr2 != null) {
                    this.zzm.zzt(bArr2, bArr2.length);
                }
            }
            this.zzR = true;
        }
        int zzd2 = i11 + this.zzm.zzd();
        if (!"V_MPEG4/ISO/AVC".equals(zzasa.zza) && !"V_MPEGH/ISO/HEVC".equals(zzasa.zza)) {
            while (true) {
                int i22 = this.zzQ;
                if (i22 >= zzd2) {
                    break;
                }
                zzr(zzari, zzars, zzd2 - i22);
            }
        } else {
            byte[] bArr3 = this.zzi.zza;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i23 = zzasa.zzO;
            int i24 = 4 - i23;
            while (this.zzQ < zzd2) {
                int i25 = this.zzX;
                if (i25 == 0) {
                    int min = Math.min(i23, this.zzm.zza());
                    zzari.zzh(bArr3, i24 + min, i23 - min, false);
                    if (min > 0) {
                        this.zzm.zzq(bArr3, i24, min);
                    }
                    this.zzQ += i23;
                    this.zzi.zzv(0);
                    this.zzX = this.zzi.zzi();
                    this.zzh.zzv(0);
                    zzars.zzb(this.zzh, 4);
                    this.zzY += 4;
                } else {
                    this.zzX = i25 - zzr(zzari, zzars, i25);
                }
            }
        }
        if ("A_VORBIS".equals(zzasa.zza)) {
            this.zzk.zzv(0);
            zzars.zzb(this.zzk, 4);
            this.zzY += 4;
        }
    }

    public final void zzb(int i11) throws zzapj {
        zzarq zzarq;
        zzawp zzawp;
        zzawp zzawp2;
        int i12;
        int i13 = 0;
        if (i11 != 160) {
            if (i11 == 174) {
                String str = this.zzw.zza;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    zzasa zzasa = this.zzw;
                    zzasa.zzb(this.zzab, zzasa.zzb);
                    SparseArray<zzasa> sparseArray = this.zzf;
                    zzasa zzasa2 = this.zzw;
                    sparseArray.put(zzasa2.zzb, zzasa2);
                }
                this.zzw = null;
            } else if (i11 == 19899) {
                int i14 = this.zzy;
                if (i14 != -1) {
                    long j11 = this.zzz;
                    if (j11 != -1) {
                        if (i14 == 475249515) {
                            this.zzB = j11;
                            return;
                        }
                        return;
                    }
                }
                throw new zzapj("Mandatory element SeekID or SeekPosition not found");
            } else if (i11 == 25152) {
                zzasa zzasa3 = this.zzw;
                if (!zzasa3.zze) {
                    return;
                }
                if (zzasa3.zzg != null) {
                    zzasa3.zzi = new zzarf(new zzare(zzaor.zzb, MimeTypes.VIDEO_WEBM, this.zzw.zzg.zzb, false));
                    return;
                }
                throw new zzapj("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i11 == 28032) {
                zzasa zzasa4 = this.zzw;
                if (zzasa4.zze && zzasa4.zzf != null) {
                    throw new zzapj("Combining encryption and compression is not supported");
                }
            } else if (i11 == 357149030) {
                if (this.zzt == C.TIME_UNSET) {
                    this.zzt = 1000000;
                }
                long j12 = this.zzu;
                if (j12 != C.TIME_UNSET) {
                    this.zzv = zzn(j12);
                }
            } else if (i11 != 374648427) {
                if (i11 == 475249515 && !this.zzx) {
                    zzark zzark = this.zzab;
                    if (this.zzs == -1 || this.zzv == C.TIME_UNSET || (zzawp = this.zzE) == null || zzawp.zza() == 0 || (zzawp2 = this.zzF) == null || zzawp2.zza() != this.zzE.zza()) {
                        this.zzE = null;
                        this.zzF = null;
                        zzarq = new zzarp(this.zzv);
                    } else {
                        int zza2 = this.zzE.zza();
                        int[] iArr = new int[zza2];
                        long[] jArr = new long[zza2];
                        long[] jArr2 = new long[zza2];
                        long[] jArr3 = new long[zza2];
                        for (int i15 = 0; i15 < zza2; i15++) {
                            jArr3[i15] = this.zzE.zzb(i15);
                            jArr[i15] = this.zzs + this.zzF.zzb(i15);
                        }
                        while (true) {
                            i12 = zza2 - 1;
                            if (i13 >= i12) {
                                break;
                            }
                            int i16 = i13 + 1;
                            iArr[i13] = (int) (jArr[i16] - jArr[i13]);
                            jArr2[i13] = jArr3[i16] - jArr3[i13];
                            i13 = i16;
                        }
                        iArr[i12] = (int) ((this.zzs + this.zzr) - jArr[i12]);
                        jArr2[i12] = this.zzv - jArr3[i12];
                        this.zzE = null;
                        this.zzF = null;
                        zzarq = new zzarh(iArr, jArr, jArr2, jArr3);
                    }
                    zzark.zzc(zzarq);
                    this.zzx = true;
                }
            } else if (this.zzf.size() != 0) {
                this.zzab.zzb();
            } else {
                throw new zzapj("No valid tracks were found");
            }
        } else if (this.zzH == 2) {
            if (!this.zzaa) {
                this.zzP |= 1;
            }
            zzo(this.zzf.get(this.zzN), this.zzI);
            this.zzH = 0;
        }
    }

    public final void zzc(int i11, double d11) {
        if (i11 == 181) {
            this.zzw.zzI = (int) d11;
        } else if (i11 != 17545) {
            switch (i11) {
                case 21969:
                    this.zzw.zzw = (float) d11;
                    return;
                case 21970:
                    this.zzw.zzx = (float) d11;
                    return;
                case 21971:
                    this.zzw.zzy = (float) d11;
                    return;
                case 21972:
                    this.zzw.zzz = (float) d11;
                    return;
                case 21973:
                    this.zzw.zzA = (float) d11;
                    return;
                case 21974:
                    this.zzw.zzB = (float) d11;
                    return;
                case 21975:
                    this.zzw.zzC = (float) d11;
                    return;
                case 21976:
                    this.zzw.zzD = (float) d11;
                    return;
                case 21977:
                    this.zzw.zzE = (float) d11;
                    return;
                case 21978:
                    this.zzw.zzF = (float) d11;
                    return;
                default:
                    return;
            }
        } else {
            this.zzu = (long) d11;
        }
    }

    public final void zzd(zzark zzark) {
        this.zzab = zzark;
    }

    public final void zze(long j11, long j12) {
        this.zzD = C.TIME_UNSET;
        this.zzH = 0;
        this.zzac.zza();
        this.zze.zzd();
        zzp();
    }

    public final int zzf(zzari zzari, zzaro zzaro) throws IOException, InterruptedException {
        this.zzZ = false;
        while (!this.zzZ) {
            if (!this.zzac.zzc(zzari)) {
                return -1;
            }
            long zzd2 = zzari.zzd();
            if (this.zzA) {
                this.zzC = zzd2;
                zzaro.zza = this.zzB;
                this.zzA = false;
                return 1;
            } else if (this.zzx) {
                long j11 = this.zzC;
                if (j11 != -1) {
                    zzaro.zza = j11;
                    this.zzC = -1;
                    return 1;
                }
            }
        }
        return 0;
    }

    public final boolean zzg(zzari zzari) throws IOException, InterruptedException {
        return new zzasc().zza(zzari);
    }

    public final void zzh(int i11, long j11) throws zzapj {
        if (i11 != 20529) {
            if (i11 != 20530) {
                boolean z11 = false;
                switch (i11) {
                    case 131:
                        this.zzw.zzc = (int) j11;
                        return;
                    case Opcodes.L2I:
                        zzasa zzasa = this.zzw;
                        if (j11 == 1) {
                            z11 = true;
                        }
                        zzasa.zzL = z11;
                        return;
                    case 155:
                        this.zzJ = zzn(j11);
                        return;
                    case Opcodes.IF_ICMPEQ:
                        this.zzw.zzG = (int) j11;
                        return;
                    case Opcodes.ARETURN:
                        this.zzw.zzj = (int) j11;
                        return;
                    case Opcodes.PUTSTATIC:
                        this.zzE.zzc(zzn(j11));
                        return;
                    case Opcodes.INVOKEDYNAMIC:
                        this.zzw.zzk = (int) j11;
                        return;
                    case 215:
                        this.zzw.zzb = (int) j11;
                        return;
                    case 231:
                        this.zzD = zzn(j11);
                        return;
                    case 241:
                        if (!this.zzG) {
                            this.zzF.zzc(j11);
                            this.zzG = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzaa = true;
                        return;
                    case 16980:
                        if (j11 != 3) {
                            StringBuilder sb2 = new StringBuilder(50);
                            sb2.append("ContentCompAlgo ");
                            sb2.append(j11);
                            sb2.append(" not supported");
                            throw new zzapj(sb2.toString());
                        }
                        return;
                    case 17029:
                        if (j11 < 1 || j11 > 2) {
                            StringBuilder sb3 = new StringBuilder(53);
                            sb3.append("DocTypeReadVersion ");
                            sb3.append(j11);
                            sb3.append(" not supported");
                            throw new zzapj(sb3.toString());
                        }
                        return;
                    case 17143:
                        if (j11 != 1) {
                            StringBuilder sb4 = new StringBuilder(50);
                            sb4.append("EBMLReadVersion ");
                            sb4.append(j11);
                            sb4.append(" not supported");
                            throw new zzapj(sb4.toString());
                        }
                        return;
                    case 18401:
                        if (j11 != 5) {
                            StringBuilder sb5 = new StringBuilder(49);
                            sb5.append("ContentEncAlgo ");
                            sb5.append(j11);
                            sb5.append(" not supported");
                            throw new zzapj(sb5.toString());
                        }
                        return;
                    case 18408:
                        if (j11 != 1) {
                            StringBuilder sb6 = new StringBuilder(56);
                            sb6.append("AESSettingsCipherMode ");
                            sb6.append(j11);
                            sb6.append(" not supported");
                            throw new zzapj(sb6.toString());
                        }
                        return;
                    case 21420:
                        this.zzz = j11 + this.zzs;
                        return;
                    case 21432:
                        int i12 = (int) j11;
                        if (i12 == 0) {
                            this.zzw.zzp = 0;
                            return;
                        } else if (i12 == 1) {
                            this.zzw.zzp = 2;
                            return;
                        } else if (i12 == 3) {
                            this.zzw.zzp = 1;
                            return;
                        } else if (i12 == 15) {
                            this.zzw.zzp = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.zzw.zzl = (int) j11;
                        return;
                    case 21682:
                        this.zzw.zzn = (int) j11;
                        return;
                    case 21690:
                        this.zzw.zzm = (int) j11;
                        return;
                    case 21930:
                        zzasa zzasa2 = this.zzw;
                        if (j11 == 1) {
                            z11 = true;
                        }
                        zzasa2.zzM = z11;
                        return;
                    case 22186:
                        this.zzw.zzJ = j11;
                        return;
                    case 22203:
                        this.zzw.zzK = j11;
                        return;
                    case 25188:
                        this.zzw.zzH = (int) j11;
                        return;
                    case 2352003:
                        this.zzw.zzd = (int) j11;
                        return;
                    case 2807729:
                        this.zzt = j11;
                        return;
                    default:
                        switch (i11) {
                            case 21945:
                                int i13 = (int) j11;
                                if (i13 == 1) {
                                    this.zzw.zzt = 2;
                                    return;
                                } else if (i13 == 2) {
                                    this.zzw.zzt = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i14 = (int) j11;
                                if (i14 != 1) {
                                    if (i14 == 16) {
                                        this.zzw.zzs = 6;
                                        return;
                                    } else if (i14 == 18) {
                                        this.zzw.zzs = 7;
                                        return;
                                    } else if (!(i14 == 6 || i14 == 7)) {
                                        return;
                                    }
                                }
                                this.zzw.zzs = 3;
                                return;
                            case 21947:
                                zzasa zzasa3 = this.zzw;
                                zzasa3.zzq = true;
                                int i15 = (int) j11;
                                if (i15 == 1) {
                                    zzasa3.zzr = 1;
                                    return;
                                } else if (i15 == 9) {
                                    zzasa3.zzr = 6;
                                    return;
                                } else if (i15 == 4 || i15 == 5 || i15 == 6 || i15 == 7) {
                                    zzasa3.zzr = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.zzw.zzu = (int) j11;
                                return;
                            case 21949:
                                this.zzw.zzv = (int) j11;
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
                throw new zzapj(sb7.toString());
            }
        } else if (j11 != 0) {
            StringBuilder sb8 = new StringBuilder(55);
            sb8.append("ContentEncodingOrder ");
            sb8.append(j11);
            sb8.append(" not supported");
            throw new zzapj(sb8.toString());
        }
    }

    public final void zzi(int i11, long j11, long j12) throws zzapj {
        if (i11 == 160) {
            this.zzaa = false;
        } else if (i11 == 174) {
            this.zzw = new zzasa((zzarz) null);
        } else if (i11 == 187) {
            this.zzG = false;
        } else if (i11 == 19899) {
            this.zzy = -1;
            this.zzz = -1;
        } else if (i11 == 20533) {
            this.zzw.zze = true;
        } else if (i11 == 21968) {
            this.zzw.zzq = true;
        } else if (i11 == 408125543) {
            long j13 = this.zzs;
            if (j13 == -1 || j13 == j11) {
                this.zzs = j11;
                this.zzr = j12;
                return;
            }
            throw new zzapj("Multiple Segment elements not supported");
        } else if (i11 == 475249515) {
            this.zzE = new zzawp(32);
            this.zzF = new zzawp(32);
        } else if (i11 != 524531317 || this.zzx) {
        } else {
            if (!this.zzg || this.zzB == -1) {
                this.zzab.zzc(new zzarp(this.zzv));
                this.zzx = true;
                return;
            }
            this.zzA = true;
        }
    }

    public final void zzj(int i11, String str) throws zzapj {
        if (i11 == 134) {
            this.zzw.zza = str;
        } else if (i11 != 17026) {
            if (i11 == 2274716) {
                this.zzw.zzP = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb2 = new StringBuilder(str.length() + 22);
            sb2.append("DocType ");
            sb2.append(str);
            sb2.append(" not supported");
            throw new zzapj(sb2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01ed, code lost:
        throw new com.google.android.gms.internal.ads.zzapj("EBML lacing sample size out of range.");
     */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0240  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk(int r19, int r20, com.google.android.gms.internal.ads.zzari r21) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 1
            r7 = 0
            if (r1 == r4) goto L_0x008b
            if (r1 == r5) goto L_0x008b
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0081
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0072
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0053
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x0049
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0030
            com.google.android.gms.internal.ads.zzasa r1 = r0.zzw
            byte[] r4 = new byte[r2]
            r1.zzo = r4
            r3.zzh(r4, r7, r2, r7)
            return
        L_0x0030:
            com.google.android.gms.internal.ads.zzapj r2 = new com.google.android.gms.internal.ads.zzapj
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 26
            r3.<init>(r4)
            java.lang.String r4 = "Unexpected id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0049:
            com.google.android.gms.internal.ads.zzasa r1 = r0.zzw
            byte[] r4 = new byte[r2]
            r1.zzh = r4
            r3.zzh(r4, r7, r2, r7)
            return
        L_0x0053:
            com.google.android.gms.internal.ads.zzawu r1 = r0.zzl
            byte[] r1 = r1.zza
            java.util.Arrays.fill(r1, r7)
            com.google.android.gms.internal.ads.zzawu r1 = r0.zzl
            byte[] r1 = r1.zza
            int r4 = 4 - r2
            r3.zzh(r1, r4, r2, r7)
            com.google.android.gms.internal.ads.zzawu r1 = r0.zzl
            r1.zzv(r7)
            com.google.android.gms.internal.ads.zzawu r1 = r0.zzl
            long r1 = r1.zzm()
            int r1 = (int) r1
            r0.zzy = r1
            return
        L_0x0072:
            byte[] r1 = new byte[r2]
            r3.zzh(r1, r7, r2, r7)
            com.google.android.gms.internal.ads.zzasa r2 = r0.zzw
            com.google.android.gms.internal.ads.zzarr r3 = new com.google.android.gms.internal.ads.zzarr
            r3.<init>(r6, r1)
            r2.zzg = r3
            return
        L_0x0081:
            com.google.android.gms.internal.ads.zzasa r1 = r0.zzw
            byte[] r4 = new byte[r2]
            r1.zzf = r4
            r3.zzh(r4, r7, r2, r7)
            return
        L_0x008b:
            int r4 = r0.zzH
            r8 = 8
            if (r4 != 0) goto L_0x00b0
            com.google.android.gms.internal.ads.zzasd r4 = r0.zze
            long r9 = r4.zze(r3, r7, r6, r8)
            int r4 = (int) r9
            r0.zzN = r4
            com.google.android.gms.internal.ads.zzasd r4 = r0.zze
            int r4 = r4.zza()
            r0.zzO = r4
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zzJ = r9
            r0.zzH = r6
            com.google.android.gms.internal.ads.zzawu r4 = r0.zzj
            r4.zzr()
        L_0x00b0:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzasa> r4 = r0.zzf
            int r9 = r0.zzN
            java.lang.Object r4 = r4.get(r9)
            com.google.android.gms.internal.ads.zzasa r4 = (com.google.android.gms.internal.ads.zzasa) r4
            if (r4 != 0) goto L_0x00c6
            int r1 = r0.zzO
            int r1 = r2 - r1
            r3.zzi(r1, r7)
            r0.zzH = r7
            return
        L_0x00c6:
            int r9 = r0.zzH
            if (r9 != r6) goto L_0x025c
            r9 = 3
            r0.zzs(r3, r9)
            com.google.android.gms.internal.ads.zzawu r10 = r0.zzj
            byte[] r10 = r10.zza
            r11 = 2
            byte r10 = r10[r11]
            r10 = r10 & 6
            int r10 = r10 >> r6
            r12 = 255(0xff, float:3.57E-43)
            if (r10 != 0) goto L_0x00ef
            r0.zzL = r6
            int[] r9 = r0.zzM
            int[] r9 = zzq(r9, r6)
            r0.zzM = r9
            int r10 = r0.zzO
            int r2 = r2 - r10
            int r2 = r2 + -3
            r9[r7] = r2
            goto L_0x01ff
        L_0x00ef:
            if (r1 != r5) goto L_0x0254
            r13 = 4
            r0.zzs(r3, r13)
            com.google.android.gms.internal.ads.zzawu r14 = r0.zzj
            byte[] r14 = r14.zza
            byte r14 = r14[r9]
            r14 = r14 & r12
            int r14 = r14 + r6
            r0.zzL = r14
            int[] r15 = r0.zzM
            int[] r14 = zzq(r15, r14)
            r0.zzM = r14
            if (r10 != r11) goto L_0x0116
            int r9 = r0.zzO
            int r10 = r0.zzL
            int r2 = r2 - r9
            int r2 = r2 + -4
            int r2 = r2 / r10
            java.util.Arrays.fill(r14, r7, r10, r2)
            goto L_0x01ff
        L_0x0116:
            if (r10 != r6) goto L_0x014b
            r9 = r7
            r10 = r9
        L_0x011a:
            int r14 = r0.zzL
            int r14 = r14 + -1
            if (r9 >= r14) goto L_0x0140
            int[] r14 = r0.zzM
            r14[r9] = r7
        L_0x0124:
            int r13 = r13 + r6
            r0.zzs(r3, r13)
            com.google.android.gms.internal.ads.zzawu r14 = r0.zzj
            byte[] r14 = r14.zza
            int r15 = r13 + -1
            byte r14 = r14[r15]
            r14 = r14 & r12
            int[] r15 = r0.zzM
            r16 = r15[r9]
            int r16 = r16 + r14
            r15[r9] = r16
            if (r14 == r12) goto L_0x0124
            int r10 = r10 + r16
            int r9 = r9 + 1
            goto L_0x011a
        L_0x0140:
            int[] r9 = r0.zzM
            int r15 = r0.zzO
            int r2 = r2 - r15
            int r2 = r2 - r13
            int r2 = r2 - r10
            r9[r14] = r2
            goto L_0x01ff
        L_0x014b:
            if (r10 != r9) goto L_0x024c
            r9 = r7
            r10 = r9
        L_0x014f:
            int r14 = r0.zzL
            int r14 = r14 + -1
            if (r9 >= r14) goto L_0x01f6
            int[] r14 = r0.zzM
            r14[r9] = r7
            int r13 = r13 + 1
            r0.zzs(r3, r13)
            int r14 = r13 + -1
            com.google.android.gms.internal.ads.zzawu r15 = r0.zzj
            byte[] r15 = r15.zza
            byte r15 = r15[r14]
            if (r15 == 0) goto L_0x01ee
            r15 = r7
        L_0x0169:
            if (r15 >= r8) goto L_0x01bd
            int r16 = 7 - r15
            int r5 = r6 << r16
            com.google.android.gms.internal.ads.zzawu r11 = r0.zzj
            byte[] r11 = r11.zza
            byte r11 = r11[r14]
            r11 = r11 & r5
            if (r11 == 0) goto L_0x01b2
            int r13 = r13 + r15
            r0.zzs(r3, r13)
            int r11 = r14 + 1
            com.google.android.gms.internal.ads.zzawu r6 = r0.zzj
            byte[] r6 = r6.zza
            byte r6 = r6[r14]
            r6 = r6 & r12
            int r5 = ~r5
            r5 = r5 & r6
            long r5 = (long) r5
        L_0x0188:
            if (r11 >= r13) goto L_0x01a0
            int r14 = r11 + 1
            long r5 = r5 << r8
            com.google.android.gms.internal.ads.zzawu r8 = r0.zzj
            byte[] r8 = r8.zza
            byte r8 = r8[r11]
            r8 = r8 & r12
            r17 = r13
            long r12 = (long) r8
            long r5 = r5 | r12
            r11 = r14
            r13 = r17
            r8 = 8
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0188
        L_0x01a0:
            r17 = r13
            if (r9 <= 0) goto L_0x01af
            int r15 = r15 * 7
            int r15 = r15 + 6
            r12 = 1
            long r12 = r12 << r15
            r14 = -1
            long r12 = r12 + r14
            long r5 = r5 - r12
        L_0x01af:
            r13 = r17
            goto L_0x01bf
        L_0x01b2:
            int r15 = r15 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 1
            r8 = 8
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0169
        L_0x01bd:
            r5 = 0
        L_0x01bf:
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 < 0) goto L_0x01e6
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 > 0) goto L_0x01e6
            int r5 = (int) r5
            int[] r6 = r0.zzM
            if (r9 == 0) goto L_0x01d7
            int r8 = r9 + -1
            r8 = r6[r8]
            int r5 = r5 + r8
        L_0x01d7:
            r6[r9] = r5
            int r10 = r10 + r5
            int r9 = r9 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 1
            r8 = 8
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x014f
        L_0x01e6:
            com.google.android.gms.internal.ads.zzapj r1 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>(r2)
            throw r1
        L_0x01ee:
            com.google.android.gms.internal.ads.zzapj r1 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>(r2)
            throw r1
        L_0x01f6:
            int[] r5 = r0.zzM
            int r6 = r0.zzO
            int r2 = r2 - r6
            int r2 = r2 - r13
            int r2 = r2 - r10
            r5[r14] = r2
        L_0x01ff:
            com.google.android.gms.internal.ads.zzawu r2 = r0.zzj
            byte[] r2 = r2.zza
            byte r5 = r2[r7]
            r6 = 1
            byte r2 = r2[r6]
            long r8 = r0.zzD
            r6 = 8
            int r5 = r5 << r6
            r6 = 255(0xff, float:3.57E-43)
            r2 = r2 & r6
            r2 = r2 | r5
            long r5 = (long) r2
            long r5 = r0.zzn(r5)
            long r8 = r8 + r5
            r0.zzI = r8
            com.google.android.gms.internal.ads.zzawu r2 = r0.zzj
            byte[] r2 = r2.zza
            r5 = 2
            byte r2 = r2[r5]
            r6 = r2 & 8
            int r8 = r4.zzc
            if (r8 == r5) goto L_0x0238
            r5 = 163(0xa3, float:2.28E-43)
            if (r1 != r5) goto L_0x0236
            r1 = 128(0x80, float:1.794E-43)
            r2 = r2 & r1
            if (r2 != r1) goto L_0x0232
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x0238
        L_0x0232:
            r2 = r7
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x0239
        L_0x0236:
            r2 = r7
            goto L_0x0239
        L_0x0238:
            r2 = 1
        L_0x0239:
            r5 = 8
            if (r6 != r5) goto L_0x0240
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0241
        L_0x0240:
            r5 = r7
        L_0x0241:
            r2 = r2 | r5
            r0.zzP = r2
            r2 = 2
            r0.zzH = r2
            r0.zzK = r7
            r2 = 163(0xa3, float:2.28E-43)
            goto L_0x025d
        L_0x024c:
            com.google.android.gms.internal.ads.zzapj r1 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r2 = "Unexpected lacing value: 2"
            r1.<init>(r2)
            throw r1
        L_0x0254:
            com.google.android.gms.internal.ads.zzapj r1 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>(r2)
            throw r1
        L_0x025c:
            r2 = r5
        L_0x025d:
            if (r1 != r2) goto L_0x0284
        L_0x025f:
            int r1 = r0.zzK
            int r2 = r0.zzL
            if (r1 >= r2) goto L_0x0281
            int[] r2 = r0.zzM
            r1 = r2[r1]
            r0.zzt(r3, r4, r1)
            long r1 = r0.zzI
            int r5 = r0.zzK
            int r6 = r4.zzd
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.zzo(r4, r1)
            int r1 = r0.zzK
            r2 = 1
            int r1 = r1 + r2
            r0.zzK = r1
            goto L_0x025f
        L_0x0281:
            r0.zzH = r7
            return
        L_0x0284:
            int[] r1 = r0.zzM
            r1 = r1[r7]
            r0.zzt(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasb.zzk(int, int, com.google.android.gms.internal.ads.zzari):void");
    }

    public zzasb(int i11) {
        zzarv zzarv = new zzarv();
        this.zzs = -1;
        this.zzt = C.TIME_UNSET;
        this.zzu = C.TIME_UNSET;
        this.zzv = C.TIME_UNSET;
        this.zzB = -1;
        this.zzC = -1;
        this.zzD = C.TIME_UNSET;
        this.zzac = zzarv;
        zzarv.zzb(new zzary(this, (zzarx) null));
        this.zzg = true;
        this.zze = new zzasd();
        this.zzf = new SparseArray<>();
        this.zzj = new zzawu(4);
        this.zzk = new zzawu(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzl = new zzawu(4);
        this.zzh = new zzawu(zzaws.zza);
        this.zzi = new zzawu(4);
        this.zzm = new zzawu();
        this.zzn = new zzawu();
        this.zzo = new zzawu(8);
        this.zzp = new zzawu();
    }
}
