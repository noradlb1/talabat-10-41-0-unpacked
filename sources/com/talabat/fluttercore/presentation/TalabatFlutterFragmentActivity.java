package com.talabat.fluttercore.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import buisnessmodels.Customer;
import com.adjust.sdk.Adjust;
import com.braze.brazeplugin.BrazePlugin;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.flutter.ConfigurationRemoteCoreLibFlutterApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.data.address.AddressInfoMethodChannel;
import com.talabat.core.flutter.channels.data.legacydeeplink.LegacyDeeplinkNavigationMethodChannel;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibApi;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import com.talabat.core.fwf.data.FwfTrackingConstantsKt;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
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
import com.talabat.fluttercore.tracking.event.BrazeAddToCartEvent;
import com.talabat.location.SelectedLocationProviderImpl;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import datamodels.Country;
import datamodels.CustomerInfo;
import datamodels.MostRecentOrderList;
import io.flutter.FlutterInjector;
import io.flutter.embedding.android.FlutterFragmentActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;
import tracking.TalabatAppBoy;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000ø\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 ð\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002ð\u0001B\u0013\u0012\b\b\u0002\u0010\\\u001a\u00020[¢\u0006\u0006\bî\u0001\u0010ï\u0001J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010%\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H\u0002J,\u0010&\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\u0012\u0010)\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'H\u0014J\b\u0010*\u001a\u00020\bH\u0014J\u0010\u0010+\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0017J\b\u00101\u001a\u00020\bH\u0016J$\u00105\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00192\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020302H\u0016J,\u00106\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H\u0016J \u0010=\u001a\u0002092\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0016J \u0010?\u001a\u00020>2\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u00020>2\u0006\u0010<\u001a\u00020;H\u0016J \u0010A\u001a\u00020@2\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u00020@2\u0006\u0010<\u001a\u00020;H\u0016J \u0010B\u001a\u00020\u00192\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u00020\u00192\u0006\u0010<\u001a\u00020;H\u0016J\u0010\u0010E\u001a\u00020\b2\u0006\u0010D\u001a\u00020CH\u0016J*\u0010F\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#2\u0006\u0010\"\u001a\u00020\u0019J$\u0010H\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H\u0016J,\u0010I\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190#H\u0016J\b\u0010J\u001a\u00020\bH\u0014J\b\u0010K\u001a\u00020\u0019H&J\b\u0010M\u001a\u00020LH\u0016J\u0010\u0010N\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010Q\u001a\u00020@2\u0006\u0010P\u001a\u00020O2\u0006\u0010:\u001a\u00020@H\u0016JP\u0010U\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002030Sj\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u000203`T2\u0006\u0010R\u001a\u00020O2\"\u0010:\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002030Sj\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u000203`TH\u0016J&\u0010X\u001a\u0004\u0018\u00010\u00192\u0006\u0010V\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u00192\b\u0010W\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010Z\u001a\u00020\b2\u0006\u0010V\u001a\u00020\u00192\b\u0010Y\u001a\u0004\u0018\u00010\u00192\b\u0010W\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\\\u001a\u00020[8\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u001b\u0010r\u001a\u00020m8BX\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\"\u0010t\u001a\u00020s8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010{\u001a\u00020z8\u0004X\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R)\u0010\u0001\u001a\u000208\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b \u0001\u0010¡\u0001R*\u0010£\u0001\u001a\u00030¢\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R*\u0010ª\u0001\u001a\u00030©\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010­\u0001\"\u0006\b®\u0001\u0010¯\u0001R*\u0010±\u0001\u001a\u00030°\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R*\u0010¸\u0001\u001a\u00030·\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R*\u0010¿\u0001\u001a\u00030¾\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R*\u0010Æ\u0001\u001a\u00030Å\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R*\u0010Í\u0001\u001a\u00030Ì\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R*\u0010Ô\u0001\u001a\u00030Ó\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R \u0010Þ\u0001\u001a\u00030Ú\u00018BX\u0002¢\u0006\u000f\n\u0005\bÛ\u0001\u0010o\u001a\u0006\bÜ\u0001\u0010Ý\u0001R \u0010ã\u0001\u001a\u00030ß\u00018BX\u0002¢\u0006\u000f\n\u0005\bà\u0001\u0010o\u001a\u0006\bá\u0001\u0010â\u0001R \u0010è\u0001\u001a\u00030ä\u00018BX\u0002¢\u0006\u000f\n\u0005\bå\u0001\u0010o\u001a\u0006\bæ\u0001\u0010ç\u0001R \u0010í\u0001\u001a\u00030é\u00018BX\u0002¢\u0006\u000f\n\u0005\bê\u0001\u0010o\u001a\u0006\bë\u0001\u0010ì\u0001¨\u0006ñ\u0001"}, d2 = {"Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lio/flutter/embedding/android/FlutterFragmentActivity;", "Lcom/talabat/fluttercore/channels/GlobalMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/ObservabilityMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/ExperimentMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/FeatureFlagMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/SharedPreferencesMethodChannelCallback;", "", "detachFragmentActivityFromMethodChannels", "initDependencies", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterEngine", "setupConfigurationRemoteChannels", "setupConfigChannel", "setupAuthenticationChannel", "launchHomeScreen", "setupAnalyticsChannel", "setupObservabilityChannel", "setupNavigationChannel", "setupExperimentChannel", "setupMediaServicesChannel", "setupFeatureFlagChannel", "setupAddressInfoChannel", "setupSharedPreferencesChannel", "", "name", "Landroid/content/SharedPreferences;", "getSharedPreferences", "setUpSecretsChannel", "setUpDeeplinkNavigationChannel", "setUpQCommerceChannel", "setUpLegacyDeeplinkNavigationMethodChannel", "eventName", "featureName", "", "attributes", "trackOnNewRelic", "trackOnBraze", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onDestroy", "cleanUpFlutterEngine", "Landroid/content/Context;", "context", "provideFlutterEngine", "configureFlutterEngine", "setUpTestingChannels", "onBackPressedFromFlutter", "", "", "events", "logFlutterEvent", "track", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "experimentKey", "", "defaultValue", "Lcom/talabat/core/experiment/domain/TalabatExperimentDataSourceStrategy;", "strategy", "getIntVariant", "", "getDoubleVariant", "", "getBooleanVariant", "getStringVariant", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "event", "trackEvent", "trackOnGA", "explanation", "trackUnexpectedScenario", "observe", "onResume", "getRoute", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getEntryPoint", "setUpExtraChannels", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "featureFlagKey", "getFeatureFlag", "remoteConfigKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRemoteConfig", "key", "sharedPreferencesName", "getString", "value", "setString", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "talabatRemoteConfiguration", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "Lcom/talabat/fluttercore/channels/ExperimentMethodChannel;", "experimentMethodChannel", "Lcom/talabat/fluttercore/channels/ExperimentMethodChannel;", "Lcom/talabat/fluttercore/channels/ObservabilityMethodChannel;", "observabilityMethodChannel", "Lcom/talabat/fluttercore/channels/ObservabilityMethodChannel;", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel;", "analyticsMethodChannel", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannel;", "Lcom/talabat/fluttercore/channels/GlobalMethodChannel;", "globalMethodChannel", "Lcom/talabat/fluttercore/channels/GlobalMethodChannel;", "Lcom/talabat/fluttercore/channels/MobileServicesMethodChannel;", "mobileServicesMethodChannel", "Lcom/talabat/fluttercore/channels/MobileServicesMethodChannel;", "Lcom/talabat/core/flutter/channels/data/legacydeeplink/LegacyDeeplinkNavigationMethodChannel;", "legacyDeeplinkNavigationMethodChannel$delegate", "Lkotlin/Lazy;", "getLegacyDeeplinkNavigationMethodChannel", "()Lcom/talabat/core/flutter/channels/data/legacydeeplink/LegacyDeeplinkNavigationMethodChannel;", "legacyDeeplinkNavigationMethodChannel", "Ltracking/gtm/TalabatGTM$Companion;", "talabatGTM", "Ltracking/gtm/TalabatGTM$Companion;", "getTalabatGTM", "()Ltracking/gtm/TalabatGTM$Companion;", "setTalabatGTM", "(Ltracking/gtm/TalabatGTM$Companion;)V", "Lcom/talabat/fluttercore/channels/NavigationMethodChannel;", "navigationChannel", "Lcom/talabat/fluttercore/channels/NavigationMethodChannel;", "getNavigationChannel", "()Lcom/talabat/fluttercore/channels/NavigationMethodChannel;", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "getPaymentConfigurationRepository", "()Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "setPaymentConfigurationRepository", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;)V", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "termsAndConditionsConfigurationRepository", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "getTermsAndConditionsConfigurationRepository", "()Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "setTermsAndConditionsConfigurationRepository", "(Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;)V", "Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "addressInfoChannelCallback", "Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "getAddressInfoChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "setAddressInfoChannelCallback", "(Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;)V", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "walletConfigFlutterChannel", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "getWalletConfigFlutterChannel", "()Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "setWalletConfigFlutterChannel", "(Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;)V", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "getTrackingCoreLibApi", "()Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "setTrackingCoreLibApi", "(Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;)V", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "getExperimentCoreLibApi", "()Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "setExperimentCoreLibApi", "(Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;)V", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "getFeatureFlagCoreLibApi", "()Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "setFeatureFlagCoreLibApi", "(Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;)V", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "getObservabilityCoreLibApi", "()Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "setObservabilityCoreLibApi", "(Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;)V", "Lcom/talabat/flutter/secrets/domain/FlutterSecretsCoreLibApi;", "flutterSecretsCoreLibApi", "Lcom/talabat/flutter/secrets/domain/FlutterSecretsCoreLibApi;", "getFlutterSecretsCoreLibApi", "()Lcom/talabat/flutter/secrets/domain/FlutterSecretsCoreLibApi;", "setFlutterSecretsCoreLibApi", "(Lcom/talabat/flutter/secrets/domain/FlutterSecretsCoreLibApi;)V", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreLibApi;", "deeplinkNavigationChannelCoreLibApi", "Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreLibApi;", "getDeeplinkNavigationChannelCoreLibApi", "()Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreLibApi;", "setDeeplinkNavigationChannelCoreLibApi", "(Lcom/talabat/core/flutter/channels/domain/di/DeeplinkNavigationChannelCoreLibApi;)V", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "getNavigationCoreLibApi", "()Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "setNavigationCoreLibApi", "(Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;)V", "Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibApi;", "qCommerceMethodChannelFeatureLibApi", "Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibApi;", "getQCommerceMethodChannelFeatureLibApi", "()Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibApi;", "setQCommerceMethodChannelFeatureLibApi", "(Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibApi;)V", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "setCoroutineDispatchersFactory", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker$delegate", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatExperiment$delegate", "getTalabatExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatExperiment", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag$delegate", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag", "Lcom/talabat/core/navigation/domain/Navigator;", "navigator$delegate", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "navigator", "<init>", "(Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;)V", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0})
public abstract class TalabatFlutterFragmentActivity extends FlutterFragmentActivity implements GlobalMethodChannelCallback, AnalyticsMethodChannelCallback, ObservabilityMethodChannelCallback, ExperimentMethodChannelCallback, FeatureFlagMethodChannelCallback, SharedPreferencesMethodChannelCallback {
    @NotNull
    public static final String ADD_TO_CART_EVENT = "add_to_cart";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public AddressInfoChannelCallback addressInfoChannelCallback;
    @Nullable
    private AnalyticsMethodChannel analyticsMethodChannel;
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    public DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi;
    public ExperimentCoreLibApi experimentCoreLibApi;
    @Nullable
    private ExperimentMethodChannel experimentMethodChannel;
    public FeatureFlagCoreLibApi featureFlagCoreLibApi;
    public FlutterSecretsCoreLibApi flutterSecretsCoreLibApi;
    @Nullable
    private GlobalMethodChannel globalMethodChannel;
    @NotNull
    private final Lazy legacyDeeplinkNavigationMethodChannel$delegate;
    @Nullable
    private MobileServicesMethodChannel mobileServicesMethodChannel;
    @NotNull
    private final NavigationMethodChannel navigationChannel;
    public NavigationCoreLibApi navigationCoreLibApi;
    @NotNull
    private final Lazy navigator$delegate;
    public ObservabilityCoreLibApi observabilityCoreLibApi;
    @Nullable
    private ObservabilityMethodChannel observabilityMethodChannel;
    public PaymentConfigurationRepository paymentConfigurationRepository;
    public QCommerceMethodChannelFeatureLibApi qCommerceMethodChannelFeatureLibApi;
    @NotNull
    private final Lazy talabatExperiment$delegate;
    @NotNull
    private final Lazy talabatFeatureFlag$delegate;
    @NotNull
    private TalabatGTM.Companion talabatGTM;
    @NotNull
    private final RemoteConfiguration talabatRemoteConfiguration;
    @NotNull
    private final Lazy talabatTracker$delegate;
    public TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository;
    public TrackingCoreLibApi trackingCoreLibApi;
    public MethodChannel.MethodCallHandler walletConfigFlutterChannel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity$Companion;", "", "()V", "ADD_TO_CART_EVENT", "", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TalabatFlutterEntryPoints.values().length];
            iArr[TalabatFlutterEntryPoints.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TalabatFlutterFragmentActivity() {
        this((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    public TalabatFlutterFragmentActivity(@NotNull RemoteConfiguration remoteConfiguration) {
        Intrinsics.checkNotNullParameter(remoteConfiguration, "talabatRemoteConfiguration");
        this._$_findViewCache = new LinkedHashMap();
        this.talabatRemoteConfiguration = remoteConfiguration;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.legacyDeeplinkNavigationMethodChannel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TalabatFlutterFragmentActivity$legacyDeeplinkNavigationMethodChannel$2(this));
        this.talabatGTM = TalabatGTM.Companion;
        this.navigationChannel = new NavigationMethodChannel();
        this.talabatTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TalabatFlutterFragmentActivity$talabatTracker$2(this));
        this.talabatExperiment$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TalabatFlutterFragmentActivity$talabatExperiment$2(this));
        this.talabatFeatureFlag$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TalabatFlutterFragmentActivity$talabatFeatureFlag$2(this));
        this.navigator$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TalabatFlutterFragmentActivity$navigator$2(this));
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
        this.navigationChannel.setCallback((Activity) null);
        ObservabilityMethodChannel observabilityMethodChannel2 = this.observabilityMethodChannel;
        if (observabilityMethodChannel2 != null) {
            observabilityMethodChannel2.setCallback((ObservabilityMethodChannelCallback) null);
        }
        ExperimentMethodChannel experimentMethodChannel2 = this.experimentMethodChannel;
        if (experimentMethodChannel2 != null) {
            experimentMethodChannel2.setCallback((ExperimentMethodChannelCallback) null);
        }
    }

    private final LegacyDeeplinkNavigationMethodChannel getLegacyDeeplinkNavigationMethodChannel() {
        return (LegacyDeeplinkNavigationMethodChannel) this.legacyDeeplinkNavigationMethodChannel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Navigator getNavigator() {
        return (Navigator) this.navigator$delegate.getValue();
    }

    private final SharedPreferences getSharedPreferences(String str) {
        Context applicationContext = getApplicationContext();
        if (str == null) {
            str = SharedPreferencesManager.TALABAT_PREFERENCE;
        }
        return applicationContext.getSharedPreferences(str, 0);
    }

    private final ITalabatExperiment getTalabatExperiment() {
        return (ITalabatExperiment) this.talabatExperiment$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        return (ITalabatFeatureFlag) this.talabatFeatureFlag$delegate.getValue();
    }

    private final TalabatTracker getTalabatTracker() {
        return (TalabatTracker) this.talabatTracker$delegate.getValue();
    }

    private final void initDependencies() {
        Class cls = ConfigurationRemoteCoreLibApi.class;
        setPaymentConfigurationRepository(((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getPaymentConfigurationRepository());
        setWalletConfigFlutterChannel(((ConfigurationRemoteCoreLibFlutterApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibFlutterApi.class)).getWalletConfigFlutterChannel());
        setExperimentCoreLibApi((ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ExperimentCoreLibApi.class));
        setTrackingCoreLibApi((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TrackingCoreLibApi.class));
        setTermsAndConditionsConfigurationRepository(((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getTermsAndConditionsConfigurationRepository());
        setAddressInfoChannelCallback(((FlutterChannelsCoreImplLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FlutterChannelsCoreImplLibApi.class)).getAddressInfoChannelCallback());
        setFeatureFlagCoreLibApi((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class));
        setObservabilityCoreLibApi((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class));
        setFlutterSecretsCoreLibApi((FlutterSecretsCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FlutterSecretsCoreLibApi.class));
        setDeeplinkNavigationChannelCoreLibApi((DeeplinkNavigationChannelCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeeplinkNavigationChannelCoreLibApi.class));
        setNavigationCoreLibApi((NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class));
        setQCommerceMethodChannelFeatureLibApi((QCommerceMethodChannelFeatureLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(QCommerceMethodChannelFeatureLibApi.class));
        setCoroutineDispatchersFactory(((DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DispatcherCoreLibApi.class)).getCoroutineDispatchersFactory());
    }

    /* access modifiers changed from: private */
    public final void launchHomeScreen() {
        getNavigator().navigateTo(this, new HomeScreen(new HomeScreen.HomeScreenData((HomeScreen.NavigationTab) null, false, 3, (DefaultConstructorMarker) null)), TalabatFlutterFragmentActivity$launchHomeScreen$1.INSTANCE);
        finish();
    }

    private final void setUpDeeplinkNavigationChannel(FlutterEngine flutterEngine) {
        DeeplinkNavigationNativeDomain deeplinkNavigationNativeDomain = getDeeplinkNavigationChannelCoreLibApi().getDeeplinkNavigationNativeDomain();
        BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
        PlatformChannel.DefaultImpls.onAttachWithActivity$default(deeplinkNavigationNativeDomain, binaryMessenger, this, (Bundle) null, 4, (Object) null);
    }

    private final void setUpLegacyDeeplinkNavigationMethodChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.LEGACY_DEEPLINK_NAVIGATION_CHANNEL).setMethodCallHandler(getLegacyDeeplinkNavigationMethodChannel());
    }

    private final void setUpQCommerceChannel(FlutterEngine flutterEngine) {
        QCommerceChannelFlutterDomain qCommerceChannelFlutterDomain = getQCommerceMethodChannelFeatureLibApi().getQCommerceChannelFlutterDomain();
        BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
        PlatformChannel.DefaultImpls.onAttachWithActivity$default(qCommerceChannelFlutterDomain, binaryMessenger, this, (Bundle) null, 4, (Object) null);
    }

    private final void setUpSecretsChannel(FlutterEngine flutterEngine) {
        SecretsMethodCallHandler secretsMethodCallHandler = getFlutterSecretsCoreLibApi().secretsMethodCallHandler();
        BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterEngine.dartExecutor.binaryMessenger");
        secretsMethodCallHandler.onAttach(binaryMessenger);
    }

    private final void setupAddressInfoChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.ADDRESS_INFO_CHANNEL).setMethodCallHandler(new AddressInfoMethodChannel(getAddressInfoChannelCallback(), getObservabilityCoreLibApi().getObservabilityManager(), getCoroutineDispatchersFactory()));
    }

    private final void setupAnalyticsChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.ANALYTICS_CHANNEL);
        AnalyticsMethodChannel analyticsMethodChannel2 = new AnalyticsMethodChannel(getTrackingCoreLibApi().getFlutterMigrationTools());
        this.analyticsMethodChannel = analyticsMethodChannel2;
        analyticsMethodChannel2.setCallback(this);
        methodChannel.setMethodCallHandler(this.analyticsMethodChannel);
    }

    private final void setupAuthenticationChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.AUTHENTICATION_CHANNEL).setMethodCallHandler(new AuthenticationMethodChannel(((SecretCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(SecretCoreLibApi.class)).getSecretProvider(), ((TokenCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TokenCoreLibApi.class)).getTokenRepository(), ((TokenCoreLibDataApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TokenCoreLibDataApi.class)).getTokenFlutterMapper(), new TalabatFlutterFragmentActivity$setupAuthenticationChannel$1$1(this)));
    }

    private final void setupConfigChannel(FlutterEngine flutterEngine) {
        Class cls = ConfigurationRemoteCoreLibApi.class;
        AppVersionProvider appVersionProvider = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getAppVersionProvider();
        ConfigurationLocalRepository repository = ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
        LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getLocationConfigurationRepository();
        IObservabilityManager observabilityManager = ((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.CONFIG_CHANNEL);
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        GlobalMethodChannel globalMethodChannel2 = new GlobalMethodChannel(appVersionProvider, repository, locationConfigurationRepository, new SelectedLocationProviderImpl(instance), new DeviceIdProviderImpl(this), GoogleClientIdLocalStorage.INSTANCE, getPaymentConfigurationRepository(), getTermsAndConditionsConfigurationRepository(), observabilityManager);
        this.globalMethodChannel = globalMethodChannel2;
        globalMethodChannel2.setCallback(this);
        methodChannel.setMethodCallHandler(this.globalMethodChannel);
    }

    private final void setupConfigurationRemoteChannels(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.CONFIGURATION_REMOTE_WALLET_CHANNEL).setMethodCallHandler(getWalletConfigFlutterChannel());
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
        FeatureFlagMethodChannel featureFlagMethodChannel = new FeatureFlagMethodChannel(getObservabilityCoreLibApi().getObservabilityManager());
        featureFlagMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(featureFlagMethodChannel);
    }

    private final void setupMediaServicesChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.MEDIA_SERVICES_CHANNEL);
        MobileServicesMethodChannel mobileServicesMethodChannel2 = new MobileServicesMethodChannel(AndroidComponentsKt.apiContainer((Activity) this));
        this.mobileServicesMethodChannel = mobileServicesMethodChannel2;
        methodChannel.setMethodCallHandler(mobileServicesMethodChannel2);
    }

    private final void setupNavigationChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.NAVIGATION_CHANNEL);
        this.navigationChannel.setCallback(this);
        methodChannel.setMethodCallHandler(this.navigationChannel);
    }

    private final void setupObservabilityChannel(FlutterEngine flutterEngine) {
        IScreenTracker screenTracker = getObservabilityCoreLibApi().getScreenTracker();
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.OBSERVABILITY_CHANNEL);
        ObservabilityMethodChannel observabilityMethodChannel2 = new ObservabilityMethodChannel(this, screenTracker);
        this.observabilityMethodChannel = observabilityMethodChannel2;
        methodChannel.setMethodCallHandler(observabilityMethodChannel2);
    }

    private final void setupSharedPreferencesChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.NATIVE_SHARED_PREFERENCES_CHANNEL);
        SharedPreferencesMethodChannel sharedPreferencesMethodChannel = new SharedPreferencesMethodChannel();
        sharedPreferencesMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(sharedPreferencesMethodChannel);
    }

    private final void trackOnBraze(String str, Map<String, String> map, String str2) {
        if (Intrinsics.areEqual((Object) str, (Object) "add_to_cart")) {
            getTalabatTracker().track(new BrazeAddToCartEvent(TalabatAppBoy.EVENT_NAME_ADD_TO_BASKET, str2, map));
        }
    }

    private final void trackOnNewRelic(String str, String str2, Map<String, String> map) {
        ObservabilityManager.track(str, str2, map);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void cleanUpFlutterEngine(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        if (((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag().getFeatureFlag(PlatformFeatureFlagsKeys.EXTEND_ENGINES_DESTRUCTION, false)) {
            try {
                Result.Companion companion = Result.Companion;
                FlutterPlugin flutterPlugin = flutterEngine.getPlugins().get(BrazePlugin.class);
                if (flutterPlugin != null) {
                    ((BrazePlugin) flutterPlugin).onDetachedFromActivity();
                    Result.m6329constructorimpl(Unit.INSTANCE);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.braze.brazeplugin.BrazePlugin");
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public void configureFlutterEngine(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setupAuthenticationChannel(flutterEngine);
        setupConfigurationRemoteChannels(flutterEngine);
        setupConfigChannel(flutterEngine);
        setupAnalyticsChannel(flutterEngine);
        setupNavigationChannel(flutterEngine);
        setupObservabilityChannel(flutterEngine);
        setupExperimentChannel(flutterEngine);
        if (Intrinsics.areEqual((Object) TalabatEnvironment.INSTANCE.getEnvironment(), (Object) "mock")) {
            setUpTestingChannels(flutterEngine);
        }
        setUpExtraChannels(flutterEngine);
        setupFeatureFlagChannel(flutterEngine);
        setupAddressInfoChannel(flutterEngine);
        setupSharedPreferencesChannel(flutterEngine);
        setUpSecretsChannel(flutterEngine);
        setUpDeeplinkNavigationChannel(flutterEngine);
        setUpQCommerceChannel(flutterEngine);
        setUpLegacyDeeplinkNavigationMethodChannel(flutterEngine);
    }

    @NotNull
    public final AddressInfoChannelCallback getAddressInfoChannelCallback() {
        AddressInfoChannelCallback addressInfoChannelCallback2 = this.addressInfoChannelCallback;
        if (addressInfoChannelCallback2 != null) {
            return addressInfoChannelCallback2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addressInfoChannelCallback");
        return null;
    }

    public boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getTalabatExperiment().getBooleanVariant(fWFKey, z11, talabatExperimentDataSourceStrategy);
    }

    @NotNull
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        CoroutineDispatchersFactory coroutineDispatchersFactory2 = this.coroutineDispatchersFactory;
        if (coroutineDispatchersFactory2 != null) {
            return coroutineDispatchersFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineDispatchersFactory");
        return null;
    }

    @NotNull
    public final DeeplinkNavigationChannelCoreLibApi getDeeplinkNavigationChannelCoreLibApi() {
        DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi2 = this.deeplinkNavigationChannelCoreLibApi;
        if (deeplinkNavigationChannelCoreLibApi2 != null) {
            return deeplinkNavigationChannelCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deeplinkNavigationChannelCoreLibApi");
        return null;
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

    @NotNull
    public final ExperimentCoreLibApi getExperimentCoreLibApi() {
        ExperimentCoreLibApi experimentCoreLibApi2 = this.experimentCoreLibApi;
        if (experimentCoreLibApi2 != null) {
            return experimentCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("experimentCoreLibApi");
        return null;
    }

    public boolean getFeatureFlag(@NotNull FWFKeyObject fWFKeyObject, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKeyObject, FwfTrackingConstantsKt.AB_GROUP_HOLDOUT_FEATURE_FLAG_KEY);
        return getTalabatFeatureFlag().getFeatureFlag(fWFKeyObject, z11);
    }

    @NotNull
    public final FeatureFlagCoreLibApi getFeatureFlagCoreLibApi() {
        FeatureFlagCoreLibApi featureFlagCoreLibApi2 = this.featureFlagCoreLibApi;
        if (featureFlagCoreLibApi2 != null) {
            return featureFlagCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagCoreLibApi");
        return null;
    }

    @NotNull
    public final FlutterSecretsCoreLibApi getFlutterSecretsCoreLibApi() {
        FlutterSecretsCoreLibApi flutterSecretsCoreLibApi2 = this.flutterSecretsCoreLibApi;
        if (flutterSecretsCoreLibApi2 != null) {
            return flutterSecretsCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flutterSecretsCoreLibApi");
        return null;
    }

    public int getIntVariant(@NotNull FWFKey fWFKey, int i11, @NotNull TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(talabatExperimentDataSourceStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return getTalabatExperiment().getIntVariant(fWFKey, i11, talabatExperimentDataSourceStrategy);
    }

    @NotNull
    public final NavigationCoreLibApi getNavigationCoreLibApi() {
        NavigationCoreLibApi navigationCoreLibApi2 = this.navigationCoreLibApi;
        if (navigationCoreLibApi2 != null) {
            return navigationCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigationCoreLibApi");
        return null;
    }

    @NotNull
    public final ObservabilityCoreLibApi getObservabilityCoreLibApi() {
        ObservabilityCoreLibApi observabilityCoreLibApi2 = this.observabilityCoreLibApi;
        if (observabilityCoreLibApi2 != null) {
            return observabilityCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityCoreLibApi");
        return null;
    }

    @NotNull
    public final PaymentConfigurationRepository getPaymentConfigurationRepository() {
        PaymentConfigurationRepository paymentConfigurationRepository2 = this.paymentConfigurationRepository;
        if (paymentConfigurationRepository2 != null) {
            return paymentConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentConfigurationRepository");
        return null;
    }

    @NotNull
    public final QCommerceMethodChannelFeatureLibApi getQCommerceMethodChannelFeatureLibApi() {
        QCommerceMethodChannelFeatureLibApi qCommerceMethodChannelFeatureLibApi2 = this.qCommerceMethodChannelFeatureLibApi;
        if (qCommerceMethodChannelFeatureLibApi2 != null) {
            return qCommerceMethodChannelFeatureLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qCommerceMethodChannelFeatureLibApi");
        return null;
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

    @NotNull
    public final TalabatGTM.Companion getTalabatGTM() {
        return this.talabatGTM;
    }

    @NotNull
    public final TermsAndConditionsConfigurationRepository getTermsAndConditionsConfigurationRepository() {
        TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2 = this.termsAndConditionsConfigurationRepository;
        if (termsAndConditionsConfigurationRepository2 != null) {
            return termsAndConditionsConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("termsAndConditionsConfigurationRepository");
        return null;
    }

    @NotNull
    public final TrackingCoreLibApi getTrackingCoreLibApi() {
        TrackingCoreLibApi trackingCoreLibApi2 = this.trackingCoreLibApi;
        if (trackingCoreLibApi2 != null) {
            return trackingCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("trackingCoreLibApi");
        return null;
    }

    @NotNull
    public final MethodChannel.MethodCallHandler getWalletConfigFlutterChannel() {
        MethodChannel.MethodCallHandler methodCallHandler = this.walletConfigFlutterChannel;
        if (methodCallHandler != null) {
            return methodCallHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("walletConfigFlutterChannel");
        return null;
    }

    public void logFlutterEvent(@NotNull String str, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "events");
        this.talabatGTM.logFlutterEvents(this, str, map);
    }

    public void observe(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        ObservabilityManager.track(str, str2, map);
    }

    public void onBackPressedFromFlutter(@NotNull Object obj) {
        GlobalMethodChannelCallback.DefaultImpls.onBackPressedFromFlutter(this, obj);
    }

    public void onCreate(@Nullable Bundle bundle) {
        initDependencies();
        super.onCreate(bundle);
    }

    public void onDestroy() {
        detachFragmentActivityFromMethodChannels();
        try {
            Result.Companion companion = Result.Companion;
            super.onDestroy();
            Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public void onResume() {
        super.onResume();
        Adjust.onResume();
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

    public final void setAddressInfoChannelCallback(@NotNull AddressInfoChannelCallback addressInfoChannelCallback2) {
        Intrinsics.checkNotNullParameter(addressInfoChannelCallback2, "<set-?>");
        this.addressInfoChannelCallback = addressInfoChannelCallback2;
    }

    public final void setCoroutineDispatchersFactory(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "<set-?>");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    public final void setDeeplinkNavigationChannelCoreLibApi(@NotNull DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi2) {
        Intrinsics.checkNotNullParameter(deeplinkNavigationChannelCoreLibApi2, "<set-?>");
        this.deeplinkNavigationChannelCoreLibApi = deeplinkNavigationChannelCoreLibApi2;
    }

    public final void setExperimentCoreLibApi(@NotNull ExperimentCoreLibApi experimentCoreLibApi2) {
        Intrinsics.checkNotNullParameter(experimentCoreLibApi2, "<set-?>");
        this.experimentCoreLibApi = experimentCoreLibApi2;
    }

    public final void setFeatureFlagCoreLibApi(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
        Intrinsics.checkNotNullParameter(featureFlagCoreLibApi2, "<set-?>");
        this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
    }

    public final void setFlutterSecretsCoreLibApi(@NotNull FlutterSecretsCoreLibApi flutterSecretsCoreLibApi2) {
        Intrinsics.checkNotNullParameter(flutterSecretsCoreLibApi2, "<set-?>");
        this.flutterSecretsCoreLibApi = flutterSecretsCoreLibApi2;
    }

    public final void setNavigationCoreLibApi(@NotNull NavigationCoreLibApi navigationCoreLibApi2) {
        Intrinsics.checkNotNullParameter(navigationCoreLibApi2, "<set-?>");
        this.navigationCoreLibApi = navigationCoreLibApi2;
    }

    public final void setObservabilityCoreLibApi(@NotNull ObservabilityCoreLibApi observabilityCoreLibApi2) {
        Intrinsics.checkNotNullParameter(observabilityCoreLibApi2, "<set-?>");
        this.observabilityCoreLibApi = observabilityCoreLibApi2;
    }

    public final void setPaymentConfigurationRepository(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "<set-?>");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }

    public final void setQCommerceMethodChannelFeatureLibApi(@NotNull QCommerceMethodChannelFeatureLibApi qCommerceMethodChannelFeatureLibApi2) {
        Intrinsics.checkNotNullParameter(qCommerceMethodChannelFeatureLibApi2, "<set-?>");
        this.qCommerceMethodChannelFeatureLibApi = qCommerceMethodChannelFeatureLibApi2;
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

    public final void setTalabatGTM(@NotNull TalabatGTM.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<set-?>");
        this.talabatGTM = companion;
    }

    public final void setTermsAndConditionsConfigurationRepository(@NotNull TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(termsAndConditionsConfigurationRepository2, "<set-?>");
        this.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository2;
    }

    public final void setTrackingCoreLibApi(@NotNull TrackingCoreLibApi trackingCoreLibApi2) {
        Intrinsics.checkNotNullParameter(trackingCoreLibApi2, "<set-?>");
        this.trackingCoreLibApi = trackingCoreLibApi2;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
    }

    @Deprecated(message = "Don't override this method. It's open for backwards compatibility.Provide api mocks through setDispatcher/setDefaultDispatcher in HookSetup")
    public void setUpTestingChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        FlutterTestingInitializer.INSTANCE.setUp(flutterEngine);
    }

    public final void setWalletConfigFlutterChannel(@NotNull MethodChannel.MethodCallHandler methodCallHandler) {
        Intrinsics.checkNotNullParameter(methodCallHandler, "<set-?>");
        this.walletConfigFlutterChannel = methodCallHandler;
    }

    public void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        trackOnGA(str, map, str2);
        trackOnNewRelic(str, str2, map);
        if (!getTalabatFeatureFlag().getFeatureFlag(PlatformFeatureFlagsKeys.BRAZE_FLUTTER_SDK, false)) {
            trackOnBraze(str, map, str2);
        }
    }

    public void trackEvent(@NotNull TalabatEvent talabatEvent) {
        Intrinsics.checkNotNullParameter(talabatEvent, "event");
        getTalabatTracker().track(talabatEvent);
    }

    public final void trackOnGA(@NotNull String str, @NotNull Map<String, String> map, @NotNull String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(str2, "featureName");
        if (Intrinsics.areEqual((Object) str, (Object) "helpcentre_link_clicked")) {
            MostRecentOrderList mostRecentOrderList = new MostRecentOrderList();
            mostRecentOrderList.encryptedOrderId = map.get("transactionId");
            TalabatGTM.Companion companion = this.talabatGTM;
            String str4 = map.get("screenName");
            if (str4 == null) {
                str3 = str2;
            } else {
                str3 = str4;
            }
            companion.onHelpcentreLinkClicked(this, mostRecentOrderList, "help_center", str3, str2, map.get("contactOption"));
        } else if (!Intrinsics.areEqual((Object) str, (Object) "screen_opened")) {
            this.talabatGTM.logFlutterEvents(this, str, MapsKt__MapsKt.toMutableMap(map));
        } else if (Intrinsics.areEqual((Object) "help_center", (Object) str2)) {
            TalabatGTM.Companion companion2 = this.talabatGTM;
            String str5 = map.get("screenName");
            if (str5 != null) {
                str2 = str5;
            }
            companion2.pushOpenScreenEvent(this, str2, (Country) null, (CustomerInfo) null);
        } else {
            this.talabatGTM.logFlutterEvents(this, str, MapsKt__MapsKt.toMutableMap(map));
        }
    }

    public void trackUnexpectedScenario(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "explanation");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        ObservabilityManager.trackUnExpectedScenario(str, map);
    }

    public void onBackPressedFromFlutter() {
        onBackPressed();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TalabatFlutterFragmentActivity(RemoteConfiguration remoteConfiguration, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? RemoteConfiguration.INSTANCE : remoteConfiguration);
    }
}
