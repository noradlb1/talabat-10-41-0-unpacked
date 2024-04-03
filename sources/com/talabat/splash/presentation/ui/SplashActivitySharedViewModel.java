package com.talabat.splash.presentation.ui;

import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.talabat.authentication.token.domain.repository.ClearOwinStartupUseCase;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.observability.localTracer.PointOfInterest;
import com.talabat.observability.localTracer.PointOfInterestReporter;
import com.talabat.observability.localTracer.SectionOfInterest;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.splash.core.extension.Event;
import com.talabat.splash.core.platform.BaseViewModel;
import com.talabat.splash.domain.model.AppInfoRequestModel;
import com.talabat.splash.domain.model.DeepLinkRedirectionWrapper;
import com.talabat.splash.domain.model.ScreenInfoWrapper;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.splash.domain.model.SplashPhaseOneWrapper;
import com.talabat.splash.domain.model.SplashRedirectionWrapper;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import com.talabat.splash.domain.model.location.LocationRequestWrapper;
import com.talabat.splash.domain.usecase.GetAppInfoUseCase;
import com.talabat.splash.domain.usecase.GetAppLanguageUseCase;
import com.talabat.splash.domain.usecase.GetAppPreferncesUseCase;
import com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase;
import com.talabat.splash.domain.usecase.GetCurrentLocationUseCase;
import com.talabat.splash.domain.usecase.GetDeviceDeepLinkUseCase;
import com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase;
import com.talabat.splash.domain.usecase.GetGpsStausUseCase;
import com.talabat.splash.domain.usecase.GetLocationPermissionStatusUseCase;
import com.talabat.splash.domain.usecase.GetRedirectionFlowUseCase;
import com.talabat.splash.domain.usecase.GetReverseGeoCodeCountryUseCase;
import com.talabat.splash.domain.usecase.GetSplashPhaseOneUseCase;
import com.talabat.splash.domain.usecase.GetThirdPartyInitUseCase;
import com.talabat.splash.domain.usecase.SetAppConfigUseCase;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.PermissionStatus;
import com.talabat.splash.presentation.infrastructure.thirdparty.SplashConfig;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking;
import com.talabat.splash.presentation.ui.displaymodel.SplashContentDisplayModel;
import com.talabat.talabatcore.logger.LogManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TrackingUtils;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B¯\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u0010,J\u0007\u0010\u0001\u001a\u00020DJ\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020/2\t\u0010\u0001\u001a\u0004\u0018\u000108J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020=H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\b\u0010\u0001\u001a\u00030\u0001J\b\u0010\u0001\u001a\u00030\u0001J\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010.J\u0017\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010.2\u0007\u0010\u0001\u001a\u00020/J\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010.J\b\u0010\u0001\u001a\u00030\u0001J\b\u0010\u0001\u001a\u00030\u0001J\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010xJ\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020xH\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010 \u0001\u001a\u00020DH\u0002J\u0013\u0010¡\u0001\u001a\u00030\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010iJ!\u0010£\u0001\u001a\u00030\u00012\u0015\u0010¤\u0001\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0005\u0012\u00030\u00010¥\u0001H\u0002J\b\u0010¦\u0001\u001a\u00030\u0001J\u0015\u0010§\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010xH\u0002J\u0012\u0010¨\u0001\u001a\u00030\u00012\b\u0010©\u0001\u001a\u00030ª\u0001J\u0012\u0010«\u0001\u001a\u00030\u00012\b\u0010¬\u0001\u001a\u00030\u0001J\u0012\u0010­\u0001\u001a\u00030\u00012\b\u0010®\u0001\u001a\u00030¯\u0001J\u0011\u0010°\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020DJ\b\u0010²\u0001\u001a\u00030\u0001J\b\u0010³\u0001\u001a\u00030\u0001J\u0007\u0010´\u0001\u001a\u00020DJ\b\u0010µ\u0001\u001a\u00030\u0001J\u0011\u0010¶\u0001\u001a\u00030\u00012\u0007\u0010·\u0001\u001a\u00020=J\b\u0010¸\u0001\u001a\u00030\u0001R\u0019\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020:0.¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR&\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00101\"\u0004\bF\u0010GR(\u0010H\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00101\"\u0004\bJ\u0010GR\u001a\u0010K\u001a\u00020DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR \u0010P\u001a\b\u0012\u0004\u0012\u00020D0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00101\"\u0004\bR\u0010GR&\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00101\"\u0004\bU\u0010GR&\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00101\"\u0004\bX\u0010GR&\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00101\"\u0004\b[\u0010GR&\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00101\"\u0004\b^\u0010GR&\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00101\"\u0004\ba\u0010GR&\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00101\"\u0004\bd\u0010GR\u001a\u0010e\u001a\u00020DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010M\"\u0004\bg\u0010OR \u0010h\u001a\b\u0012\u0004\u0012\u00020i0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u00101\"\u0004\bk\u0010GR&\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020m0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u00101\"\u0004\bo\u0010GR2\u0010p\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0q0C0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u00101\"\u0004\bs\u0010GR \u0010t\u001a\b\u0012\u0004\u0012\u00020D0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u00101\"\u0004\bv\u0010GR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010w\u001a\u0004\u0018\u00010xX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R.\u0010}\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010x\u0012\u0004\u0012\u00020D0q0.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00101\"\u0004\b\u0010GR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020D0.X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u00101\"\u0005\b\u0001\u0010GR\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/talabat/splash/presentation/ui/SplashActivitySharedViewModel;", "Lcom/talabat/splash/core/platform/BaseViewModel;", "getAuthenticationTokenUseCase", "Lcom/talabat/splash/domain/usecase/GetAuthenticationTokenUseCase;", "getAppInfoUseCase", "Lcom/talabat/splash/domain/usecase/GetAppInfoUseCase;", "setAppConfigUseCase", "Lcom/talabat/splash/domain/usecase/SetAppConfigUseCase;", "getAppPreferencesUseCase", "Lcom/talabat/splash/domain/usecase/GetAppPreferncesUseCase;", "getAppLanguageUseCase", "Lcom/talabat/splash/domain/usecase/GetAppLanguageUseCase;", "getThirdPartyInitUseCase", "Lcom/talabat/splash/domain/usecase/GetThirdPartyInitUseCase;", "getRedirectionFlowUseCase", "Lcom/talabat/splash/domain/usecase/GetRedirectionFlowUseCase;", "presentationUtils", "Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;", "getSplashPhaseOneUseCase", "Lcom/talabat/splash/domain/usecase/GetSplashPhaseOneUseCase;", "getCurrentLocationUseCase", "Lcom/talabat/splash/domain/usecase/GetCurrentLocationUseCase;", "getGpsStatusUseCase", "Lcom/talabat/splash/domain/usecase/GetGpsStausUseCase;", "getLocationPermissionStatusUseCase", "Lcom/talabat/splash/domain/usecase/GetLocationPermissionStatusUseCase;", "getReverseGeoCodeCountryUseCase", "Lcom/talabat/splash/domain/usecase/GetReverseGeoCodeCountryUseCase;", "getDeepLinkFlow", "Lcom/talabat/splash/domain/usecase/GetDeviceDeepLinkUseCase;", "tracking", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;", "getDynamicSplashContentUseCase", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "splashConfig", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/SplashConfig;", "clearOwinUseCase", "Lcom/talabat/authentication/token/domain/repository/ClearOwinStartupUseCase;", "isOnboardingExperimentEnabledUseCaseImpl", "Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;", "(Lcom/talabat/splash/domain/usecase/GetAuthenticationTokenUseCase;Lcom/talabat/splash/domain/usecase/GetAppInfoUseCase;Lcom/talabat/splash/domain/usecase/SetAppConfigUseCase;Lcom/talabat/splash/domain/usecase/GetAppPreferncesUseCase;Lcom/talabat/splash/domain/usecase/GetAppLanguageUseCase;Lcom/talabat/splash/domain/usecase/GetThirdPartyInitUseCase;Lcom/talabat/splash/domain/usecase/GetRedirectionFlowUseCase;Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;Lcom/talabat/splash/domain/usecase/GetSplashPhaseOneUseCase;Lcom/talabat/splash/domain/usecase/GetCurrentLocationUseCase;Lcom/talabat/splash/domain/usecase/GetGpsStausUseCase;Lcom/talabat/splash/domain/usecase/GetLocationPermissionStatusUseCase;Lcom/talabat/splash/domain/usecase/GetReverseGeoCodeCountryUseCase;Lcom/talabat/splash/domain/usecase/GetDeviceDeepLinkUseCase;Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase;Lcom/talabat/configuration/MutableConfigurationLocalRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/splash/presentation/infrastructure/thirdparty/SplashConfig;Lcom/talabat/authentication/token/domain/repository/ClearOwinStartupUseCase;Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;)V", "allowLocationButtonTextResId", "Landroidx/lifecycle/MutableLiveData;", "", "getAllowLocationButtonTextResId", "()Landroidx/lifecycle/MutableLiveData;", "deepLinkFlowType", "getDeepLinkFlowType", "()I", "setDeepLinkFlowType", "(I)V", "deeplinkUri", "Landroid/net/Uri;", "dynamicSplashContent", "Lcom/talabat/splash/presentation/ui/displaymodel/SplashContentDisplayModel;", "getDynamicSplashContent", "locationStatusTracking", "", "getLocationStatusTracking", "()Ljava/lang/String;", "setLocationStatusTracking", "(Ljava/lang/String;)V", "mAppBasicInfoConfig", "Lcom/talabat/splash/core/extension/Event;", "", "getMAppBasicInfoConfig", "setMAppBasicInfoConfig", "(Landroidx/lifecycle/MutableLiveData;)V", "mAppForceUpdateRedirection", "getMAppForceUpdateRedirection", "setMAppForceUpdateRedirection", "mAppInfoReceived", "getMAppInfoReceived", "()Z", "setMAppInfoReceived", "(Z)V", "mAppLanguage", "getMAppLanguage", "setMAppLanguage", "mAppPrefConfig", "getMAppPrefConfig", "setMAppPrefConfig", "mDeepLinkScreenRedirection", "getMDeepLinkScreenRedirection", "setMDeepLinkScreenRedirection", "mFetchCurrentLocationExistingUsers", "getMFetchCurrentLocationExistingUsers", "setMFetchCurrentLocationExistingUsers", "mGetAuthenticationToken", "getMGetAuthenticationToken", "setMGetAuthenticationToken", "mShowLoadingAppInfo", "getMShowLoadingAppInfo", "setMShowLoadingAppInfo", "mSplashDeepLinReceived", "getMSplashDeepLinReceived", "setMSplashDeepLinReceived", "mSplashFinished", "getMSplashFinished", "setMSplashFinished", "mSplashReDirection", "Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "getMSplashReDirection", "setMSplashReDirection", "mSplashViewPhaseWithImageOrVideo", "Lcom/talabat/splash/presentation/ui/SplashPhaseOneViewEntity;", "getMSplashViewPhaseWithImageOrVideo", "setMSplashViewPhaseWithImageOrVideo", "mSplashViewPhaseWithWelcome", "Lkotlin/Pair;", "getMSplashViewPhaseWithWelcome", "setMSplashViewPhaseWithWelcome", "playVideoWithOverlay", "getPlayVideoWithOverlay", "setPlayVideoWithOverlay", "screenInfo", "Lcom/talabat/splash/domain/model/ScreenInfoWrapper;", "getScreenInfo", "()Lcom/talabat/splash/domain/model/ScreenInfoWrapper;", "setScreenInfo", "(Lcom/talabat/splash/domain/model/ScreenInfoWrapper;)V", "screenInfoWrapperLiveData", "getScreenInfoWrapperLiveData", "setScreenInfoWrapperLiveData", "showNotificationPermission", "getShowNotificationPermission", "setShowNotificationPermission", "clearOwinTokenIfExists", "deepLinkReceived", "", "deepLinkType", "uri", "deepLinkRedirection", "forceUpdateRedirection", "forceUpdateMessage", "getAppPreferences", "getAuthenticationToken", "getCurrentLocationExistingUsers", "getGpsStatus", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus;", "getLocationData", "Lcom/talabat/splash/domain/model/location/CurrentLocationWrapper;", "locationOnlyRequest", "getLocationPerMissionStatus", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "getReDirectionFlowType", "getSplashPhaseOne", "handleScreenRedirection", "screenInfoWrapper", "handleSuccess", "", "iniThirdPartSDK", "initAppConfig", "isDeepLinkFlow", "isDynamicSplashEnabled", "legacySplashConfiguration", "isEnabled", "loadAppInfo", "redirectionFlow", "loadDynamicContentForSplash", "callback", "Lkotlin/Function1;", "lottieAnimationFinished", "normalRedirection", "onDenyLocationRequest", "locationRequestDeny", "Lcom/talabat/splash/domain/model/location/LocationRequestWrapper$LocationRequestDeny;", "onLocationReceived", "locationWrapper", "onLocationRequestSuccess", "locationRequestSuccess", "Lcom/talabat/splash/domain/model/location/LocationRequestWrapper$LocationRequestSuccess;", "playVideo", "showOverlay", "setAdjustAttribution", "setAppLanguage", "shouldPreWarmCollectionsFlutterEngine", "showLoadingPopup", "trackAppLaunchWithLocationStatus", "appLaunchWithGpsLocationStatus", "videoPlayBackFinished", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashActivitySharedViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<Integer> allowLocationButtonTextResId = new MutableLiveData<>();
    @NotNull
    private final ClearOwinStartupUseCase clearOwinUseCase;
    @NotNull
    private final MutableConfigurationLocalRepository configurationLocalRepository;
    private int deepLinkFlowType = -1;
    @Nullable
    private Uri deeplinkUri;
    @NotNull
    private final MutableLiveData<SplashContentDisplayModel> dynamicSplashContent = new MutableLiveData<>();
    @NotNull
    private final GetAppInfoUseCase getAppInfoUseCase;
    @NotNull
    private final GetAppLanguageUseCase getAppLanguageUseCase;
    @NotNull
    private final GetAppPreferncesUseCase getAppPreferencesUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetAuthenticationTokenUseCase getAuthenticationTokenUseCase;
    @NotNull
    private final GetCurrentLocationUseCase getCurrentLocationUseCase;
    @NotNull
    private final GetDeviceDeepLinkUseCase getDeepLinkFlow;
    /* access modifiers changed from: private */
    @NotNull
    public final GetDynamicSplashContentUseCase getDynamicSplashContentUseCase;
    @NotNull
    private final GetGpsStausUseCase getGpsStatusUseCase;
    @NotNull
    private final GetLocationPermissionStatusUseCase getLocationPermissionStatusUseCase;
    @NotNull
    private final GetRedirectionFlowUseCase getRedirectionFlowUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetReverseGeoCodeCountryUseCase getReverseGeoCodeCountryUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetSplashPhaseOneUseCase getSplashPhaseOneUseCase;
    @NotNull
    private final GetThirdPartyInitUseCase getThirdPartyInitUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCaseImpl;
    @NotNull
    private String locationStatusTracking = "N/A";
    @NotNull
    private MutableLiveData<Event<Boolean>> mAppBasicInfoConfig = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<String>> mAppForceUpdateRedirection = new MutableLiveData<>();
    private boolean mAppInfoReceived;
    @NotNull
    private MutableLiveData<Boolean> mAppLanguage = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<Boolean>> mAppPrefConfig = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<Boolean>> mDeepLinkScreenRedirection = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<Boolean>> mFetchCurrentLocationExistingUsers = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<Boolean>> mGetAuthenticationToken = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<Boolean>> mShowLoadingAppInfo = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<Integer>> mSplashDeepLinReceived = new MutableLiveData<>();
    private boolean mSplashFinished;
    @NotNull
    private MutableLiveData<SplashRedirectionWrapper> mSplashReDirection = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<SplashPhaseOneViewEntity>> mSplashViewPhaseWithImageOrVideo = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Event<Pair<Boolean, Boolean>>> mSplashViewPhaseWithWelcome = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> playVideoWithOverlay = new MutableLiveData<>();
    @NotNull
    private final PresentationUtils presentationUtils;
    @Nullable
    private ScreenInfoWrapper screenInfo;
    @NotNull
    private MutableLiveData<Pair<ScreenInfoWrapper, Boolean>> screenInfoWrapperLiveData = new MutableLiveData<>();
    @NotNull
    private final SetAppConfigUseCase setAppConfigUseCase;
    @NotNull
    private MutableLiveData<Boolean> showNotificationPermission = new MutableLiveData<>();
    @NotNull
    private final SplashConfig splashConfig;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final Tracking f61527tracking;

    @Inject
    public SplashActivitySharedViewModel(@NotNull GetAuthenticationTokenUseCase getAuthenticationTokenUseCase2, @NotNull GetAppInfoUseCase getAppInfoUseCase2, @NotNull SetAppConfigUseCase setAppConfigUseCase2, @NotNull GetAppPreferncesUseCase getAppPreferncesUseCase, @NotNull GetAppLanguageUseCase getAppLanguageUseCase2, @NotNull GetThirdPartyInitUseCase getThirdPartyInitUseCase2, @NotNull GetRedirectionFlowUseCase getRedirectionFlowUseCase2, @NotNull PresentationUtils presentationUtils2, @NotNull GetSplashPhaseOneUseCase getSplashPhaseOneUseCase2, @NotNull GetCurrentLocationUseCase getCurrentLocationUseCase2, @NotNull GetGpsStausUseCase getGpsStausUseCase, @NotNull GetLocationPermissionStatusUseCase getLocationPermissionStatusUseCase2, @NotNull GetReverseGeoCodeCountryUseCase getReverseGeoCodeCountryUseCase2, @NotNull GetDeviceDeepLinkUseCase getDeviceDeepLinkUseCase, @NotNull Tracking tracking2, @NotNull GetDynamicSplashContentUseCase getDynamicSplashContentUseCase2, @NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull SplashConfig splashConfig2, @NotNull ClearOwinStartupUseCase clearOwinStartupUseCase, @NotNull IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase) {
        GetAuthenticationTokenUseCase getAuthenticationTokenUseCase3 = getAuthenticationTokenUseCase2;
        GetAppInfoUseCase getAppInfoUseCase3 = getAppInfoUseCase2;
        SetAppConfigUseCase setAppConfigUseCase3 = setAppConfigUseCase2;
        GetAppPreferncesUseCase getAppPreferncesUseCase2 = getAppPreferncesUseCase;
        GetAppLanguageUseCase getAppLanguageUseCase3 = getAppLanguageUseCase2;
        GetThirdPartyInitUseCase getThirdPartyInitUseCase3 = getThirdPartyInitUseCase2;
        GetRedirectionFlowUseCase getRedirectionFlowUseCase3 = getRedirectionFlowUseCase2;
        PresentationUtils presentationUtils3 = presentationUtils2;
        GetSplashPhaseOneUseCase getSplashPhaseOneUseCase3 = getSplashPhaseOneUseCase2;
        GetCurrentLocationUseCase getCurrentLocationUseCase3 = getCurrentLocationUseCase2;
        GetGpsStausUseCase getGpsStausUseCase2 = getGpsStausUseCase;
        GetLocationPermissionStatusUseCase getLocationPermissionStatusUseCase3 = getLocationPermissionStatusUseCase2;
        GetReverseGeoCodeCountryUseCase getReverseGeoCodeCountryUseCase3 = getReverseGeoCodeCountryUseCase2;
        GetDeviceDeepLinkUseCase getDeviceDeepLinkUseCase2 = getDeviceDeepLinkUseCase;
        GetDynamicSplashContentUseCase getDynamicSplashContentUseCase3 = getDynamicSplashContentUseCase2;
        Intrinsics.checkNotNullParameter(getAuthenticationTokenUseCase3, "getAuthenticationTokenUseCase");
        Intrinsics.checkNotNullParameter(getAppInfoUseCase3, "getAppInfoUseCase");
        Intrinsics.checkNotNullParameter(setAppConfigUseCase3, "setAppConfigUseCase");
        Intrinsics.checkNotNullParameter(getAppPreferncesUseCase2, "getAppPreferencesUseCase");
        Intrinsics.checkNotNullParameter(getAppLanguageUseCase3, "getAppLanguageUseCase");
        Intrinsics.checkNotNullParameter(getThirdPartyInitUseCase3, "getThirdPartyInitUseCase");
        Intrinsics.checkNotNullParameter(getRedirectionFlowUseCase3, "getRedirectionFlowUseCase");
        Intrinsics.checkNotNullParameter(presentationUtils3, "presentationUtils");
        Intrinsics.checkNotNullParameter(getSplashPhaseOneUseCase3, "getSplashPhaseOneUseCase");
        Intrinsics.checkNotNullParameter(getCurrentLocationUseCase3, "getCurrentLocationUseCase");
        Intrinsics.checkNotNullParameter(getGpsStausUseCase2, "getGpsStatusUseCase");
        Intrinsics.checkNotNullParameter(getLocationPermissionStatusUseCase3, "getLocationPermissionStatusUseCase");
        Intrinsics.checkNotNullParameter(getReverseGeoCodeCountryUseCase3, "getReverseGeoCodeCountryUseCase");
        Intrinsics.checkNotNullParameter(getDeviceDeepLinkUseCase2, "getDeepLinkFlow");
        Intrinsics.checkNotNullParameter(tracking2, "tracking");
        Intrinsics.checkNotNullParameter(getDynamicSplashContentUseCase2, "getDynamicSplashContentUseCase");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(splashConfig2, "splashConfig");
        Intrinsics.checkNotNullParameter(clearOwinStartupUseCase, "clearOwinUseCase");
        Intrinsics.checkNotNullParameter(isOnboardingExperimentEnabledUseCase, "isOnboardingExperimentEnabledUseCaseImpl");
        this.getAuthenticationTokenUseCase = getAuthenticationTokenUseCase3;
        this.getAppInfoUseCase = getAppInfoUseCase3;
        this.setAppConfigUseCase = setAppConfigUseCase3;
        this.getAppPreferencesUseCase = getAppPreferncesUseCase2;
        this.getAppLanguageUseCase = getAppLanguageUseCase3;
        this.getThirdPartyInitUseCase = getThirdPartyInitUseCase3;
        this.getRedirectionFlowUseCase = getRedirectionFlowUseCase3;
        this.presentationUtils = presentationUtils3;
        this.getSplashPhaseOneUseCase = getSplashPhaseOneUseCase3;
        this.getCurrentLocationUseCase = getCurrentLocationUseCase3;
        this.getGpsStatusUseCase = getGpsStausUseCase2;
        this.getLocationPermissionStatusUseCase = getLocationPermissionStatusUseCase3;
        this.getReverseGeoCodeCountryUseCase = getReverseGeoCodeCountryUseCase3;
        this.getDeepLinkFlow = getDeviceDeepLinkUseCase2;
        this.f61527tracking = tracking2;
        this.getDynamicSplashContentUseCase = getDynamicSplashContentUseCase2;
        this.configurationLocalRepository = mutableConfigurationLocalRepository;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.splashConfig = splashConfig2;
        this.clearOwinUseCase = clearOwinStartupUseCase;
        this.isOnboardingExperimentEnabledUseCaseImpl = isOnboardingExperimentEnabledUseCase;
    }

    private final void deepLinkRedirection() {
        LogManager.debug("deepLinkRedirection");
        this.mDeepLinkScreenRedirection.postValue(new Event(Boolean.TRUE));
    }

    private final void forceUpdateRedirection(String str) {
        LogManager.debug("forceUpdateRedirection");
        this.mAppForceUpdateRedirection.postValue(new Event(str));
    }

    /* access modifiers changed from: private */
    public final void handleSuccess(Object obj) {
        ScreenInfoWrapper screenInfoWrapper = (ScreenInfoWrapper) obj;
        this.screenInfo = screenInfoWrapper;
        this.mAppInfoReceived = true;
        if (this.mSplashFinished) {
            handleScreenRedirection(screenInfoWrapper);
        }
    }

    private final boolean isDeepLinkFlow(ScreenInfoWrapper screenInfoWrapper) {
        int flowType = screenInfoWrapper.getScreenType().getFlowType();
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        if (flowType == splashDataUtils.getDEEP_LINK_FLOW() || screenInfoWrapper.getScreenType().getFlowType() == splashDataUtils.getDIFFERED_DEEP_LINK_FLOW() || screenInfoWrapper.getScreenType().getFlowType() == splashDataUtils.getDIFFERED_DEEP_LINK_WITH_WELCOME()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isDynamicSplashEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_DYNAMIC_SPLASH, false);
    }

    /* access modifiers changed from: private */
    public final void legacySplashConfiguration(boolean z11) {
        SplashPhaseOneWrapper splashPhaseOneWrapper = (SplashPhaseOneWrapper) this.getSplashPhaseOneUseCase.invoke();
        if (splashPhaseOneWrapper.getViewType() == 0) {
            MutableLiveData<Event<SplashPhaseOneViewEntity>> mutableLiveData = this.mSplashViewPhaseWithImageOrVideo;
            Integer splashUIType = splashPhaseOneWrapper.getSplashUIType();
            Intrinsics.checkNotNull(splashUIType);
            int intValue = splashUIType.intValue();
            Boolean showCampaignLogo = splashPhaseOneWrapper.getShowCampaignLogo();
            Intrinsics.checkNotNull(showCampaignLogo);
            mutableLiveData.postValue(new Event(new SplashPhaseOneViewEntity(intValue, showCampaignLogo.booleanValue(), splashPhaseOneWrapper.getCampaignType())));
            return;
        }
        this.mSplashViewPhaseWithWelcome.postValue(new Event(new Pair(Boolean.TRUE, Boolean.valueOf(z11))));
    }

    /* access modifiers changed from: private */
    public final void loadDynamicContentForSplash(Function1<? super SplashContentDisplayModel, Unit> function1) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SplashActivitySharedViewModel$loadDynamicContentForSplash$1(this, function1, (Continuation<? super SplashActivitySharedViewModel$loadDynamicContentForSplash$1>) null), 3, (Object) null);
    }

    private final void normalRedirection(ScreenInfoWrapper screenInfoWrapper) {
        LogManager.debug("normalRedirection");
        MutableLiveData<Pair<ScreenInfoWrapper, Boolean>> mutableLiveData = this.screenInfoWrapperLiveData;
        Boolean value = this.showNotificationPermission.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        mutableLiveData.postValue(new Pair(screenInfoWrapper, value));
        PointOfInterestReporter.INSTANCE.endTraceLog(SectionOfInterest.SPLASH_ACTIVITY, PointOfInterest.APP_INFO_CALL);
    }

    public final boolean clearOwinTokenIfExists() {
        return this.clearOwinUseCase.invoke();
    }

    public final void deepLinkReceived(int i11, @Nullable Uri uri) {
        String str;
        this.deepLinkFlowType = ((DeepLinkRedirectionWrapper) this.getDeepLinkFlow.invoke(Integer.valueOf(i11))).getFlowType();
        this.deeplinkUri = uri;
        if (uri != null) {
            str = uri.getQuery();
        } else {
            str = null;
        }
        GlobalDataModel.setDeepLinksQuery(str);
        this.mSplashDeepLinReceived.postValue(new Event(Integer.valueOf(i11)));
    }

    @NotNull
    public final MutableLiveData<Integer> getAllowLocationButtonTextResId() {
        return this.allowLocationButtonTextResId;
    }

    public final void getAppPreferences() {
        if (this.getAppPreferencesUseCase.invoke()) {
            this.mAppPrefConfig.postValue(new Event(Boolean.TRUE));
        }
    }

    public final void getAuthenticationToken() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SplashActivitySharedViewModel$getAuthenticationToken$1(this, (Continuation<? super SplashActivitySharedViewModel$getAuthenticationToken$1>) null), 3, (Object) null);
    }

    public final void getCurrentLocationExistingUsers() {
        this.mFetchCurrentLocationExistingUsers.postValue(new Event(Boolean.TRUE));
    }

    public final int getDeepLinkFlowType() {
        return this.deepLinkFlowType;
    }

    @NotNull
    public final MutableLiveData<SplashContentDisplayModel> getDynamicSplashContent() {
        return this.dynamicSplashContent;
    }

    @NotNull
    public final MutableLiveData<GpsStatus> getGpsStatus() {
        return (MutableLiveData) this.getGpsStatusUseCase.invoke();
    }

    @NotNull
    public final MutableLiveData<CurrentLocationWrapper> getLocationData(int i11) {
        return (MutableLiveData) this.getCurrentLocationUseCase.invoke(Integer.valueOf(i11));
    }

    @NotNull
    public final MutableLiveData<PermissionStatus> getLocationPerMissionStatus() {
        return (MutableLiveData) this.getLocationPermissionStatusUseCase.invoke();
    }

    @NotNull
    public final String getLocationStatusTracking() {
        return this.locationStatusTracking;
    }

    @NotNull
    public final MutableLiveData<Event<Boolean>> getMAppBasicInfoConfig() {
        return this.mAppBasicInfoConfig;
    }

    @NotNull
    public final MutableLiveData<Event<String>> getMAppForceUpdateRedirection() {
        return this.mAppForceUpdateRedirection;
    }

    public final boolean getMAppInfoReceived() {
        return this.mAppInfoReceived;
    }

    @NotNull
    public final MutableLiveData<Boolean> getMAppLanguage() {
        return this.mAppLanguage;
    }

    @NotNull
    public final MutableLiveData<Event<Boolean>> getMAppPrefConfig() {
        return this.mAppPrefConfig;
    }

    @NotNull
    public final MutableLiveData<Event<Boolean>> getMDeepLinkScreenRedirection() {
        return this.mDeepLinkScreenRedirection;
    }

    @NotNull
    public final MutableLiveData<Event<Boolean>> getMFetchCurrentLocationExistingUsers() {
        return this.mFetchCurrentLocationExistingUsers;
    }

    @NotNull
    public final MutableLiveData<Event<Boolean>> getMGetAuthenticationToken() {
        return this.mGetAuthenticationToken;
    }

    @NotNull
    public final MutableLiveData<Event<Boolean>> getMShowLoadingAppInfo() {
        return this.mShowLoadingAppInfo;
    }

    @NotNull
    public final MutableLiveData<Event<Integer>> getMSplashDeepLinReceived() {
        return this.mSplashDeepLinReceived;
    }

    public final boolean getMSplashFinished() {
        return this.mSplashFinished;
    }

    @NotNull
    public final MutableLiveData<SplashRedirectionWrapper> getMSplashReDirection() {
        return this.mSplashReDirection;
    }

    @NotNull
    public final MutableLiveData<Event<SplashPhaseOneViewEntity>> getMSplashViewPhaseWithImageOrVideo() {
        return this.mSplashViewPhaseWithImageOrVideo;
    }

    @NotNull
    public final MutableLiveData<Event<Pair<Boolean, Boolean>>> getMSplashViewPhaseWithWelcome() {
        return this.mSplashViewPhaseWithWelcome;
    }

    @NotNull
    public final MutableLiveData<Boolean> getPlayVideoWithOverlay() {
        return this.playVideoWithOverlay;
    }

    public final void getReDirectionFlowType() {
        String str;
        GetRedirectionFlowUseCase getRedirectionFlowUseCase2 = this.getRedirectionFlowUseCase;
        int i11 = this.deepLinkFlowType;
        Uri uri = this.deeplinkUri;
        if (uri == null || (str = uri.getQuery()) == null) {
            str = "";
        }
        SplashRedirectionWrapper splashRedirectionWrapper = (SplashRedirectionWrapper) getRedirectionFlowUseCase2.invoke(new GetRedirectionFlowUseCase.Parameters(i11, str));
        if (splashRedirectionWrapper.getInitiateAppInfo()) {
            this.mSplashReDirection.postValue(splashRedirectionWrapper);
        }
    }

    @Nullable
    public final ScreenInfoWrapper getScreenInfo() {
        return this.screenInfo;
    }

    @NotNull
    public final MutableLiveData<Pair<ScreenInfoWrapper, Boolean>> getScreenInfoWrapperLiveData() {
        return this.screenInfoWrapperLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowNotificationPermission() {
        return this.showNotificationPermission;
    }

    public final void getSplashPhaseOne() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SplashActivitySharedViewModel$getSplashPhaseOne$1(this, (Continuation<? super SplashActivitySharedViewModel$getSplashPhaseOne$1>) null), 3, (Object) null);
    }

    public final void handleScreenRedirection(@Nullable ScreenInfoWrapper screenInfoWrapper) {
        if (screenInfoWrapper == null) {
            return;
        }
        if (Intrinsics.areEqual((Object) screenInfoWrapper.isForceUpdate(), (Object) Boolean.TRUE)) {
            forceUpdateRedirection(screenInfoWrapper.getForceUpdateMessage());
            return;
        }
        this.f61527tracking.onAppLaunchTracking(this.locationStatusTracking, this.deeplinkUri);
        new BackendExperimentsHelper((ITalabatExperiment) null, this.talabatFeatureFlag, 1, (DefaultConstructorMarker) null).fetchBackendExperimentsIfApplicable();
        if (isDeepLinkFlow(screenInfoWrapper)) {
            deepLinkRedirection();
        } else {
            normalRedirection(screenInfoWrapper);
        }
    }

    public final void iniThirdPartSDK() {
        this.getThirdPartyInitUseCase.invoke();
        this.splashConfig.init();
    }

    public final void initAppConfig() {
        if (this.setAppConfigUseCase.invoke()) {
            this.mAppBasicInfoConfig.postValue(new Event(Boolean.TRUE));
        }
    }

    public final void loadAppInfo(@Nullable SplashRedirectionWrapper splashRedirectionWrapper) {
        this.getAppInfoUseCase.invoke(new AppInfoRequestModel(GlobalDataModel.SelectedCountryId, splashRedirectionWrapper, false, 4, (DefaultConstructorMarker) null), new SplashActivitySharedViewModel$loadAppInfo$1(this));
    }

    public final void lottieAnimationFinished() {
        this.mSplashFinished = true;
        if (this.mAppInfoReceived) {
            handleScreenRedirection(this.screenInfo);
        }
    }

    public final void onDenyLocationRequest(@NotNull LocationRequestWrapper.LocationRequestDeny locationRequestDeny) {
        Intrinsics.checkNotNullParameter(locationRequestDeny, "locationRequestDeny");
        this.mSplashFinished = true;
        this.mSplashReDirection.postValue(new SplashRedirectionWrapper(true, SplashDataUtils.INSTANCE.getNORMAL_WELCOME_DENY_FLOW()));
        this.f61527tracking.onOtherLocationClicked();
    }

    public final void onLocationReceived(@NotNull CurrentLocationWrapper currentLocationWrapper) {
        Intrinsics.checkNotNullParameter(currentLocationWrapper, "locationWrapper");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SplashActivitySharedViewModel$onLocationReceived$1(currentLocationWrapper, this, (Continuation<? super SplashActivitySharedViewModel$onLocationReceived$1>) null), 3, (Object) null);
    }

    public final void onLocationRequestSuccess(@NotNull LocationRequestWrapper.LocationRequestSuccess locationRequestSuccess) {
        String str;
        Intrinsics.checkNotNullParameter(locationRequestSuccess, "locationRequestSuccess");
        this.mSplashFinished = true;
        this.mSplashReDirection.postValue(new SplashRedirectionWrapper(true, SplashDataUtils.INSTANCE.getNORMAL_WELCOME_SUCCESS_FLOW()));
        if (locationRequestSuccess.getLocationRequestStatus()) {
            str = TrackingUtils.TrackingGpsStatus.Enabled.getValue();
        } else {
            str = TrackingUtils.TrackingGpsStatus.Disabled.getValue();
        }
        this.locationStatusTracking = str;
        this.f61527tracking.geoLocationDialogStatus(locationRequestSuccess.getLocationRequestStatus(), this.locationStatusTracking);
        Tracking tracking2 = this.f61527tracking;
        Float locationAccuracy = locationRequestSuccess.getLocationAccuracy();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(locationAccuracy);
        tracking2.OngGeoLocationClickedFromLanding(sb2.toString(), locationRequestSuccess.getLocation());
    }

    public final void playVideo(boolean z11) {
        this.playVideoWithOverlay.postValue(Boolean.valueOf(z11));
    }

    public final void setAdjustAttribution() {
        if (GlobalDataModel.adjustAttribution == null) {
            GlobalDataModel.adjustAttribution = new AdjustAttribution();
        }
        AdjustAttribution attribution = Adjust.getAttribution();
        AdjustAttribution adjustAttribution = GlobalDataModel.adjustAttribution;
        if (adjustAttribution != null && attribution != null) {
            adjustAttribution.adgroup = attribution.adgroup;
            adjustAttribution.adid = attribution.adid;
            adjustAttribution.creative = attribution.creative;
            adjustAttribution.campaign = attribution.campaign;
            adjustAttribution.clickLabel = attribution.clickLabel;
            adjustAttribution.trackerToken = attribution.trackerToken;
            adjustAttribution.trackerName = attribution.trackerName;
            adjustAttribution.network = attribution.network;
        }
    }

    public final void setAppLanguage() {
        if (this.getAppLanguageUseCase.invoke()) {
            this.mAppLanguage.postValue(Boolean.TRUE);
            if (isDynamicSplashEnabled()) {
                FunWithFlags.setAppLanguage(this.configurationLocalRepository.selectedLanguage().getLanguageCode());
            }
            this.presentationUtils.changeLanguage();
        }
        this.f61527tracking.onAppboyAppOpened();
    }

    public final void setDeepLinkFlowType(int i11) {
        this.deepLinkFlowType = i11;
    }

    public final void setLocationStatusTracking(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.locationStatusTracking = str;
    }

    public final void setMAppBasicInfoConfig(@NotNull MutableLiveData<Event<Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mAppBasicInfoConfig = mutableLiveData;
    }

    public final void setMAppForceUpdateRedirection(@NotNull MutableLiveData<Event<String>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mAppForceUpdateRedirection = mutableLiveData;
    }

    public final void setMAppInfoReceived(boolean z11) {
        this.mAppInfoReceived = z11;
    }

    public final void setMAppLanguage(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mAppLanguage = mutableLiveData;
    }

    public final void setMAppPrefConfig(@NotNull MutableLiveData<Event<Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mAppPrefConfig = mutableLiveData;
    }

    public final void setMDeepLinkScreenRedirection(@NotNull MutableLiveData<Event<Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mDeepLinkScreenRedirection = mutableLiveData;
    }

    public final void setMFetchCurrentLocationExistingUsers(@NotNull MutableLiveData<Event<Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mFetchCurrentLocationExistingUsers = mutableLiveData;
    }

    public final void setMGetAuthenticationToken(@NotNull MutableLiveData<Event<Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mGetAuthenticationToken = mutableLiveData;
    }

    public final void setMShowLoadingAppInfo(@NotNull MutableLiveData<Event<Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mShowLoadingAppInfo = mutableLiveData;
    }

    public final void setMSplashDeepLinReceived(@NotNull MutableLiveData<Event<Integer>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mSplashDeepLinReceived = mutableLiveData;
    }

    public final void setMSplashFinished(boolean z11) {
        this.mSplashFinished = z11;
    }

    public final void setMSplashReDirection(@NotNull MutableLiveData<SplashRedirectionWrapper> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mSplashReDirection = mutableLiveData;
    }

    public final void setMSplashViewPhaseWithImageOrVideo(@NotNull MutableLiveData<Event<SplashPhaseOneViewEntity>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mSplashViewPhaseWithImageOrVideo = mutableLiveData;
    }

    public final void setMSplashViewPhaseWithWelcome(@NotNull MutableLiveData<Event<Pair<Boolean, Boolean>>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mSplashViewPhaseWithWelcome = mutableLiveData;
    }

    public final void setPlayVideoWithOverlay(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.playVideoWithOverlay = mutableLiveData;
    }

    public final void setScreenInfo(@Nullable ScreenInfoWrapper screenInfoWrapper) {
        this.screenInfo = screenInfoWrapper;
    }

    public final void setScreenInfoWrapperLiveData(@NotNull MutableLiveData<Pair<ScreenInfoWrapper, Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.screenInfoWrapperLiveData = mutableLiveData;
    }

    public final void setShowNotificationPermission(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.showNotificationPermission = mutableLiveData;
    }

    public final boolean shouldPreWarmCollectionsFlutterEngine() {
        return ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_FLUTTER_VL_COLLECTION, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null);
    }

    public final void showLoadingPopup() {
        MutableLiveData<Event<Boolean>> mutableLiveData = this.mShowLoadingAppInfo;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(new Event(Boolean.TRUE));
        }
    }

    public final void trackAppLaunchWithLocationStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appLaunchWithGpsLocationStatus");
        this.locationStatusTracking = str;
    }

    public final void videoPlayBackFinished() {
        this.mSplashFinished = true;
        if (this.mAppInfoReceived) {
            handleScreenRedirection(this.screenInfo);
        }
    }
}
