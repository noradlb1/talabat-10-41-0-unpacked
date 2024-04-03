package com.talabat.talabatcommon.feature.walletPayment.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletTopUpSuggestionsAndLimitsResultModel;", "", "topUpAmountSuggestions", "", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletTopUpAmountSuggestion;", "minTopUpAmount", "", "maxTopUpAmount", "(Ljava/util/List;II)V", "getMaxTopUpAmount", "()I", "getMinTopUpAmount", "getTopUpAmountSuggestions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpSuggestionsAndLimitsResultModel {
    @SerializedName("maxTopupAmount")
    private final int maxTopUpAmount;
    @SerializedName("minTopupAmount")
    private final int minTopUpAmount;
    @SerializedName("topupSuggestions")
    @Nullable
    private final List<WalletTopUpAmountSuggestion> topUpAmountSuggestions;

    public WalletTopUpSuggestionsAndLimitsResultModel(@Nullable List<WalletTopUpAmountSuggestion> list, int i11, int i12) {
        this.topUpAmountSuggestions = list;
        this.minTopUpAmount = i11;
        this.maxTopUpAmount = i12;
    }

    public static /* synthetic */ WalletTopUpSuggestionsAndLimitsResultModel copy$default(WalletTopUpSuggestionsAndLimitsResultModel walletTopUpSuggestionsAndLimitsResultModel, List<WalletTopUpAmountSuggestion> list, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            list = walletTopUpSuggestionsAndLimitsResultModel.topUpAmountSuggestions;
        }
        if ((i13 & 2) != 0) {
            i11 = walletTopUpSuggestionsAndLimitsResultModel.minTopUpAmount;
        }
        if ((i13 & 4) != 0) {
            i12 = walletTopUpSuggestionsAndLimitsResultModel.maxTopUpAmount;
        }
        return walletTopUpSuggestionsAndLimitsResultModel.copy(list, i11, i12);
    }

    @Nullable
    public final List<WalletTopUpAmountSuggestion> component1() {
        return this.topUpAmountSuggestions;
    }

    public final int component2() {
        return this.minTopUpAmount;
    }

    public final int component3() {
        return this.maxTopUpAmount;
    }

    @NotNull
    public final WalletTopUpSuggestionsAndLimitsResultModel copy(@Nullable List<WalletTopUpAmountSuggestion> list, int i11, int i12) {
        return new WalletTopUpSuggestionsAndLimitsResultModel(list, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTopUpSuggestionsAndLimitsResultModel)) {
            return false;
        }
        WalletTopUpSuggestionsAndLimitsResultModel walletTopUpSuggestionsAndLimitsResultModel = (WalletTopUpSuggestionsAndLimitsResultModel) obj;
        return Intrinsics.areEqual((Object) this.topUpAmountSuggestions, (Object) walletTopUpSuggestionsAndLimitsResultModel.topUpAmountSuggestions) && this.minTopUpAmount == walletTopUpSuggestionsAndLimitsResultModel.minTopUpAmount && this.maxTopUpAmount == walletTopUpSuggestionsAndLimitsResultModel.maxTopUpAmount;
    }

    public final int getMaxTopUpAmount() {
        return this.maxTopUpAmount;
    }

    public final int getMinTopUpAmount() {
        return this.minTopUpAmount;
    }

    @Nullable
    public final List<WalletTopUpAmountSuggestion> getTopUpAmountSuggestions() {
        return this.topUpAmountSuggestions;
    }

    public int hashCode() {
        List<WalletTopUpAmountSuggestion> list = this.topUpAmountSuggestions;
        return ((((list == null ? 0 : list.hashCode()) * 31) + this.minTopUpAmount) * 31) + this.maxTopUpAmount;
    }

    @NotNull
    public String toString() {
        List<WalletTopUpAmountSuggestion> list = this.topUpAmountSuggestions;
        int i11 = this.minTopUpAmount;
        int i12 = this.maxTopUpAmount;
        return "WalletTopUpSuggestionsAndLimitsResultModel(topUpAmountSuggestions=" + list + ", minTopUpAmount=" + i11 + ", maxTopUpAmount=" + i12 + ")";
    }
}
