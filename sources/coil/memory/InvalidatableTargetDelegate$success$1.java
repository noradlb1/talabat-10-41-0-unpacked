package coil.memory;

import coil.request.SuccessResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.memory.InvalidatableTargetDelegate", f = "TargetDelegate.kt", i = {0, 0}, l = {228}, m = "success", n = {"result", "eventListener$iv"}, s = {"L$0", "L$1"})
public final class InvalidatableTargetDelegate$success$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39763h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39764i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f39765j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ InvalidatableTargetDelegate f39766k;

    /* renamed from: l  reason: collision with root package name */
    public int f39767l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidatableTargetDelegate$success$1(InvalidatableTargetDelegate invalidatableTargetDelegate, Continuation<? super InvalidatableTargetDelegate$success$1> continuation) {
        super(continuation);
        this.f39766k = invalidatableTargetDelegate;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39765j = obj;
        this.f39767l |= Integer.MIN_VALUE;
        return this.f39766k.success((SuccessResult) null, this);
    }
}
