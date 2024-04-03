package com.talabat.sidemenu;

import JsonModels.Response.TalabatCreditBalanceResponse;
import JsonModels.Response.WalletCreditBalanceResponse;
import JsonModels.Response.WalletCreditBalanceResultModel;
import com.talabat.talabatcommon.extentions.FloatKt;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/talabat/sidemenu/SideMenuInteractor$loadTalabatCreditBalance$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/WalletCreditBalanceResponse;", "onComplete", "", "onError", "throwable", "", "onNext", "walletCreditBalanceResponse", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuInteractor$loadTalabatCreditBalance$1 extends DisposableObserver<WalletCreditBalanceResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SideMenuInteractor f61364b;

    public SideMenuInteractor$loadTalabatCreditBalance$1(SideMenuInteractor sideMenuInteractor) {
        this.f61364b = sideMenuInteractor;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        SideMenuListener access$getSideMenuListener$p = this.f61364b.sideMenuListener;
        if (access$getSideMenuListener$p != null) {
            access$getSideMenuListener$p.onTalabatCreditBalError();
        }
    }

    public void onNext(@NotNull WalletCreditBalanceResponse walletCreditBalanceResponse) {
        Intrinsics.checkNotNullParameter(walletCreditBalanceResponse, "walletCreditBalanceResponse");
        SideMenuListener access$getSideMenuListener$p = this.f61364b.sideMenuListener;
        if (access$getSideMenuListener$p != null) {
            TalabatCreditBalanceResponse talabatCreditBalanceResponse = new TalabatCreditBalanceResponse();
            WalletCreditBalanceResultModel result = walletCreditBalanceResponse.getResult();
            talabatCreditBalanceResponse.setTotBalance(FloatKt.orZero(result != null ? result.getBalanceAmount() : null));
            access$getSideMenuListener$p.onCreditBalanceDetailsReceived(talabatCreditBalanceResponse);
        }
    }
}
