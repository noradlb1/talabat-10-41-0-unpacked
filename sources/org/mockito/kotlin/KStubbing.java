package org.mockito.kotlin;

import com.apptimize.c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.mockito.Mockito;
import org.mockito.kotlin.internal.CreateInstanceKt;
import org.mockito.stubbing.OngoingStubbing;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n¢\u0006\u0002\u0010\fJ+\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0001\u0010\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\r¢\u0006\u0002\b\u000eJ8\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0001\u0010\n\u0018\u0001*\u00020\u00022\u001b\b\b\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H\n0\r¢\u0006\u0002\b\u000eH\bJ?\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0001\u0010\n*\u00020\u00022\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H\n0\r¢\u0006\u0002\b\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\n0\u0011JW\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0001\u0010\u0001*\u00020\u0002\"\u0004\b\u0002\u0010\n*\b\u0012\u0004\u0012\u0002H\u00010\u00002'\u0010\u0013\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lorg/mockito/kotlin/KStubbing;", "T", "", "mock", "(Ljava/lang/Object;)V", "getMock", "()Ljava/lang/Object;", "Ljava/lang/Object;", "on", "Lorg/mockito/stubbing/OngoingStubbing;", "R", "methodCall", "(Ljava/lang/Object;)Lorg/mockito/stubbing/OngoingStubbing;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "onGeneric", "c", "Lkotlin/reflect/KClass;", "onBlocking", "m", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lorg/mockito/kotlin/KStubbing;Lkotlin/jvm/functions/Function2;)Lorg/mockito/stubbing/OngoingStubbing;", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
public final class KStubbing<T> {
    private final T mock;

    public KStubbing(T t11) {
        this.mock = t11;
    }

    public final T getMock() {
        return this.mock;
    }

    @NotNull
    public final <R> OngoingStubbing<R> on(R r11) {
        OngoingStubbing<R> when = Mockito.when(r11);
        Intrinsics.checkExpressionValueIsNotNull(when, "Mockito.`when`(methodCall)");
        return when;
    }

    @NotNull
    public final <T, R> OngoingStubbing<R> onBlocking(@NotNull KStubbing<? extends T> kStubbing, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(kStubbing, "$this$onBlocking");
        Intrinsics.checkParameterIsNotNull(function2, "m");
        Object runBlocking$default = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new KStubbing$onBlocking$1(kStubbing, function2, (Continuation) null), 1, (Object) null);
        Intrinsics.checkExpressionValueIsNotNull(runBlocking$default, "runBlocking { Mockito.`when`(mock.m()) }");
        return (OngoingStubbing) runBlocking$default;
    }

    @NotNull
    public final <R> OngoingStubbing<R> onGeneric(@NotNull Function1<? super T, ? extends R> function1, @NotNull KClass<R> kClass) {
        R r11;
        Intrinsics.checkParameterIsNotNull(function1, "methodCall");
        Intrinsics.checkParameterIsNotNull(kClass, c.f41585a);
        try {
            r11 = function1.invoke(this.mock);
        } catch (NullPointerException unused) {
            r11 = CreateInstanceKt.createInstance(kClass);
        }
        OngoingStubbing<R> when = Mockito.when(r11);
        Intrinsics.checkExpressionValueIsNotNull(when, "Mockito.`when`(r)");
        return when;
    }

    @NotNull
    public final <R> OngoingStubbing<R> on(@NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "methodCall");
        try {
            OngoingStubbing<R> when = Mockito.when(function1.invoke(this.mock));
            Intrinsics.checkExpressionValueIsNotNull(when, "Mockito.`when`(mock.methodCall())");
            return when;
        } catch (NullPointerException e11) {
            throw new MockitoKotlinException("NullPointerException thrown when stubbing.\nThis may be due to two reasons:\n\t- The method you're trying to stub threw an NPE: look at the stack trace below;\n\t- You're trying to stub a generic method: try `onGeneric` instead.", e11);
        }
    }

    @NotNull
    public final /* synthetic */ <R> OngoingStubbing<R> onGeneric(@NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "methodCall");
        Intrinsics.reifiedOperationMarker(4, "R");
        return onGeneric(function1, Reflection.getOrCreateKotlinClass(Object.class));
    }
}
