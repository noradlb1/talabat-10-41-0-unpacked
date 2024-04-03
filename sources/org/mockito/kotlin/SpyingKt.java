package org.mockito.kotlin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.mockito.Mockito;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003\u001a\u0019\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0004\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0005\u001aC\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0004\u001a\u0002H\u00012#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\b\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\b¢\u0006\u0002\u0010\u000b\u001a?\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\b\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"spy", "T", "", "()Ljava/lang/Object;", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "stubbing", "Lkotlin/Function2;", "Lorg/mockito/kotlin/KStubbing;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class SpyingKt {
    @NotNull
    public static final /* synthetic */ <T> T spy() {
        Intrinsics.reifiedOperationMarker(4, "T");
        T spy = Mockito.spy(Object.class);
        if (spy == null) {
            Intrinsics.throwNpe();
        }
        return spy;
    }

    @NotNull
    public static final /* synthetic */ <T> T spy(@NotNull Function2<? super KStubbing<? extends T>, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "stubbing");
        Intrinsics.reifiedOperationMarker(4, "T");
        T spy = Mockito.spy(Object.class);
        KStubbing kStubbing = new KStubbing(spy);
        Intrinsics.checkExpressionValueIsNotNull(spy, "this");
        function2.invoke(kStubbing, spy);
        if (spy == null) {
            Intrinsics.throwNpe();
        }
        return spy;
    }

    public static final <T> T spy(T t11) {
        T spy = Mockito.spy(t11);
        if (spy == null) {
            Intrinsics.throwNpe();
        }
        return spy;
    }

    public static final /* synthetic */ <T> T spy(T t11, @NotNull Function2<? super KStubbing<? extends T>, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "stubbing");
        T spy = spy(t11);
        function2.invoke(new KStubbing(spy), spy);
        if (spy == null) {
            Intrinsics.throwNpe();
        }
        return spy;
    }
}
