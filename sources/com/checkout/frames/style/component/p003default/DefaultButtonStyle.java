package com.checkout.frames.style.component.p003default;

import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.ButtonElevation;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.utils.constants.ButtonStyleConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J£\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001dJ\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultButtonStyle;", "", "()V", "lightOutline", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "text", "", "textId", "", "contentColor", "", "containerColor", "disabledContentColor", "disabledContainerColor", "shape", "Lcom/checkout/frames/model/Shape;", "cornerRadius", "Lcom/checkout/frames/model/CornerRadius;", "borderStroke", "Lcom/checkout/frames/model/BorderStroke;", "contentPadding", "Lcom/checkout/frames/model/Padding;", "leadingIconStyle", "Lcom/checkout/frames/style/component/base/ImageStyle;", "trailingIconStyle", "margin", "Lcom/checkout/frames/model/Margin;", "fontWeight", "Lcom/checkout/frames/model/font/FontWeight;", "(Ljava/lang/String;Ljava/lang/Integer;JJJJLcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/CornerRadius;Lcom/checkout/frames/model/BorderStroke;Lcom/checkout/frames/model/Padding;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/model/Margin;Lcom/checkout/frames/model/font/FontWeight;)Lcom/checkout/frames/style/component/base/ButtonStyle;", "lightSolid", "(Ljava/lang/String;Ljava/lang/Integer;JJJJLcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/CornerRadius;Lcom/checkout/frames/model/Padding;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/model/Margin;Lcom/checkout/frames/model/font/FontWeight;)Lcom/checkout/frames/style/component/base/ButtonStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultButtonStyle  reason: invalid package */
public final class DefaultButtonStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultButtonStyle INSTANCE = new DefaultButtonStyle();

    private DefaultButtonStyle() {
    }

    public static /* synthetic */ ButtonStyle lightOutline$default(DefaultButtonStyle defaultButtonStyle, String str, Integer num, long j11, long j12, long j13, long j14, Shape shape, CornerRadius cornerRadius, BorderStroke borderStroke, Padding padding, ImageStyle imageStyle, ImageStyle imageStyle2, Margin margin, FontWeight fontWeight, int i11, Object obj) {
        Shape shape2;
        BorderStroke borderStroke2;
        int i12 = i11;
        String str2 = (i12 & 1) != 0 ? "" : str;
        Integer num2 = (i12 & 2) != 0 ? null : num;
        long j15 = 4278935536L;
        long j16 = (i12 & 4) != 0 ? 4278935536L : j11;
        long colorTransparent = (i12 & 8) != 0 ? ButtonStyleConstants.INSTANCE.getColorTransparent() : j12;
        if ((i12 & 16) == 0) {
            j15 = j13;
        }
        long colorTransparent2 = (i12 & 32) != 0 ? ButtonStyleConstants.INSTANCE.getColorTransparent() : j14;
        Shape shape3 = (i12 & 64) != 0 ? Shape.RoundCorner : shape;
        CornerRadius cornerRadius2 = (i12 & 128) != 0 ? new CornerRadius(8) : cornerRadius;
        if ((i12 & 256) != 0) {
            shape2 = shape3;
            borderStroke2 = new BorderStroke(1, ButtonStyleConstants.INSTANCE.getOutlineStrokeColor());
        } else {
            shape2 = shape3;
            borderStroke2 = borderStroke;
        }
        return defaultButtonStyle.lightOutline(str2, num2, j16, colorTransparent, j15, colorTransparent2, shape2, cornerRadius2, borderStroke2, (i12 & 512) != 0 ? ButtonStyleConstants.INSTANCE.getOutlineContentPadding() : padding, (i12 & 1024) != 0 ? null : imageStyle, (i12 & 2048) != 0 ? null : imageStyle2, (i12 & 4096) != 0 ? null : margin, (i12 & 8192) != 0 ? FontWeight.Normal : fontWeight);
    }

    public static /* synthetic */ ButtonStyle lightSolid$default(DefaultButtonStyle defaultButtonStyle, String str, Integer num, long j11, long j12, long j13, long j14, Shape shape, CornerRadius cornerRadius, Padding padding, ImageStyle imageStyle, ImageStyle imageStyle2, Margin margin, FontWeight fontWeight, int i11, Object obj) {
        int i12 = i11;
        String str2 = (i12 & 1) != 0 ? "" : str;
        Integer num2 = (i12 & 2) != 0 ? null : num;
        long j15 = 4278935536L;
        long j16 = (i12 & 4) != 0 ? 4278935536L : j11;
        long colorTransparent = (i12 & 8) != 0 ? ButtonStyleConstants.INSTANCE.getColorTransparent() : j12;
        if ((i12 & 16) == 0) {
            j15 = j13;
        }
        return defaultButtonStyle.lightSolid(str2, num2, j16, colorTransparent, j15, (i12 & 32) != 0 ? ButtonStyleConstants.INSTANCE.getColorTransparent() : j14, (i12 & 64) != 0 ? Shape.RoundCorner : shape, (i12 & 128) != 0 ? new CornerRadius(8) : cornerRadius, (i12 & 256) != 0 ? ButtonStyleConstants.INSTANCE.getSolidContentPadding() : padding, (i12 & 512) != 0 ? null : imageStyle, (i12 & 1024) != 0 ? null : imageStyle2, (i12 & 2048) != 0 ? null : margin, (i12 & 4096) != 0 ? FontWeight.Normal : fontWeight);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline() {
        return lightOutline$default(this, (String) null, (Integer) null, 0, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16383, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightOutline$default(this, str, (Integer) null, 0, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16382, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightOutline$default(this, str, num, 0, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16380, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightOutline$default(this, str, num, j11, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16376, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightOutline$default(this, str, num, j11, j12, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16368, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightOutline$default(this, str, num, j11, j12, j13, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16352, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightOutline$default(this, str, num, j11, j12, j13, j14, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16320, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return lightOutline$default(this, str, num, j11, j12, j13, j14, shape, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16256, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        return lightOutline$default(this, str, num, j11, j12, j13, j14, shape, cornerRadius, (BorderStroke) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 16128, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @Nullable BorderStroke borderStroke) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        return lightOutline$default(this, str, num, j11, j12, j13, j14, shape, cornerRadius, borderStroke, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 15872, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @Nullable BorderStroke borderStroke, @NotNull Padding padding) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        return lightOutline$default(this, str, num, j11, j12, j13, j14, shape, cornerRadius, borderStroke, padding, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 15360, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @Nullable BorderStroke borderStroke, @NotNull Padding padding, @Nullable ImageStyle imageStyle) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        return lightOutline$default(this, str2, num, j11, j12, j13, j14, shape, cornerRadius, borderStroke, padding, imageStyle, (ImageStyle) null, (Margin) null, (FontWeight) null, 14336, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @Nullable BorderStroke borderStroke, @NotNull Padding padding, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        return lightOutline$default(this, str2, num, j11, j12, j13, j14, shape, cornerRadius, borderStroke, padding, imageStyle, imageStyle2, (Margin) null, (FontWeight) null, 12288, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @Nullable BorderStroke borderStroke, @NotNull Padding padding, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2, @Nullable Margin margin) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        return lightOutline$default(this, str2, num, j11, j12, j13, j14, shape, cornerRadius, borderStroke, padding, imageStyle, imageStyle2, margin, (FontWeight) null, 8192, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightOutline(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @Nullable BorderStroke borderStroke, @NotNull Padding padding, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2, @Nullable Margin margin, @NotNull FontWeight fontWeight) {
        long j15 = j12;
        long j16 = j14;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        TextLabelStyle title$default = DefaultTextLabelStyle.title$default(DefaultTextLabelStyle.INSTANCE, str, num, 0, (Font) null, fontWeight, 0, (Padding) null, 0, (Integer) null, imageStyle, imageStyle2, 492, (Object) null);
        ContainerStyle containerStyle = r30;
        ContainerStyle containerStyle2 = new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, margin, 127, (DefaultConstructorMarker) null);
        return new ButtonStyle(j15, j16, j11, j13, shape, cornerRadius, borderStroke, (ButtonElevation) null, padding, title$default, containerStyle, 128, (DefaultConstructorMarker) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid() {
        return lightSolid$default(this, (String) null, (Integer) null, 0, 0, 0, 0, (Shape) null, (CornerRadius) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 8191, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightSolid$default(this, str, (Integer) null, 0, 0, 0, 0, (Shape) null, (CornerRadius) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 8190, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightSolid$default(this, str, num, 0, 0, 0, 0, (Shape) null, (CornerRadius) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 8188, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightSolid$default(this, str, num, j11, 0, 0, 0, (Shape) null, (CornerRadius) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 8184, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightSolid$default(this, str, num, j11, j12, 0, 0, (Shape) null, (CornerRadius) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 8176, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightSolid$default(this, str, num, j11, j12, j13, 0, (Shape) null, (CornerRadius) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 8160, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14) {
        Intrinsics.checkNotNullParameter(str, "text");
        return lightSolid$default(this, str, num, j11, j12, j13, j14, (Shape) null, (CornerRadius) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 8128, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return lightSolid$default(this, str, num, j11, j12, j13, j14, shape, (CornerRadius) null, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 8064, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        return lightSolid$default(this, str, num, j11, j12, j13, j14, shape, cornerRadius, (Padding) null, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 7936, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @NotNull Padding padding) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        return lightSolid$default(this, str, num, j11, j12, j13, j14, shape, cornerRadius, padding, (ImageStyle) null, (ImageStyle) null, (Margin) null, (FontWeight) null, 7680, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @NotNull Padding padding, @Nullable ImageStyle imageStyle) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        return lightSolid$default(this, str, num, j11, j12, j13, j14, shape, cornerRadius, padding, imageStyle, (ImageStyle) null, (Margin) null, (FontWeight) null, 7168, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @NotNull Padding padding, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        return lightSolid$default(this, str2, num, j11, j12, j13, j14, shape, cornerRadius, padding, imageStyle, imageStyle2, (Margin) null, (FontWeight) null, 6144, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @NotNull Padding padding, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2, @Nullable Margin margin) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        return lightSolid$default(this, str2, num, j11, j12, j13, j14, shape, cornerRadius, padding, imageStyle, imageStyle2, margin, (FontWeight) null, 4096, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ButtonStyle lightSolid(@NotNull String str, @Nullable @StringRes Integer num, long j11, long j12, long j13, long j14, @NotNull Shape shape, @NotNull CornerRadius cornerRadius, @NotNull Padding padding, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2, @Nullable Margin margin, @NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return lightOutline(str, num, j11, j12, j13, j14, shape, cornerRadius, (BorderStroke) null, padding, imageStyle, imageStyle2, margin, fontWeight);
    }
}
