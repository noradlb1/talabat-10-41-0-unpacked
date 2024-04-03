package com.talabat.wallet.features.walletCashBack;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/WalletTopUpListFormatterParam;", "", "walletTransactionListResponse", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "(Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", "getWalletCardListDisplayModel", "()Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "getWalletTransactionListResponse", "()Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpListFormatterParam {
    @Nullable
    private final WalletCardListDisplayModel walletCardListDisplayModel;
    @Nullable
    private final WalletCashBackCampaignResponse walletTransactionListResponse;

    public WalletTopUpListFormatterParam(@Nullable WalletCashBackCampaignResponse walletCashBackCampaignResponse, @Nullable WalletCardListDisplayModel walletCardListDisplayModel2) {
        this.walletTransactionListResponse = walletCashBackCampaignResponse;
        this.walletCardListDisplayModel = walletCardListDisplayModel2;
    }

    public static /* synthetic */ WalletTopUpListFormatterParam copy$default(WalletTopUpListFormatterParam walletTopUpListFormatterParam, WalletCashBackCampaignResponse walletCashBackCampaignResponse, WalletCardListDisplayModel walletCardListDisplayModel2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletCashBackCampaignResponse = walletTopUpListFormatterParam.walletTransactionListResponse;
        }
        if ((i11 & 2) != 0) {
            walletCardListDisplayModel2 = walletTopUpListFormatterParam.walletCardListDisplayModel;
        }
        return walletTopUpListFormatterParam.copy(walletCashBackCampaignResponse, walletCardListDisplayModel2);
    }

    @Nullable
    public final WalletCashBackCampaignResponse component1() {
        return this.walletTransactionListResponse;
    }

    @Nullable
    public final WalletCardListDisplayModel component2() {
        return this.walletCardListDisplayModel;
    }

    @NotNull
    public final WalletTopUpListFormatterParam copy(@Nullable WalletCashBackCampaignResponse walletCashBackCampaignResponse, @Nullable WalletCardListDisplayModel walletCardListDisplayModel2) {
        return new WalletTopUpListFormatterParam(walletCashBackCampaignResponse, walletCardListDisplayModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTopUpListFormatterParam)) {
            return false;
        }
        WalletTopUpListFormatterParam walletTopUpListFormatterParam = (WalletTopUpListFormatterParam) obj;
        return Intrinsics.areEqual((Object) this.walletTransactionListResponse, (Object) walletTopUpListFormatterParam.walletTransactionListResponse) && Intrinsics.areEqual((Object) this.walletCardListDisplayModel, (Object) walletTopUpListFormatterParam.walletCardListDisplayModel);
    }

    @Nullable
    public final WalletCardListDisplayModel getWalletCardListDisplayModel() {
        return this.walletCardListDisplayModel;
    }

    @Nullable
    public final WalletCashBackCampaignResponse getWalletTransactionListResponse() {
        return this.walletTransactionListResponse;
    }

    public int hashCode() {
        WalletCashBackCampaignResponse walletCashBackCampaignResponse = this.walletTransactionListResponse;
        int i11 = 0;
        int hashCode = (walletCashBackCampaignResponse == null ? 0 : walletCashBackCampaignResponse.hashCode()) * 31;
        WalletCardListDisplayModel walletCardListDisplayModel2 = this.walletCardListDisplayModel;
        if (walletCardListDisplayModel2 != null) {
            i11 = walletCardListDisplayModel2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        WalletCashBackCampaignResponse walletCashBackCampaignResponse = this.walletTransactionListResponse;
        WalletCardListDisplayModel walletCardListDisplayModel2 = this.walletCardListDisplayModel;
        return "WalletTopUpListFormatterParam(walletTransactionListResponse=" + walletCashBackCampaignResponse + ", walletCardListDisplayModel=" + walletCardListDisplayModel2 + ")";
    }
}
