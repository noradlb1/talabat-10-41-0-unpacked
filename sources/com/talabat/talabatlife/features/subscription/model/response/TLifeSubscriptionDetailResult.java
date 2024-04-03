package com.talabat.talabatlife.features.subscription.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResult;", "", "subscription", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailModel;", "plan", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionPlanModel;", "paymentHistory", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionPaymentHistoryModel;", "actionText", "", "(Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailModel;Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionPlanModel;Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionPaymentHistoryModel;Ljava/lang/String;)V", "getActionText", "()Ljava/lang/String;", "getPaymentHistory", "()Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionPaymentHistoryModel;", "getPlan", "()Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionPlanModel;", "getSubscription", "()Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeSubscriptionDetailResult {
    @SerializedName("actionText")
    @Nullable
    private final String actionText;
    @SerializedName("paymentHistory")
    @Nullable
    private final TLifeSubscriptionPaymentHistoryModel paymentHistory;
    @SerializedName("plan")
    @Nullable
    private final TLifeSubscriptionPlanModel plan;
    @SerializedName("subscription")
    @Nullable
    private final TLifeSubscriptionDetailModel subscription;

    public TLifeSubscriptionDetailResult() {
        this((TLifeSubscriptionDetailModel) null, (TLifeSubscriptionPlanModel) null, (TLifeSubscriptionPaymentHistoryModel) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public TLifeSubscriptionDetailResult(@Nullable TLifeSubscriptionDetailModel tLifeSubscriptionDetailModel, @Nullable TLifeSubscriptionPlanModel tLifeSubscriptionPlanModel, @Nullable TLifeSubscriptionPaymentHistoryModel tLifeSubscriptionPaymentHistoryModel, @Nullable String str) {
        this.subscription = tLifeSubscriptionDetailModel;
        this.plan = tLifeSubscriptionPlanModel;
        this.paymentHistory = tLifeSubscriptionPaymentHistoryModel;
        this.actionText = str;
    }

    public static /* synthetic */ TLifeSubscriptionDetailResult copy$default(TLifeSubscriptionDetailResult tLifeSubscriptionDetailResult, TLifeSubscriptionDetailModel tLifeSubscriptionDetailModel, TLifeSubscriptionPlanModel tLifeSubscriptionPlanModel, TLifeSubscriptionPaymentHistoryModel tLifeSubscriptionPaymentHistoryModel, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            tLifeSubscriptionDetailModel = tLifeSubscriptionDetailResult.subscription;
        }
        if ((i11 & 2) != 0) {
            tLifeSubscriptionPlanModel = tLifeSubscriptionDetailResult.plan;
        }
        if ((i11 & 4) != 0) {
            tLifeSubscriptionPaymentHistoryModel = tLifeSubscriptionDetailResult.paymentHistory;
        }
        if ((i11 & 8) != 0) {
            str = tLifeSubscriptionDetailResult.actionText;
        }
        return tLifeSubscriptionDetailResult.copy(tLifeSubscriptionDetailModel, tLifeSubscriptionPlanModel, tLifeSubscriptionPaymentHistoryModel, str);
    }

    @Nullable
    public final TLifeSubscriptionDetailModel component1() {
        return this.subscription;
    }

    @Nullable
    public final TLifeSubscriptionPlanModel component2() {
        return this.plan;
    }

    @Nullable
    public final TLifeSubscriptionPaymentHistoryModel component3() {
        return this.paymentHistory;
    }

    @Nullable
    public final String component4() {
        return this.actionText;
    }

    @NotNull
    public final TLifeSubscriptionDetailResult copy(@Nullable TLifeSubscriptionDetailModel tLifeSubscriptionDetailModel, @Nullable TLifeSubscriptionPlanModel tLifeSubscriptionPlanModel, @Nullable TLifeSubscriptionPaymentHistoryModel tLifeSubscriptionPaymentHistoryModel, @Nullable String str) {
        return new TLifeSubscriptionDetailResult(tLifeSubscriptionDetailModel, tLifeSubscriptionPlanModel, tLifeSubscriptionPaymentHistoryModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TLifeSubscriptionDetailResult)) {
            return false;
        }
        TLifeSubscriptionDetailResult tLifeSubscriptionDetailResult = (TLifeSubscriptionDetailResult) obj;
        return Intrinsics.areEqual((Object) this.subscription, (Object) tLifeSubscriptionDetailResult.subscription) && Intrinsics.areEqual((Object) this.plan, (Object) tLifeSubscriptionDetailResult.plan) && Intrinsics.areEqual((Object) this.paymentHistory, (Object) tLifeSubscriptionDetailResult.paymentHistory) && Intrinsics.areEqual((Object) this.actionText, (Object) tLifeSubscriptionDetailResult.actionText);
    }

    @Nullable
    public final String getActionText() {
        return this.actionText;
    }

    @Nullable
    public final TLifeSubscriptionPaymentHistoryModel getPaymentHistory() {
        return this.paymentHistory;
    }

    @Nullable
    public final TLifeSubscriptionPlanModel getPlan() {
        return this.plan;
    }

    @Nullable
    public final TLifeSubscriptionDetailModel getSubscription() {
        return this.subscription;
    }

    public int hashCode() {
        TLifeSubscriptionDetailModel tLifeSubscriptionDetailModel = this.subscription;
        int i11 = 0;
        int hashCode = (tLifeSubscriptionDetailModel == null ? 0 : tLifeSubscriptionDetailModel.hashCode()) * 31;
        TLifeSubscriptionPlanModel tLifeSubscriptionPlanModel = this.plan;
        int hashCode2 = (hashCode + (tLifeSubscriptionPlanModel == null ? 0 : tLifeSubscriptionPlanModel.hashCode())) * 31;
        TLifeSubscriptionPaymentHistoryModel tLifeSubscriptionPaymentHistoryModel = this.paymentHistory;
        int hashCode3 = (hashCode2 + (tLifeSubscriptionPaymentHistoryModel == null ? 0 : tLifeSubscriptionPaymentHistoryModel.hashCode())) * 31;
        String str = this.actionText;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        TLifeSubscriptionDetailModel tLifeSubscriptionDetailModel = this.subscription;
        TLifeSubscriptionPlanModel tLifeSubscriptionPlanModel = this.plan;
        TLifeSubscriptionPaymentHistoryModel tLifeSubscriptionPaymentHistoryModel = this.paymentHistory;
        String str = this.actionText;
        return "TLifeSubscriptionDetailResult(subscription=" + tLifeSubscriptionDetailModel + ", plan=" + tLifeSubscriptionPlanModel + ", paymentHistory=" + tLifeSubscriptionPaymentHistoryModel + ", actionText=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TLifeSubscriptionDetailResult(TLifeSubscriptionDetailModel tLifeSubscriptionDetailModel, TLifeSubscriptionPlanModel tLifeSubscriptionPlanModel, TLifeSubscriptionPaymentHistoryModel tLifeSubscriptionPaymentHistoryModel, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : tLifeSubscriptionDetailModel, (i11 & 2) != 0 ? null : tLifeSubscriptionPlanModel, (i11 & 4) != 0 ? null : tLifeSubscriptionPaymentHistoryModel, (i11 & 8) != 0 ? null : str);
    }
}
