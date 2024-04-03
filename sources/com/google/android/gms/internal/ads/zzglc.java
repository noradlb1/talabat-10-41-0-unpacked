package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzglc extends zzgio<String> implements RandomAccess, zzgld {
    public static final zzgld zza;
    private static final zzglc zzb;
    private final List<Object> zzc;

    static {
        zzglc zzglc = new zzglc(10);
        zzb = zzglc;
        zzglc.zzb();
        zza = zzglc;
    }

    public zzglc() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgjf) {
            return ((zzgjf) obj).zzA(zzgkv.zzb);
        }
        return zzgkv.zzh((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        zzbU();
        this.zzc.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i11, Collection<? extends String> collection) {
        zzbU();
        if (collection instanceof zzgld) {
            collection = ((zzgld) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbU();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzbU();
        Object remove = this.zzc.remove(i11);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        zzbU();
        return zzj(this.zzc.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzgku zzd(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzc);
            return new zzglc((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzgld zze() {
        return zzc() ? new zzgnk(this) : this;
    }

    public final Object zzf(int i11) {
        return this.zzc.get(i11);
    }

    /* renamed from: zzg */
    public final String get(int i11) {
        Object obj = this.zzc.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgjf) {
            zzgjf zzgjf = (zzgjf) obj;
            String zzA = zzgjf.zzA(zzgkv.zzb);
            if (zzgjf.zzp()) {
                this.zzc.set(i11, zzA);
            }
            return zzA;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzgkv.zzh(bArr);
        if (zzgkv.zzi(bArr)) {
            this.zzc.set(i11, zzh);
        }
        return zzh;
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzgjf zzgjf) {
        zzbU();
        this.zzc.add(zzgjf);
        this.modCount++;
    }

    public zzglc(int i11) {
        this.zzc = new ArrayList(i11);
    }

    private zzglc(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
