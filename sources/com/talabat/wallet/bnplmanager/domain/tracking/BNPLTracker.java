package com.talabat.wallet.bnplmanager.domain.tracking;

import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0003H&¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTracker;", "", "onBNPLError", "", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "eventName", "", "onBNPLFakeTestSubmitted", "isBNPLNotify", "", "isBNPLFeedback", "onBNPLOrderPaymentFailure", "failureTrackingModel", "Ltracking/models/pay/BNPLOrderPaymentFailureTrackingModel;", "onBNPLPlaceOrderBottomSheetOpen", "screenName", "onBNPLValidationError", "errorCode", "errorDescription", "onPaymentMethodChanged", "onPlaceFakeOrder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BNPLTracker {
    void onBNPLError(@NotNull BNPLValidationError bNPLValidationError, @NotNull String str);

    void onBNPLFakeTestSubmitted(boolean z11, boolean z12);

    void onBNPLOrderPaymentFailure(@NotNull BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel);

    void onBNPLPlaceOrderBottomSheetOpen(@NotNull String str);

    void onBNPLValidationError(@NotNull String str, @NotNull String str2);

    void onPaymentMethodChanged(@NotNull String str);

    void onPlaceFakeOrder();
}
