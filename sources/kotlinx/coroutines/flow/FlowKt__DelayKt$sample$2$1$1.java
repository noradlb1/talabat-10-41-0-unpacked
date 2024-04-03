package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/channels/ChannelResult;", "", "result", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f25559h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25560i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f25561j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel<Unit> f25562k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> objectRef, ReceiveChannel<Unit> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.f25561j = objectRef;
        this.f25562k = receiveChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.f25561j, this.f25562k, continuation);
        flowKt__DelayKt$sample$2$1$1.f25560i = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m7828invokeWpGqRn0(((ChannelResult) obj).m7811unboximpl(), (Continuation) obj2);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m7828invokeWpGqRn0(@NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(ChannelResult.m7799boximpl(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f25559h == 0) {
            ResultKt.throwOnFailure(obj);
            T r42 = ((ChannelResult) this.f25560i).m7811unboximpl();
            Ref.ObjectRef<Object> objectRef = this.f25561j;
            boolean z11 = r42 instanceof ChannelResult.Failed;
            if (!z11) {
                objectRef.element = r42;
            }
            ReceiveChannel<Unit> receiveChannel = this.f25562k;
            if (z11) {
                Throwable r43 = ChannelResult.m7803exceptionOrNullimpl(r42);
                if (r43 == null) {
                    receiveChannel.cancel((CancellationException) new ChildCancelledException());
                    objectRef.element = NullSurrogateKt.DONE;
                } else {
                    throw r43;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
