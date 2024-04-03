package com.designsystem.ds_button_v2;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.designsystem.ds_spinner.DSSpinnerColor;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0010\u0010\bR\u001c\u0010\u0011\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0012\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/designsystem/ds_button_v2/DSButtonDefaults;", "", "()V", "ButtonAnimationDuration", "", "ButtonBorderStroke", "Landroidx/compose/ui/unit/Dp;", "getButtonBorderStroke-D9Ej5fM", "()F", "F", "ButtonDisabledIconAlpha", "", "ButtonIconAlpha", "ButtonMM2DisabledIconAlpha", "ButtonMM2RoundedCornerSize", "ButtonMinHeight", "getButtonMinHeight-D9Ej5fM", "ButtonRoundedCornerSize", "getButtonRoundedCornerSize-D9Ej5fM", "brandedButtonTheme", "Lcom/designsystem/ds_button_v2/DSDefaultButtonTheme;", "isMM2", "", "(ZLandroidx/compose/runtime/Composer;II)Lcom/designsystem/ds_button_v2/DSDefaultButtonTheme;", "destructiveButtonTheme", "primaryButtonTheme", "secondaryButtonTheme", "tertiaryButtonTheme", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSButtonDefaults {
    public static final int ButtonAnimationDuration = 50;
    private static final float ButtonBorderStroke = Dp.m5478constructorimpl((float) 1);
    public static final float ButtonDisabledIconAlpha = 0.3f;
    public static final float ButtonIconAlpha = 1.0f;
    public static final float ButtonMM2DisabledIconAlpha = 0.4f;
    public static final int ButtonMM2RoundedCornerSize = 50;
    private static final float ButtonMinHeight = Dp.m5478constructorimpl((float) 52);
    private static final float ButtonRoundedCornerSize = Dp.m5478constructorimpl((float) 8);
    @NotNull
    public static final DSButtonDefaults INSTANCE = new DSButtonDefaults();

    private DSButtonDefaults() {
    }

    @NotNull
    @Composable
    public final DSDefaultButtonTheme brandedButtonTheme(boolean z11, @Nullable Composer composer, int i11, int i12) {
        boolean z12;
        DSDefaultButtonTheme dSDefaultButtonTheme;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-277172539);
        if ((i12 & 1) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        if (z12) {
            composer2.startReplaceableGroup(-277172479);
            DSTheme dSTheme = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme.getColors(composer2, 0).m8773getDsNeutral800d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8762getDsNeutral200d7_KjU()), dSTheme.getColors(composer2, 0).m8819getDsWhite0d7_KjU(), dSTheme.getColors(composer2, 0).m8761getDsNeutral10V20d7_KjU(), dSTheme.getColors(composer2, 0).m8767getDsNeutral4V20d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8767getDsNeutral4V20d7_KjU()), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8773getDsNeutral800d7_KjU()), (Color) null, DSSpinnerColor.Black, RoundedCornerShapeKt.RoundedCornerShape(50), 128, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-277171881);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme2.getColors(composer2, 0).m8760getDsNeutral1000d7_KjU(), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8764getDsNeutral350d7_KjU()), dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), dSTheme2.getColors(composer2, 0).m8765getDsNeutral40d7_KjU(), dSTheme2.getColors(composer2, 0).m8765getDsNeutral40d7_KjU(), (Color) null, Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8771getDsNeutral700d7_KjU()), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8759getDsNeutral100d7_KjU()), (DSSpinnerColor) null, (Shape) null, 800, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return dSDefaultButtonTheme;
    }

    @NotNull
    @Composable
    public final DSDefaultButtonTheme destructiveButtonTheme(boolean z11, @Nullable Composer composer, int i11, int i12) {
        boolean z12;
        DSDefaultButtonTheme dSDefaultButtonTheme;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1258531967);
        if ((i12 & 1) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        if (z12) {
            composer2.startReplaceableGroup(1258532031);
            DSTheme dSTheme = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme.getColors(composer2, 0).m8819getDsWhite0d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8762getDsNeutral200d7_KjU()), dSTheme.getColors(composer2, 0).m8805getDsRed500d7_KjU(), dSTheme.getColors(composer2, 0).m8761getDsNeutral10V20d7_KjU(), dSTheme.getColors(composer2, 0).m8806getDsRed600d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8806getDsRed600d7_KjU()), (Color) null, (Color) null, (DSSpinnerColor) null, RoundedCornerShapeKt.RoundedCornerShape(50), 448, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(1258532503);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme2.getColors(composer2, 0).m8748getDsDanger1000d7_KjU(), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8749getDsDanger300d7_KjU()), dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), dSTheme2.getColors(composer2, 0).m8747getDsDanger100d7_KjU(), (Color) null, Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8748getDsDanger1000d7_KjU()), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8747getDsDanger100d7_KjU()), (DSSpinnerColor) null, (Shape) null, 800, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return dSDefaultButtonTheme;
    }

    /* renamed from: getButtonBorderStroke-D9Ej5fM  reason: not valid java name */
    public final float m8286getButtonBorderStrokeD9Ej5fM() {
        return ButtonBorderStroke;
    }

    /* renamed from: getButtonMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m8287getButtonMinHeightD9Ej5fM() {
        return ButtonMinHeight;
    }

    /* renamed from: getButtonRoundedCornerSize-D9Ej5fM  reason: not valid java name */
    public final float m8288getButtonRoundedCornerSizeD9Ej5fM() {
        return ButtonRoundedCornerSize;
    }

    @NotNull
    @Composable
    public final DSDefaultButtonTheme primaryButtonTheme(boolean z11, @Nullable Composer composer, int i11, int i12) {
        boolean z12;
        DSDefaultButtonTheme dSDefaultButtonTheme;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-839282819);
        if ((i12 & 1) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        if (z12) {
            composer2.startReplaceableGroup(-839282759);
            DSTheme dSTheme = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme.getColors(composer2, 0).m8819getDsWhite0d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8762getDsNeutral200d7_KjU()), dSTheme.getColors(composer2, 0).m8779getDsOrange500d7_KjU(), dSTheme.getColors(composer2, 0).m8761getDsNeutral10V20d7_KjU(), dSTheme.getColors(composer2, 0).m8780getDsOrange600d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8780getDsOrange600d7_KjU()), (Color) null, (Color) null, (DSSpinnerColor) null, RoundedCornerShapeKt.RoundedCornerShape(50), 448, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-839282278);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), (Color) null, dSTheme2.getColors(composer2, 0).m8793getDsPrimary1000d7_KjU(), dSTheme2.getColors(composer2, 0).m8794getDsPrimary300d7_KjU(), ColorKt.Color(4293284096L), Color.m2909boximpl(ColorKt.Color(4293284096L)), (Color) null, (Color) null, (DSSpinnerColor) null, (Shape) null, 962, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return dSDefaultButtonTheme;
    }

    @NotNull
    @Composable
    public final DSDefaultButtonTheme secondaryButtonTheme(boolean z11, @Nullable Composer composer, int i11, int i12) {
        boolean z12;
        DSDefaultButtonTheme dSDefaultButtonTheme;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(558244340);
        if ((i12 & 1) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        if (z12) {
            composer2.startReplaceableGroup(558244402);
            DSTheme dSTheme = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme.getColors(composer2, 0).m8773getDsNeutral800d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8762getDsNeutral200d7_KjU()), dSTheme.getColors(composer2, 0).m8819getDsWhite0d7_KjU(), dSTheme.getColors(composer2, 0).m8761getDsNeutral10V20d7_KjU(), dSTheme.getColors(composer2, 0).m8767getDsNeutral4V20d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8767getDsNeutral4V20d7_KjU()), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8773getDsNeutral800d7_KjU()), (Color) null, DSSpinnerColor.Black, RoundedCornerShapeKt.RoundedCornerShape(50), 128, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(558245000);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme2.getColors(composer2, 0).m8793getDsPrimary1000d7_KjU(), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8794getDsPrimary300d7_KjU()), dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), dSTheme2.getColors(composer2, 0).m8792getDsPrimary100d7_KjU(), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8792getDsPrimary100d7_KjU()), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8793getDsPrimary1000d7_KjU()), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8794getDsPrimary300d7_KjU()), DSSpinnerColor.Orange, (Shape) null, 512, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return dSDefaultButtonTheme;
    }

    @NotNull
    @Composable
    public final DSDefaultButtonTheme tertiaryButtonTheme(boolean z11, @Nullable Composer composer, int i11, int i12) {
        boolean z12;
        DSDefaultButtonTheme dSDefaultButtonTheme;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-116333437);
        if ((i12 & 1) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        if (z12) {
            composer2.startReplaceableGroup(-116333376);
            DSTheme dSTheme = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme.getColors(composer2, 0).m8773getDsNeutral800d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8762getDsNeutral200d7_KjU()), dSTheme.getColors(composer2, 0).m8817getDsTransparentFill0d7_KjU(), dSTheme.getColors(composer2, 0).m8817getDsTransparentFill0d7_KjU(), dSTheme.getColors(composer2, 0).m8767getDsNeutral4V20d7_KjU(), Color.m2909boximpl(dSTheme.getColors(composer2, 0).m8767getDsNeutral4V20d7_KjU()), (Color) null, (Color) null, DSSpinnerColor.Black, RoundedCornerShapeKt.RoundedCornerShape(50), 192, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-116332818);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            dSDefaultButtonTheme = new DSDefaultButtonTheme(dSTheme2.getColors(composer2, 0).m8793getDsPrimary1000d7_KjU(), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8794getDsPrimary300d7_KjU()), dSTheme2.getColors(composer2, 0).m8817getDsTransparentFill0d7_KjU(), dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), dSTheme2.getColors(composer2, 0).m8792getDsPrimary100d7_KjU(), Color.m2909boximpl(dSTheme2.getColors(composer2, 0).m8792getDsPrimary100d7_KjU()), (Color) null, (Color) null, DSSpinnerColor.Orange, (Shape) null, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return dSDefaultButtonTheme;
    }
}
