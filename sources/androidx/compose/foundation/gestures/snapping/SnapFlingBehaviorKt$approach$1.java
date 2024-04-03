package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0, 0, 0, 1, 1}, l = {216, 224}, m = "approach", n = {"$this$approach", "animation", "snapLayoutInfoProvider", "density", "remainingOffset", "currentHalfStep"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1"})
public final class SnapFlingBehaviorKt$approach$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2396h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2397i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2398j;

    /* renamed from: k  reason: collision with root package name */
    public Object f2399k;

    /* renamed from: l  reason: collision with root package name */
    public float f2400l;

    /* renamed from: m  reason: collision with root package name */
    public float f2401m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f2402n;

    /* renamed from: o  reason: collision with root package name */
    public int f2403o;

    public SnapFlingBehaviorKt$approach$1(Continuation<? super SnapFlingBehaviorKt$approach$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2402n = obj;
        this.f2403o |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.approach((ScrollScope) null, 0.0f, 0.0f, (ApproachAnimation<Float, AnimationVector1D>) null, (SnapLayoutInfoProvider) null, (Density) null, this);
    }
}
