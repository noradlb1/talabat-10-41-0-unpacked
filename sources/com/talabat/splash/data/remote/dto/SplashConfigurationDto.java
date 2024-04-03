package com.talabat.splash.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto;", "", "backgroundColor", "", "scaleType", "Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto$ScaleType;", "resourceType", "Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto$ResourceType;", "resourcePath", "(Ljava/lang/String;Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto$ScaleType;Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto$ResourceType;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getResourcePath", "getResourceType", "()Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto$ResourceType;", "getScaleType", "()Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto$ScaleType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ResourceType", "ScaleType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashConfigurationDto {
    @SerializedName("background_color")
    @Nullable
    private final String backgroundColor;
    @SerializedName("resource_path")
    @Nullable
    private final String resourcePath;
    @SerializedName("resource_type")
    @Nullable
    private final ResourceType resourceType;
    @SerializedName("scale_type")
    @Nullable
    private final ScaleType scaleType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto$ResourceType;", "", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ResourceType {
        IMAGE,
        VIDEO
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto$ScaleType;", "", "(Ljava/lang/String;I)V", "SCALE_FILL", "CENTER", "ASPECT_FIT", "ASPECT_FILL", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ScaleType {
        SCALE_FILL,
        CENTER,
        ASPECT_FIT,
        ASPECT_FILL
    }

    public SplashConfigurationDto() {
        this((String) null, (ScaleType) null, (ResourceType) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public SplashConfigurationDto(@Nullable String str, @Nullable ScaleType scaleType2, @Nullable ResourceType resourceType2, @Nullable String str2) {
        this.backgroundColor = str;
        this.scaleType = scaleType2;
        this.resourceType = resourceType2;
        this.resourcePath = str2;
    }

    public static /* synthetic */ SplashConfigurationDto copy$default(SplashConfigurationDto splashConfigurationDto, String str, ScaleType scaleType2, ResourceType resourceType2, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = splashConfigurationDto.backgroundColor;
        }
        if ((i11 & 2) != 0) {
            scaleType2 = splashConfigurationDto.scaleType;
        }
        if ((i11 & 4) != 0) {
            resourceType2 = splashConfigurationDto.resourceType;
        }
        if ((i11 & 8) != 0) {
            str2 = splashConfigurationDto.resourcePath;
        }
        return splashConfigurationDto.copy(str, scaleType2, resourceType2, str2);
    }

    @Nullable
    public final String component1() {
        return this.backgroundColor;
    }

    @Nullable
    public final ScaleType component2() {
        return this.scaleType;
    }

    @Nullable
    public final ResourceType component3() {
        return this.resourceType;
    }

    @Nullable
    public final String component4() {
        return this.resourcePath;
    }

    @NotNull
    public final SplashConfigurationDto copy(@Nullable String str, @Nullable ScaleType scaleType2, @Nullable ResourceType resourceType2, @Nullable String str2) {
        return new SplashConfigurationDto(str, scaleType2, resourceType2, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplashConfigurationDto)) {
            return false;
        }
        SplashConfigurationDto splashConfigurationDto = (SplashConfigurationDto) obj;
        return Intrinsics.areEqual((Object) this.backgroundColor, (Object) splashConfigurationDto.backgroundColor) && this.scaleType == splashConfigurationDto.scaleType && this.resourceType == splashConfigurationDto.resourceType && Intrinsics.areEqual((Object) this.resourcePath, (Object) splashConfigurationDto.resourcePath);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getResourcePath() {
        return this.resourcePath;
    }

    @Nullable
    public final ResourceType getResourceType() {
        return this.resourceType;
    }

    @Nullable
    public final ScaleType getScaleType() {
        return this.scaleType;
    }

    public int hashCode() {
        String str = this.backgroundColor;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ScaleType scaleType2 = this.scaleType;
        int hashCode2 = (hashCode + (scaleType2 == null ? 0 : scaleType2.hashCode())) * 31;
        ResourceType resourceType2 = this.resourceType;
        int hashCode3 = (hashCode2 + (resourceType2 == null ? 0 : resourceType2.hashCode())) * 31;
        String str2 = this.resourcePath;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.backgroundColor;
        ScaleType scaleType2 = this.scaleType;
        ResourceType resourceType2 = this.resourceType;
        String str2 = this.resourcePath;
        return "SplashConfigurationDto(backgroundColor=" + str + ", scaleType=" + scaleType2 + ", resourceType=" + resourceType2 + ", resourcePath=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplashConfigurationDto(String str, ScaleType scaleType2, ResourceType resourceType2, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : scaleType2, (i11 & 4) != 0 ? null : resourceType2, (i11 & 8) != 0 ? null : str2);
    }
}
