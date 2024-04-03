package com.google.android.gms.ads.formats;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.VideoOptions;

@Deprecated
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
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final int zze;
    private final VideoOptions zzf;
    private final boolean zzg;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza = false;
        /* access modifiers changed from: private */
        public int zzb = -1;
        /* access modifiers changed from: private */
        public int zzc = 0;
        /* access modifiers changed from: private */
        public boolean zzd = false;
        /* access modifiers changed from: private */
        public VideoOptions zze;
        /* access modifiers changed from: private */
        public int zzf = 1;
        /* access modifiers changed from: private */
        public boolean zzg = false;

        @RecentlyNonNull
        public NativeAdOptions build() {
            return new NativeAdOptions(this, (zzd) null);
        }

        @RecentlyNonNull
        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i11) {
            this.zzf = i11;
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public Builder setImageOrientation(int i11) {
            this.zzb = i11;
            return this;
        }

        @RecentlyNonNull
        public Builder setMediaAspectRatio(@NativeMediaAspectRatio int i11) {
            this.zzc = i11;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestCustomMuteThisAd(boolean z11) {
            this.zzg = z11;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestMultipleImages(boolean z11) {
            this.zzd = z11;
            return this;
        }

        @RecentlyNonNull
        public Builder setReturnUrlsForImageAssets(boolean z11) {
            this.zza = z11;
            return this;
        }

        @RecentlyNonNull
        public Builder setVideoOptions(@RecentlyNonNull VideoOptions videoOptions) {
            this.zze = videoOptions;
            return this;
        }
    }

    public @interface NativeMediaAspectRatio {
    }

    public /* synthetic */ NativeAdOptions(Builder builder, zzd zzd2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
        this.zze = builder.zzf;
        this.zzf = builder.zze;
        this.zzg = builder.zzg;
    }

    public int getAdChoicesPlacement() {
        return this.zze;
    }

    @Deprecated
    public int getImageOrientation() {
        return this.zzb;
    }

    public int getMediaAspectRatio() {
        return this.zzc;
    }

    @RecentlyNullable
    public VideoOptions getVideoOptions() {
        return this.zzf;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzd;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zzg;
    }
}
