package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.database.core.ValidationPath;
import java.util.Arrays;
import java.util.Collections;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class zzadn implements zzadr {
    private static final byte[] zza = {73, 68, TarConstants.LF_CHR};
    private final boolean zzb;
    private final zzfc zzc = new zzfc(new byte[7], 7);
    private final zzfd zzd = new zzfd(Arrays.copyOf(zza, 10));
    @Nullable
    private final String zze;
    private String zzf;
    private zzxt zzg;
    private zzxt zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzxt zzu;
    private long zzv;

    public zzadn(boolean z11, @Nullable String str) {
        zzh();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = C.TIME_UNSET;
        this.zzt = C.TIME_UNSET;
        this.zzb = z11;
        this.zze = str;
    }

    public static boolean zzf(int i11) {
        return (i11 & 65526) == 65520;
    }

    private final void zzg() {
        this.zzm = false;
        zzh();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzi() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private final void zzj(zzxt zzxt, long j11, int i11, int i12) {
        this.zzi = 4;
        this.zzj = i11;
        this.zzu = zzxt;
        this.zzv = j11;
        this.zzs = i12;
    }

    private final boolean zzk(zzfd zzfd, byte[] bArr, int i11) {
        int min = Math.min(zzfd.zza(), i11 - this.zzj);
        zzfd.zzB(bArr, this.zzj, min);
        int i12 = this.zzj + min;
        this.zzj = i12;
        if (i12 == i11) {
            return true;
        }
        return false;
    }

    private static final boolean zzl(byte b11, byte b12) {
        return zzf((b12 & 255) | 65280);
    }

    private static final boolean zzm(zzfd zzfd, byte[] bArr, int i11) {
        if (zzfd.zza() < i11) {
            return false;
        }
        zzfd.zzB(bArr, 0, i11);
        return true;
    }

    public final void zza(zzfd zzfd) throws zzbj {
        int i11;
        byte b11;
        int i12;
        int i13;
        boolean z11;
        int i14;
        zzfd zzfd2 = zzfd;
        this.zzg.getClass();
        int i15 = zzfn.zza;
        while (zzfd.zza() > 0) {
            int i16 = this.zzi;
            int i17 = 13;
            int i18 = 2;
            if (i16 == 0) {
                byte[] zzH = zzfd.zzH();
                int zzc2 = zzfd.zzc();
                int zzd2 = zzfd.zzd();
                while (true) {
                    if (zzc2 >= zzd2) {
                        zzfd2.zzF(zzc2);
                        break;
                    }
                    i11 = zzc2 + 1;
                    b11 = zzH[zzc2] & 255;
                    if (this.zzk == 512 && zzl((byte) -1, (byte) b11)) {
                        if (this.zzm) {
                            break;
                        }
                        int i19 = i11 - 2;
                        zzfd2.zzF(i19 + 1);
                        if (zzm(zzfd2, this.zzc.zza, 1)) {
                            this.zzc.zzh(4);
                            int zzc3 = this.zzc.zzc(1);
                            int i21 = this.zzn;
                            if (i21 == -1 || zzc3 == i21) {
                                if (this.zzo != -1) {
                                    if (!zzm(zzfd2, this.zzc.zza, 1)) {
                                        break;
                                    }
                                    this.zzc.zzh(i18);
                                    if (this.zzc.zzc(4) == this.zzo) {
                                        zzfd2.zzF(i19 + 2);
                                    }
                                }
                                if (!zzm(zzfd2, this.zzc.zza, 4)) {
                                    break;
                                }
                                this.zzc.zzh(14);
                                int zzc4 = this.zzc.zzc(i17);
                                if (zzc4 >= 7) {
                                    byte[] zzH2 = zzfd.zzH();
                                    int zzd3 = zzfd.zzd();
                                    int i22 = i19 + zzc4;
                                    if (i22 >= zzd3) {
                                        break;
                                    }
                                    if ((r8 = zzH2[i22]) == -1) {
                                    }
                                }
                            }
                        }
                    }
                    int i23 = this.zzk;
                    byte b12 = i23 | b11;
                    if (b12 == 329) {
                        i12 = 2;
                        i13 = ValidationPath.MAX_PATH_LENGTH_BYTES;
                    } else if (b12 == 511) {
                        i12 = 2;
                        i13 = 512;
                    } else if (b12 != 836) {
                        if (b12 == 1075) {
                            this.zzi = 2;
                            this.zzj = 3;
                            this.zzs = 0;
                            this.zzd.zzF(0);
                            zzfd2.zzF(i11);
                            break;
                        } else if (i23 != 256) {
                            this.zzk = 256;
                            zzc2 = i11 - 1;
                            i17 = 13;
                            i18 = 2;
                        } else {
                            i12 = 2;
                            i18 = i12;
                            zzc2 = i11;
                            i17 = 13;
                        }
                    } else {
                        i12 = 2;
                        i13 = 1024;
                    }
                    this.zzk = i13;
                    i18 = i12;
                    zzc2 = i11;
                    i17 = 13;
                }
                this.zzp = (b11 & 8) >> 3;
                if (1 != ((b11 & 1) ^ 1)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                this.zzl = z11;
                if (!this.zzm) {
                    this.zzi = 1;
                    this.zzj = 0;
                } else {
                    zzi();
                }
                zzfd2.zzF(i11);
            } else if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        int min = Math.min(zzfd.zza(), this.zzs - this.zzj);
                        this.zzu.zzq(zzfd2, min);
                        int i24 = this.zzj + min;
                        this.zzj = i24;
                        int i25 = this.zzs;
                        if (i24 == i25) {
                            long j11 = this.zzt;
                            if (j11 != C.TIME_UNSET) {
                                this.zzu.zzs(j11, 1, i25, 0, (zzxs) null);
                                this.zzt += this.zzv;
                            }
                            zzh();
                        }
                    } else {
                        if (true != this.zzl) {
                            i14 = 5;
                        } else {
                            i14 = 7;
                        }
                        if (zzk(zzfd2, this.zzc.zza, i14)) {
                            this.zzc.zzh(0);
                            if (!this.zzq) {
                                int zzc5 = this.zzc.zzc(2) + 1;
                                if (zzc5 != 2) {
                                    StringBuilder sb2 = new StringBuilder(61);
                                    sb2.append("Detected audio object type: ");
                                    sb2.append(zzc5);
                                    sb2.append(", but assuming AAC LC.");
                                    Log.w("AdtsReader", sb2.toString());
                                }
                                this.zzc.zzj(5);
                                int zzc6 = this.zzc.zzc(3);
                                int i26 = this.zzo;
                                byte[] bArr = {(byte) (((i26 >> 1) & 7) | 16), (byte) (((zzc6 << 3) & 120) | ((i26 << 7) & 128))};
                                zzvr zza2 = zzvs.zza(bArr);
                                zzz zzz = new zzz();
                                zzz.zzH(this.zzf);
                                zzz.zzS(MimeTypes.AUDIO_AAC);
                                zzz.zzx(zza2.zzc);
                                zzz.zzw(zza2.zzb);
                                zzz.zzT(zza2.zza);
                                zzz.zzI(Collections.singletonList(bArr));
                                zzz.zzK(this.zze);
                                zzab zzY = zzz.zzY();
                                this.zzr = 1024000000 / ((long) zzY.zzA);
                                this.zzg.zzk(zzY);
                                this.zzq = true;
                            } else {
                                this.zzc.zzj(10);
                            }
                            this.zzc.zzj(4);
                            int zzc7 = this.zzc.zzc(13) - 7;
                            if (this.zzl) {
                                zzc7 -= 2;
                            }
                            zzj(this.zzg, this.zzr, 0, zzc7);
                        }
                    }
                } else if (zzk(zzfd2, this.zzd.zzH(), 10)) {
                    this.zzh.zzq(this.zzd, 10);
                    this.zzd.zzF(6);
                    zzj(this.zzh, 0, 10, 10 + this.zzd.zzj());
                }
            } else if (zzfd.zza() != 0) {
                this.zzc.zza[0] = zzfd.zzH()[zzfd.zzc()];
                this.zzc.zzh(2);
                int zzc8 = this.zzc.zzc(4);
                int i27 = this.zzo;
                if (i27 == -1 || zzc8 == i27) {
                    if (!this.zzm) {
                        this.zzm = true;
                        this.zzn = this.zzp;
                        this.zzo = zzc8;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        zzafd.zzc();
        this.zzf = zzafd.zzb();
        zzxt zzv2 = zzws.zzv(zzafd.zza(), 1);
        this.zzg = zzv2;
        this.zzu = zzv2;
        if (this.zzb) {
            zzafd.zzc();
            zzxt zzv3 = zzws.zzv(zzafd.zza(), 5);
            this.zzh = zzv3;
            zzz zzz = new zzz();
            zzz.zzH(zzafd.zzb());
            zzz.zzS(MimeTypes.APPLICATION_ID3);
            zzv3.zzk(zzz.zzY());
            return;
        }
        this.zzh = new zzwo();
    }

    public final void zzc() {
    }

    public final void zzd(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.zzt = j11;
        }
    }

    public final void zze() {
        this.zzt = C.TIME_UNSET;
        zzg();
    }
}
