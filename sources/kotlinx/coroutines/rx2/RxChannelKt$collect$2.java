package kotlinx.coroutines.rx2;

import io.reactivex.ObservableSource;
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
public final class RxChannelKt$collect$2<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26298h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26299i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26300j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f26301k;

    /* renamed from: l  reason: collision with root package name */
    public int f26302l;

    public RxChannelKt$collect$2(Continuation<? super RxChannelKt$collect$2> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26301k = obj;
        this.f26302l |= Integer.MIN_VALUE;
        return RxChannelKt.collect((ObservableSource) null, (Function1) null, (Continuation<? super Unit>) this);
    }
}
