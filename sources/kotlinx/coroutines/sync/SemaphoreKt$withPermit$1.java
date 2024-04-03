package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {85}, m = "withPermit", n = {"$this$withPermit", "action"}, s = {"L$0", "L$1"})
public final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26383h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26384i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f26385j;

    /* renamed from: k  reason: collision with root package name */
    public int f26386k;

    public SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26385j = obj;
        this.f26386k |= Integer.MIN_VALUE;
        return SemaphoreKt.withPermit((Semaphore) null, (Function0) null, this);
    }
}
