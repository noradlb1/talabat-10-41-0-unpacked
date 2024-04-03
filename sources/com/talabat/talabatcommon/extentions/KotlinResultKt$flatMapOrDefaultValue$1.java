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

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0002\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H@"}, d2 = {"T", "R", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$flatMapOrDefaultValue$1", f = "KotlinResult.kt", i = {}, l = {150, 152, 152}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$flatMapOrDefaultValue$1 extends SuspendLambda implements Function1<Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f47018h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47019i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ R f47020j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, Object> f47021k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$flatMapOrDefaultValue$1(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, R r11, Function2<? super T, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, ? extends Object> function2, Continuation<? super KotlinResultKt$flatMapOrDefaultValue$1> continuation) {
        super(1, continuation);
        this.f47019i = function1;
        this.f47020j = r11;
        this.f47021k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$flatMapOrDefaultValue$1(this.f47019i, this.f47020j, this.f47021k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super R> continuation) {
        return ((KotlinResultKt$flatMapOrDefaultValue$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f47018h
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r4) goto L_0x0021
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0057
        L_0x0015:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004c
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0033
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, java.lang.Object> r6 = r5.f47019i
            r5.f47018h = r4
            java.lang.Object r6 = r6.invoke(r5)
            if (r6 != r0) goto L_0x0033
            return r0
        L_0x0033:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.m6338unboximpl()
            kotlin.ResultKt.throwOnFailure(r6)
            if (r6 != 0) goto L_0x0041
            R r6 = r5.f47020j
            goto L_0x005b
        L_0x0041:
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends R>>, ? extends java.lang.Object>>, java.lang.Object> r1 = r5.f47021k
            r5.f47018h = r3
            java.lang.Object r6 = r1.invoke(r6, r5)
            if (r6 != r0) goto L_0x004c
            return r0
        L_0x004c:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5.f47018h = r2
            java.lang.Object r6 = com.talabat.talabatcommon.extentions.KotlinResultKt.getOrThrow(r6, r5)
            if (r6 != r0) goto L_0x0057
            return r0
        L_0x0057:
            if (r6 != 0) goto L_0x005b
            R r6 = r5.f47020j
        L_0x005b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt$flatMapOrDefaultValue$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
