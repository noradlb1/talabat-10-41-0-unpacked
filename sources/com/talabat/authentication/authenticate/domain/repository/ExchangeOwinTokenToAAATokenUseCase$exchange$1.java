package com.talabat.authentication.authenticate.domain.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase", f = "ExchangeOwinTokenToAAATokenUseCase.kt", i = {0, 0, 1, 1}, l = {56, 60}, m = "exchange", n = {"this", "flowName", "this", "flowName"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class ExchangeOwinTokenToAAATokenUseCase$exchange$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55429h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55430i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f55431j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExchangeOwinTokenToAAATokenUseCase f55432k;

    /* renamed from: l  reason: collision with root package name */
    public int f55433l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExchangeOwinTokenToAAATokenUseCase$exchange$1(ExchangeOwinTokenToAAATokenUseCase exchangeOwinTokenToAAATokenUseCase, Continuation<? super ExchangeOwinTokenToAAATokenUseCase$exchange$1> continuation) {
        super(continuation);
        this.f55432k = exchangeOwinTokenToAAATokenUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55431j = obj;
        this.f55433l |= Integer.MIN_VALUE;
        return this.f55432k.exchange((String) null, this);
    }
}
