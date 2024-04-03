package com.talabat.feature.cancellationpolicy.di;

import com.talabat.feature.cancellationpolicy.mapper.ICancellationPolicyMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HelpCenterFeatureModule_CancellationPolicyMapperFactory implements Factory<ICancellationPolicyMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HelpCenterFeatureModule_CancellationPolicyMapperFactory INSTANCE = new HelpCenterFeatureModule_CancellationPolicyMapperFactory();

        private InstanceHolder() {
        }
    }

    public static ICancellationPolicyMapper cancellationPolicyMapper() {
        return (ICancellationPolicyMapper) Preconditions.checkNotNullFromProvides(HelpCenterFeatureModule.INSTANCE.cancellationPolicyMapper());
    }

    public static HelpCenterFeatureModule_CancellationPolicyMapperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public ICancellationPolicyMapper get() {
        return cancellationPolicyMapper();
    }
}
