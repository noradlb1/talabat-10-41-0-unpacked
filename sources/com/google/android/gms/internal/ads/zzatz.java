package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzatz extends zzatx {
    public static final Parcelable.Creator<zzatz> CREATOR = new zzaty();
    public final String zza;
    public final String zzb;

    public zzatz(Parcel parcel) {
        super(parcel.readString());
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzatz.class == obj.getClass()) {
            zzatz zzatz = (zzatz) obj;
            if (!this.zze.equals(zzatz.zze) || !zzaxb.zzo(this.zza, zzatz.zza) || !zzaxb.zzo(this.zzb, zzatz.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = (this.zze.hashCode() + 527) * 31;
        String str = this.zza;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = (hashCode + i11) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zze);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public zzatz(String str, String str2, String str3) {
        super(str);
        this.zza = null;
        this.zzb = str3;
    }
}
