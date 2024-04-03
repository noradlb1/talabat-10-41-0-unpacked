package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0018\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/material3/SwipeableKt$PreUpPostDownNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "(J)F", "toOffset", "(F)J", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8387b;

    public SwipeableKt$PreUpPostDownNestedScrollConnection$1(SwipeableState<T> swipeableState) {
        this.f8387b = swipeableState;
    }

    private final float toFloat(long j11) {
        return Offset.m2677getYimpl(j11);
    }

    private final long toOffset(float f11) {
        return OffsetKt.Offset(0.0f, f11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1869onPostFlingRZ2iAVY(long r5, long r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r4 = this;
            boolean r5 = r9 instanceof androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            if (r5 == 0) goto L_0x0013
            r5 = r9
            androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) r5
            int r6 = r5.f8391k
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r6 & r0
            if (r1 == 0) goto L_0x0013
            int r6 = r6 - r0
            r5.f8391k = r6
            goto L_0x0018
        L_0x0013:
            androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            r5.<init>(r4, r9)
        L_0x0018:
            java.lang.Object r6 = r5.f8389i
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.f8391k
            r1 = 1
            if (r0 == 0) goto L_0x0033
            if (r0 != r1) goto L_0x002b
            long r7 = r5.f8388h
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0053
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.material3.SwipeableState<T> r6 = r4.f8387b
            float r0 = androidx.compose.ui.unit.Velocity.m5703getXimpl(r7)
            float r2 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r7)
            long r2 = androidx.compose.ui.geometry.OffsetKt.Offset(r0, r2)
            float r0 = r4.toFloat(r2)
            r5.f8388h = r7
            r5.f8391k = r1
            java.lang.Object r5 = r6.performFling$material3_release(r0, r5)
            if (r5 != r9) goto L_0x0053
            return r9
        L_0x0053:
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m5694boximpl(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1.m1869onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1870onPostScrollDzOQY0M(long j11, long j12, int i11) {
        if (NestedScrollSource.m4213equalsimpl0(i11, NestedScrollSource.Companion.m4218getDragWNlRxjI())) {
            return toOffset(this.f8387b.performDrag$material3_release(toFloat(j12)));
        }
        return Offset.Companion.m2692getZeroF1C5BW0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1871onPreFlingQWom1Mo(long r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.f8395k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8395k = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f8393i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8395k
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            long r7 = r0.f8392h
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0078
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r9)
            float r9 = androidx.compose.ui.unit.Velocity.m5703getXimpl(r7)
            float r2 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r7)
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r9, r2)
            float r9 = r6.toFloat(r4)
            r2 = 0
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0072
            androidx.compose.material3.SwipeableState<T> r2 = r6.f8387b
            androidx.compose.runtime.State r2 = r2.getOffset()
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            androidx.compose.material3.SwipeableState<T> r4 = r6.f8387b
            float r4 = r4.getMinBound$material3_release()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0072
            androidx.compose.material3.SwipeableState<T> r2 = r6.f8387b
            r0.f8392h = r7
            r0.f8395k = r3
            java.lang.Object r9 = r2.performFling$material3_release(r9, r0)
            if (r9 != r1) goto L_0x0078
            return r1
        L_0x0072:
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.Companion
            long r7 = r7.m5714getZero9UxMQ8M()
        L_0x0078:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m5694boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1.m1871onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m1872onPreScrollOzD1aCk(long j11, int i11) {
        float f11 = toFloat(j11);
        if (f11 >= 0.0f || !NestedScrollSource.m4213equalsimpl0(i11, NestedScrollSource.Companion.m4218getDragWNlRxjI())) {
            return Offset.Companion.m2692getZeroF1C5BW0();
        }
        return toOffset(this.f8387b.performDrag$material3_release(f11));
    }
}
