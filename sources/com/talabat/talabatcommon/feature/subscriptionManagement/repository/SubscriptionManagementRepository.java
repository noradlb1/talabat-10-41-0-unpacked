package com.talabat.talabatcommon.feature.subscriptionManagement.repository;

import com.talabat.talabatcommon.feature.subscriptionManagement.model.SetSubscriptionDefaultCardResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewUpdateResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDetailRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackRequest;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationReasonResponse;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003H&J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0003H&J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J.\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0014H&¨\u0006\""}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/repository/SubscriptionManagementRepository;", "", "getProSubscription", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionRootResponse;", "country", "", "productId", "getSubscriptionCancellationReasons", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationReasonResponse;", "getSubscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRootResponse;", "getSubscriptionDetail", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDetailRootResponse;", "subscriptionMemberId", "getSubscriptionPlans", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanRootResponse;", "getSubscriptions", "isActive", "", "postSubscriptionCancellationFeedback", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackResponse;", "subscriptionCancellationFeedbackRequest", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackRequest;", "setSubscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SetSubscriptionDefaultCardResponse;", "subscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRequestModel;", "updateSubscriptionAutoRenew", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewUpdateResponse;", "subscriptionAutoRenewRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;", "isInstrumentationTest", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SubscriptionManagementRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Either updateSubscriptionAutoRenew$default(SubscriptionManagementRepository subscriptionManagementRepository, String str, SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    z11 = false;
                }
                return subscriptionManagementRepository.updateSubscriptionAutoRenew(str, subscriptionAutoRenewRequestModel, z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSubscriptionAutoRenew");
        }
    }

    @NotNull
    Either<Failure, SubscriptionRootResponse> getProSubscription(@NotNull String str, @NotNull String str2);

    @NotNull
    Either<Failure, SubscriptionCancellationReasonResponse> getSubscriptionCancellationReasons();

    @NotNull
    Either<Failure, SubscriptionDefaultCardRootResponse> getSubscriptionDefaultCard();

    @NotNull
    Either<Failure, SubscriptionDetailRootResponse> getSubscriptionDetail(@NotNull String str);

    @NotNull
    Either<Failure, SubscriptionPlanRootResponse> getSubscriptionPlans(@NotNull String str);

    @NotNull
    Either<Failure, SubscriptionRootResponse> getSubscriptions(@NotNull String str, boolean z11);

    @NotNull
    Either<Failure, SubscriptionCancellationFeedbackResponse> postSubscriptionCancellationFeedback(@NotNull SubscriptionCancellationFeedbackRequest subscriptionCancellationFeedbackRequest);

    @NotNull
    Either<Failure, SetSubscriptionDefaultCardResponse> setSubscriptionDefaultCard(@NotNull SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel);

    @NotNull
    Either<Failure, SubscriptionAutoRenewUpdateResponse> updateSubscriptionAutoRenew(@NotNull String str, @NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, boolean z11);
}
