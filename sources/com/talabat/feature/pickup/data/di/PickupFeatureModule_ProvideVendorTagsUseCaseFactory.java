package com.talabat.feature.pickup.data.di;

import com.talabat.talabatcommon.feature.vendorTags.domain.RequestVendorTagsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupFeatureModule_ProvideVendorTagsUseCaseFactory implements Factory<RequestVendorTagsUseCase> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PickupFeatureModule_ProvideVendorTagsUseCaseFactory INSTANCE = new PickupFeatureModule_ProvideVendorTagsUseCaseFactory();

        private InstanceHolder() {
        }
    }

    public static PickupFeatureModule_ProvideVendorTagsUseCaseFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RequestVendorTagsUseCase provideVendorTagsUseCase() {
        return (RequestVendorTagsUseCase) Preconditions.checkNotNullFromProvides(PickupFeatureModule.INSTANCE.provideVendorTagsUseCase());
    }

    public RequestVendorTagsUseCase get() {
        return provideVendorTagsUseCase();
    }
}
