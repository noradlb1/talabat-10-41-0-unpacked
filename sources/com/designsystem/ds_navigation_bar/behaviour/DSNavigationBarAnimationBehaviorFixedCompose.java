package com.designsystem.ds_navigation_bar.behaviour;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.designsystem.ds_navigation_bar.NavigationBar;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.extensions.IntExtensionsKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J-\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Lcom/designsystem/ds_navigation_bar/behaviour/DSNavigationBarAnimationBehaviorFixedCompose;", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "()V", "_backgroundOpacity", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_elevationOpacity", "_opacity", "backgroundOpacity", "Landroidx/lifecycle/LiveData;", "getBackgroundOpacity", "()Landroidx/lifecycle/LiveData;", "elevationOpacity", "getElevationOpacity", "opacity", "getOpacity", "scrolled", "calculateNavigationBarElevationOpacity", "scrollY", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarAnimationBehaviorFixedCompose extends DSNavigationBarAnimationBehaviour {
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

    public DSNavigationBarAnimationBehaviorFixedCompose() {
        Float valueOf = Float.valueOf(1.0f);
        MutableLiveData<Float> mutableLiveData = new MutableLiveData<>(valueOf);
        this._opacity = mutableLiveData;
        this.opacity = mutableLiveData;
        MutableLiveData<Float> mutableLiveData2 = new MutableLiveData<>(valueOf);
        this._backgroundOpacity = mutableLiveData2;
        this.backgroundOpacity = mutableLiveData2;
        MutableLiveData<Float> mutableLiveData3 = new MutableLiveData<>(Float.valueOf(0.0f));
        this._elevationOpacity = mutableLiveData3;
        this.elevationOpacity = mutableLiveData3;
    }

    private final float calculateNavigationBarElevationOpacity(float f11) {
        this.scrolled += f11;
        float toPx = (float) IntExtensionsKt.getToPx((int) NavigationBar.INSTANCE.m8500getNavigationBarHeightD9Ej5fM());
        float f12 = ((float) 1) - ((toPx - (this.scrolled * ((float) -1))) / toPx);
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

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m8507onPostScrollDzOQY0M(long j11, long j12, int i11) {
        this._elevationOpacity.setValue(Float.valueOf(calculateNavigationBarElevationOpacity(Offset.m2677getYimpl(j11))));
        return super.m8511onPostScrollDzOQY0M(j11, j12, i11);
    }
}
