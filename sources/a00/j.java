package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;

public final /* synthetic */ class j implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11651a;

    public /* synthetic */ j(Messages.GoogleSignInApi googleSignInApi) {
        this.f11651a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.GoogleSignInApi.CC.b(this.f11651a, obj, reply);
    }
}
