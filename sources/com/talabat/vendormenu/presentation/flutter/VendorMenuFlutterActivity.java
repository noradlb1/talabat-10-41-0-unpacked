package com.talabat.vendormenu.presentation.flutter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.screen.menu.MenuScreen;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModel;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModelFactory;
import com.talabat.feature.tpro.presentation.helperview.mov.wrapper.VendorMenuTProMovWrapper;
import com.talabat.fluttercore.FlutterApiInitializer;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.gem.adapters.flutter.channel.GemMethodChannel;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.ports.VendorMenuFlutterNavigatorPort;
import com.talabat.talabatcommon.ports.VendorMenuIntegratorKt;
import com.talabat.talabatcommon.ports.dto.VendorBusyPopupCallArguments;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.TalabatProMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.TalabatProMethodChannelCallback;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMenuInfoMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMenuInfoMethodChannelCallBack;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMenuMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMenuMethodChannelCallback;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMethodChannelCallback;
import com.talabat.vendormenu.presentation.flutter.di.DaggerVendorMenuFlutterActivityComponent;
import com.talabat.vendormenu.presentation.flutter.utils.FlutterRoutes;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001YB\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010-\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0002\u0010/J\n\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u00102\u001a\u000203H\u0016J\u000f\u00104\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0002\u0010/J\b\u00105\u001a\u000201H\u0016J\n\u00106\u001a\u0004\u0018\u000101H\u0002J9\u00107\u001a\u0002082/\u00109\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u00010<0;¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u0002080:H\u0016J\u0016\u0010@\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0016J\u0016\u0010A\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0016J\u0016\u0010B\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u00010<0;H\u0016J\b\u0010C\u001a\u000208H\u0002J\b\u0010D\u001a\u00020EH\u0002J\u0012\u0010F\u001a\u0002082\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010M\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010N\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010O\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010P\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010Q\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010R\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010S\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010T\u001a\u0002082\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u0002082\u0006\u0010X\u001a\u00020.H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006Z"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/VendorMenuFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuInfoMethodChannelCallBack;", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMethodChannelCallback;", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuMethodChannelCallback;", "Lcom/talabat/vendormenu/presentation/flutter/channels/TalabatProMethodChannelCallback;", "()V", "proCentralizationStatusWrapper", "Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;", "getProCentralizationStatusWrapper", "()Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;", "setProCentralizationStatusWrapper", "(Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;)V", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "setScreenTracker", "(Lcom/talabat/core/observabilityNew/domain/IScreenTracker;)V", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "getSubscriptionStatusRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "setSubscriptionStatusRepository", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "vendorMenuTProMovWrapper", "Lcom/talabat/feature/tpro/presentation/helperview/mov/wrapper/VendorMenuTProMovWrapper;", "vendorMovViewModel", "Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModel;", "getVendorMovViewModel", "()Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModel;", "vendorMovViewModel$delegate", "Lkotlin/Lazy;", "vendorMovViewModelFactory", "Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModelFactory;", "getVendorMovViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModelFactory;", "setVendorMovViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModelFactory;)V", "getBranchId", "", "()Ljava/lang/Integer;", "getDeliveryMode", "", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getItemId", "getRoute", "getShopClickOrigin", "getTalabatProConfigs", "", "vendorMovCallback", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "map", "getVendor", "getVendorMenu", "getVendorMenuInfo", "inject", "isProVendor", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpCartChannel", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpE2ETestChannel", "setUpExtraChannels", "setUpMenuChannel", "setUpTalabatProChannel", "setUpTestingChannels", "setUpVendorChannel", "setUpVendorMenuInfoChannel", "setupGemChannel", "showVendorBusyPopup", "args", "Lcom/talabat/talabatcommon/ports/dto/VendorBusyPopupCallArguments;", "updateProStatus", "countryId", "CompanionObject", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuFlutterActivity extends TalabatFlutterFragmentActivity implements VendorMenuInfoMethodChannelCallBack, VendorMethodChannelCallback, VendorMenuMethodChannelCallback, TalabatProMethodChannelCallback {
    @NotNull
    public static final String BRANCH_ID_KEY = "branchId";
    @NotNull
    public static final String CART_CHANNEL = "com.talabat.flutter/vendor-cart";
    @NotNull
    public static final CompanionObject CompanionObject = new CompanionObject((DefaultConstructorMarker) null);
    @NotNull
    public static final String GEM_CHANNEL = "com.talabat.flutter/gem";
    @NotNull
    public static final String IS_PRO_VENDOR_KEY = "isProVendor";
    @NotNull
    public static final String PAYMENT_CHANNEL = "com.talabat.flutter/payment";
    @NotNull
    public static final String SHOP_CLICK_ORIGIN_KEY = "shopClickOrigin";
    @NotNull
    public static final String TALABAT_PRO_CHANNEL = "com.talabat.flutter/talabatPro";
    @NotNull
    public static final String VENDOR_MENU_CHANNEL = "com.talabat.flutter/vendor-menu";
    @NotNull
    public static final String VENDOR_MENU_INFO_CHANNEL = "com.talabat.flutter/vendor-menu-info";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ProCentralizationStatusWrapper proCentralizationStatusWrapper;
    @Inject
    public IScreenTracker screenTracker;
    @Inject
    public ISubscriptionStatusRepository subscriptionStatusRepository;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    private VendorMenuTProMovWrapper vendorMenuTProMovWrapper;
    @NotNull
    private final Lazy vendorMovViewModel$delegate;
    @Inject
    public VendorMovViewModelFactory vendorMovViewModelFactory;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/VendorMenuFlutterActivity$CompanionObject;", "", "()V", "BRANCH_ID_KEY", "", "CART_CHANNEL", "GEM_CHANNEL", "IS_PRO_VENDOR_KEY", "PAYMENT_CHANNEL", "SHOP_CLICK_ORIGIN_KEY", "TALABAT_PRO_CHANNEL", "VENDOR_MENU_CHANNEL", "VENDOR_MENU_INFO_CHANNEL", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CompanionObject {
        private CompanionObject() {
        }

        public /* synthetic */ CompanionObject(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VendorMenuFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
        this.vendorMovViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VendorMovViewModel.class), new VendorMenuFlutterActivity$special$$inlined$viewModels$default$2(this), new VendorMenuFlutterActivity$vendorMovViewModel$2(this), new VendorMenuFlutterActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    }

    private final Integer getBranchId() {
        Integer num;
        MenuScreen.MenuData menuData;
        Intent intent = getIntent();
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            num = null;
        } else {
            num = Integer.valueOf(menuData.getBranchId());
        }
        if (getIntent().hasExtra("branchId")) {
            return Integer.valueOf(getIntent().getIntExtra("branchId", -1));
        }
        return num;
    }

    private final String getDeliveryMode() {
        String str;
        MenuScreen.MenuData menuData;
        Intent intent = getIntent();
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            str = null;
        } else {
            str = menuData.getDeliveryMode();
        }
        if (getIntent().hasExtra("deliveryMode")) {
            return getIntent().getStringExtra("deliveryMode");
        }
        return str;
    }

    private final Integer getItemId() {
        Integer num;
        MenuScreen.MenuData menuData;
        Intent intent = getIntent();
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            num = null;
        } else {
            num = Integer.valueOf(menuData.getItemId());
        }
        if (getIntent().hasExtra("itemId")) {
            return Integer.valueOf(getIntent().getIntExtra("itemId", -1));
        }
        return num;
    }

    private final String getShopClickOrigin() {
        String str;
        MenuScreen.MenuData menuData;
        Intent intent = getIntent();
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            str = null;
        } else {
            str = menuData.getShopClickOrigin();
        }
        if (getIntent().hasExtra("shopClickOrigin")) {
            return getIntent().getStringExtra("shopClickOrigin");
        }
        return str;
    }

    private final VendorMovViewModel getVendorMovViewModel() {
        return (VendorMovViewModel) this.vendorMovViewModel$delegate.getValue();
    }

    private final void inject() {
        DaggerVendorMenuFlutterActivityComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(SubscriptionsFeatureApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TrackingCoreLibApi.class), LifecycleOwnerKt.getLifecycleScope(this)).inject(this);
    }

    private final boolean isProVendor() {
        Boolean bool;
        MenuScreen.MenuData menuData;
        Intent intent = getIntent();
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(menuData.isProVendor());
        }
        if (getIntent().hasExtra(IS_PRO_VENDOR_KEY)) {
            return getIntent().getBooleanExtra(IS_PRO_VENDOR_KEY, false);
        }
        return BooleanKt.orFalse(bool);
    }

    private final void setUpCartChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-cart").setMethodCallHandler(new CartMethodChannel(this));
    }

    private final void setUpE2ETestChannel(FlutterEngine flutterEngine) {
        FlutterApiInitializer.INSTANCE.setUp(flutterEngine);
    }

    private final void setUpMenuChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-menu");
        VendorMenuMethodChannel vendorMenuMethodChannel = new VendorMenuMethodChannel();
        vendorMenuMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(vendorMenuMethodChannel);
    }

    private final void setUpTalabatProChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/talabatPro");
        TalabatProMethodChannel talabatProMethodChannel = new TalabatProMethodChannel();
        talabatProMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(talabatProMethodChannel);
    }

    private final void setUpVendorChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor");
        VendorMethodChannel vendorMethodChannel = new VendorMethodChannel();
        vendorMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(vendorMethodChannel);
    }

    private final void setUpVendorMenuInfoChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-menu-info");
        VendorMenuInfoMethodChannel vendorMenuInfoMethodChannel = new VendorMenuInfoMethodChannel();
        vendorMenuInfoMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(vendorMenuInfoMethodChannel);
    }

    private final void setupGemChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/gem");
        methodChannel.setMethodCallHandler(new GemMethodChannel());
        new GemFlutterEngineBinder(methodChannel).accept((FragmentActivity) this);
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
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.VENDOR_MENU;
    }

    @NotNull
    public final ProCentralizationStatusWrapper getProCentralizationStatusWrapper() {
        ProCentralizationStatusWrapper proCentralizationStatusWrapper2 = this.proCentralizationStatusWrapper;
        if (proCentralizationStatusWrapper2 != null) {
            return proCentralizationStatusWrapper2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("proCentralizationStatusWrapper");
        return null;
    }

    @NotNull
    public String getRoute() {
        return FlutterRoutes.VENDOR_MENU_ROUTE;
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
    public final ISubscriptionStatusRepository getSubscriptionStatusRepository() {
        ISubscriptionStatusRepository iSubscriptionStatusRepository = this.subscriptionStatusRepository;
        if (iSubscriptionStatusRepository != null) {
            return iSubscriptionStatusRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionStatusRepository");
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

    public void getTalabatProConfigs(@NotNull Function1<? super Map<String, ? extends Object>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "vendorMovCallback");
        VendorMenuTProMovWrapper vendorMenuTProMovWrapper2 = this.vendorMenuTProMovWrapper;
        if (vendorMenuTProMovWrapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vendorMenuTProMovWrapper");
            vendorMenuTProMovWrapper2 = null;
        }
        vendorMenuTProMovWrapper2.fetchTalabatProConfigs(getBranchId(), isProVendor(), function1);
    }

    @Nullable
    public Map<String, Object> getVendor() {
        return null;
    }

    @Nullable
    public Map<String, Object> getVendorMenu() {
        return null;
    }

    @NotNull
    public Map<String, Object> getVendorMenuInfo() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("shopClickOrigin", getShopClickOrigin()), TuplesKt.to("branchId", getBranchId()), TuplesKt.to("itemId", getItemId()), TuplesKt.to("deliveryMode", getDeliveryMode()));
    }

    @NotNull
    public final VendorMovViewModelFactory getVendorMovViewModelFactory() {
        VendorMovViewModelFactory vendorMovViewModelFactory2 = this.vendorMovViewModelFactory;
        if (vendorMovViewModelFactory2 != null) {
            return vendorMovViewModelFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vendorMovViewModelFactory");
        return null;
    }

    public void onCreate(@Nullable Bundle bundle) {
        inject();
        getScreenTracker().startTrace(new ScreenTrackerParams(MenuScreenPerformanceParams.TRACE, MenuScreenPerformanceParams.SCREEN_NAME, MenuScreenPerformanceParams.SCREEN_TYPE));
        getScreenTracker().startTrace(new ScreenTrackerParams(MenuScreenPerformanceParams.TRACE_NATIVE, MenuScreenPerformanceParams.SCREEN_NAME_NATIVE, MenuScreenPerformanceParams.SCREEN_TYPE));
        super.onCreate(bundle);
        this.vendorMenuTProMovWrapper = new VendorMenuTProMovWrapper(this, getVendorMovViewModel(), getSubscriptionStatusRepository());
    }

    public final void setProCentralizationStatusWrapper(@NotNull ProCentralizationStatusWrapper proCentralizationStatusWrapper2) {
        Intrinsics.checkNotNullParameter(proCentralizationStatusWrapper2, "<set-?>");
        this.proCentralizationStatusWrapper = proCentralizationStatusWrapper2;
    }

    public final void setScreenTracker(@NotNull IScreenTracker iScreenTracker) {
        Intrinsics.checkNotNullParameter(iScreenTracker, "<set-?>");
        this.screenTracker = iScreenTracker;
    }

    public final void setSubscriptionStatusRepository(@NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "<set-?>");
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpCartChannel(flutterEngine);
        setUpVendorMenuInfoChannel(flutterEngine);
        setUpMenuChannel(flutterEngine);
        setupGemChannel(flutterEngine);
        setUpVendorChannel(flutterEngine);
        setUpTalabatProChannel(flutterEngine);
    }

    public void setUpTestingChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setUpE2ETestChannel(flutterEngine);
    }

    public final void setVendorMovViewModelFactory(@NotNull VendorMovViewModelFactory vendorMovViewModelFactory2) {
        Intrinsics.checkNotNullParameter(vendorMovViewModelFactory2, "<set-?>");
        this.vendorMovViewModelFactory = vendorMovViewModelFactory2;
    }

    public void showVendorBusyPopup(@NotNull VendorBusyPopupCallArguments vendorBusyPopupCallArguments) {
        Intrinsics.checkNotNullParameter(vendorBusyPopupCallArguments, StepData.ARGS);
        VendorMenuFlutterNavigatorPort vendorMenuNavigator = VendorMenuIntegratorKt.getVendorMenuNavigator();
        if (vendorMenuNavigator != null) {
            vendorMenuNavigator.navigateToBusyBottomSheet(this, vendorBusyPopupCallArguments);
        }
    }

    public void updateProStatus(int i11) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new VendorMenuFlutterActivity$updateProStatus$1(this, i11, (Continuation<? super VendorMenuFlutterActivity$updateProStatus$1>) null), 3, (Object) null);
    }
}
