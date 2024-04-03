package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {53}, m = "elementAtOrNull", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
public final class ChannelsKt__DeprecatedKt$elementAtOrNull$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public int f25223h;

    /* renamed from: i  reason: collision with root package name */
    public int f25224i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25225j;

    /* renamed from: k  reason: collision with root package name */
    public Object f25226k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f25227l;

    /* renamed from: m  reason: collision with root package name */
    public int f25228m;

    public ChannelsKt__DeprecatedKt$elementAtOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAtOrNull$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25227l = obj;
        this.f25228m |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.elementAtOrNull((ReceiveChannel) null, 0, this);
    }
}
