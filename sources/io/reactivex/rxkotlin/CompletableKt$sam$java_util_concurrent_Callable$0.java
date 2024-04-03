package io.reactivex.rxkotlin;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
final class CompletableKt$sam$java_util_concurrent_Callable$0 implements Callable {
    private final /* synthetic */ Function0 function;

    public CompletableKt$sam$java_util_concurrent_Callable$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ Object call() {
        return this.function.invoke();
    }
}
