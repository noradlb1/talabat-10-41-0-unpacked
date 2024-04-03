package io.reactivex.rxkotlin;

import io.reactivex.functions.Function8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0011\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u0003\"\b\b\u0005\u0010\b*\u00020\u0003\"\b\b\u0006\u0010\t*\u00020\u0003\"\b\b\u0007\u0010\n*\u00020\u0003\"\b\b\b\u0010\u0001*\u00020\u00032\u0006\u0010\u000b\u001a\u0002H\u00022\u0006\u0010\f\u001a\u0002H\u00042\u0006\u0010\r\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u0002H\u00062\u0006\u0010\u000f\u001a\u0002H\u00072\u0006\u0010\u0010\u001a\u0002H\b2\u0006\u0010\u0011\u001a\u0002H\t2\u0006\u0010\u0012\u001a\u0002H\nH\n¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"<anonymous>", "R", "T1", "", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class Flowables$combineLatest$9<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.functions.Function8 f23496a;

    public Flowables$combineLatest$9(kotlin.jvm.functions.Function8 function8) {
        this.f23496a = function8;
    }

    @NotNull
    public final R apply(@NotNull T1 t12, @NotNull T2 t22, @NotNull T3 t32, @NotNull T4 t42, @NotNull T5 t52, @NotNull T6 t62, @NotNull T7 t72, @NotNull T8 t82) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        Intrinsics.checkParameterIsNotNull(t32, "t3");
        Intrinsics.checkParameterIsNotNull(t42, "t4");
        Intrinsics.checkParameterIsNotNull(t52, "t5");
        T6 t63 = t62;
        Intrinsics.checkParameterIsNotNull(t63, "t6");
        T7 t73 = t72;
        Intrinsics.checkParameterIsNotNull(t73, "t7");
        T8 t83 = t82;
        Intrinsics.checkParameterIsNotNull(t83, "t8");
        return this.f23496a.invoke(t12, t22, t32, t42, t52, t63, t73, t83);
    }
}
