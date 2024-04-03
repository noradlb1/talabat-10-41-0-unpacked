package com.talabat.feature.nfvinvendorsearch.data.di;

import com.talabat.feature.nfvinvendorsearch.data.di.QCommerceFlutterFeatureComponent;
import dagger.internal.DaggerGenerated;

@DaggerGenerated
public final class DaggerQCommerceFlutterFeatureComponent {

    public static final class Factory implements QCommerceFlutterFeatureComponent.Factory {
        private Factory() {
        }

        public QCommerceFlutterFeatureComponent create() {
            return new QCommerceFlutterFeatureComponentImpl();
        }
    }

    public static final class QCommerceFlutterFeatureComponentImpl implements QCommerceFlutterFeatureComponent {
        private final QCommerceFlutterFeatureComponentImpl qCommerceFlutterFeatureComponentImpl;

        private QCommerceFlutterFeatureComponentImpl() {
            this.qCommerceFlutterFeatureComponentImpl = this;
        }
    }

    private DaggerQCommerceFlutterFeatureComponent() {
    }

    public static QCommerceFlutterFeatureComponent create() {
        return new Factory().create();
    }

    public static QCommerceFlutterFeatureComponent.Factory factory() {
        return new Factory();
    }
}
