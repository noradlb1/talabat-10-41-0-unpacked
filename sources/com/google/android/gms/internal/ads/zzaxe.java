package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzaxe implements Parcelable {
    public static final Parcelable.Creator<zzaxe> CREATOR = new zzaxd();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final byte[] zzd;
    private int zze;

    public zzaxe(int i11, int i12, int i13, byte[] bArr) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = bArr;
    }

    public zzaxe(Parcel parcel) {
        byte[] bArr;
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        if (parcel.readInt() != 0) {
            bArr = parcel.createByteArray();
        } else {
            bArr = null;
        }
        this.zzd = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaxe.class == obj.getClass()) {
            zzaxe zzaxe = (zzaxe) obj;
            if (this.zza == zzaxe.zza && this.zzb == zzaxe.zzb && this.zzc == zzaxe.zzc && Arrays.equals(this.zzd, zzaxe.zzd)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zze;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = ((((((this.zza + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + Arrays.hashCode(this.zzd);
        this.zze = hashCode;
        return hashCode;
    }

    public final String toString() {
        int i11 = this.zza;
        int i12 = this.zzb;
        int i13 = this.zzc;
        boolean z11 = this.zzd != null;
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("ColorInfo(");
        sb2.append(i11);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i12);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i13);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(z11);
        sb2.append(")");
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int i12;
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        if (this.zzd != null) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        parcel.writeInt(i12);
        byte[] bArr = this.zzd;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
