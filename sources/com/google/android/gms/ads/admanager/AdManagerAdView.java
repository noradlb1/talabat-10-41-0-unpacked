package com.google.android.gms.ads.admanager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbhk;

public final class AdManagerAdView extends BaseAdView {
    public AdManagerAdView(@RecentlyNonNull Context context) {
        super(context, 0);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    @RecentlyNullable
    public AdSize[] getAdSizes() {
        return this.zza.zzA();
    }

    @RecentlyNullable
    public AppEventListener getAppEventListener() {
        return this.zza.zzh();
    }

    @RecentlyNonNull
    public VideoController getVideoController() {
        return this.zza.zzf();
    }

    @RecentlyNullable
    public VideoOptions getVideoOptions() {
        return this.zza.zzg();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@RecentlyNonNull AdManagerAdRequest adManagerAdRequest) {
        this.zza.zzl(adManagerAdRequest.zza());
    }

    public void recordManualImpression() {
        this.zza.zzn();
    }

    public void setAdSizes(@RecentlyNonNull AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zza.zzs(adSizeArr);
    }

    public void setAppEventListener(@Nullable AppEventListener appEventListener) {
        this.zza.zzu(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z11) {
        this.zza.zzv(z11);
    }

    public void setVideoOptions(@RecentlyNonNull VideoOptions videoOptions) {
        this.zza.zzx(videoOptions);
    }

    public final boolean zza(zzbhk zzbhk) {
        return this.zza.zzy(zzbhk);
    }

    public AdManagerAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public AdManagerAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11, 0, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }
}
