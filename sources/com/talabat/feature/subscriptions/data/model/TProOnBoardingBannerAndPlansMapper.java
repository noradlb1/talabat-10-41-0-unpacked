package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.HeroWidgetResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerAndPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingTitleSpanningResponseModel;
import com.talabat.feature.subscriptions.domain.model.FreeTrialInfo;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerModel;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingBannerAndPlansMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerAndPlanResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerAndPlanModel;", "subscriptionPlanMapper", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionMultiPlanModelMapper;", "heroBannerModelMapper", "Lcom/talabat/feature/subscriptions/data/model/HeroBannerModelMapper;", "tProOnBoardingCardMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMapper;", "tProOnBoardingCardSpanningTitleMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;", "(Lcom/talabat/feature/subscriptions/data/model/SubscriptionMultiPlanModelMapper;Lcom/talabat/feature/subscriptions/data/model/HeroBannerModelMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;)V", "apply", "source", "mapHeroBanner", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerModel;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingBannerAndPlansMapper implements ModelMapper<TProOnBoardingBannerAndPlanResponseModel, TProOnBoardingBannerAndPlanModel> {
    @NotNull
    private final HeroBannerModelMapper heroBannerModelMapper;
    @NotNull
    private final SubscriptionMultiPlanModelMapper subscriptionPlanMapper;
    @NotNull
    private final TProOnBoardingCardMapper tProOnBoardingCardMapper;
    @NotNull
    private TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper;

    @Inject
    public TProOnBoardingBannerAndPlansMapper(@NotNull SubscriptionMultiPlanModelMapper subscriptionMultiPlanModelMapper, @NotNull HeroBannerModelMapper heroBannerModelMapper2, @NotNull TProOnBoardingCardMapper tProOnBoardingCardMapper2, @NotNull TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper2) {
        Intrinsics.checkNotNullParameter(subscriptionMultiPlanModelMapper, "subscriptionPlanMapper");
        Intrinsics.checkNotNullParameter(heroBannerModelMapper2, "heroBannerModelMapper");
        Intrinsics.checkNotNullParameter(tProOnBoardingCardMapper2, "tProOnBoardingCardMapper");
        Intrinsics.checkNotNullParameter(tProOnBoardingCardSpanningTitleMapper2, "tProOnBoardingCardSpanningTitleMapper");
        this.subscriptionPlanMapper = subscriptionMultiPlanModelMapper;
        this.heroBannerModelMapper = heroBannerModelMapper2;
        this.tProOnBoardingCardMapper = tProOnBoardingCardMapper2;
        this.tProOnBoardingCardSpanningTitleMapper = tProOnBoardingCardSpanningTitleMapper2;
    }

    private final TProOnBoardingBannerModel mapHeroBanner(TProOnBoardingBannerAndPlanResponseModel tProOnBoardingBannerAndPlanResponseModel) {
        List<HeroWidgetResponseModel> list;
        List<TProOnBoardingTitleSpanningResponseModel> list2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        TProOnBoardingBannerResponseModel heroBanner = tProOnBoardingBannerAndPlanResponseModel.getHeroBanner();
        String str6 = null;
        if (heroBanner != null) {
            list = heroBanner.getHeroWidget();
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        TProOnBoardingBannerResponseModel heroBanner2 = tProOnBoardingBannerAndPlanResponseModel.getHeroBanner();
        if (heroBanner2 != null) {
            list2 = heroBanner2.getHeroSpannableTitle();
        } else {
            list2 = null;
        }
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        TProOnBoardingBannerResponseModel heroBanner3 = tProOnBoardingBannerAndPlanResponseModel.getHeroBanner();
        if (heroBanner3 != null) {
            str = heroBanner3.getHeroHeaderLogo();
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        TProOnBoardingBannerResponseModel heroBanner4 = tProOnBoardingBannerAndPlanResponseModel.getHeroBanner();
        if (heroBanner4 != null) {
            str3 = heroBanner4.getHeroBackgroundColor();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        Iterable<HeroWidgetResponseModel> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (HeroWidgetResponseModel apply : iterable) {
            arrayList.add(this.heroBannerModelMapper.apply(apply));
        }
        TProOnBoardingBannerResponseModel heroBanner5 = tProOnBoardingBannerAndPlanResponseModel.getHeroBanner();
        if (heroBanner5 != null) {
            str6 = heroBanner5.getHeroBackgroundImage();
        }
        if (str6 == null) {
            str5 = "";
        } else {
            str5 = str6;
        }
        Iterable<TProOnBoardingTitleSpanningResponseModel> iterable2 = list2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (TProOnBoardingTitleSpanningResponseModel apply2 : iterable2) {
            arrayList2.add(this.tProOnBoardingCardSpanningTitleMapper.apply(apply2));
        }
        return new TProOnBoardingBannerModel(str2, str4, arrayList, str5, arrayList2);
    }

    @NotNull
    public TProOnBoardingBannerAndPlanModel apply(@NotNull TProOnBoardingBannerAndPlanResponseModel tProOnBoardingBannerAndPlanResponseModel) {
        SubscriptionMultiPlan subscriptionMultiPlan;
        Intrinsics.checkNotNullParameter(tProOnBoardingBannerAndPlanResponseModel, "source");
        List<TProOnBoardingCardResponseModel> cards = tProOnBoardingBannerAndPlanResponseModel.getCards();
        if (cards == null) {
            cards = CollectionsKt__CollectionsKt.emptyList();
        }
        SubscriptionMultiPlanResponseModel subscriptionMultiPlans = tProOnBoardingBannerAndPlanResponseModel.getSubscriptionMultiPlans();
        if (subscriptionMultiPlans == null || (subscriptionMultiPlan = this.subscriptionPlanMapper.apply(subscriptionMultiPlans)) == null) {
            subscriptionMultiPlan = new SubscriptionMultiPlan(false, (FreeTrialInfo) null, (List) null, (List) null, (String) null, 31, (DefaultConstructorMarker) null);
        }
        TProOnBoardingBannerModel mapHeroBanner = mapHeroBanner(tProOnBoardingBannerAndPlanResponseModel);
        List<String> favoriteVendors = tProOnBoardingBannerAndPlanResponseModel.getFavoriteVendors();
        if (favoriteVendors == null) {
            favoriteVendors = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<TProOnBoardingCardResponseModel> iterable = cards;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TProOnBoardingCardResponseModel apply : iterable) {
            arrayList.add(this.tProOnBoardingCardMapper.apply(apply));
        }
        return new TProOnBoardingBannerAndPlanModel(subscriptionMultiPlan, favoriteVendors, mapHeroBanner, arrayList);
    }
}
