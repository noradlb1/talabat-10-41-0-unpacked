package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zze implements Parcelable.Creator<zzf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        boolean z11 = false;
        boolean z12 = false;
        float f11 = -1.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    i13 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    f11 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzf(i11, i12, i13, z11, z12, f11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzf[i11];
    }
}
