package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzag implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j11 = 0;
        long j12 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                j11 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 2) {
                j12 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 3) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 4) {
                i12 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i13 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SleepSegmentEvent(j11, j12, i11, i12, i13);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new SleepSegmentEvent[i11];
    }
}
