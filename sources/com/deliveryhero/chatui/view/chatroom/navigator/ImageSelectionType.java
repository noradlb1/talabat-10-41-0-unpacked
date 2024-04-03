package com.deliveryhero.chatui.view.chatroom.navigator;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "", "()V", "CAMERA", "GALLERY", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType$CAMERA;", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType$GALLERY;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ImageSelectionType {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType$CAMERA;", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "photoUri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getPhotoUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CAMERA extends ImageSelectionType {
        @NotNull
        private final Uri photoUri;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CAMERA(@NotNull Uri uri) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(uri, "photoUri");
            this.photoUri = uri;
        }

        public static /* synthetic */ CAMERA copy$default(CAMERA camera, Uri uri, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                uri = camera.photoUri;
            }
            return camera.copy(uri);
        }

        @NotNull
        public final Uri component1() {
            return this.photoUri;
        }

        @NotNull
        public final CAMERA copy(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "photoUri");
            return new CAMERA(uri);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CAMERA) && Intrinsics.areEqual((Object) this.photoUri, (Object) ((CAMERA) obj).photoUri);
        }

        @NotNull
        public final Uri getPhotoUri() {
            return this.photoUri;
        }

        public int hashCode() {
            return this.photoUri.hashCode();
        }

        @NotNull
        public String toString() {
            return "CAMERA(photoUri=" + this.photoUri + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType$GALLERY;", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "()V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GALLERY extends ImageSelectionType {
        @NotNull
        public static final GALLERY INSTANCE = new GALLERY();

        private GALLERY() {
            super((DefaultConstructorMarker) null);
        }
    }

    private ImageSelectionType() {
    }

    public /* synthetic */ ImageSelectionType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
