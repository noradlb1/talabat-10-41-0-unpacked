package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

final class zzar extends zzr {
    public static final Parcelable.Creator<zzar> CREATOR = new zzaq();

    public zzar(@Nullable String str, @Nullable AddressComponents addressComponents, @Nullable Place.BusinessStatus businessStatus, @Nullable List<String> list, @Nullable String str2, @Nullable LatLng latLng, @Nullable String str3, @Nullable OpeningHours openingHours, @Nullable String str4, @Nullable List<PhotoMetadata> list2, @Nullable PlusCode plusCode, @Nullable Integer num, @Nullable Double d11, @Nullable List<Place.Type> list3, @Nullable Integer num2, @Nullable Integer num3, @Nullable LatLngBounds latLngBounds, @Nullable Uri uri, @Nullable String str5, @Nullable Integer num4) {
        super(str, addressComponents, businessStatus, list, str2, latLng, str3, openingHours, str4, list2, plusCode, num, d11, list3, num2, num3, latLngBounds, uri, str5, num4);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        if (getAddress() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAddress());
        }
        parcel.writeParcelable(getAddressComponents(), i11);
        parcel.writeParcelable(getBusinessStatus(), i11);
        parcel.writeList(getAttributions());
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        parcel.writeParcelable(getLatLng(), i11);
        if (getName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getName());
        }
        parcel.writeParcelable(getOpeningHours(), i11);
        if (getPhoneNumber() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPhoneNumber());
        }
        parcel.writeList(getPhotoMetadatas());
        parcel.writeParcelable(getPlusCode(), i11);
        if (getPriceLevel() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getPriceLevel().intValue());
        }
        if (getRating() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeDouble(getRating().doubleValue());
        }
        parcel.writeList(getTypes());
        if (getUserRatingsTotal() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getUserRatingsTotal().intValue());
        }
        if (getUtcOffsetMinutes() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getUtcOffsetMinutes().intValue());
        }
        parcel.writeParcelable(getViewport(), i11);
        parcel.writeParcelable(getWebsiteUri(), i11);
        if (getIconUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getIconUrl());
        }
        if (getIconBackgroundColor() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeInt(getIconBackgroundColor().intValue());
    }
}
