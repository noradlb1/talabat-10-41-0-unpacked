package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.RandomAccess;

final class zzadi<E> extends zzaak<E> implements RandomAccess {
    private static final zzadi<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzadi<Object> zzadi = new zzadi<>(new Object[0], 0);
        zza = zzadi;
        zzadi.zzb();
    }

    public zzadi() {
        this(new Object[10], 0);
    }

    public static <E> zzadi<E> zzd() {
        return zza;
    }

    private final String zze(int i11) {
        int i12 = this.zzc;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    private final void zzg(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zze(i11));
        }
    }

    public final void add(int i11, E e11) {
        int i12;
        zza();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zze(i11));
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
        zzg(i11);
        return this.zzb[i11];
    }

    public final E remove(int i11) {
        zza();
        zzg(i11);
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
        zza();
        zzg(i11);
        E[] eArr = this.zzb;
        E e12 = eArr[i11];
        eArr[i11] = e11;
        this.modCount++;
        return e12;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzabz zzf(int i11) {
        if (i11 >= this.zzc) {
            return new zzadi(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzadi(E[] eArr, int i11) {
        this.zzb = eArr;
        this.zzc = i11;
    }

    public final boolean add(E e11) {
        zza();
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
