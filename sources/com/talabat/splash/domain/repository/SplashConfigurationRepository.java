package com.talabat.splash.domain.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository;", "", "getCampaign", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfiguration", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration;", "SplashCampaign", "SplashConfiguration", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SplashConfigurationRepository {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign;", "", "()V", "AvailableCampaign", "NotAvailable", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign$NotAvailable;", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign$AvailableCampaign;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class SplashCampaign {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign$AvailableCampaign;", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign;", "title", "", "imagePath", "imageWidth", "", "imageHeight", "(Ljava/lang/String;Ljava/lang/String;II)V", "getImageHeight", "()I", "getImagePath", "()Ljava/lang/String;", "getImageWidth", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class AvailableCampaign extends SplashCampaign {
            private final int imageHeight;
            @NotNull
            private final String imagePath;
            private final int imageWidth;
            @NotNull
            private final String title;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AvailableCampaign(@NotNull String str, @NotNull String str2, int i11, int i12) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "imagePath");
                this.title = str;
                this.imagePath = str2;
                this.imageWidth = i11;
                this.imageHeight = i12;
            }

            public static /* synthetic */ AvailableCampaign copy$default(AvailableCampaign availableCampaign, String str, String str2, int i11, int i12, int i13, Object obj) {
                if ((i13 & 1) != 0) {
                    str = availableCampaign.title;
                }
                if ((i13 & 2) != 0) {
                    str2 = availableCampaign.imagePath;
                }
                if ((i13 & 4) != 0) {
                    i11 = availableCampaign.imageWidth;
                }
                if ((i13 & 8) != 0) {
                    i12 = availableCampaign.imageHeight;
                }
                return availableCampaign.copy(str, str2, i11, i12);
            }

            @NotNull
            public final String component1() {
                return this.title;
            }

            @NotNull
            public final String component2() {
                return this.imagePath;
            }

            public final int component3() {
                return this.imageWidth;
            }

            public final int component4() {
                return this.imageHeight;
            }

            @NotNull
            public final AvailableCampaign copy(@NotNull String str, @NotNull String str2, int i11, int i12) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "imagePath");
                return new AvailableCampaign(str, str2, i11, i12);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AvailableCampaign)) {
                    return false;
                }
                AvailableCampaign availableCampaign = (AvailableCampaign) obj;
                return Intrinsics.areEqual((Object) this.title, (Object) availableCampaign.title) && Intrinsics.areEqual((Object) this.imagePath, (Object) availableCampaign.imagePath) && this.imageWidth == availableCampaign.imageWidth && this.imageHeight == availableCampaign.imageHeight;
            }

            public final int getImageHeight() {
                return this.imageHeight;
            }

            @NotNull
            public final String getImagePath() {
                return this.imagePath;
            }

            public final int getImageWidth() {
                return this.imageWidth;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                return (((((this.title.hashCode() * 31) + this.imagePath.hashCode()) * 31) + this.imageWidth) * 31) + this.imageHeight;
            }

            @NotNull
            public String toString() {
                String str = this.title;
                String str2 = this.imagePath;
                int i11 = this.imageWidth;
                int i12 = this.imageHeight;
                return "AvailableCampaign(title=" + str + ", imagePath=" + str2 + ", imageWidth=" + i11 + ", imageHeight=" + i12 + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign$NotAvailable;", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class NotAvailable extends SplashCampaign {
            @NotNull
            public static final NotAvailable INSTANCE = new NotAvailable();

            private NotAvailable() {
                super((DefaultConstructorMarker) null);
            }
        }

        private SplashCampaign() {
        }

        public /* synthetic */ SplashCampaign(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration;", "", "()V", "AvailableConfiguration", "NotAvailable", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$NotAvailable;", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class SplashConfiguration {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration;", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration;", "backgroundColor", "", "scaleType", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration$ScaleType;", "resourceType", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration$ResourceType;", "resourcePath", "(Ljava/lang/String;Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration$ScaleType;Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration$ResourceType;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getResourcePath", "getResourceType", "()Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration$ResourceType;", "getScaleType", "()Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration$ScaleType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ResourceType", "ScaleType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class AvailableConfiguration extends SplashConfiguration {
            @NotNull
            private final String backgroundColor;
            @NotNull
            private final String resourcePath;
            @NotNull
            private final ResourceType resourceType;
            @NotNull
            private final ScaleType scaleType;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration$ResourceType;", "", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public enum ResourceType {
                IMAGE,
                VIDEO
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration$ScaleType;", "", "(Ljava/lang/String;I)V", "SCALE_FILL", "CENTER", "ASPECT_FIT", "ASPECT_FILL", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public enum ScaleType {
                SCALE_FILL,
                CENTER,
                ASPECT_FIT,
                ASPECT_FILL
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AvailableConfiguration(@NotNull String str, @NotNull ScaleType scaleType2, @NotNull ResourceType resourceType2, @NotNull String str2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
                Intrinsics.checkNotNullParameter(scaleType2, "scaleType");
                Intrinsics.checkNotNullParameter(resourceType2, "resourceType");
                Intrinsics.checkNotNullParameter(str2, "resourcePath");
                this.backgroundColor = str;
                this.scaleType = scaleType2;
                this.resourceType = resourceType2;
                this.resourcePath = str2;
            }

            public static /* synthetic */ AvailableConfiguration copy$default(AvailableConfiguration availableConfiguration, String str, ScaleType scaleType2, ResourceType resourceType2, String str2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = availableConfiguration.backgroundColor;
                }
                if ((i11 & 2) != 0) {
                    scaleType2 = availableConfiguration.scaleType;
                }
                if ((i11 & 4) != 0) {
                    resourceType2 = availableConfiguration.resourceType;
                }
                if ((i11 & 8) != 0) {
                    str2 = availableConfiguration.resourcePath;
                }
                return availableConfiguration.copy(str, scaleType2, resourceType2, str2);
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
                return this.resourcePath;
            }

            @NotNull
            public final AvailableConfiguration copy(@NotNull String str, @NotNull ScaleType scaleType2, @NotNull ResourceType resourceType2, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
                Intrinsics.checkNotNullParameter(scaleType2, "scaleType");
                Intrinsics.checkNotNullParameter(resourceType2, "resourceType");
                Intrinsics.checkNotNullParameter(str2, "resourcePath");
                return new AvailableConfiguration(str, scaleType2, resourceType2, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AvailableConfiguration)) {
                    return false;
                }
                AvailableConfiguration availableConfiguration = (AvailableConfiguration) obj;
                return Intrinsics.areEqual((Object) this.backgroundColor, (Object) availableConfiguration.backgroundColor) && this.scaleType == availableConfiguration.scaleType && this.resourceType == availableConfiguration.resourceType && Intrinsics.areEqual((Object) this.resourcePath, (Object) availableConfiguration.resourcePath);
            }

            @NotNull
            public final String getBackgroundColor() {
                return this.backgroundColor;
            }

            @NotNull
            public final String getResourcePath() {
                return this.resourcePath;
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
                return (((((this.backgroundColor.hashCode() * 31) + this.scaleType.hashCode()) * 31) + this.resourceType.hashCode()) * 31) + this.resourcePath.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.backgroundColor;
                ScaleType scaleType2 = this.scaleType;
                ResourceType resourceType2 = this.resourceType;
                String str2 = this.resourcePath;
                return "AvailableConfiguration(backgroundColor=" + str + ", scaleType=" + scaleType2 + ", resourceType=" + resourceType2 + ", resourcePath=" + str2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$NotAvailable;", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class NotAvailable extends SplashConfiguration {
            @NotNull
            public static final NotAvailable INSTANCE = new NotAvailable();

            private NotAvailable() {
                super((DefaultConstructorMarker) null);
            }
        }

        private SplashConfiguration() {
        }

        public /* synthetic */ SplashConfiguration(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    Object getCampaign(@NotNull Continuation<? super SplashCampaign> continuation);

    @Nullable
    Object getConfiguration(@NotNull Continuation<? super SplashConfiguration> continuation);
}
