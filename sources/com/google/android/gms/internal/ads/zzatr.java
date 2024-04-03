package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class zzatr implements Parcelable {
    public static final Parcelable.Creator<zzatr> CREATOR = new zzatp();
    private final zzatq[] zza;

    public zzatr(Parcel parcel) {
        this.zza = new zzatq[parcel.readInt()];
        int i11 = 0;
        while (true) {
            zzatq[] zzatqArr = this.zza;
            if (i11 < zzatqArr.length) {
                zzatqArr[i11] = (zzatq) parcel.readParcelable(zzatq.class.getClassLoader());
                i11++;
            } else {
                return;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzatr.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzatr) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zza.length);
        for (zzatq writeParcelable : this.zza) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzatq zzb(int i11) {
        return this.zza[i11];
    }

    public zzatr(List<? extends zzatq> list) {
        zzatq[] zzatqArr = new zzatq[list.size()];
        this.zza = zzatqArr;
        list.toArray(zzatqArr);
    }
}
