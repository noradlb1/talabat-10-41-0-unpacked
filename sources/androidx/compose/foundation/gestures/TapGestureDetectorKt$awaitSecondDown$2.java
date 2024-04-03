package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", i = {0, 0}, l = {198}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "minUptime"}, s = {"L$0", "J$0"})
public final class TapGestureDetectorKt$awaitSecondDown$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public long f2223h;

    /* renamed from: i  reason: collision with root package name */
    public int f2224i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PointerInputChange f2225j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$awaitSecondDown$2(PointerInputChange pointerInputChange, Continuation<? super TapGestureDetectorKt$awaitSecondDown$2> continuation) {
        super(2, continuation);
        this.f2225j = pointerInputChange;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2 = new TapGestureDetectorKt$awaitSecondDown$2(this.f2225j, continuation);
        tapGestureDetectorKt$awaitSecondDown$2.L$0 = obj;
        return tapGestureDetectorKt$awaitSecondDown$2;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super PointerInputChange> continuation) {
        return ((TapGestureDetectorKt$awaitSecondDown$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f2224i
            r2 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            long r3 = r9.f2223h
            java.lang.Object r1 = r9.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            goto L_0x004e
        L_0x0019:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            androidx.compose.ui.input.pointer.PointerInputChange r1 = r9.f2225j
            long r3 = r1.getUptimeMillis()
            androidx.compose.ui.platform.ViewConfiguration r1 = r10.getViewConfiguration()
            long r5 = r1.getDoubleTapMinTimeMillis()
            long r3 = r3 + r5
            r1 = r10
            r10 = r9
        L_0x0039:
            r10.L$0 = r1
            r10.f2223h = r3
            r10.f2224i = r2
            r5 = 0
            r6 = 0
            java.lang.Object r5 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r1, r5, r10, r2, r6)
            if (r5 != r0) goto L_0x0048
            return r0
        L_0x0048:
            r8 = r0
            r0 = r10
            r10 = r5
            r4 = r3
            r3 = r1
            r1 = r8
        L_0x004e:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            long r6 = r10.getUptimeMillis()
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0059
            return r10
        L_0x0059:
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
