package org.junit.jupiter.api;

import j$.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 18})
public final class AssertionsKt$sam$java_util_function_Supplier$0 implements Supplier {
    private final /* synthetic */ Function0 function;

    public AssertionsKt$sam$java_util_function_Supplier$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ Object get() {
        return this.function.invoke();
    }
}
