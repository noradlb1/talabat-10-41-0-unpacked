package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic", f = "Scrollable.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4}, l = {421, 427, 429, 431, 437}, m = "onDragStopped-sF-c-tU", n = {"this", "availableVelocity", "this", "velocity", "this", "available", "this", "velocityLeft", "this"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0"})
public final class ScrollingLogic$onDragStopped$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2212h;

    /* renamed from: i  reason: collision with root package name */
    public long f2213i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f2214j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ScrollingLogic f2215k;

    /* renamed from: l  reason: collision with root package name */
    public int f2216l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onDragStopped$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$1> continuation) {
        super(continuation);
        this.f2215k = scrollingLogic;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2214j = obj;
        this.f2216l |= Integer.MIN_VALUE;
        return this.f2215k.m348onDragStoppedsFctU(0, this);
    }
}
