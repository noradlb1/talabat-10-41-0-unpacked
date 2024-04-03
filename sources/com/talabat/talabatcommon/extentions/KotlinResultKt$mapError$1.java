package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$mapError$1", f = "KotlinResult.kt", i = {}, l = {89, 89}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$mapError$1 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f47039h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47040i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Throwable, Continuation<? super T>, Object> f47041j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$mapError$1(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Function2<? super Throwable, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super KotlinResultKt$mapError$1> continuation) {
        super(1, continuation);
        this.f47040i = function1;
        this.f47041j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$mapError$1(this.f47040i, this.f47041j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super T> continuation) {
        return ((KotlinResultKt$mapError$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f47039h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Result<? extends T>>, Object> function1 = this.f47040i;
            this.f47039h = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj = ((Result) obj).m6338unboximpl();
        Function2<Throwable, Continuation<? super T>, Object> function2 = this.f47041j;
        Throwable r32 = Result.m6332exceptionOrNullimpl(obj);
        if (r32 != null) {
            this.f47039h = 2;
            obj = function2.invoke(r32, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
