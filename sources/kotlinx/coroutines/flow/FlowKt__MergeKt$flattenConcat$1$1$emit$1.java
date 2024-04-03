package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$1$1", f = "Merge.kt", i = {}, l = {80}, m = "emit", n = {}, s = {})
public final class FlowKt__MergeKt$flattenConcat$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25737h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowKt__MergeKt$flattenConcat$1$1<T> f25738i;

    /* renamed from: j  reason: collision with root package name */
    public int f25739j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__MergeKt$flattenConcat$1$1$emit$1(FlowKt__MergeKt$flattenConcat$1$1<? super T> flowKt__MergeKt$flattenConcat$1$1, Continuation<? super FlowKt__MergeKt$flattenConcat$1$1$emit$1> continuation) {
        super(continuation);
        this.f25738i = flowKt__MergeKt$flattenConcat$1$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25737h = obj;
        this.f25739j |= Integer.MIN_VALUE;
        return this.f25738i.emit((Flow) null, (Continuation<? super Unit>) this);
    }
}
