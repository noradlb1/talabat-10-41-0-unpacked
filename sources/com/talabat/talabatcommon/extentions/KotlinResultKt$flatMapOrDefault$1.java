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
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$flatMapOrDefault$1", f = "KotlinResult.kt", i = {}, l = {134, 135, 136, 136, 136}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$flatMapOrDefault$1 extends SuspendLambda implements Function1<Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f47014h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47015i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends R>>, Object> f47016j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, Object> f47017k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$flatMapOrDefault$1(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Function1<? super Continuation<? super Result<? extends R>>, ? extends Object> function12, Function2<? super T, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, ? extends Object> function2, Continuation<? super KotlinResultKt$flatMapOrDefault$1> continuation) {
        super(1, continuation);
        this.f47015i = function1;
        this.f47016j = function12;
        this.f47017k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$flatMapOrDefault$1(this.f47015i, this.f47016j, this.f47017k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super R> continuation) {
        return ((KotlinResultKt$flatMapOrDefault$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f47014h
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x002f
            if (r1 == r6) goto L_0x002b
            if (r1 == r5) goto L_0x0017
            if (r1 == r4) goto L_0x0027
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0076
        L_0x001b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0069
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005e
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003d
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, java.lang.Object> r8 = r7.f47015i
            r7.f47014h = r6
            java.lang.Object r8 = r8.invoke(r7)
            if (r8 != r0) goto L_0x003d
            return r0
        L_0x003d:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.m6338unboximpl()
            kotlin.ResultKt.throwOnFailure(r8)
            if (r8 != 0) goto L_0x0053
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends R>>, java.lang.Object> r8 = r7.f47016j
            r7.f47014h = r5
            java.lang.Object r8 = com.talabat.talabatcommon.extentions.KotlinResultKt.getOrThrow(r8, r7)
            if (r8 != r0) goto L_0x0076
            return r0
        L_0x0053:
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends R>>, ? extends java.lang.Object>>, java.lang.Object> r1 = r7.f47017k
            r7.f47014h = r4
            java.lang.Object r8 = r1.invoke(r8, r7)
            if (r8 != r0) goto L_0x005e
            return r0
        L_0x005e:
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r7.f47014h = r3
            java.lang.Object r8 = com.talabat.talabatcommon.extentions.KotlinResultKt.getOrThrow(r8, r7)
            if (r8 != r0) goto L_0x0069
            return r0
        L_0x0069:
            if (r8 != 0) goto L_0x0076
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends R>>, java.lang.Object> r8 = r7.f47016j
            r7.f47014h = r2
            java.lang.Object r8 = com.talabat.talabatcommon.extentions.KotlinResultKt.getOrThrow(r8, r7)
            if (r8 != r0) goto L_0x0076
            return r0
        L_0x0076:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt$flatMapOrDefault$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
