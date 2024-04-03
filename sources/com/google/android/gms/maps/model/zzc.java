package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzc implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        ArrayList<PatternItem> arrayList = null;
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        boolean z12 = false;
        float f11 = 0.0f;
        float f12 = 0.0f;
        double d11 = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel2, readHeader, LatLng.CREATOR);
                    break;
                case 3:
                    d11 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 4:
                    f11 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 5:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 6:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    f12 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 8:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 9:
                    z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 10:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new CircleOptions(latLng, d11, f11, i11, i12, f12, z11, z12, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new CircleOptions[i11];
    }
}
