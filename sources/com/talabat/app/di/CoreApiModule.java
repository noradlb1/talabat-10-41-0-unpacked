package com.talabat.app.di;

import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.natives.di.JwtTokenCoreLibApi;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.flutter.ConfigurationRemoteCoreLibFlutterApi;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.di.Api;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.facebook.login.domain.FacebookLoginCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import com.talabat.core.fwf.domain.di.FWFCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.gms.location.domain.GmsLocationCoreLibApi;
import com.talabat.core.google.login.domain.GoogleLoginCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.hms.location.domain.HmsLocationCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import com.talabat.core.social.login.domain.SocialLoginCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.wearable.huawei.domain.HuaweiWatchCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.flutter.secrets.domain.FlutterSecretsCoreLibApi;
import com.talabat.gdm.owin.domain.GdmOwinTokenApi;
import com.talabat.gms.maps.domain.di.GmsMapsCoreLibApi;
import com.talabat.hms.maps.domain.di.HmsMapsCoreLibApi;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0007J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202H\u0007J\u0010\u00103\u001a\u00020\u00042\u0006\u00103\u001a\u000204H\u0007J\u0010\u00105\u001a\u00020\u00042\u0006\u00105\u001a\u000206H\u0007J\u0010\u00107\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0007J\u0010\u00109\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=H\u0007J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?H\u0007J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010@\u001a\u00020AH\u0007J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0007J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010D\u001a\u00020EH\u0007J\u0010\u0010F\u001a\u00020\u00042\u0006\u0010F\u001a\u00020GH\u0007J\u0010\u0010H\u001a\u00020\u00042\u0006\u0010H\u001a\u00020IH\u0007J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010J\u001a\u00020KH\u0007J\u0010\u0010L\u001a\u00020\u00042\u0006\u0010L\u001a\u00020MH\u0007J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010N\u001a\u00020OH\u0007J\u0010\u0010P\u001a\u00020\u00042\u0006\u0010P\u001a\u00020QH\u0007J\u0010\u0010R\u001a\u00020\u00042\u0006\u0010R\u001a\u00020SH\u0007J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010T\u001a\u00020UH\u0007J\u0010\u0010V\u001a\u00020\u00042\u0006\u0010V\u001a\u00020WH\u0007J\u0010\u0010X\u001a\u00020\u00042\u0006\u0010X\u001a\u00020YH\u0007J\u0010\u0010Z\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020[H\u0007J\u0010\u0010\\\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020]H\u0007J\u0010\u0010^\u001a\u00020\u00042\u0006\u0010^\u001a\u00020_H\u0007J\u0010\u0010`\u001a\u00020\u00042\u0006\u0010`\u001a\u00020aH\u0007J\u0010\u0010b\u001a\u00020\u00042\u0006\u0010b\u001a\u00020cH\u0007J\u0010\u0010d\u001a\u00020\u00042\u0006\u0010d\u001a\u00020eH\u0007J\u0010\u0010f\u001a\u00020\u00042\u0006\u0010f\u001a\u00020gH\u0007J\u0010\u0010h\u001a\u00020\u00042\u0006\u0010h\u001a\u00020iH\u0007¨\u0006j"}, d2 = {"Lcom/talabat/app/di/CoreApiModule;", "", "()V", "aaaCoreLibApi", "Lcom/talabat/core/di/Api;", "Lcom/talabat/authentication/aaa/di/AaaCoreLibApi;", "authenticationCoreLibApi", "Lcom/talabat/authentication/authenticate/domain/AuthenticationCoreLibApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "configurationRemoteCoreLibFlutterApi", "Lcom/talabat/configuration/di/flutter/ConfigurationRemoteCoreLibFlutterApi;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "deeplinkNavigationChannelCoreImplLibApi", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreImplLibApi;", "deeplinkNavigationChannelCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreLibApi;", "dispatcherApi", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "facebookLoginCoreLibApi", "Lcom/talabat/core/facebook/login/domain/FacebookLoginCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "flutterBindingCoreLibApi", "Lcom/talabat/core/flutter/binding/domain/di/FlutterBindingCoreLibApi;", "flutterChannelsCoreImplLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreImplLibApi;", "flutterChannelsCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreLibApi;", "flutterEngineCoreLibApi", "Lcom/talabat/core/flutter/engine/domain/di/FlutterEngineCoreLibApi;", "flutterSecretsCoreLibApi", "Lcom/talabat/flutter/secrets/domain/FlutterSecretsCoreLibApi;", "fwfCoreLibApi", "Lcom/talabat/core/fwf/domain/di/FWFCoreLibApi;", "gdmOwinCoreLibApi", "gdmOwinTokenApi", "Lcom/talabat/gdm/owin/domain/GdmOwinTokenApi;", "gmsCoreLibApi", "gmsBaseCoreLibApi", "Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "gmsLocationCoreLibApi", "Lcom/talabat/core/gms/location/domain/GmsLocationCoreLibApi;", "gmsMapsCoreLibApi", "Lcom/talabat/gms/maps/domain/di/GmsMapsCoreLibApi;", "googleAdvertisementCoreLibApi", "Lcom/talabat/core/advertisement/google/domain/GoogleAdvertisementCoreLibApi;", "googleLoginCoreLibApi", "Lcom/talabat/core/google/login/domain/GoogleLoginCoreLibApi;", "hmsCoreLibApi", "hmsBaseCoreLibApi", "Lcom/talabat/core/hms/base/domain/HmsBaseCoreLibApi;", "hmsLocationCoreLibApi", "Lcom/talabat/core/hms/location/domain/HmsLocationCoreLibApi;", "hmsMapsCoreLibApi", "Lcom/talabat/hms/maps/domain/di/HmsMapsCoreLibApi;", "huaweiWatchCoreLibApi", "Lcom/talabat/core/wearable/huawei/domain/HuaweiWatchCoreLibApi;", "jwtTokenCoreLibApi", "Lcom/talabat/authentication/natives/di/JwtTokenCoreLibApi;", "locationCoreLibApi", "Lcom/talabat/location/domain/di/LocationCoreLibApi;", "mapsCoreLibApi", "Lcom/talabat/maps/domain/di/MapsCoreLibApi;", "mutableConfigurationLocalCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;", "mutableConfigurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "onBoardingExperimentApi", "Lcom/talabat/onboarding/domain/di/OnBoardingExperimentApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "perseusCoreLibApi", "Lcom/talabat/core/perseus/domain/TalabatPerseusCoreLibApi;", "pinlessCheckoutCoreLibApi", "Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutCoreLibApi;", "remoteConfigCoreLibApi", "Lcom/talabat/talabatremoteconfiguration/di/RemoteConfigCoreLibApi;", "safetyCoreLibApi", "Lcom/talabat/core/safety/domain/SafetyCoreLibApi;", "secretCoreLibApi", "Lcom/talabat/authentication/aaa/di/SecretCoreLibApi;", "socialLoginCoreLibApi", "Lcom/talabat/core/social/login/domain/SocialLoginCoreLibApi;", "tokenCoreLibApi", "Lcom/talabat/authentication/token/domain/TokenCoreLibApi;", "tokenCoreLibDataApi", "Lcom/talabat/authentication/token/data/di/TokenCoreLibDataApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "com_talabat_app_app"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {CoreLibsModule.class})
public final class CoreApiModule {
    @NotNull
    public static final CoreApiModule INSTANCE = new CoreApiModule();

    private CoreApiModule() {
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(AaaCoreLibApi.class)
    @Reusable
    @Provides
    public final Api aaaCoreLibApi(@NotNull AaaCoreLibApi aaaCoreLibApi) {
        Intrinsics.checkNotNullParameter(aaaCoreLibApi, "aaaCoreLibApi");
        return aaaCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(AuthenticationCoreLibApi.class)
    @Reusable
    @Provides
    public final Api authenticationCoreLibApi(@NotNull AuthenticationCoreLibApi authenticationCoreLibApi) {
        Intrinsics.checkNotNullParameter(authenticationCoreLibApi, "authenticationCoreLibApi");
        return authenticationCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(ConfigurationLocalCoreLibApi.class)
    @Reusable
    @Provides
    public final Api configurationLocalCoreLibApi(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        return configurationLocalCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(ConfigurationRemoteCoreLibApi.class)
    @Reusable
    @Provides
    public final Api configurationRemoteCoreLibApi(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationRemoteCoreLibApi, "configurationRemoteCoreLibApi");
        return configurationRemoteCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(ConfigurationRemoteCoreLibFlutterApi.class)
    @Reusable
    @Provides
    public final Api configurationRemoteCoreLibFlutterApi(@NotNull ConfigurationRemoteCoreLibFlutterApi configurationRemoteCoreLibFlutterApi) {
        Intrinsics.checkNotNullParameter(configurationRemoteCoreLibFlutterApi, "configurationRemoteCoreLibFlutterApi");
        return configurationRemoteCoreLibFlutterApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(ContextCoreLibApi.class)
    @Reusable
    @Provides
    public final Api contextCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return contextCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(CustomerCoreLibApi.class)
    @Reusable
    @Provides
    public final Api customerCoreLibApi(@NotNull CustomerCoreLibApi customerCoreLibApi) {
        Intrinsics.checkNotNullParameter(customerCoreLibApi, "customerCoreLibApi");
        return customerCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(DeepLinkCoreLibApi.class)
    @Reusable
    @Provides
    public final Api deepLinkCoreLibApi(@NotNull DeepLinkCoreLibApi deepLinkCoreLibApi) {
        Intrinsics.checkNotNullParameter(deepLinkCoreLibApi, "deepLinkCoreLibApi");
        return deepLinkCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(DeeplinkNavigationChannelCoreImplLibApi.class)
    @Reusable
    @Provides
    public final Api deeplinkNavigationChannelCoreImplLibApi(@NotNull DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi) {
        Intrinsics.checkNotNullParameter(deeplinkNavigationChannelCoreImplLibApi, "deeplinkNavigationChannelCoreImplLibApi");
        return deeplinkNavigationChannelCoreImplLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(DeeplinkNavigationChannelCoreLibApi.class)
    @Reusable
    @Provides
    public final Api deeplinkNavigationChannelCoreLibApi(@NotNull DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi) {
        Intrinsics.checkNotNullParameter(deeplinkNavigationChannelCoreLibApi, "deeplinkNavigationChannelCoreLibApi");
        return deeplinkNavigationChannelCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(DispatcherCoreLibApi.class)
    @Reusable
    @Provides
    public final Api dispatcherApi(@NotNull DispatcherCoreLibApi dispatcherCoreLibApi) {
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi, "dispatcherCoreLibApi");
        return dispatcherCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(ExperimentCoreLibApi.class)
    @Reusable
    @Provides
    public final Api experimentCoreLibApi(@NotNull ExperimentCoreLibApi experimentCoreLibApi) {
        Intrinsics.checkNotNullParameter(experimentCoreLibApi, "experimentCoreLibApi");
        return experimentCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(FacebookLoginCoreLibApi.class)
    @Reusable
    @Provides
    public final Api facebookLoginCoreLibApi(@NotNull FacebookLoginCoreLibApi facebookLoginCoreLibApi) {
        Intrinsics.checkNotNullParameter(facebookLoginCoreLibApi, "facebookLoginCoreLibApi");
        return facebookLoginCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(FeatureFlagCoreLibApi.class)
    @Reusable
    @Provides
    public final Api featureFlagCoreLibApi(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi) {
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi, "featureFlagCoreLibApi");
        return featureFlagCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(FlutterBindingCoreLibApi.class)
    @Reusable
    @Provides
    public final Api flutterBindingCoreLibApi(@NotNull FlutterBindingCoreLibApi flutterBindingCoreLibApi) {
        Intrinsics.checkNotNullParameter(flutterBindingCoreLibApi, "flutterBindingCoreLibApi");
        return flutterBindingCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(FlutterChannelsCoreImplLibApi.class)
    @Reusable
    @Provides
    public final Api flutterChannelsCoreImplLibApi(@NotNull FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi) {
        Intrinsics.checkNotNullParameter(flutterChannelsCoreImplLibApi, "flutterChannelsCoreImplLibApi");
        return flutterChannelsCoreImplLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(FlutterChannelsCoreLibApi.class)
    @Reusable
    @Provides
    public final Api flutterChannelsCoreLibApi(@NotNull FlutterChannelsCoreLibApi flutterChannelsCoreLibApi) {
        Intrinsics.checkNotNullParameter(flutterChannelsCoreLibApi, "flutterChannelsCoreLibApi");
        return flutterChannelsCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(FlutterEngineCoreLibApi.class)
    @Reusable
    @Provides
    public final Api flutterEngineCoreLibApi(@NotNull FlutterEngineCoreLibApi flutterEngineCoreLibApi) {
        Intrinsics.checkNotNullParameter(flutterEngineCoreLibApi, "flutterEngineCoreLibApi");
        return flutterEngineCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(FlutterSecretsCoreLibApi.class)
    @Reusable
    @Provides
    public final Api flutterSecretsCoreLibApi(@NotNull FlutterSecretsCoreLibApi flutterSecretsCoreLibApi) {
        Intrinsics.checkNotNullParameter(flutterSecretsCoreLibApi, "flutterSecretsCoreLibApi");
        return flutterSecretsCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(FWFCoreLibApi.class)
    @Reusable
    @Provides
    public final Api fwfCoreLibApi(@NotNull FWFCoreLibApi fWFCoreLibApi) {
        Intrinsics.checkNotNullParameter(fWFCoreLibApi, "fwfCoreLibApi");
        return fWFCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(GdmOwinTokenApi.class)
    @Reusable
    @Provides
    public final Api gdmOwinCoreLibApi(@NotNull GdmOwinTokenApi gdmOwinTokenApi) {
        Intrinsics.checkNotNullParameter(gdmOwinTokenApi, "gdmOwinTokenApi");
        return gdmOwinTokenApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(GmsBaseCoreLibApi.class)
    @Reusable
    @Provides
    public final Api gmsCoreLibApi(@NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi) {
        Intrinsics.checkNotNullParameter(gmsBaseCoreLibApi, "gmsBaseCoreLibApi");
        return gmsBaseCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(GmsLocationCoreLibApi.class)
    @Reusable
    @Provides
    public final Api gmsLocationCoreLibApi(@NotNull GmsLocationCoreLibApi gmsLocationCoreLibApi) {
        Intrinsics.checkNotNullParameter(gmsLocationCoreLibApi, "gmsLocationCoreLibApi");
        return gmsLocationCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(GmsMapsCoreLibApi.class)
    @Reusable
    @Provides
    public final Api gmsMapsCoreLibApi(@NotNull GmsMapsCoreLibApi gmsMapsCoreLibApi) {
        Intrinsics.checkNotNullParameter(gmsMapsCoreLibApi, "gmsMapsCoreLibApi");
        return gmsMapsCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(GoogleAdvertisementCoreLibApi.class)
    @Reusable
    @Provides
    public final Api googleAdvertisementCoreLibApi(@NotNull GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi) {
        Intrinsics.checkNotNullParameter(googleAdvertisementCoreLibApi, "googleAdvertisementCoreLibApi");
        return googleAdvertisementCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(GoogleLoginCoreLibApi.class)
    @Reusable
    @Provides
    public final Api googleLoginCoreLibApi(@NotNull GoogleLoginCoreLibApi googleLoginCoreLibApi) {
        Intrinsics.checkNotNullParameter(googleLoginCoreLibApi, "googleLoginCoreLibApi");
        return googleLoginCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(HmsBaseCoreLibApi.class)
    @Reusable
    @Provides
    public final Api hmsCoreLibApi(@NotNull HmsBaseCoreLibApi hmsBaseCoreLibApi) {
        Intrinsics.checkNotNullParameter(hmsBaseCoreLibApi, "hmsBaseCoreLibApi");
        return hmsBaseCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(HmsLocationCoreLibApi.class)
    @Reusable
    @Provides
    public final Api hmsLocationCoreLibApi(@NotNull HmsLocationCoreLibApi hmsLocationCoreLibApi) {
        Intrinsics.checkNotNullParameter(hmsLocationCoreLibApi, "hmsLocationCoreLibApi");
        return hmsLocationCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(HmsMapsCoreLibApi.class)
    @Reusable
    @Provides
    public final Api hmsMapsCoreLibApi(@NotNull HmsMapsCoreLibApi hmsMapsCoreLibApi) {
        Intrinsics.checkNotNullParameter(hmsMapsCoreLibApi, "hmsMapsCoreLibApi");
        return hmsMapsCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(HuaweiWatchCoreLibApi.class)
    @Reusable
    @Provides
    public final Api huaweiWatchCoreLibApi(@NotNull HuaweiWatchCoreLibApi huaweiWatchCoreLibApi) {
        Intrinsics.checkNotNullParameter(huaweiWatchCoreLibApi, "huaweiWatchCoreLibApi");
        return huaweiWatchCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(JwtTokenCoreLibApi.class)
    @Reusable
    @Provides
    public final Api jwtTokenCoreLibApi(@NotNull JwtTokenCoreLibApi jwtTokenCoreLibApi) {
        Intrinsics.checkNotNullParameter(jwtTokenCoreLibApi, "jwtTokenCoreLibApi");
        return jwtTokenCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(LocationCoreLibApi.class)
    @Reusable
    @Provides
    public final Api locationCoreLibApi(@NotNull LocationCoreLibApi locationCoreLibApi) {
        Intrinsics.checkNotNullParameter(locationCoreLibApi, "locationCoreLibApi");
        return locationCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(MapsCoreLibApi.class)
    @Reusable
    @Provides
    public final Api mapsCoreLibApi(@NotNull MapsCoreLibApi mapsCoreLibApi) {
        Intrinsics.checkNotNullParameter(mapsCoreLibApi, "mapsCoreLibApi");
        return mapsCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(MutableConfigurationLocalCoreLibApi.class)
    @Reusable
    @Provides
    public final Api mutableConfigurationLocalCoreLibApi(@NotNull MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi) {
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalCoreLibApi, "mutableConfigurationLocalCoreLibApi");
        return mutableConfigurationLocalCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(MutableConfigurationRemoteCoreLibApi.class)
    @Reusable
    @Provides
    public final Api mutableConfigurationRemoteCoreLibApi(@NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteCoreLibApi, "mutableConfigurationRemoteCoreLibApi");
        return mutableConfigurationRemoteCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(NavigationCoreLibApi.class)
    @Reusable
    @Provides
    public final Api navigationCoreLibApi(@NotNull NavigationCoreLibApi navigationCoreLibApi) {
        Intrinsics.checkNotNullParameter(navigationCoreLibApi, "navigationCoreLibApi");
        return navigationCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(NetworkCoreLibApi.class)
    @Reusable
    @Provides
    public final Api networkCoreLibApi(@NotNull NetworkCoreLibApi networkCoreLibApi) {
        Intrinsics.checkNotNullParameter(networkCoreLibApi, "networkCoreLibApi");
        return networkCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(ObservabilityCoreLibApi.class)
    @Reusable
    @Provides
    public final Api observabilityCoreLibApi(@NotNull ObservabilityCoreLibApi observabilityCoreLibApi) {
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi, "observabilityCoreLibApi");
        return observabilityCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(OnBoardingExperimentApi.class)
    @Reusable
    @Provides
    public final Api onBoardingExperimentApi(@NotNull OnBoardingExperimentApi onBoardingExperimentApi) {
        Intrinsics.checkNotNullParameter(onBoardingExperimentApi, "onBoardingExperimentApi");
        return onBoardingExperimentApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(ParserCoreLibApi.class)
    @Reusable
    @Provides
    public final Api parserCoreLibApi(@NotNull ParserCoreLibApi parserCoreLibApi) {
        Intrinsics.checkNotNullParameter(parserCoreLibApi, "parserCoreLibApi");
        return parserCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(TalabatPerseusCoreLibApi.class)
    @Reusable
    @Provides
    public final Api perseusCoreLibApi(@NotNull TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
        Intrinsics.checkNotNullParameter(talabatPerseusCoreLibApi, "perseusCoreLibApi");
        return talabatPerseusCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(PinlessCheckoutCoreLibApi.class)
    @Reusable
    @Provides
    public final Api pinlessCheckoutCoreLibApi(@NotNull PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi) {
        Intrinsics.checkNotNullParameter(pinlessCheckoutCoreLibApi, "pinlessCheckoutCoreLibApi");
        return pinlessCheckoutCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(RemoteConfigCoreLibApi.class)
    @Reusable
    @Provides
    public final Api remoteConfigCoreLibApi(@NotNull RemoteConfigCoreLibApi remoteConfigCoreLibApi) {
        Intrinsics.checkNotNullParameter(remoteConfigCoreLibApi, "remoteConfigCoreLibApi");
        return remoteConfigCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(SafetyCoreLibApi.class)
    @Reusable
    @Provides
    public final Api safetyCoreLibApi(@NotNull SafetyCoreLibApi safetyCoreLibApi) {
        Intrinsics.checkNotNullParameter(safetyCoreLibApi, "safetyCoreLibApi");
        return safetyCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(SecretCoreLibApi.class)
    @Reusable
    @Provides
    public final Api secretCoreLibApi(@NotNull SecretCoreLibApi secretCoreLibApi) {
        Intrinsics.checkNotNullParameter(secretCoreLibApi, "secretCoreLibApi");
        return secretCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(SocialLoginCoreLibApi.class)
    @Reusable
    @Provides
    public final Api socialLoginCoreLibApi(@NotNull SocialLoginCoreLibApi socialLoginCoreLibApi) {
        Intrinsics.checkNotNullParameter(socialLoginCoreLibApi, "socialLoginCoreLibApi");
        return socialLoginCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(TokenCoreLibApi.class)
    @Reusable
    @Provides
    public final Api tokenCoreLibApi(@NotNull TokenCoreLibApi tokenCoreLibApi) {
        Intrinsics.checkNotNullParameter(tokenCoreLibApi, "tokenCoreLibApi");
        return tokenCoreLibApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(TokenCoreLibDataApi.class)
    @Reusable
    @Provides
    public final Api tokenCoreLibDataApi(@NotNull TokenCoreLibDataApi tokenCoreLibDataApi) {
        Intrinsics.checkNotNullParameter(tokenCoreLibDataApi, "tokenCoreLibDataApi");
        return tokenCoreLibDataApi;
    }

    @CoreApis
    @IntoMap
    @NotNull
    @ClassKey(TrackingCoreLibApi.class)
    @Reusable
    @Provides
    public final Api trackingCoreLibApi(@NotNull TrackingCoreLibApi trackingCoreLibApi) {
        Intrinsics.checkNotNullParameter(trackingCoreLibApi, "trackingCoreLibApi");
        return trackingCoreLibApi;
    }
}
