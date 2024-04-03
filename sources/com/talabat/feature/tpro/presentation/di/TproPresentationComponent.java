package com.talabat.feature.tpro.presentation.di;

import android.content.Context;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsActivity;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView;
import com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment;
import com.talabat.feature.tpro.presentation.multiplan.TProPlanSelectionFragment;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment;
import com.talabat.feature.tpro.presentation.savings.TProSavingsCancellationBottomSheetFragment;
import com.talabat.feature.tpro.presentation.welcome.TProWelcomeBottomSheetFragment;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tpro/presentation/di/TproPresentationComponent;", "", "inject", "", "target", "Lcom/talabat/feature/tpro/presentation/benefits/TproBenefitsActivity;", "Lcom/talabat/feature/tpro/presentation/benefits/TproBenefitsFragment;", "Lcom/talabat/feature/tpro/presentation/checkout/SubscriptionAtCheckoutBannerView;", "Lcom/talabat/feature/tpro/presentation/helperview/mov/TProVendorMovView;", "Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/SubscriptionCancellationReasonBottomSheetFragment;", "Lcom/talabat/feature/tpro/presentation/management/details/TProSubscriptionDetailsFragment;", "Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/TproUpgradeDetailsBottomSheetFragment;", "Lcom/talabat/feature/tpro/presentation/multiplan/TProPlanSelectionFragment;", "Lcom/talabat/feature/tpro/presentation/payment/TProPaymentBottomSheetFragment;", "Lcom/talabat/feature/tpro/presentation/savings/TProSavingsCancellationBottomSheetFragment;", "Lcom/talabat/feature/tpro/presentation/welcome/TProWelcomeBottomSheetFragment;", "Factory", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, SubscriptionsFeatureApi.class, NavigationCoreLibApi.class, DeepLinkCoreLibApi.class, ObservabilityCoreLibApi.class}, modules = {TproPresentationModule.class, TProVendorMovModule.class})
public interface TproPresentationComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tpro/presentation/di/TproPresentationComponent$Factory;", "", "create", "Lcom/talabat/feature/tpro/presentation/di/TproPresentationComponent;", "context", "Landroid/content/Context;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        TproPresentationComponent create(@NotNull @BindsInstance @Named("context") Context context, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull SubscriptionsFeatureApi subscriptionsFeatureApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi);
    }

    void inject(@NotNull TproBenefitsActivity tproBenefitsActivity);

    void inject(@NotNull TproBenefitsFragment tproBenefitsFragment);

    void inject(@NotNull SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView);

    void inject(@NotNull TProVendorMovView tProVendorMovView);

    void inject(@NotNull SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment);

    void inject(@NotNull TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment);

    void inject(@NotNull TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment);

    void inject(@NotNull TProPlanSelectionFragment tProPlanSelectionFragment);

    void inject(@NotNull TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment);

    void inject(@NotNull TProSavingsCancellationBottomSheetFragment tProSavingsCancellationBottomSheetFragment);

    void inject(@NotNull TProWelcomeBottomSheetFragment tProWelcomeBottomSheetFragment);
}
