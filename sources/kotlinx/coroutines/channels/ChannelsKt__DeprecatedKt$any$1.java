package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {404}, m = "any", n = {"$this$consume$iv"}, s = {"L$0"})
public final class ChannelsKt__DeprecatedKt$any$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25189h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25190i;

    /* renamed from: j  reason: collision with root package name */
    public int f25191j;

    public ChannelsKt__DeprecatedKt$any$1(Continuation<? super ChannelsKt__DeprecatedKt$any$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25190i = obj;
        this.f25191j |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.any((ReceiveChannel) null, this);
    }
}
