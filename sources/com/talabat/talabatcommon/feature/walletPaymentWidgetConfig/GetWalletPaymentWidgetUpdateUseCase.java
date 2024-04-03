package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentWidgetUpdateUseCase;", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/WalletPaymentWidgetDisplayModelParam;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "()V", "invoke", "param", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWalletPaymentWidgetUpdateUseCase implements Function1<WalletPaymentWidgetDisplayModelParam, WalletPaymentWidgetDisplayModel> {
    @NotNull
    public WalletPaymentWidgetDisplayModel invoke(@NotNull WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam) {
        Intrinsics.checkNotNullParameter(walletPaymentWidgetDisplayModelParam, RemoteMessageConst.MessageBody.PARAM);
        if (BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.isCardAvailable() && walletPaymentWidgetDisplayModelParam.getWalletBalance() >= walletPaymentWidgetDisplayModelParam.getAmount()) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel.setSelectedPaymentMethod(PaymentMethod.WALLET);
            walletPaymentWidgetDisplayModel.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount() - walletPaymentWidgetDisplayModelParam.getWalletBalance());
            walletPaymentWidgetDisplayModel.setShouldShowCardTopUpMessage(false);
            walletPaymentWidgetDisplayModel.setShouldEnablePaymentButton(true);
            return walletPaymentWidgetDisplayModel;
        } else if (BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.getWalletBalance() < walletPaymentWidgetDisplayModelParam.getAmount() && walletPaymentWidgetDisplayModelParam.isCardAvailable() && walletPaymentWidgetDisplayModelParam.isCardSupported()) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel2 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel2.setSelectedPaymentMethod(PaymentMethod.MIXED);
            walletPaymentWidgetDisplayModel2.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount() - walletPaymentWidgetDisplayModelParam.getWalletBalance());
            walletPaymentWidgetDisplayModel2.setShouldShowCardTopUpMessage(true);
            walletPaymentWidgetDisplayModel2.setShouldEnablePaymentButton(true);
            return walletPaymentWidgetDisplayModel2;
        } else if (BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.getWalletBalance() < walletPaymentWidgetDisplayModelParam.getAmount() && !walletPaymentWidgetDisplayModelParam.isCardAvailable()) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel3 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel3.setSelectedPaymentMethod(PaymentMethod.WALLET);
            walletPaymentWidgetDisplayModel3.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount());
            walletPaymentWidgetDisplayModel3.setShouldShowCardTopUpMessage(false);
            walletPaymentWidgetDisplayModel3.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYWALLET);
            return walletPaymentWidgetDisplayModel3;
        } else if (BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.getWalletBalance() >= walletPaymentWidgetDisplayModelParam.getAmount() && !walletPaymentWidgetDisplayModelParam.isCardAvailable()) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel4 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel4.setSelectedPaymentMethod(PaymentMethod.WALLET);
            walletPaymentWidgetDisplayModel4.setShouldShowCardTopUpMessage(false);
            walletPaymentWidgetDisplayModel4.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYWALLET);
            walletPaymentWidgetDisplayModel4.setShouldEnablePaymentButton(true);
            return walletPaymentWidgetDisplayModel4;
        } else if (!BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.getWalletBalance() <= 0.0f && walletPaymentWidgetDisplayModelParam.isCardAvailable()) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel5 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel5.setSelectedPaymentMethod(PaymentMethod.CARD);
            walletPaymentWidgetDisplayModel5.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount());
            walletPaymentWidgetDisplayModel5.setShouldShowCardTopUpMessage(true);
            walletPaymentWidgetDisplayModel5.setShouldEnablePaymentButton(true);
            return walletPaymentWidgetDisplayModel5;
        } else if (!BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && !walletPaymentWidgetDisplayModelParam.isCardSupported()) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel6 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel6.setSelectedPaymentMethod(PaymentMethod.CARD);
            walletPaymentWidgetDisplayModel6.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount());
            walletPaymentWidgetDisplayModel6.setShouldShowCardTopUpMessage(true);
            walletPaymentWidgetDisplayModel6.setShouldEnablePaymentButton(false);
            return walletPaymentWidgetDisplayModel6;
        } else if (!BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel().getDisplayViewType() == WalletPaymentOptionViewModel.PaymentOptionViewType.WALLETANDCARD) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel7 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel7.setSelectedPaymentMethod(PaymentMethod.CARD);
            walletPaymentWidgetDisplayModel7.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount());
            walletPaymentWidgetDisplayModel7.setShouldShowCardTopUpMessage(true);
            walletPaymentWidgetDisplayModel7.setShouldEnablePaymentButton(true);
            return walletPaymentWidgetDisplayModel7;
        } else if (!BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel().getDisplayViewType() == WalletPaymentOptionViewModel.PaymentOptionViewType.SINGLE) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel8 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel8.setSelectedPaymentMethod(PaymentMethod.CARD);
            walletPaymentWidgetDisplayModel8.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount());
            walletPaymentWidgetDisplayModel8.setShouldShowCardTopUpMessage(true);
            walletPaymentWidgetDisplayModel8.setShouldEnablePaymentButton(true);
            return walletPaymentWidgetDisplayModel8;
        } else if (!BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel().getDisplayViewType() == WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYCARD) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel9 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel9.setSelectedPaymentMethod(PaymentMethod.CARD);
            walletPaymentWidgetDisplayModel9.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount());
            walletPaymentWidgetDisplayModel9.setShouldShowCardTopUpMessage(true);
            walletPaymentWidgetDisplayModel9.setShouldEnablePaymentButton(true);
            return walletPaymentWidgetDisplayModel9;
        } else if (!BooleanKt.orFalse(walletPaymentWidgetDisplayModelParam.isChecked()) && walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel().getDisplayViewType() == WalletPaymentOptionViewModel.PaymentOptionViewType.CASHWITHDISABLEDWALLET) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel10 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel10.setSelectedPaymentMethod(PaymentMethod.CASH);
            walletPaymentWidgetDisplayModel10.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount());
            walletPaymentWidgetDisplayModel10.setShouldShowCashToPayMessage(true);
            walletPaymentWidgetDisplayModel10.setShouldEnablePaymentButton(true);
            return walletPaymentWidgetDisplayModel10;
        } else if (walletPaymentWidgetDisplayModelParam.isCardSupported()) {
            return walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
        } else {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel11 = walletPaymentWidgetDisplayModelParam.getWalletPaymentWidgetDisplayModel();
            walletPaymentWidgetDisplayModel11.setShouldEnablePaymentButton(false);
            return walletPaymentWidgetDisplayModel11;
        }
    }
}
