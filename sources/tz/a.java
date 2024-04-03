package tz;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyEventChannel.EventResponseHandler f24126a;

    public /* synthetic */ a(KeyEventChannel.EventResponseHandler eventResponseHandler) {
        this.f24126a = eventResponseHandler;
    }

    public final void reply(Object obj) {
        KeyEventChannel.lambda$createReplyHandler$0(this.f24126a, obj);
    }
}
