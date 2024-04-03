package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BoxWithConstraintsKt {
    @Composable
    @UiComposable
    public static final void BoxWithConstraints(@Nullable Modifier modifier, @Nullable Alignment alignment, boolean z11, @NotNull Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer startRestartGroup = composer.startRestartGroup(1781813501);
        int i18 = i12 & 1;
        if (i18 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i13 = i17 | i11;
        } else {
            i13 = i11;
        }
        int i19 = i12 & 2;
        if (i19 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) alignment)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i13 |= i16;
        }
        int i21 = i12 & 4;
        if (i21 != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed(z11)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i13 |= i15;
        }
        if ((i12 & 8) != 0) {
            i13 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else if ((i11 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function3)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i13 |= i14;
        }
        if ((i13 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i18 != 0) {
                modifier = Modifier.Companion;
            }
            if (i19 != 0) {
                alignment = Alignment.Companion.getTopStart();
            }
            if (i21 != 0) {
                z11 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1781813501, i13, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:58)");
            }
            int i22 = i13 >> 3;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(alignment, z11, startRestartGroup, (i22 & 112) | (i22 & 14));
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed((Object) function3) | startRestartGroup.changed((Object) rememberBoxMeasurePolicy);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BoxWithConstraintsKt$BoxWithConstraints$1$1(rememberBoxMeasurePolicy, function3, i13);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) rememberedValue, startRestartGroup, i13 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        Alignment alignment2 = alignment;
        boolean z12 = z11;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BoxWithConstraintsKt$BoxWithConstraints$2(modifier2, alignment2, z12, function3, i11, i12));
        }
    }
}
