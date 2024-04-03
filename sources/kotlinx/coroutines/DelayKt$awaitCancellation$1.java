package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", i = {}, l = {148}, m = "awaitCancellation", n = {}, s = {})
public final class DelayKt$awaitCancellation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25125h;

    /* renamed from: i  reason: collision with root package name */
    public int f25126i;

    public DelayKt$awaitCancellation$1(Continuation<? super DelayKt$awaitCancellation$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25125h = obj;
        this.f25126i |= Integer.MIN_VALUE;
        return DelayKt.awaitCancellation(this);
    }
}
