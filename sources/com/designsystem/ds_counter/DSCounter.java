package com.designsystem.ds_counter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.res.ColorResources_androidKt;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u001b\u001a\u00020\u001cH\u0017¢\u0006\u0002\u0010\u001dR+\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR/\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/designsystem/ds_counter/DSCounter;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "containerColor", "getContainerColor", "()I", "setContainerColor", "(I)V", "containerColor$delegate", "Landroidx/compose/runtime/MutableState;", "labelColor", "getLabelColor", "setLabelColor", "labelColor$delegate", "value", "getValue", "()Ljava/lang/Integer;", "setValue", "(Ljava/lang/Integer;)V", "value$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSCounter extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState containerColor$delegate;
    @NotNull
    private final MutableState labelColor$delegate;
    @NotNull
    private final MutableState value$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSCounter(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSCounter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSCounter(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-457685465);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            getValue();
            Integer value = getValue();
            if (value == null) {
                i13 = 0;
            } else {
                i13 = value.intValue();
            }
            DSCounterKt.m8333DSCountereaDK9VM(i13, (Modifier) null, ColorResources_androidKt.colorResource(getLabelColor(), startRestartGroup, 0), ColorResources_androidKt.colorResource(getContainerColor(), startRestartGroup, 0), startRestartGroup, 0, 2);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSCounter$Content$2(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final int getContainerColor() {
        return ((Number) this.containerColor$delegate.getValue()).intValue();
    }

    public final int getLabelColor() {
        return ((Number) this.labelColor$delegate.getValue()).intValue();
    }

    @Nullable
    public final Integer getValue() {
        return (Integer) this.value$delegate.getValue();
    }

    public final void setContainerColor(int i11) {
        this.containerColor$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setLabelColor(int i11) {
        this.labelColor$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setValue(@Nullable Integer num) {
        this.value$delegate.setValue(num);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSCounter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        int i12 = R.color.ds_primary_100;
        this.containerColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i12), (SnapshotMutationPolicy) null, 2, (Object) null);
        int i13 = R.color.ds_neutral_white;
        this.labelColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i13), (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSCounter, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.DSCounter, 0, 0)");
            int i14 = R.styleable.DSCounter_ctr_value;
            if (obtainStyledAttributes.hasValue(i14)) {
                setValue(Integer.valueOf(obtainStyledAttributes.getInt(i14, 0)));
            }
            Integer resourceIdOrNull = TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSCounter_ctr_container_color);
            setContainerColor(resourceIdOrNull != null ? resourceIdOrNull.intValue() : i12);
            Integer resourceIdOrNull2 = TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSCounter_ctr_label_color);
            setLabelColor(resourceIdOrNull2 != null ? resourceIdOrNull2.intValue() : i13);
            obtainStyledAttributes.recycle();
        }
    }
}
