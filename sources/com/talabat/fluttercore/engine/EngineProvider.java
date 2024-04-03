package com.talabat.fluttercore.engine;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.data.googleclientid.GoogleClientIdLocalStorage;
import com.talabat.fluttercore.channels.ExperimentMethodChannel;
import com.talabat.fluttercore.channels.GlobalMethodChannel;
import com.talabat.fluttercore.channels.ObservabilityMethodChannel;
import com.talabat.location.SelectedLocationProviderImpl;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/fluttercore/engine/EngineProvider;", "", "context", "Landroid/content/Context;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "termsAndConditionsConfigurationRepository", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Landroid/content/Context;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;Lcom/talabat/core/observabilityNew/domain/IScreenTracker;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "provideFlutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "entryPoint", "", "setupConfigChannel", "", "flutterEngine", "setupExperimentChannel", "setupObservabilityChannel", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EngineProvider {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private final IScreenTracker screenTracker;
    @NotNull
    private final TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository;

    @Inject
    public EngineProvider(@NotNull @ApplicationContext Context context2, @NotNull AppVersionProvider appVersionProvider2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2, @NotNull IScreenTracker iScreenTracker, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(termsAndConditionsConfigurationRepository2, "termsAndConditionsConfigurationRepository");
        Intrinsics.checkNotNullParameter(iScreenTracker, "screenTracker");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.context = context2;
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository2;
        this.screenTracker = iScreenTracker;
        this.observabilityManager = iObservabilityManager;
    }

    private final void setupConfigChannel(Context context2, FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.CONFIG_CHANNEL);
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        methodChannel.setMethodCallHandler(new GlobalMethodChannel(this.appVersionProvider, this.configurationLocalRepository, this.locationConfigurationRepository, new SelectedLocationProviderImpl(instance), new DeviceIdProviderImpl(context2), GoogleClientIdLocalStorage.INSTANCE, this.paymentConfigurationRepository, this.termsAndConditionsConfigurationRepository, this.observabilityManager));
    }

    private final void setupExperimentChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.EXPERIMENT_CHANNEL).setMethodCallHandler(new ExperimentMethodChannel());
    }

    private final void setupObservabilityChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.OBSERVABILITY_CHANNEL).setMethodCallHandler(new ObservabilityMethodChannel(new ObservabilityMethodChannelCallbackImpl(this.context), this.screenTracker));
    }

    @NotNull
    public final FlutterEngine provideFlutterEngine(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        FlutterEngine flutterEngine = new FlutterEngine(this.context);
        flutterEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), str));
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        setupConfigChannel(this.context, flutterEngine);
        setupObservabilityChannel(flutterEngine);
        setupExperimentChannel(flutterEngine);
        return flutterEngine;
    }
}
