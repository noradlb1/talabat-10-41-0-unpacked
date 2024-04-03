package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DividerKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Divider-9IZ8Weo  reason: not valid java name */
    public static final void m1645Divider9IZ8Weo(@Nullable Modifier modifier, float f11, long j11, @Nullable Composer composer, int i11, int i12) {
        int i13;
        float f12;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(1562471785);
        int i17 = i12 & 1;
        if (i17 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        int i18 = i12 & 2;
        if (i18 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(f11)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        if ((i11 & 896) == 0) {
            if ((i12 & 4) != 0 || !startRestartGroup.changed(j11)) {
                i14 = 128;
            } else {
                i14 = 256;
            }
            i13 |= i14;
        }
        if ((i13 & 731) != 146 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i11 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i17 != 0) {
                    modifier = Modifier.Companion;
                }
                if (i18 != 0) {
                    f11 = DividerDefaults.INSTANCE.m1644getThicknessD9Ej5fM();
                }
                if ((i12 & 4) != 0) {
                    j11 = DividerDefaults.INSTANCE.getColor(startRestartGroup, 6);
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1562471785, i11, -1, "androidx.compose.material3.Divider (Divider.kt:43)");
            }
            startRestartGroup.startReplaceableGroup(1232935509);
            if (Dp.m5483equalsimpl0(f11, Dp.Companion.m5496getHairlineD9Ej5fM())) {
                f12 = Dp.m5478constructorimpl(1.0f / ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
            } else {
                f12 = f11;
            }
            startRestartGroup.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m177backgroundbw27NRU$default(SizeKt.m544height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), f12), j11, (Shape) null, 2, (Object) null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        float f13 = f11;
        long j12 = j11;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DividerKt$Divider$1(modifier2, f13, j12, i11, i12));
        }
    }
}
