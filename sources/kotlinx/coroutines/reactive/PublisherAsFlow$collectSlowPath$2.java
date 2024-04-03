package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H@"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherAsFlow$collectSlowPath$2", f = "ReactiveFlow.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class PublisherAsFlow$collectSlowPath$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26245h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f26246i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PublisherAsFlow<T> f26247j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublisherAsFlow$collectSlowPath$2(FlowCollector<? super T> flowCollector, PublisherAsFlow<T> publisherAsFlow, Continuation<? super PublisherAsFlow$collectSlowPath$2> continuation) {
        super(2, continuation);
        this.f26246i = flowCollector;
        this.f26247j = publisherAsFlow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PublisherAsFlow$collectSlowPath$2 publisherAsFlow$collectSlowPath$2 = new PublisherAsFlow$collectSlowPath$2(this.f26246i, this.f26247j, continuation);
        publisherAsFlow$collectSlowPath$2.L$0 = obj;
        return publisherAsFlow$collectSlowPath$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PublisherAsFlow$collectSlowPath$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26245h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector<T> flowCollector = this.f26246i;
            PublisherAsFlow<T> publisherAsFlow = this.f26247j;
            ReceiveChannel<T> produceImpl = publisherAsFlow.produceImpl(CoroutineScopeKt.plus((CoroutineScope) this.L$0, publisherAsFlow.context));
            this.f26245h = 1;
            if (FlowKt.emitAll(flowCollector, produceImpl, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
