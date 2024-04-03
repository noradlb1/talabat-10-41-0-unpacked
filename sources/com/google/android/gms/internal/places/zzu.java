package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzu extends zzq<Boolean> implements zzcw, RandomAccess {
    private static final zzu zzed;
    private int size;
    private boolean[] zzee;

    static {
        zzu zzu = new zzu(new boolean[0], 0);
        zzed = zzu;
        zzu.zzab();
    }

    public zzu() {
        this(new boolean[10], 0);
    }

    private final void zzb(int i11, boolean z11) {
        int i12;
        zzac();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
        boolean[] zArr = this.zzee;
        if (i12 < zArr.length) {
            System.arraycopy(zArr, i11, zArr, i11 + 1, i12 - i11);
        } else {
            boolean[] zArr2 = new boolean[(((i12 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            System.arraycopy(this.zzee, i11, zArr2, i11 + 1, this.size - i11);
            this.zzee = zArr2;
        }
        this.zzee[i11] = z11;
        this.size++;
        this.modCount++;
    }

    private final void zzf(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
    }

    private final String zzg(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzb(i11, ((Boolean) obj).booleanValue());
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzu)) {
            return super.addAll(collection);
        }
        zzu zzu = (zzu) collection;
        int i11 = zzu.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            boolean[] zArr = this.zzee;
            if (i13 > zArr.length) {
                this.zzee = Arrays.copyOf(zArr, i13);
            }
            System.arraycopy(zzu.zzee, 0, this.zzee, this.size, zzu.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z11) {
        zzb(this.size, z11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzu)) {
            return super.equals(obj);
        }
        zzu zzu = (zzu) obj;
        if (this.size != zzu.size) {
            return false;
        }
        boolean[] zArr = zzu.zzee;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzee[i11] != zArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzf(i11);
        return Boolean.valueOf(this.zzee[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzbd.zze(this.zzee[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzac();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Boolean.valueOf(this.zzee[i11]))) {
                boolean[] zArr = this.zzee;
                System.arraycopy(zArr, i11 + 1, zArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzac();
        if (i12 >= i11) {
            boolean[] zArr = this.zzee;
            System.arraycopy(zArr, i12, zArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzac();
        zzf(i11);
        boolean[] zArr = this.zzee;
        boolean z11 = zArr[i11];
        zArr[i11] = booleanValue;
        return Boolean.valueOf(z11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzbh zzh(int i11) {
        if (i11 >= this.size) {
            return new zzu(Arrays.copyOf(this.zzee, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzu(boolean[] zArr, int i11) {
        this.zzee = zArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzac();
        zzf(i11);
        boolean[] zArr = this.zzee;
        boolean z11 = zArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(zArr, i11 + 1, zArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z11);
    }
}
