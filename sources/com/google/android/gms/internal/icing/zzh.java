package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzh implements Parcelable.Creator<zzg> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzk[] zzkArr = null;
        Account account = null;
        boolean z11 = false;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                zzkArr = (zzk[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzk.CREATOR);
            } else if (fieldId == 2) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 3) {
                z11 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzg(zzkArr, str, z11, account);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzg[i11];
    }
}
