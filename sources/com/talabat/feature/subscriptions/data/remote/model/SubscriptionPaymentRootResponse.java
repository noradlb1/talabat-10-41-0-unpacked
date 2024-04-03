package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B#\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse;", "", "result", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse$SubscriptionPaymentResult;", "errors", "", "", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse$SubscriptionPaymentResult;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getResult", "()Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse$SubscriptionPaymentResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SubscriptionPaymentResult", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentRootResponse {
    @Nullable
    private final List<String> errors;
    @Nullable
    private final SubscriptionPaymentResult result;

    public SubscriptionPaymentRootResponse() {
        this((SubscriptionPaymentResult) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentRootResponse(@Nullable @Json(name = "result") SubscriptionPaymentResult subscriptionPaymentResult, @Nullable @Json(name = "errors") List<String> list) {
        this.result = subscriptionPaymentResult;
        this.errors = list;
    }

    public static /* synthetic */ SubscriptionPaymentRootResponse copy$default(SubscriptionPaymentRootResponse subscriptionPaymentRootResponse, SubscriptionPaymentResult subscriptionPaymentResult, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionPaymentResult = subscriptionPaymentRootResponse.result;
        }
        if ((i11 & 2) != 0) {
            list = subscriptionPaymentRootResponse.errors;
        }
        return subscriptionPaymentRootResponse.copy(subscriptionPaymentResult, list);
    }

    @Nullable
    public final SubscriptionPaymentResult component1() {
        return this.result;
    }

    @Nullable
    public final List<String> component2() {
        return this.errors;
    }

    @NotNull
    public final SubscriptionPaymentRootResponse copy(@Nullable @Json(name = "result") SubscriptionPaymentResult subscriptionPaymentResult, @Nullable @Json(name = "errors") List<String> list) {
        return new SubscriptionPaymentRootResponse(subscriptionPaymentResult, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPaymentRootResponse)) {
            return false;
        }
        SubscriptionPaymentRootResponse subscriptionPaymentRootResponse = (SubscriptionPaymentRootResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) subscriptionPaymentRootResponse.result) && Intrinsics.areEqual((Object) this.errors, (Object) subscriptionPaymentRootResponse.errors);
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    @Nullable
    public final SubscriptionPaymentResult getResult() {
        return this.result;
    }

    public int hashCode() {
        SubscriptionPaymentResult subscriptionPaymentResult = this.result;
        int i11 = 0;
        int hashCode = (subscriptionPaymentResult == null ? 0 : subscriptionPaymentResult.hashCode()) * 31;
        List<String> list = this.errors;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        SubscriptionPaymentResult subscriptionPaymentResult = this.result;
        List<String> list = this.errors;
        return "SubscriptionPaymentRootResponse(result=" + subscriptionPaymentResult + ", errors=" + list + ")";
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse$SubscriptionPaymentResult;", "", "redirectURL", "", "isSubscribed", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRedirectURL", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse$SubscriptionPaymentResult;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SubscriptionPaymentResult {
        @Nullable
        private final Boolean isSubscribed;
        @Nullable
        private final String redirectURL;

        public SubscriptionPaymentResult() {
            this((String) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
        }

        public SubscriptionPaymentResult(@Nullable @Json(name = "redirectURL") String str, @Nullable @Json(name = "isSubscribed") Boolean bool) {
            this.redirectURL = str;
            this.isSubscribed = bool;
        }

        public static /* synthetic */ SubscriptionPaymentResult copy$default(SubscriptionPaymentResult subscriptionPaymentResult, String str, Boolean bool, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = subscriptionPaymentResult.redirectURL;
            }
            if ((i11 & 2) != 0) {
                bool = subscriptionPaymentResult.isSubscribed;
            }
            return subscriptionPaymentResult.copy(str, bool);
        }

        @Nullable
        public final String component1() {
            return this.redirectURL;
        }

        @Nullable
        public final Boolean component2() {
            return this.isSubscribed;
        }

        @NotNull
        public final SubscriptionPaymentResult copy(@Nullable @Json(name = "redirectURL") String str, @Nullable @Json(name = "isSubscribed") Boolean bool) {
            return new SubscriptionPaymentResult(str, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubscriptionPaymentResult)) {
                return false;
            }
            SubscriptionPaymentResult subscriptionPaymentResult = (SubscriptionPaymentResult) obj;
            return Intrinsics.areEqual((Object) this.redirectURL, (Object) subscriptionPaymentResult.redirectURL) && Intrinsics.areEqual((Object) this.isSubscribed, (Object) subscriptionPaymentResult.isSubscribed);
        }

        @Nullable
        public final String getRedirectURL() {
            return this.redirectURL;
        }

        public int hashCode() {
            String str = this.redirectURL;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.isSubscribed;
            if (bool != null) {
                i11 = bool.hashCode();
            }
            return hashCode + i11;
        }

        @Nullable
        public final Boolean isSubscribed() {
            return this.isSubscribed;
        }

        @NotNull
        public String toString() {
            String str = this.redirectURL;
            Boolean bool = this.isSubscribed;
            return "SubscriptionPaymentResult(redirectURL=" + str + ", isSubscribed=" + bool + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SubscriptionPaymentResult(String str, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : bool);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionPaymentRootResponse(SubscriptionPaymentResult subscriptionPaymentResult, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subscriptionPaymentResult, (i11 & 2) != 0 ? null : list);
    }
}
