package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {97, 100}, m = "last", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class ChannelsKt__DeprecatedKt$last$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25273h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25274i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25275j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25276k;

    /* renamed from: l  reason: collision with root package name */
    public int f25277l;

    public ChannelsKt__DeprecatedKt$last$1(Continuation<? super ChannelsKt__DeprecatedKt$last$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25276k = obj;
        this.f25277l |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.last((ReceiveChannel) null, this);
    }
}
