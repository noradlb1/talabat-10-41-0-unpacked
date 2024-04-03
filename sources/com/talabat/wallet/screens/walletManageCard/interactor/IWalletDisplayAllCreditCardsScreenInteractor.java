package com.talabat.wallet.screens.walletManageCard.interactor;

import JsonModels.Request.WalletSetDefaultCreditCardRequest;
import JsonModels.Response.WalletCreditCardGetListDataModel;
import JsonModels.Response.WalletCreditCardGetListResponse;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/interactor/IWalletDisplayAllCreditCardsScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "getAllWalletCreditCards", "", "paymentProvider", "", "countryId", "primaryCardLabel", "", "otherCardLabel", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "mapDataResponseToAdapterDataItem", "LJsonModels/Response/WalletCreditCardGetListDataModel;", "walletCreditCardGetListResponse", "LJsonModels/Response/WalletCreditCardGetListResponse;", "setDefaultCard", "walletSetDefaultCreditCardRequest", "LJsonModels/Request/WalletSetDefaultCreditCardRequest;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletDisplayAllCreditCardsScreenInteractor extends IGlobalInteractor {
    void getAllWalletCreditCards(@Nullable Integer num, @Nullable Integer num2, @NotNull String str, @NotNull String str2);

    @Nullable
    WalletCreditCardGetListDataModel mapDataResponseToAdapterDataItem(@Nullable WalletCreditCardGetListResponse walletCreditCardGetListResponse, @NotNull String str, @NotNull String str2);

    void setDefaultCard(@NotNull WalletSetDefaultCreditCardRequest walletSetDefaultCreditCardRequest);
}
