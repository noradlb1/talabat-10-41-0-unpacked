package com.designsystem.ds_empty_state_v2;

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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0017\u001a\u00020\u0018H\u0017¢\u0006\u0002\u0010\u0019R9\u0010\u000b\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR9\u0010\u0013\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00122\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/designsystem/ds_empty_state_v2/DSEmptyStateWithIcon;", "Lcom/designsystem/ds_empty_state_v2/DSEmptyStateV2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroidx/annotation/DrawableRes;", "icon", "getIcon", "()Ljava/lang/Integer;", "setIcon", "(Ljava/lang/Integer;)V", "icon$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/annotation/ColorRes;", "iconColor", "getIconColor", "setIconColor", "iconColor$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSEmptyStateWithIcon extends DSEmptyStateV2 {
    public static final int $stable = 0;
    @NotNull
    private final MutableState icon$delegate;
    @NotNull
    private final MutableState iconColor$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateWithIcon(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateWithIcon(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSEmptyStateWithIcon(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        Unit unit;
        Function0<Unit> function0;
        Color color;
        long j11;
        Function0<Unit> function02;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-953378382);
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
            Integer icon = getIcon();
            if (icon == null) {
                startRestartGroup.startReplaceableGroup(510042161);
                startRestartGroup.endReplaceableGroup();
                unit = null;
            } else {
                startRestartGroup.startReplaceableGroup(-953378352);
                int intValue = icon.intValue();
                String title = getTitle();
                String details = getDetails();
                Integer iconColor = getIconColor();
                if (iconColor == null) {
                    startRestartGroup.startReplaceableGroup(1908761530);
                    startRestartGroup.endReplaceableGroup();
                    color = null;
                } else {
                    startRestartGroup.startReplaceableGroup(-1600995033);
                    long colorResource = ColorResources_androidKt.colorResource(iconColor.intValue(), startRestartGroup, 0);
                    startRestartGroup.endReplaceableGroup();
                    color = Color.m2909boximpl(colorResource);
                }
                if (color == null) {
                    j11 = Color.Companion.m2955getUnspecified0d7_KjU();
                } else {
                    j11 = color.m2929unboximpl();
                }
                String buttonText = getButtonText();
                if (getButtonText() == null) {
                    function02 = null;
                } else {
                    function02 = getOnButtonTap();
                }
                DSEmptyStateWithIconKt.m8334DSEmptyStateWithIcon3f6hBDE(title, intValue, (Modifier) null, details, j11, buttonText, function02, startRestartGroup, 0, 4);
                startRestartGroup.endReplaceableGroup();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                startRestartGroup.startReplaceableGroup(-953377992);
                String title2 = getTitle();
                String details2 = getDetails();
                String buttonText2 = getButtonText();
                if (getButtonText() == null) {
                    function0 = null;
                } else {
                    function0 = getOnButtonTap();
                }
                DSEmptyStateKt.DSEmptyState(title2, (Modifier) null, details2, buttonText2, function0, startRestartGroup, 0, 2);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-953378358);
                startRestartGroup.endReplaceableGroup();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSEmptyStateWithIcon$Content$3(this, i11));
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

    public final void setIcon(@Nullable Integer num) {
        this.icon$delegate.setValue(num);
    }

    public final void setIconColor(@Nullable Integer num) {
        this.iconColor$delegate.setValue(num);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateWithIcon(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.icon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.iconColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSEmptyStateWithIcon, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…EmptyStateWithIcon, 0, 0)");
            setIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSEmptyStateWithIcon_es_v2_icon));
            setIconColor(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSEmptyStateWithIcon_es_v2_icon_color));
            obtainStyledAttributes.recycle();
        }
    }
}
