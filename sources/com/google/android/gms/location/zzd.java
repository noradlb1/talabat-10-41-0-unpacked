package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzd implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<DetectedActivity> arrayList = null;
        Bundle bundle = null;
        long j11 = 0;
        long j12 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, DetectedActivity.CREATOR);
            } else if (fieldId == 2) {
                j11 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 3) {
                j12 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 4) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                bundle = SafeParcelReader.createBundle(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ActivityRecognitionResult(arrayList, j11, j12, i11, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new ActivityRecognitionResult[i11];
    }
}
