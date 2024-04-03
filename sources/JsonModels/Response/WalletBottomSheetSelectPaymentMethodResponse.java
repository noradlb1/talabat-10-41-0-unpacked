package JsonModels.Response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"LJsonModels/Response/WalletBottomSheetSelectPaymentMethodResponse;", "", "walletBalance", "LJsonModels/Response/WalletCreditBalanceResponse;", "cardList", "LJsonModels/Response/WalletCreditCardGetListDataModel;", "(LJsonModels/Response/WalletCreditBalanceResponse;LJsonModels/Response/WalletCreditCardGetListDataModel;)V", "getCardList", "()LJsonModels/Response/WalletCreditCardGetListDataModel;", "getWalletBalance", "()LJsonModels/Response/WalletCreditBalanceResponse;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBottomSheetSelectPaymentMethodResponse {
    @Nullable
    private final WalletCreditCardGetListDataModel cardList;
    @Nullable
    private final WalletCreditBalanceResponse walletBalance;

    public WalletBottomSheetSelectPaymentMethodResponse(@Nullable WalletCreditBalanceResponse walletCreditBalanceResponse, @Nullable WalletCreditCardGetListDataModel walletCreditCardGetListDataModel) {
        this.walletBalance = walletCreditBalanceResponse;
        this.cardList = walletCreditCardGetListDataModel;
    }

    public static /* synthetic */ WalletBottomSheetSelectPaymentMethodResponse copy$default(WalletBottomSheetSelectPaymentMethodResponse walletBottomSheetSelectPaymentMethodResponse, WalletCreditBalanceResponse walletCreditBalanceResponse, WalletCreditCardGetListDataModel walletCreditCardGetListDataModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletCreditBalanceResponse = walletBottomSheetSelectPaymentMethodResponse.walletBalance;
        }
        if ((i11 & 2) != 0) {
            walletCreditCardGetListDataModel = walletBottomSheetSelectPaymentMethodResponse.cardList;
        }
        return walletBottomSheetSelectPaymentMethodResponse.copy(walletCreditBalanceResponse, walletCreditCardGetListDataModel);
    }

    @Nullable
    public final WalletCreditBalanceResponse component1() {
        return this.walletBalance;
    }

    @Nullable
    public final WalletCreditCardGetListDataModel component2() {
        return this.cardList;
    }

    @NotNull
    public final WalletBottomSheetSelectPaymentMethodResponse copy(@Nullable WalletCreditBalanceResponse walletCreditBalanceResponse, @Nullable WalletCreditCardGetListDataModel walletCreditCardGetListDataModel) {
        return new WalletBottomSheetSelectPaymentMethodResponse(walletCreditBalanceResponse, walletCreditCardGetListDataModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletBottomSheetSelectPaymentMethodResponse)) {
            return false;
        }
        WalletBottomSheetSelectPaymentMethodResponse walletBottomSheetSelectPaymentMethodResponse = (WalletBottomSheetSelectPaymentMethodResponse) obj;
        return Intrinsics.areEqual((Object) this.walletBalance, (Object) walletBottomSheetSelectPaymentMethodResponse.walletBalance) && Intrinsics.areEqual((Object) this.cardList, (Object) walletBottomSheetSelectPaymentMethodResponse.cardList);
    }

    @Nullable
    public final WalletCreditCardGetListDataModel getCardList() {
        return this.cardList;
    }

    @Nullable
    public final WalletCreditBalanceResponse getWalletBalance() {
        return this.walletBalance;
    }

    public int hashCode() {
        WalletCreditBalanceResponse walletCreditBalanceResponse = this.walletBalance;
        int i11 = 0;
        int hashCode = (walletCreditBalanceResponse == null ? 0 : walletCreditBalanceResponse.hashCode()) * 31;
        WalletCreditCardGetListDataModel walletCreditCardGetListDataModel = this.cardList;
        if (walletCreditCardGetListDataModel != null) {
            i11 = walletCreditCardGetListDataModel.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        WalletCreditBalanceResponse walletCreditBalanceResponse = this.walletBalance;
        WalletCreditCardGetListDataModel walletCreditCardGetListDataModel = this.cardList;
        return "WalletBottomSheetSelectPaymentMethodResponse(walletBalance=" + walletCreditBalanceResponse + ", cardList=" + walletCreditCardGetListDataModel + ")";
    }
}
