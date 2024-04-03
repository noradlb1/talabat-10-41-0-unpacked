package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzcen extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcen> CREATOR = new zzceo();
    @SafeParcelable.Field(id = 2)
    public final zzbfd zza;
    @SafeParcelable.Field(id = 3)
    public final String zzb;

    @SafeParcelable.Constructor
    public zzcen(@SafeParcelable.Param(id = 2) zzbfd zzbfd, @SafeParcelable.Param(id = 3) String str) {
        this.zza = zzbfd;
        this.zzb = str;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i11, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
