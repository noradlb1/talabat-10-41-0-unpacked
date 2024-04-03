package com.designsystem.ds_navigation_bar.behaviour.base;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "()V", "backgroundOpacity", "Landroidx/lifecycle/LiveData;", "", "getBackgroundOpacity", "()Landroidx/lifecycle/LiveData;", "elevationOpacity", "getElevationOpacity", "opacity", "getOpacity", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DSNavigationBarAnimationBehaviour implements NestedScrollConnection {
    public static final int $stable = 0;

    @NotNull
    public abstract LiveData<Float> getBackgroundOpacity();

    @NotNull
    public abstract LiveData<Float> getElevationOpacity();

    @NotNull
    public abstract LiveData<Float> getOpacity();

    @Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m8510onPostFlingRZ2iAVY(long j11, long j12, @NotNull Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.DefaultImpls.m4198onPostFlingRZ2iAVY(this, j11, j12, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m8511onPostScrollDzOQY0M(long j11, long j12, int i11) {
        return NestedScrollConnection.DefaultImpls.m4199onPostScrollDzOQY0M(this, j11, j12, i11);
    }

    @Nullable
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m8512onPreFlingQWom1Mo(long j11, @NotNull Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.DefaultImpls.m4200onPreFlingQWom1Mo(this, j11, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m8513onPreScrollOzD1aCk(long j11, int i11) {
        return NestedScrollConnection.DefaultImpls.m4201onPreScrollOzD1aCk(this, j11, i11);
    }
}
