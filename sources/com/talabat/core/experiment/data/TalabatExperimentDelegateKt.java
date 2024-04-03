package com.talabat.core.experiment.data;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0007\u001a1\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u0003H\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"experiment", "Lkotlin/properties/ReadOnlyProperty;", "", "T", "experimentBuilder", "Lkotlin/Function1;", "Lcom/talabat/core/experiment/data/ExperimentDelegateBuilder;", "", "Lkotlin/ExtensionFunctionType;", "name", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/Object;)Lkotlin/properties/ReadOnlyProperty;", "com_talabat_core_experiment_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TalabatExperimentDelegateKt {
    @TalabatExperimentDsl
    @NotNull
    public static final <T> ReadOnlyProperty<Object, T> experiment(@NotNull FWFKey fWFKey, T t11) {
        Intrinsics.checkNotNullParameter(fWFKey, "name");
        return experiment(new TalabatExperimentDelegateKt$experiment$1(fWFKey, t11));
    }

    @TalabatExperimentDsl
    @NotNull
    public static final <T> ReadOnlyProperty<Object, T> experiment(@NotNull Function1<? super ExperimentDelegateBuilder<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "experimentBuilder");
        return new TalabatExperimentDelegateKt$experiment$2(function1);
    }
}
