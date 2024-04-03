package org.mockito.kotlin;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.mockito.BDDMockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.kotlin.internal.SuspendableAnswer;
import org.mockito.stubbing.Answer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\b\u001a\u0002H\u0002¢\u0006\u0002\u0010\t\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\fH\u0004\u001a5\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0004\u001a-\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0004\u001a/\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\f\u001aM\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\u0010\u000b\u001a \b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004H\u0004\u001a/\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001cH\u0004\u001aU\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001c2\"\u0010\u0012\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001c0\u001d\"\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001c¢\u0006\u0002\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"given", "Lorg/mockito/BDDMockito$BDDMyOngoingStubbing;", "T", "methodCall", "Lkotlin/Function0;", "(Ljava/lang/Object;)Lorg/mockito/BDDMockito$BDDMyOngoingStubbing;", "then", "Lorg/mockito/BDDMockito$Then;", "mock", "(Ljava/lang/Object;)Lorg/mockito/BDDMockito$Then;", "will", "value", "Lorg/mockito/stubbing/Answer;", "willAnswer", "Lkotlin/Function1;", "Lorg/mockito/invocation/InvocationOnMock;", "willReturn", "willReturnConsecutively", "ts", "", "willSuspendableAnswer", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lorg/mockito/BDDMockito$BDDMyOngoingStubbing;Lkotlin/jvm/functions/Function2;)Lorg/mockito/BDDMockito$BDDMyOngoingStubbing;", "willThrow", "", "t", "Lkotlin/reflect/KClass;", "", "(Lorg/mockito/BDDMockito$BDDMyOngoingStubbing;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;)Lorg/mockito/BDDMockito$BDDMyOngoingStubbing;", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class BDDMockitoKt {
    @NotNull
    public static final <T> BDDMockito.BDDMyOngoingStubbing<T> given(T t11) {
        BDDMockito.BDDMyOngoingStubbing<T> given = BDDMockito.given(t11);
        Intrinsics.checkExpressionValueIsNotNull(given, "BDDMockito.given(methodCall)");
        return given;
    }

    @NotNull
    public static final <T> BDDMockito.Then<T> then(T t11) {
        BDDMockito.Then<T> then = BDDMockito.then(t11);
        Intrinsics.checkExpressionValueIsNotNull(then, "BDDMockito.then(mock)");
        return then;
    }

    @NotNull
    public static final <T> BDDMockito.BDDMyOngoingStubbing<T> will(@NotNull BDDMockito.BDDMyOngoingStubbing<T> bDDMyOngoingStubbing, @NotNull Answer<T> answer) {
        Intrinsics.checkParameterIsNotNull(bDDMyOngoingStubbing, "$this$will");
        Intrinsics.checkParameterIsNotNull(answer, "value");
        BDDMockito.BDDMyOngoingStubbing<T> will = bDDMyOngoingStubbing.will(answer);
        Intrinsics.checkExpressionValueIsNotNull(will, "will(value)");
        return will;
    }

    @NotNull
    public static final <T> BDDMockito.BDDMyOngoingStubbing<T> willAnswer(@NotNull BDDMockito.BDDMyOngoingStubbing<T> bDDMyOngoingStubbing, @NotNull Function1<? super InvocationOnMock, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(bDDMyOngoingStubbing, "$this$willAnswer");
        Intrinsics.checkParameterIsNotNull(function1, "value");
        BDDMockito.BDDMyOngoingStubbing<T> willAnswer = bDDMyOngoingStubbing.willAnswer(new BDDMockitoKt$willAnswer$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(willAnswer, "willAnswer { value(it) }");
        return willAnswer;
    }

    @NotNull
    public static final <T> BDDMockito.BDDMyOngoingStubbing<T> willReturn(@NotNull BDDMockito.BDDMyOngoingStubbing<T> bDDMyOngoingStubbing, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(bDDMyOngoingStubbing, "$this$willReturn");
        Intrinsics.checkParameterIsNotNull(function0, "value");
        BDDMockito.BDDMyOngoingStubbing<T> willReturn = bDDMyOngoingStubbing.willReturn(function0.invoke());
        Intrinsics.checkExpressionValueIsNotNull(willReturn, "willReturn(value())");
        return willReturn;
    }

    @NotNull
    public static final /* synthetic */ <T> BDDMockito.BDDMyOngoingStubbing<T> willReturnConsecutively(@NotNull BDDMockito.BDDMyOngoingStubbing<T> bDDMyOngoingStubbing, @NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(bDDMyOngoingStubbing, "$this$willReturnConsecutively");
        Intrinsics.checkParameterIsNotNull(list, "ts");
        Object obj = list.get(0);
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] array = CollectionsKt___CollectionsKt.drop(list, 1).toArray(new Object[0]);
        if (array != null) {
            BDDMockito.BDDMyOngoingStubbing<T> willReturn = bDDMyOngoingStubbing.willReturn(obj, Arrays.copyOf(array, array.length));
            Intrinsics.checkExpressionValueIsNotNull(willReturn, "willReturn(\n          ts…p(1).toTypedArray()\n    )");
            return willReturn;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public static final <T> BDDMockito.BDDMyOngoingStubbing<T> willSuspendableAnswer(@NotNull BDDMockito.BDDMyOngoingStubbing<T> bDDMyOngoingStubbing, @NotNull Function2<? super InvocationOnMock, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(bDDMyOngoingStubbing, "$this$willSuspendableAnswer");
        Intrinsics.checkParameterIsNotNull(function2, "value");
        BDDMockito.BDDMyOngoingStubbing<T> willAnswer = bDDMyOngoingStubbing.willAnswer(new SuspendableAnswer(function2));
        Intrinsics.checkExpressionValueIsNotNull(willAnswer, "willAnswer(SuspendableAnswer(value))");
        return willAnswer;
    }

    @NotNull
    public static final <T> BDDMockito.BDDMyOngoingStubbing<T> willThrow(@NotNull BDDMockito.BDDMyOngoingStubbing<T> bDDMyOngoingStubbing, @NotNull Function0<? extends Throwable> function0) {
        Intrinsics.checkParameterIsNotNull(bDDMyOngoingStubbing, "$this$willThrow");
        Intrinsics.checkParameterIsNotNull(function0, "value");
        BDDMockito.BDDMyOngoingStubbing<T> willThrow = bDDMyOngoingStubbing.willThrow((Throwable) function0.invoke());
        Intrinsics.checkExpressionValueIsNotNull(willThrow, "willThrow(value())");
        return willThrow;
    }

    @NotNull
    public static final <T> BDDMockito.BDDMyOngoingStubbing<T> given(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "methodCall");
        return given(function0.invoke());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [kotlin.reflect.KClass, java.lang.Object, kotlin.reflect.KClass<? extends java.lang.Throwable>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> org.mockito.BDDMockito.BDDMyOngoingStubbing<T> willThrow(@org.jetbrains.annotations.NotNull org.mockito.BDDMockito.BDDMyOngoingStubbing<T> r1, @org.jetbrains.annotations.NotNull kotlin.reflect.KClass<? extends java.lang.Throwable> r2) {
        /*
            java.lang.String r0 = "$this$willThrow"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "t"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.Class r2 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r2)
            org.mockito.BDDMockito$BDDMyOngoingStubbing r1 = r1.willThrow((java.lang.Class<? extends java.lang.Throwable>) r2)
            java.lang.String r2 = "willThrow(t.java)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.kotlin.BDDMockitoKt.willThrow(org.mockito.BDDMockito$BDDMyOngoingStubbing, kotlin.reflect.KClass):org.mockito.BDDMockito$BDDMyOngoingStubbing");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [kotlin.reflect.KClass, java.lang.Object, kotlin.reflect.KClass<? extends java.lang.Throwable>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> org.mockito.BDDMockito.BDDMyOngoingStubbing<T> willThrow(@org.jetbrains.annotations.NotNull org.mockito.BDDMockito.BDDMyOngoingStubbing<T> r5, @org.jetbrains.annotations.NotNull kotlin.reflect.KClass<? extends java.lang.Throwable> r6, @org.jetbrains.annotations.NotNull kotlin.reflect.KClass<? extends java.lang.Throwable>... r7) {
        /*
            java.lang.String r0 = "$this$willThrow"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "t"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "ts"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.Class r6 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r6)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.length
            r0.<init>(r1)
            int r1 = r7.length
            r2 = 0
            r3 = r2
        L_0x001c:
            if (r3 >= r1) goto L_0x002a
            r4 = r7[r3]
            java.lang.Class r4 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r4)
            r0.add(r4)
            int r3 = r3 + 1
            goto L_0x001c
        L_0x002a:
            java.lang.Class[] r7 = new java.lang.Class[r2]
            java.lang.Object[] r7 = r0.toArray(r7)
            if (r7 == 0) goto L_0x0045
            java.lang.Class[] r7 = (java.lang.Class[]) r7
            int r0 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.lang.Class[] r7 = (java.lang.Class[]) r7
            org.mockito.BDDMockito$BDDMyOngoingStubbing r5 = r5.willThrow(r6, r7)
            java.lang.String r6 = "willThrow(t.java, *ts.ma…it.java }.toTypedArray())"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            return r5
        L_0x0045:
            kotlin.TypeCastException r5 = new kotlin.TypeCastException
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<T>"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.kotlin.BDDMockitoKt.willThrow(org.mockito.BDDMockito$BDDMyOngoingStubbing, kotlin.reflect.KClass, kotlin.reflect.KClass[]):org.mockito.BDDMockito$BDDMyOngoingStubbing");
    }
}
