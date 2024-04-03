package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzas implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                str2 = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 3) {
                j11 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                str3 = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PhoneMultiFactorInfo(str, str2, j11, str3);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new PhoneMultiFactorInfo[i11];
    }
}
