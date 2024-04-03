package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1", f = "PointerInteropFilter.android.kt", i = {}, l = {343}, m = "invokeSuspend", n = {}, s = {})
public final class PointerInteropFilter_androidKt$motionEventSpy$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f9794h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<MotionEvent, Unit> f9795i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1", f = "PointerInteropFilter.android.kt", i = {0}, l = {345}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f9796h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(function1, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.f9796h
                r2 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                java.lang.Object r1 = r6.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r7)
                r3 = r1
                r1 = r0
                r0 = r6
                goto L_0x0039
            L_0x0016:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001e:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
                r1 = r7
                r7 = r6
            L_0x0027:
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                r7.L$0 = r1
                r7.f9796h = r2
                java.lang.Object r3 = r1.awaitPointerEvent(r3, r7)
                if (r3 != r0) goto L_0x0034
                return r0
            L_0x0034:
                r5 = r0
                r0 = r7
                r7 = r3
                r3 = r1
                r1 = r5
            L_0x0039:
                androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
                android.view.MotionEvent r7 = r7.getMotionEvent$ui_release()
                if (r7 == 0) goto L_0x0046
                kotlin.jvm.functions.Function1<android.view.MotionEvent, kotlin.Unit> r4 = r3
                r4.invoke(r7)
            L_0x0046:
                r7 = r0
                r0 = r1
                r1 = r3
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PointerInteropFilter_androidKt$motionEventSpy$1(Function1<? super MotionEvent, Unit> function1, Continuation<? super PointerInteropFilter_androidKt$motionEventSpy$1> continuation) {
        super(2, continuation);
        this.f9795i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PointerInteropFilter_androidKt$motionEventSpy$1 pointerInteropFilter_androidKt$motionEventSpy$1 = new PointerInteropFilter_androidKt$motionEventSpy$1(this.f9795i, continuation);
        pointerInteropFilter_androidKt$motionEventSpy$1.L$0 = obj;
        return pointerInteropFilter_androidKt$motionEventSpy$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PointerInteropFilter_androidKt$motionEventSpy$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f9794h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            pointerInputScope.setInterceptOutOfBoundsChildEvents(true);
            final Function1<MotionEvent, Unit> function1 = this.f9795i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f9794h = 1;
            if (pointerInputScope.awaitPointerEventScope(r12, this) == coroutine_suspended) {
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
