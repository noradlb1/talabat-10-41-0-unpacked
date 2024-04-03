package com.talabat.talabatlife.ui.onBoarding.viewModel;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatlife.features.UrlConstantsKt;
import com.talabat.talabatlife.features.subscription.GetSubscriptionPaymentUseCase;
import com.talabat.talabatlife.features.subscription.GetTLifeOnBoardingPlans;
import com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel;
import com.talabat.talabatlife.features.vendors.GetVendorsList;
import com.talabat.talabatlife.features.vendors.vendorList.models.request.VendorListRequestModel;
import com.talabat.talabatlife.features.waitList.GetUserWaitListState;
import com.talabat.talabatlife.features.waitList.JoinWaitList;
import com.talabat.talabatlife.tracking.LifeOnBoardingLoadedUseCase;
import com.talabat.talabatlife.tracking.SubscribeClickedUseCase;
import com.talabat.talabatlife.tracking.SubscriptionAttemptedUseCase;
import com.talabat.talabatlife.tracking.SubscriptionCompletedUseCase;
import com.talabat.talabatlife.tracking.SubscriptionFailedUseCase;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingWaitListDisplayModel;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u0006\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J>\u0010\u0002\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u00101\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u000204H\u0016J4\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001f2\"\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f08j\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f`9H\u0002J\b\u0010:\u001a\u00020\u001cH\u0016J\b\u0010;\u001a\u00020\u001cH\u0016J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u001fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/viewModel/TLifeOnBoardingViewModelImpl;", "Lcom/talabat/talabatlife/ui/onBoarding/viewModel/TLifeOnBoardingViewModel;", "getVendorsList", "Lcom/talabat/talabatlife/features/vendors/GetVendorsList;", "getOnBoardingPlans", "Lcom/talabat/talabatlife/features/subscription/GetTLifeOnBoardingPlans;", "getUserWaitListState", "Lcom/talabat/talabatlife/features/waitList/GetUserWaitListState;", "JoinWaitList", "Lcom/talabat/talabatlife/features/waitList/JoinWaitList;", "subscriptionPaymentUseCase", "Lcom/talabat/talabatlife/features/subscription/GetSubscriptionPaymentUseCase;", "lifeOnBoardingLoadedUseCase", "Lcom/talabat/talabatlife/tracking/LifeOnBoardingLoadedUseCase;", "subscribeClickedUseCase", "Lcom/talabat/talabatlife/tracking/SubscribeClickedUseCase;", "subscriptionAttemptedUseCase", "Lcom/talabat/talabatlife/tracking/SubscriptionAttemptedUseCase;", "subscriptionCompletedUseCase", "Lcom/talabat/talabatlife/tracking/SubscriptionCompletedUseCase;", "subscriptionFailedUseCase", "Lcom/talabat/talabatlife/tracking/SubscriptionFailedUseCase;", "(Lcom/talabat/talabatlife/features/vendors/GetVendorsList;Lcom/talabat/talabatlife/features/subscription/GetTLifeOnBoardingPlans;Lcom/talabat/talabatlife/features/waitList/GetUserWaitListState;Lcom/talabat/talabatlife/features/waitList/JoinWaitList;Lcom/talabat/talabatlife/features/subscription/GetSubscriptionPaymentUseCase;Lcom/talabat/talabatlife/tracking/LifeOnBoardingLoadedUseCase;Lcom/talabat/talabatlife/tracking/SubscribeClickedUseCase;Lcom/talabat/talabatlife/tracking/SubscriptionAttemptedUseCase;Lcom/talabat/talabatlife/tracking/SubscriptionCompletedUseCase;Lcom/talabat/talabatlife/tracking/SubscriptionFailedUseCase;)V", "tLifeOnBoardingPlanDisplayModel", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;", "vendorCount", "", "getTLifeOnBoardingPlans", "", "countryCode", "lat", "", "long", "pageNumber", "pageSize", "areaID", "handleJoinWaitList", "model", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingWaitListDisplayModel;", "handlePlans", "handleSuccessSubscriptionService", "subscriptionPaymentDisplayModel", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "handleVendorListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "handleVendorListFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "handleWaitListState", "joinWaitList", "payForSubscription", "requestModel", "Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "sendFirebaseEvent", "eventName", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sendSubscriptionAttemptedEvent", "sendSubscriptionClickedEvent", "sendSubscriptionFailed", "error", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingViewModelImpl extends TLifeOnBoardingViewModel {
    @NotNull
    private final JoinWaitList JoinWaitList;
    @NotNull
    private final GetTLifeOnBoardingPlans getOnBoardingPlans;
    @NotNull
    private final GetUserWaitListState getUserWaitListState;
    @NotNull
    private final GetVendorsList getVendorsList;
    @NotNull
    private final LifeOnBoardingLoadedUseCase lifeOnBoardingLoadedUseCase;
    @NotNull
    private final SubscribeClickedUseCase subscribeClickedUseCase;
    @NotNull
    private final SubscriptionAttemptedUseCase subscriptionAttemptedUseCase;
    @NotNull
    private final SubscriptionCompletedUseCase subscriptionCompletedUseCase;
    @NotNull
    private final SubscriptionFailedUseCase subscriptionFailedUseCase;
    @NotNull
    private final GetSubscriptionPaymentUseCase subscriptionPaymentUseCase;
    @Nullable
    private TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel;
    private int vendorCount;

    public TLifeOnBoardingViewModelImpl(@NotNull GetVendorsList getVendorsList2, @NotNull GetTLifeOnBoardingPlans getTLifeOnBoardingPlans, @NotNull GetUserWaitListState getUserWaitListState2, @NotNull JoinWaitList joinWaitList, @NotNull GetSubscriptionPaymentUseCase getSubscriptionPaymentUseCase, @NotNull LifeOnBoardingLoadedUseCase lifeOnBoardingLoadedUseCase2, @NotNull SubscribeClickedUseCase subscribeClickedUseCase2, @NotNull SubscriptionAttemptedUseCase subscriptionAttemptedUseCase2, @NotNull SubscriptionCompletedUseCase subscriptionCompletedUseCase2, @NotNull SubscriptionFailedUseCase subscriptionFailedUseCase2) {
        Intrinsics.checkNotNullParameter(getVendorsList2, "getVendorsList");
        Intrinsics.checkNotNullParameter(getTLifeOnBoardingPlans, "getOnBoardingPlans");
        Intrinsics.checkNotNullParameter(getUserWaitListState2, "getUserWaitListState");
        Intrinsics.checkNotNullParameter(joinWaitList, "JoinWaitList");
        Intrinsics.checkNotNullParameter(getSubscriptionPaymentUseCase, "subscriptionPaymentUseCase");
        Intrinsics.checkNotNullParameter(lifeOnBoardingLoadedUseCase2, "lifeOnBoardingLoadedUseCase");
        Intrinsics.checkNotNullParameter(subscribeClickedUseCase2, "subscribeClickedUseCase");
        Intrinsics.checkNotNullParameter(subscriptionAttemptedUseCase2, "subscriptionAttemptedUseCase");
        Intrinsics.checkNotNullParameter(subscriptionCompletedUseCase2, "subscriptionCompletedUseCase");
        Intrinsics.checkNotNullParameter(subscriptionFailedUseCase2, "subscriptionFailedUseCase");
        this.getVendorsList = getVendorsList2;
        this.getOnBoardingPlans = getTLifeOnBoardingPlans;
        this.getUserWaitListState = getUserWaitListState2;
        this.JoinWaitList = joinWaitList;
        this.subscriptionPaymentUseCase = getSubscriptionPaymentUseCase;
        this.lifeOnBoardingLoadedUseCase = lifeOnBoardingLoadedUseCase2;
        this.subscribeClickedUseCase = subscribeClickedUseCase2;
        this.subscriptionAttemptedUseCase = subscriptionAttemptedUseCase2;
        this.subscriptionCompletedUseCase = subscriptionCompletedUseCase2;
        this.subscriptionFailedUseCase = subscriptionFailedUseCase2;
    }

    /* access modifiers changed from: private */
    public final void handleJoinWaitList(TLifeOnBoardingWaitListDisplayModel tLifeOnBoardingWaitListDisplayModel) {
        getJoinWaitListData().setValue(tLifeOnBoardingWaitListDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handlePlans(TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel2) {
        this.tLifeOnBoardingPlanDisplayModel = tLifeOnBoardingPlanDisplayModel2;
        getPlansData().setValue(tLifeOnBoardingPlanDisplayModel2);
    }

    /* access modifiers changed from: private */
    public final void handleSuccessSubscriptionService(SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel) {
        TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel2 = this.tLifeOnBoardingPlanDisplayModel;
        if (tLifeOnBoardingPlanDisplayModel2 != null) {
            UseCase.invoke$default(this.subscriptionCompletedUseCase, new SubscriptionCompletedUseCase.Params(tLifeOnBoardingPlanDisplayModel2.getPlanAmount()), (Function1) null, 2, (Object) null);
        }
        getSubscriptionPaymentData().setValue(subscriptionPaymentDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleVendorListDisplayModel(VendorListDisplayModel vendorListDisplayModel) {
        getVendorList().setValue(vendorListDisplayModel);
        int totalCount = vendorListDisplayModel.getTotalCount();
        this.vendorCount = totalCount;
        this.lifeOnBoardingLoadedUseCase.invoke(Integer.valueOf(totalCount), new TLifeOnBoardingViewModelImpl$handleVendorListDisplayModel$1(this));
    }

    /* access modifiers changed from: private */
    public final void handleVendorListFailure(Failure failure) {
        getVendorListFailure().setValue(failure);
    }

    /* access modifiers changed from: private */
    public final void handleWaitListState(TLifeOnBoardingWaitListDisplayModel tLifeOnBoardingWaitListDisplayModel) {
        getWaitListData().setValue(tLifeOnBoardingWaitListDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void sendFirebaseEvent(String str, HashMap<String, String> hashMap) {
        getSendFireBaseEventData().postValue(new Pair(str, hashMap));
    }

    public void getTLifeOnBoardingPlans(int i11) {
        this.getOnBoardingPlans.invoke(Integer.valueOf(i11), new TLifeOnBoardingViewModelImpl$getTLifeOnBoardingPlans$1(this));
    }

    public void getUserWaitListState(int i11) {
        this.getUserWaitListState.invoke(Integer.valueOf(i11), new TLifeOnBoardingViewModelImpl$getUserWaitListState$1(this));
    }

    public void getVendorsList(int i11, @Nullable String str, @Nullable String str2, int i12, int i13, @Nullable String str3) {
        GetVendorsList getVendorsList2 = this.getVendorsList;
        VendorListRequestModel vendorListRequestModel = r2;
        VendorListRequestModel vendorListRequestModel2 = new VendorListRequestModel(i11, str, UrlConstantsKt.PATH_FEATURED, str2, i12, i13, (String) null, str3, false, 0, 0, 1856, (DefaultConstructorMarker) null);
        getVendorsList2.invoke(vendorListRequestModel, new TLifeOnBoardingViewModelImpl$getVendorsList$1(this));
    }

    public void joinWaitList(int i11) {
        this.lifeOnBoardingLoadedUseCase.invoke(Integer.valueOf(this.vendorCount), new TLifeOnBoardingViewModelImpl$joinWaitList$1(this));
        this.JoinWaitList.invoke(Integer.valueOf(i11), new TLifeOnBoardingViewModelImpl$joinWaitList$2(this));
    }

    public void payForSubscription(@NotNull SubscriptionPaymentRequestModel subscriptionPaymentRequestModel) {
        Intrinsics.checkNotNullParameter(subscriptionPaymentRequestModel, "requestModel");
        this.subscriptionPaymentUseCase.invoke(subscriptionPaymentRequestModel, new TLifeOnBoardingViewModelImpl$payForSubscription$1(this));
    }

    public void sendSubscriptionAttemptedEvent() {
        TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel2 = this.tLifeOnBoardingPlanDisplayModel;
        if (tLifeOnBoardingPlanDisplayModel2 != null) {
            UseCase.invoke$default(this.subscriptionAttemptedUseCase, new SubscriptionAttemptedUseCase.Params(tLifeOnBoardingPlanDisplayModel2.getFreeTrialEligible(), tLifeOnBoardingPlanDisplayModel2.getPlanAmount()), (Function1) null, 2, (Object) null);
        }
    }

    public void sendSubscriptionClickedEvent() {
        TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel2 = this.tLifeOnBoardingPlanDisplayModel;
        if (tLifeOnBoardingPlanDisplayModel2 != null) {
            UseCase.invoke$default(this.subscribeClickedUseCase, new SubscribeClickedUseCase.Params(tLifeOnBoardingPlanDisplayModel2.getFreeTrialEligible(), tLifeOnBoardingPlanDisplayModel2.getPlanAmount()), (Function1) null, 2, (Object) null);
        }
    }

    public void sendSubscriptionFailed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel2 = this.tLifeOnBoardingPlanDisplayModel;
        if (tLifeOnBoardingPlanDisplayModel2 != null) {
            UseCase.invoke$default(this.subscriptionFailedUseCase, new SubscriptionFailedUseCase.Params(tLifeOnBoardingPlanDisplayModel2.getFreeTrialEligible(), tLifeOnBoardingPlanDisplayModel2.getPlanAmount(), str), (Function1) null, 2, (Object) null);
        }
    }
}
