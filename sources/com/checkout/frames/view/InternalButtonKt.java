package com.checkout.frames.view;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.checkout.frames.R;
import com.checkout.frames.mapper.ButtonStyleToInternalStateMapper;
import com.checkout.frames.mapper.ButtonStyleToInternalViewStyleMapper;
import com.checkout.frames.mapper.ContainerStyleToModifierMapper;
import com.checkout.frames.mapper.ImageStyleToComposableImageMapper;
import com.checkout.frames.mapper.TextLabelStyleToStateMapper;
import com.checkout.frames.mapper.TextLabelStyleToViewStyleMapper;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.ButtonElevation;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.model.TextAlign;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontStyle;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.style.component.p003default.DefaultTextLabelStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.utils.constants.CountryPickerScreenConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a+\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"ButtonPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "InternalButton", "style", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "state", "Lcom/checkout/frames/view/InternalButtonState;", "onClick", "Lkotlin/Function0;", "(Lcom/checkout/frames/style/view/InternalButtonViewStyle;Lcom/checkout/frames/view/InternalButtonState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "OutlineButtonPreview", "provideButtonElevation", "Landroidx/compose/material3/ButtonElevation;", "(Lcom/checkout/frames/style/view/InternalButtonViewStyle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonElevation;", "provideColors", "Landroidx/compose/material3/ButtonColors;", "(Lcom/checkout/frames/style/view/InternalButtonViewStyle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InternalButtonKt {
    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ButtonPreview(Composer composer, int i11) {
        int i12 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1480492879);
        if (i12 != 0 || !startRestartGroup.getSkipping()) {
            ContainerStyleToModifierMapper containerStyleToModifierMapper = new ContainerStyleToModifierMapper();
            ButtonStyleToInternalViewStyleMapper buttonStyleToInternalViewStyleMapper = new ButtonStyleToInternalViewStyleMapper(containerStyleToModifierMapper, new TextLabelStyleToViewStyleMapper(containerStyleToModifierMapper));
            ButtonStyleToInternalStateMapper buttonStyleToInternalStateMapper = new ButtonStyleToInternalStateMapper(new TextLabelStyleToStateMapper(new ImageStyleToComposableImageMapper()));
            Shape shape = Shape.RoundCorner;
            CornerRadius cornerRadius = r4;
            CornerRadius cornerRadius2 = new CornerRadius(8);
            Padding padding = r4;
            Padding padding2 = new Padding(8, 8, 16, 16);
            TextLabelStyle copy$default = TextLabelStyle.copy$default(DefaultTextLabelStyle.title$default(DefaultTextLabelStyle.INSTANCE, (String) null, (Integer) null, 0, (Font) null, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2047, (Object) null), "Save", (Integer) null, new TextStyle(15, 0, (TextAlign) null, Font.SansSerif.INSTANCE, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 502, (DefaultConstructorMarker) null), (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 58, (Object) null);
            ButtonElevation buttonElevation = r7;
            ButtonElevation buttonElevation2 = new ButtonElevation(8, 0, 0, 0, 0, 30, (DefaultConstructorMarker) null);
            ContainerStyle containerStyle = r22;
            ContainerStyle containerStyle2 = new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, new Margin(16), 127, (DefaultConstructorMarker) null);
            ButtonStyle buttonStyle = new ButtonStyle(4278935536L, 4291611852L, 4294967295L, CountryPickerScreenConstants.focusedBorderColor, shape, cornerRadius, (BorderStroke) null, buttonElevation, padding, copy$default, containerStyle, 64, (DefaultConstructorMarker) null);
            InternalButtonState map = buttonStyleToInternalStateMapper.map(buttonStyle);
            InternalButtonViewStyle map2 = buttonStyleToInternalViewStyleMapper.map(buttonStyle);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed((Object) map);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new InternalButtonKt$ButtonPreview$1$1(map);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            InternalButton(map2, map, (Function0) rememberedValue, startRestartGroup, 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InternalButtonKt$ButtonPreview$2(i12));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void InternalButton(@NotNull InternalButtonViewStyle internalButtonViewStyle, @NotNull InternalButtonState internalButtonState, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        InternalButtonViewStyle internalButtonViewStyle2 = internalButtonViewStyle;
        InternalButtonState internalButtonState2 = internalButtonState;
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(internalButtonViewStyle2, "style");
        Intrinsics.checkNotNullParameter(internalButtonState2, "state");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-376932323);
        internalButtonViewStyle.getTextStyle().m9316setColor8_81llA(Color.Companion.m2955getUnspecified0d7_KjU());
        Modifier modifier = internalButtonViewStyle.getModifier();
        boolean booleanValue = internalButtonState.isEnabled().getValue().booleanValue();
        androidx.compose.material3.ButtonElevation provideButtonElevation = provideButtonElevation(internalButtonViewStyle2, startRestartGroup, 8);
        androidx.compose.ui.graphics.Shape shape = internalButtonViewStyle.getShape();
        androidx.compose.foundation.BorderStroke border = internalButtonViewStyle.getBorder();
        ButtonKt.Button(function0, modifier, booleanValue, shape, provideColors(internalButtonViewStyle2, startRestartGroup, 8), provideButtonElevation, border, internalButtonViewStyle.getContentPadding(), (MutableInteractionSource) null, ComposableLambdaKt.composableLambda(startRestartGroup, -12868880, true, new InternalButtonKt$InternalButton$1$1(internalButtonViewStyle2, internalButtonState2)), startRestartGroup, ((i11 >> 6) & 14) | 805306368, 256);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InternalButtonKt$InternalButton$2(internalButtonViewStyle2, internalButtonState2, function02, i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void OutlineButtonPreview(Composer composer, int i11) {
        int i12 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-65728853);
        if (i12 != 0 || !startRestartGroup.getSkipping()) {
            ContainerStyleToModifierMapper containerStyleToModifierMapper = new ContainerStyleToModifierMapper();
            ButtonStyleToInternalViewStyleMapper buttonStyleToInternalViewStyleMapper = new ButtonStyleToInternalViewStyleMapper(containerStyleToModifierMapper, new TextLabelStyleToViewStyleMapper(containerStyleToModifierMapper));
            ButtonStyleToInternalStateMapper buttonStyleToInternalStateMapper = new ButtonStyleToInternalStateMapper(new TextLabelStyleToStateMapper(new ImageStyleToComposableImageMapper()));
            Shape shape = Shape.RoundCorner;
            CornerRadius cornerRadius = r5;
            CornerRadius cornerRadius2 = new CornerRadius(8);
            BorderStroke borderStroke = r5;
            BorderStroke borderStroke2 = new BorderStroke(1, 4286618109L);
            Padding padding = r5;
            Padding padding2 = new Padding(8, 8, 16, 16);
            TextLabelStyle copy$default = TextLabelStyle.copy$default(DefaultTextLabelStyle.title$default(DefaultTextLabelStyle.INSTANCE, (String) null, (Integer) null, 0, (Font) null, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2047, (Object) null), "Add billing address", (Integer) null, new TextStyle(15, 0, (TextAlign) null, Font.SansSerif.INSTANCE, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 502, (DefaultConstructorMarker) null), (ImageStyle) null, new ImageStyle(Integer.valueOf(R.drawable.cko_ic_caret_right), 4278935536L, 12, (Integer) null, new Padding(0, 0, 12, 0, 11, (DefaultConstructorMarker) null), 8, (DefaultConstructorMarker) null), (ContainerStyle) null, 42, (Object) null);
            ContainerStyle containerStyle = r24;
            ContainerStyle containerStyle2 = new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, new Margin(16), 127, (DefaultConstructorMarker) null);
            ButtonStyle buttonStyle = new ButtonStyle(0, 4291611852L, 4278935536L, 4294967040L, shape, cornerRadius, borderStroke, (ButtonElevation) null, padding, copy$default, containerStyle, 128, (DefaultConstructorMarker) null);
            InternalButtonState map = buttonStyleToInternalStateMapper.map(buttonStyle);
            InternalButtonViewStyle map2 = buttonStyleToInternalViewStyleMapper.map(buttonStyle);
            map2.getTextStyle().setTextMaxWidth(true);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed((Object) map);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new InternalButtonKt$OutlineButtonPreview$2$1(map);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            InternalButton(map2, map, (Function0) rememberedValue, startRestartGroup, 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InternalButtonKt$OutlineButtonPreview$3(i12));
        }
    }

    @Composable
    private static final androidx.compose.material3.ButtonElevation provideButtonElevation(InternalButtonViewStyle internalButtonViewStyle, Composer composer, int i11) {
        composer.startReplaceableGroup(-1707115309);
        androidx.compose.material3.ButtonElevation r92 = ButtonDefaults.INSTANCE.m1518buttonElevationR_JCAzs(internalButtonViewStyle.m9293getDefaultElevationD9Ej5fM(), internalButtonViewStyle.m9299getPressedElevationD9Ej5fM(), internalButtonViewStyle.m9297getFocusedElevationD9Ej5fM(), internalButtonViewStyle.m9298getHoveredElevationD9Ej5fM(), 0.0f, composer, 262144, 16);
        composer.endReplaceableGroup();
        return r92;
    }

    @Composable
    private static final ButtonColors provideColors(InternalButtonViewStyle internalButtonViewStyle, Composer composer, int i11) {
        composer.startReplaceableGroup(-118673801);
        ButtonColors r12 = ButtonDefaults.INSTANCE.m1517buttonColorsro_MJ88(internalButtonViewStyle.m9291getContainerColor0d7_KjU(), internalButtonViewStyle.m9292getContentColor0d7_KjU(), internalButtonViewStyle.m9294getDisabledContainerColor0d7_KjU(), internalButtonViewStyle.m9295getDisabledContentColor0d7_KjU(), composer, 32768, 0);
        composer.endReplaceableGroup();
        return r12;
    }
}
