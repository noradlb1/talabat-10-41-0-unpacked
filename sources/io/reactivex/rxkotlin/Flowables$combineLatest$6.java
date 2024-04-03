package io.reactivex.rxkotlin;

import io.reactivex.functions.Function5;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u0003\"\b\b\u0005\u0010\u0001*\u00020\u00032\u0006\u0010\b\u001a\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u00042\u0006\u0010\n\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u00062\u0006\u0010\f\u001a\u0002H\u0007H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"<anonymous>", "R", "T1", "", "T2", "T3", "T4", "T5", "t1", "t2", "t3", "t4", "t5", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class Flowables$combineLatest$6<T1, T2, T3, T4, T5, R> implements Function5<T1, T2, T3, T4, T5, R> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.functions.Function5 f23493a;

    public Flowables$combineLatest$6(kotlin.jvm.functions.Function5 function5) {
        this.f23493a = function5;
    }

    @NotNull
    public final R apply(@NotNull T1 t12, @NotNull T2 t22, @NotNull T3 t32, @NotNull T4 t42, @NotNull T5 t52) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        Intrinsics.checkParameterIsNotNull(t32, "t3");
        Intrinsics.checkParameterIsNotNull(t42, "t4");
        Intrinsics.checkParameterIsNotNull(t52, "t5");
        return this.f23493a.invoke(t12, t22, t32, t42, t52);
    }
}
