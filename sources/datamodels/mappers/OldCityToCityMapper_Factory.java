package datamodels.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class OldCityToCityMapper_Factory implements Factory<OldCityToCityMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OldCityToCityMapper_Factory INSTANCE = new OldCityToCityMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static OldCityToCityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OldCityToCityMapper newInstance() {
        return new OldCityToCityMapper();
    }

    public OldCityToCityMapper get() {
        return newInstance();
    }
}
