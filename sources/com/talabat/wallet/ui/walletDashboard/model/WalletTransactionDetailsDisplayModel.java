package com.talabat.wallet.ui.walletDashboard.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionDetailsDisplayModel;", "", "showFlutterTransactionDetails", "", "id", "", "typeId", "(ZII)V", "getId", "()I", "getShowFlutterTransactionDetails", "()Z", "getTypeId", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailsDisplayModel {

    /* renamed from: id  reason: collision with root package name */
    private final int f12741id;
    private final boolean showFlutterTransactionDetails;
    private final int typeId;

    public WalletTransactionDetailsDisplayModel() {
        this(false, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public WalletTransactionDetailsDisplayModel(boolean z11, int i11, int i12) {
        this.showFlutterTransactionDetails = z11;
        this.f12741id = i11;
        this.typeId = i12;
    }

    public static /* synthetic */ WalletTransactionDetailsDisplayModel copy$default(WalletTransactionDetailsDisplayModel walletTransactionDetailsDisplayModel, boolean z11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            z11 = walletTransactionDetailsDisplayModel.showFlutterTransactionDetails;
        }
        if ((i13 & 2) != 0) {
            i11 = walletTransactionDetailsDisplayModel.f12741id;
        }
        if ((i13 & 4) != 0) {
            i12 = walletTransactionDetailsDisplayModel.typeId;
        }
        return walletTransactionDetailsDisplayModel.copy(z11, i11, i12);
    }

    public final boolean component1() {
        return this.showFlutterTransactionDetails;
    }

    public final int component2() {
        return this.f12741id;
    }

    public final int component3() {
        return this.typeId;
    }

    @NotNull
    public final WalletTransactionDetailsDisplayModel copy(boolean z11, int i11, int i12) {
        return new WalletTransactionDetailsDisplayModel(z11, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionDetailsDisplayModel)) {
            return false;
        }
        WalletTransactionDetailsDisplayModel walletTransactionDetailsDisplayModel = (WalletTransactionDetailsDisplayModel) obj;
        return this.showFlutterTransactionDetails == walletTransactionDetailsDisplayModel.showFlutterTransactionDetails && this.f12741id == walletTransactionDetailsDisplayModel.f12741id && this.typeId == walletTransactionDetailsDisplayModel.typeId;
    }

    public final int getId() {
        return this.f12741id;
    }

    public final boolean getShowFlutterTransactionDetails() {
        return this.showFlutterTransactionDetails;
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public int hashCode() {
        boolean z11 = this.showFlutterTransactionDetails;
        if (z11) {
            z11 = true;
        }
        return ((((z11 ? 1 : 0) * true) + this.f12741id) * 31) + this.typeId;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.showFlutterTransactionDetails;
        int i11 = this.f12741id;
        int i12 = this.typeId;
        return "WalletTransactionDetailsDisplayModel(showFlutterTransactionDetails=" + z11 + ", id=" + i11 + ", typeId=" + i12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletTransactionDetailsDisplayModel(boolean z11, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? false : z11, (i13 & 2) != 0 ? -1 : i11, (i13 & 4) != 0 ? -1 : i12);
    }
}
