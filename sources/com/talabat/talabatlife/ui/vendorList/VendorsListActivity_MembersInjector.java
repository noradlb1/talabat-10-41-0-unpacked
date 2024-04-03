package com.talabat.talabatlife.ui.vendorList;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class VendorsListActivity_MembersInjector implements MembersInjector<VendorsListActivity> {
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public VendorsListActivity_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.talabatFeatureFlagProvider = provider;
    }

    public static MembersInjector<VendorsListActivity> create(Provider<ITalabatFeatureFlag> provider) {
        return new VendorsListActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.talabatlife.ui.vendorList.VendorsListActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(VendorsListActivity vendorsListActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        vendorsListActivity.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(VendorsListActivity vendorsListActivity) {
        injectTalabatFeatureFlag(vendorsListActivity, this.talabatFeatureFlagProvider.get());
    }
}
