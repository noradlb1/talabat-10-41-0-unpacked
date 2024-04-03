package com.talabat.growth.ui.loyalty;

import com.talabat.growth.features.loyalty.models.responses.RewardsPointsBannerModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/growth/features/loyalty/models/responses/RewardsPointsBannerModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderRewardsViewModel$isRewardsPointsBannerVisible$1 extends Lambda implements Function1<Either<? extends Failure, ? extends RewardsPointsBannerModel>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenHeaderRewardsViewModel f60593g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenHeaderRewardsViewModel$isRewardsPointsBannerVisible$1(HomeScreenHeaderRewardsViewModel homeScreenHeaderRewardsViewModel) {
        super(1);
        this.f60593g = homeScreenHeaderRewardsViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, RewardsPointsBannerModel>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, RewardsPointsBannerModel> either) {
        Intrinsics.checkNotNullParameter(either, "result");
        AnonymousClass1 r02 = AnonymousClass1.INSTANCE;
        final HomeScreenHeaderRewardsViewModel homeScreenHeaderRewardsViewModel = this.f60593g;
        either.either(r02, new Function1<RewardsPointsBannerModel, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RewardsPointsBannerModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull RewardsPointsBannerModel rewardsPointsBannerModel) {
                Intrinsics.checkNotNullParameter(rewardsPointsBannerModel, "it");
                if (homeScreenHeaderRewardsViewModel.isFwFLoyaltyEnabled()) {
                    homeScreenHeaderRewardsViewModel.showRewardsBanner(rewardsPointsBannerModel);
                } else {
                    homeScreenHeaderRewardsViewModel.getShowRewardsBanner().postValue(Boolean.FALSE);
                }
            }
        });
    }
}
