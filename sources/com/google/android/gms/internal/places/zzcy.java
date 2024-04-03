package com.google.android.gms.internal.places;

import java.util.ArrayList;
import java.util.List;

final class zzcy<E> extends zzq<E> {
    private static final zzcy<Object> zzlo;
    private final List<E> zzka;

    static {
        zzcy<Object> zzcy = new zzcy<>(new ArrayList(0));
        zzlo = zzcy;
        zzcy.zzab();
    }

    public zzcy() {
        this(new ArrayList(10));
    }

    public static <E> zzcy<E> zzct() {
        return zzlo;
    }

    public final void add(int i11, E e11) {
        zzac();
        this.zzka.add(i11, e11);
        this.modCount++;
    }

    public final E get(int i11) {
        return this.zzka.get(i11);
    }

    public final E remove(int i11) {
        zzac();
        E remove = this.zzka.remove(i11);
        this.modCount++;
        return remove;
    }

    public final E set(int i11, E e11) {
        zzac();
        E e12 = this.zzka.set(i11, e11);
        this.modCount++;
        return e12;
    }

    public final int size() {
        return this.zzka.size();
    }

    public final /* synthetic */ zzbh zzh(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzka);
            return new zzcy(arrayList);
        }
        throw new IllegalArgumentException();
    }

    private zzcy(List<E> list) {
        this.zzka = list;
    }
}
