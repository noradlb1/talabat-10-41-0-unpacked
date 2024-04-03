package androidx.compose.material.ripple;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.ripple.RippleAnimation", f = "RippleAnimation.kt", i = {0, 1}, l = {80, 82, 83}, m = "animate", n = {"this", "this"}, s = {"L$0", "L$0"})
public final class RippleAnimation$animate$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f6226h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f6227i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RippleAnimation f6228j;

    /* renamed from: k  reason: collision with root package name */
    public int f6229k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RippleAnimation$animate$1(RippleAnimation rippleAnimation, Continuation<? super RippleAnimation$animate$1> continuation) {
        super(continuation);
        this.f6228j = rippleAnimation;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f6227i = obj;
        this.f6229k |= Integer.MIN_VALUE;
        return this.f6228j.animate(this);
    }
}
