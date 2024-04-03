package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "isWalletBalanceServiceCompleted", "", "isCardListServiceCompleted", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetWalletPaymentOptionViewConfigUseCase$invoke$1 extends Lambda implements Function2<Boolean, Boolean, WalletPaymentWidgetDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentWidgetDisplayModelParam f61731g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetWalletPaymentOptionViewConfigUseCase$invoke$1(WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam) {
        super(2);
        this.f61731g = walletPaymentWidgetDisplayModelParam;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
    }

    @Nullable
    public final WalletPaymentWidgetDisplayModel invoke(boolean z11, boolean z12) {
        if (!z11 || !z12) {
            return this.f61731g.getWalletPaymentWidgetDisplayModel();
        }
        PaymentMethod selectedPaymentMethod = this.f61731g.getWalletPaymentWidgetDisplayModel().getSelectedPaymentMethod();
        PaymentMethod paymentMethod = PaymentMethod.CARD;
        if (selectedPaymentMethod == paymentMethod && this.f61731g.getWalletBalance() >= this.f61731g.getAmount()) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel = this.f61731g.getWalletPaymentWidgetDisplayModel();
            WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam = this.f61731g;
            walletPaymentWidgetDisplayModel.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.SINGLE);
            walletPaymentWidgetDisplayModel.setSelectedPaymentMethod(paymentMethod);
            walletPaymentWidgetDisplayModel.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam.getAmount());
            walletPaymentWidgetDisplayModel.setShouldEnablePaymentButton(true);
            walletPaymentWidgetDisplayModel.setShouldShowCardTopUpMessage(true);
            return walletPaymentWidgetDisplayModel;
        } else if (this.f61731g.getWalletPaymentWidgetDisplayModel().getSelectedPaymentMethod() == paymentMethod && this.f61731g.getWalletBalance() > 0.0f) {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel2 = this.f61731g.getWalletPaymentWidgetDisplayModel();
            WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam2 = this.f61731g;
            walletPaymentWidgetDisplayModel2.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.WALLETANDCARD);
            walletPaymentWidgetDisplayModel2.setSelectedPaymentMethod(paymentMethod);
            walletPaymentWidgetDisplayModel2.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam2.getAmount());
            walletPaymentWidgetDisplayModel2.setShouldEnablePaymentButton(true);
            walletPaymentWidgetDisplayModel2.setShouldShowCardTopUpMessage(true);
            return walletPaymentWidgetDisplayModel2;
        } else if (this.f61731g.getWalletPaymentWidgetDisplayModel().getSelectedPaymentMethod() != paymentMethod || this.f61731g.getWalletBalance() > 0.0f) {
            PaymentMethod selectedPaymentMethod2 = this.f61731g.getWalletPaymentWidgetDisplayModel().getSelectedPaymentMethod();
            PaymentMethod paymentMethod2 = PaymentMethod.CASH;
            if (selectedPaymentMethod2 == paymentMethod2 && this.f61731g.getWalletBalance() >= this.f61731g.getAmount()) {
                WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel3 = this.f61731g.getWalletPaymentWidgetDisplayModel();
                WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam3 = this.f61731g;
                walletPaymentWidgetDisplayModel3.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.SINGLE);
                walletPaymentWidgetDisplayModel3.setSelectedPaymentMethod(paymentMethod2);
                walletPaymentWidgetDisplayModel3.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam3.getAmount());
                walletPaymentWidgetDisplayModel3.setShouldShowCashToPayMessage(true);
                walletPaymentWidgetDisplayModel3.setShouldEnablePaymentButton(true);
                return walletPaymentWidgetDisplayModel3;
            } else if (this.f61731g.getWalletPaymentWidgetDisplayModel().getSelectedPaymentMethod() == paymentMethod2 && this.f61731g.getWalletBalance() > 0.0f) {
                WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel4 = this.f61731g.getWalletPaymentWidgetDisplayModel();
                WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam4 = this.f61731g;
                walletPaymentWidgetDisplayModel4.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.CASHWITHDISABLEDWALLET);
                walletPaymentWidgetDisplayModel4.setSelectedPaymentMethod(paymentMethod2);
                walletPaymentWidgetDisplayModel4.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam4.getAmount());
                walletPaymentWidgetDisplayModel4.setShouldEnablePaymentButton(true);
                return walletPaymentWidgetDisplayModel4;
            } else if (!this.f61731g.isCardAvailable() && this.f61731g.getWalletBalance() < this.f61731g.getAmount()) {
                WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel5 = this.f61731g.getWalletPaymentWidgetDisplayModel();
                WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam5 = this.f61731g;
                walletPaymentWidgetDisplayModel5.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYWALLET);
                walletPaymentWidgetDisplayModel5.setSelectedPaymentMethod(PaymentMethod.NONE);
                walletPaymentWidgetDisplayModel5.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam5.getAmount());
                walletPaymentWidgetDisplayModel5.setShouldEnablePaymentButton(false);
                return walletPaymentWidgetDisplayModel5;
            } else if (!this.f61731g.isCardAvailable() && this.f61731g.getWalletBalance() >= this.f61731g.getAmount()) {
                WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel6 = this.f61731g.getWalletPaymentWidgetDisplayModel();
                WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam6 = this.f61731g;
                walletPaymentWidgetDisplayModel6.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYWALLET);
                walletPaymentWidgetDisplayModel6.setSelectedPaymentMethod(PaymentMethod.WALLET);
                walletPaymentWidgetDisplayModel6.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam6.getAmount());
                walletPaymentWidgetDisplayModel6.setShouldEnablePaymentButton(true);
                return walletPaymentWidgetDisplayModel6;
            } else if (this.f61731g.isCardAvailable() && this.f61731g.getWalletBalance() <= 0.0f) {
                WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel7 = this.f61731g.getWalletPaymentWidgetDisplayModel();
                WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam7 = this.f61731g;
                walletPaymentWidgetDisplayModel7.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYCARD);
                walletPaymentWidgetDisplayModel7.setSelectedPaymentMethod(paymentMethod);
                walletPaymentWidgetDisplayModel7.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam7.getAmount());
                walletPaymentWidgetDisplayModel7.setShouldEnablePaymentButton(true);
                return walletPaymentWidgetDisplayModel7;
            } else if (!this.f61731g.isCardAvailable() || this.f61731g.getWalletBalance() < this.f61731g.getAmount()) {
                WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel8 = this.f61731g.getWalletPaymentWidgetDisplayModel();
                WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam8 = this.f61731g;
                walletPaymentWidgetDisplayModel8.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.WALLETANDCARD);
                walletPaymentWidgetDisplayModel8.setSelectedPaymentMethod(PaymentMethod.MIXED);
                walletPaymentWidgetDisplayModel8.setShouldEnablePaymentButton(true);
                walletPaymentWidgetDisplayModel8.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam8.getAmount() - walletPaymentWidgetDisplayModelParam8.getWalletBalance());
                return walletPaymentWidgetDisplayModel8;
            } else {
                WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel9 = this.f61731g.getWalletPaymentWidgetDisplayModel();
                WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam9 = this.f61731g;
                walletPaymentWidgetDisplayModel9.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.SINGLE);
                walletPaymentWidgetDisplayModel9.setSelectedPaymentMethod(PaymentMethod.WALLET);
                walletPaymentWidgetDisplayModel9.setShouldEnablePaymentButton(true);
                walletPaymentWidgetDisplayModel9.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam9.getAmount());
                return walletPaymentWidgetDisplayModel9;
            }
        } else {
            WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel10 = this.f61731g.getWalletPaymentWidgetDisplayModel();
            WalletPaymentWidgetDisplayModelParam walletPaymentWidgetDisplayModelParam10 = this.f61731g;
            walletPaymentWidgetDisplayModel10.setDisplayViewType(WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYCARD);
            walletPaymentWidgetDisplayModel10.setSelectedPaymentMethod(paymentMethod);
            walletPaymentWidgetDisplayModel10.setAmountToBalanceFromCard(walletPaymentWidgetDisplayModelParam10.getAmount());
            walletPaymentWidgetDisplayModel10.setShouldEnablePaymentButton(true);
            walletPaymentWidgetDisplayModel10.setShouldShowCardTopUpMessage(true);
            return walletPaymentWidgetDisplayModel10;
        }
    }
}
