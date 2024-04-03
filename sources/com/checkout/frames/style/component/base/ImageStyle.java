package com.checkout.frames.style.component.base;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.Padding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\f¨\u0006\""}, d2 = {"Lcom/checkout/frames/style/component/base/ImageStyle;", "", "image", "", "tinColor", "", "height", "width", "padding", "Lcom/checkout/frames/model/Padding;", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/checkout/frames/model/Padding;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "getPadding", "()Lcom/checkout/frames/model/Padding;", "getTinColor", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/checkout/frames/model/Padding;)Lcom/checkout/frames/style/component/base/ImageStyle;", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageStyle {
    public static final int $stable = 0;
    @Nullable
    private final Integer height;
    @Nullable
    private final Integer image;
    @Nullable
    private final Padding padding;
    @Nullable
    private final Long tinColor;
    @Nullable
    private final Integer width;

    @JvmOverloads
    public ImageStyle() {
        this((Integer) null, (Long) null, (Integer) null, (Integer) null, (Padding) null, 31, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageStyle(@Nullable @DrawableRes Integer num) {
        this(num, (Long) null, (Integer) null, (Integer) null, (Padding) null, 30, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageStyle(@Nullable @DrawableRes Integer num, @Nullable Long l11) {
        this(num, l11, (Integer) null, (Integer) null, (Padding) null, 28, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageStyle(@Nullable @DrawableRes Integer num, @Nullable Long l11, @Nullable Integer num2) {
        this(num, l11, num2, (Integer) null, (Padding) null, 24, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageStyle(@Nullable @DrawableRes Integer num, @Nullable Long l11, @Nullable Integer num2, @Nullable Integer num3) {
        this(num, l11, num2, num3, (Padding) null, 16, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageStyle(@Nullable @DrawableRes Integer num, @Nullable Long l11, @Nullable Integer num2, @Nullable Integer num3, @Nullable Padding padding2) {
        this.image = num;
        this.tinColor = l11;
        this.height = num2;
        this.width = num3;
        this.padding = padding2;
    }

    public static /* synthetic */ ImageStyle copy$default(ImageStyle imageStyle, Integer num, Long l11, Integer num2, Integer num3, Padding padding2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = imageStyle.image;
        }
        if ((i11 & 2) != 0) {
            l11 = imageStyle.tinColor;
        }
        Long l12 = l11;
        if ((i11 & 4) != 0) {
            num2 = imageStyle.height;
        }
        Integer num4 = num2;
        if ((i11 & 8) != 0) {
            num3 = imageStyle.width;
        }
        Integer num5 = num3;
        if ((i11 & 16) != 0) {
            padding2 = imageStyle.padding;
        }
        return imageStyle.copy(num, l12, num4, num5, padding2);
    }

    @Nullable
    public final Integer component1() {
        return this.image;
    }

    @Nullable
    public final Long component2() {
        return this.tinColor;
    }

    @Nullable
    public final Integer component3() {
        return this.height;
    }

    @Nullable
    public final Integer component4() {
        return this.width;
    }

    @Nullable
    public final Padding component5() {
        return this.padding;
    }

    @NotNull
    public final ImageStyle copy(@Nullable @DrawableRes Integer num, @Nullable Long l11, @Nullable Integer num2, @Nullable Integer num3, @Nullable Padding padding2) {
        return new ImageStyle(num, l11, num2, num3, padding2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageStyle)) {
            return false;
        }
        ImageStyle imageStyle = (ImageStyle) obj;
        return Intrinsics.areEqual((Object) this.image, (Object) imageStyle.image) && Intrinsics.areEqual((Object) this.tinColor, (Object) imageStyle.tinColor) && Intrinsics.areEqual((Object) this.height, (Object) imageStyle.height) && Intrinsics.areEqual((Object) this.width, (Object) imageStyle.width) && Intrinsics.areEqual((Object) this.padding, (Object) imageStyle.padding);
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final Integer getImage() {
        return this.image;
    }

    @Nullable
    public final Padding getPadding() {
        return this.padding;
    }

    @Nullable
    public final Long getTinColor() {
        return this.tinColor;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        Integer num = this.image;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l11 = this.tinColor;
        int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num2 = this.height;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.width;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Padding padding2 = this.padding;
        if (padding2 != null) {
            i11 = padding2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.image;
        Long l11 = this.tinColor;
        Integer num2 = this.height;
        Integer num3 = this.width;
        Padding padding2 = this.padding;
        return "ImageStyle(image=" + num + ", tinColor=" + l11 + ", height=" + num2 + ", width=" + num3 + ", padding=" + padding2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImageStyle(java.lang.Integer r5, java.lang.Long r6, java.lang.Integer r7, java.lang.Integer r8, com.checkout.frames.model.Padding r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ImageStyle.<init>(java.lang.Integer, java.lang.Long, java.lang.Integer, java.lang.Integer, com.checkout.frames.model.Padding, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
