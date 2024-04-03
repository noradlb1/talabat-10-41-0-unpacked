package androidx.compose.material;

import androidx.compose.foundation.gestures.DragScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Landroidx/compose/foundation/gestures/DragScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.material.SwipeableState$snapInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SwipeableState$snapInternalToOffset$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f5684h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5685i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f5686j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$snapInternalToOffset$2(float f11, SwipeableState<T> swipeableState, Continuation<? super SwipeableState$snapInternalToOffset$2> continuation) {
        super(2, continuation);
        this.f5685i = f11;
        this.f5686j = swipeableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SwipeableState$snapInternalToOffset$2 swipeableState$snapInternalToOffset$2 = new SwipeableState$snapInternalToOffset$2(this.f5685i, this.f5686j, continuation);
        swipeableState$snapInternalToOffset$2.L$0 = obj;
        return swipeableState$snapInternalToOffset$2;
    }

    @Nullable
    public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SwipeableState$snapInternalToOffset$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f5684h == 0) {
            ResultKt.throwOnFailure(obj);
            ((DragScope) this.L$0).dragBy(this.f5685i - ((Number) this.f5686j.absoluteOffset.getValue()).floatValue());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
