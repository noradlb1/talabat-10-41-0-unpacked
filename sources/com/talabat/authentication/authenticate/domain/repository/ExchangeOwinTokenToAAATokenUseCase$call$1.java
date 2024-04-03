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
@DebugMetadata(c = "com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$call$1", f = "ExchangeOwinTokenToAAATokenUseCase.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
public final class ExchangeOwinTokenToAAATokenUseCase$call$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f55425h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ExchangeOwinTokenToAAATokenUseCase f55426i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f55427j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ JwtExchangeCallback f55428k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExchangeOwinTokenToAAATokenUseCase$call$1(ExchangeOwinTokenToAAATokenUseCase exchangeOwinTokenToAAATokenUseCase, String str, JwtExchangeCallback jwtExchangeCallback, Continuation<? super ExchangeOwinTokenToAAATokenUseCase$call$1> continuation) {
        super(2, continuation);
        this.f55426i = exchangeOwinTokenToAAATokenUseCase;
        this.f55427j = str;
        this.f55428k = jwtExchangeCallback;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ExchangeOwinTokenToAAATokenUseCase$call$1(this.f55426i, this.f55427j, this.f55428k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ExchangeOwinTokenToAAATokenUseCase$call$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f55425h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ExchangeOwinTokenToAAATokenUseCase exchangeOwinTokenToAAATokenUseCase = this.f55426i;
            String str = this.f55427j;
            JwtExchangeCallback jwtExchangeCallback = this.f55428k;
            this.f55425h = 1;
            if (exchangeOwinTokenToAAATokenUseCase.invoke(str, jwtExchangeCallback, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
