package JsonModels.Response;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"LJsonModels/Response/WalletTransactionListDataModel;", "", "transactionListDataItem", "", "LJsonModels/Response/WalletTransactionListDataItem;", "walletTransactionWithMonthModel", "LJsonModels/Response/WalletTransactionSpentPerMonthModel;", "(Ljava/util/List;Ljava/util/List;)V", "getTransactionListDataItem", "()Ljava/util/List;", "setTransactionListDataItem", "(Ljava/util/List;)V", "getWalletTransactionWithMonthModel", "setWalletTransactionWithMonthModel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListDataModel {
    @Nullable
    private List<? extends WalletTransactionListDataItem> transactionListDataItem;
    @Nullable
    private List<WalletTransactionSpentPerMonthModel> walletTransactionWithMonthModel;

    public WalletTransactionListDataModel(@Nullable List<? extends WalletTransactionListDataItem> list, @Nullable List<WalletTransactionSpentPerMonthModel> list2) {
        this.transactionListDataItem = list;
        this.walletTransactionWithMonthModel = list2;
    }

    public static /* synthetic */ WalletTransactionListDataModel copy$default(WalletTransactionListDataModel walletTransactionListDataModel, List<? extends WalletTransactionListDataItem> list, List<WalletTransactionSpentPerMonthModel> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = walletTransactionListDataModel.transactionListDataItem;
        }
        if ((i11 & 2) != 0) {
            list2 = walletTransactionListDataModel.walletTransactionWithMonthModel;
        }
        return walletTransactionListDataModel.copy(list, list2);
    }

    @Nullable
    public final List<WalletTransactionListDataItem> component1() {
        return this.transactionListDataItem;
    }

    @Nullable
    public final List<WalletTransactionSpentPerMonthModel> component2() {
        return this.walletTransactionWithMonthModel;
    }

    @NotNull
    public final WalletTransactionListDataModel copy(@Nullable List<? extends WalletTransactionListDataItem> list, @Nullable List<WalletTransactionSpentPerMonthModel> list2) {
        return new WalletTransactionListDataModel(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionListDataModel)) {
            return false;
        }
        WalletTransactionListDataModel walletTransactionListDataModel = (WalletTransactionListDataModel) obj;
        return Intrinsics.areEqual((Object) this.transactionListDataItem, (Object) walletTransactionListDataModel.transactionListDataItem) && Intrinsics.areEqual((Object) this.walletTransactionWithMonthModel, (Object) walletTransactionListDataModel.walletTransactionWithMonthModel);
    }

    @Nullable
    public final List<WalletTransactionListDataItem> getTransactionListDataItem() {
        return this.transactionListDataItem;
    }

    @Nullable
    public final List<WalletTransactionSpentPerMonthModel> getWalletTransactionWithMonthModel() {
        return this.walletTransactionWithMonthModel;
    }

    public int hashCode() {
        List<? extends WalletTransactionListDataItem> list = this.transactionListDataItem;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<WalletTransactionSpentPerMonthModel> list2 = this.walletTransactionWithMonthModel;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setTransactionListDataItem(@Nullable List<? extends WalletTransactionListDataItem> list) {
        this.transactionListDataItem = list;
    }

    public final void setWalletTransactionWithMonthModel(@Nullable List<WalletTransactionSpentPerMonthModel> list) {
        this.walletTransactionWithMonthModel = list;
    }

    @NotNull
    public String toString() {
        List<? extends WalletTransactionListDataItem> list = this.transactionListDataItem;
        List<WalletTransactionSpentPerMonthModel> list2 = this.walletTransactionWithMonthModel;
        return "WalletTransactionListDataModel(transactionListDataItem=" + list + ", walletTransactionWithMonthModel=" + list2 + ")";
    }
}
