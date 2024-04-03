package kotlinx.coroutines.channels;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toMap", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
public final class ChannelsKt__DeprecatedKt$toMap$2<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25349h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25350i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25351j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25352k;

    /* renamed from: l  reason: collision with root package name */
    public int f25353l;

    public ChannelsKt__DeprecatedKt$toMap$2(Continuation<? super ChannelsKt__DeprecatedKt$toMap$2> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25352k = obj;
        this.f25353l |= Integer.MIN_VALUE;
        return ChannelsKt.toMap((ReceiveChannel) null, null, this);
    }
}
