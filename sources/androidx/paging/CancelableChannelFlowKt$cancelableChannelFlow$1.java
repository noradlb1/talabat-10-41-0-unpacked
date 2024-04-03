package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Landroidx/paging/SimpleProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.CancelableChannelFlowKt$cancelableChannelFlow$1", f = "CancelableChannelFlow.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
public final class CancelableChannelFlowKt$cancelableChannelFlow$1 extends SuspendLambda implements Function2<SimpleProducerScope<T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36523h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Job f36524i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2 f36525j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancelableChannelFlowKt$cancelableChannelFlow$1(Job job, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f36524i = job;
        this.f36525j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        CancelableChannelFlowKt$cancelableChannelFlow$1 cancelableChannelFlowKt$cancelableChannelFlow$1 = new CancelableChannelFlowKt$cancelableChannelFlow$1(this.f36524i, this.f36525j, continuation);
        cancelableChannelFlowKt$cancelableChannelFlow$1.L$0 = obj;
        return cancelableChannelFlowKt$cancelableChannelFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CancelableChannelFlowKt$cancelableChannelFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36523h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            this.f36524i.invokeOnCompletion(new Function1<Throwable, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Throwable th2) {
                    SendChannel.DefaultImpls.close$default(simpleProducerScope, (Throwable) null, 1, (Object) null);
                }
            });
            Function2 function2 = this.f36525j;
            this.f36523h = 1;
            if (function2.invoke(simpleProducerScope, this) == coroutine_suspended) {
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
