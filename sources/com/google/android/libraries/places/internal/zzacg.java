package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzacg extends zzaak<String> implements RandomAccess, zzach {
    public static final zzach zza;
    private static final zzacg zzb;
    private final List<Object> zzc;

    static {
        zzacg zzacg = new zzacg(10);
        zzb = zzacg;
        zzacg.zzb();
        zza = zzacg;
    }

    public zzacg() {
        this(10);
    }

    private static String zzi(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzaax) {
            return ((zzaax) obj).zzm(zzaca.zza);
        }
        return zzaca.zzh((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        zza();
        this.zzc.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i11, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzach) {
            collection = ((zzach) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zza();
        Object remove = this.zzc.remove(i11);
        this.modCount++;
        return zzi(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        zza();
        return zzi(this.zzc.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final zzach zzd() {
        return zzc() ? new zzaeg(this) : this;
    }

    public final Object zze(int i11) {
        return this.zzc.get(i11);
    }

    public final /* bridge */ /* synthetic */ zzabz zzf(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzc);
            return new zzacg((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: zzg */
    public final String get(int i11) {
        Object obj = this.zzc.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzaax) {
            zzaax zzaax = (zzaax) obj;
            String zzm = zzaax.zzm(zzaca.zza);
            if (zzaax.zzi()) {
                this.zzc.set(i11, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzaca.zzh(bArr);
        if (zzaca.zzi(bArr)) {
            this.zzc.set(i11, zzh);
        }
        return zzh;
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzacg(int i11) {
        this.zzc = new ArrayList(i11);
    }

    private zzacg(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
