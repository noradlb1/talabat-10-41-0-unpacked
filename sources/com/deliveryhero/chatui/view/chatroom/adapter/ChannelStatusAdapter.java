package com.deliveryhero.chatui.view.chatroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.viewholder.ChannelStatusViewHolder;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/adapter/ChannelStatusAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/deliveryhero/chatui/view/chatroom/viewholder/ChannelStatusViewHolder;", "()V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChannelStatusAdapter extends RecyclerView.Adapter<ChannelStatusViewHolder> {
    @NotNull
    public static final ChannelStatusAdapter INSTANCE = new ChannelStatusAdapter();

    private ChannelStatusAdapter() {
    }

    public int getItemCount() {
        return 1;
    }

    public void onBindViewHolder(@NotNull ChannelStatusViewHolder channelStatusViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(channelStatusViewHolder, "holder");
    }

    @NotNull
    public ChannelStatusViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_chat_viewholder_channel_status, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…      false\n            )");
        return new ChannelStatusViewHolder(inflate);
    }
}
