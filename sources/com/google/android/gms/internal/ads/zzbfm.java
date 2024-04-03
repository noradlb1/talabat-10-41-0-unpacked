package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterResponseInfoParcelCreator")
public final class zzbfm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbfm> CREATOR = new zzbfn();
    @SafeParcelable.Field(id = 1)
    public final String zza;
    @SafeParcelable.Field(id = 2)
    public long zzb;
    @SafeParcelable.Field(id = 3)
    @Nullable
    public zzbew zzc;
    @SafeParcelable.Field(id = 4)
    public final Bundle zzd;

    @SafeParcelable.Constructor
    public zzbfm(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) long j11, @SafeParcelable.Param(id = 3) @Nullable zzbew zzbew, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.zza = str;
        this.zzb = j11;
        this.zzc = zzbew;
        this.zzd = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i11, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
