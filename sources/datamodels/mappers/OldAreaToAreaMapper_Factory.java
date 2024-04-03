package datamodels.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class OldAreaToAreaMapper_Factory implements Factory<OldAreaToAreaMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OldAreaToAreaMapper_Factory INSTANCE = new OldAreaToAreaMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static OldAreaToAreaMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OldAreaToAreaMapper newInstance() {
        return new OldAreaToAreaMapper();
    }

    public OldAreaToAreaMapper get() {
        return newInstance();
    }
}
