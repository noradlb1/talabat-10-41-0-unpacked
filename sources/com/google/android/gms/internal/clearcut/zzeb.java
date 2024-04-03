package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.List;

final class zzeb<E> extends zzav<E> {
    private static final zzeb<Object> zznf;
    private final List<E> zzls;

    static {
        zzeb<Object> zzeb = new zzeb<>();
        zznf = zzeb;
        zzeb.zzv();
    }

    public zzeb() {
        this(new ArrayList(10));
    }

    private zzeb(List<E> list) {
        this.zzls = list;
    }

    public static <E> zzeb<E> zzcn() {
        return zznf;
    }

    public final void add(int i11, E e11) {
        zzw();
        this.zzls.add(i11, e11);
        this.modCount++;
    }

    public final E get(int i11) {
        return this.zzls.get(i11);
    }

    public final E remove(int i11) {
        zzw();
        E remove = this.zzls.remove(i11);
        this.modCount++;
        return remove;
    }

    public final E set(int i11, E e11) {
        zzw();
        E e12 = this.zzls.set(i11, e11);
        this.modCount++;
        return e12;
    }

    public final int size() {
        return this.zzls.size();
    }

    public final /* synthetic */ zzcn zzi(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzls);
            return new zzeb(arrayList);
        }
        throw new IllegalArgumentException();
    }
}
