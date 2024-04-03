package d00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;
import io.flutter.plugins.videoplayer.a;

public final /* synthetic */ class f implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.AndroidVideoPlayerApi f13820a;

    public /* synthetic */ f(Messages.AndroidVideoPlayerApi androidVideoPlayerApi) {
        this.f13820a = androidVideoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        a.f(this.f13820a, obj, reply);
    }
}
