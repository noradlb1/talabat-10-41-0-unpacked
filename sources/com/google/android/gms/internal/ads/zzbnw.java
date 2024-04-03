package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
public final class zzbnw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbnw> CREATOR = new zzbnx();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final boolean zzb;
    @SafeParcelable.Field(id = 3)
    public final int zzc;
    @SafeParcelable.Field(id = 4)
    public final boolean zzd;
    @SafeParcelable.Field(id = 5)
    public final int zze;
    @SafeParcelable.Field(id = 6)
    @Nullable
    public final zzbkq zzf;
    @SafeParcelable.Field(id = 7)
    public final boolean zzg;
    @SafeParcelable.Field(id = 8)
    public final int zzh;

    @SafeParcelable.Constructor
    public zzbnw(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) boolean z11, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) boolean z12, @SafeParcelable.Param(id = 5) int i13, @SafeParcelable.Param(id = 6) zzbkq zzbkq, @SafeParcelable.Param(id = 7) boolean z13, @SafeParcelable.Param(id = 8) int i14) {
        this.zza = i11;
        this.zzb = z11;
        this.zzc = i12;
        this.zzd = z12;
        this.zze = i13;
        this.zzf = zzbkq;
        this.zzg = z13;
        this.zzh = i14;
    }

    @NonNull
    public static NativeAdOptions zza(@Nullable zzbnw zzbnw) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzbnw == null) {
            return builder.build();
        }
        int i11 = zzbnw.zza;
        if (i11 != 2) {
            if (i11 != 3) {
                if (i11 == 4) {
                    builder.setRequestCustomMuteThisAd(zzbnw.zzg);
                    builder.setMediaAspectRatio(zzbnw.zzh);
                }
                builder.setReturnUrlsForImageAssets(zzbnw.zzb);
                builder.setRequestMultipleImages(zzbnw.zzd);
                return builder.build();
            }
            zzbkq zzbkq = zzbnw.zzf;
            if (zzbkq != null) {
                builder.setVideoOptions(new VideoOptions(zzbkq));
            }
        }
        builder.setAdChoicesPlacement(zzbnw.zze);
        builder.setReturnUrlsForImageAssets(zzbnw.zzb);
        builder.setRequestMultipleImages(zzbnw.zzd);
        return builder.build();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i11, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzbnw(com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzbkq(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio());
    }
}
