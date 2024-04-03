package com.talabat.wallet.screens.walletAddCard.interactor;

import com.talabat.feature.tokenization.domain.entity.TokenizationCard;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutResponse;
import datamodels.WalletCreditCard;
import io.reactivex.ObservableEmitter;
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
@DebugMetadata(c = "com.talabat.wallet.screens.walletAddCard.interactor.WalletAddCreditCardInteractor$postCreditCardToCheckout$1$1", f = "WalletAddCreditCardInteractor.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class WalletAddCreditCardInteractor$postCreditCardToCheckout$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12668h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletAddCreditCardInteractor f12669i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletCreditCard f12670j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter<CheckoutResponse> f12671k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletAddCreditCardInteractor$postCreditCardToCheckout$1$1(WalletAddCreditCardInteractor walletAddCreditCardInteractor, WalletCreditCard walletCreditCard, ObservableEmitter<CheckoutResponse> observableEmitter, Continuation<? super WalletAddCreditCardInteractor$postCreditCardToCheckout$1$1> continuation) {
        super(2, continuation);
        this.f12669i = walletAddCreditCardInteractor;
        this.f12670j = walletCreditCard;
        this.f12671k = observableEmitter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletAddCreditCardInteractor$postCreditCardToCheckout$1$1(this.f12669i, this.f12670j, this.f12671k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletAddCreditCardInteractor$postCreditCardToCheckout$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12668h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GenerateCardTokenUseCase access$getGenerateCardTokenUseCase$p = this.f12669i.generateCardTokenUseCase;
            String cardNumber = this.f12670j.getCardNumber();
            if (cardNumber == null) {
                str = "";
            } else {
                str = cardNumber;
            }
            String holderName = this.f12670j.getHolderName();
            if (holderName == null) {
                str2 = "";
            } else {
                str2 = holderName;
            }
            String month = this.f12670j.getMonth();
            if (month == null) {
                str3 = "";
            } else {
                str3 = month;
            }
            String year = this.f12670j.getYear();
            if (year == null) {
                str4 = "";
            } else {
                str4 = year;
            }
            String code = this.f12670j.getCode();
            if (code == null) {
                str5 = "";
            } else {
                str5 = code;
            }
            TokenizationCard tokenizationCard = new TokenizationCard(str, str2, str3, str4, str5);
            GenerateCardTokenUseCase.UseCase useCase = GenerateCardTokenUseCase.UseCase.WALLET;
            this.f12668h = 1;
            obj = GenerateCardTokenUseCase.invoke$default(access$getGenerateCardTokenUseCase$p, tokenizationCard, useCase, (Integer) null, this, 4, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                this.f12671k.onError(e11);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f12671k.onNext(new CheckoutResponse((String) obj));
        this.f12671k.onComplete();
        return Unit.INSTANCE;
    }
}
