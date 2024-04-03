package com.talabat.talabatlife.features.subscription.repository;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatlife.ui.subscriptionManagement.model.AutoRenewSubscriptionDisplayModel;
import com.talabat.talabatlife.ui.subscriptionManagement.model.TLifeSubscriptionDetailDisplayModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\rH&J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\f\u001a\u00020\rH&J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/repository/SubscriptionRepository;", "", "autoRenewSubscription", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/AutoRenewSubscriptionDisplayModel;", "membershipId", "", "enabled", "", "getTLifeSubscriptionDetail", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/TLifeSubscriptionDetailDisplayModel;", "country", "", "getUserPlans", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;", "subscribe", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "requestModel", "Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SubscriptionRepository {
    @NotNull
    Either<Failure, AutoRenewSubscriptionDisplayModel> autoRenewSubscription(@NotNull String str, boolean z11);

    @NotNull
    Either<Failure, TLifeSubscriptionDetailDisplayModel> getTLifeSubscriptionDetail(int i11);

    @NotNull
    Either<Failure, TLifeOnBoardingPlanDisplayModel> getUserPlans(int i11);

    @NotNull
    Either<Failure, SubscriptionPaymentDisplayModel> subscribe(@NotNull SubscriptionPaymentRequestModel subscriptionPaymentRequestModel);
}
