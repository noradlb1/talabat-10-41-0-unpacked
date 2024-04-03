package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaj implements Parcelable.Creator<zzak> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PlaceEntity placeEntity = null;
        float f11 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                placeEntity = (PlaceEntity) SafeParcelReader.createParcelable(parcel, readHeader, PlaceEntity.CREATOR);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                f11 = SafeParcelReader.readFloat(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzak(placeEntity, f11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzak[i11];
    }
}
