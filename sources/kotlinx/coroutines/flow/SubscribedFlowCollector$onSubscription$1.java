package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", i = {0, 0}, l = {419, 423}, m = "onSubscription", n = {"this", "safeCollector"}, s = {"L$0", "L$1"})
public final class SubscribedFlowCollector$onSubscription$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26068h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26069i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f26070j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SubscribedFlowCollector<T> f26071k;

    /* renamed from: l  reason: collision with root package name */
    public int f26072l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscribedFlowCollector$onSubscription$1(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super SubscribedFlowCollector$onSubscription$1> continuation) {
        super(continuation);
        this.f26071k = subscribedFlowCollector;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26070j = obj;
        this.f26072l |= Integer.MIN_VALUE;
        return this.f26071k.onSubscription(this);
    }
}
