package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/UpgradePlanRequestModel;", "", "currentPlanId", "", "upgradeablePlanId", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurrentPlanId", "()Ljava/lang/String;", "getUpgradeablePlanId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpgradePlanRequestModel {
    @NotNull
    private final String currentPlanId;
    @NotNull
    private final String upgradeablePlanId;

    public UpgradePlanRequestModel() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public UpgradePlanRequestModel(@NotNull @Json(name = "currentPlanId") String str, @NotNull @Json(name = "upgradeablePlanId") String str2) {
        Intrinsics.checkNotNullParameter(str, "currentPlanId");
        Intrinsics.checkNotNullParameter(str2, "upgradeablePlanId");
        this.currentPlanId = str;
        this.upgradeablePlanId = str2;
    }

    public static /* synthetic */ UpgradePlanRequestModel copy$default(UpgradePlanRequestModel upgradePlanRequestModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = upgradePlanRequestModel.currentPlanId;
        }
        if ((i11 & 2) != 0) {
            str2 = upgradePlanRequestModel.upgradeablePlanId;
        }
        return upgradePlanRequestModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.currentPlanId;
    }

    @NotNull
    public final String component2() {
        return this.upgradeablePlanId;
    }

    @NotNull
    public final UpgradePlanRequestModel copy(@NotNull @Json(name = "currentPlanId") String str, @NotNull @Json(name = "upgradeablePlanId") String str2) {
        Intrinsics.checkNotNullParameter(str, "currentPlanId");
        Intrinsics.checkNotNullParameter(str2, "upgradeablePlanId");
        return new UpgradePlanRequestModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpgradePlanRequestModel)) {
            return false;
        }
        UpgradePlanRequestModel upgradePlanRequestModel = (UpgradePlanRequestModel) obj;
        return Intrinsics.areEqual((Object) this.currentPlanId, (Object) upgradePlanRequestModel.currentPlanId) && Intrinsics.areEqual((Object) this.upgradeablePlanId, (Object) upgradePlanRequestModel.upgradeablePlanId);
    }

    @NotNull
    public final String getCurrentPlanId() {
        return this.currentPlanId;
    }

    @NotNull
    public final String getUpgradeablePlanId() {
        return this.upgradeablePlanId;
    }

    public int hashCode() {
        return (this.currentPlanId.hashCode() * 31) + this.upgradeablePlanId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.currentPlanId;
        String str2 = this.upgradeablePlanId;
        return "UpgradePlanRequestModel(currentPlanId=" + str + ", upgradeablePlanId=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpgradePlanRequestModel(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2);
    }
}
