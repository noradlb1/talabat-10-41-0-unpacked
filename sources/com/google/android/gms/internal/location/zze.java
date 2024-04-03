package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zze implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List zzk = zzds.zzk();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        zzd zzd = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    i13 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
                    break;
                case 8:
                    zzk = SafeParcelReader.createTypedList(parcel, readHeader, Feature.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzd(i11, i12, str, str2, str3, i13, zzk, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzd[i11];
    }
}
