package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzce extends zzav<Float> implements RandomAccess {
    private static final zzce zzjm;
    private int size;
    private float[] zzjn;

    static {
        zzce zzce = new zzce();
        zzjm = zzce;
        zzce.zzv();
    }

    public zzce() {
        this(new float[10], 0);
    }

    private zzce(float[] fArr, int i11) {
        this.zzjn = fArr;
        this.size = i11;
    }

    private final void zzc(int i11, float f11) {
        int i12;
        zzw();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
        float[] fArr = this.zzjn;
        if (i12 < fArr.length) {
            System.arraycopy(fArr, i11, fArr, i11 + 1, i12 - i11);
        } else {
            float[] fArr2 = new float[(((i12 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            System.arraycopy(this.zzjn, i11, fArr2, i11 + 1, this.size - i11);
            this.zzjn = fArr2;
        }
        this.zzjn[i11] = f11;
        this.size++;
        this.modCount++;
    }

    private final void zzg(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
    }

    private final String zzh(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzc(i11, ((Float) obj).floatValue());
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof zzce)) {
            return super.addAll(collection);
        }
        zzce zzce = (zzce) collection;
        int i11 = zzce.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            float[] fArr = this.zzjn;
            if (i13 > fArr.length) {
                this.zzjn = Arrays.copyOf(fArr, i13);
            }
            System.arraycopy(zzce.zzjn, 0, this.zzjn, this.size, zzce.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzce)) {
            return super.equals(obj);
        }
        zzce zzce = (zzce) obj;
        if (this.size != zzce.size) {
            return false;
        }
        float[] fArr = zzce.zzjn;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzjn[i11] != fArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzg(i11);
        return Float.valueOf(this.zzjn[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + Float.floatToIntBits(this.zzjn[i12]);
        }
        return i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzw();
        zzg(i11);
        float[] fArr = this.zzjn;
        float f11 = fArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(fArr, i11 + 1, fArr, i11, i12 - i11);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f11);
    }

    public final boolean remove(Object obj) {
        zzw();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Float.valueOf(this.zzjn[i11]))) {
                float[] fArr = this.zzjn;
                System.arraycopy(fArr, i11 + 1, fArr, i11, this.size - i11);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzw();
        if (i12 >= i11) {
            float[] fArr = this.zzjn;
            System.arraycopy(fArr, i12, fArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzw();
        zzg(i11);
        float[] fArr = this.zzjn;
        float f11 = fArr[i11];
        fArr[i11] = floatValue;
        return Float.valueOf(f11);
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f11) {
        zzc(this.size, f11);
    }

    public final /* synthetic */ zzcn zzi(int i11) {
        if (i11 >= this.size) {
            return new zzce(Arrays.copyOf(this.zzjn, i11), this.size);
        }
        throw new IllegalArgumentException();
    }
}
