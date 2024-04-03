package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.reactive.ChannelKt", f = "Channel.kt", i = {0, 0}, l = {120}, m = "collect", n = {"action", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
public final class ChannelKt$collect$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26220h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26221i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26222j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f26223k;

    /* renamed from: l  reason: collision with root package name */
    public int f26224l;

    public ChannelKt$collect$1(Continuation<? super ChannelKt$collect$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26223k = obj;
        this.f26224l |= Integer.MIN_VALUE;
        return ChannelKt.collect((Publisher) null, (Function1) null, this);
    }
}
