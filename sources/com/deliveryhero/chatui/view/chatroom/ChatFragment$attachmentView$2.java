package com.deliveryhero.chatui.view.chatroom;

import android.view.View;
import com.deliveryhero.chatui.view.chatroom.customview.AttachmentView;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/deliveryhero/chatui/view/chatroom/customview/AttachmentView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment$attachmentView$2 extends Lambda implements Function0<AttachmentView> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29452g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$attachmentView$2(ChatFragment chatFragment) {
        super(0);
        this.f29452g = chatFragment;
    }

    @NotNull
    public final AttachmentView invoke() {
        View view = this.f29452g.getView();
        AttachmentView attachmentView = view != null ? (AttachmentView) view.findViewById(R.id.attachment_view) : null;
        if (attachmentView != null) {
            return attachmentView;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.deliveryhero.chatui.view.chatroom.customview.AttachmentView");
    }
}
