package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@"}, d2 = {"T", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
public final class UndispatchedContextCollector$emitRef$1 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26186h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26187i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f26188j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UndispatchedContextCollector$emitRef$1(FlowCollector<? super T> flowCollector, Continuation<? super UndispatchedContextCollector$emitRef$1> continuation) {
        super(2, continuation);
        this.f26188j = flowCollector;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UndispatchedContextCollector$emitRef$1 undispatchedContextCollector$emitRef$1 = new UndispatchedContextCollector$emitRef$1(this.f26188j, continuation);
        undispatchedContextCollector$emitRef$1.f26187i = obj;
        return undispatchedContextCollector$emitRef$1;
    }

    @Nullable
    public final Object invoke(T t11, @Nullable Continuation<? super Unit> continuation) {
        return ((UndispatchedContextCollector$emitRef$1) create(t11, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26186h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.f26187i;
            FlowCollector<T> flowCollector = this.f26188j;
            this.f26186h = 1;
            if (flowCollector.emit(obj2, this) == coroutine_suspended) {
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
