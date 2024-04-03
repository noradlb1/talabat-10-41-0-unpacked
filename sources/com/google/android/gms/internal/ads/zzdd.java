package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public final class zzdd implements Parcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzdb();
    private final zzdc[] zza;

    public zzdd(Parcel parcel) {
        this.zza = new zzdc[parcel.readInt()];
        int i11 = 0;
        while (true) {
            zzdc[] zzdcArr = this.zza;
            if (i11 < zzdcArr.length) {
                zzdcArr[i11] = (zzdc) parcel.readParcelable(zzdc.class.getClassLoader());
                i11++;
            } else {
                return;
            }
        }
    }

    public zzdd(zzdc... zzdcArr) {
        this.zza = zzdcArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdd.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzdd) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.zza));
        return valueOf.length() != 0 ? "entries=".concat(valueOf) : new String("entries=");
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zza.length);
        for (zzdc writeParcelable : this.zza) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzdc zzb(int i11) {
        return this.zza[i11];
    }

    public final zzdd zzc(zzdc... zzdcArr) {
        if (zzdcArr.length == 0) {
            return this;
        }
        return new zzdd((zzdc[]) zzfn.zzZ(this.zza, zzdcArr));
    }

    public final zzdd zzd(@Nullable zzdd zzdd) {
        return zzdd == null ? this : zzc(zzdd.zza);
    }

    public zzdd(List<? extends zzdc> list) {
        this.zza = (zzdc[]) list.toArray(new zzdc[0]);
    }
}
