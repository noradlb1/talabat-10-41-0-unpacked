package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import h0.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/material3/ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExitUntilCollapsedScrollBehavior f6970b;

    public ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior) {
        this.f6970b = exitUntilCollapsedScrollBehavior;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1665onPostFlingRZ2iAVY(long r10, long r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1) r0
            int r1 = r0.f6975l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f6975l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r9, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f6973j
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.f6975l
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0040
            if (r1 == r2) goto L_0x0036
            if (r1 != r8) goto L_0x002e
            long r10 = r0.f6972i
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0080
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            long r12 = r0.f6972i
            java.lang.Object r10 = r0.f6971h
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 r10 = (androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1) r10
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0055
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r14)
            r0.f6971h = r9
            r0.f6972i = r12
            r0.f6975l = r2
            r1 = r9
            r2 = r10
            r4 = r12
            r6 = r0
            java.lang.Object r14 = h0.a.a(r1, r2, r4, r6)
            if (r14 != r7) goto L_0x0054
            return r7
        L_0x0054:
            r10 = r9
        L_0x0055:
            androidx.compose.ui.unit.Velocity r14 = (androidx.compose.ui.unit.Velocity) r14
            long r1 = r14.m5712unboximpl()
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r11 = r10.f6970b
            androidx.compose.material3.TopAppBarState r11 = r11.getState()
            float r12 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r12)
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r13 = r10.f6970b
            androidx.compose.animation.core.DecayAnimationSpec r13 = r13.getFlingAnimationSpec()
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r10 = r10.f6970b
            androidx.compose.animation.core.AnimationSpec r10 = r10.getSnapAnimationSpec()
            r14 = 0
            r0.f6971h = r14
            r0.f6972i = r1
            r0.f6975l = r8
            java.lang.Object r14 = androidx.compose.material3.AppBarKt.settleAppBar(r11, r12, r13, r10, r0)
            if (r14 != r7) goto L_0x007f
            return r7
        L_0x007f:
            r10 = r1
        L_0x0080:
            androidx.compose.ui.unit.Velocity r14 = (androidx.compose.ui.unit.Velocity) r14
            long r12 = r14.m5712unboximpl()
            long r10 = androidx.compose.ui.unit.Velocity.m5707plusAH228Gc(r10, r12)
            androidx.compose.ui.unit.Velocity r10 = androidx.compose.ui.unit.Velocity.m5694boximpl(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1.m1665onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1666onPostScrollDzOQY0M(long j11, long j12, int i11) {
        boolean z11;
        if (!this.f6970b.getCanScroll().invoke().booleanValue()) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        TopAppBarState state = this.f6970b.getState();
        state.setContentOffset(state.getContentOffset() + Offset.m2677getYimpl(j11));
        if (Offset.m2677getYimpl(j12) < 0.0f || Offset.m2677getYimpl(j11) < 0.0f) {
            float heightOffset = this.f6970b.getState().getHeightOffset();
            this.f6970b.getState().setHeightOffset(this.f6970b.getState().getHeightOffset() + Offset.m2677getYimpl(j11));
            return OffsetKt.Offset(0.0f, this.f6970b.getState().getHeightOffset() - heightOffset);
        }
        if (Offset.m2677getYimpl(j11) == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && Offset.m2677getYimpl(j12) > 0.0f) {
            this.f6970b.getState().setContentOffset(0.0f);
        }
        if (Offset.m2677getYimpl(j12) <= 0.0f) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        float heightOffset2 = this.f6970b.getState().getHeightOffset();
        this.f6970b.getState().setHeightOffset(this.f6970b.getState().getHeightOffset() + Offset.m2677getYimpl(j12));
        return OffsetKt.Offset(0.0f, this.f6970b.getState().getHeightOffset() - heightOffset2);
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m1667onPreFlingQWom1Mo(long j11, Continuation continuation) {
        return a.c(this, j11, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m1668onPreScrollOzD1aCk(long j11, int i11) {
        boolean z11;
        if (!this.f6970b.getCanScroll().invoke().booleanValue() || Offset.m2677getYimpl(j11) > 0.0f) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        float heightOffset = this.f6970b.getState().getHeightOffset();
        this.f6970b.getState().setHeightOffset(this.f6970b.getState().getHeightOffset() + Offset.m2677getYimpl(j11));
        if (heightOffset == this.f6970b.getState().getHeightOffset()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return Offset.m2670copydBAh8RU$default(j11, 0.0f, 0.0f, 2, (Object) null);
        }
        return Offset.Companion.m2692getZeroF1C5BW0();
    }
}
