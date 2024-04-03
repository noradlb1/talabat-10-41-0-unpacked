package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {447}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
public final class ChannelsKt__DeprecatedKt$none$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25315h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25316i;

    /* renamed from: j  reason: collision with root package name */
    public int f25317j;

    public ChannelsKt__DeprecatedKt$none$1(Continuation<? super ChannelsKt__DeprecatedKt$none$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25316i = obj;
        this.f25317j |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.none((ReceiveChannel) null, this);
    }
}
