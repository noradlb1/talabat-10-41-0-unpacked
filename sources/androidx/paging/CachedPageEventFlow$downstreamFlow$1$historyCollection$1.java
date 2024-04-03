package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$historyCollection$1", f = "CachedPageEventFlow.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
public final class CachedPageEventFlow$downstreamFlow$1$historyCollection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36497h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SimpleProducerScope f36498i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TemporaryDownstream f36499j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f36500k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CachedPageEventFlow$downstreamFlow$1$historyCollection$1(SimpleProducerScope simpleProducerScope, TemporaryDownstream temporaryDownstream, Ref.IntRef intRef, Continuation continuation) {
        super(2, continuation);
        this.f36498i = simpleProducerScope;
        this.f36499j = temporaryDownstream;
        this.f36500k = intRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CachedPageEventFlow$downstreamFlow$1$historyCollection$1(this.f36498i, this.f36499j, this.f36500k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CachedPageEventFlow$downstreamFlow$1$historyCollection$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36497h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow consumeHistory = this.f36499j.consumeHistory();
            CachedPageEventFlow$downstreamFlow$1$historyCollection$1$invokeSuspend$$inlined$collect$1 cachedPageEventFlow$downstreamFlow$1$historyCollection$1$invokeSuspend$$inlined$collect$1 = new CachedPageEventFlow$downstreamFlow$1$historyCollection$1$invokeSuspend$$inlined$collect$1(this);
            this.f36497h = 1;
            if (consumeHistory.collect(cachedPageEventFlow$downstreamFlow$1$historyCollection$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
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
