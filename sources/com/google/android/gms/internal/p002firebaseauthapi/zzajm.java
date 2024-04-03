package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajm  reason: invalid package */
public final class zzajm {
    private static final zzajm zza = new zzajm(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzajm() {
        this(0, new int[8], new Object[8], true);
    }

    private zzajm(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zze = -1;
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z11;
    }

    public static zzajm zzc() {
        return zza;
    }

    public static zzajm zze(zzajm zzajm, zzajm zzajm2) {
        int i11 = zzajm.zzb + zzajm2.zzb;
        int[] copyOf = Arrays.copyOf(zzajm.zzc, i11);
        System.arraycopy(zzajm2.zzc, 0, copyOf, zzajm.zzb, zzajm2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzajm.zzd, i11);
        System.arraycopy(zzajm2.zzd, 0, copyOf2, zzajm.zzb, zzajm2.zzb);
        return new zzajm(i11, copyOf, copyOf2, true);
    }

    public static zzajm zzf() {
        return new zzajm(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i11) {
        int[] iArr = this.zzc;
        if (i11 > iArr.length) {
            int i12 = this.zzb;
            int i13 = i12 + (i12 / 2);
            if (i13 >= i11) {
                i11 = i13;
            }
            if (i11 < 8) {
                i11 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i11);
            this.zzd = Arrays.copyOf(this.zzd, i11);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzajm)) {
            return false;
        }
        zzajm zzajm = (zzajm) obj;
        int i11 = this.zzb;
        if (i11 == zzajm.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzajm.zzc;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzajm.zzd;
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
        int i12 = i11 + 527;
        int[] iArr = this.zzc;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = (i12 * 31) + i14;
        Object[] objArr = this.zzd;
        int i17 = this.zzb;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return (i16 * 31) + i13;
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
                    i11 = zzagi.zzA(i18 << 3) + 8;
                } else if (i19 == 2) {
                    int i21 = zzagi.zzf;
                    int zzd2 = ((zzafv) this.zzd[i16]).zzd();
                    i11 = zzagi.zzA(i18 << 3) + zzagi.zzA(zzd2) + zzd2;
                } else if (i19 == 3) {
                    int i22 = i18 << 3;
                    int i23 = zzagi.zzf;
                    i12 = ((zzajm) this.zzd[i16]).zza();
                    int zzA = zzagi.zzA(i22);
                    i13 = zzA + zzA;
                } else if (i19 == 5) {
                    ((Integer) this.zzd[i16]).intValue();
                    i11 = zzagi.zzA(i18 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzahi.zza());
                }
                i15 += i11;
            } else {
                int i24 = i18 << 3;
                i12 = zzagi.zzB(((Long) this.zzd[i16]).longValue());
                i13 = zzagi.zzA(i24);
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
            int i14 = zzagi.zzf;
            int zzd2 = ((zzafv) this.zzd[i13]).zzd();
            int zzA = zzagi.zzA(zzd2) + zzd2;
            int zzA2 = zzagi.zzA(16);
            int zzA3 = zzagi.zzA(this.zzc[i13] >>> 3);
            int zzA4 = zzagi.zzA(8);
            i12 += zzA4 + zzA4 + zzA2 + zzA3 + zzagi.zzA(24) + zzA;
        }
        this.zze = i12;
        return i12;
    }

    public final zzajm zzd(zzajm zzajm) {
        if (zzajm.equals(zza)) {
            return this;
        }
        zzg();
        int i11 = this.zzb + zzajm.zzb;
        zzl(i11);
        System.arraycopy(zzajm.zzc, 0, this.zzc, this.zzb, zzajm.zzb);
        System.arraycopy(zzajm.zzd, 0, this.zzd, this.zzb, zzajm.zzb);
        this.zzb = i11;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.zzb; i12++) {
            zzaih.zzb(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    public final void zzj(int i11, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i12 = this.zzb;
        iArr[i12] = i11;
        this.zzd[i12] = obj;
        this.zzb = i12 + 1;
    }

    public final void zzk(zzagj zzagj) throws IOException {
        if (this.zzb != 0) {
            for (int i11 = 0; i11 < this.zzb; i11++) {
                int i12 = this.zzc[i11];
                Object obj = this.zzd[i11];
                int i13 = i12 & 7;
                int i14 = i12 >>> 3;
                if (i13 == 0) {
                    zzagj.zzt(i14, ((Long) obj).longValue());
                } else if (i13 == 1) {
                    zzagj.zzm(i14, ((Long) obj).longValue());
                } else if (i13 == 2) {
                    zzagj.zzd(i14, (zzafv) obj);
                } else if (i13 == 3) {
                    zzagj.zzE(i14);
                    ((zzajm) obj).zzk(zzagj);
                    zzagj.zzh(i14);
                } else if (i13 == 5) {
                    zzagj.zzk(i14, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzahi.zza());
                }
            }
        }
    }
}
