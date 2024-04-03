package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzw implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = 1000;
        int i12 = 1;
        int i13 = 1;
        long j11 = 0;
        zzac[] zzacArr = null;
        boolean z11 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    zzacArr = (zzac[]) SafeParcelReader.createTypedArray(parcel2, readHeader, zzac.CREATOR);
                    break;
                case 6:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new LocationAvailability(i11, i12, i13, j11, zzacArr, z11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new LocationAvailability[i11];
    }
}
