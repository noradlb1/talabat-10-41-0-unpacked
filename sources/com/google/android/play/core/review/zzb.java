package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

final class zzb implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z11;
        PendingIntent pendingIntent = (PendingIntent) parcel.readParcelable(ReviewInfo.class.getClassLoader());
        if (parcel.readInt() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        return new zza(pendingIntent, z11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new ReviewInfo[i11];
    }
}
