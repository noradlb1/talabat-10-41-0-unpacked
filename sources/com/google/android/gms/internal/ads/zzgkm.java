package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgkm extends zzgio<Integer> implements RandomAccess, zzgkq, zzgmc {
    private static final zzgkm zza;
    private int[] zzb;
    private int zzc;

    static {
        zzgkm zzgkm = new zzgkm(new int[0], 0);
        zza = zzgkm;
        zzgkm.zzb();
    }

    public zzgkm() {
        this(new int[10], 0);
    }

    public static zzgkm zzf() {
        return zza;
    }

    private final String zzi(int i11) {
        int i12 = this.zzc;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    private final void zzj(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzi(i11));
        }
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        int intValue = ((Integer) obj).intValue();
        zzbU();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i11));
        }
        int[] iArr = this.zzb;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i11, iArr, i11 + 1, i12 - i11);
        } else {
            int[] iArr2 = new int[(((i12 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.zzb, i11, iArr2, i11 + 1, this.zzc - i11);
            this.zzb = iArr2;
        }
        this.zzb[i11] = intValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbU();
        zzgkv.zze(collection);
        if (!(collection instanceof zzgkm)) {
            return super.addAll(collection);
        }
        zzgkm zzgkm = (zzgkm) collection;
        int i11 = zzgkm.zzc;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.zzc;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            int[] iArr = this.zzb;
            if (i13 > iArr.length) {
                this.zzb = Arrays.copyOf(iArr, i13);
            }
            System.arraycopy(zzgkm.zzb, 0, this.zzb, this.zzc, zzgkm.zzc);
            this.zzc = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgkm)) {
            return super.equals(obj);
        }
        zzgkm zzgkm = (zzgkm) obj;
        if (this.zzc != zzgkm.zzc) {
            return false;
        }
        int[] iArr = zzgkm.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (this.zzb[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzj(i11);
        return Integer.valueOf(this.zzb[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            i11 = (i11 * 31) + this.zzb[i12];
        }
        return i11;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i11 = this.zzc;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.zzb[i12] == intValue) {
                return i12;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzbU();
        zzj(i11);
        int[] iArr = this.zzb;
        int i12 = iArr[i11];
        int i13 = this.zzc;
        if (i11 < i13 - 1) {
            System.arraycopy(iArr, i11 + 1, iArr, i11, (i13 - i11) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Integer.valueOf(i12);
    }

    public final void removeRange(int i11, int i12) {
        zzbU();
        if (i12 >= i11) {
            int[] iArr = this.zzb;
            System.arraycopy(iArr, i12, iArr, i11, this.zzc - i12);
            this.zzc -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbU();
        zzj(i11);
        int[] iArr = this.zzb;
        int i12 = iArr[i11];
        iArr[i11] = intValue;
        return Integer.valueOf(i12);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zze(int i11) {
        zzj(i11);
        return this.zzb[i11];
    }

    /* renamed from: zzg */
    public final zzgkq zzd(int i11) {
        if (i11 >= this.zzc) {
            return new zzgkm(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int i11) {
        zzbU();
        int i12 = this.zzc;
        int[] iArr = this.zzb;
        if (i12 == iArr.length) {
            int[] iArr2 = new int[(((i12 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i13 = this.zzc;
        this.zzc = i13 + 1;
        iArr3[i13] = i11;
    }

    private zzgkm(int[] iArr, int i11) {
        this.zzb = iArr;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
