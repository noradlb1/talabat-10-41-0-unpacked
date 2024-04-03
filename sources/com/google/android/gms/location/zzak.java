package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzak implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                i12 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                i13 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i14 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzaj(i11, i12, i13, i14);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzaj[i11];
    }
}
