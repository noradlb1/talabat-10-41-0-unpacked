package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import java.util.Arrays;

public final class zzatt extends zzatx {
    public static final Parcelable.Creator<zzatt> CREATOR = new zzats();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    public zzatt(Parcel parcel) {
        super(ApicFrame.ID);
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzatt.class == obj.getClass()) {
            zzatt zzatt = (zzatt) obj;
            if (this.zzc != zzatt.zzc || !zzaxb.zzo(this.zza, zzatt.zza) || !zzaxb.zzo(this.zzb, zzatt.zzb) || !Arrays.equals(this.zzd, zzatt.zzd)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12 = (this.zzc + 527) * 31;
        String str = this.zza;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i12 + i11) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i13 = str2.hashCode();
        }
        return ((i14 + i13) * 31) + Arrays.hashCode(this.zzd);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzatt(String str, String str2, int i11, byte[] bArr) {
        super(ApicFrame.ID);
        this.zza = str;
        this.zzb = null;
        this.zzc = 3;
        this.zzd = bArr;
    }
}
