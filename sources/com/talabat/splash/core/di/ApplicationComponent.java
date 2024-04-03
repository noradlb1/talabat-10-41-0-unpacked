package com.talabat.splash.core.di;

import buisnessmodels.Cart;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.fwf.domain.di.FWFCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.di.cart.CartUtilityModule;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.helpers.TalabatApplication;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import com.talabat.splash.core.di.viewmodel.ViewModelModule;
import com.talabat.splash.presentation.ui.SplashActivity;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(dependencies = {AuthenticationCoreLibApi.class, DeepLinkCoreLibApi.class, DispatcherCoreLibApi.class, GmsBaseCoreLibApi.class, HmsBaseCoreLibApi.class, LocationCoreLibApi.class, MapsCoreLibApi.class, MutableConfigurationLocalCoreLibApi.class, MutableConfigurationRemoteCoreLibApi.class, ParserCoreLibApi.class, SubscriptionsFeatureApi.class, FeatureFlagCoreLibApi.class, FWFCoreLibApi.class, FoodCartFeatureApi.class, CampaignMigratorFeatureApi.class, ObservabilityCoreLibApi.class, TokenCoreLibApi.class, OnBoardingExperimentApi.class}, modules = {ApplicationModule.class, AuthModule.class, ViewModelModule.class, CartUtilityModule.class, MessagingModule.class})
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/splash/core/di/ApplicationComponent;", "", "inject", "", "cart", "Lbuisnessmodels/Cart;", "application", "Lcom/talabat/helpers/TalabatApplication;", "splashActivity", "Lcom/talabat/splash/presentation/ui/SplashActivity;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApplicationComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H&¨\u0006*"}, d2 = {"Lcom/talabat/splash/core/di/ApplicationComponent$Factory;", "", "create", "Lcom/talabat/splash/core/di/ApplicationComponent;", "authenticationCoreLibApi", "Lcom/talabat/authentication/authenticate/domain/AuthenticationCoreLibApi;", "applicationModule", "Lcom/talabat/splash/core/di/ApplicationModule;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "gmsBaseCoreLibApi", "Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "hmsBaseCoreLibApi", "Lcom/talabat/core/hms/base/domain/HmsBaseCoreLibApi;", "locationCoreLibApi", "Lcom/talabat/location/domain/di/LocationCoreLibApi;", "mapsCoreLibApi", "Lcom/talabat/maps/domain/di/MapsCoreLibApi;", "mutableConfigurationLocalCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;", "mutableConfigurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "foodCartFeatureApi", "Lcom/talabat/feature/foodcart2/domain/di/FoodCartFeatureApi;", "fwfCoreLibApi", "Lcom/talabat/core/fwf/domain/di/FWFCoreLibApi;", "campaignMigratorFeatureApi", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorFeatureApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "tokenCoreLibApi", "Lcom/talabat/authentication/token/domain/TokenCoreLibApi;", "onBoardingExperimentApi", "Lcom/talabat/onboarding/domain/di/OnBoardingExperimentApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ApplicationComponent create(@NotNull AuthenticationCoreLibApi authenticationCoreLibApi, @NotNull ApplicationModule applicationModule, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull HmsBaseCoreLibApi hmsBaseCoreLibApi, @NotNull LocationCoreLibApi locationCoreLibApi, @NotNull MapsCoreLibApi mapsCoreLibApi, @NotNull MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, @NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi, @NotNull SubscriptionsFeatureApi subscriptionsFeatureApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull FoodCartFeatureApi foodCartFeatureApi, @NotNull FWFCoreLibApi fWFCoreLibApi, @NotNull CampaignMigratorFeatureApi campaignMigratorFeatureApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull TokenCoreLibApi tokenCoreLibApi, @NotNull OnBoardingExperimentApi onBoardingExperimentApi);
    }

    void inject(@NotNull Cart cart);

    void inject(@NotNull TalabatApplication talabatApplication);

    void inject(@NotNull SplashActivity splashActivity);
}
