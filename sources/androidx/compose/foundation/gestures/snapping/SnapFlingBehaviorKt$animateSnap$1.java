package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0}, l = {330}, m = "animateSnap", n = {"animationState", "initialVelocity"}, s = {"L$0", "F$0"})
public final class SnapFlingBehaviorKt$animateSnap$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2389h;

    /* renamed from: i  reason: collision with root package name */
    public float f2390i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f2391j;

    /* renamed from: k  reason: collision with root package name */
    public int f2392k;

    public SnapFlingBehaviorKt$animateSnap$1(Continuation<? super SnapFlingBehaviorKt$animateSnap$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2391j = obj;
        this.f2392k |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.animateSnap((ScrollScope) null, 0.0f, 0.0f, (AnimationState<Float, AnimationVector1D>) null, (AnimationSpec<Float>) null, this);
    }
}
