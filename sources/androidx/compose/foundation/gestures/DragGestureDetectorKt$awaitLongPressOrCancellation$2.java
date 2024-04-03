package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {819, 836}, m = "invokeSuspend", n = {"$this$withTimeout", "finished", "$this$withTimeout", "event", "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
public final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f1891h;

    /* renamed from: i  reason: collision with root package name */
    public int f1892i;

    /* renamed from: j  reason: collision with root package name */
    public int f1893j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<PointerInputChange> f1894k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<PointerInputChange> f1895l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.f1894k = objectRef;
        this.f1895l = objectRef2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.f1894k, this.f1895l, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0079 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ae A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1893j
            r3 = 2
            r4 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r6) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            int r2 = r0.f1892i
            java.lang.Object r7 = r0.f1891h
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r18)
            r4 = r18
            r5 = r0
            goto L_0x00c5
        L_0x0023:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002b:
            int r2 = r0.f1892i
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r18)
            r9 = r18
            r8 = r7
            r7 = r0
            goto L_0x005b
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            r8 = r0
            r7 = r2
            r2 = 0
        L_0x0043:
            if (r2 != 0) goto L_0x015f
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r8.L$0 = r7
            r8.f1891h = r4
            r8.f1892i = r2
            r8.f1893j = r6
            java.lang.Object r9 = r7.awaitPointerEvent(r9, r8)
            if (r9 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r16 = r8
            r8 = r7
            r7 = r16
        L_0x005b:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r10 = r9.getChanges()
            int r11 = r10.size()
            r12 = 0
        L_0x0066:
            if (r12 >= r11) goto L_0x0079
            java.lang.Object r13 = r10.get(r12)
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r13 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r13 != 0) goto L_0x0076
            r10 = 0
            goto L_0x007a
        L_0x0076:
            int r12 = r12 + 1
            goto L_0x0066
        L_0x0079:
            r10 = r6
        L_0x007a:
            if (r10 == 0) goto L_0x007d
            r2 = r6
        L_0x007d:
            java.util.List r10 = r9.getChanges()
            int r11 = r10.size()
            r12 = 0
        L_0x0086:
            if (r12 >= r11) goto L_0x00ae
            java.lang.Object r13 = r10.get(r12)
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r14 = r13.isConsumed()
            if (r14 != 0) goto L_0x00a5
            long r14 = r8.m4222getSizeYbymL2g()
            long r4 = r8.m4221getExtendedTouchPaddingNHjbRc()
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.m4254isOutOfBoundsjwHxaWs(r13, r14, r4)
            if (r4 == 0) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            r4 = 0
            goto L_0x00a6
        L_0x00a5:
            r4 = r6
        L_0x00a6:
            if (r4 == 0) goto L_0x00aa
            r4 = r6
            goto L_0x00af
        L_0x00aa:
            int r12 = r12 + 1
            r4 = 0
            goto L_0x0086
        L_0x00ae:
            r4 = 0
        L_0x00af:
            if (r4 == 0) goto L_0x00b2
            r2 = r6
        L_0x00b2:
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r7.L$0 = r8
            r7.f1891h = r9
            r7.f1892i = r2
            r7.f1893j = r3
            java.lang.Object r4 = r8.awaitPointerEvent(r4, r7)
            if (r4 != r1) goto L_0x00c3
            return r1
        L_0x00c3:
            r5 = r7
            r7 = r9
        L_0x00c5:
            androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
            java.util.List r4 = r4.getChanges()
            int r9 = r4.size()
            r10 = 0
        L_0x00d0:
            if (r10 >= r9) goto L_0x00e3
            java.lang.Object r11 = r4.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.isConsumed()
            if (r11 == 0) goto L_0x00e0
            r4 = r6
            goto L_0x00e4
        L_0x00e0:
            int r10 = r10 + 1
            goto L_0x00d0
        L_0x00e3:
            r4 = 0
        L_0x00e4:
            if (r4 == 0) goto L_0x00e7
            r2 = r6
        L_0x00e7:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r5.f1894k
            T r4 = r4.element
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            long r9 = r4.m4305getIdJ3iCeTQ()
            boolean r4 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m286isPointerUpDmW0f2w(r7, r9)
            if (r4 == 0) goto L_0x0125
            java.util.List r4 = r7.getChanges()
            int r7 = r4.size()
            r9 = 0
        L_0x0100:
            if (r9 >= r7) goto L_0x0113
            java.lang.Object r10 = r4.get(r9)
            r11 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x0110
            goto L_0x0114
        L_0x0110:
            int r9 = r9 + 1
            goto L_0x0100
        L_0x0113:
            r10 = 0
        L_0x0114:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 == 0) goto L_0x0121
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r5.f1894k
            r4.element = r10
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r5.f1895l
            r4.element = r10
            goto L_0x0159
        L_0x0121:
            r2 = r6
            r7 = r8
            r4 = 0
            goto L_0x015c
        L_0x0125:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r5.f1895l
            java.util.List r7 = r7.getChanges()
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r9 = r5.f1894k
            int r10 = r7.size()
            r11 = 0
        L_0x0132:
            if (r11 >= r10) goto L_0x0156
            java.lang.Object r12 = r7.get(r11)
            r13 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            long r13 = r13.m4305getIdJ3iCeTQ()
            T r15 = r9.element
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r18 = r7
            long r6 = r15.m4305getIdJ3iCeTQ()
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m4291equalsimpl0(r13, r6)
            if (r6 == 0) goto L_0x0150
            goto L_0x0157
        L_0x0150:
            int r11 = r11 + 1
            r7 = r18
            r6 = 1
            goto L_0x0132
        L_0x0156:
            r12 = 0
        L_0x0157:
            r4.element = r12
        L_0x0159:
            r7 = r8
            r4 = 0
            r6 = 1
        L_0x015c:
            r8 = r5
            goto L_0x0043
        L_0x015f:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
