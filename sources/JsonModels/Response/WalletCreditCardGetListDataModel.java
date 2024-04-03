package JsonModels.Response;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataModel;", "", "WalletCreditCardGetListDataModel", "", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "(Ljava/util/List;)V", "getWalletCreditCardGetListDataModel", "()Ljava/util/List;", "setWalletCreditCardGetListDataModel", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditCardGetListDataModel {
    @Nullable
    private List<? extends WalletCreditCardGetListDataItem> WalletCreditCardGetListDataModel;

    public WalletCreditCardGetListDataModel(@Nullable List<? extends WalletCreditCardGetListDataItem> list) {
        this.WalletCreditCardGetListDataModel = list;
    }

    public static /* synthetic */ WalletCreditCardGetListDataModel copy$default(WalletCreditCardGetListDataModel walletCreditCardGetListDataModel, List<? extends WalletCreditCardGetListDataItem> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = walletCreditCardGetListDataModel.WalletCreditCardGetListDataModel;
        }
        return walletCreditCardGetListDataModel.copy(list);
    }

    @Nullable
    public final List<WalletCreditCardGetListDataItem> component1() {
        return this.WalletCreditCardGetListDataModel;
    }

    @NotNull
    public final WalletCreditCardGetListDataModel copy(@Nullable List<? extends WalletCreditCardGetListDataItem> list) {
        return new WalletCreditCardGetListDataModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCreditCardGetListDataModel) && Intrinsics.areEqual((Object) this.WalletCreditCardGetListDataModel, (Object) ((WalletCreditCardGetListDataModel) obj).WalletCreditCardGetListDataModel);
    }

    @Nullable
    public final List<WalletCreditCardGetListDataItem> getWalletCreditCardGetListDataModel() {
        return this.WalletCreditCardGetListDataModel;
    }

    public int hashCode() {
        List<? extends WalletCreditCardGetListDataItem> list = this.WalletCreditCardGetListDataModel;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setWalletCreditCardGetListDataModel(@Nullable List<? extends WalletCreditCardGetListDataItem> list) {
        this.WalletCreditCardGetListDataModel = list;
    }

    @NotNull
    public String toString() {
        List<? extends WalletCreditCardGetListDataItem> list = this.WalletCreditCardGetListDataModel;
        return "WalletCreditCardGetListDataModel(WalletCreditCardGetListDataModel=" + list + ")";
    }
}
