package com.talabat.helpers;

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
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import com.talabat.splash.core.di.ApplicationComponent;
import com.talabat.splash.core.di.ApplicationModule;
import com.talabat.splash.core.di.DaggerApplicationComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/splash/core/di/ApplicationComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$appComponent$2 extends Lambda implements Function0<ApplicationComponent> {
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$appComponent$2(TalabatApplication talabatApplication) {
        super(0);
        this.this$0 = talabatApplication;
    }

    @NotNull
    public final ApplicationComponent invoke() {
        ApplicationComponent.Factory factory = DaggerApplicationComponent.factory();
        ApplicationModule applicationModule = r4;
        ApplicationModule applicationModule2 = new ApplicationModule(this.this$0);
        FoodCartFeatureApi foodCartFeatureApi = (FoodCartFeatureApi) this.this$0.getFeature(FoodCartFeatureApi.class);
        return factory.create((AuthenticationCoreLibApi) this.this$0.getFeature(AuthenticationCoreLibApi.class), applicationModule, (DeepLinkCoreLibApi) this.this$0.getFeature(DeepLinkCoreLibApi.class), (DispatcherCoreLibApi) this.this$0.getFeature(DispatcherCoreLibApi.class), (GmsBaseCoreLibApi) this.this$0.getFeature(GmsBaseCoreLibApi.class), (HmsBaseCoreLibApi) this.this$0.getFeature(HmsBaseCoreLibApi.class), (LocationCoreLibApi) this.this$0.getFeature(LocationCoreLibApi.class), (MapsCoreLibApi) this.this$0.getFeature(MapsCoreLibApi.class), (MutableConfigurationLocalCoreLibApi) this.this$0.getFeature(MutableConfigurationLocalCoreLibApi.class), (MutableConfigurationRemoteCoreLibApi) this.this$0.getFeature(MutableConfigurationRemoteCoreLibApi.class), (ParserCoreLibApi) this.this$0.getFeature(ParserCoreLibApi.class), (SubscriptionsFeatureApi) this.this$0.getFeature(SubscriptionsFeatureApi.class), (FeatureFlagCoreLibApi) this.this$0.getFeature(FeatureFlagCoreLibApi.class), foodCartFeatureApi, (FWFCoreLibApi) this.this$0.getFeature(FWFCoreLibApi.class), (CampaignMigratorFeatureApi) this.this$0.getFeature(CampaignMigratorFeatureApi.class), (ObservabilityCoreLibApi) this.this$0.getFeature(ObservabilityCoreLibApi.class), (TokenCoreLibApi) this.this$0.getFeature(TokenCoreLibApi.class), (OnBoardingExperimentApi) this.this$0.getFeature(OnBoardingExperimentApi.class));
    }
}
