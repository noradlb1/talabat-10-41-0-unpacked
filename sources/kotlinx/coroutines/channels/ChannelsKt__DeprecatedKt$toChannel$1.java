package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 278}, m = "toChannel", n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class ChannelsKt__DeprecatedKt$toChannel$1<E, C extends SendChannel<? super E>> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25339h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25340i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25341j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25342k;

    /* renamed from: l  reason: collision with root package name */
    public int f25343l;

    public ChannelsKt__DeprecatedKt$toChannel$1(Continuation<? super ChannelsKt__DeprecatedKt$toChannel$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25342k = obj;
        this.f25343l |= Integer.MIN_VALUE;
        return ChannelsKt.toChannel((ReceiveChannel) null, null, this);
    }
}
