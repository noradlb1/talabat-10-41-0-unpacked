package com.talabat.hms.maps.data.di;

import android.content.Context;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.CircleOptions;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MarkerOptions;
import com.huawei.hms.maps.model.PolygonOptions;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.hms.maps.data.DefaultHmsCameraUpdateFactory_Factory;
import com.talabat.hms.maps.data.DefaultHmsLatLngFactory_Factory;
import com.talabat.hms.maps.data.DefaultHmsMapsInitializer;
import com.talabat.hms.maps.data.DefaultHmsMapsInitializer_Factory;
import com.talabat.hms.maps.data.DefaultHmsMapsViewsRepository;
import com.talabat.hms.maps.data.DefaultHmsMapsViewsRepository_Factory;
import com.talabat.hms.maps.data.DefaultHmsModelsRepository;
import com.talabat.hms.maps.data.DefaultHmsModelsRepository_Factory;
import com.talabat.hms.maps.data.di.HmsMapsCoreLibComponent;
import com.talabat.hms.maps.data.model.HmsBitmapDescriptorFactory_Factory;
import com.talabat.hms.maps.data.model.HmsCameraPositionBuilder;
import com.talabat.hms.maps.data.model.HmsCameraPositionBuilder_Factory;
import com.talabat.hms.maps.data.model.HmsCircleOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsCircleOptionsWrapper_Factory;
import com.talabat.hms.maps.data.model.HmsLatLngBoundsBuilder;
import com.talabat.hms.maps.data.model.HmsLatLngBoundsBuilder_Factory;
import com.talabat.hms.maps.data.model.HmsMarkerOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsMarkerOptionsWrapper_Factory;
import com.talabat.hms.maps.data.model.HmsPolygonOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsPolygonOptionsWrapper_Factory;
import com.talabat.hms.maps.domain.HmsCameraUpdateFactory;
import com.talabat.hms.maps.domain.HmsLatLngFactory;
import com.talabat.hms.maps.domain.HmsMapsInitializer;
import com.talabat.hms.maps.domain.HmsMapsViewsRepository;
import com.talabat.hms.maps.domain.HmsModelsRepository;
import com.talabat.maps.domain.model.BitmapDescriptorFactory;
import com.talabat.secrets.Secrets;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerHmsMapsCoreLibComponent {

    public static final class Factory implements HmsMapsCoreLibComponent.Factory {
        private Factory() {
        }

        public HmsMapsCoreLibComponent create(ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new HmsMapsCoreLibComponentImpl(new HuaweiModule(), contextCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class HmsMapsCoreLibComponentImpl implements HmsMapsCoreLibComponent {
        private Provider<BitmapDescriptorFactory> bitmapDescriptorFactoryProvider;
        private Provider<CameraPosition.Builder> cameraPositionBuilderProvider;
        private Provider<DefaultHmsMapsInitializer> defaultHmsMapsInitializerProvider;
        private Provider<DefaultHmsMapsViewsRepository> defaultHmsMapsViewsRepositoryProvider;
        private Provider<DefaultHmsModelsRepository> defaultHmsModelsRepositoryProvider;
        private Provider<Context> getContextProvider;
        private Provider<HmsCameraPositionBuilder> hmsCameraPositionBuilderProvider;
        private Provider<HmsCameraUpdateFactory> hmsCameraUpdateFactoryProvider;
        private Provider<HmsCircleOptionsWrapper> hmsCircleOptionsWrapperProvider;
        private Provider<HmsLatLngBoundsBuilder> hmsLatLngBoundsBuilderProvider;
        private final HmsMapsCoreLibComponentImpl hmsMapsCoreLibComponentImpl;
        private Provider<HmsMapsViewsRepository> hmsMapsViewsRepositoryProvider;
        private Provider<HmsMarkerOptionsWrapper> hmsMarkerOptionsWrapperProvider;
        private Provider<HmsModelsRepository> hmsModelsRepositoryProvider;
        private Provider<HmsPolygonOptionsWrapper> hmsPolygonOptionsWrapperProvider;
        private Provider<CircleOptions> huaweiCircleOptionsProvider;
        private Provider<MarkerOptions> huaweiMarkerOptionsProvider;
        private Provider<PolygonOptions> huaweiPolygonOptionsProvider;
        private Provider<LatLngBounds.Builder> latLngBoundsBuilderProvider;
        private Provider<HmsLatLngFactory> latLngFactoryProvider;
        private Provider<HmsMapsInitializer> mapsInitializerProvider;
        private Provider<Secrets> secretsProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private HmsMapsCoreLibComponentImpl(HuaweiModule huaweiModule, ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.hmsMapsCoreLibComponentImpl = this;
            initialize(huaweiModule, contextCoreLibApi, observabilityCoreLibApi);
        }

        private void initialize(HuaweiModule huaweiModule, ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            DefaultHmsMapsViewsRepository_Factory create = DefaultHmsMapsViewsRepository_Factory.create(HmsMapsModule_Companion_SupportMapFragmentFactory.create());
            this.defaultHmsMapsViewsRepositoryProvider = create;
            this.hmsMapsViewsRepositoryProvider = SingleCheck.provider(create);
            HuaweiModule_CameraPositionBuilderFactory create2 = HuaweiModule_CameraPositionBuilderFactory.create(huaweiModule);
            this.cameraPositionBuilderProvider = create2;
            this.hmsCameraPositionBuilderProvider = HmsCameraPositionBuilder_Factory.create(create2);
            HuaweiModule_LatLngBoundsBuilderFactory create3 = HuaweiModule_LatLngBoundsBuilderFactory.create(huaweiModule);
            this.latLngBoundsBuilderProvider = create3;
            this.hmsLatLngBoundsBuilderProvider = HmsLatLngBoundsBuilder_Factory.create(create3);
            HuaweiModule_HuaweiPolygonOptionsFactory create4 = HuaweiModule_HuaweiPolygonOptionsFactory.create(huaweiModule);
            this.huaweiPolygonOptionsProvider = create4;
            this.hmsPolygonOptionsWrapperProvider = HmsPolygonOptionsWrapper_Factory.create(create4);
            HuaweiModule_HuaweiCircleOptionsFactory create5 = HuaweiModule_HuaweiCircleOptionsFactory.create(huaweiModule);
            this.huaweiCircleOptionsProvider = create5;
            this.hmsCircleOptionsWrapperProvider = HmsCircleOptionsWrapper_Factory.create(create5);
            HuaweiModule_HuaweiMarkerOptionsFactory create6 = HuaweiModule_HuaweiMarkerOptionsFactory.create(huaweiModule);
            this.huaweiMarkerOptionsProvider = create6;
            this.hmsMarkerOptionsWrapperProvider = HmsMarkerOptionsWrapper_Factory.create(create6);
            Provider<BitmapDescriptorFactory> provider = SingleCheck.provider(HmsBitmapDescriptorFactory_Factory.create());
            this.bitmapDescriptorFactoryProvider = provider;
            DefaultHmsModelsRepository_Factory create7 = DefaultHmsModelsRepository_Factory.create(this.hmsCameraPositionBuilderProvider, this.hmsLatLngBoundsBuilderProvider, this.hmsPolygonOptionsWrapperProvider, this.hmsCircleOptionsWrapperProvider, this.hmsMarkerOptionsWrapperProvider, provider);
            this.defaultHmsModelsRepositoryProvider = create7;
            this.hmsModelsRepositoryProvider = SingleCheck.provider(create7);
            this.latLngFactoryProvider = SingleCheck.provider(DefaultHmsLatLngFactory_Factory.create());
            this.hmsCameraUpdateFactoryProvider = SingleCheck.provider(DefaultHmsCameraUpdateFactory_Factory.create());
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            Provider<Secrets> provider2 = SingleCheck.provider(HmsMapsModule_Companion_SecretsFactory.create());
            this.secretsProvider = provider2;
            DefaultHmsMapsInitializer_Factory create8 = DefaultHmsMapsInitializer_Factory.create(this.getContextProvider, provider2);
            this.defaultHmsMapsInitializerProvider = create8;
            this.mapsInitializerProvider = SingleCheck.provider(create8);
        }

        public HmsCameraUpdateFactory getHmsCameraUpdateFactory() {
            return this.hmsCameraUpdateFactoryProvider.get();
        }

        public HmsLatLngFactory getHmsLatLngFactory() {
            return this.latLngFactoryProvider.get();
        }

        public HmsMapsInitializer getHmsMapsInitializer() {
            return this.mapsInitializerProvider.get();
        }

        public HmsMapsViewsRepository getHmsMapsViewsRepository() {
            return this.hmsMapsViewsRepositoryProvider.get();
        }

        public HmsModelsRepository getHmsModelsRepository() {
            return this.hmsModelsRepositoryProvider.get();
        }
    }

    private DaggerHmsMapsCoreLibComponent() {
    }

    public static HmsMapsCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
