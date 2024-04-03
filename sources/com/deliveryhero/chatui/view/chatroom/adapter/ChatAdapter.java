package com.deliveryhero.chatui.view.chatroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel;
import com.deliveryhero.chatui.view.chatroom.adapter.listener.MessageClickListener;
import com.deliveryhero.chatui.view.chatroom.viewholder.AdminMessageViewHolder;
import com.deliveryhero.chatui.view.chatroom.viewholder.MessageViewHolder;
import com.deliveryhero.chatui.view.chatroom.viewholder.ReceivedMessageViewHolder;
import com.deliveryhero.chatui.view.chatroom.viewholder.SentMessageViewHolder;
import com.deliveryhero.contract.model.AdminMessage;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.view.util.AttributeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/adapter/ChatAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "messageClickListener", "Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;", "attributeUtils", "Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "(Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;Lcom/deliveryhero/customerchat/view/util/AttributeUtils;)V", "getItemId", "", "position", "", "getItemViewType", "getViewType", "viewModel", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatAdapter extends ListAdapter<ChatMessageViewModel, RecyclerView.ViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int VIEW_TYPE_ADMIN_MESSAGE = 3;
    public static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    public static final int VIEW_TYPE_MESSAGE_SENT = 1;
    @NotNull
    private final AttributeUtils attributeUtils;
    @NotNull
    private final MessageClickListener messageClickListener;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/adapter/ChatAdapter$Companion;", "", "()V", "VIEW_TYPE_ADMIN_MESSAGE", "", "VIEW_TYPE_MESSAGE_RECEIVED", "VIEW_TYPE_MESSAGE_SENT", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatAdapter(@NotNull MessageClickListener messageClickListener2, @NotNull AttributeUtils attributeUtils2) {
        super(ChatMessageViewModelDiffCallback.INSTANCE);
        Intrinsics.checkNotNullParameter(messageClickListener2, "messageClickListener");
        Intrinsics.checkNotNullParameter(attributeUtils2, "attributeUtils");
        this.messageClickListener = messageClickListener2;
        this.attributeUtils = attributeUtils2;
    }

    private final int getViewType(ChatMessageViewModel chatMessageViewModel) {
        if (chatMessageViewModel.getChatMessage() instanceof AdminMessage) {
            return 3;
        }
        if (chatMessageViewModel.getSendByMe()) {
            return 1;
        }
        return 2;
    }

    public long getItemId(int i11) {
        return (long) ((ChatMessageViewModel) getItem(i11)).getIndex();
    }

    public int getItemViewType(int i11) {
        Object item = getItem(i11);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        return getViewType((ChatMessageViewModel) item);
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ChatMessageViewModel chatMessageViewModel = (ChatMessageViewModel) getItem(i11);
        Intrinsics.checkNotNullExpressionValue(chatMessageViewModel, "viewModel");
        ((MessageViewHolder) viewHolder).bind(chatMessageViewModel);
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_chat_viewholder_message_sent, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…  false\n                )");
            return new SentMessageViewHolder(inflate, this.messageClickListener, this.attributeUtils);
        } else if (i11 == 2) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_chat_viewholder_message_received, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf…  false\n                )");
            return new ReceivedMessageViewHolder(inflate2, this.messageClickListener);
        } else if (i11 == 3) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_chat_viewholder_admin_message, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
            return new AdminMessageViewHolder(inflate3, this.messageClickListener);
        } else {
            throw new IllegalArgumentException("Unknown view type received - " + i11);
        }
    }
}
