package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzrs extends zzpo<String> implements zzrt, RandomAccess {
    private static final zzrs zzbce;
    private static final zzrt zzbcf;
    private final List<Object> zzbcg;

    static {
        zzrs zzrs = new zzrs();
        zzbce = zzrs;
        zzrs.zzmi();
        zzbcf = zzrs;
    }

    public zzrs() {
        this(10);
    }

    private static String zzv(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzps) {
            return ((zzps) obj).zznc();
        }
        return zzre.zzj((byte[]) obj);
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzmz();
        this.zzbcg.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzmz();
        this.zzbcg.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i11) {
        Object obj = this.zzbcg.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzps) {
            zzps zzps = (zzps) obj;
            String zznc = zzps.zznc();
            if (zzps.zznd()) {
                this.zzbcg.set(i11, zznc);
            }
            return zznc;
        }
        byte[] bArr = (byte[]) obj;
        String zzj = zzre.zzj(bArr);
        if (zzre.zzi(bArr)) {
            this.zzbcg.set(i11, zzj);
        }
        return zzj;
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
        zzmz();
        return zzv(this.zzbcg.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzbcg.size();
    }

    public final /* synthetic */ zzrj zzaj(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzbcg);
            return new zzrs((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final Object zzbn(int i11) {
        return this.zzbcg.get(i11);
    }

    public final void zzc(zzps zzps) {
        zzmz();
        this.zzbcg.add(zzps);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean zzmy() {
        return super.zzmy();
    }

    public final List<?> zzqa() {
        return Collections.unmodifiableList(this.zzbcg);
    }

    public final zzrt zzqb() {
        if (zzmy()) {
            return new zztu(this);
        }
        return this;
    }

    public zzrs(int i11) {
        this((ArrayList<Object>) new ArrayList(i11));
    }

    public final boolean addAll(int i11, Collection<? extends String> collection) {
        zzmz();
        if (collection instanceof zzrt) {
            collection = ((zzrt) collection).zzqa();
        }
        boolean addAll = this.zzbcg.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzmz();
        Object remove = this.zzbcg.remove(i11);
        this.modCount++;
        return zzv(remove);
    }

    private zzrs(ArrayList<Object> arrayList) {
        this.zzbcg = arrayList;
    }
}
