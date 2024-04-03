package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {487}, m = "indexOf", n = {"element", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2"})
public final class ChannelsKt__DeprecatedKt$indexOf$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25267h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25268i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25269j;

    /* renamed from: k  reason: collision with root package name */
    public Object f25270k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f25271l;

    /* renamed from: m  reason: collision with root package name */
    public int f25272m;

    public ChannelsKt__DeprecatedKt$indexOf$1(Continuation<? super ChannelsKt__DeprecatedKt$indexOf$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25271l = obj;
        this.f25272m |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.indexOf((ReceiveChannel) null, (Object) null, this);
    }
}
