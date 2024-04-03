package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzchy implements Parcelable.Creator<zzchx> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zzbfi zzbfi = null;
        zzbfd zzbfd = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                str2 = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 3) {
                zzbfi = (zzbfi) SafeParcelReader.createParcelable(parcel, readHeader, zzbfi.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzbfd = (zzbfd) SafeParcelReader.createParcelable(parcel, readHeader, zzbfd.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzchx(str, str2, zzbfi, zzbfd);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzchx[i11];
    }
}
