package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.io.IOException;
import java.util.Arrays;

public final class zzjm {
    private static final zzjm zzaaj = new zzjm(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzaak;
    private boolean zzrj;
    private int zzwe;
    private Object[] zzyv;

    private zzjm() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzjm zza(zzjm zzjm, zzjm zzjm2) {
        int i11 = zzjm.count + zzjm2.count;
        int[] copyOf = Arrays.copyOf(zzjm.zzaak, i11);
        System.arraycopy(zzjm2.zzaak, 0, copyOf, zzjm.count, zzjm2.count);
        Object[] copyOf2 = Arrays.copyOf(zzjm.zzyv, i11);
        System.arraycopy(zzjm2.zzyv, 0, copyOf2, zzjm.count, zzjm2.count);
        return new zzjm(i11, copyOf, copyOf2, true);
    }

    public static zzjm zzig() {
        return zzaaj;
    }

    public static zzjm zzih() {
        return new zzjm();
    }

    public final boolean equals(Object obj) {
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzjm)) {
            return false;
        }
        zzjm zzjm = (zzjm) obj;
        int i11 = this.count;
        if (i11 == zzjm.count) {
            int[] iArr = this.zzaak;
            int[] iArr2 = zzjm.zzaak;
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
                Object[] objArr = this.zzyv;
                Object[] objArr2 = zzjm.zzyv;
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
        int[] iArr = this.zzaak;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = (i12 + i14) * 31;
        Object[] objArr = this.zzyv;
        int i17 = this.count;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final void zzb(zzkg zzkg) throws IOException {
        if (this.count != 0) {
            if (zzkg.zzfj() == zzgs.zzf.zzww) {
                for (int i11 = 0; i11 < this.count; i11++) {
                    zzb(this.zzaak[i11], this.zzyv[i11], zzkg);
                }
                return;
            }
            for (int i12 = this.count - 1; i12 >= 0; i12--) {
                zzb(this.zzaak[i12], this.zzyv[i12], zzkg);
            }
        }
    }

    public final void zzdp() {
        this.zzrj = false;
    }

    public final int zzgf() {
        int i11;
        int i12 = this.zzwe;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.count; i14++) {
            int i15 = this.zzaak[i14];
            int i16 = i15 >>> 3;
            int i17 = i15 & 7;
            if (i17 == 0) {
                i11 = zzga.zze(i16, ((Long) this.zzyv[i14]).longValue());
            } else if (i17 == 1) {
                i11 = zzga.zzg(i16, ((Long) this.zzyv[i14]).longValue());
            } else if (i17 == 2) {
                i11 = zzga.zzc(i16, (zzfh) this.zzyv[i14]);
            } else if (i17 == 3) {
                i11 = (zzga.zzba(i16) << 1) + ((zzjm) this.zzyv[i14]).zzgf();
            } else if (i17 == 5) {
                i11 = zzga.zzo(i16, ((Integer) this.zzyv[i14]).intValue());
            } else {
                throw new IllegalStateException(zzhc.zzgr());
            }
            i13 += i11;
        }
        this.zzwe = i13;
        return i13;
    }

    public final int zzii() {
        int i11 = this.zzwe;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.count; i13++) {
            i12 += zzga.zzd(this.zzaak[i13] >>> 3, (zzfh) this.zzyv[i13]);
        }
        this.zzwe = i12;
        return i12;
    }

    private zzjm(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zzwe = -1;
        this.count = i11;
        this.zzaak = iArr;
        this.zzyv = objArr;
        this.zzrj = z11;
    }

    private static void zzb(int i11, Object obj, zzkg zzkg) throws IOException {
        int i12 = i11 >>> 3;
        int i13 = i11 & 7;
        if (i13 == 0) {
            zzkg.zzi(i12, ((Long) obj).longValue());
        } else if (i13 == 1) {
            zzkg.zzc(i12, ((Long) obj).longValue());
        } else if (i13 == 2) {
            zzkg.zza(i12, (zzfh) obj);
        } else if (i13 != 3) {
            if (i13 == 5) {
                zzkg.zzk(i12, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzhc.zzgr());
        } else if (zzkg.zzfj() == zzgs.zzf.zzww) {
            zzkg.zzbj(i12);
            ((zzjm) obj).zzb(zzkg);
            zzkg.zzbk(i12);
        } else {
            zzkg.zzbk(i12);
            ((zzjm) obj).zzb(zzkg);
            zzkg.zzbj(i12);
        }
    }

    public final void zza(zzkg zzkg) throws IOException {
        if (zzkg.zzfj() == zzgs.zzf.zzwx) {
            for (int i11 = this.count - 1; i11 >= 0; i11--) {
                zzkg.zza(this.zzaak[i11] >>> 3, this.zzyv[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.count; i12++) {
            zzkg.zza(this.zzaak[i12] >>> 3, this.zzyv[i12]);
        }
    }

    public final void zza(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.count; i12++) {
            zzid.zza(sb2, i11, String.valueOf(this.zzaak[i12] >>> 3), this.zzyv[i12]);
        }
    }

    public final void zzb(int i11, Object obj) {
        if (this.zzrj) {
            int i12 = this.count;
            int[] iArr = this.zzaak;
            if (i12 == iArr.length) {
                int i13 = i12 + (i12 < 4 ? 8 : i12 >> 1);
                this.zzaak = Arrays.copyOf(iArr, i13);
                this.zzyv = Arrays.copyOf(this.zzyv, i13);
            }
            int[] iArr2 = this.zzaak;
            int i14 = this.count;
            iArr2[i14] = i11;
            this.zzyv[i14] = obj;
            this.count = i14 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
