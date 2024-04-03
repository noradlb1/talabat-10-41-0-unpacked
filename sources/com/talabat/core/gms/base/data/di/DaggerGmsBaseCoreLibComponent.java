package com.talabat.core.gms.base.data.di;

import android.content.Context;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.gms.base.data.di.GmsBaseCoreLibComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGmsBaseCoreLibComponent {

    public static final class Factory implements GmsBaseCoreLibComponent.Factory {
        private Factory() {
        }

        public GmsBaseCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new GmsBaseCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    public static final class GmsBaseCoreLibComponentImpl implements GmsBaseCoreLibComponent {
        private final ContextCoreLibApi contextCoreLibApi;
        private final GmsBaseCoreLibComponentImpl gmsBaseCoreLibComponentImpl;

        private GmsBaseCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi2) {
            this.gmsBaseCoreLibComponentImpl = this;
            this.contextCoreLibApi = contextCoreLibApi2;
        }

        public boolean isGmsAvailable() {
            return GmsBaseModule.INSTANCE.isGmsAvailable((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }
    }

    private DaggerGmsBaseCoreLibComponent() {
    }

    public static GmsBaseCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
