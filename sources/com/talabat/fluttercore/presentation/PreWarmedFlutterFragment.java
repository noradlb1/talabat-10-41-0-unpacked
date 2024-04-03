package com.talabat.fluttercore.presentation;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import buisnessmodels.Customer;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.data.legacydeeplink.LegacyDeeplinkNavigationMethodChannel;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibApi;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import com.talabat.core.fwf.data.FwfTrackingConstantsKt;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.home.HomeScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.data.googleclientid.GoogleClientIdLocalStorage;
import com.talabat.flutter.secrets.domain.FlutterSecretsCoreLibApi;
import com.talabat.flutter.secrets.domain.handler.SecretsMethodCallHandler;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.fluttercore.channels.AnalyticsMethodChannelCallback;
import com.talabat.fluttercore.channels.AuthenticationMethodChannel;
import com.talabat.fluttercore.channels.ExperimentMethodChannel;
import com.talabat.fluttercore.channels.ExperimentMethodChannelCallback;
import com.talabat.fluttercore.channels.FeatureFlagMethodChannelCallback;
import com.talabat.fluttercore.channels.GlobalMethodChannel;
import com.talabat.fluttercore.channels.GlobalMethodChannelCallback;
import com.talabat.fluttercore.channels.MobileServicesMethodChannel;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.fluttercore.channels.ObservabilityMethodChannel;
import com.talabat.fluttercore.channels.ObservabilityMethodChannelCallback;
import com.talabat.fluttercore.channels.SharedPreferencesMethodChannel;
import com.talabat.fluttercore.channels.SharedPreferencesMethodChannelCallback;
import com.talabat.fluttercore.channels.dto.FeatureFlagMethodChannel;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.test.FlutterTestingInitializer;
import com.talabat.lib.Integration;
import com.talabat.location.SelectedLocationProviderImpl;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.FlutterInjector;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u001b\u0012\u0006\u0010Q\u001a\u00020\u0016\u0012\b\b\u0002\u0010T\u001a\u00020S¢\u0006\u0006\b\u0001\u0010\u0001J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0015J\b\u0010%\u001a\u00020\bH\u0016J,\u0010*\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160(H\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016J$\u00101\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00162\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/0.H\u0016J\b\u00102\u001a\u00020\u0016H&J\b\u00104\u001a\u000203H\u0016J\u0010\u00105\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u00106\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160(H\u0016J$\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160(H\u0016J \u0010?\u001a\u00020;2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=H\u0016J \u0010A\u001a\u00020@2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020@2\u0006\u0010>\u001a\u00020=H\u0016J \u0010C\u001a\u00020B2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020B2\u0006\u0010>\u001a\u00020=H\u0016J \u0010D\u001a\u00020\u00162\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020\u00162\u0006\u0010>\u001a\u00020=H\u0016J\u0018\u0010G\u001a\u00020B2\u0006\u0010F\u001a\u00020E2\u0006\u0010<\u001a\u00020BH\u0016JP\u0010K\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/0Ij\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/`J2\u0006\u0010H\u001a\u00020E2\"\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/0Ij\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/`JH\u0016J&\u0010N\u001a\u0004\u0018\u00010\u00162\u0006\u0010L\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010\u00162\b\u0010M\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010P\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u00162\b\u0010O\u001a\u0004\u0018\u00010\u00162\b\u0010M\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010Q\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001b\u0010p\u001a\u00020k8BX\u0002¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\u001b\u0010u\u001a\u00020q8BX\u0002¢\u0006\f\n\u0004\br\u0010m\u001a\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020v8BX\u0002¢\u0006\f\n\u0004\bw\u0010m\u001a\u0004\bx\u0010yR\u001b\u0010\u001a\u00020{8BX\u0002¢\u0006\f\n\u0004\b|\u0010m\u001a\u0004\b}\u0010~R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010m\u001a\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010m\u001a\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010m\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "Lio/flutter/embedding/android/FlutterFragment;", "Lcom/talabat/fluttercore/channels/GlobalMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/ObservabilityMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/ExperimentMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/FeatureFlagMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/SharedPreferencesMethodChannelCallback;", "", "detachFragmentActivityFromMethodChannels", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterEngine", "setupConfigChannel", "setupAuthenticationChannel", "launchHomeScreen", "setupExperimentChannel", "setupAnalyticsChannel", "setupNavigationChannel", "setupObservabilityChannel", "setupFeatureFlagChannel", "setupMediaServicesChannel", "setupSharedPreferencesChannel", "", "name", "Landroid/content/SharedPreferences;", "getSharedPreferences", "setupFlutterSecretsMethodChannel", "setupDeeplinkNavigationMethodChannel", "setUpQCommerceChannel", "setUpLegacyDeeplinkNavigationMethodChannel", "Landroid/content/Context;", "context", "onAttach", "onDestroy", "provideFlutterEngine", "configureFlutterEngine", "k0", "onBackPressedFromFlutter", "eventName", "featureName", "", "attributes", "track", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "event", "trackEvent", "", "", "events", "logFlutterEvent", "getRoute", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getEntryPoint", "setUpExtraChannels", "observe", "explanation", "trackUnexpectedScenario", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "experimentKey", "", "defaultValue", "Lcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;", "strategy", "getIntVariant", "", "getDoubleVariant", "", "getBooleanVariant", "getStringVariant", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "featureFlagKey", "getFeatureFlag", "remoteConfigKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRemoteConfig", "key", "sharedPreferencesName", "getString", "value", "setString", "engineId", "Ljava/lang/String;", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "talabatRemoteConfiguration", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "Lcom/talabat/fluttercore/channels/GlobalMethodChannel;", "globalMethodChannel", "Lcom/talabat/fluttercore/channels/GlobalMethodChannel;", "Lcom/talabat/fluttercore/channels/ExperimentMethodChannel;", "experimentMethodChannel", "Lcom/talabat/fluttercore/channels/ExperimentMethodChannel;", "Lcom/talabat/fluttercore/channels/dto/FeatureFlagMethodChannel;", "featureFlagMethodChannel", "Lcom/talabat/fluttercore/channels/dto/FeatureFlagMethodChannel;", "Lcom/talabat/fluttercore/channels/ObservabilityMethodChannel;", "observabilityMethodChannel", "Lcom/talabat/fluttercore/channels/ObservabilityMethodChannel;", "Lcom/talabat/fluttercore/channels/NavigationMethodChannel;", "navigationChannel", "Lcom/talabat/fluttercore/channels/NavigationMethodChannel;", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel;", "analyticsMethodChannel", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel;", "Lcom/talabat/fluttercore/channels/MobileServicesMethodChannel;", "mobileServicesMethodChannel", "Lcom/talabat/fluttercore/channels/MobileServicesMethodChannel;", "Lcom/talabat/core/flutter/channels/data/legacydeeplink/LegacyDeeplinkNavigationMethodChannel;", "legacyDeeplinkNavigationMethodChannel$delegate", "Lkotlin/Lazy;", "getLegacyDeeplinkNavigationMethodChannel", "()Lcom/talabat/core/flutter/channels/data/legacydeeplink/LegacyDeeplinkNavigationMethodChannel;", "legacyDeeplinkNavigationMethodChannel", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatExperiment$delegate", "getTalabatExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatExperiment", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker$delegate", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "talabatObservability$delegate", "getTalabatObservability", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "talabatObservability", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag$delegate", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "screenTracker$delegate", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "screenTracker", "Lcom/talabat/core/navigation/domain/Navigator;", "navigator$delegate", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "navigator", "<init>", "(Ljava/lang/String;Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;)V", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0})
public abstract class PreWarmedFlutterFragment extends FlutterFragment implements GlobalMethodChannelCallback, AnalyticsMethodChannelCallback, ObservabilityMethodChannelCallback, ExperimentMethodChannelCallback, FeatureFlagMethodChannelCallback, SharedPreferencesMethodChannelCallback {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    private AnalyticsMethodChannel analyticsMethodChannel;
    @NotNull
    private final String engineId;
    @Nullable
    private ExperimentMethodChannel experimentMethodChannel;
    @Nullable
    private FeatureFlagMethodChannel featureFlagMethodChannel;
    @Nullable
    private GlobalMethodChannel globalMethodChannel;
    @NotNull
    private final Lazy legacyDeeplinkNavigationMethodChannel$delegate;
    @Nullable
    private MobileServicesMethodChannel mobileServicesMethodChannel;
    @Nullable
    private NavigationMethodChannel navigationChannel;
    @NotNull
    private final Lazy navigator$delegate;
    @Nullable
    private ObservabilityMethodChannel observabilityMethodChannel;
    @NotNull
    private final Lazy screenTracker$delegate;
    @NotNull
    private final Lazy talabatExperiment$delegate;
    @NotNull
    private final Lazy talabatFeatureFlag$delegate;
    @NotNull
    private final Lazy talabatObservability$delegate;
    @NotNull
    private final RemoteConfiguration talabatRemoteConfiguration;
    @NotNull
    private final Lazy talabatTracker$delegate;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TalabatFlutterEntryPoints.values().length];
            iArr[TalabatFlutterEntryPoints.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PreWarmedFlutterFragment(@NotNull String str, @NotNull RemoteConfiguration remoteConfiguration) {
        Intrinsics.checkNotNullParameter(str, "engineId");
        Intrinsics.checkNotNullParameter(remoteConfiguration, "talabatRemoteConfiguration");
        this._$_findViewCache = new LinkedHashMap();
        this.engineId = str;
        this.talabatRemoteConfiguration = remoteConfiguration;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.legacyDeeplinkNavigationMethodChannel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PreWarmedFlutterFragment$legacyDeeplinkNavigationMethodChannel$2(this));
        this.talabatExperiment$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PreWarmedFlutterFragment$talabatExperiment$2(this));
        this.talabatTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PreWarmedFlutterFragment$talabatTracker$2(this));
        this.talabatObservability$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PreWarmedFlutterFragment$talabatObservability$2(this));
        this.talabatFeatureFlag$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PreWarmedFlutterFragment$talabatFeatureFlag$2(this));
        this.screenTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PreWarmedFlutterFragment$screenTracker$2(this));
        this.navigator$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new PreWarmedFlutterFragment$navigator$2(this));
    }

    private final void detachFragmentActivityFromMethodChannels() {
        GlobalMethodChannel globalMethodChannel2 = this.globalMethodChannel;
        if (globalMethodChannel2 != null) {
            globalMethodChannel2.setCallback((GlobalMethodChannelCallback) null);
        }
        AnalyticsMethodChannel analyticsMethodChannel2 = this.analyticsMethodChannel;
        if (analyticsMethodChannel2 != null) {
            analyticsMethodChannel2.setCallback((AnalyticsMethodChannelCallback) null);
        }
        NavigationMethodChannel navigationMethodChannel = this.navigationChannel;
        if (navigationMethodChannel != null) {
            navigationMethodChannel.setCallback((Activity) null);
        }
        ObservabilityMethodChannel observabilityMethodChannel2 = this.observabilityMethodChannel;
        if (observabilityMethodChannel2 != null) {
            observabilityMethodChannel2.setCallback((ObservabilityMethodChannelCallback) null);
        }
        ExperimentMethodChannel experimentMethodChannel2 = this.experimentMethodChannel;
        if (experimentMethodChannel2 != null) {
            experimentMethodChannel2.setCallback((ExperimentMethodChannelCallback) null);
        }
        FeatureFlagMethodChannel featureFlagMethodChannel2 = this.featureFlagMethodChannel;
        if (featureFlagMethodChannel2 != null) {
            featureFlagMethodChannel2.setCallback((FeatureFlagMethodChannelCallback) null);
        }
    }

    private final LegacyDeeplinkNavigationMethodChannel getLegacyDeeplinkNavigationMethodChannel() {
        return (LegacyDeeplinkNavigationMethodChannel) this.legacyDeeplinkNavigationMethodChannel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Navigator getNavigator() {
        return (Navigator) this.navigator$delegate.getValue();
    }

    private final IScreenTracker getScreenTracker() {
        return (IScreenTracker) this.screenTracker$delegate.getValue();
    }

    private final SharedPreferences getSharedPreferences(String str) {
        Application appContext = Integration.getAppContext();
        if (str == null) {
            str = SharedPreferencesManager.TALABAT_PREFERENCE;
        }
        return appContext.getSharedPreferences(str, 0);
    }

    private final ITalabatExperiment getTalabatExperiment() {
        return (ITalabatExperiment) this.talabatExperiment$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        return (ITalabatFeatureFlag) this.talabatFeatureFlag$delegate.getValue();
    }

    private final IObservabilityManager getTalabatObservability() {
        return (IObservabilityManager) this.talabatObservability$delegate.getValue();
    }

    private final TalabatTracker getTalabatTracker() {
        return (TalabatTracker) this.talabatTracker$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void launchHomeScreen() {
        Navigator navigator = getNavigator();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        navigator.navigateTo(context, new HomeScreen(new HomeScreen.HomeScreenData((HomeScreen.NavigationTab) null, false, 3, (DefaultConstructorMarker) null)), PreWarmedFlutterFragment$launchHomeScreen$1.INSTANCE);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void setUpLegacyDeeplinkNavigationMethodChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.LEGACY_DEEPLINK_NAVIGATION_CHANNEL).setMethodCallHandler(getLegacyDeeplinkNavigationMethodChannel());
    }

    private final void setUpQCommerceChannel(FlutterEngine flutterEngine) {
        QCommerceChannelFlutterDomain qCommerceChannelFlutterDomain = ((QCommerceMethodChannelFeatureLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(QCommerceMethodChannelFeatureLibApi.class)).getQCommerceChannelFlutterDomain();
        BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PlatformChannel.DefaultImpls.onAttachWithActivity$default(qCommerceChannelFlutterDomain, binaryMessenger, requireActivity, (Bundle) null, 4, (Object) null);
    }

    private final void setupAnalyticsChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.ANALYTICS_CHANNEL);
        AnalyticsMethodChannel analyticsMethodChannel2 = new AnalyticsMethodChannel(((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class)).getFlutterMigrationTools());
        this.analyticsMethodChannel = analyticsMethodChannel2;
        analyticsMethodChannel2.setCallback(this);
        methodChannel.setMethodCallHandler(this.analyticsMethodChannel);
    }

    private final void setupAuthenticationChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.AUTHENTICATION_CHANNEL).setMethodCallHandler(new AuthenticationMethodChannel(((SecretCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SecretCoreLibApi.class)).getSecretProvider(), ((TokenCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TokenCoreLibApi.class)).getTokenRepository(), ((TokenCoreLibDataApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TokenCoreLibDataApi.class)).getTokenFlutterMapper(), new PreWarmedFlutterFragment$setupAuthenticationChannel$1$1(this)));
    }

    private final void setupConfigChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.CONFIG_CHANNEL);
        Class cls = ConfigurationRemoteCoreLibApi.class;
        AppVersionProvider appVersionProvider = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(cls)).getAppVersionProvider();
        ConfigurationLocalRepository repository = ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
        LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(cls)).getLocationConfigurationRepository();
        PaymentConfigurationRepository paymentConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(cls)).getPaymentConfigurationRepository();
        TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(cls)).getTermsAndConditionsConfigurationRepository();
        IObservabilityManager observabilityManager = ((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        GlobalMethodChannel globalMethodChannel2 = new GlobalMethodChannel(appVersionProvider, repository, locationConfigurationRepository, new SelectedLocationProviderImpl(instance), new DeviceIdProviderImpl(Integration.getAppContext()), GoogleClientIdLocalStorage.INSTANCE, paymentConfigurationRepository, termsAndConditionsConfigurationRepository, observabilityManager);
        this.globalMethodChannel = globalMethodChannel2;
        globalMethodChannel2.setCallback(this);
        methodChannel.setMethodCallHandler(this.globalMethodChannel);
    }

    private final void setupDeeplinkNavigationMethodChannel(FlutterEngine flutterEngine) {
        DeeplinkNavigationNativeDomain deeplinkNavigationNativeDomain = ((DeeplinkNavigationChannelCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeeplinkNavigationChannelCoreLibApi.class)).getDeeplinkNavigationNativeDomain();
        BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PlatformChannel.DefaultImpls.onAttachWithActivity$default(deeplinkNavigationNativeDomain, binaryMessenger, requireActivity, (Bundle) null, 4, (Object) null);
    }

    private final void setupExperimentChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.EXPERIMENT_CHANNEL);
        ExperimentMethodChannel experimentMethodChannel2 = new ExperimentMethodChannel();
        this.experimentMethodChannel = experimentMethodChannel2;
        experimentMethodChannel2.setCallback(this);
        methodChannel.setMethodCallHandler(this.experimentMethodChannel);
    }

    private final void setupFeatureFlagChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.FEATURE_FLAG_CHANNEL);
        FeatureFlagMethodChannel featureFlagMethodChannel2 = new FeatureFlagMethodChannel(getTalabatObservability());
        this.featureFlagMethodChannel = featureFlagMethodChannel2;
        featureFlagMethodChannel2.setCallback(this);
        methodChannel.setMethodCallHandler(this.featureFlagMethodChannel);
    }

    private final void setupFlutterSecretsMethodChannel(FlutterEngine flutterEngine) {
        SecretsMethodCallHandler secretsMethodCallHandler = ((FlutterSecretsCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FlutterSecretsCoreLibApi.class)).secretsMethodCallHandler();
        BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
        secretsMethodCallHandler.onAttach(binaryMessenger);
    }

    private final void setupMediaServicesChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.MEDIA_SERVICES_CHANNEL);
        MobileServicesMethodChannel mobileServicesMethodChannel2 = new MobileServicesMethodChannel(AndroidComponentsKt.apiContainer((Fragment) this));
        this.mobileServicesMethodChannel = mobileServicesMethodChannel2;
        methodChannel.setMethodCallHandler(mobileServicesMethodChannel2);
    }

    private final void setupNavigationChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.NAVIGATION_CHANNEL);
        NavigationMethodChannel navigationMethodChannel = new NavigationMethodChannel();
        this.navigationChannel = navigationMethodChannel;
        navigationMethodChannel.setCallback(requireActivity());
        methodChannel.setMethodCallHandler(this.navigationChannel);
    }

    private final void setupObservabilityChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.OBSERVABILITY_CHANNEL);
        ObservabilityMethodChannel observabilityMethodChannel2 = new ObservabilityMethodChannel(this, getScreenTracker());
        this.observabilityMethodChannel = observabilityMethodChannel2;
        methodChannel.setMethodCallHandler(observabilityMethodChannel2);
    }

    private final void setupSharedPreferencesChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.NATIVE_SHARED_PREFERENCES_CHANNEL);
        SharedPreferencesMethodChannel sharedPreferencesMethodChannel = new SharedPreferencesMethodChannel();
        sharedPreferencesMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(sharedPreferencesMethodChannel);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void configureFlutterEngine(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setupAuthenticationChannel(flutterEngine);
        setupConfigChannel(flutterEngine);
        setupAnalyticsChannel(flutterEngine);
        setupNavigationChannel(flutterEngine);
        setupObservabilityChannel(flutterEngine);
        setupExperimentChannel(flutterEngine);
        setupFeatureFlagChannel(flutterEngine);
        setupMediaServicesChannel(flutterEngine);
        if (Intrinsics.areEqual((Object) TalabatEnvironment.INSTANCE.getEnvironment(), (Object) "mock")) {
            k0(flutterEngine);
        }
        setupSharedPreferencesChannel(flutterEngine);
        setupFlutterSecretsMethodChannel(flutterEngine);
        setupDeeplinkNavigationMethodChannel(flutterEngine);
        setUpQCommerceChannel(flutterEngine);
        setUpLegacyDeeplinkNavigationMethodChannel(flutterEngine);
        setUpExtraChannels(flutterEngine);
    }

    public boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getTalabatExperiment().getBooleanVariant(fWFKey, z11, talabatExperimentDataSourceStrategy);
    }

    public double getDoubleVariant(@NotNull FWFKey fWFKey, double d11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getTalabatExperiment().getDoubleVariant(fWFKey, d11, talabatExperimentDataSourceStrategy);
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.DEFAULT;
    }

    public boolean getFeatureFlag(@NotNull FWFKeyObject fWFKeyObject, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKeyObject, FwfTrackingConstantsKt.AB_GROUP_HOLDOUT_FEATURE_FLAG_KEY);
        return getTalabatFeatureFlag().getFeatureFlag(fWFKeyObject, z11);
    }

    public int getIntVariant(@NotNull FWFKey fWFKey, int i11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getTalabatExperiment().getIntVariant(fWFKey, i11, talabatExperimentDataSourceStrategy);
    }

    @NotNull
    public HashMap<String, Object> getRemoteConfig(@NotNull FWFKeyObject fWFKeyObject, @NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(fWFKeyObject, "remoteConfigKey");
        Intrinsics.checkNotNullParameter(hashMap, "defaultValue");
        return (HashMap) this.talabatRemoteConfiguration.getRemoteConfiguration(fWFKeyObject, hashMap, new HashMap().getClass());
    }

    @NotNull
    public abstract String getRoute();

    @Nullable
    public String getString(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences sharedPreferences = getSharedPreferences(str3);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, str2);
        }
        return null;
    }

    @NotNull
    public String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getTalabatExperiment().getStringVariant(fWFKey, str, talabatExperimentDataSourceStrategy);
    }

    @Deprecated(message = "Don't override this method. It's open for backwards compatibility.Provide api mocks through setDispatcher/setDefaultDispatcher in HookSetup")
    public void k0(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        FlutterTestingInitializer.INSTANCE.setUp(flutterEngine);
    }

    public void logFlutterEvent(@NotNull String str, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "events");
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.logFlutterEvents(requireContext, str, map);
    }

    public void observe(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        getTalabatObservability().track(str, str2, map);
    }

    public void onAttach(@NotNull Context context) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle arguments = getArguments();
        if (arguments != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            arguments = null;
        }
        if (arguments == null) {
            arguments = new Bundle();
        }
        setArguments(arguments);
        super.onAttach(context);
    }

    public void onBackPressedFromFlutter(@NotNull Object obj) {
        GlobalMethodChannelCallback.DefaultImpls.onBackPressedFromFlutter(this, obj);
    }

    public void onDestroy() {
        PlatformViewsController platformViewsController;
        FlutterEngine flutterEngine = getFlutterEngine();
        if (!(flutterEngine == null || (platformViewsController = flutterEngine.getPlatformViewsController()) == null)) {
            platformViewsController.onDetachedFromJNI();
        }
        detachFragmentActivityFromMethodChannels();
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onSetBottomNavigation(boolean z11) {
        GlobalMethodChannelCallback.DefaultImpls.onSetBottomNavigation(this, z11);
    }

    @Nullable
    public FlutterEngine provideFlutterEngine(@NotNull Context context) {
        DartExecutor.DartEntrypoint dartEntrypoint;
        Intrinsics.checkNotNullParameter(context, "context");
        FlutterEngine flutterEngine = new FlutterEngine(context);
        flutterEngine.getNavigationChannel().setInitialRoute(getRoute());
        TalabatFlutterEntryPoints entryPoint = getEntryPoint();
        if (WhenMappings.$EnumSwitchMapping$0[entryPoint.ordinal()] == 1) {
            dartEntrypoint = DartExecutor.DartEntrypoint.createDefault();
            Intrinsics.checkNotNullExpressionValue(dartEntrypoint, "createDefault()");
        } else {
            dartEntrypoint = new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), entryPoint.getValue());
        }
        flutterEngine.getDartExecutor().executeDartEntrypoint(dartEntrypoint);
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        return flutterEngine;
    }

    public void setString(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences sharedPreferences = getSharedPreferences(str3);
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString(str, str2)) != null) {
            putString.commit();
        }
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
    }

    public void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        trackEvent(new PreWarmedFlutterFragment$track$event$1(str, str2, map));
    }

    public void trackEvent(@NotNull TalabatEvent talabatEvent) {
        Intrinsics.checkNotNullParameter(talabatEvent, "event");
        getTalabatTracker().track(talabatEvent);
    }

    public void trackUnexpectedScenario(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "explanation");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        getTalabatObservability().trackUnExpectedScenario(str, map);
    }

    public void onBackPressedFromFlutter() {
        onBackPressed();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreWarmedFlutterFragment(String str, RemoteConfiguration remoteConfiguration, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? RemoteConfiguration.INSTANCE : remoteConfiguration);
    }
}
