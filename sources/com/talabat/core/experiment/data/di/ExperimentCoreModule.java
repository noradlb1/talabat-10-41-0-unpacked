package com.talabat.core.experiment.data.di;

import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/experiment/data/di/ExperimentCoreModule;", "", "()V", "provideTalabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "com_talabat_core_experiment_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class ExperimentCoreModule {
    @NotNull
    public static final ExperimentCoreModule INSTANCE = new ExperimentCoreModule();

    private ExperimentCoreModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final ITalabatExperiment provideTalabatExperiment() {
        return TalabatExperiment.INSTANCE;
    }
}
