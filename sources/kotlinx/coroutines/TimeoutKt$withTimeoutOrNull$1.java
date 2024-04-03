package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {100}, m = "withTimeoutOrNull", n = {"block", "coroutine", "timeMillis"}, s = {"L$0", "L$1", "J$0"})
public final class TimeoutKt$withTimeoutOrNull$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public long f25138h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25139i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25140j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25141k;

    /* renamed from: l  reason: collision with root package name */
    public int f25142l;

    public TimeoutKt$withTimeoutOrNull$1(Continuation<? super TimeoutKt$withTimeoutOrNull$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25141k = obj;
        this.f25142l |= Integer.MIN_VALUE;
        return TimeoutKt.withTimeoutOrNull(0, (Function2) null, this);
    }
}
