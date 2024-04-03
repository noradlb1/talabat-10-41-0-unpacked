package com.checkout.frames.usecase;

import com.checkout.api.CheckoutApiService;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.model.request.InternalCardTokenRequest;
import com.checkout.tokenization.model.CardTokenRequest;
import com.checkout.tokenization.model.TokenDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001Ba\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t\u0012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u001e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/checkout/frames/usecase/CardTokenizationUseCase;", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/model/request/InternalCardTokenRequest;", "", "checkoutApiService", "Lcom/checkout/api/CheckoutApiService;", "onStart", "Lkotlin/Function0;", "onSuccess", "Lkotlin/Function1;", "Lcom/checkout/tokenization/model/TokenDetails;", "Lkotlin/ParameterName;", "name", "tokenDetails", "onFailure", "", "errorMessage", "(Lcom/checkout/api/CheckoutApiService;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "execute", "data", "handleFailure", "onFailureInternal", "handleSuccess", "onSuccessInternal", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardTokenizationUseCase implements UseCase<InternalCardTokenRequest, Unit> {
    @NotNull
    private final CheckoutApiService checkoutApiService;
    @NotNull
    private final Function1<String, Unit> onFailure;
    @NotNull
    private final Function0<Unit> onStart;
    @NotNull
    private final Function1<TokenDetails, Unit> onSuccess;

    public CardTokenizationUseCase(@NotNull CheckoutApiService checkoutApiService2, @NotNull Function0<Unit> function0, @NotNull Function1<? super TokenDetails, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkNotNullParameter(checkoutApiService2, "checkoutApiService");
        Intrinsics.checkNotNullParameter(function0, "onStart");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onFailure");
        this.checkoutApiService = checkoutApiService2;
        this.onStart = function0;
        this.onSuccess = function1;
        this.onFailure = function12;
    }

    /* access modifiers changed from: private */
    public final void handleFailure(String str, Function0<Unit> function0) {
        function0.invoke();
        this.onFailure.invoke(str);
    }

    /* access modifiers changed from: private */
    public final void handleSuccess(TokenDetails tokenDetails, Function0<Unit> function0) {
        function0.invoke();
        this.onSuccess.invoke(tokenDetails);
    }

    public /* bridge */ /* synthetic */ Object execute(Object obj) {
        execute((InternalCardTokenRequest) obj);
        return Unit.INSTANCE;
    }

    public void execute(@NotNull InternalCardTokenRequest internalCardTokenRequest) {
        Intrinsics.checkNotNullParameter(internalCardTokenRequest, "data");
        this.onStart.invoke();
        this.checkoutApiService.createToken(new CardTokenRequest(internalCardTokenRequest.getCard(), new CardTokenizationUseCase$execute$1(this, internalCardTokenRequest), new CardTokenizationUseCase$execute$2(this, internalCardTokenRequest)));
    }
}
