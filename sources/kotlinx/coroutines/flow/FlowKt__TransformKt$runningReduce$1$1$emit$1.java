package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1", f = "Transform.kt", i = {0}, l = {125, 127}, m = "emit", n = {"this"}, s = {"L$0"})
public final class FlowKt__TransformKt$runningReduce$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25931h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25932i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25933j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FlowKt__TransformKt$runningReduce$1$1<T> f25934k;

    /* renamed from: l  reason: collision with root package name */
    public int f25935l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__TransformKt$runningReduce$1$1$emit$1(FlowKt__TransformKt$runningReduce$1$1<? super T> flowKt__TransformKt$runningReduce$1$1, Continuation<? super FlowKt__TransformKt$runningReduce$1$1$emit$1> continuation) {
        super(continuation);
        this.f25934k = flowKt__TransformKt$runningReduce$1$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25933j = obj;
        this.f25935l |= Integer.MIN_VALUE;
        return this.f25934k.emit(null, this);
    }
}
