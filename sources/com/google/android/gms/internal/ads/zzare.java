package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.UUID;

public final class zzare implements Parcelable {
    public static final Parcelable.Creator<zzare> CREATOR = new zzard();
    public final String zza;
    public final byte[] zzb;
    public final boolean zzc;
    private int zzd;
    /* access modifiers changed from: private */
    public final UUID zze;

    public zzare(Parcel parcel) {
        this.zze = new UUID(parcel.readLong(), parcel.readLong());
        this.zza = parcel.readString();
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readByte() != 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzare)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzare zzare = (zzare) obj;
        if (!this.zza.equals(zzare.zza) || !zzaxb.zzo(this.zze, zzare.zze) || !Arrays.equals(this.zzb, zzare.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i11 = this.zzd;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = (((this.zze.hashCode() * 31) + this.zza.hashCode()) * 31) + Arrays.hashCode(this.zzb);
        this.zzd = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.zze.getMostSignificantBits());
        parcel.writeLong(this.zze.getLeastSignificantBits());
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeByte(this.zzc ? (byte) 1 : 0);
    }

    public zzare(UUID uuid, String str, byte[] bArr, boolean z11) {
        uuid.getClass();
        this.zze = uuid;
        this.zza = str;
        bArr.getClass();
        this.zzb = bArr;
        this.zzc = false;
    }
}
