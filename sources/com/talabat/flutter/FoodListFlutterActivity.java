package com.talabat.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.fwfprojectskeys.domain.projects.adex.AdExExperimentsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.gem.FlutterGemCollectionScreen;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionScreen;
import com.talabat.core.navigation.domain.screen.gem.GemOffersScreen;
import com.talabat.core.navigation.domain.screen.home.HomeScreen;
import com.talabat.core.navigation.domain.screen.pickup.PickupFoodListScreen;
import com.talabat.core.navigation.domain.screen.restaurant.FoodListFlutterScreen;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.flutter.channels.FoodListMethodCallHandler;
import com.talabat.flutter.channels.IFoodListMethodCallback;
import com.talabat.flutter.channels.IInlineAdsMethodCallback;
import com.talabat.flutter.channels.InlineAdsMethodCallHandler;
import com.talabat.flutter.di.DaggerFoodListFlutterActivityComponent;
import com.talabat.flutter.utils.FlutterRoutes;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.gem.adapters.flutter.channel.GemMethodChannel;
import com.talabat.gem.adapters.flutter.channel.IGemMethodCallback;
import com.talabat.observability.performance.PerformanceTracker;
import com.talabat.observability.performance.Traces;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.GemFlutterEngineBinder;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorController;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorModel;
import com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001DB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007H\u0016J\b\u00101\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020/2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020\u000fH\u0016J\b\u00107\u001a\u00020/H\u0016J\b\u00108\u001a\u00020/H\u0016J\b\u00109\u001a\u00020/H\u0016J\u0012\u0010:\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\b\u0010=\u001a\u00020/H\u0014J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020/2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010B\u001a\u00020/2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010C\u001a\u00020/2\u0006\u0010?\u001a\u00020@H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lcom/talabat/flutter/FoodListFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/flutter/channels/IFoodListMethodCallback;", "Lcom/talabat/flutter/channels/IInlineAdsMethodCallback;", "Lcom/talabat/gem/adapters/flutter/channel/IGemMethodCallback;", "()V", "areaId", "", "getAreaId", "()Ljava/lang/String;", "areaName", "getAreaName", "cityId", "getCityId", "countryId", "", "getCountryId", "()I", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "extraFromToggle", "foodListMethodCallHandler", "Lcom/talabat/flutter/channels/FoodListMethodCallHandler;", "gemMethodChannel", "Lcom/talabat/gem/adapters/flutter/channel/GemMethodChannel;", "latitude", "", "getLatitude", "()D", "longitude", "getLongitude", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "getContext", "Landroid/content/Context;", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "navigateToCollection", "", "deeplink", "navigateToGemCollection", "navigateToGemPopup", "isFromFlutterHoF", "", "navigateToMenu", "branchId", "navigateToPickup", "navigateToSearch", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setUpCartChannel", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpExtraChannels", "setUpGemChannel", "setUpInlineAdChannel", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoodListFlutterActivity extends TalabatFlutterFragmentActivity implements IFoodListMethodCallback, IInlineAdsMethodCallback, IGemMethodCallback {
    @NotNull
    public static final String ARG_AREA_ID = "areaId";
    @NotNull
    public static final String ARG_AREA_NAME = "areaName";
    @NotNull
    public static final String ARG_CITY_ID = "cityId";
    @NotNull
    public static final String ARG_COUNTRY_ID = "countryId";
    @NotNull
    public static final String CONTROL_VARIANT = "Control";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_LATITUDE = "latitude";
    @NotNull
    public static final String EXTRA_LONGITUDE = "longitude";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @NotNull
    private final String extraFromToggle;
    @Nullable
    private FoodListMethodCallHandler foodListMethodCallHandler;
    private GemMethodChannel gemMethodChannel;
    @Inject
    public Navigator navigator;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/flutter/FoodListFlutterActivity$Companion;", "", "()V", "ARG_AREA_ID", "", "ARG_AREA_NAME", "ARG_CITY_ID", "ARG_COUNTRY_ID", "CONTROL_VARIANT", "EXTRA_LATITUDE", "EXTRA_LONGITUDE", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FoodListFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
        this.extraFromToggle = TalabatCommonNavigationActions.EXTRA_FROM_TOGGLE;
    }

    private final String getAreaId() {
        String str;
        Bundle extras;
        String string;
        FoodListFlutterScreen.FoodListFlutterData foodListFlutterData;
        Intent intent = getIntent();
        String str2 = "";
        if (intent == null || (foodListFlutterData = (FoodListFlutterScreen.FoodListFlutterData) intent.getParcelableExtra("navigatorData")) == null || (str = foodListFlutterData.getAreaId()) == null) {
            str = str2;
        }
        if (!getIntent().hasExtra("areaId")) {
            return str;
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (extras = intent2.getExtras()) == null || (string = extras.getString("areaId")) == null)) {
            str2 = string;
        }
        return str2;
    }

    private final String getAreaName() {
        String str;
        Bundle extras;
        String string;
        FoodListFlutterScreen.FoodListFlutterData foodListFlutterData;
        Intent intent = getIntent();
        String str2 = "";
        if (intent == null || (foodListFlutterData = (FoodListFlutterScreen.FoodListFlutterData) intent.getParcelableExtra("navigatorData")) == null || (str = foodListFlutterData.getAreaName()) == null) {
            str = str2;
        }
        if (!getIntent().hasExtra("areaName")) {
            return str;
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (extras = intent2.getExtras()) == null || (string = extras.getString("areaName")) == null)) {
            str2 = string;
        }
        return str2;
    }

    private final String getCityId() {
        String str;
        Bundle extras;
        String string;
        FoodListFlutterScreen.FoodListFlutterData foodListFlutterData;
        Intent intent = getIntent();
        String str2 = "";
        if (intent == null || (foodListFlutterData = (FoodListFlutterScreen.FoodListFlutterData) intent.getParcelableExtra("navigatorData")) == null || (str = foodListFlutterData.getCityId()) == null) {
            str = str2;
        }
        if (!getIntent().hasExtra("cityId")) {
            return str;
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (extras = intent2.getExtras()) == null || (string = extras.getString("cityId")) == null)) {
            str2 = string;
        }
        return str2;
    }

    private final int getCountryId() {
        int i11;
        Bundle extras;
        FoodListFlutterScreen.FoodListFlutterData foodListFlutterData;
        Intent intent = getIntent();
        if (intent == null || (foodListFlutterData = (FoodListFlutterScreen.FoodListFlutterData) intent.getParcelableExtra("navigatorData")) == null) {
            i11 = 0;
        } else {
            i11 = foodListFlutterData.getCountryId();
        }
        if (!getIntent().hasExtra("countryId")) {
            return i11;
        }
        Intent intent2 = getIntent();
        if (intent2 == null || (extras = intent2.getExtras()) == null) {
            return 0;
        }
        return extras.getInt("countryId");
    }

    private final double getLatitude() {
        double d11;
        Bundle extras;
        FoodListFlutterScreen.FoodListFlutterData foodListFlutterData;
        Intent intent = getIntent();
        if (intent == null || (foodListFlutterData = (FoodListFlutterScreen.FoodListFlutterData) intent.getParcelableExtra("navigatorData")) == null) {
            d11 = 0.0d;
        } else {
            d11 = foodListFlutterData.getLatitude();
        }
        if (!getIntent().hasExtra("latitude")) {
            return d11;
        }
        Intent intent2 = getIntent();
        if (intent2 == null || (extras = intent2.getExtras()) == null) {
            return 0.0d;
        }
        return extras.getDouble("latitude");
    }

    private final double getLongitude() {
        double d11;
        Bundle extras;
        FoodListFlutterScreen.FoodListFlutterData foodListFlutterData;
        Intent intent = getIntent();
        if (intent == null || (foodListFlutterData = (FoodListFlutterScreen.FoodListFlutterData) intent.getParcelableExtra("navigatorData")) == null) {
            d11 = 0.0d;
        } else {
            d11 = foodListFlutterData.getLongitude();
        }
        if (!getIntent().hasExtra("longitude")) {
            return d11;
        }
        Intent intent2 = getIntent();
        if (intent2 == null || (extras = intent2.getExtras()) == null) {
            return 0.0d;
        }
        return extras.getDouble("longitude");
    }

    private final void setUpCartChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-cart").setMethodCallHandler(new CartMethodChannel(this));
    }

    private final void setUpGemChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/gem");
        GemMethodChannel gemMethodChannel2 = new GemMethodChannel();
        this.gemMethodChannel = gemMethodChannel2;
        methodChannel.setMethodCallHandler(gemMethodChannel2);
        GemMethodChannel gemMethodChannel3 = this.gemMethodChannel;
        GemMethodChannel gemMethodChannel4 = null;
        if (gemMethodChannel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gemMethodChannel");
            gemMethodChannel3 = null;
        }
        gemMethodChannel3.setCallback(this);
        GemMethodChannel gemMethodChannel5 = this.gemMethodChannel;
        if (gemMethodChannel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gemMethodChannel");
        } else {
            gemMethodChannel4 = gemMethodChannel5;
        }
        gemMethodChannel4.setShouldUseFixedAmountText(true);
        new GemFlutterEngineBinder(methodChannel).accept((FragmentActivity) this);
    }

    private final void setUpInlineAdChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.INLINE_ADS_CHANNEL);
        InlineAdsMethodCallHandler inlineAdsMethodCallHandler = new InlineAdsMethodCallHandler();
        inlineAdsMethodCallHandler.setCallback(this);
        methodChannel.setMethodCallHandler(inlineAdsMethodCallHandler);
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

    @NotNull
    public Context getContext() {
        return this;
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
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.FOOD_LIST_SCREEN;
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
    public String getRoute() {
        return FlutterRoutes.FOOD_LIST_ROUTE;
    }

    public void navigateToCollection(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel(SdSquadActions.ACTION_FLUTTER_COLLECTION_ACTIVITY, (Bundle) null, new FoodListFlutterActivity$navigateToCollection$model$1(str), 2, (DefaultConstructorMarker) null));
    }

    public void navigateToGemCollection() {
        if (Intrinsics.areEqual((Object) getStringVariant(AdExExperimentsKeys.SHOW_FLUTTER_GEM_COLLECTION, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control")) {
            Navigator.DefaultImpls.navigateTo$default(getNavigator(), this, new GemCollectionScreen(new GemCollectionScreen.GemCollectionData(GemCollectionEntrypoint.FOOD_LIST)), (Function1) null, 4, (Object) null);
            return;
        }
        Navigator.DefaultImpls.navigateTo$default(getNavigator(), this, new FlutterGemCollectionScreen(new FlutterGemCollectionScreen.FlutterGemCollectionData(GemCollectionEntrypoint.FOOD_LIST)), (Function1) null, 4, (Object) null);
    }

    public void navigateToGemPopup(boolean z11) {
        Navigator.DefaultImpls.navigateTo$default(getNavigator(), this, new GemOffersScreen(new GemOffersScreen.GemOffersData(z11)), (Function1) null, 4, (Object) null);
    }

    public void navigateToMenu(int i11) {
        MenuNavigatorController.INSTANCE.navigateToMenu(this, new MenuNavigatorModel(i11, "rider", "channel", (Boolean) null, (Integer) null, 24, (DefaultConstructorMarker) null), (ITalabatFeatureFlag) null, getDeepLinkNavigator(), getNavigator());
    }

    public void navigateToPickup() {
        getNavigator().navigateTo(this, new PickupFoodListScreen(new PickupFoodListScreen.PickupFoodListData(this.extraFromToggle)), FoodListFlutterActivity$navigateToPickup$1.INSTANCE);
    }

    public void navigateToSearch() {
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, new NavigatorModel("com.talabat.VendorListSearchFlutterActivity", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
    }

    public void onBackPressed() {
        if (isTaskRoot()) {
            getNavigator().navigateTo(this, new HomeScreen(new HomeScreen.HomeScreenData((HomeScreen.NavigationTab) null, false, 3, (DefaultConstructorMarker) null)), FoodListFlutterActivity$onBackPressed$1.INSTANCE);
        }
        finish();
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        PerformanceTracker.INSTANCE.startTrace(Traces.FOOD_LIST_SCREEN_START_TIME);
        DaggerFoodListFlutterActivityComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class), LifecycleOwnerKt.getLifecycleScope(this), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
    }

    public void onDestroy() {
        GemMethodChannel gemMethodChannel2 = this.gemMethodChannel;
        if (gemMethodChannel2 != null) {
            if (gemMethodChannel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gemMethodChannel");
                gemMethodChannel2 = null;
            }
            gemMethodChannel2.clearDisposable();
        }
        super.onDestroy();
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        FoodListMethodCallHandler foodListMethodCallHandler2 = new FoodListMethodCallHandler(!SharedPreferencesManager.getInstance(this).isCardViewFavStyle(Boolean.FALSE), getLatitude(), getLongitude(), getAreaId(), getCityId(), getCountryId(), getAreaName());
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.FOOD_LIST_CHANNEL);
        foodListMethodCallHandler2.setCallback(this);
        methodChannel.setMethodCallHandler(foodListMethodCallHandler2);
        this.foodListMethodCallHandler = foodListMethodCallHandler2;
        setUpInlineAdChannel(flutterEngine);
        setUpCartChannel(flutterEngine);
        setUpGemChannel(flutterEngine);
    }
}
