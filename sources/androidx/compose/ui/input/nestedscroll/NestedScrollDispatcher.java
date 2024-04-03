package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "()V", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui_release", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "originNestedScrollScope", "getOriginNestedScrollScope$ui_release", "setOriginNestedScrollScope$ui_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setParent$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "dispatchPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPreScroll", "dispatchPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NestedScrollDispatcher {
    public static final int $stable = 8;
    @NotNull
    private Function0<? extends CoroutineScope> calculateNestedScrollScope = new NestedScrollDispatcher$calculateNestedScrollScope$1(this);
    @Nullable
    private CoroutineScope originNestedScrollScope;
    @Nullable
    private NestedScrollConnection parent;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: dispatchPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4202dispatchPostFlingRZ2iAVY(long r8, long r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1) r0
            int r1 = r0.f9753j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9753j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            r0.<init>(r7, r12)
        L_0x0018:
            r6 = r0
            java.lang.Object r12 = r6.f9751h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f9753j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r1 = r7.parent
            if (r1 == 0) goto L_0x004b
            r6.f9753j = r2
            r2 = r8
            r4 = r10
            java.lang.Object r12 = r1.m4194onPostFlingRZ2iAVY(r2, r4, r6)
            if (r12 != r0) goto L_0x0044
            return r0
        L_0x0044:
            androidx.compose.ui.unit.Velocity r12 = (androidx.compose.ui.unit.Velocity) r12
            long r8 = r12.m5712unboximpl()
            goto L_0x0051
        L_0x004b:
            androidx.compose.ui.unit.Velocity$Companion r8 = androidx.compose.ui.unit.Velocity.Companion
            long r8 = r8.m5714getZero9UxMQ8M()
        L_0x0051:
            androidx.compose.ui.unit.Velocity r8 = androidx.compose.ui.unit.Velocity.m5694boximpl(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.m4202dispatchPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: dispatchPostScroll-DzOQY0M  reason: not valid java name */
    public final long m4203dispatchPostScrollDzOQY0M(long j11, long j12, int i11) {
        NestedScrollConnection nestedScrollConnection = this.parent;
        return nestedScrollConnection != null ? nestedScrollConnection.m4195onPostScrollDzOQY0M(j11, j12, i11) : Offset.Companion.m2692getZeroF1C5BW0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: dispatchPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4204dispatchPreFlingQWom1Mo(long r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1) r0
            int r1 = r0.f9756j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9756j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f9754h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f9756j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r7 = r4.parent
            if (r7 == 0) goto L_0x0048
            r0.f9756j = r3
            java.lang.Object r7 = r7.m4196onPreFlingQWom1Mo(r5, r0)
            if (r7 != r1) goto L_0x0041
            return r1
        L_0x0041:
            androidx.compose.ui.unit.Velocity r7 = (androidx.compose.ui.unit.Velocity) r7
            long r5 = r7.m5712unboximpl()
            goto L_0x004e
        L_0x0048:
            androidx.compose.ui.unit.Velocity$Companion r5 = androidx.compose.ui.unit.Velocity.Companion
            long r5 = r5.m5714getZero9UxMQ8M()
        L_0x004e:
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m5694boximpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.m4204dispatchPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: dispatchPreScroll-OzD1aCk  reason: not valid java name */
    public final long m4205dispatchPreScrollOzD1aCk(long j11, int i11) {
        NestedScrollConnection nestedScrollConnection = this.parent;
        return nestedScrollConnection != null ? nestedScrollConnection.m4197onPreScrollOzD1aCk(j11, i11) : Offset.Companion.m2692getZeroF1C5BW0();
    }

    @NotNull
    public final Function0<CoroutineScope> getCalculateNestedScrollScope$ui_release() {
        return this.calculateNestedScrollScope;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScope = (CoroutineScope) this.calculateNestedScrollScope.invoke();
        if (coroutineScope != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    @Nullable
    public final CoroutineScope getOriginNestedScrollScope$ui_release() {
        return this.originNestedScrollScope;
    }

    @Nullable
    public final NestedScrollConnection getParent$ui_release() {
        return this.parent;
    }

    public final void setCalculateNestedScrollScope$ui_release(@NotNull Function0<? extends CoroutineScope> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.calculateNestedScrollScope = function0;
    }

    public final void setOriginNestedScrollScope$ui_release(@Nullable CoroutineScope coroutineScope) {
        this.originNestedScrollScope = coroutineScope;
    }

    public final void setParent$ui_release(@Nullable NestedScrollConnection nestedScrollConnection) {
        this.parent = nestedScrollConnection;
    }
}
