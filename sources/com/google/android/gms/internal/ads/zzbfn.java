package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbfn implements Parcelable.Creator<zzbfm> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzbew zzbew = null;
        Bundle bundle = null;
        long j11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                j11 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 3) {
                zzbew = (zzbew) SafeParcelReader.createParcelable(parcel, readHeader, zzbew.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                bundle = SafeParcelReader.createBundle(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzbfm(str, j11, zzbew, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzbfm[i11];
    }
}
