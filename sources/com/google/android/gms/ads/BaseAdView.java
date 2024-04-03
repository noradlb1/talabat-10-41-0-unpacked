package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbji;
import com.google.android.gms.internal.ads.zzciz;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public abstract class BaseAdView extends ViewGroup {
    @NotOnlyInitialized
    protected final zzbji zza;

    public BaseAdView(@RecentlyNonNull Context context, int i11) {
        super(context);
        this.zza = new zzbji(this, i11);
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

    @RecentlyNullable
    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzc();
    }

    @RecentlyNullable
    public ResponseInfo getResponseInfo() {
        return this.zza.zzd();
    }

    public boolean isLoading() {
        return this.zza.zzz();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@RecentlyNonNull AdRequest adRequest) {
        this.zza.zzl(adRequest.zza());
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
        if (adListener == null) {
            this.zza.zzp((zzbes) null);
            return;
        }
        if (adListener instanceof zzbes) {
            this.zza.zzp((zzbes) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zza.zzu((AppEventListener) adListener);
        }
    }

    public void setAdSize(@RecentlyNonNull AdSize adSize) {
        this.zza.zzr(adSize);
    }

    public void setAdUnitId(@RecentlyNonNull String str) {
        this.zza.zzt(str);
    }

    public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zza.zzw(onPaidEventListener);
    }

    public BaseAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet);
        this.zza = new zzbji(this, attributeSet, false, i11);
    }

    public BaseAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        this.zza = new zzbji(this, attributeSet, false, i12);
    }

    public BaseAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11, int i12, boolean z11) {
        super(context, attributeSet, i11);
        this.zza = new zzbji(this, attributeSet, z11, i12);
    }

    public BaseAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, boolean z11) {
        super(context, attributeSet);
        this.zza = new zzbji(this, attributeSet, z11);
    }
}
