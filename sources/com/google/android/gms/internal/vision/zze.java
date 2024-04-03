package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zze implements Parcelable.Creator<zzf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzf(i11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzf[i11];
    }
}
