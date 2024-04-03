package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import h0.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EnterAlwaysScrollBehavior f6964b;

    public EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior enterAlwaysScrollBehavior) {
        this.f6964b = enterAlwaysScrollBehavior;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1661onPostFlingRZ2iAVY(long r10, long r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) r0
            int r1 = r0.f6969l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f6969l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r9, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f6967j
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.f6969l
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0040
            if (r1 == r2) goto L_0x0036
            if (r1 != r8) goto L_0x002e
            long r10 = r0.f6966i
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0080
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            long r12 = r0.f6966i
            java.lang.Object r10 = r0.f6965h
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1 r10 = (androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1) r10
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0055
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r14)
            r0.f6965h = r9
            r0.f6966i = r12
            r0.f6969l = r2
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
            androidx.compose.material3.EnterAlwaysScrollBehavior r11 = r10.f6964b
            androidx.compose.material3.TopAppBarState r11 = r11.getState()
            float r12 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r12)
            androidx.compose.material3.EnterAlwaysScrollBehavior r13 = r10.f6964b
            androidx.compose.animation.core.DecayAnimationSpec r13 = r13.getFlingAnimationSpec()
            androidx.compose.material3.EnterAlwaysScrollBehavior r10 = r10.f6964b
            androidx.compose.animation.core.AnimationSpec r10 = r10.getSnapAnimationSpec()
            r14 = 0
            r0.f6965h = r14
            r0.f6966i = r1
            r0.f6969l = r8
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1.m1661onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r9 != false) goto L_0x005e;
     */
    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m1662onPostScrollDzOQY0M(long r5, long r7, int r9) {
        /*
            r4 = this;
            androidx.compose.material3.EnterAlwaysScrollBehavior r9 = r4.f6964b
            kotlin.jvm.functions.Function0 r9 = r9.getCanScroll()
            java.lang.Object r9 = r9.invoke()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0019
            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
            long r5 = r5.m2692getZeroF1C5BW0()
            return r5
        L_0x0019:
            androidx.compose.material3.EnterAlwaysScrollBehavior r9 = r4.f6964b
            androidx.compose.material3.TopAppBarState r9 = r9.getState()
            float r0 = r9.getContentOffset()
            float r1 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r5)
            float r0 = r0 + r1
            r9.setContentOffset(r0)
            androidx.compose.material3.EnterAlwaysScrollBehavior r9 = r4.f6964b
            androidx.compose.material3.TopAppBarState r9 = r9.getState()
            float r9 = r9.getHeightOffset()
            r0 = 0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r9 != 0) goto L_0x003e
            r9 = r1
            goto L_0x003f
        L_0x003e:
            r9 = r2
        L_0x003f:
            if (r9 != 0) goto L_0x005e
            androidx.compose.material3.EnterAlwaysScrollBehavior r9 = r4.f6964b
            androidx.compose.material3.TopAppBarState r9 = r9.getState()
            float r9 = r9.getHeightOffset()
            androidx.compose.material3.EnterAlwaysScrollBehavior r3 = r4.f6964b
            androidx.compose.material3.TopAppBarState r3 = r3.getState()
            float r3 = r3.getHeightOffsetLimit()
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x005b
            r9 = r1
            goto L_0x005c
        L_0x005b:
            r9 = r2
        L_0x005c:
            if (r9 == 0) goto L_0x007b
        L_0x005e:
            float r9 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r5)
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 != 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r1 = r2
        L_0x0068:
            if (r1 == 0) goto L_0x007b
            float r7 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r7)
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x007b
            androidx.compose.material3.EnterAlwaysScrollBehavior r7 = r4.f6964b
            androidx.compose.material3.TopAppBarState r7 = r7.getState()
            r7.setContentOffset(r0)
        L_0x007b:
            androidx.compose.material3.EnterAlwaysScrollBehavior r7 = r4.f6964b
            androidx.compose.material3.TopAppBarState r7 = r7.getState()
            androidx.compose.material3.EnterAlwaysScrollBehavior r8 = r4.f6964b
            androidx.compose.material3.TopAppBarState r8 = r8.getState()
            float r8 = r8.getHeightOffset()
            float r5 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r5)
            float r8 = r8 + r5
            r7.setHeightOffset(r8)
            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
            long r5 = r5.m2692getZeroF1C5BW0()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1.m1662onPostScrollDzOQY0M(long, long, int):long");
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m1663onPreFlingQWom1Mo(long j11, Continuation continuation) {
        return a.c(this, j11, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m1664onPreScrollOzD1aCk(long j11, int i11) {
        boolean z11;
        if (!this.f6964b.getCanScroll().invoke().booleanValue()) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        float heightOffset = this.f6964b.getState().getHeightOffset();
        this.f6964b.getState().setHeightOffset(this.f6964b.getState().getHeightOffset() + Offset.m2677getYimpl(j11));
        if (heightOffset == this.f6964b.getState().getHeightOffset()) {
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
