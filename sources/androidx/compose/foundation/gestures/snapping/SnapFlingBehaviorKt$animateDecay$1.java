package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0}, l = {300}, m = "animateDecay", n = {"animationState"}, s = {"L$0"})
public final class SnapFlingBehaviorKt$animateDecay$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2383h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2384i;

    /* renamed from: j  reason: collision with root package name */
    public int f2385j;

    public SnapFlingBehaviorKt$animateDecay$1(Continuation<? super SnapFlingBehaviorKt$animateDecay$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2384i = obj;
        this.f2385j |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.animateDecay((ScrollScope) null, 0.0f, (AnimationState<Float, AnimationVector1D>) null, (DecayAnimationSpec<Float>) null, this);
    }
}
