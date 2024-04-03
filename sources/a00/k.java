package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;
import java.util.ArrayList;

public final /* synthetic */ class k implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11652a;

    public /* synthetic */ k(Messages.GoogleSignInApi googleSignInApi) {
        this.f11652a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        this.f11652a.signInSilently(new Messages.Result<Messages.UserData>(new ArrayList(), reply) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ArrayList f14348a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BasicMessageChannel.Reply f14349b;

            {
                this.f14348a = r1;
                this.f14349b = r2;
            }

            public void error(Throwable th2) {
                this.f14349b.reply(Messages.a(th2));
            }

            public void success(UserData userData) {
                this.f14348a.add(0, userData);
                this.f14349b.reply(this.f14348a);
            }
        });
    }
}
