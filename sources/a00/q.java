package a00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.googlesignin.Messages;
import java.util.ArrayList;

public final /* synthetic */ class q implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.GoogleSignInApi f11658a;

    public /* synthetic */ q(Messages.GoogleSignInApi googleSignInApi) {
        this.f11658a = googleSignInApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        this.f11658a.clearAuthCache((String) ((ArrayList) obj).get(0), new Messages.Result<Void>(new ArrayList(), reply) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ArrayList f14358a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BasicMessageChannel.Reply f14359b;

            {
                this.f14358a = r1;
                this.f14359b = r2;
            }

            public void error(Throwable th2) {
                this.f14359b.reply(Messages.a(th2));
            }

            public void success(Void voidR) {
                this.f14358a.add(0, (Object) null);
                this.f14359b.reply(this.f14358a);
            }
        });
    }
}
