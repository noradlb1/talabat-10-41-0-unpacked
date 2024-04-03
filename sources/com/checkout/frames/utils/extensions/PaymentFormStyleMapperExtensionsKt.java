package com.checkout.frames.utils.extensions;

import androidx.compose.foundation.text.KeyboardOptions;
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
import com.checkout.frames.style.component.base.CursorStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldIndicatorStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.style.theme.PaymentFormComponent;
import com.checkout.frames.style.theme.PaymentFormTheme;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0002H\u0000\u001a \u0010\n\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0000\u001a\u0016\u0010\u000e\u001a\u00020\u000f*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\r\u001a\u00020\u0002H\u0000\u001a\u001e\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000\u001a\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a \u0010\u0017\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0000\u001a\u0016\u0010\u0018\u001a\u00020\u000f*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0000\u001a+\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\u0010\u001f\u001a \u0010 \u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0000\u001a\u0016\u0010!\u001a\u00020\u000f*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¨\u0006\""}, d2 = {"provideContainerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Lcom/checkout/frames/style/theme/PaymentFormTheme;", "padding", "Lcom/checkout/frames/model/Padding;", "provideErrorMessageStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "paymentFormTheme", "provideIndicatorStyle", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "provideInfoStyle", "component", "Lcom/checkout/frames/style/theme/PaymentFormComponent;", "from", "provideInfoTextStyle", "Lcom/checkout/frames/style/component/base/TextStyle;", "provideInputFieldContainerStyle", "provideInputFieldStyle", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "provideOutLinedButtonStyle", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "provideSolidButtonStyle", "provideSubTitleStyle", "provideSubTitleTextStyle", "provideText", "", "text", "provideTextId", "", "textId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "provideTitleStyle", "provideTitleTextStyle", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormStyleMapperExtensionsKt {
    @NotNull
    public static final ContainerStyle provideContainerStyle(@NotNull PaymentFormTheme paymentFormTheme, @Nullable Padding padding) {
        Intrinsics.checkNotNullParameter(paymentFormTheme, "<this>");
        return ContainerStyle.copy$default(new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, (Margin) null, 255, (DefaultConstructorMarker) null), paymentFormTheme.getPaymentFormThemeColors().getPaymentFormColors().getBackground(), (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, padding, (Margin) null, 190, (Object) null);
    }

    public static /* synthetic */ ContainerStyle provideContainerStyle$default(PaymentFormTheme paymentFormTheme, Padding padding, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            padding = null;
        }
        return provideContainerStyle(paymentFormTheme, padding);
    }

    @Nullable
    public static final TextLabelStyle provideErrorMessageStyle(@Nullable TextLabelStyle textLabelStyle, @NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(paymentFormTheme, "paymentFormTheme");
        if (textLabelStyle == null) {
            return null;
        }
        return TextLabelStyle.copy$default(textLabelStyle, (String) null, (Integer) null, TextStyle.copy$default(textLabelStyle.getTextStyle(), 0, paymentFormTheme.getPaymentFormThemeColors().getTextColors().getErrorColor(), (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 509, (Object) null), (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 59, (Object) null);
    }

    @NotNull
    public static final InputFieldIndicatorStyle provideIndicatorStyle(@NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(paymentFormTheme, "<this>");
        InputFieldIndicatorStyle.Border border = new InputFieldIndicatorStyle.Border((Shape) null, (CornerRadius) null, 0, 0, 0, 0, 0, 0, 255, (DefaultConstructorMarker) null);
        long focusedBorderColor = paymentFormTheme.getPaymentFormThemeColors().getInputFieldColors().getFocusedBorderColor();
        long unfocusedBorderColor = paymentFormTheme.getPaymentFormThemeColors().getInputFieldColors().getUnfocusedBorderColor();
        long disabledBorderColor = paymentFormTheme.getPaymentFormThemeColors().getInputFieldColors().getDisabledBorderColor();
        long errorBorderColor = paymentFormTheme.getPaymentFormThemeColors().getInputFieldColors().getErrorBorderColor();
        return InputFieldIndicatorStyle.Border.copy$default(border, paymentFormTheme.getPaymentFormShape().getInputFieldShape(), paymentFormTheme.getPaymentFormCornerRadius().getInputFieldCornerRadius(), 0, 0, focusedBorderColor, unfocusedBorderColor, disabledBorderColor, errorBorderColor, 12, (Object) null);
    }

    @Nullable
    public static final TextLabelStyle provideInfoStyle(@Nullable TextLabelStyle textLabelStyle, @NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
        Intrinsics.checkNotNullParameter(paymentFormTheme, "from");
        if (textLabelStyle == null) {
            return null;
        }
        return TextLabelStyle.copy$default(textLabelStyle, provideText(textLabelStyle.getText(), paymentFormComponent.getInfoText()), provideTextId(textLabelStyle.getTextId(), paymentFormComponent.getInfoText(), paymentFormComponent.getInfoTextId()), provideInfoTextStyle(textLabelStyle, paymentFormTheme), (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 56, (Object) null);
    }

    @NotNull
    public static final TextStyle provideInfoTextStyle(@Nullable TextLabelStyle textLabelStyle, @NotNull PaymentFormTheme paymentFormTheme) {
        TextStyle textStyle;
        TextStyle copy$default;
        Intrinsics.checkNotNullParameter(paymentFormTheme, "paymentFormTheme");
        if (textLabelStyle == null || (textStyle = textLabelStyle.getTextStyle()) == null || (copy$default = TextStyle.copy$default(textStyle, 0, paymentFormTheme.getPaymentFormThemeColors().getTextColors().getInfoColor(), (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 509, (Object) null)) == null) {
            return new TextStyle(0, 0, (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 511, (DefaultConstructorMarker) null);
        }
        return copy$default;
    }

    @NotNull
    public static final ContainerStyle provideInputFieldContainerStyle(@NotNull ContainerStyle containerStyle, @NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(containerStyle, "<this>");
        Intrinsics.checkNotNullParameter(paymentFormTheme, "from");
        return ContainerStyle.copy$default(containerStyle, paymentFormTheme.getPaymentFormThemeColors().getInputFieldColors().getInputFieldBackgroundColor(), paymentFormTheme.getPaymentFormShape().getInputFieldShape(), paymentFormTheme.getPaymentFormCornerRadius().getInputFieldCornerRadius(), (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, (Margin) null, 248, (Object) null);
    }

    @NotNull
    public static final InputFieldStyle provideInputFieldStyle(@NotNull InputComponentStyle inputComponentStyle, @NotNull PaymentFormTheme paymentFormTheme) {
        ImageStyle imageStyle;
        PaymentFormTheme paymentFormTheme2 = paymentFormTheme;
        Intrinsics.checkNotNullParameter(inputComponentStyle, "<this>");
        Intrinsics.checkNotNullParameter(paymentFormTheme2, "from");
        InputFieldStyle inputFieldStyle = inputComponentStyle.getInputFieldStyle();
        InputFieldIndicatorStyle provideIndicatorStyle = provideIndicatorStyle(paymentFormTheme);
        TextStyle provideTitleTextStyle = provideTitleTextStyle(inputComponentStyle.getTitleStyle(), paymentFormTheme2);
        ImageStyle trailingIconStyle = inputComponentStyle.getInputFieldStyle().getTrailingIconStyle();
        CursorStyle cursorStyle = null;
        if (trailingIconStyle != null) {
            imageStyle = ImageStyle.copy$default(trailingIconStyle, (Integer) null, paymentFormTheme.getPaymentFormThemeColors().getImageColors().getTinColor(), (Integer) null, (Integer) null, (Padding) null, 29, (Object) null);
        } else {
            imageStyle = null;
        }
        CursorStyle cursorStyle2 = inputComponentStyle.getInputFieldStyle().getCursorStyle();
        if (cursorStyle2 != null) {
            cursorStyle = cursorStyle2.copy(paymentFormTheme.getPaymentFormThemeColors().getCursorColors().getCursorColor(), paymentFormTheme.getPaymentFormThemeColors().getCursorColors().getErrorCursorColor(), paymentFormTheme.getPaymentFormThemeColors().getCursorColors().getCursorHandleColor(), paymentFormTheme.getPaymentFormThemeColors().getCursorColors().getCursorHighlightColor());
        }
        return InputFieldStyle.copy$default(inputFieldStyle, provideTitleTextStyle, (String) null, (Integer) null, (TextStyle) null, provideInputFieldContainerStyle(inputComponentStyle.getInputFieldStyle().getContainerStyle(), paymentFormTheme2), provideIndicatorStyle, (ImageStyle) null, imageStyle, cursorStyle, (KeyboardOptions) null, 590, (Object) null);
    }

    @NotNull
    public static final ButtonStyle provideOutLinedButtonStyle(@NotNull ButtonStyle buttonStyle, @NotNull PaymentFormTheme paymentFormTheme, @Nullable PaymentFormComponent paymentFormComponent) {
        BorderStroke borderStroke;
        String str;
        String str2;
        Integer num;
        ImageStyle imageStyle;
        PaymentFormTheme paymentFormTheme2 = paymentFormTheme;
        Intrinsics.checkNotNullParameter(buttonStyle, "<this>");
        Intrinsics.checkNotNullParameter(paymentFormTheme2, "from");
        long contentColor = paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getContentColor();
        long disabledContentColor = paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getDisabledContentColor();
        long disabledContainerColor = paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getDisabledContainerColor();
        BorderStroke borderStroke2 = buttonStyle.getBorderStroke();
        if (borderStroke2 != null) {
            borderStroke = BorderStroke.copy$default(borderStroke2, 0, paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getContainerColor(), 1, (Object) null);
        } else {
            borderStroke = null;
        }
        CornerRadius buttonCornerRadius = paymentFormTheme.getPaymentFormCornerRadius().getButtonCornerRadius();
        Shape buttonShape = paymentFormTheme.getPaymentFormShape().getButtonShape();
        TextLabelStyle textStyle = buttonStyle.getTextStyle();
        String text = buttonStyle.getTextStyle().getText();
        if (paymentFormComponent != null) {
            str = paymentFormComponent.getTitleText();
        } else {
            str = null;
        }
        String provideText = provideText(text, str);
        Integer textId = buttonStyle.getTextStyle().getTextId();
        if (paymentFormComponent != null) {
            str2 = paymentFormComponent.getTitleText();
        } else {
            str2 = null;
        }
        if (paymentFormComponent != null) {
            num = paymentFormComponent.getTitleTextId();
        } else {
            num = null;
        }
        Integer provideTextId = provideTextId(textId, str2, num);
        ImageStyle trailingIconStyle = buttonStyle.getTextStyle().getTrailingIconStyle();
        if (trailingIconStyle != null) {
            imageStyle = ImageStyle.copy$default(trailingIconStyle, (Integer) null, Long.valueOf(paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getContentColor()), (Integer) null, (Integer) null, (Padding) null, 29, (Object) null);
        } else {
            imageStyle = null;
        }
        return ButtonStyle.copy$default(buttonStyle, 0, disabledContainerColor, contentColor, disabledContentColor, buttonShape, buttonCornerRadius, borderStroke, (ButtonElevation) null, (Padding) null, TextLabelStyle.copy$default(textStyle, provideText, provideTextId, provideTitleTextStyle(buttonStyle.getTextStyle(), paymentFormTheme2), (ImageStyle) null, imageStyle, (ContainerStyle) null, 40, (Object) null), (ContainerStyle) null, 1409, (Object) null);
    }

    @NotNull
    public static final ButtonStyle provideSolidButtonStyle(@NotNull ButtonStyle buttonStyle, @NotNull PaymentFormTheme paymentFormTheme, @NotNull PaymentFormComponent paymentFormComponent) {
        ImageStyle imageStyle;
        PaymentFormTheme paymentFormTheme2 = paymentFormTheme;
        Intrinsics.checkNotNullParameter(buttonStyle, "<this>");
        Intrinsics.checkNotNullParameter(paymentFormTheme2, "from");
        Intrinsics.checkNotNullParameter(paymentFormComponent, FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
        long contentColor = paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getContentColor();
        long disabledContentColor = paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getDisabledContentColor();
        long containerColor = paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getContainerColor();
        CornerRadius buttonCornerRadius = paymentFormTheme.getPaymentFormCornerRadius().getButtonCornerRadius();
        Shape buttonShape = paymentFormTheme.getPaymentFormShape().getButtonShape();
        long disabledContainerColor = paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getDisabledContainerColor();
        TextLabelStyle textStyle = buttonStyle.getTextStyle();
        String provideText = provideText(buttonStyle.getTextStyle().getText(), paymentFormComponent.getTitleText());
        Integer provideTextId = provideTextId(buttonStyle.getTextStyle().getTextId(), paymentFormComponent.getTitleText(), paymentFormComponent.getTitleTextId());
        ImageStyle trailingIconStyle = buttonStyle.getTextStyle().getTrailingIconStyle();
        if (trailingIconStyle != null) {
            imageStyle = ImageStyle.copy$default(trailingIconStyle, (Integer) null, Long.valueOf(paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getContentColor()), (Integer) null, (Integer) null, (Padding) null, 29, (Object) null);
        } else {
            imageStyle = null;
        }
        return ButtonStyle.copy$default(buttonStyle, containerColor, disabledContainerColor, contentColor, disabledContentColor, buttonShape, buttonCornerRadius, (BorderStroke) null, (ButtonElevation) null, (Padding) null, TextLabelStyle.copy$default(textStyle, provideText, provideTextId, provideTitleTextStyle(buttonStyle.getTextStyle(), paymentFormTheme2), (ImageStyle) null, imageStyle, (ContainerStyle) null, 40, (Object) null), (ContainerStyle) null, 1472, (Object) null);
    }

    @Nullable
    public static final TextLabelStyle provideSubTitleStyle(@Nullable TextLabelStyle textLabelStyle, @NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
        Intrinsics.checkNotNullParameter(paymentFormTheme, "from");
        if (textLabelStyle == null) {
            return null;
        }
        return TextLabelStyle.copy$default(textLabelStyle, provideText(textLabelStyle.getText(), paymentFormComponent.getSubTitleText()), provideTextId(textLabelStyle.getTextId(), paymentFormComponent.getSubTitleText(), paymentFormComponent.getSubTitleTextId()), provideSubTitleTextStyle(textLabelStyle, paymentFormTheme), (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 56, (Object) null);
    }

    @NotNull
    public static final TextStyle provideSubTitleTextStyle(@Nullable TextLabelStyle textLabelStyle, @NotNull PaymentFormTheme paymentFormTheme) {
        TextStyle textStyle;
        TextStyle copy$default;
        Intrinsics.checkNotNullParameter(paymentFormTheme, "paymentFormTheme");
        if (textLabelStyle == null || (textStyle = textLabelStyle.getTextStyle()) == null || (copy$default = TextStyle.copy$default(textStyle, 0, paymentFormTheme.getPaymentFormThemeColors().getTextColors().getSubTitleColor(), (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 509, (Object) null)) == null) {
            return new TextStyle(0, 0, (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 511, (DefaultConstructorMarker) null);
        }
        return copy$default;
    }

    @NotNull
    public static final String provideText(@NotNull String str, @Nullable String str2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str2 == null || str2.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return str;
        }
        return str2;
    }

    public static /* synthetic */ String provideText$default(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = null;
        }
        return provideText(str, str2);
    }

    @Nullable
    public static final Integer provideTextId(@Nullable Integer num, @Nullable String str, @Nullable Integer num2) {
        return ((str == null || str.length() == 0) && num2 == null) ? num : num2;
    }

    public static /* synthetic */ Integer provideTextId$default(Integer num, String str, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        return provideTextId(num, str, num2);
    }

    @Nullable
    public static final TextLabelStyle provideTitleStyle(@Nullable TextLabelStyle textLabelStyle, @NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
        Intrinsics.checkNotNullParameter(paymentFormTheme, "from");
        ImageStyle imageStyle = null;
        if (textLabelStyle == null) {
            return null;
        }
        String provideText = provideText(textLabelStyle.getText(), paymentFormComponent.getTitleText());
        Integer provideTextId = provideTextId(textLabelStyle.getTextId(), paymentFormComponent.getTitleText(), paymentFormComponent.getTitleTextId());
        ImageStyle leadingIconStyle = textLabelStyle.getLeadingIconStyle();
        if (leadingIconStyle != null) {
            imageStyle = ImageStyle.copy$default(leadingIconStyle, (Integer) null, paymentFormTheme.getPaymentFormThemeColors().getImageColors().getTinColor(), (Integer) null, (Integer) null, (Padding) null, 29, (Object) null);
        }
        return TextLabelStyle.copy$default(textLabelStyle, provideText, provideTextId, provideTitleTextStyle(textLabelStyle, paymentFormTheme), imageStyle, (ImageStyle) null, (ContainerStyle) null, 48, (Object) null);
    }

    @NotNull
    public static final TextStyle provideTitleTextStyle(@Nullable TextLabelStyle textLabelStyle, @NotNull PaymentFormTheme paymentFormTheme) {
        TextStyle textStyle;
        TextStyle copy$default;
        Intrinsics.checkNotNullParameter(paymentFormTheme, "paymentFormTheme");
        if (textLabelStyle == null || (textStyle = textLabelStyle.getTextStyle()) == null || (copy$default = TextStyle.copy$default(textStyle, 0, paymentFormTheme.getPaymentFormThemeColors().getTextColors().getTitleColor(), (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 509, (Object) null)) == null) {
            return new TextStyle(0, 0, (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 511, (DefaultConstructorMarker) null);
        }
        return copy$default;
    }
}
