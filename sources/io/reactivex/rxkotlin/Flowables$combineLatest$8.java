package io.reactivex.rxkotlin;

import io.reactivex.functions.Function7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000f\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u0003\"\b\b\u0005\u0010\b*\u00020\u0003\"\b\b\u0006\u0010\t*\u00020\u0003\"\b\b\u0007\u0010\u0001*\u00020\u00032\u0006\u0010\n\u001a\u0002H\u00022\u0006\u0010\u000b\u001a\u0002H\u00042\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u0002H\u00062\u0006\u0010\u000e\u001a\u0002H\u00072\u0006\u0010\u000f\u001a\u0002H\b2\u0006\u0010\u0010\u001a\u0002H\tH\n¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"<anonymous>", "R", "T1", "", "T2", "T3", "T4", "T5", "T6", "T7", "t1", "t2", "t3", "t4", "t5", "t6", "t7", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class Flowables$combineLatest$8<T1, T2, T3, T4, T5, T6, T7, R> implements Function7<T1, T2, T3, T4, T5, T6, T7, R> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.functions.Function7 f23495a;

    public Flowables$combineLatest$8(kotlin.jvm.functions.Function7 function7) {
        this.f23495a = function7;
    }

    @NotNull
    public final R apply(@NotNull T1 t12, @NotNull T2 t22, @NotNull T3 t32, @NotNull T4 t42, @NotNull T5 t52, @NotNull T6 t62, @NotNull T7 t72) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        Intrinsics.checkParameterIsNotNull(t32, "t3");
        Intrinsics.checkParameterIsNotNull(t42, "t4");
        Intrinsics.checkParameterIsNotNull(t52, "t5");
        Intrinsics.checkParameterIsNotNull(t62, "t6");
        T7 t73 = t72;
        Intrinsics.checkParameterIsNotNull(t73, "t7");
        return this.f23495a.invoke(t12, t22, t32, t42, t52, t62, t73);
    }
}
