package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPRootResponseModel;", "", "result", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPPointResponseModel;", "errors", "", "", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPPointResponseModel;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getResult", "()Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPPointResponseModel;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentOTPRootResponseModel {
    @Nullable
    private final List<String> errors;
    @Nullable
    private final SubscriptionPaymentOTPPointResponseModel result;

    public SubscriptionPaymentOTPRootResponseModel() {
        this((SubscriptionPaymentOTPPointResponseModel) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentOTPRootResponseModel(@Nullable @Json(name = "result") SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel, @Nullable @Json(name = "errors") List<String> list) {
        this.result = subscriptionPaymentOTPPointResponseModel;
        this.errors = list;
    }

    public static /* synthetic */ SubscriptionPaymentOTPRootResponseModel copy$default(SubscriptionPaymentOTPRootResponseModel subscriptionPaymentOTPRootResponseModel, SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionPaymentOTPPointResponseModel = subscriptionPaymentOTPRootResponseModel.result;
        }
        if ((i11 & 2) != 0) {
            list = subscriptionPaymentOTPRootResponseModel.errors;
        }
        return subscriptionPaymentOTPRootResponseModel.copy(subscriptionPaymentOTPPointResponseModel, list);
    }

    @Nullable
    public final SubscriptionPaymentOTPPointResponseModel component1() {
        return this.result;
    }

    @Nullable
    public final List<String> component2() {
        return this.errors;
    }

    @NotNull
    public final SubscriptionPaymentOTPRootResponseModel copy(@Nullable @Json(name = "result") SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel, @Nullable @Json(name = "errors") List<String> list) {
        return new SubscriptionPaymentOTPRootResponseModel(subscriptionPaymentOTPPointResponseModel, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPaymentOTPRootResponseModel)) {
            return false;
        }
        SubscriptionPaymentOTPRootResponseModel subscriptionPaymentOTPRootResponseModel = (SubscriptionPaymentOTPRootResponseModel) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) subscriptionPaymentOTPRootResponseModel.result) && Intrinsics.areEqual((Object) this.errors, (Object) subscriptionPaymentOTPRootResponseModel.errors);
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    @Nullable
    public final SubscriptionPaymentOTPPointResponseModel getResult() {
        return this.result;
    }

    public int hashCode() {
        SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel = this.result;
        int i11 = 0;
        int hashCode = (subscriptionPaymentOTPPointResponseModel == null ? 0 : subscriptionPaymentOTPPointResponseModel.hashCode()) * 31;
        List<String> list = this.errors;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel = this.result;
        List<String> list = this.errors;
        return "SubscriptionPaymentOTPRootResponseModel(result=" + subscriptionPaymentOTPPointResponseModel + ", errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionPaymentOTPRootResponseModel(SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subscriptionPaymentOTPPointResponseModel, (i11 & 2) != 0 ? null : list);
    }
}
