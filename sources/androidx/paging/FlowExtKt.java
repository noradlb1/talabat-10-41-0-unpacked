package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001ah\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u000329\b\u0004\u0010\u0006\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\f\u001ab\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u000323\b\u0004\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\f\u001an\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00032F\u0010\u000f\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a|\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u0014\u001a\u0002H\u00042F\u0010\u000f\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001ap\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u00032B\u0010\u0006\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0017\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0002\b\u0019H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"NULL", "", "simpleFlatMapLatest", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "simpleMapLatest", "simpleRunningReduce", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleScan", "initial", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleTransformLatest", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "paging-common"}, k = 2, mv = {1, 4, 2})
public final class FlowExtKt {
    /* access modifiers changed from: private */
    public static final Object NULL = new Object();

    @NotNull
    public static final <T, R> Flow<R> simpleFlatMapLatest(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(flow, "$this$simpleFlatMapLatest");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return simpleTransformLatest(flow, new FlowExtKt$simpleFlatMapLatest$1(function2, (Continuation) null));
    }

    @NotNull
    public static final <T, R> Flow<R> simpleMapLatest(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(flow, "$this$simpleMapLatest");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return simpleTransformLatest(flow, new FlowExtKt$simpleMapLatest$1(function2, (Continuation) null));
    }

    @NotNull
    public static final <T> Flow<T> simpleRunningReduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(flow, "$this$simpleRunningReduce");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return FlowKt.flow(new FlowExtKt$simpleRunningReduce$1(flow, function3, (Continuation) null));
    }

    @NotNull
    public static final <T, R> Flow<R> simpleScan(@NotNull Flow<? extends T> flow, R r11, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(flow, "$this$simpleScan");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return FlowKt.flow(new FlowExtKt$simpleScan$1(flow, r11, function3, (Continuation) null));
    }

    @NotNull
    public static final <T, R> Flow<R> simpleTransformLatest(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(flow, "$this$simpleTransformLatest");
        Intrinsics.checkNotNullParameter(function3, "transform");
        return SimpleChannelFlowKt.simpleChannelFlow(new FlowExtKt$simpleTransformLatest$1(flow, function3, (Continuation) null));
    }
}
