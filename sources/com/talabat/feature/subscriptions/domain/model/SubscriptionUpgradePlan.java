package com.talabat.feature.subscriptions.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionUpgradePlan;", "Landroid/os/Parcelable;", "planId", "", "planPeriod", "benefits", "", "Lcom/talabat/feature/subscriptions/domain/model/UpgradePlanBenefit;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBenefits", "()Ljava/util/List;", "getPlanId", "()Ljava/lang/String;", "getPlanPeriod", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SubscriptionUpgradePlan implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<SubscriptionUpgradePlan> CREATOR = new Creator();
    @NotNull
    private final List<UpgradePlanBenefit> benefits;
    @NotNull
    private final String planId;
    @NotNull
    private final String planPeriod;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionUpgradePlan> {
        @NotNull
        public final SubscriptionUpgradePlan createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                arrayList.add(UpgradePlanBenefit.CREATOR.createFromParcel(parcel));
            }
            return new SubscriptionUpgradePlan(readString, readString2, arrayList);
        }

        @NotNull
        public final SubscriptionUpgradePlan[] newArray(int i11) {
            return new SubscriptionUpgradePlan[i11];
        }
    }

    public SubscriptionUpgradePlan() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionUpgradePlan(@NotNull String str, @NotNull String str2, @NotNull List<UpgradePlanBenefit> list) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "planPeriod");
        Intrinsics.checkNotNullParameter(list, TproBenefitsViewModel.TPRO_BENEFITS_SCREEN_TYPE);
        this.planId = str;
        this.planPeriod = str2;
        this.benefits = list;
    }

    public static /* synthetic */ SubscriptionUpgradePlan copy$default(SubscriptionUpgradePlan subscriptionUpgradePlan, String str, String str2, List<UpgradePlanBenefit> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionUpgradePlan.planId;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionUpgradePlan.planPeriod;
        }
        if ((i11 & 4) != 0) {
            list = subscriptionUpgradePlan.benefits;
        }
        return subscriptionUpgradePlan.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.planId;
    }

    @NotNull
    public final String component2() {
        return this.planPeriod;
    }

    @NotNull
    public final List<UpgradePlanBenefit> component3() {
        return this.benefits;
    }

    @NotNull
    public final SubscriptionUpgradePlan copy(@NotNull String str, @NotNull String str2, @NotNull List<UpgradePlanBenefit> list) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "planPeriod");
        Intrinsics.checkNotNullParameter(list, TproBenefitsViewModel.TPRO_BENEFITS_SCREEN_TYPE);
        return new SubscriptionUpgradePlan(str, str2, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionUpgradePlan)) {
            return false;
        }
        SubscriptionUpgradePlan subscriptionUpgradePlan = (SubscriptionUpgradePlan) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) subscriptionUpgradePlan.planId) && Intrinsics.areEqual((Object) this.planPeriod, (Object) subscriptionUpgradePlan.planPeriod) && Intrinsics.areEqual((Object) this.benefits, (Object) subscriptionUpgradePlan.benefits);
    }

    @NotNull
    public final List<UpgradePlanBenefit> getBenefits() {
        return this.benefits;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    @NotNull
    public final String getPlanPeriod() {
        return this.planPeriod;
    }

    public int hashCode() {
        return (((this.planId.hashCode() * 31) + this.planPeriod.hashCode()) * 31) + this.benefits.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.planPeriod;
        List<UpgradePlanBenefit> list = this.benefits;
        return "SubscriptionUpgradePlan(planId=" + str + ", planPeriod=" + str2 + ", benefits=" + list + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.planId);
        parcel.writeString(this.planPeriod);
        List<UpgradePlanBenefit> list = this.benefits;
        parcel.writeInt(list.size());
        for (UpgradePlanBenefit writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionUpgradePlan(String str, String str2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
