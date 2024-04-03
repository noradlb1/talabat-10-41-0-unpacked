package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.AwaitFirstLayoutModifier", f = "LazyListState.kt", i = {0, 0}, l = {432}, m = "waitForFirstLayout", n = {"this", "oldContinuation"}, s = {"L$0", "L$1"})
public final class AwaitFirstLayoutModifier$waitForFirstLayout$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2658h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2659i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f2660j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AwaitFirstLayoutModifier f2661k;

    /* renamed from: l  reason: collision with root package name */
    public int f2662l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitFirstLayoutModifier$waitForFirstLayout$1(AwaitFirstLayoutModifier awaitFirstLayoutModifier, Continuation<? super AwaitFirstLayoutModifier$waitForFirstLayout$1> continuation) {
        super(continuation);
        this.f2661k = awaitFirstLayoutModifier;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2660j = obj;
        this.f2662l |= Integer.MIN_VALUE;
        return this.f2661k.waitForFirstLayout(this);
    }
}
