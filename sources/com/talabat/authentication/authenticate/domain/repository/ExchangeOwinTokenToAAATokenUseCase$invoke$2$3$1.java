package com.talabat.authentication.authenticate.domain.repository;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$invoke$2$3$1", f = "ExchangeOwinTokenToAAATokenUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ExchangeOwinTokenToAAATokenUseCase$invoke$2$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55441h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ JwtExchangeCallback f55442i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExchangeOwinTokenToAAATokenUseCase$invoke$2$3$1(JwtExchangeCallback jwtExchangeCallback, Continuation<? super ExchangeOwinTokenToAAATokenUseCase$invoke$2$3$1> continuation) {
        super(2, continuation);
        this.f55442i = jwtExchangeCallback;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ExchangeOwinTokenToAAATokenUseCase$invoke$2$3$1(this.f55442i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ExchangeOwinTokenToAAATokenUseCase$invoke$2$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f55441h == 0) {
            ResultKt.throwOnFailure(obj);
            JwtExchangeCallback jwtExchangeCallback = this.f55442i;
            if (jwtExchangeCallback != null) {
                jwtExchangeCallback.onJwtTokenExchangeFailed();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
