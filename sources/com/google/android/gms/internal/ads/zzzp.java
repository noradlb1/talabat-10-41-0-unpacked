package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import java.util.Arrays;

public final class zzzp extends zzzu {
    public static final Parcelable.Creator<zzzp> CREATOR = new zzzo();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    public zzzp(Parcel parcel) {
        super(GeobFrame.ID);
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = (byte[]) zzfn.zzC(parcel.createByteArray());
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzp.class == obj.getClass()) {
            zzzp zzzp = (zzzp) obj;
            if (!zzfn.zzP(this.zza, zzzp.zza) || !zzfn.zzP(this.zzb, zzzp.zzb) || !zzfn.zzP(this.zzc, zzzp.zzc) || !Arrays.equals(this.zzd, zzzp.zzd)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        String str = this.zza;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i11 + 527) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        String str3 = this.zzc;
        if (str3 != null) {
            i13 = str3.hashCode();
        }
        return ((i15 + i13) * 31) + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        String str4 = this.zzc;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb2 = new StringBuilder(length + 36 + length2 + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb2.append(str);
        sb2.append(": mimeType=");
        sb2.append(str2);
        sb2.append(", filename=");
        sb2.append(str3);
        sb2.append(", description=");
        sb2.append(str4);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzzp(String str, String str2, String str3, byte[] bArr) {
        super(GeobFrame.ID);
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }
}
