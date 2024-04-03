package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PlacePhotoMetadataResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public class PlacePhotoMetadataResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzk();
    @SafeParcelable.Field(id = 2)
    private final DataHolder zzaf;
    private final PlacePhotoMetadataBuffer zzag;
    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zzp;

    @SafeParcelable.Constructor
    public PlacePhotoMetadataResult(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) DataHolder dataHolder) {
        this.zzp = status;
        this.zzaf = dataHolder;
        if (dataHolder == null) {
            this.zzag = null;
        } else {
            this.zzag = new PlacePhotoMetadataBuffer(dataHolder);
        }
    }

    public PlacePhotoMetadataBuffer getPhotoMetadata() {
        return this.zzag;
    }

    public Status getStatus() {
        return this.zzp;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i11, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzaf, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
