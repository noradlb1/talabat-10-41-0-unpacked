package com.talabat.wallet.screens.walletDashboardDetail.interactor;

import androidx.webkit.ProxyConfig;
import com.talabat.helpers.AppUrls;
import com.talabat.wallet.network.WalletApiService;
import com.talabat.wallet.network.WalletApiUrls;
import com.talabat.wallet.screens.walletDashboardDetail.WalletTransactionDetailScreenListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J!\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboardDetail/interactor/WalletTransactionDetailInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/wallet/screens/walletDashboardDetail/interactor/IWalletTransactionListInteractor;", "walletTransactionDetailScreenListener", "Lcom/talabat/wallet/screens/walletDashboardDetail/WalletTransactionDetailScreenListener;", "(Lcom/talabat/wallet/screens/walletDashboardDetail/WalletTransactionDetailScreenListener;)V", "getOrderDetails", "", "transactionOrderId", "", "getWalletCreditTransactionDetail", "transactionType", "id", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailInteractor implements IGlobalInteractor, IWalletTransactionListInteractor {
    /* access modifiers changed from: private */
    @Nullable
    public WalletTransactionDetailScreenListener walletTransactionDetailScreenListener;

    public WalletTransactionDetailInteractor(@Nullable WalletTransactionDetailScreenListener walletTransactionDetailScreenListener2) {
        this.walletTransactionDetailScreenListener = walletTransactionDetailScreenListener2;
    }

    public void getOrderDetails(@Nullable String str) {
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).getOrderDetail(CreateApiUrl.createWithParameters(AppUrls.ORDERDETAILSTALABAT, new String[]{"{transactionId}", str})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTransactionDetailInteractor$getOrderDetails$1(this, ProxyConfig.MATCH_HTTP));
    }

    public void getWalletCreditTransactionDetail(@Nullable String str, @Nullable Integer num) {
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).getWalletTransactionDetail(CreateApiUrl.createWithParameters(WalletApiUrls.Companion.getWALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL(), new String[]{"{transactionType}", String.valueOf(str), "{transactionId}", String.valueOf(num)})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTransactionDetailInteractor$getWalletCreditTransactionDetail$1(this));
    }

    public void unregister() {
        this.walletTransactionDetailScreenListener = null;
    }
}
