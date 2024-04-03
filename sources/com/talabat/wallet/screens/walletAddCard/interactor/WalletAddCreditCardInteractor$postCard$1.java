package com.talabat.wallet.screens.walletAddCard.interactor;

import JsonModels.Response.WalletSaveCreditCardResponse;
import com.talabat.wallet.screens.walletAddCard.WalletAddCardListener;
import datamodels.WalletCreditCard;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/talabat/wallet/screens/walletAddCard/interactor/WalletAddCreditCardInteractor$postCard$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/WalletSaveCreditCardResponse;", "onComplete", "", "onError", "throwable", "", "onNext", "walletSaveCreditCardResponse", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCreditCardInteractor$postCard$1 extends DisposableObserver<WalletSaveCreditCardResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletAddCreditCardInteractor f12665b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WalletCreditCard f12666c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12667d;

    public WalletAddCreditCardInteractor$postCard$1(WalletAddCreditCardInteractor walletAddCreditCardInteractor, WalletCreditCard walletCreditCard, String str) {
        this.f12665b = walletAddCreditCardInteractor;
        this.f12666c = walletCreditCard;
        this.f12667d = str;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        th2.printStackTrace();
        String localizedMessage = th2.getLocalizedMessage();
        Intrinsics.checkNotNullExpressionValue(localizedMessage, "throwable.localizedMessage");
        String lowerCase = localizedMessage.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) this.f12667d, false, 2, (Object) null)) {
            WalletAddCardListener access$getWalletAddCardListener$p = this.f12665b.walletAddCardListener;
            if (access$getWalletAddCardListener$p != null) {
                access$getWalletAddCardListener$p.onServerError();
                return;
            }
            return;
        }
        WalletAddCardListener access$getWalletAddCardListener$p2 = this.f12665b.walletAddCardListener;
        if (access$getWalletAddCardListener$p2 != null) {
            access$getWalletAddCardListener$p2.onNetworkError();
        }
    }

    public void onNext(@NotNull WalletSaveCreditCardResponse walletSaveCreditCardResponse) {
        Intrinsics.checkNotNullParameter(walletSaveCreditCardResponse, "walletSaveCreditCardResponse");
        WalletAddCardListener access$getWalletAddCardListener$p = this.f12665b.walletAddCardListener;
        if (access$getWalletAddCardListener$p != null) {
            access$getWalletAddCardListener$p.onWalletSaveCardResponseReceived(walletSaveCreditCardResponse, this.f12666c);
        }
    }
}
