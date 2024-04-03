package org.mockito.kotlin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"verify", "", "T", "mock", "block", "Lkotlin/Function1;", "Lorg/mockito/kotlin/VerifyScope;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class VerifyScopeKt {
    public static final <T> void verify(T t11, @NotNull Function1<? super VerifyScope<? extends T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        function1.invoke(new VerifyScope(t11));
    }
}
