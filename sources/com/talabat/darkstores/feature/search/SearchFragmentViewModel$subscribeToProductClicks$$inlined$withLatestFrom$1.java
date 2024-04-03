package com.talabat.darkstores.feature.search;

import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "R", "T", "", "U", "t", "u", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "io/reactivex/rxkotlin/ObservablesKt$withLatestFrom$1"}, k = 3, mv = {1, 6, 0})
public final class SearchFragmentViewModel$subscribeToProductClicks$$inlined$withLatestFrom$1<T1, T2, R> implements BiFunction<Pair<? extends Product, ? extends Integer>, String, R> {
    @NotNull
    public final R apply(@NotNull Pair<? extends Product, ? extends Integer> pair, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(pair, "t");
        Intrinsics.checkParameterIsNotNull(str, "u");
        Pair pair2 = pair;
        return new Triple((Product) pair2.component1(), Integer.valueOf(((Number) pair2.component2()).intValue()), str);
    }
}
