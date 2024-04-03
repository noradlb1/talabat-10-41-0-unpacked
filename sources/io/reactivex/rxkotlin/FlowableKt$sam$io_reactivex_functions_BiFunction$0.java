package io.reactivex.rxkotlin;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
final class FlowableKt$sam$io_reactivex_functions_BiFunction$0 implements BiFunction {
    private final /* synthetic */ Function2 function;

    public FlowableKt$sam$io_reactivex_functions_BiFunction$0(Function2 function2) {
        this.function = function2;
    }

    @NonNull
    public final /* synthetic */ Object apply(@NonNull Object obj, @NonNull Object obj2) {
        return this.function.invoke(obj, obj2);
    }
}
