package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.io.IOException;
import java.util.Arrays;

public final class zzdr {
    private static final zzdr zzmh = new zzdr(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzdy;
    private int zzii;
    private Object[] zzkt;
    private int[] zzmi;

    private zzdr() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzdr zzb(zzdr zzdr, zzdr zzdr2) {
        int i11 = zzdr.count + zzdr2.count;
        int[] copyOf = Arrays.copyOf(zzdr.zzmi, i11);
        System.arraycopy(zzdr2.zzmi, 0, copyOf, zzdr.count, zzdr2.count);
        Object[] copyOf2 = Arrays.copyOf(zzdr.zzkt, i11);
        System.arraycopy(zzdr2.zzkt, 0, copyOf2, zzdr.count, zzdr2.count);
        return new zzdr(i11, copyOf, copyOf2, true);
    }

    public static zzdr zzdh() {
        return zzmh;
    }

    public static zzdr zzdi() {
        return new zzdr();
    }

    public final boolean equals(Object obj) {
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzdr)) {
            return false;
        }
        zzdr zzdr = (zzdr) obj;
        int i11 = this.count;
        if (i11 == zzdr.count) {
            int[] iArr = this.zzmi;
            int[] iArr2 = zzdr.zzmi;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    z11 = true;
                    break;
                } else if (iArr[i12] != iArr2[i12]) {
                    z11 = false;
                    break;
                } else {
                    i12++;
                }
            }
            if (z11) {
                Object[] objArr = this.zzkt;
                Object[] objArr2 = zzdr.zzkt;
                int i13 = this.count;
                int i14 = 0;
                while (true) {
                    if (i14 >= i13) {
                        z12 = true;
                        break;
                    } else if (!objArr[i14].equals(objArr2[i14])) {
                        z12 = false;
                        break;
                    } else {
                        i14++;
                    }
                }
                if (!z12) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.count;
        int i12 = (i11 + 527) * 31;
        int[] iArr = this.zzmi;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = (i12 + i14) * 31;
        Object[] objArr = this.zzkt;
        int i17 = this.count;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final void zzab() {
        this.zzdy = false;
    }

    public final int zzbh() {
        int i11;
        int i12 = this.zzii;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.count; i14++) {
            int i15 = this.zzmi[i14];
            int i16 = i15 >>> 3;
            int i17 = i15 & 7;
            if (i17 == 0) {
                i11 = zzaj.zzf(i16, ((Long) this.zzkt[i14]).longValue());
            } else if (i17 == 1) {
                i11 = zzaj.zzh(i16, ((Long) this.zzkt[i14]).longValue());
            } else if (i17 == 2) {
                i11 = zzaj.zzd(i16, (zzw) this.zzkt[i14]);
            } else if (i17 == 3) {
                i11 = (zzaj.zzr(i16) << 1) + ((zzdr) this.zzkt[i14]).zzbh();
            } else if (i17 == 5) {
                i11 = zzaj.zzk(i16, ((Integer) this.zzkt[i14]).intValue());
            } else {
                throw new IllegalStateException(zzbk.zzbs());
            }
            i13 += i11;
        }
        this.zzii = i13;
        return i13;
    }

    public final void zzc(zzel zzel) throws IOException {
        if (this.count != 0) {
            if (zzel.zzam() == zzbc.zze.zziw) {
                for (int i11 = 0; i11 < this.count; i11++) {
                    zzc(this.zzmi[i11], this.zzkt[i11], zzel);
                }
                return;
            }
            for (int i12 = this.count - 1; i12 >= 0; i12--) {
                zzc(this.zzmi[i12], this.zzkt[i12], zzel);
            }
        }
    }

    public final int zzdj() {
        int i11 = this.zzii;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.count; i13++) {
            i12 += zzaj.zze(this.zzmi[i13] >>> 3, (zzw) this.zzkt[i13]);
        }
        this.zzii = i12;
        return i12;
    }

    private zzdr(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zzii = -1;
        this.count = i11;
        this.zzmi = iArr;
        this.zzkt = objArr;
        this.zzdy = z11;
    }

    private static void zzc(int i11, Object obj, zzel zzel) throws IOException {
        int i12 = i11 >>> 3;
        int i13 = i11 & 7;
        if (i13 == 0) {
            zzel.zzj(i12, ((Long) obj).longValue());
        } else if (i13 == 1) {
            zzel.zzd(i12, ((Long) obj).longValue());
        } else if (i13 == 2) {
            zzel.zzb(i12, (zzw) obj);
        } else if (i13 != 3) {
            if (i13 == 5) {
                zzel.zzg(i12, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzbk.zzbs());
        } else if (zzel.zzam() == zzbc.zze.zziw) {
            zzel.zzaa(i12);
            ((zzdr) obj).zzc(zzel);
            zzel.zzab(i12);
        } else {
            zzel.zzab(i12);
            ((zzdr) obj).zzc(zzel);
            zzel.zzaa(i12);
        }
    }

    public final void zzb(zzel zzel) throws IOException {
        if (zzel.zzam() == zzbc.zze.zzix) {
            for (int i11 = this.count - 1; i11 >= 0; i11--) {
                zzel.zzb(this.zzmi[i11] >>> 3, this.zzkt[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.count; i12++) {
            zzel.zzb(this.zzmi[i12] >>> 3, this.zzkt[i12]);
        }
    }

    public final void zzb(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.count; i12++) {
            zzcl.zzb(sb2, i11, String.valueOf(this.zzmi[i12] >>> 3), this.zzkt[i12]);
        }
    }

    public final void zzc(int i11, Object obj) {
        if (this.zzdy) {
            int i12 = this.count;
            int[] iArr = this.zzmi;
            if (i12 == iArr.length) {
                int i13 = i12 + (i12 < 4 ? 8 : i12 >> 1);
                this.zzmi = Arrays.copyOf(iArr, i13);
                this.zzkt = Arrays.copyOf(this.zzkt, i13);
            }
            int[] iArr2 = this.zzmi;
            int i14 = this.count;
            iArr2[i14] = i11;
            this.zzkt[i14] = obj;
            this.count = i14 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
