package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", i = {0}, l = {103, 104}, m = "emit", n = {"this"}, s = {"L$0"})
public final class FlowKt__TransformKt$runningFold$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25923h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25924i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25925j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FlowKt__TransformKt$runningFold$1$1<T> f25926k;

    /* renamed from: l  reason: collision with root package name */
    public int f25927l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__TransformKt$runningFold$1$1$emit$1(FlowKt__TransformKt$runningFold$1$1<? super T> flowKt__TransformKt$runningFold$1$1, Continuation<? super FlowKt__TransformKt$runningFold$1$1$emit$1> continuation) {
        super(continuation);
        this.f25926k = flowKt__TransformKt$runningFold$1$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25925j = obj;
        this.f25927l |= Integer.MIN_VALUE;
        return this.f25926k.emit(null, this);
    }
}
