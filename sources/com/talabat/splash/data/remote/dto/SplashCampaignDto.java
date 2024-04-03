package com.talabat.splash.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/splash/data/remote/dto/SplashCampaignDto;", "", "title", "", "imagePath", "imageWidth", "imageHeight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageHeight", "()Ljava/lang/String;", "getImagePath", "getImageWidth", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashCampaignDto {
    @SerializedName("image_height")
    @Nullable
    private final String imageHeight;
    @SerializedName("image_path")
    @Nullable
    private final String imagePath;
    @SerializedName("image_width")
    @Nullable
    private final String imageWidth;
    @SerializedName("title")
    @Nullable
    private final String title;

    public SplashCampaignDto() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public SplashCampaignDto(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.title = str;
        this.imagePath = str2;
        this.imageWidth = str3;
        this.imageHeight = str4;
    }

    public static /* synthetic */ SplashCampaignDto copy$default(SplashCampaignDto splashCampaignDto, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = splashCampaignDto.title;
        }
        if ((i11 & 2) != 0) {
            str2 = splashCampaignDto.imagePath;
        }
        if ((i11 & 4) != 0) {
            str3 = splashCampaignDto.imageWidth;
        }
        if ((i11 & 8) != 0) {
            str4 = splashCampaignDto.imageHeight;
        }
        return splashCampaignDto.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.imagePath;
    }

    @Nullable
    public final String component3() {
        return this.imageWidth;
    }

    @Nullable
    public final String component4() {
        return this.imageHeight;
    }

    @NotNull
    public final SplashCampaignDto copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new SplashCampaignDto(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplashCampaignDto)) {
            return false;
        }
        SplashCampaignDto splashCampaignDto = (SplashCampaignDto) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) splashCampaignDto.title) && Intrinsics.areEqual((Object) this.imagePath, (Object) splashCampaignDto.imagePath) && Intrinsics.areEqual((Object) this.imageWidth, (Object) splashCampaignDto.imageWidth) && Intrinsics.areEqual((Object) this.imageHeight, (Object) splashCampaignDto.imageHeight);
    }

    @Nullable
    public final String getImageHeight() {
        return this.imageHeight;
    }

    @Nullable
    public final String getImagePath() {
        return this.imagePath;
    }

    @Nullable
    public final String getImageWidth() {
        return this.imageWidth;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imagePath;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageWidth;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.imageHeight;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.imagePath;
        String str3 = this.imageWidth;
        String str4 = this.imageHeight;
        return "SplashCampaignDto(title=" + str + ", imagePath=" + str2 + ", imageWidth=" + str3 + ", imageHeight=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplashCampaignDto(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }
}
