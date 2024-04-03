package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "DocumentSectionCreator")
@SafeParcelable.Reserved({1000})
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    public static final int zza = Integer.parseInt("-1");
    private static final zzs zzf;
    @SafeParcelable.Field(id = 1)
    @Nullable
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    final zzs zzc;
    @SafeParcelable.Field(defaultValue = "-1", id = 4)
    public final int zzd;
    @SafeParcelable.Field(id = 5)
    @Nullable
    public final byte[] zze;

    static {
        zzr zzr = new zzr("SsbContext");
        zzr.zzb(true);
        zzr.zza("blob");
        zzf = zzr.zze();
    }

    @SafeParcelable.Constructor
    public zzk(@SafeParcelable.Param(id = 1) @Nullable String str, @SafeParcelable.Param(id = 3) zzs zzs, @SafeParcelable.Param(id = 4) int i11, @SafeParcelable.Param(id = 5) @Nullable byte[] bArr) {
        String str2;
        int i12 = zza;
        boolean z11 = true;
        if (i11 != i12 && zzq.zza(i11) == null) {
            z11 = false;
        }
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid section type ");
        sb2.append(i11);
        Preconditions.checkArgument(z11, sb2.toString());
        this.zzb = str;
        this.zzc = zzs;
        this.zzd = i11;
        this.zze = bArr;
        if (i11 == i12 || zzq.zza(i11) != null) {
            str2 = (str == null || bArr == null) ? null : "Both content and blobContent set";
        } else {
            StringBuilder sb3 = new StringBuilder(32);
            sb3.append("Invalid section type ");
            sb3.append(i11);
            str2 = sb3.toString();
        }
        if (str2 != null) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static zzk zza(byte[] bArr) {
        return new zzk((String) null, zzf, zza, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i11, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzk(byte[] bArr, zzs zzs) {
        this((String) null, zzs, zza, bArr);
    }
}
