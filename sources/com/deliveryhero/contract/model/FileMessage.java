package com.deliveryhero.contract.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/contract/model/FileMessage;", "Lcom/deliveryhero/contract/model/BaseMessage;", "sender", "Lcom/deliveryhero/contract/model/User;", "getSender", "()Lcom/deliveryhero/contract/model/User;", "thumbnails", "", "Lcom/deliveryhero/contract/model/FileMessage$Thumbnail;", "getThumbnails", "()Ljava/util/List;", "url", "", "getUrl", "()Ljava/lang/String;", "Thumbnail", "ThumbnailSize", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FileMessage extends BaseMessage {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/contract/model/FileMessage$Thumbnail;", "", "url", "", "maxWidth", "", "maxHeight", "realWidth", "realHeight", "(Ljava/lang/String;IIII)V", "getMaxHeight", "()I", "getMaxWidth", "getRealHeight", "getRealWidth", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Thumbnail {
        private final int maxHeight;
        private final int maxWidth;
        private final int realHeight;
        private final int realWidth;
        @NotNull
        private final String url;

        public Thumbnail(@NotNull String str, int i11, int i12, int i13, int i14) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
            this.maxWidth = i11;
            this.maxHeight = i12;
            this.realWidth = i13;
            this.realHeight = i14;
        }

        public static /* synthetic */ Thumbnail copy$default(Thumbnail thumbnail, String str, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if ((i15 & 1) != 0) {
                str = thumbnail.url;
            }
            if ((i15 & 2) != 0) {
                i11 = thumbnail.maxWidth;
            }
            int i16 = i11;
            if ((i15 & 4) != 0) {
                i12 = thumbnail.maxHeight;
            }
            int i17 = i12;
            if ((i15 & 8) != 0) {
                i13 = thumbnail.realWidth;
            }
            int i18 = i13;
            if ((i15 & 16) != 0) {
                i14 = thumbnail.realHeight;
            }
            return thumbnail.copy(str, i16, i17, i18, i14);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        public final int component2() {
            return this.maxWidth;
        }

        public final int component3() {
            return this.maxHeight;
        }

        public final int component4() {
            return this.realWidth;
        }

        public final int component5() {
            return this.realHeight;
        }

        @NotNull
        public final Thumbnail copy(@NotNull String str, int i11, int i12, int i13, int i14) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new Thumbnail(str, i11, i12, i13, i14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Thumbnail)) {
                return false;
            }
            Thumbnail thumbnail = (Thumbnail) obj;
            return Intrinsics.areEqual((Object) this.url, (Object) thumbnail.url) && this.maxWidth == thumbnail.maxWidth && this.maxHeight == thumbnail.maxHeight && this.realWidth == thumbnail.realWidth && this.realHeight == thumbnail.realHeight;
        }

        public final int getMaxHeight() {
            return this.maxHeight;
        }

        public final int getMaxWidth() {
            return this.maxWidth;
        }

        public final int getRealHeight() {
            return this.realHeight;
        }

        public final int getRealWidth() {
            return this.realWidth;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (((((((this.url.hashCode() * 31) + this.maxWidth) * 31) + this.maxHeight) * 31) + this.realWidth) * 31) + this.realHeight;
        }

        @NotNull
        public String toString() {
            return "Thumbnail(url=" + this.url + ", maxWidth=" + this.maxWidth + ", maxHeight=" + this.maxHeight + ", realWidth=" + this.realWidth + ", realHeight=" + this.realHeight + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/contract/model/FileMessage$ThumbnailSize;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ThumbnailSize {
        private final int height;
        private final int width;

        public ThumbnailSize(int i11, int i12) {
            this.width = i11;
            this.height = i12;
        }

        public static /* synthetic */ ThumbnailSize copy$default(ThumbnailSize thumbnailSize, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = thumbnailSize.width;
            }
            if ((i13 & 2) != 0) {
                i12 = thumbnailSize.height;
            }
            return thumbnailSize.copy(i11, i12);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.height;
        }

        @NotNull
        public final ThumbnailSize copy(int i11, int i12) {
            return new ThumbnailSize(i11, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ThumbnailSize)) {
                return false;
            }
            ThumbnailSize thumbnailSize = (ThumbnailSize) obj;
            return this.width == thumbnailSize.width && this.height == thumbnailSize.height;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (this.width * 31) + this.height;
        }

        @NotNull
        public String toString() {
            return "ThumbnailSize(width=" + this.width + ", height=" + this.height + ')';
        }
    }

    @NotNull
    User getSender();

    @NotNull
    List<Thumbnail> getThumbnails();

    @NotNull
    String getUrl();
}
