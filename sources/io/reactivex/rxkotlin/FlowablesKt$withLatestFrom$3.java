package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\b\u001a\u0002H\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "R", "T", "", "T1", "T2", "t", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class FlowablesKt$withLatestFrom$3<T1, T2, T3, R> implements Function3<T, T1, T2, R> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.functions.Function3 f23507a;

    public FlowablesKt$withLatestFrom$3(kotlin.jvm.functions.Function3 function3) {
        this.f23507a = function3;
    }

    @NotNull
    public final R apply(@NotNull T t11, @NotNull T1 t12, @NotNull T2 t22) {
        Intrinsics.checkParameterIsNotNull(t11, "t");
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        return this.f23507a.invoke(t11, t12, t22);
    }
}
