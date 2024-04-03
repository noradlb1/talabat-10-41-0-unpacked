package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bumptech.glide.request.RequestListener;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.HeroWidgetModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingDefaultCardModel;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionWithB2BVoucherUseCase;
import com.talabat.feature.subscriptions.domain.usecase.TProOnBoardingBannerAndPlansUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.homescreen.network.UrlConstantsKt;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import to.a;
import to.b;
import to.c;
import to.d;
import to.e;

@Metadata(d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001@\u0018\u0000 Z2\u00020\u0001:\u0001ZBY\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u000208H\u0002J\r\u0010?\u001a\u00020@H\u0002¢\u0006\u0002\u0010AJ\u001c\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u00192\b\u0010E\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u00109\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010\u00192\b\u0010D\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010F\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u00192\u0006\u0010G\u001a\u00020(J\u0016\u0010H\u001a\u00020C2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0002J\u0010\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020NH\u0002J\u0016\u0010O\u001a\u0010\u0012\f\u0012\n P*\u0004\u0018\u00010\u00190\u00190\u0018H\u0002J\u0016\u0010Q\u001a\u0010\u0012\f\u0012\n P*\u0004\u0018\u00010\u00190\u00190\u0018H\u0002J\u0006\u0010R\u001a\u00020CJ\b\u0010S\u001a\u00020CH\u0002J\u000e\u0010T\u001a\u00020C2\u0006\u0010U\u001a\u00020\u0019J\b\u0010V\u001a\u00020WH\u0002J\u000e\u0010X\u001a\u00020C2\u0006\u0010Y\u001a\u00020\u0019R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'¢\u0006\b\n\u0000\u001a\u0004\b&\u0010)R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u001f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010,0\u001f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u0002000/¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020(0\u001f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00190\u001f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u0002080\u001f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u001f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"¨\u0006["}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModel;", "Landroidx/lifecycle/ViewModel;", "resources", "Landroid/content/res/Resources;", "countryId", "", "multiPlanParams", "Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/MultiPlanParams;", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "subscriptionWithB2BVoucherUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionWithB2BVoucherUseCase;", "getActiveSubscriptionsUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "tProOnBoardingBannerAndPlansUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/TProOnBoardingBannerAndPlansUseCase;", "getProCentralizationStatusWrapper", "Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;", "(Landroid/content/res/Resources;ILcom/talabat/feature/tpro/presentation/benefits/viewmodel/MultiPlanParams;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionWithB2BVoucherUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lcom/talabat/feature/subscriptions/domain/usecase/TProOnBoardingBannerAndPlansUseCase;Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;)V", "amountText", "Landroidx/lifecycle/LiveData;", "", "getAmountText", "()Landroidx/lifecycle/LiveData;", "amountTextNewHero", "getAmountTextNewHero", "displayError", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/feature/tpro/presentation/model/SubscriptionsErrorDisplayModel;", "getDisplayError", "()Landroidx/lifecycle/MutableLiveData;", "failure", "", "getFailure", "isDataReady", "Landroidx/lifecycle/MediatorLiveData;", "", "()Landroidx/lifecycle/MediatorLiveData;", "isSubscribedWithB2BVoucher", "postUpdatingStatus", "Lcom/talabat/core/navigation/domain/screen/Screen;", "getPostUpdatingStatus", "preloaderCallback", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "getPreloaderCallback", "()Lcom/bumptech/glide/request/RequestListener;", "resourcesLoaded", "getResourcesLoaded", "sendFirebaseEvent", "getSendFirebaseEvent", "tProMultiPlan", "Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;", "getTProMultiPlan", "tProOnBoardingPlan", "Lcom/talabat/feature/tpro/presentation/model/TProOnBoardingDisplayModel;", "getTProOnBoardingPlan", "amountLabelForMonthlyPlan", "multiPlanModel", "createPreloaderCallback", "com/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModel$createPreloaderCallback$1", "()Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModel$createPreloaderCallback$1;", "fetchOnBoardingBannerAndPlans", "", "voucherCode", "duration", "loadData", "isNewBenefitsEnabled", "logNewRelicEventIfDefaultCardIsReceived", "cards", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardModel;", "logNewRelicSuccessEvent", "response", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerAndPlanModel;", "mapAmountForMultiPlan", "kotlin.jvm.PlatformType", "mapAmountForNewHeroMultiPlan", "sendPageLoadedBrazeEvent", "setupMediator", "subscribeWithB2BVoucher", "voucher", "updateCustomerInfo", "Lkotlinx/coroutines/Job;", "updateUserStatus", "status", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproBenefitsViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String REQUESTING_PAGE_NAME = "onboarding";
    @NotNull
    private static final String SUBSCRIPTION_ATTEMPTED = "subscription_attempted";
    @NotNull
    private static final String SUBSCRIPTION_COMPLETED = "subscription_completed";
    @NotNull
    private static final String SUBSCRIPTION_FAILED = "subscription_failed";
    @NotNull
    public static final String TPRO_BENEFITS_SCREEN_NAME = "tpro benefits screen";
    @NotNull
    public static final String TPRO_BENEFITS_SCREEN_TYPE = "benefits";
    @NotNull
    private final LiveData<String> amountText = mapAmountForMultiPlan();
    @NotNull
    private final LiveData<String> amountTextNewHero = mapAmountForNewHeroMultiPlan();
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    public final int countryId;
    @NotNull
    private final MutableLiveData<SubscriptionsErrorDisplayModel> displayError = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Throwable> failure = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public ProCentralizationStatusWrapper getProCentralizationStatusWrapper;
    @NotNull
    private final MediatorLiveData<Boolean> isDataReady = new MediatorLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> isSubscribedWithB2BVoucher = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MultiPlanParams multiPlanParams;
    @NotNull
    private final MutableLiveData<Screen<?>> postUpdatingStatus = new MutableLiveData<>();
    @NotNull
    private final RequestListener<Drawable> preloaderCallback = createPreloaderCallback();
    @NotNull
    private final Resources resources;
    @NotNull
    private final MutableLiveData<Boolean> resourcesLoaded = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<String> sendFirebaseEvent = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionStatusRepository subscriptionStatusRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final GetSubscriptionWithB2BVoucherUseCase subscriptionWithB2BVoucherUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionsTracker subscriptionsTracker;
    @NotNull
    private final MutableLiveData<TProMultiPlanDisplayModel> tProMultiPlan = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final TProOnBoardingBannerAndPlansUseCase tProOnBoardingBannerAndPlansUseCase;
    @NotNull
    private final MutableLiveData<TProOnBoardingDisplayModel> tProOnBoardingPlan = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModel$Companion;", "", "()V", "REQUESTING_PAGE_NAME", "", "SUBSCRIPTION_ATTEMPTED", "SUBSCRIPTION_COMPLETED", "SUBSCRIPTION_FAILED", "TPRO_BENEFITS_SCREEN_NAME", "TPRO_BENEFITS_SCREEN_TYPE", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TproBenefitsViewModel(@NotNull Resources resources2, @Named("countryId") int i11, @NotNull MultiPlanParams multiPlanParams2, @NotNull ISubscriptionsTracker iSubscriptionsTracker, @NotNull GetSubscriptionWithB2BVoucherUseCase getSubscriptionWithB2BVoucherUseCase, @NotNull GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @NotNull TProOnBoardingBannerAndPlansUseCase tProOnBoardingBannerAndPlansUseCase2, @NotNull ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(multiPlanParams2, "multiPlanParams");
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "subscriptionsTracker");
        Intrinsics.checkNotNullParameter(getSubscriptionWithB2BVoucherUseCase, "subscriptionWithB2BVoucherUseCase");
        Intrinsics.checkNotNullParameter(getActiveSubscriptionsUseCase2, "getActiveSubscriptionsUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        Intrinsics.checkNotNullParameter(tProOnBoardingBannerAndPlansUseCase2, "tProOnBoardingBannerAndPlansUseCase");
        Intrinsics.checkNotNullParameter(proCentralizationStatusWrapper, "getProCentralizationStatusWrapper");
        this.resources = resources2;
        this.countryId = i11;
        this.multiPlanParams = multiPlanParams2;
        this.subscriptionsTracker = iSubscriptionsTracker;
        this.subscriptionWithB2BVoucherUseCase = getSubscriptionWithB2BVoucherUseCase;
        this.getActiveSubscriptionsUseCase = getActiveSubscriptionsUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
        this.tProOnBoardingBannerAndPlansUseCase = tProOnBoardingBannerAndPlansUseCase2;
        this.getProCentralizationStatusWrapper = proCentralizationStatusWrapper;
        setupMediator();
    }

    private final String amountLabelForMonthlyPlan(TProMultiPlanDisplayModel tProMultiPlanDisplayModel) {
        String str;
        if (tProMultiPlanDisplayModel.getFreeTrialEligible()) {
            str = this.resources.getString(R.string.tpro_trial_plan_price, new Object[]{tProMultiPlanDisplayModel.getFreeTrialTitle(), tProMultiPlanDisplayModel.getPlans().get(0).getPaymentText()});
        } else {
            str = tProMultiPlanDisplayModel.getPlans().get(0).getPaymentText();
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (multiPlanModel.freeT…[0].paymentText\n        }");
        return str;
    }

    private final TproBenefitsViewModel$createPreloaderCallback$1 createPreloaderCallback() {
        return new TproBenefitsViewModel$createPreloaderCallback$1(this);
    }

    private final void fetchOnBoardingBannerAndPlans(String str, String str2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1(this, str2, str, (Continuation<? super TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void logNewRelicEventIfDefaultCardIsReceived(List<? extends TProOnBoardingCardModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof TProOnBoardingDefaultCardModel) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            this.subscriptionsTracker.tProOnboardingUnknownCardTypeFetched(arrayList.size());
        }
    }

    /* access modifiers changed from: private */
    public final void logNewRelicSuccessEvent(TProOnBoardingBannerAndPlanModel tProOnBoardingBannerAndPlanModel) {
        String str;
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionsTracker;
        int size = tProOnBoardingBannerAndPlanModel.getCards().size();
        HeroWidgetModel heroWidgetModel = (HeroWidgetModel) CollectionsKt___CollectionsKt.firstOrNull(tProOnBoardingBannerAndPlanModel.getHeroBanner().getHeroWidget());
        if (heroWidgetModel != null) {
            str = heroWidgetModel.getTrackingId();
        } else {
            str = null;
        }
        iSubscriptionsTracker.tProOnboardingApiSuccess(size, str, tProOnBoardingBannerAndPlanModel.getSubscriptionMultiPlan().getPlans().size());
    }

    private final LiveData<String> mapAmountForMultiPlan() {
        LiveData<String> map = Transformations.map(this.tProMultiPlan, new e(this));
        Intrinsics.checkNotNullExpressionValue(map, "map(tProMultiPlan) { mod…        }\n        }\n    }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: mapAmountForMultiPlan$lambda-5  reason: not valid java name */
    public static final String m10367mapAmountForMultiPlan$lambda5(TproBenefitsViewModel tproBenefitsViewModel, TProMultiPlanDisplayModel tProMultiPlanDisplayModel) {
        Intrinsics.checkNotNullParameter(tproBenefitsViewModel, "this$0");
        if (tProMultiPlanDisplayModel.getPlans().size() == 1) {
            Intrinsics.checkNotNullExpressionValue(tProMultiPlanDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            return tproBenefitsViewModel.amountLabelForMonthlyPlan(tProMultiPlanDisplayModel);
        } else if (tProMultiPlanDisplayModel.getFreeTrialEligible()) {
            return tProMultiPlanDisplayModel.getFreeTrialTitle();
        } else {
            return StringUtils.empty(StringCompanionObject.INSTANCE);
        }
    }

    private final LiveData<String> mapAmountForNewHeroMultiPlan() {
        LiveData<String> map = Transformations.map(this.tProOnBoardingPlan, new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "map(tProOnBoardingPlan) …        }\n        }\n    }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: mapAmountForNewHeroMultiPlan$lambda-4  reason: not valid java name */
    public static final String m10368mapAmountForNewHeroMultiPlan$lambda4(TproBenefitsViewModel tproBenefitsViewModel, TProOnBoardingDisplayModel tProOnBoardingDisplayModel) {
        Intrinsics.checkNotNullParameter(tproBenefitsViewModel, "this$0");
        if (tProOnBoardingDisplayModel.getSubscriptionMultiPlan().getPlans().size() == 1) {
            return tproBenefitsViewModel.amountLabelForMonthlyPlan(tProOnBoardingDisplayModel.getSubscriptionMultiPlan());
        }
        if (tProOnBoardingDisplayModel.getSubscriptionMultiPlan().getFreeTrialEligible()) {
            return tProOnBoardingDisplayModel.getSubscriptionMultiPlan().getFreeTrialTitle();
        }
        return StringUtils.empty(StringCompanionObject.INSTANCE);
    }

    private final void setupMediator() {
        MediatorLiveData<Boolean> mediatorLiveData = this.isDataReady;
        mediatorLiveData.addSource(this.resourcesLoaded, new b(this));
        mediatorLiveData.addSource(this.tProOnBoardingPlan, new c(this));
        mediatorLiveData.addSource(this.tProMultiPlan, new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMediator$lambda-3$lambda-0  reason: not valid java name */
    public static final void m10369setupMediator$lambda3$lambda0(TproBenefitsViewModel tproBenefitsViewModel, Boolean bool) {
        boolean z11;
        Intrinsics.checkNotNullParameter(tproBenefitsViewModel, "this$0");
        MediatorLiveData<Boolean> mediatorLiveData = tproBenefitsViewModel.isDataReady;
        Intrinsics.checkNotNullExpressionValue(bool, "result");
        if (!bool.booleanValue() || (tproBenefitsViewModel.tProOnBoardingPlan.getValue() == null && tproBenefitsViewModel.tProMultiPlan.getValue() == null)) {
            z11 = false;
        } else {
            z11 = true;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMediator$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10370setupMediator$lambda3$lambda1(TproBenefitsViewModel tproBenefitsViewModel, TProOnBoardingDisplayModel tProOnBoardingDisplayModel) {
        boolean z11;
        Intrinsics.checkNotNullParameter(tproBenefitsViewModel, "this$0");
        MediatorLiveData<Boolean> mediatorLiveData = tproBenefitsViewModel.isDataReady;
        if (!Intrinsics.areEqual((Object) tproBenefitsViewModel.resourcesLoaded.getValue(), (Object) Boolean.TRUE) || (tProOnBoardingDisplayModel == null && tproBenefitsViewModel.tProMultiPlan.getValue() == null)) {
            z11 = false;
        } else {
            z11 = true;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMediator$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10371setupMediator$lambda3$lambda2(TproBenefitsViewModel tproBenefitsViewModel, TProMultiPlanDisplayModel tProMultiPlanDisplayModel) {
        boolean z11;
        Intrinsics.checkNotNullParameter(tproBenefitsViewModel, "this$0");
        MediatorLiveData<Boolean> mediatorLiveData = tproBenefitsViewModel.isDataReady;
        if (!Intrinsics.areEqual((Object) tproBenefitsViewModel.resourcesLoaded.getValue(), (Object) Boolean.TRUE) || (tproBenefitsViewModel.tProOnBoardingPlan.getValue() == null && tProMultiPlanDisplayModel == null)) {
            z11 = false;
        } else {
            z11 = true;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    public final Job updateCustomerInfo() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproBenefitsViewModel$updateCustomerInfo$1(this, (Continuation<? super TproBenefitsViewModel$updateCustomerInfo$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<String> getAmountText() {
        return this.amountText;
    }

    @NotNull
    public final LiveData<String> getAmountTextNewHero() {
        return this.amountTextNewHero;
    }

    @NotNull
    public final MutableLiveData<SubscriptionsErrorDisplayModel> getDisplayError() {
        return this.displayError;
    }

    @NotNull
    public final MutableLiveData<Throwable> getFailure() {
        return this.failure;
    }

    @NotNull
    public final MutableLiveData<Screen<?>> getPostUpdatingStatus() {
        return this.postUpdatingStatus;
    }

    @NotNull
    public final RequestListener<Drawable> getPreloaderCallback() {
        return this.preloaderCallback;
    }

    @NotNull
    public final MutableLiveData<Boolean> getResourcesLoaded() {
        return this.resourcesLoaded;
    }

    @NotNull
    public final MutableLiveData<String> getSendFirebaseEvent() {
        return this.sendFirebaseEvent;
    }

    @NotNull
    public final MutableLiveData<TProMultiPlanDisplayModel> getTProMultiPlan() {
        return this.tProMultiPlan;
    }

    @NotNull
    public final MutableLiveData<TProOnBoardingDisplayModel> getTProOnBoardingPlan() {
        return this.tProOnBoardingPlan;
    }

    @NotNull
    public final MediatorLiveData<Boolean> isDataReady() {
        return this.isDataReady;
    }

    @NotNull
    public final MutableLiveData<Boolean> isSubscribedWithB2BVoucher() {
        return this.isSubscribedWithB2BVoucher;
    }

    public final void loadData(@Nullable String str, boolean z11) {
        if (z11) {
            fetchOnBoardingBannerAndPlans(str, this.multiPlanParams.getMultiPlanDurations());
        } else {
            getTProMultiPlan(this.multiPlanParams.getMultiPlanDurations(), str);
        }
    }

    public final void sendPageLoadedBrazeEvent() {
        if (!this.subscriptionStatusRepository.isTProUser()) {
            this.subscriptionsTracker.benefitsPageLoaded(false);
        }
    }

    public final void subscribeWithB2BVoucher(@NotNull String str) {
        List<TProPlanDisplayModel> plans;
        TProPlanDisplayModel tProPlanDisplayModel;
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.HEADER_VOUCHER);
        this.sendFirebaseEvent.postValue("subscription_attempted");
        TProMultiPlanDisplayModel value = this.tProMultiPlan.getValue();
        if (value != null && (plans = value.getPlans()) != null && (tProPlanDisplayModel = plans.get(0)) != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproBenefitsViewModel$subscribeWithB2BVoucher$1$1(this, tProPlanDisplayModel, str, (Continuation<? super TproBenefitsViewModel$subscribeWithB2BVoucher$1$1>) null), 3, (Object) null);
        }
    }

    public final void updateUserStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "status");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproBenefitsViewModel$updateUserStatus$1(this, str, (Continuation<? super TproBenefitsViewModel$updateUserStatus$1>) null), 3, (Object) null);
    }

    private final void getTProMultiPlan(String str, String str2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproBenefitsViewModel$getTProMultiPlan$1(this, str, str2, (Continuation<? super TproBenefitsViewModel$getTProMultiPlan$1>) null), 3, (Object) null);
    }
}
