package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionResponseResult;", "", "subscriptions", "", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionResponseModel;", "(Ljava/util/List;)V", "getSubscriptions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionResponseResult {
    @SerializedName("subscriptions")
    @Nullable
    private final List<SubscriptionResponseModel> subscriptions;

    public SubscriptionResponseResult(@Nullable List<SubscriptionResponseModel> list) {
        this.subscriptions = list;
    }

    public static /* synthetic */ SubscriptionResponseResult copy$default(SubscriptionResponseResult subscriptionResponseResult, List<SubscriptionResponseModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = subscriptionResponseResult.subscriptions;
        }
        return subscriptionResponseResult.copy(list);
    }

    @Nullable
    public final List<SubscriptionResponseModel> component1() {
        return this.subscriptions;
    }

    @NotNull
    public final SubscriptionResponseResult copy(@Nullable List<SubscriptionResponseModel> list) {
        return new SubscriptionResponseResult(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubscriptionResponseResult) && Intrinsics.areEqual((Object) this.subscriptions, (Object) ((SubscriptionResponseResult) obj).subscriptions);
    }

    @Nullable
    public final List<SubscriptionResponseModel> getSubscriptions() {
        return this.subscriptions;
    }

    public int hashCode() {
        List<SubscriptionResponseModel> list = this.subscriptions;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<SubscriptionResponseModel> list = this.subscriptions;
        return "SubscriptionResponseResult(subscriptions=" + list + ")";
    }
}
