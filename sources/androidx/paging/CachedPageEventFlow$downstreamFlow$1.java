package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1", f = "CachedPageEventFlow.kt", i = {0}, l = {83, 117}, m = "invokeSuspend", n = {"$this$simpleChannelFlow"}, s = {"L$0"})
public final class CachedPageEventFlow$downstreamFlow$1 extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<T>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36486h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CachedPageEventFlow f36487i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CachedPageEventFlow$downstreamFlow$1(CachedPageEventFlow cachedPageEventFlow, Continuation continuation) {
        super(2, continuation);
        this.f36487i = cachedPageEventFlow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        CachedPageEventFlow$downstreamFlow$1 cachedPageEventFlow$downstreamFlow$1 = new CachedPageEventFlow$downstreamFlow$1(this.f36487i, continuation);
        cachedPageEventFlow$downstreamFlow$1.L$0 = obj;
        return cachedPageEventFlow$downstreamFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CachedPageEventFlow$downstreamFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        SimpleProducerScope simpleProducerScope;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36486h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            simpleProducerScope = (SimpleProducerScope) this.L$0;
            FlattenedPageController access$getPageController$p = this.f36487i.pageController;
            this.L$0 = simpleProducerScope;
            this.f36486h = 1;
            obj2 = access$getPageController$p.createTemporaryDownstream(this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            simpleProducerScope = (SimpleProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SimpleProducerScope simpleProducerScope2 = simpleProducerScope;
        TemporaryDownstream temporaryDownstream = (TemporaryDownstream) obj2;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Integer.MIN_VALUE;
        Job launch$default = BuildersKt__Builders_commonKt.launch$default(simpleProducerScope2, (CoroutineContext) null, (CoroutineStart) null, new CachedPageEventFlow$downstreamFlow$1$historyCollection$1(simpleProducerScope2, temporaryDownstream, intRef, (Continuation) null), 3, (Object) null);
        Job[] jobArr = {BuildersKt__Builders_commonKt.launch$default(simpleProducerScope2, (CoroutineContext) null, (CoroutineStart) null, new CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1(this, simpleProducerScope2, temporaryDownstream, launch$default, intRef, (Continuation) null), 3, (Object) null), launch$default};
        this.L$0 = null;
        this.f36486h = 2;
        if (AwaitKt.joinAll(jobArr, (Continuation<? super Unit>) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
