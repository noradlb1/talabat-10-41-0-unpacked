package com.talabat.dh_chat;

import com.deliveryhero.chatui.data.event.Event;
import com.talabat.dh_chat.utils.JSONExtentionsKt;
import io.flutter.plugin.common.EventChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/chatui/data/event/Event;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DhChatPlugin$onListen$1 extends Lambda implements Function1<Event, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f58311g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DhChatPlugin$onListen$1(EventChannel.EventSink eventSink) {
        super(1);
        this.f58311g = eventSink;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Event) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Event event) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(event, "it");
        if (event instanceof Event.Open) {
            map = JSONExtentionsKt.toMap(event);
        } else if (event instanceof Event.Close) {
            map = JSONExtentionsKt.toMap(event);
        } else if (event instanceof Event.Call) {
            map = JSONExtentionsKt.toMap((Event.Call) event);
        } else if (event instanceof Event.MessageSent) {
            map = JSONExtentionsKt.toMap(event);
        } else if (event instanceof Event.MessageFailed) {
            map = JSONExtentionsKt.toMap(event);
        } else if (event instanceof Event.QuickReplyMessageSent) {
            map = JSONExtentionsKt.toMap((Event.QuickReplyMessageSent) event);
        } else if (event instanceof Event.Translation) {
            map = JSONExtentionsKt.toMap((Event.Translation) event);
        } else if (event instanceof Event.VoipCallFailed) {
            map = JSONExtentionsKt.toMap(event);
        } else if (event instanceof Event.LocationProviderError) {
            map = JSONExtentionsKt.toMap(event);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        EventChannel.EventSink eventSink = this.f58311g;
        if (eventSink != null) {
            eventSink.success(map);
        }
    }
}
