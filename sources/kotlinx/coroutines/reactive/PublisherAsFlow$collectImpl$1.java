package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherAsFlow", f = "ReactiveFlow.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {98, 100}, m = "collectImpl", n = {"this", "collector", "subscriber", "consumed", "this", "collector", "subscriber", "consumed"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"})
public final class PublisherAsFlow$collectImpl$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26238h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26239i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26240j;

    /* renamed from: k  reason: collision with root package name */
    public long f26241k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f26242l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ PublisherAsFlow<T> f26243m;

    /* renamed from: n  reason: collision with root package name */
    public int f26244n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublisherAsFlow$collectImpl$1(PublisherAsFlow<T> publisherAsFlow, Continuation<? super PublisherAsFlow$collectImpl$1> continuation) {
        super(continuation);
        this.f26243m = publisherAsFlow;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26242l = obj;
        this.f26244n |= Integer.MIN_VALUE;
        return this.f26243m.collectImpl((CoroutineContext) null, (FlowCollector) null, this);
    }
}
