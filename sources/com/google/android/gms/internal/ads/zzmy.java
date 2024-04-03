package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzmy {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzmy(int i11, int i12, float f11, float f12, int i13) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = f11;
        this.zzd = f12;
        this.zze = ((float) i11) / ((float) i13);
        this.zzf = i11 / 400;
        int i14 = i11 / 65;
        this.zzg = i14;
        int i15 = i14 + i14;
        this.zzh = i15;
        this.zzi = new short[i15];
        int i16 = i15 * i12;
        this.zzj = new short[i16];
        this.zzl = new short[i16];
        this.zzn = new short[i16];
    }

    private final int zzg(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.zzb;
        int i15 = 255;
        int i16 = 1;
        int i17 = 0;
        int i18 = 0;
        while (i12 <= i13) {
            int i19 = 0;
            for (int i21 = 0; i21 < i12; i21++) {
                i19 += Math.abs(sArr[i14 + i21] - sArr[(i14 + i12) + i21]);
            }
            int i22 = i19 * i17;
            int i23 = i16 * i12;
            if (i22 < i23) {
                i16 = i19;
            }
            if (i22 < i23) {
                i17 = i12;
            }
            int i24 = i19 * i15;
            int i25 = i18 * i12;
            if (i24 > i25) {
                i18 = i19;
            }
            if (i24 > i25) {
                i15 = i12;
            }
            i12++;
        }
        this.zzu = i16 / i17;
        this.zzv = i18 / i15;
        return i17;
    }

    private final void zzh(short[] sArr, int i11, int i12) {
        short[] zzl2 = zzl(this.zzl, this.zzm, i12);
        this.zzl = zzl2;
        int i13 = this.zzb;
        System.arraycopy(sArr, i11 * i13, zzl2, this.zzm * i13, i13 * i12);
        this.zzm += i12;
    }

    private final void zzi(short[] sArr, int i11, int i12) {
        int i13 = this.zzh / i12;
        int i14 = this.zzb;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.zzi[i17] = (short) (i18 / i15);
        }
    }

    private static void zzj(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
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

    private final void zzk() {
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
        int i22 = this.zzm;
        float f11 = this.zzc;
        float f12 = this.zzd;
        float f13 = f11 / f12;
        float f14 = this.zze * f12;
        double d11 = (double) f13;
        float f15 = 1.0f;
        int i23 = 1;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            int i24 = this.zzk;
            if (i24 >= this.zzh) {
                int i25 = 0;
                while (true) {
                    int i26 = this.zzr;
                    if (i26 > 0) {
                        int min = Math.min(this.zzh, i26);
                        zzh(this.zzj, i25, min);
                        this.zzr -= min;
                        i25 += min;
                    } else {
                        short[] sArr = this.zzj;
                        int i27 = this.zza;
                        if (i27 > 4000) {
                            i15 = i27 / 4000;
                        } else {
                            i15 = i23;
                        }
                        if (this.zzb == i23 && i15 == i23) {
                            i16 = zzg(sArr, i25, this.zzf, this.zzg);
                        } else {
                            zzi(sArr, i25, i15);
                            int zzg2 = zzg(this.zzi, 0, this.zzf / i15, this.zzg / i15);
                            if (i15 != i23) {
                                int i28 = zzg2 * i15;
                                int i29 = i15 * 4;
                                int i31 = i28 - i29;
                                int i32 = i28 + i29;
                                int i33 = this.zzf;
                                if (i31 < i33) {
                                    i31 = i33;
                                }
                                int i34 = this.zzg;
                                if (i32 > i34) {
                                    i32 = i34;
                                }
                                if (this.zzb == i23) {
                                    i16 = zzg(sArr, i25, i31, i32);
                                } else {
                                    zzi(sArr, i25, i23);
                                    i16 = zzg(this.zzi, 0, i31, i32);
                                }
                            } else {
                                i16 = zzg2;
                            }
                        }
                        int i35 = this.zzu;
                        int i36 = this.zzv;
                        if (i35 == 0 || (i21 = this.zzs) == 0 || i36 > i35 * 3 || i35 + i35 <= this.zzt * 3) {
                            i17 = i16;
                        } else {
                            i17 = i21;
                        }
                        this.zzt = i35;
                        this.zzs = i16;
                        if (d11 > 1.0d) {
                            short[] sArr2 = this.zzj;
                            if (f13 >= 2.0f) {
                                i19 = (int) (((float) i17) / (-1.0f + f13));
                            } else {
                                this.zzr = (int) ((((float) i17) * (2.0f - f13)) / (-1.0f + f13));
                                i19 = i17;
                            }
                            short[] zzl2 = zzl(this.zzl, this.zzm, i19);
                            this.zzl = zzl2;
                            int i37 = i19;
                            short[] sArr3 = sArr2;
                            zzj(i19, this.zzb, zzl2, this.zzm, sArr3, i25, sArr3, i25 + i17);
                            this.zzm += i37;
                            i25 += i17 + i37;
                        } else {
                            int i38 = i17;
                            short[] sArr4 = this.zzj;
                            if (f13 < 0.5f) {
                                i18 = (int) ((((float) i38) * f13) / (f15 - f13));
                            } else {
                                this.zzr = (int) ((((float) i38) * ((f13 + f13) - 4.0f)) / (f15 - f13));
                                i18 = i38;
                            }
                            int i39 = i38 + i18;
                            short[] zzl3 = zzl(this.zzl, this.zzm, i39);
                            this.zzl = zzl3;
                            int i41 = this.zzb;
                            System.arraycopy(sArr4, i25 * i41, zzl3, this.zzm * i41, i41 * i38);
                            zzj(i18, this.zzb, this.zzl, this.zzm + i38, sArr4, i25 + i38, sArr4, i25);
                            this.zzm += i39;
                            i25 += i18;
                        }
                    }
                    if (this.zzh + i25 > i24) {
                        break;
                    }
                    f15 = 1.0f;
                    i23 = 1;
                }
                int i42 = this.zzk - i25;
                short[] sArr5 = this.zzj;
                int i43 = this.zzb;
                System.arraycopy(sArr5, i25 * i43, sArr5, 0, i43 * i42);
                this.zzk = i42;
                f15 = 1.0f;
            }
        } else {
            zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
        }
        if (f14 != f15 && this.zzm != i22) {
            int i44 = this.zza;
            int i45 = (int) (((float) i44) / f14);
            while (true) {
                if (i45 <= 16384 && i44 <= 16384) {
                    break;
                }
                i45 /= 2;
                i44 /= 2;
            }
            int i46 = this.zzm - i22;
            short[] zzl4 = zzl(this.zzn, this.zzo, i46);
            this.zzn = zzl4;
            short[] sArr6 = this.zzl;
            int i47 = this.zzb;
            System.arraycopy(sArr6, i22 * i47, zzl4, this.zzo * i47, i47 * i46);
            this.zzm = i22;
            this.zzo += i46;
            int i48 = 0;
            while (true) {
                i11 = this.zzo;
                i12 = i11 - 1;
                if (i48 >= i12) {
                    break;
                }
                while (true) {
                    i13 = this.zzp + 1;
                    i14 = this.zzq;
                    if (i13 * i45 <= i14 * i44) {
                        break;
                    }
                    this.zzl = zzl(this.zzl, this.zzm, 1);
                    int i49 = 0;
                    while (true) {
                        int i50 = this.zzb;
                        if (i49 >= i50) {
                            break;
                        }
                        short[] sArr7 = this.zzl;
                        int i51 = this.zzm;
                        short[] sArr8 = this.zzn;
                        int i52 = (i48 * i50) + i49;
                        short s11 = sArr8[i52];
                        short s12 = sArr8[i52 + i50];
                        int i53 = this.zzq;
                        int i54 = this.zzp;
                        int i55 = (i54 + 1) * i45;
                        int i56 = i55 - (i53 * i44);
                        int i57 = i55 - (i54 * i45);
                        sArr7[(i51 * i50) + i49] = (short) (((s11 * i56) + ((i57 - i56) * s12)) / i57);
                        i49++;
                    }
                    this.zzq++;
                    this.zzm++;
                }
                this.zzp = i13;
                if (i13 == i44) {
                    this.zzp = 0;
                    if (i14 == i45) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zzdy.zzf(z11);
                    this.zzq = 0;
                }
                i48++;
            }
            if (i12 != 0) {
                short[] sArr9 = this.zzn;
                int i58 = this.zzb;
                System.arraycopy(sArr9, i12 * i58, sArr9, 0, (i11 - i12) * i58);
                this.zzo -= i12;
            }
        }
    }

    private final short[] zzl(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.zzb;
        int i14 = length / i13;
        if (i11 + i12 <= i14) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    public final int zza() {
        int i11 = this.zzm * this.zzb;
        return i11 + i11;
    }

    public final int zzb() {
        int i11 = this.zzk * this.zzb;
        return i11 + i11;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzb, this.zzm);
        shortBuffer.put(this.zzl, 0, this.zzb * min);
        int i11 = this.zzm - min;
        this.zzm = i11;
        short[] sArr = this.zzl;
        int i12 = this.zzb;
        System.arraycopy(sArr, min * i12, sArr, 0, i11 * i12);
    }

    public final void zze() {
        int i11;
        int i12 = this.zzk;
        float f11 = this.zzc;
        float f12 = this.zzd;
        int i13 = this.zzm + ((int) ((((((float) i12) / (f11 / f12)) + ((float) this.zzo)) / (this.zze * f12)) + 0.5f));
        short[] sArr = this.zzj;
        int i14 = this.zzh;
        this.zzj = zzl(sArr, i12, i14 + i14 + i12);
        int i15 = 0;
        while (true) {
            int i16 = this.zzh;
            i11 = i16 + i16;
            int i17 = this.zzb;
            if (i15 >= i11 * i17) {
                break;
            }
            this.zzj[(i17 * i12) + i15] = 0;
            i15++;
        }
        this.zzk += i11;
        zzk();
        if (this.zzm > i13) {
            this.zzm = i13;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i11 = this.zzb;
        int i12 = remaining / i11;
        int i13 = i11 * i12;
        short[] zzl2 = zzl(this.zzj, this.zzk, i12);
        this.zzj = zzl2;
        shortBuffer.get(zzl2, this.zzk * this.zzb, (i13 + i13) / 2);
        this.zzk += i12;
        zzk();
    }
}
