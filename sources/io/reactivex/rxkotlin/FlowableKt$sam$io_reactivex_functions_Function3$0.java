package io.reactivex.rxkotlin;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function3;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
final class FlowableKt$sam$io_reactivex_functions_Function3$0 implements Function3 {
    private final /* synthetic */ kotlin.jvm.functions.Function3 function;

    public FlowableKt$sam$io_reactivex_functions_Function3$0(kotlin.jvm.functions.Function3 function3) {
        this.function = function3;
    }

    @NonNull
    public final /* synthetic */ Object apply(@NonNull Object obj, @NonNull Object obj2, @NonNull Object obj3) {
        return this.function.invoke(obj, obj2, obj3);
    }
}
