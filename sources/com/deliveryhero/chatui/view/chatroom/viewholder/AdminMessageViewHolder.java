package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.view.View;
import com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel;
import com.deliveryhero.chatui.view.chatroom.adapter.listener.MessageClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/viewholder/AdminMessageViewHolder;", "Lcom/deliveryhero/chatui/view/chatroom/viewholder/MessageViewHolder;", "view", "Landroid/view/View;", "messageClickListener", "Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;", "(Landroid/view/View;Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;)V", "bind", "", "viewModel", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdminMessageViewHolder extends MessageViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdminMessageViewHolder(@NotNull View view, @NotNull MessageClickListener messageClickListener) {
        super(view, messageClickListener);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(messageClickListener, "messageClickListener");
    }

    public void bind(@NotNull ChatMessageViewModel chatMessageViewModel) {
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "viewModel");
        super.setTextMessage(chatMessageViewModel.getOriginalMessage());
    }
}
