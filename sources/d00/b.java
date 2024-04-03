package d00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;
import io.flutter.plugins.videoplayer.a;

public final /* synthetic */ class b implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.AndroidVideoPlayerApi f13816a;

    public /* synthetic */ b(Messages.AndroidVideoPlayerApi androidVideoPlayerApi) {
        this.f13816a = androidVideoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        a.l(this.f13816a, obj, reply);
    }
}
