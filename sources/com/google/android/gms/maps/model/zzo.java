package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.PinConfig;

public final class zzo implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PinConfig.Glyph glyph = null;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                i12 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                glyph = (PinConfig.Glyph) SafeParcelReader.createParcelable(parcel, readHeader, PinConfig.Glyph.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PinConfig(i11, i12, glyph);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new PinConfig[i11];
    }
}
