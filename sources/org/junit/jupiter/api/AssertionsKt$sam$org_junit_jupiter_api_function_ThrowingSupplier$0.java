package org.junit.jupiter.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.junit.jupiter.api.function.ThrowingSupplier;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 18})
public final class AssertionsKt$sam$org_junit_jupiter_api_function_ThrowingSupplier$0 implements ThrowingSupplier {
    private final /* synthetic */ Function0 function;

    public AssertionsKt$sam$org_junit_jupiter_api_function_ThrowingSupplier$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ Object get() {
        return this.function.invoke();
    }
}
