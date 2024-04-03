package com.designsystem.ds_navigation_bar.behaviour;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.designsystem.ds_navigation_bar.NavigationBar;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.extensions.IntExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J-\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Lcom/designsystem/ds_navigation_bar/behaviour/DSNavigationBarAnimationBehaviorImageRatioCompose;", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "imageRatioHeight", "", "(I)V", "_backgroundOpacity", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_elevationOpacity", "_opacity", "backgroundOpacity", "Landroidx/lifecycle/LiveData;", "getBackgroundOpacity", "()Landroidx/lifecycle/LiveData;", "elevationOpacity", "getElevationOpacity", "getImageRatioHeight", "()I", "setImageRatioHeight", "opacity", "getOpacity", "scrolled", "calculateNavigationBarElevationOpacity", "scrollY", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarAnimationBehaviorImageRatioCompose extends DSNavigationBarAnimationBehaviour {
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
    private int imageRatioHeight;
    @NotNull
    private final LiveData<Float> opacity;
    private float scrolled;

    public DSNavigationBarAnimationBehaviorImageRatioCompose() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public DSNavigationBarAnimationBehaviorImageRatioCompose(int i11) {
        this.imageRatioHeight = i11;
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
        this.scrolled += f11;
        float toPx = ((float) 1) - ((((float) this.imageRatioHeight) - (this.scrolled * ((float) -1))) / ((float) IntExtensionsKt.getToPx((int) NavigationBar.INSTANCE.m8500getNavigationBarHeightD9Ej5fM())));
        if (toPx > 1.0f) {
            toPx = 1.0f;
        }
        if (toPx < 0.0f) {
            return 0.0f;
        }
        return toPx;
    }

    @NotNull
    public LiveData<Float> getBackgroundOpacity() {
        return this.backgroundOpacity;
    }

    @NotNull
    public LiveData<Float> getElevationOpacity() {
        return this.elevationOpacity;
    }

    public final int getImageRatioHeight() {
        return this.imageRatioHeight;
    }

    @NotNull
    public LiveData<Float> getOpacity() {
        return this.opacity;
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m8509onPostScrollDzOQY0M(long j11, long j12, int i11) {
        float calculateNavigationBarElevationOpacity = calculateNavigationBarElevationOpacity(Offset.m2677getYimpl(j11));
        this._opacity.setValue(Float.valueOf(calculateNavigationBarElevationOpacity));
        this._backgroundOpacity.setValue(Float.valueOf(calculateNavigationBarElevationOpacity));
        this._elevationOpacity.setValue(Float.valueOf(calculateNavigationBarElevationOpacity));
        return super.m8511onPostScrollDzOQY0M(j11, j12, i11);
    }

    public final void setImageRatioHeight(int i11) {
        this.imageRatioHeight = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSNavigationBarAnimationBehaviorImageRatioCompose(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }
}
