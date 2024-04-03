package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.RandomAccess;

final class zzen<E> extends zzbt<E> implements RandomAccess {
    private static final zzen<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzen<Object> zzen = new zzen<>(new Object[0], 0);
        zza = zzen;
        zzen.zzb();
    }

    public zzen() {
        this(new Object[10], 0);
    }

    public static <E> zzen<E> zzd() {
        return zza;
    }

    private final void zzf(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
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

    public final void add(int i11, E e11) {
        int i12;
        zzc();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
        E[] eArr = this.zzb;
        if (i12 < eArr.length) {
            System.arraycopy(eArr, i11, eArr, i11 + 1, i12 - i11);
        } else {
            E[] eArr2 = new Object[(((i12 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i11);
            System.arraycopy(this.zzb, i11, eArr2, i11 + 1, this.zzc - i11);
            this.zzb = eArr2;
        }
        this.zzb[i11] = e11;
        this.zzc++;
        this.modCount++;
    }

    public final E get(int i11) {
        zzf(i11);
        return this.zzb[i11];
    }

    public final E remove(int i11) {
        zzc();
        zzf(i11);
        E[] eArr = this.zzb;
        E e11 = eArr[i11];
        int i12 = this.zzc;
        if (i11 < i12 - 1) {
            System.arraycopy(eArr, i11 + 1, eArr, i11, (i12 - i11) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e11;
    }

    public final E set(int i11, E e11) {
        zzc();
        zzf(i11);
        E[] eArr = this.zzb;
        E e12 = eArr[i11];
        eArr[i11] = e11;
        this.modCount++;
        return e12;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzdg zze(int i11) {
        if (i11 >= this.zzc) {
            return new zzen(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzen(E[] eArr, int i11) {
        this.zzb = eArr;
        this.zzc = i11;
    }

    public final boolean add(E e11) {
        zzc();
        int i11 = this.zzc;
        E[] eArr = this.zzb;
        if (i11 == eArr.length) {
            this.zzb = Arrays.copyOf(eArr, ((i11 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        eArr2[i12] = e11;
        this.modCount++;
        return true;
    }
}
