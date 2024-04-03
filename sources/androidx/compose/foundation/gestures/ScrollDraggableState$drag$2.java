package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollDraggableState$drag$2", f = "Scrollable.kt", i = {}, l = {493}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollDraggableState$drag$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2139h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ScrollDraggableState f2140i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> f2141j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollDraggableState$drag$2(ScrollDraggableState scrollDraggableState, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ScrollDraggableState$drag$2> continuation) {
        super(2, continuation);
        this.f2140i = scrollDraggableState;
        this.f2141j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ScrollDraggableState$drag$2 scrollDraggableState$drag$2 = new ScrollDraggableState$drag$2(this.f2140i, this.f2141j, continuation);
        scrollDraggableState$drag$2.L$0 = obj;
        return scrollDraggableState$drag$2;
    }

    @Nullable
    public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ScrollDraggableState$drag$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2139h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f2140i.setLatestScrollScope((ScrollScope) this.L$0);
            Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.f2141j;
            ScrollDraggableState scrollDraggableState = this.f2140i;
            this.f2139h = 1;
            if (function2.invoke(scrollDraggableState, this) == coroutine_suspended) {
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
