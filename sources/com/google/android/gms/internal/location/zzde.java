package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

public final class zzde implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LocationRequest locationRequest = null;
        ArrayList<ClientIdentity> arrayList = null;
        String str = null;
        String str2 = null;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        long j11 = Long.MAX_VALUE;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel2, readHeader, LocationRequest.CREATOR);
            } else if (fieldId != 5) {
                switch (fieldId) {
                    case 8:
                        z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                        break;
                    case 9:
                        z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                        break;
                    case 10:
                        str = SafeParcelReader.createString(parcel2, readHeader);
                        break;
                    case 11:
                        z13 = SafeParcelReader.readBoolean(parcel2, readHeader);
                        break;
                    case 12:
                        z14 = SafeParcelReader.readBoolean(parcel2, readHeader);
                        break;
                    case 13:
                        str2 = SafeParcelReader.createString(parcel2, readHeader);
                        break;
                    case 14:
                        j11 = SafeParcelReader.readLong(parcel2, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel2, readHeader);
                        break;
                }
            } else {
                arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, ClientIdentity.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzdd(locationRequest, arrayList, z11, z12, str, z13, z14, str2, j11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzdd[i11];
    }
}
