package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzaqu {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final short[] zzf;
    private int zzg;
    private short[] zzh;
    private int zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm = 0;
    private int zzn = 0;
    private float zzo = 1.0f;
    private float zzp = 1.0f;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu = 0;
    private int zzv;
    private int zzw;
    private int zzx;

    public zzaqu(int i11, int i12) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i11 / 400;
        int i13 = i11 / 65;
        this.zzd = i13;
        int i14 = i13 + i13;
        this.zze = i14;
        this.zzf = new short[i14];
        this.zzg = i14;
        int i15 = i12 * i14;
        this.zzh = new short[i15];
        this.zzi = i14;
        this.zzj = new short[i15];
        this.zzk = i14;
        this.zzl = new short[i15];
    }

    private final int zzg(short[] sArr, int i11, int i12, int i13) {
        int i14;
        int i15 = i11 * this.zzb;
        int i16 = 255;
        int i17 = 1;
        int i18 = 0;
        int i19 = 0;
        while (i12 <= i13) {
            int i21 = 0;
            for (int i22 = 0; i22 < i12; i22++) {
                short s11 = sArr[i15 + i22];
                short s12 = sArr[i15 + i12 + i22];
                if (s11 >= s12) {
                    i14 = s11 - s12;
                } else {
                    i14 = s12 - s11;
                }
                i21 += i14;
            }
            int i23 = i21 * i18;
            int i24 = i17 * i12;
            if (i23 < i24) {
                i17 = i21;
            }
            if (i23 < i24) {
                i18 = i12;
            }
            int i25 = i21 * i16;
            int i26 = i19 * i12;
            if (i25 > i26) {
                i19 = i21;
            }
            if (i25 > i26) {
                i16 = i12;
            }
            i12++;
        }
        this.zzw = i17 / i18;
        this.zzx = i19 / i16;
        return i18;
    }

    private final void zzh(short[] sArr, int i11, int i12) {
        zzk(i12);
        int i13 = this.zzb;
        System.arraycopy(sArr, i11 * i13, this.zzj, this.zzr * i13, i13 * i12);
        this.zzr += i12;
    }

    private final void zzi(short[] sArr, int i11, int i12) {
        int i13 = this.zze / i12;
        int i14 = this.zzb;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.zzf[i17] = (short) (i18 / i15);
        }
    }

    private final void zzj(int i11) {
        int i12 = this.zzq;
        int i13 = this.zzg;
        if (i12 + i11 > i13) {
            int i14 = i13 + (i13 / 2) + i11;
            this.zzg = i14;
            this.zzh = Arrays.copyOf(this.zzh, i14 * this.zzb);
        }
    }

    private final void zzk(int i11) {
        int i12 = this.zzr;
        int i13 = this.zzi;
        if (i12 + i11 > i13) {
            int i14 = i13 + (i13 / 2) + i11;
            this.zzi = i14;
            this.zzj = Arrays.copyOf(this.zzj, i14 * this.zzb);
        }
    }

    private static void zzl(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = (i13 * i12) + i16;
            int i18 = (i15 * i12) + i16;
            int i19 = (i14 * i12) + i16;
            for (int i21 = 0; i21 < i11; i21++) {
                sArr[i17] = (short) (((sArr2[i19] * (i11 - i21)) + (sArr3[i18] * i21)) / i11);
                i17 += i12;
                i19 += i12;
                i18 += i12;
            }
        }
    }

    private final void zzm() {
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z11;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22 = this.zzr;
        float f11 = this.zzo / this.zzp;
        double d11 = (double) f11;
        int i23 = 1;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            int i24 = this.zzq;
            if (i24 >= this.zze) {
                int i25 = 0;
                while (true) {
                    int i26 = this.zzt;
                    if (i26 > 0) {
                        int min = Math.min(this.zze, i26);
                        zzh(this.zzh, i25, min);
                        this.zzt -= min;
                        i25 += min;
                    } else {
                        short[] sArr = this.zzh;
                        int i27 = this.zza;
                        if (i27 > 4000) {
                            i15 = i27 / 4000;
                        } else {
                            i15 = i23;
                        }
                        if (this.zzb == i23 && i15 == i23) {
                            i16 = zzg(sArr, i25, this.zzc, this.zzd);
                        } else {
                            zzi(sArr, i25, i15);
                            int zzg2 = zzg(this.zzf, 0, this.zzc / i15, this.zzd / i15);
                            if (i15 != i23) {
                                int i28 = zzg2 * i15;
                                int i29 = i15 * 4;
                                int i31 = i28 - i29;
                                int i32 = i28 + i29;
                                int i33 = this.zzc;
                                if (i31 < i33) {
                                    i31 = i33;
                                }
                                int i34 = this.zzd;
                                if (i32 > i34) {
                                    i32 = i34;
                                }
                                if (this.zzb == i23) {
                                    i16 = zzg(sArr, i25, i31, i32);
                                } else {
                                    zzi(sArr, i25, i23);
                                    i16 = zzg(this.zzf, 0, i31, i32);
                                }
                            } else {
                                i16 = zzg2;
                            }
                        }
                        int i35 = this.zzw;
                        int i36 = this.zzx;
                        if (i35 == 0 || (i21 = this.zzu) == 0 || i36 > i35 * 3 || i35 + i35 <= this.zzv * 3) {
                            i17 = i16;
                        } else {
                            i17 = i21;
                        }
                        this.zzv = i35;
                        this.zzu = i16;
                        if (d11 > 1.0d) {
                            short[] sArr2 = this.zzh;
                            if (f11 >= 2.0f) {
                                i19 = (int) (((float) i17) / (-1.0f + f11));
                            } else {
                                this.zzt = (int) ((((float) i17) * (2.0f - f11)) / (-1.0f + f11));
                                i19 = i17;
                            }
                            zzk(i19);
                            int i37 = i19;
                            zzl(i19, this.zzb, this.zzj, this.zzr, sArr2, i25, sArr2, i25 + i17);
                            this.zzr += i37;
                            i25 += i17 + i37;
                        } else {
                            int i38 = i17;
                            short[] sArr3 = this.zzh;
                            if (f11 < 0.5f) {
                                i18 = (int) ((((float) i38) * f11) / (1.0f - f11));
                            } else {
                                this.zzt = (int) ((((float) i38) * ((f11 + f11) - 4.0f)) / (1.0f - f11));
                                i18 = i38;
                            }
                            int i39 = i38 + i18;
                            zzk(i39);
                            int i41 = this.zzb;
                            System.arraycopy(sArr3, i25 * i41, this.zzj, this.zzr * i41, i41 * i38);
                            zzl(i18, this.zzb, this.zzj, this.zzr + i38, sArr3, i38 + i25, sArr3, i25);
                            this.zzr += i39;
                            i25 += i18;
                        }
                    }
                    if (this.zze + i25 > i24) {
                        break;
                    }
                    i23 = 1;
                }
                int i42 = this.zzq - i25;
                short[] sArr4 = this.zzh;
                int i43 = this.zzb;
                System.arraycopy(sArr4, i25 * i43, sArr4, 0, i43 * i42);
                this.zzq = i42;
            }
        } else {
            zzh(this.zzh, 0, this.zzq);
            this.zzq = 0;
        }
        float f12 = this.zzp;
        if (f12 != 1.0f && this.zzr != i22) {
            int i44 = this.zza;
            int i45 = (int) (((float) i44) / f12);
            while (true) {
                if (i45 <= 16384 && i44 <= 16384) {
                    break;
                }
                i45 /= 2;
                i44 /= 2;
            }
            int i46 = this.zzr - i22;
            int i47 = this.zzs;
            int i48 = this.zzk;
            if (i47 + i46 > i48) {
                int i49 = i48 + (i48 / 2) + i46;
                this.zzk = i49;
                this.zzl = Arrays.copyOf(this.zzl, i49 * this.zzb);
            }
            short[] sArr5 = this.zzj;
            int i50 = this.zzb;
            System.arraycopy(sArr5, i22 * i50, this.zzl, this.zzs * i50, i50 * i46);
            this.zzr = i22;
            this.zzs += i46;
            int i51 = 0;
            while (true) {
                i11 = this.zzs;
                i12 = i11 - 1;
                if (i51 >= i12) {
                    break;
                }
                while (true) {
                    i13 = this.zzm + 1;
                    i14 = this.zzn;
                    if (i13 * i45 <= i14 * i44) {
                        break;
                    }
                    zzk(1);
                    int i52 = 0;
                    while (true) {
                        int i53 = this.zzb;
                        if (i52 >= i53) {
                            break;
                        }
                        short[] sArr6 = this.zzj;
                        int i54 = this.zzr;
                        short[] sArr7 = this.zzl;
                        int i55 = (i51 * i53) + i52;
                        short s11 = sArr7[i55];
                        short s12 = sArr7[i55 + i53];
                        int i56 = this.zzn;
                        int i57 = this.zzm;
                        int i58 = (i57 + 1) * i45;
                        int i59 = i58 - (i56 * i44);
                        int i60 = i58 - (i57 * i45);
                        sArr6[(i54 * i53) + i52] = (short) (((s11 * i59) + ((i60 - i59) * s12)) / i60);
                        i52++;
                    }
                    this.zzn++;
                    this.zzr++;
                }
                this.zzm = i13;
                if (i13 == i44) {
                    this.zzm = 0;
                    if (i14 == i45) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zzawm.zze(z11);
                    this.zzn = 0;
                }
                i51++;
            }
            if (i12 != 0) {
                short[] sArr8 = this.zzl;
                int i61 = this.zzb;
                System.arraycopy(sArr8, i12 * i61, sArr8, 0, (i11 - i12) * i61);
                this.zzs -= i12;
            }
        }
    }

    public final int zza() {
        return this.zzr;
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzb, this.zzr);
        shortBuffer.put(this.zzj, 0, this.zzb * min);
        int i11 = this.zzr - min;
        this.zzr = i11;
        short[] sArr = this.zzj;
        int i12 = this.zzb;
        System.arraycopy(sArr, min * i12, sArr, 0, i11 * i12);
    }

    public final void zzc() {
        int i11;
        int i12 = this.zzq;
        float f11 = this.zzo;
        float f12 = this.zzp;
        int i13 = this.zzr + ((int) ((((((float) i12) / (f11 / f12)) + ((float) this.zzs)) / f12) + 0.5f));
        int i14 = this.zze;
        zzj(i14 + i14 + i12);
        int i15 = 0;
        while (true) {
            int i16 = this.zze;
            i11 = i16 + i16;
            int i17 = this.zzb;
            if (i15 >= i11 * i17) {
                break;
            }
            this.zzh[(i17 * i12) + i15] = 0;
            i15++;
        }
        this.zzq += i11;
        zzm();
        if (this.zzr > i13) {
            this.zzr = i13;
        }
        this.zzq = 0;
        this.zzt = 0;
        this.zzs = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i11 = this.zzb;
        int i12 = remaining / i11;
        int i13 = i11 * i12;
        zzj(i12);
        shortBuffer.get(this.zzh, this.zzq * this.zzb, (i13 + i13) / 2);
        this.zzq += i12;
        zzm();
    }

    public final void zze(float f11) {
        this.zzp = f11;
    }

    public final void zzf(float f11) {
        this.zzo = f11;
    }
}
