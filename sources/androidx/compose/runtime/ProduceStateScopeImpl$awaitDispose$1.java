package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.ProduceStateScopeImpl", f = "ProduceState.kt", i = {0}, l = {227}, m = "awaitDispose", n = {"onDispose"}, s = {"L$0"})
public final class ProduceStateScopeImpl$awaitDispose$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f9147h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f9148i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ProduceStateScopeImpl<T> f9149j;

    /* renamed from: k  reason: collision with root package name */
    public int f9150k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProduceStateScopeImpl$awaitDispose$1(ProduceStateScopeImpl<T> produceStateScopeImpl, Continuation<? super ProduceStateScopeImpl$awaitDispose$1> continuation) {
        super(continuation);
        this.f9149j = produceStateScopeImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9148i = obj;
        this.f9150k |= Integer.MIN_VALUE;
        return this.f9149j.awaitDispose((Function0<Unit>) null, this);
    }
}
