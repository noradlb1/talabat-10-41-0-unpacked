package com.talabat.splash.core.interactor;

import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001 \u0001*\u00020\u0000\"\u0006\b\u0001\u0010\u0002 \u0000*\u00020\u0003H@"}, d2 = {"", "Type", "Params", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.core.interactor.UseCase$invoke$2", f = "UseCase.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
public final class UseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f61432h;

    /* renamed from: i  reason: collision with root package name */
    public int f61433i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Either<? extends Failure, ? extends Object>, Unit> f61434j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Deferred<Either<Failure, Object>> f61435k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCase$invoke$2(Function1<? super Either<? extends Failure, ? extends Object>, Unit> function1, Deferred<? extends Either<? extends Failure, ? extends Object>> deferred, Continuation<? super UseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61434j = function1;
        this.f61435k = deferred;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UseCase$invoke$2(this.f61434j, this.f61435k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Function1<Either<? extends Failure, ? extends Object>, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61433i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Either<? extends Failure, ? extends Object>, Unit> function12 = this.f61434j;
            Deferred<Either<Failure, Object>> deferred = this.f61435k;
            this.f61432h = function12;
            this.f61433i = 1;
            Object await = deferred.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            function1 = function12;
            obj = await;
        } else if (i11 == 1) {
            function1 = (Function1) this.f61432h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function1.invoke(obj);
        return Unit.INSTANCE;
    }
}
