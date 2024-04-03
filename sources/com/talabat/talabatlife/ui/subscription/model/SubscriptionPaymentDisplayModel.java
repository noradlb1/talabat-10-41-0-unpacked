package com.talabat.talabatlife.ui.subscription.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "", "result", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel$SubscriptionPaymentResult;", "error", "", "(Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel$SubscriptionPaymentResult;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "getResult", "()Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel$SubscriptionPaymentResult;", "setResult", "(Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel$SubscriptionPaymentResult;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SubscriptionPaymentResult", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentDisplayModel {
    @NotNull
    private String error;
    @NotNull
    private SubscriptionPaymentResult result;

    public SubscriptionPaymentDisplayModel() {
        this((SubscriptionPaymentResult) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentDisplayModel(@NotNull SubscriptionPaymentResult subscriptionPaymentResult, @NotNull String str) {
        Intrinsics.checkNotNullParameter(subscriptionPaymentResult, "result");
        Intrinsics.checkNotNullParameter(str, "error");
        this.result = subscriptionPaymentResult;
        this.error = str;
    }

    public static /* synthetic */ SubscriptionPaymentDisplayModel copy$default(SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel, SubscriptionPaymentResult subscriptionPaymentResult, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionPaymentResult = subscriptionPaymentDisplayModel.result;
        }
        if ((i11 & 2) != 0) {
            str = subscriptionPaymentDisplayModel.error;
        }
        return subscriptionPaymentDisplayModel.copy(subscriptionPaymentResult, str);
    }

    @NotNull
    public final SubscriptionPaymentResult component1() {
        return this.result;
    }

    @NotNull
    public final String component2() {
        return this.error;
    }

    @NotNull
    public final SubscriptionPaymentDisplayModel copy(@NotNull SubscriptionPaymentResult subscriptionPaymentResult, @NotNull String str) {
        Intrinsics.checkNotNullParameter(subscriptionPaymentResult, "result");
        Intrinsics.checkNotNullParameter(str, "error");
        return new SubscriptionPaymentDisplayModel(subscriptionPaymentResult, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPaymentDisplayModel)) {
            return false;
        }
        SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel = (SubscriptionPaymentDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) subscriptionPaymentDisplayModel.result) && Intrinsics.areEqual((Object) this.error, (Object) subscriptionPaymentDisplayModel.error);
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    @NotNull
    public final SubscriptionPaymentResult getResult() {
        return this.result;
    }

    public int hashCode() {
        return (this.result.hashCode() * 31) + this.error.hashCode();
    }

    public final void setError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.error = str;
    }

    public final void setResult(@NotNull SubscriptionPaymentResult subscriptionPaymentResult) {
        Intrinsics.checkNotNullParameter(subscriptionPaymentResult, "<set-?>");
        this.result = subscriptionPaymentResult;
    }

    @NotNull
    public String toString() {
        SubscriptionPaymentResult subscriptionPaymentResult = this.result;
        String str = this.error;
        return "SubscriptionPaymentDisplayModel(result=" + subscriptionPaymentResult + ", error=" + str + ")";
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel$SubscriptionPaymentResult;", "", "redirectURL", "", "isSubscribed", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setSubscribed", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRedirectURL", "()Ljava/lang/String;", "setRedirectURL", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel$SubscriptionPaymentResult;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SubscriptionPaymentResult {
        @Nullable
        private Boolean isSubscribed;
        @Nullable
        private String redirectURL;

        public SubscriptionPaymentResult() {
            this((String) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
        }

        public SubscriptionPaymentResult(@Nullable String str, @Nullable Boolean bool) {
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
        public final SubscriptionPaymentResult copy(@Nullable String str, @Nullable Boolean bool) {
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

        public final void setRedirectURL(@Nullable String str) {
            this.redirectURL = str;
        }

        public final void setSubscribed(@Nullable Boolean bool) {
            this.isSubscribed = bool;
        }

        @NotNull
        public String toString() {
            String str = this.redirectURL;
            Boolean bool = this.isSubscribed;
            return "SubscriptionPaymentResult(redirectURL=" + str + ", isSubscribed=" + bool + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SubscriptionPaymentResult(String str, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? Boolean.FALSE : bool);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionPaymentDisplayModel(SubscriptionPaymentResult subscriptionPaymentResult, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new SubscriptionPaymentResult((String) null, (Boolean) null, 3, (DefaultConstructorMarker) null) : subscriptionPaymentResult, (i11 & 2) != 0 ? "" : str);
    }
}
