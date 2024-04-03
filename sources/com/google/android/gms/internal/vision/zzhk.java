package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzhk extends zzex<String> implements zzhj, RandomAccess {
    private static final zzhk zzyb;
    private static final zzhj zzyc;
    private final List<Object> zzyd;

    static {
        zzhk zzhk = new zzhk();
        zzyb = zzhk;
        zzhk.zzdp();
        zzyc = zzhk;
    }

    public zzhk() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfh) {
            return ((zzfh) obj).zzer();
        }
        return zzgt.zzh((byte[]) obj);
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzdq();
        this.zzyd.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzdq();
        this.zzyd.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i11) {
        Object obj = this.zzyd.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfh) {
            zzfh zzfh = (zzfh) obj;
            String zzer = zzfh.zzer();
            if (zzfh.zzes()) {
                this.zzyd.set(i11, zzer);
            }
            return zzer;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzgt.zzh(bArr);
        if (zzgt.zzg(bArr)) {
            this.zzyd.set(i11, zzh);
        }
        return zzh;
    }

    public final Object getRaw(int i11) {
        return this.zzyd.get(i11);
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
        zzdq();
        return zzj(this.zzyd.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzyd.size();
    }

    public final /* synthetic */ zzgz zzag(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzyd);
            return new zzhk((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void zzc(zzfh zzfh) {
        zzdq();
        this.zzyd.add(zzfh);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean zzdo() {
        return super.zzdo();
    }

    public final List<?> zzgx() {
        return Collections.unmodifiableList(this.zzyd);
    }

    public final zzhj zzgy() {
        if (zzdo()) {
            return new zzjo(this);
        }
        return this;
    }

    public zzhk(int i11) {
        this((ArrayList<Object>) new ArrayList(i11));
    }

    public final boolean addAll(int i11, Collection<? extends String> collection) {
        zzdq();
        if (collection instanceof zzhj) {
            collection = ((zzhj) collection).zzgx();
        }
        boolean addAll = this.zzyd.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzdq();
        Object remove = this.zzyd.remove(i11);
        this.modCount++;
        return zzj(remove);
    }

    private zzhk(ArrayList<Object> arrayList) {
        this.zzyd = arrayList;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
