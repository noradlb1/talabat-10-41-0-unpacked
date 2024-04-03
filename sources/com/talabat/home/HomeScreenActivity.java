package com.talabat.home;

import JsonModels.parser.UniversalGson;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelLazy;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_bottom_sheet_v2.DSFragmentManagerExtensionsKt;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_fixed_footer.DSBaseFixedFooter;
import com.designsystem.ds_fixed_footer.DSFixedFooterWithVerticalButtons;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.FirebaseUserActions;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Actions;
import com.google.firebase.appindexing.builders.DigitalDocumentBuilder;
import com.google.firebase.appindexing.builders.Indexables;
import com.google.gson.Gson;
import com.integration.IntegrationGlobalDataModel;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.CartScreen;
import com.talabat.ChooseSavedAddressScreen;
import com.talabat.HomeScreenMap;
import com.talabat.R;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt;
import com.talabat.core.flutter.binding.presentation.DeeplinkFlutterFragment;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallbackHandler;
import com.talabat.core.flutter.channels.domain.home.HomeChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.home.HomeChannelProvider;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallbackHandler;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.killswitch.KillSwitchFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.menu.MenuExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.search.SearchFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.home.HomeScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.activecarts.presentation.BasketListActivity;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.model.DarkstoreNavigationType;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.rating.domain.repo.RatingSession;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.feature.tpro.presentation.benefits.SubscriptionBenefitsDeeplinkBuilder;
import com.talabat.feature.tpro.presentation.util.SubscriptionSharedPrefManager;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModel;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModelFactory;
import com.talabat.fluid.homescreen.domain.tracking.events.replacementbottomsheet.ItemReplacementBottomSheetTracker;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.fluid.homescreen.domain.usecase.application.StopHomeScreenTraceUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import com.talabat.fluid.homescreen.presentation.displaymodel.Component;
import com.talabat.fluid.homescreen.presentation.displaymodel.ItemType;
import com.talabat.fluid.homescreen.presentation.displaymodel.NavigationType;
import com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper;
import com.talabat.fluid.homescreen.presentation.mapper.EntryPointItem;
import com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapper;
import com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapperKt;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import com.talabat.fluid.homescreen.ui.bottomsheet.ItemReplacementBottomSheetBodyFragment;
import com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment;
import com.talabat.fluid.homescreen.ui.integration.FluidHomeScreenIntegrable;
import com.talabat.fluid.homescreen.ui.widget.gem.GemExpirationCallback;
import com.talabat.flutter.FoodListFlutterActivity;
import com.talabat.flutter.HomeSearchFlutterFragment;
import com.talabat.flutter.usecase.AvailableVerticalsUseCase;
import com.talabat.flutter.usecase.ShowMoreInHomeSearchUseCase;
import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.gem.IntegrationKt;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.OrderTrackingNavigator;
import com.talabat.helpers.PermissionManager;
import com.talabat.helpers.PermissionManagerKt;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.cache.EventsCache;
import com.talabat.home.di.DaggerHomeScreenActivityComponent;
import com.talabat.home.di.HomeScreenActivityComponent;
import com.talabat.home.navigation.NavigationEventStack;
import com.talabat.home.tracking.vouchers.VoucherBadgeEventSource;
import com.talabat.home.tracking.vouchers.VouchersNotificationBadgeTracker;
import com.talabat.home.useraccount.UserAccountFragment;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.homescreen.HomeScreenFragmentInteractionListener;
import com.talabat.homescreen.OnFragmentInteractionListener;
import com.talabat.homescreen.adapter.model.banner.BannerAdItem;
import com.talabat.homescreen.adapter.model.order_tracking.OrderTrackingItem;
import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import com.talabat.homescreen.utils.HomeScreenTracker;
import com.talabat.homescreen.widget.HomeScreenHeaderView;
import com.talabat.mapper.RestaurantMapper;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.localTracer.PointOfInterest;
import com.talabat.observability.localTracer.PointOfInterestReporter;
import com.talabat.observability.localTracer.SectionOfInterest;
import com.talabat.observability.performance.PerformanceTracker;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.rating.presenter.OrderRatingPresenter;
import com.talabat.screenrecorder.ScreenRecorder;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import cs.a;
import cs.b;
import cs.c;
import cs.d;
import cs.e;
import cs.f;
import cs.g;
import cs.h;
import cs.i;
import datamodels.CustomerInfo;
import datamodels.Restaurant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import library.talabat.SharedPreferencesManager;
import library.talabat.mvp.home.HomeView;
import library.talabat.mvp.home.IHomePresenter;
import library.talabat.mvp.home.IsNfvFlutterNavigationUsecase;
import library.talabat.mvp.home.VoucherNotificationStyle;
import library.talabat.mvp.home.VoucherStateDomainModel;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.homemap.HomeMapUtils;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tracking.AppTracker;
import tracking.GoogleAdvertisingIdClientHelper;
import tracking.ScreenNames;
import tracking.TalabatAdjust;
import tracking.deeplink.AppIndexingEngine;
import tracking.deeplink.IDeepLinkPresenter;
import tracking.deeplink.WebAppMapping;

@Instrumented
@Metadata(d1 = {"\u0000°\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ü\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002ü\u0003B\u0005¢\u0006\u0002\u0010\nJ\u0014\u0010í\u0001\u001a\u00030î\u00012\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0016J\n\u0010ñ\u0001\u001a\u00030ò\u0001H\u0002J7\u0010ó\u0001\u001a\u00030î\u00012\u0007\u0010ô\u0001\u001a\u00020b2\u0007\u0010õ\u0001\u001a\u00020b2\u0007\u0010ö\u0001\u001a\u00020b2\u0007\u0010÷\u0001\u001a\u00020b2\u0007\u0010ø\u0001\u001a\u00020bH\u0002JA\u0010ù\u0001\u001a\u00030î\u00012\b\u0010ú\u0001\u001a\u00030û\u00012\u0007\u0010ô\u0001\u001a\u00020b2\u0007\u0010õ\u0001\u001a\u00020b2\u0007\u0010ö\u0001\u001a\u00020b2\u0007\u0010÷\u0001\u001a\u00020b2\u0007\u0010ø\u0001\u001a\u00020bH\u0002J#\u0010ü\u0001\u001a\u00030î\u00012\u0007\u0010ý\u0001\u001a\u00020z2\u000e\u0010þ\u0001\u001a\t\u0012\u0004\u0012\u00020z0æ\u0001H\u0016J\u001b\u0010ÿ\u0001\u001a\u00030î\u00012\u000f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020æ\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030î\u00012\u0007\u0010\u0002\u001a\u00020bH\u0002J\n\u0010\u0002\u001a\u00030î\u0001H\u0002J\u0012\u0010\u0002\u001a\u00020b2\u0007\u0010ý\u0001\u001a\u00020zH\u0016J\n\u0010\u0002\u001a\u00030î\u0001H\u0002J\n\u0010\u0002\u001a\u00030î\u0001H\u0016J\n\u0010\u0002\u001a\u00030î\u0001H\u0002J\u0012\u0010\u0002\u001a\u00030î\u00012\u0006\u0010#\u001a\u00020$H\u0016J \u0010\u0002\u001a\u00030î\u00012\u0014\u0010\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J&\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u0002J/\u0010\u0002\u001a\u00030\u00022\b\u0010ú\u0001\u001a\u00030û\u00012\u0007\u0010ô\u0001\u001a\u00020b2\u0007\u0010õ\u0001\u001a\u00020b2\u0007\u0010ø\u0001\u001a\u00020bH\u0002J(\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u0002H\u0002J \u0010\u0002\u001a\u00030\u00022\u0014\u0010\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J\u0013\u0010\u0002\u001a\u00030î\u00012\u0007\u0010\u0002\u001a\u00020zH\u0002J\u0014\u0010\u0002\u001a\u00030î\u00012\b\u0010\u0002\u001a\u00030 \u0002H\u0016J\n\u0010¡\u0002\u001a\u00030î\u0001H\u0016J\u0001\u0010¢\u0002\u001a\u00030î\u00012\u0001\u0010£\u0002\u001a\u0001\u0012\u0016\u0012\u00140b¢\u0006\u000f\b¥\u0002\u0012\n\b¦\u0002\u0012\u0005\b\b(§\u0002\u0012\u0016\u0012\u00140b¢\u0006\u000f\b¥\u0002\u0012\n\b¦\u0002\u0012\u0005\b\b(¨\u0002\u0012\u0016\u0012\u00140b¢\u0006\u000f\b¥\u0002\u0012\n\b¦\u0002\u0012\u0005\b\b(©\u0002\u0012\u0016\u0012\u00140b¢\u0006\u000f\b¥\u0002\u0012\n\b¦\u0002\u0012\u0005\b\b(ª\u0002\u0012\u0016\u0012\u00140b¢\u0006\u000f\b¥\u0002\u0012\n\b¦\u0002\u0012\u0005\b\b(ø\u0001\u0012\u0005\u0012\u00030î\u00010¤\u0002H\u0002J\n\u0010«\u0002\u001a\u00030î\u0001H\u0002J\b\u0010¬\u0002\u001a\u00030­\u0002J\u0019\u0010®\u0002\u001a\u0012\u0012\u0004\u0012\u00020z\u0012\u0005\u0012\u00030¯\u0002\u0018\u00010\u0002H\u0016J\t\u0010°\u0002\u001a\u00020zH\u0002J\n\u0010±\u0002\u001a\u00030²\u0002H\u0002J\u000b\u0010³\u0002\u001a\u0004\u0018\u00010gH\u0016J\t\u0010´\u0002\u001a\u00020zH\u0016J\t\u0010µ\u0002\u001a\u00020zH\u0016J\u000b\u0010¶\u0002\u001a\u0004\u0018\u00010zH\u0002J\u0014\u0010·\u0002\u001a\u00030î\u00012\b\u0010¸\u0002\u001a\u00030¹\u0002H\u0016J)\u0010º\u0002\u001a\u00030î\u00012\u0007\u0010»\u0002\u001a\u00020z2\u0014\u0010¼\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J*\u0010½\u0002\u001a\u00030î\u00012\u0007\u0010¾\u0002\u001a\u00020z2\u0015\u0010¼\u0002\u001a\u0010\u0012\u0004\u0012\u00020z\u0012\u0005\u0012\u00030¯\u00020\u0002H\u0016J)\u0010¿\u0002\u001a\u00030î\u00012\u0007\u0010»\u0002\u001a\u00020z2\u0014\u0010¼\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J5\u0010À\u0002\u001a\u00030î\u00012\n\u0010Á\u0002\u001a\u0005\u0018\u00010Â\u00022\u0007\u0010»\u0002\u001a\u00020z2\u0014\u0010¼\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J \u0010Ã\u0002\u001a\u00030î\u00012\u0014\u0010¼\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J\u0016\u0010Ä\u0002\u001a\u00030î\u00012\n\u0010Å\u0002\u001a\u0005\u0018\u00010Æ\u0002H\u0002J\u0013\u0010Ä\u0002\u001a\u00030î\u00012\u0007\u0010\u0002\u001a\u00020zH\u0016J)\u0010Ç\u0002\u001a\u00030î\u00012\u0014\u0010¼\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u00022\u0007\u0010»\u0002\u001a\u00020zH\u0002J)\u0010È\u0002\u001a\u00030î\u00012\u0007\u0010»\u0002\u001a\u00020z2\u0014\u0010¼\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J)\u0010É\u0002\u001a\u00030î\u00012\u0014\u0010¼\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u00022\u0007\u0010»\u0002\u001a\u00020zH\u0002J\u0013\u0010Ê\u0002\u001a\u00030î\u00012\u0007\u0010»\u0002\u001a\u00020zH\u0002J\u0013\u0010Ë\u0002\u001a\u00030î\u00012\u0007\u0010»\u0002\u001a\u00020zH\u0002J\u0013\u0010Ì\u0002\u001a\u00030î\u00012\u0007\u0010»\u0002\u001a\u00020zH\u0002J \u0010Í\u0002\u001a\u00030î\u00012\u0014\u0010¼\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J\u0013\u0010Î\u0002\u001a\u00030î\u00012\u0007\u0010»\u0002\u001a\u00020zH\u0002J\u0016\u0010Ï\u0002\u001a\u00030î\u00012\n\u0010Ð\u0002\u001a\u0005\u0018\u00010Ñ\u0002H\u0002J2\u0010Ò\u0002\u001a\u00030î\u00012\u0007\u0010Ó\u0002\u001a\u00020b2\u0007\u0010\u0002\u001a\u00020b2\u0014\u0010\u0002\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0016J\u0013\u0010Ô\u0002\u001a\u00030î\u00012\u0007\u0010»\u0002\u001a\u00020zH\u0002J\n\u0010Õ\u0002\u001a\u00030î\u0001H\u0016J\n\u0010Ö\u0002\u001a\u00030î\u0001H\u0016J\n\u0010×\u0002\u001a\u00030î\u0001H\u0016J\n\u0010Ø\u0002\u001a\u00030î\u0001H\u0016J\u0014\u0010Ù\u0002\u001a\u00030î\u00012\b\u0010Ú\u0002\u001a\u00030Û\u0002H\u0002J\n\u0010Ü\u0002\u001a\u00030î\u0001H\u0002J\n\u0010Ý\u0002\u001a\u00030î\u0001H\u0002J\n\u0010Þ\u0002\u001a\u00030î\u0001H\u0002J\t\u0010ß\u0002\u001a\u00020bH\u0016J\t\u0010à\u0002\u001a\u00020bH\u0002J\t\u0010õ\u0001\u001a\u00020bH\u0002J\t\u0010ô\u0001\u001a\u00020bH\u0002J\t\u0010á\u0002\u001a\u00020bH\u0002J\t\u0010ø\u0001\u001a\u00020bH\u0002J\t\u0010ö\u0001\u001a\u00020bH\u0002J\t\u0010â\u0002\u001a\u00020bH\u0002J\t\u0010ã\u0002\u001a\u00020bH\u0002J\t\u0010ä\u0002\u001a\u00020bH\u0016J\u001d\u0010å\u0002\u001a\u00030î\u00012\u0007\u0010å\u0002\u001a\u00020b2\b\u0010\u0002\u001a\u00030 \u0002H\u0016J.\u0010æ\u0002\u001a\u00030î\u00012\b\u0010ç\u0002\u001a\u00030Ë\u00012\u0007\u0010è\u0002\u001a\u00020z2\u000f\u0010é\u0002\u001a\n\u0012\u0005\u0012\u00030Ë\u00010ê\u0002H\u0016J\u0014\u0010ë\u0002\u001a\u00030î\u00012\b\u0010\u0002\u001a\u00030 \u0002H\u0016J\n\u0010ì\u0002\u001a\u00030î\u0001H\u0002J\n\u0010í\u0002\u001a\u00030î\u0001H\u0002J\n\u0010î\u0002\u001a\u00030î\u0001H\u0002J\n\u0010ï\u0002\u001a\u00030î\u0001H\u0002J\u0013\u0010ð\u0002\u001a\u00030î\u00012\u0007\u0010ñ\u0002\u001a\u00020bH\u0016J\n\u0010ò\u0002\u001a\u00030î\u0001H\u0002J\n\u0010ó\u0002\u001a\u00030î\u0001H\u0002J*\u0010ô\u0002\u001a\u00030î\u00012\b\u0010õ\u0002\u001a\u00030Ë\u00012\b\u0010ö\u0002\u001a\u00030Ë\u00012\n\u0010÷\u0002\u001a\u0005\u0018\u00010Ñ\u0002H\u0014J\n\u0010ø\u0002\u001a\u00030î\u0001H\u0016J\n\u0010ù\u0002\u001a\u00030î\u0001H\u0016J\u0014\u0010ú\u0002\u001a\u00030î\u00012\b\u0010û\u0002\u001a\u00030ü\u0002H\u0016J\u001f\u0010ý\u0002\u001a\u00030î\u00012\b\u0010û\u0002\u001a\u00030ü\u00022\t\u0010þ\u0002\u001a\u0004\u0018\u00010zH\u0002J\u0016\u0010ÿ\u0002\u001a\u00030î\u00012\n\u0010\u0003\u001a\u0005\u0018\u00010Æ\u0002H\u0014J)\u0010\u0003\u001a\u00030î\u00012\n\u0010\u0003\u001a\u0005\u0018\u00010 \u00022\u0007\u0010\u0003\u001a\u00020b2\b\u0010\u0003\u001a\u00030\u0003H\u0016J\u001e\u0010\u0003\u001a\u00030î\u00012\b\u0010\u0002\u001a\u00030 \u00022\b\u0010\u0003\u001a\u00030\u0003H\u0016J\n\u0010\u0003\u001a\u00030î\u0001H\u0016J\u0014\u0010\u0003\u001a\u00030î\u00012\b\u0010\u0003\u001a\u00030\u0003H\u0016J\n\u0010\u0003\u001a\u00030î\u0001H\u0016J\u0014\u0010\u0003\u001a\u00030î\u00012\b\u0010\u0003\u001a\u00030\u0003H\u0016J\n\u0010\u0003\u001a\u00030î\u0001H\u0016J\u0013\u0010\u0003\u001a\u00030î\u00012\u0007\u0010\u0003\u001a\u00020bH\u0016J\u001f\u0010\u0003\u001a\u00030î\u00012\u0007\u0010\u0003\u001a\u00020e2\n\u0010\u0003\u001a\u0005\u0018\u00010Æ\u0002H\u0016J\u001f\u0010\u0003\u001a\u00030î\u00012\u0007\u0010\u0003\u001a\u00020e2\n\u0010\u0003\u001a\u0005\u0018\u00010Æ\u0002H\u0016J\u0014\u0010\u0003\u001a\u00030î\u00012\b\u0010Ú\u0002\u001a\u00030Û\u0002H\u0002J\n\u0010\u0003\u001a\u00030î\u0001H\u0016J%\u0010\u0003\u001a\u00030î\u00012\u0007\u0010\u0003\u001a\u00020z2\u0007\u0010\u0003\u001a\u00020z2\u0007\u0010\u0002\u001a\u00020zH\u0016J\n\u0010\u0003\u001a\u00030î\u0001H\u0016J\u0011\u0010\u0003\u001a\u00030î\u00012\u0007\u0010\u0003\u001a\u00020bJ\n\u0010\u0003\u001a\u00030î\u0001H\u0016J\n\u0010\u0003\u001a\u00030î\u0001H\u0014J,\u0010 \u0003\u001a\u00030î\u00012\b\u0010ç\u0002\u001a\u00030Ë\u00012\u0007\u0010¡\u0003\u001a\u00020z2\u000f\u0010é\u0002\u001a\n\u0012\u0005\u0012\u00030Ë\u00010æ\u0001J2\u0010¢\u0003\u001a\r ¤\u0001*\u0005\u0018\u00010£\u00030£\u00032\u001c\u0010¾\u0002\u001a\u0017\u0012\u0005\u0012\u00030£\u0003\u0012\u0005\u0012\u00030î\u00010¤\u0003¢\u0006\u0003\b¥\u0003H\u0002J\n\u0010¦\u0003\u001a\u00030î\u0001H\u0016J\n\u0010§\u0003\u001a\u00030î\u0001H\u0016J\u001f\u0010¨\u0003\u001a\u00030î\u00012\b\u0010û\u0002\u001a\u00030ü\u00022\t\u0010þ\u0002\u001a\u0004\u0018\u00010zH\u0002J\u0014\u0010©\u0003\u001a\u00030î\u00012\b\u0010ª\u0003\u001a\u00030\u0002H\u0016J\u0014\u0010«\u0003\u001a\u00030î\u00012\b\u0010¬\u0003\u001a\u00030Ë\u0001H\u0016J\t\u0010­\u0003\u001a\u00020bH\u0002J\u0013\u0010®\u0003\u001a\u00030î\u00012\u0007\u0010¯\u0003\u001a\u00020bH\u0016J%\u0010°\u0003\u001a\u00030î\u00012\u0007\u0010±\u0003\u001a\u00020b2\u0007\u0010²\u0003\u001a\u00020z2\u0007\u0010³\u0003\u001a\u00020bH\u0016J\n\u0010´\u0003\u001a\u00030î\u0001H\u0016J\n\u0010µ\u0003\u001a\u00030î\u0001H\u0016J\n\u0010¶\u0003\u001a\u00030î\u0001H\u0002J\n\u0010·\u0003\u001a\u00030î\u0001H\u0002J\n\u0010¸\u0003\u001a\u00030î\u0001H\u0016J\u0013\u0010¹\u0003\u001a\u00030î\u00012\u0007\u0010þ\u0001\u001a\u00020zH\u0016J\n\u0010º\u0003\u001a\u00030î\u0001H\u0016J\n\u0010»\u0003\u001a\u00030î\u0001H\u0016J\n\u0010¼\u0003\u001a\u00030î\u0001H\u0002J\n\u0010½\u0003\u001a\u00030î\u0001H\u0002J\u0014\u0010¾\u0003\u001a\u00030î\u00012\b\u0010¿\u0003\u001a\u00030À\u0003H\u0002J\u0014\u0010Á\u0003\u001a\u00030î\u00012\b\u0010Â\u0003\u001a\u00030Ë\u0001H\u0002J\u0014\u0010Ã\u0003\u001a\u00030î\u00012\b\u0010Ä\u0003\u001a\u00030Ë\u0001H\u0016J\u0015\u0010Å\u0003\u001a\u00030î\u00012\t\u0010Æ\u0003\u001a\u0004\u0018\u00010zH\u0016J\u0014\u0010Ç\u0003\u001a\u00030î\u00012\b\u0010È\u0003\u001a\u00030\u0003H\u0002J\n\u0010É\u0003\u001a\u00030î\u0001H\u0002J\u0013\u0010Ê\u0003\u001a\u00030î\u00012\u0007\u0010Ë\u0003\u001a\u00020bH\u0016J\u0013\u0010Ì\u0003\u001a\u00020b2\b\u0010Í\u0003\u001a\u00030Î\u0003H\u0002J\u0014\u0010Ï\u0003\u001a\u00030î\u00012\b\u0010Ð\u0003\u001a\u00030Ñ\u0003H\u0016J\n\u0010Ò\u0003\u001a\u00030î\u0001H\u0002J\u0013\u0010Ó\u0003\u001a\u00030î\u00012\u0007\u0010Ó\u0002\u001a\u00020bH\u0002J\u0014\u0010Ô\u0003\u001a\u00030î\u00012\b\u0010\u0002\u001a\u00030\u0002H\u0016J\n\u0010Õ\u0003\u001a\u00030î\u0001H\u0016J\n\u0010Ö\u0003\u001a\u00030î\u0001H\u0016J\n\u0010×\u0003\u001a\u00030î\u0001H\u0016J\n\u0010Ø\u0003\u001a\u00030î\u0001H\u0002J\n\u0010Ù\u0003\u001a\u00030î\u0001H\u0016J\u0013\u0010Ú\u0003\u001a\u00030î\u00012\u0007\u0010Û\u0003\u001a\u00020zH\u0016J\u0015\u0010Ü\u0003\u001a\u00030î\u00012\t\u0010Û\u0003\u001a\u0004\u0018\u00010zH\u0016J\n\u0010Ý\u0003\u001a\u00030î\u0001H\u0002J\u001b\u0010Þ\u0003\u001a\u00030î\u00012\u000f\u0010ß\u0003\u001a\n\u0012\u0005\u0012\u00030à\u00030æ\u0001H\u0002J\u0013\u0010á\u0003\u001a\u00030î\u00012\u0007\u0010â\u0003\u001a\u00020bH\u0016J\n\u0010ã\u0003\u001a\u00030î\u0001H\u0016J/\u0010ä\u0003\u001a\u00030î\u00012\u0007\u0010å\u0003\u001a\u00020b2\f\b\u0002\u0010æ\u0003\u001a\u0005\u0018\u00010ç\u00032\f\b\u0002\u0010è\u0003\u001a\u0005\u0018\u00010é\u0003H\u0002J\n\u0010ê\u0003\u001a\u00030î\u0001H\u0002J\n\u0010ë\u0003\u001a\u00030î\u0001H\u0002J\u0014\u0010ì\u0003\u001a\u00030î\u00012\b\u0010í\u0003\u001a\u00030Ë\u0001H\u0016J\u0013\u0010î\u0003\u001a\u00030î\u00012\u0007\u0010ï\u0003\u001a\u00020zH\u0002J(\u0010ð\u0003\u001a\u00030î\u00012\u001c\u0010ñ\u0003\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020z\u0012\u0005\u0012\u00030¯\u00020\u00020æ\u0001H\u0016J\u0014\u0010ò\u0003\u001a\u00030î\u00012\b\u0010ó\u0003\u001a\u00030ô\u0003H\u0016J\n\u0010õ\u0003\u001a\u00030î\u0001H\u0016J\u0010\u0010ö\u0003\u001a\u00020b*\u0005\u0018\u00010Æ\u0002H\u0002J\u001e\u0010÷\u0003\u001a\u0005\u0018\u00010Â\u0002*\u0010\u0012\u0004\u0012\u00020z\u0012\u0005\u0012\u00030¯\u00020\u0002H\u0002J\u001d\u0010ø\u0003\u001a\u0005\u0018\u00010ù\u0003*\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002J\u001d\u0010ú\u0003\u001a\u0005\u0018\u00010û\u0003*\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020z0\u0002H\u0002R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u00020D8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010I\u001a\u00020J8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020P8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001e\u0010U\u001a\u00020V8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001e\u0010[\u001a\u00020\\8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020e0dX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010f\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0010\u0010l\u001a\u0004\u0018\u00010mX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010n\u001a\u00020o8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001b\u0010t\u001a\u00020u8BX\u0002¢\u0006\f\n\u0004\bx\u0010\u001c\u001a\u0004\bv\u0010wR\u0010\u0010y\u001a\u0004\u0018\u00010zX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u00010zX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u00020bX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020bX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020bX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0012\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010¢\u0001\u001a\u0012\u0012\r\u0012\u000b ¤\u0001*\u0004\u0018\u00010z0z0£\u0001X\u000e¢\u0006\u0002\n\u0000R \u0010¥\u0001\u001a\u00030¦\u00018BX\u0002¢\u0006\u000f\n\u0005\b©\u0001\u0010\u001c\u001a\u0006\b§\u0001\u0010¨\u0001R$\u0010ª\u0001\u001a\u00030«\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010­\u0001\"\u0006\b®\u0001\u0010¯\u0001R\u0010\u0010°\u0001\u001a\u00030±\u0001X\u0004¢\u0006\u0002\n\u0000R$\u0010²\u0001\u001a\u00030³\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R\u000f\u0010¸\u0001\u001a\u00020bX\u000e¢\u0006\u0002\n\u0000R$\u0010¹\u0001\u001a\u00030º\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R \u0010¿\u0001\u001a\u00030À\u00018BX\u0002¢\u0006\u000f\n\u0005\bÃ\u0001\u0010\u001c\u001a\u0006\bÁ\u0001\u0010Â\u0001R$\u0010Ä\u0001\u001a\u00030Å\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R\u0015\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001X\u000e¢\u0006\u0005\n\u0003\u0010Ì\u0001R$\u0010Í\u0001\u001a\u00030Î\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R$\u0010Ó\u0001\u001a\u00030Ô\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R$\u0010Ù\u0001\u001a\u00030Ú\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R$\u0010ß\u0001\u001a\u00030à\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R\u0019\u0010å\u0001\u001a\f\u0012\u0005\u0012\u00030ç\u0001\u0018\u00010æ\u0001X\u000e¢\u0006\u0002\n\u0000R \u0010è\u0001\u001a\u00030é\u00018BX\u0002¢\u0006\u000f\n\u0005\bì\u0001\u0010\u001c\u001a\u0006\bê\u0001\u0010ë\u0001¨\u0006ý\u0003"}, d2 = {"Lcom/talabat/home/HomeScreenActivity;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/homescreen/OnFragmentInteractionListener;", "Llibrary/talabat/mvp/home/HomeView;", "Lcom/talabat/homemaphelper/CurrentLocationListener;", "Lcom/talabat/fluid/homescreen/ui/integration/FluidHomeScreenIntegrable;", "Lcom/talabat/fluid/homescreen/ui/widget/gem/GemExpirationCallback;", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallbackHandler;", "Lcom/talabat/core/flutter/channels/domain/useraccount/UserAccountChannelCallbackHandler;", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelProvider;", "()V", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "getAppVersionProvider", "()Lcom/talabat/configuration/discovery/AppVersionProvider;", "setAppVersionProvider", "(Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "campaignMigratorSharedPreferences", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "getCampaignMigratorSharedPreferences", "()Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "setCampaignMigratorSharedPreferences", "(Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;)V", "cobrandedCcViewModel", "Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModel;", "getCobrandedCcViewModel", "()Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModel;", "cobrandedCcViewModel$delegate", "Lkotlin/Lazy;", "cobrandedVmFactory", "Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModelFactory;", "getCobrandedVmFactory", "()Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModelFactory;", "setCobrandedVmFactory", "(Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModelFactory;)V", "configuration", "Lcom/talabat/fluid/homescreen/ui/integration/FluidHomeScreenIntegrable$Configuration;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "setCoroutineDispatchersFactory", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "currentLocationFetch", "Lcom/talabat/homemaphelper/CurrentLocationFetch;", "getCurrentLocationFetch", "()Lcom/talabat/homemaphelper/CurrentLocationFetch;", "setCurrentLocationFetch", "(Lcom/talabat/homemaphelper/CurrentLocationFetch;)V", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "getCustomerRepository", "()Lcom/talabat/customer/domain/CustomerRepository;", "setCustomerRepository", "(Lcom/talabat/customer/domain/CustomerRepository;)V", "darkstoresNavigator", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "getDarkstoresNavigator", "()Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "setDarkstoresNavigator", "(Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;)V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "factory", "Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;", "getFactory", "()Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;", "setFactory", "(Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;)V", "getActiveCartInfoUseCase", "Llibrary/talabat/mvp/home/domain/GetActiveCartInfoUseCase;", "getGetActiveCartInfoUseCase", "()Llibrary/talabat/mvp/home/domain/GetActiveCartInfoUseCase;", "setGetActiveCartInfoUseCase", "(Llibrary/talabat/mvp/home/domain/GetActiveCartInfoUseCase;)V", "getOverdueNotificationAcknowledgeUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueNotificationAcknowledgeUseCase;", "getGetOverdueNotificationAcknowledgeUseCase", "()Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueNotificationAcknowledgeUseCase;", "setGetOverdueNotificationAcknowledgeUseCase", "(Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueNotificationAcknowledgeUseCase;)V", "getOverdueUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "getGetOverdueUseCase", "()Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "setGetOverdueUseCase", "(Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;)V", "hasShownCobrandedNotification", "", "homeChannelFlutterDomainDeque", "Ljava/util/Deque;", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelFlutterDomain;", "homePresenter", "Llibrary/talabat/mvp/home/IHomePresenter;", "getHomePresenter", "()Llibrary/talabat/mvp/home/IHomePresenter;", "setHomePresenter", "(Llibrary/talabat/mvp/home/IHomePresenter;)V", "homeScreenInteractionListener", "Lcom/talabat/homescreen/HomeScreenFragmentInteractionListener;", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "getHomeScreenPerformanceObservability", "()Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "setHomeScreenPerformanceObservability", "(Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;)V", "homeScreenTracker", "Lcom/talabat/homescreen/utils/HomeScreenTracker;", "getHomeScreenTracker", "()Lcom/talabat/homescreen/utils/HomeScreenTracker;", "homeScreenTracker$delegate", "indexingDescription", "", "indexingTitle", "indexingUrl", "Landroid/net/Uri;", "isFromLocationWelcomeScreen", "isLoadMapFromWelcome", "isNfvFlutterNavigationUsecase", "Llibrary/talabat/mvp/home/IsNfvFlutterNavigationUsecase;", "()Llibrary/talabat/mvp/home/IsNfvFlutterNavigationUsecase;", "setNfvFlutterNavigationUsecase", "(Llibrary/talabat/mvp/home/IsNfvFlutterNavigationUsecase;)V", "isOnboardingExperimentEnabledUseCase", "Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;", "()Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;", "setOnboardingExperimentEnabledUseCase", "(Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;)V", "isRedirectMapAfterCountrySelection", "isShowMapSearch", "mutableLocationConfigurationRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "getMutableLocationConfigurationRepository", "()Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "setMutableLocationConfigurationRepository", "(Lcom/talabat/configuration/MutableLocationConfigurationRepository;)V", "navigationEventStack", "Lcom/talabat/home/navigation/NavigationEventStack;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "orderRatingPresenter", "Lcom/talabat/rating/presenter/OrderRatingPresenter;", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "ratingEventTracker", "Lcom/talabat/feature/rating/domain/EventTracker;", "getRatingEventTracker", "()Lcom/talabat/feature/rating/domain/EventTracker;", "ratingEventTracker$delegate", "ratingSession", "Lcom/talabat/feature/rating/domain/repo/RatingSession;", "getRatingSession", "()Lcom/talabat/feature/rating/domain/repo/RatingSession;", "setRatingSession", "(Lcom/talabat/feature/rating/domain/repo/RatingSession;)V", "screenRecorder", "Lcom/talabat/screenrecorder/ScreenRecorder;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "setScreenTracker", "(Lcom/talabat/core/observabilityNew/domain/IScreenTracker;)V", "shouldForceLocationSelection", "shouldRateLastOrderUseCase", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "getShouldRateLastOrderUseCase", "()Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "setShouldRateLastOrderUseCase", "(Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;)V", "stopHomeScreenTraceUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/application/StopHomeScreenTraceUseCase;", "getStopHomeScreenTraceUseCase", "()Lcom/talabat/fluid/homescreen/domain/usecase/application/StopHomeScreenTraceUseCase;", "stopHomeScreenTraceUseCase$delegate", "subscriptionSharedPrefManager", "Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;", "getSubscriptionSharedPrefManager", "()Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;", "setSubscriptionSharedPrefManager", "(Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;)V", "tabToSelectUponLocationSelection", "", "Ljava/lang/Integer;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "getTalabatExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "setTalabatExperiment", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTalabatTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "updateOverdueAcknowledgeStateUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;", "getUpdateOverdueAcknowledgeStateUseCase", "()Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;", "setUpdateOverdueAcknowledgeStateUseCase", "(Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;)V", "verticalItemsFromFlutter", "", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "voucherEntryPointViewModel", "Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel;", "getVoucherEntryPointViewModel", "()Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel;", "voucherEntryPointViewModel$delegate", "OnCurrentLocationPermissionStatus", "", "response", "Lcom/karumi/dexter/listener/PermissionDeniedResponse;", "accountTab", "Lcom/google/android/material/bottomnavigation/BottomNavigationItemView;", "addFragment", "isFlutterHomeEnabled", "isFlutterAccountEnabled", "isHomeOfOffersEnabled", "isFlutterOrdersListEnabled", "isFlutterSearchEnabled", "applyNavGraph", "controller", "Landroidx/navigation/NavController;", "cacheEvent", "cacheKey", "resetWhen", "callHoldOutGroups", "keys", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "changeToolBarColourViaFlutter", "shouldShowWhiteToolBar", "checkAndRequestNotificationPermission", "checkCacheEvent", "checkCobrandedCcNotification", "checkVouchersState", "clearCartInCaseOfDarkstores", "configure", "configureToolBarViaFlutter", "configurations", "", "createFooter", "Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "tracker", "Lcom/talabat/fluid/homescreen/domain/tracking/events/replacementbottomsheet/ItemReplacementBottomSheetTracker;", "info", "Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase$ItemReplacementInfo;", "createNavGraph", "Landroidx/navigation/NavGraph;", "createNavigationBar", "Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "createRestaurantFrom", "Ldatamodels/Restaurant;", "params", "deepLinkReceived", "deepLink", "deliverToCLRecived", "currentLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "destroyPresenter", "fetchTabVariants", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "flutterHomeEnabled", "flutterAccountEnabled", "homeOfOffersEnabled", "flutterOrdersListEnabled", "firebaseIndexingInit", "getAction", "Lcom/google/firebase/appindexing/Action;", "getAreaInfo", "", "getEventNavigationOrigin", "getIndexable", "Lcom/google/firebase/appindexing/Indexable;", "getPresenter", "getScreenName", "getSelectedCountryCode", "getVerticals", "goToOrderConfirmationScreen", "orderTrackingItem", "Lcom/talabat/homescreen/adapter/model/order_tracking/OrderTrackingItem;", "handleBannerClick", "url", "metadata", "handleClickFromFlutter", "action", "handleCollectionItemClicked", "handleComponentClick", "component", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/Component;", "handleCustomNavigation", "handleDeepLink", "extras", "Landroid/os/Bundle;", "handleDeepLinkWithItemTypeNavigation", "handleEntryPoints", "handleHero", "handleLoginClicked", "handlePickupClick", "handleSecondaryBannerClick", "handleSwimLaneItemClick", "handleTMartEntryPoint", "handleTabSelectionViaIntent", "intent", "Landroid/content/Intent;", "handleUpdateNavBar", "shouldShowToolBar", "handleVoucherCodeEntry", "hideCartView", "hideLoading", "hideOverdueNotification", "hideToolBar", "informHomeFragmentAboutNavigation", "destination", "Landroidx/navigation/NavDestination;", "iniThirdPartyGlobal", "inject", "invokeRefreshHomeListeners", "isAccountSelected", "isAppInfoCacheFlagEnabled", "isFlutterOrderListEnabled", "isHomeScreenToFoodListDeeplinkEnabled", "isLocationSelected", "isOverdueNotificationVisible", "isRefreshMap", "loadGroceryHomeScreen", "tileId", "veticalName", "verticalIds", "", "mapCurrentLocReceived", "navigateFromHomeToCart", "navigateToFlutterFoodList", "navigateToFlutterFoodListDeeplink", "navigateToFlutterFoodListExplicitly", "navigateToVendorListScreen", "isFoodVertical", "observerProStatus", "observerVoucherState", "onActivityResult", "requestCode", "resultCode", "data", "onAuthError", "onBackPressed", "onBannerClick", "bannerAdItem", "Lcom/talabat/homescreen/adapter/model/banner/BannerAdItem;", "onBannerClicked", "areaName", "onCreate", "savedInstanceState", "onCurrentLocationReceived", "location", "isShowLocationInAccurateAlert", "lococaccuracy", "", "onCurrentLocationReceivedWithLowAccuracy", "onDeepLinkNavigateToTproBenefits", "onEntryPointClicked", "entryPointItem", "Lcom/talabat/fluid/homescreen/presentation/mapper/EntryPointItem;", "onError", "onFragmentAttached", "fragment", "Landroidx/fragment/app/Fragment;", "onGemExpired", "onGeoLocationDialogAccepted", "locationRequestStatus", "onHomeFlutterAttached", "homeChannelFlutterDomain", "arguments", "onHomeFlutterDetached", "onNavDestinationChanged", "onNetworkError", "onPromotionsWidgetClicked", "id", "deeplink", "onResume", "onSetBottomNavigation", "boolean", "onStart", "onStop", "onVerticalSelection", "verticalName", "onWindow", "Landroid/view/Window;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "openBasketListScreen", "openFoodBasketScreen", "openMenuFromBanner", "openQCommerceBasketScreen", "restaurant", "outSideCountry", "countyId", "redirectBackToHomeAfterWelcomeWithVertical", "redirectToChooseSavedAddressScreen", "isReturnBackHome", "redirectToHomeMapScreen", "isIgnoreLocation", "userSelectedAddress", "isReturnBackToHome", "redirectToSearchScreen", "refreshHomeScreen", "removeObserverVoucherState", "removeSearchFragment", "resetAddressName", "resetCacheEvent", "resetCurrentLocationObserver", "setCurrentLocationFromBeginning", "setGoogleAdId", "setHomeToolBar", "setSelectedTab", "screen", "Lcom/talabat/home/navigation/NavigationEventStack$Screen;", "setSelectedTabId", "tabId", "setSelectedVertical", "verticalId", "setToolBarAddressLocationTitle", "selectedLocation", "setToolBarElevation", "toolBarElevation", "setToolbarItemsSelection", "setupAccountTab", "showTProLogo", "shouldSelectAddressForTab", "menuItem", "Landroid/view/MenuItem;", "showCartView", "activeCartInfo", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "showCobrandedCcNotification", "showHideToolBarViaFlutter", "showItemReplacementBottomSheet", "showLoading", "showLocationFetching", "showNotificationPermissionDialog", "showOrderListBadge", "showOverdueNotification", "showRatingBottomSheet", "encryptedOrderId", "showRatingBottomSheetForLastOrder", "showRedeemVoucherDetailsBottomSheet", "showSearchFlutterFragment", "availableVerticals", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "showTabBarNavigation", "showTabBar", "showToolBar", "showUserAccountBadge", "enableUserAccountBadge", "source", "Lcom/talabat/home/NotificationBadgeSource;", "notificationStyle", "Llibrary/talabat/mvp/home/VoucherNotificationStyle;", "snapToAddressOrCurrentLocation", "stopScreenTraceViaFlutter", "transitionHeaderColour", "colour", "updatePopUp", "msg", "updateVerticals", "verticals", "updateVoucherState", "voucherStateDomainModel", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "userAccountClicked", "fromFlutterHome", "getComponentOrNull", "getItemTypeOrNull", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/ItemType;", "getNavigationTypeOrNull", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/NavigationType;", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity extends TalabatBase implements OnFragmentInteractionListener, HomeView, CurrentLocationListener, FluidHomeScreenIntegrable, GemExpirationCallback, HomeChannelCallbackHandler, UserAccountChannelCallbackHandler, HomeChannelProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_DEEPLINK = "deeplink";
    @NotNull
    public static final String FLUTTER_FOOD_LIST_DISABLED_EXPERIMENT_VARIATION = "Control";
    @NotNull
    public static final String FLUTTER_FOOD_LIST_ENABLED_EXPERIMENT_VARIATION = "Variation1";
    @NotNull
    private static final String ITEM_REPLACEMENT_BS_TAG = "com.talabat.fluid.homescreen.item_replacement_bs";
    private static final int MAP_SCREEN_SELECTION_HOME = 50;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public AppVersionProvider appVersionProvider;
    @Inject
    public CampaignMigratorSharedPreferences campaignMigratorSharedPreferences;
    @NotNull
    private final Lazy cobrandedCcViewModel$delegate;
    @Inject
    public CobrandedCcViewModelFactory cobrandedVmFactory;
    @Nullable
    private FluidHomeScreenIntegrable.Configuration configuration;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    @Nullable
    private CurrentLocationFetch currentLocationFetch;
    @Inject
    public CustomerRepository customerRepository;
    @Inject
    public DarkstoresNavigator darkstoresNavigator;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public VoucherEntryPointViewModelFactory factory;
    @Inject
    public GetActiveCartInfoUseCase getActiveCartInfoUseCase;
    @Inject
    public GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase;
    @Inject
    public GetOverdueUseCase getOverdueUseCase;
    private boolean hasShownCobrandedNotification;
    @NotNull
    private final Deque<HomeChannelFlutterDomain> homeChannelFlutterDomainDeque;
    @Nullable
    private IHomePresenter homePresenter;
    @Nullable
    private HomeScreenFragmentInteractionListener homeScreenInteractionListener;
    @Inject
    public HomeScreenPerformanceObservability homeScreenPerformanceObservability;
    @NotNull
    private final Lazy homeScreenTracker$delegate;
    @Nullable
    private String indexingDescription;
    @Nullable
    private String indexingTitle;
    @Nullable
    private Uri indexingUrl;
    private boolean isFromLocationWelcomeScreen;
    private boolean isLoadMapFromWelcome;
    @Inject
    public IsNfvFlutterNavigationUsecase isNfvFlutterNavigationUsecase;
    @Inject
    public IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase;
    private boolean isRedirectMapAfterCountrySelection;
    private boolean isShowMapSearch;
    @Inject
    public MutableLocationConfigurationRepository mutableLocationConfigurationRepository;
    @NotNull
    private final NavigationEventStack navigationEventStack;
    @Inject
    public Navigator navigator;
    @Inject
    public IObservabilityManager observabilityManager;
    @Nullable
    private OrderRatingPresenter orderRatingPresenter;
    @NotNull
    private ActivityResultLauncher<String> permissionLauncher;
    @NotNull
    private final Lazy ratingEventTracker$delegate;
    @Inject
    public RatingSession ratingSession;
    @NotNull
    private final ScreenRecorder screenRecorder;
    @Inject
    public IScreenTracker screenTracker;
    private boolean shouldForceLocationSelection;
    @Inject
    public ShouldRateLastOrderUseCase shouldRateLastOrderUseCase;
    @NotNull
    private final Lazy stopHomeScreenTraceUseCase$delegate;
    @Inject
    public SubscriptionSharedPrefManager subscriptionSharedPrefManager;
    @Nullable
    private Integer tabToSelectUponLocationSelection;
    @Inject
    public ITalabatExperiment talabatExperiment;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @Inject
    public TalabatTracker talabatTracker;
    @Inject
    public UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase;
    @Nullable
    private List<VerticalItem> verticalItemsFromFlutter;
    @NotNull
    private final Lazy voucherEntryPointViewModel$delegate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/home/HomeScreenActivity$Companion;", "", "()V", "EXTRA_DEEPLINK", "", "FLUTTER_FOOD_LIST_DISABLED_EXPERIMENT_VARIATION", "FLUTTER_FOOD_LIST_ENABLED_EXPERIMENT_VARIATION", "ITEM_REPLACEMENT_BS_TAG", "MAP_SCREEN_SELECTION_HOME", "", "callingIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent callingIntent(@Nullable Context context) {
            return new Intent(context, HomeScreenActivity.class);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[HomeScreen.NavigationTab.values().length];
            iArr[HomeScreen.NavigationTab.HOME.ordinal()] = 1;
            iArr[HomeScreen.NavigationTab.SEARCH.ordinal()] = 2;
            iArr[HomeScreen.NavigationTab.ACCOUNT.ordinal()] = 3;
            iArr[HomeScreen.NavigationTab.FLUTTER_HOME.ordinal()] = 4;
            iArr[HomeScreen.NavigationTab.FLUTTER_ACCOUNT.ordinal()] = 5;
            iArr[HomeScreen.NavigationTab.HOME_OF_OFFERS.ordinal()] = 6;
            iArr[HomeScreen.NavigationTab.ORDER_LIST.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NavigationEventStack.Screen.values().length];
            iArr2[NavigationEventStack.Screen.ACCOUNT.ordinal()] = 1;
            iArr2[NavigationEventStack.Screen.FLUTTER_ACCOUNT.ordinal()] = 2;
            iArr2[NavigationEventStack.Screen.HOME.ordinal()] = 3;
            iArr2[NavigationEventStack.Screen.FLUTTER_HOME.ordinal()] = 4;
            iArr2[NavigationEventStack.Screen.SEARCH.ordinal()] = 5;
            iArr2[NavigationEventStack.Screen.HOME_OF_OFFERS.ordinal()] = 6;
            iArr2[NavigationEventStack.Screen.ORDER_LIST.ordinal()] = 7;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Component.values().length];
            iArr3[Component.HERO.ordinal()] = 1;
            iArr3[Component.LOGIN.ordinal()] = 2;
            iArr3[Component.ENTRY_POINT.ordinal()] = 3;
            iArr3[Component.VOUCHER_CODE_ENTRY.ordinal()] = 4;
            iArr3[Component.T_MART.ordinal()] = 5;
            iArr3[Component.BANNER.ordinal()] = 6;
            iArr3[Component.AUTO_ROTATING_BANNER.ordinal()] = 7;
            iArr3[Component.COLLECTION_ITEM.ordinal()] = 8;
            iArr3[Component.SWIM_LANE_ITEM.ordinal()] = 9;
            iArr3[Component.PICKUP.ordinal()] = 10;
            iArr3[Component.SECONDARY_BANNER.ordinal()] = 11;
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[ItemType.values().length];
            iArr4[ItemType.COLLECTION.ordinal()] = 1;
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[NavigationType.values().length];
            iArr5[NavigationType.CUSTOM.ordinal()] = 1;
            iArr5[NavigationType.DEEP_LINK.ordinal()] = 2;
            $EnumSwitchMapping$4 = iArr5;
        }
    }

    public HomeScreenActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.ratingEventTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new HomeScreenActivity$ratingEventTracker$2(this));
        this.stopHomeScreenTraceUseCase$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new HomeScreenActivity$stopHomeScreenTraceUseCase$2(this));
        this.permissionLauncher = PermissionManagerKt.notificationPermissionLauncher(this);
        this.homeScreenTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new HomeScreenActivity$homeScreenTracker$2(this));
        this.voucherEntryPointViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VoucherEntryPointViewModel.class), new HomeScreenActivity$special$$inlined$viewModels$default$2(this), new HomeScreenActivity$voucherEntryPointViewModel$2(this), new HomeScreenActivity$special$$inlined$viewModels$default$3((Function0) null, this));
        this.cobrandedCcViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CobrandedCcViewModel.class), new HomeScreenActivity$special$$inlined$viewModels$default$5(this), new HomeScreenActivity$cobrandedCcViewModel$2(this), new HomeScreenActivity$special$$inlined$viewModels$default$6((Function0) null, this));
        this.homeChannelFlutterDomainDeque = new ArrayDeque();
        this.screenRecorder = ScreenRecorder.INSTANCE;
        this.navigationEventStack = new NavigationEventStack(0, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void B(HomeScreenActivity homeScreenActivity, boolean z11, NotificationBadgeSource notificationBadgeSource, VoucherNotificationStyle voucherNotificationStyle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            notificationBadgeSource = null;
        }
        if ((i11 & 4) != 0) {
            voucherNotificationStyle = null;
        }
        homeScreenActivity.showUserAccountBadge(z11, notificationBadgeSource, voucherNotificationStyle);
    }

    private final BottomNavigationItemView accountTab() {
        View findViewById = ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).findViewById(R.id.account_nav);
        Intrinsics.checkNotNullExpressionValue(findViewById, "home_nav.findViewById(R.id.account_nav)");
        return (BottomNavigationItemView) findViewById;
    }

    /* access modifiers changed from: private */
    public final void addFragment(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        NavController navController;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        if (findFragmentById != null) {
            navController = FragmentKt.findNavController(findFragmentById);
        } else {
            navController = null;
        }
        if (navController != null) {
            navController.getNavigatorProvider().addNavigator(new SearchNavigator(this, this.homePresenter));
            applyNavGraph(navController, z11, z12, z13, z14, z15);
            navController.addOnDestinationChangedListener(new g(this));
            ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).setOnItemSelectedListener(new h(this, navController));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addFragment$lambda-16$lambda-11  reason: not valid java name */
    public static final void m10637addFragment$lambda16$lambda11(HomeScreenActivity homeScreenActivity, NavController navController, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(homeScreenActivity, "this$0");
        Intrinsics.checkNotNullParameter(navController, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        homeScreenActivity.onNavDestinationChanged(navDestination);
    }

    /* access modifiers changed from: private */
    /* renamed from: addFragment$lambda-16$lambda-15  reason: not valid java name */
    public static final boolean m10638addFragment$lambda16$lambda15(HomeScreenActivity homeScreenActivity, NavController navController, MenuItem menuItem) {
        boolean z11;
        IHomePresenter presenter;
        Intrinsics.checkNotNullParameter(homeScreenActivity, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        boolean z12 = true;
        if (!(!menuItem.isChecked())) {
            menuItem = null;
        }
        if (menuItem == null) {
            return false;
        }
        if (homeScreenActivity.shouldSelectAddressForTab(menuItem)) {
            IHomePresenter iHomePresenter = homeScreenActivity.homePresenter;
            if (iHomePresenter != null) {
                iHomePresenter.toolbarLocationSelection();
            }
            homeScreenActivity.tabToSelectUponLocationSelection = Integer.valueOf(menuItem.getItemId());
            z12 = false;
        } else {
            int itemId = menuItem.getItemId();
            Bundle bundle = new Bundle();
            bundle.putString("verticals", homeScreenActivity.getVerticals());
            Unit unit = Unit.INSTANCE;
            NavOptions.Builder builder = new NavOptions.Builder();
            if (menuItem.getItemId() == R.id.home_nav) {
                z11 = true;
            } else {
                z11 = false;
            }
            navController.navigate(itemId, bundle, NavOptions.Builder.setPopUpTo$default(builder, (int) R.id.home_nav, z11, false, 4, (Object) null).build());
            if (menuItem.getItemId() == R.id.account_nav && (presenter = homeScreenActivity.getPresenter()) != null) {
                presenter.onUserAccountTabClicked();
            }
        }
        return z12;
    }

    private final void applyNavGraph(NavController navController, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        if (!z13) {
            ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).getMenu().removeItem(R.id.home_of_offers_nav);
        }
        if (!isUserLoggedIn() || !z14) {
            ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).getMenu().removeItem(R.id.order_list_nav);
        }
        navController.setGraph(createNavGraph(navController, z11, z12, z15));
        ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).setVisibility(0);
    }

    private final void callHoldOutGroups(List<? extends FWFKey> list) {
        for (FWFKey stringVariant : list) {
            LogManager.info(getTalabatExperiment().getStringVariant(stringVariant, "", TalabatExperimentDataSourceStrategy.FWF));
        }
    }

    private final void changeToolBarColourViaFlutter(boolean z11) {
        if (z11) {
            transitionHeaderColour(getResources().getColor(R.color.ds_neutral_white, getTheme()));
            return;
        }
        FluidHomeScreenIntegrable.Configuration configuration2 = this.configuration;
        if (configuration2 != null) {
            transitionHeaderColour(configuration2.getNavigationBarColor());
        }
    }

    private final void checkAndRequestNotificationPermission() {
        Context context = getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        } else if (!ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, "android.permission.POST_NOTIFICATIONS")) {
            PermissionManager.INSTANCE.requestPermission(this.permissionLauncher, "android.permission.POST_NOTIFICATIONS");
        }
    }

    private final void checkCobrandedCcNotification() {
        if (!this.hasShownCobrandedNotification) {
            getCobrandedCcViewModel().getShowCobrandedNotification().observe(this, new f(this));
            getCobrandedCcViewModel().showCobrandedNotification();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkCobrandedCcNotification$lambda-5  reason: not valid java name */
    public static final void m10639checkCobrandedCcNotification$lambda5(HomeScreenActivity homeScreenActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(homeScreenActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "showNotification");
        if (bool.booleanValue()) {
            homeScreenActivity.showCobrandedCcNotification();
            homeScreenActivity.hasShownCobrandedNotification = true;
        }
    }

    private final void clearCartInCaseOfDarkstores() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            return;
        }
        if (restaurant.isDarkStore || restaurant.isMigrated) {
            Cart.getInstance().clearCartFromDarkstores(this);
        }
    }

    private final void configureToolBarViaFlutter(Map<String, String> map) {
        if (!map.isEmpty()) {
            try {
                Result.Companion companion = Result.Companion;
                String str = map.get("navigationBarColor");
                String str2 = "";
                if (str == null) {
                    str = str2;
                }
                int parseColor = Color.parseColor(str);
                String str3 = map.get("locationHintColor");
                if (str3 == null) {
                    str3 = str2;
                }
                int parseColor2 = Color.parseColor(str3);
                String str4 = map.get("locationTitleColor");
                if (str4 == null) {
                    str4 = str2;
                }
                int parseColor3 = Color.parseColor(str4);
                String str5 = map.get("locationArrowTintColor");
                if (str5 != null) {
                    str2 = str5;
                }
                configure(new FluidHomeScreenIntegrable.Configuration(parseColor, parseColor2, parseColor3, Color.parseColor(str2)));
                Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    private final NavGraph createNavGraph(NavController navController, boolean z11, boolean z12, boolean z13) {
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navController.getNavigatorProvider(), 0, (int) R.id.home_nav);
        Class<DeeplinkFlutterFragment> cls = DeeplinkFlutterFragment.class;
        Class cls2 = FragmentNavigator.class;
        if (z11) {
            FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(cls2), (int) R.id.home_nav, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(cls));
            fragmentNavigatorDestinationBuilder.setLabel("DeeplinkFlutterFragmentHome");
            fragmentNavigatorDestinationBuilder.argument("deeplink", HomeScreenActivity$createNavGraph$1$1$1.INSTANCE);
            navGraphBuilder.destination(fragmentNavigatorDestinationBuilder);
        } else {
            FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder2 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(cls2), (int) R.id.home_nav, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(FluidHomeScreenFragment.class));
            fragmentNavigatorDestinationBuilder2.setLabel("FluidHomeScreenFragment");
            navGraphBuilder.destination(fragmentNavigatorDestinationBuilder2);
        }
        if (z12) {
            FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder3 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(cls2), (int) R.id.account_nav, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(cls));
            fragmentNavigatorDestinationBuilder3.setLabel("DeeplinkFlutterFragmentAccount");
            fragmentNavigatorDestinationBuilder3.argument("deeplink", HomeScreenActivity$createNavGraph$1$3$1.INSTANCE);
            navGraphBuilder.destination(fragmentNavigatorDestinationBuilder3);
        } else {
            FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder4 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(cls2), (int) R.id.account_nav, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(UserAccountFragment.class));
            fragmentNavigatorDestinationBuilder4.setLabel("FluidAccountScreenFragment");
            navGraphBuilder.destination(fragmentNavigatorDestinationBuilder4);
        }
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder5 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(cls2), (int) R.id.home_of_offers_nav, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(cls));
        fragmentNavigatorDestinationBuilder5.setLabel("DeeplinkFlutterFragmentHOO");
        fragmentNavigatorDestinationBuilder5.argument("deeplink", HomeScreenActivity$createNavGraph$1$5$1.INSTANCE);
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder5);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder6 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(cls2), (int) R.id.order_list_nav, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(cls));
        fragmentNavigatorDestinationBuilder6.setLabel("DeeplinkFlutterFragmentOrderList");
        fragmentNavigatorDestinationBuilder6.argument("deeplink", HomeScreenActivity$createNavGraph$1$6$1.INSTANCE);
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder6);
        if (z13) {
            FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder7 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(cls2), (int) R.id.search_nav, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(cls));
            fragmentNavigatorDestinationBuilder7.setLabel("DeeplinkFlutterFragmentSearch");
            fragmentNavigatorDestinationBuilder7.argument("deeplink", HomeScreenActivity$createNavGraph$1$7$1.INSTANCE);
            navGraphBuilder.destination(fragmentNavigatorDestinationBuilder7);
        } else {
            ActivityNavigator.Destination createDestination = ((SearchNavigator) navController.getNavigatorProvider().getNavigator(SearchNavigator.class)).createDestination();
            createDestination.setId(R.id.search_nav);
            navGraphBuilder.addDestination(createDestination);
        }
        return navGraphBuilder.build();
    }

    private final DSNavigationBar createNavigationBar(DSBottomSheet dSBottomSheet, ItemReplacementBottomSheetTracker itemReplacementBottomSheetTracker, ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo itemReplacementInfo) {
        DSNavigationBar dSNavigationBar = new DSNavigationBar(this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        dSNavigationBar.setLeadingIconButton(new DSIconButtonModel(R.drawable.ds_close, new HomeScreenActivity$createNavigationBar$1$1(dSBottomSheet, itemReplacementBottomSheetTracker, itemReplacementInfo, this)));
        return dSNavigationBar;
    }

    private final Restaurant createRestaurantFrom(Map<String, String> map) {
        int i11;
        int i12;
        boolean z11;
        boolean z12;
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Restaurant restaurant = new Restaurant();
        String str = map.get("chainId");
        int i13 = -1;
        if (str == null || (intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull(str)) == null) {
            i11 = -1;
        } else {
            i11 = intOrNull3.intValue();
        }
        restaurant.f13872id = i11;
        String str2 = map.get("chainName");
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        restaurant.f13873name = str2;
        String str4 = map.get("shopId");
        if (!(str4 == null || (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str4)) == null)) {
            i13 = intOrNull2.intValue();
        }
        restaurant.branchId = i13;
        String str5 = map.get("shopName");
        if (str5 != null) {
            str3 = str5;
        }
        restaurant.branchName = str3;
        String str6 = map.get("verticalId");
        boolean z13 = false;
        if (str6 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str6)) == null) {
            i12 = 0;
        } else {
            i12 = intOrNull.intValue();
        }
        restaurant.shopType = i12;
        String str7 = map.get("isDarkStore");
        if (str7 != null) {
            z11 = Boolean.parseBoolean(str7);
        } else {
            z11 = false;
        }
        restaurant.isDarkStore = z11;
        String str8 = map.get(BannerAdItemMapper.KEY_IS_GRL_ENABLED);
        if (str8 != null) {
            z12 = Boolean.parseBoolean(str8);
        } else {
            z12 = false;
        }
        restaurant.isGlrEnabled = z12;
        String str9 = map.get("ismgrtd");
        if (str9 != null) {
            z13 = Boolean.parseBoolean(str9);
        }
        restaurant.isMigrated = z13;
        return restaurant;
    }

    private final void deepLinkReceived(String str) {
        boolean z11;
        String query = Uri.parse(str).getQuery();
        if (query == null || StringsKt__StringsJVMKt.isBlank(query)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(true ^ z11)) {
            query = null;
        }
        getDeepLinkPresenter().deepLinkRecived(query);
        getDeepLinkPresenter().redirectToDeepLink();
    }

    private final void fetchTabVariants(Function5<? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, Unit> function5) {
        Function5<? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, ? super Boolean, Unit> function52 = function5;
        function52.invoke(Boolean.valueOf(isFlutterHomeEnabled()), Boolean.valueOf(isFlutterAccountEnabled()), Boolean.valueOf(isHomeOfOffersEnabled()), Boolean.valueOf(isFlutterOrderListEnabled()), Boolean.valueOf(isFlutterSearchEnabled()));
    }

    private final void firebaseIndexingInit() {
        WebAppMapping generateData = AppIndexingEngine.generateData(getScreenName());
        this.indexingUrl = generateData.webUrl;
        this.indexingTitle = generateData.webTitle;
        this.indexingDescription = generateData.webDescription;
    }

    private final boolean fromFlutterHome(Bundle bundle) {
        String str;
        if (bundle != null) {
            str = bundle.getString("deeplink");
        } else {
            str = null;
        }
        return Intrinsics.areEqual((Object) str, (Object) "home");
    }

    private final CobrandedCcViewModel getCobrandedCcViewModel() {
        return (CobrandedCcViewModel) this.cobrandedCcViewModel$delegate.getValue();
    }

    private final Component getComponentOrNull(Map<String, ? extends Object> map) {
        Component.Companion companion = Component.Companion;
        Object obj = map.get(FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return null;
        }
        return companion.from(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getNavigationOrigin();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getEventNavigationOrigin() {
        /*
            r1 = this;
            com.talabat.home.navigation.NavigationEventStack r0 = r1.navigationEventStack
            com.talabat.home.navigation.NavigationEventStack$Screen r0 = r0.peek()
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getNavigationOrigin()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.home.HomeScreenActivity.getEventNavigationOrigin():java.lang.String");
    }

    private final HomeScreenTracker getHomeScreenTracker() {
        return (HomeScreenTracker) this.homeScreenTracker$delegate.getValue();
    }

    private final Indexable getIndexable() {
        DigitalDocumentBuilder noteDigitalDocumentBuilder = Indexables.noteDigitalDocumentBuilder();
        String str = this.indexingTitle;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        DigitalDocumentBuilder digitalDocumentBuilder = (DigitalDocumentBuilder) noteDigitalDocumentBuilder.setName(str);
        String str3 = this.indexingDescription;
        if (str3 != null) {
            str2 = str3;
        }
        Indexable build = ((DigitalDocumentBuilder) digitalDocumentBuilder.setText(str2).setUrl(String.valueOf(this.indexingUrl))).build();
        Intrinsics.checkNotNullExpressionValue(build, "noteDigitalDocumentBuild…g())\n            .build()");
        return build;
    }

    private final ItemType getItemTypeOrNull(Map<String, String> map) {
        ItemType.Companion companion = ItemType.Companion;
        String str = map.get(FluidHomeScreenViewModel.METADATA_ITEM_TYPE_KEY);
        if (str == null) {
            return null;
        }
        return companion.from(str);
    }

    private final NavigationType getNavigationTypeOrNull(Map<String, String> map) {
        NavigationType.Companion companion = NavigationType.Companion;
        String str = map.get(FluidHomeScreenViewModel.METADATA_NAVIGATION_TYPE_KEY);
        if (str == null) {
            return null;
        }
        return companion.from(str);
    }

    private final EventTracker getRatingEventTracker() {
        return (EventTracker) this.ratingEventTracker$delegate.getValue();
    }

    private final StopHomeScreenTraceUseCase getStopHomeScreenTraceUseCase() {
        return (StopHomeScreenTraceUseCase) this.stopHomeScreenTraceUseCase$delegate.getValue();
    }

    private final String getVerticals() {
        List<VerticalItem> list;
        HomeScreenFragmentInteractionListener homeScreenFragmentInteractionListener = this.homeScreenInteractionListener;
        if (homeScreenFragmentInteractionListener == null || (list = homeScreenFragmentInteractionListener.getAvailableVerticals()) == null) {
            list = this.verticalItemsFromFlutter;
        }
        List<FlutterVertical> invoke = new AvailableVerticalsUseCase(new ShowMoreInHomeSearchUseCase(getTalabatFeatureFlag())).invoke(list);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            return gson.toJson((Object) invoke);
        }
        return GsonInstrumentation.toJson(gson, (Object) invoke);
    }

    private final VoucherEntryPointViewModel getVoucherEntryPointViewModel() {
        return (VoucherEntryPointViewModel) this.voucherEntryPointViewModel$delegate.getValue();
    }

    private final void handleBannerClick(String str, Map<String, String> map) {
        GlobalDataModel.ShopClickOrigin = "banner";
        onBannerClick(new BannerAdItemMapper().mapFrom(str, map));
    }

    private final void handleCollectionItemClicked(String str, Map<String, String> map) {
        int i11;
        Integer intOrNull;
        IntegrationKt.getDataSources().saveOfferAutoTriggered(true);
        String str2 = map.get("verticalId");
        if (str2 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2)) == null) {
            i11 = 0;
        } else {
            i11 = intOrNull.intValue();
        }
        setSelectedVertical(i11);
        handleDeepLink(str);
    }

    private final void handleComponentClick(Component component, String str, Map<String, String> map) {
        int i11;
        String str2;
        String str3 = str + FluidHomeScreenViewModel.HOME_ORIGINATED_DEEPLINK_SUFFIX;
        if (component == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$2[component.ordinal()];
        }
        switch (i11) {
            case 1:
                handleHero(map, str);
                return;
            case 2:
                handleLoginClicked(str3);
                return;
            case 3:
                handleEntryPoints(str, map);
                return;
            case 4:
                handleVoucherCodeEntry(str3);
                return;
            case 5:
                handleTMartEntryPoint(str);
                return;
            case 6:
            case 7:
                handleBannerClick(str, map);
                return;
            case 8:
                handleCollectionItemClicked(str3, map);
                return;
            case 9:
                handleSwimLaneItemClick(map);
                return;
            case 10:
                handlePickupClick(str);
                return;
            case 11:
                handleSecondaryBannerClick(str);
                return;
            default:
                if (component != null) {
                    str2 = component.getValue();
                } else {
                    str2 = null;
                }
                LogManager.info("Clicked " + str2);
                handleDeepLink(str);
                return;
        }
    }

    private final void handleCustomNavigation(Map<String, String> map) {
        boolean z11;
        String str = map.get(VerticalItemViewEntityMapperKt.VERTICAL_ITEM_KEY);
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            onEntryPointClicked(new VerticalItemViewEntityMapper((Gson) null, 1, (DefaultConstructorMarker) null).apply(map));
        }
    }

    private final void handleDeepLink(Bundle bundle) {
        String string = bundle != null ? bundle.getString("deeplink") : null;
        if (string != null) {
            DeepLinkNavigator.DefaultImpls.navigateTo$default(getDeepLinkNavigator(), this, string, (Function0) null, 4, (Object) null);
        }
    }

    private final void handleDeepLinkWithItemTypeNavigation(Map<String, String> map, String str) {
        int i11;
        ItemType itemTypeOrNull = getItemTypeOrNull(map);
        if (itemTypeOrNull == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$3[itemTypeOrNull.ordinal()];
        }
        if (i11 == 1) {
            handleCollectionItemClicked(str, map);
        } else {
            handleDeepLink(str);
        }
    }

    private final void handleEntryPoints(String str, Map<String, String> map) {
        int i11;
        NavigationType navigationTypeOrNull = getNavigationTypeOrNull(map);
        if (navigationTypeOrNull == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$4[navigationTypeOrNull.ordinal()];
        }
        if (i11 == -1) {
            LogManager.debug("Entrypoint navigation type is null");
        } else if (i11 == 1) {
            handleCustomNavigation(map);
        } else if (i11 == 2) {
            handleDeepLink(str);
        }
    }

    private final void handleHero(Map<String, String> map, String str) {
        IntegrationGlobalDataModel.Companion.setHomeMapRedirect(getContext());
        handleDeepLinkWithItemTypeNavigation(map, str);
    }

    private final void handleLoginClicked(String str) {
        handleDeepLink(str);
    }

    private final void handlePickupClick(String str) {
        IntegrationGlobalDataModel.Companion.setHomeMapRedirect(getContext());
        handleDeepLink(str);
    }

    private final void handleSecondaryBannerClick(String str) {
        handleDeepLink(str);
    }

    private final void handleSwimLaneItemClick(Map<String, String> map) {
        Restaurant createRestaurantFrom = createRestaurantFrom(map);
        GlobalDataModel.ShopClickOrigin = "swimlane";
        GlobalDataModel.SELECTED.updateRestaurant(createRestaurantFrom);
        IntegrationGlobalDataModel.Companion.setHomeMapRedirect(getContext());
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, createRestaurantFrom.branchId, createRestaurantFrom.shopType, createRestaurantFrom.isGlrEnabled, createRestaurantFrom.isDarkStore, createRestaurantFrom.isMigrated, false, (String) null, (Bundle) null, 224, (Object) null));
    }

    private final void handleTMartEntryPoint(String str) {
        IntegrationGlobalDataModel.Companion.setHomeMapRedirect(getContext());
        handleDeepLink(str);
    }

    private final void handleTabSelectionViaIntent(Intent intent) {
        HomeScreen.NavigationTab navigationTab;
        NavigationEventStack.Screen screen;
        HomeScreen.HomeScreenData homeScreenData;
        if (intent == null || (homeScreenData = (HomeScreen.HomeScreenData) intent.getParcelableExtra("navigatorData")) == null) {
            navigationTab = null;
        } else {
            navigationTab = homeScreenData.getSelectNavigationTab();
        }
        if (navigationTab != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[navigationTab.ordinal()]) {
                case 1:
                    screen = NavigationEventStack.Screen.HOME;
                    break;
                case 2:
                    screen = NavigationEventStack.Screen.SEARCH;
                    break;
                case 3:
                    screen = NavigationEventStack.Screen.ACCOUNT;
                    break;
                case 4:
                    screen = NavigationEventStack.Screen.FLUTTER_HOME;
                    break;
                case 5:
                    screen = NavigationEventStack.Screen.FLUTTER_ACCOUNT;
                    break;
                case 6:
                    screen = NavigationEventStack.Screen.HOME_OF_OFFERS;
                    break;
                case 7:
                    screen = NavigationEventStack.Screen.ORDER_LIST;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            setSelectedTab(screen);
        }
    }

    private final void handleVoucherCodeEntry(String str) {
        handleDeepLink(str);
    }

    private final void informHomeFragmentAboutNavigation(NavDestination navDestination) {
        if (navDestination.getId() == R.id.home_nav) {
            HomeScreenFragmentInteractionListener homeScreenFragmentInteractionListener = this.homeScreenInteractionListener;
            if (homeScreenFragmentInteractionListener != null) {
                homeScreenFragmentInteractionListener.onReturningToHomeTab();
                return;
            }
            return;
        }
        HomeScreenFragmentInteractionListener homeScreenFragmentInteractionListener2 = this.homeScreenInteractionListener;
        if (homeScreenFragmentInteractionListener2 != null) {
            homeScreenFragmentInteractionListener2.onLeavingHomeTab();
        }
    }

    private final void iniThirdPartyGlobal() {
        HomeApptimizeFwFIntegration.INSTANCE.initApptimizeGlobal();
        ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(getTalabatFeatureFlag(), (FWFKey) TalabatFeatureFlagConstants.CHANGE_RETROFIT_BASE_URL, false, false, (Function1) HomeScreenActivity$iniThirdPartyGlobal$1.INSTANCE, 6, (Object) null);
        callHoldOutGroups(CollectionsKt__CollectionsKt.listOf(VendorListExperimentsKeys.HOF_HOLDOUT_Q3, MenuExperimentsKeys.MENU_HOLDOUT_EXPERIMENT, OrderingExperimentsKeys.EXP_HOLDOUT_EXPERIMENT, OrderingExperimentsKeys.EXP_HOLDOUT_Q1_2024_EXPERIMENT, OrderingExperimentsKeys.EXP_HOLDOUT_FOOD_CART_EXPERIMENT, OrderingExperimentsKeys.EXP_HOLDOUT_PRICING_EXPERIMENT, HomePageExperimentsKeys.HOME_OF_OFFERS_HOLDOUT));
    }

    private final void inject() {
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Activity) this);
        HomeScreenActivityComponent.Factory factory2 = DaggerHomeScreenActivityComponent.factory();
        TrackingCoreLibApi trackingCoreLibApi = (TrackingCoreLibApi) apiContainer.getFeature(TrackingCoreLibApi.class);
        factory2.create((ContextCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ContextCoreLibApi.class), (ActiveCartsApi) apiContainer.getFeature(ActiveCartsApi.class), (BnplCoreFeatureApi) apiContainer.getFeature(BnplCoreFeatureApi.class), (ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (MutableConfigurationRemoteCoreLibApi) apiContainer.getFeature(MutableConfigurationRemoteCoreLibApi.class), (DarkstoresFeatureApi) apiContainer.getFeature(DarkstoresFeatureApi.class), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), trackingCoreLibApi, (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (RatingFeatureApi) apiContainer.getFeature(RatingFeatureApi.class), (ExperimentCoreLibApi) apiContainer.getFeature(ExperimentCoreLibApi.class), (CampaignMigratorFeatureApi) apiContainer.getFeature(CampaignMigratorFeatureApi.class), (NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DispatcherCoreLibApi.class), (OnBoardingExperimentApi) apiContainer.getFeature(OnBoardingExperimentApi.class), (WalletCobrandedCcFeatureApi) apiContainer.getFeature(WalletCobrandedCcFeatureApi.class)).inject(this);
    }

    private final void invokeRefreshHomeListeners() {
        HomeScreenFragmentInteractionListener homeScreenFragmentInteractionListener = this.homeScreenInteractionListener;
        if (homeScreenFragmentInteractionListener != null) {
            homeScreenFragmentInteractionListener.refreshHomeScreen();
        }
        HomeChannelFlutterDomain peek = this.homeChannelFlutterDomainDeque.peek();
        if (peek != null) {
            peek.refreshHome();
        }
    }

    private final boolean isAppInfoCacheFlagEnabled() {
        return getTalabatFeatureFlag().getFeatureFlag(KillSwitchFeatureFlagsKeys.APP_LAUNCH_DATA_CACHE, true);
    }

    private final boolean isFlutterAccountEnabled() {
        return !StringsKt__StringsJVMKt.equals(getTalabatExperiment().getStringVariant(HomePageExperimentsKeys.FLUTTER_ACCOUNT_TAB, "Control", TalabatExperimentDataSourceStrategy.FWF), "Control", true);
    }

    private final boolean isFlutterHomeEnabled() {
        return !StringsKt__StringsJVMKt.equals(getTalabatExperiment().getStringVariant(HomePageExperimentsKeys.FLUTTER_HOME_TAB, "Control", TalabatExperimentDataSourceStrategy.FWF), "Control", true);
    }

    private final boolean isFlutterOrderListEnabled() {
        return !StringsKt__StringsJVMKt.equals(getTalabatExperiment().getStringVariant(OrderingExperimentsKeys.EXP_ORDERING_SHOWING_REORDER_IN_HOME_BOTTOM_TAB, "Control", TalabatExperimentDataSourceStrategy.FWF), "Control", true);
    }

    private final boolean isFlutterSearchEnabled() {
        return getTalabatFeatureFlag().getFeatureFlag(SearchFeatureFlagsKeys.GET_FLUTTER_SEARCHABLE_VERTICALS, false);
    }

    private final boolean isHomeOfOffersEnabled() {
        return !StringsKt__StringsJVMKt.equals(getTalabatExperiment().getStringVariant(HomePageExperimentsKeys.HOME_OF_OFFERS, "Control", TalabatExperimentDataSourceStrategy.FWF), "Control", true);
    }

    private final boolean isHomeScreenToFoodListDeeplinkEnabled() {
        return getTalabatFeatureFlag().getFeatureFlag(VendorListFeatureFlagsKeys.VENDORLIST_DEEP_LINK_NAVIGATION_HOF, false);
    }

    private final boolean isLocationSelected() {
        if (GlobalDataModel.RECENT_LATLONG.getLatitude() <= 0.0d || GlobalDataModel.RECENT_LATLONG.getLongitude() <= 0.0d) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void navigateFromHomeToCart() {
        Intent intent = new Intent(this, CartScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
        intent.putExtra(GlobalConstants.KEY_TOCART, "from icon click");
        startActivity(intent);
    }

    private final void navigateToFlutterFoodList() {
        if (isHomeScreenToFoodListDeeplinkEnabled()) {
            navigateToFlutterFoodListDeeplink();
        } else {
            navigateToFlutterFoodListExplicitly();
        }
    }

    private final void navigateToFlutterFoodListDeeplink() {
        DeepLinkNavigator.DefaultImpls.navigateTo$default(getDeepLinkNavigator(), this, "talabat://?s=/food-list-organic", (Function0) null, 4, (Object) null);
    }

    private final void navigateToFlutterFoodListExplicitly() {
        Intent intent = new Intent(this, FoodListFlutterActivity.class);
        intent.putExtra("latitude", GlobalDataModel.RECENT_LATLONG.latitude);
        intent.putExtra("longitude", GlobalDataModel.RECENT_LATLONG.longitude);
        intent.putExtra("areaId", String.valueOf(GlobalDataModel.SelectedAreaId));
        intent.putExtra("cityId", String.valueOf(GlobalDataModel.SelectedCityId));
        intent.putExtra("countryId", GlobalDataModel.SelectedCountryId);
        intent.putExtra("areaName", GlobalDataModel.SelectedAreaName);
        startActivity(intent);
    }

    private final void observerProStatus() {
        if (getSubscriptionSharedPrefManager().isSubscribed()) {
            getSubscriptionSharedPrefManager().resetSubscriptionStatus();
            refreshHomeScreen();
        }
    }

    private final void observerVoucherState() {
        removeObserverVoucherState();
        getVoucherEntryPointViewModel().getVouchersState().observe(this, new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observerVoucherState$lambda-47  reason: not valid java name */
    public static final void m10640observerVoucherState$lambda47(HomeScreenActivity homeScreenActivity, VoucherStateDomainModel voucherStateDomainModel) {
        Intrinsics.checkNotNullParameter(homeScreenActivity, "this$0");
        if (voucherStateDomainModel == null) {
            return;
        }
        if (StringsKt__StringsJVMKt.isBlank(voucherStateDomainModel.getNotificationLabel())) {
            homeScreenActivity.checkCobrandedCcNotification();
        } else {
            homeScreenActivity.updateVoucherState(voucherStateDomainModel);
        }
    }

    private final void onBannerClicked(BannerAdItem bannerAdItem, String str) {
        boolean z11;
        String str2 = "";
        HomeMapTemp.INSTANCE.setHomeEnabledHomeMapRedirectEnabled(this);
        Integer type = bannerAdItem.getType();
        if (type != null && type.intValue() == 1) {
            openMenuFromBanner(bannerAdItem, str);
            return;
        }
        Integer type2 = bannerAdItem.getType();
        if (type2 == null || type2.intValue() != 2) {
            openMenuFromBanner(bannerAdItem, str);
        } else if (!TalabatUtils.isNullOrEmpty(bannerAdItem.getLink())) {
            startLodingPopup();
            try {
                String query = Uri.parse(bannerAdItem.getLink()).getQuery();
                if (query != null) {
                    str2 = query;
                }
            } catch (Exception unused) {
            }
            if (str2.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                getDeepLinkPresenter().deepLinkRecived(Uri.parse(bannerAdItem.getLink()).getQuery());
                disableBrandMenu(true);
                getDeepLinkPresenter().redirectToDeepLink();
                return;
            }
            openMenuFromBanner(bannerAdItem, str);
        } else {
            openMenuFromBanner(bannerAdItem, str);
        }
    }

    private final void onNavDestinationChanged(NavDestination navDestination) {
        String str;
        boolean z11;
        NavigationEventStack.Screen screen;
        boolean z12 = true;
        ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).getMenu().findItem(navDestination.getId()).setChecked(true);
        informHomeFragmentAboutNavigation(navDestination);
        String str2 = null;
        switch (navDestination.getId()) {
            case R.id.account_nav:
                if (isFlutterAccountEnabled()) {
                    str = NavigationEventStack.Screen.FLUTTER_ACCOUNT.getNavigationOption();
                } else {
                    str = NavigationEventStack.Screen.ACCOUNT.getNavigationOption();
                }
                onWindow(new HomeScreenActivity$onNavDestinationChanged$3(this));
                Customer instance = Customer.getInstance();
                HomeScreenTracker homeScreenTracker = getHomeScreenTracker();
                String eventNavigationOrigin = getEventNavigationOrigin();
                CustomerInfo customerInfo = instance.getCustomerInfo();
                if (customerInfo != null) {
                    str2 = customerInfo.encgid;
                }
                homeScreenTracker.trackBottomNavigationClick(str, eventNavigationOrigin, str2, instance.getSelectedCustomerAddress());
                this.navigationEventStack.push(NavigationEventStack.Screen.ACCOUNT);
                removeSearchFragment();
                GlobalDataModel.isSearchActive = false;
                hideToolBar();
                break;
            case R.id.home_nav:
                onWindow(new HomeScreenActivity$onNavDestinationChanged$1(this));
                IHomePresenter iHomePresenter = this.homePresenter;
                if (iHomePresenter == null || !iHomePresenter.ifShouldTrackHomeScreenValue(this.isFromLocationWelcomeScreen, this.isLoadMapFromWelcome, this.isRedirectMapAfterCountrySelection)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    Customer instance2 = Customer.getInstance();
                    HomeScreenTracker homeScreenTracker2 = getHomeScreenTracker();
                    CustomerInfo customerInfo2 = instance2.getCustomerInfo();
                    if (customerInfo2 != null) {
                        str2 = customerInfo2.encgid;
                    }
                    homeScreenTracker2.trackHomeLoad(str2, instance2.getSelectedCustomerAddress());
                    IHomePresenter iHomePresenter2 = this.homePresenter;
                    if (iHomePresenter2 != null) {
                        iHomePresenter2.checkOnboardingFlowExperiement();
                    }
                }
                if (this.navigationEventStack.peek() != null) {
                    z12 = false;
                }
                if (isFlutterHomeEnabled()) {
                    screen = NavigationEventStack.Screen.FLUTTER_HOME;
                } else {
                    screen = NavigationEventStack.Screen.HOME;
                }
                this.navigationEventStack.push(screen);
                removeSearchFragment();
                GlobalDataModel.isSearchActive = false;
                if (!z12) {
                    showToolBar();
                    break;
                }
                break;
            case R.id.home_of_offers_nav:
                onWindow(new HomeScreenActivity$onNavDestinationChanged$5(this));
                Customer instance3 = Customer.getInstance();
                HomeScreenTracker homeScreenTracker3 = getHomeScreenTracker();
                NavigationEventStack.Screen screen2 = NavigationEventStack.Screen.HOME_OF_OFFERS;
                String navigationOption = screen2.getNavigationOption();
                String eventNavigationOrigin2 = getEventNavigationOrigin();
                CustomerInfo customerInfo3 = instance3.getCustomerInfo();
                if (customerInfo3 != null) {
                    str2 = customerInfo3.encgid;
                }
                homeScreenTracker3.trackBottomNavigationClick(navigationOption, eventNavigationOrigin2, str2, instance3.getSelectedCustomerAddress());
                this.navigationEventStack.push(screen2);
                removeSearchFragment();
                GlobalDataModel.isSearchActive = false;
                hideToolBar();
                break;
            case R.id.order_list_nav:
                onWindow(new HomeScreenActivity$onNavDestinationChanged$2(this));
                Customer instance4 = Customer.getInstance();
                HomeScreenTracker homeScreenTracker4 = getHomeScreenTracker();
                NavigationEventStack.Screen screen3 = NavigationEventStack.Screen.ORDER_LIST;
                String navigationOption2 = screen3.getNavigationOption();
                String eventNavigationOrigin3 = getEventNavigationOrigin();
                CustomerInfo customerInfo4 = instance4.getCustomerInfo();
                if (customerInfo4 != null) {
                    str2 = customerInfo4.encgid;
                }
                homeScreenTracker4.trackBottomNavigationClick(navigationOption2, eventNavigationOrigin3, str2, instance4.getSelectedCustomerAddress());
                this.navigationEventStack.push(screen3);
                removeSearchFragment();
                GlobalDataModel.isSearchActive = false;
                hideToolBar();
                break;
            case R.id.search_nav:
                hideToolBar();
                onWindow(new HomeScreenActivity$onNavDestinationChanged$4(this));
                AppTracker.onSearchBarClicked(this, ScreenNames.getScreenType(getScreenName()), getScreenName(), "N/A", getEventNavigationOrigin());
                this.navigationEventStack.push(NavigationEventStack.Screen.SEARCH);
                break;
        }
        _$_findCachedViewById(R.id.loadingLayout).setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: onStop$lambda-34  reason: not valid java name */
    public static final void m10641onStop$lambda34(Void voidR) {
    }

    /* access modifiers changed from: private */
    /* renamed from: onStop$lambda-35  reason: not valid java name */
    public static final void m10642onStop$lambda35(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
    }

    private final Window onWindow(Function1<? super Window, Unit> function1) {
        Window window = getWindow();
        function1.invoke(window);
        return window;
    }

    private final void openMenuFromBanner(BannerAdItem bannerAdItem, String str) {
        if (GlobalDataModel.SelectedAreaId > 0 && !TalabatUtils.isNullOrEmpty(str)) {
            GlobalDataModel.SELECTED.updateRestaurant(RestaurantMapper.Companion.mapToRestaurant(bannerAdItem));
            Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
            OPNavigatorActions.Companion companion2 = OPNavigatorActions.Companion;
            Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
            companion.navigate((Context) this, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(companion2, restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated, false, (String) null, (Bundle) null, 224, (Object) null));
        }
    }

    private final boolean redirectBackToHomeAfterWelcomeWithVertical() {
        return this.isFromLocationWelcomeScreen && this.isLoadMapFromWelcome;
    }

    private final void removeObserverVoucherState() {
        getVoucherEntryPointViewModel().getVouchersState().removeObservers(this);
    }

    private final void removeSearchFragment() {
        Object obj;
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager\n            .fragments");
        Iterator it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Fragment) obj) instanceof HomeSearchFlutterFragment) {
                break;
            }
        }
        Fragment fragment = (Fragment) obj;
        if (fragment != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
            FragmentTransaction remove = beginTransaction.remove(fragment);
            Intrinsics.checkNotNullExpressionValue(remove, "remove(homeSearchFlutterFragment)");
            remove.commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setCurrentLocationFromBeginning$lambda-28  reason: not valid java name */
    public static final void m10643setCurrentLocationFromBeginning$lambda28(HomeScreenActivity homeScreenActivity, LatLng latLng) {
        Intrinsics.checkNotNullParameter(homeScreenActivity, "this$0");
        if (latLng != null) {
            LatLng value = GlobalDataModel.JSON.CurrentLocationFromStart.getValue();
            Intrinsics.checkNotNull(value);
            if (value.latitude > 0.0d) {
                LatLng value2 = GlobalDataModel.JSON.CurrentLocationFromStart.getValue();
                Intrinsics.checkNotNull(value2);
                if (value2.longitude > 0.0d) {
                    IHomePresenter iHomePresenter = homeScreenActivity.homePresenter;
                    Intrinsics.checkNotNull(iHomePresenter);
                    iHomePresenter.LocationBasedAddressSelection(GlobalDataModel.JSON.CurrentLocationFromStart.getValue());
                }
            }
        }
    }

    private final void setGoogleAdId() {
        if (TalabatUtils.isNullOrEmpty(GoogleAdvertisingIdClientHelper.getInstance().googleAdvertId(getApplicationContext()))) {
            GoogleAdvertisingIdClientHelper.getInstance().getAdvertisingId(getApplicationContext());
            return;
        }
        GlobalDataModel.googleAdId = GoogleAdvertisingIdClientHelper.getInstance().googleAdvertId(getApplicationContext());
        AppTracker.setGoogleAdvertId(this, GoogleAdvertisingIdClientHelper.getInstance().googleAdvertId(getApplicationContext()));
    }

    private final void setHomeToolBar() {
        IHomePresenter iHomePresenter = this.homePresenter;
        if (iHomePresenter != null) {
            iHomePresenter.setToolBarLocation();
        }
        IHomePresenter iHomePresenter2 = this.homePresenter;
        if (iHomePresenter2 != null) {
            iHomePresenter2.setCartView();
        }
        setToolbarItemsSelection();
    }

    private final void setSelectedTab(NavigationEventStack.Screen screen) {
        switch (WhenMappings.$EnumSwitchMapping$1[screen.ordinal()]) {
            case 1:
            case 2:
                setSelectedTabId(R.id.account_nav);
                return;
            case 3:
            case 4:
                setSelectedTabId(R.id.home_nav);
                return;
            case 5:
                setSelectedTabId(R.id.search_nav);
                return;
            case 6:
                setSelectedTabId(R.id.home_of_offers_nav);
                return;
            case 7:
                setSelectedTabId(R.id.order_list_nav);
                return;
            default:
                return;
        }
    }

    private final void setSelectedTabId(int i11) {
        ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).setSelectedItemId(i11);
    }

    private final void setToolBarElevation(float f11) {
        ((CardView) _$_findCachedViewById(R.id.homeToolbar)).setCardElevation(f11);
    }

    private final void setToolbarItemsSelection() {
        HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(R.id.header_view);
        if (homeScreenHeaderView != null) {
            homeScreenHeaderView.setOnAddressClicked(new HomeScreenActivity$setToolbarItemsSelection$1(this));
        }
    }

    private final boolean shouldSelectAddressForTab(MenuItem menuItem) {
        if ((menuItem.getItemId() == R.id.home_of_offers_nav || menuItem.getItemId() == R.id.search_nav || menuItem.getItemId() == R.id.order_list_nav) && !isLocationSelected()) {
            return true;
        }
        return false;
    }

    private final void showCobrandedCcNotification() {
        B(this, true, NotificationBadgeSource.COBRANDED_CC, (VoucherNotificationStyle) null, 4, (Object) null);
    }

    private final void showHideToolBarViaFlutter(boolean z11) {
        if (z11) {
            onWindow(new HomeScreenActivity$showHideToolBarViaFlutter$1(this));
            showToolBar();
            return;
        }
        onWindow(new HomeScreenActivity$showHideToolBarViaFlutter$2(this));
        hideToolBar();
    }

    private final void showOrderListBadge() {
        if (getTalabatFeatureFlag().getFeatureFlag(OrderingFeatureFlagsKeys.BADGE_ORDER_LIST_TAB_BAR_ENABLED, false)) {
            BadgeDrawable orCreateBadge = ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).getOrCreateBadge(R.id.order_list_nav);
            Intrinsics.checkNotNullExpressionValue(orCreateBadge, "home_nav.getOrCreateBadge(R.id.order_list_nav)");
            orCreateBadge.setBackgroundColor(getColor(R.color.rdanger));
        }
    }

    private final void showRedeemVoucherDetailsBottomSheet() {
        getTalabatFeatureFlag().getFeatureFlag((FWFKey) GrowthFeatureFlagConstantKt.FunWithFlagEnableRedeemVoucherBottomSheet, false, false, (Function1<? super Boolean, Unit>) new HomeScreenActivity$showRedeemVoucherDetailsBottomSheet$1(this));
    }

    private final void showSearchFlutterFragment(List<FlutterVertical> list) {
        String str;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        HomeSearchFlutterFragment homeSearchFlutterFragment = new HomeSearchFlutterFragment();
        Bundle bundle = new Bundle();
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) list);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) list);
        }
        bundle.putString("verticals", str);
        homeSearchFlutterFragment.setArguments(bundle);
        Unit unit = Unit.INSTANCE;
        FragmentTransaction replace = beginTransaction.replace(R.id.homeScreenContainer, homeSearchFlutterFragment);
        Intrinsics.checkNotNullExpressionValue(replace, "replace(\n               …          }\n            )");
        replace.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        if (r5 == null) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showUserAccountBadge(boolean r3, com.talabat.home.NotificationBadgeSource r4, library.talabat.mvp.home.VoucherNotificationStyle r5) {
        /*
            r2 = this;
            r0 = 2131427413(0x7f0b0055, float:1.8476442E38)
            if (r3 == 0) goto L_0x005a
            int r3 = com.talabat.R.id.home_nav
            android.view.View r3 = r2._$_findCachedViewById(r3)
            com.google.android.material.bottomnavigation.BottomNavigationView r3 = (com.google.android.material.bottomnavigation.BottomNavigationView) r3
            com.google.android.material.badge.BadgeDrawable r3 = r3.getOrCreateBadge(r0)
            java.lang.String r0 = "home_nav.getOrCreateBadge(R.id.account_nav)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r0 = 2131101101(0x7f0605ad, float:1.7814602E38)
            int r0 = r2.getColor(r0)
            r3.setBackgroundColor(r0)
            com.talabat.home.NotificationBadgeSource r3 = com.talabat.home.NotificationBadgeSource.VOUCHERS
            if (r4 != r3) goto L_0x0065
            com.talabat.core.observabilityNew.domain.IObservabilityManager r3 = r2.getObservabilityManager()
            com.talabat.core.observabilityNew.domain.common.EventType r4 = com.talabat.core.observabilityNew.domain.common.EventType.GrowthEvents
            java.lang.String r4 = r4.name()
            com.talabat.core.observabilityNew.domain.common.GrowthEvents r0 = com.talabat.core.observabilityNew.domain.common.GrowthEvents.VOUCHER_NOTIFICATION_BADGE_SHOWN
            java.lang.String r0 = r0.getValue()
            if (r5 == 0) goto L_0x004a
            java.lang.String r5 = r5.name()
            if (r5 == 0) goto L_0x004a
            library.talabat.mvp.home.VoucherNotificationStyle r1 = library.talabat.mvp.home.VoucherNotificationStyle.NONE
            boolean r1 = r5.equals(r1)
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            if (r5 != 0) goto L_0x004c
        L_0x004a:
            java.lang.String r5 = "VOUCHER_COUNT"
        L_0x004c:
            java.lang.String r1 = "state"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r1, r5)
            java.util.Map r5 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r5)
            r3.trackEvent((java.lang.String) r0, (java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.String>) r5)
            goto L_0x0065
        L_0x005a:
            int r3 = com.talabat.R.id.home_nav
            android.view.View r3 = r2._$_findCachedViewById(r3)
            com.google.android.material.bottomnavigation.BottomNavigationView r3 = (com.google.android.material.bottomnavigation.BottomNavigationView) r3
            r3.removeBadge(r0)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.home.HomeScreenActivity.showUserAccountBadge(boolean, com.talabat.home.NotificationBadgeSource, library.talabat.mvp.home.VoucherNotificationStyle):void");
    }

    private final void snapToAddressOrCurrentLocation() {
        boolean z11;
        HomeScreen.HomeScreenData homeScreenData = (HomeScreen.HomeScreenData) getIntent().getParcelableExtra("navigatorData");
        if (homeScreenData != null) {
            z11 = homeScreenData.getSnap();
        } else {
            z11 = true;
        }
        IHomePresenter iHomePresenter = this.homePresenter;
        if (iHomePresenter != null) {
            iHomePresenter.fetchUserCurrentLocationFromAppStart(z11);
        }
    }

    private final void stopScreenTraceViaFlutter() {
        getStopHomeScreenTraceUseCase().stopHomeScreenTrace();
        PointOfInterestReporter pointOfInterestReporter = PointOfInterestReporter.INSTANCE;
        SectionOfInterest sectionOfInterest = SectionOfInterest.HOME_SCREEN_ACTIVITY;
        PointOfInterest pointOfInterest = PointOfInterest.TOTAL_TIME;
        pointOfInterestReporter.endTraceLog(sectionOfInterest, pointOfInterest);
        pointOfInterestReporter.endTraceLog(SectionOfInterest.APP_START_TO_INTERACTIVE, pointOfInterest);
    }

    /* access modifiers changed from: private */
    /* renamed from: transitionHeaderColour$lambda-50  reason: not valid java name */
    public static final void m10644transitionHeaderColour$lambda50(HomeScreenActivity homeScreenActivity, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(homeScreenActivity, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Integer) {
            HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) homeScreenActivity._$_findCachedViewById(R.id.header_view);
            if (homeScreenHeaderView != null) {
                homeScreenHeaderView.setHeaderBackgroundColor(((Number) animatedValue).intValue());
            }
            homeScreenActivity.onWindow(new HomeScreenActivity$transitionHeaderColour$1$1(animatedValue));
        }
    }

    private final void updatePopUp(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "updatePopup.create()");
        builder.setTitle((CharSequence) getString(R.string.update_Title));
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.update_ok_btn), (DialogInterface.OnClickListener) new HomeScreenActivity$updatePopUp$1(this));
        builder.setNegativeButton((CharSequence) getString(R.string.cancel), (DialogInterface.OnClickListener) new HomeScreenActivity$updatePopUp$2());
        builder.setOnDismissListener(new a());
        if (!create.isShowing()) {
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updatePopUp$lambda-33  reason: not valid java name */
    public static final void m10645updatePopUp$lambda33(DialogInterface dialogInterface) {
        GlobalConstants.NormalUpdate.IS_NORMAL_UPDATE = false;
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
        Intrinsics.checkNotNullParameter(permissionDeniedResponse, "response");
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

    public void cacheEvent(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        Intrinsics.checkNotNullParameter(list, "resetWhen");
        EventsCache.INSTANCE.set(str, list);
    }

    public boolean checkCacheEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "cacheKey");
        return EventsCache.INSTANCE.exists(str);
    }

    public void checkVouchersState() {
        observerVoucherState();
        getVoucherEntryPointViewModel().getVouchersState(isUserLoggedIn());
    }

    public void configure(@NotNull FluidHomeScreenIntegrable.Configuration configuration2) {
        Intrinsics.checkNotNullParameter(configuration2, "configuration");
        this.configuration = configuration2;
        HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(R.id.header_view);
        if (homeScreenHeaderView != null) {
            homeScreenHeaderView.setAddressIconTint(configuration2.getLocationArrowTintColor());
            homeScreenHeaderView.setCaptionTextColor(configuration2.getLocationHintColor());
            homeScreenHeaderView.setAddressTextColor(configuration2.getLocationTitleColor());
            homeScreenHeaderView.setHeaderBackgroundColor(configuration2.getNavigationBarColor());
        }
        onWindow(new HomeScreenActivity$configure$2(configuration2));
    }

    @NotNull
    public final DSBaseFixedFooter createFooter(@NotNull DSBottomSheet dSBottomSheet, @NotNull ItemReplacementBottomSheetTracker itemReplacementBottomSheetTracker, @NotNull ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo itemReplacementInfo) {
        DSBottomSheet dSBottomSheet2 = dSBottomSheet;
        ItemReplacementBottomSheetTracker itemReplacementBottomSheetTracker2 = itemReplacementBottomSheetTracker;
        ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo itemReplacementInfo2 = itemReplacementInfo;
        Intrinsics.checkNotNullParameter(dSBottomSheet2, "bottomSheet");
        Intrinsics.checkNotNullParameter(itemReplacementBottomSheetTracker2, "tracker");
        Intrinsics.checkNotNullParameter(itemReplacementInfo2, CustomerInfoLocalDataSourceImpl.KEY);
        DSFixedFooterWithVerticalButtons dSFixedFooterWithVerticalButtons = new DSFixedFooterWithVerticalButtons(this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        DSPrimaryButton dSPrimaryButton = new DSPrimaryButton(this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        String string = dSPrimaryButton.getResources().getString(R.string.replacement);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ion.R.string.replacement)");
        dSPrimaryButton.setTitle(string);
        dSPrimaryButton.setOnTap(new HomeScreenActivity$createFooter$1$1$1(itemReplacementBottomSheetTracker2, itemReplacementInfo2, this, dSBottomSheet2));
        dSFixedFooterWithVerticalButtons.setButtons(CollectionsKt__CollectionsJVMKt.listOf(dSPrimaryButton));
        return dSFixedFooterWithVerticalButtons;
    }

    public void deliverToCLRecived(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public void destroyPresenter() {
        this.homePresenter = null;
    }

    @NotNull
    public final Action getAction() {
        String str = this.indexingTitle;
        if (str == null) {
            str = "";
        }
        Action newView = Actions.newView(str, String.valueOf(this.indexingUrl));
        Intrinsics.checkNotNullExpressionValue(newView, "newView(indexingTitle.or…, indexingUrl.toString())");
        return newView;
    }

    @NotNull
    public final AppVersionProvider getAppVersionProvider() {
        AppVersionProvider appVersionProvider2 = this.appVersionProvider;
        if (appVersionProvider2 != null) {
            return appVersionProvider2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appVersionProvider");
        return null;
    }

    @Nullable
    public Map<String, Object> getAreaInfo() {
        double latitude = GlobalDataModel.RECENT_LATLONG.getLatitude();
        double longitude = GlobalDataModel.RECENT_LATLONG.getLongitude();
        if (latitude <= 0.0d || longitude <= 0.0d) {
            return null;
        }
        return MapsKt__MapsKt.mapOf(TuplesKt.to("areaId", Integer.valueOf(GlobalDataModel.SelectedAreaId)), TuplesKt.to("latitude", Double.valueOf(latitude)), TuplesKt.to("longitude", Double.valueOf(longitude)));
    }

    @NotNull
    public final CampaignMigratorSharedPreferences getCampaignMigratorSharedPreferences() {
        CampaignMigratorSharedPreferences campaignMigratorSharedPreferences2 = this.campaignMigratorSharedPreferences;
        if (campaignMigratorSharedPreferences2 != null) {
            return campaignMigratorSharedPreferences2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("campaignMigratorSharedPreferences");
        return null;
    }

    @NotNull
    public final CobrandedCcViewModelFactory getCobrandedVmFactory() {
        CobrandedCcViewModelFactory cobrandedCcViewModelFactory = this.cobrandedVmFactory;
        if (cobrandedCcViewModelFactory != null) {
            return cobrandedCcViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cobrandedVmFactory");
        return null;
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
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

    @Nullable
    public final CurrentLocationFetch getCurrentLocationFetch() {
        return this.currentLocationFetch;
    }

    @NotNull
    public final CustomerRepository getCustomerRepository() {
        CustomerRepository customerRepository2 = this.customerRepository;
        if (customerRepository2 != null) {
            return customerRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customerRepository");
        return null;
    }

    @NotNull
    public final DarkstoresNavigator getDarkstoresNavigator() {
        DarkstoresNavigator darkstoresNavigator2 = this.darkstoresNavigator;
        if (darkstoresNavigator2 != null) {
            return darkstoresNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("darkstoresNavigator");
        return null;
    }

    @NotNull
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final VoucherEntryPointViewModelFactory getFactory() {
        VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory = this.factory;
        if (voucherEntryPointViewModelFactory != null) {
            return voucherEntryPointViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    @NotNull
    public final GetActiveCartInfoUseCase getGetActiveCartInfoUseCase() {
        GetActiveCartInfoUseCase getActiveCartInfoUseCase2 = this.getActiveCartInfoUseCase;
        if (getActiveCartInfoUseCase2 != null) {
            return getActiveCartInfoUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getActiveCartInfoUseCase");
        return null;
    }

    @NotNull
    public final GetOverdueNotificationAcknowledgeUseCase getGetOverdueNotificationAcknowledgeUseCase() {
        GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase2 = this.getOverdueNotificationAcknowledgeUseCase;
        if (getOverdueNotificationAcknowledgeUseCase2 != null) {
            return getOverdueNotificationAcknowledgeUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getOverdueNotificationAcknowledgeUseCase");
        return null;
    }

    @NotNull
    public final GetOverdueUseCase getGetOverdueUseCase() {
        GetOverdueUseCase getOverdueUseCase2 = this.getOverdueUseCase;
        if (getOverdueUseCase2 != null) {
            return getOverdueUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getOverdueUseCase");
        return null;
    }

    @Nullable
    public final IHomePresenter getHomePresenter() {
        return this.homePresenter;
    }

    @NotNull
    public final HomeScreenPerformanceObservability getHomeScreenPerformanceObservability() {
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = this.homeScreenPerformanceObservability;
        if (homeScreenPerformanceObservability2 != null) {
            return homeScreenPerformanceObservability2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("homeScreenPerformanceObservability");
        return null;
    }

    @NotNull
    public final MutableLocationConfigurationRepository getMutableLocationConfigurationRepository() {
        MutableLocationConfigurationRepository mutableLocationConfigurationRepository2 = this.mutableLocationConfigurationRepository;
        if (mutableLocationConfigurationRepository2 != null) {
            return mutableLocationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mutableLocationConfigurationRepository");
        return null;
    }

    @NotNull
    public final com.talabat.core.navigation.domain.Navigator getNavigator() {
        com.talabat.core.navigation.domain.Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final RatingSession getRatingSession() {
        RatingSession ratingSession2 = this.ratingSession;
        if (ratingSession2 != null) {
            return ratingSession2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ratingSession");
        return null;
    }

    @NotNull
    public String getScreenName() {
        return "Home Screen";
    }

    @NotNull
    public final IScreenTracker getScreenTracker() {
        IScreenTracker iScreenTracker = this.screenTracker;
        if (iScreenTracker != null) {
            return iScreenTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        return null;
    }

    @NotNull
    public String getSelectedCountryCode() {
        return getConfigurationLocalRepository().selectedCountry().getTwoLetterCode();
    }

    @NotNull
    public final ShouldRateLastOrderUseCase getShouldRateLastOrderUseCase() {
        ShouldRateLastOrderUseCase shouldRateLastOrderUseCase2 = this.shouldRateLastOrderUseCase;
        if (shouldRateLastOrderUseCase2 != null) {
            return shouldRateLastOrderUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldRateLastOrderUseCase");
        return null;
    }

    @NotNull
    public final SubscriptionSharedPrefManager getSubscriptionSharedPrefManager() {
        SubscriptionSharedPrefManager subscriptionSharedPrefManager2 = this.subscriptionSharedPrefManager;
        if (subscriptionSharedPrefManager2 != null) {
            return subscriptionSharedPrefManager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionSharedPrefManager");
        return null;
    }

    @NotNull
    public final ITalabatExperiment getTalabatExperiment() {
        ITalabatExperiment iTalabatExperiment = this.talabatExperiment;
        if (iTalabatExperiment != null) {
            return iTalabatExperiment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatExperiment");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    @NotNull
    public final TalabatTracker getTalabatTracker() {
        TalabatTracker talabatTracker2 = this.talabatTracker;
        if (talabatTracker2 != null) {
            return talabatTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatTracker");
        return null;
    }

    @NotNull
    public final UpdateOverdueAcknowledgeStateUseCase getUpdateOverdueAcknowledgeStateUseCase() {
        UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase2 = this.updateOverdueAcknowledgeStateUseCase;
        if (updateOverdueAcknowledgeStateUseCase2 != null) {
            return updateOverdueAcknowledgeStateUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateOverdueAcknowledgeStateUseCase");
        return null;
    }

    public void goToOrderConfirmationScreen(@NotNull OrderTrackingItem orderTrackingItem) {
        Intrinsics.checkNotNullParameter(orderTrackingItem, "orderTrackingItem");
        if (!TalabatUtils.isNullOrEmpty(orderTrackingItem.getOrderTransactionID())) {
            startLodingPopup();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isOrderSuccess", orderTrackingItem.getStatus());
            bundle.putBoolean("isIndirectFlow", true);
            bundle.putString("restaurantName", orderTrackingItem.getRestaurantName());
            bundle.putString("encryptedOrderId", orderTrackingItem.getOrderTransactionID());
            OrderTrackingNavigator.navigateToOrderTracking((Context) this, bundle, false);
            stopLodingPopup();
            return;
        }
        LogManager.logException(new Exception("orderTransactionID is null or empty."));
    }

    public void handleClickFromFlutter(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        Component componentOrNull = getComponentOrNull(map);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        handleComponentClick(componentOrNull, str, linkedHashMap);
    }

    public void handleUpdateNavBar(boolean z11, boolean z12, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "configurations");
        int i11 = R.id.home_nav;
        if (((BottomNavigationView) _$_findCachedViewById(i11)).getMenu().findItem(((BottomNavigationView) _$_findCachedViewById(i11)).getSelectedItemId()).getItemId() == R.id.home_nav && isFlutterHomeEnabled()) {
            configureToolBarViaFlutter(map);
            showHideToolBarViaFlutter(z11);
            if (z11) {
                stopScreenTraceViaFlutter();
            }
            changeToolBarColourViaFlutter(z12);
        }
    }

    public void hideCartView() {
        int i11 = R.id.header_view;
        HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(i11);
        if (homeScreenHeaderView != null) {
            homeScreenHeaderView.hideBasket();
        }
        HomeScreenHeaderView homeScreenHeaderView2 = (HomeScreenHeaderView) _$_findCachedViewById(i11);
        if (homeScreenHeaderView2 != null) {
            homeScreenHeaderView2.updateBasketOrderCount(0);
        }
        HomeScreenHeaderView homeScreenHeaderView3 = (HomeScreenHeaderView) _$_findCachedViewById(i11);
        if (homeScreenHeaderView3 != null) {
            homeScreenHeaderView3.onBasketClicked(HomeScreenActivity$hideCartView$1.INSTANCE);
        }
    }

    public void hideLoading() {
        stopLodingPopup();
    }

    public void hideOverdueNotification() {
        B(this, false, (NotificationBadgeSource) null, (VoucherNotificationStyle) null, 6, (Object) null);
    }

    public void hideToolBar() {
        CardView cardView = (CardView) _$_findCachedViewById(R.id.homeToolbar);
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(R.id.header_view);
        if (homeScreenHeaderView != null) {
            homeScreenHeaderView.setVisibility(8);
        }
    }

    public boolean isAccountSelected() {
        return accountTab().isSelected();
    }

    @NotNull
    public final IsNfvFlutterNavigationUsecase isNfvFlutterNavigationUsecase() {
        IsNfvFlutterNavigationUsecase isNfvFlutterNavigationUsecase2 = this.isNfvFlutterNavigationUsecase;
        if (isNfvFlutterNavigationUsecase2 != null) {
            return isNfvFlutterNavigationUsecase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("isNfvFlutterNavigationUsecase");
        return null;
    }

    @NotNull
    public final IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase() {
        IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase2 = this.isOnboardingExperimentEnabledUseCase;
        if (isOnboardingExperimentEnabledUseCase2 != null) {
            return isOnboardingExperimentEnabledUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("isOnboardingExperimentEnabledUseCase");
        return null;
    }

    public boolean isOverdueNotificationVisible() {
        BadgeDrawable badge = ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).getBadge(R.id.account_nav);
        if (badge != null) {
            return badge.isVisible();
        }
        return false;
    }

    public void isRefreshMap(boolean z11, @NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public void loadGroceryHomeScreen(int i11, @NotNull String str, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "veticalName");
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        PerformanceTracker.INSTANCE.startTrace("groceryHomeScreenStartTime");
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, SdSquadActions.Companion.createNavigatorModelForGroceryHomeScreen$default(SdSquadActions.Companion, i11, str, list, (Bundle) null, 8, (Object) null));
    }

    public void mapCurrentLocReceived(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public void navigateToVendorListScreen(boolean z11) {
        FilterEngine.resetFilter(false);
        boolean areEqual = Intrinsics.areEqual((Object) getTalabatExperiment().getStringVariant(VendorListExperimentsKeys.FLUTTER_FOOD_LIST_SCREEN, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
        if (!z11 || !areEqual) {
            PerformanceTracker.INSTANCE.startTrace("verticalClickToVendorLoaded");
            Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
            SdSquadActions.Companion companion2 = SdSquadActions.Companion;
            String valueOf = String.valueOf(GlobalDataModel.RECENT_LATLONG.latitude);
            String valueOf2 = String.valueOf(GlobalDataModel.RECENT_LATLONG.longitude);
            int i11 = GlobalDataModel.SelectedAreaId;
            int i12 = GlobalDataModel.SelectedCityId;
            int i13 = GlobalDataModel.SelectedCountryId;
            String str = GlobalDataModel.SelectedAreaName;
            Intrinsics.checkNotNullExpressionValue(str, "SelectedAreaName");
            companion.navigate((Context) this, companion2.createNavigatorModelForListingScreen(valueOf, valueOf2, i11, i12, i13, str));
            return;
        }
        navigateToFlutterFoodList();
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        String str;
        Integer num;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 50) {
            this.isFromLocationWelcomeScreen = false;
            this.isLoadMapFromWelcome = false;
            this.isRedirectMapAfterCountrySelection = false;
            Customer instance = Customer.getInstance();
            HomeScreenTracker homeScreenTracker = getHomeScreenTracker();
            CustomerInfo customerInfo = instance.getCustomerInfo();
            if (customerInfo != null) {
                str = customerInfo.encgid;
            } else {
                str = null;
            }
            homeScreenTracker.trackHomeLoad(str, instance.getSelectedCustomerAddress());
            getHomeScreenPerformanceObservability().generateTraceId();
            setHomeToolBar();
            invokeRefreshHomeListeners();
            PreWarmedEngines.INSTANCE.removeWarmedUpEngine(PreWarmedEngines.ENGINE_FOR_SEARCH);
            if (i12 == -1 && (num = this.tabToSelectUponLocationSelection) != null) {
                Intrinsics.checkNotNull(num);
                setSelectedTabId(num.intValue());
                this.tabToSelectUponLocationSelection = null;
            }
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        PreWarmedFlutterFragment preWarmedFlutterFragment;
        if (isFlutterOrderListEnabled()) {
            onSetBottomNavigation(true);
        }
        try {
            Result.Companion companion = Result.Companion;
            Fragment fragment = getSupportFragmentManager().getFragments().get(0).getChildFragmentManager().getFragments().get(0);
            Unit unit = null;
            if (fragment instanceof PreWarmedFlutterFragment) {
                preWarmedFlutterFragment = (PreWarmedFlutterFragment) fragment;
            } else {
                preWarmedFlutterFragment = null;
            }
            if (preWarmedFlutterFragment != null) {
                preWarmedFlutterFragment.onBackPressed();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                super.onBackPressed();
            }
            Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public void onBannerClick(@NotNull BannerAdItem bannerAdItem) {
        Intrinsics.checkNotNullParameter(bannerAdItem, "bannerAdItem");
        IntegrationGlobalDataModel.Companion.setHomeMapRedirect(getContext());
        onBannerClicked(bannerAdItem, GlobalDataModel.SelectedAreaName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A[Catch:{ all -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074 A[Catch:{ all -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3 A[Catch:{ Exception -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x019f A[Catch:{ Exception -> 0x0213 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b3 A[Catch:{ Exception -> 0x0213 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01c1 A[Catch:{ Exception -> 0x0213 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01cc A[Catch:{ Exception -> 0x0213 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d1 A[Catch:{ Exception -> 0x0213 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01f5 A[Catch:{ Exception -> 0x0213 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r27) {
        /*
            r26 = this;
            r15 = r26
            java.lang.String r0 = "home"
            com.talabat.observability.localTracer.PointOfInterestReporter r1 = com.talabat.observability.localTracer.PointOfInterestReporter.INSTANCE     // Catch:{ Exception -> 0x0219 }
            com.talabat.observability.localTracer.SectionOfInterest r2 = com.talabat.observability.localTracer.SectionOfInterest.HOME_SCREEN_ACTIVITY     // Catch:{ Exception -> 0x0219 }
            com.talabat.observability.localTracer.PointOfInterest r3 = com.talabat.observability.localTracer.PointOfInterest.TOTAL_TIME     // Catch:{ Exception -> 0x0219 }
            r1.startTraceLog(r2, r3)     // Catch:{ Exception -> 0x0219 }
            r26.inject()     // Catch:{ Exception -> 0x0219 }
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r1 = r26.getHomeScreenPerformanceObservability()     // Catch:{ Exception -> 0x0219 }
            r1.generateTraceId()     // Catch:{ Exception -> 0x0219 }
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r2 = r26.getHomeScreenPerformanceObservability()     // Catch:{ Exception -> 0x0219 }
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r3 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO     // Catch:{ Exception -> 0x0219 }
            java.lang.String r4 = "homeScreenActivity.onCreate"
            r5 = 0
            r6 = 4
            r7 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0219 }
            super.onCreate(r27)     // Catch:{ Exception -> 0x0219 }
            com.talabat.observability.performance.PerformanceTracker r1 = com.talabat.observability.performance.PerformanceTracker.INSTANCE     // Catch:{ Exception -> 0x0219 }
            java.lang.String r2 = "appStartToInteractive"
            java.lang.String r3 = "HomeScreenFlow"
            r1.addAppFlowTraceAttribute(r2, r3)     // Catch:{ Exception -> 0x0219 }
            com.talabat.core.observabilityNew.domain.IScreenTracker r1 = r26.getScreenTracker()     // Catch:{ Exception -> 0x0219 }
            com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams r2 = new com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams     // Catch:{ Exception -> 0x0219 }
            java.lang.String r3 = "homeScreen"
            r2.<init>(r0, r3, r0)     // Catch:{ Exception -> 0x0219 }
            r1.startTrace(r2)     // Catch:{ Exception -> 0x0219 }
            r0 = 2131623995(0x7f0e003b, float:1.8875157E38)
            r15.setContentView((int) r0)     // Catch:{ Exception -> 0x0219 }
            r1 = 1
            r2 = 0
            r14 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0092 }
            android.content.Intent r0 = r26.getIntent()     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x005f
            java.lang.String r3 = "navigatorData"
            android.os.Parcelable r0 = r0.getParcelableExtra(r3)     // Catch:{ all -> 0x0092 }
            com.talabat.core.navigation.domain.screen.home.DeeplinkHomeScreen$DeeplinkHomeScreenData r0 = (com.talabat.core.navigation.domain.screen.home.DeeplinkHomeScreen.DeeplinkHomeScreenData) r0     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = r0.getDeeplink()     // Catch:{ all -> 0x0092 }
            goto L_0x0060
        L_0x005f:
            r0 = r14
        L_0x0060:
            if (r0 == 0) goto L_0x006b
            int r3 = r0.length()     // Catch:{ all -> 0x0092 }
            if (r3 != 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r3 = r2
            goto L_0x006c
        L_0x006b:
            r3 = r1
        L_0x006c:
            if (r3 != 0) goto L_0x0074
            r15.deepLinkReceived(r0)     // Catch:{ all -> 0x0092 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0092 }
            goto L_0x008d
        L_0x0074:
            android.content.Intent r0 = r26.getIntent()     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x008c
            android.os.Bundle r0 = r0.getExtras()     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x008c
            java.lang.String r3 = "VOUCHER_DEEP_LINK"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0092 }
            if (r3 == 0) goto L_0x008d
            r15.deepLinkReceived(r3)     // Catch:{ all -> 0x0092 }
            goto L_0x008d
        L_0x008c:
            r0 = r14
        L_0x008d:
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0092 }
            goto L_0x009d
        L_0x0092:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0219 }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ Exception -> 0x0219 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ Exception -> 0x0219 }
        L_0x009d:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r0)     // Catch:{ Exception -> 0x0219 }
            if (r0 == 0) goto L_0x00a6
            com.talabat.talabatcore.logger.LogManager.logException(r0)     // Catch:{ Exception -> 0x0219 }
        L_0x00a6:
            android.content.Intent r0 = r26.getIntent()     // Catch:{ Exception -> 0x0219 }
            java.lang.String r3 = "is_from_location_welcome"
            boolean r0 = r0.getBooleanExtra(r3, r2)     // Catch:{ Exception -> 0x0219 }
            r15.isFromLocationWelcomeScreen = r0     // Catch:{ Exception -> 0x0219 }
            android.content.Intent r0 = r26.getIntent()     // Catch:{ Exception -> 0x0219 }
            java.lang.String r3 = "is_load_map_welcome"
            boolean r0 = r0.getBooleanExtra(r3, r2)     // Catch:{ Exception -> 0x0219 }
            r15.isLoadMapFromWelcome = r0     // Catch:{ Exception -> 0x0219 }
            android.content.Intent r0 = r26.getIntent()     // Catch:{ Exception -> 0x0219 }
            java.lang.String r3 = "is_show_map_search"
            boolean r0 = r0.getBooleanExtra(r3, r2)     // Catch:{ Exception -> 0x0219 }
            r15.isShowMapSearch = r0     // Catch:{ Exception -> 0x0219 }
            android.content.Intent r0 = r26.getIntent()     // Catch:{ Exception -> 0x0219 }
            java.lang.String r3 = "redirect_map_country_selection"
            boolean r0 = r0.getBooleanExtra(r3, r2)     // Catch:{ Exception -> 0x0219 }
            r15.isRedirectMapAfterCountrySelection = r0     // Catch:{ Exception -> 0x0219 }
            android.content.Intent r0 = r26.getIntent()     // Catch:{ Exception -> 0x0219 }
            java.lang.String r3 = "should_show_force_location_selection"
            boolean r0 = r0.getBooleanExtra(r3, r2)     // Catch:{ Exception -> 0x0219 }
            r15.shouldForceLocationSelection = r0     // Catch:{ Exception -> 0x0219 }
            com.talabat.home.di.HomeScreenDependencyProvider r0 = com.talabat.home.di.HomeScreenDependencyProvider.INSTANCE     // Catch:{ Exception -> 0x0219 }
            library.talabat.mvp.home.domain.impl.ShouldShowLocationSelectionInHomeUseCaseImpl r8 = new library.talabat.mvp.home.domain.impl.ShouldShowLocationSelectionInHomeUseCaseImpl     // Catch:{ Exception -> 0x0219 }
            com.talabat.home.HomeScreenActivity$onCreate$3 r3 = new com.talabat.home.HomeScreenActivity$onCreate$3     // Catch:{ Exception -> 0x0219 }
            r3.<init>(r15)     // Catch:{ Exception -> 0x0219 }
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0219 }
            library.talabat.mvp.home.domain.impl.EnableShowLocationSelectionInHomeScreenUseCaseImpl r4 = new library.talabat.mvp.home.domain.impl.EnableShowLocationSelectionInHomeScreenUseCaseImpl     // Catch:{ Exception -> 0x0219 }
            r4.<init>(r14, r1, r14)     // Catch:{ Exception -> 0x0219 }
            io.reactivex.Scheduler r5 = io.reactivex.schedulers.Schedulers.io()     // Catch:{ Exception -> 0x0219 }
            io.reactivex.Scheduler r6 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()     // Catch:{ Exception -> 0x0219 }
            com.talabat.configuration.discovery.AppVersionProvider r7 = r26.getAppVersionProvider()     // Catch:{ Exception -> 0x0219 }
            com.talabat.configuration.ConfigurationLocalRepository r9 = r26.getConfigurationLocalRepository()     // Catch:{ Exception -> 0x0219 }
            com.talabat.configuration.MutableLocationConfigurationRepository r10 = r26.getMutableLocationConfigurationRepository()     // Catch:{ Exception -> 0x0219 }
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r11 = r26.getTalabatFeatureFlag()     // Catch:{ Exception -> 0x0219 }
            com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase r12 = r26.getGetOverdueUseCase()     // Catch:{ Exception -> 0x0219 }
            com.talabat.core.observabilityNew.domain.IObservabilityManager r13 = r26.getObservabilityManager()     // Catch:{ Exception -> 0x0219 }
            com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase r16 = r26.getGetOverdueNotificationAcknowledgeUseCase()     // Catch:{ Exception -> 0x0219 }
            com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase r17 = r26.getUpdateOverdueAcknowledgeStateUseCase()     // Catch:{ Exception -> 0x0219 }
            library.talabat.mvp.home.domain.GetActiveCartInfoUseCase r18 = r26.getGetActiveCartInfoUseCase()     // Catch:{ Exception -> 0x0219 }
            com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase r19 = r26.getShouldRateLastOrderUseCase()     // Catch:{ Exception -> 0x0219 }
            com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r1 = r26.getCoroutineDispatchersFactory()     // Catch:{ Exception -> 0x0219 }
            kotlinx.coroutines.CoroutineDispatcher r20 = r1.io()     // Catch:{ Exception -> 0x0219 }
            com.talabat.customer.domain.CustomerRepository r21 = r26.getCustomerRepository()     // Catch:{ Exception -> 0x0219 }
            com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase r22 = r26.isOnboardingExperimentEnabledUseCase()     // Catch:{ Exception -> 0x0219 }
            library.talabat.mvp.home.IsNfvFlutterNavigationUsecase r23 = r26.isNfvFlutterNavigationUsecase()     // Catch:{ Exception -> 0x0219 }
            com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r24 = r26.getCoroutineDispatchersFactory()     // Catch:{ Exception -> 0x0219 }
            java.lang.String r1 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch:{ Exception -> 0x0219 }
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch:{ Exception -> 0x0219 }
            r1 = r0
            r2 = r26
            r3 = r8
            r8 = r9
            r9 = r13
            r13 = r16
            r25 = r14
            r14 = r17
            r15 = r18
            r16 = r19
            r17 = r20
            r18 = r21
            r19 = r22
            r20 = r24
            r21 = r23
            library.talabat.mvp.home.HomePresenter r1 = r1.provideHomePresenter(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0215 }
            r2 = r26
            r2.homePresenter = r1     // Catch:{ Exception -> 0x0213 }
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r1 = r26.getTalabatFeatureFlag()     // Catch:{ Exception -> 0x0213 }
            com.talabat.feature.rating.domain.EventTracker r3 = r26.getRatingEventTracker()     // Catch:{ Exception -> 0x0213 }
            com.talabat.rating.presenter.OrderRatingPresenter r0 = r0.provideOrderRatingPresenter(r2, r1, r3)     // Catch:{ Exception -> 0x0213 }
            r2.orderRatingPresenter = r0     // Catch:{ Exception -> 0x0213 }
            r26.iniThirdPartyGlobal()     // Catch:{ Exception -> 0x0213 }
            com.talabat.screenrecorder.ScreenRecorder r0 = r2.screenRecorder     // Catch:{ Exception -> 0x0213 }
            r0.startScreenRecording(r2)     // Catch:{ Exception -> 0x0213 }
            com.talabat.home.HomeScreenActivity$onCreate$4 r0 = new com.talabat.home.HomeScreenActivity$onCreate$4     // Catch:{ Exception -> 0x0213 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0213 }
            r2.onWindow(r0)     // Catch:{ Exception -> 0x0213 }
            com.talabat.home.HomeScreenActivity$onCreate$5 r0 = new com.talabat.home.HomeScreenActivity$onCreate$5     // Catch:{ Exception -> 0x0213 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0213 }
            r2.fetchTabVariants(r0)     // Catch:{ Exception -> 0x0213 }
            r26.setHomeToolBar()     // Catch:{ Exception -> 0x0213 }
            r26.snapToAddressOrCurrentLocation()     // Catch:{ Exception -> 0x0213 }
            r26.setGoogleAdId()     // Catch:{ Exception -> 0x0213 }
            boolean r0 = com.talabat.helpers.GlobalConstants.NormalUpdate.IS_NORMAL_UPDATE     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x01a9
            java.lang.String r0 = com.talabat.helpers.GlobalConstants.NormalUpdate.NORMAL_UPDATE_MSG     // Catch:{ Exception -> 0x0213 }
            java.lang.String r1 = "NORMAL_UPDATE_MSG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0213 }
            r2.updatePopUp(r0)     // Catch:{ Exception -> 0x0213 }
        L_0x01a9:
            r26.firebaseIndexingInit()     // Catch:{ Exception -> 0x0213 }
            r26.clearCartInCaseOfDarkstores()     // Catch:{ Exception -> 0x0213 }
            library.talabat.mvp.home.IHomePresenter r0 = r2.homePresenter     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x01c1
            boolean r1 = r26.redirectBackToHomeAfterWelcomeWithVertical()     // Catch:{ Exception -> 0x0213 }
            boolean r3 = r2.isRedirectMapAfterCountrySelection     // Catch:{ Exception -> 0x0213 }
            boolean r4 = r2.shouldForceLocationSelection     // Catch:{ Exception -> 0x0213 }
            r0.onCreate(r1, r3, r4)     // Catch:{ Exception -> 0x0213 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0213 }
            goto L_0x01c3
        L_0x01c1:
            r14 = r25
        L_0x01c3:
            r26.showRedeemVoucherDetailsBottomSheet()     // Catch:{ Exception -> 0x0213 }
            android.content.Intent r0 = r26.getIntent()     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x01d1
            android.os.Bundle r14 = r0.getExtras()     // Catch:{ Exception -> 0x0213 }
            goto L_0x01d3
        L_0x01d1:
            r14 = r25
        L_0x01d3:
            r2.handleDeepLink((android.os.Bundle) r14)     // Catch:{ Exception -> 0x0213 }
            android.content.Intent r0 = r26.getIntent()     // Catch:{ all -> 0x01e4 }
            r2.handleTabSelectionViaIntent(r0)     // Catch:{ all -> 0x01e4 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01e4 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x01e4 }
            goto L_0x01ef
        L_0x01e4:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0213 }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ Exception -> 0x0213 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ Exception -> 0x0213 }
        L_0x01ef:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r0)     // Catch:{ Exception -> 0x0213 }
            if (r0 == 0) goto L_0x01f8
            com.talabat.talabatcore.logger.LogManager.logException(r0)     // Catch:{ Exception -> 0x0213 }
        L_0x01f8:
            com.talabat.observability.squads.discovery.AppLaunchTrackingManger r0 = com.talabat.observability.squads.discovery.AppLaunchTrackingManger.INSTANCE     // Catch:{ Exception -> 0x0213 }
            boolean r1 = r26.isAppInfoCacheFlagEnabled()     // Catch:{ Exception -> 0x0213 }
            r0.setPerfomanceABTest(r1)     // Catch:{ Exception -> 0x0213 }
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r3 = r26.getHomeScreenPerformanceObservability()     // Catch:{ Exception -> 0x0213 }
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r4 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO     // Catch:{ Exception -> 0x0213 }
            java.lang.String r5 = "homeScreenActivity.onCreate"
            r6 = 0
            r7 = 4
            r8 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0213 }
            r26.showOrderListBadge()     // Catch:{ Exception -> 0x0213 }
            goto L_0x0221
        L_0x0213:
            r0 = move-exception
            goto L_0x021b
        L_0x0215:
            r0 = move-exception
            r2 = r26
            goto L_0x021b
        L_0x0219:
            r0 = move-exception
            r2 = r15
        L_0x021b:
            com.talabat.talabatcore.logger.LogManager.logException(r0)
            r26.finish()
        L_0x0221:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.home.HomeScreenActivity.onCreate(android.os.Bundle):void");
    }

    public void onCurrentLocationReceived(@Nullable LatLng latLng, boolean z11, float f11) {
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull LatLng latLng, float f11) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public void onDeepLinkNavigateToTproBenefits() {
        super.onDeepLinkNavigateToTproBenefits();
        hideLoading();
    }

    public void onEntryPointClicked(@NotNull EntryPointItem entryPointItem) {
        Intrinsics.checkNotNullParameter(entryPointItem, "entryPointItem");
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        companion.saveVertical(getContext(), entryPointItem.getDeepLink(), entryPointItem.getId());
        SharedPreferencesManager instance = SharedPreferencesManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        companion.saveMoreTileVerticalIds(instance, entryPointItem.getVerticalIds());
        companion.setHomeMapRedirect(getContext());
        onVerticalSelection(entryPointItem.getId(), entryPointItem.getTitle(), entryPointItem.getVerticalIds());
    }

    public void onError() {
    }

    public void onFragmentAttached(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (fragment instanceof FluidHomeScreenFragment) {
            this.homeScreenInteractionListener = (HomeScreenFragmentInteractionListener) fragment;
        }
    }

    public void onGemExpired() {
        HomeScreenFragmentInteractionListener homeScreenFragmentInteractionListener = this.homeScreenInteractionListener;
        if (homeScreenFragmentInteractionListener != null) {
            homeScreenFragmentInteractionListener.onGemExpired();
        }
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
    }

    public void onHomeFlutterAttached(@NotNull HomeChannelFlutterDomain homeChannelFlutterDomain, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(homeChannelFlutterDomain, "homeChannelFlutterDomain");
        if (fromFlutterHome(bundle)) {
            this.homeChannelFlutterDomainDeque.push(homeChannelFlutterDomain);
            IHomePresenter iHomePresenter = this.homePresenter;
            if (iHomePresenter != null) {
                iHomePresenter.onFlutterHomeAttached();
            }
        }
    }

    public void onHomeFlutterDetached(@NotNull HomeChannelFlutterDomain homeChannelFlutterDomain, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(homeChannelFlutterDomain, "homeChannelFlutterDomain");
        if (fromFlutterHome(bundle)) {
            this.homeChannelFlutterDomainDeque.remove(homeChannelFlutterDomain);
        }
    }

    public void onNetworkError() {
    }

    public void onPromotionsWidgetClicked(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        boolean z11;
        boolean z12;
        String str4 = "";
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "deeplink");
        Intrinsics.checkNotNullParameter(str3, CustomerInfoLocalDataSourceImpl.KEY);
        if (str2.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            startLodingPopup();
            try {
                String query = Uri.parse(str2).getQuery();
                if (query != null) {
                    str4 = query;
                }
            } catch (Exception unused) {
            }
            if (str4.length() > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) "tpro", false, 2, (Object) null)) {
                    DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, context, new SubscriptionBenefitsDeeplinkBuilder().build(), (Function0) null, 4, (Object) null);
                } else {
                    getDeepLinkPresenter().deepLinkRecived(str4);
                    disableBrandMenu(true);
                    getDeepLinkPresenter().redirectToDeepLink();
                }
            }
        }
        hideLoading();
        AppTracker.onDarkstoresComponentClicked(this, str3, "campaign_carousel", "home");
    }

    public void onResume() {
        super.onResume();
        resetAddressName();
        IHomePresenter iHomePresenter = this.homePresenter;
        if (iHomePresenter != null) {
            iHomePresenter.setCartView();
        }
        observerVoucherState();
        observerProStatus();
    }

    public final void onSetBottomNavigation(boolean z11) {
        ((BottomNavigationView) _$_findCachedViewById(R.id.home_nav)).setVisibility(z11 ? 0 : 8);
    }

    public void onStart() {
        super.onStart();
        try {
            FirebaseUserActions.getInstance(getContext()).start(getAction());
            FirebaseAppIndex.getInstance(getContext()).update(getIndexable());
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void onStop() {
        try {
            Task<Void> end = FirebaseUserActions.getInstance(getContext()).end(getAction());
            Intrinsics.checkNotNullExpressionValue(end, "getInstance(context).end(getAction())");
            end.addOnSuccessListener((Activity) this, (OnSuccessListener<? super Void>) new b());
            end.addOnFailureListener((Activity) this, (OnFailureListener) new c());
        } catch (Exception e11) {
            e11.printStackTrace();
        } catch (Throwable th2) {
            super.onStop();
            throw th2;
        }
        super.onStop();
    }

    public final void onVerticalSelection(int i11, @NotNull String str, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "verticalName");
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        TalabatExperiment talabatExperiment2 = TalabatExperiment.INSTANCE;
        FWFAttributes fWFAttributes = FWFAttributes.LOCATION_COUNTRY;
        String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
        Intrinsics.checkNotNullExpressionValue(selectedCountryIso, "getSelectedCountryIso()");
        talabatExperiment2.setAttribute(fWFAttributes, selectedCountryIso, TalabatExperimentDataSourceStrategy.APPTIMIZE);
        IHomePresenter iHomePresenter = this.homePresenter;
        if (iHomePresenter != null) {
            iHomePresenter.onVerticalClicked(i11, str, list);
        }
    }

    public void openBasketListScreen() {
        startActivity(BasketListActivity.Companion.getIntent(this));
    }

    public void openFoodBasketScreen() {
        if (getTalabatFeatureFlag().getFeatureFlag(OrderingFeatureFlagsKeys.FLUTTER_HOME_CART_DEEPLINK_ENABLED, false)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new HomeScreenActivity$openFoodBasketScreen$1(this, "talabat://?s=cart?shopClickOrigin=", (Continuation<? super HomeScreenActivity$openFoodBasketScreen$1>) null), 3, (Object) null);
        } else {
            navigateFromHomeToCart();
        }
    }

    public void openQCommerceBasketScreen(@NotNull Restaurant restaurant) {
        Restaurant restaurant2 = restaurant;
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        DarkstoresNavigator.DefaultImpls.navigateToDarkStore$default(getDarkstoresNavigator(), this, restaurant2, Integer.valueOf(DarkstoreNavigationType.CART.getType()), (String) null, (String) null, (String) null, false, (String) null, (String) null, "basket_icon", (String) null, (DarkstoresTrackingData) null, 3568, (Object) null);
    }

    public void outSideCountry(int i11) {
        IHomePresenter iHomePresenter = this.homePresenter;
        if (iHomePresenter != null) {
            iHomePresenter.resetToolBarLocationTitle();
        }
    }

    public void redirectToChooseSavedAddressScreen(boolean z11) {
        Intent intent = new Intent(this, ChooseSavedAddressScreen.class);
        if (this.currentLocationFetch == null) {
            this.currentLocationFetch = new CurrentLocationFetch(this, this);
        }
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        if (currentLocationFetch2.userAllowedAllLocationPermissions(this)) {
            CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
            Intrinsics.checkNotNull(currentLocationFetch3);
            currentLocationFetch3.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_INIT_CL_BG());
            CurrentLocationFetch currentLocationFetch4 = this.currentLocationFetch;
            Intrinsics.checkNotNull(currentLocationFetch4);
            currentLocationFetch4.fetchCurrentLocation();
            intent.putExtra(GlobalConstants.ExtraNames.IS_FETCHING_CL, true);
        }
        intent.putExtra("fromHome", z11);
        startActivityForResult(intent, 50);
        overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.nothing);
    }

    public void redirectToHomeMapScreen(boolean z11, @NotNull String str, boolean z12) {
        String str2;
        LatLng areaCenterLatLg;
        Intrinsics.checkNotNullParameter(str, "userSelectedAddress");
        if (this.currentLocationFetch == null) {
            this.currentLocationFetch = new CurrentLocationFetch(this, this);
        }
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        if (currentLocationFetch2.userAllowedAllLocationPermissions(this)) {
            CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
            Intrinsics.checkNotNull(currentLocationFetch3);
            currentLocationFetch3.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_SAVED_LOC());
            CurrentLocationFetch currentLocationFetch4 = this.currentLocationFetch;
            Intrinsics.checkNotNull(currentLocationFetch4);
            currentLocationFetch4.fetchCurrentLocation();
        } else {
            GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME = null;
            GlobalDataModel.HOME_SCREEN_MAP.ADDRESS_FUSED_LOCATON = null;
        }
        if (!z11 || (areaCenterLatLg = HomeMapUtils.INSTANCE.areaCenterLatLg(GlobalDataModel.SelectedAreaId, getMutableLocationConfigurationRepository())) == null) {
            str2 = "";
        } else {
            str2 = areaCenterLatLg.latitude + "," + areaCenterLatLg.longitude;
        }
        Intent intent = new Intent(this, HomeScreenMap.class);
        intent.putExtra("areaLatLng", str2);
        intent.putExtra("fromHome", z12);
        intent.putExtra("isIgnoreCurrentLocation", z11);
        intent.putExtra("UserSelectedAddress", str);
        intent.putExtra("is_show_map_search", this.isShowMapSearch);
        intent.putExtra(GlobalConstants.ExtraNames.IS_REDIRECT_BACK_HOME_IF_VERTICAL, redirectBackToHomeAfterWelcomeWithVertical());
        this.isShowMapSearch = false;
        startActivityForResult(intent, 50);
    }

    public void redirectToSearchScreen() {
        List<VerticalItem> list;
        if (isLocationSelected()) {
            HomeScreenFragmentInteractionListener homeScreenFragmentInteractionListener = this.homeScreenInteractionListener;
            if (homeScreenFragmentInteractionListener == null || (list = homeScreenFragmentInteractionListener.getAvailableVerticals()) == null) {
                list = this.verticalItemsFromFlutter;
            }
            showSearchFlutterFragment(new AvailableVerticalsUseCase(new ShowMoreInHomeSearchUseCase(getTalabatFeatureFlag())).invoke(list));
            return;
        }
        IHomePresenter iHomePresenter = this.homePresenter;
        if (iHomePresenter != null) {
            iHomePresenter.toolbarLocationSelection();
        }
    }

    public void refreshHomeScreen() {
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = getHomeScreenPerformanceObservability();
        homeScreenPerformanceObservability2.generateTraceId();
        HomeScreenPerformanceObservability.DefaultImpls.traceEvent$default(homeScreenPerformanceObservability2, HomeScreenPerformanceObservability.Level.INFO, "homeScreenActivity.refreshHomeScreen", (Map) null, 4, (Object) null);
        invokeRefreshHomeListeners();
    }

    public void resetAddressName() {
        IHomePresenter iHomePresenter = this.homePresenter;
        if (iHomePresenter != null) {
            iHomePresenter.setToolBarLocation();
        }
    }

    public void resetCacheEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "resetWhen");
        EventsCache.INSTANCE.remove(str);
    }

    public void resetCurrentLocationObserver() {
        GlobalDataModel.JSON.CurrentLocationFromStart.setValue(null);
    }

    public final void setAppVersionProvider(@NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "<set-?>");
        this.appVersionProvider = appVersionProvider2;
    }

    public final void setCampaignMigratorSharedPreferences(@NotNull CampaignMigratorSharedPreferences campaignMigratorSharedPreferences2) {
        Intrinsics.checkNotNullParameter(campaignMigratorSharedPreferences2, "<set-?>");
        this.campaignMigratorSharedPreferences = campaignMigratorSharedPreferences2;
    }

    public final void setCobrandedVmFactory(@NotNull CobrandedCcViewModelFactory cobrandedCcViewModelFactory) {
        Intrinsics.checkNotNullParameter(cobrandedCcViewModelFactory, "<set-?>");
        this.cobrandedVmFactory = cobrandedCcViewModelFactory;
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCoroutineDispatchersFactory(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "<set-?>");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    public final void setCurrentLocationFetch(@Nullable CurrentLocationFetch currentLocationFetch2) {
        this.currentLocationFetch = currentLocationFetch2;
    }

    public void setCurrentLocationFromBeginning() {
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = getHomeScreenPerformanceObservability();
        HomeScreenPerformanceObservability.Level level = HomeScreenPerformanceObservability.Level.INFO;
        HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(homeScreenPerformanceObservability2, level, "homeScreenActivity.setCurrentLocationFromBeginning", (Map) null, 4, (Object) null);
        MutableLiveData<LatLng> mutableLiveData = GlobalDataModel.JSON.CurrentLocationFromStart;
        if (mutableLiveData == null) {
            IHomePresenter iHomePresenter = this.homePresenter;
            if (iHomePresenter != null) {
                iHomePresenter.trackAddressSnappingWithoutGps();
            }
        } else if (mutableLiveData.getValue() != null) {
            LatLng value = GlobalDataModel.JSON.CurrentLocationFromStart.getValue();
            Intrinsics.checkNotNull(value);
            if (value.latitude > 0.0d) {
                LatLng value2 = GlobalDataModel.JSON.CurrentLocationFromStart.getValue();
                Intrinsics.checkNotNull(value2);
                if (value2.longitude > 0.0d) {
                    IHomePresenter iHomePresenter2 = this.homePresenter;
                    Intrinsics.checkNotNull(iHomePresenter2);
                    iHomePresenter2.LocationBasedAddressSelection(GlobalDataModel.JSON.CurrentLocationFromStart.getValue());
                }
            }
        } else {
            GlobalDataModel.JSON.CurrentLocationFromStart.observe(this, new d(this));
            IHomePresenter iHomePresenter3 = this.homePresenter;
            if (iHomePresenter3 != null) {
                iHomePresenter3.trackAddressSnappingWithoutGps();
            }
        }
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(getHomeScreenPerformanceObservability(), level, "homeScreenActivity.setCurrentLocationFromBeginning", (Map) null, 4, (Object) null);
    }

    public final void setCustomerRepository(@NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(customerRepository2, "<set-?>");
        this.customerRepository = customerRepository2;
    }

    public final void setDarkstoresNavigator(@NotNull DarkstoresNavigator darkstoresNavigator2) {
        Intrinsics.checkNotNullParameter(darkstoresNavigator2, "<set-?>");
        this.darkstoresNavigator = darkstoresNavigator2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setFactory(@NotNull VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory) {
        Intrinsics.checkNotNullParameter(voucherEntryPointViewModelFactory, "<set-?>");
        this.factory = voucherEntryPointViewModelFactory;
    }

    public final void setGetActiveCartInfoUseCase(@NotNull GetActiveCartInfoUseCase getActiveCartInfoUseCase2) {
        Intrinsics.checkNotNullParameter(getActiveCartInfoUseCase2, "<set-?>");
        this.getActiveCartInfoUseCase = getActiveCartInfoUseCase2;
    }

    public final void setGetOverdueNotificationAcknowledgeUseCase(@NotNull GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase2) {
        Intrinsics.checkNotNullParameter(getOverdueNotificationAcknowledgeUseCase2, "<set-?>");
        this.getOverdueNotificationAcknowledgeUseCase = getOverdueNotificationAcknowledgeUseCase2;
    }

    public final void setGetOverdueUseCase(@NotNull GetOverdueUseCase getOverdueUseCase2) {
        Intrinsics.checkNotNullParameter(getOverdueUseCase2, "<set-?>");
        this.getOverdueUseCase = getOverdueUseCase2;
    }

    public final void setHomePresenter(@Nullable IHomePresenter iHomePresenter) {
        this.homePresenter = iHomePresenter;
    }

    public final void setHomeScreenPerformanceObservability(@NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability2) {
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability2, "<set-?>");
        this.homeScreenPerformanceObservability = homeScreenPerformanceObservability2;
    }

    public final void setMutableLocationConfigurationRepository(@NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository2, "<set-?>");
        this.mutableLocationConfigurationRepository = mutableLocationConfigurationRepository2;
    }

    public final void setNavigator(@NotNull com.talabat.core.navigation.domain.Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setNfvFlutterNavigationUsecase(@NotNull IsNfvFlutterNavigationUsecase isNfvFlutterNavigationUsecase2) {
        Intrinsics.checkNotNullParameter(isNfvFlutterNavigationUsecase2, "<set-?>");
        this.isNfvFlutterNavigationUsecase = isNfvFlutterNavigationUsecase2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setOnboardingExperimentEnabledUseCase(@NotNull IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase2) {
        Intrinsics.checkNotNullParameter(isOnboardingExperimentEnabledUseCase2, "<set-?>");
        this.isOnboardingExperimentEnabledUseCase = isOnboardingExperimentEnabledUseCase2;
    }

    public final void setRatingSession(@NotNull RatingSession ratingSession2) {
        Intrinsics.checkNotNullParameter(ratingSession2, "<set-?>");
        this.ratingSession = ratingSession2;
    }

    public final void setScreenTracker(@NotNull IScreenTracker iScreenTracker) {
        Intrinsics.checkNotNullParameter(iScreenTracker, "<set-?>");
        this.screenTracker = iScreenTracker;
    }

    public void setSelectedVertical(int i11) {
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        companion.saveVertical(getContext(), "", i11);
        SharedPreferencesManager instance = SharedPreferencesManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        companion.saveMoreTileVerticalIds(instance, CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i11)));
    }

    public final void setShouldRateLastOrderUseCase(@NotNull ShouldRateLastOrderUseCase shouldRateLastOrderUseCase2) {
        Intrinsics.checkNotNullParameter(shouldRateLastOrderUseCase2, "<set-?>");
        this.shouldRateLastOrderUseCase = shouldRateLastOrderUseCase2;
    }

    public final void setSubscriptionSharedPrefManager(@NotNull SubscriptionSharedPrefManager subscriptionSharedPrefManager2) {
        Intrinsics.checkNotNullParameter(subscriptionSharedPrefManager2, "<set-?>");
        this.subscriptionSharedPrefManager = subscriptionSharedPrefManager2;
    }

    public final void setTalabatExperiment(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "<set-?>");
        this.talabatExperiment = iTalabatExperiment;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setTalabatTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "<set-?>");
        this.talabatTracker = talabatTracker2;
    }

    public void setToolBarAddressLocationTitle(@Nullable String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(R.id.header_view);
            if (homeScreenHeaderView != null) {
                if (str == null) {
                    str = getResources().getString(R.string.set_deliver_location_short);
                    Intrinsics.checkNotNullExpressionValue(str, "resources\n              …t_deliver_location_short)");
                }
                homeScreenHeaderView.setAddressText(str);
                return;
            }
            return;
        }
        HomeScreenHeaderView homeScreenHeaderView2 = (HomeScreenHeaderView) _$_findCachedViewById(R.id.header_view);
        if (homeScreenHeaderView2 != null) {
            String string = getResources().getString(R.string.set_deliver_location_short);
            Intrinsics.checkNotNullExpressionValue(string, "resources\n              …t_deliver_location_short)");
            homeScreenHeaderView2.setAddressText(string);
        }
    }

    public final void setUpdateOverdueAcknowledgeStateUseCase(@NotNull UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase2) {
        Intrinsics.checkNotNullParameter(updateOverdueAcknowledgeStateUseCase2, "<set-?>");
        this.updateOverdueAcknowledgeStateUseCase = updateOverdueAcknowledgeStateUseCase2;
    }

    public void setupAccountTab(boolean z11) {
        int i11;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.home_nav);
        if (z11) {
            i11 = R.drawable.ic_account_filled_pro;
        } else {
            i11 = R.drawable.ds_profile_filled;
        }
        Drawable drawable = AppCompatResources.getDrawable(this, i11);
        MenuItem findItem = bottomNavigationView.getMenu().findItem(R.id.account_nav);
        if (findItem != null) {
            findItem.setIcon(drawable);
        }
    }

    public void showCartView(@NotNull ActiveCartInfo activeCartInfo) {
        Pair pair;
        Intrinsics.checkNotNullParameter(activeCartInfo, "activeCartInfo");
        boolean z11 = activeCartInfo instanceof ActiveCartInfo.FoodCart;
        Integer valueOf = Integer.valueOf(R.drawable.ds_bag_filled);
        if (z11) {
            pair = TuplesKt.to(Integer.valueOf(((ActiveCartInfo.FoodCart) activeCartInfo).getItemCount()), valueOf);
        } else if (activeCartInfo instanceof ActiveCartInfo.QcommerceCart) {
            pair = TuplesKt.to(Integer.valueOf(((ActiveCartInfo.QcommerceCart) activeCartInfo).getItemCount()), valueOf);
        } else if (activeCartInfo instanceof ActiveCartInfo.MultipleCarts) {
            pair = TuplesKt.to(0, Integer.valueOf(R.drawable.ds_multi_basket));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(R.id.header_view);
        if (homeScreenHeaderView != null) {
            homeScreenHeaderView.showBasket();
            homeScreenHeaderView.updateBasketOrderCount(intValue);
            homeScreenHeaderView.updateBasketIcon(intValue2);
            homeScreenHeaderView.onBasketClicked(new HomeScreenActivity$showCartView$1$1(this, activeCartInfo));
        }
    }

    public void showItemReplacementBottomSheet(@NotNull ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo itemReplacementInfo) {
        Intrinsics.checkNotNullParameter(itemReplacementInfo, CustomerInfoLocalDataSourceImpl.KEY);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        DSBottomSheet findDSBottomSheet = DSFragmentManagerExtensionsKt.findDSBottomSheet(supportFragmentManager, ITEM_REPLACEMENT_BS_TAG);
        if (findDSBottomSheet == null) {
            findDSBottomSheet = new DSBottomSheet();
        }
        if (!findDSBottomSheet.isAdded()) {
            ItemReplacementBottomSheetTracker itemReplacementBottomSheetTracker = new ItemReplacementBottomSheetTracker(getTalabatTracker());
            if (itemReplacementInfo.getShouldShowBottomSheet()) {
                findDSBottomSheet.setNavigationBar(createNavigationBar(findDSBottomSheet, itemReplacementBottomSheetTracker, itemReplacementInfo));
                findDSBottomSheet.setBody(ItemReplacementBottomSheetBodyFragment.Companion.newInstance(itemReplacementInfo.getChainName()));
                findDSBottomSheet.setFooter(createFooter(findDSBottomSheet, itemReplacementBottomSheetTracker, itemReplacementInfo));
                findDSBottomSheet.show(getSupportFragmentManager(), ITEM_REPLACEMENT_BS_TAG);
                itemReplacementBottomSheetTracker.trackShowingBottomSheet(itemReplacementInfo.getChainId(), getEventNavigationOrigin(), getScreenName());
            }
        }
    }

    public void showLoading() {
        startLodingPopup();
    }

    public void showLocationFetching() {
        HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(R.id.header_view);
        if (homeScreenHeaderView != null) {
            String string = getResources().getString(R.string.fetching_current_loc);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.fetching_current_loc)");
            homeScreenHeaderView.setAddressText(string);
        }
    }

    public void showNotificationPermissionDialog() {
        checkAndRequestNotificationPermission();
    }

    public void showOverdueNotification() {
        B(this, true, NotificationBadgeSource.BNPL, (VoucherNotificationStyle) null, 4, (Object) null);
    }

    public void showRatingBottomSheet(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        getRatingSession().setRatingShown(true);
        OrderRatingPresenter orderRatingPresenter2 = this.orderRatingPresenter;
        if (orderRatingPresenter2 != null) {
            orderRatingPresenter2.onRateOrderButtonClicked(str);
        }
    }

    public void showRatingBottomSheetForLastOrder(@Nullable String str) {
        if (str != null) {
            showRatingBottomSheet(str);
        }
    }

    public void showTabBarNavigation(boolean z11) {
        onSetBottomNavigation(z11);
    }

    public void showToolBar() {
        if (!GlobalDataModel.isSearchActive) {
            CardView cardView = (CardView) _$_findCachedViewById(R.id.homeToolbar);
            if (cardView != null) {
                cardView.setVisibility(0);
            }
            HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(R.id.header_view);
            if (homeScreenHeaderView != null) {
                homeScreenHeaderView.setVisibility(0);
            }
        }
    }

    public void transitionHeaderColour(int i11) {
        Integer num;
        int i12 = R.id.header_view;
        HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) _$_findCachedViewById(i12);
        if (homeScreenHeaderView != null) {
            num = Integer.valueOf(homeScreenHeaderView.getHeaderBackgroundColor());
        } else {
            num = null;
        }
        if (!(num == null || i11 == num.intValue())) {
            ValueAnimator ofArgb = ValueAnimator.ofArgb(new int[]{num.intValue(), i11});
            ofArgb.setDuration(500);
            ofArgb.addUpdateListener(new e(this));
            ofArgb.start();
        }
        if (i11 == -1) {
            setToolBarElevation(getResources().getDimension(R.dimen.card_view_toolbar_elevation));
            HomeScreenHeaderView homeScreenHeaderView2 = (HomeScreenHeaderView) _$_findCachedViewById(i12);
            if (homeScreenHeaderView2 != null) {
                homeScreenHeaderView2.setCaptionTextColor(homeScreenHeaderView2.getResources().getColor(R.color.ds_neutral_55, getTheme()));
                homeScreenHeaderView2.setAddressTextColor(homeScreenHeaderView2.getResources().getColor(R.color.ds_neutral_100, getTheme()));
                homeScreenHeaderView2.setAddressIconTint(homeScreenHeaderView2.getResources().getColor(R.color.ds_primary_100, getTheme()));
                return;
            }
            return;
        }
        setToolBarElevation(0.0f);
        HomeScreenHeaderView homeScreenHeaderView3 = (HomeScreenHeaderView) _$_findCachedViewById(i12);
        if (homeScreenHeaderView3 != null) {
            FluidHomeScreenIntegrable.Configuration configuration2 = this.configuration;
            if (configuration2 != null) {
                homeScreenHeaderView3.setAddressIconTint(configuration2.getLocationArrowTintColor());
            }
            FluidHomeScreenIntegrable.Configuration configuration3 = this.configuration;
            if (configuration3 != null) {
                homeScreenHeaderView3.setCaptionTextColor(configuration3.getLocationHintColor());
            }
            FluidHomeScreenIntegrable.Configuration configuration4 = this.configuration;
            if (configuration4 != null) {
                homeScreenHeaderView3.setAddressTextColor(configuration4.getLocationTitleColor());
            }
        }
    }

    public void updateVerticals(@NotNull List<? extends Map<String, ? extends Object>> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "verticals");
        VerticalItemViewEntityMapper verticalItemViewEntityMapper = new VerticalItemViewEntityMapper((Gson) null, 1, (DefaultConstructorMarker) null);
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map map : list) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m6329constructorimpl(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) map)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m6335isFailureimpl(obj)) {
                obj = null;
            }
            String str = (String) obj;
            if (str != null) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String verticalItem : arrayList) {
            VerticalItem verticalItem2 = verticalItemViewEntityMapper.getVerticalItem(verticalItem);
            if (verticalItem2 != null) {
                arrayList2.add(verticalItem2);
            }
        }
        this.verticalItemsFromFlutter = arrayList2;
    }

    public void updateVoucherState(@NotNull VoucherStateDomainModel voucherStateDomainModel) {
        Intrinsics.checkNotNullParameter(voucherStateDomainModel, "voucherStateDomainModel");
        new VouchersNotificationBadgeTracker(getTalabatTracker()).trackVouchersNotificationBadgeLoaded(VoucherBadgeEventSource.HOME, voucherStateDomainModel);
        showUserAccountBadge(!StringsKt__StringsJVMKt.isBlank(voucherStateDomainModel.getNotificationLabel()), NotificationBadgeSource.VOUCHERS, voucherStateDomainModel.getNotificationStyle());
    }

    public void userAccountClicked() {
        removeObserverVoucherState();
        hideOverdueNotification();
    }

    @Nullable
    public IHomePresenter getPresenter() {
        return this.homePresenter;
    }

    public void handleDeepLink(@NotNull String str) {
        String str2 = "";
        Intrinsics.checkNotNullParameter(str, "deepLink");
        boolean z11 = false;
        if (str.length() > 0) {
            startLodingPopup();
            try {
                String query = Uri.parse(str).getQuery();
                if (query == null) {
                    query = str2;
                }
                if (query.length() > 0) {
                    z11 = true;
                }
                if (z11) {
                    IDeepLinkPresenter deepLinkPresenter = getDeepLinkPresenter();
                    deepLinkPresenter.deepLinkRecived(query);
                    disableSideMenu(true);
                    deepLinkPresenter.redirectToDeepLink();
                }
            } catch (Exception e11) {
                LogManager.logException(e11);
                String message = e11.getMessage();
                if (message != null) {
                    str2 = message;
                }
                ObservabilityManager.trackUnExpectedScenario("FluidHomeScreenDeepLinkUnParsable", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", str2)));
            }
        }
    }
}
