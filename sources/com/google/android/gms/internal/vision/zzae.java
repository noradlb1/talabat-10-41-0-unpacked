package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "RecognitionOptionsCreator")
@SafeParcelable.Reserved({1})
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzad();
    @SafeParcelable.Field(id = 2)
    public final Rect zzeq;

    public zzae() {
        this.zzeq = new Rect();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzeq, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzae(@SafeParcelable.Param(id = 2) Rect rect) {
        this.zzeq = rect;
    }
}
