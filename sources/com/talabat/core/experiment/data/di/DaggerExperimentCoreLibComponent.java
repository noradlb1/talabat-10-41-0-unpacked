package com.talabat.core.experiment.data.di;

import com.talabat.core.experiment.data.di.ExperimentCoreLibComponent;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerExperimentCoreLibComponent {

    public static final class ExperimentCoreLibComponentImpl implements ExperimentCoreLibComponent {
        private final ExperimentCoreLibComponentImpl experimentCoreLibComponentImpl;
        private Provider<ITalabatExperiment> provideTalabatExperimentProvider;

        private ExperimentCoreLibComponentImpl() {
            this.experimentCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.provideTalabatExperimentProvider = SingleCheck.provider(ExperimentCoreModule_ProvideTalabatExperimentFactory.create());
        }

        public ITalabatExperiment getExperimentProvider() {
            return this.provideTalabatExperimentProvider.get();
        }
    }

    public static final class Factory implements ExperimentCoreLibComponent.Factory {
        private Factory() {
        }

        public ExperimentCoreLibComponent create() {
            return new ExperimentCoreLibComponentImpl();
        }
    }

    private DaggerExperimentCoreLibComponent() {
    }

    public static ExperimentCoreLibComponent create() {
        return new Factory().create();
    }

    public static ExperimentCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
