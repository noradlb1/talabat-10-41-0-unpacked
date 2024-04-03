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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {129}, m = "consumeEach", n = {"action", "channel$iv"}, s = {"L$0", "L$1"})
public final class ChannelsKt__Channels_commonKt$consumeEach$3<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25178h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25179i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25180j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25181k;

    /* renamed from: l  reason: collision with root package name */
    public int f25182l;

    public ChannelsKt__Channels_commonKt$consumeEach$3(Continuation<? super ChannelsKt__Channels_commonKt$consumeEach$3> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25181k = obj;
        this.f25182l |= Integer.MIN_VALUE;
        return ChannelsKt__Channels_commonKt.consumeEach((BroadcastChannel) null, (Function1) null, (Continuation<? super Unit>) this);
    }
}
