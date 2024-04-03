package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.concurrent.CancellationException;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
public final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f1965h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1966i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f1967j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1968k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<PointerInputChange, Offset, Unit> f1969l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1", f = "DragGestureDetector.kt", i = {0, 1, 2}, l = {238, 239, 244}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f1970h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(function1, function0, function02, function2, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.f1970h
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0032
                if (r1 == r5) goto L_0x002a
                if (r1 == r4) goto L_0x0022
                if (r1 != r3) goto L_0x001a
                java.lang.Object r0 = r7.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r0
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x007e
            L_0x001a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0022:
                java.lang.Object r1 = r7.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0056
            L_0x002a:
                java.lang.Object r1 = r7.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0045
            L_0x0032:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                r7.L$0 = r1
                r7.f1970h = r5
                java.lang.Object r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r2, r7)
                if (r8 != r0) goto L_0x0045
                return r0
            L_0x0045:
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                long r5 = r8.m4305getIdJ3iCeTQ()
                r7.L$0 = r1
                r7.f1970h = r4
                java.lang.Object r8 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m275awaitLongPressOrCancellationrnUCldI(r1, r5, r7)
                if (r8 != r0) goto L_0x0056
                return r0
            L_0x0056:
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                if (r8 == 0) goto L_0x00b1
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r4
                long r5 = r8.m4306getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m2665boximpl(r5)
                r4.invoke(r5)
                long r4 = r8.m4305getIdJ3iCeTQ()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1$1 r8 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1$1
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r6 = r7
                r8.<init>(r6)
                r7.L$0 = r1
                r7.f1970h = r3
                java.lang.Object r8 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m284dragjO51t88(r1, r4, r8, r7)
                if (r8 != r0) goto L_0x007d
                return r0
            L_0x007d:
                r0 = r1
            L_0x007e:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L_0x00ac
                androidx.compose.ui.input.pointer.PointerEvent r8 = r0.getCurrentEvent()
                java.util.List r8 = r8.getChanges()
                int r0 = r8.size()
            L_0x0092:
                if (r2 >= r0) goto L_0x00a6
                java.lang.Object r1 = r8.get(r2)
                androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r1)
                if (r3 == 0) goto L_0x00a3
                r1.consume()
            L_0x00a3:
                int r2 = r2 + 1
                goto L_0x0092
            L_0x00a6:
                kotlin.jvm.functions.Function0<kotlin.Unit> r8 = r5
                r8.invoke()
                goto L_0x00b1
            L_0x00ac:
                kotlin.jvm.functions.Function0<kotlin.Unit> r8 = r6
                r8.invoke()
            L_0x00b1:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function0<Unit> function0, Function1<? super Offset, Unit> function1, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5> continuation) {
        super(2, continuation);
        this.f1966i = function0;
        this.f1967j = function1;
        this.f1968k = function02;
        this.f1969l = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.f1966i, this.f1967j, this.f1968k, this.f1969l, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1965h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final Function1<Offset, Unit> function1 = this.f1967j;
            final Function0<Unit> function0 = this.f1968k;
            final Function0<Unit> function02 = this.f1966i;
            final Function2<PointerInputChange, Offset, Unit> function2 = this.f1969l;
            AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f1965h = 1;
            if (pointerInputScope.awaitPointerEventScope(r32, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException e11) {
                this.f1966i.invoke();
                throw e11;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
