package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.mapper.ModelMapping;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/CashBackWalletTransactionModel;", "", "amount", "", "expiryDays", "", "imageUrl", "", "(FILjava/lang/String;)V", "getAmount", "()F", "setAmount", "(F)V", "getExpiryDays", "()I", "setExpiryDays", "(I)V", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CashBackWalletTransactionModel {
    @ModelMapping({"amount"})
    private float amount;
    @ModelMapping({"expiryDays"})
    private int expiryDays;
    @NotNull
    @ModelMapping({"imageUrl"})
    private String imageUrl;

    public CashBackWalletTransactionModel() {
        this(0.0f, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public CashBackWalletTransactionModel(float f11, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        this.amount = f11;
        this.expiryDays = i11;
        this.imageUrl = str;
    }

    public static /* synthetic */ CashBackWalletTransactionModel copy$default(CashBackWalletTransactionModel cashBackWalletTransactionModel, float f11, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            f11 = cashBackWalletTransactionModel.amount;
        }
        if ((i12 & 2) != 0) {
            i11 = cashBackWalletTransactionModel.expiryDays;
        }
        if ((i12 & 4) != 0) {
            str = cashBackWalletTransactionModel.imageUrl;
        }
        return cashBackWalletTransactionModel.copy(f11, i11, str);
    }

    public final float component1() {
        return this.amount;
    }

    public final int component2() {
        return this.expiryDays;
    }

    @NotNull
    public final String component3() {
        return this.imageUrl;
    }

    @NotNull
    public final CashBackWalletTransactionModel copy(float f11, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        return new CashBackWalletTransactionModel(f11, i11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CashBackWalletTransactionModel)) {
            return false;
        }
        CashBackWalletTransactionModel cashBackWalletTransactionModel = (CashBackWalletTransactionModel) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.amount), (Object) Float.valueOf(cashBackWalletTransactionModel.amount)) && this.expiryDays == cashBackWalletTransactionModel.expiryDays && Intrinsics.areEqual((Object) this.imageUrl, (Object) cashBackWalletTransactionModel.imageUrl);
    }

    public final float getAmount() {
        return this.amount;
    }

    public final int getExpiryDays() {
        return this.expiryDays;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.amount) * 31) + this.expiryDays) * 31) + this.imageUrl.hashCode();
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setExpiryDays(int i11) {
        this.expiryDays = i11;
    }

    public final void setImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    @NotNull
    public String toString() {
        float f11 = this.amount;
        int i11 = this.expiryDays;
        String str = this.imageUrl;
        return "CashBackWalletTransactionModel(amount=" + f11 + ", expiryDays=" + i11 + ", imageUrl=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CashBackWalletTransactionModel(float f11, int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0.0f : f11, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str);
    }
}
