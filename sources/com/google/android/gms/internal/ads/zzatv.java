package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;

public final class zzatv extends zzatx {
    public static final Parcelable.Creator<zzatv> CREATOR = new zzatu();
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzatv(Parcel parcel) {
        super(CommentFrame.ID);
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzatv.class == obj.getClass()) {
            zzatv zzatv = (zzatv) obj;
            if (!zzaxb.zzo(this.zzb, zzatv.zzb) || !zzaxb.zzo(this.zza, zzatv.zza) || !zzaxb.zzo(this.zzc, zzatv.zzc)) {
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
        return i15 + i13;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zze);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zzatv(String str, String str2, String str3) {
        super(CommentFrame.ID);
        this.zza = C.LANGUAGE_UNDETERMINED;
        this.zzb = str2;
        this.zzc = str3;
    }
}
