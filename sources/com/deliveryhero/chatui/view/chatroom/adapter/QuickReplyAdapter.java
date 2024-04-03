package com.deliveryhero.chatui.view.chatroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.viewholder.QuickReplyViewHolder;
import com.deliveryhero.customerchat.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/adapter/QuickReplyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "quickReplies", "", "", "quickReplyClickListener", "Lcom/deliveryhero/chatui/view/chatroom/adapter/QuickReplyClickListener;", "(Ljava/util/List;Lcom/deliveryhero/chatui/view/chatroom/adapter/QuickReplyClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "Lcom/deliveryhero/chatui/view/chatroom/viewholder/QuickReplyViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuickReplyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public final List<String> quickReplies;
    /* access modifiers changed from: private */
    @NotNull
    public final QuickReplyClickListener quickReplyClickListener;

    public QuickReplyAdapter(@NotNull List<String> list, @NotNull QuickReplyClickListener quickReplyClickListener2) {
        Intrinsics.checkNotNullParameter(list, "quickReplies");
        Intrinsics.checkNotNullParameter(quickReplyClickListener2, "quickReplyClickListener");
        this.quickReplies = list;
        this.quickReplyClickListener = quickReplyClickListener2;
    }

    public int getItemCount() {
        return this.quickReplies.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((QuickReplyViewHolder) viewHolder).bind(this.quickReplies.get(i11), new QuickReplyAdapter$onBindViewHolder$1(this, i11));
    }

    @NotNull
    public QuickReplyViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_chat_viewholder_quick_reply, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…      false\n            )");
        return new QuickReplyViewHolder(inflate);
    }
}
