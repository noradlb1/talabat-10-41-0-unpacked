package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {148}, m = "toList", n = {"$this$toList_u24lambda_u2d3", "$this$consume$iv$iv"}, s = {"L$1", "L$2"})
public final class ChannelsKt__Channels_commonKt$toList$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25183h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25184i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25185j;

    /* renamed from: k  reason: collision with root package name */
    public Object f25186k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f25187l;

    /* renamed from: m  reason: collision with root package name */
    public int f25188m;

    public ChannelsKt__Channels_commonKt$toList$1(Continuation<? super ChannelsKt__Channels_commonKt$toList$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25187l = obj;
        this.f25188m |= Integer.MIN_VALUE;
        return ChannelsKt.toList((ReceiveChannel) null, this);
    }
}
