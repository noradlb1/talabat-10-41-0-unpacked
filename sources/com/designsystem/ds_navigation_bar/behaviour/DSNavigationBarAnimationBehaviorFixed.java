package com.designsystem.ds_navigation_bar.behaviour;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.designsystem.ds_navigation_bar.NavigationBar;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.extensions.IntExtensionsKt;
import e6.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/designsystem/ds_navigation_bar/behaviour/DSNavigationBarAnimationBehaviorFixed;", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "scrollContainer", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "_backgroundOpacity", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_elevationOpacity", "_opacity", "backgroundOpacity", "Landroidx/lifecycle/LiveData;", "getBackgroundOpacity", "()Landroidx/lifecycle/LiveData;", "elevationOpacity", "getElevationOpacity", "opacity", "getOpacity", "calculateNavigationBarElevationOpacity", "scrollY", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarAnimationBehaviorFixed extends DSNavigationBarAnimationBehaviour {
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

    public DSNavigationBarAnimationBehaviorFixed() {
        this((ViewGroup) null, 1, (DefaultConstructorMarker) null);
    }

    public DSNavigationBarAnimationBehaviorFixed(@Nullable ViewGroup viewGroup) {
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
        if (viewGroup != null) {
            viewGroup.setOnScrollChangeListener(new b(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m8506_init_$lambda1(DSNavigationBarAnimationBehaviorFixed dSNavigationBarAnimationBehaviorFixed, View view, int i11, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(dSNavigationBarAnimationBehaviorFixed, "this$0");
        dSNavigationBarAnimationBehaviorFixed._elevationOpacity.setValue(Float.valueOf(dSNavigationBarAnimationBehaviorFixed.calculateNavigationBarElevationOpacity(i12)));
    }

    private final float calculateNavigationBarElevationOpacity(int i11) {
        float toPx = (float) IntExtensionsKt.getToPx((int) NavigationBar.INSTANCE.m8500getNavigationBarHeightD9Ej5fM());
        float f11 = ((float) 1) - ((toPx - ((float) i11)) / toPx);
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        if (f11 < 0.0f) {
            return 0.0f;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSNavigationBarAnimationBehaviorFixed(ViewGroup viewGroup, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : viewGroup);
    }
}
