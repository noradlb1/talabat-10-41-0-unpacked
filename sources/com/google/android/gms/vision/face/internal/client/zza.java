package com.google.android.gms.vision.face.internal.client;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ContourParcelCreator")
@SafeParcelable.Reserved({1})
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzc();
    @SafeParcelable.Field(id = 3)
    public final int type;
    @SafeParcelable.Field(id = 2)
    public final PointF[] zzcx;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 2) PointF[] pointFArr, @SafeParcelable.Param(id = 3) int i11) {
        this.zzcx = pointFArr;
        this.type = i11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzcx, i11, false);
        SafeParcelWriter.writeInt(parcel, 3, this.type);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
