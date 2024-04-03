package com.designsystem.ds_navigation_bar;

import android.view.ViewGroup;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.behaviour.DSNavigationBarAnimationBehaviorFixed;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.ds_navigation_bar.models.DSNavigationBarActionButtonModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"DSNavigationBarWithActionButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "subtitle", "leadingIconButton", "Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "actionButton", "Lcom/designsystem/ds_navigation_bar/models/DSNavigationBarActionButtonModel;", "animationBehavior", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lcom/designsystem/ds_icon_button/DSIconButtonModel;Lcom/designsystem/ds_navigation_bar/models/DSNavigationBarActionButtonModel;Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarWithActionButtonKt {
    @Composable
    public static final void DSNavigationBarWithActionButton(@Nullable Modifier modifier, @Nullable String str, @Nullable String str2, @NotNull DSIconButtonModel dSIconButtonModel, @NotNull DSNavigationBarActionButtonModel dSNavigationBarActionButtonModel, @Nullable DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, @Nullable Composer composer, int i11, int i12) {
        Modifier modifier2;
        String str3;
        String str4;
        DSNavigationBarAnimationBehaviorFixed dSNavigationBarAnimationBehaviorFixed;
        int i13;
        DSNavigationBarActionButtonModel dSNavigationBarActionButtonModel2 = dSNavigationBarActionButtonModel;
        Intrinsics.checkNotNullParameter(dSIconButtonModel, "leadingIconButton");
        Intrinsics.checkNotNullParameter(dSNavigationBarActionButtonModel2, "actionButton");
        Composer startRestartGroup = composer.startRestartGroup(-1965584077);
        if ((i12 & 1) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i12 & 2) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i12 & 4) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i12 & 32) != 0) {
            i13 = i11 & -458753;
            dSNavigationBarAnimationBehaviorFixed = new DSNavigationBarAnimationBehaviorFixed((ViewGroup) null, 1, (DefaultConstructorMarker) null);
        } else {
            dSNavigationBarAnimationBehaviorFixed = dSNavigationBarAnimationBehaviour;
            i13 = i11;
        }
        DSNavigationBarKt.DSNavigationBar(modifier2, str3, str4, dSIconButtonModel, ComposableLambdaKt.composableLambda(startRestartGroup, -819892432, true, new DSNavigationBarWithActionButtonKt$DSNavigationBarWithActionButton$1(dSNavigationBarActionButtonModel2)), dSNavigationBarAnimationBehaviorFixed, startRestartGroup, (i13 & 14) | CpioConstants.C_ISBLK | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (i13 & Opcodes.ASM7), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSNavigationBarWithActionButtonKt$DSNavigationBarWithActionButton$2(modifier2, str3, str4, dSIconButtonModel, dSNavigationBarActionButtonModel, dSNavigationBarAnimationBehaviorFixed, i11, i12));
        }
    }
}
