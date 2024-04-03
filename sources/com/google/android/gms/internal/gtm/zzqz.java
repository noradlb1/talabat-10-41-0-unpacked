package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzqz extends zzpo<Float> implements zzsv, RandomAccess {
    private static final zzqz zzbag;
    private int size;
    private float[] zzbah;

    static {
        zzqz zzqz = new zzqz(new float[0], 0);
        zzbag = zzqz;
        zzqz.zzmi();
    }

    public zzqz() {
        this(new float[10], 0);
    }

    private final void zzah(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzai(i11));
        }
    }

    private final String zzai(int i11) {
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
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzqz)) {
            return super.addAll(collection);
        }
        zzqz zzqz = (zzqz) collection;
        int i11 = zzqz.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            float[] fArr = this.zzbah;
            if (i13 > fArr.length) {
                this.zzbah = Arrays.copyOf(fArr, i13);
            }
            System.arraycopy(zzqz.zzbah, 0, this.zzbah, this.size, zzqz.size);
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
        if (!(obj instanceof zzqz)) {
            return super.equals(obj);
        }
        zzqz zzqz = (zzqz) obj;
        if (this.size != zzqz.size) {
            return false;
        }
        float[] fArr = zzqz.zzbah;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Float.floatToIntBits(this.zzbah[i11]) != Float.floatToIntBits(fArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzah(i11);
        return Float.valueOf(this.zzbah[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + Float.floatToIntBits(this.zzbah[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzmz();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Float.valueOf(this.zzbah[i11]))) {
                float[] fArr = this.zzbah;
                System.arraycopy(fArr, i11 + 1, fArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzmz();
        if (i12 >= i11) {
            float[] fArr = this.zzbah;
            System.arraycopy(fArr, i12, fArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzmz();
        zzah(i11);
        float[] fArr = this.zzbah;
        float f11 = fArr[i11];
        fArr[i11] = floatValue;
        return Float.valueOf(f11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzrj zzaj(int i11) {
        if (i11 >= this.size) {
            return new zzqz(Arrays.copyOf(this.zzbah, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzc(float f11) {
        zzc(this.size, f11);
    }

    private zzqz(float[] fArr, int i11) {
        this.zzbah = fArr;
        this.size = i11;
    }

    private final void zzc(int i11, float f11) {
        int i12;
        zzmz();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i11));
        }
        float[] fArr = this.zzbah;
        if (i12 < fArr.length) {
            System.arraycopy(fArr, i11, fArr, i11 + 1, i12 - i11);
        } else {
            float[] fArr2 = new float[(((i12 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            System.arraycopy(this.zzbah, i11, fArr2, i11 + 1, this.size - i11);
            this.zzbah = fArr2;
        }
        this.zzbah[i11] = f11;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzmz();
        zzah(i11);
        float[] fArr = this.zzbah;
        float f11 = fArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(fArr, i11 + 1, fArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f11);
    }
}
