package com.talabat.talabatcommon.feature.walletCardList.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardList/model/request/WalletCardListParamModel;", "", "paymentMethod", "", "country", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCountry", "()Ljava/lang/Integer;", "setCountry", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPaymentMethod", "setPaymentMethod", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/talabat/talabatcommon/feature/walletCardList/model/request/WalletCardListParamModel;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardListParamModel {
    @Nullable
    private Integer country;
    @Nullable
    private Integer paymentMethod;

    public WalletCardListParamModel(@Nullable Integer num, @Nullable Integer num2) {
        this.paymentMethod = num;
        this.country = num2;
    }

    public static /* synthetic */ WalletCardListParamModel copy$default(WalletCardListParamModel walletCardListParamModel, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = walletCardListParamModel.paymentMethod;
        }
        if ((i11 & 2) != 0) {
            num2 = walletCardListParamModel.country;
        }
        return walletCardListParamModel.copy(num, num2);
    }

    @Nullable
    public final Integer component1() {
        return this.paymentMethod;
    }

    @Nullable
    public final Integer component2() {
        return this.country;
    }

    @NotNull
    public final WalletCardListParamModel copy(@Nullable Integer num, @Nullable Integer num2) {
        return new WalletCardListParamModel(num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCardListParamModel)) {
            return false;
        }
        WalletCardListParamModel walletCardListParamModel = (WalletCardListParamModel) obj;
        return Intrinsics.areEqual((Object) this.paymentMethod, (Object) walletCardListParamModel.paymentMethod) && Intrinsics.areEqual((Object) this.country, (Object) walletCardListParamModel.country);
    }

    @Nullable
    public final Integer getCountry() {
        return this.country;
    }

    @Nullable
    public final Integer getPaymentMethod() {
        return this.paymentMethod;
    }

    public int hashCode() {
        Integer num = this.paymentMethod;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.country;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setCountry(@Nullable Integer num) {
        this.country = num;
    }

    public final void setPaymentMethod(@Nullable Integer num) {
        this.paymentMethod = num;
    }

    @NotNull
    public String toString() {
        Integer num = this.paymentMethod;
        Integer num2 = this.country;
        return "WalletCardListParamModel(paymentMethod=" + num + ", country=" + num2 + ")";
    }
}
