package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpSuggestionsAndLimitsDisplayModel;", "", "suggestionsList", "", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpAmountSuggestionDisplayModel;", "maxTopUpAmount", "", "minTopUpAmount", "(Ljava/util/List;II)V", "getMaxTopUpAmount", "()I", "getMinTopUpAmount", "getSuggestionsList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpSuggestionsAndLimitsDisplayModel {
    private final int maxTopUpAmount;
    private final int minTopUpAmount;
    @NotNull
    private final List<WalletTopUpAmountSuggestionDisplayModel> suggestionsList;

    public WalletTopUpSuggestionsAndLimitsDisplayModel(@NotNull List<WalletTopUpAmountSuggestionDisplayModel> list, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "suggestionsList");
        this.suggestionsList = list;
        this.maxTopUpAmount = i11;
        this.minTopUpAmount = i12;
    }

    public static /* synthetic */ WalletTopUpSuggestionsAndLimitsDisplayModel copy$default(WalletTopUpSuggestionsAndLimitsDisplayModel walletTopUpSuggestionsAndLimitsDisplayModel, List<WalletTopUpAmountSuggestionDisplayModel> list, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            list = walletTopUpSuggestionsAndLimitsDisplayModel.suggestionsList;
        }
        if ((i13 & 2) != 0) {
            i11 = walletTopUpSuggestionsAndLimitsDisplayModel.maxTopUpAmount;
        }
        if ((i13 & 4) != 0) {
            i12 = walletTopUpSuggestionsAndLimitsDisplayModel.minTopUpAmount;
        }
        return walletTopUpSuggestionsAndLimitsDisplayModel.copy(list, i11, i12);
    }

    @NotNull
    public final List<WalletTopUpAmountSuggestionDisplayModel> component1() {
        return this.suggestionsList;
    }

    public final int component2() {
        return this.maxTopUpAmount;
    }

    public final int component3() {
        return this.minTopUpAmount;
    }

    @NotNull
    public final WalletTopUpSuggestionsAndLimitsDisplayModel copy(@NotNull List<WalletTopUpAmountSuggestionDisplayModel> list, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "suggestionsList");
        return new WalletTopUpSuggestionsAndLimitsDisplayModel(list, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTopUpSuggestionsAndLimitsDisplayModel)) {
            return false;
        }
        WalletTopUpSuggestionsAndLimitsDisplayModel walletTopUpSuggestionsAndLimitsDisplayModel = (WalletTopUpSuggestionsAndLimitsDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.suggestionsList, (Object) walletTopUpSuggestionsAndLimitsDisplayModel.suggestionsList) && this.maxTopUpAmount == walletTopUpSuggestionsAndLimitsDisplayModel.maxTopUpAmount && this.minTopUpAmount == walletTopUpSuggestionsAndLimitsDisplayModel.minTopUpAmount;
    }

    public final int getMaxTopUpAmount() {
        return this.maxTopUpAmount;
    }

    public final int getMinTopUpAmount() {
        return this.minTopUpAmount;
    }

    @NotNull
    public final List<WalletTopUpAmountSuggestionDisplayModel> getSuggestionsList() {
        return this.suggestionsList;
    }

    public int hashCode() {
        return (((this.suggestionsList.hashCode() * 31) + this.maxTopUpAmount) * 31) + this.minTopUpAmount;
    }

    @NotNull
    public String toString() {
        List<WalletTopUpAmountSuggestionDisplayModel> list = this.suggestionsList;
        int i11 = this.maxTopUpAmount;
        int i12 = this.minTopUpAmount;
        return "WalletTopUpSuggestionsAndLimitsDisplayModel(suggestionsList=" + list + ", maxTopUpAmount=" + i11 + ", minTopUpAmount=" + i12 + ")";
    }
}
