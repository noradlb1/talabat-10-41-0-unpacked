package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.Place;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "PlaceExtendedDetailsEntityCreator")
public final class zzai extends AbstractSafeParcelable implements Place.ExtendedDetails {
    public static final Parcelable.Creator<zzai> CREATOR = new zzah();
    @SafeParcelable.Field(getter = "getRating", id = 4)
    private final float zzcb;
    @SafeParcelable.Field(getter = "getPriceLevel", id = 5)
    private final int zzcc;
    @SafeParcelable.Field(getter = "getPlaceTypes", id = 1)
    private final List<Integer> zzg;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 2)
    private final String zzh;
    @SafeParcelable.Field(getter = "getWebsiteUri", id = 3)
    private final Uri zzi;

    @SafeParcelable.Constructor
    public zzai(@SafeParcelable.Param(id = 1) List<Integer> list, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) float f11, @SafeParcelable.Param(id = 5) int i11) {
        this.zzg = Collections.unmodifiableList(list);
        this.zzh = str;
        this.zzi = uri;
        this.zzcb = f11;
        this.zzcc = i11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzi, i11, false);
        SafeParcelWriter.writeFloat(parcel, 4, this.zzcb);
        SafeParcelWriter.writeInt(parcel, 5, this.zzcc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
