package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import h0.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"androidx/compose/material3/PinnedScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PinnedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PinnedScrollBehavior f7782b;

    public PinnedScrollBehavior$nestedScrollConnection$1(PinnedScrollBehavior pinnedScrollBehavior) {
        this.f7782b = pinnedScrollBehavior;
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public /* synthetic */ Object m1791onPostFlingRZ2iAVY(long j11, long j12, Continuation continuation) {
        return a.a(this, j11, j12, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1792onPostScrollDzOQY0M(long j11, long j12, int i11) {
        boolean z11;
        if (!this.f7782b.getCanScroll().invoke().booleanValue()) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        if (Offset.m2677getYimpl(j11) == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || Offset.m2677getYimpl(j12) <= 0.0f) {
            TopAppBarState state = this.f7782b.getState();
            state.setContentOffset(state.getContentOffset() + Offset.m2677getYimpl(j11));
        } else {
            this.f7782b.getState().setContentOffset(0.0f);
        }
        return Offset.Companion.m2692getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m1793onPreFlingQWom1Mo(long j11, Continuation continuation) {
        return a.c(this, j11, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public /* synthetic */ long m1794onPreScrollOzD1aCk(long j11, int i11) {
        return a.d(this, j11, i11);
    }
}
