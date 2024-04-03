package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Parcelable.Creator<Configuration> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = 0;
        zzi[] zziArr = null;
        String[] strArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                zziArr = (zzi[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzi.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                strArr = SafeParcelReader.createStringArray(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Configuration(i11, zziArr, strArr);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new Configuration[i11];
    }
}
