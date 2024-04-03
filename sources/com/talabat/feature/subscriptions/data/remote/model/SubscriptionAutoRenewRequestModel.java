package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionAutoRenewRequestModel;", "", "autoRenewal", "", "isImmediateCancelDisable", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAutoRenewal", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionAutoRenewRequestModel;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionAutoRenewRequestModel {
    @Nullable
    private final Boolean autoRenewal;
    @Nullable
    private final Boolean isImmediateCancelDisable;

    public SubscriptionAutoRenewRequestModel() {
        this((Boolean) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionAutoRenewRequestModel(@Nullable @Json(name = "autoRenewal") Boolean bool, @Nullable @Json(name = "isImmediateCancelDisable") Boolean bool2) {
        this.autoRenewal = bool;
        this.isImmediateCancelDisable = bool2;
    }

    public static /* synthetic */ SubscriptionAutoRenewRequestModel copy$default(SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, Boolean bool, Boolean bool2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = subscriptionAutoRenewRequestModel.autoRenewal;
        }
        if ((i11 & 2) != 0) {
            bool2 = subscriptionAutoRenewRequestModel.isImmediateCancelDisable;
        }
        return subscriptionAutoRenewRequestModel.copy(bool, bool2);
    }

    @Nullable
    public final Boolean component1() {
        return this.autoRenewal;
    }

    @Nullable
    public final Boolean component2() {
        return this.isImmediateCancelDisable;
    }

    @NotNull
    public final SubscriptionAutoRenewRequestModel copy(@Nullable @Json(name = "autoRenewal") Boolean bool, @Nullable @Json(name = "isImmediateCancelDisable") Boolean bool2) {
        return new SubscriptionAutoRenewRequestModel(bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionAutoRenewRequestModel)) {
            return false;
        }
        SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel = (SubscriptionAutoRenewRequestModel) obj;
        return Intrinsics.areEqual((Object) this.autoRenewal, (Object) subscriptionAutoRenewRequestModel.autoRenewal) && Intrinsics.areEqual((Object) this.isImmediateCancelDisable, (Object) subscriptionAutoRenewRequestModel.isImmediateCancelDisable);
    }

    @Nullable
    public final Boolean getAutoRenewal() {
        return this.autoRenewal;
    }

    public int hashCode() {
        Boolean bool = this.autoRenewal;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.isImmediateCancelDisable;
        if (bool2 != null) {
            i11 = bool2.hashCode();
        }
        return hashCode + i11;
    }

    @Nullable
    public final Boolean isImmediateCancelDisable() {
        return this.isImmediateCancelDisable;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.autoRenewal;
        Boolean bool2 = this.isImmediateCancelDisable;
        return "SubscriptionAutoRenewRequestModel(autoRenewal=" + bool + ", isImmediateCancelDisable=" + bool2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionAutoRenewRequestModel(Boolean bool, Boolean bool2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Boolean.FALSE : bool, (i11 & 2) != 0 ? Boolean.FALSE : bool2);
    }
}
