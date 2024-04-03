package library.talabat.mvp.home;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsNfvFlutterNavigationUsecaseImpl_Factory implements Factory<IsNfvFlutterNavigationUsecaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public IsNfvFlutterNavigationUsecaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static IsNfvFlutterNavigationUsecaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new IsNfvFlutterNavigationUsecaseImpl_Factory(provider);
    }

    public static IsNfvFlutterNavigationUsecaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new IsNfvFlutterNavigationUsecaseImpl(iTalabatExperiment);
    }

    public IsNfvFlutterNavigationUsecaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
