package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;

public final /* synthetic */ class m implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11654a;

    public /* synthetic */ m(Messages.GoogleSignInApi googleSignInApi) {
        this.f11654a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.GoogleSignInApi.CC.e(this.f11654a, obj, reply);
    }
}
