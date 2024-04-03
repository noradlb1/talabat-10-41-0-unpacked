package com.talabat;

import JsonModels.Request.RestGeoReverseCodingRequest;
import JsonModels.parser.UniversalGson;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.huawei.hms.flutter.map.constants.Param;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.moshi.Moshi;
import com.talabat.adapters.homeMap.ChooseSavedAddressListAdapter;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
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
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.DaggerChooseSavedAddressScreenComponent;
import com.talabat.domain.address.Address;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.SimpleDividerItemDecoration;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl;
import com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource;
import com.talabat.userandlocation.appinfo.data.remote.api.AppInfoApi;
import com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoApi;
import com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl;
import datamodels.analyticstrackermodels.AddressAnalyticsTracker;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import library.talabat.mvp.choosesavedaddress.ChooseSavedAddressPresenter;
import library.talabat.mvp.choosesavedaddress.ChooseSavedAddressView;
import library.talabat.mvp.choosesavedaddress.IChooseSavedAddressPresenter;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.homemap.HomeMapUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.TalabatAdjust;
import tracking.TalabatAppBoy;
import tracking.gtm.TrackingUtils;
import ue.l5;
import ue.m5;
import ue.n5;
import ue.o5;
import ue.p5;
import ue.q5;
import ue.r5;
import ue.s5;
import ue.t5;
import ue.u5;
import ue.v5;
import ue.w5;

@Instrumented
@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b6\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00152\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020;H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J(\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\rH\u0002J\u001e\u0010\u0001\u001a\u00030\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00012\b\u0010\u0001\u001a\u00030\u0001J\u0013\u0010¢\u0001\u001a\u00030\u00012\u0007\u0010£\u0001\u001a\u00020!H\u0002J\u0013\u0010¤\u0001\u001a\u00030\u00012\u0007\u0010¥\u0001\u001a\u00020\u0015H\u0016J\u0013\u0010¦\u0001\u001a\u00030\u00012\u0007\u0010§\u0001\u001a\u00020!H\u0016J\n\u0010¨\u0001\u001a\u00030\u0001H\u0016J\n\u0010©\u0001\u001a\u00030\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030\u0001H\u0002J\n\u0010«\u0001\u001a\u00030\u0001H\u0002J0\u0010¬\u0001\u001a\u00030\u00012\b\u0010­\u0001\u001a\u00030®\u00012\b\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010±\u0001\u001a\u00020\u00152\u0007\u0010²\u0001\u001a\u00020;H\u0002J\n\u0010³\u0001\u001a\u00030\u0001H\u0002J\n\u0010´\u0001\u001a\u00030\u0001H\u0016J\n\u0010µ\u0001\u001a\u00030\u0001H\u0016J\u0014\u0010¶\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010·\u0001\u001a\u00030¸\u0001H\u0016J\u000b\u0010¹\u0001\u001a\u0004\u0018\u00010RH\u0016J\t\u0010º\u0001\u001a\u00020\rH\u0016J\n\u0010»\u0001\u001a\u00030\u0001H\u0002J\n\u0010¼\u0001\u001a\u00030\u0001H\u0002J\n\u0010½\u0001\u001a\u00030\u0001H\u0003J\n\u0010¾\u0001\u001a\u00030\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020;H\u0002J\u0011\u0010À\u0001\u001a\u00020;2\b\u0010\u0001\u001a\u00030\u0001J\u001c\u0010Á\u0001\u001a\u00030\u00012\u0007\u0010Á\u0001\u001a\u00020;2\u0007\u0010§\u0001\u001a\u00020!H\u0016J\n\u0010Â\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010Ã\u0001\u001a\u00030\u00012\u0007\u0010§\u0001\u001a\u00020!H\u0016J\n\u0010Ä\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010Å\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J(\u0010Æ\u0001\u001a\u00030\u00012\u0007\u0010Ç\u0001\u001a\u00020\u00152\u0007\u0010È\u0001\u001a\u00020\u00152\n\u0010É\u0001\u001a\u0005\u0018\u00010Ê\u0001H\u0014J\n\u0010Ë\u0001\u001a\u00030\u0001H\u0016J\n\u0010Ì\u0001\u001a\u00030\u0001H\u0016J\u001b\u0010Í\u0001\u001a\u00030\u00012\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0003\u0010Ï\u0001J\u0016\u0010Ð\u0001\u001a\u00030\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ò\u0001H\u0015J(\u0010Ó\u0001\u001a\u00030\u00012\t\u0010Ô\u0001\u001a\u0004\u0018\u00010!2\u0007\u0010Õ\u0001\u001a\u00020;2\b\u0010Ö\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010×\u0001\u001a\u00030\u00012\u0007\u0010§\u0001\u001a\u00020!2\b\u0010Ö\u0001\u001a\u00030\u0001H\u0016J\n\u0010Ø\u0001\u001a\u00030\u0001H\u0016J\n\u0010Ù\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010Ú\u0001\u001a\u00030\u00012\u0007\u0010Û\u0001\u001a\u00020;H\u0016J+\u0010Ü\u0001\u001a\u00030\u00012\u001f\u0010Ý\u0001\u001a\u001a\u0012\u0005\u0012\u00030\u0001\u0018\u00010Þ\u0001j\f\u0012\u0005\u0012\u00030\u0001\u0018\u0001`ß\u0001H\u0002J\u0013\u0010à\u0001\u001a\u00030\u00012\u0007\u0010á\u0001\u001a\u00020;H\u0002J\n\u0010â\u0001\u001a\u00030\u0001H\u0016J\n\u0010ã\u0001\u001a\u00030\u0001H\u0016J\u0014\u0010ä\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0015\u0010å\u0001\u001a\u00030\u00012\t\u0010æ\u0001\u001a\u0004\u0018\u00010\rH\u0002J\u0016\u0010ç\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0016\u0010è\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\n\u0010é\u0001\u001a\u00030\u0001H\u0002J\n\u0010ê\u0001\u001a\u00030\u0001H\u0002J\n\u0010ë\u0001\u001a\u00030\u0001H\u0002J.\u0010ì\u0001\u001a\u00030\u00012\u0007\u0010í\u0001\u001a\u00020;2\u0007\u0010î\u0001\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020\u00152\u0007\u0010ð\u0001\u001a\u00020;H\u0016J\u0013\u0010ñ\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\u0014\u0010ò\u0001\u001a\u00030\u00012\b\u0010ó\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010ô\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010õ\u0001\u001a\u00030\u00012\u0007\u0010ö\u0001\u001a\u00020\rH\u0002J\u0014\u0010÷\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010ø\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010ù\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00152\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010ú\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00152\b\u0010û\u0001\u001a\u00030\u0001H\u0016J\u0016\u0010ü\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010ý\u0001\u001a\u00020\rH\u0002J\u0014\u0010þ\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0015\u0010ÿ\u0001\u001a\u00030\u00012\t\u0010\u0002\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\u0002\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0011\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\rJ\u001e\u0010\u0002\u001a\u00030\u00012\t\u0010\u0002\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0002\u001a\u00020;H\u0016J'\u0010\u0002\u001a\u00030\u00012\u001b\u0010Ý\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u00010Þ\u0001j\n\u0012\u0005\u0012\u00030\u0001`ß\u0001H\u0016J\t\u0010\u0002\u001a\u00020;H\u0016J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020;H\u0016J\u0015\u0010\u0002\u001a\u00030\u00012\t\u0010\u0002\u001a\u0004\u0018\u00010\rH\u0016J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020;H\u0016J\n\u0010\u0002\u001a\u00030\u0001H\u0016J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u0015H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001d\"\u0004\b6\u0010\u001fR\u000e\u00107\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010H\u001a\u00020I8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001d\"\u0004\bP\u0010\u001fR\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010S\u001a\u00020T8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010Y\u001a\u00020Z8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001e\u0010_\u001a\u00020`8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001e\u0010e\u001a\u00020f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001e\u0010k\u001a\u00020l8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010q\u001a\u0004\u0018\u00010rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u000e\u0010w\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010z\u001a\u00020{8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0002"}, d2 = {"Lcom/talabat/ChooseSavedAddressScreen;", "Lcom/talabat/helpers/TalabatBase;", "Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressView;", "Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$onItemClickListener;", "Lcom/talabat/homemaphelper/CurrentLocationListener;", "()V", "animation", "Landroid/view/animation/AnimationSet;", "getAnimation", "()Landroid/view/animation/AnimationSet;", "setAnimation", "(Landroid/view/animation/AnimationSet;)V", "apiErrorMsg", "", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "getAppVersionProvider", "()Lcom/talabat/configuration/discovery/AppVersionProvider;", "setAppVersionProvider", "(Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "branchIdDl", "", "changedCountryId", "getChangedCountryId", "()I", "setChangedCountryId", "(I)V", "countryName", "getCountryName", "()Ljava/lang/String;", "setCountryName", "(Ljava/lang/String;)V", "currentLocation", "Lcom/google/android/gms/maps/model/LatLng;", "currentLocationFetch", "Lcom/talabat/homemaphelper/CurrentLocationFetch;", "getCurrentLocationFetch", "()Lcom/talabat/homemaphelper/CurrentLocationFetch;", "setCurrentLocationFetch", "(Lcom/talabat/homemaphelper/CurrentLocationFetch;)V", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "getCustomerRepository", "()Lcom/talabat/customer/domain/CustomerRepository;", "setCustomerRepository", "(Lcom/talabat/customer/domain/CustomerRepository;)V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "deliveryAddressStatus", "getDeliveryAddressStatus", "setDeliveryAddressStatus", "franchiseGrpid", "geoAddressError", "geoLocationStatusTrack", "isCDLReverseGeoReceived", "", "isDeSelectBranch", "isFetchingCurrentLocation", "isFromBrandOrReorder", "isFromFanchiseRes", "isFromHome", "isFromRL", "isFromReOrder", "isIgnoreCurrentLocation", "isIgnoreSavedLoc", "isInteractedWithDL", "isLoadDeliveryAddressBasedOnVendor", "locationAccuracy", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "locationMethod", "getLocationMethod", "setLocationMethod", "mChooseSavedAddressPresenter", "Llibrary/talabat/mvp/choosesavedaddress/IChooseSavedAddressPresenter;", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "setMoshi", "(Lcom/squareup/moshi/Moshi;)V", "mutableConfigurationLocalCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;", "getMutableConfigurationLocalCoreLibApi", "()Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;", "setMutableConfigurationLocalCoreLibApi", "(Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;)V", "mutableConfigurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "getMutableConfigurationRemoteCoreLibApi", "()Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "setMutableConfigurationRemoteCoreLibApi", "(Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "getPaymentConfigurationRepository", "()Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "setPaymentConfigurationRepository", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;)V", "popupWindow", "Landroid/app/Dialog;", "getPopupWindow", "()Landroid/app/Dialog;", "setPopupWindow", "(Landroid/app/Dialog;)V", "reorderId", "reorderResId", "reorderResName", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "getSubscriptionsFeatureApi", "()Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "setSubscriptionsFeatureApi", "(Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "BrandRedirection", "", "branchId", "address", "Lcom/talabat/domain/address/Address;", "BrandReorderRedirectionDL", "ChooseAreaAndAddress", "cstAddress", "ChooseAreaAndAddressDL", "DeliverCLNotDeliverable", "isunDeliverabale", "OnCurrentLocationPermissionStatus", "response", "Lcom/karumi/dexter/listener/PermissionDeniedResponse;", "addressSelected", "animateSlideTo", "start", "", "end", "listener", "Lcom/talabat/ChooseSavedAddressScreen$SlideAnimationListener;", "animateToHide", "changeCountryAlert", "countryId", "changedCountry", "clearCart", "cart", "Lbuisnessmodels/Cart;", "convertCLToAddress", "loc", "currentLocOutSideCountry", "countyId", "deliverToCLRecived", "currentLatLng", "destroyPresenter", "enableClTxt", "enableLocFromSettings", "enabledLocTxtBasedPermission", "fadeInFadeOutAnim", "imageView", "Landroid/widget/ImageView;", "images", "", "imageIndex", "forever", "fetchCurrentLocTxt", "fetchCurrentLocaion", "forceToenableCurrentLocation", "getBranchIdGeoBased", "getContext", "Landroid/content/Context;", "getPresenter", "getScreenName", "gpsLocationSettingsAlert", "hideSystemUI", "initView", "inject", "isHomeScreenToFoodListDeeplinkEnabled", "isNeedToClearCart", "isRefreshMap", "listenForCurrentLocation", "mapCurrentLocReceived", "navigateToFlutterFoodListDeeplink", "navigateToFlutterFoodListExplicitly", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAuthError", "onBackPressed", "onCountryDataLoaded", "id", "(Ljava/lang/Integer;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCurrentLocationReceived", "location", "isShowLocationInAccurateAlert", "lococaccuracy", "onCurrentLocationReceivedWithLowAccuracy", "onDeliverHereClicked", "onError", "onGeoLocationDialogAccepted", "locationRequestStatus", "onLocationAttempted", "customerAddress", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onLocationDialogAccepted", "locationEnabled", "onPause", "onResume", "onSavedAddressClicked", "onTrackAddressErrorShown", "errorMsg", "onTrackAddressSubmitted", "onTrackGeoLocationRequested", "openSettings", "reDirectToReOrderCart", "reInitiateLocation", "redirectMapScreen", "ignoreCurrentLocation", "UserSelectedAddress", "areaId", "isPrioritizeSearch", "redirectMenu", "redirectToListingFromDCL", "result", "redirectToRestaurantListScreen", "redirecttoFreanchiseSelectionScreen", "stroeLocation", "resetAddressPref", "resetCustomerBrandAddress", "reverseBrachIdReceived", "reverseBrachIdReceivedFromDL", "reverseAddress", "reverserAddressReceived", "screenType", "selectAddress", "selectedAddressNotDeliveringAlert", "exceptionMessage", "setCurrentLocAddress", "showAreaSplitAlert", "areaName", "showBrandNotDeliverHere", "geoAddressTitle", "fromDcl", "showCustomerSavedAddress", "showRedirectLoading", "showSettingsDialog", "storeTempAddress", "unableToFindLocation", "trackError", "updateApiErrorMsg", "localizedMessage", "updateIsFrachiseRestaurant", "isFranchiseRes", "updateIsIGnoreSavedLoc", "updateRestGrpId", "restGrpId", "SlideAnimationListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseSavedAddressScreen extends TalabatBase implements ChooseSavedAddressView, ChooseSavedAddressListAdapter.onItemClickListener, CurrentLocationListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private AnimationSet animation;
    @Nullable
    private String apiErrorMsg = "";
    @Inject
    public AppVersionProvider appVersionProvider;
    private int branchIdDl;
    private int changedCountryId;
    @NotNull
    private String countryName = "";
    @Nullable
    private LatLng currentLocation;
    @Nullable
    private CurrentLocationFetch currentLocationFetch;
    @Inject
    public CustomerRepository customerRepository;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Nullable
    private String deliveryAddressStatus;
    private int franchiseGrpid;
    @Nullable
    private String geoAddressError = "";
    @NotNull
    private String geoLocationStatusTrack = "";
    private boolean isCDLReverseGeoReceived;
    private boolean isDeSelectBranch;
    private boolean isFetchingCurrentLocation;
    private boolean isFromBrandOrReorder;
    private boolean isFromFanchiseRes;
    private boolean isFromHome;
    private boolean isFromRL;
    private boolean isFromReOrder;
    private boolean isIgnoreCurrentLocation;
    private boolean isIgnoreSavedLoc;
    private boolean isInteractedWithDL;
    private boolean isLoadDeliveryAddressBasedOnVendor;
    @NotNull
    private String locationAccuracy = "";
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private String locationMethod;
    @Nullable
    private IChooseSavedAddressPresenter mChooseSavedAddressPresenter;
    @Inject
    public Moshi moshi;
    @Inject
    public MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi;
    @Inject
    public MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
    @Inject
    public Navigator navigator;
    @Inject
    public PaymentConfigurationRepository paymentConfigurationRepository;
    @Nullable
    private Dialog popupWindow;
    @NotNull
    private String reorderId = "";
    private int reorderResId;
    @NotNull
    private String reorderResName = "";
    @Inject
    public SubscriptionsFeatureApi subscriptionsFeatureApi;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/ChooseSavedAddressScreen$SlideAnimationListener;", "", "onAnimationFinish", "", "onAnimationStart", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SlideAnimationListener {
        void onAnimationFinish();

        void onAnimationStart();
    }

    private final void BrandRedirection(int i11, Address address) {
        boolean z11;
        stopLodingPopup();
        Cart instance = Cart.getInstance();
        if (instance.hasItems()) {
            if (instance.getCartAreaId() == address.areaId) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                resetAddressPref(address);
                addressSelected(address);
                redirectMenu(i11);
                return;
            }
            clearCart(instance, address);
            return;
        }
        resetAddressPref(address);
        addressSelected(address);
        redirectMenu(i11);
    }

    private final void BrandReorderRedirectionDL(Address address) {
        stopLodingPopup();
        Cart instance = Cart.getInstance();
        if (instance.hasItems()) {
            clearCart(instance, address);
        } else {
            ChooseAreaAndAddressDL(address);
        }
    }

    private final void ChooseAreaAndAddress(Address address) {
        if (this.isFromBrandOrReorder) {
            if (this.isFromReOrder) {
                addressSelected(address);
                reDirectToReOrderCart();
            } else {
                getBranchIdGeoBased(address);
            }
            HomeMapTemp.INSTANCE.setHomeMapRedirect(false, this);
            return;
        }
        addressSelected(address);
        redirectToRestaurantListScreen(address.countyId);
        onTrackAddressSubmitted(address);
    }

    private final void ChooseAreaAndAddressDL(Address address) {
        resetAddressPref(address);
        setCurrentLocAddress(address);
        onTrackGeoLocationRequested(address);
        if (!this.isFromBrandOrReorder) {
            redirectToRestaurantListScreen(address.countyId);
            onTrackAddressSubmitted(address);
        } else if (this.isFromReOrder) {
            reDirectToReOrderCart();
        } else if (this.isFromFanchiseRes) {
            Double valueOf = Double.valueOf(address.latitude);
            Double valueOf2 = Double.valueOf(address.longitude);
            redirecttoFreanchiseSelectionScreen(valueOf + "," + valueOf2);
        } else {
            redirectMenu(this.branchIdDl);
        }
    }

    private final void DeliverCLNotDeliverable(boolean z11) {
        if (z11) {
            this.isCDLReverseGeoReceived = false;
            ((TalabatTextView) _$_findCachedViewById(R.id.txt_deliver_to_my_current_loc)).setAlpha(0.5f);
            int i11 = R.id.txt_current_loc_text;
            ((TalabatTextView) _$_findCachedViewById(i11)).setAlpha(0.5f);
            ((ImageView) _$_findCachedViewById(R.id.deliver_current_location_img)).setAlpha(0.5f);
            ((TalabatTextView) _$_findCachedViewById(i11)).setVisibility(8);
            TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.out_of_delivery_txt);
            if (talabatTextView != null) {
                talabatTextView.setVisibility(0);
            }
            int i12 = R.id.deliver_to_current_location;
            ((RelativeLayout) _$_findCachedViewById(i12)).setEnabled(false);
            ((RelativeLayout) _$_findCachedViewById(i12)).setClickable(false);
        } else {
            this.isCDLReverseGeoReceived = true;
            ((TalabatTextView) _$_findCachedViewById(R.id.txt_deliver_to_my_current_loc)).setAlpha(1.0f);
            int i13 = R.id.txt_current_loc_text;
            ((TalabatTextView) _$_findCachedViewById(i13)).setAlpha(1.0f);
            ((ImageView) _$_findCachedViewById(R.id.deliver_current_location_img)).setAlpha(1.0f);
            ((TalabatTextView) _$_findCachedViewById(i13)).setVisibility(0);
            TalabatTextView talabatTextView2 = (TalabatTextView) _$_findCachedViewById(R.id.out_of_delivery_txt);
            if (talabatTextView2 != null) {
                talabatTextView2.setVisibility(8);
            }
            int i14 = R.id.deliver_to_current_location;
            ((RelativeLayout) _$_findCachedViewById(i14)).setEnabled(true);
            ((RelativeLayout) _$_findCachedViewById(i14)).setClickable(true);
        }
        ((ProgressBar) _$_findCachedViewById(R.id.deliver_current_location_progress)).setVisibility(8);
    }

    private final void addressSelected(Address address) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        GlobalDataModel.SelectedAreaId = address.areaId;
        GlobalDataModel.SelectedAreaName = address.areaName;
        int i11 = address.cityId;
        GlobalDataModel.SelectedCityId = i11;
        GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, getMutableConfigurationLocalCoreLibApi().getRepository(), getLocationConfigurationRepository());
        Context context = getContext();
        String str = null;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        } else {
            sharedPreferences = null;
        }
        if (sharedPreferences != null) {
            editor = sharedPreferences.edit();
        } else {
            editor = null;
        }
        if (editor != null) {
            editor.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        }
        if (editor != null) {
            editor.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        }
        if (editor != null) {
            editor.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        }
        if (editor != null) {
            editor.putString(GlobalConstants.PrefsConstants.CITY_NAME, GlobalDataModel.SelectedCityName);
        }
        if (editor != null) {
            editor.apply();
        }
        getCustomerRepository().setSelectedCustomerAddress(address.f58343id, address.areaId);
        getCustomerRepository().setBrandScreenLocalAddress();
        if (Customer.getInstance().getSelectedCustomerAddress() != null) {
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            if (selectedCustomerAddress != null) {
                str = selectedCustomerAddress.f58343id;
            }
            if (Intrinsics.areEqual((Object) str, (Object) address.f58343id)) {
                boolean z11 = this.isFromFanchiseRes;
                if (z11) {
                    this.isDeSelectBranch = false;
                } else if (z11) {
                    this.isDeSelectBranch = z11;
                }
                TalabatAppBoy.onLastSearchedLocation(this, address.latitude, address.longitude);
                TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
                talabatExperiment.setAttribute(FWFAttributes.AREA_ID, String.valueOf(address.areaId));
                talabatExperiment.setAttribute(FWFAttributes.LOCATION_COUNTRY, getLocationConfigurationRepository().config().getCountry().getThreeLetterCode(), TalabatExperimentDataSourceStrategy.APPTIMIZE);
            }
        }
        HomeMapTemp.INSTANCE.updateAddressNotSaved(false);
        TalabatAppBoy.onLastSearchedLocation(this, address.latitude, address.longitude);
        TalabatExperiment talabatExperiment2 = TalabatExperiment.INSTANCE;
        talabatExperiment2.setAttribute(FWFAttributes.AREA_ID, String.valueOf(address.areaId));
        talabatExperiment2.setAttribute(FWFAttributes.LOCATION_COUNTRY, getLocationConfigurationRepository().config().getCountry().getThreeLetterCode(), TalabatExperimentDataSourceStrategy.APPTIMIZE);
    }

    /* access modifiers changed from: private */
    /* renamed from: animateSlideTo$lambda-4  reason: not valid java name */
    public static final void m9410animateSlideTo$lambda4(ChooseSavedAddressScreen chooseSavedAddressScreen, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, Param.ANIMATION);
        RelativeLayout relativeLayout = (RelativeLayout) chooseSavedAddressScreen._$_findCachedViewById(R.id.content_view);
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            relativeLayout.setTranslationY(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* access modifiers changed from: private */
    public final void animateToHide() {
        animateSlideTo(0.0f, (float) ((RelativeLayout) _$_findCachedViewById(R.id.content_view)).getHeight(), new ChooseSavedAddressScreen$animateToHide$1(this));
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
        builder.setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) new n5(this, i11));
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: changeCountryAlert$lambda-9  reason: not valid java name */
    public static final void m9411changeCountryAlert$lambda9(ChooseSavedAddressScreen chooseSavedAddressScreen, int i11, DialogInterface dialogInterface, int i12) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        IChooseSavedAddressPresenter iChooseSavedAddressPresenter = chooseSavedAddressScreen.mChooseSavedAddressPresenter;
        if (iChooseSavedAddressPresenter != null) {
            iChooseSavedAddressPresenter.changeUserCountry(i11);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCart$lambda-3  reason: not valid java name */
    public static final void m9412clearCart$lambda3(ChooseSavedAddressScreen chooseSavedAddressScreen, Address address, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        Intrinsics.checkNotNullParameter(address, "$cstAddress");
        Cart.getInstance().clearCart(chooseSavedAddressScreen);
        if (chooseSavedAddressScreen.isInteractedWithDL) {
            chooseSavedAddressScreen.ChooseAreaAndAddressDL(address);
        } else {
            chooseSavedAddressScreen.ChooseAreaAndAddress(address);
        }
    }

    private final void convertCLToAddress(LatLng latLng) {
        IChooseSavedAddressPresenter iChooseSavedAddressPresenter = this.mChooseSavedAddressPresenter;
        if (iChooseSavedAddressPresenter != null) {
            iChooseSavedAddressPresenter.clToAddress(this.isFromBrandOrReorder, latLng, this.isInteractedWithDL);
        }
    }

    private final void enableClTxt() {
        ((RelativeLayout) _$_findCachedViewById(R.id.deliver_to_current_location)).setTag(2);
        ((ProgressBar) _$_findCachedViewById(R.id.deliver_current_location_progress)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.deliver_current_location_arrow)).setVisibility(4);
        enabledLocTxtBasedPermission();
    }

    private final void enableLocFromSettings() {
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        if (currentLocationFetch2.userAllowedAllLocationPermissions(this)) {
            fetchCurrentLocTxt();
            this.geoLocationStatusTrack = "enable";
            reInitiateLocation();
            return;
        }
        this.isCDLReverseGeoReceived = false;
        stopLodingPopup();
    }

    private final void enabledLocTxtBasedPermission() {
        String str;
        if (this.currentLocationFetch == null) {
            this.currentLocationFetch = new CurrentLocationFetch(this, this);
            this.geoLocationStatusTrack = "enabled";
        }
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        if (currentLocationFetch2.isLocationServiceEnabled(this)) {
            CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
            Intrinsics.checkNotNull(currentLocationFetch3);
            if (!currentLocationFetch3.checkPermissions()) {
                this.isCDLReverseGeoReceived = false;
                String string = getResources().getString(R.string.allow_app_location);
                Intrinsics.checkNotNullExpressionValue(string, "this@ChooseSavedAddressS…ion\n                    )");
                String string2 = getResources().getString(R.string.talabat_app_name);
                Intrinsics.checkNotNullExpressionValue(string2, "this@ChooseSavedAddressS…                        )");
                str = StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, string2, false, 4, (Object) null);
                this.geoLocationStatusTrack = TrackingUtils.INSTANCE.getAppGpsDisabled();
            } else {
                str = "";
            }
        } else {
            this.isCDLReverseGeoReceived = false;
            str = getResources().getString(R.string.enable_device_location);
            Intrinsics.checkNotNullExpressionValue(str, "this@ChooseSavedAddressS…ce_location\n            )");
            this.geoLocationStatusTrack = TrackingUtils.INSTANCE.getDeviceGpsDisabled();
        }
        ((TalabatTextView) _$_findCachedViewById(R.id.txt_current_loc_text)).setText(str);
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
            animationSet5.setAnimationListener(new ChooseSavedAddressScreen$fadeInFadeOutAnim$1(iArr, i11, this, imageView, z11));
        }
    }

    private final void fetchCurrentLocTxt() {
        if (!this.isCDLReverseGeoReceived) {
            ((TalabatTextView) _$_findCachedViewById(R.id.txt_current_loc_text)).setText(getResources().getString(R.string.fetching_current_loc));
            ((ProgressBar) _$_findCachedViewById(R.id.deliver_current_location_progress)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.deliver_current_location_arrow)).setVisibility(4);
        }
    }

    private final void getBranchIdGeoBased(Address address) {
        RestGeoReverseCodingRequest restGeoReverseCodingRequest = new RestGeoReverseCodingRequest(GlobalDataModel.SELECTED.restaurant.f13872id, GlobalDataModel.SelectedCountryId, address.longitude, address.latitude, 0);
        IChooseSavedAddressPresenter iChooseSavedAddressPresenter = this.mChooseSavedAddressPresenter;
        if (iChooseSavedAddressPresenter != null) {
            iChooseSavedAddressPresenter.reverseGeoCodingBasedRestaurant(address, restGeoReverseCodingRequest);
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
                    textView3.setGravity(i11);
                    if (!TalabatUtils.isRTL()) {
                        i13 = 3;
                    }
                    textView2.setGravity(i13);
                    textView.setText(replace$default);
                    textView2.setText(replace$default2);
                    Dialog dialog11 = this.popupWindow;
                    if (!(dialog11 == null || (findViewById2 = dialog11.findViewById(R.id.go_to_settings)) == null)) {
                        findViewById2.setOnClickListener(new v5(this));
                    }
                    Dialog dialog12 = this.popupWindow;
                    if (!(dialog12 == null || (findViewById = dialog12.findViewById(R.id.no_thanks)) == null)) {
                        findViewById.setOnClickListener(new w5(this));
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

    /* access modifiers changed from: private */
    /* renamed from: gpsLocationSettingsAlert$lambda-10  reason: not valid java name */
    public static final void m9413gpsLocationSettingsAlert$lambda10(ChooseSavedAddressScreen chooseSavedAddressScreen, View view) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        chooseSavedAddressScreen.openSettings();
        Dialog dialog = chooseSavedAddressScreen.popupWindow;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gpsLocationSettingsAlert$lambda-11  reason: not valid java name */
    public static final void m9414gpsLocationSettingsAlert$lambda11(ChooseSavedAddressScreen chooseSavedAddressScreen, View view) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        Dialog dialog = chooseSavedAddressScreen.popupWindow;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void hideSystemUI() {
        getWindow().setFlags(512, 512);
    }

    @ExperimentalStdlibApi
    private final void initView() {
        int i11 = R.id.saved_address_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) _$_findCachedViewById(i11)).addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.line_divider));
        AppInfoRemoteDataSourceImpl appInfoRemoteDataSourceImpl = new AppInfoRemoteDataSourceImpl((AppInfoApi) new TalabatAPIBuilder().createApi(AppInfoApi.class), getMutableConfigurationRemoteCoreLibApi().getMutableRepository(), getMoshi());
        AddressesDependencyProvider addressesDependencyProvider = AddressesDependencyProvider.INSTANCE;
        ChooseSavedAddressPresenter chooseSavedAddressPresenter = new ChooseSavedAddressPresenter(this, new AppInfoRepositoryImpl((CoroutineDispatcher) null, (CoroutineDispatcher) null, appInfoRemoteDataSourceImpl, addressesDependencyProvider.provideCustomerAddressesRepository(getTalabatFeatureFlag()), addressesDependencyProvider.provideCustomerRepository(this), new CustomerInfoRepositoryImpl((CoroutineDispatcher) null, new CustomerInfoLocalDataSourceImpl((Context) null, (Gson) null, 3, (DefaultConstructorMarker) null), new CustomerInfoRemoteDataSourceImpl((CustomerInfoApi) new TalabatAPIBuilder().createApi(CustomerInfoApi.class)), new ProCentralizationStatusWrapper(getSubscriptionsFeatureApi().getGetProCentralizationStatusUseCase(), getSubscriptionsFeatureApi().getSubscriptionsCustomerRepository()), 1, (DefaultConstructorMarker) null), getMutableConfigurationLocalCoreLibApi().getMutableRepository(), getMutableConfigurationRemoteCoreLibApi().getMutableLocationConfigurationRepository(), (AppInfoLocalDataSource) null, getPaymentConfigurationRepository(), getTalabatFeatureFlag(), 259, (DefaultConstructorMarker) null), getTalabatFeatureFlag(), getMutableConfigurationRemoteCoreLibApi().getLocationConfigurationRepository(), getMutableConfigurationLocalCoreLibApi().getMutableRepository());
        this.mChooseSavedAddressPresenter = chooseSavedAddressPresenter;
        chooseSavedAddressPresenter.updateReorder(this.isFromReOrder, this.reorderResId);
        IChooseSavedAddressPresenter iChooseSavedAddressPresenter = this.mChooseSavedAddressPresenter;
        if (iChooseSavedAddressPresenter != null) {
            iChooseSavedAddressPresenter.loadCustomerSavedAdddress(this.isLoadDeliveryAddressBasedOnVendor);
        }
        int i12 = R.id.deliver_to_current_location;
        ((RelativeLayout) _$_findCachedViewById(i12)).setVisibility(0);
        IChooseSavedAddressPresenter iChooseSavedAddressPresenter2 = this.mChooseSavedAddressPresenter;
        if (iChooseSavedAddressPresenter2 != null) {
            iChooseSavedAddressPresenter2.fetchCurrentLocation(this.isFetchingCurrentLocation);
        }
        if (this.isFetchingCurrentLocation) {
            this.geoLocationStatusTrack = "enable";
        }
        int i13 = R.id.address_title;
        ((TalabatTextView) _$_findCachedViewById(i13)).setAllCaps(false);
        ((TalabatTextView) _$_findCachedViewById(i13)).setTextColor(getResources().getColor(R.color.talabat_black));
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.saved_add_close);
        if (imageView != null) {
            imageView.setOnClickListener(new r5(this));
        }
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.deliver_diff_location);
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new s5(this));
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(i12);
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new t5(this));
        }
        ((RelativeLayout) _$_findCachedViewById(R.id.main_container)).setOnTouchListener(new ChooseSavedAddressScreen$initView$4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m9415initView$lambda0(ChooseSavedAddressScreen chooseSavedAddressScreen, View view) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        chooseSavedAddressScreen.setResult(0);
        chooseSavedAddressScreen.animateToHide();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m9416initView$lambda1(ChooseSavedAddressScreen chooseSavedAddressScreen, View view) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        chooseSavedAddressScreen.isInteractedWithDL = false;
        IChooseSavedAddressPresenter iChooseSavedAddressPresenter = chooseSavedAddressScreen.mChooseSavedAddressPresenter;
        if (iChooseSavedAddressPresenter != null) {
            iChooseSavedAddressPresenter.deliverTooDifferentLocation(chooseSavedAddressScreen.isIgnoreCurrentLocation, chooseSavedAddressScreen.isFromBrandOrReorder);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m9417initView$lambda2(ChooseSavedAddressScreen chooseSavedAddressScreen, View view) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        chooseSavedAddressScreen.isInteractedWithDL = true;
        if (Intrinsics.areEqual(((RelativeLayout) chooseSavedAddressScreen._$_findCachedViewById(R.id.deliver_to_current_location)).getTag(), (Object) 3)) {
            chooseSavedAddressScreen.changeCountryAlert(chooseSavedAddressScreen.changedCountryId, chooseSavedAddressScreen.countryName);
            return;
        }
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        chooseSavedAddressScreen.locationMethod = trackingUtils.getLocationMethodLocate();
        chooseSavedAddressScreen.deliveryAddressStatus = trackingUtils.getAddressMethodNew();
        AppTracker.onGeoLocationClicked(chooseSavedAddressScreen, chooseSavedAddressScreen.getScreenName(), chooseSavedAddressScreen.screenType(), chooseSavedAddressScreen.geoLocationStatusTrack);
        IChooseSavedAddressPresenter iChooseSavedAddressPresenter = chooseSavedAddressScreen.mChooseSavedAddressPresenter;
        if (iChooseSavedAddressPresenter != null) {
            iChooseSavedAddressPresenter.deliverToCurrentLocation(chooseSavedAddressScreen.isFromBrandOrReorder);
        }
    }

    private final void inject() {
        Application application = getApplication();
        if (application != null) {
            ApiContainer apiContainer = (ApiContainer) application;
            DaggerChooseSavedAddressScreenComponent.factory().create((CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (MutableConfigurationLocalCoreLibApi) apiContainer.getFeature(MutableConfigurationLocalCoreLibApi.class), (MutableConfigurationRemoteCoreLibApi) apiContainer.getFeature(MutableConfigurationRemoteCoreLibApi.class), (ParserCoreLibApi) apiContainer.getFeature(ParserCoreLibApi.class), (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class), (NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class)).inject(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    private final boolean isHomeScreenToFoodListDeeplinkEnabled() {
        return getTalabatFeatureFlag().getFeatureFlag(VendorListFeatureFlagsKeys.VENDORLIST_DEEP_LINK_NAVIGATION_HOF, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: listenForCurrentLocation$lambda-6  reason: not valid java name */
    public static final void m9418listenForCurrentLocation$lambda6(Ref.ObjectRef objectRef, ChooseSavedAddressScreen chooseSavedAddressScreen, LatLng latLng) {
        Double d11;
        Intrinsics.checkNotNullParameter(objectRef, "$currentLocation");
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        Double d12 = null;
        if (latLng != null) {
            d11 = Double.valueOf(latLng.latitude);
        } else {
            d11 = null;
        }
        if (latLng != null) {
            d12 = Double.valueOf(latLng.longitude);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d11);
        sb2.append(d12);
        Log.e("gotObserver2", sb2.toString());
        objectRef.element = latLng;
        if (latLng != null) {
            Intrinsics.checkNotNull(latLng);
            chooseSavedAddressScreen.convertCLToAddress(latLng);
        }
    }

    private final void navigateToFlutterFoodListDeeplink() {
        DeepLinkNavigator.DefaultImpls.navigateTo$default(getDeepLinkNavigator(), this, "talabat://?s=/food-list-organic", (Function0) null, 4, (Object) null);
    }

    private final void navigateToFlutterFoodListExplicitly(int i11) {
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
        String str = GlobalDataModel.SelectedAreaName;
        Intrinsics.checkNotNullExpressionValue(str, "SelectedAreaName");
        Navigator.DefaultImpls.navigateTo$default(navigator2, context, new FoodListFlutterScreen(new FoodListFlutterScreen.FoodListFlutterData(doubleValue, doubleValue2, valueOf, valueOf2, i11, str)), (Function1) null, 4, (Object) null);
    }

    private final void onLocationAttempted(ArrayList<Address> arrayList) {
        Address address;
        boolean z11;
        Integer num;
        String str = "N/A";
        try {
            GlobalDataModel.GEO_LOCATION_TRACKING.GEO_LOCATION_API_METHOD = str;
            if (arrayList != null) {
                int size = arrayList.size();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(size);
                str = sb2.toString();
            }
            String str2 = str;
            Integer num2 = null;
            if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                address = Customer.getInstance().getSelectedCustomerAddress();
            } else {
                address = null;
            }
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            if (address != null) {
                z11 = false;
            } else {
                z11 = true;
            }
            boolean z12 = z11;
            if (address != null) {
                num = Integer.valueOf(address.cityId);
            } else {
                num = null;
            }
            if (address != null) {
                num2 = Integer.valueOf(address.areaId);
            }
            Integer num3 = num2;
            String screenType = screenType();
            String str3 = AppTracker.NotAvail;
            try {
                AppTracker.onLocationAttempted(this, trackingUtils.getTrackingAddressObject(this, z12, address, num, num3, screenType, str3, str3, str3, str3, str3, str3, str3, str3, str3, str3, str3, str2, false, str3));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }

    private final void onLocationDialogAccepted(boolean z11) {
        String str;
        try {
            Context context = getContext();
            String screenType = screenType();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z11);
            String sb3 = sb2.toString();
            String locationPromptType = TrackingUtils.INSTANCE.getLocationPromptType();
            if (z11) {
                str = TrackingUtils.TrackingGpsStatus.Enabled.getValue();
            } else {
                str = TrackingUtils.TrackingGpsStatus.Disabled.getValue();
            }
            AppTracker.geolocationDialogueAccepted(context, ScreenNames.SCREEN_CHOOSE_SAVED_ADDRESS, screenType, sb3, locationPromptType, str);
        } catch (Exception unused) {
        }
    }

    private final void onTrackAddressErrorShown(String str) {
        try {
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            String screenType = screenType();
            String str2 = this.deliveryAddressStatus;
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
            String str = this.deliveryAddressStatus;
            String str2 = AppTracker.NotAvail;
            if (address2 != null) {
                z11 = false;
            } else {
                z11 = true;
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

    private final void onTrackGeoLocationRequested(Address address) {
        Integer num;
        String str;
        Address address2 = address;
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        GlobalDataModel.GEO_LOCATION_TRACKING.GEO_LOCATION_API_METHOD = trackingUtils.getApiMethod();
        if (TalabatUtils.isNullOrEmpty(this.geoAddressError)) {
            this.geoAddressError = this.geoLocationStatusTrack;
        }
        Integer num2 = null;
        if (address2 != null) {
            try {
                num = Integer.valueOf(address2.cityId);
            } catch (Exception unused) {
                return;
            }
        } else {
            num = null;
        }
        if (address2 != null) {
            num2 = Integer.valueOf(address2.areaId);
        }
        Integer num3 = num2;
        String screenType = screenType();
        String str2 = AppTracker.NotAvail;
        String screenName = getScreenName();
        String str3 = this.geoAddressError;
        String str4 = AppTracker.NotAvail;
        if (address2 != null) {
            str = "True";
        } else {
            str = "False";
        }
        try {
            try {
                AppTracker.onGeolocationRequested(this, trackingUtils.getTrackingAddressObject(this, false, address, num, num3, screenType, str2, screenName, str3, str4, str, this.locationAccuracy, str4, str4, str4, str4, str4, str4, false, str4));
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
        }
    }

    private final void openSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
        startActivityForResult(intent, 100);
    }

    private final void reDirectToReOrderCart() {
        if (!this.isInteractedWithDL) {
            HomeMapTemp.INSTANCE.setHomeMapRedirect(false, this);
        }
        Intent intent = new Intent();
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_ID, this.reorderId);
        setResult(-1, intent);
        finish();
    }

    private final void reInitiateLocation() {
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch2);
        if (!currentLocationFetch2.isLoactionReequestInitied()) {
            CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
            Intrinsics.checkNotNull(currentLocationFetch3);
            currentLocationFetch3.initLocationRequest(getContext(), CurrentLocHelper.INSTANCE.getIS_FROM_CL());
        }
        CurrentLocationFetch currentLocationFetch4 = this.currentLocationFetch;
        if (currentLocationFetch4 != null) {
            currentLocationFetch4.startLocationUpdates(this);
        }
    }

    private final void redirectMenu(int i11) {
        if (!this.isInteractedWithDL) {
            HomeMapTemp.INSTANCE.setHomeMapRedirect(false, this);
        }
        Intent intent = new Intent();
        intent.putExtra("DeliveryAreaBranchId", i11);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, this.isFromFanchiseRes);
        if (this.isFromFanchiseRes) {
            intent.putExtra(GlobalConstants.ExtraNames.RESET_PRE_BRANCH, true);
            intent.putExtra(GlobalConstants.ExtraNames.FRANCHISE_GRP_ID, this.franchiseGrpid);
        }
        setResult(-1, intent);
        finish();
    }

    private final void redirectToRestaurantListScreen(int i11) {
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_LOCATION_DELIVERY_TO_LIST, false, TalabatExperimentDataSourceStrategy.APPTIMIZE);
        boolean z11 = this.isFromHome;
        if (z11 && booleanVariant) {
            FilterEngine.resetFilter(false);
            if (isHomeScreenToFoodListDeeplinkEnabled()) {
                navigateToFlutterFoodListDeeplink();
            } else {
                navigateToFlutterFoodListExplicitly(i11);
            }
        } else if (this.isFromRL || (z11 && !booleanVariant)) {
            animateSlideTo(0.0f, (float) ((RelativeLayout) _$_findCachedViewById(R.id.content_view)).getHeight(), new ChooseSavedAddressScreen$redirectToRestaurantListScreen$1(this));
        } else if (isHomeScreenToFoodListDeeplinkEnabled()) {
            navigateToFlutterFoodListDeeplink();
        } else {
            navigateToFlutterFoodListExplicitly(i11);
        }
    }

    private final void redirecttoFreanchiseSelectionScreen(String str) {
        Intent intent = new Intent(this, FranchiseSelectionScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, true);
        intent.putExtra("location", str);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_RES_GRP_ID, this.franchiseGrpid);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, this.isFromFanchiseRes);
        intent.putExtra(GlobalConstants.ExtraNames.RESET_PRE_BRANCH, true);
        intent.addFlags(33554432);
        startActivity(intent);
        finish();
    }

    private final void resetAddressPref(Address address) {
        HomeMapTemp homeMapTemp;
        if (Customer.getInstance().getSelectedCustomerAddress() != null) {
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            Intrinsics.checkNotNull(selectedCustomerAddress);
            if (selectedCustomerAddress.areaId != address.areaId && (homeMapTemp = HomeMapTemp.INSTANCE) != null) {
                homeMapTemp.resetPref(this);
                return;
            }
            return;
        }
        HomeMapTemp homeMapTemp2 = HomeMapTemp.INSTANCE;
        if (homeMapTemp2 != null) {
            homeMapTemp2.resetPref(this);
        }
    }

    private final void resetCustomerBrandAddress() {
        if (getCustomerRepository().isLoggedIn()) {
            getCustomerRepository().resetBrandLocalAddress();
        }
    }

    private final String screenType() {
        if (this.isFromRL) {
            return "shop_list";
        }
        if (!this.isFromBrandOrReorder) {
            return "home";
        }
        if (this.isFromReOrder) {
            return ScreenNames.SCREEN_TYPE_REORDER;
        }
        return ScreenNames.SCREEN_TYPE_BRAND;
    }

    private final void selectedAddressNotDeliveringAlert(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private final void setCurrentLocAddress(Address address) {
        Double d11;
        GlobalDataModel.SelectedAreaId = address.areaId;
        GlobalDataModel.SelectedAreaName = address.areaName;
        int i11 = address.cityId;
        GlobalDataModel.SelectedCityId = i11;
        GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, getMutableConfigurationLocalCoreLibApi().getRepository(), getLocationConfigurationRepository());
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = 20.0f;
        GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION = 0;
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        homeMapTemp.setHomeMapLatLng(this.currentLocation, this);
        homeMapTemp.setHomeMapZoomeLevel(Float.valueOf(20.0f));
        homeMapTemp.setTempAreaId(address.areaId);
        String str = address.street;
        Intrinsics.checkNotNull(str);
        homeMapTemp.setStreetName(str);
        homeMapTemp.settempAddress(address);
        if (Customer.getInstance() != null) {
            Customer.getInstance().deselectCustomerAddress(this);
        }
        SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        LatLng latLng = this.currentLocation;
        Double d12 = null;
        if (latLng != null) {
            d11 = Double.valueOf(latLng.latitude);
        } else {
            d11 = null;
        }
        LatLng latLng2 = this.currentLocation;
        if (latLng2 != null) {
            d12 = Double.valueOf(latLng2.longitude);
        }
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_LOCATION, d11 + "," + d12);
        edit.putFloat(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ZOOM, 20.0f);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, address.areaId);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_STREET_NAME, address.street);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ADDRESS, storeTempAddress(address));
        edit.apply();
        if (this.isFromBrandOrReorder && !this.isFromReOrder) {
            resetCustomerBrandAddress();
        }
        Customer.getInstance().deselectCustomerAddress(this);
        homeMapTemp.setHomeMapRedirect(true, this);
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        talabatExperiment.setAttribute(FWFAttributes.LOCATION_COUNTRY, getLocationConfigurationRepository().config().getCountry().getThreeLetterCode(), TalabatExperimentDataSourceStrategy.APPTIMIZE);
        talabatExperiment.setAttribute(FWFAttributes.AREA_ID, String.valueOf(address.areaId));
    }

    /* access modifiers changed from: private */
    /* renamed from: showAreaSplitAlert$lambda-5  reason: not valid java name */
    public static final void m9419showAreaSplitAlert$lambda5(ChooseSavedAddressScreen chooseSavedAddressScreen, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        dialogInterface.dismiss();
        AppTracker.onAddressModificationShown(chooseSavedAddressScreen);
    }

    private final void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String string = getString(R.string.allow_app_location);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…tring.allow_app_location)");
        String string2 = getResources().getString(R.string.talabat_app_name);
        Intrinsics.checkNotNullExpressionValue(string2, "this.resources.getString….string.talabat_app_name)");
        builder.setTitle((CharSequence) StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, string2, false, 4, (Object) null));
        builder.setMessage((CharSequence) getString(R.string.enable_device_location_settings_title));
        builder.setPositiveButton((CharSequence) getString(R.string.enable_device_location_go_setting), (DialogInterface.OnClickListener) new p5(this));
        builder.setNegativeButton((CharSequence) getString(R.string.cancel), (DialogInterface.OnClickListener) new q5());
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showSettingsDialog$lambda-7  reason: not valid java name */
    public static final void m9420showSettingsDialog$lambda7(ChooseSavedAddressScreen chooseSavedAddressScreen, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressScreen, "this$0");
        dialogInterface.cancel();
        chooseSavedAddressScreen.openSettings();
    }

    /* access modifiers changed from: private */
    /* renamed from: showSettingsDialog$lambda-8  reason: not valid java name */
    public static final void m9421showSettingsDialog$lambda8(DialogInterface dialogInterface, int i11) {
        dialogInterface.cancel();
    }

    private final String storeTempAddress(Address address) {
        String str;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address);
        }
        Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(address)");
        return str;
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
        Intrinsics.checkNotNullParameter(permissionDeniedResponse, "response");
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

    public final void animateSlideTo(float f11, float f12, @Nullable SlideAnimationListener slideAnimationListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById(R.id.content_view), "translationY", new float[]{f11, f12});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new ChooseSavedAddressScreen$animateSlideTo$1(slideAnimationListener));
        ofFloat.addUpdateListener(new m5(this));
        ofFloat.start();
    }

    public final void clearCart(@Nullable Cart cart, @NotNull Address address) {
        Address address2;
        Intrinsics.checkNotNullParameter(address, "cstAddress");
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        Intrinsics.checkNotNull(cart);
        boolean z11 = cart.getRestaurant().isGlrEnabled;
        String str = cart.getRestaurant().f13873name + " - " + cart.getCartAreaName();
        if (getCustomerRepository().isLoggedIn()) {
            address2 = Customer.getInstance().getSelectedCustomerAddress();
        } else {
            address2 = null;
        }
        if (z11 && address2 != null) {
            str = cart.getRestaurant().f13873name + " - " + address2.profileName + "(" + address2.areaName + ")";
        }
        String string = getContext().getString(R.string.already_has_items_in_cart);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …ems_in_cart\n            )");
        String replace$default = StringsKt__StringsJVMKt.replace$default(string, "#", str, false, 4, (Object) null);
        builder.setTitle((int) R.string.clear_cart_alert_title);
        builder.setMessage((CharSequence) replace$default);
        builder.setPositiveButton((int) R.string.new_order, (DialogInterface.OnClickListener) new u5(this, address));
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void currentLocOutSideCountry(int i11) {
        if (i11 > 0) {
            ((RelativeLayout) _$_findCachedViewById(R.id.deliver_to_current_location)).setTag(3);
            for (Country next : getLocationConfigurationRepository().countries()) {
                if (i11 == next.getCountry().getCountryId()) {
                    this.countryName = next.getCountry().getCountryName();
                    this.changedCountryId = next.getCountry().getCountryId();
                }
            }
            String string = getContext().getString(R.string.change_country_dcl);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…tring.change_country_dcl)");
            String replace$default = StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, this.countryName, false, 4, (Object) null);
            ((ProgressBar) _$_findCachedViewById(R.id.deliver_current_location_progress)).setVisibility(8);
            ((TalabatTextView) _$_findCachedViewById(R.id.txt_current_loc_text)).setText(replace$default);
        }
    }

    public void deliverToCLRecived(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
        if (latLng.latitude <= 0.0d || latLng.longitude <= 0.0d) {
            unableToFindLocation(true);
            return;
        }
        fetchCurrentLocTxt();
        convertCLToAddress(latLng);
        this.currentLocation = latLng;
    }

    public void destroyPresenter() {
        this.mChooseSavedAddressPresenter = null;
    }

    public void fetchCurrentLocaion() {
        if (this.currentLocationFetch == null) {
            this.currentLocationFetch = new CurrentLocationFetch(this, this);
        }
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        if (currentLocationFetch2 != null) {
            currentLocationFetch2.initLocationRequest(getContext(), CurrentLocHelper.INSTANCE.getIS_FROM_CL());
        }
        CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
        Intrinsics.checkNotNull(currentLocationFetch3);
        currentLocationFetch3.fetchCurrentLocation();
    }

    public void forceToenableCurrentLocation() {
        enableClTxt();
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

    public final int getChangedCountryId() {
        return this.changedCountryId;
    }

    @NotNull
    public Context getContext() {
        return this;
    }

    @NotNull
    public final String getCountryName() {
        return this.countryName;
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
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @Nullable
    public final String getDeliveryAddressStatus() {
        return this.deliveryAddressStatus;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @Nullable
    public final String getLocationMethod() {
        return this.locationMethod;
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
    public final MutableConfigurationLocalCoreLibApi getMutableConfigurationLocalCoreLibApi() {
        MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2 = this.mutableConfigurationLocalCoreLibApi;
        if (mutableConfigurationLocalCoreLibApi2 != null) {
            return mutableConfigurationLocalCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mutableConfigurationLocalCoreLibApi");
        return null;
    }

    @NotNull
    public final MutableConfigurationRemoteCoreLibApi getMutableConfigurationRemoteCoreLibApi() {
        MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2 = this.mutableConfigurationRemoteCoreLibApi;
        if (mutableConfigurationRemoteCoreLibApi2 != null) {
            return mutableConfigurationRemoteCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mutableConfigurationRemoteCoreLibApi");
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

    @NotNull
    public String getScreenName() {
        return ScreenNames.SCREEN_CHOOSE_SAVED_ADDRESS;
    }

    @NotNull
    public final SubscriptionsFeatureApi getSubscriptionsFeatureApi() {
        SubscriptionsFeatureApi subscriptionsFeatureApi2 = this.subscriptionsFeatureApi;
        if (subscriptionsFeatureApi2 != null) {
            return subscriptionsFeatureApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFeatureApi");
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

    public final boolean isNeedToClearCart(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Cart.getSavedMcdCartAddress(this);
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            if (Cart.getInstance().getInforMapAddress() != null) {
                if (!TalabatUtils.isNullOrEmpty(Cart.getInstance().getInforMapAddress().grlid) && !Intrinsics.areEqual((Object) getCustomerRepository().getGlrId(address.f58343id), (Object) Cart.getInstance().getInforMapAddress().grlid)) {
                    return true;
                }
            } else if (TalabatUtils.isNullOrEmpty(Cart.getInstance().getCartSelectedGrlID()) || !Intrinsics.areEqual((Object) getCustomerRepository().getGlrId(address.f58343id), (Object) Cart.getInstance().getInforMapAddress().grlid)) {
                return true;
            }
        } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            if (Cart.getInstance().getMcdBhBlockAddress() == null) {
                return true;
            }
            if (!TalabatUtils.isNullOrEmpty(Cart.getInstance().getMcdBhBlockAddress().block) && !Intrinsics.areEqual((Object) getCustomerRepository().getBlock(address.f58343id), (Object) Cart.getInstance().getMcdBhBlockAddress().block)) {
                return true;
            }
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            return true;
        }
        return false;
    }

    public void isRefreshMap(boolean z11, @NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public void listenForCurrentLocation() {
        fetchCurrentLocTxt();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (GlobalDataModel.JSON.DeliverCurrentLocation.getValue() != null) {
            LatLng value = GlobalDataModel.JSON.DeliverCurrentLocation.getValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(value);
            Log.e("gotObserver1", sb2.toString());
            if (GlobalDataModel.JSON.DeliverCurrentLocation.getValue() != null) {
                T value2 = GlobalDataModel.JSON.DeliverCurrentLocation.getValue();
                objectRef.element = value2;
                if (value2 != null) {
                    convertCLToAddress((LatLng) value2);
                    return;
                }
                return;
            }
            return;
        }
        GlobalDataModel.JSON.DeliverCurrentLocation.observe(this, new l5(objectRef, this));
    }

    public void mapCurrentLocReceived(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 100) {
            enableLocFromSettings();
        }
        if (i12 == 0) {
            enableClTxt();
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCountryDataLoaded(@Nullable Integer num) {
        HomeMapTemp homeMapTemp;
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        FWFAttributes fWFAttributes = FWFAttributes.LOCATION_COUNTRY;
        String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
        Intrinsics.checkNotNullExpressionValue(selectedCountryIso, "getSelectedCountryIso()");
        talabatExperiment.setAttribute(fWFAttributes, selectedCountryIso, TalabatExperimentDataSourceStrategy.APPTIMIZE);
        stopLodingPopup();
        GlobalDataModel.DASHBOARDDATA.orderListReceived = false;
        if (GlobalDataModel.Apptimize.MapInFunnelEnabled && (homeMapTemp = HomeMapTemp.INSTANCE) != null) {
            homeMapTemp.resetPref(this);
            homeMapTemp.recentRecentLocation();
            if (getCustomerRepository().isLoggedIn() && Customer.getInstance().getSelectedCustomerAddress() != null) {
                Customer.getInstance().deselectCustomerAddress();
            }
        }
        GlobalDataModel.AD.countryChanged();
        FunWithFlags.updateSelectedCountry(getMutableConfigurationLocalCoreLibApi().getRepository().selectedCountry());
        startActivity(new Intent(this, HomeScreenActivity.class));
        AppTracker.onChangeCountryConfirmed(this);
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        String str = AppTracker.NotAvail;
        String selectedCountryIso2 = TalabatAdjust.getSelectedCountryIso();
        String str2 = AppTracker.NotAvail;
        String str3 = str2;
        String str4 = str2;
        AppTracker.onChangeCountrySelected(getContext(), trackingUtils.getTrackingAddressObject(this, true, (Address) null, (Integer) null, (Integer) null, str, str, str, str, selectedCountryIso2, str3, str2, str2, str4, str2, str2, str2, str2, true, str2));
        finish();
    }

    @ExperimentalStdlibApi
    public void onCreate(@Nullable Bundle bundle) {
        inject();
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.activity_choose_saved_address);
            getWindow().setLayout(-1, -1);
            if (getIntent() != null) {
                this.isFromRL = getIntent().getBooleanExtra("isFromRL", false);
                this.isFromHome = getIntent().getBooleanExtra("fromHome", false);
                this.isLoadDeliveryAddressBasedOnVendor = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_LOAD_DELIVERY_ADDRESS, false);
                this.isFromBrandOrReorder = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, false);
                this.isFromFanchiseRes = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, false);
                boolean booleanExtra = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER, false);
                this.isFromReOrder = booleanExtra;
                if (booleanExtra) {
                    String stringExtra = getIntent().getStringExtra(GlobalConstants.ExtraNames.RE_ORDER_ID);
                    String str = "";
                    if (stringExtra == null) {
                        stringExtra = str;
                    }
                    this.reorderId = stringExtra;
                    this.reorderResId = getIntent().getIntExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_ID, 0);
                    String stringExtra2 = getIntent().getStringExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME);
                    if (stringExtra2 != null) {
                        str = stringExtra2;
                    }
                    this.reorderResName = str;
                }
                this.isFetchingCurrentLocation = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FETCHING_CL, false);
                this.isIgnoreSavedLoc = getIntent().getBooleanExtra("isIgnoreSavedLoc", false);
            }
            hideSystemUI();
            initView();
        } catch (Exception unused) {
            finish();
        }
    }

    public void onCurrentLocationReceived(@Nullable LatLng latLng, boolean z11, float f11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f11);
        this.locationAccuracy = sb2.toString();
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull LatLng latLng, float f11) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
        CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
        if (currentLocationFetch2 != null) {
            currentLocationFetch2.startLocationUpdates(this);
        }
    }

    public void onDeliverHereClicked() {
    }

    public void onError() {
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
        onLocationDialogAccepted(z11);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        int i11 = R.id.content_view;
        ViewGroup.LayoutParams layoutParams = ((RelativeLayout) _$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(12);
            ((RelativeLayout) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
            Log.e("onResume Fetch-----", "onResumeFetch0");
            if (this.currentLocationFetch != null) {
                Log.e("onResume Fetch-----", "onResumeFetch1");
                CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
                Intrinsics.checkNotNull(currentLocationFetch2);
                if (currentLocationFetch2.userAllowedAllLocationPermissions(this)) {
                    fetchCurrentLocTxt();
                    reInitiateLocation();
                    return;
                }
                enableClTxt();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public void onSavedAddressClicked(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "cstAddress");
        this.isInteractedWithDL = false;
        if (!this.isFromBrandOrReorder) {
            resetAddressPref(address);
        }
        AppTracker.onActionSheetAddressSelected(this, address);
        IChooseSavedAddressPresenter iChooseSavedAddressPresenter = this.mChooseSavedAddressPresenter;
        if (iChooseSavedAddressPresenter != null) {
            iChooseSavedAddressPresenter.savedAddressSelected(address);
        }
    }

    public void redirectMapScreen(boolean z11, @NotNull String str, int i11, boolean z12) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "UserSelectedAddress");
        CurrentLocationFetch currentLocationFetch2 = new CurrentLocationFetch(this, this);
        this.currentLocationFetch = currentLocationFetch2;
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
        LatLng areaCenterLatLg = HomeMapUtils.INSTANCE.areaCenterLatLg(i11, getLocationConfigurationRepository());
        if (areaCenterLatLg != null) {
            str2 = areaCenterLatLg.latitude + "," + areaCenterLatLg.longitude;
        } else {
            str2 = "";
        }
        Intent intent = new Intent(this, HomeScreenMap.class);
        intent.putExtra("isIgnoreCurrentLocation", z11);
        intent.putExtra("UserSelectedAddress", str);
        intent.putExtra("areaLatLng", str2);
        intent.putExtra("isUserSelectedAddressAreaId", i11);
        intent.putExtra("isIgnoreSavedLoc", this.isIgnoreSavedLoc);
        intent.putExtra("is_show_map_search", true);
        intent.putExtra("is_show_map_search", z12);
        boolean z13 = this.isFromHome;
        if (z13) {
            intent.putExtra("fromHome", z13);
            intent.addFlags(33554432);
        } else {
            boolean z14 = this.isFromRL;
            if (z14) {
                intent.putExtra("fromRL", z14);
                intent.addFlags(33554432);
            } else if (this.isFromBrandOrReorder) {
                intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, true);
                intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, this.isFromFanchiseRes);
                boolean z15 = this.isFromReOrder;
                if (z15) {
                    intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER, z15);
                    intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_ID, this.reorderId);
                    intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_ID, this.reorderId);
                    intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_ID, this.reorderResId);
                    intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME, this.reorderResName);
                }
                intent.addFlags(33554432);
            }
        }
        GlobalDataModel.GEO_LOCATION_TRACKING.ADDRESS_STATUS = TrackingUtils.INSTANCE.getAddressMethodNew();
        startActivity(intent);
        finish();
    }

    public void redirectToListingFromDCL(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "result");
        BrandReorderRedirectionDL(address);
    }

    public void reverseBrachIdReceived(int i11, @NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        BrandRedirection(i11, address);
    }

    public void reverseBrachIdReceivedFromDL(int i11, @NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "reverseAddress");
        this.branchIdDl = i11;
        BrandReorderRedirectionDL(address);
    }

    public void reverserAddressReceived(@Nullable Address address) {
        String str;
        boolean z11;
        String str2;
        String str3;
        boolean z12;
        String str4;
        boolean z13;
        String str5;
        boolean z14;
        boolean z15;
        String str6;
        boolean z16;
        String str7;
        boolean z17 = true;
        ((RelativeLayout) _$_findCachedViewById(R.id.deliver_to_current_location)).setTag(1);
        this.isCDLReverseGeoReceived = true;
        String str8 = null;
        if (address != null) {
            str = address.extraDirections;
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str2 = "";
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
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            if (str2 == null || str2.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (address != null) {
                    str7 = address.street;
                } else {
                    str7 = null;
                }
                str2 = str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str7;
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
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            if (str2 == null || str2.length() == 0) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (!z15) {
                if (address != null) {
                    str6 = address.block;
                } else {
                    str6 = null;
                }
                str2 = str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str6;
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
            z14 = true;
        } else {
            z14 = false;
        }
        if (!z14) {
            if (!(str2 == null || str2.length() == 0)) {
                z17 = false;
            }
            if (!z17) {
                if (address != null) {
                    str8 = address.areaName;
                }
                str8 = str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str8;
            } else if (address != null) {
                str8 = address.areaName;
            }
            str2 = str8;
        }
        ((TalabatTextView) _$_findCachedViewById(R.id.txt_current_loc_text)).setText(str2);
        ((ProgressBar) _$_findCachedViewById(R.id.deliver_current_location_progress)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.deliver_current_location_arrow)).setVisibility(4);
    }

    public void selectAddress(@NotNull Address address) {
        String str;
        Intrinsics.checkNotNullParameter(address, "cstAddress");
        if (address.isAreaSplit) {
            String str2 = address.areaName;
            if (str2 == null) {
                str2 = "";
            }
            showAreaSplitAlert(str2);
        } else if (address.latitude > 0.0d || address.longitude > 0.0d) {
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            this.deliveryAddressStatus = trackingUtils.getAddressMethodSaved();
            this.locationMethod = trackingUtils.getAddressMethodSaved();
            Cart instance = Cart.getInstance();
            if (!instance.hasItems()) {
                ChooseAreaAndAddress(address);
            } else if (instance.getCartAreaId() == address.areaId) {
                if (instance.getRestaurant().isGlrEnabled) {
                    if (isNeedToClearCart(address)) {
                        clearCart(instance, address);
                    } else {
                        ChooseAreaAndAddress(address);
                    }
                } else if (TalabatUtils.isNullOrEmpty(Customer.getInstance().getSelectedCustomerAddressId())) {
                    clearCart(instance, address);
                } else if (Customer.getInstance().getSelectedCustomerAddressId().equals(address.f58343id)) {
                    ChooseAreaAndAddress(address);
                } else {
                    clearCart(instance, address);
                }
            } else if (this.isFromBrandOrReorder) {
                ChooseAreaAndAddress(address);
            } else {
                clearCart(instance, address);
            }
        } else {
            TrackingUtils trackingUtils2 = TrackingUtils.INSTANCE;
            GlobalDataModel.GEO_LOCATION_TRACKING.ADDRESS_STATUS = trackingUtils2.getAddressMethodSaved();
            this.deliveryAddressStatus = trackingUtils2.getAddressMethodNew();
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) address);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) address);
            }
            Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(cstAddress)");
            redirectMapScreen(true, str, address.areaId, false);
        }
    }

    public final void setAnimation(@Nullable AnimationSet animationSet) {
        this.animation = animationSet;
    }

    public final void setAppVersionProvider(@NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "<set-?>");
        this.appVersionProvider = appVersionProvider2;
    }

    public final void setChangedCountryId(int i11) {
        this.changedCountryId = i11;
    }

    public final void setCountryName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryName = str;
    }

    public final void setCurrentLocationFetch(@Nullable CurrentLocationFetch currentLocationFetch2) {
        this.currentLocationFetch = currentLocationFetch2;
    }

    public final void setCustomerRepository(@NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(customerRepository2, "<set-?>");
        this.customerRepository = customerRepository2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setDeliveryAddressStatus(@Nullable String str) {
        this.deliveryAddressStatus = str;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setLocationMethod(@Nullable String str) {
        this.locationMethod = str;
    }

    public final void setMoshi(@NotNull Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "<set-?>");
        this.moshi = moshi2;
    }

    public final void setMutableConfigurationLocalCoreLibApi(@NotNull MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2) {
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalCoreLibApi2, "<set-?>");
        this.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi2;
    }

    public final void setMutableConfigurationRemoteCoreLibApi(@NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteCoreLibApi2, "<set-?>");
        this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setPaymentConfigurationRepository(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "<set-?>");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }

    public final void setPopupWindow(@Nullable Dialog dialog) {
        this.popupWindow = dialog;
    }

    public final void setSubscriptionsFeatureApi(@NotNull SubscriptionsFeatureApi subscriptionsFeatureApi2) {
        Intrinsics.checkNotNullParameter(subscriptionsFeatureApi2, "<set-?>");
        this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void showAreaSplitAlert(@NotNull String str) {
        int i11;
        Intrinsics.checkNotNullParameter(str, "areaName");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getString(R.string.update_area));
        if (getCustomerRepository().isLoggedIn()) {
            i11 = R.string.area_split_message;
        } else {
            i11 = R.string.area_split_message_guest;
        }
        String string = getString(i11);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …          }\n            )");
        builder.setMessage((CharSequence) StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, str, false, 4, (Object) null));
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new o5(this));
        builder.setCancelable(false);
        builder.show();
    }

    public void showBrandNotDeliverHere(@Nullable String str, boolean z11) {
        this.geoAddressError = str;
        if (z11) {
            DeliverCLNotDeliverable(true);
        } else {
            selectedAddressNotDeliveringAlert(str);
        }
    }

    public void showCustomerSavedAddress(@NotNull ArrayList<Address> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "customerAddress");
        AppTracker.onActionSheetShown(this, arrayList.size());
        ((RecyclerView) _$_findCachedViewById(R.id.saved_address_list)).setAdapter(new ChooseSavedAddressListAdapter(this, arrayList, this, this.isLoadDeliveryAddressBasedOnVendor));
        onLocationAttempted(arrayList);
    }

    public boolean showRedirectLoading() {
        return Intrinsics.areEqual(((RelativeLayout) _$_findCachedViewById(R.id.deliver_to_current_location)).getTag(), (Object) 1);
    }

    public void unableToFindLocation(boolean z11) {
        this.geoAddressError = getResources().getString(R.string.unable_to_detect_location);
        ((TalabatTextView) _$_findCachedViewById(R.id.txt_current_loc_text)).setText(this.geoAddressError);
        if (z11) {
            onTrackGeoLocationRequested((Address) null);
            onTrackAddressErrorShown(this.geoAddressError);
        }
    }

    public void updateApiErrorMsg(@Nullable String str) {
        this.apiErrorMsg = str;
    }

    public void updateIsFrachiseRestaurant(boolean z11) {
        this.isFromFanchiseRes = z11;
    }

    public void updateIsIGnoreSavedLoc() {
        this.isIgnoreSavedLoc = true;
    }

    public void updateRestGrpId(int i11) {
        this.franchiseGrpid = i11;
    }

    @Nullable
    public IChooseSavedAddressPresenter getPresenter() {
        return this.mChooseSavedAddressPresenter;
    }
}
