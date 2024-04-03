package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a%\u0010\u000f\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001f\u0010\u0013\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u0005*\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aa\u0010\u0018\u001a\u00020\u0005*\u00020\u00192/\b\u0002\u0010\u001a\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010\u001e\u001a\u00020\u0005*\u00020\u00192\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2/\b\u0002\u0010\u001a\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u0017\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\"=\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0004ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "awaitFirstDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDownOnPass", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onPress", "onTap", "Lkotlin/Function1;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapGestures", "onDoubleTap", "onLongPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForUpOrCancellation", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TapGestureDetectorKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1((Continuation<? super TapGestureDetectorKt$NoPressGesture$1>) null);

    @Nullable
    public static final Object awaitFirstDown(@NotNull AwaitPointerEventScope awaitPointerEventScope, boolean z11, @NotNull Continuation<? super PointerInputChange> continuation) {
        return awaitFirstDownOnPass(awaitPointerEventScope, PointerEventPass.Main, z11, continuation);
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z11, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z11, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object awaitFirstDownOnPass(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, @org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.PointerEventPass r10, boolean r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1) r0
            int r1 = r0.f2222l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2222l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDownOnPass$1
            r0.<init>(r12)
        L_0x0018:
            java.lang.Object r12 = r0.f2221k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2222l
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            boolean r9 = r0.f2220j
            java.lang.Object r10 = r0.f2219i
            androidx.compose.ui.input.pointer.PointerEventPass r10 = (androidx.compose.ui.input.pointer.PointerEventPass) r10
            java.lang.Object r11 = r0.f2218h
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            r11 = r9
            r9 = r8
            goto L_0x0050
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r12)
        L_0x0041:
            r0.f2218h = r9
            r0.f2219i = r10
            r0.f2220j = r11
            r0.f2222l = r3
            java.lang.Object r12 = r9.awaitPointerEvent(r10, r0)
            if (r12 != r1) goto L_0x0050
            return r1
        L_0x0050:
            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
            java.util.List r2 = r12.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L_0x005c:
            if (r6 >= r4) goto L_0x0076
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r11 == 0) goto L_0x006b
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r7)
            goto L_0x006f
        L_0x006b:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r7)
        L_0x006f:
            if (r7 != 0) goto L_0x0073
            r2 = r5
            goto L_0x0077
        L_0x0073:
            int r6 = r6 + 1
            goto L_0x005c
        L_0x0076:
            r2 = r3
        L_0x0077:
            if (r2 == 0) goto L_0x0041
            java.util.List r9 = r12.getChanges()
            java.lang.Object r9 = r9.get(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDownOnPass(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Continuation<? super PointerInputChange> continuation) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange, (Continuation<? super TapGestureDetectorKt$awaitSecondDown$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052 A[LOOP:0: B:17:0x0050->B:18:0x0052, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a A[EDGE_INSN: B:30:0x007a->B:25:0x007a ?: BREAK  , SYNTHETIC] */
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1) r0
            int r1 = r0.f2228j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2228j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.f2227i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2228j
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r8 = r0.f2226h
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x0038:
            r0.f2226h = r8
            r0.f2228j = r3
            r9 = 0
            java.lang.Object r9 = i0.b.t(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L_0x0044
            return r1
        L_0x0044:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r2 = r9.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L_0x0050:
            if (r6 >= r4) goto L_0x005e
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            r7.consume()
            int r6 = r6 + 1
            goto L_0x0050
        L_0x005e:
            java.util.List r9 = r9.getChanges()
            int r2 = r9.size()
            r4 = r5
        L_0x0067:
            if (r4 >= r2) goto L_0x007a
            java.lang.Object r6 = r9.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = r6.getPressed()
            if (r6 == 0) goto L_0x0077
            r5 = r3
            goto L_0x007a
        L_0x0077:
            int r4 = r4 + 1
            goto L_0x0067
        L_0x007a:
            if (r5 != 0) goto L_0x0038
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final Object detectTapAndPress(@NotNull PointerInputScope pointerInputScope, @NotNull Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, @Nullable Function1<? super Offset, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new TapGestureDetectorKt$detectTapAndPress$2(new PressGestureScopeImpl(pointerInputScope), function3, function1, (Continuation<? super TapGestureDetectorKt$detectTapAndPress$2>) null), continuation);
        if (forEachGesture == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return forEachGesture;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    @Nullable
    public static final Object detectTapGestures(@NotNull PointerInputScope pointerInputScope, @Nullable Function1<? super Offset, Unit> function1, @Nullable Function1<? super Offset, Unit> function12, @NotNull Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, @Nullable Function1<? super Offset, Unit> function13, @NotNull Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapGestures$2(pointerInputScope, function3, function12, function1, function13, (Continuation<? super TapGestureDetectorKt$detectTapGestures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function1 function12, Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3, Function1 function13, Continuation continuation, int i11, Object obj) {
        Function1 function14;
        Function1 function15;
        Function1 function16;
        if ((i11 & 1) != 0) {
            function14 = null;
        } else {
            function14 = function1;
        }
        if ((i11 & 2) != 0) {
            function15 = null;
        } else {
            function15 = function12;
        }
        if ((i11 & 4) != 0) {
            function3 = NoPressGesture;
        }
        Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function32 = function3;
        if ((i11 & 8) != 0) {
            function16 = null;
        } else {
            function16 = function13;
        }
        return detectTapGestures(pointerInputScope, function14, function15, function32, function16, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00df A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0071 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00dc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object waitForUpOrCancellation(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r14) {
        /*
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$1) r0
            int r1 = r0.f2287j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2287j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$1
            r0.<init>(r14)
        L_0x0018:
            java.lang.Object r14 = r0.f2286i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2287j
            r3 = 0
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r6) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r13 = r0.f2285h
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00be
        L_0x0033:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003b:
            java.lang.Object r13 = r0.f2285h
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0053
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r14)
        L_0x0046:
            androidx.compose.ui.input.pointer.PointerEventPass r14 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r0.f2285h = r13
            r0.f2287j = r6
            java.lang.Object r14 = r13.awaitPointerEvent(r14, r0)
            if (r14 != r1) goto L_0x0053
            return r1
        L_0x0053:
            androidx.compose.ui.input.pointer.PointerEvent r14 = (androidx.compose.ui.input.pointer.PointerEvent) r14
            java.util.List r2 = r14.getChanges()
            int r7 = r2.size()
            r8 = r5
        L_0x005e:
            if (r8 >= r7) goto L_0x0071
            java.lang.Object r9 = r2.get(r8)
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r9)
            if (r9 != 0) goto L_0x006e
            r2 = r5
            goto L_0x0072
        L_0x006e:
            int r8 = r8 + 1
            goto L_0x005e
        L_0x0071:
            r2 = r6
        L_0x0072:
            if (r2 == 0) goto L_0x007d
            java.util.List r13 = r14.getChanges()
            java.lang.Object r13 = r13.get(r5)
            return r13
        L_0x007d:
            java.util.List r14 = r14.getChanges()
            int r2 = r14.size()
            r7 = r5
        L_0x0086:
            if (r7 >= r2) goto L_0x00ad
            java.lang.Object r8 = r14.get(r7)
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r9 = r8.isConsumed()
            if (r9 != 0) goto L_0x00a5
            long r9 = r13.m4222getSizeYbymL2g()
            long r11 = r13.m4221getExtendedTouchPaddingNHjbRc()
            boolean r8 = androidx.compose.ui.input.pointer.PointerEventKt.m4254isOutOfBoundsjwHxaWs(r8, r9, r11)
            if (r8 == 0) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            r8 = r5
            goto L_0x00a6
        L_0x00a5:
            r8 = r6
        L_0x00a6:
            if (r8 == 0) goto L_0x00aa
            r14 = r6
            goto L_0x00ae
        L_0x00aa:
            int r7 = r7 + 1
            goto L_0x0086
        L_0x00ad:
            r14 = r5
        L_0x00ae:
            if (r14 == 0) goto L_0x00b1
            return r3
        L_0x00b1:
            androidx.compose.ui.input.pointer.PointerEventPass r14 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.f2285h = r13
            r0.f2287j = r4
            java.lang.Object r14 = r13.awaitPointerEvent(r14, r0)
            if (r14 != r1) goto L_0x00be
            return r1
        L_0x00be:
            androidx.compose.ui.input.pointer.PointerEvent r14 = (androidx.compose.ui.input.pointer.PointerEvent) r14
            java.util.List r14 = r14.getChanges()
            int r2 = r14.size()
            r7 = r5
        L_0x00c9:
            if (r7 >= r2) goto L_0x00dc
            java.lang.Object r8 = r14.get(r7)
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.isConsumed()
            if (r8 == 0) goto L_0x00d9
            r14 = r6
            goto L_0x00dd
        L_0x00d9:
            int r7 = r7 + 1
            goto L_0x00c9
        L_0x00dc:
            r14 = r5
        L_0x00dd:
            if (r14 == 0) goto L_0x0046
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
