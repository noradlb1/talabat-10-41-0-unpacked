package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", i = {0, 0}, l = {108, 110}, m = "longSnap", n = {"this", "$this$longSnap"}, s = {"L$0", "L$1"})
public final class SnapFlingBehavior$longSnap$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2375h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2376i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f2377j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SnapFlingBehavior f2378k;

    /* renamed from: l  reason: collision with root package name */
    public int f2379l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapFlingBehavior$longSnap$1(SnapFlingBehavior snapFlingBehavior, Continuation<? super SnapFlingBehavior$longSnap$1> continuation) {
        super(continuation);
        this.f2378k = snapFlingBehavior;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2377j = obj;
        this.f2379l |= Integer.MIN_VALUE;
        return this.f2378k.longSnap((ScrollScope) null, 0.0f, this);
    }
}
