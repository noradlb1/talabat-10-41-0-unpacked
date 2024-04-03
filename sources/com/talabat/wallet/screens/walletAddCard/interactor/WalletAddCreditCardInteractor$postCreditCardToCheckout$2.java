package com.talabat.wallet.screens.walletAddCard.interactor;

import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutResponse;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.screens.walletAddCard.WalletAddCardListener;
import datamodels.WalletCreditCard;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/talabat/wallet/screens/walletAddCard/interactor/WalletAddCreditCardInteractor$postCreditCardToCheckout$2", "Lio/reactivex/observers/DisposableObserver;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutResponse;", "onComplete", "", "onError", "throwable", "", "onNext", "checkoutResponse", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCreditCardInteractor$postCreditCardToCheckout$2 extends DisposableObserver<CheckoutResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletAddCreditCardInteractor f12672b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WalletCreditCard f12673c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12674d;

    public WalletAddCreditCardInteractor$postCreditCardToCheckout$2(WalletAddCreditCardInteractor walletAddCreditCardInteractor, WalletCreditCard walletCreditCard, String str) {
        this.f12672b = walletAddCreditCardInteractor;
        this.f12673c = walletCreditCard;
        this.f12674d = str;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        LogManager.error(th2, "[ALOV]: Wallet Add Card");
        th2.printStackTrace();
        String localizedMessage = th2.getLocalizedMessage();
        Intrinsics.checkNotNullExpressionValue(localizedMessage, "throwable.localizedMessage");
        String lowerCase = localizedMessage.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) this.f12674d, false, 2, (Object) null)) {
            WalletAddCardListener access$getWalletAddCardListener$p = this.f12672b.walletAddCardListener;
            if (access$getWalletAddCardListener$p != null) {
                access$getWalletAddCardListener$p.onServerError();
                return;
            }
            return;
        }
        WalletAddCardListener access$getWalletAddCardListener$p2 = this.f12672b.walletAddCardListener;
        if (access$getWalletAddCardListener$p2 != null) {
            access$getWalletAddCardListener$p2.onNetworkError();
        }
    }

    public void onNext(@NotNull CheckoutResponse checkoutResponse) {
        Intrinsics.checkNotNullParameter(checkoutResponse, "checkoutResponse");
        WalletAddCardListener access$getWalletAddCardListener$p = this.f12672b.walletAddCardListener;
        if (access$getWalletAddCardListener$p != null) {
            access$getWalletAddCardListener$p.onCheckoutResponseReceived(checkoutResponse, this.f12673c);
        }
    }
}
