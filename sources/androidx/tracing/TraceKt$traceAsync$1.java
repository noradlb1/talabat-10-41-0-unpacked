package androidx.tracing;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "androidx.tracing.TraceKt", f = "Trace.kt", i = {0, 0}, l = {49}, m = "traceAsync", n = {"methodName", "cookie"}, s = {"L$0", "I$0"})
public final class TraceKt$traceAsync$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f37714h;

    /* renamed from: i  reason: collision with root package name */
    public int f37715i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f37716j;

    /* renamed from: k  reason: collision with root package name */
    public int f37717k;

    public TraceKt$traceAsync$1(Continuation<? super TraceKt$traceAsync$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37716j = obj;
        this.f37717k |= Integer.MIN_VALUE;
        return TraceKt.traceAsync((String) null, 0, (Function1) null, this);
    }
}
