package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
@ParametersAreNonnullByDefault
public final class zzbtz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbtz> CREATOR = new zzbua();
    @SafeParcelable.VersionField(id = 1000)
    public final int zza;
    @SafeParcelable.Field(id = 1)
    public final int zzb;
    @SafeParcelable.Field(id = 2)
    public final String zzc;
    @SafeParcelable.Field(id = 3)
    public final int zzd;

    @SafeParcelable.Constructor
    public zzbtz(@SafeParcelable.Param(id = 1000) int i11, @SafeParcelable.Param(id = 1) int i12, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i13) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = str;
        this.zzd = i13;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeString(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
