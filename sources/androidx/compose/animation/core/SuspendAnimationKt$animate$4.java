package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.SuspendAnimationKt", f = "SuspendAnimation.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {233, 272}, m = "animate", n = {"$this$animate", "animation", "block", "lateInitScope", "$this$animate", "animation", "block", "lateInitScope"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
public final class SuspendAnimationKt$animate$4<T, V extends AnimationVector> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f1379h;

    /* renamed from: i  reason: collision with root package name */
    public Object f1380i;

    /* renamed from: j  reason: collision with root package name */
    public Object f1381j;

    /* renamed from: k  reason: collision with root package name */
    public Object f1382k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f1383l;

    /* renamed from: m  reason: collision with root package name */
    public int f1384m;

    public SuspendAnimationKt$animate$4(Continuation<? super SuspendAnimationKt$animate$4> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1383l = obj;
        this.f1384m |= Integer.MIN_VALUE;
        return SuspendAnimationKt.animate((AnimationState) null, (Animation) null, 0, (Function1) null, this);
    }
}
