package androidx.compose.material3;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SwipeableState", f = "Swipeable.kt", i = {1, 1, 1, 2, 2, 2}, l = {159, 183, 186}, m = "processNewAnchors$material3_release", n = {"this", "newAnchors", "targetOffset", "this", "newAnchors", "targetOffset"}, s = {"L$0", "L$1", "F$0", "L$0", "L$1", "F$0"})
public final class SwipeableState$processNewAnchors$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f8456h;

    /* renamed from: i  reason: collision with root package name */
    public Object f8457i;

    /* renamed from: j  reason: collision with root package name */
    public float f8458j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f8459k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8460l;

    /* renamed from: m  reason: collision with root package name */
    public int f8461m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$processNewAnchors$1(SwipeableState<T> swipeableState, Continuation<? super SwipeableState$processNewAnchors$1> continuation) {
        super(continuation);
        this.f8460l = swipeableState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f8459k = obj;
        this.f8461m |= Integer.MIN_VALUE;
        return this.f8460l.processNewAnchors$material3_release((Map) null, (Map) null, this);
    }
}
