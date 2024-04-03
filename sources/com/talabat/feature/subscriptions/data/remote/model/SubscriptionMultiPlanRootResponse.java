package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanRootResponse;", "", "result", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;", "errorCode", "", "errors", "", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;Ljava/lang/String;Ljava/util/List;)V", "getErrorCode", "()Ljava/lang/String;", "getErrors", "()Ljava/util/List;", "getResult", "()Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionMultiPlanRootResponse {
    @Nullable
    private final String errorCode;
    @Nullable
    private final List<String> errors;
    @Nullable
    private final SubscriptionMultiPlanResponseModel result;

    public SubscriptionMultiPlanRootResponse() {
        this((SubscriptionMultiPlanResponseModel) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionMultiPlanRootResponse(@Nullable @Json(name = "result") SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, @Nullable @Json(name = "errorCode") String str, @Nullable @Json(name = "errors") List<String> list) {
        this.result = subscriptionMultiPlanResponseModel;
        this.errorCode = str;
        this.errors = list;
    }

    public static /* synthetic */ SubscriptionMultiPlanRootResponse copy$default(SubscriptionMultiPlanRootResponse subscriptionMultiPlanRootResponse, SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, String str, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionMultiPlanResponseModel = subscriptionMultiPlanRootResponse.result;
        }
        if ((i11 & 2) != 0) {
            str = subscriptionMultiPlanRootResponse.errorCode;
        }
        if ((i11 & 4) != 0) {
            list = subscriptionMultiPlanRootResponse.errors;
        }
        return subscriptionMultiPlanRootResponse.copy(subscriptionMultiPlanResponseModel, str, list);
    }

    @Nullable
    public final SubscriptionMultiPlanResponseModel component1() {
        return this.result;
    }

    @Nullable
    public final String component2() {
        return this.errorCode;
    }

    @Nullable
    public final List<String> component3() {
        return this.errors;
    }

    @NotNull
    public final SubscriptionMultiPlanRootResponse copy(@Nullable @Json(name = "result") SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, @Nullable @Json(name = "errorCode") String str, @Nullable @Json(name = "errors") List<String> list) {
        return new SubscriptionMultiPlanRootResponse(subscriptionMultiPlanResponseModel, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionMultiPlanRootResponse)) {
            return false;
        }
        SubscriptionMultiPlanRootResponse subscriptionMultiPlanRootResponse = (SubscriptionMultiPlanRootResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) subscriptionMultiPlanRootResponse.result) && Intrinsics.areEqual((Object) this.errorCode, (Object) subscriptionMultiPlanRootResponse.errorCode) && Intrinsics.areEqual((Object) this.errors, (Object) subscriptionMultiPlanRootResponse.errors);
    }

    @Nullable
    public final String getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    @Nullable
    public final SubscriptionMultiPlanResponseModel getResult() {
        return this.result;
    }

    public int hashCode() {
        SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel = this.result;
        int i11 = 0;
        int hashCode = (subscriptionMultiPlanResponseModel == null ? 0 : subscriptionMultiPlanResponseModel.hashCode()) * 31;
        String str = this.errorCode;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.errors;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel = this.result;
        String str = this.errorCode;
        List<String> list = this.errors;
        return "SubscriptionMultiPlanRootResponse(result=" + subscriptionMultiPlanResponseModel + ", errorCode=" + str + ", errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionMultiPlanRootResponse(SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, String str, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subscriptionMultiPlanResponseModel, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : list);
    }
}
