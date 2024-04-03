package d00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;
import io.flutter.plugins.videoplayer.a;

public final /* synthetic */ class i implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.AndroidVideoPlayerApi f13823a;

    public /* synthetic */ i(Messages.AndroidVideoPlayerApi androidVideoPlayerApi) {
        this.f13823a = androidVideoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        a.i(this.f13823a, obj, reply);
    }
}
