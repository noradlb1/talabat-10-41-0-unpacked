package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.configuration.country.Country;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaidWalletTransactionTypeDisplayModel;", "", "cashBack", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;", "headerInfo", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "selectedCountry", "Lcom/talabat/configuration/country/Country;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;Lcom/talabat/configuration/country/Country;)V", "getCashBack", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;", "setCashBack", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;)V", "getHeaderInfo", "()Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "setHeaderInfo", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;)V", "getSelectedCountry", "()Lcom/talabat/configuration/country/Country;", "setSelectedCountry", "(Lcom/talabat/configuration/country/Country;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaidWalletTransactionTypeDisplayModel {
    @NotNull
    private CashBackWalletTransactionModel cashBack;
    @NotNull
    private WalletTransactionDetailHeaderDisplayModel headerInfo;
    @NotNull
    private Country selectedCountry;

    public PaidWalletTransactionTypeDisplayModel() {
        this((CashBackWalletTransactionModel) null, (WalletTransactionDetailHeaderDisplayModel) null, (Country) null, 7, (DefaultConstructorMarker) null);
    }

    public PaidWalletTransactionTypeDisplayModel(@NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel, @NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, @NotNull Country country) {
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT);
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "headerInfo");
        Intrinsics.checkNotNullParameter(country, "selectedCountry");
        this.cashBack = cashBackWalletTransactionModel;
        this.headerInfo = walletTransactionDetailHeaderDisplayModel;
        this.selectedCountry = country;
    }

    public static /* synthetic */ PaidWalletTransactionTypeDisplayModel copy$default(PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel, CashBackWalletTransactionModel cashBackWalletTransactionModel, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, Country country, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cashBackWalletTransactionModel = paidWalletTransactionTypeDisplayModel.cashBack;
        }
        if ((i11 & 2) != 0) {
            walletTransactionDetailHeaderDisplayModel = paidWalletTransactionTypeDisplayModel.headerInfo;
        }
        if ((i11 & 4) != 0) {
            country = paidWalletTransactionTypeDisplayModel.selectedCountry;
        }
        return paidWalletTransactionTypeDisplayModel.copy(cashBackWalletTransactionModel, walletTransactionDetailHeaderDisplayModel, country);
    }

    @NotNull
    public final CashBackWalletTransactionModel component1() {
        return this.cashBack;
    }

    @NotNull
    public final WalletTransactionDetailHeaderDisplayModel component2() {
        return this.headerInfo;
    }

    @NotNull
    public final Country component3() {
        return this.selectedCountry;
    }

    @NotNull
    public final PaidWalletTransactionTypeDisplayModel copy(@NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel, @NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, @NotNull Country country) {
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT);
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "headerInfo");
        Intrinsics.checkNotNullParameter(country, "selectedCountry");
        return new PaidWalletTransactionTypeDisplayModel(cashBackWalletTransactionModel, walletTransactionDetailHeaderDisplayModel, country);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaidWalletTransactionTypeDisplayModel)) {
            return false;
        }
        PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel = (PaidWalletTransactionTypeDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.cashBack, (Object) paidWalletTransactionTypeDisplayModel.cashBack) && Intrinsics.areEqual((Object) this.headerInfo, (Object) paidWalletTransactionTypeDisplayModel.headerInfo) && this.selectedCountry == paidWalletTransactionTypeDisplayModel.selectedCountry;
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
    public final Country getSelectedCountry() {
        return this.selectedCountry;
    }

    public int hashCode() {
        return (((this.cashBack.hashCode() * 31) + this.headerInfo.hashCode()) * 31) + this.selectedCountry.hashCode();
    }

    public final void setCashBack(@NotNull CashBackWalletTransactionModel cashBackWalletTransactionModel) {
        Intrinsics.checkNotNullParameter(cashBackWalletTransactionModel, "<set-?>");
        this.cashBack = cashBackWalletTransactionModel;
    }

    public final void setHeaderInfo(@NotNull WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailHeaderDisplayModel, "<set-?>");
        this.headerInfo = walletTransactionDetailHeaderDisplayModel;
    }

    public final void setSelectedCountry(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "<set-?>");
        this.selectedCountry = country;
    }

    @NotNull
    public String toString() {
        CashBackWalletTransactionModel cashBackWalletTransactionModel = this.cashBack;
        WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = this.headerInfo;
        Country country = this.selectedCountry;
        return "PaidWalletTransactionTypeDisplayModel(cashBack=" + cashBackWalletTransactionModel + ", headerInfo=" + walletTransactionDetailHeaderDisplayModel + ", selectedCountry=" + country + ")";
    }

    public /* synthetic */ PaidWalletTransactionTypeDisplayModel(CashBackWalletTransactionModel cashBackWalletTransactionModel, WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, Country country, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel;
        Country country2;
        CashBackWalletTransactionModel cashBackWalletTransactionModel2 = (i11 & 1) != 0 ? new CashBackWalletTransactionModel(0.0f, 0, (String) null, 7, (DefaultConstructorMarker) null) : cashBackWalletTransactionModel;
        WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel2 = (i11 & 2) != 0 ? new WalletTransactionDetailHeaderDisplayModel(0, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, (String) null, (String) null, (String) null, 0, 2047, (DefaultConstructorMarker) null) : walletTransactionDetailHeaderDisplayModel;
        if ((i11 & 4) != 0) {
            country2 = Country.UNDEFINED;
            paidWalletTransactionTypeDisplayModel = this;
        } else {
            paidWalletTransactionTypeDisplayModel = this;
            country2 = country;
        }
        new PaidWalletTransactionTypeDisplayModel(cashBackWalletTransactionModel2, walletTransactionDetailHeaderDisplayModel2, country2);
    }
}
