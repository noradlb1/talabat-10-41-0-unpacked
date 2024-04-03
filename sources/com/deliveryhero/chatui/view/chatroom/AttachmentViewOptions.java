package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/AttachmentViewOptions;", "", "galleryVisibility", "", "cameraVisibility", "locationVisibility", "addVisibility", "isEnabled", "", "(IIIIZ)V", "getAddVisibility", "()I", "getCameraVisibility", "getGalleryVisibility", "()Z", "getLocationVisibility", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttachmentViewOptions {
    private final int addVisibility;
    private final int cameraVisibility;
    private final int galleryVisibility;
    private final boolean isEnabled;
    private final int locationVisibility;

    public AttachmentViewOptions(int i11, int i12, int i13, int i14, boolean z11) {
        this.galleryVisibility = i11;
        this.cameraVisibility = i12;
        this.locationVisibility = i13;
        this.addVisibility = i14;
        this.isEnabled = z11;
    }

    public static /* synthetic */ AttachmentViewOptions copy$default(AttachmentViewOptions attachmentViewOptions, int i11, int i12, int i13, int i14, boolean z11, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = attachmentViewOptions.galleryVisibility;
        }
        if ((i15 & 2) != 0) {
            i12 = attachmentViewOptions.cameraVisibility;
        }
        int i16 = i12;
        if ((i15 & 4) != 0) {
            i13 = attachmentViewOptions.locationVisibility;
        }
        int i17 = i13;
        if ((i15 & 8) != 0) {
            i14 = attachmentViewOptions.addVisibility;
        }
        int i18 = i14;
        if ((i15 & 16) != 0) {
            z11 = attachmentViewOptions.isEnabled;
        }
        return attachmentViewOptions.copy(i11, i16, i17, i18, z11);
    }

    public final int component1() {
        return this.galleryVisibility;
    }

    public final int component2() {
        return this.cameraVisibility;
    }

    public final int component3() {
        return this.locationVisibility;
    }

    public final int component4() {
        return this.addVisibility;
    }

    public final boolean component5() {
        return this.isEnabled;
    }

    @NotNull
    public final AttachmentViewOptions copy(int i11, int i12, int i13, int i14, boolean z11) {
        return new AttachmentViewOptions(i11, i12, i13, i14, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttachmentViewOptions)) {
            return false;
        }
        AttachmentViewOptions attachmentViewOptions = (AttachmentViewOptions) obj;
        return this.galleryVisibility == attachmentViewOptions.galleryVisibility && this.cameraVisibility == attachmentViewOptions.cameraVisibility && this.locationVisibility == attachmentViewOptions.locationVisibility && this.addVisibility == attachmentViewOptions.addVisibility && this.isEnabled == attachmentViewOptions.isEnabled;
    }

    public final int getAddVisibility() {
        return this.addVisibility;
    }

    public final int getCameraVisibility() {
        return this.cameraVisibility;
    }

    public final int getGalleryVisibility() {
        return this.galleryVisibility;
    }

    public final int getLocationVisibility() {
        return this.locationVisibility;
    }

    public int hashCode() {
        int i11 = ((((((this.galleryVisibility * 31) + this.cameraVisibility) * 31) + this.locationVisibility) * 31) + this.addVisibility) * 31;
        boolean z11 = this.isEnabled;
        if (z11) {
            z11 = true;
        }
        return i11 + (z11 ? 1 : 0);
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public String toString() {
        return "AttachmentViewOptions(galleryVisibility=" + this.galleryVisibility + ", cameraVisibility=" + this.cameraVisibility + ", locationVisibility=" + this.locationVisibility + ", addVisibility=" + this.addVisibility + ", isEnabled=" + this.isEnabled + ')';
    }
}
