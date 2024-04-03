package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.Arrays;

public final class zzey {
    private static final zzey zzoz = new zzey(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzfa;
    private int zzjq;
    private Object[] zzmj;
    private int[] zzpa;

    private zzey() {
        this(0, new int[8], new Object[8], true);
    }

    private zzey(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zzjq = -1;
        this.count = i11;
        this.zzpa = iArr;
        this.zzmj = objArr;
        this.zzfa = z11;
    }

    public static zzey zza(zzey zzey, zzey zzey2) {
        int i11 = zzey.count + zzey2.count;
        int[] copyOf = Arrays.copyOf(zzey.zzpa, i11);
        System.arraycopy(zzey2.zzpa, 0, copyOf, zzey.count, zzey2.count);
        Object[] copyOf2 = Arrays.copyOf(zzey.zzmj, i11);
        System.arraycopy(zzey2.zzmj, 0, copyOf2, zzey.count, zzey2.count);
        return new zzey(i11, copyOf, copyOf2, true);
    }

    private static void zzb(int i11, Object obj, zzfr zzfr) throws IOException {
        int i12 = i11 >>> 3;
        int i13 = i11 & 7;
        if (i13 == 0) {
            zzfr.zzi(i12, ((Long) obj).longValue());
        } else if (i13 == 1) {
            zzfr.zzc(i12, ((Long) obj).longValue());
        } else if (i13 == 2) {
            zzfr.zza(i12, (zzbb) obj);
        } else if (i13 != 3) {
            if (i13 == 5) {
                zzfr.zzf(i12, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzco.zzbn());
        } else if (zzfr.zzaj() == zzcg.zzg.zzko) {
            zzfr.zzaa(i12);
            ((zzey) obj).zzb(zzfr);
            zzfr.zzab(i12);
        } else {
            zzfr.zzab(i12);
            ((zzey) obj).zzb(zzfr);
            zzfr.zzaa(i12);
        }
    }

    public static zzey zzea() {
        return zzoz;
    }

    public static zzey zzeb() {
        return new zzey();
    }

    public final boolean equals(Object obj) {
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzey)) {
            return false;
        }
        zzey zzey = (zzey) obj;
        int i11 = this.count;
        if (i11 == zzey.count) {
            int[] iArr = this.zzpa;
            int[] iArr2 = zzey.zzpa;
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
                Object[] objArr = this.zzmj;
                Object[] objArr2 = zzey.zzmj;
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
                return z12;
            }
        }
    }

    public final int hashCode() {
        int i11 = this.count;
        int i12 = (i11 + 527) * 31;
        int[] iArr = this.zzpa;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = (i12 + i14) * 31;
        Object[] objArr = this.zzmj;
        int i17 = this.count;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final void zza(zzfr zzfr) throws IOException {
        if (zzfr.zzaj() == zzcg.zzg.zzkp) {
            for (int i11 = this.count - 1; i11 >= 0; i11--) {
                zzfr.zza(this.zzpa[i11] >>> 3, this.zzmj[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.count; i12++) {
            zzfr.zza(this.zzpa[i12] >>> 3, this.zzmj[i12]);
        }
    }

    public final void zza(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.count; i12++) {
            zzdr.zza(sb2, i11, String.valueOf(this.zzpa[i12] >>> 3), this.zzmj[i12]);
        }
    }

    public final int zzas() {
        int i11;
        int i12 = this.zzjq;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.count; i14++) {
            int i15 = this.zzpa[i14];
            int i16 = i15 >>> 3;
            int i17 = i15 & 7;
            if (i17 == 0) {
                i11 = zzbn.zze(i16, ((Long) this.zzmj[i14]).longValue());
            } else if (i17 == 1) {
                i11 = zzbn.zzg(i16, ((Long) this.zzmj[i14]).longValue());
            } else if (i17 == 2) {
                i11 = zzbn.zzc(i16, (zzbb) this.zzmj[i14]);
            } else if (i17 == 3) {
                i11 = (zzbn.zzr(i16) << 1) + ((zzey) this.zzmj[i14]).zzas();
            } else if (i17 == 5) {
                i11 = zzbn.zzj(i16, ((Integer) this.zzmj[i14]).intValue());
            } else {
                throw new IllegalStateException(zzco.zzbn());
            }
            i13 += i11;
        }
        this.zzjq = i13;
        return i13;
    }

    public final void zzb(int i11, Object obj) {
        if (this.zzfa) {
            int i12 = this.count;
            int[] iArr = this.zzpa;
            if (i12 == iArr.length) {
                int i13 = i12 + (i12 < 4 ? 8 : i12 >> 1);
                this.zzpa = Arrays.copyOf(iArr, i13);
                this.zzmj = Arrays.copyOf(this.zzmj, i13);
            }
            int[] iArr2 = this.zzpa;
            int i14 = this.count;
            iArr2[i14] = i11;
            this.zzmj[i14] = obj;
            this.count = i14 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzb(zzfr zzfr) throws IOException {
        if (this.count != 0) {
            if (zzfr.zzaj() == zzcg.zzg.zzko) {
                for (int i11 = 0; i11 < this.count; i11++) {
                    zzb(this.zzpa[i11], this.zzmj[i11], zzfr);
                }
                return;
            }
            for (int i12 = this.count - 1; i12 >= 0; i12--) {
                zzb(this.zzpa[i12], this.zzmj[i12], zzfr);
            }
        }
    }

    public final int zzec() {
        int i11 = this.zzjq;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.count; i13++) {
            i12 += zzbn.zzd(this.zzpa[i13] >>> 3, (zzbb) this.zzmj[i13]);
        }
        this.zzjq = i12;
        return i12;
    }

    public final void zzv() {
        this.zzfa = false;
    }
}
