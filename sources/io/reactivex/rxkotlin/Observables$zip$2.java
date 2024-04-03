package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "T1", "T2", "", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 1, 15})
public final class Observables$zip$2<T1, T2, R> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
    public static final Observables$zip$2 INSTANCE = new Observables$zip$2();

    @NotNull
    public final Pair<T1, T2> apply(@NotNull T1 t12, @NotNull T2 t22) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        return TuplesKt.to(t12, t22);
    }
}
