package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.PausableMonotonicFrameClock", f = "PausableMonotonicFrameClock.kt", i = {0, 0}, l = {62, 63}, m = "withFrameNanos", n = {"this", "onFrame"}, s = {"L$0", "L$1"})
public final class PausableMonotonicFrameClock$withFrameNanos$1<R> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f9141h;

    /* renamed from: i  reason: collision with root package name */
    public Object f9142i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9143j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PausableMonotonicFrameClock f9144k;

    /* renamed from: l  reason: collision with root package name */
    public int f9145l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PausableMonotonicFrameClock$withFrameNanos$1(PausableMonotonicFrameClock pausableMonotonicFrameClock, Continuation<? super PausableMonotonicFrameClock$withFrameNanos$1> continuation) {
        super(continuation);
        this.f9144k = pausableMonotonicFrameClock;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9143j = obj;
        this.f9145l |= Integer.MIN_VALUE;
        return this.f9144k.withFrameNanos((Function1) null, this);
    }
}
