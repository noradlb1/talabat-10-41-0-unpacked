package com.talabat.wallet.features.walletCashBack.model.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/model/request/WalletCalculateCashBackRequestModel;", "", "amount", "", "eventType", "", "countryId", "binNumber", "(FIII)V", "getAmount", "()F", "getBinNumber", "()I", "setBinNumber", "(I)V", "getCountryId", "getEventType", "setEventType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCalculateCashBackRequestModel {
    @SerializedName("amount")
    private final float amount;
    @SerializedName("binNumber")
    private int binNumber;
    @SerializedName("countryId")
    private final int countryId;
    @SerializedName("eventType")
    private int eventType;

    public WalletCalculateCashBackRequestModel(float f11, int i11, int i12, int i13) {
        this.amount = f11;
        this.eventType = i11;
        this.countryId = i12;
        this.binNumber = i13;
    }

    public static /* synthetic */ WalletCalculateCashBackRequestModel copy$default(WalletCalculateCashBackRequestModel walletCalculateCashBackRequestModel, float f11, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            f11 = walletCalculateCashBackRequestModel.amount;
        }
        if ((i14 & 2) != 0) {
            i11 = walletCalculateCashBackRequestModel.eventType;
        }
        if ((i14 & 4) != 0) {
            i12 = walletCalculateCashBackRequestModel.countryId;
        }
        if ((i14 & 8) != 0) {
            i13 = walletCalculateCashBackRequestModel.binNumber;
        }
        return walletCalculateCashBackRequestModel.copy(f11, i11, i12, i13);
    }

    public final float component1() {
        return this.amount;
    }

    public final int component2() {
        return this.eventType;
    }

    public final int component3() {
        return this.countryId;
    }

    public final int component4() {
        return this.binNumber;
    }

    @NotNull
    public final WalletCalculateCashBackRequestModel copy(float f11, int i11, int i12, int i13) {
        return new WalletCalculateCashBackRequestModel(f11, i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCalculateCashBackRequestModel)) {
            return false;
        }
        WalletCalculateCashBackRequestModel walletCalculateCashBackRequestModel = (WalletCalculateCashBackRequestModel) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.amount), (Object) Float.valueOf(walletCalculateCashBackRequestModel.amount)) && this.eventType == walletCalculateCashBackRequestModel.eventType && this.countryId == walletCalculateCashBackRequestModel.countryId && this.binNumber == walletCalculateCashBackRequestModel.binNumber;
    }

    public final float getAmount() {
        return this.amount;
    }

    public final int getBinNumber() {
        return this.binNumber;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.amount) * 31) + this.eventType) * 31) + this.countryId) * 31) + this.binNumber;
    }

    public final void setBinNumber(int i11) {
        this.binNumber = i11;
    }

    public final void setEventType(int i11) {
        this.eventType = i11;
    }

    @NotNull
    public String toString() {
        float f11 = this.amount;
        int i11 = this.eventType;
        int i12 = this.countryId;
        int i13 = this.binNumber;
        return "WalletCalculateCashBackRequestModel(amount=" + f11 + ", eventType=" + i11 + ", countryId=" + i12 + ", binNumber=" + i13 + ")";
    }
}
