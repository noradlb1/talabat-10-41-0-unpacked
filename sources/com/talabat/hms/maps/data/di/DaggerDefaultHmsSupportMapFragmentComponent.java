package com.talabat.hms.maps.data.di;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.hms.maps.data.DefaultHmsSupportMapFragment;
import com.talabat.hms.maps.data.DefaultHmsSupportMapFragment_MembersInjector;
import com.talabat.hms.maps.data.di.DefaultHmsSupportMapFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerDefaultHmsSupportMapFragmentComponent {

    public static final class DefaultHmsSupportMapFragmentComponentImpl implements DefaultHmsSupportMapFragmentComponent {
        private final DefaultHmsSupportMapFragmentComponentImpl defaultHmsSupportMapFragmentComponentImpl;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;

        private DefaultHmsSupportMapFragmentComponentImpl(ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.defaultHmsSupportMapFragmentComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private DefaultHmsSupportMapFragment injectDefaultHmsSupportMapFragment(DefaultHmsSupportMapFragment defaultHmsSupportMapFragment) {
            DefaultHmsSupportMapFragment_MembersInjector.injectObservabilityManager(defaultHmsSupportMapFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return defaultHmsSupportMapFragment;
        }

        public void inject(DefaultHmsSupportMapFragment defaultHmsSupportMapFragment) {
            injectDefaultHmsSupportMapFragment(defaultHmsSupportMapFragment);
        }
    }

    public static final class Factory implements DefaultHmsSupportMapFragmentComponent.Factory {
        private Factory() {
        }

        public DefaultHmsSupportMapFragmentComponent create(ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new DefaultHmsSupportMapFragmentComponentImpl(observabilityCoreLibApi);
        }
    }

    private DaggerDefaultHmsSupportMapFragmentComponent() {
    }

    public static DefaultHmsSupportMapFragmentComponent.Factory factory() {
        return new Factory();
    }
}
