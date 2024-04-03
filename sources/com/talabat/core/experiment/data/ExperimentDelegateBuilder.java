package com.talabat.core.experiment.data;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020 2\u0006\u0010\u0004\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\bJ\u0011\u0010!\u001a\u00020 2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0011\u0010\"\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011H\u0004J\u0011\u0010\u0016\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017H\u0004R\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/talabat/core/experiment/data/ExperimentDelegateBuilder;", "T", "", "()V", "defaultValue", "getDefaultValue$com_talabat_core_experiment_data_data", "()Ljava/lang/Object;", "setDefaultValue$com_talabat_core_experiment_data_data", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "getExperimentKey$com_talabat_core_experiment_data_data", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "setExperimentKey$com_talabat_core_experiment_data_data", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;)V", "experimentSource", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "getExperimentSource$com_talabat_core_experiment_data_data", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "setExperimentSource$com_talabat_core_experiment_data_data", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "trigger", "Lcom/talabat/core/experiment/data/ExperimentTrigger;", "getTrigger$com_talabat_core_experiment_data_data", "()Lcom/talabat/core/experiment/data/ExperimentTrigger;", "setTrigger$com_talabat_core_experiment_data_data", "(Lcom/talabat/core/experiment/data/ExperimentTrigger;)V", "with", "getWith$annotations", "getWith", "()Lcom/talabat/core/experiment/data/ExperimentDelegateBuilder;", "", "name", "source", "com_talabat_core_experiment_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExperimentDelegateBuilder<T> {
    @Nullable
    private T defaultValue;
    @Nullable
    private FWFKey experimentKey;
    @NotNull
    private ITalabatExperiment experimentSource = TalabatExperiment.INSTANCE;
    @NotNull
    private ExperimentTrigger trigger = ExperimentTrigger.ON_EVERY_ACCESS;
    @NotNull
    private final ExperimentDelegateBuilder<T> with = this;

    @TalabatExperimentDsl
    public static /* synthetic */ void getWith$annotations() {
    }

    @TalabatExperimentDsl
    public final void defaultValue(T t11) {
        this.defaultValue = t11;
    }

    @Nullable
    public final T getDefaultValue$com_talabat_core_experiment_data_data() {
        return this.defaultValue;
    }

    @Nullable
    public final FWFKey getExperimentKey$com_talabat_core_experiment_data_data() {
        return this.experimentKey;
    }

    @NotNull
    public final ITalabatExperiment getExperimentSource$com_talabat_core_experiment_data_data() {
        return this.experimentSource;
    }

    @NotNull
    public final ExperimentTrigger getTrigger$com_talabat_core_experiment_data_data() {
        return this.trigger;
    }

    @NotNull
    public final ExperimentDelegateBuilder<T> getWith() {
        return this.with;
    }

    @TalabatExperimentDsl
    public final void name(@NotNull FWFKey fWFKey) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        this.experimentKey = fWFKey;
    }

    public final void setDefaultValue$com_talabat_core_experiment_data_data(@Nullable T t11) {
        this.defaultValue = t11;
    }

    public final void setExperimentKey$com_talabat_core_experiment_data_data(@Nullable FWFKey fWFKey) {
        this.experimentKey = fWFKey;
    }

    public final void setExperimentSource$com_talabat_core_experiment_data_data(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "<set-?>");
        this.experimentSource = iTalabatExperiment;
    }

    public final void setTrigger$com_talabat_core_experiment_data_data(@NotNull ExperimentTrigger experimentTrigger) {
        Intrinsics.checkNotNullParameter(experimentTrigger, "<set-?>");
        this.trigger = experimentTrigger;
    }

    @TalabatExperimentDsl
    public final void source(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "experimentSource");
        this.experimentSource = iTalabatExperiment;
    }

    @TalabatExperimentDsl
    public final void trigger(@NotNull ExperimentTrigger experimentTrigger) {
        Intrinsics.checkNotNullParameter(experimentTrigger, "trigger");
        this.trigger = experimentTrigger;
    }
}
