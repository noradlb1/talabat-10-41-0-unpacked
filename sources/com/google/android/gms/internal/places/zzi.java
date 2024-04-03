package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;

@ShowFirstParty
@SafeParcelable.Class(creator = "PlaceUserDataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getPlaceId", id = 2)
    private final String placeId;
    @SafeParcelable.Field(getter = "getUserAccountName", id = 1)
    private final String zzav;
    @SafeParcelable.Field(getter = "getPlaceAliases", id = 6)
    private final List<zzg> zzdd;

    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 6) List<zzg> list) {
        this.zzav = str;
        this.placeId = str2;
        this.zzdd = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zzi = (zzi) obj;
        if (!this.zzav.equals(zzi.zzav) || !this.placeId.equals(zzi.placeId) || !this.zzdd.equals(zzi.zzdd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzav, this.placeId, this.zzdd);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("accountName", this.zzav).add(Param.PLACE_ID, this.placeId).add("placeAliases", this.zzdd).toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzav, false);
        SafeParcelWriter.writeString(parcel, 2, this.placeId, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzdd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
