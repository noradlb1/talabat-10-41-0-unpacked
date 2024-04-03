package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzceo implements Parcelable.Creator<zzcen> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzbfd zzbfd = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                zzbfd = (zzbfd) SafeParcelReader.createParcelable(parcel, readHeader, zzbfd.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                str = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzcen(zzbfd, str);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzcen[i11];
    }
}
