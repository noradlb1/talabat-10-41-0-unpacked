package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", i = {0}, l = {158}, m = "emit", n = {"this"}, s = {"L$0"})
public final class FlowKt__ErrorsKt$catchImpl$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25643h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25644i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlowKt__ErrorsKt$catchImpl$2<T> f25645j;

    /* renamed from: k  reason: collision with root package name */
    public int f25646k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$catchImpl$2$emit$1(FlowKt__ErrorsKt$catchImpl$2<? super T> flowKt__ErrorsKt$catchImpl$2, Continuation<? super FlowKt__ErrorsKt$catchImpl$2$emit$1> continuation) {
        super(continuation);
        this.f25645j = flowKt__ErrorsKt$catchImpl$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25644i = obj;
        this.f25646k |= Integer.MIN_VALUE;
        return this.f25645j.emit(null, this);
    }
}
