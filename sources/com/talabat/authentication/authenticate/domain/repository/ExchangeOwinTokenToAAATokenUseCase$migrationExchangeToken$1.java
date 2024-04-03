package com.talabat.authentication.authenticate.domain.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase", f = "ExchangeOwinTokenToAAATokenUseCase.kt", i = {}, l = {83}, m = "migrationExchangeToken", n = {}, s = {})
public final class ExchangeOwinTokenToAAATokenUseCase$migrationExchangeToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f55443h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ExchangeOwinTokenToAAATokenUseCase f55444i;

    /* renamed from: j  reason: collision with root package name */
    public int f55445j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExchangeOwinTokenToAAATokenUseCase$migrationExchangeToken$1(ExchangeOwinTokenToAAATokenUseCase exchangeOwinTokenToAAATokenUseCase, Continuation<? super ExchangeOwinTokenToAAATokenUseCase$migrationExchangeToken$1> continuation) {
        super(continuation);
        this.f55444i = exchangeOwinTokenToAAATokenUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55443h = obj;
        this.f55445j |= Integer.MIN_VALUE;
        return this.f55444i.migrationExchangeToken(this);
    }
}
