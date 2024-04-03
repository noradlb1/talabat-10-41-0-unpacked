package com.designsystem.ds_switch;

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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010(\u001a\u00020\u0017H\u0017¢\u0006\u0002\u0010)R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fRG\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n8F@FX\u000e¢\u0006\u0012\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR*\u0010$\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n8F@FX\u000e¢\u0006\u0012\u0012\u0004\b%\u0010!\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f¨\u0006*"}, d2 = {"Lcom/designsystem/ds_switch/DSSwitch;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isChecked", "isSwitchChecked", "()Z", "setSwitchChecked", "(Z)V", "isChecked$delegate", "Landroidx/compose/runtime/MutableState;", "isEnabled", "isSwitchEnabled", "setSwitchEnabled", "isEnabled$delegate", "Lkotlin/Function1;", "", "onCheckedChange", "getOnCheckedChange", "()Lkotlin/jvm/functions/Function1;", "setOnCheckedChange", "(Lkotlin/jvm/functions/Function1;)V", "onCheckedChange$delegate", "value", "switchIsChecked", "getSwitchIsChecked$annotations", "()V", "getSwitchIsChecked", "setSwitchIsChecked", "switchIsEnabled", "getSwitchIsEnabled$annotations", "getSwitchIsEnabled", "setSwitchIsEnabled", "Content", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSSwitch extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState isChecked$delegate;
    @NotNull
    private final MutableState isEnabled$delegate;
    @NotNull
    private final MutableState onCheckedChange$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSwitch(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSwitch(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSSwitch(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Deprecated(message = "This parameter has been replaced by 'isChecked'", replaceWith = @ReplaceWith(expression = "isChecked", imports = {}))
    public static /* synthetic */ void getSwitchIsChecked$annotations() {
    }

    @Deprecated(message = "This parameter has been replaced by 'isEnabled'", replaceWith = @ReplaceWith(expression = "isEnabled", imports = {}))
    public static /* synthetic */ void getSwitchIsEnabled$annotations() {
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        DSSwitch$Content$1$1 dSSwitch$Content$1$1;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1526720122);
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
            boolean isSwitchChecked = isSwitchChecked();
            boolean isSwitchEnabled = isSwitchEnabled();
            Function1<Boolean, Unit> onCheckedChange = getOnCheckedChange();
            if (onCheckedChange == null) {
                dSSwitch$Content$1$1 = null;
            } else {
                dSSwitch$Content$1$1 = new DSSwitch$Content$1$1(this, onCheckedChange);
            }
            DSSwitchKt.DSSwitch((Modifier) null, isSwitchChecked, isSwitchEnabled, dSSwitch$Content$1$1, startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSSwitch$Content$2(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final Function1<Boolean, Unit> getOnCheckedChange() {
        return (Function1) this.onCheckedChange$delegate.getValue();
    }

    public final boolean getSwitchIsChecked() {
        return isSwitchChecked();
    }

    public final boolean getSwitchIsEnabled() {
        return isSwitchEnabled();
    }

    @JvmName(name = "isSwitchChecked")
    public final boolean isSwitchChecked() {
        return ((Boolean) this.isChecked$delegate.getValue()).booleanValue();
    }

    @JvmName(name = "isSwitchEnabled")
    public final boolean isSwitchEnabled() {
        return ((Boolean) this.isEnabled$delegate.getValue()).booleanValue();
    }

    public final void setOnCheckedChange(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onCheckedChange$delegate.setValue(function1);
    }

    @JvmName(name = "setSwitchChecked")
    public final void setSwitchChecked(boolean z11) {
        this.isChecked$delegate.setValue(Boolean.valueOf(z11));
    }

    @JvmName(name = "setSwitchEnabled")
    public final void setSwitchEnabled(boolean z11) {
        this.isEnabled$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setSwitchIsChecked(boolean z11) {
        setSwitchChecked(z11);
    }

    public final void setSwitchIsEnabled(boolean z11) {
        setSwitchEnabled(z11);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSwitch(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isChecked$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onCheckedChange$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSSwitch, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.DSSwitch, 0, 0)");
            setSwitchEnabled(obtainStyledAttributes.getBoolean(R.styleable.DSSwitch_sw_is_enabled, true));
            setSwitchChecked(obtainStyledAttributes.getBoolean(R.styleable.DSSwitch_sw_is_checked, false));
            obtainStyledAttributes.recycle();
        }
    }
}
