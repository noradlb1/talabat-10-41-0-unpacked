package coil.memory;

import coil.request.SuccessResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.memory.PoolableTargetDelegate", f = "TargetDelegate.kt", i = {0, 0, 1, 1, 1, 1}, l = {228, 251}, m = "success", n = {"result", "eventListener$iv", "result", "this_$iv", "bitmap$iv", "eventListener$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
public final class PoolableTargetDelegate$success$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39774h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39775i;

    /* renamed from: j  reason: collision with root package name */
    public Object f39776j;

    /* renamed from: k  reason: collision with root package name */
    public Object f39777k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f39778l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ PoolableTargetDelegate f39779m;

    /* renamed from: n  reason: collision with root package name */
    public int f39780n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PoolableTargetDelegate$success$1(PoolableTargetDelegate poolableTargetDelegate, Continuation<? super PoolableTargetDelegate$success$1> continuation) {
        super(continuation);
        this.f39779m = poolableTargetDelegate;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39778l = obj;
        this.f39780n |= Integer.MIN_VALUE;
        return this.f39779m.success((SuccessResult) null, this);
    }
}
