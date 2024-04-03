package com.talabat.splash.presentation.ui.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/Campaign;", "", "()V", "Available", "Unavailable", "Lcom/talabat/splash/presentation/ui/displaymodel/Campaign$Unavailable;", "Lcom/talabat/splash/presentation/ui/displaymodel/Campaign$Available;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Campaign {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/Campaign$Available;", "Lcom/talabat/splash/presentation/ui/displaymodel/Campaign;", "title", "", "localImagePath", "imageWidth", "", "imageHeight", "(Ljava/lang/String;Ljava/lang/String;II)V", "getImageHeight", "()I", "getImageWidth", "getLocalImagePath", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Available extends Campaign {
        private final int imageHeight;
        private final int imageWidth;
        @NotNull
        private final String localImagePath;
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Available(@NotNull String str, @NotNull String str2, int i11, int i12) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "localImagePath");
            this.title = str;
            this.localImagePath = str2;
            this.imageWidth = i11;
            this.imageHeight = i12;
        }

        public static /* synthetic */ Available copy$default(Available available, String str, String str2, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                str = available.title;
            }
            if ((i13 & 2) != 0) {
                str2 = available.localImagePath;
            }
            if ((i13 & 4) != 0) {
                i11 = available.imageWidth;
            }
            if ((i13 & 8) != 0) {
                i12 = available.imageHeight;
            }
            return available.copy(str, str2, i11, i12);
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
        public final Available copy(@NotNull String str, @NotNull String str2, int i11, int i12) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "localImagePath");
            return new Available(str, str2, i11, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Available)) {
                return false;
            }
            Available available = (Available) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) available.title) && Intrinsics.areEqual((Object) this.localImagePath, (Object) available.localImagePath) && this.imageWidth == available.imageWidth && this.imageHeight == available.imageHeight;
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
            return "Available(title=" + str + ", localImagePath=" + str2 + ", imageWidth=" + i11 + ", imageHeight=" + i12 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/Campaign$Unavailable;", "Lcom/talabat/splash/presentation/ui/displaymodel/Campaign;", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unavailable extends Campaign {
        @NotNull
        public static final Unavailable INSTANCE = new Unavailable();

        private Unavailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    private Campaign() {
    }

    public /* synthetic */ Campaign(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
