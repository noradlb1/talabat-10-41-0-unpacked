package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzfey;
import com.google.android.gms.internal.ads.zzfqr;

@SafeParcelable.Class(creator = "ExceptionParcelCreator")
public final class zzbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();
    @SafeParcelable.Field(id = 1)
    public final String zza;
    @SafeParcelable.Field(id = 2)
    public final int zzb;

    @SafeParcelable.Constructor
    public zzbd(@SafeParcelable.Param(id = 1) @Nullable String str, @SafeParcelable.Param(id = 2) int i11) {
        this.zza = str == null ? "" : str;
        this.zzb = i11;
    }

    @Nullable
    public static zzbd zza(Throwable th2) {
        String str;
        zzbew zza2 = zzfey.zza(th2);
        if (zzfqr.zzd(th2.getMessage())) {
            str = zza2.zzb;
        } else {
            str = th2.getMessage();
        }
        return new zzbd(str, zza2.zza);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
