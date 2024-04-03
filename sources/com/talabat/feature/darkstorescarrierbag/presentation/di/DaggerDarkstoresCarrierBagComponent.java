package com.talabat.feature.darkstorescarrierbag.presentation.di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.ViewModelGenericFactory;
import com.talabat.core.ui.di.ViewModelGenericFactory_Factory;
import com.talabat.feature.darkstorescarrierbag.data.DarkstoresCarrierBagRepositoryImpl;
import com.talabat.feature.darkstorescarrierbag.data.DarkstoresCarrierBagRepositoryImpl_Factory;
import com.talabat.feature.darkstorescarrierbag.data.datasource.DarkstoresCarrierBagLocalDataSource;
import com.talabat.feature.darkstorescarrierbag.data.datasource.DarkstoresCarrierBagLocalDataSource_Factory;
import com.talabat.feature.darkstorescarrierbag.domain.repository.DarkstoresCarrierBagRepository;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SendDarkstoresCarrierBagEvent;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SendDarkstoresCarrierBagEventImpl;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SendDarkstoresCarrierBagEventImpl_Factory;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SetDarkstoresCarrierBagFakeDoorTestShown;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SetDarkstoresCarrierBagFakeDoorTestShownImpl;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SetDarkstoresCarrierBagFakeDoorTestShownImpl_Factory;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.ShouldShowDarkstoresCarrierBagFakeDoorTest;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.ShouldShowDarkstoresCarrierBagFakeDoorTestImpl;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.ShouldShowDarkstoresCarrierBagFakeDoorTestImpl_Factory;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagManager;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagManager_MembersInjector;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagViewModel;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagViewModel_Factory;
import com.talabat.feature.darkstorescarrierbag.presentation.di.DarkstoresCarrierBagComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerDarkstoresCarrierBagComponent {

    public static final class DarkstoresCarrierBagComponentImpl implements DarkstoresCarrierBagComponent {
        private Provider<SendDarkstoresCarrierBagEvent> bindSendDarkstoresCarrierBagEventProvider;
        private Provider<SetDarkstoresCarrierBagFakeDoorTestShown> bindSetDarkstoresCarrierBagFakeDoorTestShownProvider;
        private Provider<ShouldShowDarkstoresCarrierBagFakeDoorTest> bindShouldShowDarkstoresCarrierBagFakeDoorTestProvider;
        private Provider<ViewModelProvider.Factory> bindViewModelFactoryProvider;
        private final DarkstoresCarrierBagComponentImpl darkstoresCarrierBagComponentImpl;
        private Provider<DarkstoresCarrierBagLocalDataSource> darkstoresCarrierBagLocalDataSourceProvider;
        private Provider<DarkstoresCarrierBagRepositoryImpl> darkstoresCarrierBagRepositoryImplProvider;
        private Provider<DarkstoresCarrierBagViewModel> darkstoresCarrierBagViewModelProvider;
        private Provider<Context> getContextProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<RxSchedulersFactory> getRxSchedulersFactoryProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
        private Provider<DarkstoresCarrierBagRepository> provideRepositoryProvider;
        private Provider<SharedPreferences> provideSharedPreferencesProvider;
        private Provider<SendDarkstoresCarrierBagEventImpl> sendDarkstoresCarrierBagEventImplProvider;
        private Provider<SetDarkstoresCarrierBagFakeDoorTestShownImpl> setDarkstoresCarrierBagFakeDoorTestShownImplProvider;
        private Provider<ShouldShowDarkstoresCarrierBagFakeDoorTestImpl> shouldShowDarkstoresCarrierBagFakeDoorTestImplProvider;
        private Provider<String> vendorCodeProvider;
        private Provider<ViewModelGenericFactory> viewModelGenericFactoryProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetRxSchedulersFactoryProvider implements Provider<RxSchedulersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetRxSchedulersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public RxSchedulersFactory get() {
                return (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory());
            }
        }

        public static final class GetTalabatTrackerProvider implements Provider<TalabatTracker> {
            private final TrackingCoreLibApi trackingCoreLibApi;

            public GetTalabatTrackerProvider(TrackingCoreLibApi trackingCoreLibApi2) {
                this.trackingCoreLibApi = trackingCoreLibApi2;
            }

            public TalabatTracker get() {
                return (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker());
            }
        }

        private DarkstoresCarrierBagComponentImpl(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, String str) {
            this.darkstoresCarrierBagComponentImpl = this;
            initialize(contextCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, trackingCoreLibApi, str);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, String str) {
            this.getExperimentProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            DarkstoresTooltipDataModule_ProvideSharedPreferencesFactory create = DarkstoresTooltipDataModule_ProvideSharedPreferencesFactory.create(getContextProvider2);
            this.provideSharedPreferencesProvider = create;
            DarkstoresCarrierBagLocalDataSource_Factory create2 = DarkstoresCarrierBagLocalDataSource_Factory.create(create);
            this.darkstoresCarrierBagLocalDataSourceProvider = create2;
            DarkstoresCarrierBagRepositoryImpl_Factory create3 = DarkstoresCarrierBagRepositoryImpl_Factory.create(create2);
            this.darkstoresCarrierBagRepositoryImplProvider = create3;
            Provider<DarkstoresCarrierBagRepository> provider = SingleCheck.provider(DarkstoresTooltipDataModule_ProvideRepositoryFactory.create(create3));
            this.provideRepositoryProvider = provider;
            ShouldShowDarkstoresCarrierBagFakeDoorTestImpl_Factory create4 = ShouldShowDarkstoresCarrierBagFakeDoorTestImpl_Factory.create(this.getExperimentProvider, provider);
            this.shouldShowDarkstoresCarrierBagFakeDoorTestImplProvider = create4;
            this.bindShouldShowDarkstoresCarrierBagFakeDoorTestProvider = SingleCheck.provider(create4);
            SetDarkstoresCarrierBagFakeDoorTestShownImpl_Factory create5 = SetDarkstoresCarrierBagFakeDoorTestShownImpl_Factory.create(this.provideRepositoryProvider);
            this.setDarkstoresCarrierBagFakeDoorTestShownImplProvider = create5;
            this.bindSetDarkstoresCarrierBagFakeDoorTestShownProvider = SingleCheck.provider(create5);
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            SendDarkstoresCarrierBagEventImpl_Factory create6 = SendDarkstoresCarrierBagEventImpl_Factory.create(getTalabatTrackerProvider2);
            this.sendDarkstoresCarrierBagEventImplProvider = create6;
            this.bindSendDarkstoresCarrierBagEventProvider = SingleCheck.provider(create6);
            this.getRxSchedulersFactoryProvider = new GetRxSchedulersFactoryProvider(dispatcherCoreLibApi);
            dagger.internal.Factory create7 = InstanceFactory.create(str);
            this.vendorCodeProvider = create7;
            this.darkstoresCarrierBagViewModelProvider = DarkstoresCarrierBagViewModel_Factory.create(this.bindShouldShowDarkstoresCarrierBagFakeDoorTestProvider, this.bindSetDarkstoresCarrierBagFakeDoorTestShownProvider, this.bindSendDarkstoresCarrierBagEventProvider, this.getRxSchedulersFactoryProvider, create7);
            MapProviderFactory build = MapProviderFactory.builder(1).put((Object) DarkstoresCarrierBagViewModel.class, (Provider) this.darkstoresCarrierBagViewModelProvider).build();
            this.mapOfClassOfAndProviderOfViewModelProvider = build;
            ViewModelGenericFactory_Factory create8 = ViewModelGenericFactory_Factory.create(build);
            this.viewModelGenericFactoryProvider = create8;
            this.bindViewModelFactoryProvider = SingleCheck.provider(create8);
        }

        private DarkstoresCarrierBagManager injectDarkstoresCarrierBagManager(DarkstoresCarrierBagManager darkstoresCarrierBagManager) {
            DarkstoresCarrierBagManager_MembersInjector.injectViewModelFactory(darkstoresCarrierBagManager, this.bindViewModelFactoryProvider.get());
            return darkstoresCarrierBagManager;
        }

        public void inject(DarkstoresCarrierBagManager darkstoresCarrierBagManager) {
            injectDarkstoresCarrierBagManager(darkstoresCarrierBagManager);
        }
    }

    public static final class Factory implements DarkstoresCarrierBagComponent.Factory {
        private Factory() {
        }

        public DarkstoresCarrierBagComponent create(String str, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new DarkstoresCarrierBagComponentImpl(contextCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, trackingCoreLibApi, str);
        }
    }

    private DaggerDarkstoresCarrierBagComponent() {
    }

    public static DarkstoresCarrierBagComponent.Factory factory() {
        return new Factory();
    }
}
