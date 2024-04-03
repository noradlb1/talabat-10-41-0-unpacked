package com.talabat;

import JsonModels.parser.UniversalGson;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.gson.Gson;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.moshi.Moshi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.ConfigurationRemoteRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfig;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.restaurant.FoodListFlutterScreen;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.pinless.checkout.domain.SetHasUserPinnedLocationInOnboardingMapUseCase;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.home.DaggerHomeScreenMapFragmentComponent;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.domain.location.GeoCoordinateKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.fragments.CustomAutoCompleteFragment;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatToolBarSearchRelativeLayout;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.homemaphelper.HomeMapWrapperLayout;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.FrameworkMap;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.maps.domain.OnMapReadyCallback;
import com.talabat.maps.domain.UiSettingsWrapper;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.Polygon;
import com.talabat.maps.domain.model.PolygonOptions;
import com.talabat.maps.presentation.MapContainerFragment;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.maputils.PolyUtil;
import com.talabat.observability.performance.PerformanceTracker;
import com.talabat.observability.squads.discovery.AppLaunchTrackingManger;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl;
import com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource;
import com.talabat.userandlocation.appinfo.data.remote.api.AppInfoApi;
import com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoApi;
import com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl;
import com.tekartik.sqflite.Constant;
import datamodels.AddressArea;
import datamodels.Area;
import datamodels.analyticstrackermodels.AddressAnalyticsTracker;
import datamodels.mappers.AreaToOldAreaMapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.homemap.AllCountryPolygonRM;
import library.talabat.mvp.homemap.HomeMapPresenter;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.homemap.HomeMapUtils;
import library.talabat.mvp.homemap.HomeMapView;
import library.talabat.mvp.homemap.IHomeMapPresenter;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.TalabatAdjust;
import tracking.gtm.TrackingUtils;
import ue.a9;
import ue.b9;
import ue.c9;
import ue.d9;
import ue.e9;
import ue.f9;
import ue.i8;
import ue.j8;
import ue.k8;
import ue.l8;
import ue.m8;
import ue.n8;
import ue.o8;
import ue.p8;
import ue.q8;
import ue.r8;
import ue.s8;
import ue.t8;
import ue.u8;
import ue.v8;
import ue.w8;
import ue.x8;
import ue.y8;
import ue.z8;

@Instrumented
@Metadata(d1 = {"\u0000¾\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u0001\n\u0002\b\n\u0018\u0000 Ó\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n:\u0002Ó\u0003B\u0005¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u0002H\u0016J\n\u0010\u0002\u001a\u00030\u0002H\u0002J(\u0010\u0002\u001a\u00030\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0003\u0010\u0002J\u0013\u0010\u0002\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u000203H\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0002J\u001c\u0010\u0002\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u0002052\u0007\u0010\u0002\u001a\u00020-H\u0002J(\u0010\u0002\u001a\u00030\u00022\n\u0010\u0001\u001a\u0005\u0018\u00010\u00022\u0007\u0010\u0002\u001a\u00020-2\u0007\u0010\u0002\u001a\u000205H\u0016J\t\u0010\u0002\u001a\u000203H\u0016J\u0013\u0010\u0002\u001a\u0002032\b\u0010 \u0002\u001a\u00030¡\u0002H\u0002JR\u0010¢\u0002\u001a\u00030\u00022\b\u0010£\u0002\u001a\u00030¤\u00022\n\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u00022\n\u0010§\u0002\u001a\u0005\u0018\u00010¨\u00022\t\u0010\u0001\u001a\u0004\u0018\u00010#2\n\u0010©\u0002\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0002\u001a\u00020-H\u0002¢\u0006\u0003\u0010ª\u0002J+\u0010«\u0002\u001a\u00030\u00022\n\u0010¬\u0002\u001a\u0005\u0018\u00010¨\u00022\n\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u00022\u0007\u0010\u0002\u001a\u00020-H\u0016J\n\u0010­\u0002\u001a\u00030\u0002H\u0016J\u001b\u0010®\u0002\u001a\u0014\u0012\u0005\u0012\u00030¯\u00020\u000fj\t\u0012\u0005\u0012\u00030¯\u0002`\u0011H\u0002J\u0013\u0010°\u0002\u001a\u00030\u00022\u0007\u0010±\u0002\u001a\u000203H\u0002J\u0015\u0010²\u0002\u001a\u00030\u00022\t\u0010³\u0002\u001a\u0004\u0018\u00010#H\u0002J\u0014\u0010´\u0002\u001a\u00030\u00022\b\u0010µ\u0002\u001a\u00030\u0002H\u0002J\n\u0010¶\u0002\u001a\u00030\u0002H\u0002J\n\u0010·\u0002\u001a\u00030\u0002H\u0002J\u0014\u0010¸\u0002\u001a\u00030\u00022\b\u0010¹\u0002\u001a\u00030\u0002H\u0016J\n\u0010º\u0002\u001a\u00030\u0002H\u0016J\n\u0010»\u0002\u001a\u00030\u0002H\u0016J\t\u0010¼\u0002\u001a\u000203H\u0016J\t\u0010½\u0002\u001a\u000203H\u0002J2\u0010¾\u0002\u001a\u00030\u00022\b\u0010¿\u0002\u001a\u00030\u00022\b\u0010À\u0002\u001a\u00030\u00022\b\u0010Á\u0002\u001a\u00030\u00022\b\u0010Â\u0002\u001a\u00030\u0002H\u0002J\u0013\u0010Ã\u0002\u001a\u00030\u00022\u0007\u0010Ä\u0002\u001a\u000203H\u0016J\n\u0010Å\u0002\u001a\u00030\u0002H\u0002J\n\u0010Æ\u0002\u001a\u00030\u0002H\u0002J\u0013\u0010Ç\u0002\u001a\u00030\u00022\u0007\u0010È\u0002\u001a\u000203H\u0016J/\u0010É\u0002\u001a\u00030\u00022\b\u0010Ê\u0002\u001a\u00030Ë\u00022\u0007\u0010Ì\u0002\u001a\u00020^2\u0007\u0010Í\u0002\u001a\u0002052\u0007\u0010Î\u0002\u001a\u000203H\u0002J(\u0010Ï\u0002\u001a\u00030\u00022\u0007\u0010Ð\u0002\u001a\u0002032\u0007\u0010Ñ\u0002\u001a\u0002032\n\u0010Ò\u0002\u001a\u0005\u0018\u00010¨\u0002H\u0016J\n\u0010Ó\u0002\u001a\u00030¡\u0002H\u0016J\f\u0010Ô\u0002\u001a\u0005\u0018\u00010\u0002H\u0016J\u0012\u0010Õ\u0002\u001a\u0002052\u0007\u0010Ö\u0002\u001a\u000205H\u0002J\n\u0010×\u0002\u001a\u00030Ø\u0002H\u0002J\f\u0010Ù\u0002\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010Ú\u0002\u001a\u00020-H\u0016J\u0014\u0010Û\u0002\u001a\u00030\u00022\b\u0010Ü\u0002\u001a\u00030Ý\u0002H\u0002J\n\u0010Þ\u0002\u001a\u00030\u0002H\u0002J\n\u0010ß\u0002\u001a\u00030\u0002H\u0002J\n\u0010à\u0002\u001a\u00030\u0002H\u0016J\n\u0010á\u0002\u001a\u00030\u0002H\u0002J\n\u0010â\u0002\u001a\u00030\u0002H\u0002J\t\u0010ã\u0002\u001a\u000203H\u0002J\u0015\u0010ä\u0002\u001a\u0002032\n\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u0002H\u0002J\u001d\u0010å\u0002\u001a\u00030\u00022\u0007\u0010å\u0002\u001a\u0002032\b\u0010¹\u0002\u001a\u00030\u0002H\u0016J\t\u0010æ\u0002\u001a\u000203H\u0002J\n\u0010ç\u0002\u001a\u00030\u0002H\u0002J\n\u0010è\u0002\u001a\u00030\u0002H\u0002J6\u0010é\u0002\u001a\u00030\u00022\t\u0010ê\u0002\u001a\u0004\u0018\u00010-2\n\u0010Ò\u0002\u001a\u0005\u0018\u00010¨\u00022\n\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u00022\u0007\u0010\u0002\u001a\u00020-H\u0016J1\u0010ë\u0002\u001a\u00030\u00022\u0007\u0010æ\u0001\u001a\u0002052\n\u0010¬\u0002\u001a\u0005\u0018\u00010¨\u00022\u0007\u0010\u0002\u001a\u00020-2\u0007\u0010ì\u0002\u001a\u000203H\u0016J\u0013\u0010í\u0002\u001a\u00030\u00022\u0007\u0010î\u0002\u001a\u000203H\u0002J\u0015\u0010ï\u0002\u001a\u00030\u00022\t\u0010ê\u0002\u001a\u0004\u0018\u00010-H\u0016J\u0013\u0010ð\u0002\u001a\u00030\u00022\u0007\u0010ñ\u0002\u001a\u000203H\u0016J\u0014\u0010ò\u0002\u001a\u00030\u00022\b\u0010¹\u0002\u001a\u00030\u0002H\u0016J\u0013\u0010ó\u0002\u001a\u00030\u00022\u0007\u0010Ä\u0002\u001a\u000203H\u0016J\n\u0010¢\u0001\u001a\u00030\u0002H\u0002J\n\u0010ô\u0002\u001a\u00030\u0002H\u0002J\n\u0010õ\u0002\u001a\u00030\u0002H\u0002J(\u0010ö\u0002\u001a\u00030\u00022\u0007\u0010÷\u0002\u001a\u0002052\u0007\u0010ø\u0002\u001a\u0002052\n\u0010ù\u0002\u001a\u0005\u0018\u00010ú\u0002H\u0014J\n\u0010û\u0002\u001a\u00030\u0002H\u0016J\n\u0010ü\u0002\u001a\u00030\u0002H\u0016J\n\u0010ý\u0002\u001a\u00030\u0002H\u0016J\n\u0010þ\u0002\u001a\u00030\u0002H\u0016J\n\u0010ÿ\u0002\u001a\u00030\u0002H\u0016J\n\u0010\u0003\u001a\u00030\u0002H\u0016J\u0013\u0010\u0003\u001a\u00030\u00022\u0007\u0010\u0003\u001a\u000205H\u0016J\u001b\u0010\u0003\u001a\u00030\u00022\t\u0010\u0002\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0003\u0010\u0003J\u0016\u0010\u0003\u001a\u00030\u00022\n\u0010\u0003\u001a\u0005\u0018\u00010\u0003H\u0015J)\u0010\u0003\u001a\u00030\u00022\n\u0010³\u0002\u001a\u0005\u0018\u00010\u00022\u0007\u0010\u0003\u001a\u0002032\b\u0010\u0003\u001a\u00030\u0001H\u0017J\u001e\u0010\u0003\u001a\u00030\u00022\b\u0010¹\u0002\u001a\u00030\u00022\b\u0010\u0003\u001a\u00030\u0001H\u0016J\n\u0010\u0003\u001a\u00030\u0002H\u0014J\n\u0010\u0003\u001a\u00030\u0002H\u0016J\u0014\u0010\u0003\u001a\u00030\u00022\b\u0010Ü\u0002\u001a\u00030Ý\u0002H\u0016J\u0013\u0010\u0003\u001a\u00030\u00022\u0007\u0010\u0003\u001a\u000203H\u0016J\u0013\u0010\u0003\u001a\u00030\u00022\u0007\u0010\u0003\u001a\u000203H\u0002J\u0014\u0010\u0003\u001a\u00030\u00022\b\u0010\u0003\u001a\u00030\u0001H\u0016J\n\u0010\u0003\u001a\u00030\u0002H\u0016J\n\u0010\u0003\u001a\u00030\u0002H\u0016J\u0013\u0010\u0003\u001a\u00030\u00022\u0007\u0010\u0003\u001a\u00020-H\u0002J\u0016\u0010\u0003\u001a\u00030\u00022\n\u0010\u0003\u001a\u0005\u0018\u00010¨\u0002H\u0002J(\u0010\u0003\u001a\u00030\u00022\u0007\u0010\u0003\u001a\u00020-2\n\u0010Ò\u0002\u001a\u0005\u0018\u00010¨\u00022\u0007\u0010\u0003\u001a\u00020-H\u0002J\n\u0010\u0003\u001a\u00030\u0002H\u0002J\n\u0010\u0003\u001a\u00030\u0002H\u0002J\u0016\u0010 \u0003\u001a\u00030\u00022\n\u0010\u0001\u001a\u0005\u0018\u00010\u0002H\u0016J\u001c\u0010¡\u0003\u001a\u00030\u00022\u0007\u0010¢\u0003\u001a\u0002032\u0007\u0010£\u0003\u001a\u000203H\u0016J\u0013\u0010¤\u0003\u001a\u00030\u00022\u0007\u0010¥\u0003\u001a\u000203H\u0002J\u0014\u0010¦\u0003\u001a\u00030\u00022\b\u0010§\u0003\u001a\u00030\u0002H\u0002J\u0013\u0010¨\u0003\u001a\u00030\u00022\u0007\u0010©\u0003\u001a\u000205H\u0002J\u0013\u0010ª\u0003\u001a\u00030\u00022\u0007\u0010©\u0003\u001a\u000205H\u0002J\n\u0010«\u0003\u001a\u00030\u0002H\u0002J\n\u0010¬\u0003\u001a\u00030\u0002H\u0002J\u0013\u0010­\u0003\u001a\u00030\u00022\u0007\u0010³\u0002\u001a\u00020-H\u0002J\n\u0010®\u0003\u001a\u00030\u0002H\u0002J\n\u0010¯\u0003\u001a\u00030\u0002H\u0016J\n\u0010°\u0003\u001a\u00030\u0002H\u0002J\n\u0010±\u0003\u001a\u00030\u0002H\u0002J \u0010²\u0003\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030¨\u00022\n\u0010§\u0002\u001a\u0005\u0018\u00010¨\u0002H\u0002J\t\u0010³\u0003\u001a\u00020-H\u0002J\u001f\u0010´\u0003\u001a\u00030\u00022\n\u0010µ\u0003\u001a\u0005\u0018\u00010¨\u00022\u0007\u0010¶\u0003\u001a\u000203H\u0002JH\u0010·\u0003\u001a\u00030\u00022\n\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u00022\n\u0010§\u0002\u001a\u0005\u0018\u00010¨\u00022\t\u0010\u0001\u001a\u0004\u0018\u00010#2\n\u0010©\u0002\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0002\u001a\u00020-H\u0002¢\u0006\u0003\u0010¸\u0003J\u001f\u0010¹\u0003\u001a\u00030\u00022\n\u0010º\u0003\u001a\u0005\u0018\u00010\u00012\u0007\u0010»\u0003\u001a\u000203H\u0002J\n\u0010¼\u0003\u001a\u00030\u0002H\u0016J\n\u0010½\u0003\u001a\u00030\u0002H\u0016J\u0013\u0010¾\u0003\u001a\u00030\u00022\u0007\u0010¿\u0003\u001a\u000203H\u0002J\u0012\u0010À\u0003\u001a\u00030\u00022\b\u0010Á\u0003\u001a\u00030\u0001J\u0012\u0010Â\u0003\u001a\u00030\u00022\b\u0010Á\u0003\u001a\u00030\u0001J\u0012\u0010Ã\u0003\u001a\u00030\u00022\b\u0010Ä\u0003\u001a\u00030\u0001J\u0015\u0010Å\u0003\u001a\u00020-2\n\u0010Ò\u0002\u001a\u0005\u0018\u00010¨\u0002H\u0002J\u001f\u0010Æ\u0003\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u00020-2\n\u0010§\u0002\u001a\u0005\u0018\u00010¨\u0002H\u0002J\"\u0010Ç\u0003\u001a\u00030\u00022\n\u0010È\u0003\u001a\u0005\u0018\u00010\u00022\n\u0010É\u0003\u001a\u0005\u0018\u00010Ê\u0003H\u0016J\u0013\u0010Ë\u0003\u001a\u00030\u00022\u0007\u0010©\u0003\u001a\u000205H\u0016J\u0013\u0010Ì\u0003\u001a\u00030\u00022\u0007\u0010Í\u0003\u001a\u000203H\u0016J\u0013\u0010Î\u0003\u001a\u00030\u00022\u0007\u0010ç\u0001\u001a\u000205H\u0016J \u0010Ï\u0003\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030¨\u00022\n\u0010§\u0002\u001a\u0005\u0018\u00010¨\u0002H\u0002J(\u0010Ð\u0003\u001a\u00030\u00022\n\u0010Ñ\u0003\u001a\u0005\u0018\u00010\u00022\n\u0010Ò\u0003\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0003\u0010\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010@\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010I\u001a\u00020J8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020P8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010W\u001a\u00020X8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010/\"\u0004\ba\u00101R\u001a\u0010b\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u000e\u0010g\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010p\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010d\"\u0004\bq\u0010fR\u000e\u0010r\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010s\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010d\"\u0004\bt\u0010fR\u000e\u0010u\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010x\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010d\"\u0004\by\u0010fR\u000e\u0010z\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010|\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010d\"\u0004\b}\u0010fR\u000e\u0010~\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u000203X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010d\"\u0005\b\u0001\u0010fR\u000f\u0010\u0001\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u000203X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010d\"\u0005\b\u0001\u0010fR\u000f\u0010\u0001\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010/\"\u0005\b\u0001\u00101R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0001\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0001\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0001\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0005\n\u0003\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b \u0001\u0010¡\u0001R\u000f\u0010¢\u0001\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010£\u0001\u001a\u00020-X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010/\"\u0005\b¥\u0001\u00101R$\u0010¦\u0001\u001a\u00030§\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R$\u0010¬\u0001\u001a\u00030­\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R$\u0010²\u0001\u001a\u00030³\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R$\u0010¸\u0001\u001a\u00030¹\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R$\u0010¾\u0001\u001a\u00030¿\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0001\u0010Á\u0001\"\u0006\bÂ\u0001\u0010Ã\u0001R$\u0010Ä\u0001\u001a\u00030Å\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R$\u0010Ê\u0001\u001a\u00030Ë\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u001d\u0010Ð\u0001\u001a\u000203X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010d\"\u0005\bÒ\u0001\u0010fR$\u0010Ó\u0001\u001a\u00030Ô\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R\"\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R\u001d\u0010ß\u0001\u001a\u000203X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0001\u0010d\"\u0005\bá\u0001\u0010fR\u000f\u0010â\u0001\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ã\u0001\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ä\u0001\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010å\u0001\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010æ\u0001\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ç\u0001\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R$\u0010è\u0001\u001a\u00030é\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R$\u0010î\u0001\u001a\u00030ï\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bð\u0001\u0010ñ\u0001\"\u0006\bò\u0001\u0010ó\u0001R$\u0010ô\u0001\u001a\u00030õ\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bö\u0001\u0010÷\u0001\"\u0006\bø\u0001\u0010ù\u0001R$\u0010ú\u0001\u001a\u00030û\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\bü\u0001\u0010ý\u0001\"\u0006\bþ\u0001\u0010ÿ\u0001R \u0010\u0002\u001a\u00030\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001d\u0010\u0002\u001a\u00020-X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010/\"\u0005\b\u0002\u00101R\u001d\u0010\u0002\u001a\u00020-X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010/\"\u0005\b\u0002\u00101¨\u0006Ô\u0003"}, d2 = {"Lcom/talabat/HomeScreenMap;", "Lcom/talabat/helpers/TalabatBase;", "Llibrary/talabat/mvp/homemap/HomeMapView;", "Lcom/talabat/maps/domain/OnMapReadyCallback;", "Lcom/talabat/homemaphelper/HomeMapWrapperLayout$UpdateMapAfterUserInterection;", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveStartedListener;", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveListener;", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraMoveCanceledListener;", "Lcom/talabat/maps/domain/FrameworkMap$OnCameraIdleListener;", "Lcom/talabat/homemaphelper/CurrentLocationListener;", "Lcom/talabat/fragments/CustomAutoCompleteFragment$OnFragmentInteractionListener;", "()V", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "allCountryPolygon", "Ljava/util/ArrayList;", "Lcom/talabat/maps/domain/model/Polygon;", "Lkotlin/collections/ArrayList;", "getAllCountryPolygon", "()Ljava/util/ArrayList;", "setAllCountryPolygon", "(Ljava/util/ArrayList;)V", "animation", "Landroid/view/animation/AnimationSet;", "getAnimation", "()Landroid/view/animation/AnimationSet;", "setAnimation", "(Landroid/view/animation/AnimationSet;)V", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "getAppVersionProvider", "()Lcom/talabat/configuration/discovery/AppVersionProvider;", "setAppVersionProvider", "(Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "areaCenterLatLng", "Lcom/talabat/maps/domain/model/LatLng;", "autocompleteSupportFragment", "Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "cameraUpdateFactory", "Lcom/talabat/maps/domain/CameraUpdateFactory;", "getCameraUpdateFactory", "()Lcom/talabat/maps/domain/CameraUpdateFactory;", "setCameraUpdateFactory", "(Lcom/talabat/maps/domain/CameraUpdateFactory;)V", "changeCountryName", "", "getChangeCountryName", "()Ljava/lang/String;", "setChangeCountryName", "(Ljava/lang/String;)V", "changeCountryPrompt", "", "changedCountryId", "", "getChangedCountryId", "()I", "setChangedCountryId", "(I)V", "configurationRemoteRepository", "Lcom/talabat/configuration/ConfigurationRemoteRepository;", "getConfigurationRemoteRepository", "()Lcom/talabat/configuration/ConfigurationRemoteRepository;", "setConfigurationRemoteRepository", "(Lcom/talabat/configuration/ConfigurationRemoteRepository;)V", "currentLoc", "currentLocationFetch", "Lcom/talabat/homemaphelper/CurrentLocationFetch;", "customAutoCompleteFragment", "Lcom/talabat/fragments/CustomAutoCompleteFragment;", "getCustomAutoCompleteFragment", "()Lcom/talabat/fragments/CustomAutoCompleteFragment;", "setCustomAutoCompleteFragment", "(Lcom/talabat/fragments/CustomAutoCompleteFragment;)V", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "getCustomerRepository", "()Lcom/talabat/customer/domain/CustomerRepository;", "setCustomerRepository", "(Lcom/talabat/customer/domain/CustomerRepository;)V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "fromHome", "fromRL", "getProCentralizationStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "getGetProCentralizationStatusUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "setGetProCentralizationStatusUseCase", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;)V", "gpsAnimImgs", "", "gpsStatus", "getGpsStatus", "setGpsStatus", "ignoreBottomAnim", "getIgnoreBottomAnim", "()Z", "setIgnoreBottomAnim", "(Z)V", "ignoreCurrentloctionRequest", "ignoreSavedLoc", "interactedWithMap", "isAddressUpdateSelected", "isBottomContainerAnimationFinished", "isCLocationBtnClicked", "isCLocationBtnMovement", "isCameraSettled", "isDefaultLocationEnable", "isDelAreaFromSerach", "setDelAreaFromSerach", "isDragTutHided", "isForceRedirectSearch", "setForceRedirectSearch", "isFranchiseRes", "isFromBrandOrReorder", "isFromFanchiseRes", "isFromPlaceSearch", "setFromPlaceSearch", "isFromReOrder", "isFromReorderList", "isHideDragTutFromSearch", "setHideDragTutFromSearch", "isIgnoreCurrentLocationMovement", "isMapCameraFinished", "isOutOfCountry", "setOutOfCountry", "isPolygonDrawned", "isPreFetchAddressAvail", "isRedirectBacktoHomeFromLocationWelcome", "setRedirectBacktoHomeFromLocationWelcome", "isShowingLocAwareness", "latLngFactory", "Lcom/talabat/maps/domain/LatLngFactory;", "getLatLngFactory", "()Lcom/talabat/maps/domain/LatLngFactory;", "setLatLngFactory", "(Lcom/talabat/maps/domain/LatLngFactory;)V", "locationMethod", "getLocationMethod", "setLocationMethod", "mCustomMapView", "Landroid/view/View;", "mHomeMapPresenter", "Llibrary/talabat/mvp/homemap/IHomeMapPresenter;", "mMainLatLng", "mMap", "Lcom/talabat/maps/domain/FrameworkMap;", "mUserCurrentLocation", "mUserSavedTempLocation", "mUserSavedTempZoomLevel", "", "Ljava/lang/Float;", "mapFragment", "Lcom/talabat/maps/presentation/MapContainerFragment;", "getMapFragment", "()Lcom/talabat/maps/presentation/MapContainerFragment;", "setMapFragment", "(Lcom/talabat/maps/presentation/MapContainerFragment;)V", "mapJourneyType", "mapViewType", "getMapViewType", "setMapViewType", "mapsInitializer", "Lcom/talabat/maps/domain/MapsInitializer;", "getMapsInitializer", "()Lcom/talabat/maps/domain/MapsInitializer;", "setMapsInitializer", "(Lcom/talabat/maps/domain/MapsInitializer;)V", "modelsRepository", "Lcom/talabat/maps/domain/ModelsRepository;", "getModelsRepository", "()Lcom/talabat/maps/domain/ModelsRepository;", "setModelsRepository", "(Lcom/talabat/maps/domain/ModelsRepository;)V", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "setMoshi", "(Lcom/squareup/moshi/Moshi;)V", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "getMutableConfigurationLocalRepository", "()Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "setMutableConfigurationLocalRepository", "(Lcom/talabat/configuration/MutableConfigurationLocalRepository;)V", "mutableConfigurationRemoteRepository", "Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "getMutableConfigurationRemoteRepository", "()Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "setMutableConfigurationRemoteRepository", "(Lcom/talabat/configuration/MutableConfigurationRemoteRepository;)V", "mutableLocationConfigurationRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "getMutableLocationConfigurationRepository", "()Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "setMutableLocationConfigurationRepository", "(Lcom/talabat/configuration/MutableLocationConfigurationRepository;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "outOfService", "getOutOfService", "setOutOfService", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "getPaymentConfigurationRepository", "()Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "setPaymentConfigurationRepository", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;)V", "popupWindow", "Landroid/app/Dialog;", "getPopupWindow", "()Landroid/app/Dialog;", "setPopupWindow", "(Landroid/app/Dialog;)V", "reachedLoc", "getReachedLoc", "setReachedLoc", "redirectGPSSettings", "reorderId", "reorderResId", "reorderResName", "restBranchId", "restGrpId", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "getSecretProvider", "()Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "setSecretProvider", "(Lcom/talabat/authentication/aaa/secrets/SecretProvider;)V", "setHasUserPinnedLocationInOnboardingMapUseCase", "Lcom/talabat/core/pinless/checkout/domain/SetHasUserPinnedLocationInOnboardingMapUseCase;", "getSetHasUserPinnedLocationInOnboardingMapUseCase", "()Lcom/talabat/core/pinless/checkout/domain/SetHasUserPinnedLocationInOnboardingMapUseCase;", "setSetHasUserPinnedLocationInOnboardingMapUseCase", "(Lcom/talabat/core/pinless/checkout/domain/SetHasUserPinnedLocationInOnboardingMapUseCase;)V", "subscriptionsCustomerRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "getSubscriptionsCustomerRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "setSubscriptionsCustomerRepository", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "trackingDistance", "", "getTrackingDistance", "()D", "setTrackingDistance", "(D)V", "userSelectedAddress", "getUserSelectedAddress", "setUserSelectedAddress", "userSelectedLatLng", "getUserSelectedLatLng", "setUserSelectedLatLng", "OnCurrentLocationPermissionStatus", "", "response", "Lcom/karumi/dexter/listener/PermissionDeniedResponse;", "adjustBottonContainer", "animateMapCammera", "mapPinLatLang", "Lcom/google/android/gms/maps/model/LatLng;", "mapZoomLevel", "(Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/Float;)V", "animtLocationBtn", "isPreFecthContainerAvail", "animtLocationBtnWhileDrag", "cameraBecomeIdle", "changeCountryAlert", "countryId", "changedCountry", "changecountryPrompt", "selectedCountryName", "checkPermission", "context", "Landroid/content/Context;", "clearCart", "cart", "Lbuisnessmodels/Cart;", "area", "Ldatamodels/Area;", "googleAddress", "Lcom/talabat/domain/address/Address;", "zoom", "(Lbuisnessmodels/Cart;Ldatamodels/Area;Lcom/talabat/domain/address/Address;Lcom/talabat/maps/domain/model/LatLng;Ljava/lang/Float;Ljava/lang/String;)V", "clearCartchangeLocation", "geoAddress", "countryPolygonLoaded", "createPolygonPathForAllCountries", "Lcom/talabat/maps/domain/model/PolygonOptions;", "currentLocReceived", "fetchCurrentLoc", "currentlocationMovement", "location", "deg2rad", "deg", "deliverBtnEnable", "deliverHereCheck", "deliverToCLRecived", "currentLatLng", "destroyPresenter", "detectingLocationProgress", "deviceGpsStatus", "dismissDialog", "distanceBetweenTwoCordinatesbet", "lat1", "lon1", "lat2", "lon2", "dragFinished", "isDraging", "drawAllCountryPolygon", "drawCountryPolygon", "enableDeliverHereButton", "isEnableDeliverHere", "fadeInFadeOutAnim", "imageView", "Landroid/widget/ImageView;", "images", "imageIndex", "forever", "geocodingReceived", "isGeoLccationAvail", "showLoading", "address", "getContext", "getMainLatLng", "getPixelFromDp", "dpValue", "getPlaceSelectionListener", "Lcom/google/android/libraries/places/widget/listener/PlaceSelectionListener;", "getPresenter", "getScreenName", "googleAutoCompleteWidget", "place", "Lcom/google/android/libraries/places/api/model/Place;", "gpsLocationSettingsAlert", "hideMapDragMapTutorial", "hideMapTutorial", "initInitialView", "initMapView", "isHomeScreenToFoodListDeeplinkEnabled", "isNeedToClearCart", "isRefreshMap", "isShowCurrentLocationAwareness", "loaPlaceSearchScreen", "loadForceSearchScreen", "loadRestaurantListScreen", "msg", "loadRestaurantMenuScreen", "franchiseRes", "locationButton", "isLocationEnabled", "locationError", "mapAnimatedtoLocation", "isAlreadyAnimated", "mapCurrentLocReceived", "mapDraging", "navigateToFlutterFoodListDeeplink", "navigateToFlutterFoodListExplicitly", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAuthError", "onBackClickListener", "onBackPressed", "onCameraIdle", "onCameraMove", "onCameraMoveCanceled", "onCameraMoveStarted", "p0", "onCountryDataLoaded", "(Ljava/lang/Integer;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCurrentLocationReceived", "isShowLocationInAccurateAlert", "lococaccuracy", "onCurrentLocationReceivedWithLowAccuracy", "onDestroy", "onError", "onFragmentInteraction", "onGeoLocationDialogAccepted", "locationRequestStatus", "onLocationDialogAccepted", "locationEnabled", "onMapReady", "frameworkMap", "onPause", "onResume", "onTrackAddressErrorShown", "errorMsg", "onTrackAddressSubmitted", "cstAddress", "onTrackGeoLocationRequested", "apiStatus", "geoAddressTitle", "onTrackMapLoaded", "openSettings", "outofService", "preLocationLocationContainer", "isPreGeolocationAvail", "isShowPreloading", "prefetchLocationContainer", "isPrefetchAvail", "rad2deg", "rad", "reDirectBrandToMenuScreen", "branchId", "reDirectReOrdertCartScreen", "reInitiateLocation", "redirectToResListScreen", "redirecttoFreanchiseSelectionScreen", "refreshMapCurrentLoc", "requestForUserCurrentLocation", "resetCustomerBrandAddress", "resetPreLocationContainer", "saveForLaterAddress", "screenType", "selectAddress", "userSelectedAddressCp", "isUpdate", "selectArea", "(Ldatamodels/Area;Lcom/talabat/domain/address/Address;Lcom/talabat/maps/domain/model/LatLng;Ljava/lang/Float;Ljava/lang/String;)V", "setPaddingForGoogleLogo", "map", "isShowPrefetch", "showGeoAddressLoading", "showLinaerLoading", "showMapDragTutorial", "isVisible", "slideDown", "view", "slideUp", "stopFadeInFadeOutAnimation", "v", "storeTempAddress", "updateAddressPopup", "updateAreaLocation", "areCenterPoint", "nothing", "", "updateBranchId", "updateIsFrachiseRestaurant", "isFranchiseRest", "updateRestGrpId", "updateSelectedAddress", "updateUserSavedTempLocation", "homeMapSavedLatLng", "homeMapSavedZooLevel", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenMap extends TalabatBase implements HomeMapView, OnMapReadyCallback, HomeMapWrapperLayout.UpdateMapAfterUserInterection, FrameworkMap.OnCameraMoveStartedListener, FrameworkMap.OnCameraMoveListener, FrameworkMap.OnCameraMoveCanceledListener, FrameworkMap.OnCameraIdleListener, CurrentLocationListener, CustomAutoCompleteFragment.OnFragmentInteractionListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DELIVER_HERE_BRAND_REORDER = 3;
    private static final int DELIVER_HERE_DEFAULT = 1;
    private static final int DELIVER_HERE_NEW_COUNTRY = 2;
    private static final int PLACES_SEARCH = 36;
    private static final int REQUEST_CHECK_SETTINGS = 100;
    @NotNull
    private static final String brandMapFirst = "brand";
    @NotNull
    private static final String dashboardReorderMapFirst = "reorder";
    @NotNull
    private static final String homeMapFirst = "home";
    @NotNull
    private static final String reorderMapFirst = "reorder";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private AlertDialog alertDialog;
    @Nullable
    private ArrayList<Polygon> allCountryPolygon;
    @Nullable
    private AnimationSet animation;
    @Inject
    public AppVersionProvider appVersionProvider;
    @Nullable
    private LatLng areaCenterLatLng;
    @Nullable
    private AutocompleteSupportFragment autocompleteSupportFragment;
    @Inject
    public CameraUpdateFactory cameraUpdateFactory;
    @NotNull
    private String changeCountryName = "";
    private boolean changeCountryPrompt;
    private int changedCountryId;
    @Inject
    public ConfigurationRemoteRepository configurationRemoteRepository;
    @Nullable
    private LatLng currentLoc;
    @Nullable
    private CurrentLocationFetch currentLocationFetch;
    @Nullable
    private CustomAutoCompleteFragment customAutoCompleteFragment;
    @Inject
    public CustomerRepository customerRepository;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    private boolean fromHome;
    private boolean fromRL;
    @Inject
    public GetProCentralizationStatusUseCase getProCentralizationStatusUseCase;
    @NotNull
    private final int[] gpsAnimImgs = {R.drawable.ic_m_gps_on, R.drawable.ic_m_gps_on};
    @NotNull
    private String gpsStatus = "";
    private boolean ignoreBottomAnim;
    private boolean ignoreCurrentloctionRequest;
    private boolean ignoreSavedLoc;
    private boolean interactedWithMap;
    private boolean isAddressUpdateSelected;
    private boolean isBottomContainerAnimationFinished;
    private boolean isCLocationBtnClicked;
    private boolean isCLocationBtnMovement;
    private boolean isCameraSettled;
    private boolean isDefaultLocationEnable;
    private boolean isDelAreaFromSerach;
    private boolean isDragTutHided;
    private boolean isForceRedirectSearch;
    private boolean isFranchiseRes;
    private boolean isFromBrandOrReorder;
    private boolean isFromFanchiseRes;
    private boolean isFromPlaceSearch;
    private boolean isFromReOrder;
    private boolean isFromReorderList;
    private boolean isHideDragTutFromSearch;
    private boolean isIgnoreCurrentLocationMovement;
    /* access modifiers changed from: private */
    public boolean isMapCameraFinished;
    private boolean isOutOfCountry;
    private boolean isPolygonDrawned;
    private boolean isPreFetchAddressAvail;
    private boolean isRedirectBacktoHomeFromLocationWelcome;
    private boolean isShowingLocAwareness;
    @Inject
    public LatLngFactory latLngFactory;
    @Nullable
    private String locationMethod;
    @Nullable
    private View mCustomMapView;
    @Nullable
    private IHomeMapPresenter mHomeMapPresenter;
    @Nullable
    private LatLng mMainLatLng;
    @Nullable
    private FrameworkMap mMap;
    @Nullable
    private LatLng mUserCurrentLocation;
    @Nullable
    private LatLng mUserSavedTempLocation;
    @Nullable
    private Float mUserSavedTempZoomLevel = Float.valueOf(0.0f);
    @Nullable
    private MapContainerFragment mapFragment;
    @NotNull
    private String mapJourneyType = "";
    @NotNull
    private String mapViewType = "";
    @Inject
    public MapsInitializer mapsInitializer;
    @Inject
    public ModelsRepository modelsRepository;
    @Inject
    public Moshi moshi;
    @Inject
    public MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    @Inject
    public MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository;
    @Inject
    public MutableLocationConfigurationRepository mutableLocationConfigurationRepository;
    @Inject
    public Navigator navigator;
    private boolean outOfService;
    @Inject
    public PaymentConfigurationRepository paymentConfigurationRepository;
    @Nullable
    private Dialog popupWindow;
    private boolean reachedLoc;
    private boolean redirectGPSSettings;
    @NotNull
    private String reorderId = "";
    private int reorderResId;
    @NotNull
    private String reorderResName = "";
    private int restBranchId;
    private int restGrpId;
    @Inject
    public SecretProvider secretProvider;
    @Inject
    public SetHasUserPinnedLocationInOnboardingMapUseCase setHasUserPinnedLocationInOnboardingMapUseCase;
    @Inject
    public ISubscriptionsCustomerRepository subscriptionsCustomerRepository;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    private double trackingDistance;
    @NotNull
    private String userSelectedAddress = "";
    @NotNull
    private String userSelectedLatLng = "";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/HomeScreenMap$Companion;", "", "()V", "DELIVER_HERE_BRAND_REORDER", "", "DELIVER_HERE_DEFAULT", "DELIVER_HERE_NEW_COUNTRY", "PLACES_SEARCH", "REQUEST_CHECK_SETTINGS", "brandMapFirst", "", "dashboardReorderMapFirst", "homeMapFirst", "reorderMapFirst", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void adjustBottonContainer() {
        float f11;
        if (this.isShowingLocAwareness || this.changeCountryPrompt) {
            f11 = getResources().getDimension(R.dimen.home_map_details_container_height_with_location);
        } else {
            f11 = getResources().getDimension(R.dimen.home_map_details_container_height);
        }
        int i11 = (int) f11;
        ViewGroup.LayoutParams layoutParams = ((RelativeLayout) _$_findCachedViewById(R.id.detail_card_container)).getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.height = i11;
            layoutParams2.width = -1;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final void animtLocationBtn(boolean z11) {
        int i11;
        try {
            int i12 = R.id.map_view_switch_btn;
            if (((ImageView) _$_findCachedViewById(i12)).getVisibility() == 4) {
                ((ImageView) _$_findCachedViewById(i12)).setVisibility(0);
            }
            int i13 = R.id.location_btn_container;
            if (((LinearLayout) _$_findCachedViewById(i13)).getVisibility() == 4) {
                ((LinearLayout) _$_findCachedViewById(i13)).setVisibility(0);
            }
            if (z11) {
                i11 = 190;
                if (TalabatUtils.isArabic()) {
                    if (this.isShowingLocAwareness) {
                        i11 = PsExtractor.VIDEO_STREAM_MASK;
                    }
                } else if (this.isShowingLocAwareness) {
                    i11 = 210;
                }
            } else {
                i11 = 90;
            }
            ViewGroup.LayoutParams layoutParams = ((LinearLayout) _$_findCachedViewById(i13)).getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                if (z11) {
                    objectRef.element = ValueAnimator.ofInt(new int[]{getPixelFromDp(90), getPixelFromDp(i11)});
                } else if (!this.ignoreBottomAnim) {
                    objectRef.element = ValueAnimator.ofInt(new int[]{0, getPixelFromDp(i11)});
                }
                ValueAnimator valueAnimator = (ValueAnimator) objectRef.element;
                if (valueAnimator != null) {
                    valueAnimator.setDuration(200);
                }
                ValueAnimator valueAnimator2 = (ValueAnimator) objectRef.element;
                if (valueAnimator2 != null) {
                    valueAnimator2.addUpdateListener(new i8(this, objectRef));
                }
                ValueAnimator valueAnimator3 = (ValueAnimator) objectRef.element;
                if (valueAnimator3 != null) {
                    valueAnimator3.start();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: animtLocationBtn$lambda-23  reason: not valid java name */
    public static final void m9460animtLocationBtn$lambda23(HomeScreenMap homeScreenMap, Ref.ObjectRef objectRef, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$valueAnimator");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        int i11 = R.id.location_btn_container;
        ViewGroup.LayoutParams layoutParams = ((LinearLayout) homeScreenMap._$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout) homeScreenMap._$_findCachedViewById(i11)).requestLayout();
            ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, 0, 0, Integer.parseInt(((ValueAnimator) objectRef.element).getAnimatedValue().toString()));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final void animtLocationBtnWhileDrag() {
        try {
            int i11 = R.id.map_view_switch_btn;
            if (((ImageView) _$_findCachedViewById(i11)).getVisibility() == 4) {
                ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
            }
            int i12 = R.id.location_btn_container;
            if (((LinearLayout) _$_findCachedViewById(i12)).getVisibility() == 4) {
                ((LinearLayout) _$_findCachedViewById(i12)).setVisibility(0);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getPixelFromDp(0), getPixelFromDp(20)});
            ofInt.setDuration(200);
            ofInt.addUpdateListener(new t8(this, ofInt));
            ofInt.start();
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: animtLocationBtnWhileDrag$lambda-24  reason: not valid java name */
    public static final void m9461animtLocationBtnWhileDrag$lambda24(HomeScreenMap homeScreenMap, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator2, "it");
        int i11 = R.id.location_btn_container;
        ViewGroup.LayoutParams layoutParams = ((LinearLayout) homeScreenMap._$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout) homeScreenMap._$_findCachedViewById(i11)).requestLayout();
            ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, 0, 0, Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
            FrameworkMap frameworkMap = homeScreenMap.mMap;
            if (frameworkMap != null) {
                frameworkMap.setPadding(homeScreenMap.getPixelFromDp(2), Integer.parseInt(valueAnimator.getAnimatedValue().toString()), homeScreenMap.getPixelFromDp(2), Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    private final void cameraBecomeIdle() {
        LatLng latLng;
        int i11;
        com.google.android.gms.maps.model.LatLng latLng2;
        com.google.android.gms.maps.model.LatLng latLng3;
        com.google.android.gms.maps.model.LatLng latLng4;
        CameraPosition cameraPosition;
        this.isCameraSettled = true;
        IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
        if (iHomeMapPresenter != null) {
            iHomeMapPresenter.updateMapCameraMoved(false);
        }
        FrameworkMap frameworkMap = this.mMap;
        com.google.android.gms.maps.model.LatLng latLng5 = null;
        if (frameworkMap == null || (cameraPosition = frameworkMap.getCameraPosition()) == null) {
            latLng = null;
        } else {
            latLng = cameraPosition.getTarget();
        }
        this.mMainLatLng = latLng;
        if (this.allCountryPolygon == null) {
            this.outOfService = false;
            this.isOutOfCountry = false;
            if (this.isDelAreaFromSerach) {
                this.isDelAreaFromSerach = false;
                ((RelativeLayout) _$_findCachedViewById(R.id.pre_geo_address_container)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
                preLocationLocationContainer(false, false);
                enableDeliverHereButton(false);
                return;
            }
            IHomeMapPresenter iHomeMapPresenter2 = this.mHomeMapPresenter;
            if (iHomeMapPresenter2 != null) {
                boolean z11 = this.isMapCameraFinished;
                if (latLng != null) {
                    latLng5 = HomeScreenMapKt.toGoogle(latLng);
                }
                iHomeMapPresenter2.cameraAnimationFinished(z11, latLng5, this.isFromBrandOrReorder);
                return;
            }
            return;
        }
        boolean shouldEnableCountry = getMutableLocationConfigurationRepository().shouldEnableCountry(Country.EGYPT);
        boolean shouldEnableCountry2 = getMutableLocationConfigurationRepository().shouldEnableCountry(Country.IRAQ);
        if (GlobalDataModel.SelectedCountryId != Country.JORDAN.getCountryId() || (!shouldEnableCountry && !shouldEnableCountry2)) {
            i11 = GlobalDataModel.SelectedCountryId - 1;
        } else {
            i11 = GlobalDataModel.SelectedCountryId - 2;
        }
        ArrayList<Polygon> arrayList = this.allCountryPolygon;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                break;
            }
            LatLng latLng6 = this.mMainLatLng;
            ArrayList<Polygon> arrayList2 = this.allCountryPolygon;
            Intrinsics.checkNotNull(arrayList2);
            if (!PolyUtil.containsLocation(latLng6, arrayList2.get(i12).getPoints())) {
                this.outOfService = true;
                i12++;
            } else if (i12 == i11 || ((i12 == 6 || i12 == 7 || i12 == 8) && i12 == GlobalDataModel.SelectedCountryId - 2)) {
                this.outOfService = false;
                this.isOutOfCountry = false;
                if (this.isDelAreaFromSerach) {
                    this.isDelAreaFromSerach = false;
                    ((RelativeLayout) _$_findCachedViewById(R.id.pre_geo_address_container)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
                    preLocationLocationContainer(false, false);
                    enableDeliverHereButton(false);
                    TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.current_location_aware_txt);
                    if (talabatTextView != null) {
                        talabatTextView.setVisibility(8);
                    }
                    ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
                } else {
                    IHomeMapPresenter iHomeMapPresenter3 = this.mHomeMapPresenter;
                    if (iHomeMapPresenter3 != null) {
                        boolean z12 = this.isMapCameraFinished;
                        LatLng latLng7 = this.mMainLatLng;
                        if (latLng7 != null) {
                            latLng3 = HomeScreenMapKt.toGoogle(latLng7);
                        } else {
                            latLng3 = null;
                        }
                        iHomeMapPresenter3.cameraAnimationFinished(z12, latLng3, this.isFromBrandOrReorder);
                    }
                }
            } else {
                this.outOfService = false;
                this.isOutOfCountry = true;
                List<com.talabat.configuration.location.Country> countries = getMutableLocationConfigurationRepository().countries();
                int size2 = countries.size();
                String str = "";
                int i13 = 0;
                for (int i14 = 0; i14 < size2; i14++) {
                    str = countries.get(i12).getCountry().getCountryName();
                    i13 = countries.get(i12).getCountry().getCountryId();
                }
                ((RelativeLayout) _$_findCachedViewById(R.id.detail_card_container)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
                ((CardView) _$_findCachedViewById(R.id.deliver_here_card_view)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
                IHomeMapPresenter iHomeMapPresenter4 = this.mHomeMapPresenter;
                if (iHomeMapPresenter4 != null) {
                    boolean z13 = this.isMapCameraFinished;
                    LatLng latLng8 = this.mMainLatLng;
                    if (latLng8 != null) {
                        latLng4 = HomeScreenMapKt.toGoogle(latLng8);
                    } else {
                        latLng4 = null;
                    }
                    iHomeMapPresenter4.changeCountryPrompt(z13, latLng4, str, i13);
                }
            }
        }
        if (this.outOfService) {
            this.isOutOfCountry = true;
            IHomeMapPresenter iHomeMapPresenter5 = this.mHomeMapPresenter;
            if (iHomeMapPresenter5 != null) {
                boolean z14 = this.isMapCameraFinished;
                LatLng latLng9 = this.mMainLatLng;
                if (latLng9 != null) {
                    latLng2 = HomeScreenMapKt.toGoogle(latLng9);
                } else {
                    latLng2 = null;
                }
                iHomeMapPresenter5.outofService(z14, latLng2);
            }
        }
        if (this.isCLocationBtnMovement) {
            LatLng latLng10 = this.mMainLatLng;
            if (latLng10 != null) {
                if (latLng10 != null) {
                    latLng5 = HomeScreenMapKt.toGoogle(latLng10);
                }
                AppTracker.onGeoLocationRecievedHomeMap(this, latLng5);
            }
            this.isCLocationBtnMovement = false;
        }
    }

    private final void changeCountryAlert(int i11, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String string = getResources().getString(R.string.change_country_alert_msg);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…change_country_alert_msg)");
        String replace$default = StringsKt__StringsJVMKt.replace$default(string, "###", str, false, 4, (Object) null);
        String str2 = GlobalDataModel.SelectedCountryName;
        Intrinsics.checkNotNullExpressionValue(str2, "SelectedCountryName");
        String replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, RichContentLoadTimeRecorder.DELIMETER, str2, false, 4, (Object) null);
        builder.setTitle((int) R.string.change_country_btn_txt);
        builder.setMessage((CharSequence) replace$default2);
        builder.setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) new y8(this, i11));
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: changeCountryAlert$lambda-27  reason: not valid java name */
    public static final void m9462changeCountryAlert$lambda27(HomeScreenMap homeScreenMap, int i11, DialogInterface dialogInterface, int i12) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        IHomeMapPresenter iHomeMapPresenter = homeScreenMap.mHomeMapPresenter;
        if (iHomeMapPresenter != null) {
            iHomeMapPresenter.changeUserCountry(i11);
        }
    }

    private final boolean checkPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private final void clearCart(Cart cart, Area area, Address address, LatLng latLng, Float f11, String str) {
        Address address2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        boolean z11 = cart.getRestaurant().isGlrEnabled;
        String str2 = cart.getRestaurant().f13873name + " - " + cart.getCartAreaName();
        if (getCustomerRepository().isLoggedIn()) {
            address2 = Customer.getInstance().getSelectedCustomerAddress();
        } else {
            address2 = null;
        }
        if (z11 && address2 != null) {
            str2 = cart.getRestaurant().f13873name + " - " + address2.profileName + "(" + address2.areaName + ")";
        }
        String string = getString(R.string.already_has_items_in_cart);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…lready_has_items_in_cart)");
        String replace$default = StringsKt__StringsJVMKt.replace$default(string, "#", str2, false, 4, (Object) null);
        builder.setTitle((int) R.string.clear_cart_alert_title);
        builder.setMessage((CharSequence) replace$default);
        builder.setPositiveButton((int) R.string.new_order, (DialogInterface.OnClickListener) new c9(this, area, address, latLng, f11, str));
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new d9(this));
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCart$lambda-17  reason: not valid java name */
    public static final void m9463clearCart$lambda17(HomeScreenMap homeScreenMap, Area area, Address address, LatLng latLng, Float f11, String str, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        Intrinsics.checkNotNullParameter(str, "$userSelectedAddress");
        Cart.getInstance().clearCart(homeScreenMap);
        homeScreenMap.selectArea(area, address, latLng, f11, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCart$lambda-18  reason: not valid java name */
    public static final void m9464clearCart$lambda18(HomeScreenMap homeScreenMap, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        homeScreenMap.stopLodingPopup();
    }

    private final ArrayList<PolygonOptions> createPolygonPathForAllCountries() {
        ArrayList<PolygonOptions> arrayList = new ArrayList<>();
        int size = GlobalDataModel.GEO_CORDINATES.allCountryPolygonRMS.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList<com.google.android.gms.maps.model.LatLng> countyPoints = GlobalDataModel.GEO_CORDINATES.allCountryPolygonRMS.get(i11).getCountyPoints();
            Intrinsics.checkNotNull(countyPoints);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(countyPoints, 10));
            for (com.google.android.gms.maps.model.LatLng access$toOur : countyPoints) {
                arrayList2.add(HomeScreenMapKt.toOur(access$toOur, getLatLngFactory()));
            }
            PolygonOptions newPolygonOptions = getModelsRepository().newPolygonOptions();
            newPolygonOptions.addAll(arrayList2).strokeColor(0).strokeWidth(2.0f);
            arrayList.add(newPolygonOptions);
        }
        return arrayList;
    }

    private final void currentLocReceived(boolean z11) {
        refreshMapCurrentLoc();
        this.isCLocationBtnMovement = true;
        this.isDragTutHided = false;
        hideMapDragMapTutorial();
        MapContainerFragment mapContainerFragment = this.mapFragment;
        if (mapContainerFragment != null) {
            mapContainerFragment.legacyHideLocationButton(true);
        }
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        if (currentLocationFetch2.userAllowedAllLocationPermissions(this)) {
            if (z11) {
                if (GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG) {
                    ImageView imageView = (ImageView) _$_findCachedViewById(R.id.location_btn);
                    Intrinsics.checkNotNullExpressionValue(imageView, "location_btn");
                    fadeInFadeOutAnim(imageView, this.gpsAnimImgs, 0, true);
                    CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
                    Intrinsics.checkNotNull(currentLocationFetch3);
                    currentLocationFetch3.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_MAP());
                    CurrentLocationFetch currentLocationFetch4 = this.currentLocationFetch;
                    if (currentLocationFetch4 != null) {
                        currentLocationFetch4.fetchCurrentLocation();
                    }
                    GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG = false;
                    try {
                        AlertDialog alertDialog2 = this.alertDialog;
                        if (alertDialog2 != null) {
                            Intrinsics.checkNotNull(alertDialog2);
                            if (alertDialog2.isShowing()) {
                                AlertDialog alertDialog3 = this.alertDialog;
                                Intrinsics.checkNotNull(alertDialog3);
                                alertDialog3.dismiss();
                            }
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    CurrentLocationFetch currentLocationFetch5 = this.currentLocationFetch;
                    if (currentLocationFetch5 != null) {
                        currentLocationFetch5.updateLocationRequestType(CurrentLocHelper.INSTANCE.getIS_FROM_MAP_CURRENT_LOC());
                    }
                }
            }
            IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
            if (iHomeMapPresenter != null) {
                iHomeMapPresenter.resetPreLocation(true);
            }
            this.reachedLoc = false;
            AppTracker.onMapLocateMeClicked(this, this.mapJourneyType);
            return;
        }
        CurrentLocationFetch currentLocationFetch6 = this.currentLocationFetch;
        if (currentLocationFetch6 != null) {
            currentLocationFetch6.fetchCurrentLocation();
        }
    }

    private final void currentlocationMovement(LatLng latLng) {
        IHomeMapPresenter iHomeMapPresenter;
        com.google.android.gms.maps.model.LatLng latLng2;
        if (!this.isCLocationBtnMovement || latLng == null) {
            this.locationMethod = TrackingUtils.INSTANCE.getAddressMethodSaved();
            if (!this.isIgnoreCurrentLocationMovement && !this.reachedLoc && (iHomeMapPresenter = this.mHomeMapPresenter) != null) {
                com.google.android.gms.maps.model.LatLng latLng3 = GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME;
                LatLng latLng4 = this.mUserSavedTempLocation;
                com.google.android.gms.maps.model.LatLng latLng5 = null;
                if (latLng4 != null) {
                    latLng2 = HomeScreenMapKt.toGoogle(latLng4);
                } else {
                    latLng2 = null;
                }
                Float f11 = this.mUserSavedTempZoomLevel;
                LatLng latLng6 = this.areaCenterLatLng;
                if (latLng6 != null) {
                    latLng5 = HomeScreenMapKt.toGoogle(latLng6);
                }
                iHomeMapPresenter.LocationReceived(latLng3, latLng2, f11, latLng5);
                return;
            }
            return;
        }
        AppTracker.onGeoLocationRecievedHomeMap(this, HomeScreenMapKt.toGoogle(latLng));
        this.locationMethod = TrackingUtils.INSTANCE.getLocationMethodLocate();
        IHomeMapPresenter iHomeMapPresenter2 = this.mHomeMapPresenter;
        if (iHomeMapPresenter2 != null) {
            iHomeMapPresenter2.FromCurrentLocationClick(HomeScreenMapKt.toGoogle(latLng), Float.valueOf(18.0f));
        }
        this.isCLocationBtnMovement = false;
    }

    private final double deg2rad(double d11) {
        return (d11 * 3.141592653589793d) / 180.0d;
    }

    private final void deliverBtnEnable() {
        int i11 = R.id.deliver_here;
        ((RelativeLayout) _$_findCachedViewById(i11)).setVisibility(0);
        if (this.interactedWithMap) {
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout != null) {
                relativeLayout.setEnabled(true);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout2 != null) {
                relativeLayout2.setClickable(true);
            }
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout3 != null) {
                relativeLayout3.setAlpha(1.0f);
            }
            ((RelativeLayout) _$_findCachedViewById(i11)).setBackgroundResource(R.drawable.rounded_button_fill);
            showMapDragTutorial(false);
            ((ImageView) _$_findCachedViewById(R.id.map_pin)).setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.icon_pin));
            return;
        }
        boolean z11 = this.isCameraSettled;
        if (z11 && this.mUserCurrentLocation != null) {
            RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout4 != null) {
                relativeLayout4.setEnabled(true);
            }
            RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout5 != null) {
                relativeLayout5.setClickable(true);
            }
            RelativeLayout relativeLayout6 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout6 != null) {
                relativeLayout6.setAlpha(1.0f);
            }
            ((RelativeLayout) _$_findCachedViewById(i11)).setBackgroundResource(R.drawable.rounded_button_fill);
            showMapDragTutorial(false);
        } else if (z11 && this.areaCenterLatLng != null) {
            RelativeLayout relativeLayout7 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout7 != null) {
                relativeLayout7.setEnabled(false);
            }
            RelativeLayout relativeLayout8 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout8 != null) {
                relativeLayout8.setClickable(false);
            }
            ((RelativeLayout) _$_findCachedViewById(i11)).setBackgroundResource(R.drawable.ic_map_bg_disabled);
            if (this.isCameraSettled && this.isMapCameraFinished) {
                showMapDragTutorial(true);
            }
        }
    }

    private final void deliverHereCheck() {
        LatLng latLng;
        com.google.android.gms.maps.model.LatLng latLng2;
        CameraPosition cameraPosition;
        FrameworkMap frameworkMap = this.mMap;
        com.google.android.gms.maps.model.LatLng latLng3 = null;
        if (frameworkMap == null || (cameraPosition = frameworkMap.getCameraPosition()) == null) {
            latLng = null;
        } else {
            latLng = cameraPosition.getTarget();
        }
        this.mMainLatLng = latLng;
        if (latLng != null) {
            getSetHasUserPinnedLocationInOnboardingMapUseCase().userPinnedLocationManually(GeoCoordinateKt.geo(latLng.getLatitude(), latLng.getLongitude()));
        }
        Object tag = ((RelativeLayout) _$_findCachedViewById(R.id.deliver_here)).getTag();
        if (Intrinsics.areEqual(tag, (Object) 1)) {
            startLodingPopup();
            LatLng latLng4 = this.mMainLatLng;
            if (latLng4 != null) {
                latLng2 = HomeScreenMapKt.toGoogle(latLng4);
            } else {
                latLng2 = null;
            }
            AppTracker.onDeliverHereClicked(this, latLng2);
            IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
            if (iHomeMapPresenter != null) {
                LatLng latLng5 = this.mMainLatLng;
                if (latLng5 != null) {
                    latLng3 = HomeScreenMapKt.toGoogle(latLng5);
                }
                iHomeMapPresenter.convertLocationToArea(latLng3);
            }
            AppTracker.onMapConfirmed(this, this.mapJourneyType);
        } else if (Intrinsics.areEqual(tag, (Object) 3)) {
            IHomeMapPresenter iHomeMapPresenter2 = this.mHomeMapPresenter;
            if (iHomeMapPresenter2 != null) {
                iHomeMapPresenter2.brandDeliverHereDecisionHandler(this.restBranchId, this.isFranchiseRes);
            }
            LatLng latLng6 = this.mMainLatLng;
            if (latLng6 != null) {
                latLng3 = HomeScreenMapKt.toGoogle(latLng6);
            }
            AppTracker.onDeliverHereClicked(this, latLng3);
        } else if (Intrinsics.areEqual(tag, (Object) 2)) {
            changeCountryAlert(this.changedCountryId, this.changeCountryName);
        }
    }

    private final boolean dismissDialog() {
        Dialog dialog = this.popupWindow;
        if (dialog == null) {
            return false;
        }
        Intrinsics.checkNotNull(dialog);
        if (dialog.isShowing()) {
            return true;
        }
        return false;
    }

    private final double distanceBetweenTwoCordinatesbet(double d11, double d12, double d13, double d14) {
        double rad2deg = rad2deg(Math.acos((Math.sin(deg2rad(d11)) * Math.sin(deg2rad(d13))) + (Math.cos(deg2rad(d11)) * Math.cos(deg2rad(d13)) * Math.cos(deg2rad(d12 - d14))))) * 69090.0d;
        this.trackingDistance = rad2deg;
        return rad2deg;
    }

    private final void drawAllCountryPolygon() {
        Polygon polygon;
        ArrayList<PolygonOptions> createPolygonPathForAllCountries = createPolygonPathForAllCountries();
        this.allCountryPolygon = new ArrayList<>();
        int size = createPolygonPathForAllCountries.size();
        for (int i11 = 0; i11 < size; i11++) {
            FrameworkMap frameworkMap = this.mMap;
            if (frameworkMap != null) {
                PolygonOptions polygonOptions = createPolygonPathForAllCountries.get(i11);
                Intrinsics.checkNotNullExpressionValue(polygonOptions, "allCountryPolygonOptions[i]");
                polygon = frameworkMap.addPolygon(polygonOptions);
            } else {
                polygon = null;
            }
            ArrayList<Polygon> arrayList = this.allCountryPolygon;
            if (arrayList != null) {
                Intrinsics.checkNotNull(polygon);
                arrayList.add(polygon);
            }
            this.isPolygonDrawned = true;
        }
    }

    private final void drawCountryPolygon() {
        ArrayList<AllCountryPolygonRM> arrayList;
        if (!this.isPolygonDrawned && (arrayList = GlobalDataModel.GEO_CORDINATES.allCountryPolygonRMS) != null && arrayList.size() > 0) {
            drawAllCountryPolygon();
        }
    }

    /* access modifiers changed from: private */
    public final void fadeInFadeOutAnim(ImageView imageView, int[] iArr, int i11, boolean z11) {
        imageView.setVisibility(4);
        imageView.setImageResource(iArr[i11]);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        long j11 = (long) 300;
        alphaAnimation.setDuration(j11);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setInterpolator(new AccelerateInterpolator());
        alphaAnimation2.setStartOffset((long) 450);
        alphaAnimation2.setDuration(j11);
        AnimationSet animationSet = new AnimationSet(false);
        this.animation = animationSet;
        animationSet.setFillAfter(true);
        AnimationSet animationSet2 = this.animation;
        if (animationSet2 != null) {
            animationSet2.addAnimation(alphaAnimation);
        }
        AnimationSet animationSet3 = this.animation;
        if (animationSet3 != null) {
            animationSet3.addAnimation(alphaAnimation2);
        }
        AnimationSet animationSet4 = this.animation;
        if (animationSet4 != null) {
            animationSet4.setRepeatCount(1);
        }
        imageView.setAnimation(this.animation);
        AnimationSet animationSet5 = this.animation;
        if (animationSet5 != null) {
            animationSet5.setAnimationListener(new HomeScreenMap$fadeInFadeOutAnim$1(iArr, i11, this, imageView, z11));
        }
    }

    private final int getPixelFromDp(int i11) {
        return (int) TypedValue.applyDimension(1, (float) i11, getResources().getDisplayMetrics());
    }

    private final PlaceSelectionListener getPlaceSelectionListener() {
        return new HomeScreenMap$getPlaceSelectionListener$1(this);
    }

    /* access modifiers changed from: private */
    public final void googleAutoCompleteWidget(Place place) {
        LatLng latLng;
        this.locationMethod = TrackingUtils.INSTANCE.getLocationMethodAutocomplete();
        IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
        if (iHomeMapPresenter != null) {
            iHomeMapPresenter.resetPreLocation(true);
        }
        if (place.getLatLng() != null) {
            com.google.android.gms.maps.model.LatLng latLng2 = place.getLatLng();
            if (latLng2 != null) {
                latLng = HomeScreenMapKt.toOur(latLng2, getLatLngFactory());
            } else {
                latLng = null;
            }
            this.mMainLatLng = latLng;
            hideMapDragMapTutorial();
            animateMapCammera(place.getLatLng(), Float.valueOf(18.0f));
            AutocompleteSupportFragment autocompleteSupportFragment2 = this.autocompleteSupportFragment;
            if (autocompleteSupportFragment2 != null) {
                autocompleteSupportFragment2.setText(place.getName());
            }
        }
    }

    private final void gpsLocationSettingsAlert() {
        Window window;
        Window window2;
        Window window3;
        View view;
        View view2;
        int i11;
        View findViewById;
        View findViewById2;
        GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG = true;
        if (!dismissDialog()) {
            Dialog dialog = new Dialog(this, R.style.CustomStyle);
            this.popupWindow = dialog;
            dialog.requestWindowFeature(1);
            Dialog dialog2 = this.popupWindow;
            if (dialog2 != null) {
                dialog2.setContentView(R.layout.gps_enable_popup);
            }
            Dialog dialog3 = this.popupWindow;
            View view3 = null;
            if (dialog3 != null) {
                window = dialog3.getWindow();
            } else {
                window = null;
            }
            Intrinsics.checkNotNull(window);
            window.addFlags(4);
            Dialog dialog4 = this.popupWindow;
            if (dialog4 != null) {
                window2 = dialog4.getWindow();
            } else {
                window2 = null;
            }
            Intrinsics.checkNotNull(window2);
            window2.setBackgroundDrawable(new ColorDrawable(0));
            Dialog dialog5 = this.popupWindow;
            if (dialog5 != null) {
                dialog5.setCancelable(false);
            }
            Dialog dialog6 = this.popupWindow;
            if (dialog6 != null) {
                dialog6.setCanceledOnTouchOutside(false);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i12 = (int) (((double) displayMetrics.widthPixels) * 0.9d);
            Dialog dialog7 = this.popupWindow;
            if (dialog7 != null) {
                window3 = dialog7.getWindow();
            } else {
                window3 = null;
            }
            Intrinsics.checkNotNull(window3);
            window3.setLayout(i12, -2);
            String string = getString(R.string.gps_enable_popup_allow_location_msg_txt);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…p_allow_location_msg_txt)");
            String string2 = getResources().getString(R.string.talabat_app_name);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(com.….string.talabat_app_name)");
            String replace$default = StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, string2, false, 4, (Object) null);
            String string3 = getString(R.string.gps_seetings_txt1);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(com.talabat.lo…string.gps_seetings_txt1)");
            String string4 = getResources().getString(R.string.talabat_app_name);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(com.….string.talabat_app_name)");
            String replace$default2 = StringsKt__StringsJVMKt.replace$default(string3, RichContentLoadTimeRecorder.DELIMETER, string4, false, 4, (Object) null);
            Dialog dialog8 = this.popupWindow;
            if (dialog8 != null) {
                view = dialog8.findViewById(R.id.msg_txt);
            } else {
                view = null;
            }
            if (view != null) {
                TextView textView = (TextView) view;
                Dialog dialog9 = this.popupWindow;
                if (dialog9 != null) {
                    view2 = dialog9.findViewById(R.id.gps_steps_x1);
                } else {
                    view2 = null;
                }
                if (view2 != null) {
                    TextView textView2 = (TextView) view2;
                    Dialog dialog10 = this.popupWindow;
                    if (dialog10 != null) {
                        view3 = dialog10.findViewById(R.id.gps_steps_2);
                    }
                    if (view3 != null) {
                        TextView textView3 = (TextView) view3;
                        int i13 = 5;
                        if (TalabatUtils.isRTL()) {
                            i11 = 5;
                        } else {
                            i11 = 3;
                        }
                        textView2.setGravity(i11);
                        if (!TalabatUtils.isRTL()) {
                            i13 = 3;
                        }
                        textView3.setGravity(i13);
                        textView.setText(replace$default);
                        textView2.setText(replace$default2);
                        Dialog dialog11 = this.popupWindow;
                        if (!(dialog11 == null || (findViewById2 = dialog11.findViewById(R.id.go_to_settings)) == null)) {
                            findViewById2.setOnClickListener(new v8(this));
                        }
                        Dialog dialog12 = this.popupWindow;
                        if (!(dialog12 == null || (findViewById = dialog12.findViewById(R.id.no_thanks)) == null)) {
                            findViewById.setOnClickListener(new w8(this));
                        }
                        Dialog dialog13 = this.popupWindow;
                        if (dialog13 != null) {
                            dialog13.show();
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gpsLocationSettingsAlert$lambda-28  reason: not valid java name */
    public static final void m9465gpsLocationSettingsAlert$lambda28(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        homeScreenMap.openSettings();
        Dialog dialog = homeScreenMap.popupWindow;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gpsLocationSettingsAlert$lambda-29  reason: not valid java name */
    public static final void m9466gpsLocationSettingsAlert$lambda29(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        Dialog dialog = homeScreenMap.popupWindow;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void hideMapDragMapTutorial() {
        int i11 = R.id.drag_tut_container;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(i11);
        boolean z11 = false;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            z11 = true;
        }
        if (z11 && !this.isDragTutHided) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_off);
            loadAnimation.setDuration(300);
            loadAnimation.setFillAfter(true);
            this.isDragTutHided = true;
            loadAnimation.setAnimationListener(new HomeScreenMap$hideMapDragMapTutorial$1(this));
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(i11);
            if (linearLayout2 != null) {
                linearLayout2.startAnimation(loadAnimation);
            }
        }
    }

    private final void initInitialView() {
        IHomeMapPresenter iHomeMapPresenter;
        IHomeMapPresenter iHomeMapPresenter2;
        IHomeMapPresenter iHomeMapPresenter3;
        this.ignoreCurrentloctionRequest = getIntent().getBooleanExtra("isIgnoreCurrentLocation", false);
        this.ignoreSavedLoc = getIntent().getBooleanExtra("isIgnoreSavedLoc", false);
        boolean z11 = this.isFromReOrder;
        if (z11 && (iHomeMapPresenter3 = this.mHomeMapPresenter) != null) {
            iHomeMapPresenter3.updateResInfoFromReOrder(z11, this.reorderId, this.reorderResId);
        }
        IHomeMapPresenter iHomeMapPresenter4 = this.mHomeMapPresenter;
        if (iHomeMapPresenter4 != null) {
            iHomeMapPresenter4.mapDecesionHandler(this.ignoreCurrentloctionRequest, this.userSelectedAddress, getIntent().getIntExtra("isUserSelectedAddressAreaId", 0), this.userSelectedLatLng, this.ignoreSavedLoc);
        }
        int i11 = R.id.default_search_container;
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(i11);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        int i12 = R.id.google_place_search_fragment;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(i12);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        if (GlobalDataModel.Apptimize.CAN_SHOW_GOOGLE_AUTO_COMPLETE_WIDGET) {
            ((LinearLayout) _$_findCachedViewById(R.id.google_auto_widget_container)).setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.place_search_container)).setVisibility(8);
            AutocompleteSupportFragment autocompleteSupportFragment2 = (AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.autocomplete_support_fragment);
            this.autocompleteSupportFragment = autocompleteSupportFragment2;
            if (autocompleteSupportFragment2 != null) {
                autocompleteSupportFragment2.setPlaceFields(CollectionsKt__CollectionsKt.listOf(Place.Field.ID, Place.Field.LAT_LNG, Place.Field.NAME));
            }
            AutocompleteSupportFragment autocompleteSupportFragment3 = this.autocompleteSupportFragment;
            if (autocompleteSupportFragment3 != null) {
                autocompleteSupportFragment3.setCountry(TalabatUtils.getSelectedCountryIso3166());
            }
            AutocompleteSupportFragment autocompleteSupportFragment4 = this.autocompleteSupportFragment;
            if (autocompleteSupportFragment4 != null) {
                autocompleteSupportFragment4.setHint(getResources().getString(R.string.map_seach_hint));
            }
            AutocompleteSupportFragment autocompleteSupportFragment5 = this.autocompleteSupportFragment;
            if (autocompleteSupportFragment5 != null) {
                autocompleteSupportFragment5.setOnPlaceSelectedListener(getPlaceSelectionListener());
            }
        } else if (GlobalDataModel.Apptimize.CAN_SHOW_CUSTOM_GOOGLE_AUTO_COMPLETE_WIDGET) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFromCart", false);
            bundle.putBoolean("isFroForceFocus", this.isForceRedirectSearch);
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(i12);
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
            CustomAutoCompleteFragment customAutoCompleteFragment2 = new CustomAutoCompleteFragment();
            this.customAutoCompleteFragment = customAutoCompleteFragment2;
            Intrinsics.checkNotNull(customAutoCompleteFragment2);
            beginTransaction.add((int) R.id.google_place_search_fragment, (Fragment) customAutoCompleteFragment2, "CustomAutoCompleteFragment");
            CustomAutoCompleteFragment customAutoCompleteFragment3 = this.customAutoCompleteFragment;
            if (customAutoCompleteFragment3 != null) {
                customAutoCompleteFragment3.setArguments(bundle);
            }
            beginTransaction.commit();
        } else {
            ((LinearLayout) _$_findCachedViewById(R.id.google_auto_widget_container)).setVisibility(8);
        }
        int i13 = R.id.location_btn;
        ((ImageView) _$_findCachedViewById(i13)).setVisibility(8);
        if (GlobalConstants.isDrawCountryPolygon && (iHomeMapPresenter2 = this.mHomeMapPresenter) != null) {
            iHomeMapPresenter2.loadCountryPolygon(this);
        }
        int i14 = R.id.ed_search_location;
        ((MaterialEditText) _$_findCachedViewById(i14)).setHint(getResources().getString(R.string.map_seach_hint));
        FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(R.id.location_btn_sub_container);
        if (frameLayout3 != null) {
            frameLayout3.setOnClickListener(new f9(this));
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(i13);
        if (imageView != null) {
            imageView.setOnClickListener(new l8(this));
        }
        int i15 = R.id.deliver_here;
        ((RelativeLayout) _$_findCachedViewById(i15)).setOnClickListener(new m8(this));
        ((ImageView) _$_findCachedViewById(R.id.back_map)).setOnClickListener(new n8(this));
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.reset_to_cl);
        if (talabatTextView != null) {
            talabatTextView.setOnClickListener(new o8(this));
        }
        TalabatTextView talabatTextView2 = (TalabatTextView) _$_findCachedViewById(R.id.yes_deliver_here);
        if (talabatTextView2 != null) {
            talabatTextView2.setOnClickListener(new p8(this));
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.map_view_switch_btn);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new q8(this));
        }
        int i16 = R.id.edit_text_container;
        ((TalabatToolBarSearchRelativeLayout) _$_findCachedViewById(i16)).bringToFront();
        ((MaterialEditText) _$_findCachedViewById(i14)).setClickable(true);
        ((MaterialEditText) _$_findCachedViewById(i14)).setFocusable(false);
        ((MaterialEditText) _$_findCachedViewById(i14)).setInputType(0);
        ((TalabatToolBarSearchRelativeLayout) _$_findCachedViewById(i16)).setOnClickListener(new r8(this));
        ((LinearLayout) _$_findCachedViewById(R.id.place_search_container)).setOnClickListener(new s8(this));
        ((MaterialEditText) _$_findCachedViewById(i14)).setOnClickListener(new u8(this));
        int i17 = R.id.search_clear;
        ((RelativeLayout) _$_findCachedViewById(i17)).setOnClickListener(new j8(this));
        ((MaterialEditText) _$_findCachedViewById(i14)).addTextChangedListener(new HomeScreenMap$initInitialView$12(this));
        ((RelativeLayout) _$_findCachedViewById(i17)).setOnClickListener(new k8(this));
        deliverBtnEnable();
        if (this.isFromBrandOrReorder) {
            ((RelativeLayout) _$_findCachedViewById(i15)).setTag(3);
        } else {
            ((RelativeLayout) _$_findCachedViewById(i15)).setTag(1);
        }
        if (this.isFromReOrder && (iHomeMapPresenter = this.mHomeMapPresenter) != null) {
            iHomeMapPresenter.loadReOrderDeliveryArea(this.reorderId);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-1  reason: not valid java name */
    public static final void m9467initInitialView$lambda1(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        ((ImageView) homeScreenMap._$_findCachedViewById(R.id.location_btn)).performClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-10  reason: not valid java name */
    public static final void m9468initInitialView$lambda10(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        homeScreenMap.loaPlaceSearchScreen();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-11  reason: not valid java name */
    public static final void m9469initInitialView$lambda11(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        ((MaterialEditText) homeScreenMap._$_findCachedViewById(R.id.ed_search_location)).setText("");
        homeScreenMap.loaPlaceSearchScreen();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-12  reason: not valid java name */
    public static final void m9470initInitialView$lambda12(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        ((MaterialEditText) homeScreenMap._$_findCachedViewById(R.id.ed_search_location)).setText("");
        homeScreenMap.loaPlaceSearchScreen();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-2  reason: not valid java name */
    public static final void m9471initInitialView$lambda2(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        homeScreenMap.locationMethod = TrackingUtils.INSTANCE.getLocationMethodLocate();
        homeScreenMap.isCLocationBtnClicked = true;
        homeScreenMap.currentLocReceived(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-3  reason: not valid java name */
    public static final void m9472initInitialView$lambda3(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        homeScreenMap.deliverHereCheck();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-4  reason: not valid java name */
    public static final void m9473initInitialView$lambda4(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        AppTracker.onMapClosed(homeScreenMap, homeScreenMap.mapJourneyType);
        homeScreenMap.setResult(0);
        homeScreenMap.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-5  reason: not valid java name */
    public static final void m9474initInitialView$lambda5(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        GlobalDataModel.HOME_SCREEN_MAP.USER_IGNORE_LOCATION_AWARENESS = false;
        homeScreenMap.locationMethod = TrackingUtils.INSTANCE.getLocationMethodResetToMyLocation();
        homeScreenMap.currentLocReceived(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-6  reason: not valid java name */
    public static final void m9475initInitialView$lambda6(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        GlobalDataModel.HOME_SCREEN_MAP.USER_IGNORE_LOCATION_AWARENESS = true;
        RelativeLayout relativeLayout = (RelativeLayout) homeScreenMap._$_findCachedViewById(R.id.deliver_here);
        if (relativeLayout != null) {
            relativeLayout.performClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-7  reason: not valid java name */
    public static final void m9476initInitialView$lambda7(HomeScreenMap homeScreenMap, View view) {
        FrameworkMap.MapType mapType;
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        FrameworkMap frameworkMap = homeScreenMap.mMap;
        if (frameworkMap != null) {
            if (frameworkMap != null) {
                mapType = frameworkMap.getMapType();
            } else {
                mapType = null;
            }
            FrameworkMap.MapType mapType2 = FrameworkMap.MapType.MAP_TYPE_SATELLITE;
            if (mapType == mapType2) {
                homeScreenMap.mapViewType = "plain";
                ((ImageView) homeScreenMap._$_findCachedViewById(R.id.map_view_switch_btn)).setImageDrawable(homeScreenMap.getResources().getDrawable(R.drawable.ic_m_satlite_off));
                FrameworkMap frameworkMap2 = homeScreenMap.mMap;
                if (frameworkMap2 != null) {
                    frameworkMap2.setMapType(FrameworkMap.MapType.MAP_TYPE_NORMAL);
                }
            } else {
                homeScreenMap.mapViewType = "satellite";
                FrameworkMap frameworkMap3 = homeScreenMap.mMap;
                if (frameworkMap3 != null) {
                    frameworkMap3.setMapType(mapType2);
                }
                ((ImageView) homeScreenMap._$_findCachedViewById(R.id.map_view_switch_btn)).setImageDrawable(homeScreenMap.getResources().getDrawable(R.drawable.ic_m_satlite_on));
            }
            AppTracker.onMapViewChanged(homeScreenMap, homeScreenMap.mapViewType, homeScreenMap.mapJourneyType);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-8  reason: not valid java name */
    public static final void m9477initInitialView$lambda8(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        homeScreenMap.loaPlaceSearchScreen();
    }

    /* access modifiers changed from: private */
    /* renamed from: initInitialView$lambda-9  reason: not valid java name */
    public static final void m9478initInitialView$lambda9(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        homeScreenMap.loaPlaceSearchScreen();
    }

    private final void initMapView() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.home_map);
        if (findFragmentById != null) {
            MapContainerFragment mapContainerFragment = (MapContainerFragment) findFragmentById;
            this.mapFragment = mapContainerFragment;
            mapContainerFragment.init(new HomeMapWrapperLayout(this));
            mapContainerFragment.getMapAsync(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.maps.presentation.MapContainerFragment");
    }

    private final boolean isHomeScreenToFoodListDeeplinkEnabled() {
        return getTalabatFeatureFlag().getFeatureFlag(VendorListFeatureFlagsKeys.VENDORLIST_DEEP_LINK_NAVIGATION_HOF, false);
    }

    private final boolean isNeedToClearCart(Area area) {
        Cart.getSavedMcdCartAddress(this);
        Cart instance = Cart.getInstance();
        if (area == null) {
            return false;
        }
        if (area instanceof AddressArea) {
            if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                if (instance.getInforMapAddress() != null) {
                    if (TalabatUtils.isNullOrEmpty(instance.getInforMapAddress().grlid)) {
                        return false;
                    }
                    CustomerRepository customerRepository2 = getCustomerRepository();
                    String str = ((AddressArea) area).profileId;
                    Intrinsics.checkNotNullExpressionValue(str, "area.profileId");
                    if (Intrinsics.areEqual((Object) customerRepository2.getGlrId(str), (Object) instance.getInforMapAddress().grlid)) {
                        return false;
                    }
                } else if (!TalabatUtils.isNullOrEmpty(instance.getCartSelectedGrlID())) {
                    CustomerRepository customerRepository3 = getCustomerRepository();
                    String str2 = ((AddressArea) area).profileId;
                    Intrinsics.checkNotNullExpressionValue(str2, "area.profileId");
                    if (Intrinsics.areEqual((Object) customerRepository3.getGlrId(str2), (Object) instance.getInforMapAddress().grlid)) {
                        return false;
                    }
                }
            } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                if (Cart.getInstance().getMcdBhBlockAddress() != null) {
                    if (TalabatUtils.isNullOrEmpty(instance.getMcdBhBlockAddress().block)) {
                        return false;
                    }
                    CustomerRepository customerRepository4 = getCustomerRepository();
                    String str3 = ((AddressArea) area).profileId;
                    Intrinsics.checkNotNullExpressionValue(str3, "area.profileId");
                    if (Intrinsics.areEqual((Object) customerRepository4.getBlock(str3), (Object) instance.getMcdBhBlockAddress().block)) {
                        return false;
                    }
                }
            } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
                return false;
            }
        }
        return true;
    }

    private final boolean isShowCurrentLocationAwareness() {
        boolean z11;
        boolean z12;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        LocationConfig config = getMutableLocationConfigurationRepository().config();
        if (config.getMetersOfLocationAwareness() == 0) {
            getMutableLocationConfigurationRepository().setConfig(LocationConfig.copy$default(config, (List) null, (List) null, (Country) null, (List) null, false, 200, 31, (Object) null));
        }
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        if (currentLocationFetch2 != null) {
            z11 = currentLocationFetch2.userAllowedAllLocationPermissions(this);
        } else {
            z11 = false;
        }
        LatLng latLng = this.currentLoc;
        if (latLng != null) {
            if (latLng != null) {
                d15 = latLng.getLatitude();
            } else {
                d15 = 0.0d;
            }
            if (d15 > 0.0d) {
                LatLng latLng2 = this.currentLoc;
                if (latLng2 != null) {
                    d16 = latLng2.getLongitude();
                } else {
                    d16 = 0.0d;
                }
                if (d16 > 0.0d) {
                    z12 = true;
                    if (!z11 && z12) {
                        LatLng latLng3 = this.currentLoc;
                        if (latLng3 != null) {
                            d11 = latLng3.getLatitude();
                        } else {
                            d11 = 0.0d;
                        }
                        LatLng latLng4 = this.currentLoc;
                        if (latLng4 != null) {
                            d12 = latLng4.getLongitude();
                        } else {
                            d12 = 0.0d;
                        }
                        LatLng latLng5 = this.mMainLatLng;
                        if (latLng5 != null) {
                            d13 = latLng5.getLatitude();
                        } else {
                            d13 = 0.0d;
                        }
                        LatLng latLng6 = this.mMainLatLng;
                        if (latLng6 != null) {
                            d14 = latLng6.getLongitude();
                        } else {
                            d14 = 0.0d;
                        }
                        if (distanceBetweenTwoCordinatesbet(d11, d12, d13, d14) > ((double) getMutableLocationConfigurationRepository().config().getMetersOfLocationAwareness())) {
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        z12 = false;
        return !z11 ? false : false;
    }

    private final void loaPlaceSearchScreen() {
        hideMapDragMapTutorial();
        this.isDragTutHided = false;
        Intent intent = new Intent(this, HomeMapPlaceSearchScreen.class);
        intent.putExtra("searchKey", String.valueOf(((MaterialEditText) _$_findCachedViewById(R.id.ed_search_location)).getText()));
        intent.putExtra("currentLocationAvail", this.isDefaultLocationEnable);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, this.isFromBrandOrReorder);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER, this.isFromReOrder);
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME, this.reorderResName);
        startActivityForResult(intent, 36);
    }

    private final void loadForceSearchScreen() {
        if (this.isForceRedirectSearch) {
            if (GlobalDataModel.Apptimize.CAN_SHOW_CUSTOM_GOOGLE_AUTO_COMPLETE_WIDGET) {
                this.isHideDragTutFromSearch = true;
                CustomAutoCompleteFragment customAutoCompleteFragment2 = this.customAutoCompleteFragment;
                if (customAutoCompleteFragment2 != null) {
                    customAutoCompleteFragment2.forceFocus();
                }
            } else {
                loaPlaceSearchScreen();
            }
            this.isForceRedirectSearch = false;
        }
    }

    private final void locationButton(boolean z11) {
        int i11 = R.id.location_btn;
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
        if (z11) {
            ImageView imageView = (ImageView) _$_findCachedViewById(i11);
            if (imageView != null) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_m_gps_on));
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(i11);
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_m_gps_off));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: locationError$lambda-19  reason: not valid java name */
    public static final void m9479locationError$lambda19(HomeScreenMap homeScreenMap, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        AppTracker.onClosedAfterMapError(homeScreenMap, homeScreenMap.mapJourneyType);
    }

    private final void mapJourneyType() {
        if (!this.isFromBrandOrReorder) {
            this.mapJourneyType = "home";
        } else if (!this.isFromReOrder) {
            this.mapJourneyType = "brand";
        } else if (this.isFromReorderList) {
            this.mapJourneyType = ScreenNames.SCREEN_TYPE_REORDER;
        } else {
            this.mapJourneyType = ScreenNames.SCREEN_TYPE_REORDER;
        }
    }

    private final void navigateToFlutterFoodListDeeplink() {
        DeepLinkNavigator.DefaultImpls.navigateTo$default(getDeepLinkNavigator(), this, "talabat://?s=/food-list-organic", (Function0) null, 4, (Object) null);
    }

    private final void navigateToFlutterFoodListExplicitly() {
        Navigator navigator2 = getNavigator();
        Context context = getContext();
        Double latitudeDouble = GlobalDataModel.LATLONGFORAPI.getLatitudeDouble();
        Intrinsics.checkNotNullExpressionValue(latitudeDouble, "getLatitudeDouble()");
        double doubleValue = latitudeDouble.doubleValue();
        Double longitudeDouble = GlobalDataModel.LATLONGFORAPI.getLongitudeDouble();
        Intrinsics.checkNotNullExpressionValue(longitudeDouble, "getLongitudeDouble()");
        double doubleValue2 = longitudeDouble.doubleValue();
        String valueOf = String.valueOf(GlobalDataModel.SelectedAreaId);
        String valueOf2 = String.valueOf(GlobalDataModel.SelectedCityId);
        int i11 = GlobalDataModel.SelectedCountryId;
        String str = GlobalDataModel.SelectedAreaName;
        Intrinsics.checkNotNullExpressionValue(str, "SelectedAreaName");
        Navigator.DefaultImpls.navigateTo$default(navigator2, context, new FoodListFlutterScreen(new FoodListFlutterScreen.FoodListFlutterData(doubleValue, doubleValue2, valueOf, valueOf2, i11, str)), (Function1) null, 4, (Object) null);
    }

    private final void onLocationDialogAccepted(boolean z11) {
        String str;
        try {
            Context context = getContext();
            String screenType = screenType();
            String locationPromptType = TrackingUtils.INSTANCE.getLocationPromptType();
            if (z11) {
                str = TrackingUtils.TrackingGpsStatus.Enabled.getValue();
            } else {
                str = TrackingUtils.TrackingGpsStatus.Disabled.getValue();
            }
            AppTracker.geolocationDialogueAccepted(context, ScreenNames.SCREEN_HOME_MAP, screenType, "true", locationPromptType, str);
        } catch (Exception unused) {
        }
    }

    private final void onTrackAddressErrorShown(String str) {
        try {
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            String screenType = screenType();
            String str2 = GlobalDataModel.GEO_LOCATION_TRACKING.ADDRESS_STATUS;
            String screenName = getScreenName();
            String str3 = AppTracker.NotAvail;
            AppTracker.onAddressErrorShown(getContext(), trackingUtils.getTrackingAddressObject(this, true, (Address) null, 0, 0, screenType, str2, screenName, str, str3, str3, str3, str3, str3, str3, str3, str3, str3, false, this.locationMethod));
        } catch (Exception unused) {
        }
    }

    private final void onTrackAddressSubmitted(Address address) {
        Integer num;
        boolean z11;
        Address address2 = address;
        try {
            GlobalDataModel.GEO_LOCATION_TRACKING.GEO_LOCATION_API_METHOD = "N/A";
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            Integer num2 = null;
            if (address2 != null) {
                num = Integer.valueOf(address2.cityId);
            } else {
                num = null;
            }
            if (address2 != null) {
                num2 = Integer.valueOf(address2.areaId);
            }
            Integer num3 = num2;
            String screenType = screenType();
            String str = GlobalDataModel.GEO_LOCATION_TRACKING.ADDRESS_STATUS;
            String str2 = AppTracker.NotAvail;
            if (address2 == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            try {
                AddressAnalyticsTracker trackingAddressObject = trackingUtils.getTrackingAddressObject(this, false, address, num, num3, screenType, str, ScreenNames.SCREEN_CHOOSE_SAVED_ADDRESS, str2, str2, str2, str2, str2, str2, str2, str2, str2, str2, z11, this.locationMethod);
                String str3 = GlobalDataModel.SelectedAreaName;
                int i11 = GlobalDataModel.SelectedAreaId;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i11);
                try {
                    AppTracker.onAddressSubmitted(this, str3, sb2.toString(), trackingAddressObject);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
        }
    }

    private final void onTrackGeoLocationRequested(String str, Address address, String str2) {
        Integer num;
        boolean z11;
        Address address2 = address;
        try {
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            Integer num2 = null;
            if (address2 != null) {
                num = Integer.valueOf(address2.cityId);
            } else {
                num = null;
            }
            if (address2 != null) {
                num2 = Integer.valueOf(address2.areaId);
            }
            Integer num3 = num2;
            String screenType = screenType();
            String str3 = AppTracker.NotAvail;
            String screenName = getScreenName();
            String str4 = AppTracker.NotAvail;
            if (address2 == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z12 = z11;
            try {
                AddressAnalyticsTracker trackingAddressObject = trackingUtils.getTrackingAddressObject(this, false, address, num, num3, screenType, str3, screenName, str2, str4, str, str4, str4, str4, str4, str4, str4, str4, z12, this.locationMethod);
                try {
                    double d11 = this.trackingDistance;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(d11);
                    trackingAddressObject.setLocationDistance(sb2.toString());
                    AppTracker.onGeolocationRequested(this, trackingAddressObject);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
        }
    }

    private final void onTrackMapLoaded() {
        GlobalDataModel.GEO_LOCATION_TRACKING.GEO_LOCATION_API_METHOD = "N/A";
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        String screenType = screenType();
        String str = AppTracker.NotAvail;
        String str2 = str;
        String str3 = str;
        String str4 = str;
        String str5 = str;
        String str6 = str;
        String str7 = str;
        String str8 = str;
        String str9 = str;
        AppTracker.onMapLoaded(this, trackingUtils.getTrackingAddressObject(this, true, (Address) null, (Integer) null, 0, screenType, str5, str6, str4, str3, str8, str2, str7, str, str, this.mapViewType, str, str9, true, str));
    }

    private final void openSettings() {
        this.redirectGPSSettings = true;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Uri fromParts = Uri.fromParts("package", BuildConfig.APPLICATION_ID, (String) null);
        intent.setData(fromParts);
        intent.setData(fromParts);
        startActivityForResult(intent, 100);
    }

    private final void prefetchLocationContainer(boolean z11) {
        if (this.isBottomContainerAnimationFinished) {
            CardView cardView = (CardView) _$_findCachedViewById(R.id.deliver_here_card_view);
            if (cardView != null) {
                cardView.setVisibility(0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.detail_card_container);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        } else {
            int i11 = R.id.deliver_here_card_view;
            if (((CardView) _$_findCachedViewById(i11)).getVisibility() == 8) {
                CardView cardView2 = (CardView) _$_findCachedViewById(i11);
                if (cardView2 != null) {
                    cardView2.setVisibility(0);
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(R.id.detail_card_container);
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                }
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_top);
            loadAnimation.setDuration(500);
            loadAnimation.setFillAfter(true);
            CardView cardView3 = (CardView) _$_findCachedViewById(i11);
            if (cardView3 != null) {
                cardView3.startAnimation(loadAnimation);
            }
            this.isBottomContainerAnimationFinished = true;
        }
        if (z11) {
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(R.id.pre_geo_address_container);
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
            }
            ((CardView) _$_findCachedViewById(R.id.deliver_here_card_view)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
            ((RelativeLayout) _$_findCachedViewById(R.id.detail_card_container)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        } else {
            RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(R.id.pre_geo_address_container);
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(8);
            }
            ((TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_hint)).setVisibility(8);
            ((LinearLayout) _$_findCachedViewById(R.id.pre_geo_location_container)).setVisibility(8);
            ((TalabatTextView) _$_findCachedViewById(R.id.deliver_btn_here_txt)).setText(getResources().getString(R.string.deliver_here));
            ((CardView) _$_findCachedViewById(R.id.deliver_here_card_view)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
            ((RelativeLayout) _$_findCachedViewById(R.id.detail_card_container)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        }
        this.ignoreBottomAnim = false;
        animtLocationBtn(z11);
        setPaddingForGoogleLogo(this.mMap, false);
    }

    private final double rad2deg(double d11) {
        return (d11 * 180.0d) / 3.141592653589793d;
    }

    private final void reDirectBrandToMenuScreen(int i11) {
        Intent intent = new Intent();
        intent.putExtra("DeliveryAreaBranchId", i11);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, this.isFromFanchiseRes);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_ADDRESS_UPDATED, this.isAddressUpdateSelected);
        intent.putExtra(GlobalConstants.ExtraNames.FRANCHISE_GRP_ID, this.restGrpId);
        setResult(-1, intent);
        finish();
    }

    private final void reDirectReOrdertCartScreen(int i11) {
        Intent intent = new Intent();
        intent.putExtra("DeliveryAreaBranchId", i11);
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_ID, this.reorderId);
        setResult(-1, intent);
        finish();
    }

    private final void reInitiateLocation() {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.location_btn);
        Intrinsics.checkNotNullExpressionValue(imageView, "location_btn");
        fadeInFadeOutAnim(imageView, this.gpsAnimImgs, 0, true);
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        if (!currentLocationFetch2.isLoactionReequestInitied()) {
            CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
            Intrinsics.checkNotNull(currentLocationFetch3);
            currentLocationFetch3.initLocationRequest(getContext(), CurrentLocHelper.INSTANCE.getIS_FROM_MAP());
        }
        CurrentLocationFetch currentLocationFetch4 = this.currentLocationFetch;
        if (currentLocationFetch4 != null) {
            currentLocationFetch4.startLocationUpdates(this);
        }
    }

    private final void redirectToResListScreen() {
        if (this.isRedirectBacktoHomeFromLocationWelcome && this.fromHome) {
            setResult(-1);
            finish();
        } else if (this.fromHome || this.fromRL) {
            setResult(-1);
            finish();
        } else {
            FilterEngine.resetFilter(false);
            if (isHomeScreenToFoodListDeeplinkEnabled()) {
                navigateToFlutterFoodListDeeplink();
            } else {
                navigateToFlutterFoodListExplicitly();
            }
        }
    }

    private final void redirecttoFreanchiseSelectionScreen(String str) {
        Intent intent = new Intent(this, FranchiseSelectionScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, true);
        intent.putExtra("location", str);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_RES_GRP_ID, this.restGrpId);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, this.isFromFanchiseRes);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_ADDRESS_UPDATED, this.isAddressUpdateSelected);
        intent.putExtra(GlobalConstants.ExtraNames.RESET_PRE_BRANCH, true);
        intent.addFlags(33554432);
        startActivity(intent);
        finish();
    }

    private final void refreshMapCurrentLoc() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            FrameworkMap frameworkMap = this.mMap;
            if (frameworkMap != null) {
                frameworkMap.clear();
            }
            FrameworkMap frameworkMap2 = this.mMap;
            if (frameworkMap2 != null) {
                frameworkMap2.setMyLocationEnabled(true);
            }
        }
    }

    private final void resetCustomerBrandAddress() {
        if (getCustomerRepository().isLoggedIn()) {
            getCustomerRepository().resetBrandLocalAddress();
        }
    }

    private final void resetPreLocationContainer() {
        int i11 = R.id.deliver_here_card_view;
        ((CardView) _$_findCachedViewById(i11)).setVisibility(0);
        int i12 = R.id.detail_card_container;
        ((RelativeLayout) _$_findCachedViewById(i12)).setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.pre_geo_address_container);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.loading_progress);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.pre_geo_location_container);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_txt);
        if (talabatTextView != null) {
            talabatTextView.setVisibility(4);
        }
        TalabatTextView talabatTextView2 = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_hint);
        if (talabatTextView2 != null) {
            talabatTextView2.setVisibility(4);
        }
        TalabatTextView talabatTextView3 = (TalabatTextView) _$_findCachedViewById(R.id.current_location_aware_txt);
        if (talabatTextView3 != null) {
            talabatTextView3.setVisibility(8);
        }
        ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
        ((CardView) _$_findCachedViewById(i11)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        ((RelativeLayout) _$_findCachedViewById(i12)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
    }

    private final void saveForLaterAddress(Address address, Address address2) {
        Double d11;
        Customer.getInstance().setMapSaveLaterAddress(address.f58343id, address2);
        selectAddress(address2, false);
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        homeMapTemp.mapFirstUpdateOption(GlobalDataModel.HOME_SCREEN_MAP.SAVE_FOR_LATER);
        homeMapTemp.setHomeMapRedirect(true, this);
        homeMapTemp.setTempAddress(address2);
        homeMapTemp.updateAddressNotSaved(false);
        Double d12 = null;
        if (address2 != null) {
            d11 = Double.valueOf(address2.latitude);
        } else {
            d11 = null;
        }
        if (address2 != null) {
            d12 = Double.valueOf(address2.longitude);
        }
        String str = d11 + "," + d12;
        if (!this.isFromBrandOrReorder) {
            redirectToResListScreen();
        } else if (this.isFromReOrder) {
            reDirectReOrdertCartScreen(this.restBranchId);
        } else if (this.isFranchiseRes) {
            redirecttoFreanchiseSelectionScreen(str);
        } else {
            reDirectBrandToMenuScreen(this.restBranchId);
        }
    }

    private final String screenType() {
        if (this.fromRL) {
            return "shop_list";
        }
        if (!this.isFromBrandOrReorder) {
            return "home";
        }
        if (this.isFromReOrder) {
            return ScreenNames.SCREEN_TYPE_REORDER;
        }
        return "brand";
    }

    private final void selectAddress(Address address, boolean z11) {
        CameraPosition cameraPosition;
        com.google.android.gms.maps.model.LatLng latLng;
        CameraPosition cameraPosition2;
        Double d11;
        Double d12;
        Intrinsics.checkNotNull(address);
        GlobalDataModel.SelectedAreaId = address.areaId;
        GlobalDataModel.SelectedAreaName = address.areaName;
        int i11 = address.cityId;
        GlobalDataModel.SelectedCityId = i11;
        GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, getMutableConfigurationLocalRepository(), getMutableLocationConfigurationRepository());
        FrameworkMap frameworkMap = this.mMap;
        CameraPosition cameraPosition3 = null;
        if (frameworkMap != null) {
            cameraPosition = frameworkMap.getCameraPosition();
        } else {
            cameraPosition = null;
        }
        Intrinsics.checkNotNull(cameraPosition);
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = cameraPosition.getZoom();
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        LatLng latLng2 = this.mMainLatLng;
        if (latLng2 != null) {
            latLng = HomeScreenMapKt.toGoogle(latLng2);
        } else {
            latLng = null;
        }
        homeMapTemp.setHomeMapLatLng(latLng, this);
        FrameworkMap frameworkMap2 = this.mMap;
        if (frameworkMap2 != null) {
            cameraPosition2 = frameworkMap2.getCameraPosition();
        } else {
            cameraPosition2 = null;
        }
        Intrinsics.checkNotNull(cameraPosition2);
        homeMapTemp.setHomeMapZoomeLevel(Float.valueOf(cameraPosition2.getZoom()));
        homeMapTemp.setTempAreaId(address.areaId);
        String str = address.street;
        Intrinsics.checkNotNull(str);
        homeMapTemp.setStreetName(str);
        homeMapTemp.settempAddress(address);
        SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        if (z11) {
            Customer.getInstance().EditCustomerAddress(this, address);
            getCustomerRepository().setSelectedCustomerAddress(address.f58343id, address.areaId);
            Customer.getInstance().setBrandScreenLocalAddress();
            return;
        }
        resetCustomerBrandAddress();
        LatLng latLng3 = this.mMainLatLng;
        if (latLng3 != null) {
            d11 = Double.valueOf(latLng3.getLatitude());
        } else {
            d11 = null;
        }
        LatLng latLng4 = this.mMainLatLng;
        if (latLng4 != null) {
            d12 = Double.valueOf(latLng4.getLongitude());
        } else {
            d12 = null;
        }
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_LOCATION, d11 + "," + d12);
        FrameworkMap frameworkMap3 = this.mMap;
        if (frameworkMap3 != null) {
            cameraPosition3 = frameworkMap3.getCameraPosition();
        }
        Intrinsics.checkNotNull(cameraPosition3);
        edit.putFloat(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ZOOM, cameraPosition3.getZoom());
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, address.areaId);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_STREET_NAME, address.street);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ADDRESS, storeTempAddress(address));
        edit.apply();
        getCustomerRepository().deselectCustomerAddress();
    }

    private final void selectArea(Area area, Address address, LatLng latLng, Float f11, String str) {
        boolean z11;
        int i11;
        String str2;
        int i12;
        int i13;
        com.google.android.gms.maps.model.LatLng latLng2;
        CameraPosition cameraPosition;
        com.google.android.gms.maps.model.LatLng latLng3;
        int i14;
        String str3;
        Double d11;
        Double d12;
        String str4;
        int i15 = 0;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            updateAddressPopup(str, address);
            return;
        }
        if (area != null) {
            i11 = area.f13835id;
        } else {
            i11 = 0;
        }
        GlobalDataModel.SelectedAreaId = i11;
        Integer num = null;
        if (area != null) {
            str2 = area.areaName;
        } else {
            str2 = null;
        }
        String str5 = "";
        if (str2 == null) {
            str2 = str5;
        }
        GlobalDataModel.SelectedAreaName = str2;
        if (area != null) {
            i12 = area.cityId;
        } else {
            i12 = 0;
        }
        GlobalDataModel.SelectedCityId = i12;
        if (area != null) {
            i13 = area.cityId;
        } else {
            i13 = 0;
        }
        GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i13, getMutableConfigurationLocalRepository(), getMutableLocationConfigurationRepository());
        if (area != null) {
            latLng2 = area.getAreCenterPoint();
        } else {
            latLng2 = null;
        }
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = latLng2;
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap != null) {
            cameraPosition = frameworkMap.getCameraPosition();
        } else {
            cameraPosition = null;
        }
        Intrinsics.checkNotNull(cameraPosition);
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = cameraPosition.getZoom();
        GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION = 0;
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        if (latLng != null) {
            latLng3 = HomeScreenMapKt.toGoogle(latLng);
        } else {
            latLng3 = null;
        }
        homeMapTemp.setHomeMapLatLng(latLng3, this);
        homeMapTemp.setHomeMapZoomeLevel(f11);
        if (area != null) {
            i14 = area.f13835id;
        } else {
            i14 = 0;
        }
        homeMapTemp.setTempAreaId(i14);
        if (address != null) {
            str3 = address.street;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = str5;
        }
        homeMapTemp.setStreetName(str3);
        homeMapTemp.settempAddress(address);
        SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        if (latLng != null) {
            d11 = Double.valueOf(latLng.getLatitude());
        } else {
            d11 = null;
        }
        if (latLng != null) {
            d12 = Double.valueOf(latLng.getLongitude());
        } else {
            d12 = null;
        }
        String str6 = d11 + "," + d12;
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_LOCATION, str6);
        Intrinsics.checkNotNull(f11);
        edit.putFloat(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ZOOM, f11.floatValue());
        if (area != null) {
            i15 = area.f13835id;
        }
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, i15);
        if (address != null) {
            str4 = address.street;
        } else {
            str4 = null;
        }
        if (str4 != null) {
            str5 = str4;
        }
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_STREET_NAME, str5);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ADDRESS, storeTempAddress(address));
        edit.apply();
        if (this.isFromBrandOrReorder && !this.isFromReOrder) {
            resetCustomerBrandAddress();
        }
        if (area instanceof AddressArea) {
            CustomerRepository customerRepository2 = getCustomerRepository();
            AddressArea addressArea = (AddressArea) area;
            String str7 = addressArea.profileId;
            Intrinsics.checkNotNullExpressionValue(str7, "area.profileId");
            customerRepository2.setSelectedCustomerAddress(str7, addressArea.f13835id);
        } else {
            Customer.getInstance().deselectCustomerAddress(this);
        }
        homeMapTemp.setHomeMapRedirect(true, this);
        if (!this.isFromBrandOrReorder) {
            redirectToResListScreen();
        } else if (this.isFromReOrder) {
            reDirectReOrdertCartScreen(this.restBranchId);
        } else if (this.isFranchiseRes) {
            redirecttoFreanchiseSelectionScreen(str6);
        } else {
            reDirectBrandToMenuScreen(this.restBranchId);
        }
        onTrackAddressSubmitted(address);
        String str8 = AppTracker.NotAvail;
        Intrinsics.checkNotNullExpressionValue(str8, "NotAvail");
        onTrackGeoLocationRequested("True", address, str8);
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        FWFAttributes fWFAttributes = FWFAttributes.LOCATION_COUNTRY;
        String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
        Intrinsics.checkNotNullExpressionValue(selectedCountryIso, "getSelectedCountryIso()");
        talabatExperiment.setAttribute(fWFAttributes, selectedCountryIso, TalabatExperimentDataSourceStrategy.APPTIMIZE);
        FWFAttributes fWFAttributes2 = FWFAttributes.AREA_ID;
        if (area != null) {
            num = Integer.valueOf(area.f13835id);
        }
        talabatExperiment.setAttribute(fWFAttributes2, String.valueOf(num));
    }

    private final void setPaddingForGoogleLogo(FrameworkMap frameworkMap, boolean z11) {
        int i11;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (z11) {
            if (!this.isShowingLocAwareness) {
                i11 = Opcodes.IF_ICMPNE;
            } else if (TalabatUtils.isArabic()) {
                i11 = 230;
            } else {
                i11 = 190;
            }
        } else if (!this.isShowingLocAwareness) {
            i11 = 75;
        } else if (TalabatUtils.isArabic()) {
            i11 = 135;
        } else {
            i11 = 95;
        }
        if (z11) {
            objectRef.element = ValueAnimator.ofInt(new int[]{getPixelFromDp(80), getPixelFromDp(i11)});
        } else if (!this.ignoreBottomAnim) {
            objectRef.element = ValueAnimator.ofInt(new int[]{getPixelFromDp(0), getPixelFromDp(i11)});
        }
        ValueAnimator valueAnimator = (ValueAnimator) objectRef.element;
        if (valueAnimator != null) {
            valueAnimator.setDuration(200);
        }
        ValueAnimator valueAnimator2 = (ValueAnimator) objectRef.element;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new e9(frameworkMap, this, objectRef));
        }
        ValueAnimator valueAnimator3 = (ValueAnimator) objectRef.element;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setPaddingForGoogleLogo$lambda-22  reason: not valid java name */
    public static final void m9480setPaddingForGoogleLogo$lambda22(FrameworkMap frameworkMap, HomeScreenMap homeScreenMap, Ref.ObjectRef objectRef, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$valueAnimator");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        if (frameworkMap != null) {
            frameworkMap.setPadding(homeScreenMap.getPixelFromDp(2), Integer.parseInt(((ValueAnimator) objectRef.element).getAnimatedValue().toString()), homeScreenMap.getPixelFromDp(2), Integer.parseInt(((ValueAnimator) objectRef.element).getAnimatedValue().toString()));
        }
    }

    private final void showMapDragTutorial(boolean z11) {
        if (!z11 || this.isHideDragTutFromSearch) {
            ((LinearLayout) _$_findCachedViewById(R.id.drag_tut_container)).setVisibility(8);
            this.isHideDragTutFromSearch = false;
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_on);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        int i11 = R.id.drag_tut_container;
        if (((LinearLayout) _$_findCachedViewById(i11)).getVisibility() != 0) {
            ((LinearLayout) _$_findCachedViewById(i11)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(i11);
            if (linearLayout != null) {
                linearLayout.startAnimation(loadAnimation);
            }
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(i11);
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new x8(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showMapDragTutorial$lambda-21  reason: not valid java name */
    public static final void m9481showMapDragTutorial$lambda21(HomeScreenMap homeScreenMap, View view) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        homeScreenMap.hideMapDragMapTutorial();
    }

    private final String storeTempAddress(Address address) {
        String str;
        if (address == null) {
            return "";
        }
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address);
        }
        Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(address)");
        return str;
    }

    private final void updateAddressPopup(String str, Address address) {
        Object obj;
        Gson gson = UniversalGson.INSTANCE.gson;
        Class cls = Address.class;
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(str, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson, str, cls);
        }
        Address address2 = (Address) obj;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String string = getString(R.string.update_address_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…tring.update_address_msg)");
        String str2 = address2.profileName;
        String str3 = address2.areaName;
        String replace$default = StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, str2 + "(" + str3 + ")", false, 4, (Object) null);
        builder.setTitle((int) R.string.update_address_title);
        builder.setMessage((CharSequence) replace$default);
        builder.setNegativeButton((int) R.string.update_save_for_later_btn, (DialogInterface.OnClickListener) new z8(this, address2, address));
        builder.setPositiveButton((int) R.string.update_address_btn, (DialogInterface.OnClickListener) new a9(this, address2, address));
        AppTracker.onUpdateAddressShown(this);
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAddressPopup$lambda-25  reason: not valid java name */
    public static final void m9482updateAddressPopup$lambda25(HomeScreenMap homeScreenMap, Address address, Address address2, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        Intrinsics.checkNotNullExpressionValue(address, "userSelectedAddressObj");
        homeScreenMap.saveForLaterAddress(address, address2);
        AppTracker.onUpdateAddressSelected(homeScreenMap, "save for later");
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAddressPopup$lambda-26  reason: not valid java name */
    public static final void m9483updateAddressPopup$lambda26(HomeScreenMap homeScreenMap, Address address, Address address2, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(homeScreenMap, "this$0");
        Intrinsics.checkNotNullExpressionValue(address, "userSelectedAddressObj");
        homeScreenMap.updateSelectedAddress(address, address2);
        AppTracker.onUpdateAddressSelected(homeScreenMap, Constant.METHOD_UPDATE);
    }

    private final void updateSelectedAddress(Address address, Address address2) {
        if (address2 != null) {
            address = AddressesKt.merge(address, address2);
        }
        IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
        if (iHomeMapPresenter != null) {
            iHomeMapPresenter.updateAddress(address);
        }
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        homeMapTemp.mapFirstUpdateOption(GlobalDataModel.HOME_SCREEN_MAP.UPDATE_NOW);
        selectAddress(address, true);
        homeMapTemp.setHomeMapRedirect(true, this);
        homeMapTemp.updateAddressNotSaved(true);
        String str = address.latitude + "," + address.longitude;
        if (this.isFromBrandOrReorder) {
            this.isAddressUpdateSelected = true;
            if (this.isFromReOrder) {
                reDirectReOrdertCartScreen(this.restBranchId);
            } else if (this.isFranchiseRes) {
                redirecttoFreanchiseSelectionScreen(str);
            } else {
                reDirectBrandToMenuScreen(this.restBranchId);
            }
        } else {
            this.isAddressUpdateSelected = false;
            redirectToResListScreen();
        }
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
        String str;
        Intrinsics.checkNotNullParameter(permissionDeniedResponse, "response");
        if (permissionDeniedResponse.isPermanentlyDenied()) {
            str = TrackingUtils.INSTANCE.getDeviceGpsDisabled();
        } else {
            str = TrackingUtils.INSTANCE.getAppGpsDisabled();
        }
        this.gpsStatus = str;
        IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
        if (iHomeMapPresenter != null) {
            iHomeMapPresenter.resetGpsStatusTracker(true);
        }
        locationButton(false);
        if (permissionDeniedResponse.isPermanentlyDenied()) {
            gpsLocationSettingsAlert();
        }
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

    public void animateMapCammera(@Nullable com.google.android.gms.maps.model.LatLng latLng, @Nullable Float f11) {
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap != null) {
            CameraUpdateFactory cameraUpdateFactory2 = getCameraUpdateFactory();
            CameraPosition.Builder newCameraPositionBuilder = getModelsRepository().newCameraPositionBuilder();
            Intrinsics.checkNotNull(latLng);
            CameraPosition.Builder target = newCameraPositionBuilder.target(HomeScreenMapKt.toOur(latLng, getLatLngFactory()));
            Intrinsics.checkNotNull(f11);
            frameworkMap.animateCamera(cameraUpdateFactory2.newCameraPosition(target.zoom(f11.floatValue()).bearing(5.0f).tilt(3.0f).build()), 1000, new HomeScreenMap$animateMapCammera$1(this));
        }
    }

    public void changecountryPrompt(@Nullable com.google.android.gms.maps.model.LatLng latLng, @NotNull String str, int i11) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "selectedCountryName");
        this.changedCountryId = i11;
        this.changeCountryName = str2;
        this.changeCountryPrompt = true;
        AppTracker.onChangeCountryShown(this);
        animtLocationBtn(true);
        ((TalabatTextView) _$_findCachedViewById(R.id.deliver_btn_here_txt)).setText(getResources().getString(R.string.change_country_btn_txt));
        int i12 = R.id.deliver_here;
        ((RelativeLayout) _$_findCachedViewById(i12)).setVisibility(0);
        ((RelativeLayout) _$_findCachedViewById(i12)).setTag(2);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(i12);
        if (relativeLayout != null) {
            relativeLayout.setEnabled(true);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(i12);
        if (relativeLayout2 != null) {
            relativeLayout2.setClickable(true);
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(i12);
        if (relativeLayout3 != null) {
            relativeLayout3.setAlpha(1.0f);
        }
        ((RelativeLayout) _$_findCachedViewById(i12)).setBackgroundResource(R.drawable.rounded_button_fill);
        int i13 = R.id.pre_geo_location_txt;
        ((TalabatTextView) _$_findCachedViewById(i13)).setLines(2);
        CardView cardView = (CardView) _$_findCachedViewById(R.id.deliver_here_card_view);
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(R.id.detail_card_container);
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(0);
        }
        int i14 = R.id.pre_geo_address_container;
        RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(i14);
        if (relativeLayout5 != null) {
            relativeLayout5.setVisibility(0);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.pre_geo_location_container);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(i13);
        if (talabatTextView != null) {
            talabatTextView.setVisibility(0);
        }
        TalabatTextView talabatTextView2 = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_hint);
        if (talabatTextView2 != null) {
            talabatTextView2.setVisibility(0);
        }
        TalabatTextView talabatTextView3 = (TalabatTextView) _$_findCachedViewById(R.id.current_location_aware_txt);
        if (talabatTextView3 != null) {
            talabatTextView3.setVisibility(8);
        }
        ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.pre_geo_pin)).setVisibility(0);
        setPaddingForGoogleLogo(this.mMap, true);
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.loading_progress);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(R.id.linear_progressBar);
        if (progressBar2 != null) {
            progressBar2.setVisibility(4);
        }
        String string = getResources().getString(R.string.outside_selected_country_msg);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ide_selected_country_msg)");
        String replace$default = StringsKt__StringsJVMKt.replace$default(string, "###", str, false, 4, (Object) null);
        String str3 = GlobalDataModel.SelectedCountryName;
        Intrinsics.checkNotNullExpressionValue(str3, "SelectedCountryName");
        String replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, RichContentLoadTimeRecorder.DELIMETER, str3, false, 4, (Object) null);
        adjustBottonContainer();
        RelativeLayout relativeLayout6 = (RelativeLayout) _$_findCachedViewById(i14);
        Intrinsics.checkNotNullExpressionValue(relativeLayout6, "pre_geo_address_container");
        slideUp(relativeLayout6);
        ((RelativeLayout) _$_findCachedViewById(i14)).setBackgroundResource(R.drawable.ic_m_bg_white_top_radius);
        if (TalabatUtils.isArabic()) {
            ((TalabatTextView) _$_findCachedViewById(i13)).setGravity(5);
        } else {
            ((TalabatTextView) _$_findCachedViewById(i13)).setGravity(3);
        }
        TalabatTextView talabatTextView4 = (TalabatTextView) _$_findCachedViewById(i13);
        if (talabatTextView4 != null) {
            talabatTextView4.setText(replace$default2);
        }
    }

    public void clearCartchangeLocation(@Nullable Address address, @Nullable Area area, @NotNull String str) {
        Float f11;
        CameraPosition cameraPosition;
        Intrinsics.checkNotNullParameter(str, "userSelectedAddress");
        Cart instance = Cart.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "cart");
        Intrinsics.checkNotNull(area);
        LatLng latLng = this.mMainLatLng;
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap == null || (cameraPosition = frameworkMap.getCameraPosition()) == null) {
            f11 = null;
        } else {
            f11 = Float.valueOf(cameraPosition.getZoom());
        }
        clearCart(instance, area, address, latLng, f11, str);
    }

    public void countryPolygonLoaded() {
        if (this.mMap != null) {
            drawCountryPolygon();
        }
    }

    public void deliverToCLRecived(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public void destroyPresenter() {
        this.mHomeMapPresenter = null;
    }

    public void detectingLocationProgress() {
        this.ignoreBottomAnim = false;
        animtLocationBtn(false);
        int i11 = R.id.deliver_here;
        ((RelativeLayout) _$_findCachedViewById(i11)).setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(i11);
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(i11);
        if (relativeLayout2 != null) {
            relativeLayout2.setClickable(false);
        }
        ((RelativeLayout) _$_findCachedViewById(i11)).setBackgroundResource(R.drawable.ic_map_bg_disabled);
        ((TalabatTextView) _$_findCachedViewById(R.id.deliver_btn_here_txt)).setText(getString(R.string.Detecting_location_txt));
        int i12 = R.id.deliver_here_card_view;
        ((CardView) _$_findCachedViewById(i12)).setVisibility(0);
        int i13 = R.id.detail_card_container;
        ((RelativeLayout) _$_findCachedViewById(i13)).setVisibility(0);
        ((CardView) _$_findCachedViewById(i12)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        ((RelativeLayout) _$_findCachedViewById(R.id.pre_geo_address_container)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        int i14 = R.id.current_location_aware_txt;
        ((TalabatTextView) _$_findCachedViewById(i14)).setVisibility(8);
        ((RelativeLayout) _$_findCachedViewById(i13)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        setPaddingForGoogleLogo(this.mMap, false);
        ((ProgressBar) _$_findCachedViewById(R.id.loading_progress)).setVisibility(0);
        int i15 = R.id.pre_geo_location_hint;
        ((TalabatTextView) _$_findCachedViewById(i15)).setVisibility(8);
        ((TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_txt)).setVisibility(8);
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(i14);
        if (talabatTextView != null) {
            talabatTextView.setVisibility(8);
        }
        ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.pre_geo_pin)).setVisibility(8);
        ((TalabatTextView) _$_findCachedViewById(i15)).setVisibility(8);
        this.ignoreBottomAnim = true;
    }

    public boolean deviceGpsStatus() {
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        return currentLocationFetch2.isLocationServiceEnabled(getContext());
    }

    public void dragFinished(boolean z11) {
        this.interactedWithMap = true;
    }

    public void enableDeliverHereButton(boolean z11) {
        if (z11) {
            int i11 = R.id.deliver_here;
            ((RelativeLayout) _$_findCachedViewById(i11)).setVisibility(0);
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout != null) {
                relativeLayout.setEnabled(true);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout2 != null) {
                relativeLayout2.setClickable(true);
            }
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(i11);
            if (relativeLayout3 != null) {
                relativeLayout3.setAlpha(1.0f);
            }
            ((RelativeLayout) _$_findCachedViewById(i11)).setBackgroundResource(R.drawable.rounded_button_fill);
            showMapDragTutorial(false);
            ((ImageView) _$_findCachedViewById(R.id.map_pin)).setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.icon_pin));
            return;
        }
        int i12 = R.id.deliver_here;
        ((RelativeLayout) _$_findCachedViewById(i12)).setVisibility(0);
        RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(i12);
        if (relativeLayout4 != null) {
            relativeLayout4.setEnabled(false);
        }
        RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(i12);
        if (relativeLayout5 != null) {
            relativeLayout5.setClickable(false);
        }
        ((RelativeLayout) _$_findCachedViewById(i12)).setBackgroundResource(R.drawable.ic_map_bg_disabled);
        if (this.isCameraSettled && this.isMapCameraFinished) {
            showMapDragTutorial(true);
        }
    }

    public void geocodingReceived(boolean z11, boolean z12, @Nullable Address address) {
        String str;
        boolean z13;
        String str2;
        String str3;
        boolean z14;
        String str4;
        boolean z15;
        String str5;
        boolean z16;
        String str6;
        String str7;
        boolean z17;
        String str8;
        boolean z18;
        String str9;
        boolean z19;
        String str10;
        this.changeCountryPrompt = false;
        String str11 = null;
        if (address != null) {
            str = address.extraDirections;
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        String str12 = "";
        if (z13) {
            str2 = str12;
        } else if (address != null) {
            str2 = address.extraDirections;
        } else {
            str2 = null;
        }
        if (address != null) {
            str3 = address.street;
        } else {
            str3 = null;
        }
        if (str3 == null || str3.length() == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (!z14) {
            if (str2 == null || str2.length() == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19) {
                if (address != null) {
                    str10 = address.street;
                } else {
                    str10 = null;
                }
                str2 = str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str10;
            } else if (address != null) {
                str2 = address.street;
            } else {
                str2 = null;
            }
        }
        if (address != null) {
            str4 = address.block;
        } else {
            str4 = null;
        }
        if (str4 == null || str4.length() == 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (!z15) {
            if (str2 == null || str2.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (address != null) {
                    str9 = address.block;
                } else {
                    str9 = null;
                }
                str2 = str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str9;
            } else if (address != null) {
                str2 = address.block;
            } else {
                str2 = null;
            }
        }
        if (address != null) {
            str5 = address.areaName;
        } else {
            str5 = null;
        }
        if (str5 == null || str5.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (str2 == null || str2.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (address != null) {
                    str8 = address.areaName;
                } else {
                    str8 = null;
                }
                str2 = str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str8;
            } else if (address != null) {
                str2 = address.areaName;
            } else {
                str2 = null;
            }
        }
        if (this.isCameraSettled) {
            if (address != null) {
                str6 = address.geoAddressTitle;
            } else {
                str6 = null;
            }
            if (!TalabatUtils.isNullOrEmpty(str6)) {
                int i11 = R.id.pre_geo_address_container;
                RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(i11);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.loading_progress);
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.pre_geo_location_container);
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_txt);
                if (talabatTextView != null) {
                    talabatTextView.setVisibility(4);
                }
                TalabatTextView talabatTextView2 = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_hint);
                if (talabatTextView2 != null) {
                    talabatTextView2.setVisibility(4);
                }
                TalabatTextView talabatTextView3 = (TalabatTextView) _$_findCachedViewById(R.id.current_location_aware_txt);
                if (talabatTextView3 != null) {
                    talabatTextView3.setVisibility(8);
                }
                ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
                ((RelativeLayout) _$_findCachedViewById(i11)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
                setPaddingForGoogleLogo(this.mMap, false);
                animtLocationBtn(false);
                ((ProgressBar) _$_findCachedViewById(R.id.linear_progressBar)).setVisibility(4);
                ((ImageView) _$_findCachedViewById(R.id.pre_geo_pin)).setVisibility(4);
                TalabatTextView talabatTextView4 = (TalabatTextView) _$_findCachedViewById(R.id.deliver_btn_here_txt);
                if (address != null) {
                    str7 = address.geoAddressTitle;
                } else {
                    str7 = null;
                }
                talabatTextView4.setText(str7);
                int i12 = R.id.deliver_here;
                ((RelativeLayout) _$_findCachedViewById(i12)).setVisibility(0);
                ((RelativeLayout) _$_findCachedViewById(i12)).setBackgroundResource(R.drawable.ic_map_bg_disabled);
                ((RelativeLayout) _$_findCachedViewById(i12)).setEnabled(false);
                ((RelativeLayout) _$_findCachedViewById(i12)).setClickable(false);
                if (address != null) {
                    str11 = address.geoAddressTitle;
                }
                Intrinsics.checkNotNull(str11);
                onTrackAddressErrorShown(str11);
                String str13 = address.geoAddressTitle;
                if (str13 != null) {
                    str12 = str13;
                }
                onTrackGeoLocationRequested("False", address, str12);
            } else {
                CardView cardView = (CardView) _$_findCachedViewById(R.id.deliver_here_card_view);
                if (cardView != null) {
                    cardView.setVisibility(0);
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(R.id.detail_card_container);
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                }
                int i13 = R.id.pre_geo_address_container;
                RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(i13);
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(0);
                }
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.pre_geo_location_container);
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TalabatTextView talabatTextView5 = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_txt);
                if (talabatTextView5 != null) {
                    talabatTextView5.setVisibility(0);
                }
                TalabatTextView talabatTextView6 = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_hint);
                if (talabatTextView6 != null) {
                    talabatTextView6.setVisibility(0);
                }
                if (isShowCurrentLocationAwareness()) {
                    this.isShowingLocAwareness = true;
                    int i14 = R.id.location_aware_btn;
                    ((LinearLayout) _$_findCachedViewById(i14)).setVisibility(0);
                    ((RelativeLayout) _$_findCachedViewById(R.id.deliver_here)).setVisibility(4);
                    TalabatTextView talabatTextView7 = (TalabatTextView) _$_findCachedViewById(R.id.current_location_aware_txt);
                    if (talabatTextView7 != null) {
                        talabatTextView7.setVisibility(0);
                    }
                    ((LinearLayout) _$_findCachedViewById(i14)).setVisibility(0);
                } else {
                    this.isShowingLocAwareness = false;
                    TalabatTextView talabatTextView8 = (TalabatTextView) _$_findCachedViewById(R.id.current_location_aware_txt);
                    if (talabatTextView8 != null) {
                        talabatTextView8.setVisibility(8);
                    }
                    ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
                    int i15 = R.id.deliver_here;
                    ((RelativeLayout) _$_findCachedViewById(i15)).setVisibility(0);
                    RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(i15);
                    if (relativeLayout4 != null) {
                        relativeLayout4.setEnabled(true);
                    }
                    RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(i15);
                    if (relativeLayout5 != null) {
                        relativeLayout5.setClickable(true);
                    }
                    RelativeLayout relativeLayout6 = (RelativeLayout) _$_findCachedViewById(i15);
                    if (relativeLayout6 != null) {
                        relativeLayout6.setAlpha(1.0f);
                    }
                    ((RelativeLayout) _$_findCachedViewById(i15)).setBackgroundResource(R.drawable.rounded_button_fill);
                    ((TalabatTextView) _$_findCachedViewById(R.id.deliver_btn_here_txt)).setText(R.string.deliver_here);
                }
                if (this.isFromBrandOrReorder) {
                    ((RelativeLayout) _$_findCachedViewById(R.id.deliver_here)).setTag(3);
                } else {
                    ((RelativeLayout) _$_findCachedViewById(R.id.deliver_here)).setTag(1);
                }
                adjustBottonContainer();
                RelativeLayout relativeLayout7 = (RelativeLayout) _$_findCachedViewById(i13);
                Intrinsics.checkNotNullExpressionValue(relativeLayout7, "pre_geo_address_container");
                slideUp(relativeLayout7);
                ((RelativeLayout) _$_findCachedViewById(i13)).setBackgroundResource(R.drawable.ic_m_bg_white_top_radius);
                setPaddingForGoogleLogo(this.mMap, true);
                animtLocationBtn(true);
                ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(R.id.loading_progress);
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                }
                ProgressBar progressBar3 = (ProgressBar) _$_findCachedViewById(R.id.linear_progressBar);
                if (progressBar3 != null) {
                    progressBar3.setVisibility(4);
                }
                ((ImageView) _$_findCachedViewById(R.id.pre_geo_pin)).setVisibility(0);
            }
            int i16 = R.id.pre_geo_location_txt;
            ((TalabatTextView) _$_findCachedViewById(i16)).setLines(1);
            if (TalabatUtils.isArabic()) {
                ((TalabatTextView) _$_findCachedViewById(i16)).setGravity(5);
            } else {
                ((TalabatTextView) _$_findCachedViewById(i16)).setGravity(3);
            }
            TalabatTextView talabatTextView9 = (TalabatTextView) _$_findCachedViewById(i16);
            if (talabatTextView9 != null) {
                talabatTextView9.setText(str2);
                return;
            }
            return;
        }
        int i17 = R.id.pre_geo_address_container;
        RelativeLayout relativeLayout8 = (RelativeLayout) _$_findCachedViewById(i17);
        if (relativeLayout8 != null) {
            relativeLayout8.setVisibility(8);
        }
        ProgressBar progressBar4 = (ProgressBar) _$_findCachedViewById(R.id.loading_progress);
        if (progressBar4 != null) {
            progressBar4.setVisibility(8);
        }
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(R.id.pre_geo_location_container);
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        TalabatTextView talabatTextView10 = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_txt);
        if (talabatTextView10 != null) {
            talabatTextView10.setVisibility(4);
        }
        TalabatTextView talabatTextView11 = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_hint);
        if (talabatTextView11 != null) {
            talabatTextView11.setVisibility(4);
        }
        TalabatTextView talabatTextView12 = (TalabatTextView) _$_findCachedViewById(R.id.current_location_aware_txt);
        if (talabatTextView12 != null) {
            talabatTextView12.setVisibility(8);
        }
        ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
        ((RelativeLayout) _$_findCachedViewById(i17)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        int i18 = R.id.deliver_here;
        ((RelativeLayout) _$_findCachedViewById(i18)).setBackgroundResource(R.drawable.ic_map_bg_disabled);
        ((RelativeLayout) _$_findCachedViewById(i18)).setEnabled(false);
        ((RelativeLayout) _$_findCachedViewById(i18)).setClickable(false);
        setPaddingForGoogleLogo(this.mMap, false);
        animtLocationBtn(false);
        ((ProgressBar) _$_findCachedViewById(R.id.linear_progressBar)).setVisibility(4);
        ((ImageView) _$_findCachedViewById(R.id.pre_geo_pin)).setVisibility(4);
        TalabatTextView talabatTextView13 = (TalabatTextView) _$_findCachedViewById(R.id.deliver_btn_here_txt);
        if (address != null) {
            str11 = address.geoAddressTitle;
        }
        talabatTextView13.setText(str11);
        onTrackAddressErrorShown(TrackingUtils.INSTANCE.getOutOfDeliveryZone());
    }

    @Nullable
    public final ArrayList<Polygon> getAllCountryPolygon() {
        return this.allCountryPolygon;
    }

    @Nullable
    public final AnimationSet getAnimation() {
        return this.animation;
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

    @NotNull
    public final CameraUpdateFactory getCameraUpdateFactory() {
        CameraUpdateFactory cameraUpdateFactory2 = this.cameraUpdateFactory;
        if (cameraUpdateFactory2 != null) {
            return cameraUpdateFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraUpdateFactory");
        return null;
    }

    @NotNull
    public final String getChangeCountryName() {
        return this.changeCountryName;
    }

    public final int getChangedCountryId() {
        return this.changedCountryId;
    }

    @NotNull
    public final ConfigurationRemoteRepository getConfigurationRemoteRepository() {
        ConfigurationRemoteRepository configurationRemoteRepository2 = this.configurationRemoteRepository;
        if (configurationRemoteRepository2 != null) {
            return configurationRemoteRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationRemoteRepository");
        return null;
    }

    @NotNull
    public Context getContext() {
        return this;
    }

    @Nullable
    public final CustomAutoCompleteFragment getCustomAutoCompleteFragment() {
        return this.customAutoCompleteFragment;
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
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final GetProCentralizationStatusUseCase getGetProCentralizationStatusUseCase() {
        GetProCentralizationStatusUseCase getProCentralizationStatusUseCase2 = this.getProCentralizationStatusUseCase;
        if (getProCentralizationStatusUseCase2 != null) {
            return getProCentralizationStatusUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getProCentralizationStatusUseCase");
        return null;
    }

    @NotNull
    public final String getGpsStatus() {
        return this.gpsStatus;
    }

    public final boolean getIgnoreBottomAnim() {
        return this.ignoreBottomAnim;
    }

    @NotNull
    public final LatLngFactory getLatLngFactory() {
        LatLngFactory latLngFactory2 = this.latLngFactory;
        if (latLngFactory2 != null) {
            return latLngFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("latLngFactory");
        return null;
    }

    @Nullable
    public final String getLocationMethod() {
        return this.locationMethod;
    }

    @Nullable
    public com.google.android.gms.maps.model.LatLng getMainLatLng() {
        CameraPosition cameraPosition;
        LatLng target;
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap == null || (cameraPosition = frameworkMap.getCameraPosition()) == null || (target = cameraPosition.getTarget()) == null) {
            return null;
        }
        return HomeScreenMapKt.toGoogle(target);
    }

    @Nullable
    public final MapContainerFragment getMapFragment() {
        return this.mapFragment;
    }

    @NotNull
    public final String getMapViewType() {
        return this.mapViewType;
    }

    @NotNull
    public final MapsInitializer getMapsInitializer() {
        MapsInitializer mapsInitializer2 = this.mapsInitializer;
        if (mapsInitializer2 != null) {
            return mapsInitializer2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mapsInitializer");
        return null;
    }

    @NotNull
    public final ModelsRepository getModelsRepository() {
        ModelsRepository modelsRepository2 = this.modelsRepository;
        if (modelsRepository2 != null) {
            return modelsRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("modelsRepository");
        return null;
    }

    @NotNull
    public final Moshi getMoshi() {
        Moshi moshi2 = this.moshi;
        if (moshi2 != null) {
            return moshi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("moshi");
        return null;
    }

    @NotNull
    public final MutableConfigurationLocalRepository getMutableConfigurationLocalRepository() {
        MutableConfigurationLocalRepository mutableConfigurationLocalRepository2 = this.mutableConfigurationLocalRepository;
        if (mutableConfigurationLocalRepository2 != null) {
            return mutableConfigurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mutableConfigurationLocalRepository");
        return null;
    }

    @NotNull
    public final MutableConfigurationRemoteRepository getMutableConfigurationRemoteRepository() {
        MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository2 = this.mutableConfigurationRemoteRepository;
        if (mutableConfigurationRemoteRepository2 != null) {
            return mutableConfigurationRemoteRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mutableConfigurationRemoteRepository");
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
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    public final boolean getOutOfService() {
        return this.outOfService;
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

    @Nullable
    public final Dialog getPopupWindow() {
        return this.popupWindow;
    }

    public final boolean getReachedLoc() {
        return this.reachedLoc;
    }

    @NotNull
    public String getScreenName() {
        return ScreenNames.SCREEN_HOME_MAP;
    }

    @NotNull
    public final SecretProvider getSecretProvider() {
        SecretProvider secretProvider2 = this.secretProvider;
        if (secretProvider2 != null) {
            return secretProvider2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("secretProvider");
        return null;
    }

    @NotNull
    public final SetHasUserPinnedLocationInOnboardingMapUseCase getSetHasUserPinnedLocationInOnboardingMapUseCase() {
        SetHasUserPinnedLocationInOnboardingMapUseCase setHasUserPinnedLocationInOnboardingMapUseCase2 = this.setHasUserPinnedLocationInOnboardingMapUseCase;
        if (setHasUserPinnedLocationInOnboardingMapUseCase2 != null) {
            return setHasUserPinnedLocationInOnboardingMapUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("setHasUserPinnedLocationInOnboardingMapUseCase");
        return null;
    }

    @NotNull
    public final ISubscriptionsCustomerRepository getSubscriptionsCustomerRepository() {
        ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository = this.subscriptionsCustomerRepository;
        if (iSubscriptionsCustomerRepository != null) {
            return iSubscriptionsCustomerRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsCustomerRepository");
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

    public final double getTrackingDistance() {
        return this.trackingDistance;
    }

    @NotNull
    public final String getUserSelectedAddress() {
        return this.userSelectedAddress;
    }

    @NotNull
    public final String getUserSelectedLatLng() {
        return this.userSelectedLatLng;
    }

    public void hideMapTutorial() {
        this.isDragTutHided = false;
        hideMapDragMapTutorial();
    }

    public final boolean isDelAreaFromSerach() {
        return this.isDelAreaFromSerach;
    }

    public final boolean isForceRedirectSearch() {
        return this.isForceRedirectSearch;
    }

    public final boolean isFromPlaceSearch() {
        return this.isFromPlaceSearch;
    }

    public final boolean isHideDragTutFromSearch() {
        return this.isHideDragTutFromSearch;
    }

    public final boolean isOutOfCountry() {
        return this.isOutOfCountry;
    }

    public final boolean isRedirectBacktoHomeFromLocationWelcome() {
        return this.isRedirectBacktoHomeFromLocationWelcome;
    }

    public void isRefreshMap(boolean z11, @NotNull com.google.android.gms.maps.model.LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
        this.locationMethod = TrackingUtils.INSTANCE.getLocationMethodLocate();
        this.gpsStatus = "enabled";
        this.currentLoc = HomeScreenMapKt.toOur(latLng, getLatLngFactory());
        GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG = false;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.location_btn);
        Intrinsics.checkNotNullExpressionValue(imageView, "location_btn");
        stopFadeInFadeOutAnimation(imageView);
        if (!this.ignoreCurrentloctionRequest) {
            currentLocReceived(false);
        }
    }

    public void loadRestaurantListScreen(@Nullable String str, @Nullable Address address, @Nullable Area area, @NotNull String str2) {
        Float f11;
        CameraPosition cameraPosition;
        Float f12;
        CameraPosition cameraPosition2;
        Float f13;
        CameraPosition cameraPosition3;
        Float f14;
        CameraPosition cameraPosition4;
        Float f15;
        CameraPosition cameraPosition5;
        Intrinsics.checkNotNullParameter(str2, "userSelectedAddress");
        stopLodingPopup();
        Cart instance = Cart.getInstance();
        if (instance.hasItems()) {
            boolean z11 = false;
            if (area != null && instance.getCartAreaId() == area.f13835id) {
                z11 = true;
            }
            if (!z11) {
                Intrinsics.checkNotNullExpressionValue(instance, "cart");
                Intrinsics.checkNotNull(area);
                LatLng latLng = this.mMainLatLng;
                FrameworkMap frameworkMap = this.mMap;
                if (frameworkMap == null || (cameraPosition2 = frameworkMap.getCameraPosition()) == null) {
                    f12 = null;
                } else {
                    f12 = Float.valueOf(cameraPosition2.getZoom());
                }
                clearCart(instance, area, address, latLng, f12, str2);
            } else if (!instance.getRestaurant().isGlrEnabled) {
                LatLng latLng2 = this.mMainLatLng;
                FrameworkMap frameworkMap2 = this.mMap;
                if (frameworkMap2 == null || (cameraPosition3 = frameworkMap2.getCameraPosition()) == null) {
                    f13 = null;
                } else {
                    f13 = Float.valueOf(cameraPosition3.getZoom());
                }
                selectArea(area, address, latLng2, f13, str2);
            } else if (isNeedToClearCart(area)) {
                Intrinsics.checkNotNullExpressionValue(instance, "cart");
                LatLng latLng3 = this.mMainLatLng;
                FrameworkMap frameworkMap3 = this.mMap;
                if (frameworkMap3 == null || (cameraPosition5 = frameworkMap3.getCameraPosition()) == null) {
                    f15 = null;
                } else {
                    f15 = Float.valueOf(cameraPosition5.getZoom());
                }
                clearCart(instance, area, address, latLng3, f15, str2);
            } else {
                LatLng latLng4 = this.mMainLatLng;
                FrameworkMap frameworkMap4 = this.mMap;
                if (frameworkMap4 == null || (cameraPosition4 = frameworkMap4.getCameraPosition()) == null) {
                    f14 = null;
                } else {
                    f14 = Float.valueOf(cameraPosition4.getZoom());
                }
                selectArea(area, address, latLng4, f14, str2);
            }
        } else {
            Intrinsics.checkNotNull(area);
            LatLng latLng5 = this.mMainLatLng;
            FrameworkMap frameworkMap5 = this.mMap;
            if (frameworkMap5 == null || (cameraPosition = frameworkMap5.getCameraPosition()) == null) {
                f11 = null;
            } else {
                f11 = Float.valueOf(cameraPosition.getZoom());
            }
            selectArea(area, address, latLng5, f11, str2);
        }
    }

    public void loadRestaurantMenuScreen(int i11, @Nullable Address address, @NotNull String str, boolean z11) {
        Float f11;
        Object obj;
        Area area;
        CameraPosition cameraPosition;
        Float f12;
        CameraPosition cameraPosition2;
        CameraPosition cameraPosition3;
        CameraPosition cameraPosition4;
        Float f13;
        CameraPosition cameraPosition5;
        boolean z12;
        Intrinsics.checkNotNullParameter(str, "userSelectedAddress");
        Cart instance = Cart.getInstance();
        Intrinsics.checkNotNull(address);
        int i12 = address.areaId;
        AreaToOldAreaMapper areaToOldAreaMapper = new AreaToOldAreaMapper();
        Iterator it = getMutableLocationConfigurationRepository().areas().iterator();
        while (true) {
            f11 = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((com.talabat.configuration.location.Area) obj).getId() == i12) {
                z12 = true;
                continue;
            } else {
                z12 = false;
                continue;
            }
            if (z12) {
                break;
            }
        }
        com.talabat.configuration.location.Area area2 = (com.talabat.configuration.location.Area) obj;
        if (area2 != null) {
            area = areaToOldAreaMapper.apply(area2);
        } else {
            area = null;
        }
        if (!instance.hasItems()) {
            LatLng latLng = this.mMainLatLng;
            FrameworkMap frameworkMap = this.mMap;
            if (!(frameworkMap == null || (cameraPosition = frameworkMap.getCameraPosition()) == null)) {
                f11 = Float.valueOf(cameraPosition.getZoom());
            }
            selectArea(area, address, latLng, f11, str);
        } else if (instance.getCartAreaId() != address.areaId) {
            Intrinsics.checkNotNullExpressionValue(instance, "cart");
            LatLng latLng2 = this.mMainLatLng;
            FrameworkMap frameworkMap2 = this.mMap;
            if (frameworkMap2 == null || (cameraPosition2 = frameworkMap2.getCameraPosition()) == null) {
                f12 = null;
            } else {
                f12 = Float.valueOf(cameraPosition2.getZoom());
            }
            clearCart(instance, area, address, latLng2, f12, str);
        } else if (!instance.getRestaurant().isGlrEnabled) {
            LatLng latLng3 = this.mMainLatLng;
            FrameworkMap frameworkMap3 = this.mMap;
            if (!(frameworkMap3 == null || (cameraPosition3 = frameworkMap3.getCameraPosition()) == null)) {
                f11 = Float.valueOf(cameraPosition3.getZoom());
            }
            selectArea(area, address, latLng3, f11, str);
        } else if (isNeedToClearCart(area)) {
            Intrinsics.checkNotNullExpressionValue(instance, "cart");
            LatLng latLng4 = this.mMainLatLng;
            FrameworkMap frameworkMap4 = this.mMap;
            if (frameworkMap4 == null || (cameraPosition5 = frameworkMap4.getCameraPosition()) == null) {
                f13 = null;
            } else {
                f13 = Float.valueOf(cameraPosition5.getZoom());
            }
            clearCart(instance, area, address, latLng4, f13, str);
        } else {
            LatLng latLng5 = this.mMainLatLng;
            FrameworkMap frameworkMap5 = this.mMap;
            if (!(frameworkMap5 == null || (cameraPosition4 = frameworkMap5.getCameraPosition()) == null)) {
                f11 = Float.valueOf(cameraPosition4.getZoom());
            }
            selectArea(area, address, latLng5, f11, str);
        }
    }

    public void locationError(@Nullable String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getString(R.string.location_not_without_polygon_title));
        builder.setMessage((CharSequence) getString(R.string.location_not_without_polygon_message));
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new b9(this));
        builder.show();
    }

    public void mapAnimatedtoLocation(boolean z11) {
        this.reachedLoc = z11;
    }

    public void mapCurrentLocReceived(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
        GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG = false;
        this.currentLoc = HomeScreenMapKt.toOur(latLng, getLatLngFactory());
    }

    public void mapDraging(boolean z11) {
        if (z11) {
            this.ignoreBottomAnim = false;
            hideMapDragMapTutorial();
            this.isDelAreaFromSerach = false;
            this.interactedWithMap = true;
            IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
            if (iHomeMapPresenter != null) {
                iHomeMapPresenter.resetPreLocation(true);
            }
            this.locationMethod = TrackingUtils.INSTANCE.getLocationMethodMapCoordinates();
            if (GlobalDataModel.Apptimize.CAN_SHOW_CUSTOM_GOOGLE_AUTO_COMPLETE_WIDGET) {
                if (this.isFromPlaceSearch) {
                    CustomAutoCompleteFragment customAutoCompleteFragment2 = this.customAutoCompleteFragment;
                    if (customAutoCompleteFragment2 != null) {
                        customAutoCompleteFragment2.clearText();
                    }
                    this.isFromPlaceSearch = false;
                }
                CustomAutoCompleteFragment customAutoCompleteFragment3 = this.customAutoCompleteFragment;
                if (customAutoCompleteFragment3 != null) {
                    customAutoCompleteFragment3.hideKeyBoard();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r7, int r8, @org.jetbrains.annotations.Nullable android.content.Intent r9) {
        /*
            r6 = this;
            super.onActivityResult(r7, r8, r9)
            r0 = 36
            r1 = -1
            r2 = 0
            if (r7 == r0) goto L_0x0044
            r9 = 100
            java.lang.String r0 = "location_btn"
            if (r7 == r9) goto L_0x001f
            int r7 = com.talabat.R.id.location_btn
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r6.stopFadeInFadeOutAnimation(r7)
            goto L_0x0119
        L_0x001f:
            boolean r7 = r6.interactedWithMap
            r6.isIgnoreCurrentLocationMovement = r7
            r6.reachedLoc = r2
            if (r8 != r1) goto L_0x002b
            r6.reInitiateLocation()
            goto L_0x0032
        L_0x002b:
            boolean r7 = r6.redirectGPSSettings
            if (r7 == 0) goto L_0x0032
            r6.reInitiateLocation()
        L_0x0032:
            if (r8 != 0) goto L_0x0119
            int r7 = com.talabat.R.id.location_btn
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r6.stopFadeInFadeOutAnimation(r7)
            goto L_0x0119
        L_0x0044:
            if (r8 != r1) goto L_0x0119
            r7 = 0
            if (r9 == 0) goto L_0x0050
            java.lang.String r8 = "location"
            java.lang.String r8 = r9.getStringExtra(r8)
            goto L_0x0051
        L_0x0050:
            r8 = r7
        L_0x0051:
            if (r9 == 0) goto L_0x005a
            java.lang.String r0 = "DelAreaName"
            java.lang.String r0 = r9.getStringExtra(r0)
            goto L_0x005b
        L_0x005a:
            r0 = r7
        L_0x005b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            java.lang.String r1 = "currentLocEnabled"
            boolean r1 = r9.getBooleanExtra(r1, r2)
            r6.isDefaultLocationEnable = r1
            java.lang.String r1 = "isAreaCenterCor"
            boolean r1 = r9.getBooleanExtra(r1, r2)
            r6.isDelAreaFromSerach = r1
            boolean r1 = r6.isFromBrandOrReorder
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = "DeliveryAreaBranchId"
            int r9 = r9.getIntExtra(r1, r2)
            r6.restBranchId = r9
        L_0x007a:
            library.talabat.mvp.homemap.IHomeMapPresenter r9 = r6.mHomeMapPresenter
            r1 = 1
            if (r9 == 0) goto L_0x0082
            r9.resetPreLocation(r1)
        L_0x0082:
            boolean r9 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r8)
            if (r9 != 0) goto L_0x0119
            if (r8 == 0) goto L_0x00de
            kotlin.text.Regex r9 = new kotlin.text.Regex
            java.lang.String r3 = ","
            r9.<init>((java.lang.String) r3)
            java.util.List r8 = r9.split(r8, r2)
            if (r8 == 0) goto L_0x00de
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x00c8
            int r9 = r8.size()
            java.util.ListIterator r9 = r8.listIterator(r9)
        L_0x00a5:
            boolean r3 = r9.hasPrevious()
            if (r3 == 0) goto L_0x00c8
            java.lang.Object r3 = r9.previous()
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x00b9
            r3 = r1
            goto L_0x00ba
        L_0x00b9:
            r3 = r2
        L_0x00ba:
            if (r3 != 0) goto L_0x00a5
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            int r9 = r9.nextIndex()
            int r9 = r9 + r1
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.take(r8, r9)
            goto L_0x00cc
        L_0x00c8:
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x00cc:
            if (r8 == 0) goto L_0x00de
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.String[] r9 = new java.lang.String[r2]
            java.lang.Object[] r8 = r8.toArray(r9)
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r9)
            java.lang.String[] r8 = (java.lang.String[]) r8
            goto L_0x00df
        L_0x00de:
            r8 = r7
        L_0x00df:
            com.talabat.maps.domain.LatLngFactory r9 = r6.getLatLngFactory()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r2 = r8[r2]
            double r2 = java.lang.Double.parseDouble(r2)
            r8 = r8[r1]
            double r4 = java.lang.Double.parseDouble(r8)
            com.talabat.maps.domain.model.LatLng r8 = r9.createLatLng(r2, r4)
            r6.mMainLatLng = r8
            if (r8 == 0) goto L_0x00fe
            com.google.android.gms.maps.model.LatLng r7 = com.talabat.HomeScreenMapKt.toGoogle(r8)
        L_0x00fe:
            boolean r8 = r6.isDelAreaFromSerach
            if (r8 == 0) goto L_0x0105
            r8 = 1097859072(0x41700000, float:15.0)
            goto L_0x0107
        L_0x0105:
            r8 = 1099956224(0x41900000, float:18.0)
        L_0x0107:
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r6.animateMapCammera(r7, r8)
            int r7 = com.talabat.R.id.ed_search_location
            android.view.View r7 = r6._$_findCachedViewById(r7)
            com.materialedittext.MaterialEditText r7 = (com.materialedittext.MaterialEditText) r7
            r7.setText(r0)
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.HomeScreenMap.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onAuthError() {
    }

    public void onBackClickListener() {
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
        AppTracker.onMapClosed(this, this.mapJourneyType);
    }

    public void onCameraIdle() {
        cameraBecomeIdle();
    }

    public void onCameraMove() {
        if (this.interactedWithMap) {
            this.isCameraSettled = false;
            int i11 = R.id.deliver_here_card_view;
            if (((CardView) _$_findCachedViewById(i11)).getVisibility() == 0) {
                ((CardView) _$_findCachedViewById(i11)).setVisibility(8);
                int i12 = R.id.detail_card_container;
                ((RelativeLayout) _$_findCachedViewById(i12)).setVisibility(8);
                ((CardView) _$_findCachedViewById(i11)).setVisibility(8);
                ((RelativeLayout) _$_findCachedViewById(i12)).setVisibility(8);
            }
        }
    }

    public void onCameraMoveCanceled() {
    }

    public void onCameraMoveStarted(int i11) {
        IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
        if (iHomeMapPresenter != null) {
            iHomeMapPresenter.updateMapCameraMoved(true);
        }
        if (this.interactedWithMap) {
            int i12 = R.id.ed_search_location;
            if (!TalabatUtils.isNullOrEmpty(((MaterialEditText) _$_findCachedViewById(i12)).toString())) {
                ((MaterialEditText) _$_findCachedViewById(i12)).setText("");
            }
            resetPreLocationContainer();
            int i13 = R.id.deliver_here;
            ((RelativeLayout) _$_findCachedViewById(i13)).setVisibility(0);
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(i13);
            if (relativeLayout != null) {
                relativeLayout.setEnabled(false);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(i13);
            if (relativeLayout2 != null) {
                relativeLayout2.setClickable(false);
            }
            ((RelativeLayout) _$_findCachedViewById(i13)).setVisibility(0);
            ((RelativeLayout) _$_findCachedViewById(i13)).setBackgroundResource(R.drawable.ic_map_bg_disabled);
            ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
            ((CardView) _$_findCachedViewById(R.id.deliver_here_card_view)).setVisibility(8);
            ((RelativeLayout) _$_findCachedViewById(R.id.detail_card_container)).setVisibility(8);
            animtLocationBtnWhileDrag();
        }
    }

    public void onCountryDataLoaded(@Nullable Integer num) {
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        FWFAttributes fWFAttributes = FWFAttributes.LOCATION_COUNTRY;
        String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
        Intrinsics.checkNotNullExpressionValue(selectedCountryIso, "getSelectedCountryIso()");
        talabatExperiment.setAttribute(fWFAttributes, selectedCountryIso, TalabatExperimentDataSourceStrategy.APPTIMIZE);
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        String str = AppTracker.NotAvail;
        String selectedCountryIso2 = TalabatAdjust.getSelectedCountryIso();
        String str2 = AppTracker.NotAvail;
        String str3 = str2;
        String str4 = str2;
        String str5 = str2;
        String str6 = str2;
        String str7 = str2;
        AppTracker.onChangeCountrySelected(getContext(), trackingUtils.getTrackingAddressObject(this, true, (Address) null, (Integer) null, 0, str, str, str, str, selectedCountryIso2, str5, str7, str6, str2, str3, str4, str2, str2, true, str2));
        stopLodingPopup();
        GlobalDataModel.DASHBOARDDATA.orderListReceived = false;
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        homeMapTemp.resetPref(this);
        homeMapTemp.recentRecentLocation();
        if (!(Customer.getInstance() == null || !Customer.getInstance().isLoggedIn() || Customer.getInstance().getSelectedCustomerAddress() == null)) {
            Customer.getInstance().deselectCustomerAddress();
        }
        GlobalDataModel.AD.countryChanged();
        FunWithFlags.updateSelectedCountry(getMutableConfigurationLocalRepository().selectedCountry());
        Intent intent = new Intent(this, HomeScreenActivity.class);
        if (this.fromHome) {
            intent.putExtra("is_home_refresh_call_back", true);
        }
        intent.addFlags(335544320);
        startActivity(intent);
        AppTracker.onChangeCountryConfirmed(this);
        finish();
    }

    @ExperimentalStdlibApi
    public void onCreate(@Nullable Bundle bundle) {
        DaggerHomeScreenMapFragmentComponent.factory().create((CustomerCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(CustomerCoreLibApi.class), (LocationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(LocationCoreLibApi.class), (MapsCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(MapsCoreLibApi.class), (MutableConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(MutableConfigurationLocalCoreLibApi.class), (MutableConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(MutableConfigurationRemoteCoreLibApi.class), (ParserCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ParserCoreLibApi.class), (PinlessCheckoutCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(PinlessCheckoutCoreLibApi.class), (SecretCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(SecretCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(SubscriptionsFeatureApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class)).inject(this);
        getMapsInitializer().initialize();
        super.onCreate(bundle);
        setContentView((int) R.layout.home_screen_map_copy);
        try {
            setSupportActionBar((Toolbar) _$_findCachedViewById(R.id.toolbar_map));
            this.fromRL = getIntent().getBooleanExtra("fromRL", false);
            this.fromHome = getIntent().getBooleanExtra("fromHome", false);
            this.isRedirectBacktoHomeFromLocationWelcome = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_REDIRECT_BACK_HOME_IF_VERTICAL, false);
            if (getIntent() != null) {
                this.isFromBrandOrReorder = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, false);
                this.isFromFanchiseRes = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, false);
                this.isFromReOrder = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER, false);
                this.isFromReorderList = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER_LIST, false);
                this.isForceRedirectSearch = getIntent().getBooleanExtra("is_show_map_search", false);
                String str = "";
                if (getIntent() != null) {
                    if (getIntent().hasExtra("UserSelectedAddress")) {
                        String stringExtra = getIntent().getStringExtra("UserSelectedAddress");
                        if (stringExtra == null) {
                            stringExtra = str;
                        }
                        this.userSelectedAddress = stringExtra;
                    }
                }
                if (getIntent() != null && getIntent().hasExtra("areaLatLng")) {
                    String stringExtra2 = getIntent().getStringExtra("areaLatLng");
                    if (stringExtra2 == null) {
                        stringExtra2 = str;
                    }
                    this.userSelectedLatLng = stringExtra2;
                }
                if (this.isFromReOrder) {
                    if (getIntent() != null && getIntent().hasExtra(GlobalConstants.ExtraNames.RE_ORDER_ID)) {
                        String stringExtra3 = getIntent().getStringExtra(GlobalConstants.ExtraNames.RE_ORDER_ID);
                        if (stringExtra3 == null) {
                            stringExtra3 = str;
                        }
                        this.reorderId = stringExtra3;
                    }
                    this.reorderResId = getIntent().getIntExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_ID, 0);
                    if (getIntent() != null && getIntent().hasExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME)) {
                        String stringExtra4 = getIntent().getStringExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME);
                        if (stringExtra4 != null) {
                            str = stringExtra4;
                        }
                        this.reorderResName = str;
                    }
                }
            }
            mapJourneyType();
            if (GlobalDataModel.Apptimize.CAN_SHOW_GOOGLE_AUTO_COMPLETE_WIDGET && !Places.isInitialized()) {
                Places.initialize(getApplicationContext(), getSecretProvider().getGoogleApiKey());
            }
            AddressesDependencyProvider addressesDependencyProvider = AddressesDependencyProvider.INSTANCE;
            this.mHomeMapPresenter = new HomeMapPresenter(this, addressesDependencyProvider.provideCustomerAddressesRepository(getTalabatFeatureFlag()), new AppInfoRepositoryImpl((CoroutineDispatcher) null, (CoroutineDispatcher) null, new AppInfoRemoteDataSourceImpl((AppInfoApi) new TalabatAPIBuilder().createApi(AppInfoApi.class), getMutableConfigurationRemoteRepository(), getMoshi()), addressesDependencyProvider.provideCustomerAddressesRepository(getTalabatFeatureFlag()), addressesDependencyProvider.provideCustomerRepository(this), new CustomerInfoRepositoryImpl((CoroutineDispatcher) null, new CustomerInfoLocalDataSourceImpl((Context) null, (Gson) null, 3, (DefaultConstructorMarker) null), new CustomerInfoRemoteDataSourceImpl((CustomerInfoApi) new TalabatAPIBuilder().createApi(CustomerInfoApi.class)), new ProCentralizationStatusWrapper(getGetProCentralizationStatusUseCase(), getSubscriptionsCustomerRepository()), 1, (DefaultConstructorMarker) null), getMutableConfigurationLocalRepository(), getMutableLocationConfigurationRepository(), (AppInfoLocalDataSource) null, getPaymentConfigurationRepository(), getTalabatFeatureFlag(), 259, (DefaultConstructorMarker) null), getAppVersionProvider(), getMutableLocationConfigurationRepository(), getTalabatFeatureFlag(), TalabatExperiment.INSTANCE, getMutableConfigurationLocalRepository());
            initInitialView();
            CurrentLocationFetch currentLocationFetch2 = new CurrentLocationFetch(this, this);
            this.currentLocationFetch = currentLocationFetch2;
            Intrinsics.checkNotNull(currentLocationFetch2);
            currentLocationFetch2.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_MAP());
            if (!this.isForceRedirectSearch) {
                com.google.android.gms.maps.model.LatLng latLng = GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME;
                if (latLng == null) {
                    CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
                    Intrinsics.checkNotNull(currentLocationFetch3);
                    currentLocationFetch3.fetchCurrentLocation();
                } else {
                    Intrinsics.checkNotNullExpressionValue(latLng, "FUSED_LOCATION_FROM_HOME");
                    this.currentLoc = HomeScreenMapKt.toOur(latLng, getLatLngFactory());
                }
            }
            initMapView();
            loadForceSearchScreen();
            PerformanceTracker performanceTracker = PerformanceTracker.INSTANCE;
            performanceTracker.addAppFlowTraceAttribute("appStartToInteractive", "HomeScreenMap");
            performanceTracker.stopTrace("appStartToInteractive");
            AppLaunchTrackingManger appLaunchTrackingManger = AppLaunchTrackingManger.INSTANCE;
            appLaunchTrackingManger.trackEvent("home_screen_access_time", Calendar.getInstance().getTimeInMillis());
            appLaunchTrackingManger.sendAppLaunchEvent();
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void onCurrentLocationReceived(@Nullable com.google.android.gms.maps.model.LatLng latLng, boolean z11, float f11) {
        LatLng latLng2;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.location_btn);
        Intrinsics.checkNotNullExpressionValue(imageView, "location_btn");
        stopFadeInFadeOutAnimation(imageView);
        LatLng latLng3 = null;
        if (latLng != null) {
            latLng2 = HomeScreenMapKt.toOur(latLng, getLatLngFactory());
        } else {
            latLng2 = null;
        }
        this.currentLoc = latLng2;
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        if (currentLocationFetch2.userAllowedAllLocationPermissions(this)) {
            FrameworkMap frameworkMap = this.mMap;
            if (frameworkMap != null) {
                frameworkMap.setMyLocationEnabled(true);
            }
            MapContainerFragment mapContainerFragment = this.mapFragment;
            if (mapContainerFragment != null) {
                mapContainerFragment.legacyHideLocationButton(false);
            }
        }
        if (latLng != null) {
            latLng3 = HomeScreenMapKt.toOur(latLng, getLatLngFactory());
        }
        currentlocationMovement(latLng3);
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull com.google.android.gms.maps.model.LatLng latLng, float f11) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        if (currentLocationFetch2 != null) {
            currentLocationFetch2.startLocationUpdates(this);
        }
    }

    public void onDestroy() {
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap != null) {
            frameworkMap.clear();
        }
        super.onDestroy();
    }

    public void onError() {
    }

    public void onFragmentInteraction(@NotNull Place place) {
        Intrinsics.checkNotNullParameter(place, "place");
        this.isFromPlaceSearch = true;
        googleAutoCompleteWidget(place);
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
        onLocationDialogAccepted(z11);
    }

    public void onMapReady(@NotNull FrameworkMap frameworkMap) {
        UiSettingsWrapper uiSettingsWrapper;
        UiSettingsWrapper uiSettingsWrapper2;
        UiSettingsWrapper uiSettingsWrapper3;
        UiSettingsWrapper uiSettingsWrapper4;
        UiSettingsWrapper uiSettingsWrapper5;
        com.google.android.gms.maps.model.LatLng latLng;
        com.google.android.gms.maps.model.LatLng latLng2;
        FrameworkMap frameworkMap2;
        com.google.android.gms.maps.model.LatLng latLng3;
        FrameworkMap.MapType mapType;
        com.google.android.gms.maps.model.LatLng latLng4;
        FrameworkMap.MapType mapType2;
        Intrinsics.checkNotNullParameter(frameworkMap, "frameworkMap");
        this.mMap = frameworkMap;
        drawCountryPolygon();
        String str = "satellite";
        UiSettingsWrapper uiSettingsWrapper6 = null;
        if (this.ignoreCurrentloctionRequest) {
            String str2 = this.mapJourneyType;
            LatLng latLng5 = this.mUserSavedTempLocation;
            if (latLng5 == null || (latLng4 = HomeScreenMapKt.toGoogle(latLng5)) == null) {
                LatLng latLng6 = this.areaCenterLatLng;
                if (latLng6 != null) {
                    latLng4 = HomeScreenMapKt.toGoogle(latLng6);
                } else {
                    latLng4 = null;
                }
            }
            FrameworkMap frameworkMap3 = this.mMap;
            if (frameworkMap3 != null) {
                mapType2 = frameworkMap3.getMapType();
            } else {
                mapType2 = null;
            }
            if (mapType2 != FrameworkMap.MapType.MAP_TYPE_SATELLITE) {
                str = "plain";
            }
            AppTracker.onMapShown(this, str2, latLng4, str);
        } else {
            String str3 = this.mapJourneyType;
            LatLng latLng7 = this.mUserSavedTempLocation;
            if (latLng7 == null || (latLng3 = HomeScreenMapKt.toGoogle(latLng7)) == null) {
                latLng3 = GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME;
            }
            FrameworkMap frameworkMap4 = this.mMap;
            if (frameworkMap4 != null) {
                mapType = frameworkMap4.getMapType();
            } else {
                mapType = null;
            }
            if (mapType != FrameworkMap.MapType.MAP_TYPE_SATELLITE) {
                str = "plain";
            }
            AppTracker.onMapShown(this, str3, latLng3, str);
        }
        HomeMapUtils homeMapUtils = HomeMapUtils.INSTANCE;
        if (!(homeMapUtils.defaultCountryLatLang() == null || (frameworkMap2 = this.mMap) == null)) {
            CameraUpdateFactory cameraUpdateFactory2 = getCameraUpdateFactory();
            com.google.android.gms.maps.model.LatLng defaultCountryLatLang = homeMapUtils.defaultCountryLatLang();
            Intrinsics.checkNotNull(defaultCountryLatLang);
            frameworkMap2.moveCamera(cameraUpdateFactory2.newLatLngZoom(HomeScreenMapKt.toOur(defaultCountryLatLang, getLatLngFactory()), 11.0f));
        }
        IHomeMapPresenter iHomeMapPresenter = this.mHomeMapPresenter;
        if (iHomeMapPresenter != null) {
            com.google.android.gms.maps.model.LatLng latLng8 = GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME;
            LatLng latLng9 = this.mUserSavedTempLocation;
            if (latLng9 != null) {
                latLng = HomeScreenMapKt.toGoogle(latLng9);
            } else {
                latLng = null;
            }
            Float f11 = this.mUserSavedTempZoomLevel;
            LatLng latLng10 = this.areaCenterLatLng;
            if (latLng10 != null) {
                latLng2 = HomeScreenMapKt.toGoogle(latLng10);
            } else {
                latLng2 = null;
            }
            iHomeMapPresenter.LocationReceived(latLng8, latLng, f11, latLng2);
        }
        FrameworkMap frameworkMap5 = this.mMap;
        if (frameworkMap5 != null) {
            uiSettingsWrapper = frameworkMap5.getUiSettings();
        } else {
            uiSettingsWrapper = null;
        }
        if (uiSettingsWrapper != null) {
            uiSettingsWrapper.setMyLocationButtonEnabled(true);
        }
        FrameworkMap frameworkMap6 = this.mMap;
        if (frameworkMap6 != null) {
            uiSettingsWrapper2 = frameworkMap6.getUiSettings();
        } else {
            uiSettingsWrapper2 = null;
        }
        if (uiSettingsWrapper2 != null) {
            uiSettingsWrapper2.setCompassEnabled(false);
        }
        FrameworkMap frameworkMap7 = this.mMap;
        if (frameworkMap7 != null) {
            uiSettingsWrapper3 = frameworkMap7.getUiSettings();
        } else {
            uiSettingsWrapper3 = null;
        }
        if (uiSettingsWrapper3 != null) {
            uiSettingsWrapper3.setTiltGesturesEnabled(true);
        }
        FrameworkMap frameworkMap8 = this.mMap;
        if (frameworkMap8 != null) {
            uiSettingsWrapper4 = frameworkMap8.getUiSettings();
        } else {
            uiSettingsWrapper4 = null;
        }
        if (uiSettingsWrapper4 != null) {
            uiSettingsWrapper4.setRotateGesturesEnabled(true);
        }
        FrameworkMap frameworkMap9 = this.mMap;
        if (frameworkMap9 != null) {
            uiSettingsWrapper5 = frameworkMap9.getUiSettings();
        } else {
            uiSettingsWrapper5 = null;
        }
        if (uiSettingsWrapper5 != null) {
            uiSettingsWrapper5.setZoomGesturesEnabled(true);
        }
        FrameworkMap frameworkMap10 = this.mMap;
        if (frameworkMap10 != null) {
            uiSettingsWrapper6 = frameworkMap10.getUiSettings();
        }
        if (uiSettingsWrapper6 != null) {
            uiSettingsWrapper6.setZoomControlsEnabled(false);
        }
        FrameworkMap frameworkMap11 = this.mMap;
        if (frameworkMap11 != null) {
            frameworkMap11.setBuildingsEnabled(true);
        }
        frameworkMap.setOnCameraIdleListener(this);
        frameworkMap.setOnCameraMoveStartedListener(this);
        frameworkMap.setOnCameraMoveListener(this);
        frameworkMap.setOnCameraMoveCanceledListener(this);
        if (checkPermission(this)) {
            IHomeMapPresenter iHomeMapPresenter2 = this.mHomeMapPresenter;
            if (iHomeMapPresenter2 != null) {
                iHomeMapPresenter2.resetGpsStatusTracker(false);
            }
        } else if (GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME != null) {
            IHomeMapPresenter iHomeMapPresenter3 = this.mHomeMapPresenter;
            if (iHomeMapPresenter3 != null) {
                iHomeMapPresenter3.resetGpsStatusTracker(false);
            }
        } else {
            IHomeMapPresenter iHomeMapPresenter4 = this.mHomeMapPresenter;
            if (iHomeMapPresenter4 != null) {
                iHomeMapPresenter4.resetGpsStatusTracker(true);
            }
        }
        FrameworkMap frameworkMap12 = this.mMap;
        if (frameworkMap12 != null) {
            frameworkMap12.setPadding(getPixelFromDp(2), getPixelFromDp(20), getPixelFromDp(2), getPixelFromDp(20));
        }
        locationButton(false);
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            FrameworkMap frameworkMap13 = this.mMap;
            if (frameworkMap13 != null) {
                frameworkMap13.setMyLocationEnabled(true);
            }
            MapContainerFragment mapContainerFragment = this.mapFragment;
            if (mapContainerFragment != null) {
                mapContainerFragment.legacyHideLocationButton(false);
            }
            this.mapViewType = "plain";
            onTrackMapLoaded();
            locationButton(true);
        }
    }

    public void onPause() {
        super.onPause();
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        if (currentLocationFetch2 != null) {
            Intrinsics.checkNotNull(currentLocationFetch2);
            if (currentLocationFetch2.isLoactionReequestInitied()) {
                CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
                Intrinsics.checkNotNull(currentLocationFetch3);
                currentLocationFetch3.stopLocationUpdates();
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG) {
            try {
                AlertDialog alertDialog2 = this.alertDialog;
                CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
                boolean z11 = false;
                if (currentLocationFetch2 != null && currentLocationFetch2.userAllowedAllLocationPermissions(this)) {
                    z11 = true;
                }
                if (z11 && alertDialog2 != null && alertDialog2.isShowing()) {
                    alertDialog2.dismiss();
                }
            } catch (Exception e11) {
                LogManager.logException(e11);
            }
        }
    }

    public void outofService(@Nullable com.google.android.gms.maps.model.LatLng latLng) {
        animtLocationBtn(false);
        int i11 = R.id.deliver_here_card_view;
        CardView cardView = (CardView) _$_findCachedViewById(i11);
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        int i12 = R.id.detail_card_container;
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(i12);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        int i13 = R.id.pre_geo_address_container;
        RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(i13);
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.loading_progress);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.pre_geo_location_container);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_txt);
        if (talabatTextView != null) {
            talabatTextView.setVisibility(4);
        }
        TalabatTextView talabatTextView2 = (TalabatTextView) _$_findCachedViewById(R.id.pre_geo_location_hint);
        if (talabatTextView2 != null) {
            talabatTextView2.setVisibility(4);
        }
        TalabatTextView talabatTextView3 = (TalabatTextView) _$_findCachedViewById(R.id.current_location_aware_txt);
        if (talabatTextView3 != null) {
            talabatTextView3.setVisibility(8);
        }
        ((LinearLayout) _$_findCachedViewById(R.id.location_aware_btn)).setVisibility(8);
        ((RelativeLayout) _$_findCachedViewById(i13)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        ((CardView) _$_findCachedViewById(i11)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        ((RelativeLayout) _$_findCachedViewById(i12)).setBackgroundColor(ContextCompat.getColor(this, R.color.color_transpearnt));
        setPaddingForGoogleLogo(this.mMap, false);
        ((ProgressBar) _$_findCachedViewById(R.id.linear_progressBar)).setVisibility(4);
        if (this.isFromBrandOrReorder) {
            ((RelativeLayout) _$_findCachedViewById(R.id.deliver_here)).setTag(3);
        } else {
            ((RelativeLayout) _$_findCachedViewById(R.id.deliver_here)).setTag(1);
        }
        ((TalabatTextView) _$_findCachedViewById(R.id.deliver_btn_here_txt)).setText(getResources().getString(R.string.dont_deliver_msg));
        onTrackAddressErrorShown(TrackingUtils.INSTANCE.getOutOfDeliveryZone());
    }

    public void preLocationLocationContainer(boolean z11, boolean z12) {
        this.isPreFetchAddressAvail = z11;
        prefetchLocationContainer(z11);
    }

    public void requestForUserCurrentLocation() {
        this.isCLocationBtnMovement = false;
    }

    public final void setAllCountryPolygon(@Nullable ArrayList<Polygon> arrayList) {
        this.allCountryPolygon = arrayList;
    }

    public final void setAnimation(@Nullable AnimationSet animationSet) {
        this.animation = animationSet;
    }

    public final void setAppVersionProvider(@NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "<set-?>");
        this.appVersionProvider = appVersionProvider2;
    }

    public final void setCameraUpdateFactory(@NotNull CameraUpdateFactory cameraUpdateFactory2) {
        Intrinsics.checkNotNullParameter(cameraUpdateFactory2, "<set-?>");
        this.cameraUpdateFactory = cameraUpdateFactory2;
    }

    public final void setChangeCountryName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.changeCountryName = str;
    }

    public final void setChangedCountryId(int i11) {
        this.changedCountryId = i11;
    }

    public final void setConfigurationRemoteRepository(@NotNull ConfigurationRemoteRepository configurationRemoteRepository2) {
        Intrinsics.checkNotNullParameter(configurationRemoteRepository2, "<set-?>");
        this.configurationRemoteRepository = configurationRemoteRepository2;
    }

    public final void setCustomAutoCompleteFragment(@Nullable CustomAutoCompleteFragment customAutoCompleteFragment2) {
        this.customAutoCompleteFragment = customAutoCompleteFragment2;
    }

    public final void setCustomerRepository(@NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(customerRepository2, "<set-?>");
        this.customerRepository = customerRepository2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setDelAreaFromSerach(boolean z11) {
        this.isDelAreaFromSerach = z11;
    }

    public final void setForceRedirectSearch(boolean z11) {
        this.isForceRedirectSearch = z11;
    }

    public final void setFromPlaceSearch(boolean z11) {
        this.isFromPlaceSearch = z11;
    }

    public final void setGetProCentralizationStatusUseCase(@NotNull GetProCentralizationStatusUseCase getProCentralizationStatusUseCase2) {
        Intrinsics.checkNotNullParameter(getProCentralizationStatusUseCase2, "<set-?>");
        this.getProCentralizationStatusUseCase = getProCentralizationStatusUseCase2;
    }

    public final void setGpsStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gpsStatus = str;
    }

    public final void setHideDragTutFromSearch(boolean z11) {
        this.isHideDragTutFromSearch = z11;
    }

    public final void setIgnoreBottomAnim(boolean z11) {
        this.ignoreBottomAnim = z11;
    }

    public final void setLatLngFactory(@NotNull LatLngFactory latLngFactory2) {
        Intrinsics.checkNotNullParameter(latLngFactory2, "<set-?>");
        this.latLngFactory = latLngFactory2;
    }

    public final void setLocationMethod(@Nullable String str) {
        this.locationMethod = str;
    }

    public final void setMapFragment(@Nullable MapContainerFragment mapContainerFragment) {
        this.mapFragment = mapContainerFragment;
    }

    public final void setMapViewType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mapViewType = str;
    }

    public final void setMapsInitializer(@NotNull MapsInitializer mapsInitializer2) {
        Intrinsics.checkNotNullParameter(mapsInitializer2, "<set-?>");
        this.mapsInitializer = mapsInitializer2;
    }

    public final void setModelsRepository(@NotNull ModelsRepository modelsRepository2) {
        Intrinsics.checkNotNullParameter(modelsRepository2, "<set-?>");
        this.modelsRepository = modelsRepository2;
    }

    public final void setMoshi(@NotNull Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "<set-?>");
        this.moshi = moshi2;
    }

    public final void setMutableConfigurationLocalRepository(@NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository2, "<set-?>");
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
    }

    public final void setMutableConfigurationRemoteRepository(@NotNull MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository2) {
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteRepository2, "<set-?>");
        this.mutableConfigurationRemoteRepository = mutableConfigurationRemoteRepository2;
    }

    public final void setMutableLocationConfigurationRepository(@NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository2, "<set-?>");
        this.mutableLocationConfigurationRepository = mutableLocationConfigurationRepository2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setOutOfCountry(boolean z11) {
        this.isOutOfCountry = z11;
    }

    public final void setOutOfService(boolean z11) {
        this.outOfService = z11;
    }

    public final void setPaymentConfigurationRepository(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "<set-?>");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }

    public final void setPopupWindow(@Nullable Dialog dialog) {
        this.popupWindow = dialog;
    }

    public final void setReachedLoc(boolean z11) {
        this.reachedLoc = z11;
    }

    public final void setRedirectBacktoHomeFromLocationWelcome(boolean z11) {
        this.isRedirectBacktoHomeFromLocationWelcome = z11;
    }

    public final void setSecretProvider(@NotNull SecretProvider secretProvider2) {
        Intrinsics.checkNotNullParameter(secretProvider2, "<set-?>");
        this.secretProvider = secretProvider2;
    }

    public final void setSetHasUserPinnedLocationInOnboardingMapUseCase(@NotNull SetHasUserPinnedLocationInOnboardingMapUseCase setHasUserPinnedLocationInOnboardingMapUseCase2) {
        Intrinsics.checkNotNullParameter(setHasUserPinnedLocationInOnboardingMapUseCase2, "<set-?>");
        this.setHasUserPinnedLocationInOnboardingMapUseCase = setHasUserPinnedLocationInOnboardingMapUseCase2;
    }

    public final void setSubscriptionsCustomerRepository(@NotNull ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsCustomerRepository, "<set-?>");
        this.subscriptionsCustomerRepository = iSubscriptionsCustomerRepository;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setTrackingDistance(double d11) {
        this.trackingDistance = d11;
    }

    public final void setUserSelectedAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userSelectedAddress = str;
    }

    public final void setUserSelectedLatLng(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userSelectedLatLng = str;
    }

    public void showGeoAddressLoading() {
    }

    public void showLinaerLoading() {
        int i11 = R.id.linear_progressBar;
        if (((ProgressBar) _$_findCachedViewById(i11)) == null || ((RelativeLayout) _$_findCachedViewById(R.id.pre_geo_address_container)).getVisibility() != 0) {
            ((ProgressBar) _$_findCachedViewById(i11)).setVisibility(4);
        } else {
            ((ProgressBar) _$_findCachedViewById(i11)).setVisibility(0);
        }
    }

    public final void slideDown(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) view.getHeight());
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        view.startAnimation(translateAnimation);
    }

    public final void slideUp(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) view.getHeight(), 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        view.startAnimation(translateAnimation);
    }

    public final void stopFadeInFadeOutAnimation(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        AnimationSet animationSet = this.animation;
        if (animationSet != null) {
            animationSet.cancel();
        }
        AnimationSet animationSet2 = this.animation;
        if (animationSet2 != null) {
            animationSet2.setAnimationListener((Animation.AnimationListener) null);
        }
        view.clearAnimation();
        int i11 = R.id.location_btn;
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
        ImageView imageView = (ImageView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNull(imageView);
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_m_gps_on));
    }

    public void updateAreaLocation(@Nullable com.google.android.gms.maps.model.LatLng latLng, @Nullable Void voidR) {
        this.areaCenterLatLng = latLng != null ? HomeScreenMapKt.toOur(latLng, getLatLngFactory()) : null;
    }

    public void updateBranchId(int i11) {
        this.restBranchId = i11;
    }

    public void updateIsFrachiseRestaurant(boolean z11) {
        this.isFranchiseRes = z11;
    }

    public void updateRestGrpId(int i11) {
        this.restGrpId = i11;
    }

    public void updateUserSavedTempLocation(@Nullable com.google.android.gms.maps.model.LatLng latLng, @Nullable Float f11) {
        LatLng latLng2;
        if (latLng != null) {
            latLng2 = HomeScreenMapKt.toOur(latLng, getLatLngFactory());
        } else {
            latLng2 = null;
        }
        this.mUserSavedTempLocation = latLng2;
        this.mUserSavedTempZoomLevel = f11;
    }

    public boolean checkPermission() {
        return checkPermission(this);
    }

    @Nullable
    public IHomeMapPresenter getPresenter() {
        return this.mHomeMapPresenter;
    }
}
