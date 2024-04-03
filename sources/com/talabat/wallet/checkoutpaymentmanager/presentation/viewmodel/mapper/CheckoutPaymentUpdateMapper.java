package com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel.mapper;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail;
import com.talabat.wallet.checkoutpaymentmanager.domain.entity.CheckoutPaymentUpdateResult;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPlanEligibilityState;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPopUpViewState;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.CheckoutPaymentUpdateDisplayModel;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.QPayRedirectUrlDisplayModel;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.WalletBalanceDisplayModel;
import com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult;
import com.talabat.wallet.walletbalance.domain.entity.WalletBalanceResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¨\u0006\u001d"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/viewmodel/mapper/CheckoutPaymentUpdateMapper;", "", "()V", "mapToBNPLPlanEligibilityDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "bNPLEligiblePlanDetail", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligiblePlanDetail;", "cartTotalPrice", "", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligiblePlanDetail;Ljava/lang/Float;)Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "mapToBNPLPopViewDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState;", "isChangeCardClicked", "", "isPaymentFallback", "mapToPaymentMethodUpdateToDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "checkoutPaymentUpdateResult", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/entity/CheckoutPaymentUpdateResult;", "mapToQPayRedirectUrlDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel;", "qPayRedirectUrlResult", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult;", "mapToWalletBalanceDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel;", "walletBalanceResult", "Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutPaymentUpdateMapper {
    @NotNull
    public static final CheckoutPaymentUpdateMapper INSTANCE = new CheckoutPaymentUpdateMapper();

    private CheckoutPaymentUpdateMapper() {
    }

    public static /* synthetic */ BNPLPopUpViewState mapToBNPLPopViewDisplayModel$default(CheckoutPaymentUpdateMapper checkoutPaymentUpdateMapper, BNPLEligiblePlanDetail bNPLEligiblePlanDetail, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            z12 = false;
        }
        return checkoutPaymentUpdateMapper.mapToBNPLPopViewDisplayModel(bNPLEligiblePlanDetail, z11, z12);
    }

    @NotNull
    public final BNPLPlanEligibilityState mapToBNPLPlanEligibilityDisplayModel(@NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull BNPLEligiblePlanDetail bNPLEligiblePlanDetail, @Nullable Float f11) {
        BNPLPlanEligibilityState bNPLInstallmentPlan;
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(bNPLEligiblePlanDetail, "bNPLEligiblePlanDetail");
        if (bNPLEligiblePlanDetail.getBNPLEligibilityDetail().isHideBNPLPaymentMethod()) {
            return BNPLPlanEligibilityState.BNPLHidden.INSTANCE;
        }
        if (!bNPLEligiblePlanDetail.getBNPLEligibilityDetail().isBNPLEligible() && bNPLEligiblePlanDetail.getBNPLPlan().getPaymentCycles() == 1) {
            return new BNPLPlanEligibilityState.BNPLDeferredPlanError(bNPLEligiblePlanDetail.getBNPLEligibilityDetail().getBNPLValidationError(), bNPLEligiblePlanDetail.getBNPLPlan());
        }
        if (!bNPLEligiblePlanDetail.getBNPLEligibilityDetail().isBNPLEligible() && bNPLEligiblePlanDetail.getBNPLPlan().getPaymentCycles() > 1) {
            bNPLInstallmentPlan = new BNPLPlanEligibilityState.BNPLInstallmentPlanError(bNPLEligiblePlanDetail.getBNPLEligibilityDetail().getBNPLValidationError(), bNPLEligiblePlanDetail.getBNPLPlan(), CurrencyFormatter.Companion.formatAmount(locationConfigurationRepository, FloatKt.orZero(f11) / ((float) bNPLEligiblePlanDetail.getBNPLPlan().getPaymentCycles()), true));
        } else if (bNPLEligiblePlanDetail.getBNPLPlan().getPaymentCycles() == 1) {
            return new BNPLPlanEligibilityState.BNPLDeferredPlan(bNPLEligiblePlanDetail.getBNPLPlan());
        } else {
            if (bNPLEligiblePlanDetail.getBNPLPlan().getPaymentCycles() <= 1) {
                return BNPLPlanEligibilityState.BNPLHidden.INSTANCE;
            }
            bNPLInstallmentPlan = new BNPLPlanEligibilityState.BNPLInstallmentPlan(bNPLEligiblePlanDetail.getBNPLPlan(), CurrencyFormatter.Companion.formatAmount(locationConfigurationRepository, FloatKt.orZero(f11) / ((float) bNPLEligiblePlanDetail.getBNPLPlan().getPaymentCycles()), true));
        }
        return bNPLInstallmentPlan;
    }

    @NotNull
    public final BNPLPopUpViewState mapToBNPLPopViewDisplayModel(@NotNull BNPLEligiblePlanDetail bNPLEligiblePlanDetail, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(bNPLEligiblePlanDetail, "bNPLEligiblePlanDetail");
        if (!bNPLEligiblePlanDetail.getBNPLEligibilityDetail().isBNPLEligible()) {
            return new BNPLPopUpViewState.BNPLErrorPopUp(bNPLEligiblePlanDetail.getBNPLEligibilityDetail().getBNPLValidationError());
        }
        return new BNPLPopUpViewState.BNPLPlanPopUp(bNPLEligiblePlanDetail.getBNPLPlan(), z11, z12);
    }

    @NotNull
    public final CheckoutPaymentUpdateDisplayModel mapToPaymentMethodUpdateToDisplayModel(@Nullable CheckoutPaymentUpdateResult checkoutPaymentUpdateResult) {
        CheckoutPaymentUpdateDisplayModel showQPayBinsInfo;
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.KNetIsAvailable) {
            return CheckoutPaymentUpdateDisplayModel.ShowKNetPaymentOption.INSTANCE;
        }
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.KNetIsUnAvailable) {
            return CheckoutPaymentUpdateDisplayModel.ShowKNetFallback.INSTANCE;
        }
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.QPayIsAvailable) {
            return CheckoutPaymentUpdateDisplayModel.ShowQPayPaymentOption.INSTANCE;
        }
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.QPayIsNotAvailable) {
            return CheckoutPaymentUpdateDisplayModel.HideQPayPaymentOption.INSTANCE;
        }
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.DefaultPaymentMethod) {
            return CheckoutPaymentUpdateDisplayModel.ShowDefaultPaymentScreen.INSTANCE;
        }
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.QPayIsDown) {
            return CheckoutPaymentUpdateDisplayModel.ShowQPayFallback.INSTANCE;
        }
        if (checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.BenefitBinsInfo) {
            CheckoutPaymentUpdateResult.BenefitBinsInfo benefitBinsInfo = (CheckoutPaymentUpdateResult.BenefitBinsInfo) checkoutPaymentUpdateResult;
            showQPayBinsInfo = new CheckoutPaymentUpdateDisplayModel.ShowBenefitBinsInfo(benefitBinsInfo.getBins(), benefitBinsInfo.getBenefitCardDeflectionExpiryDate());
        } else if (!(checkoutPaymentUpdateResult instanceof CheckoutPaymentUpdateResult.QPayBinsInfo)) {
            return CheckoutPaymentUpdateDisplayModel.Loading.INSTANCE;
        } else {
            CheckoutPaymentUpdateResult.QPayBinsInfo qPayBinsInfo = (CheckoutPaymentUpdateResult.QPayBinsInfo) checkoutPaymentUpdateResult;
            showQPayBinsInfo = new CheckoutPaymentUpdateDisplayModel.ShowQPayBinsInfo(qPayBinsInfo.getBins(), qPayBinsInfo.getQPayCardDeflectionExpiryDate());
        }
        return showQPayBinsInfo;
    }

    @NotNull
    public final QPayRedirectUrlDisplayModel mapToQPayRedirectUrlDisplayModel(@Nullable QPayRedirectUrlResult qPayRedirectUrlResult) {
        if (qPayRedirectUrlResult instanceof QPayRedirectUrlResult.Error) {
            return QPayRedirectUrlDisplayModel.ShowQPayRedirectError.INSTANCE;
        }
        if (qPayRedirectUrlResult instanceof QPayRedirectUrlResult.RedirectToQPayThreeDSUrl) {
            return new QPayRedirectUrlDisplayModel.ShowQPayRedirectScreen(((QPayRedirectUrlResult.RedirectToQPayThreeDSUrl) qPayRedirectUrlResult).getRedirectUrl());
        }
        return QPayRedirectUrlDisplayModel.Loading.INSTANCE;
    }

    @NotNull
    public final WalletBalanceDisplayModel mapToWalletBalanceDisplayModel(@Nullable WalletBalanceResult walletBalanceResult) {
        if (walletBalanceResult instanceof WalletBalanceResult.WalletBalanceFailure) {
            return WalletBalanceDisplayModel.HideWalletBalance.INSTANCE;
        }
        boolean z11 = walletBalanceResult instanceof WalletBalanceResult.WalletBalanceSuccess;
        if (z11) {
            WalletBalanceResult.WalletBalanceSuccess walletBalanceSuccess = (WalletBalanceResult.WalletBalanceSuccess) walletBalanceResult;
            if (walletBalanceSuccess.getBalanceAmount() > 0.0f) {
                return new WalletBalanceDisplayModel.ShowWalletBalance(walletBalanceSuccess.getBalanceAmount());
            }
        }
        if (!z11 || ((WalletBalanceResult.WalletBalanceSuccess) walletBalanceResult).getBalanceAmount() > 0.0f) {
            return WalletBalanceDisplayModel.LoadingWalletBalance.INSTANCE;
        }
        return WalletBalanceDisplayModel.HideWalletBalance.INSTANCE;
    }
}
