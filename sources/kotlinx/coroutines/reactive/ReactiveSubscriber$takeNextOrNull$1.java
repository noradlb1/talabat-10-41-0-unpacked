package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.ReactiveSubscriber", f = "ReactiveFlow.kt", i = {}, l = {129}, m = "takeNextOrNull", n = {}, s = {})
public final class ReactiveSubscriber$takeNextOrNull$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f26261h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ReactiveSubscriber<T> f26262i;

    /* renamed from: j  reason: collision with root package name */
    public int f26263j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactiveSubscriber$takeNextOrNull$1(ReactiveSubscriber<T> reactiveSubscriber, Continuation<? super ReactiveSubscriber$takeNextOrNull$1> continuation) {
        super(continuation);
        this.f26262i = reactiveSubscriber;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26261h = obj;
        this.f26263j |= Integer.MIN_VALUE;
        return this.f26262i.takeNextOrNull(this);
    }
}
