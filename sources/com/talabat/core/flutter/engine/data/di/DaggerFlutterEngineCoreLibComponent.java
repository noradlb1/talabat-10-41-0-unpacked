package com.talabat.core.flutter.engine.data.di;

import android.content.Context;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.flutter.engine.data.FlutterEngineProvider;
import com.talabat.core.flutter.engine.data.FlutterEngineProvider_Factory;
import com.talabat.core.flutter.engine.data.di.FlutterEngineCoreLibComponent;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.flutter.embedding.engine.FlutterEngineGroup;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFlutterEngineCoreLibComponent {

    public static final class Factory implements FlutterEngineCoreLibComponent.Factory {
        private Factory() {
        }

        public FlutterEngineCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new FlutterEngineCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    public static final class FlutterEngineCoreLibComponentImpl implements FlutterEngineCoreLibComponent {
        private final FlutterEngineCoreLibComponentImpl flutterEngineCoreLibComponentImpl;
        private Provider<FlutterEngineGroup> flutterEngineGroupProvider;
        private Provider<FlutterEngineProvider> flutterEngineProvider;
        private Provider<IFlutterEngineProvider> flutterEngineProvider2;
        private Provider<Context> getContextProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private FlutterEngineCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.flutterEngineCoreLibComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            FlutterEngineCoreLibModule_Companion_FlutterEngineGroupFactory create = FlutterEngineCoreLibModule_Companion_FlutterEngineGroupFactory.create(getContextProvider2);
            this.flutterEngineGroupProvider = create;
            FlutterEngineProvider_Factory create2 = FlutterEngineProvider_Factory.create(this.getContextProvider, create);
            this.flutterEngineProvider = create2;
            this.flutterEngineProvider2 = SingleCheck.provider(create2);
        }

        public IFlutterEngineProvider getFlutterEngineProvider() {
            return this.flutterEngineProvider2.get();
        }
    }

    private DaggerFlutterEngineCoreLibComponent() {
    }

    public static FlutterEngineCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
