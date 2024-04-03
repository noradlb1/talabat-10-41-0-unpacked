package com.talabat.splash.domain.usecase;

import com.talabat.splash.domain.repository.DownloadsRepository;
import com.talabat.splash.domain.repository.SplashConfigurationRepository;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\rH\u0002J\u0011\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase;", "", "splashConfigurationRepository", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository;", "downloadsRepository", "Lcom/talabat/splash/domain/repository/DownloadsRepository;", "(Lcom/talabat/splash/domain/repository/SplashConfigurationRepository;Lcom/talabat/splash/domain/repository/DownloadsRepository;)V", "getAvailableCampaignOrDownload", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Campaign;", "it", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign$AvailableCampaign;", "getAvailableContentOrDownload", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration;", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration;", "getDynamicSplashContent", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DynamicSplashContent", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetDynamicSplashContentUseCase {
    @NotNull
    private final DownloadsRepository downloadsRepository;
    @NotNull
    private final SplashConfigurationRepository splashConfigurationRepository;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent;", "", "configuration", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration;", "campaign", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Campaign;", "(Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration;Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Campaign;)V", "getCampaign", "()Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Campaign;", "getConfiguration", "()Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Campaign", "Configuration", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DynamicSplashContent {
        @Nullable
        private final Campaign campaign;
        @NotNull
        private final Configuration configuration;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Campaign;", "", "title", "", "localImagePath", "imageWidth", "", "imageHeight", "(Ljava/lang/String;Ljava/lang/String;II)V", "getImageHeight", "()I", "getImageWidth", "getLocalImagePath", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Campaign {
            private final int imageHeight;
            private final int imageWidth;
            @NotNull
            private final String localImagePath;
            @NotNull
            private final String title;

            public Campaign(@NotNull String str, @NotNull String str2, int i11, int i12) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "localImagePath");
                this.title = str;
                this.localImagePath = str2;
                this.imageWidth = i11;
                this.imageHeight = i12;
            }

            public static /* synthetic */ Campaign copy$default(Campaign campaign, String str, String str2, int i11, int i12, int i13, Object obj) {
                if ((i13 & 1) != 0) {
                    str = campaign.title;
                }
                if ((i13 & 2) != 0) {
                    str2 = campaign.localImagePath;
                }
                if ((i13 & 4) != 0) {
                    i11 = campaign.imageWidth;
                }
                if ((i13 & 8) != 0) {
                    i12 = campaign.imageHeight;
                }
                return campaign.copy(str, str2, i11, i12);
            }

            @NotNull
            public final String component1() {
                return this.title;
            }

            @NotNull
            public final String component2() {
                return this.localImagePath;
            }

            public final int component3() {
                return this.imageWidth;
            }

            public final int component4() {
                return this.imageHeight;
            }

            @NotNull
            public final Campaign copy(@NotNull String str, @NotNull String str2, int i11, int i12) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "localImagePath");
                return new Campaign(str, str2, i11, i12);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Campaign)) {
                    return false;
                }
                Campaign campaign = (Campaign) obj;
                return Intrinsics.areEqual((Object) this.title, (Object) campaign.title) && Intrinsics.areEqual((Object) this.localImagePath, (Object) campaign.localImagePath) && this.imageWidth == campaign.imageWidth && this.imageHeight == campaign.imageHeight;
            }

            public final int getImageHeight() {
                return this.imageHeight;
            }

            public final int getImageWidth() {
                return this.imageWidth;
            }

            @NotNull
            public final String getLocalImagePath() {
                return this.localImagePath;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                return (((((this.title.hashCode() * 31) + this.localImagePath.hashCode()) * 31) + this.imageWidth) * 31) + this.imageHeight;
            }

            @NotNull
            public String toString() {
                String str = this.title;
                String str2 = this.localImagePath;
                int i11 = this.imageWidth;
                int i12 = this.imageHeight;
                return "Campaign(title=" + str + ", localImagePath=" + str2 + ", imageWidth=" + i11 + ", imageHeight=" + i12 + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration;", "", "()V", "Bundled", "Dynamic", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Bundled;", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static abstract class Configuration {

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Bundled;", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Bundled extends Configuration {
                @NotNull
                public static final Bundled INSTANCE = new Bundled();

                private Bundled() {
                    super((DefaultConstructorMarker) null);
                }
            }

            @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic;", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration;", "backgroundColor", "", "scaleType", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic$ScaleType;", "resourceType", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic$ResourceType;", "localResourcePath", "(Ljava/lang/String;Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic$ScaleType;Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic$ResourceType;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getLocalResourcePath", "getResourceType", "()Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic$ResourceType;", "getScaleType", "()Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic$ScaleType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ResourceType", "ScaleType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Dynamic extends Configuration {
                @NotNull
                private final String backgroundColor;
                @NotNull
                private final String localResourcePath;
                @NotNull
                private final ResourceType resourceType;
                @NotNull
                private final ScaleType scaleType;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic$ResourceType;", "", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
                public enum ResourceType {
                    IMAGE,
                    VIDEO
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Dynamic$ScaleType;", "", "(Ljava/lang/String;I)V", "SCALE_FILL", "CENTER", "ASPECT_FIT", "ASPECT_FILL", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
                public enum ScaleType {
                    SCALE_FILL,
                    CENTER,
                    ASPECT_FIT,
                    ASPECT_FILL
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Dynamic(@NotNull String str, @NotNull ScaleType scaleType2, @NotNull ResourceType resourceType2, @NotNull String str2) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
                    Intrinsics.checkNotNullParameter(scaleType2, "scaleType");
                    Intrinsics.checkNotNullParameter(resourceType2, "resourceType");
                    Intrinsics.checkNotNullParameter(str2, "localResourcePath");
                    this.backgroundColor = str;
                    this.scaleType = scaleType2;
                    this.resourceType = resourceType2;
                    this.localResourcePath = str2;
                }

                public static /* synthetic */ Dynamic copy$default(Dynamic dynamic, String str, ScaleType scaleType2, ResourceType resourceType2, String str2, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = dynamic.backgroundColor;
                    }
                    if ((i11 & 2) != 0) {
                        scaleType2 = dynamic.scaleType;
                    }
                    if ((i11 & 4) != 0) {
                        resourceType2 = dynamic.resourceType;
                    }
                    if ((i11 & 8) != 0) {
                        str2 = dynamic.localResourcePath;
                    }
                    return dynamic.copy(str, scaleType2, resourceType2, str2);
                }

                @NotNull
                public final String component1() {
                    return this.backgroundColor;
                }

                @NotNull
                public final ScaleType component2() {
                    return this.scaleType;
                }

                @NotNull
                public final ResourceType component3() {
                    return this.resourceType;
                }

                @NotNull
                public final String component4() {
                    return this.localResourcePath;
                }

                @NotNull
                public final Dynamic copy(@NotNull String str, @NotNull ScaleType scaleType2, @NotNull ResourceType resourceType2, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
                    Intrinsics.checkNotNullParameter(scaleType2, "scaleType");
                    Intrinsics.checkNotNullParameter(resourceType2, "resourceType");
                    Intrinsics.checkNotNullParameter(str2, "localResourcePath");
                    return new Dynamic(str, scaleType2, resourceType2, str2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Dynamic)) {
                        return false;
                    }
                    Dynamic dynamic = (Dynamic) obj;
                    return Intrinsics.areEqual((Object) this.backgroundColor, (Object) dynamic.backgroundColor) && this.scaleType == dynamic.scaleType && this.resourceType == dynamic.resourceType && Intrinsics.areEqual((Object) this.localResourcePath, (Object) dynamic.localResourcePath);
                }

                @NotNull
                public final String getBackgroundColor() {
                    return this.backgroundColor;
                }

                @NotNull
                public final String getLocalResourcePath() {
                    return this.localResourcePath;
                }

                @NotNull
                public final ResourceType getResourceType() {
                    return this.resourceType;
                }

                @NotNull
                public final ScaleType getScaleType() {
                    return this.scaleType;
                }

                public int hashCode() {
                    return (((((this.backgroundColor.hashCode() * 31) + this.scaleType.hashCode()) * 31) + this.resourceType.hashCode()) * 31) + this.localResourcePath.hashCode();
                }

                @NotNull
                public String toString() {
                    String str = this.backgroundColor;
                    ScaleType scaleType2 = this.scaleType;
                    ResourceType resourceType2 = this.resourceType;
                    String str2 = this.localResourcePath;
                    return "Dynamic(backgroundColor=" + str + ", scaleType=" + scaleType2 + ", resourceType=" + resourceType2 + ", localResourcePath=" + str2 + ")";
                }
            }

            private Configuration() {
            }

            public /* synthetic */ Configuration(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public DynamicSplashContent(@NotNull Configuration configuration2, @Nullable Campaign campaign2) {
            Intrinsics.checkNotNullParameter(configuration2, "configuration");
            this.configuration = configuration2;
            this.campaign = campaign2;
        }

        public static /* synthetic */ DynamicSplashContent copy$default(DynamicSplashContent dynamicSplashContent, Configuration configuration2, Campaign campaign2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                configuration2 = dynamicSplashContent.configuration;
            }
            if ((i11 & 2) != 0) {
                campaign2 = dynamicSplashContent.campaign;
            }
            return dynamicSplashContent.copy(configuration2, campaign2);
        }

        @NotNull
        public final Configuration component1() {
            return this.configuration;
        }

        @Nullable
        public final Campaign component2() {
            return this.campaign;
        }

        @NotNull
        public final DynamicSplashContent copy(@NotNull Configuration configuration2, @Nullable Campaign campaign2) {
            Intrinsics.checkNotNullParameter(configuration2, "configuration");
            return new DynamicSplashContent(configuration2, campaign2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DynamicSplashContent)) {
                return false;
            }
            DynamicSplashContent dynamicSplashContent = (DynamicSplashContent) obj;
            return Intrinsics.areEqual((Object) this.configuration, (Object) dynamicSplashContent.configuration) && Intrinsics.areEqual((Object) this.campaign, (Object) dynamicSplashContent.campaign);
        }

        @Nullable
        public final Campaign getCampaign() {
            return this.campaign;
        }

        @NotNull
        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public int hashCode() {
            int hashCode = this.configuration.hashCode() * 31;
            Campaign campaign2 = this.campaign;
            return hashCode + (campaign2 == null ? 0 : campaign2.hashCode());
        }

        @NotNull
        public String toString() {
            Configuration configuration2 = this.configuration;
            Campaign campaign2 = this.campaign;
            return "DynamicSplashContent(configuration=" + configuration2 + ", campaign=" + campaign2 + ")";
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.values().length];
            iArr[SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.SCALE_FILL.ordinal()] = 1;
            iArr[SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.CENTER.ordinal()] = 2;
            iArr[SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.ASPECT_FIT.ordinal()] = 3;
            iArr[SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.ASPECT_FILL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ResourceType.values().length];
            iArr2[SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ResourceType.IMAGE.ordinal()] = 1;
            iArr2[SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ResourceType.VIDEO.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public GetDynamicSplashContentUseCase(@NotNull SplashConfigurationRepository splashConfigurationRepository2, @NotNull DownloadsRepository downloadsRepository2) {
        Intrinsics.checkNotNullParameter(splashConfigurationRepository2, "splashConfigurationRepository");
        Intrinsics.checkNotNullParameter(downloadsRepository2, "downloadsRepository");
        this.splashConfigurationRepository = splashConfigurationRepository2;
        this.downloadsRepository = downloadsRepository2;
    }

    private final DynamicSplashContent.Campaign getAvailableCampaignOrDownload(SplashConfigurationRepository.SplashCampaign.AvailableCampaign availableCampaign) {
        boolean z11;
        if (this.downloadsRepository.isDownloaded(availableCampaign.getImagePath())) {
            return new DynamicSplashContent.Campaign(availableCampaign.getTitle(), this.downloadsRepository.getLocalPath(availableCampaign.getImagePath()), availableCampaign.getImageWidth(), availableCampaign.getImageHeight());
        }
        if (availableCampaign.getImagePath().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.downloadsRepository.downLoad(availableCampaign.getImagePath(), DownloadsRepository.Type.IMAGE);
        }
        return null;
    }

    private final DynamicSplashContent.Configuration getAvailableContentOrDownload(SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration availableConfiguration) {
        boolean z11;
        DownloadsRepository.Type type;
        DynamicSplashContent.Configuration.Dynamic.ScaleType scaleType;
        DynamicSplashContent.Configuration.Dynamic.ResourceType resourceType;
        if (this.downloadsRepository.isDownloaded(availableConfiguration.getResourcePath())) {
            String backgroundColor = availableConfiguration.getBackgroundColor();
            int i11 = WhenMappings.$EnumSwitchMapping$0[availableConfiguration.getScaleType().ordinal()];
            if (i11 == 1) {
                scaleType = DynamicSplashContent.Configuration.Dynamic.ScaleType.SCALE_FILL;
            } else if (i11 == 2) {
                scaleType = DynamicSplashContent.Configuration.Dynamic.ScaleType.CENTER;
            } else if (i11 == 3) {
                scaleType = DynamicSplashContent.Configuration.Dynamic.ScaleType.ASPECT_FIT;
            } else if (i11 == 4) {
                scaleType = DynamicSplashContent.Configuration.Dynamic.ScaleType.ASPECT_FILL;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            int i12 = WhenMappings.$EnumSwitchMapping$1[availableConfiguration.getResourceType().ordinal()];
            if (i12 == 1) {
                resourceType = DynamicSplashContent.Configuration.Dynamic.ResourceType.IMAGE;
            } else if (i12 == 2) {
                resourceType = DynamicSplashContent.Configuration.Dynamic.ResourceType.VIDEO;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new DynamicSplashContent.Configuration.Dynamic(backgroundColor, scaleType, resourceType, this.downloadsRepository.getLocalPath(availableConfiguration.getResourcePath()));
        }
        if (availableConfiguration.getResourcePath().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return DynamicSplashContent.Configuration.Bundled.INSTANCE;
        }
        DownloadsRepository downloadsRepository2 = this.downloadsRepository;
        String resourcePath = availableConfiguration.getResourcePath();
        int i13 = WhenMappings.$EnumSwitchMapping$1[availableConfiguration.getResourceType().ordinal()];
        if (i13 == 1) {
            type = DownloadsRepository.Type.IMAGE;
        } else if (i13 == 2) {
            type = DownloadsRepository.Type.VIDEO;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        downloadsRepository2.downLoad(resourcePath, type);
        return DynamicSplashContent.Configuration.Bundled.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getDynamicSplashContent(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase.DynamicSplashContent> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$getDynamicSplashContent$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$getDynamicSplashContent$1 r0 = (com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$getDynamicSplashContent$1) r0
            int r1 = r0.f61497l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61497l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$getDynamicSplashContent$1 r0 = new com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$getDynamicSplashContent$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61495j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61497l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r1 = r0.f61494i
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration r1 = (com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration) r1
            java.lang.Object r0 = r0.f61493h
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase r0 = (com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0083
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003c:
            java.lang.Object r2 = r0.f61493h
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase r2 = (com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0055
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.splash.domain.repository.SplashConfigurationRepository r6 = r5.splashConfigurationRepository
            r0.f61493h = r5
            r0.f61497l = r4
            java.lang.Object r6 = r6.getConfiguration(r0)
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r2 = r5
        L_0x0055:
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashConfiguration r6 = (com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashConfiguration) r6
            boolean r4 = r6 instanceof com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration
            if (r4 == 0) goto L_0x0062
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration r6 = (com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration) r6
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration r6 = r2.getAvailableContentOrDownload(r6)
            goto L_0x0071
        L_0x0062:
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashConfiguration$NotAvailable r4 = com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashConfiguration.NotAvailable.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 == 0) goto L_0x00aa
            java.lang.String r6 = "No SplashConfiguration available"
            com.talabat.talabatcore.logger.LogManager.info(r6)
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$DynamicSplashContent$Configuration$Bundled r6 = com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Bundled.INSTANCE
        L_0x0071:
            com.talabat.splash.domain.repository.SplashConfigurationRepository r4 = r2.splashConfigurationRepository
            r0.f61493h = r2
            r0.f61494i = r6
            r0.f61497l = r3
            java.lang.Object r0 = r4.getCampaign(r0)
            if (r0 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r1 = r6
            r6 = r0
            r0 = r2
        L_0x0083:
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashCampaign r6 = (com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashCampaign) r6
            boolean r2 = r6 instanceof com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashCampaign.AvailableCampaign
            if (r2 == 0) goto L_0x0090
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashCampaign$AvailableCampaign r6 = (com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashCampaign.AvailableCampaign) r6
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$DynamicSplashContent$Campaign r6 = r0.getAvailableCampaignOrDownload(r6)
            goto L_0x009e
        L_0x0090:
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashCampaign$NotAvailable r0 = com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashCampaign.NotAvailable.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x00a4
            java.lang.String r6 = "No Campaign available"
            com.talabat.talabatcore.logger.LogManager.info(r6)
            r6 = 0
        L_0x009e:
            com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$DynamicSplashContent r0 = new com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase$DynamicSplashContent
            r0.<init>(r1, r6)
            return r0
        L_0x00a4:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x00aa:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase.getDynamicSplashContent(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
