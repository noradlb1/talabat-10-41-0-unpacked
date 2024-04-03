package com.talabat.core.observabilityNew.data.di;

import android.app.Application;
import android.content.Context;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingAttributesProvider;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.data.di.ObservabilityCoreLibComponent;
import com.talabat.core.observabilityNew.domain.IAppLaunchTrackingManager;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IPerformanceTracker;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ITimeTracker;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.observabilityNew.ObservabilityManager;
import com.talabat.observabilityNew.ObservabilityManager_Factory;
import com.talabat.observabilityNew.performance.FirebasePerformanceProviderInitializer;
import com.talabat.observabilityNew.performance.FirebasePerformanceProviderInitializer_Factory;
import com.talabat.observabilityNew.performance.PerformanceAttributesProvider;
import com.talabat.observabilityNew.performance.PerformanceAttributesProvider_Factory;
import com.talabat.observabilityNew.performance.PerformanceTracker;
import com.talabat.observabilityNew.performance.PerformanceTracker_Factory;
import com.talabat.observabilityNew.performance.PerformanceTrackingInitializer;
import com.talabat.observabilityNew.screentracker.ScreenTracker;
import com.talabat.observabilityNew.screentracker.ScreenTracker_Factory;
import com.talabat.observabilityNew.squads.discovery.AppLaunchTrackingManager;
import com.talabat.observabilityNew.squads.discovery.AppLaunchTrackingManager_Factory;
import com.talabat.observabilityNew.tracker.IObservabilityTracker;
import com.talabat.observabilityNew.tracker.TimeTrackerImplementation;
import com.talabat.observabilityNew.tracker.TimeTrackerImplementation_Factory;
import com.talabat.observabilityNew.tracker.TimeTrackingData;
import com.talabat.observabilityNew.tracker.impl.NewRelicObservabilityTracker_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.HashMap;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerObservabilityCoreLibComponent {

    public static final class Factory implements ObservabilityCoreLibComponent.Factory {
        private Factory() {
        }

        public ObservabilityCoreLibComponent create(ContextCoreLibApi contextCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(talabatPerseusCoreLibApi);
            return new ObservabilityCoreLibComponentImpl(contextCoreLibApi, talabatPerseusCoreLibApi);
        }
    }

    public static final class ObservabilityCoreLibComponentImpl implements ObservabilityCoreLibComponent {
        private Provider<AppLaunchTrackingManager> appLaunchTrackingManagerProvider;
        private Provider<IAppLaunchTrackingManager> appLaunchTrackingManagerProvider2;
        private Provider<PerformanceTrackingInitializer> firebasePerformanceInitializerProvider;
        private Provider<FirebasePerformanceProviderInitializer> firebasePerformanceProviderInitializerProvider;
        private Provider<Application> getApplicationProvider;
        private Provider<Context> getContextProvider;
        private Provider<TalabatPerseusRepository> getTalabatPerseusRepositoryProvider;
        private final ObservabilityCoreLibComponentImpl observabilityCoreLibComponentImpl;
        private Provider<ObservabilityManager> observabilityManagerProvider;
        private Provider<IObservabilityManager> observabilityManagerProvider2;
        private Provider<ITimeTracker> observabilityManagerProvider3;
        private Provider<IObservabilityTracker> observabilityTrackerProvider;
        private Provider<PerformanceAttributesProvider> performanceAttributesProvider;
        private Provider<PerformanceTrackingAttributesProvider> performanceAttributesProvider2;
        private Provider<PerformanceTrackingManager> performanceTrackerManagerProvider;
        private Provider<PerformanceTracker> performanceTrackerProvider;
        private Provider<IPerformanceTracker> performanceTrackerProvider2;
        private Provider<IScreenTracker> performanceTrackerProvider3;
        private Provider<ScreenTracker> screenTrackerProvider;
        private Provider<HashMap<Object, TimeTrackingData>> timeCachesHashMapProvider;
        private Provider<TimeTrackerImplementation> timeTrackerImplementationProvider;

        public static final class GetApplicationProvider implements Provider<Application> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetApplicationProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Application get() {
                return (Application) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getApplication());
            }
        }

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetTalabatPerseusRepositoryProvider implements Provider<TalabatPerseusRepository> {
            private final TalabatPerseusCoreLibApi talabatPerseusCoreLibApi;

            public GetTalabatPerseusRepositoryProvider(TalabatPerseusCoreLibApi talabatPerseusCoreLibApi2) {
                this.talabatPerseusCoreLibApi = talabatPerseusCoreLibApi2;
            }

            public TalabatPerseusRepository get() {
                return (TalabatPerseusRepository) Preconditions.checkNotNullFromComponent(this.talabatPerseusCoreLibApi.getTalabatPerseusRepository());
            }
        }

        private ObservabilityCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            this.observabilityCoreLibComponentImpl = this;
            initialize(contextCoreLibApi, talabatPerseusCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            Provider<IObservabilityTracker> provider = SingleCheck.provider(NewRelicObservabilityTracker_Factory.create());
            this.observabilityTrackerProvider = provider;
            ObservabilityManager_Factory create = ObservabilityManager_Factory.create(provider);
            this.observabilityManagerProvider = create;
            Provider<IObservabilityManager> provider2 = SingleCheck.provider(create);
            this.observabilityManagerProvider2 = provider2;
            AppLaunchTrackingManager_Factory create2 = AppLaunchTrackingManager_Factory.create(provider2);
            this.appLaunchTrackingManagerProvider = create2;
            this.appLaunchTrackingManagerProvider2 = SingleCheck.provider(create2);
            this.getApplicationProvider = new GetApplicationProvider(contextCoreLibApi);
            GetTalabatPerseusRepositoryProvider getTalabatPerseusRepositoryProvider2 = new GetTalabatPerseusRepositoryProvider(talabatPerseusCoreLibApi);
            this.getTalabatPerseusRepositoryProvider = getTalabatPerseusRepositoryProvider2;
            PerformanceAttributesProvider_Factory create3 = PerformanceAttributesProvider_Factory.create(getTalabatPerseusRepositoryProvider2);
            this.performanceAttributesProvider = create3;
            Provider<PerformanceTrackingAttributesProvider> provider3 = SingleCheck.provider(PerformanceTrackerModule_PerformanceAttributesProviderFactory.create(create3));
            this.performanceAttributesProvider2 = provider3;
            this.performanceTrackerManagerProvider = SingleCheck.provider(PerformanceTrackerModule_PerformanceTrackerManagerFactory.create(provider3));
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            FirebasePerformanceProviderInitializer_Factory create4 = FirebasePerformanceProviderInitializer_Factory.create(getContextProvider2);
            this.firebasePerformanceProviderInitializerProvider = create4;
            Provider<PerformanceTrackingInitializer> provider4 = SingleCheck.provider(PerformanceTrackerModule_FirebasePerformanceInitializerFactory.create(create4));
            this.firebasePerformanceInitializerProvider = provider4;
            PerformanceTracker_Factory create5 = PerformanceTracker_Factory.create(this.getApplicationProvider, this.performanceTrackerManagerProvider, provider4);
            this.performanceTrackerProvider = create5;
            this.performanceTrackerProvider2 = SingleCheck.provider(PerformanceTrackerModule_PerformanceTrackerFactory.create(create5));
            ScreenTracker_Factory create6 = ScreenTracker_Factory.create(this.performanceTrackerManagerProvider, this.firebasePerformanceInitializerProvider);
            this.screenTrackerProvider = create6;
            this.performanceTrackerProvider3 = SingleCheck.provider(ScreenTrackerModule_PerformanceTrackerFactory.create(create6));
            Provider<HashMap<Object, TimeTrackingData>> provider5 = SingleCheck.provider(TimeTrackerModule_Companion_TimeCachesHashMapFactory.create());
            this.timeCachesHashMapProvider = provider5;
            TimeTrackerImplementation_Factory create7 = TimeTrackerImplementation_Factory.create(provider5, this.observabilityManagerProvider);
            this.timeTrackerImplementationProvider = create7;
            this.observabilityManagerProvider3 = SingleCheck.provider(create7);
        }

        public IAppLaunchTrackingManager getAppLaunchTrackingManager() {
            return this.appLaunchTrackingManagerProvider2.get();
        }

        public IObservabilityManager getObservabilityManager() {
            return this.observabilityManagerProvider2.get();
        }

        public IPerformanceTracker getPerformanceTracker() {
            return this.performanceTrackerProvider2.get();
        }

        public IScreenTracker getScreenTracker() {
            return this.performanceTrackerProvider3.get();
        }

        public ITimeTracker getTimeTracker() {
            return this.observabilityManagerProvider3.get();
        }
    }

    private DaggerObservabilityCoreLibComponent() {
    }

    public static ObservabilityCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
