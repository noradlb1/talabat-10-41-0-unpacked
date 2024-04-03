package com.talabat.wallet.ui.walletTopUp.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel;", "", "data", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "deflectionType", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType;", "(Ljava/util/List;Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType;)V", "getData", "()Ljava/util/List;", "getDeflectionType", "()Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DeflectionType", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditCardListDataItemWithTypeDisplayModel {
    @NotNull
    private final List<WalletCreditCardListDataItemDisplayModel> data;
    @NotNull
    private final DeflectionType deflectionType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType;", "", "(Ljava/lang/String;I)V", "QPAY", "BENEFITS", "NONE", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum DeflectionType {
        QPAY,
        BENEFITS,
        NONE
    }

    public WalletCreditCardListDataItemWithTypeDisplayModel(@NotNull List<? extends WalletCreditCardListDataItemDisplayModel> list, @NotNull DeflectionType deflectionType2) {
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(deflectionType2, "deflectionType");
        this.data = list;
        this.deflectionType = deflectionType2;
    }

    public static /* synthetic */ WalletCreditCardListDataItemWithTypeDisplayModel copy$default(WalletCreditCardListDataItemWithTypeDisplayModel walletCreditCardListDataItemWithTypeDisplayModel, List<WalletCreditCardListDataItemDisplayModel> list, DeflectionType deflectionType2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = walletCreditCardListDataItemWithTypeDisplayModel.data;
        }
        if ((i11 & 2) != 0) {
            deflectionType2 = walletCreditCardListDataItemWithTypeDisplayModel.deflectionType;
        }
        return walletCreditCardListDataItemWithTypeDisplayModel.copy(list, deflectionType2);
    }

    @NotNull
    public final List<WalletCreditCardListDataItemDisplayModel> component1() {
        return this.data;
    }

    @NotNull
    public final DeflectionType component2() {
        return this.deflectionType;
    }

    @NotNull
    public final WalletCreditCardListDataItemWithTypeDisplayModel copy(@NotNull List<? extends WalletCreditCardListDataItemDisplayModel> list, @NotNull DeflectionType deflectionType2) {
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(deflectionType2, "deflectionType");
        return new WalletCreditCardListDataItemWithTypeDisplayModel(list, deflectionType2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCreditCardListDataItemWithTypeDisplayModel)) {
            return false;
        }
        WalletCreditCardListDataItemWithTypeDisplayModel walletCreditCardListDataItemWithTypeDisplayModel = (WalletCreditCardListDataItemWithTypeDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) walletCreditCardListDataItemWithTypeDisplayModel.data) && this.deflectionType == walletCreditCardListDataItemWithTypeDisplayModel.deflectionType;
    }

    @NotNull
    public final List<WalletCreditCardListDataItemDisplayModel> getData() {
        return this.data;
    }

    @NotNull
    public final DeflectionType getDeflectionType() {
        return this.deflectionType;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.deflectionType.hashCode();
    }

    @NotNull
    public String toString() {
        List<WalletCreditCardListDataItemDisplayModel> list = this.data;
        DeflectionType deflectionType2 = this.deflectionType;
        return "WalletCreditCardListDataItemWithTypeDisplayModel(data=" + list + ", deflectionType=" + deflectionType2 + ")";
    }
}
