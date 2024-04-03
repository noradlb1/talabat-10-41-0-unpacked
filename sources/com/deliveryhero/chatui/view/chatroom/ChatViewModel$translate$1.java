package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "value", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel$translate$1 extends Lambda implements Function1<ChatMessageViewModel, ChatMessageViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29594g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$translate$1(ChatViewModel chatViewModel) {
        super(1);
        this.f29594g = chatViewModel;
    }

    @NotNull
    public final ChatMessageViewModel invoke(@NotNull ChatMessageViewModel chatMessageViewModel) {
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "value");
        return this.f29594g.mapper.translate(this.f29594g.preferredLanguage$customerchat_basicRelease(), chatMessageViewModel);
    }
}
