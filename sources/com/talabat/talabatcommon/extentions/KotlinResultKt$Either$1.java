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

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "Lkotlin/Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$Either$1", f = "KotlinResult.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$Either$1 extends SuspendLambda implements Function1<Continuation<? super Result<? extends T>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f46998h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super T>, Object> f46999i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$Either$1(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super KotlinResultKt$Either$1> continuation) {
        super(1, continuation);
        this.f46999i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$Either$1(this.f46999i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Result<? extends T>> continuation) {
        return ((KotlinResultKt$Either$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f46998h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super T>, Object> function1 = this.f46999i;
            Result.Companion companion = Result.Companion;
            this.f46998h = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl(obj);
        return Result.m6328boximpl(obj2);
    }
}
