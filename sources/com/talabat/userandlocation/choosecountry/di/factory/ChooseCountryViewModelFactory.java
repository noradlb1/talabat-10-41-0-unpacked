package com.talabat.userandlocation.choosecountry.di.factory;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.userandlocation.choosecountry.di.DaggerAreasComponent;
import com.talabat.userandlocation.choosecountry.di.module.DomainModule;
import com.talabat.userandlocation.choosecountry.domain.UseCases;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.RequestAreasToCacheUseCase;
import com.talabat.userandlocation.choosecountry.presentation.StringProvider;
import com.talabat.userandlocation.choosecountry.presentation.impl.StringProviderImpl;
import com.talabat.userandlocation.choosecountry.presentation.viewmodel.ChooseCountryViewModel;
import d2.h;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/di/factory/ChooseCountryViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "activity", "Landroid/app/Activity;", "stringProvider", "Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider;", "(Landroid/app/Activity;Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider;)V", "useCases", "Lcom/talabat/userandlocation/choosecountry/domain/UseCases;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalStdlibApi
public final class ChooseCountryViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Activity activity;
    @NotNull
    private final StringProvider stringProvider;
    @NotNull
    private final UseCases useCases;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/di/factory/ChooseCountryViewModelFactory$Companion;", "", "()V", "newInstance", "Lcom/talabat/userandlocation/choosecountry/di/factory/ChooseCountryViewModelFactory;", "activity", "Landroid/app/Activity;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChooseCountryViewModelFactory newInstance(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Resources resources = activity.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
            return new ChooseCountryViewModelFactory(activity, new StringProviderImpl(resources), (DefaultConstructorMarker) null);
        }
    }

    private ChooseCountryViewModelFactory(Activity activity2, StringProvider stringProvider2) {
        this.activity = activity2;
        this.stringProvider = stringProvider2;
        Application application = activity2.getApplication();
        if (application != null) {
            ApiContainer apiContainer = (ApiContainer) application;
            Moshi moshi = ((ParserCoreLibApi) apiContainer.getFeature(ParserCoreLibApi.class)).getMoshi();
            Class cls = ConfigurationRemoteCoreLibApi.class;
            ((ConfigurationRemoteCoreLibApi) apiContainer.getFeature(cls)).getDiscoveryConfigurationRepository();
            MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi = (MutableConfigurationRemoteCoreLibApi) apiContainer.getFeature(MutableConfigurationRemoteCoreLibApi.class);
            PaymentConfigurationRepository paymentConfigurationRepository = ((ConfigurationRemoteCoreLibApi) apiContainer.getFeature(cls)).getPaymentConfigurationRepository();
            SubscriptionsFeatureApi subscriptionsFeatureApi = (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class);
            FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class);
            IObservabilityManager observabilityManager = ((ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
            CountryToOldCountryMapper countryToOldCountryMapper = new CountryToOldCountryMapper(new CityToOldCityMapper());
            RequestAreasToCacheUseCase requestAreasToCacheUseCase = DaggerAreasComponent.factory().create(featureFlagCoreLibApi, mutableConfigurationRemoteCoreLibApi).getRequestAreasToCacheUseCase();
            this.useCases = DomainModule.INSTANCE.provideUseCases$com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry(activity2, moshi, ((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class)).getRepository(), countryToOldCountryMapper, mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository(), ((MutableConfigurationLocalCoreLibApi) apiContainer.getFeature(MutableConfigurationLocalCoreLibApi.class)).getMutableRepository(), mutableConfigurationRemoteCoreLibApi.getMutableRepository(), requestAreasToCacheUseCase, paymentConfigurationRepository, subscriptionsFeatureApi.getSubscriptionsCustomerRepository(), subscriptionsFeatureApi.getGetProCentralizationStatusUseCase(), featureFlagCoreLibApi.getTalabatFeatureFlag(), observabilityManager);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    public /* synthetic */ ChooseCountryViewModelFactory(Activity activity2, StringProvider stringProvider2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2, stringProvider2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new ChooseCountryViewModel(this.useCases, this.stringProvider, (CoroutineDispatcher) null, (Function1) null, 12, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
