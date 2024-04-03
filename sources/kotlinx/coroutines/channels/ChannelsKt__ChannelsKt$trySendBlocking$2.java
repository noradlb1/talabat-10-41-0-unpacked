package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ChannelResult;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25170h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SendChannel<E> f25171i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ E f25172j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(SendChannel<? super E> sendChannel, E e11, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> continuation) {
        super(2, continuation);
        this.f25171i = sendChannel;
        this.f25172j = e11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.f25171i, this.f25172j, continuation);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ChannelResult<Unit>> continuation) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25170h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            SendChannel<E> sendChannel = this.f25171i;
            E e11 = this.f25172j;
            Result.Companion companion = Result.Companion;
            this.f25170h = 1;
            if (sendChannel.send(e11, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        if (Result.m6336isSuccessimpl(obj2)) {
            obj3 = ChannelResult.Companion.m7814successJP2dKIU(Unit.INSTANCE);
        } else {
            obj3 = ChannelResult.Companion.m7812closedJP2dKIU(Result.m6332exceptionOrNullimpl(obj2));
        }
        return ChannelResult.m7799boximpl(obj3);
    }
}
