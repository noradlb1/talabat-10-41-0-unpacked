package com.talabat.gdm.owin.data.di;

import com.talabat.gdm.owin.data.DefaultGdmOwinTokenRepository;
import com.talabat.gdm.owin.data.di.GdmOwinTokenComponent;
import com.talabat.gdm.owin.domain.GdmOwinTokenRepository;
import dagger.internal.DaggerGenerated;

@DaggerGenerated
public final class DaggerGdmOwinTokenComponent {

    public static final class Factory implements GdmOwinTokenComponent.Factory {
        private Factory() {
        }

        public GdmOwinTokenComponent create() {
            return new GdmOwinTokenComponentImpl();
        }
    }

    public static final class GdmOwinTokenComponentImpl implements GdmOwinTokenComponent {
        private final GdmOwinTokenComponentImpl gdmOwinTokenComponentImpl;

        private GdmOwinTokenComponentImpl() {
            this.gdmOwinTokenComponentImpl = this;
        }

        public GdmOwinTokenRepository getGdmOwinTokenRepository() {
            return new DefaultGdmOwinTokenRepository();
        }
    }

    private DaggerGdmOwinTokenComponent() {
    }

    public static GdmOwinTokenComponent create() {
        return new Factory().create();
    }

    public static GdmOwinTokenComponent.Factory factory() {
        return new Factory();
    }
}
