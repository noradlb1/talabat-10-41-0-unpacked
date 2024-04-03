package com.talabat.core.hms.base.data.di;

import android.content.Context;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.hms.base.data.di.HmsBaseCoreLibComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerHmsBaseCoreLibComponent {

    public static final class Factory implements HmsBaseCoreLibComponent.Factory {
        private Factory() {
        }

        public HmsBaseCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new HmsBaseCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    public static final class HmsBaseCoreLibComponentImpl implements HmsBaseCoreLibComponent {
        private final ContextCoreLibApi contextCoreLibApi;
        private final HmsBaseCoreLibComponentImpl hmsBaseCoreLibComponentImpl;

        private HmsBaseCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi2) {
            this.hmsBaseCoreLibComponentImpl = this;
            this.contextCoreLibApi = contextCoreLibApi2;
        }

        public boolean isHmsAvailable() {
            return HmsBaseModule.INSTANCE.isHmsAvailable((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }
    }

    private DaggerHmsBaseCoreLibComponent() {
    }

    public static HmsBaseCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
