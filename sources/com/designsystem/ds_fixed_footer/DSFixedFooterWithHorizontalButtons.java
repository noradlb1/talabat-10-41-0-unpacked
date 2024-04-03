package com.designsystem.ds_fixed_footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/designsystem/ds_fixed_footer/DSFixedFooterWithHorizontalButtons;", "Lcom/designsystem/ds_fixed_footer/DSFixedFooterWithButtons;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithHorizontalButtons extends DSFixedFooterWithButtons {
    public static final int $stable = 0;
    public static final float ButtonBoxWeight = 1.0f;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_fixed_footer/DSFixedFooterWithHorizontalButtons$Companion;", "", "()V", "ButtonBoxWeight", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooterWithHorizontalButtons(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooterWithHorizontalButtons(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSFixedFooterWithHorizontalButtons(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        ComposableLambda composableLambda;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1442721360);
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
        if ((2 ^ (i12 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            boolean isElevated = isElevated();
            View topContent = getTopContent();
            if (topContent == null) {
                composableLambda = null;
            } else {
                composableLambda = ComposableLambdaKt.composableLambdaInstance(-985530789, true, new DSFixedFooterWithHorizontalButtons$Content$1$1(topContent));
            }
            int i14 = (i12 << 3) & 112;
            DSFixedFooterWithHorizontalButtonsKt.DSFixedFooterWithHorizontalButtons((Modifier) null, isElevated, composableLambda, a(getButtons(), startRestartGroup, i14 | 8), startRestartGroup, 4096, 1);
            FixedFooterPadding$marshmallow_release(isElevated(), startRestartGroup, i14);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSFixedFooterWithHorizontalButtons$Content$2(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooterWithHorizontalButtons(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
