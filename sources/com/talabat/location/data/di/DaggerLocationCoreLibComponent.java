package com.talabat.location.data.di;

import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.gms.location.domain.GmsLocationCoreLibApi;
import com.talabat.core.gms.location.domain.GmsLocationRepository;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.hms.location.domain.HmsLocationCoreLibApi;
import com.talabat.core.hms.location.domain.HmsLocationRepository;
import com.talabat.location.data.di.LocationCoreLibComponent;
import com.talabat.location.domain.LocationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerLocationCoreLibComponent {

    public static final class Factory implements LocationCoreLibComponent.Factory {
        private Factory() {
        }

        public LocationCoreLibComponent create(GmsBaseCoreLibApi gmsBaseCoreLibApi, GmsLocationCoreLibApi gmsLocationCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, HmsLocationCoreLibApi hmsLocationCoreLibApi) {
            Preconditions.checkNotNull(gmsBaseCoreLibApi);
            Preconditions.checkNotNull(gmsLocationCoreLibApi);
            Preconditions.checkNotNull(hmsBaseCoreLibApi);
            Preconditions.checkNotNull(hmsLocationCoreLibApi);
            return new LocationCoreLibComponentImpl(gmsBaseCoreLibApi, gmsLocationCoreLibApi, hmsBaseCoreLibApi, hmsLocationCoreLibApi);
        }
    }

    public static final class LocationCoreLibComponentImpl implements LocationCoreLibComponent {
        private Provider<GmsLocationRepository> getGmsLocationRepositoryProvider;
        private Provider<HmsLocationRepository> getHmsLocationRepositoryProvider;
        private Provider<Boolean> isGmsAvailableProvider;
        private Provider<Boolean> isHmsAvailableProvider;
        private final LocationCoreLibComponentImpl locationCoreLibComponentImpl;
        private Provider<LocationRepository> locationRepositoryProvider;

        public static final class GetGmsLocationRepositoryProvider implements Provider<GmsLocationRepository> {
            private final GmsLocationCoreLibApi gmsLocationCoreLibApi;

            public GetGmsLocationRepositoryProvider(GmsLocationCoreLibApi gmsLocationCoreLibApi2) {
                this.gmsLocationCoreLibApi = gmsLocationCoreLibApi2;
            }

            public GmsLocationRepository get() {
                return (GmsLocationRepository) Preconditions.checkNotNullFromComponent(this.gmsLocationCoreLibApi.getGmsLocationRepository());
            }
        }

        public static final class GetHmsLocationRepositoryProvider implements Provider<HmsLocationRepository> {
            private final HmsLocationCoreLibApi hmsLocationCoreLibApi;

            public GetHmsLocationRepositoryProvider(HmsLocationCoreLibApi hmsLocationCoreLibApi2) {
                this.hmsLocationCoreLibApi = hmsLocationCoreLibApi2;
            }

            public HmsLocationRepository get() {
                return (HmsLocationRepository) Preconditions.checkNotNullFromComponent(this.hmsLocationCoreLibApi.getHmsLocationRepository());
            }
        }

        public static final class IsGmsAvailableProvider implements Provider<Boolean> {
            private final GmsBaseCoreLibApi gmsBaseCoreLibApi;

            public IsGmsAvailableProvider(GmsBaseCoreLibApi gmsBaseCoreLibApi2) {
                this.gmsBaseCoreLibApi = gmsBaseCoreLibApi2;
            }

            public Boolean get() {
                return Boolean.valueOf(this.gmsBaseCoreLibApi.isGmsAvailable());
            }
        }

        public static final class IsHmsAvailableProvider implements Provider<Boolean> {
            private final HmsBaseCoreLibApi hmsBaseCoreLibApi;

            public IsHmsAvailableProvider(HmsBaseCoreLibApi hmsBaseCoreLibApi2) {
                this.hmsBaseCoreLibApi = hmsBaseCoreLibApi2;
            }

            public Boolean get() {
                return Boolean.valueOf(this.hmsBaseCoreLibApi.isHmsAvailable());
            }
        }

        private LocationCoreLibComponentImpl(GmsBaseCoreLibApi gmsBaseCoreLibApi, GmsLocationCoreLibApi gmsLocationCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, HmsLocationCoreLibApi hmsLocationCoreLibApi) {
            this.locationCoreLibComponentImpl = this;
            initialize(gmsBaseCoreLibApi, gmsLocationCoreLibApi, hmsBaseCoreLibApi, hmsLocationCoreLibApi);
        }

        private void initialize(GmsBaseCoreLibApi gmsBaseCoreLibApi, GmsLocationCoreLibApi gmsLocationCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, HmsLocationCoreLibApi hmsLocationCoreLibApi) {
            this.isGmsAvailableProvider = new IsGmsAvailableProvider(gmsBaseCoreLibApi);
            this.isHmsAvailableProvider = new IsHmsAvailableProvider(hmsBaseCoreLibApi);
            this.getGmsLocationRepositoryProvider = new GetGmsLocationRepositoryProvider(gmsLocationCoreLibApi);
            GetHmsLocationRepositoryProvider getHmsLocationRepositoryProvider2 = new GetHmsLocationRepositoryProvider(hmsLocationCoreLibApi);
            this.getHmsLocationRepositoryProvider = getHmsLocationRepositoryProvider2;
            this.locationRepositoryProvider = SingleCheck.provider(LocationModule_LocationRepositoryFactory.create(this.isGmsAvailableProvider, this.isHmsAvailableProvider, this.getGmsLocationRepositoryProvider, getHmsLocationRepositoryProvider2));
        }

        public LocationRepository getLocationRepository() {
            return this.locationRepositoryProvider.get();
        }
    }

    private DaggerLocationCoreLibComponent() {
    }

    public static LocationCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
