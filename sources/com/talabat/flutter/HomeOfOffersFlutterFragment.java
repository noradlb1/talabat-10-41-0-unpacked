package com.talabat.flutter;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import buisnessmodels.Customer;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.subscription.SubscriptionFeatureFlagConstants;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.flutter.channels.HomeOfOffersMethodChannel;
import com.talabat.flutter.channels.IHomeOfOffersMethodChannel;
import com.talabat.flutter.di.DaggerHomeOfOffersFlutterFragmentComponent;
import com.talabat.flutter.homeofoffers.HomeOfOffersBroadcastReceiver;
import com.talabat.flutter.utils.FlutterRoutes;
import com.talabat.fluttercore.FlutterApiInitializer;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.gem.adapters.flutter.channel.GemMethodChannel;
import com.talabat.helpers.GlobalConstants;
import com.talabat.home.HomeScreenActivity;
import com.talabat.talabatcommon.ports.VendorMenuFlutterNavigatorPort;
import com.talabat.talabatcommon.ports.VendorMenuIntegratorKt;
import com.talabat.talabatcommon.ports.dto.VendorBusyPopupCallArguments;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.vendormenu.presentation.flutter.GemFlutterEngineBinder;
import com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMenuInfoMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMenuInfoMethodChannelCallBack;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMenuMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMethodChannel;
import com.talabat.vendormenu.presentation.flutter.channels.VendorMethodChannelCallback;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00012B\u0007¢\u0006\u0004\b0\u00101J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0016\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016R\u0014\u0010'\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/talabat/flutter/HomeOfOffersFlutterFragment;", "Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "Lcom/talabat/flutter/channels/IHomeOfOffersMethodChannel;", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuInfoMethodChannelCallBack;", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMethodChannelCallback;", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterEngine", "", "setUpHomeOfOffersChannel", "setUpCartChannel", "setUpVendorMenuInfoChannel", "setupGemChannel", "setUpMenuChannel", "setUpVendorChannel", "Landroid/content/Context;", "context", "onAttach", "", "getRoute", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getEntryPoint", "setUpExtraChannels", "k0", "getVendorsOffers", "", "boolean", "onSetBottomNavigation", "", "", "getVendorMenuInfo", "Lcom/talabat/talabatcommon/ports/dto/VendorBusyPopupCallArguments;", "args", "showVendorBusyPopup", "getVendor", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onDestroy", "Lcom/talabat/flutter/homeofoffers/HomeOfOffersBroadcastReceiver;", "hooBroadcastReceiver", "Lcom/talabat/flutter/homeofoffers/HomeOfOffersBroadcastReceiver;", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "<init>", "()V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public final class HomeOfOffersFlutterFragment extends PreWarmedFlutterFragment implements IHomeOfOffersMethodChannel, VendorMenuInfoMethodChannelCallBack, VendorMethodChannelCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String HOME_OF_OFFERS_DEEP_LINK = "home_of_offers";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final HomeOfOffersBroadcastReceiver hooBroadcastReceiver;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/flutter/HomeOfOffersFlutterFragment$Companion;", "", "()V", "HOME_OF_OFFERS_DEEP_LINK", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HomeOfOffersFlutterFragment() {
        super(PreWarmedEngines.ENGINE_FOR_HOME_OF_OFFERS, (RemoteConfiguration) null, 2, (DefaultConstructorMarker) null);
        this.hooBroadcastReceiver = new HomeOfOffersBroadcastReceiver();
    }

    private final void setUpCartChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-cart");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        methodChannel.setMethodCallHandler(new CartMethodChannel(context));
    }

    private final void setUpHomeOfOffersChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.HOME_OF_OFFERS_CHANNEL);
        HomeOfOffersMethodChannel homeOfOffersMethodChannel = new HomeOfOffersMethodChannel();
        homeOfOffersMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(homeOfOffersMethodChannel);
    }

    private final void setUpMenuChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-menu").setMethodCallHandler(new VendorMenuMethodChannel());
    }

    private final void setUpVendorChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor").setMethodCallHandler(new VendorMethodChannel());
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new GemFlutterEngineBinder(methodChannel).accept(activity);
        }
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

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.HOME_OF_OFFERS;
    }

    @NotNull
    public String getRoute() {
        return FlutterRoutes.HOME_OF_OFFERS;
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

    @Nullable
    public Map<String, Object> getVendor() {
        return MapsKt__MapsKt.emptyMap();
    }

    @NotNull
    public Map<String, Object> getVendorMenuInfo() {
        boolean z11;
        Pair[] pairArr = new Pair[5];
        Customer instance = Customer.getInstance();
        if (instance == null || !instance.isShowPro()) {
            z11 = false;
        } else {
            z11 = true;
        }
        pairArr[0] = TuplesKt.to("isTalabatProSubscriptionEnabled", Boolean.valueOf(z11));
        pairArr[1] = TuplesKt.to("showTproBannerForNonTproUsers", Boolean.valueOf(getTalabatFeatureFlag().getFeatureFlag(SubscriptionFeatureFlagConstants.INSTANCE.getSHOW_TPRO_BANNER_FOR_NON_TPRO_USERS(), false)));
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        TalabatExperimentConstants talabatExperimentConstants = TalabatExperimentConstants.CAN_SHOW_ORDER_AGAIN_SECTION;
        TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy = TalabatExperimentDataSourceStrategy.APPTIMIZE;
        pairArr[2] = TuplesKt.to("canShowOrderAgainMenuSection", talabatExperiment.getStringVariant(talabatExperimentConstants, "do_not_show", talabatExperimentDataSourceStrategy));
        pairArr[3] = TuplesKt.to("canShowStarRatings", Boolean.valueOf(talabatExperiment.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_STAR_RATING, false, talabatExperimentDataSourceStrategy)));
        pairArr[4] = TuplesKt.to("canShowShareMenu", Boolean.valueOf(talabatExperiment.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_SHARE_MENU, false, talabatExperimentDataSourceStrategy)));
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public String getVendorsOffers() {
        return "Test Vendor Item";
    }

    public void k0(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        FlutterApiInitializer.INSTANCE.setUp(flutterEngine);
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerHomeOfOffersFlutterFragmentComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.hooBroadcastReceiver, new IntentFilter(GlobalConstants.BROADCAST_KILL_MENU));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.hooBroadcastReceiver);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onSetBottomNavigation(boolean z11) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((HomeScreenActivity) activity).onSetBottomNavigation(z11);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.home.HomeScreenActivity");
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        setUpHomeOfOffersChannel(flutterEngine);
        setUpCartChannel(flutterEngine);
        setUpVendorMenuInfoChannel(flutterEngine);
        setUpMenuChannel(flutterEngine);
        setupGemChannel(flutterEngine);
        setUpVendorChannel(flutterEngine);
    }

    public void showVendorBusyPopup(@NotNull VendorBusyPopupCallArguments vendorBusyPopupCallArguments) {
        Intrinsics.checkNotNullParameter(vendorBusyPopupCallArguments, StepData.ARGS);
        VendorMenuFlutterNavigatorPort vendorMenuNavigator = VendorMenuIntegratorKt.getVendorMenuNavigator();
        if (vendorMenuNavigator != null) {
            vendorMenuNavigator.navigateToBusyBottomSheet((FragmentActivity) this, vendorBusyPopupCallArguments);
        }
    }
}
