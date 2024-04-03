package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzcjg implements Parcelable.Creator<zzcjf> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 3) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 4) {
                i12 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 5) {
                z11 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                z12 = SafeParcelReader.readBoolean(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzcjf(str, i11, i12, z11, z12);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzcjf[i11];
    }
}
