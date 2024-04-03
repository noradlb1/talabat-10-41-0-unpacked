package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.chatui.data.event.Event;
import com.deliveryhero.contract.model.BaseMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/contract/model/BaseMessage;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel$sendNewMessage$1 extends Lambda implements Function1<BaseMessage, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29565g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ChatMessageViewModel f29566h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$sendNewMessage$1(ChatViewModel chatViewModel, ChatMessageViewModel chatMessageViewModel) {
        super(1);
        this.f29565g = chatViewModel;
        this.f29566h = chatMessageViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BaseMessage) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BaseMessage baseMessage) {
        Intrinsics.checkNotNullParameter(baseMessage, "it");
        ChatViewModel.a(this.f29565g, baseMessage, this.f29566h, (Throwable) null, 4, (Object) null);
        this.f29565g.eventHandler.onEvent(Event.MessageSent.INSTANCE);
    }
}
