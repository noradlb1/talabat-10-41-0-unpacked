package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import net.bytebuddy.jar.asm.Opcodes;
import okio.Utf8;

public final class zzvv {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {OpusUtil.SAMPLE_RATE, 44100, 32000};
    private static final int[] zzd = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, Opcodes.IF_ICMPNE, 192, 224, 256, 320, RendererCapabilities.MODE_SUPPORT_MASK, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, Opcodes.F2I, Opcodes.FRETURN, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i11 = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
            return i11 + i11;
        }
        byte b11 = bArr[4];
        return zze((b11 & 192) >> 6, b11 & Utf8.REPLACEMENT_BYTE);
    }

    public static zzab zzb(zzfd zzfd, String str, String str2, @Nullable zzs zzs) {
        int i11 = zzc[(zzfd.zzk() & 192) >> 6];
        int zzk = zzfd.zzk();
        int i12 = zze[(zzk & 56) >> 3];
        if ((zzk & 4) != 0) {
            i12++;
        }
        zzz zzz = new zzz();
        zzz.zzH(str);
        zzz.zzS(MimeTypes.AUDIO_AC3);
        zzz.zzw(i12);
        zzz.zzT(i11);
        zzz.zzB(zzs);
        zzz.zzK(str2);
        return zzz.zzY();
    }

    public static zzab zzc(zzfd zzfd, String str, String str2, @Nullable zzs zzs) {
        String str3;
        zzfd.zzG(2);
        int i11 = zzc[(zzfd.zzk() & 192) >> 6];
        int zzk = zzfd.zzk();
        int i12 = zze[(zzk & 14) >> 1];
        if ((zzk & 1) != 0) {
            i12++;
        }
        if (((zzfd.zzk() & 30) >> 1) > 0 && (2 & zzfd.zzk()) != 0) {
            i12 += 2;
        }
        if (zzfd.zza() <= 0 || (zzfd.zzk() & 1) == 0) {
            str3 = MimeTypes.AUDIO_E_AC3;
        } else {
            str3 = MimeTypes.AUDIO_E_AC3_JOC;
        }
        zzz zzz = new zzz();
        zzz.zzH(str);
        zzz.zzS(str3);
        zzz.zzw(i12);
        zzz.zzT(i11);
        zzz.zzB(zzs);
        zzz.zzK(str2);
        return zzz.zzY();
    }

    public static zzvu zzd(zzfc zzfc) {
        int i11;
        String str;
        int i12;
        int i13;
        int i14;
        int i15;
        String str2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        String str3;
        int i22;
        int i23;
        zzfc zzfc2 = zzfc;
        int zzb2 = zzfc.zzb();
        zzfc2.zzj(40);
        int zzc2 = zzfc2.zzc(5);
        zzfc2.zzh(zzb2);
        int i24 = -1;
        if (zzc2 > 10) {
            zzfc2.zzj(16);
            int zzc3 = zzfc2.zzc(2);
            if (zzc3 == 0) {
                i24 = 0;
            } else if (zzc3 == 1) {
                i24 = 1;
            } else if (zzc3 == 2) {
                i24 = 2;
            }
            zzfc2.zzj(3);
            int zzc4 = zzfc2.zzc(11) + 1;
            i15 = zzc4 + zzc4;
            int zzc5 = zzfc2.zzc(2);
            if (zzc5 == 3) {
                i17 = 6;
                i13 = zzd[zzfc2.zzc(2)];
                i18 = 3;
            } else {
                i18 = zzfc2.zzc(2);
                i17 = zzb[i18];
                i13 = zzc[zzc5];
            }
            i14 = i17 * 256;
            int zzc6 = zzfc2.zzc(3);
            boolean zzl = zzfc.zzl();
            i12 = zze[zzc6] + (zzl ? 1 : 0);
            zzfc2.zzj(10);
            if (zzfc.zzl()) {
                zzfc2.zzj(8);
            }
            if (zzc6 == 0) {
                zzfc2.zzj(5);
                if (zzfc.zzl()) {
                    zzfc2.zzj(8);
                }
                i19 = 0;
                zzc6 = 0;
            } else {
                i19 = zzc6;
            }
            if (i24 == 1) {
                if (zzfc.zzl()) {
                    zzfc2.zzj(16);
                }
                i21 = 1;
            } else {
                i21 = i24;
            }
            if (zzfc.zzl()) {
                if (i19 > 2) {
                    zzfc2.zzj(2);
                }
                if ((i19 & 1) != 0 && i19 > 2) {
                    zzfc2.zzj(6);
                }
                if ((i19 & 4) != 0) {
                    zzfc2.zzj(6);
                }
                if (zzl && zzfc.zzl()) {
                    zzfc2.zzj(5);
                }
                if (i21 == 0) {
                    if (zzfc.zzl()) {
                        zzfc2.zzj(6);
                    }
                    if (i19 == 0 && zzfc.zzl()) {
                        zzfc2.zzj(6);
                    }
                    if (zzfc.zzl()) {
                        zzfc2.zzj(6);
                    }
                    int zzc7 = zzfc2.zzc(2);
                    if (zzc7 == 1) {
                        zzfc2.zzj(5);
                    } else if (zzc7 == 2) {
                        zzfc2.zzj(12);
                    } else if (zzc7 == 3) {
                        int zzc8 = zzfc2.zzc(5);
                        if (zzfc.zzl()) {
                            zzfc2.zzj(5);
                            if (zzfc.zzl()) {
                                zzfc2.zzj(4);
                            }
                            if (zzfc.zzl()) {
                                zzfc2.zzj(4);
                            }
                            if (zzfc.zzl()) {
                                zzfc2.zzj(4);
                            }
                            if (zzfc.zzl()) {
                                zzfc2.zzj(4);
                            }
                            if (zzfc.zzl()) {
                                zzfc2.zzj(4);
                            }
                            if (zzfc.zzl()) {
                                zzfc2.zzj(4);
                            }
                            if (zzfc.zzl()) {
                                zzfc2.zzj(4);
                            }
                            if (zzfc.zzl()) {
                                if (zzfc.zzl()) {
                                    zzfc2.zzj(4);
                                }
                                if (zzfc.zzl()) {
                                    zzfc2.zzj(4);
                                }
                            }
                        }
                        if (zzfc.zzl()) {
                            zzfc2.zzj(5);
                            if (zzfc.zzl()) {
                                zzfc2.zzj(7);
                                if (zzfc.zzl()) {
                                    i23 = 8;
                                    zzfc2.zzj(8);
                                    zzfc2.zzj((zzc8 + 2) * i23);
                                    zzfc.zzd();
                                }
                            }
                        }
                        i23 = 8;
                        zzfc2.zzj((zzc8 + 2) * i23);
                        zzfc.zzd();
                    }
                    if (i19 < 2) {
                        if (zzfc.zzl()) {
                            zzfc2.zzj(14);
                        }
                        if (zzc6 == 0 && zzfc.zzl()) {
                            zzfc2.zzj(14);
                        }
                    }
                    if (zzfc.zzl()) {
                        if (i18 == 0) {
                            zzfc2.zzj(5);
                            i21 = 0;
                            i18 = 0;
                        } else {
                            for (int i25 = 0; i25 < i17; i25++) {
                                if (zzfc.zzl()) {
                                    zzfc2.zzj(5);
                                }
                            }
                        }
                    }
                    i21 = 0;
                }
            }
            if (zzfc.zzl()) {
                zzfc2.zzj(5);
                if (i19 == 2) {
                    zzfc2.zzj(4);
                    i19 = 2;
                }
                if (i19 >= 6) {
                    zzfc2.zzj(2);
                }
                if (zzfc.zzl()) {
                    i22 = 8;
                    zzfc2.zzj(8);
                } else {
                    i22 = 8;
                }
                if (i19 == 0 && zzfc.zzl()) {
                    zzfc2.zzj(i22);
                }
                if (zzc5 < 3) {
                    zzfc.zzi();
                }
            }
            if (i21 == 0 && i18 != 3) {
                zzfc.zzi();
            }
            if (i21 == 2 && (i18 == 3 || zzfc.zzl())) {
                zzfc2.zzj(6);
            }
            if (zzfc.zzl() && zzfc2.zzc(6) == 1 && zzfc2.zzc(8) == 1) {
                str3 = MimeTypes.AUDIO_E_AC3_JOC;
            } else {
                str3 = MimeTypes.AUDIO_E_AC3;
            }
            str = str3;
            i11 = i24;
        } else {
            zzfc2.zzj(32);
            int zzc9 = zzfc2.zzc(2);
            if (zzc9 == 3) {
                str2 = null;
            } else {
                str2 = MimeTypes.AUDIO_AC3;
            }
            i15 = zze(zzc9, zzfc2.zzc(6));
            zzfc2.zzj(8);
            int zzc10 = zzfc2.zzc(3);
            if (!((zzc10 & 1) == 0 || zzc10 == 1)) {
                zzfc2.zzj(2);
            }
            if ((zzc10 & 4) != 0) {
                zzfc2.zzj(2);
            }
            if (zzc10 == 2) {
                zzfc2.zzj(2);
            }
            if (zzc9 < 3) {
                i16 = zzc[zzc9];
            } else {
                i16 = -1;
            }
            i12 = zze[zzc10] + (zzfc.zzl() ? 1 : 0);
            i14 = 1536;
            i11 = -1;
            str = str2;
        }
        return new zzvu(str, i11, i12, i13, i15, i14, (zzvt) null);
    }

    private static int zze(int i11, int i12) {
        int i13 = i12 / 2;
        if (i11 < 0 || i11 >= 3 || i12 < 0 || i13 >= 19) {
            return -1;
        }
        int i14 = zzc[i11];
        if (i14 == 44100) {
            int i15 = zzg[i13] + (i12 & 1);
            return i15 + i15;
        }
        int i16 = zzf[i13];
        if (i14 == 32000) {
            return i16 * 6;
        }
        return i16 * 4;
    }
}
