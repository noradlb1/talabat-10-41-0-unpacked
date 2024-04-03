package vx;

import com.talabat.wallet.screens.walletAddCard.interactor.WalletAddCreditCardInteractor;
import datamodels.WalletCreditCard;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class a implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletAddCreditCardInteractor f24151a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletCreditCard f24152b;

    public /* synthetic */ a(WalletAddCreditCardInteractor walletAddCreditCardInteractor, WalletCreditCard walletCreditCard) {
        this.f24151a = walletAddCreditCardInteractor;
        this.f24152b = walletCreditCard;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        WalletAddCreditCardInteractor.m5957postCreditCardToCheckout$lambda1(this.f24151a, this.f24152b, observableEmitter);
    }
}
