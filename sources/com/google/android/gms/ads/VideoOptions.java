package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.ads.zzbkq;

public final class VideoOptions {
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza = true;
        /* access modifiers changed from: private */
        public boolean zzb = false;
        /* access modifiers changed from: private */
        public boolean zzc = false;

        @RecentlyNonNull
        public VideoOptions build() {
            return new VideoOptions(this, (zzd) null);
        }

        @RecentlyNonNull
        public Builder setClickToExpandRequested(boolean z11) {
            this.zzc = z11;
            return this;
        }

        @RecentlyNonNull
        public Builder setCustomControlsRequested(boolean z11) {
            this.zzb = z11;
            return this;
        }

        @RecentlyNonNull
        public Builder setStartMuted(boolean z11) {
            this.zza = z11;
            return this;
        }
    }

    public /* synthetic */ VideoOptions(Builder builder, zzd zzd) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
    }

    public VideoOptions(zzbkq zzbkq) {
        this.zza = zzbkq.zza;
        this.zzb = zzbkq.zzb;
        this.zzc = zzbkq.zzc;
    }

    public boolean getClickToExpandRequested() {
        return this.zzc;
    }

    public boolean getCustomControlsRequested() {
        return this.zzb;
    }

    public boolean getStartMuted() {
        return this.zza;
    }
}
