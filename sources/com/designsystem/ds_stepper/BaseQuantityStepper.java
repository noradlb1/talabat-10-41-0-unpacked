package com.designsystem.ds_stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AbstractComposeView;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR+\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR+\u0010\u001f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R+\u0010%\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0011\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#RG\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*\u0018\u00010)8F@FX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0011\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u00101\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0011\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000f¨\u00065"}, d2 = {"Lcom/designsystem/ds_stepper/BaseQuantityStepper;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "forceMM2", "getForceMM2", "()Z", "setForceMM2", "(Z)V", "forceMM2$delegate", "Landroidx/compose/runtime/MutableState;", "initialValue", "getInitialValue", "()Ljava/lang/Integer;", "setInitialValue", "(Ljava/lang/Integer;)V", "initialValue$delegate", "isEnabled", "isStepperEnabled", "setStepperEnabled", "isEnabled$delegate", "isLoading", "setLoading", "isLoading$delegate", "max", "getMax", "()I", "setMax", "(I)V", "max$delegate", "min", "getMin", "setMin", "min$delegate", "Lkotlin/Function1;", "", "onValueChanged", "getOnValueChanged", "()Lkotlin/jvm/functions/Function1;", "setOnValueChanged", "(Lkotlin/jvm/functions/Function1;)V", "onValueChanged$delegate", "shouldShowBinIcon", "getShouldShowBinIcon", "setShouldShowBinIcon", "shouldShowBinIcon$delegate", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class BaseQuantityStepper extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState forceMM2$delegate;
    @NotNull
    private final MutableState initialValue$delegate;
    @NotNull
    private final MutableState isEnabled$delegate;
    @NotNull
    private final MutableState isLoading$delegate;
    @NotNull
    private final MutableState max$delegate;
    @NotNull
    private final MutableState min$delegate;
    @NotNull
    private final MutableState onValueChanged$delegate;
    @NotNull
    private final MutableState shouldShowBinIcon$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseQuantityStepper(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseQuantityStepper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseQuantityStepper(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean getForceMM2() {
        return ((Boolean) this.forceMM2$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final Integer getInitialValue() {
        return (Integer) this.initialValue$delegate.getValue();
    }

    public final int getMax() {
        return ((Number) this.max$delegate.getValue()).intValue();
    }

    public final int getMin() {
        return ((Number) this.min$delegate.getValue()).intValue();
    }

    @Nullable
    public final Function1<Integer, Unit> getOnValueChanged() {
        return (Function1) this.onValueChanged$delegate.getValue();
    }

    public final boolean getShouldShowBinIcon() {
        return ((Boolean) this.shouldShowBinIcon$delegate.getValue()).booleanValue();
    }

    public final boolean isLoading() {
        return ((Boolean) this.isLoading$delegate.getValue()).booleanValue();
    }

    @JvmName(name = "isStepperEnabled")
    public final boolean isStepperEnabled() {
        return ((Boolean) this.isEnabled$delegate.getValue()).booleanValue();
    }

    public final void setForceMM2(boolean z11) {
        this.forceMM2$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setInitialValue(@Nullable Integer num) {
        this.initialValue$delegate.setValue(num);
    }

    public final void setLoading(boolean z11) {
        this.isLoading$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setMax(int i11) {
        this.max$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setMin(int i11) {
        this.min$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setOnValueChanged(@Nullable Function1<? super Integer, Unit> function1) {
        this.onValueChanged$delegate.setValue(function1);
    }

    public final void setShouldShowBinIcon(boolean z11) {
        this.shouldShowBinIcon$delegate.setValue(Boolean.valueOf(z11));
    }

    @JvmName(name = "setStepperEnabled")
    public final void setStepperEnabled(boolean z11) {
        this.isEnabled$delegate.setValue(Boolean.valueOf(z11));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseQuantityStepper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.min$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.max$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(99, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.initialValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onValueChanged$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool = Boolean.FALSE;
        this.shouldShowBinIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.forceMM2$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isLoading$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BaseQuantityStepper, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…aseQuantityStepper, 0, 0)");
            setMin(obtainStyledAttributes.getInt(R.styleable.BaseQuantityStepper_qs_min, 0));
            setMax(obtainStyledAttributes.getInt(R.styleable.BaseQuantityStepper_qs_max, 99));
            int i12 = R.styleable.BaseQuantityStepper_qs_initial_value;
            if (obtainStyledAttributes.hasValue(i12)) {
                setInitialValue(Integer.valueOf(obtainStyledAttributes.getInt(i12, 0)));
            }
            setShouldShowBinIcon(obtainStyledAttributes.getBoolean(R.styleable.BaseQuantityStepper_qs_should_show_bin_icon, false));
            setForceMM2(obtainStyledAttributes.getBoolean(R.styleable.BaseQuantityStepper_qs_force_mm2, false));
            setLoading(obtainStyledAttributes.getBoolean(R.styleable.BaseQuantityStepper_qs_is_loading, false));
            setStepperEnabled(obtainStyledAttributes.getBoolean(R.styleable.BaseQuantityStepper_qs_is_enabled, true));
        }
    }
}
