package com.designsystem.ds_navigation_bar.behaviour;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.designsystem.ds_navigation_bar.NavigationBar;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.extensions.IntExtensionsKt;
import e6.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/designsystem/ds_navigation_bar/behaviour/DSNavigationBarAnimationBehaviorImageRatio;", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "imageView", "Landroid/widget/ImageView;", "scrollContainer", "Landroid/view/ViewGroup;", "(Landroid/widget/ImageView;Landroid/view/ViewGroup;)V", "_backgroundOpacity", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_elevationOpacity", "_opacity", "backgroundOpacity", "Landroidx/lifecycle/LiveData;", "getBackgroundOpacity", "()Landroidx/lifecycle/LiveData;", "elevationOpacity", "getElevationOpacity", "opacity", "getOpacity", "calculateNavigationBarTitleOpacity", "scrollY", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarAnimationBehaviorImageRatio extends DSNavigationBarAnimationBehaviour {
    public static final int $stable = 8;
    @NotNull
    private final MutableLiveData<Float> _backgroundOpacity;
    @NotNull
    private final MutableLiveData<Float> _elevationOpacity;
    @NotNull
    private final MutableLiveData<Float> _opacity;
    @NotNull
    private final LiveData<Float> backgroundOpacity;
    @NotNull
    private final LiveData<Float> elevationOpacity;
    @NotNull
    private final ImageView imageView;
    @NotNull
    private final LiveData<Float> opacity;

    public DSNavigationBarAnimationBehaviorImageRatio(@NotNull ImageView imageView2, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(imageView2, "imageView");
        Intrinsics.checkNotNullParameter(viewGroup, "scrollContainer");
        this.imageView = imageView2;
        Float valueOf = Float.valueOf(0.0f);
        MutableLiveData<Float> mutableLiveData = new MutableLiveData<>(valueOf);
        this._opacity = mutableLiveData;
        this.opacity = mutableLiveData;
        MutableLiveData<Float> mutableLiveData2 = new MutableLiveData<>(valueOf);
        this._backgroundOpacity = mutableLiveData2;
        this.backgroundOpacity = mutableLiveData2;
        MutableLiveData<Float> mutableLiveData3 = new MutableLiveData<>(valueOf);
        this._elevationOpacity = mutableLiveData3;
        this.elevationOpacity = mutableLiveData3;
        viewGroup.setOnScrollChangeListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m8508_init_$lambda1(DSNavigationBarAnimationBehaviorImageRatio dSNavigationBarAnimationBehaviorImageRatio, View view, int i11, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(dSNavigationBarAnimationBehaviorImageRatio, "this$0");
        float calculateNavigationBarTitleOpacity = dSNavigationBarAnimationBehaviorImageRatio.calculateNavigationBarTitleOpacity(i12);
        dSNavigationBarAnimationBehaviorImageRatio._opacity.setValue(Float.valueOf(calculateNavigationBarTitleOpacity));
        dSNavigationBarAnimationBehaviorImageRatio._backgroundOpacity.setValue(Float.valueOf(calculateNavigationBarTitleOpacity));
        dSNavigationBarAnimationBehaviorImageRatio._elevationOpacity.setValue(Float.valueOf(calculateNavigationBarTitleOpacity));
    }

    private final float calculateNavigationBarTitleOpacity(int i11) {
        boolean z11;
        float f11;
        int toPx = IntExtensionsKt.getToPx((int) NavigationBar.INSTANCE.m8500getNavigationBarHeightD9Ej5fM());
        int height = this.imageView.getHeight() - toPx;
        if (i11 > height) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f11 = (((float) i11) - ((float) height)) / ((float) toPx);
        } else {
            f11 = 0.0f;
        }
        if (f11 > 1.0f) {
            return 1.0f;
        }
        return f11;
    }

    @NotNull
    public LiveData<Float> getBackgroundOpacity() {
        return this.backgroundOpacity;
    }

    @NotNull
    public LiveData<Float> getElevationOpacity() {
        return this.elevationOpacity;
    }

    @NotNull
    public LiveData<Float> getOpacity() {
        return this.opacity;
    }
}
