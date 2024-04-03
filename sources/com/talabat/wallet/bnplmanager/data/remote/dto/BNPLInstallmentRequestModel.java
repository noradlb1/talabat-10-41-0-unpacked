package com.talabat.wallet.bnplmanager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;", "", "planId", "", "orderAmount", "", "(Ljava/lang/String;F)V", "getOrderAmount", "()F", "getPlanId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLInstallmentRequestModel {
    @SerializedName("orderAmount")
    private final float orderAmount;
    @SerializedName("planId")
    @NotNull
    private final String planId;

    public BNPLInstallmentRequestModel(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        this.planId = str;
        this.orderAmount = f11;
    }

    public static /* synthetic */ BNPLInstallmentRequestModel copy$default(BNPLInstallmentRequestModel bNPLInstallmentRequestModel, String str, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bNPLInstallmentRequestModel.planId;
        }
        if ((i11 & 2) != 0) {
            f11 = bNPLInstallmentRequestModel.orderAmount;
        }
        return bNPLInstallmentRequestModel.copy(str, f11);
    }

    @NotNull
    public final String component1() {
        return this.planId;
    }

    public final float component2() {
        return this.orderAmount;
    }

    @NotNull
    public final BNPLInstallmentRequestModel copy(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        return new BNPLInstallmentRequestModel(str, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLInstallmentRequestModel)) {
            return false;
        }
        BNPLInstallmentRequestModel bNPLInstallmentRequestModel = (BNPLInstallmentRequestModel) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) bNPLInstallmentRequestModel.planId) && Intrinsics.areEqual((Object) Float.valueOf(this.orderAmount), (Object) Float.valueOf(bNPLInstallmentRequestModel.orderAmount));
    }

    public final float getOrderAmount() {
        return this.orderAmount;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    public int hashCode() {
        return (this.planId.hashCode() * 31) + Float.floatToIntBits(this.orderAmount);
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        float f11 = this.orderAmount;
        return "BNPLInstallmentRequestModel(planId=" + str + ", orderAmount=" + f11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLInstallmentRequestModel(String str, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? 0.0f : f11);
    }
}
