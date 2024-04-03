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

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$flatMapError$1", f = "KotlinResult.kt", i = {}, l = {161, 161, 161}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$flatMapError$1 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f47008h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47009i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Throwable, Continuation<? super Function1<? super Continuation<? super Result<? extends T>>, ? extends Object>>, Object> f47010j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$flatMapError$1(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Function2<? super Throwable, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends T>>, ? extends Object>>, ? extends Object> function2, Continuation<? super KotlinResultKt$flatMapError$1> continuation) {
        super(1, continuation);
        this.f47009i = function1;
        this.f47010j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$flatMapError$1(this.f47009i, this.f47010j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super T> continuation) {
        return ((KotlinResultKt$flatMapError$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056 A[PHI: r6 
      PHI: (r6v1 java.lang.Object) = (r6v4 java.lang.Object), (r6v7 java.lang.Object), (r6v0 java.lang.Object) binds: [B:19:0x0053, B:14:0x003f, B:5:0x0011] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f47008h
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r4) goto L_0x0021
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0056
        L_0x0015:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0033
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, java.lang.Object> r6 = r5.f47009i
            r5.f47008h = r4
            java.lang.Object r6 = r6.invoke(r5)
            if (r6 != r0) goto L_0x0033
            return r0
        L_0x0033:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.m6338unboximpl()
            kotlin.jvm.functions.Function2<java.lang.Throwable, kotlin.coroutines.Continuation<? super kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, ? extends java.lang.Object>>, java.lang.Object> r1 = r5.f47010j
            java.lang.Throwable r4 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r4 != 0) goto L_0x0042
            goto L_0x0056
        L_0x0042:
            r5.f47008h = r3
            java.lang.Object r6 = r1.invoke(r4, r5)
            if (r6 != r0) goto L_0x004b
            return r0
        L_0x004b:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5.f47008h = r2
            java.lang.Object r6 = com.talabat.talabatcommon.extentions.KotlinResultKt.getOrThrow(r6, r5)
            if (r6 != r0) goto L_0x0056
            return r0
        L_0x0056:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt$flatMapError$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
