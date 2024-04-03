package com.talabat.wallet.checkoutbinvoucher.domain.business.usecase;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository;
import com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/domain/business/usecase/GetBinVoucherCheckEligibility;", "", "repository", "Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;", "(Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;)V", "invoke", "", "model", "Lcom/talabat/wallet/checkoutbinvoucher/domain/entity/BinVoucherCheckEligibilityModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetBinVoucherCheckEligibility {
    @NotNull
    private final CheckoutPaymentManagerRepository repository;

    public GetBinVoucherCheckEligibility(@NotNull CheckoutPaymentManagerRepository checkoutPaymentManagerRepository) {
        Intrinsics.checkNotNullParameter(checkoutPaymentManagerRepository, "repository");
        this.repository = checkoutPaymentManagerRepository;
    }

    public final boolean invoke(@NotNull BinVoucherCheckEligibilityModel binVoucherCheckEligibilityModel) {
        boolean z11;
        Intrinsics.checkNotNullParameter(binVoucherCheckEligibilityModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        if (!binVoucherCheckEligibilityModel.isBinCampAvailable() || binVoucherCheckEligibilityModel.isGemActive() || binVoucherCheckEligibilityModel.isDarkStore()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            return false;
        }
        for (TokenisationCreditCard tokenisationCreditCard : this.repository.getSavedCardList()) {
            if (Intrinsics.areEqual((Object) tokenisationCreditCard.binNumber, (Object) binVoucherCheckEligibilityModel.getBinNumber()) && !tokenisationCreditCard.isBinDiscountValid) {
                return false;
            }
        }
        return true;
    }
}
