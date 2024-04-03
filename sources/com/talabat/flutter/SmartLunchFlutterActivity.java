package com.talabat.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import buisnessmodels.Customer;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.data.googleclientid.GoogleClientIdLocalStorage;
import com.talabat.flutter.channels.IPaymentMethodChannel;
import com.talabat.flutter.channels.PaymentMethodChannel;
import com.talabat.flutter.utils.payment.FlutterPaymentExtensionsKt;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.fluttercore.channels.AnalyticsMethodChannelCallback;
import com.talabat.fluttercore.channels.GlobalMethodChannel;
import com.talabat.fluttercore.channels.GlobalMethodChannelCallback;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.lib.Integration;
import com.talabat.location.SelectedLocationProviderImpl;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.BottomSheetPaymentStatusModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentBottomSheetInterface;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheet;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.embedding.android.FlutterFragmentActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00018B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000fH\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010-\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J,\u0010.\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f01H\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/talabat/flutter/SmartLunchFlutterActivity;", "Lio/flutter/embedding/android/FlutterFragmentActivity;", "Lcom/talabat/fluttercore/channels/GlobalMethodChannelCallback;", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannelCallback;", "Lcom/talabat/flutter/channels/IPaymentMethodChannel;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentBottomSheetInterface;", "()V", "bottomSheet", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheet;", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "logFlutterEvent", "eventName", "", "events", "", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressedFromFlutter", "openPaymentWidget", "paymentInfoDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "provideFlutterEngine", "context", "Landroid/content/Context;", "sendCardDetailsToFlutterScreen", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "sendCardDetailsToParentScreen", "sendPaymentWidgetClosedEvent", "paymentStatus", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;", "transactionId", "setupAnalyticsChannel", "setupConfigChannel", "setupNavigationChannel", "setupPaymentChannel", "track", "featureName", "attributes", "", "trackEvent", "event", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "updatePaymentStatus", "bottomSheetPaymentStatusModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/BottomSheetPaymentStatusModel;", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SmartLunchFlutterActivity extends FlutterFragmentActivity implements GlobalMethodChannelCallback, AnalyticsMethodChannelCallback, IPaymentMethodChannel, PaymentBottomSheetInterface {
    @NotNull
    private static final String ANALYTICS_CHANNEL = "com.talabat.flutter/analytics";
    @NotNull
    private static final String CONFIG_CHANNEL = "com.talabat.flutter/global";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String NAVIGATION_CHANNEL = "com.talabat.flutter/navigation";
    @NotNull
    private static final String SMART_LUNCH_CHANNEL = "com.talabat.flutter/smart-lunch";
    @NotNull
    private static final String SMART_LUNCH_ROUTE = "/smart-onboarding";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private PaymentWidgetBottomSheet bottomSheet;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/flutter/SmartLunchFlutterActivity$Companion;", "", "()V", "ANALYTICS_CHANNEL", "", "CONFIG_CHANNEL", "NAVIGATION_CHANNEL", "SMART_LUNCH_CHANNEL", "SMART_LUNCH_ROUTE", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void sendCardDetailsToFlutterScreen(WalletCardDisplayModel walletCardDisplayModel, PaymentMethod paymentMethod) {
        DartExecutor dartExecutor;
        BinaryMessenger binaryMessenger;
        LogManager.debug(walletCardDisplayModel.getCardNumber());
        FlutterEngine P = P();
        if (P != null && (dartExecutor = P.getDartExecutor()) != null && (binaryMessenger = dartExecutor.getBinaryMessenger()) != null) {
            new MethodChannel(binaryMessenger, "com.talabat.flutter/smart-lunch").invokeMethod("sendCardDetails", FlutterPaymentExtensionsKt.toMap(FlutterPaymentExtensionsKt.getWalletCardDetails(walletCardDisplayModel, paymentMethod)), new SmartLunchFlutterActivity$sendCardDetailsToFlutterScreen$1());
        }
    }

    private final void setupAnalyticsChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/analytics");
        AnalyticsMethodChannel analyticsMethodChannel = new AnalyticsMethodChannel(((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TrackingCoreLibApi.class)).getFlutterMigrationTools());
        analyticsMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(analyticsMethodChannel);
    }

    private final void setupConfigChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/global");
        Class cls = ConfigurationRemoteCoreLibApi.class;
        AppVersionProvider appVersionProvider = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getAppVersionProvider();
        ConfigurationLocalRepository repository = ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
        LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getLocationConfigurationRepository();
        PaymentConfigurationRepository paymentConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getPaymentConfigurationRepository();
        TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(cls)).getTermsAndConditionsConfigurationRepository();
        IObservabilityManager observabilityManager = ((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        GlobalMethodChannel globalMethodChannel = new GlobalMethodChannel(appVersionProvider, repository, locationConfigurationRepository, new SelectedLocationProviderImpl(instance), new DeviceIdProviderImpl(Integration.getAppContext()), GoogleClientIdLocalStorage.INSTANCE, paymentConfigurationRepository, termsAndConditionsConfigurationRepository, observabilityManager);
        globalMethodChannel.setCallback(this);
        methodChannel.setMethodCallHandler(globalMethodChannel);
    }

    private final void setupNavigationChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/navigation").setMethodCallHandler(new NavigationMethodChannel());
    }

    private final void setupPaymentChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/smart-lunch");
        new PaymentMethodChannel().setPaymentMethodChannelInterface(this);
        methodChannel.setMethodCallHandler(new PaymentMethodChannel());
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

    public void configureFlutterEngine(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        setupConfigChannel(flutterEngine);
        setupPaymentChannel(flutterEngine);
        setupAnalyticsChannel(flutterEngine);
        setupNavigationChannel(flutterEngine);
    }

    public void getCardClicked() {
        PaymentBottomSheetInterface.DefaultImpls.getCardClicked(this);
    }

    public void logFlutterEvent(@NotNull String str, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "events");
        TalabatGTM.Companion.logFlutterEvents(this, str, map);
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        finish();
    }

    public void onBackPressedFromFlutter(@NotNull Object obj) {
        GlobalMethodChannelCallback.DefaultImpls.onBackPressedFromFlutter(this, obj);
    }

    public void onSetBottomNavigation(boolean z11) {
        GlobalMethodChannelCallback.DefaultImpls.onSetBottomNavigation(this, z11);
    }

    public void openPaymentWidget(@NotNull PaymentInfoDisplayModel paymentInfoDisplayModel) {
        Intrinsics.checkNotNullParameter(paymentInfoDisplayModel, "paymentInfoDisplayModel");
        PaymentWidgetBottomSheet paymentWidgetBottomSheet = new PaymentWidgetBottomSheet(paymentInfoDisplayModel, this);
        this.bottomSheet = paymentWidgetBottomSheet;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        paymentWidgetBottomSheet.openBottomSheet(supportFragmentManager);
    }

    @Nullable
    public FlutterEngine provideFlutterEngine(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FlutterEngine flutterEngine = new FlutterEngine(context);
        flutterEngine.getNavigationChannel().setInitialRoute(SMART_LUNCH_ROUTE);
        flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        return flutterEngine;
    }

    public void sendCardDetailsToParentScreen(@NotNull WalletCardDisplayModel walletCardDisplayModel, @NotNull PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        sendCardDetailsToFlutterScreen(walletCardDisplayModel, paymentMethod);
    }

    public void sendPaymentWidgetClosedEvent(@NotNull WalletPaymentStatus walletPaymentStatus, @NotNull String str) {
        DartExecutor dartExecutor;
        BinaryMessenger binaryMessenger;
        Intrinsics.checkNotNullParameter(walletPaymentStatus, "paymentStatus");
        Intrinsics.checkNotNullParameter(str, "transactionId");
        FlutterEngine P = P();
        if (P != null && (dartExecutor = P.getDartExecutor()) != null && (binaryMessenger = dartExecutor.getBinaryMessenger()) != null) {
            new MethodChannel(binaryMessenger, "com.talabat.flutter/smart-lunch").invokeMethod("paymentWidgetClosed", Integer.valueOf(walletPaymentStatus.getValue()));
        }
    }

    public void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
    }

    public void trackEvent(@NotNull TalabatEvent talabatEvent) {
        Intrinsics.checkNotNullParameter(talabatEvent, "event");
    }

    public void updatePaymentStatus(@NotNull BottomSheetPaymentStatusModel bottomSheetPaymentStatusModel) {
        Intrinsics.checkNotNullParameter(bottomSheetPaymentStatusModel, "bottomSheetPaymentStatusModel");
        PaymentWidgetBottomSheet paymentWidgetBottomSheet = this.bottomSheet;
        if (paymentWidgetBottomSheet != null) {
            paymentWidgetBottomSheet.updatePaymentStatus(bottomSheetPaymentStatusModel);
        }
    }

    public void onBackPressedFromFlutter() {
        onBackPressed();
    }
}
