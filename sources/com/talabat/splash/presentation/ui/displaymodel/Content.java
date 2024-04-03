package com.talabat.splash.presentation.ui.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/Content;", "", "()V", "Bundled", "Dynamic", "Lcom/talabat/splash/presentation/ui/displaymodel/Content$Bundled;", "Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Content {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/Content$Bundled;", "Lcom/talabat/splash/presentation/ui/displaymodel/Content;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Bundled extends Content {
        @NotNull
        public static final Bundled INSTANCE = new Bundled();

        private Bundled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic;", "Lcom/talabat/splash/presentation/ui/displaymodel/Content;", "backgroundColor", "", "scaleType", "Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic$ScaleType;", "resourceType", "Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic$ResourceType;", "localResourcePath", "(Ljava/lang/String;Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic$ScaleType;Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic$ResourceType;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getLocalResourcePath", "getResourceType", "()Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic$ResourceType;", "getScaleType", "()Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic$ScaleType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ResourceType", "ScaleType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Dynamic extends Content {
        @NotNull
        private final String backgroundColor;
        @NotNull
        private final String localResourcePath;
        @NotNull
        private final ResourceType resourceType;
        @NotNull
        private final ScaleType scaleType;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic$ResourceType;", "", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public enum ResourceType {
            IMAGE,
            VIDEO
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/Content$Dynamic$ScaleType;", "", "(Ljava/lang/String;I)V", "SCALE_FILL", "CENTER", "ASPECT_FIT", "ASPECT_FILL", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    private Content() {
    }

    public /* synthetic */ Content(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
