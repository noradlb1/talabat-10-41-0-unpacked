package com.talabat.darkstores.di;

import android.app.Application;
import androidx.annotation.VisibleForTesting;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesFeatureApi;
import com.talabat.feature.darkstores.vendorlanding.domain.VendorLandingFeatureApi;
import com.talabat.feature.darkstorescampaignmessage.domain.CampaignMessagingApi;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.features.swimlanevoucherslist.domain.di.CustomerVouchersSwimLaneFeaturesApi;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/di/Injector;", "", "()V", "<set-?>", "Lcom/talabat/darkstores/di/ApplicationComponent;", "appComponent", "getAppComponent", "()Lcom/talabat/darkstores/di/ApplicationComponent;", "clearAppComponent", "", "createAppComponent", "appContext", "Landroid/app/Application;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "setAppComponent", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Injector {
    @NotNull
    public static final Injector INSTANCE = new Injector();
    @Nullable
    private static ApplicationComponent appComponent;

    private Injector() {
    }

    public final void clearAppComponent() {
        appComponent = null;
    }

    public final void createAppComponent(@NotNull Application application, @NotNull ConfigurationParameters configurationParameters) {
        Application application2 = application;
        Intrinsics.checkNotNullParameter(application2, "appContext");
        Intrinsics.checkNotNullParameter(configurationParameters, "configurationParameters");
        ApplicationComponent applicationComponent = appComponent;
        if (applicationComponent == null || !Intrinsics.areEqual((Object) applicationComponent.getConfigurationParameters().getVendorCode(), (Object) configurationParameters.getVendorCode())) {
            ApiContainer apiContainer = (ApiContainer) application2;
            CampaignMessagingApi campaignMessagingApi = (CampaignMessagingApi) apiContainer.getFeature(CampaignMessagingApi.class);
            SwimlanesFeatureApi swimlanesFeatureApi = (SwimlanesFeatureApi) apiContainer.getFeature(SwimlanesFeatureApi.class);
            BaseUrlFactory baseUrlFactory = ((NetworkCoreLibApi) apiContainer.getFeature(NetworkCoreLibApi.class)).getBaseUrlFactory();
            ApiContainer apiContainer2 = apiContainer;
            Application application3 = application;
            ConfigurationParameters configurationParameters2 = configurationParameters;
            appComponent = DaggerApplicationComponent.factory().create(application3, (ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), configurationParameters2, (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (DarkstoresCartApi) apiContainer.getFeature(DarkstoresCartApi.class), (DarkstoresCartListApi) apiContainer.getFeature(DarkstoresCartListApi.class), (DarkstoresFlutterCartApi) apiContainer.getFeature(DarkstoresFlutterCartApi.class), (DarkstoresVendorApi) apiContainer.getFeature(DarkstoresVendorApi.class), (VendorLandingFeatureApi) apiContainer.getFeature(VendorLandingFeatureApi.class), campaignMessagingApi, (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class), (DispatcherCoreLibApi) apiContainer.getFeature(DispatcherCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), ((ParserCoreLibApi) apiContainer.getFeature(ParserCoreLibApi.class)).getGson(), (SecretCoreLibApi) apiContainer.getFeature(SecretCoreLibApi.class), swimlanesFeatureApi, (TrackingCoreLibApi) apiContainer.getFeature(TrackingCoreLibApi.class), (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class), baseUrlFactory, (ObservabilityCoreLibApi) apiContainer2.getFeature(ObservabilityCoreLibApi.class), (CustomerVouchersSwimLaneFeaturesApi) apiContainer2.getFeature(CustomerVouchersSwimLaneFeaturesApi.class), (RemoteConfigCoreLibApi) apiContainer2.getFeature(RemoteConfigCoreLibApi.class), (NavigationCoreLibApi) apiContainer2.getFeature(NavigationCoreLibApi.class));
        }
    }

    @Nullable
    public final ApplicationComponent getAppComponent() {
        return appComponent;
    }

    @VisibleForTesting
    public final void setAppComponent(@NotNull ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "appComponent");
        appComponent = applicationComponent;
    }
}
