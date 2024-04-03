package com.talabat.core.dispatcher.data.di;

import com.talabat.core.dispatcher.data.RealCoroutineDispatchersFactory_Factory;
import com.talabat.core.dispatcher.data.RealRxSchedulersFactory_Factory;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerDispatcherCoreLibComponent {

    public static final class Builder {
        private Builder() {
        }

        public DispatcherCoreLibComponent build() {
            return new DispatcherCoreLibComponentImpl();
        }
    }

    public static final class DispatcherCoreLibComponentImpl implements DispatcherCoreLibComponent {
        private Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
        private final DispatcherCoreLibComponentImpl dispatcherCoreLibComponentImpl;
        private Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;

        private DispatcherCoreLibComponentImpl() {
            this.dispatcherCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.coroutineDispatchersFactoryProvider = SingleCheck.provider(RealCoroutineDispatchersFactory_Factory.create());
            this.rxSchedulersFactoryProvider = SingleCheck.provider(RealRxSchedulersFactory_Factory.create());
        }

        public CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
            return this.coroutineDispatchersFactoryProvider.get();
        }

        public RxSchedulersFactory getRxSchedulersFactory() {
            return this.rxSchedulersFactoryProvider.get();
        }
    }

    private DaggerDispatcherCoreLibComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static DispatcherCoreLibComponent create() {
        return new Builder().build();
    }
}
