package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AdRequestParcelCreator")
public final class zzbfd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbfd> CREATOR = new zzbff();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    @Deprecated
    public final long zzb;
    @SafeParcelable.Field(id = 3)
    public final Bundle zzc;
    @SafeParcelable.Field(id = 4)
    @Deprecated
    public final int zzd;
    @SafeParcelable.Field(id = 5)
    public final List<String> zze;
    @SafeParcelable.Field(id = 6)
    public final boolean zzf;
    @SafeParcelable.Field(id = 7)
    public final int zzg;
    @SafeParcelable.Field(id = 8)
    public final boolean zzh;
    @SafeParcelable.Field(id = 9)
    public final String zzi;
    @SafeParcelable.Field(id = 10)
    public final zzbkm zzj;
    @SafeParcelable.Field(id = 11)
    public final Location zzk;
    @SafeParcelable.Field(id = 12)
    public final String zzl;
    @SafeParcelable.Field(id = 13)
    public final Bundle zzm;
    @SafeParcelable.Field(id = 14)
    public final Bundle zzn;
    @SafeParcelable.Field(id = 15)
    public final List<String> zzo;
    @SafeParcelable.Field(id = 16)
    public final String zzp;
    @SafeParcelable.Field(id = 17)
    public final String zzq;
    @SafeParcelable.Field(id = 18)
    @Deprecated
    public final boolean zzr;
    @SafeParcelable.Field(id = 19)
    @Nullable
    public final zzbeu zzs;
    @SafeParcelable.Field(id = 20)
    public final int zzt;
    @SafeParcelable.Field(id = 21)
    @Nullable
    public final String zzu;
    @SafeParcelable.Field(id = 22)
    public final List<String> zzv;
    @SafeParcelable.Field(id = 23)
    public final int zzw;
    @SafeParcelable.Field(id = 24)
    @Nullable
    public final String zzx;

    @SafeParcelable.Constructor
    public zzbfd(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) long j11, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i12, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z11, @SafeParcelable.Param(id = 7) int i13, @SafeParcelable.Param(id = 8) boolean z12, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzbkm zzbkm, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List<String> list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z13, @SafeParcelable.Param(id = 19) zzbeu zzbeu, @SafeParcelable.Param(id = 20) int i14, @SafeParcelable.Param(id = 21) @Nullable String str5, @SafeParcelable.Param(id = 22) List<String> list3, @SafeParcelable.Param(id = 23) int i15, @SafeParcelable.Param(id = 24) String str6) {
        this.zza = i11;
        this.zzb = j11;
        this.zzc = bundle == null ? new Bundle() : bundle;
        this.zzd = i12;
        this.zze = list;
        this.zzf = z11;
        this.zzg = i13;
        this.zzh = z12;
        this.zzi = str;
        this.zzj = zzbkm;
        this.zzk = location;
        this.zzl = str2;
        this.zzm = bundle2 == null ? new Bundle() : bundle2;
        this.zzn = bundle3;
        this.zzo = list2;
        this.zzp = str3;
        this.zzq = str4;
        this.zzr = z13;
        this.zzs = zzbeu;
        this.zzt = i14;
        this.zzu = str5;
        this.zzv = list3 == null ? new ArrayList<>() : list3;
        this.zzw = i15;
        this.zzx = str6;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbfd)) {
            return false;
        }
        zzbfd zzbfd = (zzbfd) obj;
        if (this.zza != zzbfd.zza || this.zzb != zzbfd.zzb || !zzcja.zza(this.zzc, zzbfd.zzc) || this.zzd != zzbfd.zzd || !Objects.equal(this.zze, zzbfd.zze) || this.zzf != zzbfd.zzf || this.zzg != zzbfd.zzg || this.zzh != zzbfd.zzh || !Objects.equal(this.zzi, zzbfd.zzi) || !Objects.equal(this.zzj, zzbfd.zzj) || !Objects.equal(this.zzk, zzbfd.zzk) || !Objects.equal(this.zzl, zzbfd.zzl) || !zzcja.zza(this.zzm, zzbfd.zzm) || !zzcja.zza(this.zzn, zzbfd.zzn) || !Objects.equal(this.zzo, zzbfd.zzo) || !Objects.equal(this.zzp, zzbfd.zzp) || !Objects.equal(this.zzq, zzbfd.zzq) || this.zzr != zzbfd.zzr || this.zzt != zzbfd.zzt || !Objects.equal(this.zzu, zzbfd.zzu) || !Objects.equal(this.zzv, zzbfd.zzv) || this.zzw != zzbfd.zzw || !Objects.equal(this.zzx, zzbfd.zzx)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze, Boolean.valueOf(this.zzf), Integer.valueOf(this.zzg), Boolean.valueOf(this.zzh), this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, Boolean.valueOf(this.zzr), Integer.valueOf(this.zzt), this.zzu, this.zzv, Integer.valueOf(this.zzw), this.zzx);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeBundle(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeStringList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i11, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzr);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzs, i11, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzt);
        SafeParcelWriter.writeString(parcel, 21, this.zzu, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzv, false);
        SafeParcelWriter.writeInt(parcel, 23, this.zzw);
        SafeParcelWriter.writeString(parcel, 24, this.zzx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
