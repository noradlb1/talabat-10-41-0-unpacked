package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"E", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__ChannelsKt$sendBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f25167h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SendChannel<E> f25168i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ E f25169j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__ChannelsKt$sendBlocking$1(SendChannel<? super E> sendChannel, E e11, Continuation<? super ChannelsKt__ChannelsKt$sendBlocking$1> continuation) {
        super(2, continuation);
        this.f25168i = sendChannel;
        this.f25169j = e11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChannelsKt__ChannelsKt$sendBlocking$1(this.f25168i, this.f25169j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__ChannelsKt$sendBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25167h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SendChannel<E> sendChannel = this.f25168i;
            E e11 = this.f25169j;
            this.f25167h = 1;
            if (sendChannel.send(e11, this) == coroutine_suspended) {
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
