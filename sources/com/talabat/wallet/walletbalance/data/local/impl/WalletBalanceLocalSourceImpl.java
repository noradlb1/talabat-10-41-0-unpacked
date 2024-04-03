package com.talabat.wallet.walletbalance.data.local.impl;

import buisnessmodels.Customer;
import com.talabat.wallet.walletbalance.data.local.WalletBalanceLocalSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/walletbalance/data/local/impl/WalletBalanceLocalSourceImpl;", "Lcom/talabat/wallet/walletbalance/data/local/WalletBalanceLocalSource;", "()V", "setWalletBalance", "", "walletBalance", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceLocalSourceImpl implements WalletBalanceLocalSource {
    public void setWalletBalance(float f11) {
        Customer.getInstance().getCustomerInfo().setTalabatCredit(f11);
    }
}
