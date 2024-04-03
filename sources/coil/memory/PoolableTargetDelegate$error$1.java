package coil.memory;

import coil.request.ErrorResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.memory.PoolableTargetDelegate", f = "TargetDelegate.kt", i = {0, 0, 1, 1, 1}, l = {227, 240}, m = "error", n = {"result", "eventListener$iv", "result", "this_$iv", "eventListener$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class PoolableTargetDelegate$error$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39768h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39769i;

    /* renamed from: j  reason: collision with root package name */
    public Object f39770j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f39771k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ PoolableTargetDelegate f39772l;

    /* renamed from: m  reason: collision with root package name */
    public int f39773m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PoolableTargetDelegate$error$1(PoolableTargetDelegate poolableTargetDelegate, Continuation<? super PoolableTargetDelegate$error$1> continuation) {
        super(continuation);
        this.f39772l = poolableTargetDelegate;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39771k = obj;
        this.f39773m |= Integer.MIN_VALUE;
        return this.f39772l.error((ErrorResult) null, this);
    }
}
