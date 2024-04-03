package com.talabat.wallet.payproxymanager.preesentation.viewmodel;

import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.wallet.payproxymanager.domain.business.GetSendCVVToProxyUseCase;
import com.talabat.wallet.payproxymanager.preesentation.displaymodel.SendCVVToProxyDisplayModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/payproxymanager/preesentation/viewmodel/PayProxyManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "getSendCVVToProxyUseCase", "Lcom/talabat/wallet/payproxymanager/domain/business/GetSendCVVToProxyUseCase;", "(Lcom/talabat/wallet/payproxymanager/domain/business/GetSendCVVToProxyUseCase;)V", "sendCVVToProxyData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel;", "getSendCVVToProxyData", "()Landroidx/lifecycle/MutableLiveData;", "onSendCVVToProxy", "", "recurringPurchaseRequest", "LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;", "paymentMethod", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyManagerViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final GetSendCVVToProxyUseCase getSendCVVToProxyUseCase;
    @NotNull
    private final MutableLiveData<SendCVVToProxyDisplayModel> sendCVVToProxyData = new MutableLiveData<>();

    public PayProxyManagerViewModel(@NotNull GetSendCVVToProxyUseCase getSendCVVToProxyUseCase2) {
        Intrinsics.checkNotNullParameter(getSendCVVToProxyUseCase2, "getSendCVVToProxyUseCase");
        this.getSendCVVToProxyUseCase = getSendCVVToProxyUseCase2;
    }

    @NotNull
    public final MutableLiveData<SendCVVToProxyDisplayModel> getSendCVVToProxyData() {
        return this.sendCVVToProxyData;
    }

    public final void onSendCVVToProxy(@NotNull RecurringPurchaseRequest recurringPurchaseRequest, int i11) {
        Intrinsics.checkNotNullParameter(recurringPurchaseRequest, "recurringPurchaseRequest");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PayProxyManagerViewModel$onSendCVVToProxy$1(recurringPurchaseRequest, this, i11, (Continuation<? super PayProxyManagerViewModel$onSendCVVToProxy$1>) null), 3, (Object) null);
    }
}
