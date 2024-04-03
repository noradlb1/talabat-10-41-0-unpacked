package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzg {

    public static final class zza extends zzuq<zza> {
        public static final zzur<zzl, zza> zzpx = zzur.zza(11, zza.class, 810);
        private static final zza[] zzpy = new zza[0];
        public int[] zzpz;
        public int[] zzqa;
        public int[] zzqb;
        private int zzqc = 0;
        public int[] zzqd;
        public int zzqe;
        private int zzqf;

        public zza() {
            int[] iArr = zzuz.zzbcw;
            this.zzpz = iArr;
            this.zzqa = iArr;
            this.zzqb = iArr;
            this.zzqd = iArr;
            this.zzqe = 0;
            this.zzqf = 0;
            this.zzbhb = null;
            this.zzbhl = -1;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (!zzuu.equals(this.zzpz, zza.zzpz) || !zzuu.equals(this.zzqa, zza.zzqa) || !zzuu.equals(this.zzqb, zza.zzqb) || this.zzqc != zza.zzqc || !zzuu.equals(this.zzqd, zza.zzqd) || this.zzqe != zza.zzqe || this.zzqf != zza.zzqf) {
                return false;
            }
            zzus zzus = this.zzbhb;
            if (zzus != null && !zzus.isEmpty()) {
                return this.zzbhb.equals(zza.zzbhb);
            }
            zzus zzus2 = zza.zzbhb;
            if (zzus2 == null || zzus2.isEmpty()) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i11;
            int hashCode = (((((((((((((((zza.class.getName().hashCode() + 527) * 31) + zzuu.hashCode(this.zzpz)) * 31) + zzuu.hashCode(this.zzqa)) * 31) + zzuu.hashCode(this.zzqb)) * 31) + this.zzqc) * 31) + zzuu.hashCode(this.zzqd)) * 31) + this.zzqe) * 31) + this.zzqf) * 31;
            zzus zzus = this.zzbhb;
            if (zzus == null || zzus.isEmpty()) {
                i11 = 0;
            } else {
                i11 = this.zzbhb.hashCode();
            }
            return hashCode + i11;
        }

        public final void zza(zzuo zzuo) throws IOException {
            int[] iArr = this.zzpz;
            int i11 = 0;
            if (iArr != null && iArr.length > 0) {
                int i12 = 0;
                while (true) {
                    int[] iArr2 = this.zzpz;
                    if (i12 >= iArr2.length) {
                        break;
                    }
                    zzuo.zze(1, iArr2[i12]);
                    i12++;
                }
            }
            int[] iArr3 = this.zzqa;
            if (iArr3 != null && iArr3.length > 0) {
                int i13 = 0;
                while (true) {
                    int[] iArr4 = this.zzqa;
                    if (i13 >= iArr4.length) {
                        break;
                    }
                    zzuo.zze(2, iArr4[i13]);
                    i13++;
                }
            }
            int[] iArr5 = this.zzqb;
            if (iArr5 != null && iArr5.length > 0) {
                int i14 = 0;
                while (true) {
                    int[] iArr6 = this.zzqb;
                    if (i14 >= iArr6.length) {
                        break;
                    }
                    zzuo.zze(3, iArr6[i14]);
                    i14++;
                }
            }
            int i15 = this.zzqc;
            if (i15 != 0) {
                zzuo.zze(4, i15);
            }
            int[] iArr7 = this.zzqd;
            if (iArr7 != null && iArr7.length > 0) {
                while (true) {
                    int[] iArr8 = this.zzqd;
                    if (i11 >= iArr8.length) {
                        break;
                    }
                    zzuo.zze(5, iArr8[i11]);
                    i11++;
                }
            }
            int i16 = this.zzqe;
            if (i16 != 0) {
                zzuo.zze(6, i16);
            }
            int i17 = this.zzqf;
            if (i17 != 0) {
                zzuo.zze(7, i17);
            }
            super.zza(zzuo);
        }

        public final int zzy() {
            int[] iArr;
            int[] iArr2;
            int[] iArr3;
            int[] iArr4;
            int zzy = super.zzy();
            int[] iArr5 = this.zzpz;
            int i11 = 0;
            if (iArr5 != null && iArr5.length > 0) {
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    iArr4 = this.zzpz;
                    if (i12 >= iArr4.length) {
                        break;
                    }
                    i13 += zzuo.zzbc(iArr4[i12]);
                    i12++;
                }
                zzy = zzy + i13 + (iArr4.length * 1);
            }
            int[] iArr6 = this.zzqa;
            if (iArr6 != null && iArr6.length > 0) {
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    iArr3 = this.zzqa;
                    if (i14 >= iArr3.length) {
                        break;
                    }
                    i15 += zzuo.zzbc(iArr3[i14]);
                    i14++;
                }
                zzy = zzy + i15 + (iArr3.length * 1);
            }
            int[] iArr7 = this.zzqb;
            if (iArr7 != null && iArr7.length > 0) {
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    iArr2 = this.zzqb;
                    if (i16 >= iArr2.length) {
                        break;
                    }
                    i17 += zzuo.zzbc(iArr2[i16]);
                    i16++;
                }
                zzy = zzy + i17 + (iArr2.length * 1);
            }
            int i18 = this.zzqc;
            if (i18 != 0) {
                zzy += zzuo.zzi(4, i18);
            }
            int[] iArr8 = this.zzqd;
            if (iArr8 != null && iArr8.length > 0) {
                int i19 = 0;
                while (true) {
                    iArr = this.zzqd;
                    if (i11 >= iArr.length) {
                        break;
                    }
                    i19 += zzuo.zzbc(iArr[i11]);
                    i11++;
                }
                zzy = zzy + i19 + (iArr.length * 1);
            }
            int i21 = this.zzqe;
            if (i21 != 0) {
                zzy += zzuo.zzi(6, i21);
            }
            int i22 = this.zzqf;
            if (i22 != 0) {
                return zzy + zzuo.zzi(7, i22);
            }
            return zzy;
        }

        public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
            while (true) {
                int zzni = zzun.zzni();
                switch (zzni) {
                    case 0:
                        return this;
                    case 8:
                        int zzb = zzuz.zzb(zzun, 8);
                        int[] iArr = this.zzpz;
                        int length = iArr == null ? 0 : iArr.length;
                        int i11 = zzb + length;
                        int[] iArr2 = new int[i11];
                        if (length != 0) {
                            System.arraycopy(iArr, 0, iArr2, 0, length);
                        }
                        while (length < i11 - 1) {
                            iArr2[length] = zzun.zzoa();
                            zzun.zzni();
                            length++;
                        }
                        iArr2[length] = zzun.zzoa();
                        this.zzpz = iArr2;
                        break;
                    case 10:
                        int zzaq = zzun.zzaq(zzun.zzoa());
                        int position = zzun.getPosition();
                        int i12 = 0;
                        while (zzun.zzrv() > 0) {
                            zzun.zzoa();
                            i12++;
                        }
                        zzun.zzbz(position);
                        int[] iArr3 = this.zzpz;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int i13 = i12 + length2;
                        int[] iArr4 = new int[i13];
                        if (length2 != 0) {
                            System.arraycopy(iArr3, 0, iArr4, 0, length2);
                        }
                        while (length2 < i13) {
                            iArr4[length2] = zzun.zzoa();
                            length2++;
                        }
                        this.zzpz = iArr4;
                        zzun.zzar(zzaq);
                        break;
                    case 16:
                        int zzb2 = zzuz.zzb(zzun, 16);
                        int[] iArr5 = this.zzqa;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int i14 = zzb2 + length3;
                        int[] iArr6 = new int[i14];
                        if (length3 != 0) {
                            System.arraycopy(iArr5, 0, iArr6, 0, length3);
                        }
                        while (length3 < i14 - 1) {
                            iArr6[length3] = zzun.zzoa();
                            zzun.zzni();
                            length3++;
                        }
                        iArr6[length3] = zzun.zzoa();
                        this.zzqa = iArr6;
                        break;
                    case 18:
                        int zzaq2 = zzun.zzaq(zzun.zzoa());
                        int position2 = zzun.getPosition();
                        int i15 = 0;
                        while (zzun.zzrv() > 0) {
                            zzun.zzoa();
                            i15++;
                        }
                        zzun.zzbz(position2);
                        int[] iArr7 = this.zzqa;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int i16 = i15 + length4;
                        int[] iArr8 = new int[i16];
                        if (length4 != 0) {
                            System.arraycopy(iArr7, 0, iArr8, 0, length4);
                        }
                        while (length4 < i16) {
                            iArr8[length4] = zzun.zzoa();
                            length4++;
                        }
                        this.zzqa = iArr8;
                        zzun.zzar(zzaq2);
                        break;
                    case 24:
                        int zzb3 = zzuz.zzb(zzun, 24);
                        int[] iArr9 = this.zzqb;
                        int length5 = iArr9 == null ? 0 : iArr9.length;
                        int i17 = zzb3 + length5;
                        int[] iArr10 = new int[i17];
                        if (length5 != 0) {
                            System.arraycopy(iArr9, 0, iArr10, 0, length5);
                        }
                        while (length5 < i17 - 1) {
                            iArr10[length5] = zzun.zzoa();
                            zzun.zzni();
                            length5++;
                        }
                        iArr10[length5] = zzun.zzoa();
                        this.zzqb = iArr10;
                        break;
                    case 26:
                        int zzaq3 = zzun.zzaq(zzun.zzoa());
                        int position3 = zzun.getPosition();
                        int i18 = 0;
                        while (zzun.zzrv() > 0) {
                            zzun.zzoa();
                            i18++;
                        }
                        zzun.zzbz(position3);
                        int[] iArr11 = this.zzqb;
                        int length6 = iArr11 == null ? 0 : iArr11.length;
                        int i19 = i18 + length6;
                        int[] iArr12 = new int[i19];
                        if (length6 != 0) {
                            System.arraycopy(iArr11, 0, iArr12, 0, length6);
                        }
                        while (length6 < i19) {
                            iArr12[length6] = zzun.zzoa();
                            length6++;
                        }
                        this.zzqb = iArr12;
                        zzun.zzar(zzaq3);
                        break;
                    case 32:
                        this.zzqc = zzun.zzoa();
                        break;
                    case 40:
                        int zzb4 = zzuz.zzb(zzun, 40);
                        int[] iArr13 = this.zzqd;
                        int length7 = iArr13 == null ? 0 : iArr13.length;
                        int i21 = zzb4 + length7;
                        int[] iArr14 = new int[i21];
                        if (length7 != 0) {
                            System.arraycopy(iArr13, 0, iArr14, 0, length7);
                        }
                        while (length7 < i21 - 1) {
                            iArr14[length7] = zzun.zzoa();
                            zzun.zzni();
                            length7++;
                        }
                        iArr14[length7] = zzun.zzoa();
                        this.zzqd = iArr14;
                        break;
                    case 42:
                        int zzaq4 = zzun.zzaq(zzun.zzoa());
                        int position4 = zzun.getPosition();
                        int i22 = 0;
                        while (zzun.zzrv() > 0) {
                            zzun.zzoa();
                            i22++;
                        }
                        zzun.zzbz(position4);
                        int[] iArr15 = this.zzqd;
                        int length8 = iArr15 == null ? 0 : iArr15.length;
                        int i23 = i22 + length8;
                        int[] iArr16 = new int[i23];
                        if (length8 != 0) {
                            System.arraycopy(iArr15, 0, iArr16, 0, length8);
                        }
                        while (length8 < i23) {
                            iArr16[length8] = zzun.zzoa();
                            length8++;
                        }
                        this.zzqd = iArr16;
                        zzun.zzar(zzaq4);
                        break;
                    case 48:
                        this.zzqe = zzun.zzoa();
                        break;
                    case 56:
                        this.zzqf = zzun.zzoa();
                        break;
                    default:
                        if (super.zza(zzun, zzni)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }
    }
}
