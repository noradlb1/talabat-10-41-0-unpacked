package kotlinx.coroutines.rx2;

import io.reactivex.MaybeSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxChannelKt", f = "RxChannel.kt", i = {0, 0}, l = {104}, m = "collect", n = {"action", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
public final class RxChannelKt$collect$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26293h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26294i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26295j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f26296k;

    /* renamed from: l  reason: collision with root package name */
    public int f26297l;

    public RxChannelKt$collect$1(Continuation<? super RxChannelKt$collect$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26296k = obj;
        this.f26297l |= Integer.MIN_VALUE;
        return RxChannelKt.collect((MaybeSource) null, (Function1) null, (Continuation<? super Unit>) this);
    }
}
