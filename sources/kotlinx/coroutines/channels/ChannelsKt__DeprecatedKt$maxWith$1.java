package kotlinx.coroutines.channels;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {420, 422}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "max"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class ChannelsKt__DeprecatedKt$maxWith$1<E> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25303h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25304i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25305j;

    /* renamed from: k  reason: collision with root package name */
    public Object f25306k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f25307l;

    /* renamed from: m  reason: collision with root package name */
    public int f25308m;

    public ChannelsKt__DeprecatedKt$maxWith$1(Continuation<? super ChannelsKt__DeprecatedKt$maxWith$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25307l = obj;
        this.f25308m |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.maxWith((ReceiveChannel) null, (Comparator) null, this);
    }
}
