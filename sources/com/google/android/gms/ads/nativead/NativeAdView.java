package com.google.android.gms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbju;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzbof;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzciz;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class NativeAdView extends FrameLayout {
    @NotOnlyInitialized
    private final FrameLayout zza;
    @NotOnlyInitialized
    @Nullable
    private final zzbom zzb = zze();

    public NativeAdView(@RecentlyNonNull Context context) {
        super(context);
        this.zza = zzd(context);
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    @RequiresNonNull({"overlayFrame"})
    @Nullable
    private final zzbom zze() {
        if (isInEditMode()) {
            return null;
        }
        return zzbgo.zza().zzg(this.zza.getContext(), this, this.zza);
    }

    private final void zzf(String str, @Nullable View view) {
        zzbom zzbom = this.zzb;
        if (zzbom != null) {
            try {
                zzbom.zzbE(str, ObjectWrapper.wrap(view));
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call setAssetView on delegate", e11);
            }
        }
    }

    public final void addView(@RecentlyNonNull View view, int i11, @RecentlyNonNull ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        super.bringChildToFront(this.zza);
    }

    public final void bringChildToFront(@RecentlyNonNull View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zza;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void destroy() {
        zzbom zzbom = this.zzb;
        if (zzbom != null) {
            try {
                zzbom.zzc();
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to destroy native ad view", e11);
            }
        }
    }

    public final boolean dispatchTouchEvent(@RecentlyNonNull MotionEvent motionEvent) {
        zzbom zzbom;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcf)).booleanValue() && (zzbom = this.zzb) != null) {
            try {
                zzbom.zzd(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call handleTouchEvent on delegate", e11);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @RecentlyNullable
    public AdChoicesView getAdChoicesView() {
        View zza2 = zza("3011");
        if (zza2 instanceof AdChoicesView) {
            return (AdChoicesView) zza2;
        }
        return null;
    }

    @RecentlyNullable
    public final View getAdvertiserView() {
        return zza("3005");
    }

    @RecentlyNullable
    public final View getBodyView() {
        return zza("3004");
    }

    @RecentlyNullable
    public final View getCallToActionView() {
        return zza("3002");
    }

    @RecentlyNullable
    public final View getHeadlineView() {
        return zza("3001");
    }

    @RecentlyNullable
    public final View getIconView() {
        return zza("3003");
    }

    @RecentlyNullable
    public final View getImageView() {
        return zza("3008");
    }

    @RecentlyNullable
    public final MediaView getMediaView() {
        View zza2 = zza("3010");
        if (zza2 instanceof MediaView) {
            return (MediaView) zza2;
        }
        if (zza2 == null) {
            return null;
        }
        zzciz.zze("View is not an instance of MediaView");
        return null;
    }

    @RecentlyNullable
    public final View getPriceView() {
        return zza("3007");
    }

    @RecentlyNullable
    public final View getStarRatingView() {
        return zza("3009");
    }

    @RecentlyNullable
    public final View getStoreView() {
        return zza("3006");
    }

    public final void onVisibilityChanged(@RecentlyNonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        zzbom zzbom = this.zzb;
        if (zzbom != null) {
            try {
                zzbom.zze(ObjectWrapper.wrap(view), i11);
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call onVisibilityChanged on delegate", e11);
            }
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zza);
    }

    public final void removeView(@RecentlyNonNull View view) {
        if (this.zza != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(@Nullable AdChoicesView adChoicesView) {
        zzf("3011", adChoicesView);
    }

    public final void setAdvertiserView(@Nullable View view) {
        zzf("3005", view);
    }

    public final void setBodyView(@Nullable View view) {
        zzf("3004", view);
    }

    public final void setCallToActionView(@Nullable View view) {
        zzf("3002", view);
    }

    public final void setClickConfirmingView(@Nullable View view) {
        zzbom zzbom = this.zzb;
        if (zzbom != null) {
            try {
                zzbom.zzbF(ObjectWrapper.wrap(view));
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call setClickConfirmingView on delegate", e11);
            }
        }
    }

    public final void setHeadlineView(@Nullable View view) {
        zzf("3001", view);
    }

    public final void setIconView(@Nullable View view) {
        zzf("3003", view);
    }

    public final void setImageView(@Nullable View view) {
        zzf("3008", view);
    }

    public final void setMediaView(@Nullable MediaView mediaView) {
        zzf("3010", mediaView);
        if (mediaView != null) {
            mediaView.zza(new zzb(this));
            mediaView.zzb(new zzc(this));
        }
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(@RecentlyNonNull NativeAd nativeAd) {
        zzbom zzbom = this.zzb;
        if (zzbom != null) {
            try {
                zzbom.zzbI(nativeAd.zza());
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call setNativeAd on delegate", e11);
            }
        }
    }

    public final void setPriceView(@Nullable View view) {
        zzf("3007", view);
    }

    public final void setStarRatingView(@Nullable View view) {
        zzf("3009", view);
    }

    public final void setStoreView(@Nullable View view) {
        zzf("3006", view);
    }

    @RecentlyNullable
    public final View zza(@RecentlyNonNull String str) {
        zzbom zzbom = this.zzb;
        if (zzbom != null) {
            try {
                IObjectWrapper zzb2 = zzbom.zzb(str);
                if (zzb2 != null) {
                    return (View) ObjectWrapper.unwrap(zzb2);
                }
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call getAssetView on delegate", e11);
            }
        }
        return null;
    }

    public final /* synthetic */ void zzb(MediaContent mediaContent) {
        zzbom zzbom = this.zzb;
        if (zzbom != null) {
            try {
                if (mediaContent instanceof zzbju) {
                    zzbom.zzbG(((zzbju) mediaContent).zza());
                } else if (mediaContent == null) {
                    zzbom.zzbG((zzbof) null);
                } else {
                    zzciz.zze("Use MediaContent provided by NativeAd.getMediaContent");
                }
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call setMediaContent on delegate", e11);
            }
        }
    }

    public final /* synthetic */ void zzc(ImageView.ScaleType scaleType) {
        zzbom zzbom = this.zzb;
        if (zzbom != null && scaleType != null) {
            try {
                zzbom.zzbH(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call setMediaViewImageScaleType on delegate", e11);
            }
        }
    }

    public NativeAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = zzd(context);
    }

    public NativeAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.zza = zzd(context);
    }

    @TargetApi(21)
    public NativeAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.zza = zzd(context);
    }
}
