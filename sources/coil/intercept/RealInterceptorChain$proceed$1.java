package coil.intercept;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", i = {0, 0}, l = {27}, m = "proceed", n = {"this", "interceptor"}, s = {"L$0", "L$1"})
public final class RealInterceptorChain$proceed$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39753h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39754i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f39755j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ RealInterceptorChain f39756k;

    /* renamed from: l  reason: collision with root package name */
    public int f39757l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealInterceptorChain$proceed$1(RealInterceptorChain realInterceptorChain, Continuation<? super RealInterceptorChain$proceed$1> continuation) {
        super(continuation);
        this.f39756k = realInterceptorChain;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39755j = obj;
        this.f39757l |= Integer.MIN_VALUE;
        return this.f39756k.proceed((ImageRequest) null, this);
    }
}
