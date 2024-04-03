package com.talabat.maps.data.di;

import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.gms.maps.domain.GmsCameraUpdateFactory;
import com.talabat.gms.maps.domain.GmsLatLngFactory;
import com.talabat.gms.maps.domain.GmsMapsInitializer;
import com.talabat.gms.maps.domain.GmsMapsViewsRepository;
import com.talabat.gms.maps.domain.GmsModelsRepository;
import com.talabat.gms.maps.domain.di.GmsMapsCoreLibApi;
import com.talabat.hms.maps.domain.HmsCameraUpdateFactory;
import com.talabat.hms.maps.domain.HmsLatLngFactory;
import com.talabat.hms.maps.domain.HmsMapsInitializer;
import com.talabat.hms.maps.domain.HmsMapsViewsRepository;
import com.talabat.hms.maps.domain.HmsModelsRepository;
import com.talabat.hms.maps.domain.di.HmsMapsCoreLibApi;
import com.talabat.maps.data.di.MapsCoreLibComponent;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapType;
import com.talabat.maps.domain.MapViewsRepository;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerMapsCoreLibComponent {

    public static final class Factory implements MapsCoreLibComponent.Factory {
        private Factory() {
        }

        public MapsCoreLibComponent create(GmsBaseCoreLibApi gmsBaseCoreLibApi, GmsMapsCoreLibApi gmsMapsCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, HmsMapsCoreLibApi hmsMapsCoreLibApi) {
            Preconditions.checkNotNull(gmsBaseCoreLibApi);
            Preconditions.checkNotNull(gmsMapsCoreLibApi);
            Preconditions.checkNotNull(hmsBaseCoreLibApi);
            Preconditions.checkNotNull(hmsMapsCoreLibApi);
            return new MapsCoreLibComponentImpl(gmsBaseCoreLibApi, gmsMapsCoreLibApi, hmsBaseCoreLibApi, hmsMapsCoreLibApi);
        }
    }

    public static final class MapsCoreLibComponentImpl implements MapsCoreLibComponent {
        private Provider<CameraUpdateFactory> cameraUpdateFactoryProvider;
        private Provider<GmsCameraUpdateFactory> getGmsCameraUpdateFactoryProvider;
        private Provider<GmsLatLngFactory> getGmsLatLngFactoryProvider;
        private Provider<GmsMapsInitializer> getGmsMapsInitializerProvider;
        private Provider<GmsMapsViewsRepository> getGmsMapsViewsRepositoryProvider;
        private Provider<GmsModelsRepository> getGmsModelsRepositoryProvider;
        private Provider<HmsCameraUpdateFactory> getHmsCameraUpdateFactoryProvider;
        private Provider<HmsLatLngFactory> getHmsLatLngFactoryProvider;
        private Provider<HmsMapsInitializer> getHmsMapsInitializerProvider;
        private Provider<HmsMapsViewsRepository> getHmsMapsViewsRepositoryProvider;
        private Provider<HmsModelsRepository> getHmsModelsRepositoryProvider;
        private Provider<Boolean> isGmsAvailableProvider;
        private Provider<Boolean> isHmsAvailableProvider;
        private Provider<LatLngFactory> latLngFactoryProvider;
        private Provider<MapType> mapTypeProvider;
        private Provider<MapViewsRepository> mapViewsRepositoryProvider;
        private final MapsCoreLibComponentImpl mapsCoreLibComponentImpl;
        private Provider<MapsInitializer> mapsInitializerProvider;
        private Provider<ModelsRepository> modelsRepositoryProvider;

        public static final class GetGmsCameraUpdateFactoryProvider implements Provider<GmsCameraUpdateFactory> {
            private final GmsMapsCoreLibApi gmsMapsCoreLibApi;

            public GetGmsCameraUpdateFactoryProvider(GmsMapsCoreLibApi gmsMapsCoreLibApi2) {
                this.gmsMapsCoreLibApi = gmsMapsCoreLibApi2;
            }

            public GmsCameraUpdateFactory get() {
                return (GmsCameraUpdateFactory) Preconditions.checkNotNullFromComponent(this.gmsMapsCoreLibApi.getGmsCameraUpdateFactory());
            }
        }

        public static final class GetGmsLatLngFactoryProvider implements Provider<GmsLatLngFactory> {
            private final GmsMapsCoreLibApi gmsMapsCoreLibApi;

            public GetGmsLatLngFactoryProvider(GmsMapsCoreLibApi gmsMapsCoreLibApi2) {
                this.gmsMapsCoreLibApi = gmsMapsCoreLibApi2;
            }

            public GmsLatLngFactory get() {
                return (GmsLatLngFactory) Preconditions.checkNotNullFromComponent(this.gmsMapsCoreLibApi.getGmsLatLngFactory());
            }
        }

        public static final class GetGmsMapsInitializerProvider implements Provider<GmsMapsInitializer> {
            private final GmsMapsCoreLibApi gmsMapsCoreLibApi;

            public GetGmsMapsInitializerProvider(GmsMapsCoreLibApi gmsMapsCoreLibApi2) {
                this.gmsMapsCoreLibApi = gmsMapsCoreLibApi2;
            }

            public GmsMapsInitializer get() {
                return (GmsMapsInitializer) Preconditions.checkNotNullFromComponent(this.gmsMapsCoreLibApi.getGmsMapsInitializer());
            }
        }

        public static final class GetGmsMapsViewsRepositoryProvider implements Provider<GmsMapsViewsRepository> {
            private final GmsMapsCoreLibApi gmsMapsCoreLibApi;

            public GetGmsMapsViewsRepositoryProvider(GmsMapsCoreLibApi gmsMapsCoreLibApi2) {
                this.gmsMapsCoreLibApi = gmsMapsCoreLibApi2;
            }

            public GmsMapsViewsRepository get() {
                return (GmsMapsViewsRepository) Preconditions.checkNotNullFromComponent(this.gmsMapsCoreLibApi.getGmsMapsViewsRepository());
            }
        }

        public static final class GetGmsModelsRepositoryProvider implements Provider<GmsModelsRepository> {
            private final GmsMapsCoreLibApi gmsMapsCoreLibApi;

            public GetGmsModelsRepositoryProvider(GmsMapsCoreLibApi gmsMapsCoreLibApi2) {
                this.gmsMapsCoreLibApi = gmsMapsCoreLibApi2;
            }

            public GmsModelsRepository get() {
                return (GmsModelsRepository) Preconditions.checkNotNullFromComponent(this.gmsMapsCoreLibApi.getGmsModelsRepository());
            }
        }

        public static final class GetHmsCameraUpdateFactoryProvider implements Provider<HmsCameraUpdateFactory> {
            private final HmsMapsCoreLibApi hmsMapsCoreLibApi;

            public GetHmsCameraUpdateFactoryProvider(HmsMapsCoreLibApi hmsMapsCoreLibApi2) {
                this.hmsMapsCoreLibApi = hmsMapsCoreLibApi2;
            }

            public HmsCameraUpdateFactory get() {
                return (HmsCameraUpdateFactory) Preconditions.checkNotNullFromComponent(this.hmsMapsCoreLibApi.getHmsCameraUpdateFactory());
            }
        }

        public static final class GetHmsLatLngFactoryProvider implements Provider<HmsLatLngFactory> {
            private final HmsMapsCoreLibApi hmsMapsCoreLibApi;

            public GetHmsLatLngFactoryProvider(HmsMapsCoreLibApi hmsMapsCoreLibApi2) {
                this.hmsMapsCoreLibApi = hmsMapsCoreLibApi2;
            }

            public HmsLatLngFactory get() {
                return (HmsLatLngFactory) Preconditions.checkNotNullFromComponent(this.hmsMapsCoreLibApi.getHmsLatLngFactory());
            }
        }

        public static final class GetHmsMapsInitializerProvider implements Provider<HmsMapsInitializer> {
            private final HmsMapsCoreLibApi hmsMapsCoreLibApi;

            public GetHmsMapsInitializerProvider(HmsMapsCoreLibApi hmsMapsCoreLibApi2) {
                this.hmsMapsCoreLibApi = hmsMapsCoreLibApi2;
            }

            public HmsMapsInitializer get() {
                return (HmsMapsInitializer) Preconditions.checkNotNullFromComponent(this.hmsMapsCoreLibApi.getHmsMapsInitializer());
            }
        }

        public static final class GetHmsMapsViewsRepositoryProvider implements Provider<HmsMapsViewsRepository> {
            private final HmsMapsCoreLibApi hmsMapsCoreLibApi;

            public GetHmsMapsViewsRepositoryProvider(HmsMapsCoreLibApi hmsMapsCoreLibApi2) {
                this.hmsMapsCoreLibApi = hmsMapsCoreLibApi2;
            }

            public HmsMapsViewsRepository get() {
                return (HmsMapsViewsRepository) Preconditions.checkNotNullFromComponent(this.hmsMapsCoreLibApi.getHmsMapsViewsRepository());
            }
        }

        public static final class GetHmsModelsRepositoryProvider implements Provider<HmsModelsRepository> {
            private final HmsMapsCoreLibApi hmsMapsCoreLibApi;

            public GetHmsModelsRepositoryProvider(HmsMapsCoreLibApi hmsMapsCoreLibApi2) {
                this.hmsMapsCoreLibApi = hmsMapsCoreLibApi2;
            }

            public HmsModelsRepository get() {
                return (HmsModelsRepository) Preconditions.checkNotNullFromComponent(this.hmsMapsCoreLibApi.getHmsModelsRepository());
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

        private MapsCoreLibComponentImpl(GmsBaseCoreLibApi gmsBaseCoreLibApi, GmsMapsCoreLibApi gmsMapsCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, HmsMapsCoreLibApi hmsMapsCoreLibApi) {
            this.mapsCoreLibComponentImpl = this;
            initialize(gmsBaseCoreLibApi, gmsMapsCoreLibApi, hmsBaseCoreLibApi, hmsMapsCoreLibApi);
        }

        private void initialize(GmsBaseCoreLibApi gmsBaseCoreLibApi, GmsMapsCoreLibApi gmsMapsCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, HmsMapsCoreLibApi hmsMapsCoreLibApi) {
            this.isGmsAvailableProvider = new IsGmsAvailableProvider(gmsBaseCoreLibApi);
            IsHmsAvailableProvider isHmsAvailableProvider2 = new IsHmsAvailableProvider(hmsBaseCoreLibApi);
            this.isHmsAvailableProvider = isHmsAvailableProvider2;
            this.mapTypeProvider = SingleCheck.provider(MapsModule_MapTypeFactory.create(this.isGmsAvailableProvider, isHmsAvailableProvider2));
            this.getGmsMapsViewsRepositoryProvider = new GetGmsMapsViewsRepositoryProvider(gmsMapsCoreLibApi);
            GetHmsMapsViewsRepositoryProvider getHmsMapsViewsRepositoryProvider2 = new GetHmsMapsViewsRepositoryProvider(hmsMapsCoreLibApi);
            this.getHmsMapsViewsRepositoryProvider = getHmsMapsViewsRepositoryProvider2;
            this.mapViewsRepositoryProvider = SingleCheck.provider(MapsModule_MapViewsRepositoryFactory.create(this.getGmsMapsViewsRepositoryProvider, getHmsMapsViewsRepositoryProvider2, this.mapTypeProvider));
            this.getGmsLatLngFactoryProvider = new GetGmsLatLngFactoryProvider(gmsMapsCoreLibApi);
            GetHmsLatLngFactoryProvider getHmsLatLngFactoryProvider2 = new GetHmsLatLngFactoryProvider(hmsMapsCoreLibApi);
            this.getHmsLatLngFactoryProvider = getHmsLatLngFactoryProvider2;
            this.latLngFactoryProvider = SingleCheck.provider(MapsModule_LatLngFactoryFactory.create(this.getGmsLatLngFactoryProvider, getHmsLatLngFactoryProvider2, this.mapTypeProvider));
            this.getGmsModelsRepositoryProvider = new GetGmsModelsRepositoryProvider(gmsMapsCoreLibApi);
            GetHmsModelsRepositoryProvider getHmsModelsRepositoryProvider2 = new GetHmsModelsRepositoryProvider(hmsMapsCoreLibApi);
            this.getHmsModelsRepositoryProvider = getHmsModelsRepositoryProvider2;
            this.modelsRepositoryProvider = SingleCheck.provider(MapsModule_ModelsRepositoryFactory.create(this.getGmsModelsRepositoryProvider, getHmsModelsRepositoryProvider2, this.mapTypeProvider));
            this.getGmsCameraUpdateFactoryProvider = new GetGmsCameraUpdateFactoryProvider(gmsMapsCoreLibApi);
            GetHmsCameraUpdateFactoryProvider getHmsCameraUpdateFactoryProvider2 = new GetHmsCameraUpdateFactoryProvider(hmsMapsCoreLibApi);
            this.getHmsCameraUpdateFactoryProvider = getHmsCameraUpdateFactoryProvider2;
            this.cameraUpdateFactoryProvider = SingleCheck.provider(MapsModule_CameraUpdateFactoryFactory.create(this.getGmsCameraUpdateFactoryProvider, getHmsCameraUpdateFactoryProvider2, this.mapTypeProvider));
            this.getGmsMapsInitializerProvider = new GetGmsMapsInitializerProvider(gmsMapsCoreLibApi);
            GetHmsMapsInitializerProvider getHmsMapsInitializerProvider2 = new GetHmsMapsInitializerProvider(hmsMapsCoreLibApi);
            this.getHmsMapsInitializerProvider = getHmsMapsInitializerProvider2;
            this.mapsInitializerProvider = SingleCheck.provider(MapsModule_MapsInitializerFactory.create(this.getGmsMapsInitializerProvider, getHmsMapsInitializerProvider2, this.mapTypeProvider));
        }

        public CameraUpdateFactory getCameraUpdateFactory() {
            return this.cameraUpdateFactoryProvider.get();
        }

        public LatLngFactory getLatLngFactory() {
            return this.latLngFactoryProvider.get();
        }

        public MapViewsRepository getMapViewsRepository() {
            return this.mapViewsRepositoryProvider.get();
        }

        public MapsInitializer getMapsInitializer() {
            return this.mapsInitializerProvider.get();
        }

        public ModelsRepository getModelsRepository() {
            return this.modelsRepositoryProvider.get();
        }

        public MapType getUsingMapType() {
            return this.mapTypeProvider.get();
        }
    }

    private DaggerMapsCoreLibComponent() {
    }

    public static MapsCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
