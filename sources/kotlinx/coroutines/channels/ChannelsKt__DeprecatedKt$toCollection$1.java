package kotlinx.coroutines.channels;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toCollection", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
public final class ChannelsKt__DeprecatedKt$toCollection$1<E, C extends Collection<? super E>> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25344h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25345i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25346j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25347k;

    /* renamed from: l  reason: collision with root package name */
    public int f25348l;

    public ChannelsKt__DeprecatedKt$toCollection$1(Continuation<? super ChannelsKt__DeprecatedKt$toCollection$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25347k = obj;
        this.f25348l |= Integer.MIN_VALUE;
        return ChannelsKt.toCollection((ReceiveChannel) null, null, this);
    }
}
