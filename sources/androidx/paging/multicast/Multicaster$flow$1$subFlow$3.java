package androidx.paging.multicast;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.Multicaster$flow$1$subFlow$3", f = "Multicaster.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class Multicaster$flow$1$subFlow$3 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f37229h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Multicaster$flow$1 f37230i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Channel f37231j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Multicaster$flow$1$subFlow$3(Multicaster$flow$1 multicaster$flow$1, Channel channel, Continuation continuation) {
        super(3, continuation);
        this.f37230i = multicaster$flow$1;
        this.f37231j = channel;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super T> flowCollector, @Nullable Throwable th2, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNullParameter(flowCollector, "$this$create");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return new Multicaster$flow$1$subFlow$3(this.f37230i, this.f37231j, continuation);
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((Multicaster$flow$1$subFlow$3) create((FlowCollector) obj, (Throwable) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37229h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelManager access$getChannelManager$p = this.f37230i.f37225i.getChannelManager();
            Channel channel = this.f37231j;
            this.f37229h = 1;
            if (access$getChannelManager$p.removeDownstream(channel, this) == coroutine_suspended) {
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
