package coil.transition;

import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.transition.CrossfadeTransition", f = "CrossfadeTransition.kt", i = {0, 0, 0, 0}, l = {98}, m = "transition", n = {"this", "target", "result", "outerCrossfade"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class CrossfadeTransition$transition$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39805h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39806i;

    /* renamed from: j  reason: collision with root package name */
    public Object f39807j;

    /* renamed from: k  reason: collision with root package name */
    public Object f39808k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f39809l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ CrossfadeTransition f39810m;

    /* renamed from: n  reason: collision with root package name */
    public int f39811n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CrossfadeTransition$transition$1(CrossfadeTransition crossfadeTransition, Continuation<? super CrossfadeTransition$transition$1> continuation) {
        super(continuation);
        this.f39810m = crossfadeTransition;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39809l = obj;
        this.f39811n |= Integer.MIN_VALUE;
        return this.f39810m.transition((TransitionTarget) null, (ImageResult) null, this);
    }
}
