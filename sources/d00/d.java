package d00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;
import io.flutter.plugins.videoplayer.a;

public final /* synthetic */ class d implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.AndroidVideoPlayerApi f13818a;

    public /* synthetic */ d(Messages.AndroidVideoPlayerApi androidVideoPlayerApi) {
        this.f13818a = androidVideoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        a.c(this.f13818a, obj, reply);
    }
}
