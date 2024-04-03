package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", i = {}, l = {545}, m = "invokeSuspend", n = {}, s = {})
public final class DragGestureDetectorKt$detectHorizontalDragGestures$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f1976h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f1977i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<PointerInputChange, Float, Unit> f1978j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1979k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1980l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {546, 548, 559}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "overSlop"}, s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public Object f1981h;

        /* renamed from: i  reason: collision with root package name */
        public int f1982i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(function1, function2, function0, function02, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00aa  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.f1982i
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0032
                if (r1 == r4) goto L_0x002a
                if (r1 == r3) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x00a2
            L_0x0016:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x001e:
                java.lang.Object r1 = r12.f1981h
                kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
                java.lang.Object r3 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x006d
            L_0x002a:
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x0048
            L_0x0032:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                r12.L$0 = r13
                r12.f1982i = r4
                r1 = 0
                java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r13, r1, r12)
                if (r1 != r0) goto L_0x0045
                return r0
            L_0x0045:
                r11 = r1
                r1 = r13
                r13 = r11
            L_0x0048:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
                r10.<init>()
                long r5 = r13.m4305getIdJ3iCeTQ()
                int r7 = r13.m4309getTypeT8wyACA()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$drag$1 r8 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$drag$1
                r8.<init>(r10)
                r12.L$0 = r1
                r12.f1981h = r10
                r12.f1982i = r3
                r4 = r1
                r9 = r12
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m273awaitHorizontalPointerSlopOrCancellationgDDlDlE(r4, r5, r7, r8, r9)
                if (r13 != r0) goto L_0x006b
                return r0
            L_0x006b:
                r3 = r1
                r1 = r10
            L_0x006d:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                if (r13 == 0) goto L_0x00b5
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r4
                long r5 = r13.m4306getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m2665boximpl(r5)
                r4.invoke(r5)
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r4 = r5
                float r1 = r1.element
                java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
                r4.invoke(r13, r1)
                long r4 = r13.m4305getIdJ3iCeTQ()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$1
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r1 = r5
                r13.<init>(r1)
                r1 = 0
                r12.L$0 = r1
                r12.f1981h = r1
                r12.f1982i = r2
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m285horizontalDragjO51t88(r3, r4, r13, r12)
                if (r13 != r0) goto L_0x00a2
                return r0
            L_0x00a2:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto L_0x00b0
                kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r6
                r13.invoke()
                goto L_0x00b5
            L_0x00b0:
                kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r7
                r13.invoke()
            L_0x00b5:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$detectHorizontalDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5> continuation) {
        super(2, continuation);
        this.f1977i = function1;
        this.f1978j = function2;
        this.f1979k = function0;
        this.f1980l = function02;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DragGestureDetectorKt$detectHorizontalDragGestures$5 dragGestureDetectorKt$detectHorizontalDragGestures$5 = new DragGestureDetectorKt$detectHorizontalDragGestures$5(this.f1977i, this.f1978j, this.f1979k, this.f1980l, continuation);
        dragGestureDetectorKt$detectHorizontalDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectHorizontalDragGestures$5;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectHorizontalDragGestures$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1976h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final Function1<Offset, Unit> function1 = this.f1977i;
            final Function2<PointerInputChange, Float, Unit> function2 = this.f1978j;
            final Function0<Unit> function0 = this.f1979k;
            final Function0<Unit> function02 = this.f1980l;
            AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f1976h = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(r32, this) == coroutine_suspended) {
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
