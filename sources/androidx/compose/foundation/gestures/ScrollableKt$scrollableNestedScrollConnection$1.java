package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import h0.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/gestures/ScrollableKt$scrollableNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScrollableKt$scrollableNestedScrollConnection$1 implements NestedScrollConnection {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ State<ScrollingLogic> f2189b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f2190c;

    public ScrollableKt$scrollableNestedScrollConnection$1(State<ScrollingLogic> state, boolean z11) {
        this.f2189b = state;
        this.f2190c = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m341onPostFlingRZ2iAVY(long r3, long r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
            if (r3 == 0) goto L_0x0013
            r3 = r7
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r3 = (androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) r3
            int r4 = r3.f2195l
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L_0x0013
            int r4 = r4 - r0
            r3.f2195l = r4
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r3 = new androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
            r3.<init>(r2, r7)
        L_0x0018:
            java.lang.Object r4 = r3.f2193j
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.f2195l
            r1 = 1
            if (r0 == 0) goto L_0x0037
            if (r0 != r1) goto L_0x002f
            long r5 = r3.f2192i
            java.lang.Object r3 = r3.f2191h
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1 r3 = (androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1) r3
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0054
        L_0x002f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r4)
            boolean r4 = r2.f2190c
            if (r4 == 0) goto L_0x005f
            androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r4 = r2.f2189b
            java.lang.Object r4 = r4.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
            r3.f2191h = r2
            r3.f2192i = r5
            r3.f2195l = r1
            java.lang.Object r4 = r4.m347doFlingAnimationQWom1Mo(r5, r3)
            if (r4 != r7) goto L_0x0053
            return r7
        L_0x0053:
            r3 = r2
        L_0x0054:
            androidx.compose.ui.unit.Velocity r4 = (androidx.compose.ui.unit.Velocity) r4
            long r0 = r4.m5712unboximpl()
            long r4 = androidx.compose.ui.unit.Velocity.m5706minusAH228Gc(r5, r0)
            goto L_0x0066
        L_0x005f:
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r4 = r3.m5714getZero9UxMQ8M()
            r3 = r2
        L_0x0066:
            androidx.compose.ui.unit.Velocity r4 = androidx.compose.ui.unit.Velocity.m5694boximpl(r4)
            androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r3 = r3.f2189b
            r4.m5712unboximpl()
            java.lang.Object r3 = r3.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r3 = (androidx.compose.foundation.gestures.ScrollingLogic) r3
            r5 = 0
            r3.registerNestedFling(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1.m341onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m342onPostScrollDzOQY0M(long j11, long j12, int i11) {
        if (this.f2190c) {
            return this.f2189b.getValue().m350performRawScrollMKHz9U(j12);
        }
        return Offset.Companion.m2692getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m343onPreFlingQWom1Mo(long j11, Continuation continuation) {
        return a.c(this, j11, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m344onPreScrollOzD1aCk(long j11, int i11) {
        if (NestedScrollSource.m4213equalsimpl0(i11, NestedScrollSource.Companion.m4219getFlingWNlRxjI())) {
            this.f2189b.getValue().registerNestedFling(true);
        }
        return Offset.Companion.m2692getZeroF1C5BW0();
    }
}
