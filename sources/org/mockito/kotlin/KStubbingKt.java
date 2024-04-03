package org.mockito.kotlin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022#\u0010\u0000\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\b¢\u0006\u0002\u0010\u0007\u001aA\u0010\b\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\t*\u0002H\u00022#\u0010\u0000\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\b¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"stubbing", "", "T", "mock", "Lkotlin/Function2;", "Lorg/mockito/kotlin/KStubbing;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "stub", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class KStubbingKt {
    @NotNull
    public static final <T> T stub(@NotNull T t11, @NotNull Function2<? super KStubbing<? extends T>, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(t11, "$this$stub");
        Intrinsics.checkParameterIsNotNull(function2, "stubbing");
        function2.invoke(new KStubbing(t11), t11);
        return t11;
    }

    public static final <T> void stubbing(T t11, @NotNull Function2<? super KStubbing<? extends T>, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "stubbing");
        function2.invoke(new KStubbing(t11), t11);
    }
}
