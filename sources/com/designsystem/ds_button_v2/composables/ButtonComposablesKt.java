package com.designsystem.ds_button_v2.composables;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import com.designsystem.ds_counter.CounterComposablesKt;
import com.designsystem.ds_theme.DSTheme;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0012\u001a\u00020\u00012\b\b\u0001\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0005H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0012\u001a\u00020\u00012\b\b\u0001\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001aO\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001fH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\u0010(\u001a!\u0010)\u001a\b\u0012\u0004\u0012\u0002H+0*\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001a\u00020%H\u0001¢\u0006\u0002\u0010-\u001a\u0014\u0010.\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010/\u001a\u00020'H\u0001\u001a<\u00100\u001a\u00020\u001d*\u00020\u001d2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0001022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020'2\b\b\u0002\u00108\u001a\u00020'H\u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"ButtonCaptionText", "", "caption", "", "color", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ButtonCaptionText-3IgeMak", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "ButtonCounter", "quantity", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "labelColor", "ButtonCounter-Bx497Mc", "(ILandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/runtime/Composer;I)V", "ButtonLeadingIcon", "leadingIcon", "tint", "ButtonLeadingIcon-RPmYEkk", "(IJLandroidx/compose/runtime/Composer;I)V", "alpha", "", "(IFLandroidx/compose/runtime/Composer;I)V", "ButtonTitleText", "title", "modifier", "Landroidx/compose/ui/Modifier;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "ButtonTitleText-8V94_ZQ", "(Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "buttonAnimationEasing", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/core/Easing;", "isPressed", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "buttonAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "T", "animationEasing", "(Landroidx/compose/animation/core/Easing;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/TweenSpec;", "isVisible", "value", "tappable", "onTap", "Lkotlin/Function0;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "view", "Landroid/view/View;", "isEnabled", "hasHapticFeedback", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ButtonComposablesKt {
    @Composable
    /* renamed from: ButtonCaptionText-3IgeMak  reason: not valid java name */
    public static final void m8294ButtonCaptionText3IgeMak(@NotNull String str, long j11, @Nullable TextStyle textStyle, @Nullable Composer composer, int i11, int i12) {
        int i13;
        TextStyle textStyle2;
        Composer composer2;
        int i14;
        int i15;
        int i16;
        String str2 = str;
        int i17 = i11;
        Intrinsics.checkNotNullParameter(str2, ShareConstants.FEED_CAPTION_PARAM);
        Composer startRestartGroup = composer.startRestartGroup(-67741930);
        if ((i12 & 1) != 0) {
            i13 = i17 | 6;
        } else if ((i17 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i17;
        } else {
            i13 = i17;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
            long j12 = j11;
        } else {
            long j13 = j11;
            if ((i17 & 112) == 0) {
                if (startRestartGroup.changed(j13)) {
                    i15 = 32;
                } else {
                    i15 = 16;
                }
                i13 |= i15;
            }
        }
        if ((i17 & 896) == 0) {
            if ((i12 & 4) == 0) {
                textStyle2 = textStyle;
                if (startRestartGroup.changed((Object) textStyle2)) {
                    i14 = 256;
                    i13 |= i14;
                }
            } else {
                textStyle2 = textStyle;
            }
            i14 = 128;
            i13 |= i14;
        } else {
            textStyle2 = textStyle;
        }
        if (((i13 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            if ((i17 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.startDefaults();
                if ((i12 & 4) != 0) {
                    textStyle2 = DSTheme.INSTANCE.getTypography(startRestartGroup, 0).getDsCaption();
                    i13 &= -897;
                }
                startRestartGroup.endDefaults();
            } else {
                startRestartGroup.skipCurrentGroup();
                if ((i12 & 4) != 0) {
                    i13 &= -897;
                }
            }
            int i18 = i13;
            TextStyle textStyle3 = textStyle2;
            composer2 = startRestartGroup;
            TextKt.m1461TextfLXpl1I(str, (Modifier) null, j11, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, textStyle3, composer2, (i18 & 14) | ((i18 << 3) & 896), ((i18 << 9) & Opcodes.ASM7) | 3136, 22522);
            textStyle2 = textStyle3;
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ButtonComposablesKt$ButtonCaptionText$1(str, j11, textStyle2, i11, i12));
        }
    }

    @Composable
    /* renamed from: ButtonCounter-Bx497Mc  reason: not valid java name */
    public static final void m8295ButtonCounterBx497Mc(int i11, @NotNull Shape shape, @NotNull TextStyle textStyle, long j11, @Nullable Composer composer, int i12) {
        int i13;
        Composer composer2;
        int i14;
        int i15;
        int i16;
        int i17;
        Shape shape2 = shape;
        TextStyle textStyle2 = textStyle;
        int i18 = i12;
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(textStyle2, "textStyle");
        Composer startRestartGroup = composer.startRestartGroup(-2136260328);
        int i19 = i11;
        if ((i18 & 14) == 0) {
            if (startRestartGroup.changed(i19)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i13 = i17 | i18;
        } else {
            i13 = i18;
        }
        if ((i18 & 112) == 0) {
            if (startRestartGroup.changed((Object) shape2)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i13 |= i16;
        }
        if ((i18 & 896) == 0) {
            if (startRestartGroup.changed((Object) textStyle2)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i13 |= i15;
        }
        long j12 = j11;
        if ((i18 & 7168) == 0) {
            if (startRestartGroup.changed(j12)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i13 |= i14;
        }
        if (((i13 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            long r42 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8818getDsTransparentWhite200d7_KjU();
            Button button = Button.INSTANCE;
            int i21 = ((i13 << 3) & 112) | 6 | ((i13 >> 3) & 896) | ((i13 << 12) & 3670016) | ((i13 << 18) & 29360128);
            composer2 = startRestartGroup;
            CounterComposablesKt.m8319CounterComposablesT9BRK9s(TestTagKt.testTag(Modifier.Companion, Button.ButtonCounterTestTag), i11, j11, r42, button.m8293getButtonCounterSizeD9Ej5fM(), button.m8293getButtonCounterSizeD9Ej5fM(), textStyle, shape, startRestartGroup, i21, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ButtonComposablesKt$ButtonCounter$1(i11, shape, textStyle, j11, i12));
        }
    }

    @Composable
    public static final void ButtonLeadingIcon(@DrawableRes int i11, float f11, @Nullable Composer composer, int i12) {
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1094768478);
        if ((i12 & 14) == 0) {
            if (startRestartGroup.changed(i11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            if (startRestartGroup.changed(f11)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            IconKt.m1278Iconww6aTOc(PainterResources_androidKt.painterResource(i11, startRestartGroup, i13 & 14), "", AlphaKt.alpha(SemanticsModifierKt.semantics$default(SizeKt.m558size3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM()), false, ButtonComposablesKt$ButtonLeadingIcon$3.INSTANCE, 1, (Object) null), f11), Color.Companion.m2955getUnspecified0d7_KjU(), startRestartGroup, 56, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ButtonComposablesKt$ButtonLeadingIcon$4(i11, f11, i12));
        }
    }

    @Composable
    /* renamed from: ButtonLeadingIcon-RPmYEkk  reason: not valid java name */
    public static final void m8296ButtonLeadingIconRPmYEkk(@DrawableRes int i11, long j11, @Nullable Composer composer, int i12) {
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1094768900);
        if ((i12 & 14) == 0) {
            if (startRestartGroup.changed(i11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            if (startRestartGroup.changed(j11)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            IconKt.m1278Iconww6aTOc(PainterResources_androidKt.painterResource(i11, startRestartGroup, i13 & 14), (String) null, SemanticsModifierKt.semantics$default(SizeKt.m558size3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM()), false, ButtonComposablesKt$ButtonLeadingIcon$1.INSTANCE, 1, (Object) null), j11, startRestartGroup, ((i13 << 6) & 7168) | 56, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ButtonComposablesKt$ButtonLeadingIcon$2(i11, j11, i12));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: ButtonTitleText-8V94_ZQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8297ButtonTitleText8V94_ZQ(@org.jetbrains.annotations.NotNull java.lang.String r28, long r29, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r2 = r28
            r3 = r35
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -710265112(0xffffffffd5aa36e8, float:-2.33940997E13)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r0 = r36 & 1
            if (r0 == 0) goto L_0x0019
            r0 = r3 | 6
            goto L_0x0029
        L_0x0019:
            r0 = r3 & 14
            if (r0 != 0) goto L_0x0028
            boolean r0 = r1.changed((java.lang.Object) r2)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r3
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            r4 = r36 & 2
            if (r4 == 0) goto L_0x0032
            r0 = r0 | 48
            r13 = r29
            goto L_0x0044
        L_0x0032:
            r4 = r3 & 112(0x70, float:1.57E-43)
            r13 = r29
            if (r4 != 0) goto L_0x0044
            boolean r4 = r1.changed((long) r13)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r0 = r0 | r4
        L_0x0044:
            r4 = r36 & 4
            if (r4 == 0) goto L_0x004b
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r5 = r3 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005e
            r5 = r31
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005a
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r0 = r0 | r6
            goto L_0x0060
        L_0x005e:
            r5 = r31
        L_0x0060:
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0079
            r6 = r36 & 8
            if (r6 != 0) goto L_0x0073
            r6 = r32
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0075
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r6 = r32
        L_0x0075:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r0 = r0 | r7
            goto L_0x007b
        L_0x0079:
            r6 = r32
        L_0x007b:
            r18 = 57344(0xe000, float:8.0356E-41)
            r7 = r3 & r18
            if (r7 != 0) goto L_0x0097
            r7 = r36 & 16
            if (r7 != 0) goto L_0x0091
            r7 = r33
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0093
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r7 = r33
        L_0x0093:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r0 = r0 | r8
            goto L_0x0099
        L_0x0097:
            r7 = r33
        L_0x0099:
            r8 = 46811(0xb6db, float:6.5596E-41)
            r8 = r8 & r0
            r8 = r8 ^ 9362(0x2492, float:1.3119E-41)
            if (r8 != 0) goto L_0x00b2
            boolean r8 = r1.getSkipping()
            if (r8 != 0) goto L_0x00a8
            goto L_0x00b2
        L_0x00a8:
            r1.skipToGroupEnd()
            r27 = r1
            r4 = r5
            r5 = r6
            r6 = r7
            goto L_0x014c
        L_0x00b2:
            r8 = r3 & 1
            r9 = -57345(0xffffffffffff1fff, float:NaN)
            if (r8 == 0) goto L_0x00d5
            boolean r8 = r1.getDefaultsInvalid()
            if (r8 == 0) goto L_0x00c0
            goto L_0x00d5
        L_0x00c0:
            r1.skipCurrentGroup()
            r4 = r36 & 8
            if (r4 == 0) goto L_0x00c9
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00c9:
            r4 = r36 & 16
            if (r4 == 0) goto L_0x00ce
            r0 = r0 & r9
        L_0x00ce:
            r24 = r5
            r25 = r6
        L_0x00d2:
            r26 = r7
            goto L_0x0101
        L_0x00d5:
            r1.startDefaults()
            if (r4 == 0) goto L_0x00dd
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            goto L_0x00de
        L_0x00dd:
            r4 = r5
        L_0x00de:
            r5 = r36 & 8
            if (r5 == 0) goto L_0x00f0
            com.designsystem.ds_theme.DSTheme r5 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r6 = 0
            com.designsystem.ds_theme.DSTypography r5 = r5.getTypography(r1, r6)
            androidx.compose.ui.text.TextStyle r5 = r5.getDsButton()
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x00f1
        L_0x00f0:
            r5 = r6
        L_0x00f1:
            r6 = r36 & 16
            if (r6 == 0) goto L_0x00f9
            com.designsystem.ds_button_v2.composables.ButtonComposablesKt$ButtonTitleText$1 r6 = com.designsystem.ds_button_v2.composables.ButtonComposablesKt$ButtonTitleText$1.INSTANCE
            r0 = r0 & r9
            r7 = r6
        L_0x00f9:
            r1.endDefaults()
            r24 = r4
            r25 = r5
            goto L_0x00d2
        L_0x0101:
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r15 = r4.m5403getEllipsisgIe3tQ8()
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r13 = r16
            r16 = 0
            r17 = 1
            r19 = r0 & 14
            int r20 = r0 >> 3
            r20 = r20 & 112(0x70, float:1.57E-43)
            r19 = r19 | r20
            int r4 = r0 << 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r21 = r19 | r4
            r4 = r0 & r18
            r4 = r4 | 3136(0xc40, float:4.394E-42)
            r5 = 458752(0x70000, float:6.42848E-40)
            int r0 = r0 << 6
            r0 = r0 & r5
            r22 = r4 | r0
            r23 = 6136(0x17f8, float:8.598E-42)
            r0 = r28
            r27 = r1
            r1 = r24
            r2 = r29
            r18 = r26
            r19 = r25
            r20 = r27
            r4 = 0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r4 = r24
            r5 = r25
            r6 = r26
        L_0x014c:
            androidx.compose.runtime.ScopeUpdateScope r9 = r27.endRestartGroup()
            if (r9 != 0) goto L_0x0153
            goto L_0x0164
        L_0x0153:
            com.designsystem.ds_button_v2.composables.ButtonComposablesKt$ButtonTitleText$2 r10 = new com.designsystem.ds_button_v2.composables.ButtonComposablesKt$ButtonTitleText$2
            r0 = r10
            r1 = r28
            r2 = r29
            r7 = r35
            r8 = r36
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            r9.updateScope(r10)
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_button_v2.composables.ButtonComposablesKt.m8297ButtonTitleText8V94_ZQ(java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    @NotNull
    @Composable
    public static final State<Easing> buttonAnimationEasing(boolean z11, @Nullable Composer composer, int i11) {
        Easing easing;
        composer.startReplaceableGroup(1863608925);
        if (z11) {
            easing = EasingKt.getLinearOutSlowInEasing();
        } else {
            easing = EasingKt.getFastOutLinearInEasing();
        }
        State<Easing> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(easing, composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public static final <T> TweenSpec<T> buttonAnimationSpec(@NotNull Easing easing, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(easing, "animationEasing");
        composer.startReplaceableGroup(-1177990483);
        TweenSpec<T> tween$default = AnimationSpecKt.tween$default(50, 0, easing, 2, (Object) null);
        composer.endReplaceableGroup();
        return tween$default;
    }

    @NotNull
    @Stable
    public static final Modifier isVisible(@NotNull Modifier modifier, boolean z11) {
        float f11;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (z11) {
            f11 = 1.0f;
        } else {
            f11 = 0.0f;
        }
        return modifier.then(SemanticsModifierKt.semantics$default(AlphaKt.alpha(modifier, f11), false, new ButtonComposablesKt$isVisible$1(z11), 1, (Object) null));
    }

    @SuppressLint({"MissingPermission"})
    @Stable
    @NotNull
    public static final Modifier tappable(@NotNull Modifier modifier, @NotNull Function0<Unit> function0, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull View view, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(view, "view");
        return modifier.then(ClickableKt.m194clickableO2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, z11, (String) null, Role.m4904boximpl(Role.Companion.m4911getButtono7Vup1c()), new ButtonComposablesKt$tappable$1(z12, view, function0), 8, (Object) null));
    }

    public static /* synthetic */ Modifier tappable$default(Modifier modifier, Function0 function0, MutableInteractionSource mutableInteractionSource, View view, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            z12 = true;
        }
        return tappable(modifier, function0, mutableInteractionSource, view, z11, z12);
    }
}
