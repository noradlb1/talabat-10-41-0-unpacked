package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzab implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 2:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z15 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    z16 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LocationSettingsStates(z11, z12, z13, z14, z15, z16);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new LocationSettingsStates[i11];
    }
}
