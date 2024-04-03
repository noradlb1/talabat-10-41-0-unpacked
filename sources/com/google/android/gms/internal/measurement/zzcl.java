package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InitializationParamsCreator")
public final class zzcl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcl> CREATOR = new zzcm();
    @SafeParcelable.Field(id = 1)
    public final long zza;
    @SafeParcelable.Field(id = 2)
    public final long zzb;
    @SafeParcelable.Field(id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(id = 4)
    @Nullable
    public final String zzd;
    @SafeParcelable.Field(id = 5)
    @Nullable
    public final String zze;
    @SafeParcelable.Field(id = 6)
    @Nullable
    public final String zzf;
    @SafeParcelable.Field(id = 7)
    @Nullable
    public final Bundle zzg;
    @SafeParcelable.Field(id = 8)
    @Nullable
    public final String zzh;

    @SafeParcelable.Constructor
    public zzcl(@SafeParcelable.Param(id = 1) long j11, @SafeParcelable.Param(id = 2) long j12, @SafeParcelable.Param(id = 3) boolean z11, @SafeParcelable.Param(id = 4) @Nullable String str, @SafeParcelable.Param(id = 5) @Nullable String str2, @SafeParcelable.Param(id = 6) @Nullable String str3, @SafeParcelable.Param(id = 7) @Nullable Bundle bundle, @SafeParcelable.Param(id = 8) @Nullable String str4) {
        this.zza = j11;
        this.zzb = j12;
        this.zzc = z11;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = bundle;
        this.zzh = str4;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
