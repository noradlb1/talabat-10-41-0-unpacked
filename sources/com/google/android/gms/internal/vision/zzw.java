package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BoundingBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzv();
    @SafeParcelable.Field(id = 5)
    public final int height;
    @SafeParcelable.Field(id = 2)
    public final int left;
    @SafeParcelable.Field(id = 3)
    public final int top;
    @SafeParcelable.Field(id = 4)
    public final int width;
    @SafeParcelable.Field(id = 6)
    public final float zzeg;

    @SafeParcelable.Constructor
    public zzw(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) int i13, @SafeParcelable.Param(id = 5) int i14, @SafeParcelable.Param(id = 6) float f11) {
        this.left = i11;
        this.top = i12;
        this.width = i13;
        this.height = i14;
        this.zzeg = f11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.left);
        SafeParcelWriter.writeInt(parcel, 3, this.top);
        SafeParcelWriter.writeInt(parcel, 4, this.width);
        SafeParcelWriter.writeInt(parcel, 5, this.height);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzeg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
