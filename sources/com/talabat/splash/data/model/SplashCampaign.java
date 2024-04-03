package com.talabat.splash.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/splash/data/model/SplashCampaign;", "", "title", "", "imagePath", "imageWidth", "imageHeight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageHeight", "()Ljava/lang/String;", "getImagePath", "getImageWidth", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashCampaign {
    @NotNull
    private final String imageHeight;
    @NotNull
    private final String imagePath;
    @NotNull
    private final String imageWidth;
    @NotNull
    private final String title;

    public SplashCampaign(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "imagePath");
        Intrinsics.checkNotNullParameter(str3, "imageWidth");
        Intrinsics.checkNotNullParameter(str4, "imageHeight");
        this.title = str;
        this.imagePath = str2;
        this.imageWidth = str3;
        this.imageHeight = str4;
    }

    public static /* synthetic */ SplashCampaign copy$default(SplashCampaign splashCampaign, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = splashCampaign.title;
        }
        if ((i11 & 2) != 0) {
            str2 = splashCampaign.imagePath;
        }
        if ((i11 & 4) != 0) {
            str3 = splashCampaign.imageWidth;
        }
        if ((i11 & 8) != 0) {
            str4 = splashCampaign.imageHeight;
        }
        return splashCampaign.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.imagePath;
    }

    @NotNull
    public final String component3() {
        return this.imageWidth;
    }

    @NotNull
    public final String component4() {
        return this.imageHeight;
    }

    @NotNull
    public final SplashCampaign copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "imagePath");
        Intrinsics.checkNotNullParameter(str3, "imageWidth");
        Intrinsics.checkNotNullParameter(str4, "imageHeight");
        return new SplashCampaign(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplashCampaign)) {
            return false;
        }
        SplashCampaign splashCampaign = (SplashCampaign) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) splashCampaign.title) && Intrinsics.areEqual((Object) this.imagePath, (Object) splashCampaign.imagePath) && Intrinsics.areEqual((Object) this.imageWidth, (Object) splashCampaign.imageWidth) && Intrinsics.areEqual((Object) this.imageHeight, (Object) splashCampaign.imageHeight);
    }

    @NotNull
    public final String getImageHeight() {
        return this.imageHeight;
    }

    @NotNull
    public final String getImagePath() {
        return this.imagePath;
    }

    @NotNull
    public final String getImageWidth() {
        return this.imageWidth;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.imagePath.hashCode()) * 31) + this.imageWidth.hashCode()) * 31) + this.imageHeight.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.imagePath;
        String str3 = this.imageWidth;
        String str4 = this.imageHeight;
        return "SplashCampaign(title=" + str + ", imagePath=" + str2 + ", imageWidth=" + str3 + ", imageHeight=" + str4 + ")";
    }
}
