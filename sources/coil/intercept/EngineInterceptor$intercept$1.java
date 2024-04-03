package coil.intercept;

import coil.intercept.Interceptor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0}, l = {103}, m = "intercept", n = {"this", "chain"}, s = {"L$0", "L$1"})
public final class EngineInterceptor$intercept$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39729h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39730i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f39731j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f39732k;

    /* renamed from: l  reason: collision with root package name */
    public int f39733l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$intercept$1(EngineInterceptor engineInterceptor, Continuation<? super EngineInterceptor$intercept$1> continuation) {
        super(continuation);
        this.f39732k = engineInterceptor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39731j = obj;
        this.f39733l |= Integer.MIN_VALUE;
        return this.f39732k.intercept((Interceptor.Chain) null, this);
    }
}
