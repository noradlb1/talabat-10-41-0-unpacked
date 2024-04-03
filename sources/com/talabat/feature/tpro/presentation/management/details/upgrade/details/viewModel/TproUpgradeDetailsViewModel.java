package com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpgradeSubscriptionPlanUseCase;
import com.talabat.talabatlife.features.UrlConstantsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/viewModel/TproUpgradeDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "upgradePlanUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/UpgradeSubscriptionPlanUseCase;", "getActiveSubscriptionsUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "(Lcom/talabat/feature/subscriptions/domain/usecase/UpgradeSubscriptionPlanUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "_upgradeResult", "Landroidx/lifecycle/MutableLiveData;", "Lorg/threeten/bp/LocalDateTime;", "_verification3ds", "", "upgradeResult", "Landroidx/lifecycle/LiveData;", "getUpgradeResult", "()Landroidx/lifecycle/LiveData;", "verification3ds", "getVerification3ds", "updateCustomerInfo", "Lkotlinx/coroutines/Job;", "upgradePlan", "", "membershipId", "currentPlanId", "upgradePlanId", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproUpgradeDetailsViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<LocalDateTime> _upgradeResult = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<String> _verification3ds = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionStatusRepository subscriptionStatusRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final UpgradeSubscriptionPlanUseCase upgradePlanUseCase;

    @Inject
    public TproUpgradeDetailsViewModel(@NotNull UpgradeSubscriptionPlanUseCase upgradeSubscriptionPlanUseCase, @NotNull GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(upgradeSubscriptionPlanUseCase, "upgradePlanUseCase");
        Intrinsics.checkNotNullParameter(getActiveSubscriptionsUseCase2, "getActiveSubscriptionsUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        this.upgradePlanUseCase = upgradeSubscriptionPlanUseCase;
        this.getActiveSubscriptionsUseCase = getActiveSubscriptionsUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    @NotNull
    public final LiveData<LocalDateTime> getUpgradeResult() {
        return this._upgradeResult;
    }

    @NotNull
    public final LiveData<String> getVerification3ds() {
        return this._verification3ds;
    }

    @NotNull
    public final Job updateCustomerInfo() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproUpgradeDetailsViewModel$updateCustomerInfo$1(this, (Continuation<? super TproUpgradeDetailsViewModel$updateCustomerInfo$1>) null), 3, (Object) null);
    }

    public final void upgradePlan(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        Intrinsics.checkNotNullParameter(str2, "currentPlanId");
        Intrinsics.checkNotNullParameter(str3, "upgradePlanId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproUpgradeDetailsViewModel$upgradePlan$1(this, str, str2, str3, (Continuation<? super TproUpgradeDetailsViewModel$upgradePlan$1>) null), 3, (Object) null);
    }
}
