package com.talabat.wallet.common.walletBalance.interactor;

import com.talabat.wallet.common.interactors.walletBalance.IWalletBalanceCommonInteractor;
import com.talabat.wallet.common.interactors.walletBalance.WalletBalanceCommonInteractor;
import com.talabat.wallet.common.walletBalance.WalletBalanceListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/common/walletBalance/interactor/WalletBalanceInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/wallet/common/walletBalance/interactor/IWalletBalanceInteractor;", "walletBalanceListener", "Lcom/talabat/wallet/common/walletBalance/WalletBalanceListener;", "(Lcom/talabat/wallet/common/walletBalance/WalletBalanceListener;)V", "mWalletBalanceCommonInteractor", "Lcom/talabat/wallet/common/interactors/walletBalance/IWalletBalanceCommonInteractor;", "getWalletCreditBalance", "", "countryCode", "", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceInteractor implements IGlobalInteractor, IWalletBalanceInteractor {
    @NotNull
    private IWalletBalanceCommonInteractor mWalletBalanceCommonInteractor = new WalletBalanceCommonInteractor();
    /* access modifiers changed from: private */
    @Nullable
    public WalletBalanceListener walletBalanceListener;

    public WalletBalanceInteractor(@NotNull WalletBalanceListener walletBalanceListener2) {
        Intrinsics.checkNotNullParameter(walletBalanceListener2, "walletBalanceListener");
        this.walletBalanceListener = walletBalanceListener2;
    }

    public void getWalletCreditBalance(@Nullable String str) {
        this.mWalletBalanceCommonInteractor.getWalletCreditBalance(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletBalanceInteractor$getWalletCreditBalance$1(this));
    }

    public void unregister() {
        this.walletBalanceListener = null;
    }
}
