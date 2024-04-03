package com.designsystem.ds_stepper;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0012\u001a\u00020\u0013H\u0017¢\u0006\u0002\u0010\u0014R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/designsystem/ds_stepper/DSCollapsibleQuantityStepper;", "Lcom/designsystem/ds_stepper/BaseQuantityStepper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroidx/compose/ui/Alignment$Horizontal;", "alignment", "getAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "setAlignment", "(Landroidx/compose/ui/Alignment$Horizontal;)V", "alignment$delegate", "Landroidx/compose/runtime/MutableState;", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSCollapsibleQuantityStepper extends BaseQuantityStepper {
    public static final int $stable = 0;
    @NotNull
    private final MutableState alignment$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSCollapsibleQuantityStepper(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSCollapsibleQuantityStepper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSCollapsibleQuantityStepper(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15 = i11;
        Composer startRestartGroup = composer.startRestartGroup(196290675);
        if ((i15 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i15;
        } else {
            i12 = i15;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            getInitialValue();
            int min = getMin();
            int max = getMax();
            Integer initialValue = getInitialValue();
            if (initialValue == null) {
                i13 = 0;
            } else {
                i13 = initialValue.intValue();
            }
            DSCollapsibleQuantityStepperKt.DSCollapsibleQuantityStepper((Modifier) null, min, max, i13, getOnValueChanged(), getShouldShowBinIcon(), getAlignment(), getForceMM2(), isLoading(), isStepperEnabled(), startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSCollapsibleQuantityStepper$Content$2(this, i15));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final Alignment.Horizontal getAlignment() {
        return (Alignment.Horizontal) this.alignment$delegate.getValue();
    }

    public final void setAlignment(@Nullable Alignment.Horizontal horizontal) {
        this.alignment$delegate.setValue(horizontal);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSCollapsibleQuantityStepper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.alignment$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
