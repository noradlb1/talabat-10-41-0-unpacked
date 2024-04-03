package com.talabat.core.pinless.checkout.data;

import android.content.Context;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.pinless.checkout.data.PinlessCheckoutCoreLibComponent;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutFeatureRepository;
import com.talabat.core.pinless.checkout.domain.SetHasUserPinnedLocationInOnboardingMapUseCase;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerPinlessCheckoutCoreLibComponent {

    public static final class Factory implements PinlessCheckoutCoreLibComponent.Factory {
        private Factory() {
        }

        public PinlessCheckoutCoreLibComponent create(ContextCoreLibApi contextCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new PinlessCheckoutCoreLibComponentImpl(trackingCoreLibApi, contextCoreLibApi);
        }
    }

    public static final class PinlessCheckoutCoreLibComponentImpl implements PinlessCheckoutCoreLibComponent {
        private Provider<Context> getContextProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private final PinlessCheckoutCoreLibComponentImpl pinlessCheckoutCoreLibComponentImpl;
        private Provider<PinlessCheckoutRepository> pinlessCheckoutRepositoryProvider;
        private Provider<PinlessCheckoutFeatureRepository> providePinlessCheckoutFeatureRepository$com_talabat_core_pinless_checkout_data_dataProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
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

        private PinlessCheckoutCoreLibComponentImpl(TrackingCoreLibApi trackingCoreLibApi, ContextCoreLibApi contextCoreLibApi) {
            this.pinlessCheckoutCoreLibComponentImpl = this;
            initialize(trackingCoreLibApi, contextCoreLibApi);
        }

        private GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap getHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap() {
            return new GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap(this.providePinlessCheckoutFeatureRepository$com_talabat_core_pinless_checkout_data_dataProvider.get());
        }

        private void initialize(TrackingCoreLibApi trackingCoreLibApi, ContextCoreLibApi contextCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            PinlessCheckoutRepository_Factory create = PinlessCheckoutRepository_Factory.create(this.getContextProvider, getTalabatTrackerProvider2);
            this.pinlessCheckoutRepositoryProvider = create;
            this.providePinlessCheckoutFeatureRepository$com_talabat_core_pinless_checkout_data_dataProvider = SingleCheck.provider(create);
        }

        public GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase getGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase() {
            return getHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap();
        }

        public SetHasUserPinnedLocationInOnboardingMapUseCase getSetHasUserPinnedLocationInOnboardingMapUseCase() {
            return getHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap();
        }
    }

    private DaggerPinlessCheckoutCoreLibComponent() {
    }

    public static PinlessCheckoutCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
