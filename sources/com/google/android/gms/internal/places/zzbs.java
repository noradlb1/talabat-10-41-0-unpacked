package com.google.android.gms.internal.places;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzbs extends zzq<String> implements zzbr, RandomAccess {
    private static final zzbs zzjy;
    private static final zzbr zzjz;
    private final List<Object> zzka;

    static {
        zzbs zzbs = new zzbs();
        zzjy = zzbs;
        zzbs.zzab();
        zzjz = zzbs;
    }

    public zzbs() {
        this(10);
    }

    private static String zzf(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzw) {
            return ((zzw) obj).zzad();
        }
        return zzbd.zzf((byte[]) obj);
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzac();
        this.zzka.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzac();
        this.zzka.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i11) {
        Object obj = this.zzka.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzw) {
            zzw zzw = (zzw) obj;
            String zzad = zzw.zzad();
            if (zzw.zzae()) {
                this.zzka.set(i11, zzad);
            }
            return zzad;
        }
        byte[] bArr = (byte[]) obj;
        String zzf = zzbd.zzf(bArr);
        if (zzbd.zze(bArr)) {
            this.zzka.set(i11, zzf);
        }
        return zzf;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        zzac();
        return zzf(this.zzka.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzka.size();
    }

    public final /* bridge */ /* synthetic */ boolean zzaa() {
        return super.zzaa();
    }

    public final Object zzae(int i11) {
        return this.zzka.get(i11);
    }

    public final List<?> zzby() {
        return Collections.unmodifiableList(this.zzka);
    }

    public final zzbr zzbz() {
        if (zzaa()) {
            return new zzdt(this);
        }
        return this;
    }

    public final /* synthetic */ zzbh zzh(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzka);
            return new zzbs((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public zzbs(int i11) {
        this((ArrayList<Object>) new ArrayList(i11));
    }

    public final boolean addAll(int i11, Collection<? extends String> collection) {
        zzac();
        if (collection instanceof zzbr) {
            collection = ((zzbr) collection).zzby();
        }
        boolean addAll = this.zzka.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzac();
        Object remove = this.zzka.remove(i11);
        this.modCount++;
        return zzf(remove);
    }

    private zzbs(ArrayList<Object> arrayList) {
        this.zzka = arrayList;
    }
}
