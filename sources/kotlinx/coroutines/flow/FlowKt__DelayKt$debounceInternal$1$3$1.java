package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f25536h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f25537i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f25538j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$1(FlowCollector<? super T> flowCollector, Ref.ObjectRef<Object> objectRef, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$1> continuation) {
        super(1, continuation);
        this.f25537i = flowCollector;
        this.f25538j = objectRef;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.f25537i, this.f25538j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25536h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector<T> flowCollector = this.f25537i;
            T t11 = NullSurrogateKt.NULL;
            T t12 = this.f25538j.element;
            if (t12 == t11) {
                t12 = null;
            }
            this.f25536h = 1;
            if (flowCollector.emit(t12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f25538j.element = null;
        return Unit.INSTANCE;
    }
}
