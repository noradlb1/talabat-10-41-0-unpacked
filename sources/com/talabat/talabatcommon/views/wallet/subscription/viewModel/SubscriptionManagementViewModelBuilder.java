package com.talabat.talabatcommon.views.wallet.subscription.viewModel;

import android.content.Context;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetPostSubscriptionCancellationFeedbackUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSetSubscriptionDefaultCardUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionCancellationReasonsUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionDefaultCardUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionDetailUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionPlansUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionViewsDataUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetUpdateSubscriptionAutoRenewUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.network.SubscriptionManagementService;
import com.talabat.talabatcommon.feature.subscriptionManagement.repository.SubscriptionManagementRepositoryImpl;
import com.talabat.talabatcommon.feature.walletCardList.GetCardListUseCase;
import com.talabat.talabatcommon.feature.walletCardList.network.WalletCardListService;
import com.talabat.talabatcommon.views.wallet.IsWalletAddCardFlutterScreenEnabledUseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.walletCardList.repository.WalletCardListRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModelBuilder$Companion;", "", "()V", "getSubscriptionManagementViewModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModelImpl;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getSavingsInfoUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SubscriptionManagementViewModelImpl getSubscriptionManagementViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull GetSavingsInfoUseCase getSavingsInfoUseCase, @NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
            Context context2 = context;
            CoroutineScope coroutineScope2 = coroutineScope;
            ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "featureFlag");
            Intrinsics.checkNotNullParameter(getSavingsInfoUseCase, "getSavingsInfoUseCase");
            Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "subscriptionsFeatureFlag");
            SubscriptionManagementRepositoryImpl subscriptionManagementRepositoryImpl = new SubscriptionManagementRepositoryImpl(new NetworkHandler(context2), new SubscriptionManagementService(new TalabatAPIBuilder()));
            GetSubscriptionPlansUseCase getSubscriptionPlansUseCase = new GetSubscriptionPlansUseCase(subscriptionManagementRepositoryImpl, coroutineScope2, Dispatchers.getMain());
            GetCardListUseCase getCardListUseCase = new GetCardListUseCase(new WalletCardListRepositoryImpl(new NetworkHandler(context2), new WalletCardListService(new TalabatAPIBuilder())), coroutineScope2, Dispatchers.getMain());
            GetSubscriptionDefaultCardUseCase getSubscriptionDefaultCardUseCase = new GetSubscriptionDefaultCardUseCase(subscriptionManagementRepositoryImpl, coroutineScope2, Dispatchers.getMain());
            GetSetSubscriptionDefaultCardUseCase getSetSubscriptionDefaultCardUseCase = new GetSetSubscriptionDefaultCardUseCase(subscriptionManagementRepositoryImpl, coroutineScope2, Dispatchers.getMain());
            GetSubscriptionUseCase getSubscriptionUseCase = new GetSubscriptionUseCase(subscriptionManagementRepositoryImpl, coroutineScope2, Dispatchers.getMain());
            GetSubscriptionDetailUseCase getSubscriptionDetailUseCase = new GetSubscriptionDetailUseCase(subscriptionManagementRepositoryImpl, coroutineScope2, Dispatchers.getMain());
            GetSubscriptionCancellationReasonsUseCase getSubscriptionCancellationReasonsUseCase = new GetSubscriptionCancellationReasonsUseCase(subscriptionManagementRepositoryImpl, coroutineScope2, Dispatchers.getMain());
            GetPostSubscriptionCancellationFeedbackUseCase getPostSubscriptionCancellationFeedbackUseCase = new GetPostSubscriptionCancellationFeedbackUseCase(subscriptionManagementRepositoryImpl, coroutineScope2, Dispatchers.getMain());
            return new SubscriptionManagementViewModelImpl(getSubscriptionPlansUseCase, getSubscriptionUseCase, new GetSubscriptionViewsDataUseCase(), getSubscriptionDefaultCardUseCase, getSetSubscriptionDefaultCardUseCase, getCardListUseCase, getSubscriptionDetailUseCase, new GetUpdateSubscriptionAutoRenewUseCase(subscriptionManagementRepositoryImpl, coroutineScope2, Dispatchers.getMain()), getSubscriptionCancellationReasonsUseCase, getPostSubscriptionCancellationFeedbackUseCase, new IsWalletAddCardFlutterScreenEnabledUseCase(iTalabatFeatureFlag2), getSavingsInfoUseCase, iSubscriptionsFeatureFlagsRepository);
        }
    }
}
