package com.talabat.talabatlife.ui.subscriptionManagement.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailModel;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailResult;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionPaymentHistoryModel;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionPlanModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/subscriptionManagement/model/TLifeSubscriptionManagementMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeSubscriptionManagementMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/talabat/talabatlife/ui/subscriptionManagement/model/TLifeSubscriptionManagementMapper$Companion;", "", "()V", "mapTLifeSubscriptionDetail", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/TLifeSubscriptionDetailDisplayModel;", "response", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResponse;", "setButtonAction", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/SubscriptionButtonAction;", "isActive", "", "isAutoRenewable", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TLifeSubscriptionDetailDisplayModel mapTLifeSubscriptionDetail(@Nullable TLifeSubscriptionDetailResponse tLifeSubscriptionDetailResponse) {
            TLifeSubscriptionDetailResult result;
            TLifeSubscriptionPaymentHistoryModel paymentHistory;
            Boolean latestAutoRenewPaymentStatus;
            TLifeSubscriptionDetailResult result2;
            String actionText;
            TLifeSubscriptionDetailResult result3;
            TLifeSubscriptionPlanModel plan;
            TLifeSubscriptionDetailResult result4;
            TLifeSubscriptionDetailModel subscription;
            TLifeSubscriptionDetailDisplayModel tLifeSubscriptionDetailDisplayModel = new TLifeSubscriptionDetailDisplayModel();
            String str = "";
            if (!(tLifeSubscriptionDetailResponse == null || (result4 = tLifeSubscriptionDetailResponse.getResult()) == null || (subscription = result4.getSubscription()) == null)) {
                tLifeSubscriptionDetailDisplayModel.setActive(BooleanKt.orFalse(subscription.isActive()));
                String membershipId = subscription.getMembershipId();
                if (membershipId == null) {
                    membershipId = str;
                }
                tLifeSubscriptionDetailDisplayModel.setMembershipId(membershipId);
                tLifeSubscriptionDetailDisplayModel.setAutoRenewable(BooleanKt.orFalse(subscription.isAutoRenewable()));
                String nextBillingDate = subscription.getNextBillingDate();
                if (nextBillingDate == null) {
                    nextBillingDate = str;
                }
                tLifeSubscriptionDetailDisplayModel.setNextBillingDate(nextBillingDate);
                String endDate = subscription.getEndDate();
                if (endDate == null) {
                    endDate = str;
                }
                tLifeSubscriptionDetailDisplayModel.setEndDate(endDate);
                tLifeSubscriptionDetailDisplayModel.setButtonAction(TLifeSubscriptionManagementMapper.Companion.setButtonAction(tLifeSubscriptionDetailDisplayModel.isActive(), tLifeSubscriptionDetailDisplayModel.isAutoRenewable()));
            }
            if (!(tLifeSubscriptionDetailResponse == null || (result3 = tLifeSubscriptionDetailResponse.getResult()) == null || (plan = result3.getPlan()) == null)) {
                String planTitle = plan.getPlanTitle();
                if (planTitle != null) {
                    str = planTitle;
                }
                tLifeSubscriptionDetailDisplayModel.setPlanTitle(str);
            }
            if (!(tLifeSubscriptionDetailResponse == null || (result2 = tLifeSubscriptionDetailResponse.getResult()) == null || (actionText = result2.getActionText()) == null)) {
                tLifeSubscriptionDetailDisplayModel.setActionText(actionText);
            }
            if (!(tLifeSubscriptionDetailResponse == null || (result = tLifeSubscriptionDetailResponse.getResult()) == null || (paymentHistory = result.getPaymentHistory()) == null || (latestAutoRenewPaymentStatus = paymentHistory.getLatestAutoRenewPaymentStatus()) == null)) {
                tLifeSubscriptionDetailDisplayModel.setLatestAutoRenewPaymentStatus(latestAutoRenewPaymentStatus.booleanValue());
            }
            return tLifeSubscriptionDetailDisplayModel;
        }

        @NotNull
        public final SubscriptionButtonAction setButtonAction(boolean z11, boolean z12) {
            if (!z11) {
                return SubscriptionButtonAction.SUBSCRIBE;
            }
            if (z11 && !z12) {
                return SubscriptionButtonAction.AUTO_RENEW;
            }
            if (!z11 || !z12) {
                return SubscriptionButtonAction.DEFAULT;
            }
            return SubscriptionButtonAction.CANCEL_SUBSCRIPTION;
        }
    }
}
