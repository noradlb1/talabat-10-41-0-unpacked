package com.deliveryhero.chatui.view.chatroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.dataholder.AttachmentDataModel;
import com.deliveryhero.chatui.view.chatroom.viewholder.AttachmentViewHolder;
import com.deliveryhero.customerchat.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/adapter/AttachmentDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/deliveryhero/chatui/view/chatroom/viewholder/AttachmentViewHolder;", "attachmentOptionList", "", "Lcom/deliveryhero/chatui/view/chatroom/dataholder/AttachmentDataModel;", "onItemClickListener", "Lcom/deliveryhero/chatui/view/chatroom/adapter/ListItemClickListener;", "(Ljava/util/List;Lcom/deliveryhero/chatui/view/chatroom/adapter/ListItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttachmentDialogAdapter extends RecyclerView.Adapter<AttachmentViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public final List<AttachmentDataModel> attachmentOptionList;
    /* access modifiers changed from: private */
    @NotNull
    public final ListItemClickListener onItemClickListener;

    public AttachmentDialogAdapter(@NotNull List<AttachmentDataModel> list, @NotNull ListItemClickListener listItemClickListener) {
        Intrinsics.checkNotNullParameter(list, "attachmentOptionList");
        Intrinsics.checkNotNullParameter(listItemClickListener, "onItemClickListener");
        this.attachmentOptionList = list;
        this.onItemClickListener = listItemClickListener;
    }

    public int getItemCount() {
        return this.attachmentOptionList.size();
    }

    public void onBindViewHolder(@NotNull AttachmentViewHolder attachmentViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(attachmentViewHolder, "holder");
        attachmentViewHolder.bind(this.attachmentOptionList.get(i11), new AttachmentDialogAdapter$onBindViewHolder$1(this, i11));
    }

    @NotNull
    public AttachmentViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_chat_viewholder_attachment_view, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…      false\n            )");
        return new AttachmentViewHolder(inflate);
    }
}
