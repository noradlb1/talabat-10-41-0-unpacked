package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzabt extends zzaak<Integer> implements RandomAccess, zzabw, zzadg {
    private static final zzabt zza;
    private int[] zzb;
    private int zzc;

    static {
        zzabt zzabt = new zzabt(new int[0], 0);
        zza = zzabt;
        zzabt.zzb();
    }

    public zzabt() {
        this(new int[10], 0);
    }

    public static zzabt zze() {
        return zza;
    }

    private final String zzg(int i11) {
        int i12 = this.zzc;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    private final void zzh(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
    }

    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        int i12;
        int intValue = ((Integer) obj).intValue();
        zza();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i11));
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
        zza();
        zzaca.zze(collection);
        if (!(collection instanceof zzabt)) {
            return super.addAll(collection);
        }
        zzabt zzabt = (zzabt) collection;
        int i11 = zzabt.zzc;
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
            System.arraycopy(zzabt.zzb, 0, this.zzb, this.zzc, zzabt.zzc);
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
        if (!(obj instanceof zzabt)) {
            return super.equals(obj);
        }
        zzabt zzabt = (zzabt) obj;
        if (this.zzc != zzabt.zzc) {
            return false;
        }
        int[] iArr = zzabt.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (this.zzb[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        zzh(i11);
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
        zza();
        zzh(i11);
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
        zza();
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
        zza();
        zzh(i11);
        int[] iArr = this.zzb;
        int i12 = iArr[i11];
        iArr[i11] = intValue;
        return Integer.valueOf(i12);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zzd(int i11) {
        zzh(i11);
        return this.zzb[i11];
    }

    public final /* bridge */ /* synthetic */ zzabz zzf(int i11) {
        if (i11 >= this.zzc) {
            return new zzabt(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzabt(int[] iArr, int i11) {
        this.zzb = iArr;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        int intValue = ((Integer) obj).intValue();
        zza();
        int i11 = this.zzc;
        int[] iArr = this.zzb;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[(((i11 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        iArr3[i12] = intValue;
        return true;
    }
}
