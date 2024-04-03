package d00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;

public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.AndroidVideoPlayerApi f13815a;

    public /* synthetic */ a(Messages.AndroidVideoPlayerApi androidVideoPlayerApi) {
        this.f13815a = androidVideoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        io.flutter.plugins.videoplayer.a.b(this.f13815a, obj, reply);
    }
}
