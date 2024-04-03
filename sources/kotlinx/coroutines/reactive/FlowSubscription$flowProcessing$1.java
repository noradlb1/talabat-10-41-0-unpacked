package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.FlowSubscription", f = "ReactiveFlow.kt", i = {0}, l = {209}, m = "flowProcessing", n = {"this"}, s = {"L$0"})
public final class FlowSubscription$flowProcessing$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26233h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26234i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlowSubscription<T> f26235j;

    /* renamed from: k  reason: collision with root package name */
    public int f26236k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowSubscription$flowProcessing$1(FlowSubscription<T> flowSubscription, Continuation<? super FlowSubscription$flowProcessing$1> continuation) {
        super(continuation);
        this.f26235j = flowSubscription;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26234i = obj;
        this.f26236k |= Integer.MIN_VALUE;
        return this.f26235j.flowProcessing(this);
    }
}
