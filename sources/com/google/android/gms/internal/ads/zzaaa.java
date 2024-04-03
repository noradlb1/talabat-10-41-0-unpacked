package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import java.util.Arrays;

public final class zzaaa extends zzzu {
    public static final Parcelable.Creator<zzaaa> CREATOR = new zzzz();
    public final String zza;
    public final byte[] zzb;

    public zzaaa(Parcel parcel) {
        super(PrivFrame.ID);
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zza = readString;
        this.zzb = (byte[]) zzfn.zzC(parcel.createByteArray());
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaaa.class == obj.getClass()) {
            zzaaa zzaaa = (zzaaa) obj;
            if (!zzfn.zzP(this.zza, zzaaa.zza) || !Arrays.equals(this.zzb, zzaaa.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        String str = this.zza;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        return ((i11 + 527) * 31) + Arrays.hashCode(this.zzb);
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(": owner=");
        sb2.append(str2);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
    }

    public zzaaa(String str, byte[] bArr) {
        super(PrivFrame.ID);
        this.zza = str;
        this.zzb = bArr;
    }
}
