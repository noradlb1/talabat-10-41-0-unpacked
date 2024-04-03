package com.talabat.wallet.screens.walletManageCard.presenter;

import JsonModels.Request.WalletDeleteCreditCardRequest;
import JsonModels.Request.WalletSetDefaultCreditCardRequest;
import java.util.List;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/presenter/IWalletManageCardsScreenPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "deleteCreditCards", "", "cardIds", "", "LJsonModels/Request/WalletDeleteCreditCardRequest;", "setAllWalletCreditCards", "primaryCardLabel", "", "otherCardLabel", "setDefaultCreditCard", "walletSetDefaultCreditCardRequest", "LJsonModels/Request/WalletSetDefaultCreditCardRequest;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletManageCardsScreenPresenter extends IGlobalPresenter {
    void deleteCreditCards(@NotNull List<WalletDeleteCreditCardRequest> list);

    void setAllWalletCreditCards(@NotNull String str, @NotNull String str2);

    void setDefaultCreditCard(@Nullable WalletSetDefaultCreditCardRequest walletSetDefaultCreditCardRequest);
}
