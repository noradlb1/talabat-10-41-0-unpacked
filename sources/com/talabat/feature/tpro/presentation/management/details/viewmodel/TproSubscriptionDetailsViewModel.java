package com.talabat.feature.tpro.presentation.management.details.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.usecase.CancelFreeTrialUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionDetailsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.talabatlife.features.UrlConstantsKt;
import hp.a;
import hp.b;
import java.util.List;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0006\u0010%\u001a\u00020:J\u0006\u0010;\u001a\u00020:J\u0006\u0010<\u001a\u00020:J\u0012\u0010=\u001a\u0004\u0018\u00010\u001c2\u0006\u0010>\u001a\u00020\u0019H\u0002J\u000e\u0010?\u001a\u00020:2\u0006\u0010>\u001a\u00020\u0019J\b\u0010@\u001a\u00020:H\u0002J\u001e\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015J\u000e\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u0019R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\"8F¢\u0006\u0006\u001a\u0004\b&\u0010$R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150(¢\u0006\b\n\u0000\u001a\u0004\b'\u0010)R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190\"8F¢\u0006\u0006\u001a\u0004\b/\u0010$R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00190\"8F¢\u0006\u0006\u001a\u0004\b1\u0010$R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c0\"8F¢\u0006\u0006\u001a\u0004\b3\u0010$R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00150\"8F¢\u0006\u0006\u001a\u0004\b5\u0010$R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00150\"8F¢\u0006\u0006\u001a\u0004\b7\u0010$R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0019\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\"8F¢\u0006\u0006\u001a\u0004\b9\u0010$R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/viewmodel/TproSubscriptionDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "getSubscriptionDetails", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionDetailsUseCase;", "getSavingsInfoUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "updateAutoRenewalUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;", "cancelFreeTrialUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/CancelFreeTrialUseCase;", "subscriptionsCustomerHelper", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "subscriptionsStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getProCentralizationStatusWrapper", "Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionDetailsUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/CancelFreeTrialUseCase;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;)V", "_autoRenewalCanceledFromBanner", "Landroidx/lifecycle/MutableLiveData;", "", "_cancelFreeTrial", "_postUpdatingStatus", "_renewalCanceled", "", "_renewalEnabled", "_subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "_subscriptionAutoRenewTurnedOff", "_subscriptionAutoRenewTurnedOn", "_subscriptionsSaving", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "autoRenewalCanceledFromBanner", "Landroidx/lifecycle/LiveData;", "getAutoRenewalCanceledFromBanner", "()Landroidx/lifecycle/LiveData;", "cancelFreeTrial", "getCancelFreeTrial", "isDataReady", "Landroidx/lifecycle/MediatorLiveData;", "()Landroidx/lifecycle/MediatorLiveData;", "isSavingsDataLoaded", "postUpdatingStatus", "getPostUpdatingStatus", "()Landroidx/lifecycle/MutableLiveData;", "renewalCanceled", "getRenewalCanceled", "renewalEnabled", "getRenewalEnabled", "subscription", "getSubscription", "subscriptionAutoRenewTurnedOff", "getSubscriptionAutoRenewTurnedOff", "subscriptionAutoRenewTurnedOn", "getSubscriptionAutoRenewTurnedOn", "subscriptionsSaving", "getSubscriptionsSaving", "", "clearActiveSubscription", "getSavingsInfo", "getSubscriptionStatus", "membershipId", "loadData", "setupMediator", "updateAutoRenewalStatus", "autoRenewal", "canceledFromBanner", "isImmediateCancelDisable", "updateUserStatus", "status", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproSubscriptionDetailsViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _autoRenewalCanceledFromBanner = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _cancelFreeTrial = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _postUpdatingStatus = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<String> _renewalCanceled = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<String> _renewalEnabled = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Subscription> _subscription = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _subscriptionAutoRenewTurnedOff = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _subscriptionAutoRenewTurnedOn = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<SubscriptionSavingsInfo> _subscriptionsSaving = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CancelFreeTrialUseCase cancelFreeTrialUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @NotNull
    public ProCentralizationStatusWrapper getProCentralizationStatusWrapper;
    /* access modifiers changed from: private */
    @NotNull
    public final GetSavingsInfoUseCase getSavingsInfoUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetSubscriptionDetailsUseCase getSubscriptionDetails;
    @NotNull
    private final MediatorLiveData<Boolean> isDataReady = new MediatorLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> isSavingsDataLoaded = new MutableLiveData<>();
    @NotNull
    private final ISubscriptionsCustomerRepository subscriptionsCustomerHelper;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionsStatusRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final UpdateAutoRenewalUseCase updateAutoRenewalUseCase;

    @Inject
    public TproSubscriptionDetailsViewModel(@NotNull GetSubscriptionDetailsUseCase getSubscriptionDetailsUseCase, @NotNull GetSavingsInfoUseCase getSavingsInfoUseCase2, @NotNull UpdateAutoRenewalUseCase updateAutoRenewalUseCase2, @NotNull CancelFreeTrialUseCase cancelFreeTrialUseCase2, @NotNull ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        Intrinsics.checkNotNullParameter(getSubscriptionDetailsUseCase, "getSubscriptionDetails");
        Intrinsics.checkNotNullParameter(getSavingsInfoUseCase2, "getSavingsInfoUseCase");
        Intrinsics.checkNotNullParameter(updateAutoRenewalUseCase2, "updateAutoRenewalUseCase");
        Intrinsics.checkNotNullParameter(cancelFreeTrialUseCase2, "cancelFreeTrialUseCase");
        Intrinsics.checkNotNullParameter(iSubscriptionsCustomerRepository, "subscriptionsCustomerHelper");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionsStatusRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(proCentralizationStatusWrapper, "getProCentralizationStatusWrapper");
        this.getSubscriptionDetails = getSubscriptionDetailsUseCase;
        this.getSavingsInfoUseCase = getSavingsInfoUseCase2;
        this.updateAutoRenewalUseCase = updateAutoRenewalUseCase2;
        this.cancelFreeTrialUseCase = cancelFreeTrialUseCase2;
        this.subscriptionsCustomerHelper = iSubscriptionsCustomerRepository;
        this.subscriptionsStatusRepository = iSubscriptionStatusRepository;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.getProCentralizationStatusWrapper = proCentralizationStatusWrapper;
        setupMediator();
    }

    /* access modifiers changed from: private */
    public final Subscription getSubscriptionStatus(String str) {
        List<Subscription> subscriptionsList = this.subscriptionsStatusRepository.getSubscriptionsList();
        if (subscriptionsList == null) {
            return null;
        }
        for (Subscription subscription : subscriptionsList) {
            if (Intrinsics.areEqual((Object) subscription.getMembershipId(), (Object) str)) {
                return subscription;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void setupMediator() {
        MediatorLiveData<Boolean> mediatorLiveData = this.isDataReady;
        mediatorLiveData.addSource(getSubscription(), new a(mediatorLiveData, this));
        mediatorLiveData.addSource(this.isSavingsDataLoaded, new b(mediatorLiveData, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMediator$lambda-2$lambda-0  reason: not valid java name */
    public static final void m10410setupMediator$lambda2$lambda0(MediatorLiveData mediatorLiveData, TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, Subscription subscription) {
        boolean z11;
        Intrinsics.checkNotNullParameter(mediatorLiveData, "$this_with");
        Intrinsics.checkNotNullParameter(tproSubscriptionDetailsViewModel, "this$0");
        boolean z12 = false;
        if (subscription != null) {
            Boolean value = tproSubscriptionDetailsViewModel.isSavingsDataLoaded.getValue();
            if (value == null) {
                z11 = false;
            } else {
                z11 = value.booleanValue();
            }
            if (z11) {
                z12 = true;
            }
        }
        mediatorLiveData.setValue(Boolean.valueOf(z12));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupMediator$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10411setupMediator$lambda2$lambda1(MediatorLiveData mediatorLiveData, TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, Boolean bool) {
        boolean z11;
        Intrinsics.checkNotNullParameter(mediatorLiveData, "$this_with");
        Intrinsics.checkNotNullParameter(tproSubscriptionDetailsViewModel, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isLoaded");
        if (bool.booleanValue()) {
            if (tproSubscriptionDetailsViewModel.getSubscription().getValue() != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            mediatorLiveData.setValue(Boolean.valueOf(z11));
        }
    }

    public final void cancelFreeTrial() {
        String str;
        Subscription value = getSubscription().getValue();
        if (value != null) {
            str = value.getMembershipId();
        } else {
            str = null;
        }
        if (str != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1(this, str, (Continuation<? super TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1>) null), 3, (Object) null);
        }
    }

    public final void clearActiveSubscription() {
        this.subscriptionsCustomerHelper.clearSubscriptionInfo();
    }

    @NotNull
    public final LiveData<Boolean> getAutoRenewalCanceledFromBanner() {
        return this._autoRenewalCanceledFromBanner;
    }

    @NotNull
    public final LiveData<Boolean> getCancelFreeTrial() {
        return this._cancelFreeTrial;
    }

    @NotNull
    public final MutableLiveData<Boolean> getPostUpdatingStatus() {
        return this._postUpdatingStatus;
    }

    @NotNull
    public final LiveData<String> getRenewalCanceled() {
        return this._renewalCanceled;
    }

    @NotNull
    public final LiveData<String> getRenewalEnabled() {
        return this._renewalEnabled;
    }

    public final void getSavingsInfo() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproSubscriptionDetailsViewModel$getSavingsInfo$1(this, (Continuation<? super TproSubscriptionDetailsViewModel$getSavingsInfo$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<Subscription> getSubscription() {
        return this._subscription;
    }

    @NotNull
    public final LiveData<Boolean> getSubscriptionAutoRenewTurnedOff() {
        return this._subscriptionAutoRenewTurnedOff;
    }

    @NotNull
    public final LiveData<Boolean> getSubscriptionAutoRenewTurnedOn() {
        return this._subscriptionAutoRenewTurnedOn;
    }

    @NotNull
    public final LiveData<SubscriptionSavingsInfo> getSubscriptionsSaving() {
        return this._subscriptionsSaving;
    }

    @NotNull
    public final MediatorLiveData<Boolean> isDataReady() {
        return this.isDataReady;
    }

    public final void loadData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproSubscriptionDetailsViewModel$loadData$1(this, str, (Continuation<? super TproSubscriptionDetailsViewModel$loadData$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateAutoRenewalStatus(boolean r15, boolean r16, boolean r17) {
        /*
            r14 = this;
            androidx.lifecycle.LiveData r0 = r14.getSubscription()
            java.lang.Object r0 = r0.getValue()
            com.talabat.feature.subscriptions.domain.model.Subscription r0 = (com.talabat.feature.subscriptions.domain.model.Subscription) r0
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getMembershipId()
            r4 = r0
            goto L_0x0014
        L_0x0013:
            r4 = r1
        L_0x0014:
            com.talabat.core.experiment.data.TalabatExperiment r0 = com.talabat.core.experiment.data.TalabatExperiment.INSTANCE
            com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys r2 = com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r3 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.FWF
            r5 = 0
            boolean r0 = r0.getBooleanVariant(r2, r5, r3)
            androidx.lifecycle.LiveData r2 = r14.getSubscription()
            java.lang.Object r2 = r2.getValue()
            com.talabat.feature.subscriptions.domain.model.Subscription r2 = (com.talabat.feature.subscriptions.domain.model.Subscription) r2
            if (r2 == 0) goto L_0x0036
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlan r2 = r2.getPlan()
            if (r2 == 0) goto L_0x0036
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r2 = r2.getCategory()
            goto L_0x0037
        L_0x0036:
            r2 = r1
        L_0x0037:
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r3 = com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory.B2B
            r6 = 1
            if (r2 != r3) goto L_0x003e
            r2 = r6
            goto L_0x003f
        L_0x003e:
            r2 = r5
        L_0x003f:
            androidx.lifecycle.LiveData r3 = r14.getSubscription()
            java.lang.Object r3 = r3.getValue()
            com.talabat.feature.subscriptions.domain.model.Subscription r3 = (com.talabat.feature.subscriptions.domain.model.Subscription) r3
            if (r3 == 0) goto L_0x0055
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlan r3 = r3.getPlan()
            if (r3 == 0) goto L_0x0055
            com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r1 = r3.getRenewType()
        L_0x0055:
            com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r3 = com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType.Renewable
            if (r1 != r3) goto L_0x005b
            r1 = r6
            goto L_0x005c
        L_0x005b:
            r1 = r5
        L_0x005c:
            if (r2 == 0) goto L_0x007b
            if (r1 == 0) goto L_0x007b
            androidx.lifecycle.LiveData r1 = r14.getSubscription()
            java.lang.Object r1 = r1.getValue()
            com.talabat.feature.subscriptions.domain.model.Subscription r1 = (com.talabat.feature.subscriptions.domain.model.Subscription) r1
            if (r1 == 0) goto L_0x0074
            boolean r1 = r1.isActive()
            if (r1 != r6) goto L_0x0074
            r1 = r6
            goto L_0x0075
        L_0x0074:
            r1 = r5
        L_0x0075:
            if (r1 == 0) goto L_0x007b
            if (r0 == 0) goto L_0x007b
            r7 = r6
            goto L_0x007c
        L_0x007b:
            r7 = r5
        L_0x007c:
            if (r4 == 0) goto L_0x0098
            kotlinx.coroutines.CoroutineScope r0 = androidx.lifecycle.ViewModelKt.getViewModelScope(r14)
            r1 = 0
            r10 = 0
            com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1 r11 = new com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1
            r9 = 0
            r2 = r11
            r3 = r14
            r5 = r15
            r6 = r17
            r8 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r12 = 3
            r13 = 0
            r8 = r0
            r9 = r1
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel.updateAutoRenewalStatus(boolean, boolean, boolean):void");
    }

    public final void updateUserStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "status");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproSubscriptionDetailsViewModel$updateUserStatus$1(this, str, (Continuation<? super TproSubscriptionDetailsViewModel$updateUserStatus$1>) null), 3, (Object) null);
    }
}
