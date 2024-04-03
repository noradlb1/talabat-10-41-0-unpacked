package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/UpgradePlanBenefitResponseModel;", "", "name", "", "description", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpgradePlanBenefitResponseModel {
    @Nullable
    private String description;
    @Nullable
    private String icon;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58955name;

    public UpgradePlanBenefitResponseModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public UpgradePlanBenefitResponseModel(@Nullable @Json(name = "name") String str, @Nullable @Json(name = "description") String str2, @Nullable @Json(name = "icon") String str3) {
        this.f58955name = str;
        this.description = str2;
        this.icon = str3;
    }

    public static /* synthetic */ UpgradePlanBenefitResponseModel copy$default(UpgradePlanBenefitResponseModel upgradePlanBenefitResponseModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = upgradePlanBenefitResponseModel.f58955name;
        }
        if ((i11 & 2) != 0) {
            str2 = upgradePlanBenefitResponseModel.description;
        }
        if ((i11 & 4) != 0) {
            str3 = upgradePlanBenefitResponseModel.icon;
        }
        return upgradePlanBenefitResponseModel.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.f58955name;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final String component3() {
        return this.icon;
    }

    @NotNull
    public final UpgradePlanBenefitResponseModel copy(@Nullable @Json(name = "name") String str, @Nullable @Json(name = "description") String str2, @Nullable @Json(name = "icon") String str3) {
        return new UpgradePlanBenefitResponseModel(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpgradePlanBenefitResponseModel)) {
            return false;
        }
        UpgradePlanBenefitResponseModel upgradePlanBenefitResponseModel = (UpgradePlanBenefitResponseModel) obj;
        return Intrinsics.areEqual((Object) this.f58955name, (Object) upgradePlanBenefitResponseModel.f58955name) && Intrinsics.areEqual((Object) this.description, (Object) upgradePlanBenefitResponseModel.description) && Intrinsics.areEqual((Object) this.icon, (Object) upgradePlanBenefitResponseModel.icon);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getName() {
        return this.f58955name;
    }

    public int hashCode() {
        String str = this.f58955name;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    @NotNull
    public String toString() {
        String str = this.f58955name;
        String str2 = this.description;
        String str3 = this.icon;
        return "UpgradePlanBenefitResponseModel(name=" + str + ", description=" + str2 + ", icon=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpgradePlanBenefitResponseModel(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }
}
