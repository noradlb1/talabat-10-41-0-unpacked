package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AppOpenAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbfo> CREATOR = new zzbfp();
    @SafeParcelable.Field(id = 2)
    @AppOpenAd.AppOpenAdOrientation
    public final int zza;

    @SafeParcelable.Constructor
    public zzbfo(@SafeParcelable.Param(id = 2) @AppOpenAd.AppOpenAdOrientation int i11) {
        this.zza = i11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
