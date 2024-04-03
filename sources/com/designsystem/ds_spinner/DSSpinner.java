package com.designsystem.ds_spinner;

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
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0019\u001a\u00020\u001aH\u0017¢\u0006\u0002\u0010\u001bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/designsystem/ds_spinner/DSSpinner;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/designsystem/ds_spinner/DSSpinnerSize;", "size", "getSize", "()Lcom/designsystem/ds_spinner/DSSpinnerSize;", "setSize", "(Lcom/designsystem/ds_spinner/DSSpinnerSize;)V", "size$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/designsystem/ds_spinner/DSSpinnerColor;", "type", "getType", "()Lcom/designsystem/ds_spinner/DSSpinnerColor;", "setType", "(Lcom/designsystem/ds_spinner/DSSpinnerColor;)V", "type$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSSpinner extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState size$delegate;
    @NotNull
    private final MutableState type$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSpinner(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSpinner(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSSpinner(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1035117723);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            DSSpinnerKt.DSSpinner((Modifier) null, getType(), getSize(), startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSSpinner$Content$1(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @NotNull
    public final DSSpinnerSize getSize() {
        return (DSSpinnerSize) this.size$delegate.getValue();
    }

    @NotNull
    public final DSSpinnerColor getType() {
        return (DSSpinnerColor) this.type$delegate.getValue();
    }

    public final void setSize(@NotNull DSSpinnerSize dSSpinnerSize) {
        Intrinsics.checkNotNullParameter(dSSpinnerSize, "<set-?>");
        this.size$delegate.setValue(dSSpinnerSize);
    }

    public final void setType(@NotNull DSSpinnerColor dSSpinnerColor) {
        Intrinsics.checkNotNullParameter(dSSpinnerColor, "<set-?>");
        this.type$delegate.setValue(dSSpinnerColor);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSpinner(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        DSSpinnerColor dSSpinnerColor = DSSpinnerColor.Orange;
        this.type$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(dSSpinnerColor, (SnapshotMutationPolicy) null, 2, (Object) null);
        DSSpinnerSize dSSpinnerSize = DSSpinnerSize.Normal;
        this.size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(dSSpinnerSize, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSSpinner, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.DSSpinner, 0, 0)");
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSSpinner_sr_color, -1);
            setType(i12 >= 0 ? DSSpinnerColor.values()[i12] : dSSpinnerColor);
            int i13 = obtainStyledAttributes.getInt(R.styleable.DSSpinner_sr_size, -1);
            setSize(i13 >= 0 ? DSSpinnerSize.values()[i13] : dSSpinnerSize);
            obtainStyledAttributes.recycle();
        }
    }
}
