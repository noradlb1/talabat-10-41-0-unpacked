package com.google.android.gms.ads.admanager;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbjg;
import java.util.List;

@VisibleForTesting
public final class AdManagerAdRequest extends AdRequest {

    @VisibleForTesting
    public static final class Builder extends AdRequest.Builder {
        @RecentlyNonNull
        public Builder addCategoryExclusion(@RecentlyNonNull String str) {
            this.zza.zzr(str);
            return this;
        }

        @RecentlyNonNull
        public Builder addCustomTargeting(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
            this.zza.zzt(str, str2);
            return this;
        }

        @RecentlyNonNull
        public Builder setPublisherProvidedId(@RecentlyNonNull String str) {
            this.zza.zzI(str);
            return this;
        }

        @RecentlyNonNull
        public Builder addCustomTargeting(@RecentlyNonNull String str, @RecentlyNonNull List<String> list) {
            if (list != null) {
                this.zza.zzt(str, TextUtils.join(",", list));
            }
            return this;
        }

        @RecentlyNonNull
        public AdManagerAdRequest build() {
            return new AdManagerAdRequest(this, (zza) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        @Deprecated
        public Builder setAdInfo(@RecentlyNonNull AdInfo adInfo) {
            this.zza.zzz(adInfo);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAdString(@RecentlyNonNull String str) {
            this.zza.zzA(str);
            return this;
        }
    }

    public /* synthetic */ AdManagerAdRequest(Builder builder, zza zza) {
        super(builder);
    }

    @RecentlyNonNull
    public Bundle getCustomTargeting() {
        return this.zza.zzf();
    }

    @RecentlyNonNull
    public String getPublisherProvidedId() {
        return this.zza.zzn();
    }

    public final zzbjg zza() {
        return this.zza;
    }
}
