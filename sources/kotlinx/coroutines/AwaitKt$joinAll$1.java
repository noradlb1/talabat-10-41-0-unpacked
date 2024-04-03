package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {54}, m = "joinAll", n = {"$this$forEach$iv"}, s = {"L$0"})
public final class AwaitKt$joinAll$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25111h;

    /* renamed from: i  reason: collision with root package name */
    public int f25112i;

    /* renamed from: j  reason: collision with root package name */
    public int f25113j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25114k;

    /* renamed from: l  reason: collision with root package name */
    public int f25115l;

    public AwaitKt$joinAll$1(Continuation<? super AwaitKt$joinAll$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25114k = obj;
        this.f25115l |= Integer.MIN_VALUE;
        return AwaitKt.joinAll((Job[]) null, (Continuation<? super Unit>) this);
    }
}
