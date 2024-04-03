package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {104}, m = "consumeEach", n = {"action", "$this$consume$iv"}, s = {"L$0", "L$1"})
public final class ChannelsKt__Channels_commonKt$consumeEach$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25173h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25174i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25175j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25176k;

    /* renamed from: l  reason: collision with root package name */
    public int f25177l;

    public ChannelsKt__Channels_commonKt$consumeEach$1(Continuation<? super ChannelsKt__Channels_commonKt$consumeEach$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25176k = obj;
        this.f25177l |= Integer.MIN_VALUE;
        return ChannelsKt__Channels_commonKt.consumeEach((ReceiveChannel) null, (Function1) null, (Continuation<? super Unit>) this);
    }
}
