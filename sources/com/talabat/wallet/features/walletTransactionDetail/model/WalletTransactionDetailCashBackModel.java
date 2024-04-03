package com.talabat.wallet.features.walletTransactionDetail.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailCashBackModel;", "", "imageUrl", "", "amount", "", "expiryDays", "", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getExpiryDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;)Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailCashBackModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailCashBackModel {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("expiryDays")
    @Nullable
    private final Integer expiryDays;
    @SerializedName("imageUrl")
    @Nullable
    private final String imageUrl;

    public WalletTransactionDetailCashBackModel(@Nullable String str, @Nullable Float f11, @Nullable Integer num) {
        this.imageUrl = str;
        this.amount = f11;
        this.expiryDays = num;
    }

    public static /* synthetic */ WalletTransactionDetailCashBackModel copy$default(WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel, String str, Float f11, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletTransactionDetailCashBackModel.imageUrl;
        }
        if ((i11 & 2) != 0) {
            f11 = walletTransactionDetailCashBackModel.amount;
        }
        if ((i11 & 4) != 0) {
            num = walletTransactionDetailCashBackModel.expiryDays;
        }
        return walletTransactionDetailCashBackModel.copy(str, f11, num);
    }

    @Nullable
    public final String component1() {
        return this.imageUrl;
    }

    @Nullable
    public final Float component2() {
        return this.amount;
    }

    @Nullable
    public final Integer component3() {
        return this.expiryDays;
    }

    @NotNull
    public final WalletTransactionDetailCashBackModel copy(@Nullable String str, @Nullable Float f11, @Nullable Integer num) {
        return new WalletTransactionDetailCashBackModel(str, f11, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionDetailCashBackModel)) {
            return false;
        }
        WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel = (WalletTransactionDetailCashBackModel) obj;
        return Intrinsics.areEqual((Object) this.imageUrl, (Object) walletTransactionDetailCashBackModel.imageUrl) && Intrinsics.areEqual((Object) this.amount, (Object) walletTransactionDetailCashBackModel.amount) && Intrinsics.areEqual((Object) this.expiryDays, (Object) walletTransactionDetailCashBackModel.expiryDays);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final Integer getExpiryDays() {
        return this.expiryDays;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        String str = this.imageUrl;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f11 = this.amount;
        int hashCode2 = (hashCode + (f11 == null ? 0 : f11.hashCode())) * 31;
        Integer num = this.expiryDays;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.imageUrl;
        Float f11 = this.amount;
        Integer num = this.expiryDays;
        return "WalletTransactionDetailCashBackModel(imageUrl=" + str + ", amount=" + f11 + ", expiryDays=" + num + ")";
    }
}
