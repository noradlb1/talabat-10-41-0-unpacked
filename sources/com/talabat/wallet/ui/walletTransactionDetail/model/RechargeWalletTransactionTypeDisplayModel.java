package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/RechargeWalletTransactionTypeDisplayModel;", "", "headerInfo", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "payment", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;", "cashBack", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;)V", "getCashBack", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;", "setCashBack", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;)V", "getHeaderInfo", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "setHeaderInfo", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", "getPayment", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;", "setPayment", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaymentWalletTransactionDisplayModel;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RechargeWalletTransactionTypeDisplayModel {
    @NotNull
    private CashBackWalletTransactionModel cashBack;
    @NotNull
    private WalletTransactionDetailHeaderDisplayModel headerInfo;
    @NotNull
    private PaymentWalletTransactionDisplayModel payment;

    public RechargeWalletTransactionTypeDisplayModel() {
        this((WalletTransactionDetailHeaderDisplayModel) null, (PaymentWalletTransactionDisplayModel) null, (CashBackWalletTransactionModel) null, 7, (DefaultConstructorMarker) null);
    }

    public RechargeWalletTransactionTypeDisplayModel(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, @NotNull PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, @NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "headerInfo");
        Intrinsics.checkNotNullParameter(paymentWalletTransactionDisplayModel, "payment");
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT);
        this.headerInfo = walletTransactionDetailHeaderDisplayModel;
        this.payment = paymentWalletTransactionDisplayModel;
        this.cashBack = cashBackWalletTransactionModel;
    }

    public static /* synthetic */ RechargeWalletTransactionTypeDisplayModel copy$default(RechargeWalletTransactionTypeDisplayModel rechargeWalletTransactionTypeDisplayModel, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, CashBackWalletTransactionModel cashBackWalletTransactionModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletTransactionDetailHeaderDisplayModel = rechargeWalletTransactionTypeDisplayModel.headerInfo;
        }
        if ((i11 & 2) != 0) {
            paymentWalletTransactionDisplayModel = rechargeWalletTransactionTypeDisplayModel.payment;
        }
        if ((i11 & 4) != 0) {
            cashBackWalletTransactionModel = rechargeWalletTransactionTypeDisplayModel.cashBack;
        }
        return rechargeWalletTransactionTypeDisplayModel.copy(walletTransactionDetailHeaderDisplayModel, paymentWalletTransactionDisplayModel, cashBackWalletTransactionModel);
    }

    @NotNull
    public final WalletTransactionDetailHeaderDisplayModel component1() {
        return this.headerInfo;
    }

    @NotNull
    public final PaymentWalletTransactionDisplayModel component2() {
        return this.payment;
    }

    @NotNull
    public final CashBackWalletTransactionModel component3() {
        return this.cashBack;
    }

    @NotNull
    public final RechargeWalletTransactionTypeDisplayModel copy(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, @NotNull PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel, @NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "headerInfo");
        Intrinsics.checkNotNullParameter(paymentWalletTransactionDisplayModel, "payment");
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT);
        return new RechargeWalletTransactionTypeDisplayModel(walletTransactionDetailHeaderDisplayModel, paymentWalletTransactionDisplayModel, cashBackWalletTransactionModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RechargeWalletTransactionTypeDisplayModel)) {
            return false;
        }
        RechargeWalletTransactionTypeDisplayModel rechargeWalletTransactionTypeDisplayModel = (RechargeWalletTransactionTypeDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.headerInfo, (Object) rechargeWalletTransactionTypeDisplayModel.headerInfo) && Intrinsics.areEqual((Object) this.payment, (Object) rechargeWalletTransactionTypeDisplayModel.payment) && Intrinsics.areEqual((Object) this.cashBack, (Object) rechargeWalletTransactionTypeDisplayModel.cashBack);
    }

    @NotNull
    public final CashBackWalletTransactionModel getCashBack() {
        return this.cashBack;
    }

    @NotNull
    public final WalletTransactionDetailHeaderDisplayModel getHeaderInfo() {
        return this.headerInfo;
    }

    @NotNull
    public final PaymentWalletTransactionDisplayModel getPayment() {
        return this.payment;
    }

    public int hashCode() {
        return (((this.headerInfo.hashCode() * 31) + this.payment.hashCode()) * 31) + this.cashBack.hashCode();
    }

    public final void setCashBack(@NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel) {
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, "<set-?>");
        this.cashBack = cashBackWalletTransactionModel;
    }

    public final void setHeaderInfo(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "<set-?>");
        this.headerInfo = walletTransactionDetailHeaderDisplayModel;
    }

    public final void setPayment(@NotNull PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel) {
        Intrinsics.checkNotNullParameter(paymentWalletTransactionDisplayModel, "<set-?>");
        this.payment = paymentWalletTransactionDisplayModel;
    }

    @NotNull
    public String toString() {
        WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = this.headerInfo;
        PaymentWalletTransactionDisplayModel paymentWalletTransactionDisplayModel = this.payment;
        CashBackWalletTransactionModel cashBackWalletTransactionModel = this.cashBack;
        return "RechargeWalletTransactionTypeDisplayModel(headerInfo=" + walletTransactionDetailHeaderDisplayModel + ", payment=" + paymentWalletTransactionDisplayModel + ", cashBack=" + cashBackWalletTransactionModel + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RechargeWalletTransactionTypeDisplayModel(com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel r16, com.talabat.wallet.ui.walletTransactionDetail.model.PaymentWalletTransactionDisplayModel r17, com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r15 = this;
            r0 = r19 & 1
            if (r0 == 0) goto L_0x0019
            com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel r0 = new com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 2047(0x7ff, float:2.868E-42)
            r14 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x001b
        L_0x0019:
            r0 = r16
        L_0x001b:
            r1 = r19 & 2
            if (r1 == 0) goto L_0x002b
            com.talabat.wallet.ui.walletTransactionDetail.model.PaymentWalletTransactionDisplayModel r1 = new com.talabat.wallet.ui.walletTransactionDetail.model.PaymentWalletTransactionDisplayModel
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 7
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x002d
        L_0x002b:
            r1 = r17
        L_0x002d:
            r2 = r19 & 4
            if (r2 == 0) goto L_0x003e
            com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel r2 = new com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 7
            r8 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            r3 = r15
            goto L_0x0041
        L_0x003e:
            r3 = r15
            r2 = r18
        L_0x0041:
            r15.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletTransactionDetail.model.RechargeWalletTransactionTypeDisplayModel.<init>(com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel, com.talabat.wallet.ui.walletTransactionDetail.model.PaymentWalletTransactionDisplayModel, com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
