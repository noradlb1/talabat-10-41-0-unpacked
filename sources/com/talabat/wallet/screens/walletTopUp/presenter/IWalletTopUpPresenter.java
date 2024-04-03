package com.talabat.wallet.screens.walletTopUp.presenter;

import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H&J7\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUp/presenter/IWalletTopUpPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "getWalletCalculatedCashBack", "", "editTextValue", "", "eventType", "", "binNumber", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setWalletAmountTopUp", "submitWalletTopUpRequest", "tokenId", "card4Digits", "cardType", "amount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/Integer;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTopUpPresenter extends IGlobalPresenter {
    void getWalletCalculatedCashBack(@Nullable String str, @Nullable Integer num, @Nullable Integer num2);

    void setWalletAmountTopUp();

    void submitWalletTopUpRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, float f11, @Nullable Integer num);
}
