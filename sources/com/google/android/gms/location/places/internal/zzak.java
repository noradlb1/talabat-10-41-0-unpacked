package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

@SafeParcelable.Class(creator = "PlaceLikelihoodEntityCreator")
@SafeParcelable.Reserved({1000})
public final class zzak extends AbstractSafeParcelable implements PlaceLikelihood {
    public static final Parcelable.Creator<zzak> CREATOR = new zzaj();
    @SafeParcelable.Field(id = 1)
    private final PlaceEntity zzcj;
    @SafeParcelable.Field(id = 2)
    private final float zzck;

    @SafeParcelable.Constructor
    public zzak(@SafeParcelable.Param(id = 1) PlaceEntity placeEntity, @SafeParcelable.Param(id = 2) float f11) {
        this.zzcj = placeEntity;
        this.zzck = f11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzak)) {
            return false;
        }
        zzak zzak = (zzak) obj;
        if (!this.zzcj.equals(zzak.zzcj) || this.zzck != zzak.zzck) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final float getLikelihood() {
        return this.zzck;
    }

    public final Place getPlace() {
        return this.zzcj;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzcj, Float.valueOf(this.zzck));
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("place", this.zzcj).add("likelihood", Float.valueOf(this.zzck)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzcj, i11, false);
        SafeParcelWriter.writeFloat(parcel, 2, this.zzck);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
