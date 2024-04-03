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
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.Multicaster$flow$1$subFlow$1", f = "Multicaster.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
public final class Multicaster$flow$1$subFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super ChannelManager.Message.Dispatch.Value<T>>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f37226h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Multicaster$flow$1 f37227i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Channel f37228j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Multicaster$flow$1$subFlow$1(Multicaster$flow$1 multicaster$flow$1, Channel channel, Continuation continuation) {
        super(2, continuation);
        this.f37227i = multicaster$flow$1;
        this.f37228j = channel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new Multicaster$flow$1$subFlow$1(this.f37227i, this.f37228j, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Multicaster$flow$1$subFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37226h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelManager access$getChannelManager$p = this.f37227i.f37225i.getChannelManager();
            Channel channel = this.f37228j;
            this.f37226h = 1;
            if (access$getChannelManager$p.addDownstream(channel, this) == coroutine_suspended) {
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
