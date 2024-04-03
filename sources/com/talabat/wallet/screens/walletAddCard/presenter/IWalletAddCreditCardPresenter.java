package com.talabat.wallet.screens.walletAddCard.presenter;

import datamodels.WalletCreditCard;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/screens/walletAddCard/presenter/IWalletAddCreditCardPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "getCreditCardNumberLength", "", "paymentOption", "", "getMaximumLengthForSecurityCode", "getPaymentMethodOptionName", "cardBin", "isLuhnValid", "", "cardNumber", "saveCreditCard", "", "card", "Ldatamodels/WalletCreditCard;", "validateExpiryDate", "filledDate", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletAddCreditCardPresenter extends IGlobalPresenter {
    int getCreditCardNumberLength(@Nullable String str);

    int getMaximumLengthForSecurityCode(@Nullable String str);

    @Nullable
    String getPaymentMethodOptionName(@Nullable String str);

    boolean isLuhnValid(@NotNull String str);

    void saveCreditCard(@NotNull WalletCreditCard walletCreditCard);

    boolean validateExpiryDate(@NotNull String str);
}
