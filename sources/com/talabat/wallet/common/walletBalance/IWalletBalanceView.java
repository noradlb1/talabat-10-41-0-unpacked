package com.talabat.wallet.common.walletBalance;

import com.talabat.helpers.Talabat;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/common/walletBalance/IWalletBalanceView;", "Lcom/talabat/helpers/Talabat;", "addBalance", "", "balance", "", "(Ljava/lang/Float;)V", "walletBalanceDisplayServerErrorMessage", "walletBalanceRedirectToLoginScreen", "walletBalanceSetupViewsBeforeServiceRequest", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletBalanceView extends Talabat {
    void addBalance(@Nullable Float f11);

    void walletBalanceDisplayServerErrorMessage();

    void walletBalanceRedirectToLoginScreen();

    void walletBalanceSetupViewsBeforeServiceRequest();
}
