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

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0002\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H@"}, d2 = {"T", "R", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.extentions.KotlinResultKt$map$1", f = "KotlinResult.kt", i = {}, l = {39, 39}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinResultKt$map$1 extends SuspendLambda implements Function1<Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f47035h;

    /* renamed from: i  reason: collision with root package name */
    public int f47036i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super R>, Object> f47037j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> f47038k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinResultKt$map$1(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Continuation<? super KotlinResultKt$map$1> continuation) {
        super(1, continuation);
        this.f47037j = function2;
        this.f47038k = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new KotlinResultKt$map$1(this.f47037j, this.f47038k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super R> continuation) {
        return ((KotlinResultKt$map$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Function2<T, Continuation<? super R>, Object> function2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f47036i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            function2 = this.f47037j;
            Function1<Continuation<? super Result<? extends T>>, Object> function1 = this.f47038k;
            this.f47035h = function2;
            this.f47036i = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            function2 = (Function2) this.f47035h;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object r52 = ((Result) obj).m6338unboximpl();
        ResultKt.throwOnFailure(r52);
        this.f47035h = null;
        this.f47036i = 2;
        obj = function2.invoke(r52, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return obj;
    }
}
