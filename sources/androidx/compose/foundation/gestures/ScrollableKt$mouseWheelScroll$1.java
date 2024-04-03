package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1", f = "Scrollable.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollableKt$mouseWheelScroll$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2168h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ScrollConfig f2169i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<ScrollingLogic> f2170j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1", f = "Scrollable.kt", i = {0}, l = {291}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f2171h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(scrollConfig, state, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0057 A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.f2171h
                r2 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                java.lang.Object r1 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r11)
                r3 = r1
                r1 = r0
                r0 = r10
                goto L_0x0037
            L_0x0016:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001e:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
                r1 = r11
                r11 = r10
            L_0x0027:
                r11.L$0 = r1
                r11.f2171h = r2
                java.lang.Object r3 = androidx.compose.foundation.gestures.ScrollableKt.awaitScrollEvent(r1, r11)
                if (r3 != r0) goto L_0x0032
                return r0
            L_0x0032:
                r9 = r0
                r0 = r11
                r11 = r3
                r3 = r1
                r1 = r9
            L_0x0037:
                androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                java.util.List r4 = r11.getChanges()
                int r5 = r4.size()
                r6 = 0
                r7 = r6
            L_0x0043:
                if (r7 >= r5) goto L_0x0057
                java.lang.Object r8 = r4.get(r7)
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                boolean r8 = r8.isConsumed()
                r8 = r8 ^ r2
                if (r8 != 0) goto L_0x0054
                r4 = r6
                goto L_0x0058
            L_0x0054:
                int r7 = r7 + 1
                goto L_0x0043
            L_0x0057:
                r4 = r2
            L_0x0058:
                if (r4 == 0) goto L_0x009c
                androidx.compose.foundation.gestures.ScrollConfig r4 = r3
                androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r5 = r4
                long r7 = r3.m4222getSizeYbymL2g()
                long r7 = r4.m339calculateMouseWheelScroll8xgXZGE(r3, r11, r7)
                java.lang.Object r4 = r5.getValue()
                androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
                float r5 = r4.m355toFloatk4lQ0M(r7)
                float r5 = r4.reverseIfNeeded(r5)
                androidx.compose.foundation.gestures.ScrollableState r4 = r4.getScrollableState()
                float r4 = r4.dispatchRawDelta(r5)
                r5 = 0
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 != 0) goto L_0x0083
                r4 = r2
                goto L_0x0084
            L_0x0083:
                r4 = r6
            L_0x0084:
                if (r4 != 0) goto L_0x009c
                java.util.List r11 = r11.getChanges()
                int r4 = r11.size()
            L_0x008e:
                if (r6 >= r4) goto L_0x009c
                java.lang.Object r5 = r11.get(r6)
                androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
                r5.consume()
                int r6 = r6 + 1
                goto L_0x008e
            L_0x009c:
                r11 = r0
                r0 = r1
                r1 = r3
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableKt$mouseWheelScroll$1(ScrollConfig scrollConfig, State<ScrollingLogic> state, Continuation<? super ScrollableKt$mouseWheelScroll$1> continuation) {
        super(2, continuation);
        this.f2169i = scrollConfig;
        this.f2170j = state;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ScrollableKt$mouseWheelScroll$1 scrollableKt$mouseWheelScroll$1 = new ScrollableKt$mouseWheelScroll$1(this.f2169i, this.f2170j, continuation);
        scrollableKt$mouseWheelScroll$1.L$0 = obj;
        return scrollableKt$mouseWheelScroll$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ScrollableKt$mouseWheelScroll$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2168h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final ScrollConfig scrollConfig = this.f2169i;
            final State<ScrollingLogic> state = this.f2170j;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f2168h = 1;
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
