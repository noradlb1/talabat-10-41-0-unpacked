package com.talabat.flutter.groceryhome.presentation.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.grocery.GroceryHomeScreen;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.activecarts.domain.model.BasketType;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.model.DarkstoreNavigationType;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.flutter.channels.VendorListSearchMethodChannel;
import com.talabat.flutter.groceryhome.di.DaggerGroceryHomeComponent;
import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandler;
import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandlerFactory;
import com.talabat.flutter.utils.FlutterRoutes;
import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.gem.adapters.flutter.channel.GemMethodChannel;
import com.talabat.home.HomeScreenActivity;
import com.talabat.search.domain.callback.SearchMethodHandlerCallback;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.GemFlutterEngineBinder;
import com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel;
import datamodels.Restaurant;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0013H\u0002J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0016J\u0013\u00102\u001a\b\u0012\u0004\u0012\u0002000(H\u0016¢\u0006\u0002\u00103J\b\u00104\u001a\u00020%H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020%H\u0016J\u0010\u00109\u001a\u00020%2\u0006\u00106\u001a\u000207H\u0016J\b\u0010:\u001a\u00020%H\u0016J\b\u0010;\u001a\u00020%H\u0016J\u0012\u0010<\u001a\u00020%2\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\b\u0010?\u001a\u00020%H\u0014J \u0010@\u001a\u00020%2\u0006\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020,H\u0016J\u0010\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010H\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010I\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010J\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010K\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006L"}, d2 = {"Lcom/talabat/flutter/groceryhome/presentation/activity/GroceryHomeFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/search/domain/callback/SearchMethodHandlerCallback;", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler$Callback;", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler$MethodHandlerCallback;", "()V", "activeCartsMethodCallHandler", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;", "getActiveCartsMethodCallHandler", "()Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;", "setActiveCartsMethodCallHandler", "(Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;)V", "darkstoresNavigator", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "getDarkstoresNavigator", "()Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "setDarkstoresNavigator", "(Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;)V", "groceryHomeMethodHandler", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler;", "getGroceryHomeMethodHandler", "()Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler;", "groceryHomeMethodHandler$delegate", "Lkotlin/Lazy;", "groceryHomeMethodHandlerFactory", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerFactory;", "getGroceryHomeMethodHandlerFactory", "()Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerFactory;", "setGroceryHomeMethodHandlerFactory", "(Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerFactory;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "backToHomeScreen", "", "createGroceryHomeMethodHandler", "getAvailableVertical", "", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "()[Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "getRoute", "", "getScreenData", "Lcom/talabat/core/navigation/domain/screen/grocery/GroceryHomeScreen$GroceryHomeData;", "getSelectedCollectionId", "", "getSelectedCuisine", "getSelectedFliterIds", "()[Ljava/lang/Integer;", "injectDependencies", "navigateToCart", "restaurant", "Ldatamodels/Restaurant;", "navigateToFoodBasket", "navigateToQcommerceBasket", "onBackPressed", "onBackPressedFromFlutter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNavigationToLifestyleProducts", "vendor", "swimlaneId", "missionName", "setUpActiveCartsMethodChannel", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpExtraChannels", "setUpFoodCartChannel", "setUpGemChannel", "setUpGroceryHomeChannel", "setUpSearchChannel", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryHomeFlutterActivity extends TalabatFlutterFragmentActivity implements SearchMethodHandlerCallback, GroceryHomeMethodHandler.Callback, ActiveCartsMethodCallHandler.MethodHandlerCallback {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ActiveCartsMethodCallHandler activeCartsMethodCallHandler;
    @Inject
    public DarkstoresNavigator darkstoresNavigator;
    @NotNull
    private final Lazy groceryHomeMethodHandler$delegate;
    @Inject
    public GroceryHomeMethodHandlerFactory groceryHomeMethodHandlerFactory;
    @Inject
    public Navigator navigator;

    public GroceryHomeFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
        this.groceryHomeMethodHandler$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new GroceryHomeFlutterActivity$groceryHomeMethodHandler$2(this));
    }

    private final void backToHomeScreen() {
        if (isTaskRoot()) {
            startActivity(new Intent(this, HomeScreenActivity.class));
            finish();
            return;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: private */
    public final GroceryHomeMethodHandler createGroceryHomeMethodHandler() {
        Bundle bundle;
        ArrayList<Integer> arrayList;
        int i11;
        GroceryHomeScreen.GroceryHomeData screenData = getScreenData();
        if (screenData != null) {
            bundle = screenData.getDeepLinkBundle();
        } else {
            bundle = null;
        }
        if (screenData == null || (arrayList = screenData.getVerticalIds()) == null) {
            arrayList = new ArrayList<>();
        }
        if (screenData != null) {
            i11 = screenData.getShopType();
        } else {
            i11 = 0;
        }
        return getGroceryHomeMethodHandlerFactory().create(bundle, arrayList, i11, this);
    }

    private final GroceryHomeMethodHandler getGroceryHomeMethodHandler() {
        return (GroceryHomeMethodHandler) this.groceryHomeMethodHandler$delegate.getValue();
    }

    private final GroceryHomeScreen.GroceryHomeData getScreenData() {
        GroceryHomeScreen.GroceryHomeData groceryHomeData;
        Bundle bundle;
        Bundle bundle2;
        ArrayList<Integer> arrayList;
        Object obj;
        Intent intent = getIntent();
        Integer num = null;
        if (intent != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) intent.getParcelableExtra("navigatorData", GroceryHomeScreen.GroceryHomeData.class);
            } else {
                Parcelable parcelableExtra = intent.getParcelableExtra("navigatorData");
                if (!(parcelableExtra instanceof GroceryHomeScreen.GroceryHomeData)) {
                    parcelableExtra = null;
                }
                obj = (GroceryHomeScreen.GroceryHomeData) parcelableExtra;
            }
            groceryHomeData = (GroceryHomeScreen.GroceryHomeData) obj;
        } else {
            groceryHomeData = null;
        }
        if (groceryHomeData != null) {
            return groceryHomeData;
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            bundle = intent2.getExtras();
        } else {
            bundle = null;
        }
        if (bundle == null || (bundle2 = bundle.getBundle("deeplink")) == null) {
            bundle2 = new Bundle();
        }
        Intrinsics.checkNotNullExpressionValue(bundle2, "extras?.getBundle(SdSqua…ARG_DEEPLINK) ?: Bundle()");
        if (bundle != null) {
            arrayList = bundle.getIntegerArrayList("verticalIds");
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt(SdSquadActions.ARG_TILE_ID));
        }
        return new GroceryHomeScreen.GroceryHomeData(IntKt.orZero(num), "grocery", arrayList, bundle2);
    }

    private final void injectDependencies() {
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Activity) this);
        DaggerGroceryHomeComponent.factory().create((DarkstoresFeatureApi) apiContainer.getFeature(DarkstoresFeatureApi.class), (ActiveCartsApi) apiContainer.getFeature(ActiveCartsApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (ExperimentCoreLibApi) apiContainer.getFeature(ExperimentCoreLibApi.class), (DispatcherCoreLibApi) apiContainer.getFeature(DispatcherCoreLibApi.class), (ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class)).inject(this);
    }

    private final void navigateToCart(Restaurant restaurant) {
        DarkstoresNavigator.DefaultImpls.navigateToDarkStore$default(getDarkstoresNavigator(), this, restaurant, Integer.valueOf(DarkstoreNavigationType.CART.getType()), (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 4080, (Object) null);
    }

    private final void setUpActiveCartsMethodChannel(FlutterEngine flutterEngine) {
        getActiveCartsMethodCallHandler().setUp(flutterEngine, this, SetsKt__SetsJVMKt.setOf(BasketType.QCOMMERCE));
    }

    private final void setUpFoodCartChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-cart").setMethodCallHandler(new CartMethodChannel(this));
    }

    private final void setUpGemChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/gem");
        methodChannel.setMethodCallHandler(new GemMethodChannel());
        new GemFlutterEngineBinder(methodChannel).accept((FragmentActivity) this);
    }

    private final void setUpGroceryHomeChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/grocery-home").setMethodCallHandler(getGroceryHomeMethodHandler());
    }

    private final void setUpSearchChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.SEARCH_CHANNEL);
        VendorListSearchMethodChannel vendorListSearchMethodChannel = new VendorListSearchMethodChannel(false, 1, (DefaultConstructorMarker) null);
        vendorListSearchMethodChannel.setSearchMethodChannelCallbacks(this);
        methodChannel.setMethodCallHandler(vendorListSearchMethodChannel);
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
    public final ActiveCartsMethodCallHandler getActiveCartsMethodCallHandler() {
        ActiveCartsMethodCallHandler activeCartsMethodCallHandler2 = this.activeCartsMethodCallHandler;
        if (activeCartsMethodCallHandler2 != null) {
            return activeCartsMethodCallHandler2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activeCartsMethodCallHandler");
        return null;
    }

    @NotNull
    public FlutterVertical[] getAvailableVertical() {
        Bundle bundle;
        Integer num;
        String str;
        ArrayList<Integer> arrayList;
        Intent intent = getIntent();
        String str2 = null;
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt(SdSquadActions.ARG_TILE_ID));
        } else {
            num = null;
        }
        if (bundle != null) {
            str = bundle.getString("verticalName");
        } else {
            str = null;
        }
        if (bundle != null) {
            arrayList = bundle.getIntegerArrayList("verticalIds");
        } else {
            arrayList = null;
        }
        if (num != null) {
            str2 = num.toString();
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str == null) {
            str = "";
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        return new FlutterVertical[]{new FlutterVertical(str2, str, arrayList)};
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
    public final GroceryHomeMethodHandlerFactory getGroceryHomeMethodHandlerFactory() {
        GroceryHomeMethodHandlerFactory groceryHomeMethodHandlerFactory2 = this.groceryHomeMethodHandlerFactory;
        if (groceryHomeMethodHandlerFactory2 != null) {
            return groceryHomeMethodHandlerFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("groceryHomeMethodHandlerFactory");
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
    public String getRoute() {
        Integer num;
        String str;
        String str2;
        boolean z11;
        Bundle deepLinkBundle;
        ArrayList<Integer> verticalIds;
        GroceryHomeScreen.GroceryHomeData screenData = getScreenData();
        if (screenData != null) {
            num = Integer.valueOf(screenData.getShopType());
        } else {
            num = null;
        }
        if (screenData == null || (verticalIds = screenData.getVerticalIds()) == null) {
            str = null;
        } else {
            str = CollectionsKt___CollectionsKt.joinToString$default(verticalIds, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (screenData == null || (deepLinkBundle = screenData.getDeepLinkBundle()) == null) {
            str2 = null;
        } else {
            str2 = deepLinkBundle.getString("i");
        }
        Uri.Builder appendEncodedPath = new Uri.Builder().appendEncodedPath(FlutterRoutes.GROCERY_HOME_ROUTE);
        if (num != null) {
            num.intValue();
            appendEncodedPath.appendQueryParameter("verticalTileId", num.toString());
        }
        if (str != null) {
            if (str.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                appendEncodedPath.appendQueryParameter("verticalIds", str);
            }
        }
        if (str2 != null) {
            appendEncodedPath.appendQueryParameter("vendorListStrategy", str2);
        }
        String builder = appendEncodedPath.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "builder.toString()");
        if (!StringsKt__StringsJVMKt.startsWith$default(builder, "/", false, 2, (Object) null)) {
            return builder;
        }
        String substring = builder.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public int getSelectedCollectionId() {
        return 0;
    }

    public int getSelectedCuisine() {
        return 0;
    }

    @NotNull
    public Integer[] getSelectedFliterIds() {
        return new Integer[0];
    }

    public void navigateToFoodBasket() {
    }

    public void navigateToQcommerceBasket(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        navigateToCart(restaurant);
    }

    public void onBackPressed() {
        backToHomeScreen();
    }

    public void onBackPressedFromFlutter() {
        backToHomeScreen();
    }

    public void onCreate(@Nullable Bundle bundle) {
        injectDependencies();
        super.onCreate(bundle);
    }

    public void onDestroy() {
        getGroceryHomeMethodHandler().unsubscribe();
        getActiveCartsMethodCallHandler().terminate();
        super.onDestroy();
    }

    public void onNavigationToLifestyleProducts(@NotNull Restaurant restaurant, @NotNull String str, @NotNull String str2) {
        Restaurant restaurant2 = restaurant;
        Intrinsics.checkNotNullParameter(restaurant2, "vendor");
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "swimlaneId");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "missionName");
        DarkstoresNavigator.DefaultImpls.navigateToDarkStore$default(getDarkstoresNavigator(), this, restaurant2, Integer.valueOf(DarkstoreNavigationType.LIFESTYLE_MISSION.getType()), str3, (String) null, str4, false, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 4048, (Object) null);
    }

    public final void setActiveCartsMethodCallHandler(@NotNull ActiveCartsMethodCallHandler activeCartsMethodCallHandler2) {
        Intrinsics.checkNotNullParameter(activeCartsMethodCallHandler2, "<set-?>");
        this.activeCartsMethodCallHandler = activeCartsMethodCallHandler2;
    }

    public final void setDarkstoresNavigator(@NotNull DarkstoresNavigator darkstoresNavigator2) {
        Intrinsics.checkNotNullParameter(darkstoresNavigator2, "<set-?>");
        this.darkstoresNavigator = darkstoresNavigator2;
    }

    public final void setGroceryHomeMethodHandlerFactory(@NotNull GroceryHomeMethodHandlerFactory groceryHomeMethodHandlerFactory2) {
        Intrinsics.checkNotNullParameter(groceryHomeMethodHandlerFactory2, "<set-?>");
        this.groceryHomeMethodHandlerFactory = groceryHomeMethodHandlerFactory2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpGroceryHomeChannel(flutterEngine);
        setUpSearchChannel(flutterEngine);
        setUpGemChannel(flutterEngine);
        setUpActiveCartsMethodChannel(flutterEngine);
        setUpFoodCartChannel(flutterEngine);
    }
}
