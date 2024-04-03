package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "PlaceOpeningHoursEntityCreator")
@SafeParcelable.Reserved({1000})
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzaq();
    @SafeParcelable.Field(id = 1)
    private final List<zzao> zzcl;
    @SafeParcelable.Field(id = 2)
    private final List<zzan> zzcm;

    @SafeParcelable.Constructor
    public zzal(@SafeParcelable.Param(id = 1) List<zzao> list, @SafeParcelable.Param(id = 2) List<zzan> list2) {
        this.zzcl = Collections.unmodifiableList(list);
        this.zzcm = Collections.unmodifiableList(list2);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zzcl, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzcm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
