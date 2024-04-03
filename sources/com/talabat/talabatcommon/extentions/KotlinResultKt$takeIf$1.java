package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u0004\b\u00028\u0000\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$takeIf$1", f = "KotlinResult.kt", i = {1}, l = {63, 66}, m = "invokeSuspend", n = {"item"}, s = {"L$0"})
public final class KotlinResultKt$takeIf$1 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f47052h;

    /* renamed from: i  reason: collision with root package name */
    public int f47053i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47054j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> f47055k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$takeIf$1(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super KotlinResultKt$takeIf$1> continuation) {
        super(1, continuation);
        this.f47054j = function1;
        this.f47055k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$takeIf$1(this.f47054j, this.f47055k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super T> continuation) {
        return ((KotlinResultKt$takeIf$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f47053i
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            java.lang.Object r0 = r4.f47052h
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0048
        L_0x0014:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x002e
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, java.lang.Object> r5 = r4.f47054j
            r4.f47053i = r3
            java.lang.Object r5 = r5.invoke(r4)
            if (r5 != r0) goto L_0x002e
            return r0
        L_0x002e:
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.m6338unboximpl()
            kotlin.ResultKt.throwOnFailure(r5)
            if (r5 == 0) goto L_0x0054
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r1 = r4.f47055k
            r4.f47052h = r5
            r4.f47053i = r2
            java.lang.Object r1 = r1.invoke(r5, r4)
            if (r1 != r0) goto L_0x0046
            return r0
        L_0x0046:
            r0 = r5
            r5 = r1
        L_0x0048:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0051
            return r0
        L_0x0051:
            com.talabat.talabatcommon.extentions.NullValueInEitherException r5 = com.talabat.talabatcommon.extentions.NullValueInEitherException.INSTANCE
            throw r5
        L_0x0054:
            com.talabat.talabatcommon.extentions.NullValueInEitherException r5 = com.talabat.talabatcommon.extentions.NullValueInEitherException.INSTANCE
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt$takeIf$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
