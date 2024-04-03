package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", i = {}, l = {409}, m = "collect", n = {}, s = {})
public final class SubscribedSharedFlow$collect$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f26073h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubscribedSharedFlow<T> f26074i;

    /* renamed from: j  reason: collision with root package name */
    public int f26075j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscribedSharedFlow$collect$1(SubscribedSharedFlow<T> subscribedSharedFlow, Continuation<? super SubscribedSharedFlow$collect$1> continuation) {
        super(continuation);
        this.f26074i = subscribedSharedFlow;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26073h = obj;
        this.f26075j |= Integer.MIN_VALUE;
        return this.f26074i.collect((FlowCollector) null, this);
    }
}
