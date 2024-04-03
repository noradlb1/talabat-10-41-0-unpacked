package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"R", "E", "Lkotlinx/coroutines/channels/ChannelResult;", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1", f = "Channel.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
public final class ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1 extends SuspendLambda implements Function2<ChannelResult<? extends E>, Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f25374h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25375i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<E, Continuation<? super R>, Object> f25376j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1> continuation) {
        super(2, continuation);
        this.f25376j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1 receiveChannel$onReceiveOrNull$1$registerSelectClause1$1 = new ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(this.f25376j, continuation);
        receiveChannel$onReceiveOrNull$1$registerSelectClause1$1.f25375i = obj;
        return receiveChannel$onReceiveOrNull$1$registerSelectClause1$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m7819invokeWpGqRn0(((ChannelResult) obj).m7811unboximpl(), (Continuation) obj2);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m7819invokeWpGqRn0(@NotNull Object obj, @Nullable Continuation<? super R> continuation) {
        return ((ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1) create(ChannelResult.m7799boximpl(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25374h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Object r42 = ((ChannelResult) this.f25375i).m7811unboximpl();
            Throwable r12 = ChannelResult.m7803exceptionOrNullimpl(r42);
            if (r12 == null) {
                Function2<E, Continuation<? super R>, Object> function2 = this.f25376j;
                Object r43 = ChannelResult.m7804getOrNullimpl(r42);
                this.f25374h = 1;
                obj = function2.invoke(r43, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw r12;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
