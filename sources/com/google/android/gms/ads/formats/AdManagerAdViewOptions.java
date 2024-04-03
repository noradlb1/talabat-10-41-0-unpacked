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
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbpy;
import com.google.android.gms.internal.ads.zzbpz;

@SafeParcelable.Class(creator = "AdManagerAdViewOptionsCreator")
public final class AdManagerAdViewOptions extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<AdManagerAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)
    private final boolean zza;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 2)
    @Nullable
    private final IBinder zzb;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza = false;
        /* access modifiers changed from: private */
        @Nullable
        public ShouldDelayBannerRenderingListener zzb;

        @RecentlyNonNull
        public AdManagerAdViewOptions build() {
            return new AdManagerAdViewOptions(this, (zzb) null);
        }

        @RecentlyNonNull
        public Builder setManualImpressionsEnabled(boolean z11) {
            this.zza = z11;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setShouldDelayBannerRenderingListener(@RecentlyNonNull ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzb = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    public /* synthetic */ AdManagerAdViewOptions(Builder builder, zzb zzb2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb != null ? new zzbko(builder.zzb) : null;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zza;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzbpz zza() {
        IBinder iBinder = this.zzb;
        if (iBinder == null) {
            return null;
        }
        return zzbpy.zzc(iBinder);
    }

    @SafeParcelable.Constructor
    public AdManagerAdViewOptions(@SafeParcelable.Param(id = 1) boolean z11, @SafeParcelable.Param(id = 2) @Nullable IBinder iBinder) {
        this.zza = z11;
        this.zzb = iBinder;
    }
}
