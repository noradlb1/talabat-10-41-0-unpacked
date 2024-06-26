package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanUdfEntityModel;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "setValue", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPlanUdfEntityModel {
    @SerializedName("key")
    @Nullable
    private final String key;
    @SerializedName("value")
    @Nullable
    private String value;

    public SubscriptionPlanUdfEntityModel() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionPlanUdfEntityModel(@Nullable String str, @Nullable String str2) {
        this.key = str;
        this.value = str2;
    }

    public static /* synthetic */ SubscriptionPlanUdfEntityModel copy$default(SubscriptionPlanUdfEntityModel subscriptionPlanUdfEntityModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionPlanUdfEntityModel.key;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionPlanUdfEntityModel.value;
        }
        return subscriptionPlanUdfEntityModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.key;
    }

    @Nullable
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final SubscriptionPlanUdfEntityModel copy(@Nullable String str, @Nullable String str2) {
        return new SubscriptionPlanUdfEntityModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPlanUdfEntityModel)) {
            return false;
        }
        SubscriptionPlanUdfEntityModel subscriptionPlanUdfEntityModel = (SubscriptionPlanUdfEntityModel) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) subscriptionPlanUdfEntityModel.key) && Intrinsics.areEqual((Object) this.value, (Object) subscriptionPlanUdfEntityModel.value);
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.key;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setValue(@Nullable String str) {
        this.value = str;
    }

    @NotNull
    public String toString() {
        String str = this.key;
        String str2 = this.value;
        return "SubscriptionPlanUdfEntityModel(key=" + str + ", value=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionPlanUdfEntityModel(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
