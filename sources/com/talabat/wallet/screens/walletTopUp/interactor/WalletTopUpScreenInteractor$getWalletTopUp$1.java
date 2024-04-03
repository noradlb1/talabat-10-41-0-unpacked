package com.talabat.wallet.screens.walletTopUp.interactor;

import JsonModels.Response.WalletTopUpResponse;
import com.talabat.wallet.screens.walletTopUp.WalletTopUpListener;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/talabat/wallet/screens/walletTopUp/interactor/WalletTopUpScreenInteractor$getWalletTopUp$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/WalletTopUpResponse;", "onComplete", "", "onError", "throwable", "", "onNext", "walletTopUpResponse", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpScreenInteractor$getWalletTopUp$1 extends DisposableObserver<WalletTopUpResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopUpScreenInteractor f12702b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12703c;

    public WalletTopUpScreenInteractor$getWalletTopUp$1(WalletTopUpScreenInteractor walletTopUpScreenInteractor, String str) {
        this.f12702b = walletTopUpScreenInteractor;
        this.f12703c = str;
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
        if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) this.f12703c, false, 2, (Object) null)) {
            WalletTopUpListener access$getWalletTopUpListener$p = this.f12702b.walletTopUpListener;
            if (access$getWalletTopUpListener$p != null) {
                access$getWalletTopUpListener$p.onServerError();
                return;
            }
            return;
        }
        WalletTopUpListener access$getWalletTopUpListener$p2 = this.f12702b.walletTopUpListener;
        if (access$getWalletTopUpListener$p2 != null) {
            access$getWalletTopUpListener$p2.onNetworkError();
        }
    }

    public void onNext(@NotNull WalletTopUpResponse walletTopUpResponse) {
        Intrinsics.checkNotNullParameter(walletTopUpResponse, "walletTopUpResponse");
        WalletTopUpListener access$getWalletTopUpListener$p = this.f12702b.walletTopUpListener;
        if (access$getWalletTopUpListener$p != null) {
            access$getWalletTopUpListener$p.onWalletTopUpReceived(walletTopUpResponse);
        }
    }
}
