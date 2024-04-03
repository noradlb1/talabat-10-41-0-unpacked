package org.mockito.kotlin;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.kotlin.internal.SuspendableAnswer;
import org.mockito.stubbing.OngoingStubbing;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007H\u0004\u001a+\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\tH\u0004\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002H\u0004¢\u0006\u0002\u0010\f\u001a=\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u00022\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u000e\"\u0002H\u0002¢\u0006\u0002\u0010\u000f\u001a/\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011H\f\u001aM\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\u0010\u0006\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a'\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0018H\u0004\u001a=\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00182\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u000e\"\u00020\u0018¢\u0006\u0002\u0010\u0019\u001a/\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001aH\u0004\u001aU\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001a2\"\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001a0\u000e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001a¢\u0006\u0002\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"whenever", "Lorg/mockito/stubbing/OngoingStubbing;", "T", "methodCall", "(Ljava/lang/Object;)Lorg/mockito/stubbing/OngoingStubbing;", "doAnswer", "answer", "Lkotlin/Function1;", "Lorg/mockito/invocation/InvocationOnMock;", "Lorg/mockito/stubbing/Answer;", "doReturn", "t", "(Lorg/mockito/stubbing/OngoingStubbing;Ljava/lang/Object;)Lorg/mockito/stubbing/OngoingStubbing;", "ts", "", "(Lorg/mockito/stubbing/OngoingStubbing;Ljava/lang/Object;[Ljava/lang/Object;)Lorg/mockito/stubbing/OngoingStubbing;", "doReturnConsecutively", "", "doSuspendableAnswer", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lorg/mockito/stubbing/OngoingStubbing;Lkotlin/jvm/functions/Function2;)Lorg/mockito/stubbing/OngoingStubbing;", "doThrow", "", "(Lorg/mockito/stubbing/OngoingStubbing;Ljava/lang/Throwable;[Ljava/lang/Throwable;)Lorg/mockito/stubbing/OngoingStubbing;", "Lkotlin/reflect/KClass;", "(Lorg/mockito/stubbing/OngoingStubbing;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;)Lorg/mockito/stubbing/OngoingStubbing;", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class OngoingStubbingKt {
    /* JADX WARNING: type inference failed for: r2v0, types: [org.mockito.stubbing.Answer, org.mockito.stubbing.Answer<?>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> org.mockito.stubbing.OngoingStubbing<T> doAnswer(@org.jetbrains.annotations.NotNull org.mockito.stubbing.OngoingStubbing<T> r1, @org.jetbrains.annotations.NotNull org.mockito.stubbing.Answer<?> r2) {
        /*
            java.lang.String r0 = "$this$doAnswer"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "answer"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            org.mockito.stubbing.OngoingStubbing r1 = r1.thenAnswer(r2)
            java.lang.String r2 = "thenAnswer(answer)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.kotlin.OngoingStubbingKt.doAnswer(org.mockito.stubbing.OngoingStubbing, org.mockito.stubbing.Answer):org.mockito.stubbing.OngoingStubbing");
    }

    @NotNull
    public static final <T> OngoingStubbing<T> doReturn(@NotNull OngoingStubbing<T> ongoingStubbing, T t11) {
        Intrinsics.checkParameterIsNotNull(ongoingStubbing, "$this$doReturn");
        OngoingStubbing<T> thenReturn = ongoingStubbing.thenReturn(t11);
        Intrinsics.checkExpressionValueIsNotNull(thenReturn, "thenReturn(t)");
        return thenReturn;
    }

    @NotNull
    public static final /* synthetic */ <T> OngoingStubbing<T> doReturnConsecutively(@NotNull OngoingStubbing<T> ongoingStubbing, @NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(ongoingStubbing, "$this$doReturnConsecutively");
        Intrinsics.checkParameterIsNotNull(list, "ts");
        Object obj = list.get(0);
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] array = CollectionsKt___CollectionsKt.drop(list, 1).toArray(new Object[0]);
        if (array != null) {
            OngoingStubbing<T> thenReturn = ongoingStubbing.thenReturn(obj, Arrays.copyOf(array, array.length));
            Intrinsics.checkExpressionValueIsNotNull(thenReturn, "thenReturn(\n          ts…p(1).toTypedArray()\n    )");
            return thenReturn;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public static final <T> OngoingStubbing<T> doSuspendableAnswer(@NotNull OngoingStubbing<T> ongoingStubbing, @NotNull Function2<? super InvocationOnMock, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(ongoingStubbing, "$this$doSuspendableAnswer");
        Intrinsics.checkParameterIsNotNull(function2, "answer");
        OngoingStubbing<T> thenAnswer = ongoingStubbing.thenAnswer(new SuspendableAnswer(function2));
        Intrinsics.checkExpressionValueIsNotNull(thenAnswer, "thenAnswer(SuspendableAnswer(answer))");
        return thenAnswer;
    }

    @NotNull
    public static final <T> OngoingStubbing<T> doThrow(@NotNull OngoingStubbing<T> ongoingStubbing, @NotNull Throwable th2) {
        Intrinsics.checkParameterIsNotNull(ongoingStubbing, "$this$doThrow");
        Intrinsics.checkParameterIsNotNull(th2, "t");
        OngoingStubbing<T> thenThrow = ongoingStubbing.thenThrow(th2);
        Intrinsics.checkExpressionValueIsNotNull(thenThrow, "thenThrow(t)");
        return thenThrow;
    }

    @NotNull
    public static final <T> OngoingStubbing<T> whenever(T t11) {
        OngoingStubbing<T> when = Mockito.when(t11);
        if (when == null) {
            Intrinsics.throwNpe();
        }
        return when;
    }

    @NotNull
    public static final <T> OngoingStubbing<T> doAnswer(@NotNull OngoingStubbing<T> ongoingStubbing, @NotNull Function1<? super InvocationOnMock, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(ongoingStubbing, "$this$doAnswer");
        Intrinsics.checkParameterIsNotNull(function1, "answer");
        OngoingStubbing<T> thenAnswer = ongoingStubbing.thenAnswer(new OngoingStubbingKt$sam$org_mockito_stubbing_Answer$0(function1));
        Intrinsics.checkExpressionValueIsNotNull(thenAnswer, "thenAnswer(answer)");
        return thenAnswer;
    }

    @NotNull
    public static final <T> OngoingStubbing<T> doReturn(@NotNull OngoingStubbing<T> ongoingStubbing, T t11, @NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(ongoingStubbing, "$this$doReturn");
        Intrinsics.checkParameterIsNotNull(tArr, "ts");
        OngoingStubbing<T> thenReturn = ongoingStubbing.thenReturn(t11, Arrays.copyOf(tArr, tArr.length));
        Intrinsics.checkExpressionValueIsNotNull(thenReturn, "thenReturn(t, *ts)");
        return thenReturn;
    }

    @NotNull
    public static final <T> OngoingStubbing<T> doThrow(@NotNull OngoingStubbing<T> ongoingStubbing, @NotNull Throwable th2, @NotNull Throwable... thArr) {
        Intrinsics.checkParameterIsNotNull(ongoingStubbing, "$this$doThrow");
        Intrinsics.checkParameterIsNotNull(th2, "t");
        Intrinsics.checkParameterIsNotNull(thArr, "ts");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(th2);
        spreadBuilder.addSpread(thArr);
        OngoingStubbing<T> thenThrow = ongoingStubbing.thenThrow((Throwable[]) spreadBuilder.toArray(new Throwable[spreadBuilder.size()]));
        Intrinsics.checkExpressionValueIsNotNull(thenThrow, "thenThrow(t, *ts)");
        return thenThrow;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [kotlin.reflect.KClass, java.lang.Object, kotlin.reflect.KClass<? extends java.lang.Throwable>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> org.mockito.stubbing.OngoingStubbing<T> doThrow(@org.jetbrains.annotations.NotNull org.mockito.stubbing.OngoingStubbing<T> r1, @org.jetbrains.annotations.NotNull kotlin.reflect.KClass<? extends java.lang.Throwable> r2) {
        /*
            java.lang.String r0 = "$this$doThrow"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "t"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.Class r2 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r2)
            org.mockito.stubbing.OngoingStubbing r1 = r1.thenThrow((java.lang.Class<? extends java.lang.Throwable>) r2)
            java.lang.String r2 = "thenThrow(t.java)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.kotlin.OngoingStubbingKt.doThrow(org.mockito.stubbing.OngoingStubbing, kotlin.reflect.KClass):org.mockito.stubbing.OngoingStubbing");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [kotlin.reflect.KClass, java.lang.Object, kotlin.reflect.KClass<? extends java.lang.Throwable>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> org.mockito.stubbing.OngoingStubbing<T> doThrow(@org.jetbrains.annotations.NotNull org.mockito.stubbing.OngoingStubbing<T> r5, @org.jetbrains.annotations.NotNull kotlin.reflect.KClass<? extends java.lang.Throwable> r6, @org.jetbrains.annotations.NotNull kotlin.reflect.KClass<? extends java.lang.Throwable>... r7) {
        /*
            java.lang.String r0 = "$this$doThrow"
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
            org.mockito.stubbing.OngoingStubbing r5 = r5.thenThrow(r6, r7)
            java.lang.String r6 = "thenThrow(t.java, *ts.ma…it.java }.toTypedArray())"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            return r5
        L_0x0045:
            kotlin.TypeCastException r5 = new kotlin.TypeCastException
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<T>"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.kotlin.OngoingStubbingKt.doThrow(org.mockito.stubbing.OngoingStubbing, kotlin.reflect.KClass, kotlin.reflect.KClass[]):org.mockito.stubbing.OngoingStubbing");
    }
}
