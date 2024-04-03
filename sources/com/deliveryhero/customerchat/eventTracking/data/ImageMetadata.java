package com.deliveryhero.customerchat.eventTracking.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/ImageMetadata;", "", "source", "Lcom/deliveryhero/customerchat/eventTracking/data/ImageSource;", "imageWidth", "", "imageHeight", "imageSizeInKB", "imageUploadDuration", "(Lcom/deliveryhero/customerchat/eventTracking/data/ImageSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageHeight", "()Ljava/lang/String;", "getImageSizeInKB", "getImageUploadDuration", "setImageUploadDuration", "(Ljava/lang/String;)V", "getImageWidth", "getSource", "()Lcom/deliveryhero/customerchat/eventTracking/data/ImageSource;", "setSource", "(Lcom/deliveryhero/customerchat/eventTracking/data/ImageSource;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageMetadata {
    @NotNull
    private final String imageHeight;
    @NotNull
    private final String imageSizeInKB;
    @Nullable
    private String imageUploadDuration;
    @NotNull
    private final String imageWidth;
    @NotNull
    private ImageSource source;

    public ImageMetadata(@NotNull ImageSource imageSource, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(imageSource, "source");
        Intrinsics.checkNotNullParameter(str, "imageWidth");
        Intrinsics.checkNotNullParameter(str2, "imageHeight");
        Intrinsics.checkNotNullParameter(str3, "imageSizeInKB");
        this.source = imageSource;
        this.imageWidth = str;
        this.imageHeight = str2;
        this.imageSizeInKB = str3;
        this.imageUploadDuration = str4;
    }

    public static /* synthetic */ ImageMetadata copy$default(ImageMetadata imageMetadata, ImageSource imageSource, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            imageSource = imageMetadata.source;
        }
        if ((i11 & 2) != 0) {
            str = imageMetadata.imageWidth;
        }
        String str5 = str;
        if ((i11 & 4) != 0) {
            str2 = imageMetadata.imageHeight;
        }
        String str6 = str2;
        if ((i11 & 8) != 0) {
            str3 = imageMetadata.imageSizeInKB;
        }
        String str7 = str3;
        if ((i11 & 16) != 0) {
            str4 = imageMetadata.imageUploadDuration;
        }
        return imageMetadata.copy(imageSource, str5, str6, str7, str4);
    }

    @NotNull
    public final ImageSource component1() {
        return this.source;
    }

    @NotNull
    public final String component2() {
        return this.imageWidth;
    }

    @NotNull
    public final String component3() {
        return this.imageHeight;
    }

    @NotNull
    public final String component4() {
        return this.imageSizeInKB;
    }

    @Nullable
    public final String component5() {
        return this.imageUploadDuration;
    }

    @NotNull
    public final ImageMetadata copy(@NotNull ImageSource imageSource, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(imageSource, "source");
        Intrinsics.checkNotNullParameter(str, "imageWidth");
        Intrinsics.checkNotNullParameter(str2, "imageHeight");
        Intrinsics.checkNotNullParameter(str3, "imageSizeInKB");
        return new ImageMetadata(imageSource, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageMetadata)) {
            return false;
        }
        ImageMetadata imageMetadata = (ImageMetadata) obj;
        return this.source == imageMetadata.source && Intrinsics.areEqual((Object) this.imageWidth, (Object) imageMetadata.imageWidth) && Intrinsics.areEqual((Object) this.imageHeight, (Object) imageMetadata.imageHeight) && Intrinsics.areEqual((Object) this.imageSizeInKB, (Object) imageMetadata.imageSizeInKB) && Intrinsics.areEqual((Object) this.imageUploadDuration, (Object) imageMetadata.imageUploadDuration);
    }

    @NotNull
    public final String getImageHeight() {
        return this.imageHeight;
    }

    @NotNull
    public final String getImageSizeInKB() {
        return this.imageSizeInKB;
    }

    @Nullable
    public final String getImageUploadDuration() {
        return this.imageUploadDuration;
    }

    @NotNull
    public final String getImageWidth() {
        return this.imageWidth;
    }

    @NotNull
    public final ImageSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int hashCode = ((((((this.source.hashCode() * 31) + this.imageWidth.hashCode()) * 31) + this.imageHeight.hashCode()) * 31) + this.imageSizeInKB.hashCode()) * 31;
        String str = this.imageUploadDuration;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setImageUploadDuration(@Nullable String str) {
        this.imageUploadDuration = str;
    }

    public final void setSource(@NotNull ImageSource imageSource) {
        Intrinsics.checkNotNullParameter(imageSource, "<set-?>");
        this.source = imageSource;
    }

    @NotNull
    public String toString() {
        return "ImageMetadata(source=" + this.source + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", imageSizeInKB=" + this.imageSizeInKB + ", imageUploadDuration=" + this.imageUploadDuration + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageMetadata(ImageSource imageSource, String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, str, str2, str3, (i11 & 16) != 0 ? null : str4);
    }
}
