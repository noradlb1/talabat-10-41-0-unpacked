package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionUpgradePlanResponseModel;", "", "planId", "", "planPeriod", "benefits", "", "Lcom/talabat/feature/subscriptions/data/remote/model/UpgradePlanBenefitResponseModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBenefits", "()Ljava/util/List;", "getPlanId", "()Ljava/lang/String;", "getPlanPeriod", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionUpgradePlanResponseModel {
    @Nullable
    private final List<UpgradePlanBenefitResponseModel> benefits;
    @Nullable
    private final String planId;
    @Nullable
    private final String planPeriod;

    public SubscriptionUpgradePlanResponseModel() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionUpgradePlanResponseModel(@Nullable @Json(name = "planId") String str, @Nullable @Json(name = "planPeriod") String str2, @Nullable @Json(name = "benefits") List<UpgradePlanBenefitResponseModel> list) {
        this.planId = str;
        this.planPeriod = str2;
        this.benefits = list;
    }

    public static /* synthetic */ SubscriptionUpgradePlanResponseModel copy$default(SubscriptionUpgradePlanResponseModel subscriptionUpgradePlanResponseModel, String str, String str2, List<UpgradePlanBenefitResponseModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionUpgradePlanResponseModel.planId;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionUpgradePlanResponseModel.planPeriod;
        }
        if ((i11 & 4) != 0) {
            list = subscriptionUpgradePlanResponseModel.benefits;
        }
        return subscriptionUpgradePlanResponseModel.copy(str, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.planId;
    }

    @Nullable
    public final String component2() {
        return this.planPeriod;
    }

    @Nullable
    public final List<UpgradePlanBenefitResponseModel> component3() {
        return this.benefits;
    }

    @NotNull
    public final SubscriptionUpgradePlanResponseModel copy(@Nullable @Json(name = "planId") String str, @Nullable @Json(name = "planPeriod") String str2, @Nullable @Json(name = "benefits") List<UpgradePlanBenefitResponseModel> list) {
        return new SubscriptionUpgradePlanResponseModel(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionUpgradePlanResponseModel)) {
            return false;
        }
        SubscriptionUpgradePlanResponseModel subscriptionUpgradePlanResponseModel = (SubscriptionUpgradePlanResponseModel) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) subscriptionUpgradePlanResponseModel.planId) && Intrinsics.areEqual((Object) this.planPeriod, (Object) subscriptionUpgradePlanResponseModel.planPeriod) && Intrinsics.areEqual((Object) this.benefits, (Object) subscriptionUpgradePlanResponseModel.benefits);
    }

    @Nullable
    public final List<UpgradePlanBenefitResponseModel> getBenefits() {
        return this.benefits;
    }

    @Nullable
    public final String getPlanId() {
        return this.planId;
    }

    @Nullable
    public final String getPlanPeriod() {
        return this.planPeriod;
    }

    public int hashCode() {
        String str = this.planId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.planPeriod;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<UpgradePlanBenefitResponseModel> list = this.benefits;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.planPeriod;
        List<UpgradePlanBenefitResponseModel> list = this.benefits;
        return "SubscriptionUpgradePlanResponseModel(planId=" + str + ", planPeriod=" + str2 + ", benefits=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionUpgradePlanResponseModel(String str, String str2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : list);
    }
}
