package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005\"\b\b\u0002\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u0004H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "T1", "T2", "T3", "", "t1", "t2", "t3", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;"}, k = 3, mv = {1, 1, 15})
public final class Maybes$zip$4<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
    public static final Maybes$zip$4 INSTANCE = new Maybes$zip$4();

    @NotNull
    public final Triple<T1, T2, T3> apply(@NotNull T1 t12, @NotNull T2 t22, @NotNull T3 t32) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        Intrinsics.checkParameterIsNotNull(t32, "t3");
        return new Triple<>(t12, t22, t32);
    }
}
