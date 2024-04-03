package com.deliveryhero.chatui.view.chatroom.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/adapter/ChatMessageViewModelDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatMessageViewModelDiffCallback extends DiffUtil.ItemCallback<ChatMessageViewModel> {
    @NotNull
    public static final ChatMessageViewModelDiffCallback INSTANCE = new ChatMessageViewModelDiffCallback();

    private ChatMessageViewModelDiffCallback() {
    }

    public boolean areContentsTheSame(@NotNull ChatMessageViewModel chatMessageViewModel, @NotNull ChatMessageViewModel chatMessageViewModel2) {
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "oldItem");
        Intrinsics.checkNotNullParameter(chatMessageViewModel2, "newItem");
        return Intrinsics.areEqual((Object) chatMessageViewModel, (Object) chatMessageViewModel2);
    }

    public boolean areItemsTheSame(@NotNull ChatMessageViewModel chatMessageViewModel, @NotNull ChatMessageViewModel chatMessageViewModel2) {
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "oldItem");
        Intrinsics.checkNotNullParameter(chatMessageViewModel2, "newItem");
        return chatMessageViewModel.getIndex() == chatMessageViewModel2.getIndex();
    }
}
