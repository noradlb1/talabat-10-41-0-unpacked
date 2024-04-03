package com.talabat.talabatlife.features.subscription.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/response/SubscriptionPaymentResponse;", "", "result", "Lcom/talabat/talabatlife/features/subscription/model/response/SubscriptionPaymentResponse$SubscriptionPaymentResult;", "errors", "", "", "(Lcom/talabat/talabatlife/features/subscription/model/response/SubscriptionPaymentResponse$SubscriptionPaymentResult;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getResult", "()Lcom/talabat/talabatlife/features/subscription/model/response/SubscriptionPaymentResponse$SubscriptionPaymentResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SubscriptionPaymentResult", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentResponse {
    @SerializedName("errors")
    @Nullable
    private final List<String> errors;
    @SerializedName("result")
    @Nullable
    private final SubscriptionPaymentResult result;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/response/SubscriptionPaymentResponse$SubscriptionPaymentResult;", "", "()V", "isSubscribed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "redirectURL", "", "getRedirectURL", "()Ljava/lang/String;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SubscriptionPaymentResult {
        @SerializedName("isSubscribed")
        @Nullable
        private final Boolean isSubscribed;
        @SerializedName("redirectURL")
        @Nullable
        private final String redirectURL;

        @Nullable
        public final String getRedirectURL() {
            return this.redirectURL;
        }

        @Nullable
        public final Boolean isSubscribed() {
            return this.isSubscribed;
        }
    }

    public SubscriptionPaymentResponse() {
        this((SubscriptionPaymentResult) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentResponse(@Nullable SubscriptionPaymentResult subscriptionPaymentResult, @Nullable List<String> list) {
        this.result = subscriptionPaymentResult;
        this.errors = list;
    }

    public static /* synthetic */ SubscriptionPaymentResponse copy$default(SubscriptionPaymentResponse subscriptionPaymentResponse, SubscriptionPaymentResult subscriptionPaymentResult, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionPaymentResult = subscriptionPaymentResponse.result;
        }
        if ((i11 & 2) != 0) {
            list = subscriptionPaymentResponse.errors;
        }
        return subscriptionPaymentResponse.copy(subscriptionPaymentResult, list);
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
    public final SubscriptionPaymentResponse copy(@Nullable SubscriptionPaymentResult subscriptionPaymentResult, @Nullable List<String> list) {
        return new SubscriptionPaymentResponse(subscriptionPaymentResult, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPaymentResponse)) {
            return false;
        }
        SubscriptionPaymentResponse subscriptionPaymentResponse = (SubscriptionPaymentResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) subscriptionPaymentResponse.result) && Intrinsics.areEqual((Object) this.errors, (Object) subscriptionPaymentResponse.errors);
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
        return "SubscriptionPaymentResponse(result=" + subscriptionPaymentResult + ", errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionPaymentResponse(SubscriptionPaymentResult subscriptionPaymentResult, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subscriptionPaymentResult, (i11 & 2) != 0 ? null : list);
    }
}
