package kotlin.reflect.full;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0, 0}, l = {74}, m = "callSuspendBy", n = {"$this$callSuspendBy", "args", "kCallable"}, s = {"L$0", "L$1", "L$2"})
public final class KCallables$callSuspendBy$1<R> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f34528h;

    /* renamed from: i  reason: collision with root package name */
    public Object f34529i;

    /* renamed from: j  reason: collision with root package name */
    public Object f34530j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f34531k;

    /* renamed from: l  reason: collision with root package name */
    public int f34532l;

    public KCallables$callSuspendBy$1(Continuation<? super KCallables$callSuspendBy$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f34531k = obj;
        this.f34532l |= Integer.MIN_VALUE;
        return KCallables.callSuspendBy((KCallable) null, (Map<KParameter, ? extends Object>) null, this);
    }
}
