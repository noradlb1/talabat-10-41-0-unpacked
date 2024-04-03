package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzq implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = new ArrayList();
        float f11 = 0.0f;
        ArrayList<PatternItem> arrayList2 = null;
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i13 = 0;
        float f12 = 0.0f;
        ArrayList<LatLng> arrayList3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    arrayList3 = SafeParcelReader.createTypedList(parcel, readHeader, LatLng.CREATOR);
                    break;
                case 3:
                    SafeParcelReader.readList(parcel, readHeader, arrayList, zzq.class.getClassLoader());
                    break;
                case 4:
                    f11 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 5:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    f12 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    i13 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 12:
                    arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PolygonOptions(arrayList3, arrayList, f11, i11, i12, f12, z11, z12, z13, i13, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new PolygonOptions[i11];
    }
}
