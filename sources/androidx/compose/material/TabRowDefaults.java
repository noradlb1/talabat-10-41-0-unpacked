package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import com.huawei.hms.analytics.instance.CallBack;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/TabRowDefaults;", "", "()V", "DividerOpacity", "", "DividerThickness", "Landroidx/compose/ui/unit/Dp;", "getDividerThickness-D9Ej5fM", "()F", "F", "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;
    private static final float DividerThickness = Dp.m5478constructorimpl((float) 1);
    @NotNull
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float IndicatorHeight = Dp.m5478constructorimpl((float) 2);
    private static final float ScrollableTabRowPadding = Dp.m5478constructorimpl((float) 52);

    private TabRowDefaults() {
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Divider-9IZ8Weo  reason: not valid java name */
    public final void m1417Divider9IZ8Weo(@Nullable Modifier modifier, float f11, long j11, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Modifier modifier2;
        float f12;
        long j12;
        long j13;
        float f13;
        float f14;
        Modifier modifier3;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        Composer startRestartGroup = composer.startRestartGroup(910934799);
        int i19 = i12 & 1;
        if (i19 != 0) {
            i13 = i18 | 6;
            modifier2 = modifier;
        } else if ((i18 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed((Object) modifier2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i13 = i17 | i18;
        } else {
            modifier2 = modifier;
            i13 = i18;
        }
        if ((i18 & 112) == 0) {
            if ((i12 & 2) == 0) {
                f12 = f11;
                if (startRestartGroup.changed(f12)) {
                    i16 = 32;
                    i13 |= i16;
                }
            } else {
                f12 = f11;
            }
            i16 = 16;
            i13 |= i16;
        } else {
            f12 = f11;
        }
        if ((i18 & 896) == 0) {
            j12 = j11;
            if ((i12 & 4) != 0 || !startRestartGroup.changed(j12)) {
                i15 = 128;
            } else {
                i15 = 256;
            }
            i13 |= i15;
        } else {
            j12 = j11;
        }
        if ((i12 & 8) != 0) {
            i13 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else {
            if ((i18 & 7168) == 0) {
                if (startRestartGroup.changed((Object) this)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i13 |= i14;
            }
        }
        if ((i13 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i18 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i12 & 2) != 0) {
                    f14 = DividerThickness;
                    i13 &= CallBack.OAID_TRACKING_OFF;
                } else {
                    f14 = f12;
                }
                if ((i12 & 4) != 0) {
                    j13 = Color.m2918copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i13 &= -897;
                    startRestartGroup.endDefaults();
                    DividerKt.m1219DivideroMI9zvI(modifier3, j13, f14, 0.0f, startRestartGroup, (i13 & 14) | ((i13 >> 3) & 112) | ((i13 << 3) & 896), 8);
                    f13 = f14;
                    modifier2 = modifier3;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i12 & 2) != 0) {
                    i13 &= CallBack.OAID_TRACKING_OFF;
                }
                if ((i12 & 4) != 0) {
                    i13 &= -897;
                }
                modifier3 = modifier2;
                f14 = f12;
            }
            j13 = j12;
            startRestartGroup.endDefaults();
            DividerKt.m1219DivideroMI9zvI(modifier3, j13, f14, 0.0f, startRestartGroup, (i13 & 14) | ((i13 >> 3) & 112) | ((i13 << 3) & 896), 8);
            f13 = f14;
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
            f13 = f12;
            j13 = j12;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowDefaults$Divider$1(this, modifier2, f13, j13, i11, i12));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Indicator-9IZ8Weo  reason: not valid java name */
    public final void m1418Indicator9IZ8Weo(@Nullable Modifier modifier, float f11, long j11, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Modifier modifier2;
        float f12;
        long j12;
        long j13;
        float f13;
        float f14;
        Modifier modifier3;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        Composer startRestartGroup = composer.startRestartGroup(1499002201);
        int i19 = i12 & 1;
        if (i19 != 0) {
            i13 = i18 | 6;
            modifier2 = modifier;
        } else if ((i18 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed((Object) modifier2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i13 = i17 | i18;
        } else {
            modifier2 = modifier;
            i13 = i18;
        }
        if ((i18 & 112) == 0) {
            if ((i12 & 2) == 0) {
                f12 = f11;
                if (startRestartGroup.changed(f12)) {
                    i16 = 32;
                    i13 |= i16;
                }
            } else {
                f12 = f11;
            }
            i16 = 16;
            i13 |= i16;
        } else {
            f12 = f11;
        }
        if ((i18 & 896) == 0) {
            j12 = j11;
            if ((i12 & 4) != 0 || !startRestartGroup.changed(j12)) {
                i15 = 128;
            } else {
                i15 = 256;
            }
            i13 |= i15;
        } else {
            j12 = j11;
        }
        if ((i12 & 8) != 0) {
            i13 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else {
            if ((i18 & 7168) == 0) {
                if (startRestartGroup.changed((Object) this)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i13 |= i14;
            }
        }
        if ((i13 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i18 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i12 & 2) != 0) {
                    f14 = IndicatorHeight;
                } else {
                    f14 = f12;
                }
                if ((i12 & 4) != 0) {
                    j12 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f14 = f12;
            }
            startRestartGroup.endDefaults();
            BoxKt.Box(BackgroundKt.m177backgroundbw27NRU$default(SizeKt.m544height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f14), j12, (Shape) null, 2, (Object) null), startRestartGroup, 0);
            f13 = f14;
            j13 = j12;
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
            f13 = f12;
            j13 = j12;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowDefaults$Indicator$1(this, modifier2, f13, j13, i11, i12));
        }
    }

    /* renamed from: getDividerThickness-D9Ej5fM  reason: not valid java name */
    public final float m1419getDividerThicknessD9Ej5fM() {
        return DividerThickness;
    }

    /* renamed from: getIndicatorHeight-D9Ej5fM  reason: not valid java name */
    public final float m1420getIndicatorHeightD9Ej5fM() {
        return IndicatorHeight;
    }

    /* renamed from: getScrollableTabRowPadding-D9Ej5fM  reason: not valid java name */
    public final float m1421getScrollableTabRowPaddingD9Ej5fM() {
        return ScrollableTabRowPadding;
    }

    @NotNull
    public final Modifier tabIndicatorOffset(@NotNull Modifier modifier, @NotNull TabPosition tabPosition) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(tabPosition, "currentTabPosition");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1(tabPosition);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new TabRowDefaults$tabIndicatorOffset$2(tabPosition));
    }
}
