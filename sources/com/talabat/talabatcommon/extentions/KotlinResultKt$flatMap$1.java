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
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$flatMap$1", f = "KotlinResult.kt", i = {}, l = {98, 98, 98}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$flatMap$1 extends SuspendLambda implements Function1<Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f47004h;

    /* renamed from: i  reason: collision with root package name */
    public int f47005i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, Object> f47006j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47007k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$flatMap$1(Function2<? super T, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, ? extends Object> function2, Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Continuation<? super KotlinResultKt$flatMap$1> continuation) {
        super(1, continuation);
        this.f47006j = function2;
        this.f47007k = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$flatMap$1(this.f47006j, this.f47007k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super R> continuation) {
        return ((KotlinResultKt$flatMap$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A[PHI: r6 
      PHI: (r6v1 java.lang.Object) = (r6v4 java.lang.Object), (r6v0 java.lang.Object) binds: [B:17:0x0058, B:5:0x0011] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f47005i
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0029
            if (r1 == r4) goto L_0x0021
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005b
        L_0x0015:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x0021:
            java.lang.Object r1 = r5.f47004h
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003b
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends R>>, ? extends java.lang.Object>>, java.lang.Object> r1 = r5.f47006j
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, java.lang.Object> r6 = r5.f47007k
            r5.f47004h = r1
            r5.f47005i = r4
            java.lang.Object r6 = r6.invoke(r5)
            if (r6 != r0) goto L_0x003b
            return r0
        L_0x003b:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.m6338unboximpl()
            kotlin.ResultKt.throwOnFailure(r6)
            r4 = 0
            r5.f47004h = r4
            r5.f47005i = r3
            java.lang.Object r6 = r1.invoke(r6, r5)
            if (r6 != r0) goto L_0x0050
            return r0
        L_0x0050:
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5.f47005i = r2
            java.lang.Object r6 = com.talabat.talabatcommon.extentions.KotlinResultKt.getOrThrow(r6, r5)
            if (r6 != r0) goto L_0x005b
            return r0
        L_0x005b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt$flatMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
