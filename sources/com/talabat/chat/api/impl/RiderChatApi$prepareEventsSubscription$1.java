package com.talabat.chat.api.impl;

import com.deliveryhero.chatui.data.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/chatui/data/event/Event;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderChatApi$prepareEventsSubscription$1 extends Lambda implements Function1<Event, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderChatApi f55538g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderChatApi$prepareEventsSubscription$1(RiderChatApi riderChatApi) {
        super(1);
        this.f55538g = riderChatApi;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Event) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Event event) {
        Intrinsics.checkNotNullParameter(event, "it");
        if (event instanceof Event.Call) {
            this.f55538g.callEventHandler.invoke();
        } else if (event instanceof Event.Open) {
            this.f55538g.chatOpenedEventHandler.invoke();
        } else if (event instanceof Event.Close) {
            this.f55538g.chatClosedEventHandler.invoke();
        }
    }
}
