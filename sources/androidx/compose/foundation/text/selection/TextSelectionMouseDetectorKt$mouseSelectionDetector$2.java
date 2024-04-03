package androidx.compose.foundation.text.selection;

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
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2", f = "TextSelectionMouseDetector.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class TextSelectionMouseDetectorKt$mouseSelectionDetector$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3769h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MouseSelectionObserver f3770i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1", f = "TextSelectionMouseDetector.kt", i = {0, 0, 1, 1, 2, 2}, l = {90, 97, 112}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "clicksCounter", "$this$awaitPointerEventScope", "clicksCounter", "$this$awaitPointerEventScope", "clicksCounter"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public Object f3771h;

        /* renamed from: i  reason: collision with root package name */
        public int f3772i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(mouseSelectionObserver, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0051 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.f3772i
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0034
                if (r1 == r4) goto L_0x0027
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x001a:
                java.lang.Object r1 = r12.f3771h
                androidx.compose.foundation.text.selection.ClicksCounter r1 = (androidx.compose.foundation.text.selection.ClicksCounter) r1
                java.lang.Object r5 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r13)
                r13 = r5
                goto L_0x0044
            L_0x0027:
                java.lang.Object r1 = r12.f3771h
                androidx.compose.foundation.text.selection.ClicksCounter r1 = (androidx.compose.foundation.text.selection.ClicksCounter) r1
                java.lang.Object r5 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r13)
                r6 = r12
                goto L_0x0056
            L_0x0034:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                androidx.compose.foundation.text.selection.ClicksCounter r1 = new androidx.compose.foundation.text.selection.ClicksCounter
                androidx.compose.ui.platform.ViewConfiguration r5 = r13.getViewConfiguration()
                r1.<init>(r5)
            L_0x0044:
                r5 = r12
            L_0x0045:
                r5.L$0 = r13
                r5.f3771h = r1
                r5.f3772i = r4
                java.lang.Object r6 = androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.awaitMouseEventDown(r13, r5)
                if (r6 != r0) goto L_0x0052
                return r0
            L_0x0052:
                r11 = r5
                r5 = r13
                r13 = r6
                r6 = r11
            L_0x0056:
                androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
                r1.update(r13)
                java.util.List r7 = r13.getChanges()
                r8 = 0
                java.lang.Object r7 = r7.get(r8)
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                boolean r13 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.isShiftPressed(r13)
                if (r13 == 0) goto L_0x0093
                androidx.compose.foundation.text.selection.MouseSelectionObserver r13 = r3
                long r8 = r7.m4306getPositionF1C5BW0()
                boolean r13 = r13.m950onExtendk4lQ0M(r8)
                if (r13 == 0) goto L_0x00d6
                r7.consume()
                long r7 = r7.m4305getIdJ3iCeTQ()
                androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1$1 r13 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1$1
                androidx.compose.foundation.text.selection.MouseSelectionObserver r9 = r3
                r13.<init>(r9)
                r6.L$0 = r5
                r6.f3771h = r1
                r6.f3772i = r3
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m284dragjO51t88(r5, r7, r13, r6)
                if (r13 != r0) goto L_0x00d6
                return r0
            L_0x0093:
                int r13 = r1.getClicks()
                if (r13 == r4) goto L_0x00a9
                if (r13 == r3) goto L_0x00a2
                androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
                androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getParagraph()
                goto L_0x00af
            L_0x00a2:
                androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
                androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getWord()
                goto L_0x00af
            L_0x00a9:
                androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r13 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
                androidx.compose.foundation.text.selection.SelectionAdjustment r13 = r13.getNone()
            L_0x00af:
                androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = r3
                long r9 = r7.m4306getPositionF1C5BW0()
                boolean r8 = r8.m952onStart3MmeM6k(r9, r13)
                if (r8 == 0) goto L_0x00d6
                r7.consume()
                long r7 = r7.m4305getIdJ3iCeTQ()
                androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1$2 r9 = new androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1$2
                androidx.compose.foundation.text.selection.MouseSelectionObserver r10 = r3
                r9.<init>(r10, r13)
                r6.L$0 = r5
                r6.f3771h = r1
                r6.f3772i = r2
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m284dragjO51t88(r5, r7, r9, r6)
                if (r13 != r0) goto L_0x00d6
                return r0
            L_0x00d6:
                r13 = r5
                r5 = r6
                goto L_0x0045
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextSelectionMouseDetectorKt$mouseSelectionDetector$2(MouseSelectionObserver mouseSelectionObserver, Continuation<? super TextSelectionMouseDetectorKt$mouseSelectionDetector$2> continuation) {
        super(2, continuation);
        this.f3770i = mouseSelectionObserver;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TextSelectionMouseDetectorKt$mouseSelectionDetector$2 textSelectionMouseDetectorKt$mouseSelectionDetector$2 = new TextSelectionMouseDetectorKt$mouseSelectionDetector$2(this.f3770i, continuation);
        textSelectionMouseDetectorKt$mouseSelectionDetector$2.L$0 = obj;
        return textSelectionMouseDetectorKt$mouseSelectionDetector$2;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TextSelectionMouseDetectorKt$mouseSelectionDetector$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3769h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final MouseSelectionObserver mouseSelectionObserver = this.f3770i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f3769h = 1;
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
