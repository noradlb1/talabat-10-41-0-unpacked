package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahm  reason: invalid package */
public final class zzahm extends zzafg implements RandomAccess, zzahn {
    @Deprecated
    public static final zzahn zza;
    private static final zzahm zzb;
    private final List zzc;

    static {
        zzahm zzahm = new zzahm(false);
        zzb = zzahm;
        zza = zzahm;
    }

    public zzahm() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzafv) {
            return ((zzafv) obj).zzo(zzahg.zzb);
        }
        return zzahg.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        zza();
        this.zzc.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i11, Collection collection) {
        zza();
        if (collection instanceof zzahn) {
            collection = ((zzahn) collection).zzh();
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
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        zza();
        return zzj(this.zzc.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzahf zzd(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzc);
            return new zzahm(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzahn zze() {
        return zzc() ? new zzajq(this) : this;
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
        if (obj instanceof zzafv) {
            zzafv zzafv = (zzafv) obj;
            String zzo = zzafv.zzo(zzahg.zzb);
            if (zzafv.zzk()) {
                this.zzc.set(i11, zzo);
            }
            return zzo;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzahg.zzd(bArr);
        if (zzaka.zze(bArr)) {
            this.zzc.set(i11, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzafv zzafv) {
        zza();
        this.zzc.add(zzafv);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzahm(int i11) {
        super(true);
        ArrayList arrayList = new ArrayList(i11);
        this.zzc = arrayList;
    }

    private zzahm(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzahm(boolean z11) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
