package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a>\u0010\b\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ForEachGestureKt {
    public static final boolean allPointersUp(@NotNull AwaitPointerEventScope awaitPointerEventScope) {
        Intrinsics.checkNotNullParameter(awaitPointerEventScope, "<this>");
        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
        int size = changes.size();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            } else if (changes.get(i11).getPressed()) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        return !z11;
    }

    @Nullable
    public static final Object awaitAllPointersUp(@NotNull PointerInputScope pointerInputScope, @NotNull Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new ForEachGestureKt$awaitAllPointersUp$2((Continuation<? super ForEachGestureKt$awaitAllPointersUp$2>) null), continuation);
        return awaitPointerEventScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074 A[SYNTHETIC, Splitter:B:25:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object forEachGesture(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.PointerInputScope r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1) r0
            int r1 = r0.f2131l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2131l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f2130k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2131l
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0067
            if (r2 == r5) goto L_0x0055
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r8 = r0.f2129j
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r9 = r0.f2128i
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r2 = r0.f2127h
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0052
        L_0x003b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0043:
            java.lang.Object r8 = r0.f2129j
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r9 = r0.f2128i
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r2 = r0.f2127h
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ CancellationException -> 0x0065 }
        L_0x0052:
            r10 = r8
            r8 = r2
            goto L_0x006e
        L_0x0055:
            java.lang.Object r8 = r0.f2129j
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r9 = r0.f2128i
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r2 = r0.f2127h
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ CancellationException -> 0x0065 }
            goto L_0x0085
        L_0x0065:
            r10 = move-exception
            goto L_0x0099
        L_0x0067:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.coroutines.CoroutineContext r10 = r0.getContext()
        L_0x006e:
            boolean r2 = kotlinx.coroutines.JobKt.isActive(r10)
            if (r2 == 0) goto L_0x00af
            r0.f2127h = r8     // Catch:{ CancellationException -> 0x0094 }
            r0.f2128i = r9     // Catch:{ CancellationException -> 0x0094 }
            r0.f2129j = r10     // Catch:{ CancellationException -> 0x0094 }
            r0.f2131l = r5     // Catch:{ CancellationException -> 0x0094 }
            java.lang.Object r2 = r9.invoke(r8, r0)     // Catch:{ CancellationException -> 0x0094 }
            if (r2 != r1) goto L_0x0083
            return r1
        L_0x0083:
            r2 = r8
            r8 = r10
        L_0x0085:
            r0.f2127h = r2     // Catch:{ CancellationException -> 0x0065 }
            r0.f2128i = r9     // Catch:{ CancellationException -> 0x0065 }
            r0.f2129j = r8     // Catch:{ CancellationException -> 0x0065 }
            r0.f2131l = r4     // Catch:{ CancellationException -> 0x0065 }
            java.lang.Object r10 = awaitAllPointersUp((androidx.compose.ui.input.pointer.PointerInputScope) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)     // Catch:{ CancellationException -> 0x0065 }
            if (r10 != r1) goto L_0x0052
            return r1
        L_0x0094:
            r2 = move-exception
            r7 = r2
            r2 = r8
            r8 = r10
            r10 = r7
        L_0x0099:
            boolean r6 = kotlinx.coroutines.JobKt.isActive(r8)
            if (r6 == 0) goto L_0x00ae
            r0.f2127h = r2
            r0.f2128i = r9
            r0.f2129j = r8
            r0.f2131l = r3
            java.lang.Object r10 = awaitAllPointersUp((androidx.compose.ui.input.pointer.PointerInputScope) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r10 != r1) goto L_0x0052
            return r1
        L_0x00ae:
            throw r10
        L_0x00af:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.forEachGesture(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (allPointersUp(r7) == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (r4 == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a A[EDGE_INSN: B:27:0x006a->B:23:0x006a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitAllPointersUp(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3) r0
            int r1 = r0.f2126j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2126j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f2125i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2126j
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r7 = r0.f2124h
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004b
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = allPointersUp(r7)
            if (r8 != 0) goto L_0x006c
        L_0x003e:
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.f2124h = r7
            r0.f2126j = r3
            java.lang.Object r8 = r7.awaitPointerEvent(r8, r0)
            if (r8 != r1) goto L_0x004b
            return r1
        L_0x004b:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.util.List r8 = r8.getChanges()
            int r2 = r8.size()
            r4 = 0
            r5 = r4
        L_0x0057:
            if (r5 >= r2) goto L_0x006a
            java.lang.Object r6 = r8.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = r6.getPressed()
            if (r6 == 0) goto L_0x0067
            r4 = r3
            goto L_0x006a
        L_0x0067:
            int r5 = r5 + 1
            goto L_0x0057
        L_0x006a:
            if (r4 != 0) goto L_0x003e
        L_0x006c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
