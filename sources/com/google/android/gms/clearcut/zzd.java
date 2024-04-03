package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzd implements Parcelable.Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z11 = false;
        long j11 = 0;
        long j12 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                z11 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 2) {
                j12 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                j11 = SafeParcelReader.readLong(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzc(z11, j11, j12);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzc[i11];
    }
}
