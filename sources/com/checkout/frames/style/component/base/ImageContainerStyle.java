package com.checkout.frames.style.component.base;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/checkout/frames/style/component/base/ImageContainerStyle;", "", "mainAxisSpacing", "", "crossAxisSpacing", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "(IILcom/checkout/frames/style/component/base/ContainerStyle;)V", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "getCrossAxisSpacing", "()I", "getMainAxisSpacing", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageContainerStyle {
    public static final int $stable = 0;
    @NotNull
    private final ContainerStyle containerStyle;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;

    @JvmOverloads
    public ImageContainerStyle() {
        this(0, 0, (ContainerStyle) null, 7, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageContainerStyle(int i11) {
        this(i11, 0, (ContainerStyle) null, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageContainerStyle(int i11, int i12) {
        this(i11, i12, (ContainerStyle) null, 4, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageContainerStyle(int i11, int i12, @NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        this.mainAxisSpacing = i11;
        this.crossAxisSpacing = i12;
        this.containerStyle = containerStyle2;
    }

    public static /* synthetic */ ImageContainerStyle copy$default(ImageContainerStyle imageContainerStyle, int i11, int i12, ContainerStyle containerStyle2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = imageContainerStyle.mainAxisSpacing;
        }
        if ((i13 & 2) != 0) {
            i12 = imageContainerStyle.crossAxisSpacing;
        }
        if ((i13 & 4) != 0) {
            containerStyle2 = imageContainerStyle.containerStyle;
        }
        return imageContainerStyle.copy(i11, i12, containerStyle2);
    }

    public final int component1() {
        return this.mainAxisSpacing;
    }

    public final int component2() {
        return this.crossAxisSpacing;
    }

    @NotNull
    public final ContainerStyle component3() {
        return this.containerStyle;
    }

    @NotNull
    public final ImageContainerStyle copy(int i11, int i12, @NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        return new ImageContainerStyle(i11, i12, containerStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageContainerStyle)) {
            return false;
        }
        ImageContainerStyle imageContainerStyle = (ImageContainerStyle) obj;
        return this.mainAxisSpacing == imageContainerStyle.mainAxisSpacing && this.crossAxisSpacing == imageContainerStyle.crossAxisSpacing && Intrinsics.areEqual((Object) this.containerStyle, (Object) imageContainerStyle.containerStyle);
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    public final int getCrossAxisSpacing() {
        return this.crossAxisSpacing;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public int hashCode() {
        return (((this.mainAxisSpacing * 31) + this.crossAxisSpacing) * 31) + this.containerStyle.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.mainAxisSpacing;
        int i12 = this.crossAxisSpacing;
        ContainerStyle containerStyle2 = this.containerStyle;
        return "ImageContainerStyle(mainAxisSpacing=" + i11 + ", crossAxisSpacing=" + i12 + ", containerStyle=" + containerStyle2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImageContainerStyle(int r16, int r17, com.checkout.frames.style.component.base.ContainerStyle r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r15 = this;
            r0 = r19 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0009
        L_0x0007:
            r0 = r16
        L_0x0009:
            r2 = r19 & 2
            if (r2 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r1 = r17
        L_0x0010:
            r2 = r19 & 4
            if (r2 == 0) goto L_0x0028
            com.checkout.frames.style.component.base.ContainerStyle r2 = new com.checkout.frames.style.component.base.ContainerStyle
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 255(0xff, float:3.57E-43)
            r14 = 0
            r3 = r2
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r3 = r15
            goto L_0x002b
        L_0x0028:
            r3 = r15
            r2 = r18
        L_0x002b:
            r15.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ImageContainerStyle.<init>(int, int, com.checkout.frames.style.component.base.ContainerStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
