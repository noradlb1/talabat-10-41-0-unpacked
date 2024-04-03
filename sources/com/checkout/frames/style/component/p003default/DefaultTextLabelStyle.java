package com.checkout.frames.style.component.p003default;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
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
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.utils.constants.ErrorConstants;
import com.checkout.frames.utils.constants.HeaderTitleConstants;
import com.checkout.frames.utils.constants.SubtitleConstants;
import com.checkout.frames.utils.constants.TextConstants;
import com.checkout.frames.utils.constants.TitleConstants;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007JX\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u000eH\u0007Ja\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0019Ja\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0019J\u0001\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultTextLabelStyle;", "", "()V", "error", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "fontSize", "", "font", "Lcom/checkout/frames/model/font/Font;", "color", "", "leadingIconSize", "leadingIconId", "padding", "Lcom/checkout/frames/model/Padding;", "headerTitle", "fontWeight", "Lcom/checkout/frames/model/font/FontWeight;", "maxLines", "leadingIconPadding", "subtitle", "text", "", "textId", "lineHeight", "(Ljava/lang/String;Ljava/lang/Integer;ILcom/checkout/frames/model/font/Font;JLcom/checkout/frames/model/Padding;ILjava/lang/Integer;)Lcom/checkout/frames/style/component/base/TextLabelStyle;", "title", "leadingIconStyle", "Lcom/checkout/frames/style/component/base/ImageStyle;", "trailingIconStyle", "(Ljava/lang/String;Ljava/lang/Integer;ILcom/checkout/frames/model/font/Font;Lcom/checkout/frames/model/font/FontWeight;JLcom/checkout/frames/model/Padding;ILjava/lang/Integer;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/style/component/base/ImageStyle;)Lcom/checkout/frames/style/component/base/TextLabelStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultTextLabelStyle  reason: invalid package */
public final class DefaultTextLabelStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultTextLabelStyle INSTANCE = new DefaultTextLabelStyle();

    private DefaultTextLabelStyle() {
    }

    public static /* synthetic */ TextLabelStyle error$default(DefaultTextLabelStyle defaultTextLabelStyle, int i11, Font font, long j11, int i12, int i13, Padding padding, int i14, Object obj) {
        int i15;
        Font font2;
        long j12;
        int i16;
        int i17;
        Padding padding2;
        if ((i14 & 1) != 0) {
            i15 = 13;
        } else {
            i15 = i11;
        }
        if ((i14 & 2) != 0) {
            font2 = ErrorConstants.INSTANCE.getFont();
        } else {
            font2 = font;
        }
        if ((i14 & 4) != 0) {
            j12 = 4289538110L;
        } else {
            j12 = j11;
        }
        if ((i14 & 8) != 0) {
            i16 = 15;
        } else {
            i16 = i12;
        }
        if ((i14 & 16) != 0) {
            i17 = R.drawable.cko_ic_error;
        } else {
            i17 = i13;
        }
        if ((i14 & 32) != 0) {
            padding2 = new Padding(8, 0, 0, 0, 14, (DefaultConstructorMarker) null);
        } else {
            padding2 = padding;
        }
        return defaultTextLabelStyle.error(i15, font2, j12, i16, i17, padding2);
    }

    public static /* synthetic */ TextLabelStyle headerTitle$default(DefaultTextLabelStyle defaultTextLabelStyle, int i11, FontWeight fontWeight, Font font, long j11, Padding padding, int i12, int i13, Padding padding2, int i14, Object obj) {
        int i15;
        FontWeight fontWeight2;
        Font font2;
        long j12;
        Padding padding3;
        int i16;
        int i17;
        Padding padding4;
        int i18 = i14;
        if ((i18 & 1) != 0) {
            i15 = 20;
        } else {
            i15 = i11;
        }
        if ((i18 & 2) != 0) {
            fontWeight2 = FontWeight.Normal;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((i18 & 4) != 0) {
            font2 = HeaderTitleConstants.INSTANCE.getFont();
        } else {
            font2 = font;
        }
        if ((i18 & 8) != 0) {
            j12 = 4279505940L;
        } else {
            j12 = j11;
        }
        if ((i18 & 16) != 0) {
            padding3 = new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
        } else {
            padding3 = padding;
        }
        if ((i18 & 32) != 0) {
            i16 = 1;
        } else {
            i16 = i12;
        }
        if ((i18 & 64) != 0) {
            i17 = 14;
        } else {
            i17 = i13;
        }
        if ((i18 & 128) != 0) {
            padding4 = new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
        } else {
            padding4 = padding2;
        }
        return defaultTextLabelStyle.headerTitle(i15, fontWeight2, font2, j12, padding3, i16, i17, padding4);
    }

    public static /* synthetic */ TextLabelStyle subtitle$default(DefaultTextLabelStyle defaultTextLabelStyle, String str, Integer num, int i11, Font font, long j11, Padding padding, int i12, Integer num2, int i13, Object obj) {
        String str2;
        Integer num3;
        int i14;
        Font font2;
        long j12;
        Padding padding2;
        int i15;
        int i16 = i13;
        if ((i16 & 1) != 0) {
            str2 = "";
        } else {
            str2 = str;
        }
        Integer num4 = null;
        if ((i16 & 2) != 0) {
            num3 = null;
        } else {
            num3 = num;
        }
        if ((i16 & 4) != 0) {
            i14 = 13;
        } else {
            i14 = i11;
        }
        if ((i16 & 8) != 0) {
            font2 = SubtitleConstants.INSTANCE.getFont();
        } else {
            font2 = font;
        }
        if ((i16 & 16) != 0) {
            j12 = 4285690482L;
        } else {
            j12 = j11;
        }
        if ((i16 & 32) != 0) {
            padding2 = new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
        } else {
            padding2 = padding;
        }
        if ((i16 & 64) != 0) {
            i15 = Integer.MAX_VALUE;
        } else {
            i15 = i12;
        }
        if ((i16 & 128) == 0) {
            num4 = num2;
        }
        return defaultTextLabelStyle.subtitle(str2, num3, i14, font2, j12, padding2, i15, num4);
    }

    public static /* synthetic */ TextLabelStyle text$default(DefaultTextLabelStyle defaultTextLabelStyle, String str, Integer num, int i11, Font font, long j11, Padding padding, int i12, Integer num2, int i13, Object obj) {
        String str2;
        Integer num3;
        int i14;
        Font font2;
        long j12;
        Padding padding2;
        int i15;
        int i16 = i13;
        if ((i16 & 1) != 0) {
            str2 = "";
        } else {
            str2 = str;
        }
        Integer num4 = null;
        if ((i16 & 2) != 0) {
            num3 = null;
        } else {
            num3 = num;
        }
        if ((i16 & 4) != 0) {
            i14 = 15;
        } else {
            i14 = i11;
        }
        if ((i16 & 8) != 0) {
            font2 = TextConstants.INSTANCE.getFont();
        } else {
            font2 = font;
        }
        if ((i16 & 16) != 0) {
            j12 = 4279505940L;
        } else {
            j12 = j11;
        }
        if ((i16 & 32) != 0) {
            padding2 = new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
        } else {
            padding2 = padding;
        }
        if ((i16 & 64) != 0) {
            i15 = Integer.MAX_VALUE;
        } else {
            i15 = i12;
        }
        if ((i16 & 128) == 0) {
            num4 = num2;
        }
        return defaultTextLabelStyle.text(str2, num3, i14, font2, j12, padding2, i15, num4);
    }

    public static /* synthetic */ TextLabelStyle title$default(DefaultTextLabelStyle defaultTextLabelStyle, String str, Integer num, int i11, Font font, FontWeight fontWeight, long j11, Padding padding, int i12, Integer num2, ImageStyle imageStyle, ImageStyle imageStyle2, int i13, Object obj) {
        int i14 = i13;
        String str2 = (i14 & 1) != 0 ? "" : str;
        ImageStyle imageStyle3 = null;
        Integer num3 = (i14 & 2) != 0 ? null : num;
        int i15 = (i14 & 4) != 0 ? 15 : i11;
        Font font2 = (i14 & 8) != 0 ? TitleConstants.INSTANCE.getFont() : font;
        FontWeight fontWeight2 = (i14 & 16) != 0 ? FontWeight.Normal : fontWeight;
        long j12 = (i14 & 32) != 0 ? 4279505940L : j11;
        Padding padding2 = (i14 & 64) != 0 ? new Padding(0, 0, 0, 0, 15, (DefaultConstructorMarker) null) : padding;
        int i16 = (i14 & 128) != 0 ? 1 : i12;
        Integer num4 = (i14 & 256) != 0 ? null : num2;
        ImageStyle imageStyle4 = (i14 & 512) != 0 ? null : imageStyle;
        if ((i14 & 1024) == 0) {
            imageStyle3 = imageStyle2;
        }
        return defaultTextLabelStyle.title(str2, num3, i15, font2, fontWeight2, j12, padding2, i16, num4, imageStyle4, imageStyle3);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle error() {
        return error$default(this, 0, (Font) null, 0, 0, 0, (Padding) null, 63, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle error(int i11) {
        return error$default(this, i11, (Font) null, 0, 0, 0, (Padding) null, 62, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle error(int i11, @NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        return error$default(this, i11, font, 0, 0, 0, (Padding) null, 60, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle error(int i11, @NotNull Font font, long j11) {
        Intrinsics.checkNotNullParameter(font, "font");
        return error$default(this, i11, font, j11, 0, 0, (Padding) null, 56, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle error(int i11, @NotNull Font font, long j11, int i12) {
        Intrinsics.checkNotNullParameter(font, "font");
        return error$default(this, i11, font, j11, i12, 0, (Padding) null, 48, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle error(int i11, @NotNull Font font, long j11, int i12, @DrawableRes int i13) {
        Intrinsics.checkNotNullParameter(font, "font");
        return error$default(this, i11, font, j11, i12, i13, (Padding) null, 32, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle error(int i11, @NotNull Font font, long j11, int i12, @DrawableRes int i13, @NotNull Padding padding) {
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Intrinsics.checkNotNullParameter(padding, Param.PADDING);
        return new TextLabelStyle((String) null, (Integer) null, new TextStyle(i11, j11, (TextAlign) null, font2, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 500, (DefaultConstructorMarker) null), new ImageStyle(Integer.valueOf(i13), Long.valueOf(j11), Integer.valueOf(i12), Integer.valueOf(i12), new Padding(0, 0, 0, 8, 7, (DefaultConstructorMarker) null)), (ImageStyle) null, new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, padding, (Margin) null, Opcodes.ATHROW, (DefaultConstructorMarker) null), 19, (DefaultConstructorMarker) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle() {
        return headerTitle$default(this, 0, (FontWeight) null, (Font) null, 0, (Padding) null, 0, 0, (Padding) null, 255, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle(int i11) {
        return headerTitle$default(this, i11, (FontWeight) null, (Font) null, 0, (Padding) null, 0, 0, (Padding) null, 254, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle(int i11, @NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return headerTitle$default(this, i11, fontWeight, (Font) null, 0, (Padding) null, 0, 0, (Padding) null, 252, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle(int i11, @NotNull FontWeight fontWeight, @NotNull Font font) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return headerTitle$default(this, i11, fontWeight, font2, 0, (Padding) null, 0, 0, (Padding) null, 248, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle(int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return headerTitle$default(this, i11, fontWeight, font2, j11, (Padding) null, 0, 0, (Padding) null, PsExtractor.VIDEO_STREAM_MASK, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle(int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return headerTitle$default(this, i11, fontWeight, font2, j11, padding2, 0, 0, (Padding) null, 224, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle(int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding, int i12) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return headerTitle$default(this, i11, fontWeight, font2, j11, padding2, i12, 0, (Padding) null, 192, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle(int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding, int i12, int i13) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return headerTitle$default(this, i11, fontWeight, font2, j11, padding2, i12, i13, (Padding) null, 128, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle headerTitle(int i11, @NotNull FontWeight fontWeight, @NotNull Font font, long j11, @NotNull Padding padding, int i12, int i13, @NotNull Padding padding2) {
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Intrinsics.checkNotNullParameter(padding, Param.PADDING);
        Intrinsics.checkNotNullParameter(padding2, "leadingIconPadding");
        return new TextLabelStyle((String) null, (Integer) null, new TextStyle(i11, j11, (TextAlign) null, font2, (FontStyle) null, fontWeight2, i12, (Integer) null, (Integer) null, 404, (DefaultConstructorMarker) null), new ImageStyle((Integer) null, Long.valueOf(j11), Integer.valueOf(i13), Integer.valueOf(i13), padding2, 1, (DefaultConstructorMarker) null), (ImageStyle) null, new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, padding, (Margin) null, Opcodes.ATHROW, (DefaultConstructorMarker) null), 19, (DefaultConstructorMarker) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle() {
        return subtitle$default(this, (String) null, (Integer) null, 0, (Font) null, 0, (Padding) null, 0, (Integer) null, 255, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return subtitle$default(this, str, (Integer) null, 0, (Font) null, 0, (Padding) null, 0, (Integer) null, 254, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle(@NotNull String str, @Nullable @StringRes Integer num) {
        Intrinsics.checkNotNullParameter(str, "text");
        return subtitle$default(this, str, num, 0, (Font) null, 0, (Padding) null, 0, (Integer) null, 252, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle(@NotNull String str, @Nullable @StringRes Integer num, int i11) {
        Intrinsics.checkNotNullParameter(str, "text");
        return subtitle$default(this, str, num, i11, (Font) null, 0, (Padding) null, 0, (Integer) null, 248, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return subtitle$default(this, str, num, i11, font2, 0, (Padding) null, 0, (Integer) null, PsExtractor.VIDEO_STREAM_MASK, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, long j11) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return subtitle$default(this, str, num, i11, font2, j11, (Padding) null, 0, (Integer) null, 224, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, long j11, @NotNull Padding padding) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return subtitle$default(this, str, num, i11, font2, j11, padding2, 0, (Integer) null, 192, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, long j11, @NotNull Padding padding, int i12) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return subtitle$default(this, str, num, i11, font2, j11, padding2, i12, (Integer) null, 128, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle subtitle(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, long j11, @NotNull Padding padding, int i12, @Nullable Integer num2) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(padding, Param.PADDING);
        return new TextLabelStyle(str2, num, new TextStyle(i11, j11, (TextAlign) null, font, (FontStyle) null, (FontWeight) null, i12, (Integer) null, num2, 180, (DefaultConstructorMarker) null), (ImageStyle) null, (ImageStyle) null, new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, padding, (Margin) null, Opcodes.ATHROW, (DefaultConstructorMarker) null), 24, (DefaultConstructorMarker) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text() {
        return text$default(this, (String) null, (Integer) null, 0, (Font) null, 0, (Padding) null, 0, (Integer) null, 255, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return text$default(this, str, (Integer) null, 0, (Font) null, 0, (Padding) null, 0, (Integer) null, 254, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text(@NotNull String str, @Nullable @StringRes Integer num) {
        Intrinsics.checkNotNullParameter(str, "text");
        return text$default(this, str, num, 0, (Font) null, 0, (Padding) null, 0, (Integer) null, 252, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text(@NotNull String str, @Nullable @StringRes Integer num, int i11) {
        Intrinsics.checkNotNullParameter(str, "text");
        return text$default(this, str, num, i11, (Font) null, 0, (Padding) null, 0, (Integer) null, 248, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return text$default(this, str, num, i11, font2, 0, (Padding) null, 0, (Integer) null, PsExtractor.VIDEO_STREAM_MASK, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, long j11) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return text$default(this, str, num, i11, font2, j11, (Padding) null, 0, (Integer) null, 224, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, long j11, @NotNull Padding padding) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return text$default(this, str, num, i11, font2, j11, padding2, 0, (Integer) null, 192, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, long j11, @NotNull Padding padding, int i12) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return text$default(this, str, num, i11, font2, j11, padding2, i12, (Integer) null, 128, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle text(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, long j11, @NotNull Padding padding, int i12, @Nullable Integer num2) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(padding, Param.PADDING);
        return new TextLabelStyle(str2, num, new TextStyle(i11, j11, (TextAlign) null, font, (FontStyle) null, (FontWeight) null, i12, (Integer) null, num2, 180, (DefaultConstructorMarker) null), (ImageStyle) null, (ImageStyle) null, new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, padding, (Margin) null, Opcodes.ATHROW, (DefaultConstructorMarker) null), 24, (DefaultConstructorMarker) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title() {
        return title$default(this, (String) null, (Integer) null, 0, (Font) null, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2047, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        return title$default(this, str2, (Integer) null, 0, (Font) null, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2046, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        return title$default(this, str2, num, 0, (Font) null, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2044, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        return title$default(this, str2, num, i11, (Font) null, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2040, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        return title$default(this, str2, num, i11, font2, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2032, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, @NotNull FontWeight fontWeight) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return title$default(this, str2, num, i11, font2, fontWeight2, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2016, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, @NotNull FontWeight fontWeight, long j11) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return title$default(this, str2, num, i11, font2, fontWeight2, j11, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 1984, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, @NotNull FontWeight fontWeight, long j11, @NotNull Padding padding) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return title$default(this, str2, num, i11, font2, fontWeight2, j11, padding2, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 1920, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, @NotNull FontWeight fontWeight, long j11, @NotNull Padding padding, int i12) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return title$default(this, str2, num, i11, font2, fontWeight2, j11, padding2, i12, (Integer) null, (ImageStyle) null, (ImageStyle) null, 1792, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, @NotNull FontWeight fontWeight, long j11, @NotNull Padding padding, int i12, @Nullable Integer num2) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return title$default(this, str2, num, i11, font2, fontWeight2, j11, padding2, i12, num2, (ImageStyle) null, (ImageStyle) null, 1536, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, @NotNull FontWeight fontWeight, long j11, @NotNull Padding padding, int i12, @Nullable Integer num2, @Nullable ImageStyle imageStyle) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, Param.PADDING);
        return title$default(this, str2, num, i11, font2, fontWeight2, j11, padding2, i12, num2, imageStyle, (ImageStyle) null, 1024, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final TextLabelStyle title(@NotNull String str, @Nullable @StringRes Integer num, int i11, @NotNull Font font, @NotNull FontWeight fontWeight, long j11, @NotNull Padding padding, int i12, @Nullable Integer num2, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font2, "font");
        FontWeight fontWeight2 = fontWeight;
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Intrinsics.checkNotNullParameter(padding, Param.PADDING);
        return new TextLabelStyle(str, num, new TextStyle(i11, j11, (TextAlign) null, font2, (FontStyle) null, fontWeight2, i12, (Integer) null, num2, 148, (DefaultConstructorMarker) null), imageStyle, imageStyle2, new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, padding, (Margin) null, Opcodes.ATHROW, (DefaultConstructorMarker) null));
    }
}
