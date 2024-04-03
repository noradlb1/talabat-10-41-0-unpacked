package kotlinx.coroutines.channels;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {434, 436}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class ChannelsKt__DeprecatedKt$minWith$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25309h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25310i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25311j;

    /* renamed from: k  reason: collision with root package name */
    public Object f25312k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f25313l;

    /* renamed from: m  reason: collision with root package name */
    public int f25314m;

    public ChannelsKt__DeprecatedKt$minWith$1(Continuation<? super ChannelsKt__DeprecatedKt$minWith$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25313l = obj;
        this.f25314m |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.minWith((ReceiveChannel) null, (Comparator) null, this);
    }
}
