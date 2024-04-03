package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel;
import com.deliveryhero.chatui.view.chatroom.adapter.listener.MessageClickListener;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.view.util.AttributeUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/viewholder/SentMessageViewHolder;", "Lcom/deliveryhero/chatui/view/chatroom/viewholder/MessageViewHolder;", "view", "Landroid/view/View;", "messageClickListener", "Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;", "attributeUtils", "Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "(Landroid/view/View;Lcom/deliveryhero/chatui/view/chatroom/adapter/listener/MessageClickListener;Lcom/deliveryhero/customerchat/view/util/AttributeUtils;)V", "error", "Landroid/graphics/drawable/Drawable;", "messageIndicatorIcon", "Landroid/widget/ImageView;", "getMessageIndicatorIcon", "()Landroid/widget/ImageView;", "messageIndicatorIcon$delegate", "Lkotlin/Lazy;", "seen", "sending", "sent", "bind", "", "viewModel", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "setMessageState", "state", "Lcom/deliveryhero/contract/model/Receipt;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SentMessageViewHolder extends MessageViewHolder {
    @Nullable
    private final Drawable error;
    @NotNull
    private final Lazy messageIndicatorIcon$delegate;
    @Nullable
    private final Drawable seen;
    @Nullable
    private final Drawable sending;
    @Nullable
    private final Drawable sent;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Receipt.values().length];
            iArr[Receipt.SENDING.ordinal()] = 1;
            iArr[Receipt.SEEN.ordinal()] = 2;
            iArr[Receipt.SENT.ordinal()] = 3;
            iArr[Receipt.FAILED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SentMessageViewHolder(@NotNull View view, @NotNull MessageClickListener messageClickListener, @NotNull AttributeUtils attributeUtils) {
        super(view, messageClickListener);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(messageClickListener, "messageClickListener");
        Intrinsics.checkNotNullParameter(attributeUtils, "attributeUtils");
        this.messageIndicatorIcon$delegate = LazyKt__LazyJVMKt.lazy(new SentMessageViewHolder$messageIndicatorIcon$2(view));
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.seen = attributeUtils.getIconDrawable(context, R.attr.seenMessageIcon);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        this.sent = attributeUtils.getIconDrawable(context2, R.attr.sentMessageIcon);
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        this.error = attributeUtils.getIconDrawable(context3, R.attr.errorSendingMessageIcon);
        Context context4 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "view.context");
        this.sending = attributeUtils.getIconDrawable(context4, R.attr.sendingMessageIcon);
    }

    private final ImageView getMessageIndicatorIcon() {
        return (ImageView) this.messageIndicatorIcon$delegate.getValue();
    }

    private final void setMessageState(Receipt receipt) {
        int i11;
        TextView dateTextView$customerchat_basicRelease = getDateTextView$customerchat_basicRelease();
        Context context = getView().getContext();
        if (receipt == Receipt.FAILED) {
            i11 = R.color.customer_chat_text_sending_error;
        } else {
            i11 = R.color.customer_chat_text_light;
        }
        dateTextView$customerchat_basicRelease.setTextColor(ContextCompat.getColor(context, i11));
        int i12 = WhenMappings.$EnumSwitchMapping$0[receipt.ordinal()];
        if (i12 == 1) {
            getMessageIndicatorIcon().setImageDrawable(this.sending);
        } else if (i12 == 2) {
            getMessageIndicatorIcon().setImageDrawable(this.seen);
        } else if (i12 == 3) {
            getMessageIndicatorIcon().setImageDrawable(this.sent);
        } else if (i12 == 4) {
            getMessageIndicatorIcon().setImageDrawable(this.error);
        }
    }

    public void bind(@NotNull ChatMessageViewModel chatMessageViewModel) {
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "viewModel");
        super.bind(chatMessageViewModel);
        setMessageState(chatMessageViewModel.getReceiptState());
    }
}
