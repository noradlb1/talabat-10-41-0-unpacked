package com.talabat.di;

import android.app.Activity;
import com.talabat.AddAddressScreen2;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.addressV2.AddAddressScreen2Module;
import org.jetbrains.annotations.NotNull;

@Component(dependencies = {ConfigurationLocalCoreLibApi.class, MutableConfigurationRemoteCoreLibApi.class, MapsCoreLibApi.class, PinlessCheckoutCoreLibApi.class, TrackingCoreLibApi.class, FeatureFlagCoreLibApi.class}, modules = {AddAddressScreen2Module.class})
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/talabat/di/AddAddressScreen2Component;", "", "inject", "", "addAddressScreen2", "Lcom/talabat/AddAddressScreen2;", "Companion", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AddAddressScreen2Component {
    @NotNull
    public static final Companion Companion = Companion.f58318a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/di/AddAddressScreen2Component$Companion;", "", "()V", "injectToScreen", "", "screen", "Lcom/talabat/AddAddressScreen2;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f58318a = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final void injectToScreen(@NotNull AddAddressScreen2 addAddressScreen2) {
            Intrinsics.checkNotNullParameter(addAddressScreen2, "screen");
            ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Activity) addAddressScreen2);
            DaggerAddAddressScreen2Component.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (MutableConfigurationRemoteCoreLibApi) apiContainer.getFeature(MutableConfigurationRemoteCoreLibApi.class), (MapsCoreLibApi) apiContainer.getFeature(MapsCoreLibApi.class), (PinlessCheckoutCoreLibApi) apiContainer.getFeature(PinlessCheckoutCoreLibApi.class), (TrackingCoreLibApi) apiContainer.getFeature(TrackingCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), TalabatExperiment.INSTANCE).inject(addAddressScreen2);
        }
    }

    @Component.Factory
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/di/AddAddressScreen2Component$Factory;", "", "create", "Lcom/talabat/di/AddAddressScreen2Component;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "mutableConfigurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "mapsCoreLibApi", "Lcom/talabat/maps/domain/di/MapsCoreLibApi;", "pinlessCheckoutCoreLibApi", "Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        AddAddressScreen2Component create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, @NotNull MapsCoreLibApi mapsCoreLibApi, @NotNull PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull @BindsInstance ITalabatExperiment iTalabatExperiment);
    }

    void inject(@NotNull AddAddressScreen2 addAddressScreen2);
}
