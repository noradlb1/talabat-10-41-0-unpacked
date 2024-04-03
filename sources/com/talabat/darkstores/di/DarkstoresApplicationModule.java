package com.talabat.darkstores.di;

import android.content.Context;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.integration.IntegrationAppTracker;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.common.helpers.Base64Helper;
import com.talabat.darkstores.common.helpers.Base64Wrapper;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.impression.BannerImpressionMapper;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.di.qualifier.HeroBannerImpressionTracker;
import com.talabat.darkstores.di.qualifier.SmallBannerImpressionTracker;
import com.talabat.darkstores.feature.checkout.DarkstoresEventListener;
import com.talabat.darkstores.feature.checkout.DarkstoresListener;
import com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCase;
import com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker;
import com.talabat.darkstores.feature.observability.DarkStoreObservabilityTrackerImpl;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.DarkstoresTracker;
import com.talabat.impressiontracking.TalabatImpressionTracker;
import com.talabat.talabatnavigation.Navigator;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.ITalabatFirebase;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J*\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020\u0012H\u0007J(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J(\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J(\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010,\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020/H\u0007J\b\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u000203H\u0007¨\u00064"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresApplicationModule;", "", "()V", "provideCategoryTracker", "Lcom/talabat/darkstores/data/tracking/product/ProductTracker;", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "provideCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "provideDarkStoreObservabilityTracker", "Lcom/talabat/darkstores/feature/observability/DarkStoreObservabilityTracker;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "integrationGlobalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "getVendorLightningOptimizationExpVariantUseCase", "Lcom/talabat/darkstores/feature/home/usecase/GetVendorLightningOptimizationExpVariantUseCase;", "provideDarkstoresEventTracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "context", "Landroid/content/Context;", "talabatTracker", "locationTrackingProvider", "Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;", "provideDarkstoresListener", "Lcom/talabat/darkstores/feature/checkout/DarkstoresListener;", "gson", "Lcom/google/gson/Gson;", "provideDataModel", "provideHeroBannerProductImpressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "bannerImpressionMapper", "Lcom/talabat/darkstores/data/tracking/impression/BannerImpressionMapper;", "impressionTracker", "Lcom/talabat/impressiontracking/TalabatImpressionTracker;", "provideImpressionTracker", "provideProductImpressionTracker", "provideSmallBannerProductImpressionTracker", "provideTalabatFirebase", "Ltracking/gtm/ITalabatFirebase;", "providesBase64Helper", "Lcom/talabat/darkstores/common/helpers/Base64Helper;", "providesCustomer", "Lbuisnessmodels/Customer;", "providesTalabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresApplicationModule {
    @NotNull
    public static final DarkstoresApplicationModule INSTANCE = new DarkstoresApplicationModule();

    private DarkstoresApplicationModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final ProductTracker provideCategoryTracker(@NotNull TalabatTracker talabatTracker, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider, @NotNull ConfigurationParameters configurationParameters) {
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(configurationParameters, "configurationParameters");
        return new ProductTracker(talabatTracker, storeInfoTrackingProvider, configurationParameters);
    }

    @NotNull
    @Provides
    public final CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @NotNull
    @LibScope
    @Provides
    public final DarkStoreObservabilityTracker provideDarkStoreObservabilityTracker(@NotNull IObservabilityManager iObservabilityManager, @NotNull IntegrationGlobalDataModel.Companion companion, @NotNull ConfigurationParameters configurationParameters, @NotNull AppVersionProvider appVersionProvider, @NotNull GetVendorLightningOptimizationExpVariantUseCase getVendorLightningOptimizationExpVariantUseCase) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(companion, "integrationGlobalDataModel");
        Intrinsics.checkNotNullParameter(configurationParameters, "configurationParameters");
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(getVendorLightningOptimizationExpVariantUseCase, "getVendorLightningOptimizationExpVariantUseCase");
        return new DarkStoreObservabilityTrackerImpl(iObservabilityManager, companion, configurationParameters, appVersionProvider);
    }

    @NotNull
    @LibScope
    @Provides
    public final DarkstoresEventTracker provideDarkstoresEventTracker(@NotNull @ApplicationContext Context context, @NotNull TalabatTracker talabatTracker, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider, @NotNull LocationTrackingProvider locationTrackingProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider, "locationTrackingProvider");
        return new DarkstoresTracker(context, IntegrationAppTracker.Companion, talabatTracker, storeInfoTrackingProvider, locationTrackingProvider);
    }

    @NotNull
    @Provides
    public final DarkstoresListener provideDarkstoresListener(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new DarkstoresEventListener(Navigator.Companion, IntegrationGlobalDataModel.Companion, gson);
    }

    @NotNull
    @Provides
    public final IntegrationGlobalDataModel.Companion provideDataModel() {
        return IntegrationGlobalDataModel.Companion;
    }

    @NotNull
    @HeroBannerImpressionTracker
    @Provides
    public final ProductImpressionTracker provideHeroBannerProductImpressionTracker(@NotNull BannerImpressionMapper bannerImpressionMapper, @NotNull TalabatImpressionTracker talabatImpressionTracker, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider, @NotNull LocationTrackingProvider locationTrackingProvider) {
        Intrinsics.checkNotNullParameter(bannerImpressionMapper, "bannerImpressionMapper");
        Intrinsics.checkNotNullParameter(talabatImpressionTracker, "impressionTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider, "locationTrackingProvider");
        return new ProductImpressionTracker(bannerImpressionMapper, talabatImpressionTracker, storeInfoTrackingProvider, locationTrackingProvider);
    }

    @NotNull
    @Provides
    public final TalabatImpressionTracker provideImpressionTracker(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        return new TalabatImpressionTracker(talabatTracker, true);
    }

    @NotNull
    @Provides
    public final ProductImpressionTracker provideProductImpressionTracker(@NotNull BannerImpressionMapper bannerImpressionMapper, @NotNull TalabatImpressionTracker talabatImpressionTracker, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider, @NotNull LocationTrackingProvider locationTrackingProvider) {
        Intrinsics.checkNotNullParameter(bannerImpressionMapper, "bannerImpressionMapper");
        Intrinsics.checkNotNullParameter(talabatImpressionTracker, "impressionTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider, "locationTrackingProvider");
        return new ProductImpressionTracker(bannerImpressionMapper, talabatImpressionTracker, storeInfoTrackingProvider, locationTrackingProvider);
    }

    @NotNull
    @SmallBannerImpressionTracker
    @Provides
    public final ProductImpressionTracker provideSmallBannerProductImpressionTracker(@NotNull BannerImpressionMapper bannerImpressionMapper, @NotNull TalabatImpressionTracker talabatImpressionTracker, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider, @NotNull LocationTrackingProvider locationTrackingProvider) {
        Intrinsics.checkNotNullParameter(bannerImpressionMapper, "bannerImpressionMapper");
        Intrinsics.checkNotNullParameter(talabatImpressionTracker, "impressionTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider, "locationTrackingProvider");
        return new ProductImpressionTracker(bannerImpressionMapper, talabatImpressionTracker, storeInfoTrackingProvider, locationTrackingProvider);
    }

    @NotNull
    @Provides
    public final ITalabatFirebase provideTalabatFirebase() {
        return new TalabatFirebase();
    }

    @NotNull
    @LibScope
    @Provides
    public final Base64Helper providesBase64Helper() {
        return new Base64Helper(new Base64Wrapper());
    }

    @NotNull
    @Provides
    public final Customer providesCustomer() {
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    @Provides
    public final ITalabatExperiment providesTalabatExperiment() {
        return TalabatExperiment.INSTANCE;
    }
}
