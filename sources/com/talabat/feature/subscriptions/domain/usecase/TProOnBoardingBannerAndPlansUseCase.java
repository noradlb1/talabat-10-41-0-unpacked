package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JI\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/TProOnBoardingBannerAndPlansUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;)V", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerAndPlanModel;", "country", "", "duration", "", "freeCoffee", "", "voucherCode", "requestingPage", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingBannerAndPlansUseCase {
    @NotNull
    private final ISubscriptionsRepository repository;

    @Inject
    public TProOnBoardingBannerAndPlansUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        this.repository = iSubscriptionsRepository;
    }

    public static /* synthetic */ Object invoke$default(TProOnBoardingBannerAndPlansUseCase tProOnBoardingBannerAndPlansUseCase, int i11, String str, Boolean bool, String str2, String str3, Continuation continuation, int i12, Object obj) {
        return tProOnBoardingBannerAndPlansUseCase.invoke(i11, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : bool, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? null : str3, continuation);
    }

    @Nullable
    public final Object invoke(int i11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super TProOnBoardingBannerAndPlanModel> continuation) {
        return this.repository.fetchTProOnBoardingBannerAndPlans(i11, str, bool, str2, str3, continuation);
    }
}
