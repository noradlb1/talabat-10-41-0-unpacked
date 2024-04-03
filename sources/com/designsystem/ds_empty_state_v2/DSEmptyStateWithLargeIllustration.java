package com.designsystem.ds_empty_state_v2;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/designsystem/ds_empty_state_v2/DSEmptyStateWithLargeIllustration;", "Lcom/designsystem/ds_empty_state_v2/DSEmptyStateWithIllustration;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSEmptyStateWithLargeIllustration extends DSEmptyStateWithIllustration {
    public static final int $stable = 0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateWithLargeIllustration(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateWithLargeIllustration(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSEmptyStateWithLargeIllustration(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        Unit unit;
        Function0<Unit> function0;
        Function0<Unit> function02;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1990756050);
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
            Integer illustration = getIllustration();
            if (illustration == null) {
                startRestartGroup.startReplaceableGroup(1583896585);
                startRestartGroup.endReplaceableGroup();
                unit = null;
            } else {
                startRestartGroup.startReplaceableGroup(1990756088);
                int intValue = illustration.intValue();
                String title = getTitle();
                String details = getDetails();
                String buttonText = getButtonText();
                if (getButtonText() == null) {
                    function02 = null;
                } else {
                    function02 = getOnButtonTap();
                }
                DSEmptyStateWithLargeIllustrationKt.DSEmptyStateWithLargeIllustration(title, intValue, (Modifier) null, details, buttonText, function02, startRestartGroup, 0, 4);
                startRestartGroup.endReplaceableGroup();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                startRestartGroup.startReplaceableGroup(1990756398);
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
                startRestartGroup.startReplaceableGroup(1990756074);
                startRestartGroup.endReplaceableGroup();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSEmptyStateWithLargeIllustration$Content$3(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateWithLargeIllustration(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
