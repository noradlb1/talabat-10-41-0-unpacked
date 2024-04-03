package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;

public final /* synthetic */ class p implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11657a;

    public /* synthetic */ p(Messages.GoogleSignInApi googleSignInApi) {
        this.f11657a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.GoogleSignInApi.CC.h(this.f11657a, obj, reply);
    }
}
