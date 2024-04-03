package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbb extends zzq<Float> implements zzcw, RandomAccess {
    private static final zzbb zzic;
    private int size;
    private float[] zzid;

    static {
        zzbb zzbb = new zzbb(new float[0], 0);
        zzic = zzbb;
        zzbb.zzab();
    }

    public zzbb() {
        this(new float[10], 0);
    }

    private final void zzd(int i11, float f11) {
        int i12;
        zzac();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
        float[] fArr = this.zzid;
        if (i12 < fArr.length) {
            System.arraycopy(fArr, i11, fArr, i11 + 1, i12 - i11);
        } else {
            float[] fArr2 = new float[(((i12 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            System.arraycopy(this.zzid, i11, fArr2, i11 + 1, this.size - i11);
            this.zzid = fArr2;
        }
        this.zzid[i11] = f11;
        this.size++;
        this.modCount++;
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
        zzd(i11, ((Float) obj).floatValue());
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzbb)) {
            return super.addAll(collection);
        }
        zzbb zzbb = (zzbb) collection;
        int i11 = zzbb.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            float[] fArr = this.zzid;
            if (i13 > fArr.length) {
                this.zzid = Arrays.copyOf(fArr, i13);
            }
            System.arraycopy(zzbb.zzid, 0, this.zzid, this.size, zzbb.size);
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
        if (!(obj instanceof zzbb)) {
            return super.equals(obj);
        }
        zzbb zzbb = (zzbb) obj;
        if (this.size != zzbb.size) {
            return false;
        }
        float[] fArr = zzbb.zzid;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Float.floatToIntBits(this.zzid[i11]) != Float.floatToIntBits(fArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzf(i11);
        return Float.valueOf(this.zzid[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + Float.floatToIntBits(this.zzid[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzac();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Float.valueOf(this.zzid[i11]))) {
                float[] fArr = this.zzid;
                System.arraycopy(fArr, i11 + 1, fArr, i11, (this.size - i11) - 1);
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
            float[] fArr = this.zzid;
            System.arraycopy(fArr, i12, fArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzac();
        zzf(i11);
        float[] fArr = this.zzid;
        float f11 = fArr[i11];
        fArr[i11] = floatValue;
        return Float.valueOf(f11);
    }

    public final int size() {
        return this.size;
    }

    public final void zzf(float f11) {
        zzd(this.size, f11);
    }

    public final /* synthetic */ zzbh zzh(int i11) {
        if (i11 >= this.size) {
            return new zzbb(Arrays.copyOf(this.zzid, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzbb(float[] fArr, int i11) {
        this.zzid = fArr;
        this.size = i11;
    }

    private final void zzf(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
    }

    public final /* synthetic */ Object remove(int i11) {
        zzac();
        zzf(i11);
        float[] fArr = this.zzid;
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
