package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzbji;
import com.google.android.gms.internal.ads.zzciz;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class SearchAdView extends ViewGroup {
    @NotOnlyInitialized
    private final zzbji zza;

    public SearchAdView(@RecentlyNonNull Context context) {
        super(context);
        this.zza = new zzbji(this);
    }

    public void destroy() {
        this.zza.zzk();
    }

    @RecentlyNonNull
    public AdListener getAdListener() {
        return this.zza.zza();
    }

    @RecentlyNullable
    public AdSize getAdSize() {
        return this.zza.zzb();
    }

    @RecentlyNonNull
    public String getAdUnitId() {
        return this.zza.zzj();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@RecentlyNonNull DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.zza.zzl(dynamicHeightSearchAdRequest.zza());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i15 = ((i13 - i11) - measuredWidth) / 2;
            int i16 = ((i14 - i12) - measuredHeight) / 2;
            childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        AdSize adSize;
        int i14 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e11) {
                zzciz.zzh("Unable to retrieve ad size.", e11);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i13 = adSize.getHeightInPixels(context);
                i14 = widthInPixels;
            } else {
                i13 = 0;
            }
        } else {
            measureChild(childAt, i11, i12);
            i14 = childAt.getMeasuredWidth();
            i13 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i14, getSuggestedMinimumWidth()), i11), View.resolveSize(Math.max(i13, getSuggestedMinimumHeight()), i12));
    }

    public void pause() {
        this.zza.zzm();
    }

    public void resume() {
        this.zza.zzo();
    }

    public void setAdListener(@RecentlyNonNull AdListener adListener) {
        this.zza.zzq(adListener);
    }

    public void setAdSize(@RecentlyNonNull AdSize adSize) {
        this.zza.zzr(adSize);
    }

    public void setAdUnitId(@RecentlyNonNull String str) {
        this.zza.zzt(str);
    }

    public SearchAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = new zzbji(this, attributeSet, false);
    }

    public SearchAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.zza = new zzbji(this, attributeSet, false);
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@RecentlyNonNull SearchAdRequest searchAdRequest) {
        this.zza.zzl(searchAdRequest.zza());
    }
}
