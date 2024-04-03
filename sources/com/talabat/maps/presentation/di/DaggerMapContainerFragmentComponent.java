package com.talabat.maps.presentation.di;

import com.talabat.maps.domain.MapViewsRepository;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.maps.presentation.MapContainerFragment;
import com.talabat.maps.presentation.MapContainerFragment_MembersInjector;
import com.talabat.maps.presentation.di.MapContainerFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerMapContainerFragmentComponent {

    public static final class Factory implements MapContainerFragmentComponent.Factory {
        private Factory() {
        }

        public MapContainerFragmentComponent create(MapsCoreLibApi mapsCoreLibApi) {
            Preconditions.checkNotNull(mapsCoreLibApi);
            return new MapContainerFragmentComponentImpl(mapsCoreLibApi);
        }
    }

    public static final class MapContainerFragmentComponentImpl implements MapContainerFragmentComponent {
        private final MapContainerFragmentComponentImpl mapContainerFragmentComponentImpl;
        private final MapsCoreLibApi mapsCoreLibApi;

        private MapContainerFragmentComponentImpl(MapsCoreLibApi mapsCoreLibApi2) {
            this.mapContainerFragmentComponentImpl = this;
            this.mapsCoreLibApi = mapsCoreLibApi2;
        }

        private MapContainerFragment injectMapContainerFragment(MapContainerFragment mapContainerFragment) {
            MapContainerFragment_MembersInjector.injectMapViewsRepository(mapContainerFragment, (MapViewsRepository) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getMapViewsRepository()));
            return mapContainerFragment;
        }

        public void inject(MapContainerFragment mapContainerFragment) {
            injectMapContainerFragment(mapContainerFragment);
        }
    }

    private DaggerMapContainerFragmentComponent() {
    }

    public static MapContainerFragmentComponent.Factory factory() {
        return new Factory();
    }
}
