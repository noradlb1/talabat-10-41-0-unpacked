package kotlinx.coroutines;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {}, l = {66}, m = "joinAll", n = {}, s = {})
public final class AwaitKt$joinAll$3 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25116h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25117i;

    /* renamed from: j  reason: collision with root package name */
    public int f25118j;

    public AwaitKt$joinAll$3(Continuation<? super AwaitKt$joinAll$3> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25117i = obj;
        this.f25118j |= Integer.MIN_VALUE;
        return AwaitKt.joinAll((Collection<? extends Job>) null, (Continuation<? super Unit>) this);
    }
}
