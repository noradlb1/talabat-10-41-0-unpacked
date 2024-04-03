package com.designsystem.ds_alert;

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
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u00102\u001a\u000203H\u0017¢\u0006\u0002\u00104R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u00198F@FX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\t\u001a\u0004\u0018\u00010 8F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010'\u001a\u0004\u0018\u00010\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u00198F@FX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR/\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\t\u001a\u0004\u0018\u00010+8F@FX\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0011\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/designsystem/ds_alert/DSAlert;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/designsystem/ds_alert/DSAlertActionButtonModel;", "actionButton", "getActionButton", "()Lcom/designsystem/ds_alert/DSAlertActionButtonModel;", "setActionButton", "(Lcom/designsystem/ds_alert/DSAlertActionButtonModel;)V", "actionButton$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/designsystem/ds_alert/DSAlertType;", "alertType", "getAlertType", "()Lcom/designsystem/ds_alert/DSAlertType;", "setAlertType", "(Lcom/designsystem/ds_alert/DSAlertType;)V", "alertType$delegate", "", "descriptor", "getDescriptor", "()Ljava/lang/String;", "setDescriptor", "(Ljava/lang/String;)V", "descriptor$delegate", "Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "iconButton", "getIconButton", "()Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "setIconButton", "(Lcom/designsystem/ds_icon_button/DSIconButtonModel;)V", "iconButton$delegate", "title", "getTitle", "setTitle", "title$delegate", "", "withLeadingIcon", "getWithLeadingIcon", "()Ljava/lang/Boolean;", "setWithLeadingIcon", "(Ljava/lang/Boolean;)V", "withLeadingIcon$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSAlert extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState actionButton$delegate;
    @NotNull
    private final MutableState alertType$delegate;
    @NotNull
    private final MutableState descriptor$delegate;
    @NotNull
    private final MutableState iconButton$delegate;
    @NotNull
    private final MutableState title$delegate;
    @NotNull
    private final MutableState withLeadingIcon$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSAlert(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSAlert(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSAlert(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(2110815047);
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
            getDescriptor();
            getAlertType();
            String descriptor = getDescriptor();
            if (descriptor == null) {
                descriptor = "";
            }
            String str = descriptor;
            DSAlertType alertType = getAlertType();
            if (alertType == null) {
                alertType = DSAlertType.WARNING;
            }
            DSAlertKt.DSAlert((Modifier) null, str, alertType, getTitle(), getActionButton(), getIconButton(), getWithLeadingIcon(), startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSAlert$Content$3(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final DSAlertActionButtonModel getActionButton() {
        return (DSAlertActionButtonModel) this.actionButton$delegate.getValue();
    }

    @Nullable
    public final DSAlertType getAlertType() {
        return (DSAlertType) this.alertType$delegate.getValue();
    }

    @Nullable
    public final String getDescriptor() {
        return (String) this.descriptor$delegate.getValue();
    }

    @Nullable
    public final DSIconButtonModel getIconButton() {
        return (DSIconButtonModel) this.iconButton$delegate.getValue();
    }

    @Nullable
    public final String getTitle() {
        return (String) this.title$delegate.getValue();
    }

    @Nullable
    public final Boolean getWithLeadingIcon() {
        return (Boolean) this.withLeadingIcon$delegate.getValue();
    }

    public final void setActionButton(@Nullable DSAlertActionButtonModel dSAlertActionButtonModel) {
        this.actionButton$delegate.setValue(dSAlertActionButtonModel);
    }

    public final void setAlertType(@Nullable DSAlertType dSAlertType) {
        this.alertType$delegate.setValue(dSAlertType);
    }

    public final void setDescriptor(@Nullable String str) {
        this.descriptor$delegate.setValue(str);
    }

    public final void setIconButton(@Nullable DSIconButtonModel dSIconButtonModel) {
        this.iconButton$delegate.setValue(dSIconButtonModel);
    }

    public final void setTitle(@Nullable String str) {
        this.title$delegate.setValue(str);
    }

    public final void setWithLeadingIcon(@Nullable Boolean bool) {
        this.withLeadingIcon$delegate.setValue(bool);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSAlert(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        DSAlertType dSAlertType = null;
        this.descriptor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.alertType$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.title$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.actionButton$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.iconButton$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.withLeadingIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSAlert, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….styleable.DSAlert, 0, 0)");
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSAlert_at_alert_type, -1);
            setAlertType(i12 >= 0 ? DSAlertType.values()[i12] : dSAlertType);
            setDescriptor(obtainStyledAttributes.getString(R.styleable.DSAlert_at_descriptor));
            setTitle(obtainStyledAttributes.getString(R.styleable.DSAlert_at_title));
            setWithLeadingIcon(Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.DSAlert_at_with_leading_icon, true)));
        }
    }
}
