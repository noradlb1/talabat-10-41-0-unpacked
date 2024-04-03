package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
@ParametersAreNonnullByDefault
public final class zzchx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzchx> CREATOR = new zzchy();
    @SafeParcelable.Field(id = 1)
    @Deprecated
    public final String zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    @Deprecated
    public final zzbfi zzc;
    @SafeParcelable.Field(id = 4)
    public final zzbfd zzd;

    @SafeParcelable.Constructor
    public zzchx(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) zzbfi zzbfi, @SafeParcelable.Param(id = 4) zzbfd zzbfd) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbfi;
        this.zzd = zzbfd;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
