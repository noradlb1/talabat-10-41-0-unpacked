package com.google.android.gms.internal.icing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdn extends zzbt<String> implements RandomAccess, zzdo {
    public static final zzdo zza;
    private static final zzdn zzb;
    private final List<Object> zzc;

    static {
        zzdn zzdn = new zzdn(10);
        zzb = zzdn;
        zzdn.zzb();
        zza = zzdn;
    }

    public zzdn() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzcf) {
            return ((zzcf) obj).zzk(zzdh.zza);
        }
        return zzdh.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        zzc();
        this.zzc.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i11, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzdo) {
            collection = ((zzdo) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzc();
        Object remove = this.zzc.remove(i11);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        zzc();
        return zzj(this.zzc.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    /* renamed from: zzd */
    public final String get(int i11) {
        Object obj = this.zzc.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzcf) {
            zzcf zzcf = (zzcf) obj;
            String zzk = zzcf.zzk(zzdh.zza);
            if (zzcf.zzh()) {
                this.zzc.set(i11, zzk);
            }
            return zzk;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzdh.zzd(bArr);
        if (zzdh.zzc(bArr)) {
            this.zzc.set(i11, zzd);
        }
        return zzd;
    }

    public final /* bridge */ /* synthetic */ zzdg zze(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzc);
            return new zzdn((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(zzcf zzcf) {
        zzc();
        this.zzc.add(zzcf);
        this.modCount++;
    }

    public final Object zzg(int i11) {
        return this.zzc.get(i11);
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzdo zzi() {
        if (zza()) {
            return new zzfi(this);
        }
        return this;
    }

    public zzdn(int i11) {
        this.zzc = new ArrayList(i11);
    }

    private zzdn(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
