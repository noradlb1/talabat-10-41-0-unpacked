package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.Arrays;

public final class zzts {
    private static final zzts zzbem = new zzts(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzavs;
    private int zzbal;
    private Object[] zzbcz;
    private int[] zzben;

    private zzts() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzts zza(zzts zzts, zzts zzts2) {
        int i11 = zzts.count + zzts2.count;
        int[] copyOf = Arrays.copyOf(zzts.zzben, i11);
        System.arraycopy(zzts2.zzben, 0, copyOf, zzts.count, zzts2.count);
        Object[] copyOf2 = Arrays.copyOf(zzts.zzbcz, i11);
        System.arraycopy(zzts2.zzbcz, 0, copyOf2, zzts.count, zzts2.count);
        return new zzts(i11, copyOf, copyOf2, true);
    }

    public static zzts zzrj() {
        return zzbem;
    }

    public static zzts zzrk() {
        return new zzts();
    }

    public final boolean equals(Object obj) {
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzts)) {
            return false;
        }
        zzts zzts = (zzts) obj;
        int i11 = this.count;
        if (i11 == zzts.count) {
            int[] iArr = this.zzben;
            int[] iArr2 = zzts.zzben;
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
                Object[] objArr = this.zzbcz;
                Object[] objArr2 = zzts.zzbcz;
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
        int[] iArr = this.zzben;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = (i12 + i14) * 31;
        Object[] objArr = this.zzbcz;
        int i17 = this.count;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final void zzb(zzum zzum) throws IOException {
        if (this.count != 0) {
            if (zzum.zzol() == zzrc.zze.zzbbc) {
                for (int i11 = 0; i11 < this.count; i11++) {
                    zzb(this.zzben[i11], this.zzbcz[i11], zzum);
                }
                return;
            }
            for (int i12 = this.count - 1; i12 >= 0; i12--) {
                zzb(this.zzben[i12], this.zzbcz[i12], zzum);
            }
        }
    }

    public final void zzmi() {
        this.zzavs = false;
    }

    public final int zzpe() {
        int i11;
        int i12 = this.zzbal;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.count; i14++) {
            int i15 = this.zzben[i14];
            int i16 = i15 >>> 3;
            int i17 = i15 & 7;
            if (i17 == 0) {
                i11 = zzqj.zze(i16, ((Long) this.zzbcz[i14]).longValue());
            } else if (i17 == 1) {
                i11 = zzqj.zzg(i16, ((Long) this.zzbcz[i14]).longValue());
            } else if (i17 == 2) {
                i11 = zzqj.zzc(i16, (zzps) this.zzbcz[i14]);
            } else if (i17 == 3) {
                i11 = (zzqj.zzbb(i16) << 1) + ((zzts) this.zzbcz[i14]).zzpe();
            } else if (i17 == 5) {
                i11 = zzqj.zzl(i16, ((Integer) this.zzbcz[i14]).intValue());
            } else {
                throw new IllegalStateException(zzrk.zzpt());
            }
            i13 += i11;
        }
        this.zzbal = i13;
        return i13;
    }

    public final int zzrl() {
        int i11 = this.zzbal;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.count; i13++) {
            i12 += zzqj.zzd(this.zzben[i13] >>> 3, (zzps) this.zzbcz[i13]);
        }
        this.zzbal = i12;
        return i12;
    }

    private zzts(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zzbal = -1;
        this.count = i11;
        this.zzben = iArr;
        this.zzbcz = objArr;
        this.zzavs = z11;
    }

    private static void zzb(int i11, Object obj, zzum zzum) throws IOException {
        int i12 = i11 >>> 3;
        int i13 = i11 & 7;
        if (i13 == 0) {
            zzum.zzi(i12, ((Long) obj).longValue());
        } else if (i13 == 1) {
            zzum.zzc(i12, ((Long) obj).longValue());
        } else if (i13 == 2) {
            zzum.zza(i12, (zzps) obj);
        } else if (i13 != 3) {
            if (i13 == 5) {
                zzum.zzh(i12, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzrk.zzpt());
        } else if (zzum.zzol() == zzrc.zze.zzbbc) {
            zzum.zzbk(i12);
            ((zzts) obj).zzb(zzum);
            zzum.zzbl(i12);
        } else {
            zzum.zzbl(i12);
            ((zzts) obj).zzb(zzum);
            zzum.zzbk(i12);
        }
    }

    public final void zza(zzum zzum) throws IOException {
        if (zzum.zzol() == zzrc.zze.zzbbd) {
            for (int i11 = this.count - 1; i11 >= 0; i11--) {
                zzum.zza(this.zzben[i11] >>> 3, this.zzbcz[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.count; i12++) {
            zzum.zza(this.zzben[i12] >>> 3, this.zzbcz[i12]);
        }
    }

    public final void zza(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.count; i12++) {
            zzsn.zza(sb2, i11, String.valueOf(this.zzben[i12] >>> 3), this.zzbcz[i12]);
        }
    }

    public final void zzb(int i11, Object obj) {
        if (this.zzavs) {
            int i12 = this.count;
            int[] iArr = this.zzben;
            if (i12 == iArr.length) {
                int i13 = i12 + (i12 < 4 ? 8 : i12 >> 1);
                this.zzben = Arrays.copyOf(iArr, i13);
                this.zzbcz = Arrays.copyOf(this.zzbcz, i13);
            }
            int[] iArr2 = this.zzben;
            int i14 = this.count;
            iArr2[i14] = i11;
            this.zzbcz[i14] = obj;
            this.count = i14 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
