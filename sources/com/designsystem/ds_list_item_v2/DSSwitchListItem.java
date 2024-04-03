package com.designsystem.ds_list_item_v2;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/designsystem/ds_list_item_v2/DSSwitchListItem;", "Lcom/designsystem/ds_list_item_v2/DSSelectionListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSSwitchListItem extends DSSelectionListItem {
    public static final int $stable = 0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSwitchListItem(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSwitchListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSSwitchListItem(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        float f11;
        boolean z11;
        int i13;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1806999351);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            getLabel();
            String label = getLabel();
            if (label == null) {
                label = "";
            }
            boolean isListItemSelected = isListItemSelected();
            Function1<Boolean, Unit> onChanged = getOnChanged();
            String descriptor = getDescriptor();
            String secondaryLabel = getSecondaryLabel();
            Integer descriptorColor = getDescriptorColor();
            Integer leadingIcon = getLeadingIcon();
            Integer leadingImage = getLeadingImage();
            Dp r12 = m8483getImageCornerRadiuslTKBWiU();
            if (r12 == null) {
                startRestartGroup.startReplaceableGroup(-1806998848);
                f11 = DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1806998884);
                startRestartGroup.endReplaceableGroup();
                f11 = r12.m5492unboximpl();
            }
            Boolean isEnabled = isEnabled();
            if (isEnabled == null) {
                z11 = true;
            } else {
                z11 = isEnabled.booleanValue();
            }
            DSSwitchListItemKt.m8486DSSwitchListItempU6N4AM(label, isListItemSelected, onChanged, (Modifier) null, descriptor, secondaryLabel, descriptorColor, leadingIcon, leadingImage, f11, z11, getPrice(), getOldPrice(), getShowSelectionIndicator(), startRestartGroup, 0, 0, 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSSwitchListItem$Content$2(this, i14));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSwitchListItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
