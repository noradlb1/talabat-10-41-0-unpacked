package com.designsystem.ds_button_v2;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.designsystem.ds_spinner.DSSpinnerColor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001Bl\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017¢\u0006\u0002\u0010\u0019J\r\u0010\u000b\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\u001aJ\r\u0010\r\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/designsystem/ds_button_v2/DSDefaultButtonTheme;", "Lcom/designsystem/ds_button_v2/DSButtonTheme;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "disabledBackgroundColor", "pressedBackgroundColor", "loadingBackgroundColor", "borderColor", "disabledBorderColor", "loadingAnimationColor", "Lcom/designsystem/ds_spinner/DSSpinnerColor;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(JLandroidx/compose/ui/graphics/Color;JJJLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/designsystem/ds_spinner/DSSpinnerColor;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "isEnabled", "", "isLoading", "isPressed", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_spinner/DSSpinnerColor;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSDefaultButtonTheme implements DSButtonTheme {
    private final long backgroundColor;
    @Nullable
    private final Color borderColor;
    private final long disabledBackgroundColor;
    @Nullable
    private final Color disabledBorderColor;
    @Nullable
    private final Color disabledTextColor;
    @NotNull
    private final DSSpinnerColor loadingAnimationColor;
    @Nullable
    private final Color loadingBackgroundColor;
    private final long pressedBackgroundColor;
    @NotNull
    private final Shape shape;
    private final long textColor;

    private DSDefaultButtonTheme(long j11, Color color, long j12, long j13, long j14, Color color2, Color color3, Color color4, DSSpinnerColor dSSpinnerColor, Shape shape2) {
        this.textColor = j11;
        this.disabledTextColor = color;
        this.backgroundColor = j12;
        this.disabledBackgroundColor = j13;
        this.pressedBackgroundColor = j14;
        this.loadingBackgroundColor = color2;
        this.borderColor = color3;
        this.disabledBorderColor = color4;
        this.loadingAnimationColor = dSSpinnerColor;
        this.shape = shape2;
    }

    public /* synthetic */ DSDefaultButtonTheme(long j11, Color color, long j12, long j13, long j14, Color color2, Color color3, Color color4, DSSpinnerColor dSSpinnerColor, Shape shape2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, color, j12, j13, j14, color2, color3, color4, dSSpinnerColor, shape2);
    }

    @NotNull
    @Composable
    public State<Color> backgroundColor(boolean z11, boolean z12, boolean z13, @Nullable Composer composer, int i11) {
        long j11;
        Color color;
        composer.startReplaceableGroup(-32021737);
        if (!z11) {
            j11 = this.disabledBackgroundColor;
        } else if (z12 && (color = this.loadingBackgroundColor) != null) {
            j11 = color.m2929unboximpl();
        } else if (z13) {
            j11 = this.pressedBackgroundColor;
        } else {
            j11 = this.backgroundColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<BorderStroke> borderStroke(boolean z11, @Nullable Composer composer, int i11) {
        BorderStroke borderStroke;
        composer.startReplaceableGroup(1646922445);
        if (!z11 && this.disabledBorderColor != null) {
            borderStroke = BorderStrokeKt.m191BorderStrokecXLIe8U(DSButtonDefaults.INSTANCE.m8286getButtonBorderStrokeD9Ej5fM(), this.disabledBorderColor.m2929unboximpl());
        } else if (!z11 || this.borderColor == null) {
            borderStroke = null;
        } else {
            borderStroke = BorderStrokeKt.m191BorderStrokecXLIe8U(DSButtonDefaults.INSTANCE.m8286getButtonBorderStrokeD9Ej5fM(), this.borderColor.m2929unboximpl());
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(borderStroke, composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public DSSpinnerColor loadingAnimationColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(169045648);
        DSSpinnerColor dSSpinnerColor = this.loadingAnimationColor;
        composer.endReplaceableGroup();
        return dSSpinnerColor;
    }

    @NotNull
    @Composable
    public Shape shape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-267674964);
        Shape shape2 = this.shape;
        composer.endReplaceableGroup();
        return shape2;
    }

    @NotNull
    @Composable
    public State<Color> textColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        Color color;
        composer.startReplaceableGroup(-1135642717);
        if (z11 || (color = this.disabledTextColor) == null) {
            j11 = this.textColor;
        } else {
            j11 = color.m2929unboximpl();
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DSDefaultButtonTheme(long r20, androidx.compose.ui.graphics.Color r22, long r23, long r25, long r27, androidx.compose.ui.graphics.Color r29, androidx.compose.ui.graphics.Color r30, androidx.compose.ui.graphics.Color r31, com.designsystem.ds_spinner.DSSpinnerColor r32, androidx.compose.ui.graphics.Shape r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r19 = this;
            r0 = r34
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r22
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r13 = r2
            goto L_0x0013
        L_0x0011:
            r13 = r29
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r14 = r2
            goto L_0x001b
        L_0x0019:
            r14 = r30
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0021
            r15 = r2
            goto L_0x0023
        L_0x0021:
            r15 = r31
        L_0x0023:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002c
            com.designsystem.ds_spinner.DSSpinnerColor r1 = com.designsystem.ds_spinner.DSSpinnerColor.White
            r16 = r1
            goto L_0x002e
        L_0x002c:
            r16 = r32
        L_0x002e:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x003f
            com.designsystem.ds_button_v2.DSButtonDefaults r0 = com.designsystem.ds_button_v2.DSButtonDefaults.INSTANCE
            float r0 = r0.m8288getButtonRoundedCornerSizeD9Ej5fM()
            androidx.compose.foundation.shape.RoundedCornerShape r0 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(r0)
            r17 = r0
            goto L_0x0041
        L_0x003f:
            r17 = r33
        L_0x0041:
            r18 = 0
            r3 = r19
            r4 = r20
            r7 = r23
            r9 = r25
            r11 = r27
            r3.<init>(r4, r6, r7, r9, r11, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_button_v2.DSDefaultButtonTheme.<init>(long, androidx.compose.ui.graphics.Color, long, long, long, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, com.designsystem.ds_spinner.DSSpinnerColor, androidx.compose.ui.graphics.Shape, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
