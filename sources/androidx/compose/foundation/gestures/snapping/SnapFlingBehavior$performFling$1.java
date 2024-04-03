package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", i = {}, l = {89, 91}, m = "performFling", n = {}, s = {})
public final class SnapFlingBehavior$performFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f2380h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SnapFlingBehavior f2381i;

    /* renamed from: j  reason: collision with root package name */
    public int f2382j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapFlingBehavior$performFling$1(SnapFlingBehavior snapFlingBehavior, Continuation<? super SnapFlingBehavior$performFling$1> continuation) {
        super(continuation);
        this.f2381i = snapFlingBehavior;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2380h = obj;
        this.f2382j |= Integer.MIN_VALUE;
        return this.f2381i.performFling((ScrollScope) null, 0.0f, this);
    }
}
