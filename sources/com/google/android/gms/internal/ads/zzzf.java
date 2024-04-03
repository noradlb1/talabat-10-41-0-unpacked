package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import java.util.Arrays;

public final class zzzf extends zzzu {
    public static final Parcelable.Creator<zzzf> CREATOR = new zzze();
    public final String zza;
    @Nullable
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    public zzzf(Parcel parcel) {
        super(ApicFrame.ID);
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = (byte[]) zzfn.zzC(parcel.createByteArray());
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzf.class == obj.getClass()) {
            zzzf zzzf = (zzzf) obj;
            if (this.zzc != zzzf.zzc || !zzfn.zzP(this.zza, zzzf.zza) || !zzfn.zzP(this.zzb, zzzf.zzb) || !Arrays.equals(this.zzd, zzzf.zzd)) {
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

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        int length = String.valueOf(str).length();
        StringBuilder sb2 = new StringBuilder(length + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append(": mimeType=");
        sb2.append(str2);
        sb2.append(", description=");
        sb2.append(str3);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public final void zza(zzbc zzbc) {
        zzbc.zza(this.zzd, this.zzc);
    }

    public zzzf(String str, @Nullable String str2, int i11, byte[] bArr) {
        super(ApicFrame.ID);
        this.zza = str;
        this.zzb = str2;
        this.zzc = i11;
        this.zzd = bArr;
    }
}
