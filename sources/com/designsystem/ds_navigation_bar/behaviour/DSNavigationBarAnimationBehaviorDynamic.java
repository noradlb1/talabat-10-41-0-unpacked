package com.designsystem.ds_navigation_bar.behaviour;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import e6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/designsystem/ds_navigation_bar/behaviour/DSNavigationBarAnimationBehaviorDynamic;", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "threshold", "", "scrollContainer", "Landroid/view/ViewGroup;", "(FLandroid/view/ViewGroup;)V", "_backgroundOpacity", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "_elevationOpacity", "_opacity", "backgroundOpacity", "Landroidx/lifecycle/LiveData;", "getBackgroundOpacity", "()Landroidx/lifecycle/LiveData;", "elevationOpacity", "getElevationOpacity", "opacity", "getOpacity", "calculateNavigationBarTitleOpacity", "scrollY", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarAnimationBehaviorDynamic extends DSNavigationBarAnimationBehaviour {
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
    private final LiveData<Float> opacity;
    private final float threshold;

    public DSNavigationBarAnimationBehaviorDynamic(float f11, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "scrollContainer");
        this.threshold = f11;
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
        viewGroup.setOnScrollChangeListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m8504_init_$lambda1(DSNavigationBarAnimationBehaviorDynamic dSNavigationBarAnimationBehaviorDynamic, View view, int i11, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(dSNavigationBarAnimationBehaviorDynamic, "this$0");
        float calculateNavigationBarTitleOpacity = dSNavigationBarAnimationBehaviorDynamic.calculateNavigationBarTitleOpacity(i12);
        dSNavigationBarAnimationBehaviorDynamic._opacity.setValue(Float.valueOf(calculateNavigationBarTitleOpacity));
        dSNavigationBarAnimationBehaviorDynamic._backgroundOpacity.setValue(Float.valueOf(calculateNavigationBarTitleOpacity));
        dSNavigationBarAnimationBehaviorDynamic._elevationOpacity.setValue(Float.valueOf(calculateNavigationBarTitleOpacity));
    }

    private final float calculateNavigationBarTitleOpacity(int i11) {
        float f11 = this.threshold;
        float f12 = ((float) 1) - ((f11 - ((float) i11)) / f11);
        if (f12 > 1.0f) {
            f12 = 1.0f;
        }
        if (f12 < 0.0f) {
            return 0.0f;
        }
        return f12;
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
