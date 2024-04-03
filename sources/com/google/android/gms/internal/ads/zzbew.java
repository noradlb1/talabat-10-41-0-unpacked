package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdErrorParcelCreator")
public final class zzbew extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbew> CREATOR = new zzbex();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    public final String zzc;
    @SafeParcelable.Field(id = 4)
    @Nullable
    public zzbew zzd;
    @SafeParcelable.Field(id = 5, type = "android.os.IBinder")
    @Nullable
    public IBinder zze;

    @SafeParcelable.Constructor
    public zzbew(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) @Nullable zzbew zzbew, @SafeParcelable.Param(id = 5) @Nullable IBinder iBinder) {
        this.zza = i11;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzbew;
        this.zze = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i11, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdError zza() {
        zzbew zzbew = this.zzd;
        return new AdError(this.zza, this.zzb, this.zzc, zzbew == null ? null : new AdError(zzbew.zza, zzbew.zzb, zzbew.zzc));
    }

    public final LoadAdError zzb() {
        AdError adError;
        zzbew zzbew = this.zzd;
        zzbiw zzbiw = null;
        if (zzbew == null) {
            adError = null;
        } else {
            adError = new AdError(zzbew.zza, zzbew.zzb, zzbew.zzc);
        }
        int i11 = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        IBinder iBinder = this.zze;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzbiw) {
                zzbiw = (zzbiw) queryLocalInterface;
            } else {
                zzbiw = new zzbiu(iBinder);
            }
        }
        return new LoadAdError(i11, str, str2, adError, ResponseInfo.zza(zzbiw));
    }
}
