package androidx.compose.foundation.text;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
public final class LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3527h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextDragObserver f3528i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2$1", f = "LongPressTextDragObserver.kt", i = {0, 1, 1}, l = {99, 103}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "down"}, s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public Object f3529h;

        /* renamed from: i  reason: collision with root package name */
        public int f3530i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(textDragObserver, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0060 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0094 A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f3530i
                r3 = 2
                r4 = 0
                r5 = 0
                r6 = 1
                if (r2 == 0) goto L_0x0033
                if (r2 == r6) goto L_0x0029
                if (r2 != r3) goto L_0x0021
                java.lang.Object r2 = r0.f3529h
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
                java.lang.Object r7 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
                kotlin.ResultKt.throwOnFailure(r17)
                r9 = r17
                r8 = r0
                goto L_0x0061
            L_0x0021:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0029:
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r17)
                r7 = r17
                goto L_0x0045
            L_0x0033:
                kotlin.ResultKt.throwOnFailure(r17)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                r0.L$0 = r2
                r0.f3530i = r6
                java.lang.Object r7 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r2, r5, r0, r6, r4)
                if (r7 != r1) goto L_0x0045
                return r1
            L_0x0045:
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                androidx.compose.foundation.text.TextDragObserver r8 = r3
                long r9 = r7.m4306getPositionF1C5BW0()
                r8.m903onDownk4lQ0M(r9)
                r8 = r0
                r15 = r7
                r7 = r2
                r2 = r15
            L_0x0054:
                r8.L$0 = r7
                r8.f3529h = r2
                r8.f3530i = r3
                java.lang.Object r9 = i0.b.t(r7, r4, r8, r6, r4)
                if (r9 != r1) goto L_0x0061
                return r1
            L_0x0061:
                androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                java.util.List r9 = r9.getChanges()
                int r10 = r9.size()
                r11 = r5
            L_0x006c:
                if (r11 >= r10) goto L_0x0094
                java.lang.Object r12 = r9.get(r11)
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                long r13 = r12.m4305getIdJ3iCeTQ()
                long r3 = r2.m4305getIdJ3iCeTQ()
                boolean r3 = androidx.compose.ui.input.pointer.PointerId.m4291equalsimpl0(r13, r3)
                if (r3 == 0) goto L_0x008a
                boolean r3 = r12.getPressed()
                if (r3 == 0) goto L_0x008a
                r3 = r6
                goto L_0x008b
            L_0x008a:
                r3 = r5
            L_0x008b:
                if (r3 == 0) goto L_0x008f
                r3 = r6
                goto L_0x0095
            L_0x008f:
                int r11 = r11 + 1
                r3 = 2
                r4 = 0
                goto L_0x006c
            L_0x0094:
                r3 = r5
            L_0x0095:
                if (r3 != 0) goto L_0x009f
                androidx.compose.foundation.text.TextDragObserver r1 = r3
                r1.onUp()
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x009f:
                r3 = 2
                r4 = 0
                goto L_0x0054
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(TextDragObserver textDragObserver, Continuation<? super LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2> continuation) {
        super(2, continuation);
        this.f3528i = textDragObserver;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 = new LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(this.f3528i, continuation);
        longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.L$0 = obj;
        return longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3527h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final TextDragObserver textDragObserver = this.f3528i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f3527h = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
