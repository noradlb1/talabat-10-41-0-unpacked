package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzx implements Parcelable.Creator<zzac> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z11 = false;
        int i11 = 0;
        String str = null;
        Bundle bundle = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                z11 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 2) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 4) {
                bundle = SafeParcelReader.createBundle(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                bundle2 = SafeParcelReader.createBundle(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzac(z11, i11, str, bundle, bundle2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzac[i11];
    }
}
