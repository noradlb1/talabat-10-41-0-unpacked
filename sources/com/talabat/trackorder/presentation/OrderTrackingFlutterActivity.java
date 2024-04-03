package com.talabat.trackorder.presentation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.home.HomeScreen;
import com.talabat.core.navigation.domain.screen.ordertracking.OrderTrackingScreen;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.core.observabilityNew.domain.squads.ordertracking.OrderTrackingScreenPerformanceParams;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragmentKt;
import com.talabat.feature.tpro.presentation.payment.callback.ITProPaymentOtpCallback;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterWebViewActivity;
import com.talabat.localization.R;
import com.talabat.riderinfo.presentation.activity.RiderChatDeepLinkActivity;
import com.talabat.screenrecorder.ScreenRecorder;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderBottomSheetState;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipBottomSheetDialogFragment;
import com.talabat.talabatpurchaseevent.PurchaseEventTracker;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.trackorder.presentation.channels.OrderTrackingMethodChannel;
import com.talabat.trackorder.presentation.channels.OrderTrackingMethodChannelCallback;
import com.talabat.trackorder.presentation.di.DaggerOrderTrackingComponent;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorController;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorModel;
import com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.deeplink.IDeepLinkPresenter;
import tracking.deeplink.OrderTrackingDeeplinksCallback;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u00109\u001a\u00020:H\u0016J\n\u0010;\u001a\u0004\u0018\u00010<H\u0002J\b\u0010=\u001a\u00020<H\u0002J\n\u0010>\u001a\u0004\u0018\u00010<H\u0002J\b\u0010?\u001a\u00020<H\u0016J\b\u0010@\u001a\u00020<H\u0002J\b\u0010A\u001a\u00020:H\u0002J\b\u0010B\u001a\u00020:H\u0016J\u0012\u0010C\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010EH\u0014J\u0010\u0010F\u001a\u00020:2\u0006\u0010G\u001a\u00020<H\u0016J\u0010\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020<H\u0016J\u0010\u0010J\u001a\u00020:2\u0006\u0010I\u001a\u00020<H\u0016J\u0010\u0010K\u001a\u00020:2\u0006\u0010I\u001a\u00020<H\u0016J\u0010\u0010L\u001a\u00020:2\u0006\u0010I\u001a\u00020<H\u0016J\u0010\u0010M\u001a\u00020:2\u0006\u0010I\u001a\u00020<H\u0016J\u0010\u0010N\u001a\u00020:2\u0006\u0010I\u001a\u00020<H\u0016J\u0010\u0010O\u001a\u00020:2\u0006\u0010I\u001a\u00020<H\u0016J\u0010\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020RH\u0002J\u0010\u0010S\u001a\u00020:2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010T\u001a\u00020UH\u0002J1\u0010V\u001a\u00020:2\u0006\u0010G\u001a\u00020<2\u0006\u0010W\u001a\u00020<2\u0006\u0010X\u001a\u00020Y2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010[H\u0002¢\u0006\u0002\u0010\\J\b\u0010]\u001a\u00020:H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006^"}, d2 = {"Lcom/talabat/trackorder/presentation/OrderTrackingFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Ltracking/deeplink/OrderTrackingDeeplinksCallback;", "Lcom/talabat/trackorder/presentation/channels/OrderTrackingMethodChannelCallback;", "Lcom/talabat/feature/tpro/presentation/payment/callback/ITProPaymentOtpCallback;", "()V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "deeplinkPresenter", "Ltracking/deeplink/IDeepLinkPresenter;", "getDeeplinkPresenter", "()Ltracking/deeplink/IDeepLinkPresenter;", "deeplinkPresenter$delegate", "Lkotlin/Lazy;", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "getExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "setExperiment", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "helpCenterDeeplinkBuilder", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "getHelpCenterDeeplinkBuilder", "()Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "setHelpCenterDeeplinkBuilder", "(Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "orderTrackingMethodChannel", "Lio/flutter/plugin/common/MethodChannel;", "purchaseEventTracker", "Lcom/talabat/talabatpurchaseevent/PurchaseEventTracker;", "getPurchaseEventTracker", "()Lcom/talabat/talabatpurchaseevent/PurchaseEventTracker;", "purchaseEventTracker$delegate", "screenRecorder", "Lcom/talabat/screenrecorder/ScreenRecorder;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "setScreenTracker", "(Lcom/talabat/core/observabilityNew/domain/IScreenTracker;)V", "talabatFeatureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlags", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlags", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "closeOrderTracking", "", "getEncryptedOrderIdFromIntent", "", "getOrderId", "getOrderIdFromIntent", "getRoute", "getTransactionId", "inject", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRiderChatRedirection", "orderId", "openGhc", "deeplink", "openMenu", "openProPaymentScreen", "openQCommerceDeeplink", "openRiderChat", "openRiderTip", "openRiderTipInfo", "setUpCartChannel", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpExtraChannels", "shouldClearNavigationStack", "", "showRiderTipBottomSheet", "encryptedOrderId", "tipRiderBottomSheetStatus", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;", "selectedTip", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;Ljava/lang/Float;)V", "subscriptionStatusChanged", "com_talabat_feature_trackorder_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingFlutterActivity extends TalabatFlutterFragmentActivity implements OrderTrackingDeeplinksCallback, OrderTrackingMethodChannelCallback, ITProPaymentOtpCallback {
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @NotNull
    private final Lazy deeplinkPresenter$delegate;
    @Inject
    public ITalabatExperiment experiment;
    @Inject
    public IHelpCenterDeeplinkBuilder helpCenterDeeplinkBuilder;
    @Inject
    public Navigator navigator;
    /* access modifiers changed from: private */
    public MethodChannel orderTrackingMethodChannel;
    @NotNull
    private final Lazy purchaseEventTracker$delegate;
    @NotNull
    private final ScreenRecorder screenRecorder = ScreenRecorder.INSTANCE;
    @Inject
    public IScreenTracker screenTracker;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlags;

    public OrderTrackingFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.deeplinkPresenter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new OrderTrackingFlutterActivity$deeplinkPresenter$2(this));
        this.purchaseEventTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new OrderTrackingFlutterActivity$purchaseEventTracker$2(this));
    }

    public static /* synthetic */ void T(OrderTrackingFlutterActivity orderTrackingFlutterActivity, String str, String str2, TipRiderBottomSheetState tipRiderBottomSheetState, Float f11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            f11 = null;
        }
        orderTrackingFlutterActivity.showRiderTipBottomSheet(str, str2, tipRiderBottomSheetState, f11);
    }

    private final IDeepLinkPresenter getDeeplinkPresenter() {
        return (IDeepLinkPresenter) this.deeplinkPresenter$delegate.getValue();
    }

    private final String getEncryptedOrderIdFromIntent() {
        return getIntent().getStringExtra("encryptedOrderId");
    }

    private final String getOrderId() {
        String encryptedOrderIdFromIntent = getEncryptedOrderIdFromIntent();
        if (encryptedOrderIdFromIntent != null) {
            return encryptedOrderIdFromIntent;
        }
        String orderIdFromIntent = getOrderIdFromIntent();
        return orderIdFromIntent == null ? "" : orderIdFromIntent;
    }

    private final String getOrderIdFromIntent() {
        Object obj;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        if (Build.VERSION.SDK_INT >= 33) {
            obj = (Parcelable) intent.getParcelableExtra("navigatorData", OrderTrackingScreen.OrderTrackingScreenData.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("navigatorData");
            if (!(parcelableExtra instanceof OrderTrackingScreen.OrderTrackingScreenData)) {
                parcelableExtra = null;
            }
            obj = (OrderTrackingScreen.OrderTrackingScreenData) parcelableExtra;
        }
        OrderTrackingScreen.OrderTrackingScreenData orderTrackingScreenData = (OrderTrackingScreen.OrderTrackingScreenData) obj;
        if (orderTrackingScreenData != null) {
            return orderTrackingScreenData.getOrderId();
        }
        return null;
    }

    private final PurchaseEventTracker getPurchaseEventTracker() {
        return (PurchaseEventTracker) this.purchaseEventTracker$delegate.getValue();
    }

    private final String getTransactionId() {
        String stringExtra = getIntent().getStringExtra("transId");
        return stringExtra == null ? "" : stringExtra;
    }

    private final void inject() {
        DaggerOrderTrackingComponent.factory().create((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TrackingCoreLibApi.class), (ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ExperimentCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class), (HelpCenterFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(HelpCenterFeatureApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    private final void setUpCartChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-cart").setMethodCallHandler(new CartMethodChannel(this));
    }

    private final boolean shouldClearNavigationStack() {
        return getIntent().getBooleanExtra("shouldClearNavigationStack", false);
    }

    private final void showRiderTipBottomSheet(String str, String str2, TipRiderBottomSheetState tipRiderBottomSheetState, Float f11) {
        OrderTrackingFlutterActivity$showRiderTipBottomSheet$successListener$1 orderTrackingFlutterActivity$showRiderTipBottomSheet$successListener$1 = new OrderTrackingFlutterActivity$showRiderTipBottomSheet$successListener$1(this);
        TipRiderSource tipRiderSource = TipRiderSource.ORDER_CONFIRMATION_SCREEN;
        RiderTipBottomSheetDialogFragment riderTipBottomSheetDialogFragment = new RiderTipBottomSheetDialogFragment(orderTrackingFlutterActivity$showRiderTipBottomSheet$successListener$1, tipRiderBottomSheetState, tipRiderSource, OrderStatus.PREPARING, str, str2, tipRiderSource.getScreenName(), f11);
        Bundle bundle = new Bundle();
        bundle.putString("encryptedOrderId", str2);
        bundle.putString("orderId", str);
        riderTipBottomSheetDialogFragment.setArguments(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction();
        riderTipBottomSheetDialogFragment.show(supportFragmentManager, "");
    }

    public void closeOrderTracking() {
        onBackPressed();
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
    public final ITalabatExperiment getExperiment() {
        ITalabatExperiment iTalabatExperiment = this.experiment;
        if (iTalabatExperiment != null) {
            return iTalabatExperiment;
        }
        Intrinsics.throwUninitializedPropertyAccessException(InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        return null;
    }

    @NotNull
    public final IHelpCenterDeeplinkBuilder getHelpCenterDeeplinkBuilder() {
        IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder = this.helpCenterDeeplinkBuilder;
        if (iHelpCenterDeeplinkBuilder != null) {
            return iHelpCenterDeeplinkBuilder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helpCenterDeeplinkBuilder");
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
        String orderId = getOrderId();
        boolean shouldClearNavigationStack = shouldClearNavigationStack();
        return "/order-tracking?orderId=" + orderId + "&shouldClearNavigationStack=" + shouldClearNavigationStack;
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
    public final ITalabatFeatureFlag getTalabatFeatureFlags() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlags;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlags");
        return null;
    }

    public void onBackPressed() {
        if (shouldClearNavigationStack()) {
            getNavigator().navigateTo(this, new HomeScreen(new HomeScreen.HomeScreenData((HomeScreen.NavigationTab) null, false, 3, (DefaultConstructorMarker) null)), OrderTrackingFlutterActivity$onBackPressed$1.INSTANCE);
            return;
        }
        if (isTaskRoot()) {
            Navigator.DefaultImpls.navigateTo$default(getNavigator(), this, new HomeScreen(new HomeScreen.HomeScreenData((HomeScreen.NavigationTab) null, false, 3, (DefaultConstructorMarker) null)), (Function1) null, 4, (Object) null);
        }
        finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        this.screenRecorder.startScreenRecording(this);
        inject();
        getScreenTracker().startTrace(new ScreenTrackerParams("orderTracking", OrderTrackingScreenPerformanceParams.SCREEN_NAME, "orderTracking"));
        super.onCreate(bundle);
        getPurchaseEventTracker().trackOrderPlaced(getTransactionId());
    }

    public void onRiderChatRedirection(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "orderId");
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Toast.makeText(this, R.string.chat_error_message, 1).show();
            return;
        }
        Intent intent = new Intent("com.talabat.riderinfo.deeplink.riderchat");
        intent.putExtra(RiderChatDeepLinkActivity.ORDER_ID_KEY, str);
        startActivity(intent);
    }

    public void openGhc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        String queryParameter = Uri.parse(str).getQueryParameter("i");
        if (queryParameter == null) {
            queryParameter = "";
        }
        DeepLinkNavigator.DefaultImpls.navigateTo$default(getDeepLinkNavigator(), this, IHelpCenterDeeplinkBuilder.DefaultImpls.build$default(getHelpCenterDeeplinkBuilder(), queryParameter, (String) null, 2, (Object) null), (Function0) null, 4, (Object) null);
    }

    public void openMenu(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        String queryParameter = Uri.parse(str).getQueryParameter("v");
        if (queryParameter == null) {
            queryParameter = "-1";
        }
        String queryParameter2 = Uri.parse(str).getQueryParameter("ipv");
        if (queryParameter2 == null) {
            queryParameter2 = "false";
        }
        String queryParameter3 = Uri.parse(str).getQueryParameter("dm");
        if (queryParameter3 == null) {
            queryParameter3 = "rider";
        }
        String str2 = queryParameter3;
        MenuNavigatorController menuNavigatorController = MenuNavigatorController.INSTANCE;
        menuNavigatorController.navigateToMenu(this, new MenuNavigatorModel(Integer.parseInt(queryParameter), str2, OrderTrackingScreenPerformanceParams.SCREEN_NAME, Boolean.valueOf(Boolean.parseBoolean(queryParameter2)), (Integer) null, 16, (DefaultConstructorMarker) null), getTalabatFeatureFlags(), getDeepLinkNavigator(), getNavigator());
    }

    public void openProPaymentScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        String queryParameter = Uri.parse(str).getQueryParameter("orderId");
        String str2 = "";
        if (queryParameter == null) {
            queryParameter = str2;
        }
        String queryParameter2 = Uri.parse(str).getQueryParameter("deliveryFee");
        if (queryParameter2 != null) {
            str2 = queryParameter2;
        }
        TProPaymentBottomSheetFragmentKt.showPaymentBottomSheetFromOTP(this, queryParameter, str2);
    }

    public void openQCommerceDeeplink(@NotNull String str) {
        Integer intOrNull;
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "deeplink");
        String query = Uri.parse(str).getQuery();
        if (query == null) {
            query = "";
        }
        char[] cArr = {Typography.amp};
        ArrayList<List> arrayList = new ArrayList<>();
        for (String split$default : StringsKt__StringsKt.split$default((CharSequence) query, cArr, false, 0, 6, (Object) null)) {
            List split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default, new char[]{SignatureVisitor.INSTANCEOF}, false, 0, 6, (Object) null);
            if (split$default2.size() == 2) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                split$default2 = null;
            }
            if (split$default2 != null) {
                arrayList.add(split$default2);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (List list : arrayList) {
            Pair pair = TuplesKt.to(list.get(0), list.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        Intent intent = new Intent("com.talabat.feature.darkstores.deeplink");
        String str2 = (String) linkedHashMap.get("t");
        if (!(str2 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2)) == null)) {
            intent.putExtra("deeplinkType", intOrNull.intValue());
        }
        String str3 = (String) linkedHashMap.get("i");
        if (str3 != null) {
            intent.putExtra("deeplinkInfo", str3);
        }
        String str4 = (String) linkedHashMap.get("s");
        if (str4 != null) {
            intent.putExtra("isDarkStore", Intrinsics.areEqual((Object) str4, (Object) "ds"));
            intent.putExtra("isMigrated", Intrinsics.areEqual((Object) str4, (Object) "mv"));
        }
        String str5 = (String) linkedHashMap.get("bid");
        if (str5 != null) {
            intent.putExtra("branchId", str5);
        }
        String str6 = (String) linkedHashMap.get(InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        if (str6 != null) {
            intent.putExtra(InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT, str6);
        }
        intent.putExtra("shopClickOrigin", GlobalHelpCenterWebViewActivity.ORDER_TRACKING);
        intent.putExtra("eventOrigin", "looking_glass");
        startActivity(intent);
    }

    public void openRiderChat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        getDeeplinkPresenter().deepLinkRecived(URI.create(str).getQuery());
        getDeeplinkPresenter().redirectToDeepLink();
    }

    public void openRiderTip(@NotNull String str) {
        Float f11;
        Intrinsics.checkNotNullParameter(str, "deeplink");
        String queryParameter = Uri.parse(str).getQueryParameter(RiderChatDeepLinkActivity.ORDER_ID_KEY);
        if (queryParameter == null) {
            queryParameter = "";
        }
        String queryParameter2 = Uri.parse(str).getQueryParameter("tip_value");
        if (queryParameter2 != null) {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(queryParameter2);
        } else {
            f11 = null;
        }
        String encryptedOrderIdFromIntent = getEncryptedOrderIdFromIntent();
        if (encryptedOrderIdFromIntent == null) {
            encryptedOrderIdFromIntent = queryParameter;
        }
        showRiderTipBottomSheet(queryParameter, encryptedOrderIdFromIntent, TipRiderBottomSheetState.OPEN_PAYMENT_WIDGET, f11);
    }

    public void openRiderTipInfo(@NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "deeplink");
        String queryParameter = Uri.parse(str).getQueryParameter(RiderChatDeepLinkActivity.ORDER_ID_KEY);
        if (queryParameter == null) {
            queryParameter = "";
        }
        String str3 = queryParameter;
        String encryptedOrderIdFromIntent = getEncryptedOrderIdFromIntent();
        if (encryptedOrderIdFromIntent == null) {
            str2 = str3;
        } else {
            str2 = encryptedOrderIdFromIntent;
        }
        T(this, str3, str2, TipRiderBottomSheetState.OPEN_INFO_WITHOUT_TIP_AGAIN, (Float) null, 8, (Object) null);
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setExperiment(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "<set-?>");
        this.experiment = iTalabatExperiment;
    }

    public final void setHelpCenterDeeplinkBuilder(@NotNull IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        Intrinsics.checkNotNullParameter(iHelpCenterDeeplinkBuilder, "<set-?>");
        this.helpCenterDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setScreenTracker(@NotNull IScreenTracker iScreenTracker) {
        Intrinsics.checkNotNullParameter(iScreenTracker, "<set-?>");
        this.screenTracker = iScreenTracker;
    }

    public final void setTalabatFeatureFlags(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlags = iTalabatFeatureFlag;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        this.orderTrackingMethodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/order_tracking");
        OrderTrackingMethodChannel orderTrackingMethodChannel2 = new OrderTrackingMethodChannel();
        orderTrackingMethodChannel2.setCallback(this);
        MethodChannel methodChannel = this.orderTrackingMethodChannel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderTrackingMethodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(orderTrackingMethodChannel2);
        setUpCartChannel(flutterEngine);
    }

    public void subscriptionStatusChanged() {
        MethodChannel methodChannel = this.orderTrackingMethodChannel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderTrackingMethodChannel");
            methodChannel = null;
        }
        methodChannel.invokeMethod("refreshOtp", "");
    }
}
