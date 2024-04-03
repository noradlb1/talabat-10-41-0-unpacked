package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PlacePhotoResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public class PlacePhotoResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzl();
    @SafeParcelable.Field(id = 2)
    private final BitmapTeleporter zzah;
    private final Bitmap zzai;
    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zzp;

    @SafeParcelable.Constructor
    public PlacePhotoResult(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) BitmapTeleporter bitmapTeleporter) {
        this.zzp = status;
        this.zzah = bitmapTeleporter;
        if (bitmapTeleporter != null) {
            this.zzai = bitmapTeleporter.get();
        } else {
            this.zzai = null;
        }
    }

    public Bitmap getBitmap() {
        return this.zzai;
    }

    public Status getStatus() {
        return this.zzp;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzp).add("bitmap", this.zzai).toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i11, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzah, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
