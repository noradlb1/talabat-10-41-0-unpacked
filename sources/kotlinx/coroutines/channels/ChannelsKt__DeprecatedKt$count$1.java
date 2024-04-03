package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "count", n = {"count", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
public final class ChannelsKt__DeprecatedKt$count$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25194h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25195i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25196j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25197k;

    /* renamed from: l  reason: collision with root package name */
    public int f25198l;

    public ChannelsKt__DeprecatedKt$count$1(Continuation<? super ChannelsKt__DeprecatedKt$count$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25197k = obj;
        this.f25198l |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.count((ReceiveChannel) null, this);
    }
}
