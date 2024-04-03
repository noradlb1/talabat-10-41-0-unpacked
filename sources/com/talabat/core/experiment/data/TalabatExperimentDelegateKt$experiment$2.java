package com.talabat.core.experiment.data;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00028\u00000\u0001J\r\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tJ$\u0010\u0012\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\r\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00028\u00008FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"com/talabat/core/experiment/data/TalabatExperimentDelegateKt$experiment$2", "Lkotlin/properties/ReadOnlyProperty;", "", "builder", "Lcom/talabat/core/experiment/data/ExperimentDelegateBuilder;", "getBuilder", "()Lcom/talabat/core/experiment/data/ExperimentDelegateBuilder;", "firstAccessValue", "getFirstAccessValue", "()Ljava/lang/Object;", "firstAccessValue$delegate", "Lkotlin/Lazy;", "initialValue", "getInitialValue", "setInitialValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "defaultValue", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "name", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "trigger", "com_talabat_core_experiment_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatExperimentDelegateKt$experiment$2 implements ReadOnlyProperty<Object, T> {
    @NotNull
    private final ExperimentDelegateBuilder<T> builder;
    @NotNull
    private final Lazy firstAccessValue$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TalabatExperimentDelegateKt$experiment$2$firstAccessValue$2(this));
    @Nullable
    private T initialValue;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExperimentTrigger.values().length];
            iArr[ExperimentTrigger.ON_INITIALIZE.ordinal()] = 1;
            iArr[ExperimentTrigger.ON_FIRST_ACCESS_ONLY.ordinal()] = 2;
            iArr[ExperimentTrigger.ON_EVERY_ACCESS.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TalabatExperimentDelegateKt$experiment$2(Function1<? super ExperimentDelegateBuilder<T>, Unit> function1) {
        T t11;
        ExperimentDelegateBuilder<T> experimentDelegateBuilder = new ExperimentDelegateBuilder<>();
        function1.invoke(experimentDelegateBuilder);
        this.builder = experimentDelegateBuilder;
        if (experimentDelegateBuilder.getTrigger$com_talabat_core_experiment_data_data() == ExperimentTrigger.ON_INITIALIZE) {
            t11 = trigger();
        } else {
            t11 = null;
        }
        this.initialValue = t11;
    }

    private final T defaultValue() {
        T defaultValue$com_talabat_core_experiment_data_data = this.builder.getDefaultValue$com_talabat_core_experiment_data_data();
        if (defaultValue$com_talabat_core_experiment_data_data != null) {
            return defaultValue$com_talabat_core_experiment_data_data;
        }
        throw new IllegalArgumentException("default value cannot be null");
    }

    private final FWFKey name() {
        FWFKey experimentKey$com_talabat_core_experiment_data_data = this.builder.getExperimentKey$com_talabat_core_experiment_data_data();
        if (experimentKey$com_talabat_core_experiment_data_data != null) {
            return experimentKey$com_talabat_core_experiment_data_data;
        }
        throw new IllegalArgumentException("experiment name cannot be null");
    }

    /* access modifiers changed from: private */
    public final T trigger() {
        return Experiments.withSafeExperiment$default(name(), defaultValue(), this.builder.getExperimentSource$com_talabat_core_experiment_data_data(), (Function1) null, 8, (Object) null);
    }

    @NotNull
    public final ExperimentDelegateBuilder<T> getBuilder() {
        return this.builder;
    }

    public final T getFirstAccessValue() {
        return this.firstAccessValue$delegate.getValue();
    }

    @Nullable
    public final T getInitialValue() {
        return this.initialValue;
    }

    public T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.builder.getTrigger$com_talabat_core_experiment_data_data().ordinal()];
        if (i11 == 1) {
            T t11 = this.initialValue;
            if (t11 == null) {
                return defaultValue();
            }
            return t11;
        } else if (i11 == 2) {
            return getFirstAccessValue();
        } else {
            if (i11 == 3) {
                return trigger();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setInitialValue(@Nullable T t11) {
        this.initialValue = t11;
    }
}
