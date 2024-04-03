package com.deliveryhero.fluid.widgets.utils;

import android.graphics.drawable.Drawable;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.values.Color;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\f\b\u0002\u0010\r\u001a\u00060\u000ej\u0002`\u000f\u0012\f\b\u0002\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f\u0012\f\b\u0002\u0010\u0011\u001a\u00060\u000ej\u0002`\u000f\u0012\f\b\u0002\u0010\u0012\u001a\u00060\u000ej\u0002`\u000f\u0012\f\b\u0002\u0010\u0013\u001a\u00060\tj\u0002`\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\r\u0010C\u001a\u00060\u000ej\u0002`\u000fHÆ\u0003J\r\u0010D\u001a\u00060\tj\u0002`\u0014HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010>J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\r\u0010L\u001a\u00060\u000ej\u0002`\u000fHÆ\u0003J\r\u0010M\u001a\u00060\u000ej\u0002`\u000fHÆ\u0003J\r\u0010N\u001a\u00060\u000ej\u0002`\u000fHÆ\u0003Jº\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\f\b\u0002\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\f\b\u0002\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\f\b\u0002\u0010\u0011\u001a\u00060\u000ej\u0002`\u000f2\f\b\u0002\u0010\u0012\u001a\u00060\u000ej\u0002`\u000f2\f\b\u0002\u0010\u0013\u001a\u00060\tj\u0002`\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010T\u001a\u00020\tHÖ\u0001J\t\u0010U\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0012\u001a\u00060\u000ej\u0002`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u0011\u001a\u00060\u000ej\u0002`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001e\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001e\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0013\u001a\u00060\tj\u0002`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001cR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006V"}, d2 = {"Lcom/deliveryhero/fluid/widgets/utils/WidgetTags;", "", "defaultBackground", "Landroid/graphics/drawable/Drawable;", "onClickUrl", "", "accessibilityId", "lottieUrl", "textAppearanceId", "", "backgroundColors", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundCornerRadiusTopLeft", "", "Lcom/deliveryhero/fluid/values/Pixel;", "backgroundCornerRadiusTopRight", "backgroundCornerRadiusBottomRight", "backgroundCornerRadiusBottomLeft", "borderWidth", "Lcom/deliveryhero/fluid/values/PixelInt;", "borderColor", "dataHolder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;FFFFILcom/deliveryhero/fluid/values/Color;Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;)V", "getAccessibilityId", "()Ljava/lang/String;", "setAccessibilityId", "(Ljava/lang/String;)V", "getBackgroundColors", "()Ljava/util/List;", "setBackgroundColors", "(Ljava/util/List;)V", "getBackgroundCornerRadiusBottomLeft", "()F", "setBackgroundCornerRadiusBottomLeft", "(F)V", "getBackgroundCornerRadiusBottomRight", "setBackgroundCornerRadiusBottomRight", "getBackgroundCornerRadiusTopLeft", "setBackgroundCornerRadiusTopLeft", "getBackgroundCornerRadiusTopRight", "setBackgroundCornerRadiusTopRight", "getBorderColor", "()Lcom/deliveryhero/fluid/values/Color;", "setBorderColor", "(Lcom/deliveryhero/fluid/values/Color;)V", "getBorderWidth", "()I", "setBorderWidth", "(I)V", "getDataHolder", "()Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "setDataHolder", "(Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;)V", "getDefaultBackground", "()Landroid/graphics/drawable/Drawable;", "getLottieUrl", "setLottieUrl", "getOnClickUrl", "setOnClickUrl", "getTextAppearanceId", "()Ljava/lang/Integer;", "setTextAppearanceId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;FFFFILcom/deliveryhero/fluid/values/Color;Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;)Lcom/deliveryhero/fluid/widgets/utils/WidgetTags;", "equals", "", "other", "hashCode", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WidgetTags {
    @Nullable
    private String accessibilityId;
    @Nullable
    private List<Color> backgroundColors;
    private float backgroundCornerRadiusBottomLeft;
    private float backgroundCornerRadiusBottomRight;
    private float backgroundCornerRadiusTopLeft;
    private float backgroundCornerRadiusTopRight;
    @Nullable
    private Color borderColor;
    private int borderWidth;
    @Nullable
    private TemplateUiDataHolder dataHolder;
    @Nullable
    private final Drawable defaultBackground;
    @Nullable
    private String lottieUrl;
    @Nullable
    private String onClickUrl;
    @Nullable
    private Integer textAppearanceId;

    public WidgetTags(@Nullable Drawable drawable, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable List<Color> list, float f11, float f12, float f13, float f14, int i11, @Nullable Color color, @Nullable TemplateUiDataHolder templateUiDataHolder) {
        this.defaultBackground = drawable;
        this.onClickUrl = str;
        this.accessibilityId = str2;
        this.lottieUrl = str3;
        this.textAppearanceId = num;
        this.backgroundColors = list;
        this.backgroundCornerRadiusTopLeft = f11;
        this.backgroundCornerRadiusTopRight = f12;
        this.backgroundCornerRadiusBottomRight = f13;
        this.backgroundCornerRadiusBottomLeft = f14;
        this.borderWidth = i11;
        this.borderColor = color;
        this.dataHolder = templateUiDataHolder;
    }

    public static /* synthetic */ WidgetTags copy$default(WidgetTags widgetTags, Drawable drawable, String str, String str2, String str3, Integer num, List list, float f11, float f12, float f13, float f14, int i11, Color color, TemplateUiDataHolder templateUiDataHolder, int i12, Object obj) {
        WidgetTags widgetTags2 = widgetTags;
        int i13 = i12;
        return widgetTags.copy((i13 & 1) != 0 ? widgetTags2.defaultBackground : drawable, (i13 & 2) != 0 ? widgetTags2.onClickUrl : str, (i13 & 4) != 0 ? widgetTags2.accessibilityId : str2, (i13 & 8) != 0 ? widgetTags2.lottieUrl : str3, (i13 & 16) != 0 ? widgetTags2.textAppearanceId : num, (i13 & 32) != 0 ? widgetTags2.backgroundColors : list, (i13 & 64) != 0 ? widgetTags2.backgroundCornerRadiusTopLeft : f11, (i13 & 128) != 0 ? widgetTags2.backgroundCornerRadiusTopRight : f12, (i13 & 256) != 0 ? widgetTags2.backgroundCornerRadiusBottomRight : f13, (i13 & 512) != 0 ? widgetTags2.backgroundCornerRadiusBottomLeft : f14, (i13 & 1024) != 0 ? widgetTags2.borderWidth : i11, (i13 & 2048) != 0 ? widgetTags2.borderColor : color, (i13 & 4096) != 0 ? widgetTags2.dataHolder : templateUiDataHolder);
    }

    @Nullable
    public final Drawable component1() {
        return this.defaultBackground;
    }

    public final float component10() {
        return this.backgroundCornerRadiusBottomLeft;
    }

    public final int component11() {
        return this.borderWidth;
    }

    @Nullable
    public final Color component12() {
        return this.borderColor;
    }

    @Nullable
    public final TemplateUiDataHolder component13() {
        return this.dataHolder;
    }

    @Nullable
    public final String component2() {
        return this.onClickUrl;
    }

    @Nullable
    public final String component3() {
        return this.accessibilityId;
    }

    @Nullable
    public final String component4() {
        return this.lottieUrl;
    }

    @Nullable
    public final Integer component5() {
        return this.textAppearanceId;
    }

    @Nullable
    public final List<Color> component6() {
        return this.backgroundColors;
    }

    public final float component7() {
        return this.backgroundCornerRadiusTopLeft;
    }

    public final float component8() {
        return this.backgroundCornerRadiusTopRight;
    }

    public final float component9() {
        return this.backgroundCornerRadiusBottomRight;
    }

    @NotNull
    public final WidgetTags copy(@Nullable Drawable drawable, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable List<Color> list, float f11, float f12, float f13, float f14, int i11, @Nullable Color color, @Nullable TemplateUiDataHolder templateUiDataHolder) {
        return new WidgetTags(drawable, str, str2, str3, num, list, f11, f12, f13, f14, i11, color, templateUiDataHolder);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WidgetTags)) {
            return false;
        }
        WidgetTags widgetTags = (WidgetTags) obj;
        return Intrinsics.areEqual((Object) this.defaultBackground, (Object) widgetTags.defaultBackground) && Intrinsics.areEqual((Object) this.onClickUrl, (Object) widgetTags.onClickUrl) && Intrinsics.areEqual((Object) this.accessibilityId, (Object) widgetTags.accessibilityId) && Intrinsics.areEqual((Object) this.lottieUrl, (Object) widgetTags.lottieUrl) && Intrinsics.areEqual((Object) this.textAppearanceId, (Object) widgetTags.textAppearanceId) && Intrinsics.areEqual((Object) this.backgroundColors, (Object) widgetTags.backgroundColors) && Intrinsics.areEqual((Object) Float.valueOf(this.backgroundCornerRadiusTopLeft), (Object) Float.valueOf(widgetTags.backgroundCornerRadiusTopLeft)) && Intrinsics.areEqual((Object) Float.valueOf(this.backgroundCornerRadiusTopRight), (Object) Float.valueOf(widgetTags.backgroundCornerRadiusTopRight)) && Intrinsics.areEqual((Object) Float.valueOf(this.backgroundCornerRadiusBottomRight), (Object) Float.valueOf(widgetTags.backgroundCornerRadiusBottomRight)) && Intrinsics.areEqual((Object) Float.valueOf(this.backgroundCornerRadiusBottomLeft), (Object) Float.valueOf(widgetTags.backgroundCornerRadiusBottomLeft)) && this.borderWidth == widgetTags.borderWidth && Intrinsics.areEqual((Object) this.borderColor, (Object) widgetTags.borderColor) && Intrinsics.areEqual((Object) this.dataHolder, (Object) widgetTags.dataHolder);
    }

    @Nullable
    public final String getAccessibilityId() {
        return this.accessibilityId;
    }

    @Nullable
    public final List<Color> getBackgroundColors() {
        return this.backgroundColors;
    }

    public final float getBackgroundCornerRadiusBottomLeft() {
        return this.backgroundCornerRadiusBottomLeft;
    }

    public final float getBackgroundCornerRadiusBottomRight() {
        return this.backgroundCornerRadiusBottomRight;
    }

    public final float getBackgroundCornerRadiusTopLeft() {
        return this.backgroundCornerRadiusTopLeft;
    }

    public final float getBackgroundCornerRadiusTopRight() {
        return this.backgroundCornerRadiusTopRight;
    }

    @Nullable
    public final Color getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final TemplateUiDataHolder getDataHolder() {
        return this.dataHolder;
    }

    @Nullable
    public final Drawable getDefaultBackground() {
        return this.defaultBackground;
    }

    @Nullable
    public final String getLottieUrl() {
        return this.lottieUrl;
    }

    @Nullable
    public final String getOnClickUrl() {
        return this.onClickUrl;
    }

    @Nullable
    public final Integer getTextAppearanceId() {
        return this.textAppearanceId;
    }

    public int hashCode() {
        Drawable drawable = this.defaultBackground;
        int i11 = 0;
        int hashCode = (drawable == null ? 0 : drawable.hashCode()) * 31;
        String str = this.onClickUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.accessibilityId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lottieUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.textAppearanceId;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        List<Color> list = this.backgroundColors;
        int hashCode6 = (((((((((((hashCode5 + (list == null ? 0 : list.hashCode())) * 31) + Float.floatToIntBits(this.backgroundCornerRadiusTopLeft)) * 31) + Float.floatToIntBits(this.backgroundCornerRadiusTopRight)) * 31) + Float.floatToIntBits(this.backgroundCornerRadiusBottomRight)) * 31) + Float.floatToIntBits(this.backgroundCornerRadiusBottomLeft)) * 31) + this.borderWidth) * 31;
        Color color = this.borderColor;
        int hashCode7 = (hashCode6 + (color == null ? 0 : color.hashCode())) * 31;
        TemplateUiDataHolder templateUiDataHolder = this.dataHolder;
        if (templateUiDataHolder != null) {
            i11 = templateUiDataHolder.hashCode();
        }
        return hashCode7 + i11;
    }

    public final void setAccessibilityId(@Nullable String str) {
        this.accessibilityId = str;
    }

    public final void setBackgroundColors(@Nullable List<Color> list) {
        this.backgroundColors = list;
    }

    public final void setBackgroundCornerRadiusBottomLeft(float f11) {
        this.backgroundCornerRadiusBottomLeft = f11;
    }

    public final void setBackgroundCornerRadiusBottomRight(float f11) {
        this.backgroundCornerRadiusBottomRight = f11;
    }

    public final void setBackgroundCornerRadiusTopLeft(float f11) {
        this.backgroundCornerRadiusTopLeft = f11;
    }

    public final void setBackgroundCornerRadiusTopRight(float f11) {
        this.backgroundCornerRadiusTopRight = f11;
    }

    public final void setBorderColor(@Nullable Color color) {
        this.borderColor = color;
    }

    public final void setBorderWidth(int i11) {
        this.borderWidth = i11;
    }

    public final void setDataHolder(@Nullable TemplateUiDataHolder templateUiDataHolder) {
        this.dataHolder = templateUiDataHolder;
    }

    public final void setLottieUrl(@Nullable String str) {
        this.lottieUrl = str;
    }

    public final void setOnClickUrl(@Nullable String str) {
        this.onClickUrl = str;
    }

    public final void setTextAppearanceId(@Nullable Integer num) {
        this.textAppearanceId = num;
    }

    @NotNull
    public String toString() {
        return "WidgetTags(defaultBackground=" + this.defaultBackground + ", onClickUrl=" + this.onClickUrl + ", accessibilityId=" + this.accessibilityId + ", lottieUrl=" + this.lottieUrl + ", textAppearanceId=" + this.textAppearanceId + ", backgroundColors=" + this.backgroundColors + ", backgroundCornerRadiusTopLeft=" + this.backgroundCornerRadiusTopLeft + ", backgroundCornerRadiusTopRight=" + this.backgroundCornerRadiusTopRight + ", backgroundCornerRadiusBottomRight=" + this.backgroundCornerRadiusBottomRight + ", backgroundCornerRadiusBottomLeft=" + this.backgroundCornerRadiusBottomLeft + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", dataHolder=" + this.dataHolder + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WidgetTags(android.graphics.drawable.Drawable r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Integer r18, java.util.List r19, float r20, float r21, float r22, float r23, int r24, com.deliveryhero.fluid.values.Color r25, com.deliveryhero.fluid.template.data.TemplateUiDataHolder r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 64
            r8 = 0
            if (r7 == 0) goto L_0x0031
            r7 = r8
            goto L_0x0033
        L_0x0031:
            r7 = r20
        L_0x0033:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0039
            r9 = r8
            goto L_0x003b
        L_0x0039:
            r9 = r21
        L_0x003b:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0041
            r10 = r8
            goto L_0x0043
        L_0x0041:
            r10 = r22
        L_0x0043:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r8 = r23
        L_0x004a:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r2 = r26
        L_0x0061:
            r15 = r13
            r16 = r14
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r9
            r24 = r10
            r25 = r8
            r26 = r11
            r27 = r12
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.utils.WidgetTags.<init>(android.graphics.drawable.Drawable, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.List, float, float, float, float, int, com.deliveryhero.fluid.values.Color, com.deliveryhero.fluid.template.data.TemplateUiDataHolder, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
