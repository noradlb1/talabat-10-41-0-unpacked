package com.talabat.talabatlife.ui.onBoarding.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatlife.features.subscription.model.response.TLifePlansResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifePlansRootResponse;
import com.talabat.talabatlife.features.waitList.model.UserWaitListRootResponse;
import com.talabat.talabatlife.features.waitList.model.UserWaitState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingDisplayModelMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingDisplayModelMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingDisplayModelMapper$Companion;", "", "()V", "mapToTLifeOnBoardingDisplayModel", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;", "root", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifePlansRootResponse;", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingWaitListDisplayModel;", "data", "Lcom/talabat/talabatlife/features/waitList/model/UserWaitListRootResponse;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TLifeOnBoardingPlanDisplayModel mapToTLifeOnBoardingDisplayModel(@NotNull TLifePlansRootResponse tLifePlansRootResponse) {
            Intrinsics.checkNotNullParameter(tLifePlansRootResponse, "root");
            TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel = new TLifeOnBoardingPlanDisplayModel(false, (String) null, (String) null, 0.0f, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 8191, (DefaultConstructorMarker) null);
            TLifePlansResponse tLifePlansResponse = (TLifePlansResponse) tLifePlansRootResponse.getResult();
            if (tLifePlansResponse != null) {
                tLifeOnBoardingPlanDisplayModel.setFreeTrialEligible(BooleanKt.orFalse(tLifePlansResponse.getFreeTrialEligible()));
                String planId = tLifePlansResponse.getPlanId();
                String str = "";
                if (planId == null) {
                    planId = str;
                }
                tLifeOnBoardingPlanDisplayModel.setPlanId(planId);
                String planTitle = tLifePlansResponse.getPlanTitle();
                if (planTitle == null) {
                    planTitle = str;
                }
                tLifeOnBoardingPlanDisplayModel.setPlanTitle(planTitle);
                tLifeOnBoardingPlanDisplayModel.setPlanAmount(FloatKt.orZero(tLifePlansResponse.getPlanAmount()));
                tLifeOnBoardingPlanDisplayModel.setFreeTrialDays(IntKt.orZero(tLifePlansResponse.getFreeTrialDays()));
                String freeTrialTitle = tLifePlansResponse.getFreeTrialTitle();
                if (freeTrialTitle == null) {
                    freeTrialTitle = str;
                }
                tLifeOnBoardingPlanDisplayModel.setFreeTrialTitle(freeTrialTitle);
                String subscriptionPaymentDate = tLifePlansResponse.getSubscriptionPaymentDate();
                if (subscriptionPaymentDate == null) {
                    subscriptionPaymentDate = str;
                }
                tLifeOnBoardingPlanDisplayModel.setSubscriptionPaymentDate(subscriptionPaymentDate);
                String actionText = tLifePlansResponse.getActionText();
                if (actionText == null) {
                    actionText = str;
                }
                tLifeOnBoardingPlanDisplayModel.setActionText(actionText);
                String onBoardingTitle = tLifePlansResponse.getOnBoardingTitle();
                if (onBoardingTitle == null) {
                    onBoardingTitle = str;
                }
                tLifeOnBoardingPlanDisplayModel.setOnBoardingTitle(onBoardingTitle);
                String onBoardingSubTitle = tLifePlansResponse.getOnBoardingSubTitle();
                if (onBoardingSubTitle == null) {
                    onBoardingSubTitle = str;
                }
                tLifeOnBoardingPlanDisplayModel.setOnBoardingSubTitle(onBoardingSubTitle);
                String descriptionText = tLifePlansResponse.getDescriptionText();
                if (descriptionText == null) {
                    descriptionText = str;
                }
                tLifeOnBoardingPlanDisplayModel.setDescriptionText(descriptionText);
                String nextBillingText = tLifePlansResponse.getNextBillingText();
                if (nextBillingText == null) {
                    nextBillingText = str;
                }
                tLifeOnBoardingPlanDisplayModel.setNextBillingText(nextBillingText);
                String nextBillingSubText = tLifePlansResponse.getNextBillingSubText();
                if (nextBillingSubText != null) {
                    str = nextBillingSubText;
                }
                tLifeOnBoardingPlanDisplayModel.setNextBillingSubText(str);
            }
            return tLifeOnBoardingPlanDisplayModel;
        }

        @NotNull
        public final TLifeOnBoardingWaitListDisplayModel mapToTLifeOnBoardingDisplayModel(@NotNull UserWaitListRootResponse userWaitListRootResponse) {
            Intrinsics.checkNotNullParameter(userWaitListRootResponse, "data");
            TLifeOnBoardingWaitListDisplayModel tLifeOnBoardingWaitListDisplayModel = new TLifeOnBoardingWaitListDisplayModel((String) null, (String) null, (String) null, false, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
            UserWaitState userWaitState = (UserWaitState) userWaitListRootResponse.getResult();
            if (userWaitState != null) {
                String actionText = userWaitState.getActionText();
                String str = "";
                if (actionText == null) {
                    actionText = str;
                }
                tLifeOnBoardingWaitListDisplayModel.setAction(actionText);
                String title = userWaitState.getTitle();
                if (title == null) {
                    title = str;
                }
                tLifeOnBoardingWaitListDisplayModel.setTitle(title);
                String descriptionText = userWaitState.getDescriptionText();
                if (descriptionText == null) {
                    descriptionText = str;
                }
                tLifeOnBoardingWaitListDisplayModel.setDescription(descriptionText);
                tLifeOnBoardingWaitListDisplayModel.setUserInWaitList(BooleanKt.orFalse(userWaitState.isUserInWaitList()));
                String onBoardingTitle = userWaitState.getOnBoardingTitle();
                if (onBoardingTitle == null) {
                    onBoardingTitle = str;
                }
                tLifeOnBoardingWaitListDisplayModel.setOnBoardingTitle(onBoardingTitle);
                String onBoardingSubTitle = userWaitState.getOnBoardingSubTitle();
                if (onBoardingSubTitle != null) {
                    str = onBoardingSubTitle;
                }
                tLifeOnBoardingWaitListDisplayModel.setOnBoardingSubTitle(str);
            }
            return tLifeOnBoardingWaitListDisplayModel;
        }
    }
}
