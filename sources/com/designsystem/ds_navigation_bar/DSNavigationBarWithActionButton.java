package com.designsystem.ds_navigation_bar;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.models.DSNavigationBarActionButtonModel;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0012\u001a\u00020\u0013H\u0017¢\u0006\u0002\u0010\u0014R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/designsystem/ds_navigation_bar/DSNavigationBarWithActionButton;", "Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/designsystem/ds_navigation_bar/models/DSNavigationBarActionButtonModel;", "actionButton", "getActionButton", "()Lcom/designsystem/ds_navigation_bar/models/DSNavigationBarActionButtonModel;", "setActionButton", "(Lcom/designsystem/ds_navigation_bar/models/DSNavigationBarActionButtonModel;)V", "actionButton$delegate", "Landroidx/compose/runtime/MutableState;", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarWithActionButton extends DSNavigationBar {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String NAVIGATION_BAR_ACTION_BUTTON_TEST_TAG = "NAVIGATION_BAR_ACTION_BUTTON_TEST_TAG";
    @NotNull
    private final MutableState actionButton$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_navigation_bar/DSNavigationBarWithActionButton$Companion;", "", "()V", "NAVIGATION_BAR_ACTION_BUTTON_TEST_TAG", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSNavigationBarWithActionButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSNavigationBarWithActionButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSNavigationBarWithActionButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1987256266);
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
            getLeadingIconButton();
            getActionButton();
            String title = getTitle();
            String subtitle = getSubtitle();
            DSIconButtonModel leadingIconButton = getLeadingIconButton();
            if (leadingIconButton == null) {
                leadingIconButton = DSIconButtonModel.Companion.empty();
            }
            DSIconButtonModel dSIconButtonModel = leadingIconButton;
            DSNavigationBarActionButtonModel actionButton = getActionButton();
            if (actionButton == null) {
                actionButton = DSNavigationBarActionButtonModel.Companion.empty();
            }
            DSNavigationBarWithActionButtonKt.DSNavigationBarWithActionButton((Modifier) null, title, subtitle, dSIconButtonModel, actionButton, getAnimationBehavior(), startRestartGroup, 32768, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSNavigationBarWithActionButton$Content$3(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final DSNavigationBarActionButtonModel getActionButton() {
        return (DSNavigationBarActionButtonModel) this.actionButton$delegate.getValue();
    }

    public final void setActionButton(@Nullable DSNavigationBarActionButtonModel dSNavigationBarActionButtonModel) {
        this.actionButton$delegate.setValue(dSNavigationBarActionButtonModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSNavigationBarWithActionButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.actionButton$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
