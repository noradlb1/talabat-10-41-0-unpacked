package d00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;
import io.flutter.plugins.videoplayer.a;

public final /* synthetic */ class e implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.AndroidVideoPlayerApi f13819a;

    public /* synthetic */ e(Messages.AndroidVideoPlayerApi androidVideoPlayerApi) {
        this.f13819a = androidVideoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        a.e(this.f13819a, obj, reply);
    }
}
