package com.talabat.gms.maps.data.di;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.gms.maps.data.DefaultSupportMapFragment;
import com.talabat.gms.maps.data.DefaultSupportMapFragment_MembersInjector;
import com.talabat.gms.maps.data.di.DefaultSupportMapFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerDefaultSupportMapFragmentComponent {

    public static final class DefaultSupportMapFragmentComponentImpl implements DefaultSupportMapFragmentComponent {
        private final DefaultSupportMapFragmentComponentImpl defaultSupportMapFragmentComponentImpl;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;

        private DefaultSupportMapFragmentComponentImpl(ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.defaultSupportMapFragmentComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private DefaultSupportMapFragment injectDefaultSupportMapFragment(DefaultSupportMapFragment defaultSupportMapFragment) {
            DefaultSupportMapFragment_MembersInjector.injectObservabilityManager(defaultSupportMapFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return defaultSupportMapFragment;
        }

        public void inject(DefaultSupportMapFragment defaultSupportMapFragment) {
            injectDefaultSupportMapFragment(defaultSupportMapFragment);
        }
    }

    public static final class Factory implements DefaultSupportMapFragmentComponent.Factory {
        private Factory() {
        }

        public DefaultSupportMapFragmentComponent create(ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new DefaultSupportMapFragmentComponentImpl(observabilityCoreLibApi);
        }
    }

    private DaggerDefaultSupportMapFragmentComponent() {
    }

    public static DefaultSupportMapFragmentComponent.Factory factory() {
        return new Factory();
    }
}
