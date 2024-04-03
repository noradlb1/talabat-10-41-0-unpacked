package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.view.View;
import android.widget.TextView;
import com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel;
import com.deliveryhero.chatui.view.chatroom.TextMessage;
import com.deliveryhero.chatui.view.chatroom.adapter.listener.MessageClickListener;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0012\u0010\nR\u001b\u0010\u0014\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/viewholder/ReceivedMessageViewHolder;", "Lcom/deliveryhero/chatui/view/chatroom/viewholder/MessageViewHolder;", "view", "Landroid/view/View;", "messageClickListener", "Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;", "(Landroid/view/View;Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;)V", "fadedTextView", "Landroid/widget/TextView;", "getFadedTextView", "()Landroid/widget/TextView;", "fadedTextView$delegate", "Lkotlin/Lazy;", "line", "getLine", "()Landroid/view/View;", "line$delegate", "senderTextView", "getSenderTextView", "senderTextView$delegate", "translatedWithOriginalView", "getTranslatedWithOriginalView", "translatedWithOriginalView$delegate", "bind", "", "viewModel", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "hideFadedViewAndLine", "setFadedOriginalText", "message", "Lcom/deliveryhero/chatui/view/chatroom/TextMessage;", "setSender", "senderName", "", "showFadedViewAndLine", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReceivedMessageViewHolder extends MessageViewHolder {
    @NotNull
    private final Lazy fadedTextView$delegate;
    @NotNull
    private final Lazy line$delegate;
    @NotNull
    private final Lazy senderTextView$delegate;
    @NotNull
    private final Lazy translatedWithOriginalView$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceivedMessageViewHolder(@NotNull View view, @NotNull MessageClickListener messageClickListener) {
        super(view, messageClickListener);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(messageClickListener, "messageClickListener");
        this.fadedTextView$delegate = LazyKt__LazyJVMKt.lazy(new ReceivedMessageViewHolder$fadedTextView$2(view));
        this.translatedWithOriginalView$delegate = LazyKt__LazyJVMKt.lazy(new ReceivedMessageViewHolder$translatedWithOriginalView$2(view));
        this.line$delegate = LazyKt__LazyJVMKt.lazy(new ReceivedMessageViewHolder$line$2(view));
        this.senderTextView$delegate = LazyKt__LazyJVMKt.lazy(new ReceivedMessageViewHolder$senderTextView$2(view));
    }

    private final TextView getFadedTextView() {
        return (TextView) this.fadedTextView$delegate.getValue();
    }

    private final View getLine() {
        return (View) this.line$delegate.getValue();
    }

    private final TextView getSenderTextView() {
        return (TextView) this.senderTextView$delegate.getValue();
    }

    private final View getTranslatedWithOriginalView() {
        Object value = this.translatedWithOriginalView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-translatedWithOriginalView>(...)");
        return (View) value;
    }

    private final void hideFadedViewAndLine() {
        getLine().setVisibility(8);
        getFadedTextView().setVisibility(8);
    }

    private final void setFadedOriginalText(TextMessage textMessage) {
        getFadedTextView().setText(textMessage.getMessage());
    }

    private final void setSender(String str) {
        boolean z11;
        int i11 = 0;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = true ^ z11;
        TextView senderTextView = getSenderTextView();
        if (!z12) {
            i11 = 8;
        }
        senderTextView.setVisibility(i11);
        if (z12) {
            getSenderTextView().setText(str);
        }
    }

    private final void showFadedViewAndLine() {
        getLine().setVisibility(0);
        getFadedTextView().setVisibility(0);
    }

    public void bind(@NotNull ChatMessageViewModel chatMessageViewModel) {
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "viewModel");
        super.setImageMessage(chatMessageViewModel.getImageMessage());
        super.setDate(chatMessageViewModel.getDate());
        super.setLocationMessage(chatMessageViewModel.getLocationMessage());
        TextMessage translatedMessage = chatMessageViewModel.getTranslatedMessage();
        if (translatedMessage == null) {
            super.setTextMessage(chatMessageViewModel.getOriginalMessage());
            getTranslatedWithOriginalView().setVisibility(chatMessageViewModel.getOriginalMessage().getVisibility());
            hideFadedViewAndLine();
        } else {
            super.setTextMessage(translatedMessage);
            showFadedViewAndLine();
            setFadedOriginalText(chatMessageViewModel.getOriginalMessage());
        }
        setSender(chatMessageViewModel.getSenderNickName());
    }
}
