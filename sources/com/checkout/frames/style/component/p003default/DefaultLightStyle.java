package com.checkout.frames.style.component.p003default;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.model.TextAlign;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontStyle;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.ScreenHeaderStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.CursorStyle;
import com.checkout.frames.style.component.base.ImageContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldIndicatorStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.utils.constants.HeaderTitleConstants;
import com.checkout.frames.utils.constants.LightStyleConstants;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import okio.Utf8;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00062\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020#J\u0001\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00062\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010,\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00103\u001a\u00020\b2\b\b\u0002\u00104\u001a\u00020\b2\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00107J\u0012\u00108\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u0006\u00109\u001a\u00020\u000bJ\u0006\u0010:\u001a\u00020%J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020\u000b¨\u0006>"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultLightStyle;", "", "()V", "cardSchemeComponentStyle", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "titleText", "", "titleTextId", "", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "errorTextLabelStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "indicatorStyle", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "inputComponentStyle", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "subtitleText", "subtitleTextId", "infoText", "infoTextId", "placeholderResourceText", "placeholderResourceTextId", "withLeadingIcon", "", "padding", "Lcom/checkout/frames/model/Padding;", "margin", "Lcom/checkout/frames/model/Margin;", "isFieldOptional", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZLcom/checkout/frames/model/Padding;Lcom/checkout/frames/model/Margin;ZLandroidx/compose/foundation/text/KeyboardOptions;)Lcom/checkout/frames/style/component/base/InputComponentStyle;", "inputFieldStyle", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "inputFieldTextStyle", "Lcom/checkout/frames/style/component/base/TextStyle;", "leadingIconStyle", "Lcom/checkout/frames/style/component/base/ImageStyle;", "placeHolderTextStyle", "screenHeader", "Lcom/checkout/frames/style/component/ScreenHeaderStyle;", "text", "textId", "imageId", "fontSize", "fontWeight", "Lcom/checkout/frames/model/font/FontWeight;", "font", "Lcom/checkout/frames/model/font/Font;", "textColor", "", "height", "maxLines", "leadingIconSize", "leadingIconPadding", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILcom/checkout/frames/model/font/FontWeight;Lcom/checkout/frames/model/font/Font;JLcom/checkout/frames/model/Padding;IIILcom/checkout/frames/model/Padding;)Lcom/checkout/frames/style/component/ScreenHeaderStyle;", "screenTitleTextLabelStyle", "subtitleTextLabelStyle", "supportedCardSchemeIconStyle", "supportedCardSchemeImageContainerStyle", "Lcom/checkout/frames/style/component/base/ImageContainerStyle;", "titleTextLabelStyle", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultLightStyle  reason: invalid package */
public final class DefaultLightStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultLightStyle INSTANCE = new DefaultLightStyle();

    private DefaultLightStyle() {
    }

    public static /* synthetic */ CardSchemeComponentStyle cardSchemeComponentStyle$default(DefaultLightStyle defaultLightStyle, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 2) != 0) {
            num = Integer.valueOf(R.string.cko_accepted_cards_title);
        }
        return defaultLightStyle.cardSchemeComponentStyle(str, num);
    }

    public static /* synthetic */ InputComponentStyle inputComponentStyle$default(DefaultLightStyle defaultLightStyle, String str, Integer num, String str2, Integer num2, String str3, Integer num3, String str4, Integer num4, boolean z11, Padding padding, Margin margin, boolean z12, KeyboardOptions keyboardOptions, int i11, Object obj) {
        int i12 = i11;
        String str5 = "";
        String str6 = (i12 & 1) != 0 ? str5 : str;
        Integer num5 = null;
        Integer num6 = (i12 & 2) != 0 ? null : num;
        String str7 = (i12 & 4) != 0 ? str5 : str2;
        Integer num7 = (i12 & 8) != 0 ? null : num2;
        String str8 = (i12 & 16) != 0 ? str5 : str3;
        Integer num8 = (i12 & 32) != 0 ? null : num3;
        if ((i12 & 64) == 0) {
            str5 = str4;
        }
        if ((i12 & 128) == 0) {
            num5 = num4;
        }
        boolean z13 = false;
        boolean z14 = (i12 & 256) != 0 ? false : z11;
        Padding padding2 = (i12 & 512) != 0 ? new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null) : padding;
        Margin margin2 = (i12 & 1024) != 0 ? new Margin(0, 0, 0, 0, 15, (DefaultConstructorMarker) null) : margin;
        if ((i12 & 2048) == 0) {
            z13 = z12;
        }
        return defaultLightStyle.inputComponentStyle(str6, num6, str7, num7, str8, num8, str5, num5, z14, padding2, margin2, z13, (i12 & 4096) != 0 ? KeyboardOptions.Companion.getDefault() : keyboardOptions);
    }

    public static /* synthetic */ InputFieldStyle inputFieldStyle$default(DefaultLightStyle defaultLightStyle, boolean z11, KeyboardOptions keyboardOptions, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            keyboardOptions = KeyboardOptions.Companion.getDefault();
        }
        return defaultLightStyle.inputFieldStyle(z11, keyboardOptions);
    }

    public static /* synthetic */ ScreenHeaderStyle screenHeader$default(DefaultLightStyle defaultLightStyle, String str, Integer num, Integer num2, int i11, FontWeight fontWeight, Font font, long j11, Padding padding, int i12, int i13, int i14, Padding padding2, int i15, Object obj) {
        int i16 = i15;
        String str2 = (i16 & 1) != 0 ? "" : str;
        Integer num3 = null;
        Integer num4 = (i16 & 2) != 0 ? null : num;
        if ((i16 & 4) == 0) {
            num3 = num2;
        }
        return defaultLightStyle.screenHeader(str2, num4, num3, (i16 & 8) != 0 ? 20 : i11, (i16 & 16) != 0 ? FontWeight.Normal : fontWeight, (i16 & 32) != 0 ? HeaderTitleConstants.INSTANCE.getFont() : font, (i16 & 64) != 0 ? 4279505940L : j11, (i16 & 128) != 0 ? new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null) : padding, (i16 & 256) != 0 ? 56 : i12, (i16 & 512) != 0 ? 1 : i13, (i16 & 1024) != 0 ? 14 : i14, (i16 & 2048) != 0 ? new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null) : padding2);
    }

    public static /* synthetic */ TextLabelStyle screenTitleTextLabelStyle$default(DefaultLightStyle defaultLightStyle, Padding padding, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            padding = new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
        }
        return defaultLightStyle.screenTitleTextLabelStyle(padding);
    }

    @NotNull
    public final CardSchemeComponentStyle cardSchemeComponentStyle(@NotNull String str, @Nullable @StringRes Integer num) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "titleText");
        TextLabelStyle subtitleTextLabelStyle = subtitleTextLabelStyle();
        subtitleTextLabelStyle.setText(str2);
        subtitleTextLabelStyle.setTextId(num);
        return new CardSchemeComponentStyle(subtitleTextLabelStyle, supportedCardSchemeIconStyle(), new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, new Margin(8, 24, 0, 0, 12, (DefaultConstructorMarker) null), 127, (DefaultConstructorMarker) null), supportedCardSchemeImageContainerStyle());
    }

    @NotNull
    public final TextLabelStyle errorTextLabelStyle() {
        return DefaultTextLabelStyle.error$default(DefaultTextLabelStyle.INSTANCE, 0, (Font) null, 0, 0, 0, (Padding) null, 63, (Object) null);
    }

    @NotNull
    public final InputFieldIndicatorStyle indicatorStyle() {
        return new InputFieldIndicatorStyle.Border((Shape) null, (CornerRadius) null, 0, 0, 4278935536L, 4287269514L, 0, 4289538110L, 79, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final InputComponentStyle inputComponentStyle(@NotNull String str, @Nullable @StringRes Integer num, @NotNull String str2, @Nullable @StringRes Integer num2, @NotNull String str3, @Nullable @StringRes Integer num3, @NotNull String str4, @Nullable @StringRes Integer num4, boolean z11, @NotNull Padding padding, @NotNull Margin margin, boolean z12, @NotNull KeyboardOptions keyboardOptions) {
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        KeyboardOptions keyboardOptions2 = keyboardOptions;
        Intrinsics.checkNotNullParameter(str5, "titleText");
        Intrinsics.checkNotNullParameter(str6, "subtitleText");
        Intrinsics.checkNotNullParameter(str7, "infoText");
        Intrinsics.checkNotNullParameter(str8, "placeholderResourceText");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        Margin margin2 = margin;
        Intrinsics.checkNotNullParameter(margin2, "margin");
        Intrinsics.checkNotNullParameter(keyboardOptions2, "keyboardOptions");
        TextLabelStyle titleTextLabelStyle = titleTextLabelStyle();
        titleTextLabelStyle.setText(str5);
        titleTextLabelStyle.setTextId(num);
        TextLabelStyle subtitleTextLabelStyle = subtitleTextLabelStyle();
        subtitleTextLabelStyle.setText(str6);
        subtitleTextLabelStyle.setTextId(num2);
        InputFieldStyle inputFieldStyle = inputFieldStyle(z11, keyboardOptions2);
        inputFieldStyle.setPlaceholderText(str8);
        inputFieldStyle.setPlaceholderTextId(num4);
        TextLabelStyle subtitleTextLabelStyle2 = subtitleTextLabelStyle();
        subtitleTextLabelStyle2.setText(str7);
        subtitleTextLabelStyle2.setTextId(num3);
        return new InputComponentStyle(titleTextLabelStyle, subtitleTextLabelStyle, subtitleTextLabelStyle2, inputFieldStyle, errorTextLabelStyle(), new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, padding2, margin2, 63, (DefaultConstructorMarker) null), z12);
    }

    @NotNull
    public final InputFieldStyle inputFieldStyle(boolean z11, @NotNull KeyboardOptions keyboardOptions) {
        ImageStyle imageStyle;
        Intrinsics.checkNotNullParameter(keyboardOptions, "keyboardOptions");
        TextStyle inputFieldTextStyle = inputFieldTextStyle();
        InputFieldIndicatorStyle indicatorStyle = indicatorStyle();
        TextStyle placeHolderTextStyle = placeHolderTextStyle();
        if (z11) {
            imageStyle = leadingIconStyle();
        } else {
            imageStyle = null;
        }
        return new InputFieldStyle(inputFieldTextStyle, (String) null, (Integer) null, placeHolderTextStyle, new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, new Margin(8, 0, 0, 0, 14, (DefaultConstructorMarker) null), 127, (DefaultConstructorMarker) null), indicatorStyle, imageStyle, (ImageStyle) null, (CursorStyle) null, keyboardOptions, 390, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final TextStyle inputFieldTextStyle() {
        return new TextStyle(15, 4279505940L, (TextAlign) null, LightStyleConstants.INSTANCE.getFont(), (FontStyle) null, (FontWeight) null, 1, (Integer) null, (Integer) null, 436, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final ImageStyle leadingIconStyle() {
        return new ImageStyle((Integer) null, (Long) null, 16, 26, new Padding(0, 0, 20, 10, 3, (DefaultConstructorMarker) null), 3, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final TextStyle placeHolderTextStyle() {
        return DefaultTextStyle.INSTANCE.placeHolder();
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader() {
        return screenHeader$default(this, (String) null, (Integer) null, (Integer) null, 0, (FontWeight) null, (Font) null, 0, (Padding) null, 0, 0, 0, (Padding) null, UnixStat.PERM_MASK, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        return screenHeader$default(this, str2, (Integer) null, (Integer) null, 0, (FontWeight) null, (Font) null, 0, (Padding) null, 0, 0, 0, (Padding) null, 4094, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        return screenHeader$default(this, str2, num, (Integer) null, 0, (FontWeight) null, (Font) null, 0, (Padding) null, 0, 0, 0, (Padding) null, 4092, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        return screenHeader$default(this, str2, num, num2, 0, (FontWeight) null, (Font) null, 0, (Padding) null, 0, 0, 0, (Padding) null, 4088, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        return screenHeader$default(this, str2, num, num2, i11, (FontWeight) null, (Font) null, 0, (Padding) null, 0, 0, 0, (Padding) null, 4080, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11, @NotNull FontWeight fontWeight) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return screenHeader$default(this, str2, num, num2, i11, fontWeight2, (Font) null, 0, (Padding) null, 0, 0, 0, (Padding) null, 4064, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11, @NotNull FontWeight fontWeight, @NotNull Font font) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return screenHeader$default(this, str2, num, num2, i11, fontWeight2, font2, 0, (Padding) null, 0, 0, 0, (Padding) null, 4032, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return screenHeader$default(this, str2, num, num2, i11, fontWeight2, font2, j11, (Padding) null, 0, 0, 0, (Padding) null, Utf8.MASK_2BYTES, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return screenHeader$default(this, str2, num, num2, i11, fontWeight2, font2, j11, padding2, 0, 0, 0, (Padding) null, 3840, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding, int i12) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return screenHeader$default(this, str2, num, num2, i11, fontWeight2, font2, j11, padding2, i12, 0, 0, (Padding) null, 3584, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding, int i12, int i13) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return screenHeader$default(this, str2, num, num2, i11, fontWeight2, font2, j11, padding2, i12, i13, 0, (Padding) null, KfsConstant.KFS_RSA_KEY_LEN_3072, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding, int i12, int i13, int i14) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return screenHeader$default(this, str2, num, num2, i11, fontWeight2, font2, j11, padding2, i12, i13, i14, (Padding) null, 2048, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ScreenHeaderStyle screenHeader(@NotNull String str, @Nullable @StringRes Integer num, @Nullable @DrawableRes Integer num2, int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding, int i12, int i13, int i14, @NotNull Padding padding2) {
        Intrinsics.checkNotNullParameter(str, "text");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Intrinsics.checkNotNullParameter(padding, Param.PADDING);
        Intrinsics.checkNotNullParameter(padding2, "leadingIconPadding");
        return new ScreenHeaderStyle(str, num, new TextStyle(i11, j11, (TextAlign) null, font2, (FontStyle) null, fontWeight2, i13, (Integer) null, (Integer) null, 404, (DefaultConstructorMarker) null), new ImageStyle(num2, Long.valueOf(j11), Integer.valueOf(i14), Integer.valueOf(i14), padding2), new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, Integer.valueOf(i12), padding, (Margin) null, Opcodes.IF_ICMPEQ, (DefaultConstructorMarker) null));
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle screenTitleTextLabelStyle() {
        return screenTitleTextLabelStyle$default(this, (Padding) null, 1, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle screenTitleTextLabelStyle(@NotNull Padding padding) {
        Intrinsics.checkNotNullParameter(padding, Param.PADDING);
        return DefaultTextLabelStyle.headerTitle$default(DefaultTextLabelStyle.INSTANCE, 0, (FontWeight) null, (Font) null, 0, padding, 0, 0, (Padding) null, 239, (Object) null);
    }

    @NotNull
    public final TextLabelStyle subtitleTextLabelStyle() {
        return DefaultTextLabelStyle.subtitle$default(DefaultTextLabelStyle.INSTANCE, (String) null, (Integer) null, 0, (Font) null, 0, (Padding) null, 0, (Integer) null, 255, (Object) null);
    }

    @NotNull
    public final ImageStyle supportedCardSchemeIconStyle() {
        return new ImageStyle((Integer) null, (Long) null, 16, 26, (Padding) null, 19, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final ImageContainerStyle supportedCardSchemeImageContainerStyle() {
        return new ImageContainerStyle(4, 6, new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, new Margin(8, 0, 0, 0, 14, (DefaultConstructorMarker) null), 127, (DefaultConstructorMarker) null));
    }

    @NotNull
    public final TextLabelStyle titleTextLabelStyle() {
        return DefaultTextLabelStyle.title$default(DefaultTextLabelStyle.INSTANCE, (String) null, (Integer) null, 0, (Font) null, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2047, (Object) null);
    }
}
