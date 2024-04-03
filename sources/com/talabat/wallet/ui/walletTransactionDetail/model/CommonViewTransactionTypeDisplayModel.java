package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/CommonViewTransactionTypeDisplayModel;", "", "headerInfo", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "cashBack", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;)V", "getCashBack", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;", "setCashBack", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;)V", "getHeaderInfo", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "setHeaderInfo", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonViewTransactionTypeDisplayModel {
    @NotNull
    private CashBackWalletTransactionModel cashBack;
    @NotNull
    private WalletTransactionDetailHeaderDisplayModel headerInfo;

    public CommonViewTransactionTypeDisplayModel() {
        this((WalletTransactionDetailHeaderDisplayModel) null, (CashBackWalletTransactionModel) null, 3, (DefaultConstructorMarker) null);
    }

    public CommonViewTransactionTypeDisplayModel(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, @NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "headerInfo");
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT);
        this.headerInfo = walletTransactionDetailHeaderDisplayModel;
        this.cashBack = cashBackWalletTransactionModel;
    }

    public static /* synthetic */ CommonViewTransactionTypeDisplayModel copy$default(CommonViewTransactionTypeDisplayModel commonViewTransactionTypeDisplayModel, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, CashBackWalletTransactionModel cashBackWalletTransactionModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletTransactionDetailHeaderDisplayModel = commonViewTransactionTypeDisplayModel.headerInfo;
        }
        if ((i11 & 2) != 0) {
            cashBackWalletTransactionModel = commonViewTransactionTypeDisplayModel.cashBack;
        }
        return commonViewTransactionTypeDisplayModel.copy(walletTransactionDetailHeaderDisplayModel, cashBackWalletTransactionModel);
    }

    @NotNull
    public final WalletTransactionDetailHeaderDisplayModel component1() {
        return this.headerInfo;
    }

    @NotNull
    public final CashBackWalletTransactionModel component2() {
        return this.cashBack;
    }

    @NotNull
    public final CommonViewTransactionTypeDisplayModel copy(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, @NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "headerInfo");
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT);
        return new CommonViewTransactionTypeDisplayModel(walletTransactionDetailHeaderDisplayModel, cashBackWalletTransactionModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonViewTransactionTypeDisplayModel)) {
            return false;
        }
        CommonViewTransactionTypeDisplayModel commonViewTransactionTypeDisplayModel = (CommonViewTransactionTypeDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.headerInfo, (Object) commonViewTransactionTypeDisplayModel.headerInfo) && Intrinsics.areEqual((Object) this.cashBack, (Object) commonViewTransactionTypeDisplayModel.cashBack);
    }

    @NotNull
    public final CashBackWalletTransactionModel getCashBack() {
        return this.cashBack;
    }

    @NotNull
    public final WalletTransactionDetailHeaderDisplayModel getHeaderInfo() {
        return this.headerInfo;
    }

    public int hashCode() {
        return (this.headerInfo.hashCode() * 31) + this.cashBack.hashCode();
    }

    public final void setCashBack(@NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel) {
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, "<set-?>");
        this.cashBack = cashBackWalletTransactionModel;
    }

    public final void setHeaderInfo(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "<set-?>");
        this.headerInfo = walletTransactionDetailHeaderDisplayModel;
    }

    @NotNull
    public String toString() {
        WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = this.headerInfo;
        CashBackWalletTransactionModel cashBackWalletTransactionModel = this.cashBack;
        return "CommonViewTransactionTypeDisplayModel(headerInfo=" + walletTransactionDetailHeaderDisplayModel + ", cashBack=" + cashBackWalletTransactionModel + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CommonViewTransactionTypeDisplayModel(com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel r16, com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r15 = this;
            r0 = r18 & 1
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
            r1 = r18 & 2
            if (r1 == 0) goto L_0x002c
            com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel r1 = new com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 7
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = r15
            goto L_0x002f
        L_0x002c:
            r2 = r15
            r1 = r17
        L_0x002f:
            r15.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletTransactionDetail.model.CommonViewTransactionTypeDisplayModel.<init>(com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel, com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
