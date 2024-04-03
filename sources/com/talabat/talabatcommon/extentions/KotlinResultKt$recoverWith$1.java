package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$recoverWith$1", f = "KotlinResult.kt", i = {}, l = {170, 170}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$recoverWith$1 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f47049h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47050i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47051j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$recoverWith$1(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function12, Continuation<? super KotlinResultKt$recoverWith$1> continuation) {
        super(1, continuation);
        this.f47050i = function1;
        this.f47051j = function12;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$recoverWith$1(this.f47050i, this.f47051j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super T> continuation) {
        return ((KotlinResultKt$recoverWith$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f47049h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Result<? extends T>>, Object> function1 = this.f47050i;
            this.f47049h = 1;
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
        Function1<Continuation<? super Result<? extends T>>, Object> function12 = this.f47051j;
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            this.f47049h = 2;
            obj = KotlinResultKt.getOrThrow(function12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
