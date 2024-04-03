package coil.memory;

import coil.request.ErrorResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.memory.InvalidatableTargetDelegate", f = "TargetDelegate.kt", i = {0, 0}, l = {225}, m = "error", n = {"result", "eventListener$iv"}, s = {"L$0", "L$1"})
public final class InvalidatableTargetDelegate$error$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39758h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39759i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f39760j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ InvalidatableTargetDelegate f39761k;

    /* renamed from: l  reason: collision with root package name */
    public int f39762l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidatableTargetDelegate$error$1(InvalidatableTargetDelegate invalidatableTargetDelegate, Continuation<? super InvalidatableTargetDelegate$error$1> continuation) {
        super(continuation);
        this.f39761k = invalidatableTargetDelegate;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39760j = obj;
        this.f39762l |= Integer.MIN_VALUE;
        return this.f39761k.error((ErrorResult) null, this);
    }
}
