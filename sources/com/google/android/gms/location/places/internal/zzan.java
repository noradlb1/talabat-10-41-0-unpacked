package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ExceptionalHoursCreator")
@SafeParcelable.Reserved({1000})
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new zzf();
    @SafeParcelable.Field(id = 4)
    private final int endYear;
    @SafeParcelable.Field(id = 1)
    private final int startYear;
    @SafeParcelable.Field(id = 2)
    private final int zzcn;
    @SafeParcelable.Field(id = 3)
    private final int zzco;
    @SafeParcelable.Field(id = 5)
    private final int zzcp;
    @SafeParcelable.Field(id = 6)
    private final int zzcq;
    @SafeParcelable.Field(id = 7)
    private final List<zzao> zzcr;

    @SafeParcelable.Constructor
    public zzan(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) int i13, @SafeParcelable.Param(id = 4) int i14, @SafeParcelable.Param(id = 5) int i15, @SafeParcelable.Param(id = 6) int i16, @SafeParcelable.Param(id = 7) List<zzao> list) {
        this.startYear = i11;
        this.zzcn = i12;
        this.zzco = i13;
        this.endYear = i14;
        this.zzcp = i15;
        this.zzcq = i16;
        this.zzcr = Collections.unmodifiableList(list);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.startYear);
        SafeParcelWriter.writeInt(parcel, 2, this.zzcn);
        SafeParcelWriter.writeInt(parcel, 3, this.zzco);
        SafeParcelWriter.writeInt(parcel, 4, this.endYear);
        SafeParcelWriter.writeInt(parcel, 5, this.zzcp);
        SafeParcelWriter.writeInt(parcel, 6, this.zzcq);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzcr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
