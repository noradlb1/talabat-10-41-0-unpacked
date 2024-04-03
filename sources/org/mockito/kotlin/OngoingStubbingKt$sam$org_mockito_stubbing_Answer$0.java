package org.mockito.kotlin;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
final class OngoingStubbingKt$sam$org_mockito_stubbing_Answer$0 implements Answer {
    private final /* synthetic */ Function1 function;

    public OngoingStubbingKt$sam$org_mockito_stubbing_Answer$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ Object answer(InvocationOnMock invocationOnMock) {
        return this.function.invoke(invocationOnMock);
    }
}
