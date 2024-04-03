package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.JG\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J3\u00103\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J3\u00106\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00105R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u001a\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/material/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedBorderOpacity", "", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "buttonColors", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "elevation", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "pressedElevation", "disabledElevation", "elevation-yajeYGU", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "outlinedButtonColors", "outlinedButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "textButtonColors-RGew2ao", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    @NotNull
    private static final PaddingValues ContentPadding;
    @NotNull
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize = Dp.m5478constructorimpl((float) 18);
    private static final float IconSpacing;
    private static final float MinHeight = Dp.m5478constructorimpl((float) 36);
    private static final float MinWidth = Dp.m5478constructorimpl((float) 64);
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize = Dp.m5478constructorimpl((float) 1);
    @NotNull
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    static {
        float r02 = Dp.m5478constructorimpl((float) 16);
        ButtonHorizontalPadding = r02;
        float f11 = (float) 8;
        float r22 = Dp.m5478constructorimpl(f11);
        ButtonVerticalPadding = r22;
        PaddingValues r03 = PaddingKt.m482PaddingValuesa9UjIt4(r02, r22, r02, r22);
        ContentPadding = r03;
        IconSpacing = Dp.m5478constructorimpl(f11);
        float r12 = Dp.m5478constructorimpl(f11);
        TextButtonHorizontalPadding = r12;
        TextButtonContentPadding = PaddingKt.m482PaddingValuesa9UjIt4(r12, r03.m499calculateTopPaddingD9Ej5fM(), r12, r03.m496calculateBottomPaddingD9Ej5fM());
    }

    private ButtonDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: buttonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1129buttonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1870371134);
        if ((i12 & 1) != 0) {
            j15 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU();
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorsKt.m1197contentColorForek8zF_U(j15, composer2, i11 & 14);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j17 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(materialTheme.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), materialTheme.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x008e;
     */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* renamed from: elevation-R_JCAzs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material.ButtonElevation m1130elevationR_JCAzs(float r14, float r15, float r16, float r17, float r18, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r13 = this;
            r0 = r19
            r1 = -737170518(0xffffffffd40fabaa, float:-2.46824147E12)
            r0.startReplaceableGroup(r1)
            r1 = r21 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0014
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r4 = r1
            goto L_0x0015
        L_0x0014:
            r4 = r14
        L_0x0015:
            r1 = r21 & 2
            if (r1 == 0) goto L_0x0022
            r1 = 8
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r5 = r1
            goto L_0x0023
        L_0x0022:
            r5 = r15
        L_0x0023:
            r1 = r21 & 4
            r3 = 0
            if (r1 == 0) goto L_0x002f
            float r1 = (float) r3
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r6 = r1
            goto L_0x0031
        L_0x002f:
            r6 = r16
        L_0x0031:
            r1 = r21 & 8
            r7 = 4
            if (r1 == 0) goto L_0x003c
            float r1 = (float) r7
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            goto L_0x003e
        L_0x003c:
            r1 = r17
        L_0x003e:
            r8 = r21 & 16
            if (r8 == 0) goto L_0x0048
            float r8 = (float) r7
            float r8 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r8)
            goto L_0x004a
        L_0x0048:
            r8 = r18
        L_0x004a:
            r9 = 5
            java.lang.Object[] r10 = new java.lang.Object[r9]
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r4)
            r10[r3] = r11
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r5)
            r12 = 1
            r10[r12] = r11
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r6)
            r10[r2] = r11
            r2 = 3
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m5476boximpl(r1)
            r10[r2] = r11
            androidx.compose.ui.unit.Dp r2 = androidx.compose.ui.unit.Dp.m5476boximpl(r8)
            r10[r7] = r2
            r2 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r2)
            r2 = r3
        L_0x0074:
            if (r3 >= r9) goto L_0x0080
            r7 = r10[r3]
            boolean r7 = r0.changed((java.lang.Object) r7)
            r2 = r2 | r7
            int r3 = r3 + 1
            goto L_0x0074
        L_0x0080:
            java.lang.Object r3 = r19.rememberedValue()
            if (r2 != 0) goto L_0x008e
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0099
        L_0x008e:
            androidx.compose.material.DefaultButtonElevation r2 = new androidx.compose.material.DefaultButtonElevation
            r9 = 0
            r3 = r2
            r7 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.updateRememberedValue(r2)
        L_0x0099:
            r19.endReplaceableGroup()
            androidx.compose.material.DefaultButtonElevation r3 = (androidx.compose.material.DefaultButtonElevation) r3
            r19.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ButtonDefaults.m1130elevationR_JCAzs(float, float, float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material.ButtonElevation");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    @Composable
    /* renamed from: elevation-yajeYGU  reason: not valid java name */
    public final /* synthetic */ ButtonElevation m1131elevationyajeYGU(float f11, float f12, float f13, Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(1428576874);
        if ((i12 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 2);
        }
        float f14 = f11;
        if ((i12 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 8);
        }
        float f15 = f12;
        if ((i12 & 4) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        }
        float f16 = (float) 4;
        ButtonElevation r102 = m1130elevationR_JCAzs(f14, f15, f13, Dp.m5478constructorimpl(f16), Dp.m5478constructorimpl(f16), composer, (i11 & 14) | 27648 | (i11 & 112) | (i11 & 896) | ((i11 << 6) & Opcodes.ASM7), 0);
        composer.endReplaceableGroup();
        return r102;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1132getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM  reason: not valid java name */
    public final float m1133getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1134getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m1135getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @NotNull
    @Composable
    @JvmName(name = "getOutlinedBorder")
    public final BorderStroke getOutlinedBorder(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-2091313033);
        BorderStroke r11 = BorderStrokeKt.m191BorderStrokecXLIe8U(OutlinedBorderSize, Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1178getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
        composer.endReplaceableGroup();
        return r11;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM  reason: not valid java name */
    public final float m1136getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    @NotNull
    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedButtonColors-RGew2ao  reason: not valid java name */
    public final ButtonColors m1137outlinedButtonColorsRGew2ao(long j11, long j12, long j13, @Nullable Composer composer, int i11, int i12) {
        long j14;
        long j15;
        long j16;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-2124406093);
        if ((i12 & 1) != 0) {
            j14 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU();
        } else {
            j14 = j11;
        }
        if ((i12 & 2) != 0) {
            j15 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU();
        } else {
            j15 = j12;
        }
        if ((i12 & 4) != 0) {
            j16 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j16 = j13;
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j14, j15, j14, j16, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @NotNull
    @Composable
    /* renamed from: textButtonColors-RGew2ao  reason: not valid java name */
    public final ButtonColors m1138textButtonColorsRGew2ao(long j11, long j12, long j13, @Nullable Composer composer, int i11, int i12) {
        long j14;
        long j15;
        long j16;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(182742216);
        if ((i12 & 1) != 0) {
            j14 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j14 = j11;
        }
        if ((i12 & 2) != 0) {
            j15 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU();
        } else {
            j15 = j12;
        }
        if ((i12 & 4) != 0) {
            j16 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j16 = j13;
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j14, j15, j14, j16, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }
}
