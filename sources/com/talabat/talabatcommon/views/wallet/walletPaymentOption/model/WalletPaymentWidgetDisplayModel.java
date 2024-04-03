package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "", "()V", "amountToBalanceFromCard", "", "getAmountToBalanceFromCard", "()F", "setAmountToBalanceFromCard", "(F)V", "displayViewType", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel$PaymentOptionViewType;", "getDisplayViewType", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel$PaymentOptionViewType;", "setDisplayViewType", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel$PaymentOptionViewType;)V", "selectedPaymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "getSelectedPaymentMethod", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "setSelectedPaymentMethod", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;)V", "shouldEnablePaymentButton", "", "getShouldEnablePaymentButton", "()Z", "setShouldEnablePaymentButton", "(Z)V", "shouldShowCardTopUpMessage", "getShouldShowCardTopUpMessage", "setShouldShowCardTopUpMessage", "shouldShowCashToPayMessage", "getShouldShowCashToPayMessage", "setShouldShowCashToPayMessage", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentWidgetDisplayModel {
    private float amountToBalanceFromCard;
    @NotNull
    private WalletPaymentOptionViewModel.PaymentOptionViewType displayViewType = WalletPaymentOptionViewModel.PaymentOptionViewType.NONE;
    @NotNull
    private PaymentMethod selectedPaymentMethod = PaymentMethod.NONE;
    private boolean shouldEnablePaymentButton;
    private boolean shouldShowCardTopUpMessage;
    private boolean shouldShowCashToPayMessage;

    public final float getAmountToBalanceFromCard() {
        return this.amountToBalanceFromCard;
    }

    @NotNull
    public final WalletPaymentOptionViewModel.PaymentOptionViewType getDisplayViewType() {
        return this.displayViewType;
    }

    @NotNull
    public final PaymentMethod getSelectedPaymentMethod() {
        return this.selectedPaymentMethod;
    }

    public final boolean getShouldEnablePaymentButton() {
        return this.shouldEnablePaymentButton;
    }

    public final boolean getShouldShowCardTopUpMessage() {
        return this.shouldShowCardTopUpMessage;
    }

    public final boolean getShouldShowCashToPayMessage() {
        return this.shouldShowCashToPayMessage;
    }

    public final void setAmountToBalanceFromCard(float f11) {
        this.amountToBalanceFromCard = f11;
    }

    public final void setDisplayViewType(@NotNull WalletPaymentOptionViewModel.PaymentOptionViewType paymentOptionViewType) {
        Intrinsics.checkNotNullParameter(paymentOptionViewType, "<set-?>");
        this.displayViewType = paymentOptionViewType;
    }

    public final void setSelectedPaymentMethod(@NotNull PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "<set-?>");
        this.selectedPaymentMethod = paymentMethod;
    }

    public final void setShouldEnablePaymentButton(boolean z11) {
        this.shouldEnablePaymentButton = z11;
    }

    public final void setShouldShowCardTopUpMessage(boolean z11) {
        this.shouldShowCardTopUpMessage = z11;
    }

    public final void setShouldShowCashToPayMessage(boolean z11) {
        this.shouldShowCashToPayMessage = z11;
    }
}
