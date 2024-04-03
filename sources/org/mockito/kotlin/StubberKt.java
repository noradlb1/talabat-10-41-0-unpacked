package org.mockito.kotlin;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Stubber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0010\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\n\u001a-\u0010\b\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\r\"\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\r\"\u00020\u0011¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u000f\u001a\u00020\u00012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013\u001a%\u0010\u0014\u001a\n \u0015*\u0004\u0018\u0001H\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0016\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"doAnswer", "Lorg/mockito/stubbing/Stubber;", "T", "answer", "Lkotlin/Function1;", "Lorg/mockito/invocation/InvocationOnMock;", "doCallRealMethod", "doNothing", "doReturn", "value", "", "toBeReturned", "toBeReturnedNext", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Lorg/mockito/stubbing/Stubber;", "doThrow", "toBeThrown", "", "([Ljava/lang/Throwable;)Lorg/mockito/stubbing/Stubber;", "Lkotlin/reflect/KClass;", "whenever", "kotlin.jvm.PlatformType", "mock", "(Lorg/mockito/stubbing/Stubber;Ljava/lang/Object;)Ljava/lang/Object;", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class StubberKt {
    @NotNull
    public static final <T> Stubber doAnswer(@NotNull Function1<? super InvocationOnMock, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "answer");
        Stubber doAnswer = Mockito.doAnswer(new StubberKt$doAnswer$1(function1));
        if (doAnswer == null) {
            Intrinsics.throwNpe();
        }
        return doAnswer;
    }

    @NotNull
    public static final Stubber doCallRealMethod() {
        Stubber doCallRealMethod = Mockito.doCallRealMethod();
        if (doCallRealMethod == null) {
            Intrinsics.throwNpe();
        }
        return doCallRealMethod;
    }

    @NotNull
    public static final Stubber doNothing() {
        Stubber doNothing = Mockito.doNothing();
        if (doNothing == null) {
            Intrinsics.throwNpe();
        }
        return doNothing;
    }

    @NotNull
    public static final Stubber doReturn(@Nullable Object obj) {
        Stubber doReturn = Mockito.doReturn(obj);
        if (doReturn == null) {
            Intrinsics.throwNpe();
        }
        return doReturn;
    }

    @NotNull
    public static final Stubber doThrow(@NotNull KClass<? extends Throwable> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "toBeThrown");
        Stubber doThrow = Mockito.doThrow(JvmClassMappingKt.getJavaClass(kClass));
        if (doThrow == null) {
            Intrinsics.throwNpe();
        }
        return doThrow;
    }

    public static final <T> T whenever(@NotNull Stubber stubber, T t11) {
        Intrinsics.checkParameterIsNotNull(stubber, "$this$whenever");
        return stubber.when(t11);
    }

    @NotNull
    public static final Stubber doReturn(@Nullable Object obj, @NotNull Object... objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "toBeReturnedNext");
        Stubber doReturn = Mockito.doReturn(obj, Arrays.copyOf(objArr, objArr.length));
        if (doReturn == null) {
            Intrinsics.throwNpe();
        }
        return doReturn;
    }

    @NotNull
    public static final Stubber doThrow(@NotNull Throwable... thArr) {
        Intrinsics.checkParameterIsNotNull(thArr, "toBeThrown");
        Stubber doThrow = Mockito.doThrow((Throwable[]) Arrays.copyOf(thArr, thArr.length));
        if (doThrow == null) {
            Intrinsics.throwNpe();
        }
        return doThrow;
    }
}
