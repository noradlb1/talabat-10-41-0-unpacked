package org.junit.jupiter.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.junit.jupiter.api.function.Executable;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 18})
public final class AssertionsKt$sam$org_junit_jupiter_api_function_Executable$0 implements Executable {
    private final /* synthetic */ Function0 function;

    public AssertionsKt$sam$org_junit_jupiter_api_function_Executable$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void execute() {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(), "invoke(...)");
    }
}
