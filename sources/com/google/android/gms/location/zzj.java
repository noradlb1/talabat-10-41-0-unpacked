package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

public final class zzj implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        long j11 = Long.MAX_VALUE;
        long j12 = Long.MAX_VALUE;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        int i13 = 102;
        String str = null;
        zzd zzd = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 2:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 6:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel2, readHeader, WorkSource.CREATOR);
                    break;
                case 7:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel2, readHeader, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new CurrentLocationRequest(j11, i11, i13, j12, z11, i12, str, workSource, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new CurrentLocationRequest[i11];
    }
}
