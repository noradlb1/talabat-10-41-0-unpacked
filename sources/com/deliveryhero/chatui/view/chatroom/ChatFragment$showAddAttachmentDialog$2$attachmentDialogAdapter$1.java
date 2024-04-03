package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.chatui.view.chatroom.adapter.ListItemClickListener;
import com.deliveryhero.chatui.view.chatroom.customview.AttachmentDialog;
import com.deliveryhero.chatui.view.chatroom.dataholder.AttachmentDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/deliveryhero/chatui/view/chatroom/ChatFragment$showAddAttachmentDialog$2$attachmentDialogAdapter$1", "Lcom/deliveryhero/chatui/view/chatroom/adapter/ListItemClickListener;", "onItemClick", "", "itemPosition", "", "item", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment$showAddAttachmentDialog$2$attachmentDialogAdapter$1 implements ListItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29489a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AttachmentDialog f29490b;

    public ChatFragment$showAddAttachmentDialog$2$attachmentDialogAdapter$1(ChatFragment chatFragment, AttachmentDialog attachmentDialog) {
        this.f29489a = chatFragment;
        this.f29490b = attachmentDialog;
    }

    public void onItemClick(int i11, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        this.f29489a.performAttachmentAction((AttachmentDataModel) obj);
        this.f29490b.dismissDialog();
    }
}
