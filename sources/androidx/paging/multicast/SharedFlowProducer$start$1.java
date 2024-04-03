package androidx.paging.multicast;

import androidx.paging.multicast.ChannelManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.SharedFlowProducer$start$1", f = "SharedFlowProducer.kt", i = {}, l = {75, 80, 80}, m = "invokeSuspend", n = {}, s = {})
public final class SharedFlowProducer$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f37241h;

    /* renamed from: i  reason: collision with root package name */
    public int f37242i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SharedFlowProducer f37243j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedFlowProducer$start$1(SharedFlowProducer sharedFlowProducer, Continuation continuation) {
        super(2, continuation);
        this.f37243j = sharedFlowProducer;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SharedFlowProducer$start$1(this.f37243j, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SharedFlowProducer$start$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37242i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Job access$getCollectionJob$p = this.f37243j.collectionJob;
            this.f37242i = 1;
            if (access$getCollectionJob$p.join(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                try {
                    Function2 access$getSendUpsteamMessage$p = this.f37243j.sendUpsteamMessage;
                    ChannelManager.Message.Dispatch.UpstreamFinished upstreamFinished = new ChannelManager.Message.Dispatch.UpstreamFinished(this.f37243j);
                    this.f37241h = th3;
                    this.f37242i = 3;
                    if (access$getSendUpsteamMessage$p.invoke(upstreamFinished, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (ClosedSendChannelException unused) {
                }
                th2 = th3;
            }
        } else if (i11 == 2) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (ClosedSendChannelException unused2) {
            }
            return Unit.INSTANCE;
        } else if (i11 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            th2 = (Throwable) this.f37241h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (ClosedSendChannelException unused3) {
            }
            throw th2;
        }
        Function2 access$getSendUpsteamMessage$p2 = this.f37243j.sendUpsteamMessage;
        ChannelManager.Message.Dispatch.UpstreamFinished upstreamFinished2 = new ChannelManager.Message.Dispatch.UpstreamFinished(this.f37243j);
        this.f37242i = 2;
        if (access$getSendUpsteamMessage$p2.invoke(upstreamFinished2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
