package com.deliveryhero.chatui.view.chatroom.dataholder;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/dataholder/AttachmentDataModel;", "", "attachmentIcon", "Landroid/graphics/drawable/Drawable;", "attachmentType", "", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "getAttachmentIcon", "()Landroid/graphics/drawable/Drawable;", "getAttachmentType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttachmentDataModel {
    @Nullable
    private final Drawable attachmentIcon;
    @NotNull
    private final String attachmentType;

    public AttachmentDataModel(@Nullable Drawable drawable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "attachmentType");
        this.attachmentIcon = drawable;
        this.attachmentType = str;
    }

    public static /* synthetic */ AttachmentDataModel copy$default(AttachmentDataModel attachmentDataModel, Drawable drawable, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            drawable = attachmentDataModel.attachmentIcon;
        }
        if ((i11 & 2) != 0) {
            str = attachmentDataModel.attachmentType;
        }
        return attachmentDataModel.copy(drawable, str);
    }

    @Nullable
    public final Drawable component1() {
        return this.attachmentIcon;
    }

    @NotNull
    public final String component2() {
        return this.attachmentType;
    }

    @NotNull
    public final AttachmentDataModel copy(@Nullable Drawable drawable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "attachmentType");
        return new AttachmentDataModel(drawable, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttachmentDataModel)) {
            return false;
        }
        AttachmentDataModel attachmentDataModel = (AttachmentDataModel) obj;
        return Intrinsics.areEqual((Object) this.attachmentIcon, (Object) attachmentDataModel.attachmentIcon) && Intrinsics.areEqual((Object) this.attachmentType, (Object) attachmentDataModel.attachmentType);
    }

    @Nullable
    public final Drawable getAttachmentIcon() {
        return this.attachmentIcon;
    }

    @NotNull
    public final String getAttachmentType() {
        return this.attachmentType;
    }

    public int hashCode() {
        Drawable drawable = this.attachmentIcon;
        return ((drawable == null ? 0 : drawable.hashCode()) * 31) + this.attachmentType.hashCode();
    }

    @NotNull
    public String toString() {
        return "AttachmentDataModel(attachmentIcon=" + this.attachmentIcon + ", attachmentType=" + this.attachmentType + ')';
    }
}
