package com.designsystem.ds_chip;

import androidx.annotation.DrawableRes;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.designsystem.ds_counter.DSCounterKt;
import com.designsystem.ds_theme.DSTheme;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a'\u0010\u0005\u001a\u00020\u00012\b\b\u0001\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000b\u001a!\u0010\f\u001a\u00020\u00012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\u000e\u001aK\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a\u001d\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\u001c\u001a!\u0010\u001d\u001a\u00020\u00012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\u000e\u001a#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020!H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a\u0018\u0010%\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\bH\u0003ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\bH\u0003ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010(\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\bH\u0003ø\u0001\u0000¢\u0006\u0002\u0010&\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"ChipCounter", "", "count", "", "(ILandroidx/compose/runtime/Composer;I)V", "ChipIcon", "icon", "isSelected", "", "testTag", "", "(IZLjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ChipLeadingIcon", "leadingIcon", "(Ljava/lang/Integer;ZLandroidx/compose/runtime/Composer;I)V", "ChipSurface", "modifier", "Landroidx/compose/ui/Modifier;", "onTap", "Lkotlin/Function0;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ChipText", "text", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "ChipTrailingIcon", "trailingIcon", "animateChipColorAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "targetValue", "animateChipColorAsState-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "borderColor", "(ZLandroidx/compose/runtime/Composer;I)J", "contentColor", "surfaceColor", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ChipComposablesKt {
    @Composable
    public static final void ChipCounter(int i11, @Nullable Composer composer, int i12) {
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(470720908);
        if ((i12 & 14) == 0) {
            if (startRestartGroup.changed(i11)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i13 = i14 | i12;
        } else {
            i13 = i12;
        }
        if ((2 ^ (i13 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM()), startRestartGroup, 0);
            DSCounterKt.m8333DSCountereaDK9VM(i11, TestTagKt.testTag(companion, Chip.ChipCounterTestTag), dSTheme.getColors(startRestartGroup, 0).m8793getDsPrimary1000d7_KjU(), dSTheme.getColors(startRestartGroup, 0).m8774getDsNeutralWhite0d7_KjU(), startRestartGroup, (i13 & 14) | 48, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipComposablesKt$ChipCounter$1(i11, i12));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void ChipIcon(@DrawableRes int i11, boolean z11, String str, Composer composer, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i11;
        boolean z12 = z11;
        String str2 = str;
        int i18 = i12;
        Composer startRestartGroup = composer.startRestartGroup(-2093772475);
        if ((i18 & 14) == 0) {
            if (startRestartGroup.changed(i17)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i18;
        } else {
            i13 = i18;
        }
        if ((i18 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        if ((i18 & 896) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i13 |= i14;
        }
        if (((i13 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            State<Color> r62 = m8317animateChipColorAsStateek8zF_U(contentColor(z12, startRestartGroup, (i13 >> 3) & 14), startRestartGroup, 0);
            Painter painterResource = PainterResources_androidKt.painterResource(i17, startRestartGroup, i13 & 14);
            Modifier r92 = SizeKt.m558size3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM());
            startRestartGroup.startReplaceableGroup(-3686930);
            boolean changed = startRestartGroup.changed((Object) str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ChipComposablesKt$ChipIcon$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ImageKt.Image(painterResource, (String) null, SemanticsModifierKt.semantics$default(r92, false, (Function1) rememberedValue, 1, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m2960tintxETnrds$default(ColorFilter.Companion, m8313ChipIcon$lambda5(r62), 0, 2, (Object) null), startRestartGroup, 56, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipComposablesKt$ChipIcon$2(i17, z12, str2, i18));
        }
    }

    /* renamed from: ChipIcon$lambda-5  reason: not valid java name */
    private static final long m8313ChipIcon$lambda5(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    @Composable
    public static final void ChipLeadingIcon(@Nullable @DrawableRes Integer num, boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(1369233015);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) num)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (num == null) {
                startRestartGroup.startReplaceableGroup(-503446332);
            } else {
                startRestartGroup.startReplaceableGroup(1369233117);
                ChipIcon(num.intValue(), z11, Chip.ChipLeadingIconTestTag, startRestartGroup, (i12 & 112) | RendererCapabilities.MODE_SUPPORT_MASK);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8848getDsXxxsD9Ej5fM()), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipComposablesKt$ChipLeadingIcon$2(num, z11, i11));
        }
    }

    @Composable
    public static final void ChipSurface(@NotNull Modifier modifier, boolean z11, @Nullable Function0<Unit> function0, @NotNull Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Function0<Unit> function02;
        Function0<Unit> function03;
        int i14;
        int i15;
        int i16;
        int i17;
        Modifier modifier2 = modifier;
        boolean z12 = z11;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i18 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function32, "content");
        Composer startRestartGroup = composer.startRestartGroup(-772876063);
        if ((i12 & 1) != 0) {
            i13 = i18 | 6;
        } else if ((i18 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i13 = i17 | i18;
        } else {
            i13 = i18;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i18 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i13 |= i16;
        }
        if ((i18 & 896) == 0) {
            if ((i12 & 4) == 0) {
                function02 = function0;
                if (startRestartGroup.changed((Object) function02)) {
                    i15 = 256;
                    i13 |= i15;
                }
            } else {
                function02 = function0;
            }
            i15 = 128;
            i13 |= i15;
        } else {
            function02 = function0;
        }
        if ((i12 & 8) != 0) {
            i13 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else if ((i18 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i13 |= i14;
        }
        if (((i13 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            if ((i18 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.startDefaults();
                if ((i12 & 4) != 0) {
                    function02 = ChipComposablesKt$ChipSurface$1.INSTANCE;
                    i13 &= -897;
                }
                startRestartGroup.endDefaults();
            } else {
                startRestartGroup.skipCurrentGroup();
                if ((i12 & 4) != 0) {
                    i13 &= -897;
                }
            }
            Function0<Unit> function04 = function02;
            int i19 = i13;
            function03 = function04;
            int i21 = (i19 >> 3) & 14;
            State<Color> r82 = m8317animateChipColorAsStateek8zF_U(surfaceColor(z12, startRestartGroup, i21), startRestartGroup, 0);
            State<Color> r72 = m8317animateChipColorAsStateek8zF_U(borderColor(z12, startRestartGroup, i21), startRestartGroup, 0);
            Chip chip = Chip.INSTANCE;
            RoundedCornerShape r16 = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(chip.m8311getChipCornerShapeD9Ej5fM());
            long r17 = m8314ChipSurface$lambda0(r82);
            BorderStroke r19 = BorderStrokeKt.m191BorderStrokecXLIe8U(chip.m8310getChipBorderStrokeD9Ej5fM(), m8315ChipSurface$lambda1(r72));
            SurfaceKt.m1384SurfaceFjzlyU(AnimationModifierKt.animateContentSize$default(ClickableKt.m194clickableO2vRcR0$default(ClipKt.clip(modifier2, RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(chip.m8311getChipCornerShapeD9Ej5fM())), InteractionSourceKt.MutableInteractionSource(), (Indication) null, false, (String) null, (Role) null, function03, 28, (Object) null), (FiniteAnimationSpec) null, (Function2) null, 3, (Object) null), r16, r17, 0, r19, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -819893131, true, new ChipComposablesKt$ChipSurface$2(function32, i19)), startRestartGroup, 1572864, 40);
        } else {
            startRestartGroup.skipToGroupEnd();
            function03 = function02;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipComposablesKt$ChipSurface$3(modifier, z11, function03, function3, i11, i12));
        }
    }

    /* renamed from: ChipSurface$lambda-0  reason: not valid java name */
    private static final long m8314ChipSurface$lambda0(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* renamed from: ChipSurface$lambda-1  reason: not valid java name */
    private static final long m8315ChipSurface$lambda1(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    @Composable
    public static final void ChipText(@NotNull String str, boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        int i14;
        String str2 = str;
        boolean z12 = z11;
        int i15 = i11;
        Intrinsics.checkNotNullParameter(str2, "text");
        Composer startRestartGroup = composer.startRestartGroup(-2083545966);
        if ((i15 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i15;
        } else {
            i12 = i15;
        }
        if ((i15 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        int i16 = i12;
        if (((i16 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            composer2 = startRestartGroup;
            String str3 = str;
            TextKt.m1461TextfLXpl1I(str3, (Modifier) null, m8316ChipText$lambda4(m8317animateChipColorAsStateek8zF_U(contentColor(z12, startRestartGroup, (i16 >> 3) & 14), startRestartGroup, 0)), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 1, (Function1<? super TextLayoutResult, Unit>) null, DSTheme.INSTANCE.getTypography(startRestartGroup, 0).getDsSubheading2(), composer2, i16 & 14, 3136, 24570);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipComposablesKt$ChipText$1(str, z11, i11));
        }
    }

    /* renamed from: ChipText$lambda-4  reason: not valid java name */
    private static final long m8316ChipText$lambda4(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    @Composable
    public static final void ChipTrailingIcon(@Nullable @DrawableRes Integer num, boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-654704446);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) num)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (num == null) {
                startRestartGroup.startReplaceableGroup(1179001910);
            } else {
                startRestartGroup.startReplaceableGroup(-654704341);
                int intValue = num.intValue();
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM()), startRestartGroup, 0);
                ChipIcon(intValue, z11, Chip.ChipTrailingIconTestTag, startRestartGroup, (i12 & 112) | RendererCapabilities.MODE_SUPPORT_MASK);
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipComposablesKt$ChipTrailingIcon$2(num, z11, i11));
        }
    }

    @Composable
    /* renamed from: animateChipColorAsState-ek8zF_U  reason: not valid java name */
    private static final State<Color> m8317animateChipColorAsStateek8zF_U(long j11, Composer composer, int i11) {
        composer.startReplaceableGroup(1595534989);
        State<Color> r11 = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j11, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, (i11 & 14) | 48, 4);
        composer.endReplaceableGroup();
        return r11;
    }

    @Composable
    private static final long borderColor(boolean z11, Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-712685517);
        if (z11) {
            composer.startReplaceableGroup(-712685443);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8793getDsPrimary1000d7_KjU();
        } else {
            composer.startReplaceableGroup(-712685410);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8759getDsNeutral100d7_KjU();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return j11;
    }

    @Composable
    private static final long contentColor(boolean z11, Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-263653483);
        if (z11) {
            composer.startReplaceableGroup(-263653408);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8774getDsNeutralWhite0d7_KjU();
        } else {
            composer.startReplaceableGroup(-263653373);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8771getDsNeutral700d7_KjU();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return j11;
    }

    @Composable
    private static final long surfaceColor(boolean z11, Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(485865816);
        if (z11) {
            composer.startReplaceableGroup(485865891);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8793getDsPrimary1000d7_KjU();
        } else {
            composer.startReplaceableGroup(485865924);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8774getDsNeutralWhite0d7_KjU();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return j11;
    }
}
