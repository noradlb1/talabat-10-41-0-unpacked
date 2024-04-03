package com.talabat.core.featureflag.fake.di;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.fake.FakeTalabatFeatureFlag;
import com.talabat.core.featureflag.fake.FakeTalabatFeatureFlag_Factory;
import com.talabat.core.featureflag.fake.di.FakeFeatureFlagLibComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFakeFeatureFlagLibComponent {

    public static final class Factory implements FakeFeatureFlagLibComponent.Factory {
        private Factory() {
        }

        public FakeFeatureFlagLibComponent create() {
            return new FakeFeatureFlagLibComponentImpl();
        }
    }

    public static final class FakeFeatureFlagLibComponentImpl implements FakeFeatureFlagLibComponent {
        private final FakeFeatureFlagLibComponentImpl fakeFeatureFlagLibComponentImpl;
        private Provider<FakeTalabatFeatureFlag> fakeTalabatFeatureFlagProvider;

        private FakeFeatureFlagLibComponentImpl() {
            this.fakeFeatureFlagLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.fakeTalabatFeatureFlagProvider = SingleCheck.provider(FakeTalabatFeatureFlag_Factory.create());
        }

        public ITalabatFeatureFlag getTalabatFeatureFlag() {
            return this.fakeTalabatFeatureFlagProvider.get();
        }
    }

    private DaggerFakeFeatureFlagLibComponent() {
    }

    public static FakeFeatureFlagLibComponent create() {
        return new Factory().create();
    }

    public static FakeFeatureFlagLibComponent.Factory factory() {
        return new Factory();
    }
}
