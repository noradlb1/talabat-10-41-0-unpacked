package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzccm;
import com.google.android.gms.internal.ads.zzccn;
import java.util.List;
import java.util.Map;

@KeepForSdk
public final class ReportingInfo {
    private final zzccn zza;

    @KeepForSdk
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzccm zza;

        @KeepForSdk
        public Builder(@RecentlyNonNull View view) {
            zzccm zzccm = new zzccm();
            this.zza = zzccm;
            zzccm.zzb(view);
        }

        @RecentlyNonNull
        @KeepForSdk
        public ReportingInfo build() {
            return new ReportingInfo(this, (zza) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAssetViews(@RecentlyNonNull Map<String, View> map) {
            this.zza.zzc(map);
            return this;
        }
    }

    public /* synthetic */ ReportingInfo(Builder builder, zza zza2) {
        this.zza = new zzccn(builder.zza);
    }

    @KeepForSdk
    public void reportTouchEvent(@RecentlyNonNull MotionEvent motionEvent) {
        this.zza.zza(motionEvent);
    }

    @KeepForSdk
    public void updateClickUrl(@RecentlyNonNull Uri uri, @RecentlyNonNull UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza.zzb(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public void updateImpressionUrls(@RecentlyNonNull List<Uri> list, @RecentlyNonNull UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza.zzc(list, updateImpressionUrlsCallback);
    }
}
