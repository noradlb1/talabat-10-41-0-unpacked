package com.talabat.gms.maps.data.di;

import android.content.Context;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.gms.maps.data.DefaultGmsCameraUpdateFactory_Factory;
import com.talabat.gms.maps.data.DefaultGmsLatLngFactory_Factory;
import com.talabat.gms.maps.data.DefaultGmsMapsInitializer;
import com.talabat.gms.maps.data.DefaultGmsMapsInitializer_Factory;
import com.talabat.gms.maps.data.DefaultGmsMapsViewsRepository;
import com.talabat.gms.maps.data.DefaultGmsMapsViewsRepository_Factory;
import com.talabat.gms.maps.data.DefaultGmsModelsRepository;
import com.talabat.gms.maps.data.DefaultGmsModelsRepository_Factory;
import com.talabat.gms.maps.data.di.GmsMapsCoreLibComponent;
import com.talabat.gms.maps.data.model.GmsBitmapDescriptorFactory_Factory;
import com.talabat.gms.maps.data.model.GmsCameraPositionBuilder;
import com.talabat.gms.maps.data.model.GmsCameraPositionBuilder_Factory;
import com.talabat.gms.maps.data.model.GmsCircleOptionsWrapper;
import com.talabat.gms.maps.data.model.GmsCircleOptionsWrapper_Factory;
import com.talabat.gms.maps.data.model.GmsLatLngBoundsBuilder;
import com.talabat.gms.maps.data.model.GmsLatLngBoundsBuilder_Factory;
import com.talabat.gms.maps.data.model.GmsMarkerOptionsWrapper;
import com.talabat.gms.maps.data.model.GmsMarkerOptionsWrapper_Factory;
import com.talabat.gms.maps.data.model.GmsPolygonOptionsWrapper;
import com.talabat.gms.maps.data.model.GmsPolygonOptionsWrapper_Factory;
import com.talabat.gms.maps.domain.GmsCameraUpdateFactory;
import com.talabat.gms.maps.domain.GmsLatLngFactory;
import com.talabat.gms.maps.domain.GmsMapsInitializer;
import com.talabat.gms.maps.domain.GmsMapsViewsRepository;
import com.talabat.gms.maps.domain.GmsModelsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerGmsMapsCoreLibComponent {

    public static final class Factory implements GmsMapsCoreLibComponent.Factory {
        private Factory() {
        }

        public GmsMapsCoreLibComponent create(ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new GmsMapsCoreLibComponentImpl(new GoogleModule(), contextCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class GmsMapsCoreLibComponentImpl implements GmsMapsCoreLibComponent {
        private Provider<CameraPosition.Builder> cameraPositionBuilderProvider;
        private Provider<DefaultGmsMapsInitializer> defaultGmsMapsInitializerProvider;
        private Provider<DefaultGmsMapsViewsRepository> defaultGmsMapsViewsRepositoryProvider;
        private Provider<DefaultGmsModelsRepository> defaultGmsModelsRepositoryProvider;
        private Provider<Context> getContextProvider;
        private Provider<GmsCameraPositionBuilder> gmsCameraPositionBuilderProvider;
        private Provider<GmsCameraUpdateFactory> gmsCameraUpdateFactoryProvider;
        private Provider<GmsCircleOptionsWrapper> gmsCircleOptionsWrapperProvider;
        private Provider<GmsLatLngBoundsBuilder> gmsLatLngBoundsBuilderProvider;
        private final GmsMapsCoreLibComponentImpl gmsMapsCoreLibComponentImpl;
        private Provider<GmsMapsViewsRepository> gmsMapsViewsRepositoryProvider;
        private Provider<GmsMarkerOptionsWrapper> gmsMarkerOptionsWrapperProvider;
        private Provider<GmsModelsRepository> gmsModelsRepositoryProvider;
        private Provider<GmsPolygonOptionsWrapper> gmsPolygonOptionsWrapperProvider;
        private Provider<CircleOptions> googleCircleOptionsProvider;
        private Provider<MarkerOptions> googleMarkerOptionsProvider;
        private Provider<PolygonOptions> googlePolygonOptionsProvider;
        private Provider<LatLngBounds.Builder> latLngBoundsBuilderProvider;
        private Provider<GmsLatLngFactory> latLngFactoryProvider;
        private Provider<GmsMapsInitializer> mapsInitializerProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private GmsMapsCoreLibComponentImpl(GoogleModule googleModule, ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.gmsMapsCoreLibComponentImpl = this;
            initialize(googleModule, contextCoreLibApi, observabilityCoreLibApi);
        }

        private void initialize(GoogleModule googleModule, ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            DefaultGmsMapsViewsRepository_Factory create = DefaultGmsMapsViewsRepository_Factory.create(GmsMapsModule_Companion_SupportMapFragmentFactory.create());
            this.defaultGmsMapsViewsRepositoryProvider = create;
            this.gmsMapsViewsRepositoryProvider = SingleCheck.provider(create);
            GoogleModule_CameraPositionBuilderFactory create2 = GoogleModule_CameraPositionBuilderFactory.create(googleModule);
            this.cameraPositionBuilderProvider = create2;
            this.gmsCameraPositionBuilderProvider = GmsCameraPositionBuilder_Factory.create(create2);
            GoogleModule_LatLngBoundsBuilderFactory create3 = GoogleModule_LatLngBoundsBuilderFactory.create(googleModule);
            this.latLngBoundsBuilderProvider = create3;
            this.gmsLatLngBoundsBuilderProvider = GmsLatLngBoundsBuilder_Factory.create(create3);
            GoogleModule_GooglePolygonOptionsFactory create4 = GoogleModule_GooglePolygonOptionsFactory.create(googleModule);
            this.googlePolygonOptionsProvider = create4;
            this.gmsPolygonOptionsWrapperProvider = GmsPolygonOptionsWrapper_Factory.create(create4);
            GoogleModule_GoogleCircleOptionsFactory create5 = GoogleModule_GoogleCircleOptionsFactory.create(googleModule);
            this.googleCircleOptionsProvider = create5;
            this.gmsCircleOptionsWrapperProvider = GmsCircleOptionsWrapper_Factory.create(create5);
            GoogleModule_GoogleMarkerOptionsFactory create6 = GoogleModule_GoogleMarkerOptionsFactory.create(googleModule);
            this.googleMarkerOptionsProvider = create6;
            GmsMarkerOptionsWrapper_Factory create7 = GmsMarkerOptionsWrapper_Factory.create(create6);
            this.gmsMarkerOptionsWrapperProvider = create7;
            DefaultGmsModelsRepository_Factory create8 = DefaultGmsModelsRepository_Factory.create(this.gmsCameraPositionBuilderProvider, this.gmsLatLngBoundsBuilderProvider, this.gmsPolygonOptionsWrapperProvider, this.gmsCircleOptionsWrapperProvider, create7, GmsBitmapDescriptorFactory_Factory.create());
            this.defaultGmsModelsRepositoryProvider = create8;
            this.gmsModelsRepositoryProvider = SingleCheck.provider(create8);
            this.latLngFactoryProvider = SingleCheck.provider(DefaultGmsLatLngFactory_Factory.create());
            this.gmsCameraUpdateFactoryProvider = SingleCheck.provider(DefaultGmsCameraUpdateFactory_Factory.create());
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            DefaultGmsMapsInitializer_Factory create9 = DefaultGmsMapsInitializer_Factory.create(getContextProvider2);
            this.defaultGmsMapsInitializerProvider = create9;
            this.mapsInitializerProvider = SingleCheck.provider(create9);
        }

        public GmsCameraUpdateFactory getGmsCameraUpdateFactory() {
            return this.gmsCameraUpdateFactoryProvider.get();
        }

        public GmsLatLngFactory getGmsLatLngFactory() {
            return this.latLngFactoryProvider.get();
        }

        public GmsMapsInitializer getGmsMapsInitializer() {
            return this.mapsInitializerProvider.get();
        }

        public GmsMapsViewsRepository getGmsMapsViewsRepository() {
            return this.gmsMapsViewsRepositoryProvider.get();
        }

        public GmsModelsRepository getGmsModelsRepository() {
            return this.gmsModelsRepositoryProvider.get();
        }
    }

    private DaggerGmsMapsCoreLibComponent() {
    }

    public static GmsMapsCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
