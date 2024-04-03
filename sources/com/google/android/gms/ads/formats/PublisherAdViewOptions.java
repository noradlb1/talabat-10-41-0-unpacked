package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhr;
import com.google.android.gms.internal.ads.zzbpy;
import com.google.android.gms.internal.ads.zzbpz;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
@Deprecated
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)
    private final boolean zza;
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzbhr zzb;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 3)
    @Nullable
    private final IBinder zzc;

    @Deprecated
    public static final class Builder {
        @Nullable
        private ShouldDelayBannerRenderingListener zza;

        @RecentlyNonNull
        @KeepForSdk
        public Builder setShouldDelayBannerRenderingListener(@RecentlyNonNull ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zza = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public PublisherAdViewOptions(@SafeParcelable.Param(id = 1) boolean z11, @SafeParcelable.Param(id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(id = 3) @Nullable IBinder iBinder2) {
        zzbhr zzbhr;
        this.zza = z11;
        if (iBinder != null) {
            zzbhr = zzbhq.zzd(iBinder);
        } else {
            zzbhr = null;
        }
        this.zzb = zzbhr;
        this.zzc = iBinder2;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i11) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        zzbhr zzbhr = this.zzb;
        if (zzbhr == null) {
            iBinder = null;
        } else {
            iBinder = zzbhr.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzbhr zza() {
        return this.zzb;
    }

    @Nullable
    public final zzbpz zzb() {
        IBinder iBinder = this.zzc;
        if (iBinder == null) {
            return null;
        }
        return zzbpy.zzc(iBinder);
    }

    public final boolean zzc() {
        return this.zza;
    }
}
