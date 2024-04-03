package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LineBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzab();
    @SafeParcelable.Field(id = 7)
    private final float zzdo;
    @SafeParcelable.Field(id = 8)
    public final String zzec;
    @SafeParcelable.Field(id = 2)
    public final zzaj[] zzeh;
    @SafeParcelable.Field(id = 3)
    public final zzw zzei;
    @SafeParcelable.Field(id = 4)
    private final zzw zzej;
    @SafeParcelable.Field(id = 5)
    private final zzw zzek;
    @SafeParcelable.Field(id = 6)
    public final String zzel;
    @SafeParcelable.Field(id = 9)
    private final int zzem;
    @SafeParcelable.Field(id = 10)
    public final boolean zzen;
    @SafeParcelable.Field(id = 11)
    public final int zzeo;
    @SafeParcelable.Field(id = 12)
    public final int zzep;

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param(id = 2) zzaj[] zzajArr, @SafeParcelable.Param(id = 3) zzw zzw, @SafeParcelable.Param(id = 4) zzw zzw2, @SafeParcelable.Param(id = 5) zzw zzw3, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) float f11, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) int i11, @SafeParcelable.Param(id = 10) boolean z11, @SafeParcelable.Param(id = 11) int i12, @SafeParcelable.Param(id = 12) int i13) {
        this.zzeh = zzajArr;
        this.zzei = zzw;
        this.zzej = zzw2;
        this.zzek = zzw3;
        this.zzel = str;
        this.zzdo = f11;
        this.zzec = str2;
        this.zzem = i11;
        this.zzen = z11;
        this.zzeo = i12;
        this.zzep = i13;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzeh, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzei, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzej, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzek, i11, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzel, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzdo);
        SafeParcelWriter.writeString(parcel, 8, this.zzec, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzem);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzen);
        SafeParcelWriter.writeInt(parcel, 11, this.zzeo);
        SafeParcelWriter.writeInt(parcel, 12, this.zzep);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
