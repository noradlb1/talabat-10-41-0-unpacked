package com.talabat.card_tokenization.datasource;

import com.checkout.tokenization.model.TokenDetails;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/checkout/tokenization/model/TokenDetails;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CheckoutTokenizationDataSource$generateToken$2$request$1 extends Lambda implements Function1<TokenDetails, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<String> f55536g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutTokenizationDataSource$generateToken$2$request$1(CancellableContinuation<? super String> cancellableContinuation) {
        super(1);
        this.f55536g = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TokenDetails) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TokenDetails tokenDetails) {
        Intrinsics.checkNotNullParameter(tokenDetails, "it");
        CancellableContinuation<String> cancellableContinuation = this.f55536g;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m6329constructorimpl(tokenDetails.getToken()));
    }
}
