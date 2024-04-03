package com.designsystem.ds_stepper;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/designsystem/ds_stepper/StepperValues;", "", "value", "", "min", "max", "(III)V", "getMax", "()I", "getMin", "getValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class StepperValues {
    private final int max;
    private final int min;
    private final int value;

    public StepperValues(int i11, int i12, int i13) {
        this.value = i11;
        this.min = i12;
        this.max = i13;
    }

    public static /* synthetic */ StepperValues copy$default(StepperValues stepperValues, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = stepperValues.value;
        }
        if ((i14 & 2) != 0) {
            i12 = stepperValues.min;
        }
        if ((i14 & 4) != 0) {
            i13 = stepperValues.max;
        }
        return stepperValues.copy(i11, i12, i13);
    }

    public final int component1() {
        return this.value;
    }

    public final int component2() {
        return this.min;
    }

    public final int component3() {
        return this.max;
    }

    @NotNull
    public final StepperValues copy(int i11, int i12, int i13) {
        return new StepperValues(i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepperValues)) {
            return false;
        }
        StepperValues stepperValues = (StepperValues) obj;
        return this.value == stepperValues.value && this.min == stepperValues.min && this.max == stepperValues.max;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.value * 31) + this.min) * 31) + this.max;
    }

    @NotNull
    public String toString() {
        return "StepperValues(value=" + this.value + ", min=" + this.min + ", max=" + this.max + ')';
    }
}
