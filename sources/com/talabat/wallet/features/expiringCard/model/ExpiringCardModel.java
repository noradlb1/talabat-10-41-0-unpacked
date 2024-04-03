package com.talabat.wallet.features.expiringCard.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/features/expiringCard/model/ExpiringCardModel;", "", "expiryDate", "", "amount", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getExpiryDate", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Float;)Lcom/talabat/wallet/features/expiringCard/model/ExpiringCardModel;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpiringCardModel {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("expiryDate")
    @Nullable
    private final String expiryDate;

    public ExpiringCardModel() {
        this((String) null, (Float) null, 3, (DefaultConstructorMarker) null);
    }

    public ExpiringCardModel(@Nullable String str, @Nullable Float f11) {
        this.expiryDate = str;
        this.amount = f11;
    }

    public static /* synthetic */ ExpiringCardModel copy$default(ExpiringCardModel expiringCardModel, String str, Float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = expiringCardModel.expiryDate;
        }
        if ((i11 & 2) != 0) {
            f11 = expiringCardModel.amount;
        }
        return expiringCardModel.copy(str, f11);
    }

    @Nullable
    public final String component1() {
        return this.expiryDate;
    }

    @Nullable
    public final Float component2() {
        return this.amount;
    }

    @NotNull
    public final ExpiringCardModel copy(@Nullable String str, @Nullable Float f11) {
        return new ExpiringCardModel(str, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpiringCardModel)) {
            return false;
        }
        ExpiringCardModel expiringCardModel = (ExpiringCardModel) obj;
        return Intrinsics.areEqual((Object) this.expiryDate, (Object) expiringCardModel.expiryDate) && Intrinsics.areEqual((Object) this.amount, (Object) expiringCardModel.amount);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public int hashCode() {
        String str = this.expiryDate;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f11 = this.amount;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.expiryDate;
        Float f11 = this.amount;
        return "ExpiringCardModel(expiryDate=" + str + ", amount=" + f11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpiringCardModel(String str, Float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : f11);
    }
}
