package org.mockito.kotlin;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "it", "Lorg/mockito/invocation/InvocationOnMock;", "kotlin.jvm.PlatformType", "answer", "(Lorg/mockito/invocation/InvocationOnMock;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class StubberKt$doAnswer$1<T> implements Answer<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f63286b;

    public StubberKt$doAnswer$1(Function1 function1) {
        this.f63286b = function1;
    }

    @Nullable
    public final T answer(InvocationOnMock invocationOnMock) {
        Function1 function1 = this.f63286b;
        Intrinsics.checkExpressionValueIsNotNull(invocationOnMock, "it");
        return function1.invoke(invocationOnMock);
    }
}
