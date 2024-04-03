package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherRootResponse;", "", "result", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherResponseModel;", "errorCode", "", "errors", "", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherResponseModel;Ljava/lang/String;Ljava/util/List;)V", "getErrorCode", "()Ljava/lang/String;", "getErrors", "()Ljava/util/List;", "getResult", "()Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherResponseModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionB2BVoucherRootResponse {
    @Nullable
    private final String errorCode;
    @Nullable
    private final List<String> errors;
    @Nullable
    private final SubscriptionB2BVoucherResponseModel result;

    public SubscriptionB2BVoucherRootResponse() {
        this((SubscriptionB2BVoucherResponseModel) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionB2BVoucherRootResponse(@Nullable @Json(name = "result") SubscriptionB2BVoucherResponseModel subscriptionB2BVoucherResponseModel, @Nullable @Json(name = "errorCode") String str, @Nullable @Json(name = "errors") List<String> list) {
        this.result = subscriptionB2BVoucherResponseModel;
        this.errorCode = str;
        this.errors = list;
    }

    public static /* synthetic */ SubscriptionB2BVoucherRootResponse copy$default(SubscriptionB2BVoucherRootResponse subscriptionB2BVoucherRootResponse, SubscriptionB2BVoucherResponseModel subscriptionB2BVoucherResponseModel, String str, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionB2BVoucherResponseModel = subscriptionB2BVoucherRootResponse.result;
        }
        if ((i11 & 2) != 0) {
            str = subscriptionB2BVoucherRootResponse.errorCode;
        }
        if ((i11 & 4) != 0) {
            list = subscriptionB2BVoucherRootResponse.errors;
        }
        return subscriptionB2BVoucherRootResponse.copy(subscriptionB2BVoucherResponseModel, str, list);
    }

    @Nullable
    public final SubscriptionB2BVoucherResponseModel component1() {
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
    public final SubscriptionB2BVoucherRootResponse copy(@Nullable @Json(name = "result") SubscriptionB2BVoucherResponseModel subscriptionB2BVoucherResponseModel, @Nullable @Json(name = "errorCode") String str, @Nullable @Json(name = "errors") List<String> list) {
        return new SubscriptionB2BVoucherRootResponse(subscriptionB2BVoucherResponseModel, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionB2BVoucherRootResponse)) {
            return false;
        }
        SubscriptionB2BVoucherRootResponse subscriptionB2BVoucherRootResponse = (SubscriptionB2BVoucherRootResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) subscriptionB2BVoucherRootResponse.result) && Intrinsics.areEqual((Object) this.errorCode, (Object) subscriptionB2BVoucherRootResponse.errorCode) && Intrinsics.areEqual((Object) this.errors, (Object) subscriptionB2BVoucherRootResponse.errors);
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
    public final SubscriptionB2BVoucherResponseModel getResult() {
        return this.result;
    }

    public int hashCode() {
        SubscriptionB2BVoucherResponseModel subscriptionB2BVoucherResponseModel = this.result;
        int i11 = 0;
        int hashCode = (subscriptionB2BVoucherResponseModel == null ? 0 : subscriptionB2BVoucherResponseModel.hashCode()) * 31;
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
        SubscriptionB2BVoucherResponseModel subscriptionB2BVoucherResponseModel = this.result;
        String str = this.errorCode;
        List<String> list = this.errors;
        return "SubscriptionB2BVoucherRootResponse(result=" + subscriptionB2BVoucherResponseModel + ", errorCode=" + str + ", errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionB2BVoucherRootResponse(SubscriptionB2BVoucherResponseModel subscriptionB2BVoucherResponseModel, String str, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subscriptionB2BVoucherResponseModel, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : list);
    }
}
