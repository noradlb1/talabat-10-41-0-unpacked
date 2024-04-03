package com.talabat.feature.tpro.presentation.model;

import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/TProOnBoardingDisplayModel;", "", "subscriptionMultiPlan", "Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;", "favoriteVendors", "", "", "heroBanner", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerModel;", "cards", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardModel;", "(Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;Ljava/util/List;Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerModel;Ljava/util/List;)V", "getCards", "()Ljava/util/List;", "getFavoriteVendors", "getHeroBanner", "()Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerModel;", "getSubscriptionMultiPlan", "()Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingDisplayModel {
    @NotNull
    private final List<TProOnBoardingCardModel> cards;
    @NotNull
    private final List<String> favoriteVendors;
    @NotNull
    private final TProOnBoardingBannerModel heroBanner;
    @NotNull
    private final TProMultiPlanDisplayModel subscriptionMultiPlan;

    public TProOnBoardingDisplayModel(@NotNull TProMultiPlanDisplayModel tProMultiPlanDisplayModel, @NotNull List<String> list, @NotNull TProOnBoardingBannerModel tProOnBoardingBannerModel, @NotNull List<? extends TProOnBoardingCardModel> list2) {
        Intrinsics.checkNotNullParameter(tProMultiPlanDisplayModel, "subscriptionMultiPlan");
        Intrinsics.checkNotNullParameter(list, "favoriteVendors");
        Intrinsics.checkNotNullParameter(tProOnBoardingBannerModel, "heroBanner");
        Intrinsics.checkNotNullParameter(list2, "cards");
        this.subscriptionMultiPlan = tProMultiPlanDisplayModel;
        this.favoriteVendors = list;
        this.heroBanner = tProOnBoardingBannerModel;
        this.cards = list2;
    }

    public static /* synthetic */ TProOnBoardingDisplayModel copy$default(TProOnBoardingDisplayModel tProOnBoardingDisplayModel, TProMultiPlanDisplayModel tProMultiPlanDisplayModel, List<String> list, TProOnBoardingBannerModel tProOnBoardingBannerModel, List<TProOnBoardingCardModel> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            tProMultiPlanDisplayModel = tProOnBoardingDisplayModel.subscriptionMultiPlan;
        }
        if ((i11 & 2) != 0) {
            list = tProOnBoardingDisplayModel.favoriteVendors;
        }
        if ((i11 & 4) != 0) {
            tProOnBoardingBannerModel = tProOnBoardingDisplayModel.heroBanner;
        }
        if ((i11 & 8) != 0) {
            list2 = tProOnBoardingDisplayModel.cards;
        }
        return tProOnBoardingDisplayModel.copy(tProMultiPlanDisplayModel, list, tProOnBoardingBannerModel, list2);
    }

    @NotNull
    public final TProMultiPlanDisplayModel component1() {
        return this.subscriptionMultiPlan;
    }

    @NotNull
    public final List<String> component2() {
        return this.favoriteVendors;
    }

    @NotNull
    public final TProOnBoardingBannerModel component3() {
        return this.heroBanner;
    }

    @NotNull
    public final List<TProOnBoardingCardModel> component4() {
        return this.cards;
    }

    @NotNull
    public final TProOnBoardingDisplayModel copy(@NotNull TProMultiPlanDisplayModel tProMultiPlanDisplayModel, @NotNull List<String> list, @NotNull TProOnBoardingBannerModel tProOnBoardingBannerModel, @NotNull List<? extends TProOnBoardingCardModel> list2) {
        Intrinsics.checkNotNullParameter(tProMultiPlanDisplayModel, "subscriptionMultiPlan");
        Intrinsics.checkNotNullParameter(list, "favoriteVendors");
        Intrinsics.checkNotNullParameter(tProOnBoardingBannerModel, "heroBanner");
        Intrinsics.checkNotNullParameter(list2, "cards");
        return new TProOnBoardingDisplayModel(tProMultiPlanDisplayModel, list, tProOnBoardingBannerModel, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingDisplayModel)) {
            return false;
        }
        TProOnBoardingDisplayModel tProOnBoardingDisplayModel = (TProOnBoardingDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.subscriptionMultiPlan, (Object) tProOnBoardingDisplayModel.subscriptionMultiPlan) && Intrinsics.areEqual((Object) this.favoriteVendors, (Object) tProOnBoardingDisplayModel.favoriteVendors) && Intrinsics.areEqual((Object) this.heroBanner, (Object) tProOnBoardingDisplayModel.heroBanner) && Intrinsics.areEqual((Object) this.cards, (Object) tProOnBoardingDisplayModel.cards);
    }

    @NotNull
    public final List<TProOnBoardingCardModel> getCards() {
        return this.cards;
    }

    @NotNull
    public final List<String> getFavoriteVendors() {
        return this.favoriteVendors;
    }

    @NotNull
    public final TProOnBoardingBannerModel getHeroBanner() {
        return this.heroBanner;
    }

    @NotNull
    public final TProMultiPlanDisplayModel getSubscriptionMultiPlan() {
        return this.subscriptionMultiPlan;
    }

    public int hashCode() {
        return (((((this.subscriptionMultiPlan.hashCode() * 31) + this.favoriteVendors.hashCode()) * 31) + this.heroBanner.hashCode()) * 31) + this.cards.hashCode();
    }

    @NotNull
    public String toString() {
        TProMultiPlanDisplayModel tProMultiPlanDisplayModel = this.subscriptionMultiPlan;
        List<String> list = this.favoriteVendors;
        TProOnBoardingBannerModel tProOnBoardingBannerModel = this.heroBanner;
        List<TProOnBoardingCardModel> list2 = this.cards;
        return "TProOnBoardingDisplayModel(subscriptionMultiPlan=" + tProMultiPlanDisplayModel + ", favoriteVendors=" + list + ", heroBanner=" + tProOnBoardingBannerModel + ", cards=" + list2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProOnBoardingDisplayModel(TProMultiPlanDisplayModel tProMultiPlanDisplayModel, List list, TProOnBoardingBannerModel tProOnBoardingBannerModel, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(tProMultiPlanDisplayModel, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, tProOnBoardingBannerModel, list2);
    }
}
