package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.contract.model.FileMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "", "()V", "Downloading", "Hidden", "UploadFailed", "Uploading", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage$Hidden;", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage$Uploading;", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage$Downloading;", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage$UploadFailed;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ImageMessage {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ImageMessage$Downloading;", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "visibility", "", "thumbnail", "Lcom/deliveryhero/contract/model/FileMessage$Thumbnail;", "url", "", "(ILcom/deliveryhero/contract/model/FileMessage$Thumbnail;Ljava/lang/String;)V", "getThumbnail", "()Lcom/deliveryhero/contract/model/FileMessage$Thumbnail;", "getUrl", "()Ljava/lang/String;", "getVisibility", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Downloading extends ImageMessage {
        @NotNull
        private final FileMessage.Thumbnail thumbnail;
        @NotNull
        private final String url;
        private final int visibility;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Downloading(int i11, FileMessage.Thumbnail thumbnail2, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 0 : i11, thumbnail2, str);
        }

        public static /* synthetic */ Downloading copy$default(Downloading downloading, int i11, FileMessage.Thumbnail thumbnail2, String str, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = downloading.visibility;
            }
            if ((i12 & 2) != 0) {
                thumbnail2 = downloading.thumbnail;
            }
            if ((i12 & 4) != 0) {
                str = downloading.url;
            }
            return downloading.copy(i11, thumbnail2, str);
        }

        public final int component1() {
            return this.visibility;
        }

        @NotNull
        public final FileMessage.Thumbnail component2() {
            return this.thumbnail;
        }

        @NotNull
        public final String component3() {
            return this.url;
        }

        @NotNull
        public final Downloading copy(int i11, @NotNull FileMessage.Thumbnail thumbnail2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(thumbnail2, "thumbnail");
            Intrinsics.checkNotNullParameter(str, "url");
            return new Downloading(i11, thumbnail2, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Downloading)) {
                return false;
            }
            Downloading downloading = (Downloading) obj;
            return this.visibility == downloading.visibility && Intrinsics.areEqual((Object) this.thumbnail, (Object) downloading.thumbnail) && Intrinsics.areEqual((Object) this.url, (Object) downloading.url);
        }

        @NotNull
        public final FileMessage.Thumbnail getThumbnail() {
            return this.thumbnail;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public final int getVisibility() {
            return this.visibility;
        }

        public int hashCode() {
            return (((this.visibility * 31) + this.thumbnail.hashCode()) * 31) + this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "Downloading(visibility=" + this.visibility + ", thumbnail=" + this.thumbnail + ", url=" + this.url + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Downloading(int i11, @NotNull FileMessage.Thumbnail thumbnail2, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(thumbnail2, "thumbnail");
            Intrinsics.checkNotNullParameter(str, "url");
            this.visibility = i11;
            this.thumbnail = thumbnail2;
            this.url = str;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ImageMessage$Hidden;", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "visibility", "", "(I)V", "getVisibility", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends ImageMessage {
        private final int visibility;

        public Hidden() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public Hidden(int i11) {
            super((DefaultConstructorMarker) null);
            this.visibility = i11;
        }

        public static /* synthetic */ Hidden copy$default(Hidden hidden, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = hidden.visibility;
            }
            return hidden.copy(i11);
        }

        public final int component1() {
            return this.visibility;
        }

        @NotNull
        public final Hidden copy(int i11) {
            return new Hidden(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Hidden) && this.visibility == ((Hidden) obj).visibility;
        }

        public final int getVisibility() {
            return this.visibility;
        }

        public int hashCode() {
            return this.visibility;
        }

        @NotNull
        public String toString() {
            return "Hidden(visibility=" + this.visibility + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Hidden(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 8 : i11);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ImageMessage$UploadFailed;", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "visibility", "", "url", "", "(ILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getVisibility", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UploadFailed extends ImageMessage {
        @Nullable
        private final String url;
        private final int visibility;

        public UploadFailed() {
            this(0, (String) null, 3, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UploadFailed(int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? null : str);
        }

        public static /* synthetic */ UploadFailed copy$default(UploadFailed uploadFailed, int i11, String str, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = uploadFailed.visibility;
            }
            if ((i12 & 2) != 0) {
                str = uploadFailed.url;
            }
            return uploadFailed.copy(i11, str);
        }

        public final int component1() {
            return this.visibility;
        }

        @Nullable
        public final String component2() {
            return this.url;
        }

        @NotNull
        public final UploadFailed copy(int i11, @Nullable String str) {
            return new UploadFailed(i11, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UploadFailed)) {
                return false;
            }
            UploadFailed uploadFailed = (UploadFailed) obj;
            return this.visibility == uploadFailed.visibility && Intrinsics.areEqual((Object) this.url, (Object) uploadFailed.url);
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        public final int getVisibility() {
            return this.visibility;
        }

        public int hashCode() {
            int i11 = this.visibility * 31;
            String str = this.url;
            return i11 + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "UploadFailed(visibility=" + this.visibility + ", url=" + this.url + ')';
        }

        public UploadFailed(int i11, @Nullable String str) {
            super((DefaultConstructorMarker) null);
            this.visibility = i11;
            this.url = str;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/ImageMessage$Uploading;", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "visibility", "", "(I)V", "getVisibility", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Uploading extends ImageMessage {
        private final int visibility;

        public Uploading() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public Uploading(int i11) {
            super((DefaultConstructorMarker) null);
            this.visibility = i11;
        }

        public static /* synthetic */ Uploading copy$default(Uploading uploading, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = uploading.visibility;
            }
            return uploading.copy(i11);
        }

        public final int component1() {
            return this.visibility;
        }

        @NotNull
        public final Uploading copy(int i11) {
            return new Uploading(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Uploading) && this.visibility == ((Uploading) obj).visibility;
        }

        public final int getVisibility() {
            return this.visibility;
        }

        public int hashCode() {
            return this.visibility;
        }

        @NotNull
        public String toString() {
            return "Uploading(visibility=" + this.visibility + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Uploading(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 0 : i11);
        }
    }

    private ImageMessage() {
    }

    public /* synthetic */ ImageMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
