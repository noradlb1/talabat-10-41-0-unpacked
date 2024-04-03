package com.talabat.wallet.payproxymanager.preesentation.viewmodel.mapper;

import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult;
import com.talabat.wallet.payproxymanager.preesentation.displaymodel.SendCVVToProxyDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/payproxymanager/preesentation/viewmodel/mapper/PayProxyDisplayModelMapper;", "", "()V", "mapToSendCVVToProxyDisplayModel", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel;", "payProxyCVVResult", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "recurringPurchaseRequest", "LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;", "paymentMethod", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyDisplayModelMapper {
    @NotNull
    public static final PayProxyDisplayModelMapper INSTANCE = new PayProxyDisplayModelMapper();

    private PayProxyDisplayModelMapper() {
    }

    @NotNull
    public final SendCVVToProxyDisplayModel mapToSendCVVToProxyDisplayModel(@Nullable PayProxyCVVResult payProxyCVVResult, @NotNull RecurringPurchaseRequest recurringPurchaseRequest, int i11) {
        Intrinsics.checkNotNullParameter(recurringPurchaseRequest, "recurringPurchaseRequest");
        boolean z11 = payProxyCVVResult instanceof PayProxyCVVResult.CVVSuccessful;
        if (z11 && i11 == 4) {
            recurringPurchaseRequest.setIsCVCRequired(Boolean.TRUE);
            recurringPurchaseRequest.cvv = StringUtils.empty(StringCompanionObject.INSTANCE);
            return new SendCVVToProxyDisplayModel.ContinueWithAdyenPayment(recurringPurchaseRequest);
        } else if (!z11 || i11 != 2) {
            boolean z12 = payProxyCVVResult instanceof PayProxyCVVResult.CVVIsUnAvailable;
            if (z12 && i11 == 4) {
                recurringPurchaseRequest.setIsCVCRequired(Boolean.FALSE);
                return new SendCVVToProxyDisplayModel.ContinueWithAdyenPayment(recurringPurchaseRequest);
            } else if (z12 && i11 == 2) {
                recurringPurchaseRequest.setIsCVCRequired(Boolean.FALSE);
                return new SendCVVToProxyDisplayModel.ContinueWithCheckoutPayment(recurringPurchaseRequest);
            } else if (payProxyCVVResult instanceof PayProxyCVVResult.CVVServerError) {
                return SendCVVToProxyDisplayModel.CVVSentFailure.INSTANCE;
            } else {
                return SendCVVToProxyDisplayModel.CVVToProxyLoading.INSTANCE;
            }
        } else {
            recurringPurchaseRequest.setIsCVCRequired(Boolean.TRUE);
            recurringPurchaseRequest.cvv = StringUtils.empty(StringCompanionObject.INSTANCE);
            return new SendCVVToProxyDisplayModel.ContinueWithCheckoutPayment(recurringPurchaseRequest);
        }
    }
}
