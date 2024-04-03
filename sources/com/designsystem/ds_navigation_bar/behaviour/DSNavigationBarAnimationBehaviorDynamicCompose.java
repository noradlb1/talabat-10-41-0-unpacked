package com.designsystem.ds_navigation_bar.behaviour;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Lcom/designsystem/ds_navigation_bar/behaviour/DSNavigationBarAnimationBehaviorDynamicCompose;", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "threshold", "", "(F)V", "_backgroundOpacity", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "_elevationOpacity", "_opacity", "backgroundOpacity", "Landroidx/lifecycle/LiveData;", "getBackgroundOpacity", "()Landroidx/lifecycle/LiveData;", "elevationOpacity", "getElevationOpacity", "opacity", "getOpacity", "scrolled", "calculateNavigationBarElevationOpacity", "scrollY", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarAnimationBehaviorDynamicCompose extends DSNavigationBarAnimationBehaviour {
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
    private float scrolled;
    private final float threshold;

    public DSNavigationBarAnimationBehaviorDynamicCompose(float f11) {
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
    }

    private final float calculateNavigationBarElevationOpacity(float f11) {
        float f12 = this.scrolled + f11;
        this.scrolled = f12;
        float f13 = this.threshold;
        float f14 = ((float) 1) - ((f13 - (f12 * ((float) -1))) / f13);
        if (f14 > 1.0f) {
            f14 = 1.0f;
        }
        if (f14 < 0.0f) {
            return 0.0f;
        }
        return f14;
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

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m8505onPostScrollDzOQY0M(long j11, long j12, int i11) {
        float calculateNavigationBarElevationOpacity = calculateNavigationBarElevationOpacity(Offset.m2677getYimpl(j11));
        this._opacity.setValue(Float.valueOf(calculateNavigationBarElevationOpacity));
        this._backgroundOpacity.setValue(Float.valueOf(calculateNavigationBarElevationOpacity));
        this._elevationOpacity.setValue(Float.valueOf(calculateNavigationBarElevationOpacity));
        return super.m8511onPostScrollDzOQY0M(j11, j12, i11);
    }
}
