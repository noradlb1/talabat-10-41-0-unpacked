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
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$doOnNext$1", f = "KotlinResult.kt", i = {}, l = {106, 106}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$doOnNext$1 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f47000h;

    /* renamed from: i  reason: collision with root package name */
    public int f47001i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47002j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> f47003k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$doOnNext$1(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super KotlinResultKt$doOnNext$1> continuation) {
        super(1, continuation);
        this.f47002j = function1;
        this.f47003k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$doOnNext$1(this.f47002j, this.f47003k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super T> continuation) {
        return ((KotlinResultKt$doOnNext$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f47001i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Result<? extends T>>, Object> function1 = this.f47002j;
            this.f47001i = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            Object obj2 = this.f47000h;
            ResultKt.throwOnFailure(obj);
            return obj2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object r52 = ((Result) obj).m6338unboximpl();
        ResultKt.throwOnFailure(r52);
        Function2<T, Continuation<? super Unit>, Object> function2 = this.f47003k;
        this.f47000h = r52;
        this.f47001i = 2;
        if (function2.invoke(r52, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return r52;
    }
}
