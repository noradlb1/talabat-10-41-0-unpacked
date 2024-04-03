package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableState", f = "Swipeable.kt", i = {1, 1, 1, 2, 2, 2}, l = {159, 183, 186}, m = "processNewAnchors$material_release", n = {"this", "newAnchors", "targetOffset", "this", "newAnchors", "targetOffset"}, s = {"L$0", "L$1", "F$0", "L$0", "L$1", "F$0"})
public final class SwipeableState$processNewAnchors$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f5678h;

    /* renamed from: i  reason: collision with root package name */
    public Object f5679i;

    /* renamed from: j  reason: collision with root package name */
    public float f5680j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f5681k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f5682l;

    /* renamed from: m  reason: collision with root package name */
    public int f5683m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$processNewAnchors$1(SwipeableState<T> swipeableState, Continuation<? super SwipeableState$processNewAnchors$1> continuation) {
        super(continuation);
        this.f5682l = swipeableState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f5681k = obj;
        this.f5683m |= Integer.MIN_VALUE;
        return this.f5682l.processNewAnchors$material_release((Map) null, (Map) null, this);
    }
}
