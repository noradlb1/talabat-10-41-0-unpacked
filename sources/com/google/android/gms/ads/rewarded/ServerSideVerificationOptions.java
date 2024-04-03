package com.google.android.gms.ads.rewarded;

import androidx.annotation.RecentlyNonNull;

public class ServerSideVerificationOptions {
    private final String zza;
    private final String zzb;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String zza = "";
        /* access modifiers changed from: private */
        public String zzb = "";

        @RecentlyNonNull
        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (zzb) null);
        }

        @RecentlyNonNull
        public Builder setCustomData(@RecentlyNonNull String str) {
            this.zzb = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setUserId(@RecentlyNonNull String str) {
            this.zza = str;
            return this;
        }
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, zzb zzb2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
    }

    @RecentlyNonNull
    public String getCustomData() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String getUserId() {
        return this.zza;
    }
}
