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

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0002\u001a\u0004\b\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H@"}, d2 = {"T", "R", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$mapNonNull$1", f = "KotlinResult.kt", i = {}, l = {50, 52}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$mapNonNull$1 extends SuspendLambda implements Function1<Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f47042h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47043i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super R>, Object> f47044j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$mapNonNull$1(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super KotlinResultKt$mapNonNull$1> continuation) {
        super(1, continuation);
        this.f47043i = function1;
        this.f47044j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$mapNonNull$1(this.f47043i, this.f47044j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super R> continuation) {
        return ((KotlinResultKt$mapNonNull$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f47042h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0042
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x002c
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, java.lang.Object> r5 = r4.f47043i
            r4.f47042h = r3
            java.lang.Object r5 = r5.invoke(r4)
            if (r5 != r0) goto L_0x002c
            return r0
        L_0x002c:
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.m6338unboximpl()
            kotlin.ResultKt.throwOnFailure(r5)
            if (r5 == 0) goto L_0x0048
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r4.f47044j
            r4.f47042h = r2
            java.lang.Object r5 = r1.invoke(r5, r4)
            if (r5 != r0) goto L_0x0042
            return r0
        L_0x0042:
            if (r5 == 0) goto L_0x0045
            return r5
        L_0x0045:
            com.talabat.talabatcommon.extentions.NullValueInEitherException r5 = com.talabat.talabatcommon.extentions.NullValueInEitherException.INSTANCE
            throw r5
        L_0x0048:
            com.talabat.talabatcommon.extentions.NullValueInEitherException r5 = com.talabat.talabatcommon.extentions.NullValueInEitherException.INSTANCE
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt$mapNonNull$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
