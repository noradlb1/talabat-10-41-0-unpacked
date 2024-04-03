package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zaa implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z11 = false;
        int i11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                z11 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ModuleAvailabilityResponse(z11, i11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new ModuleAvailabilityResponse[i11];
    }
}
