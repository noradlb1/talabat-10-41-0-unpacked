package com.deliveryhero.chatui.view.chatroom.dataholder;

import android.content.Context;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.view.util.AttributeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/dataholder/AttachmentDataHolder;", "", "attributeUtils", "Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "(Lcom/deliveryhero/customerchat/view/util/AttributeUtils;)V", "isImageSharing", "", "isLocationSharing", "getAttachmentOptionList", "", "Lcom/deliveryhero/chatui/view/chatroom/dataholder/AttachmentDataModel;", "context", "Landroid/content/Context;", "enableImageSharing", "enableLocationSharing", "AttachmentTypes", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttachmentDataHolder {
    @NotNull
    private final AttributeUtils attributeUtils;
    private boolean isImageSharing;
    private boolean isLocationSharing;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/dataholder/AttachmentDataHolder$AttachmentTypes;", "", "type", "", "icon", "(Ljava/lang/String;III)V", "getIcon", "()I", "getType", "GALLERY", "CAMERA", "LOCATION", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum AttachmentTypes {
        GALLERY(R.attr.customerChatSelectGalleryText, R.attr.openGalleryIcon),
        CAMERA(R.attr.customerChatSelectCameraText, R.attr.openCameraIcon),
        LOCATION(R.attr.customerChatSelectLocationText, R.attr.openLocationIcon);
        
        private final int icon;
        private final int type;

        private AttachmentTypes(int i11, int i12) {
            this.type = i11;
            this.icon = i12;
        }

        public final int getIcon() {
            return this.icon;
        }

        public final int getType() {
            return this.type;
        }
    }

    public AttachmentDataHolder(@NotNull AttributeUtils attributeUtils2) {
        Intrinsics.checkNotNullParameter(attributeUtils2, "attributeUtils");
        this.attributeUtils = attributeUtils2;
    }

    @NotNull
    public final List<AttachmentDataModel> getAttachmentOptionList(@NotNull Context context, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.isLocationSharing = z12;
        this.isImageSharing = z11;
        ArrayList arrayList = new ArrayList();
        if (this.isImageSharing) {
            AttributeUtils attributeUtils2 = this.attributeUtils;
            AttachmentTypes attachmentTypes = AttachmentTypes.GALLERY;
            arrayList.add(new AttachmentDataModel(attributeUtils2.getIconDrawable(context, attachmentTypes.getIcon()), this.attributeUtils.getStringAttribute(context, attachmentTypes.getType())));
            AttributeUtils attributeUtils3 = this.attributeUtils;
            AttachmentTypes attachmentTypes2 = AttachmentTypes.CAMERA;
            arrayList.add(new AttachmentDataModel(attributeUtils3.getIconDrawable(context, attachmentTypes2.getIcon()), this.attributeUtils.getStringAttribute(context, attachmentTypes2.getType())));
        }
        if (this.isLocationSharing) {
            AttributeUtils attributeUtils4 = this.attributeUtils;
            AttachmentTypes attachmentTypes3 = AttachmentTypes.LOCATION;
            arrayList.add(new AttachmentDataModel(attributeUtils4.getIconDrawable(context, attachmentTypes3.getIcon()), this.attributeUtils.getStringAttribute(context, attachmentTypes3.getType())));
        }
        return arrayList;
    }
}
