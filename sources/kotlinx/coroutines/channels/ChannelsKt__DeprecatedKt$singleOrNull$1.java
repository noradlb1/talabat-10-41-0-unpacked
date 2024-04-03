package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {149, 152}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class ChannelsKt__DeprecatedKt$singleOrNull$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25325h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25326i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25327j;

    /* renamed from: k  reason: collision with root package name */
    public int f25328k;

    public ChannelsKt__DeprecatedKt$singleOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$singleOrNull$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25327j = obj;
        this.f25328k |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.singleOrNull((ReceiveChannel) null, this);
    }
}
