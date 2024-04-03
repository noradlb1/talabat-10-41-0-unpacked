package com.designsystem.ds_icon_button;

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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.res.ColorResources_androidKt;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010-\u001a\u00020\u0018H\u0017¢\u0006\u0002\u0010.R9\u0010\u000b\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR9\u0010\u0013\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00122\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR;\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178F@FX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8F@FX\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010'\u001a\u00020&2\u0006\u0010\t\u001a\u00020&8F@FX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/designsystem/ds_icon_button/DSIconButton;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroidx/annotation/DrawableRes;", "icon", "getIcon", "()Ljava/lang/Integer;", "setIcon", "(Ljava/lang/Integer;)V", "icon$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/annotation/ColorRes;", "iconColor", "getIconColor", "setIconColor", "iconColor$delegate", "Lkotlin/Function0;", "", "onTap", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "setOnTap", "(Lkotlin/jvm/functions/Function0;)V", "onTap$delegate", "", "showRoundedBackground", "getShowRoundedBackground", "()Z", "setShowRoundedBackground", "(Z)V", "showRoundedBackground$delegate", "Lcom/designsystem/ds_icon_button/DSIconButtonSize;", "size", "getSize", "()Lcom/designsystem/ds_icon_button/DSIconButtonSize;", "setSize", "(Lcom/designsystem/ds_icon_button/DSIconButtonSize;)V", "size$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSIconButton extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState icon$delegate;
    @NotNull
    private final MutableState iconColor$delegate;
    @NotNull
    private final MutableState onTap$delegate;
    @NotNull
    private final MutableState showRoundedBackground$delegate;
    @NotNull
    private final MutableState size$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSIconButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSIconButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSIconButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Color color;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(975759375);
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
            getIcon();
            Integer icon = getIcon();
            if (icon == null) {
                i13 = -1;
            } else {
                i13 = icon.intValue();
            }
            int i15 = i13;
            Function0<Unit> onTap = getOnTap();
            Integer iconColor = getIconColor();
            if (iconColor == null) {
                startRestartGroup.startReplaceableGroup(183777087);
                startRestartGroup.endReplaceableGroup();
                color = null;
            } else {
                startRestartGroup.startReplaceableGroup(975759618);
                long colorResource = ColorResources_androidKt.colorResource(iconColor.intValue(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                color = Color.m2909boximpl(colorResource);
            }
            DSIconButtonKt.m8355DSIconButton_trzpw((Modifier) null, i15, onTap, color, getShowRoundedBackground(), getSize(), startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSIconButton$Content$3(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final Integer getIcon() {
        return (Integer) this.icon$delegate.getValue();
    }

    @Nullable
    public final Integer getIconColor() {
        return (Integer) this.iconColor$delegate.getValue();
    }

    @Nullable
    public final Function0<Unit> getOnTap() {
        return (Function0) this.onTap$delegate.getValue();
    }

    public final boolean getShowRoundedBackground() {
        return ((Boolean) this.showRoundedBackground$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final DSIconButtonSize getSize() {
        return (DSIconButtonSize) this.size$delegate.getValue();
    }

    public final void setIcon(@Nullable Integer num) {
        this.icon$delegate.setValue(num);
    }

    public final void setIconColor(@Nullable Integer num) {
        this.iconColor$delegate.setValue(num);
    }

    public final void setOnTap(@Nullable Function0<Unit> function0) {
        this.onTap$delegate.setValue(function0);
    }

    public final void setShowRoundedBackground(boolean z11) {
        this.showRoundedBackground$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setSize(@NotNull DSIconButtonSize dSIconButtonSize) {
        Intrinsics.checkNotNullParameter(dSIconButtonSize, "<set-?>");
        this.size$delegate.setValue(dSIconButtonSize);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSIconButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.icon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.iconColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.showRoundedBackground$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        DSIconButtonSize dSIconButtonSize = DSIconButtonSize.SMALL;
        this.size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(dSIconButtonSize, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSIconButton, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.DSIconButton, 0, 0)");
            setIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSIconButton_ib_icon));
            setIconColor(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSIconButton_ib_icon_color));
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSIconButton_ib_size, -1);
            setSize(i12 >= 0 ? DSIconButtonSize.values()[i12] : dSIconButtonSize);
            setShowRoundedBackground(obtainStyledAttributes.getBoolean(R.styleable.DSIconButton_ib_show_rounded_background, false));
            obtainStyledAttributes.recycle();
        }
    }
}
