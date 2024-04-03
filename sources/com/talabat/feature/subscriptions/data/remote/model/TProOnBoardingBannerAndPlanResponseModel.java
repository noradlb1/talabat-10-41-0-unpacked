package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerAndPlanResponseModel;", "", "subscriptionMultiPlans", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;", "favoriteVendors", "", "", "heroBanner", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerResponseModel;", "cards", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardResponseModel;", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;Ljava/util/List;Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerResponseModel;Ljava/util/List;)V", "getCards", "()Ljava/util/List;", "getFavoriteVendors", "getHeroBanner", "()Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerResponseModel;", "getSubscriptionMultiPlans", "()Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingBannerAndPlanResponseModel {
    @Nullable
    private final List<TProOnBoardingCardResponseModel> cards;
    @Nullable
    private final List<String> favoriteVendors;
    @Nullable
    private final TProOnBoardingBannerResponseModel heroBanner;
    @Nullable
    private final SubscriptionMultiPlanResponseModel subscriptionMultiPlans;

    public TProOnBoardingBannerAndPlanResponseModel() {
        this((SubscriptionMultiPlanResponseModel) null, (List) null, (TProOnBoardingBannerResponseModel) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingBannerAndPlanResponseModel(@Nullable @Json(name = "subscriptionMultiPlans") SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, @Nullable @Json(name = "favoriteVendors") List<String> list, @Nullable @Json(name = "heroBanner") TProOnBoardingBannerResponseModel tProOnBoardingBannerResponseModel, @Nullable @Json(name = "cards") List<? extends TProOnBoardingCardResponseModel> list2) {
        this.subscriptionMultiPlans = subscriptionMultiPlanResponseModel;
        this.favoriteVendors = list;
        this.heroBanner = tProOnBoardingBannerResponseModel;
        this.cards = list2;
    }

    public static /* synthetic */ TProOnBoardingBannerAndPlanResponseModel copy$default(TProOnBoardingBannerAndPlanResponseModel tProOnBoardingBannerAndPlanResponseModel, SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, List<String> list, TProOnBoardingBannerResponseModel tProOnBoardingBannerResponseModel, List<TProOnBoardingCardResponseModel> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionMultiPlanResponseModel = tProOnBoardingBannerAndPlanResponseModel.subscriptionMultiPlans;
        }
        if ((i11 & 2) != 0) {
            list = tProOnBoardingBannerAndPlanResponseModel.favoriteVendors;
        }
        if ((i11 & 4) != 0) {
            tProOnBoardingBannerResponseModel = tProOnBoardingBannerAndPlanResponseModel.heroBanner;
        }
        if ((i11 & 8) != 0) {
            list2 = tProOnBoardingBannerAndPlanResponseModel.cards;
        }
        return tProOnBoardingBannerAndPlanResponseModel.copy(subscriptionMultiPlanResponseModel, list, tProOnBoardingBannerResponseModel, list2);
    }

    @Nullable
    public final SubscriptionMultiPlanResponseModel component1() {
        return this.subscriptionMultiPlans;
    }

    @Nullable
    public final List<String> component2() {
        return this.favoriteVendors;
    }

    @Nullable
    public final TProOnBoardingBannerResponseModel component3() {
        return this.heroBanner;
    }

    @Nullable
    public final List<TProOnBoardingCardResponseModel> component4() {
        return this.cards;
    }

    @NotNull
    public final TProOnBoardingBannerAndPlanResponseModel copy(@Nullable @Json(name = "subscriptionMultiPlans") SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, @Nullable @Json(name = "favoriteVendors") List<String> list, @Nullable @Json(name = "heroBanner") TProOnBoardingBannerResponseModel tProOnBoardingBannerResponseModel, @Nullable @Json(name = "cards") List<? extends TProOnBoardingCardResponseModel> list2) {
        return new TProOnBoardingBannerAndPlanResponseModel(subscriptionMultiPlanResponseModel, list, tProOnBoardingBannerResponseModel, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingBannerAndPlanResponseModel)) {
            return false;
        }
        TProOnBoardingBannerAndPlanResponseModel tProOnBoardingBannerAndPlanResponseModel = (TProOnBoardingBannerAndPlanResponseModel) obj;
        return Intrinsics.areEqual((Object) this.subscriptionMultiPlans, (Object) tProOnBoardingBannerAndPlanResponseModel.subscriptionMultiPlans) && Intrinsics.areEqual((Object) this.favoriteVendors, (Object) tProOnBoardingBannerAndPlanResponseModel.favoriteVendors) && Intrinsics.areEqual((Object) this.heroBanner, (Object) tProOnBoardingBannerAndPlanResponseModel.heroBanner) && Intrinsics.areEqual((Object) this.cards, (Object) tProOnBoardingBannerAndPlanResponseModel.cards);
    }

    @Nullable
    public final List<TProOnBoardingCardResponseModel> getCards() {
        return this.cards;
    }

    @Nullable
    public final List<String> getFavoriteVendors() {
        return this.favoriteVendors;
    }

    @Nullable
    public final TProOnBoardingBannerResponseModel getHeroBanner() {
        return this.heroBanner;
    }

    @Nullable
    public final SubscriptionMultiPlanResponseModel getSubscriptionMultiPlans() {
        return this.subscriptionMultiPlans;
    }

    public int hashCode() {
        SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel = this.subscriptionMultiPlans;
        int i11 = 0;
        int hashCode = (subscriptionMultiPlanResponseModel == null ? 0 : subscriptionMultiPlanResponseModel.hashCode()) * 31;
        List<String> list = this.favoriteVendors;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        TProOnBoardingBannerResponseModel tProOnBoardingBannerResponseModel = this.heroBanner;
        int hashCode3 = (hashCode2 + (tProOnBoardingBannerResponseModel == null ? 0 : tProOnBoardingBannerResponseModel.hashCode())) * 31;
        List<TProOnBoardingCardResponseModel> list2 = this.cards;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel = this.subscriptionMultiPlans;
        List<String> list = this.favoriteVendors;
        TProOnBoardingBannerResponseModel tProOnBoardingBannerResponseModel = this.heroBanner;
        List<TProOnBoardingCardResponseModel> list2 = this.cards;
        return "TProOnBoardingBannerAndPlanResponseModel(subscriptionMultiPlans=" + subscriptionMultiPlanResponseModel + ", favoriteVendors=" + list + ", heroBanner=" + tProOnBoardingBannerResponseModel + ", cards=" + list2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProOnBoardingBannerAndPlanResponseModel(SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, List list, TProOnBoardingBannerResponseModel tProOnBoardingBannerResponseModel, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subscriptionMultiPlanResponseModel, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : tProOnBoardingBannerResponseModel, (i11 & 8) != 0 ? null : list2);
    }
}
