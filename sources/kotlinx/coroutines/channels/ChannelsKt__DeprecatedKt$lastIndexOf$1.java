package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {487}, m = "lastIndexOf", n = {"element", "lastIndex", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class ChannelsKt__DeprecatedKt$lastIndexOf$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25278h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25279i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25280j;

    /* renamed from: k  reason: collision with root package name */
    public Object f25281k;

    /* renamed from: l  reason: collision with root package name */
    public Object f25282l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f25283m;

    /* renamed from: n  reason: collision with root package name */
    public int f25284n;

    public ChannelsKt__DeprecatedKt$lastIndexOf$1(Continuation<? super ChannelsKt__DeprecatedKt$lastIndexOf$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25283m = obj;
        this.f25284n |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.lastIndexOf((ReceiveChannel) null, (Object) null, this);
    }
}
