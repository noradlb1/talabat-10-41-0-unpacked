package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", i = {0}, l = {156}, m = "catchImpl", n = {"fromDownstream"}, s = {"L$0"})
public final class FlowKt__ErrorsKt$catchImpl$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25638h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25639i;

    /* renamed from: j  reason: collision with root package name */
    public int f25640j;

    public FlowKt__ErrorsKt$catchImpl$1(Continuation<? super FlowKt__ErrorsKt$catchImpl$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25639i = obj;
        this.f25640j |= Integer.MIN_VALUE;
        return FlowKt.catchImpl((Flow) null, (FlowCollector) null, this);
    }
}
