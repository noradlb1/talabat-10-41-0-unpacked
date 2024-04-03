package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

public final class zzdqn {
    public static final zzdqn zza = new zzdqn(new zzdql());
    @Nullable
    private final zzbpj zzb;
    @Nullable
    private final zzbpg zzc;
    @Nullable
    private final zzbpw zzd;
    @Nullable
    private final zzbpt zze;
    @Nullable
    private final zzbui zzf;
    private final SimpleArrayMap<String, zzbpp> zzg;
    private final SimpleArrayMap<String, zzbpm> zzh;

    private zzdqn(zzdql zzdql) {
        this.zzb = zzdql.zza;
        this.zzc = zzdql.zzb;
        this.zzd = zzdql.zzc;
        this.zzg = new SimpleArrayMap<>(zzdql.zzf);
        this.zzh = new SimpleArrayMap<>(zzdql.zzg);
        this.zze = zzdql.zzd;
        this.zzf = zzdql.zze;
    }

    @Nullable
    public final zzbpg zza() {
        return this.zzc;
    }

    @Nullable
    public final zzbpj zzb() {
        return this.zzb;
    }

    @Nullable
    public final zzbpm zzc(String str) {
        return this.zzh.get(str);
    }

    @Nullable
    public final zzbpp zzd(String str) {
        return this.zzg.get(str);
    }

    @Nullable
    public final zzbpt zze() {
        return this.zze;
    }

    @Nullable
    public final zzbpw zzf() {
        return this.zzd;
    }

    @Nullable
    public final zzbui zzg() {
        return this.zzf;
    }

    public final ArrayList<String> zzh() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzg.size());
        for (int i11 = 0; i11 < this.zzg.size(); i11++) {
            arrayList.add(this.zzg.keyAt(i11));
        }
        return arrayList;
    }

    public final ArrayList<String> zzi() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzg.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
