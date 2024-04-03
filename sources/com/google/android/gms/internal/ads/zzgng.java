package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

public final class zzgng {
    private static final zzgng zza = new zzgng(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzgng() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgng(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zze = -1;
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z11;
    }

    public static zzgng zzc() {
        return zza;
    }

    public static zzgng zzd(zzgng zzgng, zzgng zzgng2) {
        int i11 = zzgng.zzb + zzgng2.zzb;
        int[] copyOf = Arrays.copyOf(zzgng.zzc, i11);
        System.arraycopy(zzgng2.zzc, 0, copyOf, zzgng.zzb, zzgng2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgng.zzd, i11);
        System.arraycopy(zzgng2.zzd, 0, copyOf2, zzgng.zzb, zzgng2.zzb);
        return new zzgng(i11, copyOf, copyOf2, true);
    }

    public static zzgng zze() {
        return new zzgng(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgng)) {
            return false;
        }
        zzgng zzgng = (zzgng) obj;
        int i11 = this.zzb;
        if (i11 == zzgng.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgng.zzc;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgng.zzd;
                    int i13 = this.zzb;
                    int i14 = 0;
                    while (i14 < i13) {
                        if (objArr[i14].equals(objArr2[i14])) {
                            i14++;
                        }
                    }
                    return true;
                } else if (iArr[i12] != iArr2[i12]) {
                    break;
                } else {
                    i12++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzb;
        int i12 = (i11 + 527) * 31;
        int[] iArr = this.zzc;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = (i12 + i14) * 31;
        Object[] objArr = this.zzd;
        int i17 = this.zzb;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final int zza() {
        int i11;
        int i12;
        int i13;
        int i14 = this.zze;
        if (i14 != -1) {
            return i14;
        }
        int i15 = 0;
        for (int i16 = 0; i16 < this.zzb; i16++) {
            int i17 = this.zzc[i16];
            int i18 = i17 >>> 3;
            int i19 = i17 & 7;
            if (i19 != 0) {
                if (i19 == 1) {
                    ((Long) this.zzd[i16]).longValue();
                    i11 = zzgjs.zzA(i18 << 3) + 8;
                } else if (i19 == 2) {
                    int zzA = zzgjs.zzA(i18 << 3);
                    int zzd2 = ((zzgjf) this.zzd[i16]).zzd();
                    i15 += zzA + zzgjs.zzA(zzd2) + zzd2;
                } else if (i19 == 3) {
                    int zzz = zzgjs.zzz(i18);
                    i13 = zzz + zzz;
                    i12 = ((zzgng) this.zzd[i16]).zza();
                } else if (i19 == 5) {
                    ((Integer) this.zzd[i16]).intValue();
                    i11 = zzgjs.zzA(i18 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzgkx.zza());
                }
                i15 += i11;
            } else {
                long longValue = ((Long) this.zzd[i16]).longValue();
                i13 = zzgjs.zzA(i18 << 3);
                i12 = zzgjs.zzB(longValue);
            }
            i11 = i13 + i12;
            i15 += i11;
        }
        this.zze = i15;
        return i15;
    }

    public final int zzb() {
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzb; i13++) {
            int i14 = this.zzc[i13];
            int zzA = zzgjs.zzA(8);
            int zzd2 = ((zzgjf) this.zzd[i13]).zzd();
            i12 += zzA + zzA + zzgjs.zzA(16) + zzgjs.zzA(i14 >>> 3) + zzgjs.zzA(24) + zzgjs.zzA(zzd2) + zzd2;
        }
        this.zze = i12;
        return i12;
    }

    public final void zzf() {
        this.zzf = false;
    }

    public final void zzg(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.zzb; i12++) {
            zzglx.zzb(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    public final void zzh(int i11, Object obj) {
        int i12;
        if (this.zzf) {
            int i13 = this.zzb;
            int[] iArr = this.zzc;
            if (i13 == iArr.length) {
                if (i13 < 4) {
                    i12 = 8;
                } else {
                    i12 = i13 >> 1;
                }
                int i14 = i13 + i12;
                this.zzc = Arrays.copyOf(iArr, i14);
                this.zzd = Arrays.copyOf(this.zzd, i14);
            }
            int[] iArr2 = this.zzc;
            int i15 = this.zzb;
            iArr2[i15] = i11;
            this.zzd[i15] = obj;
            this.zzb = i15 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zzgjt zzgjt) throws IOException {
        if (this.zzb != 0) {
            for (int i11 = 0; i11 < this.zzb; i11++) {
                int i12 = this.zzc[i11];
                Object obj = this.zzd[i11];
                int i13 = i12 >>> 3;
                int i14 = i12 & 7;
                if (i14 == 0) {
                    zzgjt.zzt(i13, ((Long) obj).longValue());
                } else if (i14 == 1) {
                    zzgjt.zzm(i13, ((Long) obj).longValue());
                } else if (i14 == 2) {
                    zzgjt.zzd(i13, (zzgjf) obj);
                } else if (i14 == 3) {
                    zzgjt.zzE(i13);
                    ((zzgng) obj).zzi(zzgjt);
                    zzgjt.zzh(i13);
                } else if (i14 == 5) {
                    zzgjt.zzk(i13, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzgkx.zza());
                }
            }
        }
    }
}
