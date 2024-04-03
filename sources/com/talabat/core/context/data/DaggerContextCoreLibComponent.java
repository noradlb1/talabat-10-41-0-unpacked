package com.talabat.core.context.data;

import android.app.Application;
import android.content.Context;
import com.talabat.core.context.data.ContextCoreLibComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerContextCoreLibComponent {

    public static final class ContextCoreLibComponentImpl implements ContextCoreLibComponent {
        private final Application application;
        private final Context context;
        private final ContextCoreLibComponentImpl contextCoreLibComponentImpl;

        private ContextCoreLibComponentImpl(Application application2, Context context2) {
            this.contextCoreLibComponentImpl = this;
            this.application = application2;
            this.context = context2;
        }

        public Application getApplication() {
            return this.application;
        }

        public Context getContext() {
            return this.context;
        }
    }

    public static final class Factory implements ContextCoreLibComponent.Factory {
        private Factory() {
        }

        public ContextCoreLibComponent create(Application application, Context context) {
            Preconditions.checkNotNull(application);
            Preconditions.checkNotNull(context);
            return new ContextCoreLibComponentImpl(application, context);
        }
    }

    private DaggerContextCoreLibComponent() {
    }

    public static ContextCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
