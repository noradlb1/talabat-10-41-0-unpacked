package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0}, l = {56}, m = "callSuspend", n = {"$this$callSuspend", "args"}, s = {"L$0", "L$1"})
public final class KCallables$callSuspend$1<R> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f34524h;

    /* renamed from: i  reason: collision with root package name */
    public Object f34525i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f34526j;

    /* renamed from: k  reason: collision with root package name */
    public int f34527k;

    public KCallables$callSuspend$1(Continuation<? super KCallables$callSuspend$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f34526j = obj;
        this.f34527k |= Integer.MIN_VALUE;
        return KCallables.callSuspend((KCallable) null, (Object[]) null, this);
    }
}
