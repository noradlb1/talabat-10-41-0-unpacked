package com.deliveryhero.chatui.data.event;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005J\"\u0010\n\u001a\u00020\u00062\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatui/data/event/EventHandler;", "", "()V", "callback", "Lkotlin/Function1;", "Lcom/deliveryhero/chatui/data/event/Event;", "", "Lcom/deliveryhero/chatui/data/event/EventCallback;", "onEvent", "event", "register", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventHandler {
    @Nullable
    private Function1<? super Event, Unit> callback;

    public final void onEvent(@NotNull Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Function1<? super Event, Unit> function1 = this.callback;
        if (function1 != null) {
            function1.invoke(event);
        }
    }

    public final void register(@Nullable Function1<? super Event, Unit> function1) {
        this.callback = function1;
    }
}
