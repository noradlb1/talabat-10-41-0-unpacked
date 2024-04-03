package com.talabat.wallet.common.walletBalance.interactor;

import JsonModels.Response.WalletCreditBalanceResponse;
import com.talabat.wallet.common.walletBalance.WalletBalanceListener;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/talabat/wallet/common/walletBalance/interactor/WalletBalanceInteractor$getWalletCreditBalance$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/WalletCreditBalanceResponse;", "onComplete", "", "onError", "throwable", "", "onNext", "walletCreditBalanceResponse", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceInteractor$getWalletCreditBalance$1 extends DisposableObserver<WalletCreditBalanceResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletBalanceInteractor f12561b;

    public WalletBalanceInteractor$getWalletCreditBalance$1(WalletBalanceInteractor walletBalanceInteractor) {
        this.f12561b = walletBalanceInteractor;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        if (th2 instanceof HttpException) {
            WalletBalanceListener access$getWalletBalanceListener$p = this.f12561b.walletBalanceListener;
            if (access$getWalletBalanceListener$p != null) {
                access$getWalletBalanceListener$p.onWalletBalanceServerError();
                return;
            }
            return;
        }
        WalletBalanceListener access$getWalletBalanceListener$p2 = this.f12561b.walletBalanceListener;
        if (access$getWalletBalanceListener$p2 != null) {
            access$getWalletBalanceListener$p2.onWalletBalanceNetworkError();
        }
    }

    public void onNext(@NotNull WalletCreditBalanceResponse walletCreditBalanceResponse) {
        Intrinsics.checkNotNullParameter(walletCreditBalanceResponse, "walletCreditBalanceResponse");
        WalletBalanceListener access$getWalletBalanceListener$p = this.f12561b.walletBalanceListener;
        if (access$getWalletBalanceListener$p != null) {
            access$getWalletBalanceListener$p.onCreditBalanceReceived(walletCreditBalanceResponse);
        }
    }
}
