package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgo extends zzex<Float> implements zzio, RandomAccess {
    private static final zzgo zzvq;
    private int size;
    private float[] zzvr;

    static {
        zzgo zzgo = new zzgo(new float[0], 0);
        zzvq = zzgo;
        zzgo.zzdp();
    }

    public zzgo() {
        this(new float[10], 0);
    }

    private final void zzae(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
    }

    private final String zzaf(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        float floatValue = ((Float) obj).floatValue();
        zzdq();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
        float[] fArr = this.zzvr;
        if (i12 < fArr.length) {
            System.arraycopy(fArr, i11, fArr, i11 + 1, i12 - i11);
        } else {
            float[] fArr2 = new float[(((i12 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            System.arraycopy(this.zzvr, i11, fArr2, i11 + 1, this.size - i11);
            this.zzvr = fArr2;
        }
        this.zzvr[i11] = floatValue;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzgo)) {
            return super.addAll(collection);
        }
        zzgo zzgo = (zzgo) collection;
        int i11 = zzgo.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            float[] fArr = this.zzvr;
            if (i13 > fArr.length) {
                this.zzvr = Arrays.copyOf(fArr, i13);
            }
            System.arraycopy(zzgo.zzvr, 0, this.zzvr, this.size, zzgo.size);
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
        if (!(obj instanceof zzgo)) {
            return super.equals(obj);
        }
        zzgo zzgo = (zzgo) obj;
        if (this.size != zzgo.size) {
            return false;
        }
        float[] fArr = zzgo.zzvr;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Float.floatToIntBits(this.zzvr[i11]) != Float.floatToIntBits(fArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzae(i11);
        return Float.valueOf(this.zzvr[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + Float.floatToIntBits(this.zzvr[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Float.valueOf(this.zzvr[i11]))) {
                float[] fArr = this.zzvr;
                System.arraycopy(fArr, i11 + 1, fArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzdq();
        if (i12 >= i11) {
            float[] fArr = this.zzvr;
            System.arraycopy(fArr, i12, fArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzdq();
        zzae(i11);
        float[] fArr = this.zzvr;
        float f11 = fArr[i11];
        fArr[i11] = floatValue;
        return Float.valueOf(f11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzgz zzag(int i11) {
        if (i11 >= this.size) {
            return new zzgo(Arrays.copyOf(this.zzvr, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzu(float f11) {
        zzdq();
        int i11 = this.size;
        float[] fArr = this.zzvr;
        if (i11 == fArr.length) {
            float[] fArr2 = new float[(((i11 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            this.zzvr = fArr2;
        }
        float[] fArr3 = this.zzvr;
        int i12 = this.size;
        this.size = i12 + 1;
        fArr3[i12] = f11;
    }

    private zzgo(float[] fArr, int i11) {
        this.zzvr = fArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzdq();
        zzae(i11);
        float[] fArr = this.zzvr;
        float f11 = fArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(fArr, i11 + 1, fArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f11);
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzu(((Float) obj).floatValue());
        return true;
    }
}
