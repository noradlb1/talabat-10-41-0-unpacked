package com.talabat.fluttercore.channels;

import androidx.core.app.NotificationCompat;
import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.data.googleclientid.GoogleClientIdProvider;
import com.talabat.fluttercore.domain.entities.FlutterConfigKt;
import com.talabat.location.FlutterUserLocationMapperKt;
import com.talabat.location.SelectedLocationProvider;
import com.talabat.location.UserLocation;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.datalayerLogger.DatalayerModel;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/fluttercore/channels/GlobalMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "selectedLocationProvider", "Lcom/talabat/location/SelectedLocationProvider;", "deviceIdProvider", "Lcom/talabat/application/device/id/domain/DeviceIdProvider;", "googleClientIdProvider", "Lcom/talabat/data/googleclientid/GoogleClientIdProvider;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "termsAndConditionsConfigurationRepository", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/location/SelectedLocationProvider;Lcom/talabat/application/device/id/domain/DeviceIdProvider;Lcom/talabat/data/googleclientid/GoogleClientIdProvider;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "globalMethodChannelCallback", "Lcom/talabat/fluttercore/channels/GlobalMethodChannelCallback;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onSetBottomNavigationOff", "onSetBottomNavigationOn", "setCallback", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Don't extend, pass data using :core:configuration:remote method channels")
public final class GlobalMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final String BACK_NAVIGATION_ACTION = "backNavigation";
    @NotNull
    private static final String CONFIGS_ACTION_METHOD_CALL = "configs";
    @NotNull
    private static final String CURRENT_ADDRESS_METHOD_CALL = "currentAddress";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ENVIRONMENT_ACTION_METHOD_CALL = "environment";
    @NotNull
    private static final String SET_BOTTOM_NAVIGATION_OFF = "setBottomNavigationOff";
    @NotNull
    private static final String SET_BOTTOM_NAVIGATION_ON = "setBottomNavigationOn";
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final DeviceIdProvider deviceIdProvider;
    @Nullable
    private GlobalMethodChannelCallback globalMethodChannelCallback;
    @NotNull
    private final GoogleClientIdProvider googleClientIdProvider;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private final SelectedLocationProvider selectedLocationProvider;
    @NotNull
    private final TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/fluttercore/channels/GlobalMethodChannel$Companion;", "", "()V", "BACK_NAVIGATION_ACTION", "", "CONFIGS_ACTION_METHOD_CALL", "CURRENT_ADDRESS_METHOD_CALL", "ENVIRONMENT_ACTION_METHOD_CALL", "SET_BOTTOM_NAVIGATION_OFF", "SET_BOTTOM_NAVIGATION_ON", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GlobalMethodChannel(@NotNull AppVersionProvider appVersionProvider2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull SelectedLocationProvider selectedLocationProvider2, @NotNull DeviceIdProvider deviceIdProvider2, @NotNull GoogleClientIdProvider googleClientIdProvider2, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(selectedLocationProvider2, "selectedLocationProvider");
        Intrinsics.checkNotNullParameter(deviceIdProvider2, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(googleClientIdProvider2, "googleClientIdProvider");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(termsAndConditionsConfigurationRepository2, "termsAndConditionsConfigurationRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.selectedLocationProvider = selectedLocationProvider2;
        this.deviceIdProvider = deviceIdProvider2;
        this.googleClientIdProvider = googleClientIdProvider2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    private final void onSetBottomNavigationOff() {
        LogManager.debug("Native method:setBottomNavigationOff");
        GlobalMethodChannelCallback globalMethodChannelCallback2 = this.globalMethodChannelCallback;
        if (globalMethodChannelCallback2 != null) {
            globalMethodChannelCallback2.onSetBottomNavigation(false);
        }
    }

    private final void onSetBottomNavigationOn() {
        LogManager.debug("Native method:setBottomNavigationOn");
        GlobalMethodChannelCallback globalMethodChannelCallback2 = this.globalMethodChannelCallback;
        if (globalMethodChannelCallback2 != null) {
            globalMethodChannelCallback2.onSetBottomNavigation(true);
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1593748850:
                    if (str.equals(SET_BOTTOM_NAVIGATION_OFF)) {
                        onSetBottomNavigationOff();
                        return;
                    }
                    break;
                case -240241061:
                    if (str.equals(BACK_NAVIGATION_ACTION)) {
                        Object obj = methodCall.arguments;
                        LogManager.debug(BACK_NAVIGATION_ACTION + obj);
                        Object obj2 = methodCall.arguments;
                        if (obj2 != null) {
                            GlobalMethodChannelCallback globalMethodChannelCallback2 = this.globalMethodChannelCallback;
                            if (globalMethodChannelCallback2 != null) {
                                Intrinsics.checkNotNullExpressionValue(obj2, "call.arguments");
                                globalMethodChannelCallback2.onBackPressedFromFlutter(obj2);
                                return;
                            }
                            return;
                        }
                        GlobalMethodChannelCallback globalMethodChannelCallback3 = this.globalMethodChannelCallback;
                        if (globalMethodChannelCallback3 != null) {
                            globalMethodChannelCallback3.onBackPressedFromFlutter();
                            return;
                        }
                        return;
                    }
                    break;
                case -85904877:
                    if (str.equals("environment")) {
                        String environment = FlutterConfigKt.getEnvironment();
                        LogManager.debug("environment" + environment);
                        result.success(environment);
                        return;
                    }
                    break;
                case 502778080:
                    if (str.equals(SET_BOTTOM_NAVIGATION_ON)) {
                        onSetBottomNavigationOn();
                        return;
                    }
                    break;
                case 951117169:
                    if (str.equals(CONFIGS_ACTION_METHOD_CALL)) {
                        Map<String, Object> map2 = FlutterConfigKt.toMap(FlutterConfigKt.getFlutterConfig(this.appVersionProvider, this.configurationLocalRepository, this.locationConfigurationRepository, this.deviceIdProvider, this.googleClientIdProvider, this.paymentConfigurationRepository.walletConfig(), this.termsAndConditionsConfigurationRepository.config(), this.observabilityManager, DatalayerModel.INSTANCE));
                        LogManager.debug(CONFIGS_ACTION_METHOD_CALL + map2);
                        result.success(map2);
                        return;
                    }
                    break;
                case 1557400635:
                    if (str.equals(CURRENT_ADDRESS_METHOD_CALL)) {
                        UserLocation selectedUserLocation = this.selectedLocationProvider.getSelectedUserLocation();
                        if (selectedUserLocation != null) {
                            map = FlutterUserLocationMapperKt.toFlutterMap(selectedUserLocation);
                        } else {
                            map = null;
                        }
                        LogManager.debug(CURRENT_ADDRESS_METHOD_CALL + map);
                        result.success(map);
                        return;
                    }
                    break;
            }
        }
        Object obj3 = methodCall.arguments;
        LogManager.debug("Not Implemented" + obj3);
    }

    public final void setCallback(@Nullable GlobalMethodChannelCallback globalMethodChannelCallback2) {
        this.globalMethodChannelCallback = globalMethodChannelCallback2;
    }
}
