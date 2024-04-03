package com.talabat.app.di;

import android.app.Application;
import androidx.work.WorkerFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.AaaCoreLibComponent;
import com.talabat.authentication.aaa.di.DaggerAaaCoreLibComponent;
import com.talabat.authentication.aaa.di.DaggerSecretCoreLibComponent;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibComponent;
import com.talabat.authentication.authenticate.data.di.DaggerAuthenticationCoreLibComponent;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.natives.di.DaggerJwtTokenCoreLibComponent;
import com.talabat.authentication.natives.di.JwtTokenCoreLibApi;
import com.talabat.authentication.token.data.di.DaggerTokenCoreLibComponent;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibComponent;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.DaggerConfigurationLocalCoreLibComponent;
import com.talabat.configuration.di.DaggerConfigurationRemoteCoreLibComponent;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.flutter.ConfigurationRemoteCoreLibFlutterApi;
import com.talabat.configuration.di.flutter.DaggerConfigurationRemoteCoreLibFlutterComponent;
import com.talabat.core.advertisement.google.data.di.DaggerGoogleAdvertisementCoreLibComponent;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.data.di.DaggerDeepLinkCoreLibComponent;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.data.di.DaggerDispatcherCoreLibComponent;
import com.talabat.core.dispatcher.data.di.DispatcherCoreLibComponent;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.data.di.DaggerExperimentCoreLibComponent;
import com.talabat.core.experiment.data.di.ExperimentCoreLibComponent;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.facebook.login.data.di.DaggerFacebookLoginCoreLibComponent;
import com.talabat.core.facebook.login.domain.FacebookLoginCoreLibApi;
import com.talabat.core.featureflag.data.di.DaggerFeatureFlagCoreLibComponent;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.binding.data.di.DaggerFlutterBindingCoreLibComponent;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingCoreLibApi;
import com.talabat.core.flutter.channels.data.di.DaggerDeeplinkNavigationChannelCoreLibComponent;
import com.talabat.core.flutter.channels.data.di.DaggerFlutterChannelsCoreLibComponent;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.channels.impl.data.di.DaggerDeeplinkNavigationChannelCoreImplLibComponent;
import com.talabat.core.flutter.channels.impl.data.di.DaggerFlutterChannelsCoreImplLibComponent;
import com.talabat.core.flutter.engine.data.di.DaggerFlutterEngineCoreLibComponent;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import com.talabat.core.fwf.data.di.DaggerFWFManagerCoreLibComponent;
import com.talabat.core.fwf.domain.di.FWFCoreLibApi;
import com.talabat.core.gms.base.data.di.DaggerGmsBaseCoreLibComponent;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.gms.location.data.di.DaggerGmsLocationCoreLibComponent;
import com.talabat.core.gms.location.domain.GmsLocationCoreLibApi;
import com.talabat.core.google.login.data.di.DaggerGoogleLoginCoreLibComponent;
import com.talabat.core.google.login.domain.GoogleLoginCoreLibApi;
import com.talabat.core.hms.base.data.di.DaggerHmsBaseCoreLibComponent;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.hms.location.data.di.DaggerHmsLocationCoreLibComponent;
import com.talabat.core.hms.location.domain.HmsLocationCoreLibApi;
import com.talabat.core.navigation.data.di.DaggerNavigationCoreLibComponent;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.network.di.DaggerNetworkCoreLibComponent;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.data.di.DaggerObservabilityCoreLibComponent;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.data.DaggerParserCoreLibComponent;
import com.talabat.core.parser.data.ParserCoreLibComponent;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.perseus.di.DaggerTalabatPerseusCoreLibComponent;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.pinless.checkout.data.DaggerPinlessCheckoutCoreLibComponent;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.safety.data.di.DaggerSafetyCoreLibComponent;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import com.talabat.core.social.login.data.di.DaggerSocialLoginCoreLibComponent;
import com.talabat.core.social.login.domain.SocialLoginCoreLibApi;
import com.talabat.core.tracking.data.di.DaggerTrackingCoreLibComponent;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.wearable.huawei.data.di.DaggerHuaweiWatchCoreLibApiComponent;
import com.talabat.core.wearable.huawei.domain.HuaweiWatchCoreLibApi;
import com.talabat.core.work.di.DaggerWorkCoreLibComponent;
import com.talabat.core.work.di.WorkCoreLibApi;
import com.talabat.customer.di.DaggerCustomerCoreLibComponent;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.flutter.secrets.data.di.DaggerFlutterSecretsCoreLibComponent;
import com.talabat.flutter.secrets.domain.FlutterSecretsCoreLibApi;
import com.talabat.gdm.owin.data.di.DaggerGdmOwinTokenComponent;
import com.talabat.gdm.owin.domain.GdmOwinTokenApi;
import com.talabat.gms.maps.data.di.DaggerGmsMapsCoreLibComponent;
import com.talabat.gms.maps.domain.di.GmsMapsCoreLibApi;
import com.talabat.hms.maps.data.di.DaggerHmsMapsCoreLibComponent;
import com.talabat.hms.maps.domain.di.HmsMapsCoreLibApi;
import com.talabat.location.data.di.DaggerLocationCoreLibComponent;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.data.di.DaggerMapsCoreLibComponent;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.onboarding.data.di.DaggerOnboardingExperimentComponent;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import com.talabat.talabatremoteconfiguration.di.DaggerRemoteConfigCoreLibComponent;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Ø\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0007JP\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007JH\u0010)\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u00103\u001a\u0002042\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u00105\u001a\u0002062\u0006\u00103\u001a\u0002042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010+\u001a\u00020,H\u0007J\u0010\u00107\u001a\u0002082\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J(\u00109\u001a\u00020:2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007Jh\u0010;\u001a\u00020<2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>2\u0006\u0010-\u001a\u00020.2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020$H\u0007J(\u0010/\u001a\u0002002\u0006\u0010;\u001a\u00020<2\u0006\u0010C\u001a\u00020D2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u00101\u001a\u0002022\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010C\u001a\u00020D2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J \u0010E\u001a\u00020F2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020HH\u0007J\b\u0010I\u001a\u00020\u0015H\u0007J\u0010\u0010G\u001a\u00020H2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010J\u001a\u00020K2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0018\u0010L\u001a\u00020M2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010N\u001a\u00020O2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010P\u001a\u00020Q2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010R\u001a\u00020S2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010T\u001a\u00020U2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0018\u0010V\u001a\u00020W2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010X\u001a\u00020Y2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007JP\u0010Z\u001a\u00020[2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020]2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J(\u0010^\u001a\u00020_2\u0006\u0010G\u001a\u00020H2\u0006\u0010J\u001a\u00020K2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0007J(\u0010`\u001a\u00020a2\u0006\u0010G\u001a\u00020H2\u0006\u0010L\u001a\u00020M2\u0006\u0010R\u001a\u00020S2\u0006\u0010V\u001a\u00020WH\u0007J\b\u0010A\u001a\u00020!H\u0007J0\u0010B\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010b\u001a\u00020c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010-\u001a\u00020.H\u0007J\u0010\u0010b\u001a\u00020c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010d\u001a\u00020eH\u0007J\u0018\u0010f\u001a\u00020g2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J \u0010h\u001a\u00020e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010=\u001a\u00020>2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@H\u0007J\b\u0010\\\u001a\u00020]H\u0007JX\u0010i\u001a\u00020j2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010N\u001a\u00020O2\u0006\u0010G\u001a\u00020H2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010b\u001a\u00020c2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010d\u001a\u00020eH\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u001b\u0010k\u001a\r\u0012\t\u0012\u00070m¢\u0006\u0002\bn0l2\u0006\u0010\"\u001a\u00020#H\u0007J \u0010o\u001a\u00020p2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020Q2\u0006\u00107\u001a\u000208H\u0007J\u0010\u0010q\u001a\u00020r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J8\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J@\u0010s\u001a\u00020@2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010G\u001a\u00020H2\u0006\u0010R\u001a\u00020S2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020eH\u0007J\u001b\u0010t\u001a\u00020u2\u0011\u0010v\u001a\r\u0012\t\u0012\u00070m¢\u0006\u0002\bn0lH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006w"}, d2 = {"Lcom/talabat/app/di/CoreLibsModule;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "contextApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "getContextApi", "()Lcom/talabat/core/context/domain/ContextCoreLibApi;", "contextApi$delegate", "Lkotlin/Lazy;", "aaaCoreLibApi", "Lcom/talabat/authentication/aaa/di/AaaCoreLibApi;", "authenticationCoreLibApi", "Lcom/talabat/authentication/authenticate/domain/AuthenticationCoreLibApi;", "contextCoreLibApi", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "gdmOwinTokenApi", "Lcom/talabat/gdm/owin/domain/GdmOwinTokenApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "secretCoreLibApi", "Lcom/talabat/authentication/aaa/di/SecretCoreLibApi;", "tokenCoreLibDataApi", "Lcom/talabat/authentication/token/data/di/TokenCoreLibDataApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "api", "Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "configurationRemoteCoreLibFlutterApi", "Lcom/talabat/configuration/di/flutter/ConfigurationRemoteCoreLibFlutterApi;", "customerCoreLibApi", "Lcom/talabat/customer/domain/di/CustomerCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "flutterChannelsCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreLibApi;", "flutterEngineCoreLibApi", "Lcom/talabat/core/flutter/engine/domain/di/FlutterEngineCoreLibApi;", "deeplinkNavigationChannelCoreImplLibApi", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreImplLibApi;", "deeplinkNavigationChannelCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreLibApi;", "facebookLoginCoreLibApi", "Lcom/talabat/core/facebook/login/domain/FacebookLoginCoreLibApi;", "flutterBindingCoreLibApi", "Lcom/talabat/core/flutter/binding/domain/di/FlutterBindingCoreLibApi;", "flutterChannelsCoreImplLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreImplLibApi;", "pinlessCheckoutCoreLibApi", "Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "mutableConfigurationLocalCoreLibApi", "mutableConfigurationRemoteCoreLibApi", "flutterSecretsCoreLibApi", "Lcom/talabat/flutter/secrets/domain/FlutterSecretsCoreLibApi;", "fwfCoreLibApi", "Lcom/talabat/core/fwf/domain/di/FWFCoreLibApi;", "gmsBaseCoreLibApi", "Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "gdmOwinTokenCoreLibApi", "gmsLocationCoreLibApi", "Lcom/talabat/core/gms/location/domain/GmsLocationCoreLibApi;", "gmsMapsCoreLibApi", "Lcom/talabat/gms/maps/domain/di/GmsMapsCoreLibApi;", "googleAdvertisementCoreLibApi", "Lcom/talabat/core/advertisement/google/domain/GoogleAdvertisementCoreLibApi;", "googleLoginCoreLibApi", "Lcom/talabat/core/google/login/domain/GoogleLoginCoreLibApi;", "hmsBaseCoreLibApi", "Lcom/talabat/core/hms/base/domain/HmsBaseCoreLibApi;", "hmsLocationCoreLibApi", "Lcom/talabat/core/hms/location/domain/HmsLocationCoreLibApi;", "hmsMapsCoreLibApi", "Lcom/talabat/hms/maps/domain/di/HmsMapsCoreLibApi;", "huaweiWatchCoreLibApi", "Lcom/talabat/core/wearable/huawei/domain/HuaweiWatchCoreLibApi;", "jwtTokenCoreLibApi", "Lcom/talabat/authentication/natives/di/JwtTokenCoreLibApi;", "remoteConfigCoreLibApi", "Lcom/talabat/talabatremoteconfiguration/di/RemoteConfigCoreLibApi;", "locationCoreLibApi", "Lcom/talabat/location/domain/di/LocationCoreLibApi;", "mapsCoreLibApi", "Lcom/talabat/maps/domain/di/MapsCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "talabatPerseusCoreLibApi", "Lcom/talabat/core/perseus/domain/TalabatPerseusCoreLibApi;", "onBoardingExperimentApi", "Lcom/talabat/onboarding/domain/di/OnBoardingExperimentApi;", "perseusCoreLibApi", "safetyCoreLibApi", "Lcom/talabat/core/safety/domain/SafetyCoreLibApi;", "sendWorkerFactory", "", "Landroidx/work/WorkerFactory;", "Lkotlin/jvm/JvmSuppressWildcards;", "socialLoginCoreLibApi", "Lcom/talabat/core/social/login/domain/SocialLoginCoreLibApi;", "tokenCoreLibApi", "Lcom/talabat/authentication/token/domain/TokenCoreLibApi;", "trackerCoreLibApi", "workCoreLibApi", "Lcom/talabat/core/work/di/WorkCoreLibApi;", "workerFactories", "com_talabat_app_app"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class CoreLibsModule {
    /* access modifiers changed from: private */
    @NotNull
    public final Application application;
    @NotNull
    private final Lazy contextApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new CoreLibsModule$contextApi$2(this));

    public CoreLibsModule(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, MimeTypes.BASE_TYPE_APPLICATION);
        this.application = application2;
    }

    private final ContextCoreLibApi getContextApi() {
        return (ContextCoreLibApi) this.contextApi$delegate.getValue();
    }

    @NotNull
    @Reusable
    @Provides
    public final AaaCoreLibApi aaaCoreLibApi() {
        AaaCoreLibComponent create = DaggerAaaCoreLibComponent.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        return create;
    }

    @NotNull
    @Reusable
    @Provides
    public final AuthenticationCoreLibApi authenticationCoreLibApi(@NotNull AaaCoreLibApi aaaCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull GdmOwinTokenApi gdmOwinTokenApi, @NotNull ParserCoreLibApi parserCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull TokenCoreLibDataApi tokenCoreLibDataApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi) {
        Intrinsics.checkNotNullParameter(aaaCoreLibApi, "aaaCoreLibApi");
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi, "dispatcherCoreLibApi");
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi, "featureFlagCoreLibApi");
        GdmOwinTokenApi gdmOwinTokenApi2 = gdmOwinTokenApi;
        Intrinsics.checkNotNullParameter(gdmOwinTokenApi2, "gdmOwinTokenApi");
        ParserCoreLibApi parserCoreLibApi2 = parserCoreLibApi;
        Intrinsics.checkNotNullParameter(parserCoreLibApi2, "parserCoreLibApi");
        SecretCoreLibApi secretCoreLibApi2 = secretCoreLibApi;
        Intrinsics.checkNotNullParameter(secretCoreLibApi2, "secretCoreLibApi");
        TokenCoreLibDataApi tokenCoreLibDataApi2 = tokenCoreLibDataApi;
        Intrinsics.checkNotNullParameter(tokenCoreLibDataApi2, "tokenCoreLibDataApi");
        ObservabilityCoreLibApi observabilityCoreLibApi2 = observabilityCoreLibApi;
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi2, "observabilityCoreLibApi");
        return DaggerAuthenticationCoreLibComponent.factory().create(aaaCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, gdmOwinTokenApi2, parserCoreLibApi2, secretCoreLibApi2, tokenCoreLibDataApi2, observabilityCoreLibApi2);
    }

    @NotNull
    @Reusable
    @Provides
    public final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi(@NotNull MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi) {
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalCoreLibApi, "api");
        return mutableConfigurationLocalCoreLibApi;
    }

    @NotNull
    @Reusable
    @Provides
    public final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi(@NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteCoreLibApi, "api");
        return mutableConfigurationRemoteCoreLibApi;
    }

    @NotNull
    @Reusable
    @Provides
    public final ConfigurationRemoteCoreLibFlutterApi configurationRemoteCoreLibFlutterApi(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationRemoteCoreLibApi, "configurationRemoteCoreLibApi");
        return DaggerConfigurationRemoteCoreLibFlutterComponent.factory().create(configurationRemoteCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final ContextCoreLibApi contextCoreLibApi() {
        return getContextApi();
    }

    @NotNull
    @Reusable
    @Provides
    public final CustomerCoreLibApi customerCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerCustomerCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final DeepLinkCoreLibApi deepLinkCoreLibApi(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, @NotNull FlutterEngineCoreLibApi flutterEngineCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull CustomerCoreLibApi customerCoreLibApi) {
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi, "featureFlagCoreLibApi");
        Intrinsics.checkNotNullParameter(experimentCoreLibApi, "experimentCoreLibApi");
        Intrinsics.checkNotNullParameter(navigationCoreLibApi, "navigationCoreLibApi");
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi, "observabilityCoreLibApi");
        Intrinsics.checkNotNullParameter(flutterChannelsCoreLibApi, "flutterChannelsCoreLibApi");
        FlutterEngineCoreLibApi flutterEngineCoreLibApi2 = flutterEngineCoreLibApi;
        Intrinsics.checkNotNullParameter(flutterEngineCoreLibApi2, "flutterEngineCoreLibApi");
        DispatcherCoreLibApi dispatcherCoreLibApi2 = dispatcherCoreLibApi;
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi2, "dispatcherCoreLibApi");
        CustomerCoreLibApi customerCoreLibApi2 = customerCoreLibApi;
        Intrinsics.checkNotNullParameter(customerCoreLibApi2, "customerCoreLibApi");
        return DaggerDeepLinkCoreLibComponent.factory().create(featureFlagCoreLibApi, experimentCoreLibApi, navigationCoreLibApi, observabilityCoreLibApi, flutterChannelsCoreLibApi, flutterEngineCoreLibApi2, dispatcherCoreLibApi2, customerCoreLibApi2);
    }

    @NotNull
    @Reusable
    @Provides
    public final DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi(@NotNull DeepLinkCoreLibApi deepLinkCoreLibApi) {
        Intrinsics.checkNotNullParameter(deepLinkCoreLibApi, "deepLinkCoreLibApi");
        return DaggerDeeplinkNavigationChannelCoreImplLibComponent.factory().create(deepLinkCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi(@NotNull DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi) {
        Intrinsics.checkNotNullParameter(deeplinkNavigationChannelCoreImplLibApi, "deeplinkNavigationChannelCoreImplLibApi");
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi, "dispatcherCoreLibApi");
        return DaggerDeeplinkNavigationChannelCoreLibComponent.factory().create(dispatcherCoreLibApi, deeplinkNavigationChannelCoreImplLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final DispatcherCoreLibApi dispatcherCoreLibApi() {
        DispatcherCoreLibComponent create = DaggerDispatcherCoreLibComponent.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        return create;
    }

    @NotNull
    @Reusable
    @Provides
    public final ExperimentCoreLibApi experimentCoreLibApi() {
        ExperimentCoreLibComponent create = DaggerExperimentCoreLibComponent.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        return create;
    }

    @NotNull
    @Reusable
    @Provides
    public final FacebookLoginCoreLibApi facebookLoginCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerFacebookLoginCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final FeatureFlagCoreLibApi featureFlagCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerFeatureFlagCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final FlutterBindingCoreLibApi flutterBindingCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi, @NotNull FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, @NotNull FlutterEngineCoreLibApi flutterEngineCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(deeplinkNavigationChannelCoreLibApi, "deeplinkNavigationChannelCoreLibApi");
        Intrinsics.checkNotNullParameter(flutterChannelsCoreLibApi, "flutterChannelsCoreLibApi");
        Intrinsics.checkNotNullParameter(flutterEngineCoreLibApi, "flutterEngineCoreLibApi");
        return DaggerFlutterBindingCoreLibComponent.factory().create(contextCoreLibApi, deeplinkNavigationChannelCoreLibApi, flutterChannelsCoreLibApi, flutterEngineCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull TokenCoreLibDataApi tokenCoreLibDataApi, @NotNull PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi, @NotNull MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, @NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        FeatureFlagCoreLibApi featureFlagCoreLibApi2 = featureFlagCoreLibApi;
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi2, "featureFlagCoreLibApi");
        ObservabilityCoreLibApi observabilityCoreLibApi2 = observabilityCoreLibApi;
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi2, "observabilityCoreLibApi");
        ExperimentCoreLibApi experimentCoreLibApi2 = experimentCoreLibApi;
        Intrinsics.checkNotNullParameter(experimentCoreLibApi2, "experimentCoreLibApi");
        SecretCoreLibApi secretCoreLibApi2 = secretCoreLibApi;
        Intrinsics.checkNotNullParameter(secretCoreLibApi2, "secretCoreLibApi");
        TokenCoreLibDataApi tokenCoreLibDataApi2 = tokenCoreLibDataApi;
        Intrinsics.checkNotNullParameter(tokenCoreLibDataApi2, "tokenCoreLibDataApi");
        PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi2 = pinlessCheckoutCoreLibApi;
        Intrinsics.checkNotNullParameter(pinlessCheckoutCoreLibApi2, "pinlessCheckoutCoreLibApi");
        NavigationCoreLibApi navigationCoreLibApi2 = navigationCoreLibApi;
        Intrinsics.checkNotNullParameter(navigationCoreLibApi2, "navigationCoreLibApi");
        TrackingCoreLibApi trackingCoreLibApi2 = trackingCoreLibApi;
        Intrinsics.checkNotNullParameter(trackingCoreLibApi2, "trackingCoreLibApi");
        ParserCoreLibApi parserCoreLibApi2 = parserCoreLibApi;
        Intrinsics.checkNotNullParameter(parserCoreLibApi2, "parserCoreLibApi");
        MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2 = mutableConfigurationLocalCoreLibApi;
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalCoreLibApi2, "mutableConfigurationLocalCoreLibApi");
        MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2 = mutableConfigurationRemoteCoreLibApi;
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteCoreLibApi2, "mutableConfigurationRemoteCoreLibApi");
        return DaggerFlutterChannelsCoreImplLibComponent.factory().create(contextCoreLibApi, featureFlagCoreLibApi2, observabilityCoreLibApi2, experimentCoreLibApi2, secretCoreLibApi2, tokenCoreLibDataApi2, pinlessCheckoutCoreLibApi2, navigationCoreLibApi2, trackingCoreLibApi2, parserCoreLibApi2, mutableConfigurationLocalCoreLibApi2, mutableConfigurationRemoteCoreLibApi2);
    }

    @NotNull
    @Reusable
    @Provides
    public final FlutterChannelsCoreLibApi flutterChannelsCoreLibApi(@NotNull FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi, @NotNull FlutterSecretsCoreLibApi flutterSecretsCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi) {
        Intrinsics.checkNotNullParameter(flutterChannelsCoreImplLibApi, "flutterChannelsCoreImplLibApi");
        Intrinsics.checkNotNullParameter(flutterSecretsCoreLibApi, "flutterSecretsCoreLibApi");
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi, "dispatcherCoreLibApi");
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi, "observabilityCoreLibApi");
        return DaggerFlutterChannelsCoreLibComponent.factory().create(dispatcherCoreLibApi, flutterChannelsCoreImplLibApi, flutterSecretsCoreLibApi, observabilityCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final FlutterEngineCoreLibApi flutterEngineCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerFlutterEngineCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final FlutterSecretsCoreLibApi flutterSecretsCoreLibApi(@NotNull SecretCoreLibApi secretCoreLibApi) {
        Intrinsics.checkNotNullParameter(secretCoreLibApi, "secretCoreLibApi");
        return DaggerFlutterSecretsCoreLibComponent.factory().create(secretCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final FWFCoreLibApi fwfCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        Intrinsics.checkNotNullParameter(gmsBaseCoreLibApi, "gmsBaseCoreLibApi");
        return DaggerFWFManagerCoreLibComponent.factory().create(configurationLocalCoreLibApi, contextCoreLibApi, gmsBaseCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final GdmOwinTokenApi gdmOwinTokenCoreLibApi() {
        return DaggerGdmOwinTokenComponent.factory().create();
    }

    @NotNull
    @Reusable
    @Provides
    public final GmsBaseCoreLibApi gmsBaseCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerGmsBaseCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final GmsLocationCoreLibApi gmsLocationCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerGmsLocationCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final GmsMapsCoreLibApi gmsMapsCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi, "observabilityCoreLibApi");
        return DaggerGmsMapsCoreLibComponent.factory().create(contextCoreLibApi, observabilityCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerGoogleAdvertisementCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final GoogleLoginCoreLibApi googleLoginCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerGoogleLoginCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final HmsBaseCoreLibApi hmsBaseCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerHmsBaseCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final HmsLocationCoreLibApi hmsLocationCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerHmsLocationCoreLibComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final HmsMapsCoreLibApi hmsMapsCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi, "observabilityCoreLibApi");
        return DaggerHmsMapsCoreLibComponent.factory().create(contextCoreLibApi, observabilityCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final HuaweiWatchCoreLibApi huaweiWatchCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        return DaggerHuaweiWatchCoreLibApiComponent.factory().create(contextCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final JwtTokenCoreLibApi jwtTokenCoreLibApi(@NotNull AaaCoreLibApi aaaCoreLibApi, @NotNull AuthenticationCoreLibApi authenticationCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull RemoteConfigCoreLibApi remoteConfigCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull TokenCoreLibDataApi tokenCoreLibDataApi) {
        Intrinsics.checkNotNullParameter(aaaCoreLibApi, "aaaCoreLibApi");
        Intrinsics.checkNotNullParameter(authenticationCoreLibApi, "authenticationCoreLibApi");
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi, "dispatcherCoreLibApi");
        Intrinsics.checkNotNullParameter(experimentCoreLibApi, "experimentCoreLibApi");
        FeatureFlagCoreLibApi featureFlagCoreLibApi2 = featureFlagCoreLibApi;
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi2, "featureFlagCoreLibApi");
        ObservabilityCoreLibApi observabilityCoreLibApi2 = observabilityCoreLibApi;
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi2, "observabilityCoreLibApi");
        RemoteConfigCoreLibApi remoteConfigCoreLibApi2 = remoteConfigCoreLibApi;
        Intrinsics.checkNotNullParameter(remoteConfigCoreLibApi2, "remoteConfigCoreLibApi");
        SecretCoreLibApi secretCoreLibApi2 = secretCoreLibApi;
        Intrinsics.checkNotNullParameter(secretCoreLibApi2, "secretCoreLibApi");
        TokenCoreLibDataApi tokenCoreLibDataApi2 = tokenCoreLibDataApi;
        Intrinsics.checkNotNullParameter(tokenCoreLibDataApi2, "tokenCoreLibDataApi");
        return DaggerJwtTokenCoreLibComponent.factory().create(aaaCoreLibApi, authenticationCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi2, observabilityCoreLibApi2, remoteConfigCoreLibApi2, secretCoreLibApi2, tokenCoreLibDataApi2);
    }

    @NotNull
    @Reusable
    @Provides
    public final LocationCoreLibApi locationCoreLibApi(@NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull GmsLocationCoreLibApi gmsLocationCoreLibApi, @NotNull HmsBaseCoreLibApi hmsBaseCoreLibApi, @NotNull HmsLocationCoreLibApi hmsLocationCoreLibApi) {
        Intrinsics.checkNotNullParameter(gmsBaseCoreLibApi, "gmsBaseCoreLibApi");
        Intrinsics.checkNotNullParameter(gmsLocationCoreLibApi, "gmsLocationCoreLibApi");
        Intrinsics.checkNotNullParameter(hmsBaseCoreLibApi, "hmsBaseCoreLibApi");
        Intrinsics.checkNotNullParameter(hmsLocationCoreLibApi, "hmsLocationCoreLibApi");
        return DaggerLocationCoreLibComponent.factory().create(gmsBaseCoreLibApi, gmsLocationCoreLibApi, hmsBaseCoreLibApi, hmsLocationCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final MapsCoreLibApi mapsCoreLibApi(@NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull GmsMapsCoreLibApi gmsMapsCoreLibApi, @NotNull HmsBaseCoreLibApi hmsBaseCoreLibApi, @NotNull HmsMapsCoreLibApi hmsMapsCoreLibApi) {
        Intrinsics.checkNotNullParameter(gmsBaseCoreLibApi, "gmsBaseCoreLibApi");
        Intrinsics.checkNotNullParameter(gmsMapsCoreLibApi, "gmsMapsCoreLibApi");
        Intrinsics.checkNotNullParameter(hmsBaseCoreLibApi, "hmsBaseCoreLibApi");
        Intrinsics.checkNotNullParameter(hmsMapsCoreLibApi, "hmsMapsCoreLibApi");
        return DaggerMapsCoreLibComponent.factory().create(gmsBaseCoreLibApi, gmsMapsCoreLibApi, hmsBaseCoreLibApi, hmsMapsCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi() {
        ConfigurationLocalCoreLibComponent create = DaggerConfigurationLocalCoreLibComponent.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        return create;
    }

    @NotNull
    @Reusable
    @Provides
    public final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi, "featureFlagCoreLibApi");
        Intrinsics.checkNotNullParameter(networkCoreLibApi, "networkCoreLibApi");
        Intrinsics.checkNotNullParameter(parserCoreLibApi, "parserCoreLibApi");
        return DaggerConfigurationRemoteCoreLibComponent.factory().create(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, parserCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final NavigationCoreLibApi navigationCoreLibApi() {
        return DaggerNavigationCoreLibComponent.factory().create();
    }

    @NotNull
    @Reusable
    @Provides
    public final NetworkCoreLibApi networkCoreLibApi(@NotNull ParserCoreLibApi parserCoreLibApi) {
        Intrinsics.checkNotNullParameter(parserCoreLibApi, "parserCoreLibApi");
        return DaggerNetworkCoreLibComponent.factory().create(parserCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final ObservabilityCoreLibApi observabilityCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(talabatPerseusCoreLibApi, "talabatPerseusCoreLibApi");
        return DaggerObservabilityCoreLibComponent.factory().create(contextCoreLibApi, talabatPerseusCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final OnBoardingExperimentApi onBoardingExperimentApi(@NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi) {
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi, "dispatcherCoreLibApi");
        Intrinsics.checkNotNullParameter(experimentCoreLibApi, "experimentCoreLibApi");
        return DaggerOnboardingExperimentComponent.factory().create(experimentCoreLibApi, dispatcherCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final ParserCoreLibApi parserCoreLibApi() {
        ParserCoreLibComponent create = DaggerParserCoreLibComponent.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        return create;
    }

    @NotNull
    @Reusable
    @Provides
    public final TalabatPerseusCoreLibApi perseusCoreLibApi(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationRemoteCoreLibApi, "configurationRemoteCoreLibApi");
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi, "dispatcherCoreLibApi");
        return DaggerTalabatPerseusCoreLibComponent.factory().create(configurationRemoteCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi) {
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(trackingCoreLibApi, "trackingCoreLibApi");
        return DaggerPinlessCheckoutCoreLibComponent.factory().create(contextCoreLibApi, trackingCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final RemoteConfigCoreLibApi remoteConfigCoreLibApi() {
        return DaggerRemoteConfigCoreLibComponent.factory().create();
    }

    @NotNull
    @Reusable
    @Provides
    public final SafetyCoreLibApi safetyCoreLibApi(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi, @NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        Intrinsics.checkNotNullParameter(configurationRemoteCoreLibApi, "configurationRemoteCoreLibApi");
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi2 = googleAdvertisementCoreLibApi;
        Intrinsics.checkNotNullParameter(googleAdvertisementCoreLibApi2, "googleAdvertisementCoreLibApi");
        GmsBaseCoreLibApi gmsBaseCoreLibApi2 = gmsBaseCoreLibApi;
        Intrinsics.checkNotNullParameter(gmsBaseCoreLibApi2, "gmsBaseCoreLibApi");
        DispatcherCoreLibApi dispatcherCoreLibApi2 = dispatcherCoreLibApi;
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi2, "dispatcherCoreLibApi");
        NetworkCoreLibApi networkCoreLibApi2 = networkCoreLibApi;
        Intrinsics.checkNotNullParameter(networkCoreLibApi2, "networkCoreLibApi");
        ObservabilityCoreLibApi observabilityCoreLibApi2 = observabilityCoreLibApi;
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi2, "observabilityCoreLibApi");
        SecretCoreLibApi secretCoreLibApi2 = secretCoreLibApi;
        Intrinsics.checkNotNullParameter(secretCoreLibApi2, "secretCoreLibApi");
        TalabatPerseusCoreLibApi talabatPerseusCoreLibApi2 = talabatPerseusCoreLibApi;
        Intrinsics.checkNotNullParameter(talabatPerseusCoreLibApi2, "talabatPerseusCoreLibApi");
        return DaggerSafetyCoreLibComponent.factory().create(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi2, googleAdvertisementCoreLibApi2, gmsBaseCoreLibApi2, networkCoreLibApi2, observabilityCoreLibApi2, secretCoreLibApi2, talabatPerseusCoreLibApi2);
    }

    @NotNull
    @Reusable
    @Provides
    public final SecretCoreLibApi secretCoreLibApi() {
        SecretCoreLibComponent create = DaggerSecretCoreLibComponent.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        return create;
    }

    @ElementsIntoSet
    @NotNull
    @Reusable
    @Provides
    public final Set<WorkerFactory> sendWorkerFactory(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationRemoteCoreLibApi, "configurationRemoteCoreLibApi");
        return SetsKt__SetsKt.emptySet();
    }

    @NotNull
    @Reusable
    @Provides
    public final SocialLoginCoreLibApi socialLoginCoreLibApi(@NotNull AuthenticationCoreLibApi authenticationCoreLibApi, @NotNull GoogleLoginCoreLibApi googleLoginCoreLibApi, @NotNull FacebookLoginCoreLibApi facebookLoginCoreLibApi) {
        Intrinsics.checkNotNullParameter(authenticationCoreLibApi, "authenticationCoreLibApi");
        Intrinsics.checkNotNullParameter(googleLoginCoreLibApi, "googleLoginCoreLibApi");
        Intrinsics.checkNotNullParameter(facebookLoginCoreLibApi, "facebookLoginCoreLibApi");
        return DaggerSocialLoginCoreLibComponent.factory().create(authenticationCoreLibApi, googleLoginCoreLibApi, facebookLoginCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final TokenCoreLibApi tokenCoreLibApi(@NotNull TokenCoreLibDataApi tokenCoreLibDataApi) {
        Intrinsics.checkNotNullParameter(tokenCoreLibDataApi, "tokenCoreLibDataApi");
        return tokenCoreLibDataApi;
    }

    @NotNull
    @Reusable
    @Provides
    public final TokenCoreLibDataApi tokenCoreLibDataApi(@NotNull AaaCoreLibApi aaaCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi) {
        Intrinsics.checkNotNullParameter(aaaCoreLibApi, "aaaCoreLibApi");
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi, "featureFlagCoreLibApi");
        Intrinsics.checkNotNullParameter(parserCoreLibApi, "parserCoreLibApi");
        Intrinsics.checkNotNullParameter(secretCoreLibApi, "secretCoreLibApi");
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi, "observabilityCoreLibApi");
        return DaggerTokenCoreLibComponent.factory().create(aaaCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, parserCoreLibApi, secretCoreLibApi, observabilityCoreLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final TrackingCoreLibApi trackerCoreLibApi(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull HmsBaseCoreLibApi hmsBaseCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        Intrinsics.checkNotNullParameter(contextCoreLibApi, "contextCoreLibApi");
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi, "featureFlagCoreLibApi");
        Intrinsics.checkNotNullParameter(gmsBaseCoreLibApi, "gmsBaseCoreLibApi");
        Intrinsics.checkNotNullParameter(hmsBaseCoreLibApi, "hmsBaseCoreLibApi");
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi, "observabilityCoreLibApi");
        TalabatPerseusCoreLibApi talabatPerseusCoreLibApi2 = talabatPerseusCoreLibApi;
        Intrinsics.checkNotNullParameter(talabatPerseusCoreLibApi2, "talabatPerseusCoreLibApi");
        return DaggerTrackingCoreLibComponent.factory().create(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, gmsBaseCoreLibApi, hmsBaseCoreLibApi, observabilityCoreLibApi, talabatPerseusCoreLibApi2);
    }

    @NotNull
    @Reusable
    @Provides
    public final WorkCoreLibApi workCoreLibApi(@NotNull Set<WorkerFactory> set) {
        Intrinsics.checkNotNullParameter(set, "workerFactories");
        return DaggerWorkCoreLibComponent.factory().create(set);
    }
}
