package com.google.android.gms.ads.nativead;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.VideoOptions;

public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    private final boolean zza;
    private final int zzb;
    private final boolean zzc;
    private final int zzd;
    private final VideoOptions zze;
    private final boolean zzf;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza = false;
        /* access modifiers changed from: private */
        public int zzb = 0;
        /* access modifiers changed from: private */
        public boolean zzc = false;
        /* access modifiers changed from: private */
        public VideoOptions zzd;
        /* access modifiers changed from: private */
        public int zze = 1;
        /* access modifiers changed from: private */
        public boolean zzf = false;

        @RecentlyNonNull
        public NativeAdOptions build() {
            return new NativeAdOptions(this, (zza) null);
        }

        @RecentlyNonNull
        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i11) {
            this.zze = i11;
            return this;
        }

        @RecentlyNonNull
        public Builder setMediaAspectRatio(@NativeMediaAspectRatio int i11) {
            this.zzb = i11;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestCustomMuteThisAd(boolean z11) {
            this.zzf = z11;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestMultipleImages(boolean z11) {
            this.zzc = z11;
            return this;
        }

        @RecentlyNonNull
        public Builder setReturnUrlsForImageAssets(boolean z11) {
            this.zza = z11;
            return this;
        }

        @RecentlyNonNull
        public Builder setVideoOptions(@RecentlyNonNull VideoOptions videoOptions) {
            this.zzd = videoOptions;
            return this;
        }
    }

    public @interface NativeMediaAspectRatio {
    }

    public /* synthetic */ NativeAdOptions(Builder builder, zza zza2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zze;
        this.zze = builder.zzd;
        this.zzf = builder.zzf;
    }

    public int getAdChoicesPlacement() {
        return this.zzd;
    }

    public int getMediaAspectRatio() {
        return this.zzb;
    }

    @RecentlyNullable
    public VideoOptions getVideoOptions() {
        return this.zze;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzc;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zzf;
    }
}
