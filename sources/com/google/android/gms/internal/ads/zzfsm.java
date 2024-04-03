package com.google.android.gms.internal.ads;

public abstract class zzfsm<E> {
    public static int zzd(int i11, int i12) {
        int i13 = i11 + (i11 >> 1) + 1;
        if (i13 < i12) {
            int highestOneBit = Integer.highestOneBit(i12 - 1);
            i13 = highestOneBit + highestOneBit;
        }
        if (i13 < 0) {
            return Integer.MAX_VALUE;
        }
        return i13;
    }

    public abstract zzfsm<E> zzb(E e11);
}
