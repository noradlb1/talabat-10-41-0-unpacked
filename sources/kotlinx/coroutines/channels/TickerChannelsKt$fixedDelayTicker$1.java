package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 1, 1, 2, 2}, l = {106, 108, 109}, m = "fixedDelayTicker", n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
public final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public long f25379h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25380i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25381j;

    /* renamed from: k  reason: collision with root package name */
    public int f25382k;

    public TickerChannelsKt$fixedDelayTicker$1(Continuation<? super TickerChannelsKt$fixedDelayTicker$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25381j = obj;
        this.f25382k |= Integer.MIN_VALUE;
        return TickerChannelsKt.fixedDelayTicker(0, 0, (SendChannel<? super Unit>) null, this);
    }
}
