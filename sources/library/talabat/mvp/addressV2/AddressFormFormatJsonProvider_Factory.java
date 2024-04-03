package library.talabat.mvp.addressV2;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressFormFormatJsonProvider_Factory implements Factory<AddressFormFormatJsonProvider> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public AddressFormFormatJsonProvider_Factory(Provider<ITalabatExperiment> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.talabatExperimentProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static AddressFormFormatJsonProvider_Factory create(Provider<ITalabatExperiment> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new AddressFormFormatJsonProvider_Factory(provider, provider2);
    }

    public static AddressFormFormatJsonProvider newInstance(ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new AddressFormFormatJsonProvider(iTalabatExperiment, iTalabatFeatureFlag);
    }

    public AddressFormFormatJsonProvider get() {
        return newInstance(this.talabatExperimentProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
