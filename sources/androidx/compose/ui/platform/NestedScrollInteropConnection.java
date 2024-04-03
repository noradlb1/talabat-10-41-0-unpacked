package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "consumedScrollCache", "", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "interruptOngoingScrolls", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    @NotNull
    private final int[] consumedScrollCache = new int[2];
    @NotNull
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    @NotNull
    private final View view;

    public NestedScrollInteropConnection(@NotNull View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view2);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        ViewCompat.setNestedScrollingEnabled(view2, true);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }

    @Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m4859onPostFlingRZ2iAVY(long j11, long j12, @NotNull Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5703getXimpl(j12)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5704getYimpl(j12)), true)) {
            j12 = Velocity.Companion.m5714getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m5694boximpl(j12);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m4860onPostScrollDzOQY0M(long j11, long j12, int i11) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m4866getScrollAxesk4lQ0M(j12), NestedScrollInteropConnectionKt.m4868toViewTypeGyEprt8(i11))) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        ArraysKt___ArraysJvmKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2676getXimpl(j11)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2677getYimpl(j11)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2676getXimpl(j12)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2677getYimpl(j12)), (int[]) null, NestedScrollInteropConnectionKt.m4868toViewTypeGyEprt8(i11), this.consumedScrollCache);
        return NestedScrollInteropConnectionKt.m4867toOffsetUv8p0NA(this.consumedScrollCache, j12);
    }

    @Nullable
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m4861onPreFlingQWom1Mo(long j11, @NotNull Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5703getXimpl(j11)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5704getYimpl(j11)))) {
            j11 = Velocity.Companion.m5714getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m5694boximpl(j11);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m4862onPreScrollOzD1aCk(long j11, int i11) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m4866getScrollAxesk4lQ0M(j11), NestedScrollInteropConnectionKt.m4868toViewTypeGyEprt8(i11))) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        ArraysKt___ArraysJvmKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2676getXimpl(j11)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2677getYimpl(j11)), this.consumedScrollCache, (int[]) null, NestedScrollInteropConnectionKt.m4868toViewTypeGyEprt8(i11));
        return NestedScrollInteropConnectionKt.m4867toOffsetUv8p0NA(this.consumedScrollCache, j11);
    }
}
