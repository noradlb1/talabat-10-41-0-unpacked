package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.Place;
import java.util.ArrayList;

final class zzaq implements Parcelable.Creator<zzar> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str;
        String str2;
        String str3;
        String str4;
        Integer num;
        Double d11;
        Integer num2;
        Integer num3;
        String str5;
        Integer num4;
        Parcel parcel2 = parcel;
        if (parcel.readInt() == 0) {
            str = parcel.readString();
        } else {
            str = null;
        }
        Class<Place> cls = Place.class;
        AddressComponents addressComponents = (AddressComponents) parcel2.readParcelable(cls.getClassLoader());
        Place.BusinessStatus businessStatus = (Place.BusinessStatus) parcel2.readParcelable(cls.getClassLoader());
        ArrayList readArrayList = parcel2.readArrayList(cls.getClassLoader());
        if (parcel.readInt() == 0) {
            str2 = parcel.readString();
        } else {
            str2 = null;
        }
        LatLng latLng = (LatLng) parcel2.readParcelable(cls.getClassLoader());
        if (parcel.readInt() == 0) {
            str3 = parcel.readString();
        } else {
            str3 = null;
        }
        OpeningHours openingHours = (OpeningHours) parcel2.readParcelable(cls.getClassLoader());
        if (parcel.readInt() == 0) {
            str4 = parcel.readString();
        } else {
            str4 = null;
        }
        ArrayList readArrayList2 = parcel2.readArrayList(cls.getClassLoader());
        PlusCode plusCode = (PlusCode) parcel2.readParcelable(cls.getClassLoader());
        if (parcel.readInt() == 0) {
            num = Integer.valueOf(parcel.readInt());
        } else {
            num = null;
        }
        if (parcel.readInt() == 0) {
            d11 = Double.valueOf(parcel.readDouble());
        } else {
            d11 = null;
        }
        ArrayList readArrayList3 = parcel2.readArrayList(cls.getClassLoader());
        if (parcel.readInt() == 0) {
            num2 = Integer.valueOf(parcel.readInt());
        } else {
            num2 = null;
        }
        if (parcel.readInt() == 0) {
            num3 = Integer.valueOf(parcel.readInt());
        } else {
            num3 = null;
        }
        LatLngBounds latLngBounds = (LatLngBounds) parcel2.readParcelable(cls.getClassLoader());
        Uri uri = (Uri) parcel2.readParcelable(cls.getClassLoader());
        if (parcel.readInt() == 0) {
            str5 = parcel.readString();
        } else {
            str5 = null;
        }
        if (parcel.readInt() == 0) {
            num4 = Integer.valueOf(parcel.readInt());
        } else {
            num4 = null;
        }
        return new zzar(str, addressComponents, businessStatus, readArrayList, str2, latLng, str3, openingHours, str4, readArrayList2, plusCode, num, d11, readArrayList3, num2, num3, latLngBounds, uri, str5, num4);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzar[i11];
    }
}
