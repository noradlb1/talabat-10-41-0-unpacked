package org.mockito.kotlin.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mockito.internal.invocation.InterceptedInvocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B.\u0012$\u0010\u0003\u001a \b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0017\u0010\n\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\fR1\u0010\u0003\u001a \b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lorg/mockito/kotlin/internal/SuspendableAnswer;", "T", "Lorg/mockito/stubbing/Answer;", "body", "Lkotlin/Function2;", "Lorg/mockito/invocation/InvocationOnMock;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "answer", "invocation", "(Lorg/mockito/invocation/InvocationOnMock;)Ljava/lang/Object;", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
public final class SuspendableAnswer<T> implements Answer<T> {
    private final Function2<InvocationOnMock, Continuation<? super T>, Object> body;

    public SuspendableAnswer(@NotNull Function2<? super InvocationOnMock, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "body");
        this.body = function2;
    }

    public T answer(@Nullable InvocationOnMock invocationOnMock) {
        if (invocationOnMock != null) {
            Object[] rawArguments = ((InterceptedInvocation) invocationOnMock).getRawArguments();
            Intrinsics.checkExpressionValueIsNotNull(rawArguments, "rawInvocation.rawArguments");
            Object last = ArraysKt___ArraysKt.last((T[]) rawArguments);
            if (last != null) {
                Continuation continuation = (Continuation) last;
                Function2<InvocationOnMock, Continuation<? super T>, Object> function2 = this.body;
                if (function2 != null) {
                    return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(invocationOnMock, continuation);
                }
                throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<T?>");
        }
        throw new TypeCastException("null cannot be cast to non-null type org.mockito.internal.invocation.InterceptedInvocation");
    }
}
