package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherRequestModel;", "", "planId", "", "subscriptionCode", "cardTokenId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardTokenId", "()Ljava/lang/String;", "getPlanId", "getSubscriptionCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionB2BVoucherRequestModel {
    @NotNull
    private final String cardTokenId;
    @NotNull
    private final String planId;
    @NotNull
    private final String subscriptionCode;

    public SubscriptionB2BVoucherRequestModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionB2BVoucherRequestModel(@NotNull @Json(name = "planId") String str, @NotNull @Json(name = "subscriptionCode") String str2, @NotNull @Json(name = "cardTokenId") String str3) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, TproBenefitsFragment.APPLIED_VOUCHER_CODE);
        Intrinsics.checkNotNullParameter(str3, "cardTokenId");
        this.planId = str;
        this.subscriptionCode = str2;
        this.cardTokenId = str3;
    }

    public static /* synthetic */ SubscriptionB2BVoucherRequestModel copy$default(SubscriptionB2BVoucherRequestModel subscriptionB2BVoucherRequestModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionB2BVoucherRequestModel.planId;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionB2BVoucherRequestModel.subscriptionCode;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionB2BVoucherRequestModel.cardTokenId;
        }
        return subscriptionB2BVoucherRequestModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.planId;
    }

    @NotNull
    public final String component2() {
        return this.subscriptionCode;
    }

    @NotNull
    public final String component3() {
        return this.cardTokenId;
    }

    @NotNull
    public final SubscriptionB2BVoucherRequestModel copy(@NotNull @Json(name = "planId") String str, @NotNull @Json(name = "subscriptionCode") String str2, @NotNull @Json(name = "cardTokenId") String str3) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, TproBenefitsFragment.APPLIED_VOUCHER_CODE);
        Intrinsics.checkNotNullParameter(str3, "cardTokenId");
        return new SubscriptionB2BVoucherRequestModel(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionB2BVoucherRequestModel)) {
            return false;
        }
        SubscriptionB2BVoucherRequestModel subscriptionB2BVoucherRequestModel = (SubscriptionB2BVoucherRequestModel) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) subscriptionB2BVoucherRequestModel.planId) && Intrinsics.areEqual((Object) this.subscriptionCode, (Object) subscriptionB2BVoucherRequestModel.subscriptionCode) && Intrinsics.areEqual((Object) this.cardTokenId, (Object) subscriptionB2BVoucherRequestModel.cardTokenId);
    }

    @NotNull
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    @NotNull
    public final String getSubscriptionCode() {
        return this.subscriptionCode;
    }

    public int hashCode() {
        return (((this.planId.hashCode() * 31) + this.subscriptionCode.hashCode()) * 31) + this.cardTokenId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.subscriptionCode;
        String str3 = this.cardTokenId;
        return "SubscriptionB2BVoucherRequestModel(planId=" + str + ", subscriptionCode=" + str2 + ", cardTokenId=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionB2BVoucherRequestModel(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3);
    }
}
