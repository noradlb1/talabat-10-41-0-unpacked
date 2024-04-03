package com.talabat.talabatlife.ui.onBoarding;

import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentBottomSheetInterface;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import com.talabat.talabatlife.ui.onBoarding.viewModel.TLifeOnBoardingViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/talabatlife/ui/onBoarding/TLifeOnBoardingFragment$paymentBottomSheetInterface$1", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentBottomSheetInterface;", "getCardClicked", "", "sendCardDetailsToParentScreen", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "sendPaymentWidgetClosedEvent", "paymentStatus", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;", "transactionId", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingFragment$paymentBottomSheetInterface$1 implements PaymentBottomSheetInterface {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TLifeOnBoardingFragment f12065b;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WalletPaymentStatus.values().length];
            iArr[WalletPaymentStatus.SUCCESS.ordinal()] = 1;
            iArr[WalletPaymentStatus.FAILURE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TLifeOnBoardingFragment$paymentBottomSheetInterface$1(TLifeOnBoardingFragment tLifeOnBoardingFragment) {
        this.f12065b = tLifeOnBoardingFragment;
    }

    public void getCardClicked() {
        TLifeOnBoardingFragment.access$getViewModel(this.f12065b).sendSubscriptionAttemptedEvent();
    }

    public void sendCardDetailsToParentScreen(@NotNull WalletCardDisplayModel walletCardDisplayModel, @NotNull PaymentMethod paymentMethod) {
        String str;
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        TLifeOnBoardingViewModel access$getViewModel = TLifeOnBoardingFragment.access$getViewModel(this.f12065b);
        TLifeOnBoardingViewModel access$getViewModel2 = TLifeOnBoardingFragment.access$getViewModel(this.f12065b);
        TLifeOnBoardingPlanDisplayModel value = TLifeOnBoardingFragment.access$getViewModel(this.f12065b).getPlansData().getValue();
        if (value != null) {
            str = value.getPlanId();
        } else {
            str = null;
        }
        access$getViewModel.payForSubscription(access$getViewModel2.getSubscriptionPaymentRequestModel(walletCardDisplayModel, str));
    }

    public void sendPaymentWidgetClosedEvent(@NotNull WalletPaymentStatus walletPaymentStatus, @NotNull String str) {
        Intrinsics.checkNotNullParameter(walletPaymentStatus, "paymentStatus");
        Intrinsics.checkNotNullParameter(str, "transactionId");
        int i11 = WhenMappings.$EnumSwitchMapping$0[walletPaymentStatus.ordinal()];
        if (i11 == 1) {
            this.f12065b.navigateToRestaurantList();
            this.f12065b.fireTackingEventSubscriptionCompleted();
        } else if (i11 != 2) {
            LogManager.debug("unexpected payment status");
        } else {
            this.f12065b.showSubscriptionFailed("Authentication failed");
        }
    }
}
