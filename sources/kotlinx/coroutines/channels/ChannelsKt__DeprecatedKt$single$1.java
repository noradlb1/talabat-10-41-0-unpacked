package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {136, 139}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class ChannelsKt__DeprecatedKt$single$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25321h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25322i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25323j;

    /* renamed from: k  reason: collision with root package name */
    public int f25324k;

    public ChannelsKt__DeprecatedKt$single$1(Continuation<? super ChannelsKt__DeprecatedKt$single$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25323j = obj;
        this.f25324k |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.single((ReceiveChannel) null, this);
    }
}
